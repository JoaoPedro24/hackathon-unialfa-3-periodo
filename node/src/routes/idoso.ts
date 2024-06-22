import Router from 'express'
import knex from '../database/knex'
import AppError from '../utils/AppError'
import { z } from 'zod'

const router = Router()

router.get('/', async (req, res) => {
    const idosos = await knex('idosos')

    res.json({ idosos })
})

router.get('/:id', async (req, res) => {
    const { id } = req.params
    const idoso = await knex('idosos').where({ id }).first()

    res.json({ idoso })
})

router.post('/', async (req, res) => {
    const registerBodySchema = z.object({
        id_responsavel: z.number().int(),
        nome: z.string(),
        cpf: z.string(),
        telefone: z.string(),
        data_nascimento: z.string().date(),
        cep: z.string(),
        rua: z.string(),
        bairro: z.string(),
        numero: z.number().int(),
        complemento: z.string().nullable().optional(),
        uf: z.string(),
        cidade: z.string()
    })

    const objSalvar = registerBodySchema.parse(req.body)
    await knex("idosos").insert(objSalvar)

    res.json({ message: "Idoso criado com sucesso!" })
})

router.put('/:id', async (req, res) => {
    const registerBodySchema = z.object({
        id_responsavel: z.number().int(),
        nome: z.string().optional(),
        cpf: z.string().optional(),
        telefone: z.string().optional(),
        data_nascimento: z.string().date().optional(),
        cep: z.string().optional(),
        rua: z.string().optional(),
        bairro: z.string().optional(),
        numero: z.number().int().optional(),
        complemento: z.string().nullable().optional(),
        uf: z.string().optional(),
        cidade: z.string().optional()
    })

    const objSalvar = registerBodySchema.parse(req.body)
    const { id } = req.params

    let idoso = await knex('idosos').where({ id }).first()

    if (!idoso?.id) {
        throw new AppError('Idoso não encontrado')
    }

    let novoIdoso = {
        ...idoso,
        ...objSalvar
    }

    await knex('idosos').update(novoIdoso).where({ id: idoso.id })

    return res.json({
        message: "Idoso editado com sucesso!",
        idoso_antigo: idoso
    })
})

router.delete('/:id', async (req, res) => {
    const { id } = req.params

    let idoso = await knex('idosos').where({ id }).first()

    if (!idoso?.id) {
        throw new AppError('Idoso não encontrado')
    }

    await knex('idosos').where({ id }).delete()

    return res.json({ message: "Idoso deletado com sucesso!" })
})

export default router
