import { Router } from 'express'
import responsavelRouter from './responsavel'
import idosoRouter from './idoso'
import historicoMedicoIdosoRouter from './historicoMedicoIdoso'
import agendamentoRouter from './agendamento'
import vacinaRouter from './vacina'

const routes = Router()

routes.use('/responsaveis', responsavelRouter)
routes.use('/idosos', idosoRouter)
routes.use('/historicoMedicoIdoso', historicoMedicoIdosoRouter)
routes.use('/agendamentos', agendamentoRouter)
routes.use('/vacinas', vacinaRouter)

export default routes