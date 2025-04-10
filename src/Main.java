import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        passwordMenu();
        System.out.println("Программа завершена!");

    }

    public static void passwordMenu() {
        Scanner scanner = new Scanner(System.in);

        PasswordCheker cheker = new PasswordCheker();
        try {
            System.out.print("Введите мин. длину пароля: ");
            int minLengthOfPassword = scanner.nextInt();
            System.out.println();
            cheker.setMinLength(minLengthOfPassword);
            System.out.print("Введите макс. допустимое количество повторений символа подряд: ");
            int maxLengthOfRepeat = scanner.nextInt();
            System.out.println();
            cheker.setMaxRepeat(maxLengthOfRepeat);
        } catch (IllegalArgumentException e) {
            System.out.println();
            System.out.println("Кажется вы ввели недопустмые значения для проверки паролей! Ради безопастности завершаем программу...");
            return;
        }
        scanner.nextLine();

        while (true) {
            System.out.print("Введите пароль или end: ");
            String input = scanner.next();
            if ("end".equals(input)) {
                return;
            }

            try {
                if (cheker.verify(input)) {
                    System.out.println("Подходит!");
                } else {
                    System.out.println("Не подходит!");
                }
            } catch (IllegalStateException e) {
                System.out.println("Не заполнены данные о проверки паролей!");
                return;
            }
            System.out.println();
        }
    }
}