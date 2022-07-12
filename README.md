# Link Conversion
Сервис для генерации короткой ссылки

Порт и длина генерируемой ссылки конфигурируются в следующем файле:

```shell script
src/main/resources/application.yaml
```

Запуск проекта осуществляется с помощью *“Run” в IDE*

Конвертация ссылки осуществляется с помощью *POST* запроса по адресу:

```shell script
http://localhost:8080//api/convert
```

В теле запроса нужно передать JSON, пример:

```shell script
{
    "link":"https://can.ua/akkumulyatornaya-batareya-great-power-pg-12-7-2/p37854/"
    }
```

В ответе придет сгенерированная короткая ссылка

*REST API* защищенное *Basic* авторизаций

Credentials:

```shell script
Login: user
Password: user
```

При переходе по короткой ссылке будет перенаправление на оригинальную ссылку