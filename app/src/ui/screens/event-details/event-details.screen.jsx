import { useParams } from 'react-router-dom'
import { Header } from '../../components'

export function EventDetails() {
  const { id } = useParams()
  return (
    <>
      <Header />
      <p>Página do evento</p>
    </>
  )
}
