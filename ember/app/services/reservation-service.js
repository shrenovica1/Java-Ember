import Ember from 'ember';

export default Ember.Service.extend({
restaurant:null,
details: null,
available: null,
    setCurrentRestaurant(restaurant){
        this.set('restaurant', restaurant);
        this.restaurant=restaurant;
  
    },
  
    getCurrentRestaurant(){
        return Promise.resolve(this.restaurant);
    },
    setReservationDetails(details){
        this.set('details', details);
        this.details=details;
    },
    getReservationDetails(){
        return Promise.resolve(this.details);
    },
    setReservationAvailableTables(available){
        this.set('available', available);
        this.available=available;
    },
    getReservationAvailableTables(){
        return Promise.resolve(this.available);
    },


});
