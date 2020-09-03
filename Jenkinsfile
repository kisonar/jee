pipeline {
    agent any

    stages {
        stage('Start - preparing workspace') {
            steps {
                echo 'Cleaning up workspace..'
                mvn clean
            }
        }
		
		stage('Checking Maven and JDK Versions') {
            steps {
                echo 'Checking JDK and Maven versions'
                mvn enforcer:enforce
            }
        }
		
    	stage('Checking updates for plugins') {
            steps {
                echo 'Check for plugins updates'
                mvn versions:display-plugin-updates
            }
        }

		stage('Checking updates for dependencies') {
            steps {
                echo 'Check for dependencies updates'
                mvn  versions:display-dependency-updates
            }
        }
		
		stage('Checking dependencies management') {
            steps {
                echo 'Check for dependencies updates'
                mvn  dependency:analyze-dep-mgt
            }
        }
		
        stage('Build and testing') {
            steps {
                echo 'Building and installing in local environment..'
                mvn install 
            }
        }

		stage('Documentation') {
            steps {
                echo 'Generating documentation'
                mvn site
            }
        }
		
        stage('Done..') {
            steps {
                echo 'Build pipe done successfully....'
            }
        }
    }
}