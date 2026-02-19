# 📝 Online Assessment Portal

> A full-stack online assessment platform with OTP-based student registration, quiz management, and real-time evaluation — built with Spring Boot, Angular, and MongoDB.

![Java](https://img.shields.io/badge/Backend-Spring%20Boot-green) ![Angular](https://img.shields.io/badge/Frontend-Angular-red) ![MongoDB](https://img.shields.io/badge/Database-MongoDB-brightgreen)

---

## 📌 Overview

The Online Assessment Portal enables educational institutions to manage students, create quizzes, and conduct assessments end-to-end. Students register for quizzes via OTP email verification, ensuring authenticated participation before any assessment begins.

---

## ✨ Features

- **OTP Registration** — Students receive a one-time password via email to register for quizzes, preventing unauthorized access
- **Student Management** — Full CRUD: create, view, update, delete student records
- **Quiz Management** — Create and manage quizzes with configurable questions and time limits
- **Email Notification Service** — Automated OTP delivery using JavaMail / Spring Mail
- **Role-based Views** — Separate interfaces for admins and students
- **RESTful API** — Clean Spring Boot backend with repository pattern
- **Responsive UI** — Angular frontend with component-driven architecture

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Frontend | Angular, TypeScript, Angular Material |
| Backend | Java, Spring Boot, Spring Data MongoDB |
| Database | MongoDB |
| Auth / OTP | Spring Mail, JavaMailSender |
| Build | Maven |

---

## 🗂️ Project Structure

```
online-assessment-portal/          # Spring Boot backend
├── src/main/java/
│   ├── controller/                # REST controllers
│   │   ├── StudentController.java
│   │   ├── QuizController.java
│   │   └── OTPController.java
│   ├── model/                     # MongoDB document models
│   │   ├── Student.java
│   │   ├── Quiz.java
│   │   └── OTPVerification.java
│   ├── repository/                # Spring Data MongoDB repos
│   ├── service/                   # Business logic + email service
│   └── PortalApplication.java
└── src/main/resources/
    └── application.properties

online-assessment-portal-ui/       # Angular frontend
├── src/app/
│   ├── components/
│   │   ├── student/
│   │   ├── quiz/
│   │   └── otp-verification/
│   ├── services/                  # HTTP service layer
│   └── app-routing.module.ts
└── angular.json
```

---

## 🚀 Getting Started

### Prerequisites
- Java 17+, Maven
- Node.js 18+, Angular CLI
- MongoDB (local or Atlas)

### Backend Setup

```bash
git clone https://github.com/DivitaP/online-assessment-portal.git
cd online-assessment-portal
```

Configure `src/main/resources/application.properties`:
```properties
spring.data.mongodb.uri=mongodb://localhost:27017/assessment_portal
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your_email@gmail.com
spring.mail.password=your_app_password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

Run the backend:
```bash
mvn spring-boot:run
```
API runs at `http://localhost:8080`

### Frontend Setup

```bash
git clone https://github.com/DivitaP/online-assessment-portal-ui.git
cd online-assessment-portal-ui
npm install
ng serve
```
App runs at `http://localhost:4200`

---

## 📡 API Endpoints

### Students
| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/students` | Get all students |
| POST | `/api/students` | Create student |
| PUT | `/api/students/{id}` | Update student |
| DELETE | `/api/students/{id}` | Delete student |

### Quizzes
| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/quizzes` | Get all quizzes |
| POST | `/api/quizzes` | Create quiz |
| PUT | `/api/quizzes/{id}` | Update quiz |
| DELETE | `/api/quizzes/{id}` | Delete quiz |

### OTP
| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/otp/send` | Send OTP to student email |
| POST | `/api/otp/verify` | Verify OTP and register student for quiz |

---

## 🔑 OTP Flow

```
Student enters email
        │
        ▼
POST /api/otp/send
  → generates 6-digit OTP
  → stores OTP with expiry in MongoDB
  → sends email via JavaMailSender
        │
        ▼
Student enters OTP in UI
        │
        ▼
POST /api/otp/verify
  → validates OTP + expiry
  → registers student for quiz
  → returns success token
```

---

## 📄 License

MIT License
