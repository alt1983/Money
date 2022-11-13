#Приложение для перевода денег

##Запуск
Приложение запускается на порту 5500

##Запрос на перевод

###Пример запроса на перевод

POST http://localhost:5500/transfer
Content-Type: application/json

{
"cardFromNumber":"1111111111111111",
"cardFromValidTill":"12/23",
"cardFromCVV":"111",
"cardToNumber":"2222222222222222",
"amount":{
"value":100,
"currency":"RUR"
}
}

##Запрос на подтверждение

###Пример запроса на подтверждение перевода

POST http://localhost:5500/transfer
Content-Type: application/json

{
"operationId" : "1",
"code" : "0000"
}

##Тестирование
* Реализован набор тестов с использованием Mockito и JUnit
* Реализован набор тестов с использованием Testcontainers
* Для добства тестирования создан Docker-image money




