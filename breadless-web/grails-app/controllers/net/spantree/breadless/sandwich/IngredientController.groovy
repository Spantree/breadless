package net.spantree.breadless.sandwich

import grails.converters.JSON
import net.spantree.breadless.Ingredient

class IngredientController {

    def list = {
        render Ingredient.all.collect {  Ingredient ingredient ->
            [
                name: ingredient.name,
                type: ingredient.ingredientType.name(),
            ]
        } as JSON
    }
}
