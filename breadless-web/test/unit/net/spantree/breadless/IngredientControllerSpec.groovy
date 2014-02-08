package net.spantree.breadless

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(IngredientController)
@Mock([Ingredient])
class IngredientControllerSpec extends Specification {

    def setup(){

      //  front = new Location(event: event, name: "Front", type: LocationType.Room).save()
      // back = new Location(event: event, name: "Back", type: LocationType.Panel).save()

        pepperoni = new Ingredient(name:"Pepperoni",type:IngredientType.MEAT).save()

        controller.request.addHeader("Accept", "application/json")
        controller.response.format = 'json'
    }

// //   def "Should show pepperoni as a meat"(){
//        when: "read the ingredients list"
//        controller.list()
//        def res = controller.response.contentAsString
//        def jsonOutput = JSON.parse(res)
//
//        then: "It should contain them in the correct format"
//        jsonOutput
//        jsonOutput.size() == 4
//
//        when: "We look at the meat list"
//        def yesJson
//        if (jsonOutput[0].preference == "YES") {
//            yesJson = jsonOutput[0]
//        } else {
//            yesJson = jsonOutput[1]
//        }
//
//        then: "They should have the appropriate json"
//        yesJson.id == .id.toString()
//        yesJson.name == front.name
//
//    }

}
