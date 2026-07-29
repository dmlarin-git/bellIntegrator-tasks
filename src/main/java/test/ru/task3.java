package test.ru;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class task3 {
    public static void main(String[] args) {
        // String str = "{()[]}";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите последовательность скобок: ");
        String str = scanner.next();

        System.out.printf("Последовательность скобок \"%s\" является %s.%n",
                str, balanceBrackets(str) ? "сбалансированной" : "несбалансированной");
    }

    // метод определения сбалансированной строки
    public static boolean balanceBrackets(String str) {
        List<Character> leftBrackets = List.of('{', '[', '(');

        boolean balanceBrackets = true;
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            // Если это левые скобки, то складываем в стек
            if (leftBrackets.contains(c)) {
                stack.push(c);
            } else {
                // Если стек пустой, то не с чем сравнивать и нет пары для скобки
                if (stack.empty()) {
                    return false;
                }
                char currentBracket = stack.pop();
                if (!(currentBracket == '{' && c == '}') &&
                        !(currentBracket == '[' && c == ']') &&
                        !(currentBracket == '(' && c == ')')) {
                    return false;
                }
            }
        }
        // Если в стеке остались скобки, то строка не является сбалансированной
        if (!stack.empty()) {
            return false;
        }

        return true;
    }
}
