@Breadless.module "SandwichBuilder.Main", (Main, App, Backbone, Marionette, $, _) ->

  class Main.SandwichBuilderView extends Marionette.ItemView
    template: (obj) ->
      Handlebars.templates['templates/sandwichBuilder/sandwichBuilder'](obj)

    initialize: (options)->
      @model = options.model
      @ingredients = options.ingredients

      @model.on 'change', @render, @

    events:
        "click #save-sandwich": "save"
        "change .ingredient-select": "addIngredient"

    serializeData: ()->
        obj = @model.toJSON()
        obj.possibleIngredients = @ingredients.toJSON()
        obj

    addIngredient: (item)->
      ingredients = @model.get('ingredients')
      ingredients.push { name: item.target.value }
      @model.set('ingredients', ingredients)
      @model.trigger 'change'


    save: ->
      console.log $('#sandwich-name').val()
      @model.set('name', $('#sandwich-name').val())
      @model.save({})