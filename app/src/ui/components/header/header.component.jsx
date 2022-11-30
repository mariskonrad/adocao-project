import { ROUTES } from '../../../constants/routes'
import { Link, useNavigate } from 'react-router-dom'
import { useGlobalUser } from '../../../assets/context'
import './header.style.css'
import { useUserApi } from '../../../assets/hooks/api'
import LOGO from '../../../images/logo.png'

export function Header() {
  const [globalUser, setGlobalUser] = useGlobalUser()
  const userApi = useUserApi()
  const navigate = useNavigate()

  async function handleLogout() {
    await userApi.logout()
    setGlobalUser({})
    navigate(ROUTES.LOGIN)
  }

  if (globalUser) {
    return (
      <div className='container'>
        <div className='header-container'>
          <div className='header-content'>
            <div>
              <Link to={ROUTES.HOME}>
                <img src={LOGO} alt='Logo' className='logo-image' />
              </Link>
            </div>
            <div className='header-content-text text-header'>
              <Link to={ROUTES.ANIMALS}>Adotáveis</Link>
            </div>
            <div className='header-content-text text-header'>
              <Link to={ROUTES.HELP}>Como ajudar</Link>
            </div>
            <div className='header-content-text text-header'>
              <Link to={ROUTES.EVENTS}>Eventos</Link>
            </div>
            <div className='header-content-text text-header'>
              <Link to={ROUTES.CONTACT}>Contato</Link>
            </div>
          </div>
          <div className='header-content'>
            <button onClick={handleLogout} className='text-header'>
              Logout
            </button>
          </div>
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
