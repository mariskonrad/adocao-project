import { useEffect, useState } from 'react'
import { useAnimalsApi } from '../../../assets/hooks/api'
import { AnimalCard, Header } from '../../components'
import { Link } from 'react-router-dom'
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

  if (!allPets) {
    return (
      <>
        <Header />
        <h1>Nenhum pet cadastrado</h1>
      </>
    )
  }

  return (
    <>
      <Header />
      <h1>Amigos disponíveis</h1>
      <div className='pets-container'>
        {allPets?.content.map(pet => {
          return (
            <div key={pet.id} className='card-container'>
              <Link to={`/adotaveis/${pet.id}`}>
                <AnimalCard animal={pet} />
              </Link>
            </div>
          )
        })}
      </div>
    </>
  )
}
