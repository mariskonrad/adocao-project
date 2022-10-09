import { useHttp } from '../_base/use-http.hook'
import { baseUrl } from '../_base/base-url'
import { useMemo } from 'react'

export function useAnimalsApi() {
  const httpInstance = useHttp(baseUrl)

  async function getAllPets() {
    const response = await httpInstance.get('/pets')
    return response
  }

  return useMemo(
    () => ({
      getAllPets
    }),
    // eslint-disable-next-line react-hooks/exhaustive-deps
    []
  )
}
