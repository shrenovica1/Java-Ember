package models;
import  javax.inject.Inject;
import javax.inject.Singleton;
import  models.users;
import  models.usersRepository;
import java.util.List;
import java.util.ArrayList;


@Singleton
public  class usersService{

    @Inject
    private usersRepository usersRepository;

    @Inject
    public usersRepository getUsersRepository() {
        return usersRepository;
    }

    public users create(users user){
        System.out.println( user.getId());
        return usersRepository.create(user);
 }
    public Login signin(Login login){
        System.out.println("servis");
       //boolean validate= usersRepository.validate(login);

        return usersRepository.signin(login);
    }
    public String getUserId(String email){
        return usersRepository.getUserId(email);
    }
    public List<Object[]> getHistory(String id){
        return usersRepository.getHistory(id);
    }

}