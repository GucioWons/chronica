pipeline {
    agent any

    environment {
    APP_VERSION = "1.0.0"
    }

    stages {
        stage("Prepare chronica application") {
            steps {
                   echo "Preparing the application..."
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

         stage("Build eureka gateway"){
            steps {
                dir("gateway"){
                    sh 'mvn clean install'
                }
            }
         }

         stage("Build document-module"){
            steps {
                dir("document"){
                    sh 'mvn clean install'
                }
            }
         }

          stage("Build chain-module"){
             steps {
                 dir("chain"){
                     sh 'mvn clean install'
                 }
             }
          }

          stage("Build group-module"){
             steps {
                 dir("group"){
                     sh 'mvn clean install'
                 }
             }
          }

          stage("Build notification-module"){
             steps {
                 dir("notification"){
                     sh 'mvn clean install'
                 }
             }
          }

          stage("Build project-module"){
             steps {
                 dir("project"){
                     sh 'mvn clean install'
                 }
             }
          }

          stage("Build snap-module"){
             steps {
                 dir("snap"){
                     sh 'mvn clean install'
                 }
             }
          }

          stage("Build user-module"){
             steps {
                 dir("user"){
                     sh 'mvn clean install'
                 }
             }
          }
    }
}