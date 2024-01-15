
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Cipher cipher = new Cipher();
        boolean ending =false;
        boolean exiting=false;
        String command;
        String message;
        String result;


        System.out.println("\nCipher Program");
        System.out.println("Author[Jhan Derille C. Unlayao]");
        System.out.println("Version[v1.1]\n");


        while (!ending && !exiting){
            command =enterInput("Cipher>home: ");
            command=command.toLowerCase();

            switch  (command){
                case "?":
                case "help":
                    displayCommands("home");
                    break;
                case "custom":
                    while (!exiting){
                        command = enterInput("Cipher>Custom: ");

                        switch (command){
                            case "?":
                            case "help":
                                displayCommands("custom");
                                break;
                            case "encrypt":
                                if(cipher.customKey.equalsIgnoreCase("<none>")){
                                    System.out.println("\tCustom-key is not set. generate or insert key first.");
                                    break;
                                } else{
                                    System.out.println("Custom Encryption:");
                                    message = enterInput("\tInsert Texts/Message: ");
                                    result = cipher.customEncrypt(message);
                                    System.out.println("Encrypted Message:");
                                    System.out.format("\t\t%s%n", result);
                                    break;
                                }
                            case"decrypt":
                                if(cipher.customKey.equalsIgnoreCase("<none>")){
                                    System.out.println("\tCustom-key is not set. generate or insert key first.");
                                } else{
                                    System.out.println("Custom Decryption:");
                                    message = enterInput("\tInsert Texts/Message: ");
                                    result = cipher.customDecrypt(message);
                                    System.out.println("Decrypted Message:");
                                    System.out.format("\t\t%s%n", result);
                                }
                                break;
                            case "generate-key":
                                cipher.generateKey();
                                System.out.println("\tKey Successfully Generated!");
                                break;
                            case "insert-key":
                                cipher.customKey=enterInput("\tInsert Custom-key: ");
                                break;
                            case "show-key":
                                cipher.showKey(false);
                                break;
                            case "show-key visible":
                                cipher.showKey(true);
                                break;
                            case "exit":
                                exiting=true;
                                break;
                            case "end":
                                exiting=true;
                                ending = true;
                                break;
                            default:
                                System.out.println("Cipher>Custom: Invalid Command.");
                        }
                    }
                    exiting=false;
                    break;
                case "default":
                    while (!exiting){
                        command = enterInput("Cipher>Default: ");

                        switch (command){
                            case "?":
                            case "help":
                                displayCommands("default");
                                break;
                            case "encrypt":
                                System.out.println("Default Encryption:");
                                message = enterInput("\tInsert Texts/Message: ");
                                result = cipher.encrypt(message);
                                System.out.println("Encrypted Message:");
                                System.out.format("\t\t%s%n", result);
                                break;
                            case"decrypt":
                                System.out.println("Default Decryption:");
                                message = enterInput("\tInsert Texts/Message: ");
                                result = cipher.decrypt(message);
                                System.out.println("Decrypted Message:");
                                System.out.format("\t\t%s%n", result);
                                break;

                            case "exit":
                                exiting=true;
                                break;
                            case "end":
                                exiting = true;
                                ending = true;
                                break;
                            default:
                                System.out.println("Cipher>Default: Invalid Command.");
                        }
                    }
                    exiting=false;
                    break;

                case "end":
                    exiting=true;
                    ending = true;
                    break;
                default:
                    System.out.println("Cipher>home: Invalid Command.");

            }
        }
    }
    static void displayCommands(String mode){
        //List commands for each mode
        if(mode.equals("home")){
            System.out.println(
                    """
                            \n\t?/help --- display commands
                            \tcustom --- go to custom mode.
                            \tdefault --- go to default mode.
                            \tend --- close program\n""");
        }
        else if(mode.equals("custom")){
            System.out.println(
                    """
                            \n\t?/help ---- display commands
                            \tencrypt ---- encrypt message/text.
                            \tdecrypt ---- decrypt encrypted message.
                            \tgenerate-key --- automatically generate custom key.
                            \tinsert-key --- manually insert custom key.
                            \tshow-key --- display custom key as encrypted.
                            \tshow-key visible --- displays plain text custom key.
                            \texit --- exit out of the mode.
                            \tend - close program\n""");
        }
        else if(mode.equals("default")){
            System.out.println(
                    """
                            \n\t?/help - display commands
                            \tencrypt - encrypt message/text.
                            \tdecrypt - decrypt encrypted message.
                            \texit --- exit out of the mode.
                            \tend - close program\n""");
        }

    }
    static String enterInput(String msg){
        //get user input, with prompt
        Scanner scanner = new Scanner(System.in);
        System.out.print(msg);
        return scanner.nextLine();





    }
}