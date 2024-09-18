pipeline {
    agent any

    environment {
    APP_VERSION = '1.0.0'
    }

    stages {
        stage("Prepare chronica application") {
            steps {
                   echo 'Preparing the application...'
                   echo "Chronica ver. ${APP_VERSION}"
            }
        }

        stage("Build chronica-library"){
            steps {
                dir("chronica-library"){
                    sh 'mvn clean install'
                }
            }
        }

         stage("Build eureka server"){
            steps {
                dir("server"){
                    sh 'mvn clean install'
                }
            }
         }
    }
}