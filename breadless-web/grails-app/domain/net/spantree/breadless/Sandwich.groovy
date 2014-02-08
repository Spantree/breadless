package net.spantree.breadless

class Sandwich {

    User creator
    Competition competition
    Set<Ingredient> ingredients

    static hasMany = [ingredients: Ingredient]
}
