import java.util.Scanner;

// Program.ATM object that contains its main program
public class ATM {
    private int atmBalance;
    private final FakeAPI fakeAPI = new FakeAPI();
    private final Scanner scanner = new Scanner(System.in);
    private Customer currentCustomer;

    public int getAtmBalance() {
        return atmBalance;
    }

    // constructor
    public ATM(int balance) {
        this.atmBalance = balance;
    }

    // displays the customer's current balance
    public void showBalance() {
        System.out.println(ATMConstants.customerBalance(currentCustomer));
    }

    // prompts user to press ENTER to return to the menu
    public void pressEnterToReturn() {
        System.out.println(ATMConstants.pressEnterToReturnToMenu);
        scanner.nextLine();
    }

    // increase Program.ATM's balance by the given amount
    public void increaseATMBalance(int amount) {
        atmBalance += amount;
    }

    // decrease Program.ATM's balance by the given amount
    public void decreaseATMBalance(int amount) {
        atmBalance -= amount;
    }

    // deposits to customer's account
    public void deposit() {
        System.out.println(ATMConstants.depositSelectionMessage);
        String input = scanner.nextLine();
        if (input.matches("[0-9]+")) {
            int depositAmount = Integer.parseInt(input);
            int originalAmount = currentCustomer.getBalance();
            currentCustomer.deposit(depositAmount);
            System.out.println(ATMConstants.depositCompletionMessage(depositAmount, originalAmount));
            increaseATMBalance(depositAmount);
        } else {
            System.out.println(ATMConstants.depositFailedMessage);
        }
    }

    // allows customer to withdraw from their account
    public void withdraw() {
        System.out.println(ATMConstants.withdrawSelectionMessage);
        String input = scanner.nextLine();
        if (input.matches("[0-9]+")) {
            int withdrawalAmount = Integer.parseInt(input);
            int originalAmount = currentCustomer.getBalance();
            boolean exceedsWithdrawalLimit = currentCustomer.exceedsWithdrawalLimit(withdrawalAmount);
            boolean exceedsAccountBalance = currentCustomer.exceedsAccountBalance(withdrawalAmount);
            boolean exceedsATMBalance = withdrawalAmount > atmBalance;
            if (!(exceedsWithdrawalLimit || exceedsAccountBalance || exceedsATMBalance)) {
                currentCustomer.withdraw(withdrawalAmount);
                System.out.println(ATMConstants.withdrawCompletionMessage(withdrawalAmount, originalAmount));
                decreaseATMBalance(withdrawalAmount);
            } else {
                if (exceedsWithdrawalLimit) {
                    System.out.println(ATMConstants.withdrawalFailedExceedsLimitMessage);
                }
                if (exceedsAccountBalance) {
                    System.out.println(ATMConstants.withdrawalFailedInsufficientFundsMessage);
                }
                if (exceedsATMBalance) {
                    System.out.println(ATMConstants.withdrawalFailedInsufficientATMFundsMessage);
                }
            }
        } else {
            System.out.println(ATMConstants.withdrawalFailedMessage);
        }
    }

    // main Program.ATM program
    public void run() {
        System.out.println(ATMConstants.filler);
        System.out.println(ATMConstants.welcomeMessage);
        currentCustomer = null;
        System.out.println(ATMConstants.promptInsertCardMessage);
        System.out.println(ATMConstants.simulateCardInsertInstructions);
        currentCustomer = fakeAPI.cardInsert();
        System.out.println(ATMConstants.filler);
        System.out.println(ATMConstants.greetUserByNameMessage(currentCustomer.getName()));
        // loop until user enters valid pin
        boolean isPinCorrect = false;
        while (!isPinCorrect) {
            System.out.println(ATMConstants.promptPINEnterMessage);
            System.out.println(ATMConstants.simulatePINEnterInstructions);
            isPinCorrect = fakeAPI.validatePin();
            if (!isPinCorrect) {
                System.out.println(ATMConstants.filler);
                System.out.println(ATMConstants.accessDeniedMessage);
            }
        }
        // loop until customer indicates that they want to exit the program
        boolean userIndicatedExit = false;
        while (!userIndicatedExit) {
            System.out.println(ATMConstants.filler);
            System.out.println(ATMConstants.userOptions);
            // loop until customer selects valid option (i.e. 1, 2, 3, or 4)
            boolean optionSelected = false;
            int selection = -1;
            while (!optionSelected) {
                String input = scanner.nextLine();
                if (input.matches("[0-9]+") && input.length() == 1) {
                    selection = Integer.parseInt(input);
                    if (selection > 0 && selection <= 4) {
                        optionSelected = true;
                    } else {
                        System.out.println(ATMConstants.invalidSelection);
                    }
                } else {
                    System.out.println(ATMConstants.invalidSelection);
                }
            }
            System.out.println(ATMConstants.filler);
            // launches selected option
            switch (selection) {
                case 1:
                    showBalance();
                    pressEnterToReturn();
                    break;
                case 2:
                    deposit();
                    pressEnterToReturn();
                    break;
                case 3:
                    withdraw();
                    pressEnterToReturn();
                    break;
                case 4:
                    userIndicatedExit = true;
                    System.out.println(ATMConstants.exitMessage);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                default:
                    break;
            }
        }
    }
}
