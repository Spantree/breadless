package net.spantree.breadless

import grails.converters.JSON

class SandwichController {
    def ingredientService

    def show = {
        def id = params.id
        def sandwich = Sandwich.findById(id)
        def json = [:]
        if (!sandwich) {
            json = [msg: 'Sandwich not found']
        } else {
            json << [creator: sandwich.creator]
            json << [ingredients: ingredientService.formatIngredients(sandwich.ingredients)]
        }
        render json as JSON
    }
}