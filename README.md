# School Management System (JavaFX + SQLite)

Desktop school management application built with Java, JavaFX (FXML), and SQLite.
Includes login with role selection (Admin / Student), an admin dashboard for managing student records, and a student view.

## Highlights
- JavaFX UI (FXML + controllers)
- SQLite persistence via JDBC
- Role-based flow (Admin / Student)
- `TableView` with observable model (`StudentData`)

## What I added in this repo
- `schema.sql` — database schema for `login` and `students` tables
- `seed.sql` — example seed data to populate the DB for testing
- `LICENSE` — MIT license
- polished `README.md` with setup and publish instructions

## Quick start (Windows / PowerShell)
1. Ensure JDK 8 is installed. This project was developed with `jdk1.8.0_202`.
2. From the project root, build with the NetBeans Ant bundled with NetBeans (or Apache Ant):

```powershell
$env:JAVA_HOME='C:\Program Files\Java\jdk1.8.0_202'
$env:Path = "$env:JAVA_HOME\bin;$env:Path"
& 'C:\Program Files\NetBeans-22\netbeans\extide\ant\bin\ant.bat' -f 'build.xml'
```

3. Create a fresh SQLite DB from the schema and seed it (requires `sqlite3` CLI):

```powershell
sqlite3 schoolsystem.sqlite < schema.sql
sqlite3 schoolsystem.sqlite < seed.sql
```

If you don't have `sqlite3`, you can run the SQL files in any SQLite GUI (DB Browser for SQLite) or via Java code.

4. Run the app directly (after build):

```powershell
java -cp "build\classes;lib\sqlite-jdbc-3.16.1.jar;C:\Program Files\Java\jdk1.8.0_202\jre\lib\jfxrt.jar" loginapp.LoginApp
```

Or open the folder in VS Code and press F5 (the repo includes `.vscode/launch.json`).

## Database schema (summary)
- `login` — stores `username`, `password` (plain text here; **change to hashed** for production), and `division` (role).
- `students` — stores student records used by the admin dashboard.

Run `schema.sql` and `seed.sql` to create and populate the database.

## Publishing to GitHub and replacing existing repo contents
If the remote repo currently stores a ZIP or an older/incorrect snapshot and you want to replace its contents entirely, use a force-push to `main` (careful: this overwrites remote history):

```powershell
git init
git add .
git commit -m "Initial commit: School Management System (polished)"
git branch -M main
git remote add origin https://github.com/YOUR_USERNAME/REPO_NAME.git
git push -u --force origin main
```

Notes:
- Replace `YOUR_USERNAME/REPO_NAME` with your GitHub repo URL.
- Force-pushing (`--force`) will replace remote history — only do this if you intend to overwrite the remote.

## Recommended next improvements (for a job-ready project)
- Hash passwords (BCrypt/PBKDF2) instead of plain text
- Fix SQL bugs and parameterize all queries
- Add form validation and confirmation dialogs
- Add DAO/service layers and unit tests
- Provide migration scripts and remove the DB file from the repo

## License
This repository includes an MIT license (`LICENSE`).

---
If you want, I will:
- create `schema.sql` and `seed.sql` (done) and run a quick verification,
- prepare a short `schema.md` describing the table columns,
- give the exact commands to force-push to GitHub and remove the zip-only content.
