import Ember from 'ember';


export default Ember.Controller.extend({

 ajax: Ember.inject.service(),


	actions:{
     
             create() {
      var response = this.get('ajax').post('/singup', {
          contentType: 'application/json',
          dataType: "json",
        xhrFields: {
          withCredentials: true
        },
        data: JSON.stringify({lastname: this.get('lastname'), 
                              firstname: this.get('firstname'),
                             email: this.get('email'), 
                             phone: this.get('phone'),
                             city: document.getElementById("exampleFormControlSelect1").value,
                             country: document.getElementById("exampleFormControlSelect2").value,
                             passwor:this.get('password'),
                             isAdmin: false}),
         success : function (odg) {
            // alert(odg);
         }
      });
       response.then( () => {
       // this.get('session').setToken(token);
         //  
        this.transitionToRoute('home')},
         (error) => {
          alert("Invalid form");
           //alert("The server says: " + odg.token);
        
        }
         
        
      );
    },
  
  }
});
