import { createStore, combineReducers, applyMiddleware } from 'redux';
// import { persistReducer } from 'redux-persist';
// import storage from 'redux-persist/lib/storage';
// import autoMergeLevel2 from 'redux-persist/lib/stateReconciler/autoMergeLevel2';
import thunk from 'redux-thunk';
import { composeWithDevTools } from 'redux-devtools-extension';
import {rowReducer} from './reducers';
 

// const persistConfig = {
//     key: 'root',
//     storage,
//     stateReconciler: autoMergeLevel2,
// }

const rootReducer = combineReducers( {
    "products": rowReducer
});
// const persistedReducer = persistReducer(persistConfig, rootReducer);

export const configureStore = () =>createStore(rootReducer,composeWithDevTools(applyMiddleware(thunk)));
