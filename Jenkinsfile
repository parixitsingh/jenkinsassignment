pipeline {
    agent any
    tools
    {
        maven 'Maven3'
    }
    options {
        timestamps()
        timeout(time: 1, unit: 'HOURS')

        skipDefaultCheckout()
        buildDiscarder(logRotator(daysToKeepStr: '10', numToKeepStr: '10'))

        disableConcurrentBuilds()
    }

    environment {
        BUILD_DIR = 'jenkins-assignment'
        PROJECT_ID = 'jenkinsassignment-360411'
        CLUSTER_NAME = 'kubernetes-cluster-parixitsingh'
        LOCATION = 'us-central1'
        KUBERNETES_CREDENTIALS_ID = 'gsaccount'
        DOCKER_CREDENTIALS_ID = "dockerhub"
        BRANCH_NAME = '' //bat (script: 'git rev-parse --abbrev-ref HEAD', returnStdout: true).trim()
    }

    stages {
        stage('Sequential Setup Steps') {
            stages {
                stage ('Checkout') {
                    steps {
                        // deleteDir()
                        // dir(env.BUILD_DIR) {
                            script {
                                checkout scm
                                env.BRANCH_NAME = scm.branches[0].name
                                echo scm.branches
                            }
                        // }
                    }
                }

                stage ('Stash') {
                    steps {
                        stash includes: '**', name: 'source', useDefaultExcludes: false
                    }
                }
            }
            // post {
            //     cleanup { deleteDir() }
            // }
        }

        stage ('Build') {
            steps {
                // deleteDir()
                // unstash 'source'
                // dir(env.BUILD_DIR) {
                    script {
                        echo env.BRANCH_NAME
                        bat 'mvn clean install'
                    }
                // }
            }
        }

        stage ('Unit Testing') {
            when {
                expression {
                    return env.BRANCH_NAME == 'main';
                }
            }
            steps {
                // deleteDir()
                // unstash 'source'
                // dir(env.BUILD_DIR) {
                    script {
                        bat 'mvn test'
                    }
                // }
            }
        }

        stage ("Sonar Analysis") {
            when {
                expression {
                    return env.BRANCH_NAME == 'develop';
                }
            }
            steps {
                withSonarQubeEnv("Test_Sonar") {
                    bat 'mvn sonar:sonar'
                }
            }
        }
        
        stage ('Docker Image') {
            steps {
                script{    
                    withDockerServer([uri:'tcp://localhost:2375', credentialsId: env.DOCKER_CREDENTIALS_ID]) {
                        withDockerRegistry([credentialsId: env.DOCKER_CREDENTIALS_ID, url: "https://docker.io/"]) {
                            bat 'docker login -u pstsingh5 -p Prat@2208'                
                            bat 'docker build -t pstsingh5/iparixitsingh%env.BRANCH_NAME%:latest --no-cache -f Dockerfile .'
                        }
                    }   
                }
            }
        }

        stage ('Upload docker image') {
            steps {
                script {
                    bat 'docker push pstsingh5/iparixitsingh%env.BRANCH_NAME%:latest'
                }
            }
        }

        stage ('Kubernetes deployment'){
            steps {
                script {
                   // bat 'bash sed -e "s~BRANCH_NAME_VAR~main~g" "deployment.yaml" > "deploy.yaml"'
                 //   bat 'bash script.sh -b %env.BRANCH_NAME%'

                    withKubeConfig([credentialsId: env.KUBERNETES_CREDENTIALS_ID, clusterName: env.CLUSTER_NAME]) {
                        bat 'kubectl apply -f deploy.yaml --context kubernetes-cluster-parixitsingh'
                    }
                }
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}