This is a test project for Hacken company.

Docker software is required to start this application.
(It could be installed via the following link https://docs.docker.com/engine/install/).

To start a project **docker-compose.yml** file from this repository must be saved to the local machine.
After that, the following command should be typed in terminal:

        docker-compose up

Docker will download images from Docker Hub and then launch two containers, so it will take some time.

---
API documentation is available in two formats: OpenAPI and Swagger (preferred).
Swagger documentation is located at:

    http://localhost:8080/v1/swagger-ui/index.html

OpenAPI documentation URL:

    http://localhost:8080/v1/v3/api-docs

---
Data in the uploading file (with csv extension) must have the following structure:

    first name,last name,email,country,about user
    actualName,actualSurname,email@gmail.com,Ukraine,Some info about user

File with test data is located in this repository as well
and is named **test_user_data.csv**
---
The whole stored data could be checked via the following URL:

    http://localhost:9200/user/_search?pretty

---
Application supports both search by field and value and full-text search.
The first search type checks value presence only the provided field, whereas 
the second one searches within all fields.

In addition, basic health checks are available on the url:

    http://localhost:8080/v1/actuator/health