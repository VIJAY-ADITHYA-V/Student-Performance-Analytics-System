pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Correct way to pull the code
                git branch: 'main', url: 'https://github.com/VIJAY-ADITHYA-V/Student-Performance-Analytics-System.git'
            }
        }

        stage('Build & Test') {
            steps {
                // Runs Maven clean and runs your unit tests
                sh 'mvn clean test'
            }
        }

        stage('Package') {
            steps {
                // Packages the app into a JAR/WAR file, skipping tests for speed
                sh 'mvn package -DskipTests'
            }
        }
    }

    post {
        always {
            // Collects and displays test results in the Jenkins UI
            junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'
        }
    }
}
