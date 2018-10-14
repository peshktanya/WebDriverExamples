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
                withMaven(maven:'maven-3.5.4'){
                    bat 'mvn clean compile'
                }
            }
        }
        stage('Test'){
            steps {
                withMaven(maven:'maven-3.5.4'){
                    bat 'mvn test'
                }
            }
        }
    }
}