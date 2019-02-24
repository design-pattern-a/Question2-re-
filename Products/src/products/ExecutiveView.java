
package products;

public class ExecutiveView implements User{
    @Override
    public String queryData() {
        return "select * from sold_products";
    }
}
