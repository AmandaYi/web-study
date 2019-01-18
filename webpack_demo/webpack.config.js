var website = {
    publicPath: "http://localhost:2019/"
}


const path = require("path")
const uglify = require("uglifyjs-webpack-plugin")
const htmlPlugin = require('html-webpack-plugin')
const extractTextPlugin = require("extract-text-webpack-plugin")
module.exports = {
    // 入口
    entry: "./src/entery.js",
    // 出口
    output: {
        // 打包文件的路径
        path: path.resolve(__dirname, "./dist"),
        // 打包文件的名字,修改  //输出的文件名称 
        //[name]的意思是根据入口文件的名称，打包成相同的名称，有几个入口文件，就可以打包出几个文件。
        filename: "entery.js",
        publicPath: website.publicPath
    },

    // 模块,例如,解读CSS,图片如何转换,压缩
    module: {
        rules: [
            // 匹配less
            {
                test: /\.(less)$/,
                // use: [
                //     {
                //         loader:"style-loader"
                //     },
                //     {
                //         loader:"css-loader"
                //     },
                //     {
                //         loader: "less-loader"
                //     }
                // ],
                // less文件分离
                use: extractTextPlugin.extract({
                    use: [{
                        loader: "css-loader"
                    }, {
                        loader: "less-loader"
                    }],
                    fallback: "style-loader"
                })
            },
            {
                test: /\.(html|htm)$/,
                use: "html-withimg-loader"
            },
            {
                test: /\.css$/,
                // 第一种写法
                // use: ["style-loader", "css-loader"],
                // // 第二种写法
                // loader: ["style-loader", "css-loader"],
                // 第三种写法
                use: extractTextPlugin.extract({
                    fallback: "style-loader",
                    use: [{
                        loader: "css-loader",
                        options: { importLoaders: 1 },
                    }, "postcss-loader"]
                })
            },
            {
                // test:/.(png|jpg|gif)/是匹配图片文件后缀名称。
                test: /\.(png|jpg|gif)$/,
                // use：是指定使用的loader和loader的配置参数。
                use: [{
                    loader: "url-loader",
                    options: {
                        // limit：是把小于500000B的文件打成Base64的格式，写入JS。
                        limit: 500000,
                        outputPath: 'images/',
                        // 1.文件大小小于limit参数，url-loader将会把文件转为DataURL（Base64格式）；
                        // 2.文件大小大于limit，url-loader会调用file-loader进行处理，参数也会直接传给file-loader。
                    }
                },
                    // {
                    //     loader: "file-loader",// 其实这里是不需要加载这个file-loader的,因为,url-loader已经内置了url-loader
                    //     // 为什么只使用了url-loader
                    //     // 有的小伙伴会发现我们并没有在webpack.config.js中使用file-loader，但是依然打包成功了。我们需要了解file-loader和url-loader的关系。url-loader和file-loader是什么关系呢？简答地说，url-loader封装了file-loader。url-loader不依赖于file-loader，即使用url-loader时，只需要安装url-loader即可，不需要安装file-loader，因为url-loader内置了file-loader。通过上面的介绍，我们可以看到，url-loader工作分两种情况：
                    // }
                ]
            }
        ]
    },

    // 插件,用于生产模板,和各项功能
    plugins: [new uglify(), new htmlPlugin({
        // minify：是对html文件进行压缩，removeAttrubuteQuotes是却掉属性的双引号。
        minify: {
            removeAttributeQuotes: true
        },
        hash: true,//hash：为了开发中js有缓存效果，所以加入hash，这样可以有效避免缓存JS。
        template: "./src/index.html"//template：是要打包的html模版路径和文件名称。
    }),
    //这里的/css/index.css是分离后的路径位置。这部配置完成后，包装代码：还要修改原来我们的style-loader和css-loader。
    new extractTextPlugin("./css/index.css")
    ],

    // 配置webpack开发环境的服务功能
    devServer: {
        //设置基本目录结构
        contentBase: path.resolve(__dirname, 'dist'),
        //服务器的IP地址，可以使用IP也可以使用localhost
        host: 'localhost',
        //服务端压缩是否开启
        compress: true,
        //配置服务端口号
        port: 2019
    }
}


