import Router from 'express'
import knex from '../database/knex'
import AppError from '../utils/AppError'
import { z } from 'zod'

const router = Router()

router.get('/', async (req, res) => {
    const responsaveis = await knex('responsaveis')

    res.json({ responsaveis })
})

router.post('/', async (req, res) => {
    const registerBodySchema = z.object({
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
    await knex("responsaveis").insert(objSalvar)

    res.json({ message: "Responsável criado com sucesso!" })
})

router.put('/:id', async (req, res) => {
    const registerBodySchema = z.object({
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

    let responsavel = await knex('responsaveis').where({ id }).first()

    if (!responsavel?.id) {
        throw new AppError('Responsável não encontrado')
    }

    let novoResponsavel = {
        ...responsavel,
        ...objSalvar
    }

    await knex('responsaveis').update(novoResponsavel).where({ id: responsavel.id })

    return res.json({
        message: "Responsável editado com sucesso!",
        responsavel_antigo: responsavel
    })
})

router.delete('/:id', async (req, res) => {
    const { id } = req.params

    let responsavel = await knex('responsaveis').where({ id }).first()

    if (!responsavel?.id) {
        throw new AppError('Responsável não encontrado')
    }

    await knex('responsaveis').where({ id }).delete()

    return res.json({ message: "Responsável deletado com sucesso!" })
})

export default router