
import Explore from '../Explore/Explore'
import Saved from '../Saved/Saved'
import './Main.css'
import { Route, Routes } from 'react-router-dom'

const Main = () => {

  return (
    <main>
      <Routes>
        <Route path='/' element={<Explore />} />
        <Route path='/explore' element={<Explore />} />
        <Route path='/saved' element={<Saved />} />
      </Routes>
    </main>
  )
}
export default Main