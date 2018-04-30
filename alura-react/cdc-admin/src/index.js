import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import registerServiceWorker from './registerServiceWorker';
//import { Router, Route, browserHistory, IndexRoute } from 'react-router';
import { BrowserRouter as Router, Route, Switch, Link } from 'react-router-dom';
import AutorBox from './Autor';
import LivroBox from './Livro';
import Home from './Home';

ReactDOM.render(
  (<Router>
    <App>
      <Switch>
        <Route exact path="/" component={Home} />
        <Route path="/autor" component={AutorBox} />
        <Route path="/livro" component={LivroBox} />
      </Switch>
    </App>
  </Router>),
  document.getElementById('root'));
registerServiceWorker();
