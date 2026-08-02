pipeline {
    agent any

    stages {
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
            // حفظ تقرير HTML ونتائج Allure
            archiveArtifacts artifacts: 'target/surefire-reports/*.html, allure-results/**', allowEmptyArchive: true

            // توليد تقرير Allure التفاعلي
            allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
        }
        success {
            echo 'Build Passed ✅'
        }
        failure {
            echo 'Build Failed ❌'
        }
    }
}