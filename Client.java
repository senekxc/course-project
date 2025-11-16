public class Client extends User {
    private double discount;

    public Client(int userID, String name, String phoneNum, String email, double discount) {
        super(userID, name, phoneNum, email);
        this.discount = discount;
    }
    public int getClientID() { return userID; }
    public double getDiscount() { return discount; }
    public void setDiscount(double discount) { this.discount = discount; }
}
