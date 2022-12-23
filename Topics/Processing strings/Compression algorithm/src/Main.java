import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//Костыль в виде добаления последнего символа :) подумай как от него избавиться
        String textInput = scanner.nextLine();
        char[] chars = textInput.toCharArray();
        char previousChar = chars[0];
        int counter = 0;
        StringBuilder result = new StringBuilder();
        for(char charInUse : chars){
            if(charInUse != previousChar) {
                result.append(previousChar).append(counter);
                previousChar = charInUse;
                counter = 1;
            }
            else {
                counter ++;
            }
        }
        result.append(previousChar).append(counter);
        System.out.println(result);
    }
}