package groupproject484;

public class ClubMember {
    private String name;
    private String phone;
    private String street;
    private String city;
    private String state;
    private String zip;
    private static int nextID = 0;
    private int ID;
    
    public ClubMember(String name, String phone, String street, String city, String state, String zip) {
        this.name = name;
        this.phone = phone;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.ID = nextID;
        nextID++;
    }
    
    public ClubMember(int ID, String name, String phone, String street, String city, String state, String zip) {
        this.name = name;
        this.phone = phone;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.ID = ID;
        nextID = ID;
        nextID++;
    }
}