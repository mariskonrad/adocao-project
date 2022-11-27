export function EventCard({ event }) {
  return (
    <div>
      <div className='event-image'>
        <img src={event.image} alt='Imagem do evento' />
      </div>
      <div>Descrição: {event.description}</div>
      <div>Data e hora: {event.startEvent}</div>
      <div>Local: {event.location}</div>
    </div>
  )
}
