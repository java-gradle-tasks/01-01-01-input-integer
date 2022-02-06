   import org.junit.jupiter.api.Assertions;
   import org.junit.jupiter.api.Test;

   import java.io.ByteArrayInputStream;
   import java.io.ByteArrayOutputStream;
   import java.io.InputStream;
   import java.io.PrintStream;

   public class TestInput {

      @Test
      public void testInput() {
         InputStream stdin = System.in;

         int expectedYear=2099;

         String input=String.valueOf(expectedYear)+"\r\n";
         System.setIn(new ByteArrayInputStream(input.getBytes()));

         ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
         PrintStream ps = new PrintStream(byteArrayOutputStream);
         PrintStream stdout = System.out;
         System.setOut(ps);

         MyYearOfBirth.main(new String[0]);

         System.setIn(stdin);
         System.setOut(stdout);

         String outStream="Adja meg a szuletesi evet:";
         String actual=byteArrayOutputStream.toString();

         String expected=outStream+String.valueOf(expectedYear)+"\r\n";

         System.out.println(actual);
         System.out.println(expected);
         Assertions.assertEquals(actual,expected,"Hianyzik az input a kodbol");
      }
   }
