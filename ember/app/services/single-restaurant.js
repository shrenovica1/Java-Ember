import CustomAjax from './ajax';

export default CustomAjax.extend({
  ajax: Ember.inject.service(),
   
init() {
    this._super(...arguments);
  },
  restaurant: null,
   breakfastMenu: null,
   lunchMenu: null,
   dinnerMenu: null,
   tables: null,
   available: null,
   self: this,
   photos:null,
  setCurrentRestaurant(restaurant){
  	this.set('restaurant', restaurant);
  	this.restaurant=restaurant;

  },

  getCurrentRestaurant(){
  //	alert(this.restaurant);
  	return Promise.resolve(this.restaurant);
  
  },
  setBreakfastMenu(menu){
  	this.set('breakfastMenu',menu);
  	this.breakfastMenu=menu;
  },
  getBreakfastMenu(){
  //	alert(this.breakfastMenu);
  	return Promise.resolve(this.breakfastMenu);
  },
  setLunchMenu(menu){
    this.set('lunchMenu',menu);
    this.lunchMenu=menu;
  },
  getLunchMenu(){
   // alert(this.lunchMenu);
    return Promise.resolve(this.lunchMenu);
  },
  setDinnerMenu(menu){
    this.set('dinnerMenu',menu);
    this.dinnerMenu=menu;
  },
  getDinnerMenu(){
    //alert(this.dinnerMenu);
    return Promise.resolve(this.dinnerMenu);
  },
  setPhotos(photos){
    this.set('photos',photos);
    this.photos=photos;
  },
  getPhotos(){
    return Promise.resolve(this.photos);
  },
  getTables(){
   // alert("gettingtables"+this.tables);
    return Promise.resolve(this.tables);
  },
  setTables(tables){
    this.set('tables', tables); 
    //alert("tablessetto:"+tables);
    this.tables=tables;
  },
  getAvailableTables(){
    return new Promise((resolve,reject)=>{
       this.get('ajax').post('/findTable', {
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

                              })
                            })
        .then(data =>{
            resolve(data);
        })
        .catch(error =>{
            this.set('errorMessage',error);
            reject(error);
        })
    })

}
 
  });