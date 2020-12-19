class Main {
    public static void main(String[] args) {
        ATM atmInstance1 = new ATM(0);
        boolean atmPowerOn = true;
        while(atmPowerOn) {
            atmInstance1.run();
        }
    }
}
