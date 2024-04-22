package Utilities;
import java.util.Random;

public class Random_Data_Utilities {
    public static String randomEmail(String email) {
            Random random = new Random();
            int number = random.nextInt(1000);
            int indexOfAtSign = email.indexOf("@");
            String firstPart = email.substring(0, indexOfAtSign);
            String secondPart = email.substring(indexOfAtSign);
            return firstPart + number + secondPart;
        }
}
