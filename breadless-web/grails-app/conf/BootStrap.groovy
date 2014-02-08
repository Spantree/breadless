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

        def turkey = Ingredient.findByName("Turkey") ?: new Ingredient(name: "Turkey", type: IngredientType.MEAT).save()
        def ham = Ingredient.findByName("Turkey") ?:new Ingredient(name: "Ham", type: IngredientType.MEAT).save()
        def bologna = Ingredient.findByName("Turkey") ?:new Ingredient(name: "Bologna", type: IngredientType.MEAT).save()
        def americanCheese = Ingredient.findByName("Turkey") ?:new Ingredient(name: "American Cheese", type: IngredientType.MEAT).save()
        def pickles = Ingredient.findByName("Turkey") ?:new Ingredient(name: "Pickles", type: IngredientType.MEAT).save()
        def lettuce = Ingredient.findByName("Turkey") ?:new Ingredient(name: "Lettuce", type: IngredientType.MEAT).save()
        def tomatoes =Ingredient.findByName("Turkey") ?: new Ingredient(name: "Tomatoes", type: IngredientType.MEAT).save()
        def onions = Ingredient.findByName("Turkey") ?:new Ingredient(name: "Onions", type: IngredientType.MEAT).save()
        def provolone = Ingredient.findByName("Turkey") ?:new Ingredient(name: "Provolone", type: IngredientType.MEAT).save()
        def mayonnaise = Ingredient.findByName("Turkey") ?:new Ingredient(name: "Mayonnaise", type: IngredientType.MEAT).save()
        def mustard = Ingredient.findByName("Turkey") ?:new Ingredient(name: "Mustard", type: IngredientType.MEAT).save()

        def originalComp = new Competition(name: "Original").save()

    }
    def destroy = {
    }
}
