import java.util.Scanner;

public class VigenereCypher {
    public static void main(String[] args) {
        int modifier = 0;
        String inputString = "";
        String keyString = "";
        char[] input;
        char[] key;
        String output = "";
        int asciiDiff = 97;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input string : ");
        inputString = scanner.nextLine();


        if(isLetter(inputString)){


            System.out.print("Encrypt or decrypt (e/d)");

            String ans = scanner.nextLine();
            if(ans.equalsIgnoreCase("e")){
                modifier = 1;
            }
            else if(ans.equalsIgnoreCase("d")){
                modifier = -1;
            }else{
                System.out.println("Answer not valid");
                System.exit(0);
            }

            System.out.print("Key : ");

            keyString = scanner.nextLine();
            if(isLetter(keyString)){
                String tomin = inputString.toLowerCase();
                input = tomin.toCharArray();
                key = keyString.toLowerCase().toCharArray();
                int spaces = 0;
                for(int i = 0; i < input.length; i++){

                    if(input[i] == ' '){
                        spaces++;
                        output += ' ';
                    }
                    else{
                        int skewedCharint;
                        skewedCharint = input[i] + ((key[(i - spaces) % key.length] - asciiDiff) * modifier);
                        char skewedChar = (char) skewedCharint;
                        if((int)skewedChar > 122)skewedCharint -= 26;
                        if((int)skewedChar < 97) skewedCharint += 26;
                        skewedChar = (char) skewedCharint;
                        output += skewedChar;

                    }
                }
                System.out.println(output);
            }
            else{
                System.out.println("Invalid key");
            }
        }else{
            System.out.println("Invalid input string");
        }
    }

    private static boolean isLetter(String string) {
        for(int i = 0; i < string.length(); i++){
            if(!Character.isLetter(string.charAt(i)) ^ string.charAt(i) == ' '){
                return false;
            }
        }
        return true;
    }
}