def call() {
    node {

        sh 'env'
        common.codeQuality()

        if ( BRANCH_NAME == "main" || tag ==~ "*" ) {
            stage('Style Checks') {
                echo 'Style Checks'
            }
        }
    }
}
