def call() {
    env.SONAR_EXTRA_OPTS = "-Dsonar.java.binaries=./target"
    env.APPTYPE = "java"
    node {
        try {
            common.codeCheckout()
            stage('Compile Code') {
                sh 'mvn compile'
            }
            common.codeQuality()
            common.codeChecks()
            common.artifacts()
        }   catch (Exception e) {
            mail bcc: '', body: "Build Failed ${RUN_DISPLAY_URL}", cc: '', from: 'venkymec1922@gmail.com', replyTo: '', subject: 'BUILD FAILURE', to: 'venkymec1922@gmail.com'
        }
    }

}
