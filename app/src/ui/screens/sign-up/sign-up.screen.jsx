import { useState } from 'react'
import { ROUTES } from '../../../constants/routes'
import { Link, useNavigate } from 'react-router-dom'
import { useUserApi } from '../../../assets/hooks/api'
import './sign-up.style.css'
import '../login/login.style.css'
import '../../../index.css'

export function SignUpScreen() {
  const [inputsSignUp, setInputSignUp] = useState({ name: '', email: '', password: '' })
  const [errorMessage, setErrorMessage] = useState(null)
  const userApi = useUserApi()
  const navigate = useNavigate()

  function handleChange(event) {
    const { name, value } = event.target
    const userInformation = { ...inputsSignUp, [name]: value }
    setInputSignUp(userInformation)
  }

  async function handleSignUpSubmit(event) {
    event.preventDefault()

    try {
      await userApi.signUp(inputsSignUp.name, inputsSignUp.email, inputsSignUp.password)
      navigate(ROUTES.LOGIN)
    } catch (error) {
      setErrorMessage(error.response.data.message)
    }
  }

  return (
    <div className='sign-up-container'>
      <div className='title'>Cadastro</div>
      <div className='sign-up-form'>
        <form className='form-primary'>
          <div className='label-left-align'>
            <div className='form-input'>
              <div className='form-input-title'>Nome</div>
              <input
                name='name'
                type='text'
                value={inputsSignUp.name}
                onChange={handleChange}
                placeholder='Nome'
              />
            </div>
          </div>
          <div className='label-left-align'>
            <div className='form-input'>
              <div className='form-input-title'>E-mail</div>
              <input
                name='email'
                type='email'
                value={inputsSignUp.email}
                onChange={handleChange}
                placeholder='E-mail'
              />
            </div>
          </div>
          <div className='label-left-align'>
            <div className='form-input-title'>
              <div className='input-form'>Senha</div>
              <input
                name='password'
                type='password'
                value={inputsSignUp.password}
                onChange={handleChange}
                placeholder='Senha'
              />
            </div>
          </div>
        </form>
      </div>
      <button onClick={handleSignUpSubmit} className='primary-button button-360'>
        Cadastrar
      </button>
      {errorMessage}
      <div>
        Já tem uma conta?{' '}
        <Link to={ROUTES.LOGIN} className='text-secondary'>
          Faça login.
        </Link>
      </div>
    </div>
  )
}
