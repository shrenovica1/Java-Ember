import Ember from 'ember';
import RSVP from 'rsvp';

const {
    inject: {
      service
    }
  } = Ember;

export default Ember.Route.extend({
    reservationService: service('reservation-service'),
    singleRestaurantService: service('single-restaurant'),
    session: Ember.inject.service('login'),
    
    model(){
		return RSVP.hash({
  	 	 restaurant:  this.get('singleRestaurantService').getCurrentRestaurant()
                                        .then(data => {
                                            alert(data);
                                          this.restaurant=data;
                                    
                                            return data;
                                        })              
                                        .catch(error => {
                                            return null;
                                        }),
         details:  this.get('reservationService').getReservationDetails()
                                        .then(data => {
                                            
                                            return data.details;
                                        })              
                                        .catch(error => {
                                            return null;
                                        }),
        available:    this.get('reservationService').getReservationAvailableTables()
                                        .then(data => {
                                       alert("fettablesRSTOUTEMODEL"+data);
                                            return data;
                                        })              
                                        .catch(error => {
                                            return null;
                                        }),
        user:          this.get('session').getToken(),                             
        });
    }
});
