package controllers;
import play.data.Form;
import play.mvc.*;
import play.db.jpa.Transactional;
import views.html.*;
import  javax.inject.Inject;
import javax.inject.Singleton;
import play.db.jpa.JPA;
import models.RestaurantService;
import play.libs.Json;
import play.data.FormFactory;
import models.Restoran;
import models.Login;
import models.SingleRestaurant;
import java.util.UUID;
import play.data.*;
import javax.validation.Validator;
import play.mvc.Controller;
import models.JwtUtility;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import play.libs.Json;
import models.Menu;
import models.TableSearch;
import java.util.List;
import java.util.ArrayList;


public class RestaurantController extends Controller{

    @Inject public FormFactory formFactory;

    @Inject
    public void setFormFactory(FormFactory formFactory) {
        this.formFactory = formFactory;
    }
    private RestaurantService restaurantService;

    @Inject
    public void setRestaurantService(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @Transactional
    public Result getAllRestaurants(){
        List<Object[]> restaurants=  this.restaurantService.getAllRestaurants();

        ArrayNode lista=Json.newArray();

     List<String> restorani= new ArrayList();
       // Restoran rest;
        for(int i=0; i<restaurants.size(); i++){
          //  rest= new Restoran (restaurants.get(i)[1].toString(),restaurants.get(i)[2].toString(),restaurants.get(i)[3].toString(),Double.parseDouble(restaurants.get(i)[4].toString()),Double.parseDouble(restaurants.get(i)[5].toString()),restaurants.get(i)[6].toString(),restaurants.get(i)[7].toString(),restaurants.get(i)[8].toString(),restaurants.get(i)[9].toString(),restaurants.get(i)[10].toString(),Double.parseDouble(restaurants.get(i)[11].toString()),Double.parseDouble(restaurants.get(i)[12].toString()));
            Restoran rest= new Restoran();
            ObjectNode item = Json.newObject();
           rest.setName(restaurants.get(i)[1].toString());
           rest.setDescription(restaurants.get(i)[3].toString());
           rest.setImageFile(restaurants.get(i)[6].toString());
           rest.setLongitude(Double.parseDouble(restaurants.get(i)[11].toString()));
            rest.setLatitude(Double.parseDouble(restaurants.get(i)[12].toString()));
           rest.setId(UUID.fromString(restaurants.get(i)[0].toString()));
           rest.setRating(Double.parseDouble(restaurants.get(i)[5].toString()));
           System.out.println(restaurants.get(i)[1].toString());

           lista.add(Json.toJson(rest));
            System.out.println(lista.get(0).toString());


        }
        ObjectNode restoraniVracam = Json.newObject();
        restoraniVracam.put("restaurants", lista);
        return ok(restoraniVracam);
    }
    @Transactional
    public Result getSingleRestaurant(){
        Form<SingleRestaurant> single = formFactory.form(SingleRestaurant.class);
        SingleRestaurant restaurant = single.bindFromRequest().get();

        if (single.hasErrors()) {
            return badRequest("form has errors");
        }
        System.out.println(restaurant.getId());
        ObjectNode item = Json.newObject();
        ObjectNode breakfastMenu = Json.newObject();
        ObjectNode lunchMenu = Json.newObject();
        ObjectNode dinnerMenu = Json.newObject();
        ArrayNode lista=Json.newArray();
        ArrayNode breakfast=Json.newArray();
        ArrayNode lunch=Json.newArray();
        ArrayNode dinner=Json.newArray();

       item.put("restaurant", Json.toJson(restaurant));

        List<Object[]> menu=  this.restaurantService.getRestaurantMenu(restaurant.getId().toString());
        List<String> photos=  this.restaurantService.getPhotos(restaurant.getId().toString());
        item.put("photos", Json.toJson(photos));
        for(int i=0; i<menu.size(); i++){
            Menu m= new Menu();
            m.setName(menu.get(i)[1].toString());
            m.setType(menu.get(i)[2].toString());
            m.setDescription(menu.get(i)[3].toString());
            m.setPrice(menu.get(i)[4].toString());
            if(menu.get(i)[2].toString().equals("Breakfast")) breakfast.add(Json.toJson(m));
            else if(menu.get(i)[2].toString().equals("Lunch")) lunch.add(Json.toJson(m));
            else dinner.add(Json.toJson(m));

        }

        breakfastMenu.put("breakfast", breakfast);
        lunchMenu.put("lunch", lunch);
        dinnerMenu.put("dinner",dinner);
        lista.add(breakfastMenu);
        lista.add(lunchMenu);
        lista.add(dinnerMenu);
        item.put("menu", lista);
       System.out.println(item.toString());
        return ok(item);
    }
    @Transactional
    public Result getTables(){
        Form<TableSearch> form = formFactory.form(TableSearch.class);
        TableSearch table = form.bindFromRequest().get();
        ArrayNode lista=Json.newArray();
        ObjectNode item= Json.newObject();
        ObjectNode object= Json.newObject();

        if (form.hasErrors()) {
            return badRequest("form has errors");
        }

        Integer availableTime=Integer.parseInt(table.getTime().substring(0,2)+table.getTime().substring(3,5));
        System.out.println(availableTime.toString()+"tabletable");
        String availableTimestring=table.getTime();
        ArrayNode returnList=Json.newArray();
       String finalTable="";

        for(int i=0; i<10;i++) {
            ObjectNode availableItem = Json.newObject();
            List<Object[]> availableTables = this.restaurantService.getTables(table.getRestaurant().toString(), table.getPeople(), table.getDate(), availableTimestring);
            if (availableTables.size() == 0 && i == 0) {

                List<Object[]> tableReservation = this.restaurantService.getFromTable(table.getRestaurant().toString(), table.getPeople());

                finalTable = tableReservation.get(0)[0].toString();

                item.put("available", finalTable);
                break;
            } else {
                if (availableTables.size() == 0 && i!=0) {
                    List<Object[]> tableReservation = this.restaurantService.getFromTable(table.getRestaurant().toString(), table.getPeople());


                        availableItem.put("tableId", tableReservation.get(0)[0].toString());
                        availableItem.put("time", availableTimestring);
                        returnList.add(availableItem);


                }

            }
            if(i==0){
                availableTime-=100;
                String help = availableTime.toString();
                availableTimestring = help.substring(0, 2) + ":" + help.substring(2, 4);
                System.out.println(availableTimestring + "stringstring");
            }
            availableTime += 30;
            //System.out.println((availableTime % 100).toString);
            if (availableTime % 100 == 60) availableTime += 40;
            String help = availableTime.toString();
            availableTimestring = help.substring(0, 2) + ":" + help.substring(2, 4);
            System.out.println(availableTimestring + "stringstring");
        }

        item.put("details", Json.toJson(table));
        item.put("available",returnList);


        return ok(item);

    }
    @Transactional
    public Result ratePlace(){
      //  this.restaurantService.changeRating();
        return ok();
    }

}