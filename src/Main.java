import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Dni d = new Dni(18957690, 'D');
        System.out.println(d.toFormattedString());

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a DNI");
        String s = input.next();
        Dni dni = new Dni(s);
        if (dni.isCorrect()) {
            System.out.println("Dni correct");
        } else {
            System.out.println("Wrong DNI");
        }
    }
}
