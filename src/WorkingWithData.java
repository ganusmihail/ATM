import java.io.*;

class WorkingWithData {

    public void addCard(String numberCard, String pinCode, int balance) {
        try {
            FileWriter fileWriter = new FileWriter("Data.txt", true);
            fileWriter.write(numberCard + " " + pinCode + " " + balance + "\n");
            fileWriter.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public String getCard(String numberCard) {
        String accountDetails = " ";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("Data.txt"));
            while (bufferedReader.ready()) {
                accountDetails = bufferedReader.readLine();
                if (accountDetails.contains(numberCard)) {
                    break;
                }
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
        return accountDetails;
    }

    public void replaceCard(String a, String b) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("Data.txt"));
            StringBuffer stringBuffer = new StringBuffer();

            while (bufferedReader.ready()) {
                stringBuffer.append(bufferedReader.readLine());
                stringBuffer.append("\n");
            }
            bufferedReader.close();

            String input = stringBuffer.toString();
            input = input.replace(a, b);

            FileOutputStream fileOut = new FileOutputStream("Data.txt");
            fileOut.write(input.getBytes());
            fileOut.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
