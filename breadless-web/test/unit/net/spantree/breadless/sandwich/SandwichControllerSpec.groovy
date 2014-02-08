package net.spantree.breadless.sandwich

import grails.converters.JSON
import grails.plugins.springsecurity.SpringSecurityService
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.domain.DomainClassUnitTestMixin
import net.spantree.breadless.Ingredient
import net.spantree.breadless.IngredientService
import net.spantree.breadless.IngredientType
import net.spantree.breadless.Sandwich
import net.spantree.breadless.User
import spock.lang.Specification

@TestFor(SandwichController)
@Mock([Sandwich, User, Ingredient])
class SandwichControllerSpec extends Specification {

    def setup() {
        User.metaClass.encodePassword = { -> }

        def malynda = new User(username: "Malynda", password: "hi").save()

        def pepperoni = new Ingredient(name: "Pepperoni", type: IngredientType.MEAT).save()
        def gouda = new Ingredient(name: "Gouda", type: IngredientType.CHEESE).save()
        def pAndG = new Sandwich(creator: malynda, ingredients: [pepperoni, gouda]).save(flush: true)
        //  def cucumber = new Ingredient(name:"Cucumber", type:IngredientType.VEGGIES).save()
        //  def garlicAioli = new Ingredient(name:"Garlic Aioli", type:IngredientType.CONDIMENTS).save()

        controller.request.addHeader("Accept", "application/json")
        controller.response.format = 'json'
        params.id = pAndG.id

        controller.ingredientService= new IngredientService()
    }

    def "Should show sandwiches in the list"() {
        when: "read the sandwich list"
        controller.show()
        def res = controller.response.contentAsString
        def jsonOutput = JSON.parse(res)

        then: "It should contain them in the correct format"
        jsonOutput
        jsonOutput.size() == 2
        //CREATOR
        when: "We look at the creator list"
        def creatorJson = jsonOutput.creator
//
        then: "it should exist and have a size of one"
        creatorJson.size() == 2
        creatorJson.username == "Malynda"

        //INGREDIENTS
        when: "We look at the ingredients list"
        def ingredJson = jsonOutput.ingredients

        then: "the list should have a size of one"
        ingredJson.size() == 4
        ingredJson.meat[0] == "Pepperoni"
        ingredJson.cheese[0] == "Gouda"

    }


}
