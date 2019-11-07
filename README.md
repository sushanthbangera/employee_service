# glarimy-quiz

REST API for Glarimy Quiz

## Build Machine

```
git clone https://glarimy@bitbucket.org/glarimy/glarimy-quiz-employee-service.git
cd glarimy-quiz-employee-service
docker build -t glarimy/employee-service .
docker login
docker push glarimy/employee-service
```

## Release Machine

```
docker pull mongo
docker pull glarimy/employee-service
docker network create glarimy
docker run -d --network glarimy --name mongodb mongo
docker run -d --network glarimy -p 8080:8080 glarimy/employee-service
```

## Compose

```
version: "3"
services:
  employee-service:
    image: glarimy/employee-service:latest
    ports:
      - "8080:8080"
    networks:
      - glarimy
    depends_on:
      - mongodb

  question-service:
    image: glarimy/question-service:latest
    ports:
      - "8081:8081"
    networks:
      - glarimy
    depends_on:
      - mongodb

  mongodb:
    image: mongo:latest
    networks:
      - glarimy

networks:
  glarimy: 

```

Models

Employee
ID
Name
Password
Role
QuizList
	QuizID
	Score

Subject
ID
Name

Quiz
ID
Date
From
To
Questions
Employees
	EmployeeID
	Score

HR

Add Employee
POST /employee

Remove Employee
DELETE /employee/{eid}

List Employees
GET /employee

View Employee
GET /employee/{eid}

Update Employee
PUT /employee/{eid}

Add Subject
POST /subject

List Subjects
GET /subject

Schedule Quiz
POST /quiz

Remove Quiz
DELETE /quiz/{qid}

List Quizes
GET /quiz

View Quiz
GET /quiz/{qid}

View Quiz Results
GET /quiz/{qid}/results

View Employee Results
GET /employee/{eid}/results

SME

Add Question
POST /question

List Questions
GET /question

Update Question
PUT /question/{qnid}

View Question
GET /question/{qnid}


Employee

List Quizes
GET /quiz

Take Quiz
GET /quiz/{qid}

Submit Quiz
POST /quiz/{qid}/answers

View Quiz Results
GET /quiz/{qid}/results

View All Results
GET /quiz/results

