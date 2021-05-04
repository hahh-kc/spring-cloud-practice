import {LOAD_PRODUCT_SUCCESS} from '../action/actions.js';
const initialState = { products: [] };
export const rowReducer = (state = initialState, action) => {
    const { type, payload } = action;
   
    switch (type) { 
    
    case LOAD_PRODUCT_SUCCESS: {
        
        return {            
            ...state,
            data: payload.data,
        };
    }
   
    default:
        return state;
    }
}