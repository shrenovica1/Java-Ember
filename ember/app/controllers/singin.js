import Ember from 'ember';

  const {
    inject: {
      service
    }
  } = Ember;



export default Ember.Controller.extend({

 ajax: Ember.inject.service(),
 session: Ember.inject.service('login'),

	actions:{
   // var token=null;
    
             login() {
              var token="";
      var response = this.get('ajax').post('/singin', {
          contentType: 'application/json',
          dataType: 'json',
        xhrFields: {
          withCredentials: true
        },
        data: JSON.stringify({email: this.get('email'), 
                              password: this.get('password')}),
        success : function (odg) {
          token=odg.token;
         
        
        }
        


      });
  
      response.then( () => {
        this.get('session').setToken(token);
        //alert( this.get('session').setToken(token))
         
        this.transitionToRoute('home')},
         (error) => {
          alert("Invalid username or password");
           //alert("The server says: " + odg.token);
        
        }
         
        
      );
    },
  
  }


});
