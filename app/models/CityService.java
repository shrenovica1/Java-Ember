package models;
import  javax.inject.Inject;
import javax.inject.Singleton;
import  models.City;
import  models.CityRepository;
import java.util.List;


@Singleton
public  class CityService{

    @Inject
    private CityRepository cityRepository;

    @Inject
    public CityRepository getCityRepository() {
        return cityRepository;
    }

    public List<String> getAllCities(){
      //  System.out.println( user.getId());
        return cityRepository.getAllCities();
    }


}