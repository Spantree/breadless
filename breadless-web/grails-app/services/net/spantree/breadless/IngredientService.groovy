package net.spantree.breadless

import net.spantree.breadless.Ingredient
import net.spantree.breadless.IngredientType

class IngredientService {
    def formatIngredients(Collection<Ingredient> ingredients) {
        def json = [:]
        def meats = ingredients.findAll { Ingredient ingredient -> ingredient.type == IngredientType.MEAT }
        def cheeses = ingredients.findAll { Ingredient ingredient -> ingredient.type == IngredientType.CHEESE }
        def veggies = ingredients.findAll { Ingredient ingredient -> ingredient.type == IngredientType.VEGGIES }
        def condiments = ingredients.findAll { Ingredient ingredient -> ingredient.type == IngredientType.CONDIMENTS }
        json << [meat: meats.collect { it.name }]
        json << [cheese: cheeses.collect { it.name }]
        json << [veggies: veggies.collect { it.name }]
        json << [condiments: condiments.collect { it.name }]
        return json
    }
}
