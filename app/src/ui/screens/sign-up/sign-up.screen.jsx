import { useState } from 'react'
import { ROUTES } from '../../../constants/routes'
import { Link, useNavigate } from 'react-router-dom'
import { useUserApi } from '../../../assets/hooks/api'

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
      <h3 className='title-primary'>CADASTRO</h3>
      <div className='sign-up-form'>
        <form className='form-primary'>
          <div className='label-left-align'>
            <label>
              Nome
              <input
                name='name'
                type='text'
                value={inputsSignUp.name}
                onChange={handleChange}
                placeholder='Nome'
              />
            </label>
          </div>
          <div className='label-left-align'>
            <label>
              E-mail
              <input
                name='email'
                type='email'
                value={inputsSignUp.email}
                onChange={handleChange}
                placeholder='E-mail'
              />
            </label>
          </div>
          <div className='label-left-align'>
            <label>
              Senha
              <input
                name='password'
                type='password'
                value={inputsSignUp.password}
                onChange={handleChange}
                placeholder='Senha'
              />
            </label>
          </div>
          {/* <div className='label-left-align'>
            <label>
              Imagem de perfil
              <input
                name='profileImage'
                type='text'
                value={inputsSignUp.imagemPerfil}
                onChange={handleChange}
                placeholder='Imagem de perfil'
              />
            </label>
          </div> */}
        </form>
      </div>
      <button onClick={handleSignUpSubmit} className='button-primary button-360'>
        Cadastrar
      </button>
      {errorMessage}
      <div>
        Já tem uma conta?{' '}
        <Link to={ROUTES.LOGIN} className='link-primary'>
          Faça login.
        </Link>
      </div>
    </div>
  )
}
