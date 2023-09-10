

import './Disponibilidad.css'


const Disponibilidad = ({ available }) => {
  return (
    <div className="estado-disponibilidad">
      <div
        className={`punto-señal ${available ? 'verde' : 'rojo'}`}
      ></div>
      {/* <span>{available ? 'Disponible' : 'No disponible'}</span> */}
    </div>
  )
}

export default Disponibilidad