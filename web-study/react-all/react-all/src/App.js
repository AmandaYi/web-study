import React from 'react';
// import Index from './Components/BaseUse/index.jsx'
// import Index from "./Components/advancedUse/index.jsx"
// import Index from "./Components/ReduxUse/index"
// import Index from './Components/RouterUse';
// import Index from "./Components/SetStateCountDemo"
import Index from "./Components/HooksDemo/index"
class App extends React.Component {
  state = {
    count: 0
  }
  componentDidMount() {
    // console.log(React.version)
  }
  render() {
    return (
      <Index></Index>
    );
  }
}

export default App;

