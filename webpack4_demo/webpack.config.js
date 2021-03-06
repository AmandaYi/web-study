let globleVariable = {
    publicPath: "http://localhost:3000/"
}
const path = require("path")
// 引入第三方的glob
const glob = require("glob-all")
// 引入插件
const UglifyJsPlugin = require('uglifyjs-webpack-plugin');
// 引入插件处理html
const HtmlWebpackPlugin = require("html-webpack-plugin")

// 引入分离插件处理CSS分离
const ExtractTextWebpackPlugin = require("extract-text-webpack-plugin")

// 引入去除没有使用的CSS代码
const PurifyCSSPlugin = require("purifycss-webpack");
const process = require("process")
// 传入的值
console.log(encodeURIComponent(process.env.NODE_ENV))
let mode = process.env.NODE_ENV ? process.env.NODE_ENV : "development"

// 引入webpack
const webpack = require("webpack")
// 引入自动加载模块,而不是到处import或者require
const ProvidePlugin = webpack.ProvidePlugin;
 
module.exports = {
    optimization: {
        splitChunks: {
          chunks: 'async',
          minSize: 30000,
          maxSize: 0,
          minChunks: 1,
          maxAsyncRequests: 5,
          maxInitialRequests: 3,
          automaticNameDelimiter: '~',
          name: true,
          cacheGroups: {
            vendors: {
              test: /[\\/]node_modules[\\/]/,
              priority: -10
            },
            default: {
              minChunks: 2,
              priority: -20,
              reuseExistingChunk: true
            }
          }
        }
      },
     
    // 这里使用了ES6语法,这里是环境构建模式
    mode,
    // 打开监听模式。这意味着在初始构建之后，webpack将继续监视任何已解析文件的更改。
    watch: true,
    // 配置监听选项
    watchOptions: {
        // 第一个文件更改后，在重建之前添加延迟。
        // 这允许webpack将在此时间段内所做的任何其他更改聚合到一个重建中。传递一个以毫秒为单位的值：
        aggregateTimeout: 300,
        //检测修改的时间，以毫秒为单位
        poll: 1000,
        // 排除不监听的文件夹,也可以这样子 ignored: ['files/**/*.js', 'node_modules']
        ignored: /node_modules/
    },

    // 入口
    entry: {
        /* ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓  ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ */
        // 这里新增加了一个入口,并修改了入口的名字也就是index,和 index2
        index: "./src/index.js",
        /* ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ */
        // 引入入口文件,这里直接写文件名,nodejs会自动去找node_modules文件夹下面的包,nodejs基础知识
        jquery: "jquery",
        layui: "layui"
    },
    // 出口
    output: {
        path: path.resolve(__dirname, "./dist/"),
        filename: "[name].js",
        publicPath: globleVariable.publicPath
    },

    // 模块,例如,解读CSS,图片如何转换,压缩
    module: {
        rules: [
            {
                test: /\.css$/,
                // use: [
                //     {
                //         loader: "style-loader"
                //     },
                //     {
                //         loader: "css-loader",
                //         options: {
                //             importLoaders: 1
                //         }
                //     },
                //     {
                //         // 增加一个处理css的postcss-loader
                //         loader: "postcss-loader",
                //     }
                // ]
                use: ExtractTextWebpackPlugin.extract({
                    use: [{
                        loader: "css-loader",
                        options: {
                            importLoaders: 1
                        }
                    }, {
                        loader: "postcss-loader"
                    }],
                    fallback: "style-loader",
                })
            },
            {
                test: /\.js$/,
                exclude: /(node_modules|bower_components)/,
                use: [{
                    loader: "babel-loader",
                    options: {
                        presets: ["@babel/preset-env"],
                        // 增加对react的支持
                        plugins: [require("@babel/plugin-proposal-object-rest-spread")]
                    }
                }]
            },
            {
                test: /\.(png|jpg|jpg|gif)$/,
                use: [
                    {
                        loader: "url-loader",
                        options: {
                            // limit Byte limit to inline files as Data URL
                            // 1.文件大小小于limit参数，url-loader将会把文件转为DataURL（Base64格式）；
                            // 2.文件大小大于limit，url-loader会调用file-loader进行处理，参数也会直接传给file-loader。
                            limit: 1024 * 30, //是把小于500000B的文件打成Base64的格式，写入JS。
                            mimetype: "extname", // 指定文件的MIME类型（否则从文件扩展名推断）
                            fallback: "file-loader", //loader当文件大于限制时（以字节为单位） 指定使用file-loader进行处理,
                            // 这里配置一下输出的路径就可以了
                            outputPath: "images/"

                        }
                    }
                ]
            },
            {
                test: /\.scss$/,
                // sass分类操作
                use: ExtractTextWebpackPlugin.extract({
                    use: [
                        { loader: "css-loader" },
                        { loader: "sass-loader" },

                    ],
                    // 在开发环境使用 style-loader
                    fallback: "style-loader"
                })
                // use: [
                //     {
                //         loader: "style-loader", //将 JS 字符串生成为 style 节点
                //     },
                //     {
                //         loader: "css-loader", //将 CSS 转化成 CommonJS 模块
                //     },
                //     {
                //         loader: "sass-loader",//将 Sass 编译成 CSS
                //         options: {
                //             // 这里是一些配置项
                //         }
                //     }
                // ]
            },
            {
                test: /\.less$/,
                use: ExtractTextWebpackPlugin.extract({
                    use: [
                        { loader: "css-loader" },
                        { loader: "less-loader" }
                    ],
                    fallback: {
                        loader: "style-loader",
                        options: {
                            // 这里是一些配置项
                        }
                    }
                })

                // use: [
                //     {
                //         loader: "style-loader",//将 JS 字符串生成为 style 节点, 
                //     },
                //     {
                //         loader: "css-loader",//将 CSS 转化成 CommonJS 模块
                //     },
                //     {
                //         loader: "less-loader",//将 Less 编译成 CSS
                //         options: {
                //             // 这里是一些配置项
                //         }
                //     }
                // ]
            },

        ]
    },
    // 插件,用于生产模板,和各项功能
    plugins: [
        // 引入自动加载模块的插件
        new ProvidePlugin({
            $: 'jquery',
            jQuery: 'jquery'
        }),
        new CommonsChunkPlugin({
            // 入口的key值
            name: ["jquery", "layui"],
            //最小打包的文件模块数，这里直接写2就好
            minChunks: 2,
            //把文件打包到哪里，是一个路径
            filename: "assets/js/[name].js",
        }),
        // 初始化JS处理插件
        new UglifyJsPlugin(),
        //配置html处理的插件,其中一个html需要配置一个处理html的插件
        new HtmlWebpackPlugin({
            // 生成html文件的标题,调用的话, 
            //  <title><%= htmlWebpackPlugin.options.title %></title> // 注意这个首字母一定是小写开头的
            title: "webpack4,优秀!",
            // 进行压缩,
            /**
             * 
             * 使用minify会对生成的html文件进行压缩。
             * 默认是false。html-webpack-plugin内部集成了 html-minifier,因此，
             * 还可以对minify进行配置：
             * （注意，虽然minify支持BooleanObject,但是不能直接这样写：minify: true ,
             *  这样会报错 ERROR in TypeError: Cannot use 'in' operator to search for 'html5' in true , 
             * 使用时候必须给定一个 { } 对象 ）
             * 
             *  */
            minify: {
                // 压缩的选项,负责处理属性的双引号自动替换为单引号
                removeAttributeQuotes: true,
            },
            // 防止开发中的缓存因素,
            hash: true,
            // 指定你生成的文件所依赖哪一个html文件模板，模板类型可以是html、jade、ejs等。但是要注意的是，如果想使用自定义的模板文件的时候，你需要安装对应的loader,
            /* 举例
            npm install jade-loader --save-dev
            loaders: {
                    ...
                    {
                        test: /\.jade$/,
                        loader: 'jade'
                    }
                }
            plugins: [
                new HtmlWebpackPlugin({
                    ...
                    jade: 'path/to/yourfile.jade'
                })
            ]
            */
            template: "./src/index.html",
            /** 
             * inject有四个值： true body head false
             * true 默认值，script标签位于html文件的 body 底部
             * body script标签位于html文件的 body 底部
             * head script标签位于html文件的 head中
             * false 不插入生成的js文件，这个几乎不会用到的
             * */
            inject: true,
            /**
             * 
             * 给你生成的html文件生成一个 favicon ,值是一个路径,
             * 然后再生成的html中就有了一个 link 标签
             * <link rel="shortcut icon" href="example.ico">
             */
            // favicon:"xxx",
            /**
             * 当webpack报错的时候，会把错误信息包裹再一个pre中，默认是true。
             * 
             */
            showErrors: true,
            /**
             * chunks主要用于多入口文件，当你有多个入口文件，那就回编译后生成多个打包后的文件，
             * 那么chunks 就能选择你要使用那些js文件
             * 
             
             entry: {
                    index: path.resolve(__dirname, './src/index.js'),
                    devor: path.resolve(__dirname, './src/devor.js'),
                    main: path.resolve(__dirname, './src/main.js')
                }

                plugins: [
                    new httpWebpackPlugin({
                        chunks: ['index','main']
                    })
                ]

                编译之后就会生成如下
                <script type=text/javascript src="index.js"></script>
                <script type=text/javascript src="main.js"></script>
                如果你没有设置chunks选项，那么默认是全部显示
             */

            // 排除掉一些js
            // excludeChunks
            // 一个布尔值，默认值是 false ，如果为 true ,则以兼容 xhtml 的模式引用文件。
            xhtml: false,
            /**
             *  script的顺序，默认四个选项： none auto dependency {function}
             * 'dependency' 不用说，按照不同文件的依赖关系来排序。
             * 'auto' 默认值，插件的内置的排序方式，具体顺序....
             * 'none' 无序？
             * {function} 提供一个函数？
             * 
             * 
             * 
             * 
             * 
             */
            chunksSortMode: "auto"
        }),
        // 处理css分离出来
        // 这里的/css/index.css是分离后的路径位置。这部配置完成后，包装代码：还要修改原来我们的style-loader和css-loader。
        new ExtractTextWebpackPlugin("./css/index.css"),
        // 这个插件自动去除无用的css样式, 必须要在css样式插件extract-text-webpack-plugin分离的后面使用,
        // 否则的话,会自动删除很多有用的css
        new PurifyCSSPlugin({
            // 配置了一个paths，主要是需找html模板，purifycss根据这个配置会遍历你的文件，查找哪些css被使用了。
            // 因为这里使用的第三方的glob,所以参数是个数组
            paths: glob.sync([
                path.join(__dirname, "./src/*.html")
            ]),
        }),

    ],

    // 配置webpack开发服务功能
    devServer: {
        // 在这里增加了开发服务的功能
        // 设置需要监听的目录
        contentBase: path.resolve(__dirname, 'src'),
        //  
        host: "localhost",
        // 设置服务器的端口
        port: 3000,
        // 服务器是否启用压缩功能,一般启用
        compress: true,

        // 实时刷新
        inline: true,
        // 新文件的内存路径与配置文件中的publicPath相关，如http://localhost:8080/{publicPath}/bundle.js
        // 这里尽量不要配置,容易找不到路径,使用根目录既可
        // publicPath: "/src/"
    }
}

