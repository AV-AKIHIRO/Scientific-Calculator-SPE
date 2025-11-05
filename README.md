# Scientific Calculator with DevOps Pipeline

A terminal-based scientific calculator application built with Java, featuring a complete CI/CD pipeline demonstrating modern DevOps practices including automated testing, containerization, and continuous deployment.

[![Docker Hub](https://img.shields.io/badge/Docker%20Hub-areen9295%2Fcalc--app2-blue)](https://hub.docker.com/r/areen9295/calc-app2)
[![Java](https://img.shields.io/badge/Java-17-orange)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.9.3-red)](https://maven.apache.org/)

## Project Overview

**Student Name:** Areen Vaghasiya  
**Roll Number:** IMT2022048

This project implements a scientific calculator with four core advanced mathematical operations and demonstrates a complete DevOps lifecycle from source control to automated deployment.

### Features

- **Square Root**: √x
- **Factorial**: x!
- **Natural Logarithm**: ln(x) (base e)
- **Power Function**: x^b

## DevOps Pipeline Architecture

The project implements a fully automated CI/CD pipeline with the following workflow:

```
Developer Push → GitHub → Webhook (ngrok) → Jenkins → Maven Build & Test 
→ Docker Build → Docker Hub Push → Ansible Deployment → Email Notification
```

### Pipeline Stages

1. **Source Control**: Git commits trigger GitHub webhook
2. **Continuous Integration**: Jenkins orchestrates the pipeline
3. **Build**: Maven compiles and packages the application
4. **Test**: JUnit 5 executes automated unit tests
5. **Containerization**: Docker builds the application image
6. **Registry**: Image pushed to Docker Hub
7. **Deployment**: Ansible deploys container to target environment
8. **Notification**: Email alerts on pipeline success/failure

## Technology Stack

| Component | Tool | Purpose |
|-----------|------|---------|
| **Language** | Java 17 | Application development |
| **Build Tool** | Maven 3.9.3 | Build automation and dependency management |
| **Testing** | JUnit 5 | Unit testing framework |
| **Version Control** | Git + GitHub | Source code management |
| **CI/CD** | Jenkins | Pipeline orchestration |
| **Containerization** | Docker | Application packaging |
| **Registry** | Docker Hub | Container image storage |
| **Deployment** | Ansible | Automated configuration management |
| **Tunneling** | ngrok | GitHub-Jenkins webhook connectivity |

## Prerequisites

- Java Development Kit (JDK) 17
- Maven 3.9.3+
- Docker
- Jenkins
- Ansible
- Git
- ngrok (for local Jenkins setup)

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/AV-AKIHIRO/Scientific-Calculator-SPE.git
cd Scientific-Calculator-SPE
```

### Build with Maven

```bash
# Compile and run tests
mvn test

# Build the JAR file
mvn clean package
```

### Run Locally

```bash
# Run the JAR file
java -jar target/scientific-calculator-1.0-SNAPSHOT.jar
```

### Using Docker

```bash
# Pull from Docker Hub
docker pull areen9295/calc-app2:latest

# Run the container interactively
docker run -it --rm areen9295/calc-app2:latest

# Or run in detached mode
docker run -d --name calc-container areen9295/calc-app2:latest
```

### Build Docker Image Locally

```bash
docker build -t areen9295/calc-app2:latest .
docker run -it --rm areen9295/calc-app2:latest
```

## 🔧 Jenkins Pipeline Setup

### Required Jenkins Plugins

- Git Plugin
- Maven Integration Plugin
- Docker Pipeline Plugin
- Ansible Plugin
- GitHub Integration Plugin
- Email Extension Plugin

### Jenkins Configuration

1. **Global Tool Configuration**
   - JDK: JDK 17
   - Maven: Maven 3.9.3
   - Git, Docker, and Ansible executables

2. **Credentials Setup**
   - GitHub personal access token
   - Docker Hub credentials (ID: `dockerhub-credentials`)
   - Email credentials for notifications

3. **Jenkins URL Configuration**
   - Set Jenkins URL to your ngrok tunnel endpoint

### GitHub Webhook Setup

1. Start ngrok tunnel:
   ```bash
   ngrok http --url="https://your-static-url.ngrok-free.dev" 8080
   ```

2. Configure webhook in GitHub:
   - **Payload URL**: `https://your-ngrok-url.ngrok-free.dev/github-webhook/`
   - **Content type**: `application/json`
   - **Events**: Just the push event
   - **Active**: ✓ Checked

3. Create Jenkins Pipeline job:
   - Enable "GitHub hook trigger for GITScm polling"
   - Set Pipeline script from SCM (Git)
   - Branch: `*/main`
   - Script Path: `Jenkinsfile`

## Project Structure

```
Scientific-Calculator-SPE/
├── src/
│   ├── main/
│   │   └── java/          # Application source code
│   └── test/
│       └── java/          # JUnit test cases
├── target/                # Maven build output
├── Dockerfile             # Docker configuration
├── Jenkinsfile            # CI/CD pipeline definition
├── deploy.yml             # Ansible deployment playbook
├── inventory.ini          # Ansible inventory
├── pom.xml               # Maven configuration
└── README.md             # Project documentation
```

## Testing

Unit tests are written using JUnit 5 and cover all calculator operations:

```bash
mvn test
```

Tests verify:
- Square root calculations
- Factorial computations
- Natural logarithm operations
- Power function results

## Docker Hub

**Repository**: [areen9295/calc-app2](https://hub.docker.com/r/areen9295/calc-app2)

Images are automatically tagged with:
- Build number: `areen9295/calc-app2:${BUILD_NUMBER}`
- Latest: `areen9295/calc-app2:latest`

## Ansible Deployment

The deployment is automated using Ansible playbook (`deploy.yml`):

```bash
ansible-playbook -i inventory.ini deploy.yml
```

The playbook:
- Verifies Python Docker module availability
- Pulls the latest image from Docker Hub
- Deploys container on localhost
- Maps port 80 to host port 9000
- Sets restart policy to `always`

## Challenges and Solutions

### Docker Permission Issues
**Problem**: Jenkins user lacked Docker daemon permissions  
**Solution**: 
```bash
sudo usermod -aG docker jenkins
sudo systemctl restart jenkins
```

### Ansible SSH Connection
**Problem**: SSH authentication failures for localhost  
**Solution**: Use `ansible_connection=local` in inventory file

### Maven Dependency Resolution
**Problem**: Corrupted repository cache  
**Solution**: 
```bash
mvn clean install -U
```

### ngrok URL Changes
**Problem**: Free tier ngrok generates new URLs on restart  
**Solution**: Use the one free static subdomain available on free tier

## Email Notifications

The pipeline sends automated email notifications on:
- **Success**: Build details and Docker image tags
- **Failure**: Error alerts with log inspection prompts

## DevOps Benefits Demonstrated

- **Faster Release Cycles**: Automated pipeline reduces deployment time
- **Improved Quality**: Automated testing catches bugs early
- **Enhanced Scalability**: Containerization enables easy scaling
- **Reduced Risk**: Automated deployments with consistent environments
- **Better Collaboration**: Unified tooling and version control
- **Cost Efficiency**: Automation reduces manual intervention

## References

- [Docker Hub Repository](https://hub.docker.com/r/areen9295/calc-app2)
- [GitHub Repository](https://github.com/AV-AKIHIRO/Scientific-Calculator-SPE.git)


## Author

**Areen Vaghasiya** (IMT2022048)

---




