import CustomAjax from './ajax';

export default CustomAjax.extend({
    
    currentUser: null,
    isLogged: false,
    token: null,
    errorMessage: "",



    setToken(token){
    	//this.set('currentUser', email);
    	this.set('isLogged', true);
    	this.set('token', token);

    },
    getToken(){
        return this.get('token');
    },

   /*   login(email, password,token) {
        return new Promise((resolve, reject) => {
            this.post('/singin', {
                xhrFields: {
                    withCredentials: true,
                  },
                data: {
                    email: email,
                    password: password
                }
            }).then(data => {
                this.set('currentUser', data);
                this.set('isLogged', true);
                resolve(data);
            })
            .catch(error => {
                this.set('currentUser', null);
                this.set('isLogged', false);
                reject(error);
            })
        })
    },*/

    getIsLogged() {
        return this.get('isLogged');
    }  
	
});
