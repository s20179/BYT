package Mediator;

public class Students {

    private String name;
    private String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Students(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public void introduce(String sentence){
        ClassRoom.introduce(this,sentence);
    }
}
