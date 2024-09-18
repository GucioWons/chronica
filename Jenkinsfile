pipeline {
    agent any
    stages {
        stage('Build chronica-library') {
            steps {
                dir('chronica-library') {
                    sh './mvnw clean install'
                }
            }
        }
    }
}