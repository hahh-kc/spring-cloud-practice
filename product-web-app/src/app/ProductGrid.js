import DataGrid from 'react-data-grid';
import { connect } from 'react-redux';
import React, { useEffect } from 'react';
import {loadProducts} from './thunks';

const columns = [
  { key: 'id', name: 'ID' },
  { key: 'name', name: 'Name' },
  { key: 'description', name: 'Description' }
];


const ProductGrid = ({products, startLoadingProduct}) => {
  useEffect(() => {   
    startLoadingProduct();
  });

  
  if (products != null) {
    return (
      <DataGrid columns={columns} rows={products} />    
    );
  }
  else
  {
    return ( <div>Loading... </div> ); 
  }
}


const mapStateToProps = state => ({
  products: state.products.data,
});

const mapDispatchToProps = dispatch => ({
  startLoadingProduct: () => dispatch(loadProducts()) 
});


export default connect(mapStateToProps,mapDispatchToProps)(ProductGrid);