
public class Main {
    public static void main(String[] args) {

        // Задание 1 - общая сумма чисел от 0 до 1000
        int sum = 0;
        for (int i = 0; i <= 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        System.out.println("Общая сумма чисел: " + sum);

        // Задание 2 - поиск мин элемента среди всех элементов массива
        int[][] nums = {{20, 34, 2}, {9, 12, 18}, {3, 4, 5}};
        int min = nums[0][0];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (nums[i][j] < min) {
                    min = nums[i][j];
                }
            }
        }
        System.out.println("Минимальный элемент массива: " + min);

        }
    }
