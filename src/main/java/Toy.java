public class Toy {
    private int id;
    private static int count = 0;
    private String name;
    private int frequency;
    private int quantity;

    public Toy(String name, int frequency) {
        count++;
        this.id = count;
        this.name = name;
        this.frequency = frequency;
        quantity = 1;
    }
    public Toy(String name, int frequency, int quantity) {
        this(name, frequency);
        this.quantity = quantity;
    }

    // геттеры и сеттеры
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Название: " + name + ", Частота: " + frequency + "%\n";
    }
}
