pipeline {
    agent any

    tools {
        // Must match the name configured in 'Manage Jenkins' -> 'Global Tool Configuration'
        maven 'Maven 3.x' 
        jdk 'Java 17' // Adjust version to match your project's requirement
    }

    stages {
        stage('Checkout') {
            steps {
                // Pulled from the provided GitHub repository
                git branch: 'main', url: 'https://github.com/VIJAY-ADITHYA-V/Student-Performance-Analytics-System.git'
            }
        }

        stage('Build & Test') {
            steps {
                // Executes clean and test; ensure Maven is in the PATH via the 'tools' block
                sh 'mvn clean test'
            }
        }

        stage('Package') {
            steps {
                // Packages the application while skipping tests for faster execution
                sh 'mvn package -DskipTests'
            }
        }
    }

    post {
        always {
            // Correctly archives JUnit test reports from the standard Maven target directory
            junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'
        }
        success {
            // Optional: Archive the resulting JAR/WAR file
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
    }
}
