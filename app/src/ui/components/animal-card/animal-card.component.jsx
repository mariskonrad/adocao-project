import './animal-card.style.css'
import { SIZE, SEX } from '../../../constants'

export function AnimalCard({ animal }) {
  return (
    <div>
      <div className='animal-imagem'>
        <img src={animal.image} alt='Imagem do cachorro' className='animal-image' />
      </div>
      <div>Nome: {animal.name}</div>
      <div>Idade: {animal.age}</div>
      <div>Tamanho: {SIZE[animal.size]}</div>
      <div>{SEX[animal.sex]}</div>
    </div>
  )
}
