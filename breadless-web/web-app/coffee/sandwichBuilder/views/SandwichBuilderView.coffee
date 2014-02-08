@Breadless.module "SandwichBuilder.Main", (Main, App, Backbone, Marionette, $, _) ->

  class Main.SandwichBuilderView extends Marionette.ItemView
    template: (obj) ->
      Handlebars.templates['templates/sandwichBuilder/sandwichBuilder'](obj)

    events:
        "click #save-sandwich": "save"

    initialize: (options)->
      console.log "view start"

    save: ->
      @model.save({})
      console.log "save"