

import './Publish.css'

const Publish = () => {
  return (
    <div className='publish'>
      <div>
        <span>address</span>
        <input type="text" placeholder='Address' />
      </div>
      <div className='available-div'>
        <span>¿Is the house availabe?</span>
        <input type='checkbox' className='checkbox-available' />
      </div>
      <div>
        <span>Owner</span>
        <input type="text" placeholder='Owner' />
      </div>
      <div>
        <span>Rental Info</span>
        <input type="text" placeholder='Rental Information' />
      </div>
      <div>
        <span>Imagenes</span>
        <input type="file" placeholder='Rental Information' />
      </div>
      <div className='publish-buttons'>
        <button className='button red'>Limpiar información</button>
        <button className='button green'>Enviar información de Casa</button>
      </div>
    </div>
  )
}

export default Publish