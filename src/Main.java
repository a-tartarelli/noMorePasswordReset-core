import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static Scanner in = new Scanner(System.in);
    private static TreeSet<Credential> credentials = new TreeSet<>();
    private static TreeMap<String, TreeSet<Credential>> manager = new TreeMap<>();

    public static void main(String[] args) {

        int sel = -1;
        printMenu();

        sel = getSel();

        while(true) {
            switch(sel) {
                case 0: credentials.add(addCredential());
                        for (Credential c : credentials) {
                            IOfile.WriteObjectToFile(c);
                        }
                    break;
                case 1: String separetor = "________________________________________________";
                        String s = "|name credential|username|password|backup codes|";
                        System.out.println(separetor + "\n" + s);
                        //credentials = (List<Credential>) IOfile.ReadObjectFromFile();
                        showCredentials(credentials);
                    break;
                case 2:
                    break;
                case 3: System.out.println("Insert caategory name: ");
                        System.out.println(">:");
                        in.nextLine();
                        String catName = in.nextLine();
                        if(Category.addCategory(new Category(catName)))
                            System.out.println("Category successful created");
                        else
                            System.out.println("Category already present");
                        Category.showCategory();
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

        System.out.println("Enter your name for credential, username and password: (one by one)");
        System.out.println(">:");
        in.nextLine();
        nameCredential = in.nextLine();
        System.out.println(">:");
        user = in.nextLine();
        System.out.println(">:");
        password = in.nextLine();
        System.out.println(">:");
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
            System.out.println(">:");
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



    public static void showCredentials(TreeSet<Credential> credentials) {
        credentials.stream().forEach(System.out::println);

        /*for(Credential c : credentials) {
            System.out.println(c.toString());
        }*/
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
