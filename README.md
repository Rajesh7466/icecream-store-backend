# 🔐 Spring Boot Security Project

## 📌 Authentication & Authorization Flow

```mermaid
flowchart TD
    A[👤 User] --> B[📝 Login Form]
    B --> C{🔒 Spring Security}

    C -->|Valid Credentials| D[🎟️ Generate JWT Token]
    C -->|Invalid Credentials| E[❌ Access Denied]

    D --> F[🔑 Access Protected API]
    F --> G{🛡️ Authorization Check}

    G -->|Admin Role| H[👨‍💼 Admin Access Granted]
    G -->|User Role| I[👤 User Access Granted]
    G -->|Unauthorized| E