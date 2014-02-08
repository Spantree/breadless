modules = {
    jquery {
        resource url: 'js/jquery-2.1.0.js'
    }
    bootstrap {
        dependsOn 'jquery'
        resource url: 'css/bootstrap.css'
        resource url: 'css/bootstrap-theme.css'
        resource url: 'js/bootstrap.js'
    }
    application {
         dependsOn 'bootstrap'
         resource url: 'css/main.css'
    }
}