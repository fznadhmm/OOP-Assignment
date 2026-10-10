import java.util.Scanner;

public class Bank_Main2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bank_Blueprint bankMBG = new Bank_Blueprint();

        bankMBG.addCustomer("Tony", "Stark");
        bankMBG.getCustomer(0).setAccount(new Account(100000));

        bankMBG.addCustomer("Peter", "Parker");
        bankMBG.getCustomer(1).setAccount(new Account(100000));

        bankMBG.addCustomer("Natasha", "Romanoff");
        bankMBG.getCustomer(2).setAccount(new Account(100000));

        System.out.println("Welcome to Bank ABC\n");

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("=== Welcome to MBG (My Bank Gwe)  ===");
            System.out.println("1. List Account ");
            System.out.println("2. Add New Customer");
            System.out.println("3. Open New Account");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            int menu = input.nextInt();
            System.out.println();

            if (menu == 1) {
                System.out.println("=== CUSTOMERS & ACCOUNTS ===");
                for (int i = 0; i < bankMBG.getNumOfCustomers(); i++) {
                    Customer cust = bankMBG.getCustomer(i);
                    System.out.println("[" + i + "] " + cust.getFirstName() + " " + cust.getLastName());
                    for (int j = 0; j < cust.getNumOfAccounts(); j++) {
                        System.out.println("    Account " + j + ": Rp " + cust.getAccount(j).getBalance());
                    }
                }
                System.out.println();

            } else if (menu == 2) {
                System.out.print("Enter first name: ");
                String fn = input.next();
                System.out.print("Enter last name: ");
                String ln = input.next();

                bankMBG.addCustomer(fn, ln);
                System.out.println("New customer has been added successfully.\n");

            } else if (menu == 3) {
                System.out.print("Enter customer index: ");
                int cIdx = input.nextInt();
                Customer cust = bankMBG.getCustomer(cIdx);
                
                if (cust != null) {
                    System.out.print("Enter initial balance: ");
                    double balance = input.nextDouble();
                    cust.setAccount(new Account(balance));
                    System.out.println("Account successfully opened.\n");
                } else {
                    System.out.println("Customer not found!\n");
                }

            } else if (menu == 4) {
                System.out.print("Enter customer index: ");
                int cIdx = input.nextInt();
                Customer cust = bankMBG.getCustomer(cIdx);

                if (cust != null) {
                    System.out.print("Enter account index: ");
                    int aIdx = input.nextInt();
                    Account acc = cust.getAccount(aIdx);
                    
                    if (acc != null) {
                        System.out.print("Enter amount to deposit: ");
                        double amt = input.nextDouble();
                        if (acc.deposit(amt)) {
                            System.out.println("Deposit success. Current balance: Rp " + acc.getBalance() + "\n");
                        } else {
                            System.out.println("Deposit failed. Invalid amount.\n");
                        }
                    } else {
                        System.out.println("Account not found!\n");
                    }
                } else {
                    System.out.println("Customer not found!\n");
                }

            } else if (menu == 5) {
                System.out.print("Enter customer index: ");
                int cIdx = input.nextInt();
                Customer cust = bankMBG.getCustomer(cIdx);

                if (cust != null) {
                    System.out.print("Enter account index: ");
                    int aIdx = input.nextInt();
                    Account acc = cust.getAccount(aIdx);

                    if (acc != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double amt = input.nextDouble();
                        if (acc.withdraw(amt)) {
                            System.out.println("Withdraw success. Current balance: Rp " + acc.getBalance() + "\n");
                        } else {
                            System.out.println("Withdraw failed. Insufficient balance.\n");
                        }
                    } else {
                        System.out.println("Account not found!\n");
                    }
                } else {
                    System.out.println("Customer not found!\n");
                }

            } else if (menu == 6) {
                System.out.println("Total transactions today: " + Account.getTransactionCount());
                System.out.println("Exiting system. Thank you!");
                isRunning = false;
                
            } else {
                System.out.println("Menu not available. Try again.\n");
            }
        }
        
        input.close();
    }
}