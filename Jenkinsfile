pipeline {
    agent any
    stages {
        stage('Build chronica-library') {
            steps {
                dir('chronica-library') {
                    sh 'mvn clean install'
                }
            }
        }
    }
}