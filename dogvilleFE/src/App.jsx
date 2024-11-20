import { Provider } from 'react-redux'
import './App.css'
import store from "./redux/store"

import HomepageCustom from './components/homepage/HomepageCustom'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import NotFoundPage from './components/NotFoundPage'

function App() {

  return (
    <>
      <Provider store={store}>
        <BrowserRouter>
          <Routes>
            <Route path="/" element={
              <HomepageCustom></HomepageCustom>
            }>
            </Route>
            <Route path="*" element={<NotFoundPage />}></Route>
          </Routes>
        </BrowserRouter>


      </Provider>

    </>
  )
}

export default App
