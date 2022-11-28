import java.util.ArrayList;
import java.util.Collections;

public class Operations {

    private String cardNumberWithDelimiter;
    private final String cardNumber;
    private final ArrayList<String> accountDataList = new ArrayList<>();
    private final WorkingWithData baseWorking = new WorkingWithData();

    public Operations(String cardNumber) {
        if (cardNumber.length() == 19) {
            this.cardNumberWithDelimiter = cardNumber;
            String[] cardN = cardNumber.split("-");
            this.cardNumber = String.join("", cardN);
        } else {
            this.cardNumber = cardNumber;
        }
        String[] st = baseWorking.getCard(this.cardNumber).split(" ");
        Collections.addAll(accountDataList, st);
    }

    public String getCardNumber() {
        return accountDataList.get(0);
    }

    public String getCardNumberWithDelimiter() {
        return cardNumberWithDelimiter;
    }

    public String getPinCode() {
        return accountDataList.get(1);
    }

    public int balance() {
        return Integer.parseInt(accountDataList.get(2));
    }

    public void withdrawMoney(int money) {
        int newBalance = balance() - money;
        String newDate = accountDataList.get(0) + " " + accountDataList.get(1) + " " + newBalance;
        baseWorking.replaceCard(baseWorking.getCard(cardNumber), newDate);
    }

    public void depositMoney(int money) {
        int newBalance = balance() + money;
        String newDate = accountDataList.get(0) + " " + accountDataList.get(1) + " " + newBalance;
        baseWorking.replaceCard(baseWorking.getCard(cardNumber), newDate);
    }
}
