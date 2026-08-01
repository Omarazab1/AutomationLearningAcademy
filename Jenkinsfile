pipeline {
    agent any

    tools {
       jdk 'jdk-21'
       maven 'Default Maven'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Clean') {
            steps {
                bat 'mvn clean'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn test'
            }
        }
    }

    post {

        always {
            archiveArtifacts artifacts: 'allure-results/**', allowEmptyArchive: true
        }

        success {
            echo 'Build Passed ✅'
        }

        failure {
            echo 'Build Failed ❌'
        }
    }
}