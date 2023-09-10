


import './Sidebar.css'
import explore from '../../assets/icons/explore.svg'
import saved from '../../assets/icons/saved.svg'
import publish from '../../assets/icons/album-.svg'
import house from '../../assets/icons/house.svg'
import { Link } from 'react-router-dom'
import logout from '../../assets/icons/logout23.svg'


const Sidebar = () => {
  return (
    <aside>
      <Link to='/'>
        <div>
          <img
            alt='house-section-icon'
            src={house}
            className="section-icon"
          />
          <span>Home</span>
        </div>
      </Link>
      <hr />
      <Link to='/explore'>
        <div>
          <img
            alt='sidebar-section-icon'
            src={explore}
            className="section-icon"
          />
          <span>Explore</span>
        </div>
      </Link>
      <Link to='/saved'>
        <div>
          <img
            alt='sidebar-section-icon'
            src={saved}
            className="section-icon"
          />
          <span>Saved</span>
        </div>
      </Link>
      <Link to='/publish'>
        <div>
          <img
            alt='sidebar-section-icon'
            src={publish}
            className="section-icon"
          />
          <span>Publish</span>
        </div>
      </Link>
      <hr />
      <Link to='/login'>
        <div className="logout-button">
          <img
            alt='sidebar-section-icon'
            src={logout}
            className="section-icon"
          />
          <span>Logout</span>
        </div>
      </Link>
    </aside>
  )
}

export default Sidebar