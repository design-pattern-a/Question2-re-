
package products;

public class UserFactory {
    public User getUser(String userType){
        if(userType == null){
            return null;
        }
        if(userType == "customer"){
            return new CustomerView();
        }
        if(userType == "executive"){
            return new ExecutiveView();
        }
        
        return null;
    }
}
