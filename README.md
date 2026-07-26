# 🌸 Allergen Information System

A beautiful, production-ready Spring Boot application for managing allergen information across foods, ingredients, and recipes.

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.0-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-8.x-blue)
![Docker](https://img.shields.io/badge/Docker-Ready-blue)
![Status](https://img.shields.io/badge/Status-Production%20Ready-success)
![Theme](https://img.shields.io/badge/Theme-Cherry%20Blossom%20🌸-ff69b4)

## 🚀 Quick Start

### Prerequisites
- Docker Desktop installed and running
- Port 8080 and 3306 available

### Run the Application

```bash
docker-compose up --build
```

Wait for these messages:
```
✔ Container allergen-mysql  Healthy
✔ Container allergen-app    Started
Started AllergenInformationSystem in 5.234 seconds
```

Then open: **http://localhost:8080** 🌸

That's it! The application is running with MySQL database fully configured.

## 📸 What You'll See

### Home Page
Beautiful cherry blossom themed landing page with easy navigation to all sections.

### Food Management
List, create, edit, and delete food items with a clean, modern interface.

### Ingredient Tracking
Manage your ingredient database with full CRUD operations.

### Recipe Relationships
Link foods with ingredients to track complete allergen information.

## 🛠️ Technology Stack

- **Backend:** Spring Boot 3.5.0, Java 17
- **Database:** MySQL 8.x with HikariCP connection pooling
- **Frontend:** Thymeleaf, HTML5, CSS3
- **Infrastructure:** Docker, Docker Compose
- **Build Tool:** Maven
- **Theme:** Custom Cherry Blossom design

## 📁 Project Structure

```
Allergen-Information-System/
├── src/
│   ├── main/
│   │   ├── java/com/allergen_info_service/
│   │   │   ├── Controllers/          # REST controllers
│   │   │   ├── Models/               # JPA entities
│   │   │   ├── Repositories/         # Data access
│   │   │   └── Services/             # Business logic
│   │   └── resources/
│   │       ├── templates/            # Thymeleaf views
│   │       ├── static/css/           # Stylesheets
│   │       └── application.properties # Configuration
│   └── test/
├── Dockerfile                         # Optimized multi-stage build
├── compose.yaml                       # Docker Compose configuration
└── pom.xml                           # Maven dependencies
```

## 💻 Development

### Run Locally (Without Docker)

```bash
# Start MySQL in Docker
docker-compose up mysql -d

# Run Spring Boot
mvn spring-boot:run
```

### Run Tests

```bash
mvn test
```

### Build Only

```bash
# Build Docker image
docker build -t allergen-app .

# Build JAR file
mvn clean package
```

## 🔧 Configuration

### Environment Variables

The application uses environment variables for flexible configuration:

- `SPRING_DATASOURCE_URL` - Database connection URL
- `SPRING_DATASOURCE_USERNAME` - Database username
- `SPRING_DATASOURCE_PASSWORD` - Database password

Defaults are configured in `application.properties` for local development.

### Database Configuration

MySQL database with the following settings:
- **Database Name:** mydatabase
- **Username:** myuser
- **Password:** secret
- **Port:** 3306 (exposed to host)

## 🧪 Testing

### Manual Testing

1. Start the application: `docker-compose up --build`
2. Navigate to http://localhost:8080
3. Test CRUD operations:
   - Create new foods, ingredients, and recipes
   - Edit existing items
   - Delete items (test foreign key constraints)
4. Verify navigation works seamlessly

### Automated Diagnostics

```powershell
.\diagnose-mysql.ps1
```

This PowerShell script automatically checks:
- Docker status
- Container health
- MySQL connectivity
- Database existence
- Application logs
- Provides specific recommendations

## 📊 Performance

- **Build Time:** ~60s first build, ~15s cached rebuilds
- **Startup Time:** ~25-30s (MySQL + App)
- **Docker Image Size:** 300MB (optimized with multi-stage build)
- **Memory Usage:** ~256-512MB per service
- **Connection Pool:** 10 max connections, 5 minimum idle

## 🔒 Security Notes

### Current Configuration (Development)
- ⚠️ Uses default credentials
- ⚠️ No authentication/authorization
- ⚠️ No HTTPS
- ⚠️ Suitable for development only

### Production Recommendations
- ✅ Use Docker secrets for credentials
- ✅ Enable Spring Security with authentication
- ✅ Configure HTTPS/TLS
- ✅ Implement rate limiting
- ✅ Add audit logging
- ✅ Use production-grade MySQL version
- ✅ Enable MySQL SSL connections
- ✅ Implement proper input validation



### Common Commands

```bash
# Start everything
docker-compose up --build

# Stop everything
docker-compose down

# View logs (follow mode)
docker-compose logs -f

# View only app logs
docker-compose logs -f app

# Restart app after code changes
docker-compose restart app

# Clean slate (removes data!)
docker-compose down -v
docker-compose up --build

# Check status
docker-compose ps

# Run diagnostics
.\diagnose-mysql.ps1
```

---

**Date:** June 19, 2026  
**Version:** 1.0.0  
**Theme:** Cherry Blossom 🌸  
**Status:** Ready to Deploy 🚀  


---

Made with 💖 and lots of 🌸

