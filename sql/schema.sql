
/*Таблица - user. Список пользователей
UID - id пользователя
LOGIN - логин пользователя
PASSWORD - паоль пользователя
*/
CREATE TABLE IF NOT EXISTS user (
    UID SERIAL PRIMARY KEY,
    LOGIN        CHAR(20),
    PASSWORD        VARCHAR(100)
);

/*Таблица - person. Список субъектов
UID - id субъекта
NAME - имя субъекта
FULLNAME - полное имя субъекта
POST_ID - должность. Ссылка на таблицу post(таблица должностей).
*/
CREATE TABLE IF NOT EXISTS person (
    UID SERIAL PRIMARY KEY,
    NAME        CHAR(50),
    FULLNAME        VARCHAR(150),
    POST_ID  INTEGER REFERENCES post (UID)
);

/*Таблица - company. Список компаний
UID - id компании
NAME - наименование компании
FULLNAME - полное наименование компании
EDRPOU - ЕДРПОУ компании
INN - ИНН компании
ADDRESS - адресс компании
PERSON_ID - директор. Ссылка на таблицу person(таблица субъектов)
*/
CREATE TABLE IF NOT EXISTS company  (
 UID SERIAL PRIMARY KEY,
 NAME        CHAR(50),
 FULLNAME    VARCHAR(150),
 EDRPOU CHAR(50),
 INN CHAR(50),
 ADDRESS VARCHAR (250),
 PERSON_ID INTEGER REFERENCES person (UID)
 );

/*Таблица - unit. Список едениц измерений.
UID - id единицы измерения
NAME - наименование единицы измерения
*/
CREATE TABLE IF NOT EXISTS unit  (
 UID SERIAL PRIMARY KEY,
 NAME        CHAR(30),
 FULLNAME    CHAR(50)
);

/*Таблица - post. Список должностей
UID - id должности
NAME - наименование должности
*/
CREATE TABLE IF NOT EXISTS  post (
   UID INT PRIMARY KEY NOT NULL,
   NAME        CHAR(50)
);

/*Таблица - account. Список расчетных счетов
UID - id р/с
NUMBER - номер счета
NAMEBANK - наименование банка
MFO - МФО банка
ADDRESS - адресс компании
ISMAIN - основной ли счет
COMPANY_ID - компания. Ссылка на таблицу company(Список компаний)
*/
CREATE TABLE IF NOT EXISTS account (
  UID SERIAL PRIMARY KEY,
  NUMBER CHAR(14),
  NAMEBANK VARCHAR(100),
  MFO INTEGER,
  ADRESS VARCHAR(250),
  ISMAIN BOOLEAN,
  PARENTUID  INTEGER REFERENCES company (UID)
);

/*Таблица - invoice. Список выписанных счетов
UID - id счета
DATEDOC - дата счета
OURCOMPANY_ID - наша компания. Ссылка на таблицу company(Список компаний)
OURCOMPANY_ID - компания клиент. Ссылка на таблицу company(Список компаний)
DESCRIPTION - описание счета
*/
CREATE TABLE IF NOT EXISTS invoice (
  UID SERIAL PRIMARY KEY,
  NUMBER CHAR(10),
  DATEDOC DATE,
  OURCOMPANY_ID  INTEGER REFERENCES company (UID),
  CLIENT_ID  INTEGER REFERENCES company (UID),
  DESCRIPTION VARCHAR (350)
);

/*Таблица - invoice_dt. Детализация выписанного счета
UID - id записи
INVOICE_ID - id счета
DESCRIPTION - описание записи.
UNIT_ID - единица измерения. Ссылка на таблицу unit(Список ед.измерений)
AMOUNT - количество единиц
PRICE - цена единицы
SUM - сумма записи
*/
CREATE TABLE IF NOT EXISTS invoicedt (
  UID SERIAL PRIMARY KEY,
  PARENTUID  INTEGER REFERENCES invoice (UID),
  DESCRIPTION VARCHAR (350),
  UNIT_ID INTEGER REFERENCES unit (UID),
  AMOUNT NUMERIC(4,2),
  PRICE NUMERIC(10,2),
  SUM NUMERIC  (10,2)
 );

