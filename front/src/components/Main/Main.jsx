
import Explore from '../Explore/Explore'
import Saved from '../Saved/Saved'
import Publish from '../publish/Publish'
import './Main.css'
import { Route, Routes } from 'react-router-dom'

const Main = () => {

  return (
    <main>
      <Routes>
        <Route path='/' element={<>
          <h1>Eliga el apartado a buscar...</h1>
        </>} />
        <Route path='/explore' element={<Explore />} />
        <Route path='/saved' element={<Saved />} />
        <Route path='/publish' element={<Publish />} />
      </Routes>
    </main>
  )
}
export default Main