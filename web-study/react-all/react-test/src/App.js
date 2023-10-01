import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

import Todo from './components/todo/index.js'

class App extends Component {
  render() {
    return (
      <div>
        <Todo/>
      </div>
    );
  }
}

/*
    React.createElement(
      "div",
      null,
      React.createElement(Todo, null)
    );

    var todo = new Todo()
    return todo.render()
*/

export default App;


// vue 4 步
// 1. 解析模版,把全部的模版解析成JS逻辑,for,if转换为JS逻辑,data里面的数据转换为JS的变量
// 2. 使用Object.defineProperty给data的属性进行递归绑定get 和 set 方法, 让其成为响应式, 同时,使用Object.defineProperty把data下面的属性代理到this实例下面,也就是this.data.key代理为this.key
// 3. 初次进行渲染,找到容器,然后把虚拟node同时patch函数进行渲染上去,最后渲染为html
// 4. 修改了data之后, 触发updateElement函数, 这时候是异步的, 然后用重新渲染实例,拿到新的vnode,还要拿到上一次的vnode,进行对比,使用patch形式进行更新
岗位职责：
1. 1年以上前端开发经验，有完整的前端开发案例
2. 精通 HTML5、CSS3、ES6
3. 熟悉 jQuery、Vue、React、AngularJS 中的一种框架
4. 了解 node.js 优先
5、有移动端开发、小程序开发、微信接口开发经验的优先
6、有较强的主动性，责任性，有团队合作意识精神；工作认真踏实，有探索求知欲望
任职要求：
1、互联网行业从业经验至少3年以上，可以独立开发，有对于web技术的深入了解
2、熟悉常见页面布局方式，移动端响应式页面布局方式，熟悉css性能优化方式；
3、熟悉或擅长react/angularjs/vue等前端框架中的一种或多种；
4、熟悉NODE.JS的开发实践，如expressjs或koa框架等，有生产环境的开发经验，并且熟悉PM2；
5、有前端运维的相关经验；
6、需要有良好的工作责任感和团队合作能力，热爱技术研发工作。
 
我会什么?
HTML
css,less,sass,
js,ex,jsx
mvvm,vue,react native,ionic3+,angular4+
微信小程序开发
koa,pm2,nodejs
nginx,
go,gin
php
C++
webpack,rollup,gulp
性能优化
精通HTML,CSS,LESS,SASS,ES6标准
1.精通移动端开发,使用LESS,SASS等独立完成工作
2.精通React Native,能够独立完成App开发更新上线
3.能够独立完成业务,PC/移动端界面页面还原度98%
4.熟练vue,react和微信小程序开发
5.熟悉视频直播
6.独立完成复杂前端模块的实现,编写部门需要的前端组件
7.能够使用Rollup,Webpack,Gulp构件开发流程,撰写了webpack4教程(见博客导航)
8.熟悉git,svn进行管理
9.熟悉前后端分离及Koa2
10.掌握go的基础知识,能够使用Gin+mgo开发服务
11.熟悉nginx,pm2运维
12.熟悉Angular4.x和ionic3.x开发APP
13.熟悉PHP程序开发,略微了解C++
14.能培训人员上手制作app,良好的逻辑编程能力,擅长沟通交流
15.熟悉W3C等前端标准,独立学习新技术
17.博客 blog.potop168.com