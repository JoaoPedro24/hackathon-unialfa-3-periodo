import Router from 'express'
import knex from '../database/knex'

const router = Router()

router.get('/', async (req, res) => {
    const enfermeiros = await knex('enfermeiros')

    res.json({ enfermeiros })
})

export default router
