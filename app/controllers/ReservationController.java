package controllers;
import play.data.Form;
import play.mvc.*;
import play.db.jpa.Transactional;
import views.html.*;
import  javax.inject.Inject;
import javax.inject.Singleton;
import play.db.jpa.JPA;
import  models.Reservation;
import models.ReservationHelper;
import  models.ReservationService;
import play.libs.Json;
import play.data.FormFactory;
import models.Restoran;
import models.RestaurantTable;
import models.users;
import models.Login;
import java.util.UUID;
import play.data.*;
import javax.validation.Validator;
import play.mvc.Controller;
import models.JwtUtility;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import play.libs.Json;
import java.sql.Timestamp;

import java.util.List;


public class ReservationController extends Controller{

    @Inject public FormFactory formFactory;

    @Inject
    public void setFormFactory(FormFactory formFactory) {
        this.formFactory = formFactory;
    }
    private ReservationService reservationService;

    @Inject
    public void setReservationService(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @Transactional
    public Result makeReservation(){

        Form<ReservationHelper> reservationForm = formFactory.form(ReservationHelper.class);
        ReservationHelper reservationHelper = reservationForm.bindFromRequest().get();
        RestaurantTable restaurantTable=new RestaurantTable(reservationHelper.getTableId());
        users User = new users(reservationHelper.getUserId());

        Timestamp reservationTime = Timestamp.valueOf(reservationHelper.getReservationTime());
        Reservation reservation=new Reservation(restaurantTable,User,reservationTime,reservationTime,true);


        if (reservationForm.hasErrors()) {
            return badRequest("form has errors");
        }
        this.reservationService.makeReservation(reservation);

        return ok();
    }

}