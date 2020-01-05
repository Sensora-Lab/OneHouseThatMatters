import React, { Component } from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import Autostart from './libs/Autostart';
import { Alert } from './libs/Libs';
import './App.scss';

const loading = () => <div className="animated fadeIn pt-3 text-center">Loading...</div>;

// Containers
const DefaultLayout = React.lazy(() => import('./containers/DefaultLayout'));

new Autostart();


// Pages
const Page404 = React.lazy(() => import('./views/Pages/Page404'));
const Page500 = React.lazy(() => import('./views/Pages/Page500'));

class App extends Component {

    render() {
        return (
          <BrowserRouter>
              <React.Suspense fallback={loading()}>
                <Switch>
                  <Route exact path="/404" name="Page 404" render={props => <Page404 {...props}/>} />
                  <Route exact path="/500" name="Page 500" render={props => <Page500 {...props}/>} />
                  <Route path="/" name="Home" render={props => <DefaultLayout {...props}/>} />
                </Switch>
                <Alert />
              </React.Suspense>
          </BrowserRouter>
        );
    }
}

export default App;
