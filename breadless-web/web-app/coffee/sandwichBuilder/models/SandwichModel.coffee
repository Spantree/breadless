@Breadless.module "SandwichBuilder.Main", (Main, App, Backbone, Marionette, $, _) ->

  class Main.SandwichModel extends Backbone.Model
    urlRoot: '/sandwich',
    defaults:
      creator: ''
      msg: ''
      ingredients: {}