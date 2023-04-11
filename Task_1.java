import java.util.HashMap;
import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> phoneBook = new HashMap<>();

        System.out.println("Введите имя и телефоны через пробел, либо q для выхода:");

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("q")) {
                break;
            }

            String[] inputParts = input.split(" ");

            if (inputParts.length < 2) {
                System.out.println("Неверный формат ввода. Попробуйте еще раз.");
                continue;
            }

            String name = inputParts[0];
            String phones = "";

            for (int i = 1; i < inputParts.length; i++) {
                phones += inputParts[i] + ",";
            }

            phones = phones.substring(0, phones.length() - 1); // удаляем последнюю запятую

            if (phoneBook.containsKey(name)) {
                String existingPhones = phoneBook.get(name);
                phoneBook.put(name, existingPhones + ", " + phones);
            } else {
                phoneBook.put(name, phones);
            }

            System.out.println("Данные введены. Чтобы продолжить ввод, введите имя и телефоны, для завершения введите q:");
        }

        System.out.println("Телефонная книга:");
        for (String name : phoneBook.keySet()) {
            String phones = phoneBook.get(name);
            System.out.println(name + ": " + phones);
        }
    }
}
