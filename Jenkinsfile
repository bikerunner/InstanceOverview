node  {
    // Mark the code checkout 'stage'....
    stage('Checkout') {
       // Checkout code from repository
       checkout scm
    }

    stage('Build') {
        bat "set"
    
        if(isUnix()) {
            sh 'gradlew build --info'
        } else {
            bat 'gradlew build --info'
        }
    }
}