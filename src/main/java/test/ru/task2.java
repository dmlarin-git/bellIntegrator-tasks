package test.ru;

public class task2 {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 8, 2, 2, 13},
                {6, 7, 33, 11, 12},
                {3, 2, 24, 5, -2},
                {75, 68, 9, 5, 0},
                {2, 88, 55, -5, 56}
        };

        System.out.println("Исходный массив:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%-5d", arr[i][j]);
            }
            System.out.println();
        }

        // Поиск минимального по диагонали
        int N = arr.length;
        int medN = N / 2 + 1;
        int min = arr[0][N-1];
        for (int i = 1; i < N; i++) {
            if (i != medN - 1) { // если не пересечение диагоналей
                if (min > arr[i][N-i-1]) {
                    min = arr[i][N-i-1];
                }
            }
        }

        System.out.println("Минимальный элемент диагонали в таблице = " + min);
    }
}
