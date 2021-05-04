import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import { configureStore } from './app/store';

// import { persistStore } from 'redux-persist';
// import { PersistGate } from 'redux-persist/lib/integration/react';
import { Provider } from 'react-redux';

const store = configureStore();
// const persistor = persistStore(store);

ReactDOM.render(
  <React.StrictMode>
    <Provider store={store}>       
        <App />        
    </Provider>
    </React.StrictMode>,
    document.getElementById('root'),
);