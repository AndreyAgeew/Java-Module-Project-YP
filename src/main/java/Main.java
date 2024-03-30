import java.util.Scanner;

import calculator.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("На скольких человек разделить счет?");
        Scanner scanner = new Scanner(System.in);
        int peopleCounter;
        do {
            peopleCounter = scanner.nextInt();
            if (peopleCounter <= 1) {
                System.out.println("На такое количество людей нельзя разделить счет!");
            }
        } while (peopleCounter <= 1);

        Calculator calculator = new Calculator(peopleCounter);
        calculator.start();

    }

}
