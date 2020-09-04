import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    /*
    * usero le mappe per gestire le categorie, map<NomeCat, Array[credential]>
    controllo ogni volta che si crea una nuova categoria che non sia gia esistente
    * salvero su file tutta la mappa previo criptaggio delle stringhe sensibili (nome utente, password, codebackup)
    * */

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Credential> credentials = new ArrayList<>();
        int sel = -1;
        printMenu();

        sel = getSel();

        while(true) {
            switch(sel) {
                case 0: credentials.add(addCredential());
                        //System.out.println(credentials.toString());
                    break;
                case 1: showCredentials(credentials);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5: System.exit(0);
                    break;
                default: System.out.println("Error, reinput");
            }
            System.out.println("$:");
            sel = getSel();
        }


    }

    public static int getSel() {
        int sel = -1;
        try {
            sel = in.nextInt();
        } catch (Exception e) {
            sel = 50;
            in.nextLine();
        }
        return sel;
    }

    public static Credential addCredential() {
        String nameCredential, user, password;
        boolean flag = false;
        ArrayList<String> backupCode = new ArrayList<>();

        System.out.println("Enter your name for credential, username and password: (once at time)");
        System.out.println("$:");
        in.nextLine();
        nameCredential = in.nextLine();
        System.out.println("$:");
        user = in.nextLine();
        System.out.println("$:");
        password = in.nextLine();
        System.out.println("$:");
        backupCode = insertBackupCode();

        Credential c = new Credential(nameCredential, user, password, backupCode);
        // System.out.println(c.toString());

        return c;
    }

    public static ArrayList<String> insertBackupCode() {
        ArrayList<String> backupCode = new ArrayList<>();
        boolean next = true;
        System.out.println("Enter your list of backup code if you have it: (null if not)");


        do{
            System.out.println("$:");
            String code = in.nextLine();
            if(code.equalsIgnoreCase("null")) {
                backupCode = null;
                break;
            } else {
                backupCode.add(code);
                System.out.println("Do you have another code? (y/n)");
                String go = in.nextLine();
                if(go.equalsIgnoreCase("n") || go.equalsIgnoreCase("no")) {
                    next = false;
                }

            }

        }
        while(next);

        return backupCode;
    }

    public static void showCredentials(ArrayList<Credential> credentials) {
        for(Credential c : credentials) {
            System.out.println(c.toString());
        }
    }


    private static void printMenu() {
        System.out.println("___  ___             _               ______                                              _ \n" +
                "|  \\/  |            | |              | ___ \\                                            | |\n" +
                "| .  . |  __ _  ___ | |_   ___  _ __ | |_/ /  __ _  ___  ___ __      __  ___   _ __   __| |\n" +
                "| |\\/| | / _` |/ __|| __| / _ \\| '__||  __/  / _` |/ __|/ __|\\ \\ /\\ / / / _ \\ | '__| / _` |\n" +
                "| |  | || (_| |\\__ \\| |_ |  __/| |   | |    | (_| |\\__ \\\\__ \\ \\ V  V / | (_) || |   | (_| |\n" +
                "\\_|  |_/ \\__,_||___/ \\__| \\___||_|   \\_|     \\__,_||___/|___/  \\_/\\_/   \\___/ |_|    \\__,_|\n" +
                "                                                                                           \n" +
                "                                                                                           \n");
        System.out.println("0) Add credential");
        System.out.println("1) Show credentials");
        System.out.println("2) Modify credential");
        System.out.println("3) Create category");
        System.out.println("4) Modify category");
        System.out.println("5) Exit");
        System.out.println("$:");
    }

}
