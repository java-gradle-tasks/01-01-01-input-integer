   import org.junit.jupiter.api.Assertions;
   import org.junit.jupiter.api.Test;

   import java.io.ByteArrayInputStream;
   import java.io.ByteArrayOutputStream;
   import java.io.InputStream;
   import java.io.PrintStream;

   public class TestInput {

      @Test
      public void testInput() {
         
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

         String outStream="Adja meg a szuletesi evet:";
         String expected=outStream;

         String actual=byteArrayOutputStream.toString();

         boolean found=actual.contains(expected);

         Assertions.assertTrue(found,"Hianyzik az input a kodbol vagy az input szovege nem megfelelo!");
      }
   }
