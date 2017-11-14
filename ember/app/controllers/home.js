import Ember from 'ember';
import RSVP from 'rsvp';

const {
    inject: {
      service
    }
  } = Ember;

export default Ember.Controller.extend({
  
 ajax: Ember.inject.service(),
 singleRestaurantService: service('single-restaurant'),
  session: Ember.inject.service('login'),
 restaurant: null,
 breakfastMenu: null,
 lunchMenu: null,
 dinnerMenu: null,
 photos:null,
 id: null,
 self: this,
actions:{
  select(restaurant){
      var response = this.get('ajax').post('/singleRestaurant', {
          contentType: 'application/json',
          dataType: "json",
        xhrFields: {
          withCredentials: true
        },
        data: JSON.stringify({
                              id: restaurant.id,
                              name: restaurant.name,
                              address: restaurant.address,
                              description: restaurant.description,
                              pricerange: restaurant.pricerange,
                              rating: restaurant.rating,
                              profileimagefile: restaurant.imageFile,
                              opentime: restaurant.opentime,
                              closetime: restaurant.closetime,
                              phone: restaurant.phone,
                              coverfile: restaurant.coverfile,
                              longitude: restaurant.longitude,
                              latitude: restaurant.latitude


                              }),
         success : function (odg) {
          alert(odg.photos);
          self.restaurant=odg.restaurant;
          self.breakfastMenu=odg.menu.get(0).breakfast;
          self.lunchMenu=odg.menu.get(1).lunch;
          self.dinnerMenu=odg.menu.get(2).dinner;
          self.photos=odg.photos;
          
         }

      });
      response.then( () => {
      this.get('singleRestaurantService').setCurrentRestaurant(self.restaurant);
      this.get('singleRestaurantService').setBreakfastMenu(self.breakfastMenu);
      this.get('singleRestaurantService').setLunchMenu(self.lunchMenu);
      this.get('singleRestaurantService').setDinnerMenu(self.dinnerMenu);
      this.get('singleRestaurantService').setPhotos(self.photos);
      this.transitionToRoute('restaurant')
      },
         (error) => {
          alert("Invalid form");
           
        }
         
        
      );
    
  
  },

}

});
	



