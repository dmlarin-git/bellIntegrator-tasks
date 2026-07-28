package test.ru;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class task1streamAPI {
    public static void main(String[] args) {
        // ==== 1 ==== Заполняем базу сотрудников (в реальности считываем с БД или json)
        List<Map<String, String>> employees = new ArrayList<>();

        String column1 = "Имя";
        String column2 = "Возраст";
        String column3 = "Должность";
        String column4 = "Зарплата";

        // инициализируем список для дальнейшей работы с ним
        employeesInit(employees, column1, column2, column3, column4);

        // выводим всех сотрудников
        System.out.println("=========== База сотрудников ===========");
        System.out.printf("%-15s %-15s %-32s %-20s%n", column1, column2, column3, column4);
        for (Map<String, String> row : employees) {
            System.out.printf("%-15s %-15s %-32s %-20s%n",
                    row.get(column1), row.get(column2), row.get(column3), row.get(column4));
        }

        // ==== 2 ==== выполняем поиск нужных значений задачи
        double averageAgeEmployees = employees.stream()
                .map(row -> row.get("Возраст"))
                .mapToInt(Integer::parseInt)
                .average()
                .orElse(0);

        List<String> nameEmployeesLess30 = employees.stream()
                .filter(row -> Integer.parseInt(row.get("Возраст")) < 30)
                .map(row -> row.get("Имя"))
                .toList();

        List<String> nameEmployeesSalaryRub = employees.stream()
                .filter(row -> row.get("Зарплата").contains("₽"))
                .map(row -> row.get("Имя")).toList();

        // теперь выводим итоговые значения
        System.out.println("\n----------- РЕЗУЛЬТАТ: -----------");
        System.out.printf("Средний возраст всех сотрудников: %.1f лет.%n", averageAgeEmployees);
        System.out.printf("Сотрудники, младше 30 лет: %s%n", nameEmployeesLess30);
        System.out.printf("Сотрудники, получающие зарплату в рублях: %s%n", nameEmployeesSalaryRub);
    }

    // инициализация массива (в реальности может быть через БД или json)
    public static void employeesInit(List<Map<String, String>> employees,
                                     String column1, String column2, String column3, String column4) {
        // строка 1
        Map<String, String> row1 = new HashMap<>();
        row1.put(column1, "Максим");
        row1.put(column2, "32");
        row1.put(column3, "Middle java dev");
        row1.put(column4, "$ 1200");
        employees.add(row1);

        // строка 2
        Map<String, String> row2 = new HashMap<>();
        row2.put(column1, "Иван");
        row2.put(column2, "25");
        row2.put(column3, "Junior java dev");
        row2.put(column4, "50000 ₽");
        employees.add(row2);

        // строка 3
        Map<String, String> row3 = new HashMap<>();
        row3.put(column1, "Мария");
        row3.put(column2, "35");
        row3.put(column3, "Senior java automation QA");
        row3.put(column4, "160000 ₽");
        employees.add(row3);

        // строка 4
        Map<String, String> row4 = new HashMap<>();
        row4.put(column1, "Петр");
        row4.put(column2, "28");
        row4.put(column3, "Dev-ops");
        row4.put(column4, "$ 1700");
        employees.add(row4);

        // строка 5
        Map<String, String> row5 = new HashMap<>();
        row5.put(column1, "Анна");
        row5.put(column2, "31");
        row5.put(column3, "Middle functional tester");
        row5.put(column4, "€ 1100");
        employees.add(row5);

        // строка 6
        Map<String, String> row6 = new HashMap<>();
        row6.put(column1, "Кирилл");
        row6.put(column2, "36");
        row6.put(column3, "Senior java dev");
        row6.put(column4, "€ 2500");
        employees.add(row6);

        // строка 7
        Map<String, String> row7 = new HashMap<>();
        row7.put(column1, "Дмитрий");
        row7.put(column2, "22");
        row7.put(column3, "Junior java automation Q");
        row7.put(column4, "45000 ₽");
        employees.add(row7);
    }
}
