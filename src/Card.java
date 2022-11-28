import java.util.Random;

public class Card {

    private final String cardNumber;
    private final String pinCode;
    final int BALANCE = 0;
    private final Random random = new Random();

    public Card() {
        this.cardNumber = genCardNumber();
        this.pinCode = genPinCode();
        new WorkingWithData().addCard(cardNumber, pinCode, BALANCE);
    }

    private String genCardNumber() {
        String value = "1234567890";
        char[] chars = new char[16];
        for (int x = 0; x < 16; x++) {
            chars[x] = value.charAt(random.nextInt(10));
        }
        return new String(chars);
    }

    private String genPinCode() {
        String value = "1234567890";
        char[] chars = new char[4];
        for (int x = 0; x < 4; x++) {
            chars[x] = value.charAt(random.nextInt(10));
        }
        return new String(chars);
    }

    public String getCardNumber() {
        StringBuffer stringBuffer = new StringBuffer(cardNumber);
        stringBuffer.insert(4, "-");
        stringBuffer.insert(9, "-");
        stringBuffer.insert(14, "-");
        return stringBuffer.toString();
    }

    public String getPinCode() {
        return pinCode;
    }
}
