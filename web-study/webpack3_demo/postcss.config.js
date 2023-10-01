module.exports = {
    plugins: [
        //这就是对postCSS一个简单的配置，引入了autoprefixer插件。让postCSS拥有添加前缀的能力，它会根据 can i use 来增加相应的css3属性前缀。
        require("autoprefixer")
    ]
}