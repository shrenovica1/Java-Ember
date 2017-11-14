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
import models.CityService;
import models.City;
import org.hibernate.cfg.Configuration;
import play.libs.Json;
import java.util.List;
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

public class CityRepository{

    @Transactional
    public List<String> getAllCities(){
        String hql = "select name from City";
        Query query = JPA.em().createQuery(hql);
        List<String> list=query.getResultList();
        System.out.println(list.get(0));

        return list;
    }
}


