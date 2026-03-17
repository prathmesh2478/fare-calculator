pipeline {
    // This tells Jenkins it can run this job on any available executor
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                echo 'Pulling the latest code from the repository...'
                // This command tells Jenkins to pull your source code
                checkout scm
            }
        }

        stage('Compile') {
            steps {
                echo 'Compiling the Spring Boot Java application...'
                // 'bat' is used because you are on Windows
                bat 'mvn clean compile'
            }
        }

        stage('Run Unit Tests') {
            steps {
                echo 'Executing JUnit tests and generating Jacoco coverage...'
                bat 'mvn test'
            }
            post {
                always {
                    // This tells Jenkins to read the test results and create a chart in the Jenkins UI
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Code Quality Check') {
            steps {
                echo 'Enforcing Google Java formatting rules...'
                bat 'mvn checkstyle:check'
            }
        }

        stage('Package JAR') {
            steps {
                echo 'Packaging the application into a standalone executable...'
                // We use -DskipTests here because we already ran and passed the tests in step 3!
                bat 'mvn package -DskipTests'
            }
            post {
                success {
                    echo 'SUCCESS! The Fare Calculator API is ready for deployment.'
                }
                failure {
                    echo 'FAILURE! Something broke. Check the logs above.'
                }
            }
        }
    }
}