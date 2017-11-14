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
import models.ReservationService;
import models.Reservation;
import org.hibernate.cfg.Configuration;
import play.libs.Json;
import java.util.List;
import play.data.FormFactory;
import models.Restoran;
import models.Login;
import java.util.UUID;
import play.data.*;
import javax.validation.Validator;
import org.hibernate.jpa.HibernateEntityManager;
import models.HibernateUtil;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;

public class ReservationRepository{

    @Transactional
    public Reservation makeReservation(Reservation reservation){
        JPA.em().persist(reservation);
        JPA.em().flush();
        return reservation;

    }
}


