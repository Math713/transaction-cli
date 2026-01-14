import java.util.HashMap;
import java.util.Map;

public class DataStore {
    private Map<String,Double> transactions = new HashMap<>();

    public Map<String, Double> getTransactions() {
        return Map.copyOf(transactions);
    }

    public void addTransactions(String id, double value){
        transactions.put(id,value);
    }
}
