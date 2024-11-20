import { Provider } from 'react-redux'
import './App.css'
import store from "./redux/store"

import HomepageCustom from './components/homepage/HomepageCustom'

function App() {

  return (
    <>
      <Provider store={store}>
        <HomepageCustom></HomepageCustom>
      </Provider>

    </>
  )
}

export default App
