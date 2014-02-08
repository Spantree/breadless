package net.spantree.breadless.sandwich

import grails.converters.JSON
import net.spantree.breadless.Competition
import net.spantree.breadless.Entry
import net.spantree.breadless.Ingredient
import net.spantree.breadless.Sandwich

class SandwichController {
    def ingredientService

    def show = {

        withFormat {
            html {
               render view: "edit", model: [
                   id: params.id
               ]
            }

            json {
                def id = params.id
                def sandwich = Sandwich.findById(id)
                def json = [:]
                if (!sandwich) {
                    json = [msg: 'Sandwich not found']
                } else {
                    json << [creator: [id: sandwich.creator.id, username: sandwich.creator.username]]
                    json << [ingredients: ingredientService.formatIngredients(sandwich.ingredients)]
                }
                render json as JSON
            }
        }
    }

    def submit = {
        def competition = Competition.findByName("Original") // Competition.findById(params.id)
        def name = params.name
        def creator = getAuthenticationUser()
        def ingredients = params.ingredients.collect {
            Ingredient.findByName(it)
        }

        def sandwich = new Sandwich(
                name: name,
                creator: creator,
                ingredients: ingredients
        )

        sandwich.save()
        new Entry(competition: competition, sandwich: sandwich).save()
        def json = [message: "Saved sandwich with id ${sandwich.id}"]
        render json as JSON
    }
}