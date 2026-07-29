package test.ru;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Person implements Basket {
    private final int id;
    private String name;
    private double balance;
    private HashMap<String, Integer> productsBasket;

    public Person(int id, String name, double balance) {
        this.id = id;
        setName(name);
        setBalance(balance);
        productsBasket = new HashMap<>();
    }

    public Person(int id, String name) {
        this(id, name, 0.0);
    }

    // GETTERS
    public int getId() { return id; }
    public String getName() { return name; }
    public double getBalance() { return balance; }
    public HashMap<String, Integer> getProductsBasket() { return productsBasket; }

    // SETTERS
    public void setName(String name) {
        if (name.isEmpty()) {
            this.name = "default";
        } else {
            this.name = name;
        }
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public void addProduct(String name, int quantity) {
        name = name.trim();
        if (name.isEmpty()) {
            System.err.println("Товар без названия не был добавлен в корзину.");
            return;
        }

        if (quantity <= 0) {
            System.err.printf("Товар \"%s\" не был добавлен в корзину. Возможно добавлять положительное количество.%n",
                    name);
            return;
        }

        // проверяем, есть ли такой продукт
        if (productsBasket.containsKey(name)) {
            // если есть, то берем текущее значение
            int current = productsBasket.get(name);
            // и добавляем новое (можно и перезаписать в зависимости от бизнес-логики)
            productsBasket.put(name, current + quantity);
        } else {
            productsBasket.put(name, quantity);
        }
    }

    @Override
    public void removeProduct(String product) {
        product = product.trim();
        if (product.isEmpty()) {
            return;
        }

        productsBasket.remove(product);
    }

    @Override
    public void updateProductQuantity(String product, int quantity) {
        product = product.trim();
        if (product.isEmpty()) {
            System.err.println("Не удалось обновить количество продукта, так как не указано его название.");
            return;
        }

        quantity = Math.max(quantity, 0);

        // реализуем вариант, когда при отсутствии такого товара новый не создается
        if (productsBasket.containsKey(product)) {
            productsBasket.put(product, quantity);
        } else {
            // логируем или выполняем другие операции
            System.out.println("Товар " + product + ", отсутсвует в корзине, обновление невозможно.");
        }
    }

    @Override
    public void clear() {
        productsBasket.clear();
    }

    @Override
    public List<String> getProducts() {
        if (productsBasket.isEmpty()) {
            return List.of();
        }

        return new ArrayList<>(productsBasket.keySet());
    }

    @Override
    public int getProductQuantity(String name) {
        name = name.trim();
        if (name.isEmpty() || !productsBasket.containsKey(name)) {
            return -1; // как обозначение, что некорректно введено или такого товара нет
        }

        return productsBasket.get(name);
    }
}