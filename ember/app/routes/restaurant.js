import Ember from 'ember';
import RSVP from 'rsvp';

const {
    inject: {
      service
    }
  } = Ember;

export default Ember.Route.extend({
	singleRestaurantService: service('single-restaurant'),
   ajax: Ember.inject.service(),
  date:null,
  people: null,
  time: null,
  table: null,
  restaurant:null,
  self: this,

	model(){
		return RSVP.hash({
  	 	 restaurant:  this.get('singleRestaurantService').getCurrentRestaurant()
                                        .then(data => {
                                          this.restaurant=data.id;
                                    
                                            return data;
                                        })              
                                        .catch(error => {
                                            return null;
                                        }),
         breakfast:  this.get('singleRestaurantService').getBreakfastMenu()
                                        .then(data => {
                                          //alert("routesrestaurantjs"+data);
                                            return data;
                                        })              
                                        .catch(error => {
                                            return null;
                                        }),

        lunch:  this.get('singleRestaurantService').getLunchMenu()
                                        .then(data => {
                                        //  alert("routesrestaurantjs"+data);
                                            return data;
                                        })              
                                        .catch(error => {
                                            return null;
                                        }),

        dinner:  this.get('singleRestaurantService').getDinnerMenu()
                                        .then(data => {
                                       //   alert("routesrestaurantjs"+data);
                                            return data;
                                        })              
                                        .catch(error => {
                                            return null;
                                        }),
        photos:  this.get('singleRestaurantService').getPhotos()
                                        .then(data => {
                                    //   alert("routesrestaurantjs"+data);
                                            return data.slice(0,7);;
                                        })              
                                        .catch(error => {
                                            return null;
                                        }),
        tables:    this.get('singleRestaurantService').getTables()
                                        .then(data => {
                                     //  alert("fettablesMODEL"+data.details);
                                            return data;
                                        })              
                                        .catch(error => {
                                            return null;
                                        }),
        

     });
     

	}
	

    

  
});
