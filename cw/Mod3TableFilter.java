import java.io.*;

/**
 * A Java application to demonstrate the Mod3Table class 
 * by using it to filter the input stream. Those lines
 * that are accepted by Mod3Table are echoed to the
 * standard output.
 */
public class Mod3TableFilter {
  public static void main(String[] args) 
        throws IOException {

    Mod3Table m = new Mod3Table(); // DFA
    File file = new File("numbers.txt");
    BufferedReader in =  // Standard input
      new BufferedReader(new FileReader(file));

    // Read and echo lines until EOF

    String s = in.readLine();
    while (s!=null) {
      m.reset();
      m.process(s);
      if (m.accepted()) System.out.println(s);
      s = in.readLine();
    }
  }
}
