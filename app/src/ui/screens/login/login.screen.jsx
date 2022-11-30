import { useState } from 'react'
import { useUserApi } from '../../../assets/hooks/api'
import { useGlobalUser } from '../../../assets/context'
import { useNavigate, Link } from 'react-router-dom'
import { ROUTES } from '../../../constants/routes'
import LOGO from '../../../images/logo.png'
import './login.style.css'
import '../../components/button/button.style.css'

export function LoginScreen() {
  const [username, setUsername] = useState('')
  const [password, setPassword] = useState('')
  const [errorMessage, setErrorMessage] = useState(null)
  const [, setGlobalUser] = useGlobalUser()
  const navigate = useNavigate()
  const userApi = useUserApi()

  function handleUsernameChange(event) {
    const username = event.target.value
    setUsername(username)
    setErrorMessage(null)
  }

  function handlePasswordChange(event) {
    const password = event.target.value
    setPassword(password)
  }

  async function onLoginSubmit(event) {
    event.preventDefault()

    try {
      const user = await userApi.login(username, password)
      setGlobalUser(user)
      navigate(ROUTES.HOME)
    } catch (error) {
      setErrorMessage('Usuário ou senha inválidos.')
    }
  }

  return (
    <div className='form-container'>
      <div>
        <img src={LOGO} alt='Logo' />
      </div>
      <div className='login-box'>
        <div className='text-primary'>Login</div>
        <fieldset>
          <form onSubmit={onLoginSubmit}>
            <div className='form-input'>
              <div className='form-input-title'>E-mail</div>
              <input
                className='input-form'
                name='username'
                type='text'
                value={username}
                onChange={handleUsernameChange}
              />
            </div>
            <div className='form-input'>
              <div className='form-input-title'>Senha</div>
              <input
                className='input-form'
                name='password'
                type='password'
                value={password}
                onChange={handlePasswordChange}
              />
            </div>
            <div>
              <button className='primary-button'>Enviar</button>
            </div>
          </form>
        </fieldset>
        {errorMessage}
      </div>
      <div>
        Não possui conta? <Link to={ROUTES.SIGN_UP}>Cadastre-se</Link>
      </div>
    </div>
  )
}
