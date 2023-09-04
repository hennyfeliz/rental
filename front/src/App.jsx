import './App.css'
import Sidebar from './components/Sidebar/Sidebar'
import Main from './components/Main/Main'
import Header from './components/Header/Header'

import Login from './components/Login/Login'
import { Route, Routes, BrowserRouter } from 'react-router-dom'

function App() {

  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path='/' element={
            <div className="main-container-1">
              <Sidebar />
              <div className="main-container-2">
                <Header />
                <Main />
              </div>
            </div>
          } />
          <Route path='/login' element={<Login />} />
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
