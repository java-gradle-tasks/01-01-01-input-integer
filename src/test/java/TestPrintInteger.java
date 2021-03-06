import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class TestPrintInteger {

   @Test
   public void testPrintInteger () {
      
      String newLine="";
      if (System.getProperty("os.name").startsWith("Windows")) {
         newLine="\r\n";
      } else {
         newLine="\n";
      }

      InputStream stdin = System.in;

      int expectedYear=2099;

      String input=String.valueOf(expectedYear)+newLine;
      System.setIn(new ByteArrayInputStream(input.getBytes()));

      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      PrintStream ps = new PrintStream(byteArrayOutputStream);
      PrintStream stdout = System.out;
      System.setOut(ps);

      MyYearOfBirth.main(new String[0]);

      System.setIn(stdin);
      System.setOut(stdout);

      String actual=byteArrayOutputStream.toString();

      boolean found=actual.contains(input);

      Assertions.assertTrue(found,"Nem irta ki a kepernyore a bekert szamot!");
   }
}
