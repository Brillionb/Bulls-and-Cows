import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};
        String inputWord = scanner.nextLine();
        char[] inputArray = new char[inputWord.length()];
        char[] outputArray = new char[inputWord.length()];

        for (int i = 0; i < inputArray.length; i++) {
            outputArray[i] = 'C';
            for (int j = 0; j < vowels.length; j++) {
                if (inputWord.charAt(i) == vowels[j]) {
                    outputArray[i] = 'V';
                }
            }
        }
        String outputWord = new String(outputArray);
        String regex = "([V]{3,})|([C]{3,})";

        Matcher m = Pattern.compile(regex).matcher(outputWord);
        int count = 0;

        while (m.find()) {
            String sub = m.group();
            if (sub.length() > 2 && sub.length()%2>0) {
               count+=sub.length()/2;
            }else if (sub.length() > 2 && sub.length()%2==0){
                count+=sub.length()/2-1;
            }
        }

        System.out.println(count);
    }
}