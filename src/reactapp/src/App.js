import React from 'react';
import './App.css';
import Home from './pages/Home'; // Import the Home component

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <Home /> {/* Use the Home component */}
      </header>
    </div>
  );
}

export default App;
