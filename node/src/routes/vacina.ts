import Router from 'express'
import knex from '../database/knex'

const router = Router()

router.get('/', async (req, res) => {
    const vacinas = await knex('vacinas')

    res.json({ vacinas })
})

export default router