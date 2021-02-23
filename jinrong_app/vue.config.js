var webpack=require('webpack');
module.exports={
    //github pull文件测试
    //github pull文件测试222 王*提交 2021.2.23 17:20PM 第N次提交
    //github pull文件测试333  王*提交 2021.2.23 17:31PM 第N+1次提交
    devServer:{
      // host:"192.168.3.135",
        //port:80,
        /*axios 代理链接全局配置*/
        proxy:{
        '/api':{
            target:'http://192.168.3.135:8088/jinrong_api/',//后端地址
            secure:false,// 如果是https接口，需要配置这个参数
            ws:true,//是否代理websockets
            changeOrigin:true,/*前端工程化 axios跨域 配置*/
            pathRewrite:{
                '^/api':''
            }
        }
        }
    },
    /*全局支持jquery 以$形式注入jquery*/
    configureWebpack:{
     plugins:[
         // eslint-disable-next-line no-undef
         new webpack.ProvidePlugin({
             $:"jquery",
             jQuery:"jquery",
             "windows.jQuery":"jquery"
         })
     ]

    },
    /*为了方便前端工程化 打包部署的配置*/
    publicPath:'./',



}
