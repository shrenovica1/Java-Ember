import Ember from 'ember';
import RSVP from 'rsvp';
const {
    inject: {
      service
    }
  } = Ember;


export default Ember.Route.extend({
	
restaurantService: service('restaurant-service'),
	  ajax: Ember.inject.service(),
	  self: this,
	  listOfCities: null,

	  
  model() {   

  	 return RSVP.hash({
  	 	 locations:  this.get('restaurantService').getLocations()
                                        .then(data => {
                                            return data.city;
                                        })              
                                        .catch(error => {
                                            return null;
                                        }),
         restaurants: this.get('restaurantService').getRestaurants()
                                        .then(data => {
                                            return data.restaurants.slice(0,7);
                                        })              
                                        .catch(error => {
                                            return null;
                                        }),


  	 });
  
 },

 
});
	


