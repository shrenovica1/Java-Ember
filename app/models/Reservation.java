package models;
import java.util.UUID;
import models.users;
import models.Restoran;
import models.RestaurantTable;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table( name = "reservations" )
public class Reservation {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "table_id",
            foreignKey = @ForeignKey(name = "reservations_tableid_fkey")
    )
    private RestaurantTable tableId;



    @ManyToOne
    @JoinColumn(name = "userid",

            foreignKey = @ForeignKey(name = "reservations_userid_fkey")
    )
    private users userId;

    @Column(name = "reservationtime")
    private Timestamp reservationTime;


    @Column(name = "starttime")
    private Timestamp startTime;

    @Column(name = "isconfirmed")
    private Boolean isConfirmed;



    public Reservation() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public RestaurantTable getTableId() {
        return tableId;
    }

    public void setTableId(RestaurantTable idTable) {
        this.tableId = idTable;
    }

    public users getUserId() {
        return userId;
    }

    public void setUserId(users idUser) {
        this.userId = idUser;
    }

    public Timestamp getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(Timestamp reservationTime) {
        this.reservationTime = reservationTime;
    }

    public Boolean getConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        isConfirmed = confirmed;
    }
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Reservation(RestaurantTable tableId, users userId, Timestamp reservationTime, Timestamp startTime, Boolean isConfirmed) {

        this.tableId = tableId;
        this.userId = userId;
        this.reservationTime = reservationTime;
        this.startTime = startTime;
        this.isConfirmed = isConfirmed;
    }
}