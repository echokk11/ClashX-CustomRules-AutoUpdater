# ClashX-CustomRules-AutoUpdater

鉴于Mac版本ClashX/ClashX Pro每一次自动更新配置文件都会覆盖掉原来的配置文件，所以写了一个简单的程序来扫描文件的改动，并且把自定义规则写入到更新下来的配置文件当中去。

## 说明
编写自己的规则到`myRules.yaml`,文件存储在用户目录下如`~/.config/clash/myRules.yaml`    
内容如下(这是例子):
```yaml
rules:
    - 'DOMAIN-SUFFIX,rubygems.org,PROXY'
    - 'DOMAIN-SUFFIX,github.com,PROXY'
    - 'DOMAIN-SUFFIX,openai.com,PROXY'
    - 'DOMAIN-SUFFIX,auth0.com,PROXY'
    - 'DOMAIN-SUFFIX,pub.dev,PROXY'
    - 'DOMAIN-SUFFIX,npmjs.org,PROXY'
    - 'DOMAIN-SUFFIX,cloudfront.net,PROXY'
    - 'DOMAIN-SUFFIX,jsdelivr.net,PROXY'
    - 'DOMAIN-SUFFIX,apache.org,PROXY'
    - 'DOMAIN-SUFFIX,maven.org,PROXY'
    - 'DOMAIN-SUFFIX,sonatype.com,PROXY'
    - 'DOMAIN-SUFFIX,brew.sh,PROXY'
    - 'DOMAIN-SUFFIX,ghcr.io,PROXY'
    - 'DOMAIN-SUFFIX,hellogithub.com,PROXY'
    - 'DOMAIN-SUFFIX,ruanyifeng.com,PROXY'
    - 'DOMAIN-SUFFIX,jetbrains.com,PROXY'
    - 'DOMAIN-SUFFIX,vultr.com,PROXY'
    - 'DOMAIN-SUFFIX,itellyou.cn,PROXY'
    - 'DOMAIN-SUFFIX,proton.me,PROXY'
    - 'DOMAIN-SUFFIX,amazonaws.com,PROXY'
    - 'DOMAIN-SUFFIX,amazon.com,PROXY'
    - 'DOMAIN-SUFFIX,live.com,PROXY'
    - 'DOMAIN-SUFFIX,bing.com,PROXY'
    - 'DOMAIN-SUFFIX,sentry.io,PROXY'
    - 'DOMAIN-SUFFIX,deepl.com,PROXY'
```

>文件名称可以在`application.yaml`中修改
```yaml
clashx:
  main: YourAutoUpdateFile.yaml
  custom: myRules.yaml
```

## 使用
修改`application.yaml`中main的value为自动更新(订阅)的文件名称，新建文件`myRules.yaml`，编写自定义规则
```shell
mvn clean package
java -jar ClashX-CustomRules-AutoUpdater-0.0.1-SNAPSHOT.jar
# or
nohup java -jar ClashX-CustomRules-AutoUpdater-0.0.1-SNAPSHOT.jar > /dev/null 2>&1 &
```
如果你开启clashX的通知，监测到文件的变动一般会弹窗提示点击重载，如果没有，可以手动点击重载    
配置->重载配置文件(CMD+R)    

可以做成mac的`自动操作`在电脑启动时候自动启动    
新建->应用程序->运行shell脚本    
```shell
nohup java -jar ClashX-CustomRules-AutoUpdater-0.0.1-SNAPSHOT.jar > /dev/null 2>&1 &
```
然后加入到mac系统    
设置->通用->登录项->添加到登录时打开
