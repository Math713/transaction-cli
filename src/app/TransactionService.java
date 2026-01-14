public class TransactionService {
    private DataStore dataStore;

    public TransactionService(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    public void showTransactions(){
        dataStore.getTransactions().forEach((id, value) ->
                System.out.println("ID: " + id + " | Value: " + value));
    }

    public void addTransactionsService(String id, double value){
        if (dataStore.getTransactions().containsKey(id)){
            System.out.println("Already have this id. Try again");
        }
        if (value <= 0){
            System.out.println("Only transactions above 0!");
        }

        dataStore.addTransactions(id, value);

    }

    public double calculateTotal (){
        return dataStore.getTransactions().values()
                .stream().mapToDouble(v -> v).sum();
    }

    public void filterTransaction(double cash){
        dataStore.getTransactions().entrySet().stream()
                .filter(x -> x.getValue() > cash)
                .forEach(entry ->
                        System.out.println("ID: " + entry.getKey() + " | Value: " + entry.getValue()));
    }
}
