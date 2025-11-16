public abstract class User {
    protected int userID;
    protected String name;
    protected String phoneNum;
    protected String email;

    public User(int userID, String name, String phoneNum, String email) {
        this.userID = userID;
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    public int getUserID() { return userID; }
    public String getName() { return name; }
    public String getPhoneNum() { return phoneNum; }
    public String getEmail() { return email; }
}
