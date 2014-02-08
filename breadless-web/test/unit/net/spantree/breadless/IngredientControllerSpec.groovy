package net.spantree.breadless

import grails.converters.JSON
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(IngredientController)
@Mock([Ingredient])
class IngredientControllerSpec extends Specification {

    def setup(){

        def pepperoni = new Ingredient(name:"Pepperoni",type:IngredientType.MEAT).save()
        def gouda = new Ingredient(name:"Gouda", type:IngredientType.CHEESE).save()
        def cucumber = new Ingredient(name:"Cucumber", type:IngredientType.VEGGIES).save()
        def garlicAioli = new Ingredient(name:"Garlic Aioli", type:IngredientType.CONDIMENTS).save()

        controller.request.addHeader("Accept", "application/json")
        controller.response.format = 'json'
    }

   def "Should show pepperoni as a meat"(){
        when: "read the ingredients list"
        controller.list()
        def res = controller.response.contentAsString
        def jsonOutput = JSON.parse(res)

        then: "It should contain them in the correct format"
        jsonOutput
        jsonOutput.size() == 4
        //MEAT
        when: "We look at the meat list"
        def meatJson= jsonOutput.meat

       then: "it should exist and have a size of one"
       meatJson.size() == 1

       when: "we get the element in meatJson"
       def ingredient = meatJson[0]

       then: "the ingredient should be pepperoni"
       ingredient == "Pepperoni"
        //CHEESE
        when: "we look at the cheese list"
       def cheeseJson = jsonOutput.cheese

       then: "it should exist and have a size of one"
       cheeseJson.size() == 1

       when: "we get the element in cheeseJson"
       def ingredientCheese = cheeseJson[0]

       then: "the ingredient should be gouda"
       ingredientCheese == "Gouda"
        //VEGGIES
       when: "we look at the veggies list"
       def veggieJson = jsonOutput.veggies

       then: "it should exist and have a size of one"
       veggieJson.size()==1

       when: "we get the element in veggieJson"
       def ingredientVeg = veggieJson[0]

       then: "the ingredient should be cucumber"
       ingredientVeg == "Cucumber"
       // CONDIMENTS
       when: "we look at the condiments list"
       def condJson = jsonOutput.condiments

       then: "it should exist and have a size of one"
       condJson.size() == 1

       when: "we get the element in condJson"
       def ingredientCond = condJson[0]

       then: "the ingredient should be garlic aioli"
       ingredientCond == "Garlic Aioli"

    }
}
