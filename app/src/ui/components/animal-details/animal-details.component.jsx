export function AnimalDetails({ animal }) {
  return (
    <>
      <div className='animal-screen-container'>
        <div className='animal-screen-description'>
          {animal && <img src={animal.image} alt='Imagem do cachorro' />}
        </div>
      </div>
    </>
  )
}
