import { Header, AnimalDetails } from '../../components'
import { useParams } from 'react-router-dom'
import { useEffect, useState } from 'react'
import { useAnimalsApi } from '../../../assets/hooks/api'

export function AnimalScreen() {
  const { id } = useParams()
  const animalsApi = useAnimalsApi()
  const [animal, setAnimal] = useState()
  const [errorMessage, setErrorMessage] = useState()

  useEffect(() => {
    async function getAnimalById() {
      try {
        const response = await animalsApi.getPetDetails(id)
        console.log('### animal screen response', response)
        setAnimal(response)
      } catch (error) {
        setErrorMessage('Animal não encontrado.')
      }
    }
    getAnimalById()
  }, [animalsApi])

  console.log('Id', id)

  return (
    <>
      <Header />
      <div className='animal-screen-content'>
        <AnimalDetails animal={animal} />
      </div>
    </>
  )
}
