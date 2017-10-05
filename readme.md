### fCik_for_CBR [4.1 std]

Необходимо настроить файл с вашей конфигурацией: config.properties
````
QUERY=Запрос из БД, который должен вернуть следующие поля как VARCHAR:idClient,LastName,FirstName,MiddleName,BirthDay,TypyOfAccount,Account,Ostt,NameOfCred,KodOfCred,NekonfAdrOfCred,konfAdrOfCred
      Передающие параметры (VARCHAR):
            :p1 - код документа
            :p2 - серия
            :p3 - номер
            :p4 - дата запроса в формате dd.mm.yyyy
OGRN=Ваш ОГРН
INN=Ваш ИНН
ADRESS=Ваш адрес
NAME=Название вашей КО
PHONE=Телефон
FIO=Фамилия вашего проверяющего
EMAIL=email вашего проверяющего
Необязательно (доступно из интерфейса)
JDBCTHIN=jdbc:oracle:thin:логин/пароль@IP сервера:ПОРТ:SID
````
