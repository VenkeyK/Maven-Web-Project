#!groovy

pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '722d2e88-8a8a-45a2-9ac4-ca07b2deb1ac', url: 'https://github.com/VenkeyK/Maven-Web-Project.git']]])
            }
        }
        stage('Build and Test') {
            steps {
               //withEnv(["PATH=${tool 'apache-maven-3.6.0'}/bin:${tool 'java-1.8.0-openjdk-amd64'}/bin:${env.PATH}"])
                sh 'mvn clean compile'
            }
        }
        stage('Deploy') {
            steps {
                sh 'cp $workspace/target/*.war ubuntu@54.227.233.10:/opt/tomcat/apache-tomcat-8.5.37/webapps/'
            }
        }
    }
}

