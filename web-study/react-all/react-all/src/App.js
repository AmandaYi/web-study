import React  from 'react';
// import Index from './Components/BaseUse/index.jsx'
// import Index from "./Components/advancedUse/index.jsx"
import Index from "./Components/ReduxUse/index"
class App extends React.Component {
  state = {
    count: 0
  }
  componentDidMount() {
  }
  render() {
    return (
      <Index></Index>
    );
  }
}

export default App;
