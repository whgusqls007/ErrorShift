import { BrowserRouter as Router, Routes, Route} from 'react-router-dom';import './App.css';
import Main from '../features/main/home/Home';
import Adv from '../features/main/adv/Adv';
import ErrorType from '../features/main/errortype/ErrorType'

import ErorrTypeOne from '../features/errorpage/errortype1'
import ErorrTypeTwo from '../features/errorpage/errortype2'
import ErorrTypeThree from '../features/errorpage/errortype3'

function App() {
  return (

    <Router>
      <Routes>
        <Route exact path="/" element={ <Main/> } />
        <Route exact path="/adv" element={ <Adv/> } />
        <Route exact path="/errortype" element={ <ErrorType/> } />

        <Route exact path="/errortype/errortype1" element={ <ErorrTypeOne/> } /> 
        <Route exact path="/errortype/errortype2" element={ <ErorrTypeTwo/> } /> 
        <Route exact path="/errortype/errortype3" element={ <ErorrTypeThree/> } /> 
        
      </Routes>
    </Router>
  );
}

export default App;
