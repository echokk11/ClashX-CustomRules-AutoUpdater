# ClashX-CustomRules-AutoUpdater

鉴于Mac版本ClashX每一次自动更新都会覆盖掉原来的配置文件，所以写了一个简单的程序来扫描文件的改动，并且把自定义规则写入到正在用的文件当中去。

## 说明
编写自己的规则到`myRules.yaml`,文件存储在用户目录下如`~/.config/clash/myRules.yaml`    
内容如下(这是例子):
```yaml
rules:
    - 'DOMAIN-SUFFIX,rubygem.org,BosLife'
    - 'DOMAIN-SUFFIX,github.com,BosLife'
    - 'DOMAIN-SUFFIX,openai.com,BosLife'
    - 'DOMAIN-SUFFIX,pub.dev,BosLife'
    - 'DOMAIN-SUFFIX,npmjs.org,BosLife'
    - 'DOMAIN-SUFFIX,cloudfront.net,BosLife'
    - 'DOMAIN-SUFFIX,jsdelivr.net,BosLife'
    - 'DOMAIN-SUFFIX,apache.org,BosLife'
    - 'DOMAIN-SUFFIX,maven.org,BosLife'
    - 'DOMAIN-SUFFIX,sonatype.com,BosLife'
```

>文件名称可以在`application.yaml`中修改
```yaml
clashx:
  main: YourAutoUpdateFile.yaml
  custom: myRules.yaml
```

## 使用
修改`application.yaml`中main为自动更新的文件名称，新建文件`myRules.yaml`，编写自定义规则
```shell
mvn clean package
java -jar ClashX-CustomRules-AutoUpdater-0.0.1-SNAPSHOT.jar
```
如果你开启clashX的通知，监测到文件的变动一般会弹窗提示点击重载，如果没有，可以手动点击重载    
配置->重载配置文件    

可以做成mac的`自动操作`在电脑启动时候自动启动
