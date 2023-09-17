
import './Explore.css'
import { Button } from 'tdesign-react'
import HouseCard from '../HouseCard/HouseCard'
import { useEffect, useState } from 'react'

const Explore = () => {

  const [data, setData] = useState([]);

  const getHouses = () => {
    const jwtToken = localStorage.getItem('token');
    const url = "http://localhost:8080/api/v1/houses/"; 

    return fetch(url, {
      method: "GET",
      headers: {
        'Authorization': `Bearer ${jwtToken}`,
        "Content-Type": "application/json",
      },
    })
      .then((response) => {
        return response.json();
      })
      .then((data) => {
        console.log(data);
        setData(data);
        return data;
      })
      .catch((error) => {
        console.error("Error al iniciar sesión:", error);
        throw error;
      });
  }

  useEffect(() => {
    getHouses();
  }, [])

  return (
    <div className="explore">
      <div className="explore-sections">
        <Button size="large" variant="outline">All houses</Button>
        <Button size="large" variant="outline">For rent</Button>
        <Button size="large" variant="outline">Airbnb houses</Button>
        <Button size="large" variant="outline">For sale</Button>
      </div>
      <div className="houses-list">
        {data.map((item, index) => { return (<HouseCard item={item} key={index} />) })}
      </div>
    </div>
  )
}

export default Explore