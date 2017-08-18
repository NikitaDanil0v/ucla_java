package JavaCP;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Nikit on 17.08.2017.
 */
public class JavaCP {
    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Source:");
        String src = scan.next();
        System.out.println("Destination:");
        String dest = scan.next();

        try {
            FileInputStream is = new FileInputStream(new File(src));

            InputStreamReader reader = new InputStreamReader(is);
            BufferedReader in = new BufferedReader(reader);

            FileOutputStream outputStream = new FileOutputStream(dest);
            OutputStreamWriter writer = new OutputStreamWriter(outputStream);

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                writer.write(inputLine);
                writer.write("\n");
            }

            in.close();
            writer.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}