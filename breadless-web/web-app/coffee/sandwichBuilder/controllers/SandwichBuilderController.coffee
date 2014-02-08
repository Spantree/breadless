@Breadless.module "SandwichBuilder.Main", (Main, App, Backbone, Marionette, $, _) ->

  class Main.Controller extends Marionette.Controller
    initialize: (options) ->
      @region = options.region

      if options.id?
        @model = new Main.SandwichModel(options.id)
        @model.fetch()
      else
        @model = new Main.SandwichModel(options.id)

      @view = new Main.SandwichBuilderView
        model: @model

      @region.show @view