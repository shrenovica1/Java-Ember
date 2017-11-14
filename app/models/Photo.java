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
import play.data.Form.*;
import play.db.jpa.JPAApi;
import javax.persistence.*;
import models.Restoran;

@Entity
@Table(name="\"photo\"")
public class Photo {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private  UUID id;

    @Column(name = "photoPath")
    private String photoPath;

    @ManyToOne
    @JoinColumn(name = "restaurant",
            foreignKey = @ForeignKey(name = "restaurantId")
    )
    private Restoran restaurant;


    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public Photo(String photoPath){
        this.photoPath=photoPath;
    }
}
