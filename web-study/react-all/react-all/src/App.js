import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {
  state = {
    count: 0
  }
  componentDidMount() {
    this.setState({ count: this.state.count + 1 })
    console.log(this.state.count)
    this.setState({ count: this.state.count + 1 })
    console.log(this.state.count)

    this.setState(prevState => ({ count: this.state.count + 1 }), () => {
      console.log(this.state.count)
    }) 

    setTimeout(() => {
      this.setState({ count: this.state.count + 1 })
      console.log(this.state.count)
    }, 0)
    setTimeout(() => {
      this.setState({ count: this.state.count + 1 })
      console.log(this.state.count)
    }, 0)
  }
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <p>
            你好,学习react
          </p>
          <a
            className="App-link"
            href="https://reactjs.org"
            target="_blank"
            rel="noopener noreferrer"
          >
            Learn React
          </a>
          <p>count:{this.state.count}</p>
        </header>
      </div>
    );
  }
}

export default App;
