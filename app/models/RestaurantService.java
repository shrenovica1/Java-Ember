package models;
import  javax.inject.Inject;
import javax.inject.Singleton;
import  models.Restoran;
import  models.RestaurantRepository;
import java.util.List;
import java.util.UUID;


@Singleton
public  class RestaurantService {

    @Inject
    private RestaurantRepository restaurantRepository;

    @Inject
    public RestaurantRepository getRestaurantRepository() {
        return restaurantRepository;
    }

    /* public Restoran create(Restoran restaurant){

         return restaurantRepository.create(restaurant);
     }*/
    public List<Object[]> getAllRestaurants() {
        //  System.out.println( user.getId());
        return restaurantRepository.getAllRestaurants();
    }
    public List<Object[]>getRestaurantMenu(String id){
        return restaurantRepository.getRestaurantMenu(id);
    }
    public List<Object[]>getTables(String restaurant, String people, String date, String time){
        return restaurantRepository.getTables(restaurant,people,date, time);
    }
    public List<Object[]> getFromTable(String restaurant, String people){
        return restaurantRepository.getFromTable(restaurant,people);
    }
    public List<String>getPhotos(String restaurant){
        return restaurantRepository.getPhotos(restaurant);
    }

}
