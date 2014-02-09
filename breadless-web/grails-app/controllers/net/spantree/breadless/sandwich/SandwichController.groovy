package net.spantree.breadless.sandwich

import grails.converters.JSON
import grails.plugins.springsecurity.SpringSecurityService
import net.spantree.breadless.Competition
import net.spantree.breadless.Entry
import net.spantree.breadless.Ingredient
import net.spantree.breadless.Sandwich

class SandwichController {
    def ingredientService
    SpringSecurityService springSecurityService

    def show = {

        withFormat {
            html {
               render view: "edit", model: [
                   id: params.id
               ]
            }

            json {
                def id = params.id as Integer
                def sandwich = Sandwich.get(id)
                def json = [:]
                if (!sandwich) {
                    json = [msg: 'Sandwich not found']
                } else {
                    json << [
                            name: sandwich.name,
                            creator: [id: sandwich.creator.id, username: sandwich.creator.username],
                            ingredients: ingredientService.formatIngredients(sandwich.ingredients)
                    ]
                    //json << [ingredients: ingredientService.formatIngredients(sandwich.ingredients)]
                }
                render json as JSON
            }
        }
    }

    def submit = {
        def competition = Competition.findByName("Original") // Competition.findById(params.id)
        def json = request.JSON
        def name = json.name
        def creator = springSecurityService.currentUser
        def ingredientNames = json.ingredients
        def ingredients = ingredientNames.collect {
            Ingredient.findByName(it.name)
        }

        Sandwich sandwich
        if(json.id) {
           sandwich = Sandwich.get(json.id as Integer)
        }
        else {
            sandwich = new Sandwich()
        }

        sandwich.name = name?: ''
        sandwich.creator = creator
        sandwich.ingredients = ingredients?:[]

        sandwich.save()

        new Entry(competition: competition, sandwich: sandwich).save()
        def result = [message: "Saved sandwich with id ${sandwich.id}"]
        render result as JSON
    }
}