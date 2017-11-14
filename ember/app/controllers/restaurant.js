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
 reservationService: service('reservation-service'),
  session: Ember.inject.service('login'),
 restaurant: null,
 available: null,
 table: null,
 details: null,
 lunchMenu: null,
 dinnerMenu: null,
 id: null,
 mark:null,
 //model: null,
 
 self: this,
 
actions:{
    
    breakfast(){
        document.getElementById('breakfast-list').style.display = "block";
         document.getElementById('lunch-list').style.display = "none";
         document.getElementById('dinner-list').style.display = "none";
 
     },
     lunch(){
        document.getElementById('lunch-list').style.display = "block";
        document.getElementById('breakfast-list').style.display = "none";
        document.getElementById('dinner-list').style.display = "none";
 
     },
      dinner(){
        document.getElementById('dinner-list').style.display = "block";
         document.getElementById('breakfast-list').style.display = "none";
          document.getElementById('lunch-list').style.display = "none";
 
     },
  onFind(){

 //   alert( this.get('session').getToken());

      var response = this.get('ajax').post('/findTable', {
          contentType: 'application/json',
          dataType: "json",
        xhrFields: {
          withCredentials: true
        },
        data: JSON.stringify({
            people: document.getElementById("people-select").value,
            time: document.getElementById("time-select").value,
            date: document.getElementById("datepicker").value,
            restaurant: this.get('model.restaurant.id')

                              }),
         success : function (odg) {
         alert(odg.details);
          self.table=odg.details;
          self.available=odg.available.slice(0,4);
          self.details=odg;
         }

      });
      response.then( () => {
      this.set('table',self.table);
      this.set('details',self.details);
      this.set('available',self.available);
       this.get('singleRestaurantService').setTables(self.table);
     
      },
         (error) => {
          alert("Invalid form");
           
        }
      );
  },
    onReserve(table,available){
        this.get('reservationService').setReservationDetails(table);
        this.get('reservationService').setReservationAvailableTables(available);
        this.transitionToRoute('reservation');
    },
    onMark(mark){
        
        

    },
    onRate(){

        if(document.getElementById('star5').checked) {
            self.mark=5;
            
            }else if(document.getElementById('star4').checked) {
            self.mark=4;
            }else if(document.getElementById('star3').checked) {
                self.mark=3;
                }else if(document.getElementById('star2').checked) {
                    self.mark=2;
                    }else if(document.getElementById('star1').checked) {
                        self.mark=1;
                        }
        
       
        var response = this.get('ajax').post('/ratePlace', {
            contentType: 'application/json',
            dataType: 'json',
            xhrFields: {
            withCredentials: true
             },
            data: JSON.stringify({
                                mark: self.mark,
                                comment: document.getElementById('userComment').value,
                                restaurant: this.get('model.restaurant.id')
                                }),
            success : function (odg) {
           
          }
          });
             response.then( () => {
            
                },
             (error) => {
          
          }
        );
    },

    oneStar() {
        this.set('one', true);
        this.set('two', false);
        this.set('three', false);
        this.set('four', false);
        this.set('five', false);
    },
    twoStar() {
        this.set('one', true);
        this.set('two', true);
        this.set('three', false);
        this.set('four', false);
        this.set('five', false);
    },

    threeStar() {
        this.set('one', true);
        this.set('two', true);
        this.set('three', true);
        this.set('four', false);
        this.set('five', false);
    },

    fourStar() {
        this.set('one', true);
        this.set('two', true);
        this.set('three', true);
        this.set('four', true);
        this.set('five', false);
    },

    fiveStar() {
        this.set('one', true);
        this.set('two', true);
        this.set('three', true);
        this.set('four', true);
        this.set('five', true);
    },
}


});
