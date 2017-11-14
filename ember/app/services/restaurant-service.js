
import CustomAjax from './ajax';

export default CustomAjax.extend({
   
   
    getLocations() {
        return new Promise((resolve, reject) => {
            this.request('/location')
                .then(data => {
                    resolve(data);
                })
                .catch(error => {
                    this.set('errorMessage', error);
                    reject(error);
                });
        });
    },

     getRestaurants() {
        return new Promise((resolve, reject) => {
            this.request('/restaurants')
                .then(data => {
                    resolve(data);
                })
                .catch(error => {
                    this.set('errorMessage', error);
                    reject(error);
                });
        });
    },

    getSingleRestaurant(){
        return new Promise((resolve,reject)=>{
            this.request('/singleRestaurant')
            .then(data =>{
                resolve(data);
            })
            .catch(error =>{
                this.set('errorMessage',error);
                reject(error);
            });
        });

    }
  
    
  });