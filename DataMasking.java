import java.util.Scanner;
public class DataMasking {

    // Mask Email
    public static String maskEmail(String email) {
        String[] parts = email.split("@");
        String username = parts[0];
        if (username.length() <= 2) {
            return username + "@" + parts[1]; // No masking for very short usernames
        }
        else {
            return username.charAt(0) + " * ".repeat(username.length() - 2) + username.charAt(username.length() - 1) + "@" + parts[1];//username.length() - 2;----> -2 for first letter and last letter from String[] username
        }
    }

    // Mask Aadhar Card
    public static String maskAadharCard(String aadhar) {
        return aadhar.substring(0,4)+" * * * * * * " + aadhar.substring(aadhar.length() - 2);
    }

    // Mask Phone Number
    public static String maskPhone(String phone) {
        return phone.substring(0, 2) + "-* * * * * *-" + phone.substring(phone.length() - 2);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter your mail address: ");
        String email = scan.nextLine();
        System.out.println();

        System.out.print("Enter your Aadhar number: ");
        String aadhar = scan.nextLine();
        System.out.println();

        System.out.print("Enter your phone number: +91-");
        String phone = scan.nextLine();
        System.out.println();

        System.out.println("Masked Email: " + maskEmail(email));

        System.out.println("Masked Aadhar: " + maskAadharCard(aadhar));

        System.out.println("Masked Phone: +91 " + maskPhone(phone));
    }
}