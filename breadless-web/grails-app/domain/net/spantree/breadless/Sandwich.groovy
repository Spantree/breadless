package net.spantree.breadless

class Sandwich {
    String name
    User creator
    List<Ingredient> ingredients

    static hasMany = [ingredients: Ingredient]
}
