package models;
import  javax.inject.Inject;
import javax.inject.Singleton;
import  models.Reservation;
import  models.ReservationRepository;
import java.util.List;


@Singleton
public  class ReservationService{

    @Inject
    private ReservationRepository reservationRepository;

    @Inject
    public ReservationRepository getReservationRepository() {
        return reservationRepository;
    }

    public Reservation makeReservation(Reservation reservation){

       return reservationRepository.makeReservation(reservation);
    }


}