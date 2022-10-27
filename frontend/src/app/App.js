import { BrowserRouter as Router, Routes, Route} from 'react-router-dom';import './App.css';
import Main from '../features/main/home/Home';
import Adv from '../features/main/adv/Adv';
import ErrorType from '../features/main/errortype/ErrorType'

import FourZeroZero from '../features/errorpage/4xx/400'
import FourZeroOne from '../features/errorpage/4xx/401'
import FourZeroTwo from '../features/errorpage/4xx/402'

import FiveZeroZero from '../features/errorpage/5xx/500'
import FiveZeroOne from '../features/errorpage/5xx/501'
import FiveZeroTwo from '../features/errorpage/5xx/502'

function App() {
  return (

    <Router>
      <Routes>
        <Route exact path="/" element={ <Main/> } />
        <Route exact path="/adv" element={ <Adv/> } />
        <Route exact path="/errortype" element={ <ErrorType/> } />

        <Route exact path="/errortype/400" element={ <FourZeroZero/> } /> 
        <Route exact path="/errortype/401" element={ <FourZeroOne/> } /> 
        <Route exact path="/errortype/402" element={ <FourZeroTwo/> } /> 
        
        <Route exact path="/errortype/500" element={ <FiveZeroZero/> } /> 
        <Route exact path="/errortype/501" element={ <FiveZeroOne/> } /> 
        <Route exact path="/errortype/502" element={ <FiveZeroTwo/> } /> 
      </Routes>
    </Router>
  );
}

export default App;
