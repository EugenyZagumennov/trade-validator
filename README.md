#Trade Validator
---
##Run service
```
java -jar trade-validator.jar
```
---
##1. Validation API
```
Make a curl request, for example:
curl -X POST -d "{\"test\": [{\"customer\":\"PLUTO1\",\"ccyPair\":\"EURUSD\",\"type\":\"Spot\",\"direction\":\"SELL\",\"tradeDate\":\"2016-08-11\",\"amount1\":1000000.00,\"amount2\":1120000.00,\"rate\":1.12,\"valueDate\":\"2016-08-22\",\"legalEntity\":\"CS Zurich\",\"trader\":\"JohannBaumfiddler\"}]}" -H "Content-Type:application/json" http://localhost:8080/api/validator

Will get response:
{"content":[{"id":0,"success":true,"messages":null}]}
```

##2.Graceful shutdown
```
Make a curl request:
curl -X POST localhost:8080/actuator/shutdown

Application will be closed gracefully, and return the response:
{"message":"Shutting down, bye..."}
 ```
        
##3.MVC Viewer
```
Also you can open the web interface, load json file and see the response
http://localhost:8080/view
```