/**
 * Created by Shikhar on 10-06-2018.
 */
abstract class Animal {
    protected boolean isMammal;
    protected boolean isCarnivorous;

    public Animal(boolean isMammal, boolean isCarnivorous) {
        this.isMammal = isMammal;
        this.isCarnivorous = isCarnivorous;
    }

    public boolean getIsMammal() {
        return this.isMammal;
    }

    public boolean getIsCarnivorous() {
        return this.isCarnivorous;
    }

    abstract public String getGreeting();

    public void printAnimal(String name) {
        System.out.println(
                "A " + name + " says '" + this.getGreeting()
                        + "', is " + (this.getIsCarnivorous() ? "" : "not ")
                        + "carnivorous, and is " + (this.getIsMammal() ? "" : "not ") + "a mammal."
        );
    }
}

class Dog extends Animal{


    protected Dog() {
        super(true,true);
    }


    public String getGreeting(){
        return "ruff";
    }
}

 class Solution3 {

    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.printAnimal("dog");


    }
}