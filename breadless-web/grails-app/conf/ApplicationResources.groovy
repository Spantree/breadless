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

    backbonejs {
        dependsOn "jquery, underscore"
        resource url: 'js/libs/backbone.marionette/backbone.js'
    }

    marionettejs {
        dependsOn 'backbonejs'
        resource url: 'js/libs/backbone.marionette/backbone.marionette.js'
        resource url: 'js/libs/backbone.marionette/backbone.babysitter.js'
        resource url: 'js/libs/backbone.marionette/backbone.wreqr.js'
    }

    baseApp {
        dependsOn "backbonejs, underscorestring, marionettejs"
        resource url: 'coffee/app.coffee'
    }

    sandwichBuilderApp {
        dependsOn "baseApp"

        resource url: 'coffee/sandwichBuilder/router.coffee'
    }

    application {
         dependsOn 'bootstrap'
         resource url: 'css/main.css'
    }
}