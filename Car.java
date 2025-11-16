public class Car {
    private int carID;
    private String plate;
    private String carType;
    private String color;
    private int seats;
    private int driverID;

    public Car(int carID, String plate, String carType, String color, int seats, int driverID) {
        this.carID = carID;
        this.plate = plate;
        this.carType = carType;
        this.color = color;
        this.seats = seats;
        this.driverID = driverID;
    }

    public int getCarID() { return carID; }
    public String getPlate() { return plate; }
    public String getCarType() { return carType; }
    public String getColor() { return color; }
    public int getSeats() { return seats; }
    public int getDriverID() { return driverID; }
}
