import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // write your code here
        OnlineShop onlineShop = new OnlineShop("Emag", "logo.jpg", new ArrayList<Product>());

        Product product1 = new Product("Laptop", 3200.5, 1, 1, 1123, "");
        Product product2 = new Product("Frigider", 207.95, 1, 2, 1245, "");

        Product product3 = new Product(product1);

        product3.setQty(5);
        product3.setName("Paine");

        onlineShop.addProduct(product1);
        onlineShop.addProduct(product2);

        onlineShop.deleteProduct(product1);
        System.out.println(product1.equals(product2));
    }
}

class OnlineShop {
    private String name;
    private String imageUrl;
    private ArrayList<Product> products;

    OnlineShop(String name, String imageUrl, ArrayList<Product> products) {
        this.products = products;
        this.imageUrl = imageUrl;
        this.name = name;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void deleteProduct(Product product) {
        this.products.remove(product);
    }

    /*
    public void modifyProductsList(int what, Product p) {
        if (what == 1) {
            this.products.add(p);
        } else
            this.products.remove(p);
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

class Product {
    private int id;
    private String name;
    private double price;
    private int type;
    private int category;
    private int qty;
    private String expirationDate; //expiry date - only for goods
    private String details; // ex.: processor, memory, power, volume (for refrigerators etc)

    public Product(String name, double price, int type, int category, int id, String expirationDate) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.category = category;
        this.id = id;
        this.expirationDate = expirationDate;
    }

    public Product(Product originalProduct) {
        this.name = originalProduct.name;
        this.price = originalProduct.price;
        this.type = originalProduct.type;
        this.category = originalProduct.category;
        this.id = originalProduct.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }


    // this method checks to see it 2 products have the same: id, name, price, type and category
    public boolean equals(Product p) {
        if (p.id != this.id)
            return false;
        if (!p.name.equals(this.name))
            return false;
        if (p.price != this.price)
            return false;
        if (p.type != this.type)
            return false;
        if (p.category != this.category)
            return false;
        return true;
    }

    // function should take in a number between (-1,1)
    public void modifyPrice(double value) {
        this.price += this.price * value;
    }

    // function can take in any number and compute it as a percentage increase/decrease
    public void modifyPricePercentage(double value) {
        this.price += this.price * value / 100;
    }

    /*
    public void modify(boolean flag, double val) {
        if (flag)
            this.productPrice += this.productPrice * val;
        if (!flag)
            this.productPrice -= this.productPrice * val / 100;
    }*/

}

class User {
    private String name;
    private String id;
    private ArrayList<Order> orders;
    private ArrayList<Order> completedOrders;

    public User(String name, String id) {
        this.name = name;
        this.id = id;
        orders = new ArrayList<Order>();
        completedOrders = new ArrayList<Order>();
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public void addCompletedOrder(Order order) {
        this.completedOrders.add(order);
    }
}

class Order {
    private ArrayList<Product> products;
    private String address;

    public Order() {
        products = new ArrayList<Product>();
    }

    public void addProduct(Product product) {
        if (products.size() > 99)
            return;
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

class InventoryProduct {
    private Product product;
    private int quantity;

    public InventoryProduct(Product product, int quantity) {
        this.product = new Product(product);
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}


