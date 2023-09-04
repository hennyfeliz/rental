

import './Header.css'
import house_icon from '../../assets/icons/house.svg'

const Header = () => {
  return (
    <header>
      <div>
        <img
          alt='house_icon-icon'
          src={house_icon}
          className="house_icon"
        />
        <h2>
          Houses
        </h2>
      </div>
    </header>
  )
}

export default Header