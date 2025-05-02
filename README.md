# 🗳️ Student Voting System

A web-based voting platform for students to participate in elections securely and fairly. Built with Jakarta EE, JSP, Servlets, MySQL, and runs on Apache Tomcat.

## 🚀 Features

- Student registration & login
- Vote once per student
- View real-time voting stats
- Candidate profiles
- Admin contact page
- Clean, navy-blue themed UI

## 🧰 Tech Stack

- **Frontend:** JSP, HTML, CSS
- **Backend:** Jakarta EE, Servlets, DAO pattern
- **Database:** MySQL (accessed via phpMyAdmin)
- **Server:** Apache Tomcat 10.1
- **ORM:** JPA (Object-Relational Mapping)
- **IDE:** NetBeans

## 📄 Pages

| Page           | Description                                 |
|----------------|---------------------------------------------|
| `index.jsp`     | Homepage overview of the system             |
| `register.jsp`  | Student registration form                   |
| `login.jsp`     | Student login form                          |
| `vote.jsp`      | Voting interface (requires login)           |
| `vote-stats.jsp`| Live voting results                         |
| `JasonDanta.jsp`| Candidate profile sample                    |
| `contact.jsp`   | Contact form or admin information           |

## 🗂️ Database Tables

- `voters` – Student accounts
- `candidates` – Election candidates
- `votes` – Tracks individual votes
- `elections` – Election details (type, dates, etc.)

## 🛠️ Setup Instructions

1. Clone this repository:

```bash
git clone https://github.com/yourusername/student-voting-system.git
