import { Injectable } from '@nestjs/common';

import Hello, { Hello2 } from './Hello'

import Hello3 from './Hello3'

import React = require('react');

import * as ReactDOM from "react-dom/server"
@Injectable()
export class AppService {
  getHello(): any {
    return `
      <html>
        <body>
          <h1>测试</h1>
          <p>${ReactDOM.renderToString(<Hello />)}</p>
        </body>
      </html>
    `;
  }
  getList(): any {
    let str = `
    <html>
      <body>
        <h1>测试2222223333333333333333333333</h1>
        <div>${ReactDOM.renderToString(<Hello2 />)}</div>
        <div>${ReactDOM.renderToString(<Hello3 />)}</div>
      </body>
    </html>
  ` 
  console.log(str)
    return str;
  }
}
