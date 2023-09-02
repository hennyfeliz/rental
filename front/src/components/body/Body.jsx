

import './Body.css'
import remodelectrix from '../../assets/services-images/Remodelectrix.png'


const Body = () => {
  return (
    <main>
      <section className="section">
        <h1>Conectando el Futuro: Tu Guía Eléctrica en Línea</h1>
      </section>
      <section className="section">
        <img
          src={remodelectrix}
          alt='remodelectrix-icon'
          // style={{ width: '34px', height: '34px', padding: '8px', }}
        />
      </section>
    </main>
  )
}

export default Body