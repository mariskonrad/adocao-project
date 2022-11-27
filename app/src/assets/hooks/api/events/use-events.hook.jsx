import { useHttp } from '../_base/use-http.hook'
import { baseUrl } from '../_base/base-url'
import { useMemo } from 'react'

export function useEventsApi() {
  const httpInstance = useHttp(baseUrl)

  async function getAllEvents() {
    const response = await httpInstance.get('/events')
    return response
  }

  async function getEventDetails(id) {
    const response = await httpInstance.get(`events/${id}`)
    return response
  }

  return useMemo(
    () => ({
      getAllEvents,
      getEventDetails
    }),
    // eslint-disable-next-line react-hooks/exhaustive-deps
    []
  )
}
