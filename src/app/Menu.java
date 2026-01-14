import java.util.Scanner;

public class Menu {
    private TransactionService transactionService;

    public Menu(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public void start(){
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("""
                    ------------------------------------
                            TRANSACTION CLI
                    ------------------------------------
                    1) List transactions
                    2) Add transaction
                    3) Calculate total
                    4) Filter transactions
                    0) Exit
                    ------------------------------------
                    """);

            System.out.print("Select an option: ");
            int option = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (option) {
                case 1:
                    transactionService.showTransactions();
                    break;

                case 2:
                    System.out.print("ID of transaction: ");
                    String id = sc.nextLine();

                    System.out.print("Value: ");
                    double value = sc.nextDouble();

                    if (value <= 0){
                        System.out.println("Only transactions above 0!");
                        break;
                    }
                    transactionService.addTransactionsService(id,value);
                    break;

                case 3:
                    System.out.println("Total Value: ");
                    System.out.println(transactionService.calculateTotal());
                    break;

                case 4:
                    System.out.print("Type the value (only value above/equals 500): ");
                    double cash = sc.nextDouble();
                    if (cash < 500){
                        System.out.println("Only cash above/equals 500!");
                    }
                    transactionService.filterTransaction(cash);
                    break;

                case 0:
                    System.out.println("Leaving the program.......");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }

    }
}
