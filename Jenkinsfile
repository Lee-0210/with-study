pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo '==================== SCM 확인  ===================='
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo '==================== 프로젝트 빌드 ===================='
                sh 'chmod +x gradlew'
                sh './gradlew clean build'
            }
        }

        stage('Check Artifact') {
            steps {
                echo '==================== .jar 파일 확인 ===================='
                sh 'ls -al build/libs'
            }
        }
    }

    post {
        success {
            echo '==================== 빌드 성공 ===================='
        }
        failure {
            echo '==================== 빌드 실패 ===================='
        }
        always {
            echo '==================== 파이프라인 끝 ===================='
        }
    }
}