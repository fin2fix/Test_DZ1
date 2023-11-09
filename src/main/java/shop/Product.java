package shop;

public class Product {

    public Product(Integer cost, String title) {
        this.cost = cost;
        this.title = title;
    }

    private Integer cost; // Стоимость продукта
    private String title; // Название

    // Геттеры, сеттеры:
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object obj) {

        // If the object is compared with itself then return true, if the Class is different then return false
        if (obj == this) {
            return true;
        } else if (!(obj instanceof Product)) {
            return false;
        }
        Product prod = (Product) obj;  // typecast o to Product so that we can compare data members
        return this.cost.equals(prod.getCost()) && this.title.equals(prod.getTitle());
    }

    @Override
    public String toString() {
        return "Продукт " + this.title + "  Стоимостью: " + this.cost;
    }
}