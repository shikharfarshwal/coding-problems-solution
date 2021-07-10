public class Sachin {

    Shikhar shikhar;

    public Sachin(Shikhar shikhar) {
        this.shikhar = new Shikhar(shikhar.name);
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Shikhar shikhar = new Shikhar("shikhar");
        Shikhar shikhar2 = shikhar;

        System.out.println(shikhar.hashCode());
        System.out.println(shikhar2.hashCode());

        shikhar2.name = "sachin";
        System.out.println(shikhar.name);
        System.out.println(shikhar2.name);

        Shikhar shikhar3 = new Shikhar();
        shikhar3.name = shikhar.name;
        System.out.println(shikhar3);


        shikhar.name = "abc";

       /* Shikhar shikhar3 = (Shikhar) shikhar.clone();
        shikhar3.name = "choudhary";
        System.out.println(shikhar3.name);
        System.out.println(shikhar.name);
        System.out.println(shikhar2.name);


        Naming naming = new Naming(shikhar);
        System.out.println(naming);
        naming.shikhar = shikhar2;
        System.out.println(naming);*/

    }
}


class Naming {

    Shikhar shikhar;

    public Naming(Shikhar shikhar) {
        this.shikhar = new Shikhar(shikhar.name);
    }

    @Override
    public String toString() {
        return "Naming{" +
                "shikhar=" + shikhar +
                '}';
    }
}

class Shikhar implements Cloneable {

    String name;

    public Shikhar(String name) {
        this.name = name;
    }

    public Shikhar() {
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Shikhar{" +
                "name='" + name + '\'' +
                '}';
    }
}
