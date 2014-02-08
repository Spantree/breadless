@Breadless = do(Backbone, Marionette) ->

  App = new Marionette.Application
  App.appModule = window.appModule


  App.addRegions
    mainRegion: '#main-region'

  App.addInitializer ->
    if App.appModule
        App.module(App.appModule).start()

  App.on "initialize:after", ->
    @startHistory()
    #@navigate(@rootRoute, trigger: true) unless @getCurrentRoute()

  App