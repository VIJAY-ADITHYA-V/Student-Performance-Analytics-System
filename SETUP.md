# Setup Instructions for Student Performance Analytics System

## Step 1: Repository Already Created

Repository is available at: https://github.com/VIJAY-ADITHYA-V/Student-Performance-Analytics-System

## Step 2: Clone Repository Locally

```bash
cd /path/to/your/workspace
git clone https://github.com/VIJAY-ADITHYA-V/Student-Performance-Analytics-System.git
cd Student-Performance-Analytics-System
```

## Step 3: Project Structure

The Maven directory structure is already set up:

```
Student-Performance-Analytics-System/
├── src/
│   ├── main/
│   │   └── java/com/studentperformance/
│   │       ├── Main.java
│   │       ├── models/
│   │       │   └── Student.java
│   │       └── service/
│   │           └── PerformanceAnalyzer.java
│   └── test/
│       └── java/com/studentperformance/
│           └── StudentTest.java
├── pom.xml
├── Jenkinsfile
├── .gitignore
├── README.md
└── SETUP.md
```

## Step 4: Verify Build Locally

```bash
# Navigate to project root
cd Student-Performance-Analytics-System

# Clean and compile
mvn clean compile

# Run tests
mvn test

# Package
mvn package
```

## Step 5: Run Application

```bash
java -jar target/StudentPerformanceAnalytics-1.0-SNAPSHOT.jar
```

Or using Maven directly:

```bash
mvn exec:java -Dexec.mainClass="com.studentperformance.Main"
```

## Development Workflow

### Making Changes

```bash
# 1. Check current status
git status

# 2. Create a new branch for your feature (recommended)
git checkout -b feature/your-feature-name

# 3. Make your code changes in VS Code
# 4. Stage changes
git add .

# 5. Commit with meaningful message
git commit -m "Add feature: description of changes"

# 6. Push to GitHub
git push origin feature/your-feature-name
```

### Creating Pull Request

1. Go to GitHub repository: https://github.com/VIJAY-ADITHYA-V/Student-Performance-Analytics-System
2. Click "Compare & pull request"
3. Add title and description
4. Click "Create pull request"
5. Merge after review

### Merging Back to Main

```bash
# Switch to main branch
git checkout main

# Pull latest changes
git pull origin main

# Merge feature branch
git merge feature/your-feature-name

# Push merged changes
git push origin main

# Delete feature branch locally
git branch -d feature/your-feature-name

# Delete feature branch on GitHub
git push origin --delete feature/your-feature-name
```

## Git Configuration

### First Time Setup

```bash
# Configure Git with your details
git config --global user.name "Your Full Name"
git config --global user.email "your-email@example.com"

# Verify configuration
git config --global --list
```

### SSH Authentication (Recommended)

```bash
# Generate SSH key
ssh-keygen -t ed25519 -C "your-email@example.com"

# Add public key to GitHub Settings > SSH and GPG keys
# Use: cat ~/.ssh/id_ed25519.pub
```

## VS Code Setup

### Install Extensions

1. Open VS Code
2. Install these extensions:
   - Extension Pack for Java
   - Maven for Java
   - Spring Boot Extension Pack
   - Git Graph
   - GitLens

### Configure Java Path

1. File > Preferences > Settings
2. Search for "Java"
3. Set JAVA_HOME to your Java 11 installation path

## Maven Commands Reference

```bash
# Clean build directory
mvn clean

# Compile source code
mvn compile

# Run unit tests
mvn test

# Package into JAR
mvn package

# Install to local repository
mvn install

# Clean and build everything
mvn clean install

# Run with specific main class
mvn exec:java -Dexec.mainClass="com.studentperformance.Main"

# Skip tests during build
mvn clean package -DskipTests

# Display project info
mvn help:describe -Dplugin=org.apache.maven.plugins:maven-compiler-plugin
```

## Jenkins Setup for CI/CD

### Prerequisites

- Jenkins server installed and running
- Maven installed on Jenkins server
- GitHub repository access from Jenkins

### Steps to Configure

1. **Install Jenkins Plugins**
   ```
   - Maven Integration Plugin
   - GitHub Integration Plugin
   - Pipeline Plugin
   - JUnit Plugin
   ```

2. **Create Pipeline Job**
   - Jenkins Dashboard > New Item
   - Enter name: `StudentPerformanceAnalytics`
   - Select "Pipeline"
   - Click OK

3. **Configure Pipeline**
   - Definition: Pipeline script from SCM
   - SCM: Git
   - Repository URL: https://github.com/VIJAY-ADITHYA-V/Student-Performance-Analytics-System.git
   - Branch: */main
   - Script Path: Jenkinsfile
   - Save

4. **Configure Webhook (Optional)**
   - GitHub: Settings > Webhooks > Add webhook
   - Payload URL: http://your-jenkins-url/github-webhook/
   - Content type: application/json
   - Events: Push events
   - Save

5. **Build Now**
   - Click "Build Now" to start first build
   - Monitor in Console Output

### Jenkins Pipeline Stages

Pipeline automatically executes these stages:
1. **Checkout** - Clone from GitHub
2. **Build** - Maven compile
3. **Test** - Run unit tests
4. **Package** - Create JAR file
5. **SonarQube Analysis** - Code quality (optional)
6. **Archive Artifacts** - Store JAR file
7. **Deploy** - Ready for deployment

### Monitor Builds

```bash
# View build logs
Jenkins Dashboard > StudentPerformanceAnalytics > Build #X > Console Output

# Check test results
Jenkins Dashboard > StudentPerformanceAnalytics > Build #X > Test Result
```

## Troubleshooting

### Maven Build Issues

```bash
# Clear Maven cache
rm -rf ~/.m2/repository

# Rebuild
mvn clean install

# Check Maven version
mvn --version

# Check Java version
java -version
```

### Git Push Rejected

```bash
# Pull latest changes first
git pull origin main

# Resolve conflicts if any
# Then push again
git push origin main
```

### Authentication Issues

```bash
# Test SSH connection
ssh -T git@github.com

# If fails, regenerate SSH key and add to GitHub
ssh-keygen -t ed25519 -C "your-email@example.com"
```

### Jenkins Build Failed

1. Check Console Output for errors
2. Verify Maven and Java are installed
3. Check GitHub repository access
4. Review Jenkinsfile syntax

### Port Already in Use

```bash
# Find process using port 8080 (Jenkins default)
lsof -i :8080

# Kill process
kill -9 <PID>

# Or use different port
java -jar jenkins.war --httpPort=8081
```

## Continuous Development

```bash
# Regular workflow for daily development
git pull origin main          # Get latest
git checkout -b feature/xyz   # Create feature branch
# Make changes in VS Code
mvn clean test                # Test locally
git add .                     # Stage changes
git commit -m "Feature: xyz"  # Commit
git push origin feature/xyz   # Push
# Create Pull Request on GitHub
# After merge: git checkout main && git pull origin main
```

## Resources

- [Maven Documentation](https://maven.apache.org/)
- [Git Documentation](https://git-scm.com/doc)
- [Jenkins Documentation](https://www.jenkins.io/doc/)
- [Java 11 Documentation](https://docs.oracle.com/en/java/javase/11/)
- [GitHub Guides](https://guides.github.com/)