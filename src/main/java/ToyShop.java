import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class ToyShop {
    public static void main(String[] args) {
        PriorityQueue<Toy> toysQueue = new PriorityQueue<>((t1, t2) -> t2.getFrequency() - t1.getFrequency());

        addToy(toysQueue,"Игрушка 1", 5, 3);
        addToy(toysQueue,"Игрушка 2", 3, 1);
        addToy(toysQueue,"Игрушка 3", 7, 5);

        List<Toy> toys = new ArrayList<>();
        // Играем до тех пор, пока не останется игрушек
        while (!toysQueue.isEmpty()) {
            Toy toy = playToy(toysQueue);
            if (toy != null) {
                System.out.println(toy);
                toys.add(toy);
            }
        }

        getToy(toys);
    }

    private static void getToy(List<Toy> toys) {
        try (FileWriter writer = new FileWriter("src/main/java/result.txt")) {
            for (Toy toy : toys) {
                writer.write("ID: " + toy.getId() + ", Название: " + toy.getName() + ", Частота: " + toy.getFrequency() + "%\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Toy playToy(PriorityQueue<Toy> toysQueue) {
        Random random = new Random();
        for (Toy toy : toysQueue) {
            if (random.nextInt(100) <= toy.getFrequency()) {
                toy.setQuantity(toy.getQuantity() - 1);
                if (toy.getQuantity() == 0) {
                    toysQueue.remove(toy);
                }
                return toy;
            }
        }
        System.out.println("Увы, вам не повезло.");
        return null;
    }

    private static void addToy(PriorityQueue<Toy> toysQueue, String name, int frequency, int quantity) {
        toysQueue.add(new Toy(name, frequency, quantity));
    }
}
