// message constants to be used in the Program.ATM program
public class ATMConstants {
    public static String welcomeMessage = "Welcome to simple Program.ATM!";

    public static String promptInsertCardMessage = "Please insert your ACCESS CARD.";

    public static String simulateCardInsertInstructions =
            "(For the purposes of this demo, press ENTER to simulate card insertion.)";

    public static String promptPINEnterMessage = "Please enter your PIN.";

    public static String simulatePINEnterInstructions =
            "(For the purposes of this demo, press input any 4 DIGIT NUMBER and press ENTER. - ex.0000)";

    public static String accessDeniedMessage = "Access denied. Re-enter your PIN.";

    public static String greetUserByNameMessage(String name) {
        return "Hello, " + name + "!";
    }

    public static String userOptions =
            "Please choose from the following options:\n" +
                    "[1] See Balance\n" +
                    "[2] Deposit\n" +
                    "[3] Withdraw\n" +
                    "[4] Exit";

    public static String invalidSelection = "Invalid selection. Please try again.";

    public static String pressEnterToReturnToMenu = "Press ENTER to return to menu.";

    public static String customerBalance(Customer customer) {
        return "Your balance is $ " + customer.getBalance();
    }

    public static String depositSelectionMessage = "Input the amount you wish to deposit in dollars, then press enter.";

    public static String depositCompletionMessage(int depositAmount, int originalAmount) {
        return "Deposited $ " + depositAmount + " into your account. \n" +
                "Your new balance is: $ " + (originalAmount + depositAmount);
    }

    public static String depositFailedMessage = "Error - invalid amount. Failed to deposit.";

    public static String withdrawSelectionMessage = "Input the amount you wish to withdraw, then press enter.";

    public static String withdrawCompletionMessage(int withdrawalAmount, int originalAmount) {
        return "Withdrew $ " + withdrawalAmount + " from your account. \n" +
                "Your new balance is: $ " + (originalAmount - withdrawalAmount);
    }

    public static String withdrawalFailedMessage = "Error - invalid amount. Failed to withdraw.";

    public static String withdrawalFailedExceedsLimitMessage = "Error - entered amount exceeds withdrawal limit. " +
            "Failed to withdraw.";

    public static String withdrawalFailedInsufficientFundsMessage = "Error - entered amount exceeds account balance. " +
            "Failed to withdraw.";

    public static String withdrawalFailedInsufficientATMFundsMessage = "Error - entered amount exceeds ATM balance. " +
            "Failed to withdraw.";

    public static String exitMessage = "Thank you for using simple Program.ATM.\n" +
            "Please take your ACCESS CARD.";

    public static String logo = "     _                 _           _  _____ __  __ \n" +
            " ___(_)_ __ ___  _ __ | | ___     / \\|_   _|  \\/  |\n" +
            "/ __| | '_ ` _ \\| '_ \\| |/ _ \\   / _ \\ | | | |\\/| |\n" +
            "\\__ \\ | | | | | | |_) | |  __/  / ___ \\| | | |  | |\n" +
            "|___/_|_| |_| |_| .__/|_|\\___| /_/   \\_\\_| |_|  |_|\n" +
            "                |_|                                ";

    public static String filler = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
            "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
            logo + "\n----------------------------------------------------------------------------";

}
