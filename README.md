# Spring框架下的REST服務(無伺服器版)

* 使用SpringMVC整合aws-serverless-java-container嘗試做出API

## 開始



### Prerequisites

* 需可執行gradle的套件
* 安裝Docker
* 安裝aws sam cli (建議使用npm)

### 安裝

下載之後轉為gradle專案

## 佈署

* 以gradle套件執行build即可，會產生jar檔
* 使用sam cli進行佈署(本地端) 
```
sam local start-api -p 80
```


## 測試

以瀏覽器查詢http://localhost:3000/user

