package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    private List<Item> items = new ArrayList<>();
    private double totalAmount = 0;
    private int peopleCounter;

    public Calculator(int peopleCounter) {
        this.peopleCounter = peopleCounter;
    }

    public void addItem(Item item) {
        items.add(item);
        totalAmount += item.getPrice();
    }

    private void displayItems() {
        System.out.println("Добавленные товары:");
        for (Item item : items) {
            System.out.println(item.getName() + " - " + item.getPrice() + " руб.");
        }
    }

    private double getTotalAmount() {
        return totalAmount;
    }


    private void displayTotalAmount() {
        double totalAmount = getTotalAmount();
        int rubles = (int) totalAmount;
        int kopecks = (int) ((totalAmount - rubles) * 100);

        String rublesWord = getRublesWord(rubles);
        String kopecksWord = getKopecksWord(kopecks);

        System.out.println("Общая сумма всех товаров: " + rubles + " " + rublesWord + " " + kopecks + " " + kopecksWord);
    }

    private void displayTotalAmountPerPerson() {
        double totalAmount = getTotalAmount()/peopleCounter;
        int rubles = (int) totalAmount;
        int kopecks = (int) ((totalAmount - rubles) * 100);

        String rublesWord = getRublesWord(rubles);
        String kopecksWord = getKopecksWord(kopecks);

        System.out.println("Каждому нужно заплатить: " + rubles + " " + rublesWord + " " + kopecks + " " + kopecksWord);
    }

    private String getRublesWord(int rubles) {
        int lastDigit = rubles % 10;
        int lastTwoDigits = rubles % 100;
        String rublesWord = "рублей";
        if (lastTwoDigits >= 11 && lastTwoDigits <= 14) {
            rublesWord = "рублей";
        } else if (lastDigit == 1) {
            rublesWord = "рубль";
        } else if (lastDigit >= 2 && lastDigit <= 4) {
            rublesWord = "рубля";
        }
        return rublesWord;
    }


    private String getKopecksWord(int kopecks) {
        String kopecksWord = "копеек";
        if (kopecks == 1) {
            kopecksWord = "копейка";
        } else if (kopecks >= 2 && kopecks <= 4) {
            kopecksWord = "копейки";
        }
        return kopecksWord;
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
        }

        displayItems();
        displayTotalAmount();
        displayTotalAmountPerPerson();

    }
}
