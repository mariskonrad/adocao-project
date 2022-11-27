import { Header, AnimalDetails, Button } from '../../components'
import { useParams } from 'react-router-dom'
import { useEffect, useState } from 'react'
import { useAnimalsApi } from '../../../assets/hooks/api'
import './animal-screen.style.css'

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
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [animalsApi])

  return (
    <>
      <Header />
      <div className='animal-screen-content'>
        <AnimalDetails animal={animal} />
        <Button className='button-primary'>Quero adotar!</Button>
      </div>
    </>
  )
}
