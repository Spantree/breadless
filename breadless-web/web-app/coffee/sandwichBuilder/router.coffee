@RedParrot.module "SandwichBuilder", (SandwichBuilder, App, Backbone, Marionette, $, _) ->
  @startWithParent = false

  class SandwichBuilder.Router extends Marionette.AppRouter
    appRoutes:
      "sandwich/:id" : "show"

  API =
    show: ->
      console.log "show"

  SandwichBuilder.on "start", ->
    new SandwichBuilder.Router
      controller: API
