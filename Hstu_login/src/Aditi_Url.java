import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Aditi_Url {
      public Aditi_Url(){
          try {
              Desktop.getDesktop().browse(new URI("https://hstu.ac.bd/library"));
          } catch (IOException e) {
              throw new RuntimeException(e);
          } catch (URISyntaxException e) {
              throw new RuntimeException(e);
          }
      }

    public static void main(String[] args) {

      // Url n=new Url();

    }
}
