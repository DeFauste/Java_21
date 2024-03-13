package ex05;


import java.util.Scanner;

public class Menu {
    private Scanner scannerNumber = null;
    private Scanner scannerData = null;
    boolean state = true;
    String profile = "default";
    TransactionsService transactionsService = new TransactionsService();
    String[] menuLine = {
            "1. Add a user",
            "2. View user balances",
            "3. Perform a transfer",
            "4. View all transactions for a specific user",
            "5. DEV – remove a transfer by ID",
            "6. DEV – check transfer validity",
            "7. Finish execution"};

    private void Start(String profile) {
        this.profile = profile;
        scannerNumber = new Scanner(System.in);
        Uptade();
        Exit();
    }
    public void Uptade(){
        int numCommand = 0;
        while (state) {
            ShowMenu();

            System.out.println("---------------------------------------------------------");
        }

    }
    private void Exit() {
        scannerNumber.close();
        scannerData.close();
    }
    public void ShowMenu() {
        boolean dev = (profile.compareTo("dev") == 0);
        for (int i = 0; i < menuLine.length; ++i) {
            if (!dev && (i == 5 || i == 6)) {
                continue;
            }
            System.out.println(menuLine[i]);
        }
    }
    private void DoItMenu(int num) {
        switch (num) {
            case 1:

                break;
        }
    }

    private int InputNumberMenu() {
        return  scannerNumber.nextInt();
    }


}
