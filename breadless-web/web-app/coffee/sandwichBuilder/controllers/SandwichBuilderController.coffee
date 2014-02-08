@Breadless.module "SandwichBuilder.Main", (Main, App, Backbone, Marionette, $, _) ->

  class Main.Controller extends Marionette.Controller
    initialize: (options) ->
      @region = options.region