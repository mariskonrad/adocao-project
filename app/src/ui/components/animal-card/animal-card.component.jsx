import './animal-card.style.css'
import { SIZE, SEX } from '../../../constants'

export function AnimalCard({ animal }) {
  return (
    <div>
      <div className='animal-imagem'>
        <img src={animal.image} alt='Imagem do cachorro' className='animal-image' />
      </div>
      <div className='text-primary'>{animal.name}</div>
      <div className='text-tertiary'>Idade: {animal.age}</div>
      <div className='text-tertiary'>Tamanho: {SIZE[animal.size]}</div>
      <div className='text-tertiary'>{SEX[animal.sex]}</div>
    </div>
  )
}
