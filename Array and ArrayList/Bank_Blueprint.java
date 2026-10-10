import java.util.ArrayList;

public class Bank_Blueprint {
    private ArrayList<Customer> customers;

    public Bank_Blueprint() {
        customers = new ArrayList<>();
    }

    public void addCustomer(String f, String l) {
        customers.add(new Customer(f, l));
    }

    public int getNumOfCustomers() {
        return customers.size();
    }

    public Customer getCustomer(int index) {
        if (index >= 0 && index < customers.size()) {
            return customers.get(index);
        }
        return null;
    }
}