pipeline {
    agent any   // Run on any available Jenkins agent

    tools {
        maven 'Maven_3.9.9'   // Must match Global Tool Config name in Jenkins
        jdk 'JDK17'
    }

    environment {
        DOCKER_IMAGE = "areen9295/calc-app2"
        // Define the location of the Ansible inventory file (e.g., hosts.ini)
        ANSIBLE_INVENTORY = "hosts.ini" 
        // Define the playbook file (assuming it's in the root of the repo)
        ANSIBLE_PLAYBOOK = "deploy.yml"
    }

    stages {
        stage('Checkout') {
            steps {
                // Pull code from GitHub
                git branch: 'main', url: 'https://github.com/AV-AKIHIRO/Scientific-Calculator-SPE'
            }
        }

        stage('Build') {
            steps {
                // clean and compile
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                // run unit tests
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                // create the jar file
                sh 'mvn package'
            }
        }
        
        stage('Archive Artifact') {
            steps {
                // Save JAR file inside Jenkins
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }

        stage('Docker Build & Push') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', 'dockerhub-credentials') {
                        // Build Docker image with version tag
                        def app = docker.build("${DOCKER_IMAGE}:${env.BUILD_NUMBER}")
                        // Push with build number tag
                        app.push()
                        // Also push as latest
                        app.push("latest")
                    }
                }
            }
        }

        stage('Ansible Deploy') {
            steps {
                echo "Starting Ansible deployment for image ${DOCKER_IMAGE}:${env.BUILD_NUMBER}"
                
                // Execute the playbook, passing the newly created Docker tag as an extra variable.
                // NOTE: The Jenkins agent must have Ansible installed.
                sh "ansible-playbook -i ${ANSIBLE_INVENTORY} ${ANSIBLE_PLAYBOOK} -e \"docker_image_tag=${DOCKER_IMAGE}:${env.BUILD_NUMBER}\""
            }
        }
    }

    post {
        success {
            echo "Build #${env.BUILD_NUMBER} completed successfully!"
            emailext(
                to: 'areen.vaghasiya+jenkins@iiitb.ac.in',
                subject: "Jenkins Build SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
                Hi,

                The Jenkins pipeline for *${env.JOB_NAME}* completed successfully.
                Docker Image pushed: ${DOCKER_IMAGE}:${env.BUILD_NUMBER}

                Regards,
                Jenkins CI/CD(Areen Vaghasiya)
                """
            )
        }
        failure {
            echo "Build #${env.BUILD_NUMBER} failed!"
            emailext(
                to: 'areen.vaghasiya+jenkins@iiitb.ac.in',
                subject: "Jenkins Build FAILURE: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
                Hi ,

                The Jenkins pipeline for *${env.JOB_NAME}* has FAILED.
                Please check Jenkins logs for details.

                Regards,
                Jenkins CI/CD(Areen Vaghasiya)
                """
            )
        }
    }
}
