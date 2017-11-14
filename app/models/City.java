package models;
import play.data.Form;
import play.data.FormFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jpa.HibernateEntityManager;
import play.db.jpa.JPA;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
import  javax.persistence.*;
import play.data.Form.*;
import play.db.jpa.JPAApi;


@Entity
@Table(name="\"city\"")
public class City {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private  UUID id;

    @Column(name = "name")
    private String name;

    public Country getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Country country_id) {
        this.country_id = country_id;
    }

    @ManyToOne
    @JoinColumn(name="country", foreignKey=@ForeignKey(name ="country_id"))
    private Country country_id;


    public UUID getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public City(String name, Country country){
        this.name=name;
        this.country_id=country;
    }
}
