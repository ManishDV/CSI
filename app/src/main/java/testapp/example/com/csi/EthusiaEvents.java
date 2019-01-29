package testapp.example.com.csi;

public class EthusiaEvents {

    int id;
    String name;
    String description;
    float price;


    public EthusiaEvents(){};
    public EthusiaEvents(int id, String name, String disp, float price) {
        this.id = id;
        this.name = name;
        this.description = disp;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }




}
