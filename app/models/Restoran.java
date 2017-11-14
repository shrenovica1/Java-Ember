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
import java.util.stream.Collectors;
import java.util.UUID;
import java.lang.Object;
import javax.persistence.EntityManager;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.Constraint;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import play.data.Form.*;
import play.db.jpa.JPAApi;
import models.Review;
import models.Photo;
import models.Menu;

@Entity
@Table(name="\"restaurant\"")
public class Restoran {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private  UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "description")
    private String description;

    @Column(name = "priceRange")
    private Double priceRange;

    @Column(name = "rating")
    private Double rating;

    @OneToMany(mappedBy = "restaurant")
    private List<Review> Reviews = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant")
    private List<Menu> Menu = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant")
    private List<Photo> photos;

    @Column(name = "profileImageFile")
    private String imageFile;

    public String getDescription() {
        return description;
    }
    @Column(name = "openTime")
    private String openTime;

    @Column(name = "closeTime")
    private String closeTime;

    @Column(name = "phone")
    private String phone;

    @Column(name = "coverFile")
    private String coverFile;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "latitude")
    private Double latitude;

    @ManyToOne
    @JoinColumn(name = "city",
            foreignKey = @ForeignKey(name = "restaurant_city")
    )
    private City location;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "restaurant_cousine",
            joinColumns = @JoinColumn(name = "restaurant"),
            inverseJoinColumns = @JoinColumn(name = "cousine"))
    private List<Cousine> Cousine = new ArrayList<>();

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

   public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(Double priceRange) {
        this.priceRange = priceRange;
    }

    public List<Review> getReviews() {
        return Reviews;
    }

    public void setReviews(List<Review> reviews) {
        Reviews = reviews;
    }

    public List<Menu> getMenu() {
        return Menu;
    }

    public void setMenu(List<Menu> menu) {
        Menu = menu;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    public String getCoverFile() {
        return coverFile;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setCoverFile(String coverFile) {
        this.coverFile = coverFile;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public City getLocation() {
        return location;
    }

    public void setLocation(City location) {
        this.location = location;
    }

    public List<Cousine> getCousine() {
        return Cousine;
    }

    public void setCousine(List<Cousine> cousine) {
        Cousine = cousine;
    }


    public UUID getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Restoran(String name, String address, String description, Double priceRange, Double rating, String imageFile, String openTime, String closeTime, String phone, String coverFile, Double longitude, Double latitude) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.priceRange = priceRange;
        this.rating = rating;
        this.imageFile = imageFile;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.phone = phone;
        this.coverFile = coverFile;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Restoran(){}

}
