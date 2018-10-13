pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
            }
        }
        stage('Compile'){
            steps {
                withMaven(maven:'maven-3.5.4'){
                    sh 'mvn clean compile'
                }
            }
        }
        stage('Test'){
            steps {
                withMaven(maven:'maven-3.5.4'){
                    sh 'mvn test'
                }
            }
        }
    }

    }
}