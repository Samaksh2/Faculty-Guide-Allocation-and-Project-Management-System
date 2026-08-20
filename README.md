# Faculty Guide Allocation and Project Management System

A lightweight Java + JDBC + PostgreSQL web application. It provides role-based student, faculty, and coordinator dashboards, guide-request approval, capacity enforcement, automatic project creation, milestones, announcements, and reports.

## First-time setup on Windows

1. Install PostgreSQL using the official Windows installer: https://www.postgresql.org/download/windows/. It includes pgAdmin. During installation, retain port `5432`, choose a password for the `postgres` superuser, and remember it.
2. Open pgAdmin. In the left tree, right-click **Databases** > **Create** > **Database**. Enter `faculty_guide_db` as the database name and click **Save**.
3. Right-click `faculty_guide_db` > **Query Tool**, open `database/schema.sql`, then execute it. The schema creates all tables, constraints, trigger functions, procedure, views, and demo accounts.
4. Download the PostgreSQL JDBC driver from https://jdbc.postgresql.org/download/, place its `.jar` file in this project folder, and rename it to `postgresql.jar`.

## Run

In PowerShell, open this project folder and set the password you created during PostgreSQL installation:

```powershell
$env:DB_USER="postgres"
$env:DB_PASSWORD="your_postgres_password"
$env:DB_URL="jdbc:postgresql://localhost:5432/faculty_guide_db"
```

Compile and start the application:

```powershell
New-Item -ItemType Directory -Force out
javac -d out src\main\java\com\college\guide\*.java
java -cp "out;postgresql.jar" com.college.guide.App
```

Open http://localhost:8080. Use the sample accounts: `student1@college.edu`, `faculty1@college.edu`, or `admin@college.edu`; password: `password`.

> This is a classroom starter. Passwords use BCrypt through PostgreSQL's `pgcrypto` extension. Production deployments still require HTTPS and a real session store.
