
import './Explore.css'
import { Button } from 'tdesign-react'
import HouseCard from '../HouseCard/HouseCard'

const Explore = () => {

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