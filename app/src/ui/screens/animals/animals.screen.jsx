import { useEffect, useState } from 'react'
import { useAnimalsApi } from '../../../assets/hooks/api'
import { AnimalCard, Header } from '../../components'
import './animals.style.css'

export function AnimalsScreen() {
  const petsApi = useAnimalsApi()
  const [allPets, setAllPets] = useState(null)

  useEffect(() => {
    async function getAllPets() {
      const pets = await petsApi.getAllPets()
      setAllPets(pets)
    }
    getAllPets()
  }, [petsApi])

  console.log(allPets)

  if (!allPets) {
    return <h1>Nenhum pet cadastrado</h1>
  }

  return (
    <>
      <Header />
      <div className='pets-container'>
        {allPets?.content.map(pet => {
          return (
            <div key={pet.id} className='card-container'>
              <AnimalCard animal={pet} />
            </div>
          )
        })}
      </div>
    </>
  )
}
