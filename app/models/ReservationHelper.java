package models;
import java.util.UUID;
import models.users;
import models.Restoran;
import models.RestaurantTable;

import javax.persistence.*;
import java.sql.Timestamp;



public class ReservationHelper {

    @GeneratedValue
    private UUID id;

    private String tableId;

    private String userId;

    private String reservationTime;

    private String startTime;

    private Boolean isConfirmed;

    public ReservationHelper(String tableId, String userId, String reservationTime, String startTime, String isConfirmed) {
        this.tableId = tableId;
        this.userId = userId;
        this.reservationTime = reservationTime;
        this.startTime = startTime;
        this.isConfirmed = Boolean.valueOf(isConfirmed);
    }

    public ReservationHelper() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(String reservationTime) {
        this.reservationTime = reservationTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Boolean getConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        isConfirmed = confirmed;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}