pipeline {
    agent any
    environment {
        dockerImage = ''
        registry = 'rutikk/springboot-crud-app:latest'
      DOCKERHUB_CREDENTIALS = credentials('dockerhub_id')
    }
    stages {
        
        stage('Build Docker Images') {
            steps {
                script {
                    echo registry
                    sh 'ls'
                    sh 'docker image build -t rutikk/springboot-crud-app:latest .'
                }
            }
        }
        stage('Upload to DockerHub') {
            steps {
                script {
                    sh 'echo "$DOCKERHUB_CREDENTIALS_USR"'
                    sh 'echo "$DOCKERHUB_CREDENTIALS_PSW"'
                    sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                    sh 'docker image push rutikk/springboot-crud-app:latest'
                }
            }
        }
        stage('Stop and Remove Existing Containers') {
            steps {
                sh 'docker-compose -f /home/rutik_ravindra_kalokhe/docker-compose.yml down'
            }
        }
        stage('Run Docker Compose') {
            steps {
                script {
                    sh 'docker-compose -f /home/rutik_ravindra_kalokhe/docker-compose.yml up -d'
                }
            }
        }
    }
}
