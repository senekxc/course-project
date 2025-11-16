import java.time.LocalDateTime;

public class Receipt {

    private int receiptID;
    private Order order;
    private double basePrice;
    private double extrasPrice;
    private double discount;
    private double finalPrice;
    private LocalDateTime generatedAt;

    public Receipt(int receiptID, Order order,
                   double basePrice, double extrasPrice,
                   double discount, double finalPrice) {
        this.receiptID = receiptID;
        this.order = order;
        this.basePrice = basePrice;
        this.extrasPrice = extrasPrice;
        this.discount = discount;
        this.finalPrice = finalPrice;
        this.generatedAt = LocalDateTime.now();
    }

    // ===== ГЕТТЕРИ =====

    public int getReceiptID() { return receiptID; }

    public Order getOrder() { return order; }

    public double getBasePrice() { return basePrice; }

    public double getExtrasPrice() { return extrasPrice; }

    public double getDiscount() { return discount; }

    public double getFinalPrice() { return finalPrice; }

    public LocalDateTime getGeneratedAt() { return generatedAt; }

    public void printReceipt() {
        System.out.println("Receipt #" + receiptID);
        System.out.println("Order: " + order.getOrderID());
        System.out.println("Client: " + order.getClient().getName());
        System.out.println("Base price: " + basePrice);
        System.out.println("Extras: " + extrasPrice);
        System.out.println("Discount: " + discount);
        System.out.println("Final price: " + finalPrice);
        System.out.println("Generated at: " + generatedAt);
    }
}
