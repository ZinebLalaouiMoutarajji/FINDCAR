package eu.basicairdata.graziano.gpslogger.Model;



public class Category {

    private String Name;
    private String Image;
    private int Id;

    public Category() {
    }

    public Category(String name, String image, int id) {
        Name = name;
        Image = image;
        Id = id;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
