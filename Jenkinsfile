// Set your project Prefix using your GUID
def prefix = "test2020"

// Set variable globally to be available in all stages
// Set Maven command to always include Nexus Settings
def mvnCmd = "mvn -s ./nexus_settings.xml"
// Set Development and Production Project Names
def devProject = "${prefix}-tasks-dev"
def prodProject = "${prefix}-tasks-prod"
// Set the tag for the development image: version + build number
def devTag = "0.0-0"
// Set the tag for the production image: version
def prodTag = "0.0"
def destApp = "tasks-green"
def activeApp = ""

pipeline {
    agent {
        label "maven"
    }
    options {
        skipDefaultCheckout()
        disableConcurrentBuilds()
    }
    stages {
// Checkout Source Code and calculate Version Numbers and Tags
stage('Checkout Source') {
steps {
// Replace the credentials with your credentials.
//git  url: 'https://github.com/jaysonzhao/chainedcicddemo.git'
// or when using the Pipeline from the repo itself:
 checkout scm
 
}
}

// Using Maven build the war file
// Do not run tests in this step
stage('Build Jar File') {
steps {
//echo "Building version ${devTag}"
dir('depjar'){
     sh "${mvnCmd} clean package -DskipTests=true"
}
}
}




// Publish the built war file to Nexus
stage('Publish to Nexus') {
steps {
echo "Publish to Nexus"
dir('depjar'){
      sh "${mvnCmd}  deploy -DskipTests=true -DaltDeploymentRepository=nexus::default::http://nexus3.nexus.svc.cluster.local:8081/repository/maven-releases"
}
}
}


stage('Compile springboot') {
steps {
echo "Compile springboot"
dir('springboothello'){
      sh "${mvnCmd}  clean install"
}
}
}


}
}