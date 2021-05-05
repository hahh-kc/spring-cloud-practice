import React from 'react';
import logo from './logo.svg';
import './App.css';
// import { Routes, Route } from "react-router-dom";
import ProductGrid from './app/ProductGrid.js';
import { Tab, Tabs, TabList, TabPanel } from 'react-tabs';
import 'react-tabs/style/react-tabs.css';

function Main({ login }) {

  // const [data, setData] = useState(null);
  // const [loading, setLoading] = useState(false);
  // const [error, setError] = useState(null);
  return (

    <Tabs>
      <TabList>
        <Tab>Product List</Tab>
        <Tab>View Product</Tab>
      </TabList>

      <TabPanel>
        <h2>Product List</h2>
        <ProductGrid />
      </TabPanel>
      <TabPanel>
        <h2>View Product</h2>
      </TabPanel>
    </Tabs>



  );
}


function Footer(props) {
  return (
    <div className="Footer">Copyright by {props.companyName}</div>
  )
}

function Header() {
  return (
    <header className="App-header">
      <img src={logo} className="App-logo" alt="Hello Product React App" />
    </header>
  )
}


function App() {
  return (
    <>
      <div className="App">
        <Header />
        <Main login="hhh7681" />
        <Footer companyName="K+C"> </Footer>
      </div>
    </>
  );
}

export default App;
