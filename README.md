# gulimall

## 解决导入新的 SpringBoot 项目 idea 不显示的问题
https://www.cnblogs.com/sxdcgaq8080/p/9790236.html

##renren-fast-vue 启动流程
1. 安装nodejs
2. 切换淘宝镜像
    npm install -g cnpm --registry=https://registry.npm.taobao.org
3. 安装依赖
    cnpm install 
4. 启动
    cnpm run dev
   
遇到需要安装 python 环境，可使用 cnpm
遇到 Node Sass does not yet support your current environment: Windows 64-bit with Unsupported runtime
node sass不支持当前环境，所以可以直接删掉原来不支持本机的node sass，再重新安装支持的就行了
删除：
cnpm uninstall --save node-sass   /   npm uninstall --save node-sass
安装：
cnpm install --save node-sass    /    npm install --save node-sass

## 