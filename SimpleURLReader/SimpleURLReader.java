package SimpleURLReader;

import java.io.*;
import java.util.zip.*;
import java.net.URL;

/**
 * Created by Nikit on 17.08.2017.
 */
public class SimpleURLReader {
    public static void main(String[] args) throws Exception{

        URL address = new URL("https://www.uclaextension.edu");
        InputStream addr_is = address.openStream();
        InputStreamReader addr_reader = new InputStreamReader(addr_is);
        BufferedReader in =  new BufferedReader(addr_reader);

        StringWriter contents = new StringWriter();

        FileOutputStream out_file = new FileOutputStream("ucla_ex.html.gz");

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            contents.write(inputLine);

        }
        in.close();

        BufferedWriter out = new BufferedWriter(contents);
        GZIPOutputStream gz_in  = new GZIPOutputStream(out_file);

    }
}
