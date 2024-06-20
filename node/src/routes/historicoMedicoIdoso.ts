import Router from 'express'
import knex from '../database/knex'
import AppError from '../utils/AppError'
import { z } from 'zod'

const router = Router()

router.get('/:id_idoso', async (req, res) => {
    const { id_idoso } = req.params

    const historicoMedicoIdoso = await knex('historicos_medicos_idosos').where({ id_idoso }).first()

    res.json({ historicoMedicoIdoso })
})

router.post('/', async (req, res) => {
    const registerBodySchema = z.object({
        id_idoso: z.number().int(),
        alergias: z.string().nullable(),
        condicoes_preexistentes: z.string().nullable(),
        observacoes: z.string().optional().nullable()
    })

    const objSalvar = registerBodySchema.parse(req.body)
    await knex("historicos_medicos_idosos").insert(objSalvar)

    res.json({ message: "Histórico médido do idoso criado com sucesso!" })
})

router.put('/:id_idoso', async (req, res) => {
    const registerBodySchema = z.object({
        alergias: z.string().optional().nullable(),
        condicoes_preexistentes: z.string().optional().nullable(),
        observacoes: z.string().optional().nullable()
    })

    const objSalvar = registerBodySchema.parse(req.body)
    const { id_idoso } = req.params

    let historicoMedicoIdoso = await knex('historicos_medicos_idosos').where({ id_idoso }).first()

    if (!historicoMedicoIdoso?.id) {
        throw new AppError('Histórico médido do idoso não encontrado')
    }

    let novoHistoricoMedicoIdoso = {
        ...historicoMedicoIdoso,
        ...objSalvar
    }

    await knex('historicos_medicos_idosos').update(novoHistoricoMedicoIdoso).where({ id: historicoMedicoIdoso.id })

    return res.json({
        message: "Histórico médido do idoso editado com sucesso!",
        historico_medico_idoso_antigo: historicoMedicoIdoso
    })
})

router.delete('/:id_idoso', async (req, res) => {
    const { id_idoso } = req.params

    let historicoMedicoIdoso = await knex('historicos_medicos_idosos').where({ id_idoso }).first()

    if (!historicoMedicoIdoso?.id) {
        throw new AppError('Histórico médido do idoso não encontrado')
    }

    await knex('historicos_medicos_idosos').where({ id_idoso }).delete()

    return res.json({ message: "Histórico médido do idoso deletado com sucesso!" })
})

export default router