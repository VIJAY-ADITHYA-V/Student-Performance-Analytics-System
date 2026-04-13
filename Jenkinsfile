pipeline {
    agent any
    
    // Add this tools section
    tools {
        maven 'MAVEN_HOME' // Use the name you configured in Manage Jenkins > Global Tool Configuration
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/VIJAY-ADITHYA-V/Student-Performance-Analytics-System.git'
            }
        }
        // ... rest of your stages
    }
}
