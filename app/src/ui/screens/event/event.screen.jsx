import { useParams } from 'react-router-dom'
import { useEventsApi } from '../../../assets/hooks/api'
import { Header, EventDetails } from '../../components'
import { useState } from 'react'
import { useEffect } from 'react'

export function EventScreen() {
  const { id } = useParams()
  const eventsApi = useEventsApi()
  const [event, setEvent] = useState(null)
  const [errorMessage, setErrorMessage] = useState(null)

  useEffect(() => {
    async function getEventById() {
      try {
        const response = await eventsApi.getEventDetails(id)
        setEvent(response)
      } catch (error) {
        setErrorMessage('Evento não encontrado.')
      }
    }
    getEventById()
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [eventsApi])

  return (
    <>
      <Header />
      <div className='event-screen-content'>
        <EventDetails event={event} />
      </div>
    </>
  )
}
