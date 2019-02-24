
package products;

public class CustomerView implements User{
    @Override
    public String queryData() {
        return "select id, name from sold_products";
    }
    
}
