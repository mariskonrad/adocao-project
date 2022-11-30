import { formatDateWhitHours } from '../../../utils'

export function EventCard({ event }) {
  const dateFormatted = formatDateWhitHours(event.startEvent)
  return (
    <div className='card-container'>
      <div>
        <img src={event.image} alt='Imagem do evento' className='event-image' />
      </div>
      <div className='text-primary'>{event.description}</div>
      <div className='text-tertiary'>Data e hora: {dateFormatted}</div>
      <div className='text-tertiary'>Local: {event.location}</div>
    </div>
  )
}
