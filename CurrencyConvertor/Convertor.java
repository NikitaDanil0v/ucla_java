package CurrencyConvertor;

/**
 * Created by Nikit on 17.08.2017.
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Convertor {

    public HashMap<String, Float> readCSV (String csvFilePath, String delimiter) {
        HashMap<String, Float> h = new HashMap<String, Float>();

        try {
            Scanner in = new Scanner(new FileReader(csvFilePath));
            while(in.hasNextLine())
            {
                String[] s = in.nextLine().split(delimiter);

                // Doesn't work without Trim function. It seems to me that first element of array has hidden chars.
                String key = String.valueOf(s[0]).trim();
                Float value = Float.valueOf(s[2]);

                h.put(key, value);
            }
        } catch (Exception e){
            System.err.println("Error " + e.getMessage());
        } finally {
            return h;
        }
    }

    public static void main(String args[]){
        try{
            System.out.println("====== Currency Convertor ======");
            Convertor convertor = new Convertor();
            HashMap<String, Float> dbCurrency = convertor.readCSV("src/CurrencyConvertor/forex.csv", ",");

            Scanner s = new Scanner(System.in);

            System.out.println("Enter your first currency (ex:AUD)");
            String curr1 = s.next().toUpperCase();

            if(dbCurrency.get(curr1) == null ) {
                System.err.println(curr1 + " Not found!");
                System.exit(0);
            }

            System.out.println("Enter amount of " + curr1);
            Integer amt1 = s.nextInt();

            System.out.println("Enter your second currency (ex:MXN)");
            String curr2 = s.next().toUpperCase();

            if(dbCurrency.get(curr2) == null ) {
                System.err.println(curr2 + " Not found!");
                System.exit(0);
            }

            Float cross_course =  dbCurrency.get(curr2) / dbCurrency.get(curr1) ;
            Float amt2 = amt1 * cross_course;

            System.out.println("Cross course:" + cross_course + " " + curr1 + "/" + curr2);
            System.out.println(amt1 + " " + curr1 + " = " + amt2 + " " + curr2);

        } catch (Exception e){
            System.err.println("Error " + e.getMessage());
        }
    }
}