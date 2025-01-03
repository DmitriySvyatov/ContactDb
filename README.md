# Contact Management System

## Описание

Этот проект представляет собой систему управления контактами, реализованную с использованием Spring Framework. Система позволяет выполнять основные операции CRUD (создание, чтение, обновление и удаление) для сущности "Контакт". Данные хранятся в базе данных PostgreSQL.

## Структура проекта

- **Контроллеры**: ContactController — управляет запросами и взаимодействует с сервисом для обработки данных контактов.
- **Сервисы**: ContactService — содержит бизнес-логику для работы с контактами.
- **DAO**: Contact — модель данных для представления контактов.

## Зависимости

- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL Driver
- Lombok
- Thymeleaf (для шаблонов)

## Использование

### Основные функции

- **Получить список всех контактов**:
    - Открывает главную страницу, отображающую все контакты: GET /

- **Создать новый контакт**:
    - Показать форму для создания нового контакта: GET /contact/create
    - Отправить форму для сохранения контакта: POST /contact/create

- **Редактировать существующий контакт**:
    - Показать форму для редактирования контакта: GET /contact/edit/{id}
    - Отправить форму для обновления контакта: POST /contact/edit

- **Удалить контакт**:
    - Удалить контакт по ID: GET /contact/delete/{id}

### Логирование

Для отслеживания действий в приложении используется стандартное логирование Spring. Логи будут выводиться в консоль или файл, в зависимости от конфигурации вашего приложения.

