import {loadProductsSuccess} from '../action/actions.js';

export const loadProducts = () => async dispatch => {
    try {
       
        const response = await fetch('http://localhost:9090/product');
        const products = await response.json();
    
        dispatch(loadProductsSuccess(products));
    } catch (e) {
       
    }
}