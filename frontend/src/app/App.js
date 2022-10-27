import { BrowserRouter as Router, Routes, Route} from 'react-router-dom';import './App.css';
import Main from '../features/main/home/Home';
import Adv from '../features/main/adv/Adv';
import ErrorType from '../features/main/errortype/ErrorType'

function App() {
  return (
    <Router>
      <Routes>
        <Route exact path="/" element={ <Main/> } />
        <Route exact path="/adv" element={ <Adv/> } />
        <Route exact path="/errortype" element={ <ErrorType/> } />
      </Routes>
    </Router>
  );
}

export default App;
