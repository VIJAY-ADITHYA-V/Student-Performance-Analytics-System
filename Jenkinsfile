pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                https://github.com/VIJAY-ADITHYA-V/Student-Performance-Analytics-System.git
                git 'https://github.com'
            }
        }
        stage('Build & Test') {
            steps {
                sh 'mvn clean test'
            }
        }
        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }
    }
    post {
        always {
            // allowEmptyResults prevents the build from failing if tests didn't run
            junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'
        }
    }
}
