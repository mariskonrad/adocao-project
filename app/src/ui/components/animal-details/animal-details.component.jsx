import { SIZE, SEX } from '../../../constants'
import './animal-details.style.css'

export function AnimalDetails({ animal }) {
  return (
    <>
      <div className='animal-screen-container'>
        <div className='animal-screen-description'>
          <div className='animal-details-image'>
            {animal && <img src={animal.image} alt='Imagem do cachorro' />}
          </div>
          <div className='animal-details-info'>
            <p>Nome: {animal?.name}</p>
            <p>Idade: {animal?.age}</p>
            <p>Tamanho: {SIZE[animal?.size]}</p>
            <p>Sexo: {SEX[animal?.sex]}</p>
          </div>
        </div>
      </div>
    </>
  )
}
