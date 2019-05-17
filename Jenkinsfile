pipeline { 
    agent any   
    stages { 
        stage("SCM") {
            steps { 
                git 'https://github.com/ParadoxZero/GameMenu-cpp.git'
            }
        }
        stage('Build') { 
            steps { 
                sh 'make'
            }
        }
        stage("Uniti test") { 
            steps { 
                sh 'ls -l build/GameMenu/GameMenu.o'
            }
        }
        stage("SonarQube analysis") {
            environment {
            scannerHome = tool 'sonarqube_scanner'
            }
            
            steps { 
                withSonarQubeEnv('sonarqube_scanner') {
                    sh "${scannerHome}/bin/sonar-scanner -X  -Dsonar.host.url=http://192.168.56.101:9000  -Dsonar.language=c++ -Dsonar.projectName=test -Dsonar.lang.patterns.c++=**/*.cpp,**/*.h -Dsonar.projectVersion=1.1 -Dsonar.projectKey=My_project -Dsonar.lang.patterns.c=**/*.c,**/*.h -Dsonar.sources=src -Dsonar.projectBaseDir=/home/jenkins/workspace/test_c++ -Dsonar.tests=. -Dsonar.test.inclusions=**/*Test*/** -Dsonar.exclusions=**/*Test*/**"
                }
            }
        }
        stage("Push Artifactory") {
            steps { 
                sh 'curl -u admin:password -T build/GameMenu/GameMenu.o "http://192.168.56.101:8081/artifactory/example-repo-local/"'
            }
        }
    }
}
