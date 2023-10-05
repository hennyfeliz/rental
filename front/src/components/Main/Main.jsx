
import Explore from '../Explore/Explore'
import Saved from '../Saved/Saved'
import Publish from '../publish/Publish'
import houseIcon from '../../assets/icons/house-bg-white.svg'
import './Main.css'
import { Route, Routes } from 'react-router-dom'

const Main = () => {

  return (
    <main>
      <Routes>
        <Route path='/' element={<>
          <div className='main-container-landing-page'>
            <div className='landing-page-content'>
              <h1>Bringding the better houses</h1>
              <img
                alt='house-icon'
                className='house-icon-principal-dashboard'
                src={houseIcon}
              />
            </div>
          </div>
        </>} />
        <Route path='/explore' element={<Explore />} />
        <Route path='/saved' element={<Saved />} />
        <Route path='/publish' element={<Publish />} />
      </Routes>
    </main>
  )
}
export default Main