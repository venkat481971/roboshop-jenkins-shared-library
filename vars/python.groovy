def call() {
    env.APPTYPE = "python"
    node {
        try {
            common.codeCheckout()
            common.codeQuality()
            common.codeChecks()
            common.artifacts()
        }   catch (Exception e) {
            mail bcc: '', body: "Build Failed ${RUN_DISPLAY_URL}", cc: '', from: 'venkymec1922@gmail.com', replyTo: '', subject: 'BUILD FAILURE', to: 'venkymec1922@gmail.com'
        }
    }

}
