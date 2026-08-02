pipeline {
    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven'
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
            archiveArtifacts artifacts: 'target/surefire-reports/*.html', allowEmptyArchive: true
        }

        success {
            echo 'Build Passed ✅'
        }

        failure {
            echo 'Build Failed ❌'
        }
    }
}