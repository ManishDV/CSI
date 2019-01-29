package testapp.example.com.csi;

public class EthusiaEvents {

    int id, maxParticipent;
    String name;
    String description;
    float price;

    public EthusiaEvents() {
    }

    public EthusiaEvents(int id, int maxParticipent, String name, String description, float price) {
        this.id = id;
        this.maxParticipent = maxParticipent;
        this.name = name;
        this.description = description;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxParticipent() {
        return maxParticipent;
    }

    public void setMaxParticipent(int maxParticipent) {
        this.maxParticipent = maxParticipent;
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
