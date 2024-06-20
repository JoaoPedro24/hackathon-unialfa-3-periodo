import { Router } from 'express'
import responsavelRouter from './responsavel'
import idosoRouter from './idoso'
import historicoMedicoIdosoRouter from './historicoMedicoIdoso'

const routes = Router()

routes.use('/responsaveis', responsavelRouter)
routes.use('/idosos', idosoRouter)
routes.use('/historicoMedicoIdoso', historicoMedicoIdosoRouter)

export default routes