import Router from 'express'
import knex from '../database/knex'
import AppError from '../utils/AppError'
import { z } from 'zod'

const router = Router()

router.get('/:id_idoso', async (req, res) => {
    const { id_idoso } = req.params
    const agendamentos = await knex('agendamentos as a')
    .join('idosos as i', 'i.id', 'a.id_idoso')
    .join('enfermeiros as e', 'e.id', 'a.id_enfermeiro')
    .join('vacinas as v', 'v.id', 'a.id_vacina')
    .select('a.data', 'a.observacoes', 'i.nome as idoso', 'v.nome as vacina', 'e.nome as enfermeiro')
    .where("id_idoso", id_idoso)

    res.json({ agendamentos })
})

router.get('/enfermeiro/:id_enfermeiro', async (req, res) => {
    const { id_enfermeiro } = req.params
    const { data } = req.query
    const agendamento = await knex('agendamentos')
    .where("id_enfermeiro", id_enfermeiro)
    .where("data", data)

    res.json({ agendamento })
})

router.post('/', async (req, res) => {
    const registerBodySchema = z.object({
        id_idoso: z.number().int(),
        id_enfermeiro: z.number().int(),
        id_vacina: z.number().int(),
        data: z.string().date(),
        observacoes: z.string().optional().nullable()
    })

    const objSalvar = registerBodySchema.parse(req.body)
    await knex("agendamentos").insert(objSalvar)

    res.json({ message: "Vacinação agendada com sucesso!" })
})

router.put('/:id', async (req, res) => {
    const registerBodySchema = z.object({
        id_idoso: z.number().int().optional(),
        id_enfermeiro: z.number().int().optional(),
        id_vacina: z.number().int().optional(),
        data: z.string().date().optional(),
        observacoes: z.string().optional().nullable()
    })

    const objSalvar = registerBodySchema.parse(req.body)
    const { id } = req.params

    let agendamento = await knex('agendamentos').where({ id }).first()

    if (!agendamento?.id) {
        throw new AppError('Agendamentos não encontrado')
    }

    let novoAgendamento = {
        ...agendamento,
        ...objSalvar
    }

    await knex('agendamentos').update(novoAgendamento).where({ id: agendamento.id })

    return res.json({
        message: "Agendamento de vacinação editado com sucesso!",
        idoso_antigo: agendamento
    })
})

router.delete('/:id', async (req, res) => {
    const { id } = req.params

    let agendamento = await knex('agendamentos').where({ id }).first()

    if (!agendamento?.id) {
        throw new AppError('Agendamento de vacinação não encontrado')
    }

    await knex('agendamentos').where({ id }).delete()

    return res.json({ message: "Agendamento de vacinação deletado com sucesso!" })
})

export default router
