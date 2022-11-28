import java.util.Scanner;

public class Atm {

    private static int atmBalance = 3000000;

    public static void main(String[] args) {

        boolean workAtm = true;

        Scanner scanner = new Scanner(System.in);

        while (workAtm) {
            System.out.println("\n* Для авторизации и операций с карт-счётом - нажмите 1 *");
            System.out.println("* Для создания карт-счёта в нашем банке - нажмите 2 *");
            System.out.println("* Для завершить сеанс - нажмите 0 *");
            System.out.print("\nПоле ввода: ");
            String options = scanner.next();
            switch (options) {
                case "0":
                    workAtm = false;
                    break;
                case "1":
                    System.out.print("\nВведите номер карты: ");
                    String numberCard = scanner.next();
                    Operations operationsWithCard = new Operations(numberCard);
                    if (numberCard.equals(operationsWithCard.getCardNumber()) || numberCard.equals(operationsWithCard.getCardNumberWithDelimiter())) {
                        System.out.print("Введите PIN-код карты: ");
                        String pinCode = scanner.next();
                        if (pinCode.equals(operationsWithCard.getPinCode())) {
                            boolean workingWithOperations = true;
                            while (workingWithOperations) {
                                System.out.println("\n** Для проверки баланса - нажмите 1 **");
                                System.out.println("** Для пополнения счета - нажмите 2 **");
                                System.out.println("** Для снятия денежных средств - нажмите 3 **");
                                System.out.println("** Для возврата в главное меню - нажмите 4 **");
                                System.out.println("** Для завершения сеанса - нажмите 0 **");
                                System.out.print("\nПоле ввода: ");
                                int trans = scanner.nextInt();
                                switch (trans) {
                                    case 0:
                                        workingWithOperations = false;
                                        workAtm = false;
                                        continue;
                                    case 1:
                                        Operations operationWithBalance = new Operations(numberCard);
                                        System.out.println("\nВаш баланс составляет: " + operationWithBalance.balance() + " BYN");
                                        while (true) {
                                            System.out.println("\n** Для продолжения работы с карт-счётом - нажмите 1 **");
                                            System.out.println("** Для возврата в главное меню - нажмите 2 **");
                                            System.out.println("** Для завершения сеанса - нажмите 0 **");
                                            System.out.print("\nПоле ввода: ");
                                            String sc = scanner.next();
                                            if (sc.equals("1")) {
                                                break;
                                            }
                                            if (sc.equals("2")) {
                                                workingWithOperations = false;
                                                break;
                                            }
                                            if (sc.equals("0")) {
                                                workingWithOperations = false;
                                                workAtm = false;
                                                break;
                                            }
                                        }
                                        continue;
                                    case 2:
                                        Operations operationWithDeposit = new Operations(numberCard);
                                        System.out.println("\nСумма внесенных денежных средств не должна превышать 1000000 BYN");
                                        System.out.print("Внесите необходимую сумму: ");
                                        int deposit = scanner.nextInt();
                                        if (deposit < 0) {
                                            System.out.println("\nНедопустимое значение");
                                        } else if (deposit > 1000000) {
                                            System.out.println("\nПревышен допустимый лимит внесения денежных средств");
                                        } else {
                                            atmBalance += deposit;
                                            operationWithDeposit.depositMoney(deposit);
                                            System.out.println("\nБаланс успешно пополнен");
                                        }
                                        while (true) {
                                            System.out.println("\n** Для продолжения работы с карт-счётом - нажмите 1 **");
                                            System.out.println("** Для возврата в главное меню - нажмите 2 **");
                                            System.out.println("** Для завершения сеанса - нажмите 0 **");
                                            System.out.print("\nПоле ввода: ");
                                            String sc = scanner.next();
                                            if (sc.equals("1")) {
                                                break;
                                            }
                                            if (sc.equals("2")) {
                                                workingWithOperations = false;
                                                break;
                                            }
                                            if (sc.equals("0")) {
                                                workingWithOperations = false;
                                                workAtm = false;
                                                break;
                                            }
                                        }
                                        continue;
                                    case 3:
                                        Operations operationWithWithdraw = new Operations(numberCard);
                                        System.out.print("\nВведите сумму для снятия денежных средств: ");
                                        int withdraw = scanner.nextInt();
                                        if (withdraw < 0) {
                                            System.out.println("\nНедопустимое значение");
                                        } else if (withdraw > atmBalance) {
                                            System.out.println("\nПревышен допустимая сумма.");
                                            System.out.println("Максимальная сумма для снятия: " + atmBalance);
                                        } else if (withdraw > operationWithWithdraw.balance()) {
                                            System.out.println("\nНедостаточно средств");
                                        } else {
                                            atmBalance -= withdraw;
                                            operationWithWithdraw.withdrawMoney(withdraw);
                                            System.out.println("\nСумма " + withdraw + " BYN успешно снята");
                                        }
                                        while (true) {
                                            System.out.println("\n** Для продолжения работы с карт-счётом - нажмите 1 **");
                                            System.out.println("** Для возврата в главное меню - нажмите 2 **");
                                            System.out.println("** Для завершения сеанса - нажмите 0 **");
                                            System.out.print("\nПоле ввода: ");
                                            String sc = scanner.next();
                                            if (sc.equals("1")) {
                                                break;
                                            }
                                            if (sc.equals("2")) {
                                                workingWithOperations = false;
                                                break;
                                            }
                                            if (sc.equals("0")) {
                                                workingWithOperations = false;
                                                workAtm = false;
                                                break;
                                            }
                                        }
                                        continue;
                                    case 4:
                                        workingWithOperations = false;
                                        break;
                                }
                            }
                        } else {
                            System.out.println("\nНеправильный PIN-код");
                            continue;
                        }
                    } else {
                        System.out.println("\nКарта с таким номером отсутствует");
                        continue;
                    }
                    break;
                case "2":
                    Card card = new Card();
                    System.out.println("\nОбязательно запомните следующую информацию: ");
                    System.out.println("- Номер вашей карты: " + card.getCardNumber());
                    System.out.println("- Пин-код вашей карты: " + card.getPinCode());
                    while (true) {
                        System.out.println("\n** Для возврата в главное меню - нажмите 2 **");
                        System.out.println("** Для завершения сеанса - нажмите 0 **");
                        System.out.print("\nПоле ввода: ");
                        String sc = scanner.next();
                        if (sc.equals("2")) {
                            break;
                        }
                        if (sc.equals("0")) {
                            workAtm = false;
                            break;
                        }
                    }
            }
        }
        System.out.println("\n* Спасибо, что воспользовались услугами нашего банка *");
        System.out.println("* Не забудьте забрать карту и всего Вам самого доброго! *");
    }
}
