REST API для управления банковскими картами, транзакциями и пользователями. Приложение реализовано с использованием
Java 17, Spring Boot+Security, PostgreSQL, Liquibase и Docker. Поддерживает роли `ADMIN` и `USER`,
JWT-аутентификацию, маскирование номеров карт и документирование API через Swagger UI.

Для удобства проверки:
- логи в консоли реализованы на русском языке;
- переменные среды НЕ использованы;
- URL БД: jdbc:postgresql://localhost:5433/bankdb. Пользователь: postgres, пароль: 123.

## Требования
- Java SE 17+
- Maven 3.8+
- Docker и Docker Compose
- IntelliJ IDEA (для запуска через IDE)

## Запуск через Maven (архив из репозитория)

**Подготовка окружения**
   - Убедитесь, что Java SE 17+ (https://www.oracle.com/java/technologies/downloads/archive/) и Maven 3.8+ (https://maven.apache.org/download.cgi) установлены:
   ```bash
   java -version
   ```
   затем:
   ```bash
   mvn -version
   ```
   - Установите Docker Desktop (Windows/Mac) или Docker (Linux): https://www.docker.com/get-started.
   - Запустите Docker и проверьте, что он виден в системе: 
   ```bash
   docker --version
   ```

1. **Копирование репозитория**
- Скачайте архив проекта https://github.com/herbal-egress/bank_rest-main_4.7/archive/refs/heads/master.zip и распакуйте вложенную папку на диск C:\
- Перейдите в папку проекта:
   ```bash
   cd c:\bank_rest-main_4.7-master
   ```


2. **Настройка PostgreSQL через Docker**
   - Убедитесь, что файл `docker-compose.yml` находится в корне проекта c:\bank_rest-main_4.7-master.
   - Выполните команду для запуска PostgreSQL через Docker:
   ```bash
   docker-compose up -d
   ```
   - Проверьте, что контейнер `bank_postgres` работает: 
   ```bash
   docker ps
   ```
     
3. **Генерация кода через OpenAPI Generator**
   - Выполните команду в корне проекта:
   ```bash
   mvn clean generate-sources
   ```

 
4. **Сборка и запуск приложения**
   - Убедитесь, что кодировка консоли поддерживает UTF-8:
   ```bash
   chcp 65001
   ```
   - Скомпилируйте проект с инициализацией тестирования, встроенного в проект: 
   ```bash
   mvn test
   ```
   - Убедитесь, что все 45 тестов прошли успешно и запустите приложение:
   ```bash
   mvn spring-boot:run
   ```
   - Откройте Swagger UI по адресу: http://localhost:8080/swagger-ui.html.


5. **Проверка работы программы в SwaggerUI**
   - Начните работу с раздела "Аутентификация": нажмите кнопку Try it out
   - Заполните предложенный пример JSON, использовав указанный в скобках логин/пароль admin или user. От выбора будет
   зависеть роль.
   - Нажмите Execute и скопируйте содержимое поля token из JSON, сформированного ниже в окне Response body.
   - Нажмите на иконку 🔓 в любом разделе UI, либо на Authorize в заголовке страницы. В открывшемся окне вставьте токен
   в поле Value и нажмите Authorize.
   - Всё готово. Проверяйте функционал любого эндпоинта. Комментарии к разделам и образцы JSON вам помогут сориентироваться.
   - Остановите приложение, нажав `Ctrl + C` в терминале.
   - Остановите Docker-контейнер:
  ```bash
  docker-compose down
  ```