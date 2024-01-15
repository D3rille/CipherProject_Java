import java.util.Random;
public class Cipher{
    public String indexGuide;
    //guides the character to its corresponding index.
    public String key;
    //equivalent value of the index from the guide, corresponding with the character
    public String customKey;
    //user-defined key

    Cipher(){
        this.indexGuide="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890 .,?:;-_!+/*()=<>[]|#@";
        this.key = "wc(9d<n-E1T.DJAx24Qr=Mle>_hygCvI7m?zk]F)OtUV[!3L:W#qB5Su8sf/N|jZH*YpXK,aRi0 oG;Pb+@6";
        this.customKey="<none>";
    }

    public String encrypt(String message){
        //Encrypt texts in default-mode
        StringBuilder str = new StringBuilder();
        char character;
        int index;
        for (int iter = 0; iter < message.length(); iter++) {
            character = message.charAt(iter);
            index = indexGuide.indexOf(character);
            character = key.charAt(index);
            str.append(character);
        }
        return str.toString();

    }
    public String customEncrypt(String message){
        //Encrypt texts in custom-mode
        StringBuilder str = new StringBuilder();
        char character;
        int index;
        for (int iter = 0; iter < message.length(); iter++) {
            character = message.charAt(iter);
            index = indexGuide.indexOf(character);
            character = customKey.charAt(index);
            str.append(character);
        }
        return str.toString();

    }
    public String decrypt(String encryptedMessage){
        //Decrypt encrypted text in default-mode
        StringBuilder str = new StringBuilder();
        char character;
        int index;
        for (int iter = 0; iter < encryptedMessage.length(); iter++) {
            character = encryptedMessage.charAt(iter);
            index = key.indexOf(character);
            character = indexGuide.charAt(index);
            str.append(character);
        }
        return str.toString();

    }
    public String customDecrypt(String encryptedMessage){
        //Decrypt encrypted text in custom-mode
        StringBuilder str = new StringBuilder();
        char character;
        int index;
        for (int iter = 0; iter < encryptedMessage.length(); iter++) {
            character = encryptedMessage.charAt(iter);
            index = customKey.indexOf(character);
            character = indexGuide.charAt(index);
            str.append(character);
        }
        return str.toString();

    }
    public void generateKey(){
        //generate custom key automatically
        Random random = new Random();
        StringBuilder key = new StringBuilder();
        String guide = this.indexGuide;
        int guideLength = guide.length();
        char character;
        int randomNum;

        for (; guideLength >0; guideLength--) {
            //rearrange characters of indexGuide
            randomNum=random.nextInt(guideLength);
            character = guide.charAt(randomNum);
            key.append(character);
            guide=guide.replace((""+character), "");
        }
        this.customKey = key.toString();

    }
    public void showKey(boolean visible){
        //used to display custom key
        System.out.print("\tCustom-key: ");
        if(!visible && !customKey.equalsIgnoreCase("<none>")){
            //display encrypted custom key
            for (int iter = 0; iter < customKey.length(); iter++) {
                if(iter>=0 && iter<3){
                    System.out.print(customKey.charAt(iter));
                } else{
                    System.out.print("*");
                }
            }
        } else{
            //display custom key in plain text
            System.out.print(customKey);
        }
        System.out.println();
    }

}
