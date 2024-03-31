import java.util.InputMismatchException;
import java.util.Scanner;

import calculator.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("На скольких человек разделить счет?");
        Scanner scanner = new Scanner(System.in);
        int peopleCounter;

        while (true) {
            try {
                peopleCounter = scanner.nextInt();
                if (peopleCounter <= 1) {
                    System.out.println("На такое количество людей нельзя разделить счет!");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введите целое число.");
                scanner.nextLine();
            }
        }


        Calculator calculator = new Calculator(peopleCounter);
        calculator.start();

    }

}
