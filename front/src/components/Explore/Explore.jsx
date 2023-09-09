
import './Explore.css'
import { Button } from 'tdesign-react'
import HouseCard from '../HouseCard/HouseCard'
import { useEffect, useState } from 'react'

const Explore = () => {

  const [data, setData] = useState([]);

  useEffect(() => {


    const url = "http://localhost:8080/publico/authenticate"; // Reemplaza esto con la URL de tu servidor de inicio de sesión

    return fetch(url, {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((response) => {
        console.log(response);
        setData(response.data);
        return response;
      })
      .catch((error) => {
        console.error("Error al iniciar sesión:", error);
        throw error;
      });
  }, [])

  const houses = [
    {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}
  ]

  return (
    <div className="explore">
      <div className="explore-sections">
        <Button size="large" variant="outline">All houses</Button>
        <Button size="large" variant="outline">For rent</Button>
        <Button size="large" variant="outline">Airbnb houses</Button>
        <Button size="large" variant="outline">For sale</Button>
      </div>
      <div className="houses-list">
        {houses.map((item, index) => { return (<HouseCard key={index} />) })}
      </div>
    </div>
  )
}

export default Explore