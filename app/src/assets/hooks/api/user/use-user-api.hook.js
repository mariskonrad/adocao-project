import { useHttp } from '../_base/use-http.hook'
import { baseUrl } from '../_base/base-url'
import { useMemo } from 'react'

export function useUserApi() {
  const httpInstance = useHttp(baseUrl)

  async function login(username, password) {
    const response = await httpInstance.post(
      '/login',
      {},
      {
        auth: {
          username,
          password
        }
      }
    )
    return response
  }

  async function signUp(username, email, password) {
    const response = await httpInstance.post('/users', {
      name: username,
      email: email,
      password: password
    })
    return response
  }

  function logout() {
    return httpInstance.post('/logout')
  }

  return useMemo(
    () => ({ login, signUp, logout }),
    // eslint-disable-next-line react-hooks/exhaustive-deps
    []
  )
}
