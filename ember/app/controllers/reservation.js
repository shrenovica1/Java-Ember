import Ember from 'ember';


export default Ember.Controller.extend({
    ajax: Ember.inject.service(),
    actions:{
        onCompleteReservation(user,available,details){
            var response = this.get('ajax').post('/makeReservation', {
                contentType: 'application/json',
                dataType: 'json',
                xhrFields: {
                withCredentials: true
                 },
                data: JSON.stringify({
                                    tableId: available.tableId,
                                    userId: user,
                                    reservationTime: details.date+" "+available.time+":00",
                                    startTime: details.date+" "+available.time+":00",
                                    isConfirmed: true
                                    }),
                success : function (odg) {
               
              }
              });
                 response.then( () => {
                
                    },
                 (error) => {
              
              }
            );
        }
    }
});
