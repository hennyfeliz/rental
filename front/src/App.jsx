import './App.css'
import Sidebar from './components/Sidebar/Sidebar'
import Main from './components/Main/Main'
import Explore from './components/Explore/Explore'
import Saved from './components/Saved/Saved'
import Header from './components/Header/Header'
import { Toaster } from 'sonner'
import Login from './components/Login/Login'
import { Route, Routes, BrowserRouter } from 'react-router-dom'
import Publish from './components/publish/Publish'

function App() {

  return (
    <>
      <BrowserRouter>
        <Toaster />
        <Routes>
          <Route path='/' exac element={
            <div className="main-container-1">
              <Sidebar />
              <div className="main-container-2">
                <Header />
                <Main />
              </div>
            </div>
          }>
            <Route path='/explore' element={<Explore />} />
            <Route path='/saved' element={<Saved />} />
            <Route path='/publish' element={<Publish />} />
          </Route>
          <Route path='/login' element={<Login />} />
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
