/**
 * Created by Shikhar on 31-03-2019.
 */
public class Hck3 {
    int id ;
    String name;

    public Hck3(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Hck3{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


}
class TestEm{
    public static void main(String[] args) {
        Hck3 hck3 = new Hck3(1,"ABC");
        System.out.println(hck3);

        changeStep1(hck3);
        System.out.println(hck3);
        changeStep2(hck3);
        System.out.println(hck3);
        changeStep3(hck3);
        System.out.println(hck3);

    }


    static void changeStep1(Hck3 hck3){
        hck3.setId(2);
        hck3.setName("AAA");
    }

    static Hck3 changeStep2(Hck3 hck3){
        return new Hck3(3,"BBB");
    }

    static void changeStep3(Hck3 hck3){
        hck3 = new Hck3(4,"CCC" );
    }
}

