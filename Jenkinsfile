#!groovy

pipeline {
  agent any
	stage('Checkout'){
 checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '722d2e88-8a8a-45a2-9ac4-ca07b2deb1ac', url: 'https://github.com/VenkeyK/Maven-Web-Project.git']]])
       }
 stage('Build and Test'){
       
          sh 'mvn install'
       }
	   
      stage('Deployment') {
                  
                    sh 'cp $workspace/target/*.war ubuntu@54.227.233.10:/opt/tomcat/apache-tomcat-8.5.37/webapps/'
                }
       
}
