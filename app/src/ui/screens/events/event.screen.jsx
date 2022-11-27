import { Header, EventCard } from '../../components'
import { useEventsApi } from '../../../assets/hooks/api'
import { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'

export function EventsScreen() {
  const eventsApi = useEventsApi()
  const [allEvents, setAllEvents] = useState(null)

  useEffect(() => {
    async function getEvents() {
      const events = await eventsApi.getAllEvents()
      setAllEvents(events)
    }
    getEvents()
  }, [eventsApi])

  if (!allEvents) {
    return (
      <>
        <Header />
        <h1>Nenhum evento cadastrado</h1>
      </>
    )
  }

  return (
    <>
      <Header />
      <div>
        <div>
          <h1>Nossos eventos</h1>
        </div>
        <div>
          {allEvents?.content.map(event => {
            return (
              <div key={event.id} className='card-container'>
                <Link to={`/eventos/${event.id}`}>
                  <EventCard event={event} />
                </Link>
              </div>
            )
          })}
        </div>
      </div>
    </>
  )
}
