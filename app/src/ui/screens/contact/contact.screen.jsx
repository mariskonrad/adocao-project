import { Header } from '../../components'
import EMAIL from '../../../images/email.png'
import PHONE from '../../../images/whats.png'
import './contact.style.css'

export function ContactScreen() {
  return (
    <>
      <Header />
      <div className='container'>
        <div className='contact-container'>
          <div className='contact-box'>
            <p className='title'>Entre em contato conosco</p>
            <div className='contact-info'>
              <div>
                <img src={EMAIL} alt='Ícone e-mail' className='icons' />
              </div>
              <div className='text-tertiary'>associacao@gmail.com</div>
            </div>
            <div className='contact-info'>
              <div>
                <img src={PHONE} alt='Ícone telefone' className='icons' />
              </div>
              <div className='text-tertiary'>(51) 99999999</div>
            </div>
          </div>
        </div>
      </div>
    </>
  )
}
