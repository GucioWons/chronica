pipeline {
    agent any
    environment {
    APP_VERSION = '1.0.0'
    }
    stages {
        stage("build") {
            steps {
                   echo 'Building the application...'
                   echo "Chronica ver. ${APP_VERSION}"
            }
        }
        stage("build chronica-library"){
            steps {
                dir("chronica-library"){
                    sh 'mvn clean install'
                }
            }
        }
    }
}