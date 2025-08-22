import java.util.ArrayList;
public class DS0_CH7_Bank {
    private String bankName;
    private ArrayList<DS0_CH7_Account> accounts;

    public DS0_CH7_Bank(String name){
        this.bankName = name;
        accounts = new ArrayList<>();
    }

    public boolean openAccount(long accountNumber, String customerName, double startingBalance){
        for(int i = accounts.size()-1; i>=0; i--){
            if(accounts.get(i).getAccountNumber()==accountNumber){
                return false;
            }
        }
        if(startingBalance<=0){
            return false;
        } else{
            accounts.add(new DS0_CH7_Account(accountNumber, customerName, startingBalance));
            return true;
        }
    }

    public double closeAccount(long accountNumber){
        for(int i = accounts.size()-1; i>=0; i--){
            if(accounts.get(i).getAccountNumber()==accountNumber){
                double hi = accounts.get(i).getBalance();
                accounts.remove(i);
                return hi;
            }
        }
        return -1;
    }

    public void setName(String bankName){
        this.bankName = bankName;
    }

    public String getName(){
        return bankName;
    }

    public DS0_CH7_Account getAccount(long accountNumber){
        for(int i = 0; i<accounts.size(); i++){
            if(accounts.get(i).getAccountNumber()==accountNumber){
                return accounts.get(i);
            }
        }
        return null;
    }

    public ArrayList<DS0_CH7_Account> getAccounts(){
        return accounts;
    }
}