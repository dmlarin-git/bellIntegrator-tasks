package test.ru;

import java.util.List;
import java.util.Stack;

public class task3 {
    public static void main(String[] args) {
        String str = "[{{}}]";
        List<Character> leftBrackets = List.of('{', '[');

        boolean correctBrackets = true;
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            // Если это левые скобки, то складываем в стек
            if (leftBrackets.contains(c)) {
                stack.push(c);
            } else {
                // Если стек пустой, то не с чем сравнивать и нет пары для скобки
                if (stack.empty()) {
                    correctBrackets = false;
                    break;
                }
                char currentBracket = stack.pop();
                if (!(currentBracket == '{' && c == '}') &&
                    !(currentBracket == '[' && c == ']')) {
                    correctBrackets = false;
                    break;
                }
            }
        }

        System.out.printf("Последовательность скобок \"%s\" является %s.%n",
                str, correctBrackets ? "корректной" : "некорректной");
    }
}
