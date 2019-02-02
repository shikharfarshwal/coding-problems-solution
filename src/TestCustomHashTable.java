/**
 * Created by Shikhar on 26-01-2019.
 */
public class TestCustomHashTable {

    public static void main(String[] args) {

        CustomHashTable<String, String> customHashTable = new CustomHashTable<>(50);
        customHashTable.set("Lipi","Pili");
        System.out.println(customHashTable.get("Lipi").get());
    }
}
