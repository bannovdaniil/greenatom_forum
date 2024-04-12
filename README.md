## GreenAtom test forum

- Язык – Java + Spring Boot
- Хранилище – in-memory DB + скрипт по наполнению тестовыми данными.
- Автоматизация сборки – Gradle
- немного junit5 тестов + Mockito

#### Авторизация
- user:user
- admin:admin

#### Как использовать
Открыть код в IDE нажать кнопку выполнить. В браузере обратиться к API согласно документации.
Для авторизации воспользоваться одним из приведенных выше аккаунтов.


##### Получить список всех топиков
```
GET http://localhost:8080/api/v1/topic
GET http://localhost:8080/api/v1/topic?page={{$random.integer(100)}}&size={{$random.integer(100)}}
```

##### Создать топик
```
POST http://localhost:8080/api/v1/topic
{
  "topicName": "Тестовая тема",
  "message": {
    "text": "Первое сообщение",
    "author": "Ivan",
  }
}
```

##### Изменить топик
```
PUT http://localhost:8080/api/v1/topic
{
  "id": "{{postid}}",
  "name": "Edit Тестовая тема",
  "created": "2024-12-03T15:23:17+03:00"
}
```

##### Получить все сообщения топика
```
GET http://localhost:8080/api/v1/topic/{{postid}}
```

##### Создать сообщение в топике
```
POST http://localhost:8080/api/v1/topic/{{postid}}/message
        {
            "uuid": "6ae85279-4f54-4e39-8fef-4c1f8b822b7b",
            "text": "New Первое сообщение",
            "author": "Ivan 2",
            "created": "2024-04-12T10:56:52.2671067"
        }
```

##### Изменить сообщение в топике
```
PUT http://localhost:8080/api/v1/topic/{{postid}}/message
        {
            "uuid": "{{messageId}}",
            "text": "Edit Last сообщение",
            "author": "Ivan 2",
            "created": "2024-04-12T10:56:52.2671067"
        }
```


##### Удалить сообщение
```
DELETE http://localhost:8080/api/v1/message/{{messageId}}
```

**Задание:**

1. Есть топики (темы), в каждом топике может быть одно или более сообщений.
2. Движок должен обеспечивать хранение в БД (IMDB) и CRUD операции с топиками (темами) и сообщениями в топиках.
3. Топик должен содержать заголовок (название темы). Топик не может быть пустым, т.е. должен содержать как минимум одно сообщение.
4. Сообщение должно содержать имя (ник) автора, текст сообщения, дату создания.
5. Сообщение обязательно должно относиться к одному из топиков.
6. Необходимо реализовать клиентский REST-API позволяющий пользователю:
- получать список топиков
- получать сообщения в указанном топике
- создать топик (с первым сообщением в нем)
- создать сообщение в указанном топике
- отредактировать свое сообщение
- удалить свое сообщение

Задания на дополнительный бал
+1. Реализовать пагинацию для топиков и сообщений
+2. Реализовать аутентификацию пользователей (т.е. для доступа к сервису необходимо сперва залогиниться)