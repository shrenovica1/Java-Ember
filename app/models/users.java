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
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


@Entity
@Table(name="\"users\"")
public class users {

   // EntityManagerFactory emfdb = Persistence.createEntityManagerFactory("defaultPersistenceUnit");

    //Form<users> USERS_FORM = formFactory.form(users.class);
    //public static final Form<users>USERS_FORM = FormFactory.form(users.class);
    @Id
    @GeneratedValue
    @Column(name = "id")
    private  UUID id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "city")
    private String city;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "country")
    private String country;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "passwor")
    private String passwor;

    @Column(name = "is_admin")
    private Boolean isAdmin;

    public users() { }


    public users(String firstName, String lastName, String email, String password, String phone, String city, String country) {
        this.firstname = firstName;
        this.lastname=lastName;
        this.email = email;
        this.country=country;
        this.city=city;
        this.phone=phone;
        this.passwor=password;
       // this.setPassword(password);

    }
    public users(String id) {
        this.id= UUID.fromString(id);
        this.firstname = null;
        this.lastname=null;
        this.email = null;
        this.country=null;
        this.city=null;
        this.phone=null;
        this.passwor=null;
        // this.setPassword(password);

    }


    public UUID getId() { return id; }

    public void setId(UUID id) { this.id = id; }


    public String getFirstname() { return firstname; }


    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }


    public void setLastname(String lastname) { this.lastname = lastname; }



    public String getCity() { return city; }


    public void setCity(String city) { this.city = city; }


    public String getPhone() { return phone; }


    public void setPhone(String phone) { this.phone = phone; }


    public String getEmail() { return email; }


    public void setEmail(String email) { this.email = email; }


    public void setPasswor(String password) {
        //this.salt = base64Encode(Passwords.getNextSalt());
        //this.paswor = base64Encode(Passwords.hash(password.toCharArray(), base64Decode(this.salt)));
        this.passwor=password;
    }
    public String getPasswor(){
        return passwor;
    }

    /*private String base64Encode(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    private byte[] base64Decode(String string) {
        return Base64.getDecoder().decode(string);
    }
*/

    public Boolean getIsAdmin() { return isAdmin; }


    public void setIsAdmin(Boolean admin) { isAdmin = admin; }
}
