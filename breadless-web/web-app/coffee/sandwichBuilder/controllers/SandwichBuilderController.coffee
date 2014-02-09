@Breadless.module "SandwichBuilder.Main", (Main, App, Backbone, Marionette, $, _) ->

  class Main.Controller extends Marionette.Controller
    initialize: (options) ->
      @region = options.region

      ingredients = new Main.SandwichIngredientsCollection()
      ingredients.fetch
        success: ()=>
          if options.id?
            @model = new Main.SandwichModel({"id":options.id})
            @model.fetch()
          else
            @model = new Main.SandwichModel()

          @view = new Main.SandwichBuilderView
            model: @model
            ingredients: ingredients

          @region.show @view