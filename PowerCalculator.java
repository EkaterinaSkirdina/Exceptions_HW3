import java.util.InputMismatchException;
import java.util.Scanner;

/**
 Задача1. Напишите программу-калькулятор, которая запрашивает у пользователя два числа и выполняет операцию 
 возведения первого числа в степень второго числа. Если введены некорректные числа или происходит деление на 
 ноль, необходимо обработать соответствующие исключения и вывести информативное сообщение об ошибке.
 Важно! С использованием принципа одного уровня абстракции!
** В этой задаче мы создаем класс PowerCalculator, который содержит метод calculatePower(), выполняющий операцию
 возведения числа в степень. Если введено некорректное основание (ноль) и отрицательная степень, выбрасывается 
 исключение InvalidInputException.
 В методе main() мы запрашиваем у пользователя основание и показатель степени, вызываем метод calculatePower() 
 и выводим результат. Если введены некорректные числа или происходит ошибка ввода, соответствующие исключения 
 перехватываются и выводится информативное сообщение об ошибке.
 Обратите внимание, что в этой задаче мы использовали собственное исключение InvalidInputException, 
 чтобы явно указать на некорректный ввод. Это помогает разделить обработку ошибок на соответствующие 
 уровни абстракции.**
 */

 public class PowerCalculator {
    public static void main(String[] args) {
        double num1 = getNumber("Введите основание: ");
        double num2 = getNumber("Введите степень: ");
        try {
            double result = calculatePower(num1, num2);
            System.out.println(num1 + "**" + num2 + " = " + result);
        } catch (InvalidInputException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

    }

    public static double calculatePower(double a, double b) throws InvalidInputException {
        if (a == 0) throw new InvalidInputException("Ноль нельзя возвести в степень.");
        if (b < 0) throw new InvalidInputException("Степень не может быть отрицательной.");
        return Math.pow(a, b);
    }

    public static double getNumber(String prompt) {
        Scanner scanner = new Scanner(System.in);
        double num;
        while (true) {
            try {
                System.out.println(prompt);
                num = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод.");
                scanner.nextLine();
            }
        }
        return num;
    }


 }
 class InvalidInputException extends Exception {
    public InvalidInputException(String message){
        super(message);
    }
 }