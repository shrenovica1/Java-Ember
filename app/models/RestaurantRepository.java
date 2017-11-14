package models;
import play.db.jpa.JPA;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import javax.inject.*;
import javax.persistence.*;
import java.util.concurrent.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import models.RestaurantService;
import models.Restoran;
import org.hibernate.cfg.Configuration;
import play.libs.Json;
import java.util.List;
import java.util.ArrayList;
import play.data.FormFactory;
import models.Restoran;
import models.Login;
import java.util.UUID;
import play.data.*;
import javax.validation.Validator;
//import org.hibernate.Query;
import org.hibernate.jpa.HibernateEntityManager;
import models.HibernateUtil;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;

public class RestaurantRepository{

    @Transactional
    public List<Object[]> getAllRestaurants(){
        String hql = "select r from Restoran r";
        Query query = JPA.em().createQuery("select id,name, address,description, priceRange ,rating,imageFile,openTime,closeTime,phone,coverFile,longitude,latitude from Restoran");
        List<Object[]> list=query.getResultList();
        // Restoran r= list.get(0);
         for(Object[] r: list)
        System.out.println(r[7]);
        return list;
    }
    @Transactional
    public List<Object[]> getRestaurantMenu(String id){
        String hql="select id,name,type,description,price,restaurant from Menu m where m.restaurant='"+id+"'";
        Query query=JPA.em().createQuery(hql);
        List<Object[]> list=query.getResultList();
        return list;

    }
    @Transactional
    public List<Object[]> getTables(String restaurant, String people, String date, String time){
        String hql="select t.id, r.reservationTime from Reservation r, RestaurantTable t where r.tableId=t.id and t.restaurantId='"+restaurant+"' and r.isConfirmed=true and t.chairs="+people.substring(0, 1)
                +"and r.reservationTime='"+date+" "+time.substring(0,5)+":00'";


        Query query=JPA.em().createQuery(hql);
        List<Object[]> list=query.getResultList();

        return list;
    }
    @Transactional
    public List<Object[]> getFromTable(String id, String people){
        String hql="select rt.id, rt.chairs from RestaurantTable rt where rt.restaurantId='"+id+"' and rt.chairs='"+people.substring(0,1)+"'";
        Query query=JPA.em().createQuery(hql);
        List<Object[]> list=query.getResultList();
      //  System.out.println(list.get(0).toString());
        return list;

    }

    @Transactional
    public List<String> getPhotos(String restaurant){
        String hql="select photoPath from Photo p where p.restaurant='"+restaurant+"'";
        Query query=JPA.em().createQuery(hql);
        List<String> list=query.getResultList();

        return list;

    }
}


