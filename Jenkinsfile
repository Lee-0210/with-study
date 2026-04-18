pipeline {
    agent any

    environment {
        IMAGE_TAG = "${BUILD_NUMBER}-${GIT_COMMIT.take(7)}"
    }

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

        stage('Docker Login Build & Push') {
            steps {
                echo '==================== Docker 로그인 ===================='
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    sh """
                        echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin
                    """

                    echo '==================== Docker Build & Push ===================='
                    sh """
                        docker build -t $DOCKER_USER/with-study:${IMAGE_TAG} .
                        docker push $DOCKER_USER/with-study:${IMAGE_TAG}
                    """
                }
            }
        }

        stage('Deploy') {
            steps {
                echo '==================== 프로젝트 배포  ===================='
                sshagent(['win-ssh-key']) {

                    withCredentials([
                        string(credentialsId: 'MYSQL_ROOT_PASSWORD', variable: 'MYSQL_ROOT_PASSWORD')
                    ]) {

                        sh """
                            ssh ljy@192.168.1.191 "powershell -ExecutionPolicy Bypass -File C:\\deploy.ps1 '${IMAGE_TAG}' '${MYSQL_ROOT_PASSWORD}'"
                        """
                    }
                }
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