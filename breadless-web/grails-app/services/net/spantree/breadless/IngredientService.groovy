package net.spantree.breadless

import grails.converters.JSON
import net.spantree.breadless.Ingredient
import net.spantree.breadless.IngredientType

class IngredientService {
    def formatIngredients(Collection<Ingredient> ingredients) {
        return ingredients.collect {
            [
                name:it.name,
                type:it.ingredientType.name()
            ]
        }
    }
}
