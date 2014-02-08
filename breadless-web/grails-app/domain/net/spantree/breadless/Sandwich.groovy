package net.spantree.breadless

class Sandwich {

    User creator
    List<Ingredient> ingredients

    static hasMany = [ingredients: Ingredient]
}
