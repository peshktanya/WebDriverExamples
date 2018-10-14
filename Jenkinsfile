pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                bat 'mvn --version'
            }
        }
        stage('Compile'){
            steps {
                bat 'mvn clean compile'
            }
        }
        stage('Test'){
            steps {
                bat 'mvn test'
            }
        }

        stage('Package'){
            steps {
                bat 'mvn package -DskipTests'
            }
        }
    }
}