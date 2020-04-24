pipeline {

    agent any

    tools {
        jdk 'jdk-14'
    }

    stages {

        stage('Compile and test') {
            steps {
                bat "gradlew bootJar"
            }
        }

        stage('Static code analysis') {
            steps {
                bat "gradlew sonarqube"
            }
        }

        stage('Deploy to dev environment') {
            when {
                branch 'master'
            }
            steps {
                echo "TODO"
            }
        }

    }

}
