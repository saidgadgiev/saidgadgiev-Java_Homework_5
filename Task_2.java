import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Task_2 {
    public static void main(String[] args) {
        List<String> employees = new ArrayList<>();
        employees.add("Иван Иванов");
        employees.add("Светлана Петрова");
        employees.add("Кристина Белова");
        employees.add("Анна Мусина");
        employees.add("Анна Крутова");
        employees.add("Иван Юрин");
        employees.add("Петр Лыков");
        employees.add("Павел Чернов");
        employees.add("Петр Чернышов");
        employees.add("Мария Федорова");
        employees.add("Марина Светлова");
        employees.add("Мария Савина");
        employees.add("Мария Рыкова");
        employees.add("Марина Лугова");
        employees.add("Анна Владимирова");
        employees.add("Иван Мечников");
        employees.add("Петр Петин");
        employees.add("Иван Ежов");

        Map<String, Integer> nameCount = new HashMap<>();

        for (String employee : employees) {
            String name = employee.split(" ")[0];
            Integer count = nameCount.get(name);
            if (count == null) {
                count = 0;
            }
            nameCount.put(name, count + 1);
        }

        nameCount.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));

    }

}

