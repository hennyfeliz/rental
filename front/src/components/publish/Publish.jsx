

import AutocompleteDropdown from '../Dropdown/AutocompleteDropdown';
import './Publish.css'
import { useRef, useState } from 'react';

const Publish = () => {

  const addressRef = useRef(null);
  const isAvailableRef = useRef(null);
  const ownerRef = useRef(null);
  const rentalInfoRef = useRef(null);
  let imageId = null;

  const [fetchResponse, setFetchResponse] = useState(false);

  const uploadImages = (event) => {
    const token = localStorage.getItem('token');

    const url = 'http://localhost:8080/image/subir';
    const files = event.target.files;
    const formData = new FormData();

    for (let i = 0; i < files.length; i++) {
      formData.append('archivo', files[i]);
    }

    fetch(url, {
      method: 'POST',
      headers: {
        'Authorization': `Bearer ${token}`,
      },
      body: formData
    })
      .then(response => response.text())
      .then(data => {
        setFetchResponse(data);
        imageId = data;
        console.log(imageId);
      })
      .catch(error => {
        console.error('Error occurred while uploading images:', error);
        throw error;
      });
  };

  const handleSubmit = async () => {

    const token = localStorage.getItem('token');

    const dataToSend = {
      address: addressRef.current.value,
      available: isAvailableRef.current.checked,
      owner: ownerRef.current.value,
      rentalInfo: rentalInfoRef.current.value,
      image: imageId
    };

    try {
      const response = await fetch('http://localhost:8080/api/v1/houses/', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${token}`,
        },
        body: JSON.stringify(dataToSend),
      });

      if (response.ok) {
        console.log('Datos enviados con éxito');
      } else {
        console.error('Error al enviar datos');
      }
    } catch (error) {
      console.error('Error al realizar la solicitud:', error);
    }
  };

  return (
    <div className='publish'>
      <div>
        <span>address</span>
        <input type="text" placeholder='Address' ref={addressRef} />
      </div>
      <div className='available-div'>
        <span>¿Is the house available?</span>
        <input type='checkbox' className='checkbox-available' ref={isAvailableRef} />
      </div>
      <div>
        <span>Owner</span>
        <input type="number" placeholder='Owner' ref={ownerRef} />
      </div>
      {/* <div>
        <input type="number" placeholder='Rental Information' ref={rentalInfoRef} />
      </div> */}
      <div>
        <span>Rental Info</span>
        <AutocompleteDropdown />
      </div>
      <div className='images-div'>
        <span>Imagenes</span>
        <input type='file' onChange={uploadImages} multiple />
        {fetchResponse ? <span>Imagen cargada! {`${imageId}`} </span> : ''}
      </div>
      <div className='publish-buttons'>
        <button className='button red'>Limpiar información</button>
        <button className='button green' onClick={handleSubmit}>Enviar información de Casa</button>
      </div>
    </div>
  );
};

export default Publish;
