import net.spantree.breadless.Competition
import net.spantree.breadless.Ingredient
import net.spantree.breadless.IngredientType
import net.spantree.breadless.Role
import net.spantree.breadless.User
import net.spantree.breadless.UserRole

class BootStrap {
    def springSecurityService

    def init = { servletContext ->

        def userRole = Role.findByAuthority('ROLE_USER') ?: new Role(authority: 'ROLE_USER').save(failOnError: true)
        def adminRole = Role.findByAuthority('ROLE_ADMIN') ?: new Role(authority: 'ROLE_ADMIN').save(failOnError: true)


        def user = User.findByUsername("test") ?: new User(
                username: "test",
                password: "test",
                enabled: true,
                accountExpired: false,
                accountLocked: false,
                passwordExpired: false,
        ).save(flush: true)

        if (!user.authorities.contains(adminRole)) {
            UserRole.create(user, adminRole)
        }
        if (!user.authorities.contains(userRole)) {
            UserRole.create(user, userRole)
        }

        def turkey = Ingredient.findByName("Turkey") ?: new Ingredient(name: "Turkey", ingredientType: IngredientType.MEAT).save()
        def ham = Ingredient.findByName("Ham") ?:new Ingredient(name: "Ham", ingredientType: IngredientType.MEAT).save()
        def bologna = Ingredient.findByName("Bologna") ?:new Ingredient(name: "Bologna", ingredientType: IngredientType.MEAT).save()
        def americanCheese = Ingredient.findByName("American Cheese") ?:new Ingredient(name: "American Cheese", ingredientType: IngredientType.CHEESE).save()
        def pickles = Ingredient.findByName("Pickles") ?:new Ingredient(name: "Pickles", ingredientType: IngredientType.VEGGIES).save()
        def lettuce = Ingredient.findByName("Lettuce") ?:new Ingredient(name: "Lettuce", ingredientType: IngredientType.VEGGIES).save()
        def tomatoes =Ingredient.findByName("Tomatoes") ?: new Ingredient(name: "Tomatoes", ingredientType: IngredientType.VEGGIES).save()
        def onions = Ingredient.findByName("Onions") ?:new Ingredient(name: "Onions", ingredientType: IngredientType.VEGGIES).save()
        def provolone = Ingredient.findByName("Provolone") ?:new Ingredient(name: "Provolone", ingredientType: IngredientType.CHEESE).save()
        def mayonnaise = Ingredient.findByName("Mayonnaise") ?:new Ingredient(name: "Mayonnaise", ingredientType: IngredientType.CONDIMENTS).save()
        def mustard = Ingredient.findByName("Mustard") ?:new Ingredient(name: "Mustard", ingredientType: IngredientType.CONDIMENTS).save()

        def originalComp = new Competition(name: "Original").save()

    }
    def destroy = {
    }
}
