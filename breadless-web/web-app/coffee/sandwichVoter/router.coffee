@Breadless.module "SandwichVoter", (SandwichVoter, App, Backbone, Marionette, $, _) ->
  @startWithParent = false

  class SandwichVoter.Router extends Marionette.AppRouter
    appRoutes:
      "sandwich/vote/:compName" : "show"
      "sandwich/vote/" : "show"

  API =
    show: (id)->
      console.log "show #{id}"



  SandwichVoter.on "start", ->
    console.log "I'm right after SandwichVoter.on start"
    new SandwichVoter.Router
      controller: API