package net.spantree.breadless

class Sandwich {

    User creator
    Set<Ingredient> ingredients

    static hasMany = [ingredients: Ingredient]
}
