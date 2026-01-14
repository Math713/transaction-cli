package app;

public class Main {
    public static void main(String[] args){
        DataStore dataStore = new DataStore();
        TransactionService transactionService = new TransactionService(dataStore);
        Menu menu = new Menu(transactionService);

        menu.start();
    }
}
