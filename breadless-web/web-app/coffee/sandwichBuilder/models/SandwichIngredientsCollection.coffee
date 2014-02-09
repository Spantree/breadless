@Breadless.module "SandwichBuilder.Main", (Main, App, Backbone, Marionette, $, _) ->

  class Main.SandwichIngredientModel extends Backbone.Model

  class Main.SandwichIngredientsCollection extends Backbone.Collection
    url: 'ingredient/list'
    model: Main.SandwichIngredientModel
