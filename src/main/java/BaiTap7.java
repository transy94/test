import java.util.Scanner;
import java.util.regex.Pattern;

public class BaiTap7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap url : ");
        String n = scanner.nextLine();
        Pattern pattern = Pattern.compile("[(http(s)?):\\/\\/(www)?a-zA-Z_0-9].[a-z]{2,6}\b([-a-zA-Z0-9@:%_\\\\+.~#?&//=]*)");
        System.out.println(pattern.matcher(n).matches());

    }
}
