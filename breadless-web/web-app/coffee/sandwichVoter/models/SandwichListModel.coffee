@Breadless.module "SandwichVoter.Main", (Main, App, Backbone, Marionette, $, _) ->

  class Main.SandwichModel extends Backbone.Model

  class Main.SandwichCollection extends Backbone.collection
    url: "/sandwich/list"
    model: Main.SandwichModel