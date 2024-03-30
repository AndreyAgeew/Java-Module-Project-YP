package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    private List<Item> items = new ArrayList<>();
    private double totalAmount = 0;

    public void addItem(Item item) {
        items.add(item);
        totalAmount += item.getPrice();
    }

    public void displayItems() {
        System.out.println("Добавленные товары:");
        for (Item item : items) {
            System.out.println(item.getName() + " - " + item.getPrice() + " руб.");
        }
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите название товара или 'Завершить' для завершения:");
            String itemName = scanner.nextLine();

            if (itemName.equalsIgnoreCase("Завершить")) {
                break;
            }

            System.out.println("Введите стоимость товара (в формате рубли.копейки):");
            double price = scanner.nextDouble();
            scanner.nextLine();

            Item item = new Item(itemName, price);
            addItem(item);
            System.out.println("Товар успешно добавлен в калькулятор.");
            System.out.println("Хотите добавить ещё один товар? (Да/Нет)");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("Да")) {
                break;
            }
        }

        displayItems();
        System.out.println("Общая сумма всех товаров: " + getTotalAmount() + " руб.");
    }
}
