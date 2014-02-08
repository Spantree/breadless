package net.spantree.breadless

import grails.converters.JSON

class IngredientController {

    def list = {
        def json = [:]
        json << [meat: Ingredient.findAllByType(IngredientType.MEAT).collect{ it.name }]
        json << [cheese: Ingredient.findAllByType(IngredientType.CHEESE).collect{ it.name }]
        json << [veggies: Ingredient.findAllByType(IngredientType.VEGGIES).collect{ it.name }]
        json << [condiments: Ingredient.findAllByType(IngredientType.CONDIMENTS).collect{ it.name }]

        render json as JSON
    }
}
