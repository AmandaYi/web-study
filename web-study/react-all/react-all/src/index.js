import React from 'react';
import ReactDOM from 'react-dom';
// import ReactDOM from "react-dom/client"
import App from './App';
import * as serviceWorker from './serviceWorker';

ReactDOM.render(<App />, document.getElementById('root'));
// ReactDOM.createRoot(document.getElementById("root")).render(<App/>)
serviceWorker.register();
