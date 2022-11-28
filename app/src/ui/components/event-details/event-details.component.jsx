export function EventDetails({ event }) {
  return (
    <>
      <div className='event-screen-container'>
        <div className='event-screen-description'>
          <div className='event-details-image'>
            {event && <img src={event.image} alt='Imagem do evento' />}
          </div>
          <div className='event-details-info'>
            <p>Descrição: {event?.description}</p>
            <p>Data e hora: {event?.startEvent}</p>
            <p>Local: {event?.location}</p>
          </div>
        </div>
      </div>
    </>
  )
}
