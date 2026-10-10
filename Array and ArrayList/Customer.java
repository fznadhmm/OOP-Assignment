public class Customer {
    private String firstName;
    private String lastName;
    private Account[] accounts;
    private int numOfAccounts;

    public Customer(String fName, String lName) {
        firstName = fName;
        lastName = lName;
        accounts = new Account[10];
        numOfAccounts = 0;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAccount(Account acc) {
        if (numOfAccounts < accounts.length) {
            accounts[numOfAccounts] = acc;
            numOfAccounts++;
        }
    }

    public Account getAccount(int index) {
        if (index >= 0 && index < numOfAccounts) {
            return accounts[index];
        }
        return null;
    }

    public int getNumOfAccounts() {
        return numOfAccounts;
    }
}