import { ROUTES } from '../../../constants/routes'
import { Link, useNavigate } from 'react-router-dom'
import { useGlobalUser } from '../../../assets/context'
import './header.style.css'
import { useUserApi } from '../../../assets/hooks/api'

export function Header() {
  const [globalUser] = useGlobalUser()
  const userApi = useUserApi()
  const navigate = useNavigate()

  async function handleLogout() {
    userApi.logout()
    navigate(ROUTES.LOGIN)
  }

  if (globalUser) {
    return (
      <div className='header-container'>
        <div className='header-content'>
          <div>Logo</div>
          <div>
            <Link to={ROUTES.ANIMALS}>Adotáveis</Link>
          </div>
          <div>
            <Link to={ROUTES.HELP}>Como ajudar</Link>
          </div>
          <div>
            <Link to={ROUTES.EVENTS}>Eventos</Link>
          </div>
          <div>
            <Link to={ROUTES.CONTACT}>Contato</Link>
          </div>
        </div>
        <div>
          <button onClick={handleLogout}>Logout</button>
        </div>
      </div>
    )
  }

  return (
    <div className='header-container'>
      <div className='header-content'>
        <Link to={ROUTES.LOGIN}>Login</Link>
      </div>
      <div>
        <Link to={ROUTES.SIGN_UP}></Link>Cadastre-se
      </div>
    </div>
  )
}
