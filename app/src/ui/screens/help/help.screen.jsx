import { Header } from '../../components/header/header.component'
import './help.style.css'

export function HelpScreen() {
  return (
    <>
      <Header />
      <div className='help-container container'>
        <div className='title'>Como ajudar</div>
        <div className='help-content'>
          <div className='help-content-text'>
            <p className='text-primary'>Voluntariado</p>
            <p className='text-tertiary'>
              Os voluntários ajudam nas tarefas do canil, nos eventos, no transporte dos animais, doações, nos
              banhos e nos passeios dos nossos animais.
            </p>
          </div>
          <div className='help-content-text'>
            <p className='text-primary'>Parcerias</p>
            <p className='text-tertiary'>
              Para empresas que queiram formar parcerias para atendimento veterinário, castração, venda de
              produtos com porcentagem de doação para a Associação, doação de produtos, etc.
            </p>
          </div>
          <div className='help-content-text'>
            <p className='text-primary'>Doação em dinheiro</p>
            <p className='text-tertiary'>Toda e qualquer doação é bem vinda e muito importante!</p>
            <p className='text-tertiary'>Chave PIX para doação: 99999999</p>
          </div>
        </div>
      </div>
    </>
  )
}
