import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shikhar on 28-05-2018.
 */
public class Clone {

    public static void main(String[] args) throws IOException {

        try {
            FileOutputStream fileOutputStream=new FileOutputStream("hjebajh");
            List adas= new ArrayList<>();
            new ObjectOutputStream(fileOutputStream).writeObject(adas);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
