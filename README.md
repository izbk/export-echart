## 1.安装配置phantomjs
### 1.1下载
https://phantomjs.org/download.html
### 1.2 Linux环境安装
```shell script
tar -jxvf phantomjs-2.1.1-linux-x86_64.tar.bz2
mv phantomjs-2.1.1-linux-x86_64 /usr/local/src/phantomjs
ln -sf /usr/local/src/phantomjs/bin/phantomjs /usr/local/bin/phantomjs
phantomjs -v
```
### 1.3 配置项目yml
```text
chart:
  phantomjs:
    path: ${WORK_PATH:D:\temp}
```
### 1.4 配置必须的运行环境
将echarts-convert.js、echarts.js、jquery.js复制到WORK_PATH目录中


