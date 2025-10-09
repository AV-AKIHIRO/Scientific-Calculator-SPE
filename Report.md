# Mini Project Report

**Student Name:** Areen Vaghasiya
**Roll Number:** IMT2022048
**Project Title:** Scientific Calculator with DevOps Pipeline

---


* **Problem Statement:**
  Create a scientific calculator with following operations:

  * Square root (√x)
  * Factorial (!x)
  * Natural logarithm ln(x)
  * Power function (x^b)

* **Goal:**
  Implement the calculator in Java and integrate it into a full DevOps pipeline:
  Source Control → Testing → Build → CI → Containerization → Deployment → Configuration Management.

---

## 2. What and Why of DevOps?

* **What is DevOps?**
  DevOps is a cultural and technical practice that unifies software development (Dev) and IT operations (Ops) to deliver applications and services faster, more reliably, and with higher quality. It emphasizes collaboration across teams, automation of repetitive tasks, and continuous feedback throughout the software lifecycle. Key components include:
  - Continuous Integration (CI)
  - Continuous Delivery/Deployment (CD)
  - Infrastructure as code (IaC),
  - Automated testing
  - Monitoring
  - Rapid rollback capabilities.



* **Why DevOps?**

  * Faster release cycles
  * Quality & reliability
  * Scalability
  * Easier deployment & rollback

<!-- *(Add diagram if possible – “DevOps Infinity Loop”)* -->
<img src="images/DevOps-Loop-1200.png" width="600" alt="devops" />

---

## 3. Tools Used

| Step             | Tool         | Why Used                                 |
| ---------------- | ------------ | ---------------------------------------- |
| Source Control   | Git + GitHub | Code versioning & collaboration          |
| Testing          | JUnit 5      | Automated unit testing for Java          |
| Build            | Maven        | Dependency management & packaging        |
| CI               | Jenkins      | Continuous integration pipeline          |
| Containerization | Docker       | Application containerization             |
| Image Registry   | Docker Hub   | Store & share container images           |
| Deployment       | Ansible      | Automate deployment on local/remote host |

---

## 4. Pipeline Steps

### 4.1 Source Control Management (Git + GitHub)

* **Brief:** Code versioning, collaboration, rollback.
* **Setup:** Installed Git, created GitHub repo `Scientific-Calculator-SPE`.
* **Commands Used:**

  ```bash
  git init
  git remote add origin <repo-url>
  git add .
  git commit -m "Initial commit with BasicOps and AdvOps"
  git push -u origin master
  ```
* **Screenshots:**

  * GitHub repo creation
  <img src="images\git-1.png" width="600" alt="Git repo create" />
  
  * Repo showing uploaded code
  <img src="images\github-1.png" width="600" alt="GitHub structure" />
  
  * Commits on Github
  <img src="images\github-commits.png" width="500" alt="GitHub structure" />


---

### 4.2 Testing (JUnit 5)

* **Brief:** Automated unit testing for calculator functions.
* **Setup:** Maven project with `src/main/java` and `src/test/java`.
* **Dependencies:** Added JUnit to `pom.xml`.
* **Commands Used:**

  ```bash
  mvn test
  ```
* **Files Attached:**

  * `BasicOpsTest.java`
  * `AdvOpsTest.java`
* **Screenshots:**

<img src="images\mvn-test.png" width="400" alt="GitHub structure" />

---

### 4.3 Build (Maven)

* **Brief:** Packaging the project into a JAR so the application can be run, containerized, or distributed. The Maven build compiles source code, runs unit tests, and assembles a reproducible artifact (the JAR) according to pom.xml settings
* **Commands Used:**

  ```bash
  mvn clean package
  ```
  Alternatively,you could also use:

  ```bash
  mvn clean compile
  mvn test
  mvn package
  ```
* **What happens:** Maven resolves dependencies, compiles sources, executes tests (JUnit), and packages the application into target/<artifactId>-<version>.jar (name set in pom.xml). Failing tests stop the build by default.
* **Output:** `target/scientific-calculator-1.0-SNAPSHOT.jar`
* **Screenshots:**

<img src="images\mvn-clean-package-1.png" width="400" alt="Image 1 showing mvn clean package result" />
<img src="images\mvn-clean-package-2 mvn-test.png" width="400" alt="Image 2 showing mvn clean package result" />

  * Successful build logs

  <img src="images\file-struct-jar.png" width="180" alt="Image showing created .jar file">
  * Generated JAR file

* **Common troubleshooting:**
  - Dependency download errors: run `mvn -U clean package` to force updates and check network/registry settings.
  - Test failures: inspect `target/surefire-reports/` for stack traces and rerun failing tests locally.
  - Missing JDK/Maven on CI agent: verify Jenkins Global Tool Configuration and agent environment.
---

### 4.4 Continuous Integration (Jenkins)

* **Brief:** Automate testing & build whenever code is pushed.
* **Setup:** Installed Jenkins, configured GitHub Webhook.
* **Pipeline Script:** (Jenkinsfile snippet)

  ```groovy
  pipeline {
      agent any
      stages {
          stage('Checkout') { steps { git 'https://github.com/user/ScientificCalculator-DevOps.git' } }
          stage('Build') { steps { sh 'mvn clean package' } }
          stage('Test') { steps { sh 'mvn test' } }
      }
  }
  ```
* **Screenshots:**

  * Jenkins job setup
  * Successful pipeline run

---

### 4.5 Containerization (Docker)

* **Brief:** Package calculator as Docker image.
* **Dockerfile Example:**

  ```dockerfile
  FROM openjdk:17
  WORKDIR /app
  COPY target/scientific-calculator-1.0-SNAPSHOT.jar app.jar
  CMD ["java", "-jar", "app.jar"]
  ```
* **Commands Used:**

  ```bash
  docker build -t username/scientific-calculator:1.0 .
  docker run --rm username/scientific-calculator:1.0
  ```
* **Screenshots:**

  * Docker build logs
  * Container running calculator

---

### 4.6 Push to Docker Hub

* **Commands Used:**

  ```bash
  docker login
  docker push username/scientific-calculator:1.0
  ```
* **Link to Image:** [Docker Hub Repo](https://hub.docker.com/username/scientific-calculator)

---

### 4.7 Deployment with Ansible

* **Brief:** Automate pulling & running Docker container on local/remote machine.
* **Ansible Playbook Example (`deploy.yml`):**

  ```yaml
  - hosts: localhost
    tasks:
      - name: Pull Docker image
        docker_image:
          name: username/scientific-calculator
          tag: "1.0"
          source: pull

      - name: Run container
        docker_container:
          name: sci-calc
          image: username/scientific-calculator:1.0
          state: started
          ports:
            - "8080:8080"
  ```
* **Commands Used:**

  ```bash
  ansible-playbook deploy.yml
  ```
* **Screenshots:**

  * Ansible execution logs
  * Calculator running in container

---

## 5. Application Output

* Screenshot of calculator running with sample operations:

  * √25 = 5
  * 5! = 120
  * ln(1) = 0
  * 2^3 = 8

---

## 6. References

* GitHub Docs
* JUnit Docs
* Maven Documentation
* Jenkins Official Guide
* Docker Docs
* Ansible Docs

---

## 7. Links

* **GitHub Repo:** [ScientificCalculator-DevOps](https://github.com/yourusername/ScientificCalculator-DevOps)
* **Docker Hub Repo:** [username/scientific-calculator](https://hub.docker.com/r/username/scientific-calculator)

---

## 8. Appendix

* Full `pom.xml`
* Full `Dockerfile`
* Full `Jenkinsfile`
* Full `deploy.yml` (Ansible playbook)

---

📌 This markdown is intentionally modular:

* You fill in screenshots under each step.
* Add code/config snippets where relevant.
* Convert to PDF at the end with your roll number.

---

Do you want me to also **give you a ready-to-use `Report.md` skeleton file** with headings and placeholders (so you can just fill screenshots and links)?
