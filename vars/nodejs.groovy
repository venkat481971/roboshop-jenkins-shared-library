def call() {
    node {

        sh 'env'
        common.codeQuality()
    }
}
