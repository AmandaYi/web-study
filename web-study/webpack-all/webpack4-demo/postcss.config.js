module.exports = {

    plugins: [
        // 引入自动增加前缀的功能,它会根据 can i use 来增加相应的css3属性前缀,后面的浏览器版本限制可以省略
        // 可以直接写成  require("autoprefixer")
        require("autoprefixer")({ browsers: ['last 2 versions'] })
    ]

}