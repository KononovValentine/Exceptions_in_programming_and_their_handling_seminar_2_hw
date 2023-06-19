import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        getFloat();
        task2();
        task3();
    }

    // Задание 1
    // Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает
    // введенное значение. Ввод текста вместо числа не должно приводить к падению приложения, вместо этого,
    // необходимо повторно запросить у пользователя ввод данных.

    // Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
    // Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

    public static float getFloat() {
        Scanner scanner = new Scanner(System.in);
        float number = 0;
        while (true) {
            System.out.println("Введите дробное число: ");
            String input = scanner.nextLine();
            if (isNumeric(input)) { // если во вводе число цикл остановится
                number = Float.parseFloat(input);
                break;
            } else if (input == "") { // пробросил трай кетч чтобы выполнение кода не прерывалось
                try {
                    throw new Exception();
                } catch (Exception e) {
                    System.out.println("Поле ввода не должно быть пустым!");
                }
            } else { // в любом другом случае возврат к началу цикла
                System.out.println("Неверный ввод, требуется дробное число!");
            }
        }
        System.out.println("Введенное число = " + number);
        return number;
    }

    // Проверка, является ли введенная строка числом через трай кетч
    public static boolean isNumeric(String strNum) {
        try {
            double d = Float.parseFloat(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

    // Задание 2
    // Часть 1
    // Если необходимо, исправьте данный код:

    public static void task2() { // Добавлен массив, убрано деление на 0
        try {
            int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
            int d = 1;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }


    // Часть 2
    // Дан следующий код, исправьте его там, где требуется:
    public static void task3() { // Изменен порядок обработки ошибок, исправлен размер массива
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = {1, 2, 3, 4};
            abc[3] = 9;
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }

    }

    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
        System.out.println(a + b);
    }

}
