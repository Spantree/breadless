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
        dependsOn "backbonejs, marionettejs, handlebars_runtime"
        resource url: 'coffee/app.coffee'
    }

    sandwichBuilderApp {
        dependsOn "baseApp"

        resource url: 'coffee/sandwichBuilder/router.coffee'
        resource url: 'coffee/sandwichBuilder/controllers/SandwichBuilderController.coffee'

        resource url: 'coffee/sandwichBuilder/models/SandwichIngredientsCollection.coffee'
        resource url: 'coffee/sandwichBuilder/models/SandwichModel.coffee'
        resource url: 'coffee/sandwichBuilder/views/SandwichBuilderView.coffee'
        resource url: 'templates/sandwichBuilder/sandwichBuilder.handlebars'
        resource url: 'css/sandwichBuilder/sandwichBuilder.css'
    }

    sandwichListerApp {
        dependsOn "baseApp"

        resource url: 'coffee/sandwichLister/router.coffee'
        resource url: 'coffee/sandwichLister/controllers/SandwichListController.coffee'
        resource url: 'coffee/sandwichLister/models/SandwichListModel.coffee'

    }

    sandwichVoterApp {
        depends on "baseApp"

        resource url: 'coffee/sandwichVoter/'
    }

    application {
         dependsOn 'bootstrap'
         resource url: 'css/main.css'
    }
}