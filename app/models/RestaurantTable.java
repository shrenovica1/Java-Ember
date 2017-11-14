package models;
import play.data.Form;
import play.data.FormFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jpa.HibernateEntityManager;
import play.db.jpa.JPA;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Base64;
import java.util.UUID;
import java.lang.Object;
import javax.persistence.EntityManager;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.Constraint;
import play.data.Form.*;
import play.db.jpa.JPAApi;
import models.Restoran;


@Entity
@Table(name="\"restaurant_table\"")
public class RestaurantTable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private  UUID id;

    @ManyToOne
    @JoinColumn(name = "restaurantid",
            foreignKey = @ForeignKey(name = "restauranttables_restaurantid_fkey")
    )
    private Restoran restaurantId;

    @Column (name="chairs")
    private Integer chairs;
    public UUID getId() {
        return id;
    }


    public RestaurantTable(){
    }
    public RestaurantTable(String id){
        this.id= UUID.fromString(id);
        this.chairs=null;
        this.restaurantId=null;
    }

    public void setId(UUID id) {
        this.id=id;
    }

    public Integer getChairs(){
        return chairs;
    }
    public void setChairs(Integer chairs){
        this.chairs=chairs;
    }

    public Restoran getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Restoran restaurantId) {
        this.restaurantId = restaurantId;
    }
}