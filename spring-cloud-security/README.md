# Spring and OAuth2



方法1：

第一步：
http://localhost:1111/oauth/authorize?client_id=client&response_type=code

登录用户名和密码， 并点击approve，返回code：
https://www.baidu.com/?code=nI3Lfg

第二步：
把code带入，返回授权信息

http://localhost:1111/oauth/token?client_id=client&client_secret=secret&grant_type=authorization_code&code=THA57y


{"access_token":"fd1085e3-cf6e-4b39-9b59-1f3935a68f84","token_type":"bearer","refresh_token":"976c4488-b1ce-44c0-89e3-fbd10559d016","expires_in":1199,"scope":"app"}