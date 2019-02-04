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
                sh 'mvn clean install'
            }
        }
        stage('Deploy') {
            steps {
              // sh 'scp /var/lib/jenkins/workspace/pipe/target/*.war ubuntu@18.212.8.72:/opt/tomcat/apache-tomcat-8.5.37/webapps/'
               sh '''cp -R //var//lib//jenkins//workspace//pipe//target//*.war //opt//tomcat//apache-tomcat-8.5.37//webapps//'''
            }
        }
    }
}

