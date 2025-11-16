public class Driver extends User {
    private String licenseNo;
    private double rating;
    private boolean active;

    public Driver(int userID, String name, String phoneNum, String email, String licenseNo, double rating, boolean active) {
        super(userID, name, phoneNum, email);
        this.licenseNo = licenseNo;
        this.rating = rating;
        this.active = active;
    }

    public String getLicenseNo() { return licenseNo; }
    public double getRating() { return rating; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
    public int getDriverID() {return userID; }
    public void receiveOrder(Order order) {
        System.out.println("Driver " + name + " received order " + order.getOrderID());
    }

    public void confirmOrder(Order order) {
        order.setStatus(Order.OrderStatus.ASSIGNED);
        System.out.println("Driver " + name + " confirmed order " + order.getOrderID());
    }

    public void completeOrder(Order order) {
        order.setStatus(Order.OrderStatus.COMPLETED);
        System.out.println("Driver " + name + " completed order " + order.getOrderID());
    }

    public void updateRating(double newRating) {
        this.rating = (this.rating + newRating) / 2.0;
    }
}
