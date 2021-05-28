pipeline {
  agent any
  stages{    
    stage("maven clean"){
      steps {
        sh 'mvn clean'
      }  
    }
    
    stage("maven compile"){
      steps {
        sh 'mvn compile'
      }  
    }

    stage("docker build"){
      steps {
        sh 'docker build -t Spring-Projcet .'
      }
    }

    stage("docker run"){
      steps {
        sh 'docker run Spring-Project'
      }
    }
  }

}
