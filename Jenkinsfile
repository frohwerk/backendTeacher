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
    }

}
