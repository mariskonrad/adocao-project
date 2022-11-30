import { Header } from '../../components/header/header.component'
import DOG from '../../../images/dog.png'
import './home.style.css'

export function HomeScreen() {
  return (
    <>
      <Header />
      <div className='container'>
        <div className='home-content'>
          <div className='home-title'>Adote um amigo!</div>
          <div>
            <img src={DOG} alt='Cachorro' />
          </div>
        </div>
      </div>
    </>
  )
}
