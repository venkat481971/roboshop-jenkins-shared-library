def call() {
    node {

        if (! env.TAG_NAME) {
            env.TAG_NAME = ""
        }

        sh 'env'
        common.codeQuality()

        if ( BRANCH_NAME == "main" || TAG_NAME ==~ "*" ) {
            stage('Style Checks') {
                echo 'Style Checks'
            }
        }
    }
}
