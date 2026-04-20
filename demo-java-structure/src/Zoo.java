import java.util.ArrayList;

public class Zoo<T extends Animal> {
  private ArrayList<T> animals; // array only ADD no set

  public Zoo(T animals) {
    this.animals = new ArrayList<>();
  }

  public ArrayList<T> getAnimals() {
    return this.animals;
  }

  public boolean add(T animal) {
    return this.animals.add(animal);
  }

  public static void main(String[] args) {
    // ! Runtime -> Define T
    Zoo<Tiger> zoo1 = new Zoo<>();
    zoo1.add(new Tiger());
    Zoo<Panda> zoo2 = new Zoo<>();
    zoo2.add(new Panda());
    Zoo<Animal> zoo3 = new Zoo<>();
    zoo3.add(new Tiger());
    zoo3.add(new Panda());

  }
}