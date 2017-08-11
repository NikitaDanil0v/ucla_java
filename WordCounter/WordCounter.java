import java.io.FileReader;
import java.util.*;

public class WordCounter {

    public Hashtable count_words(String contents){
        Hashtable count = new Hashtable();

        StringTokenizer st = new StringTokenizer(contents);
        while (st.hasMoreTokens()) {
            String token = st.nextToken().replaceAll("\\W","").toLowerCase();
            if (!count.containsKey(token)) {
                count.put(token, 1);
            }
            else {
                count.put(token,(int)count.get(token) + 1);
            }
        }
        return count;
    }

    public LinkedList top20(Hashtable count)
    {
        LinkedList<Map.Entry<String, Integer>> sortedList = new LinkedList(count.entrySet());

        Collections.sort(sortedList, new Comparator<Map.Entry<String, Integer>>(){

            public int compare(Map.Entry<String, Integer> v1, Map.Entry<String, Integer> v2) {
                return v2.getValue().compareTo(v1.getValue());
            }});

        LinkedList<Map.Entry<String, Integer>> linkedList = new LinkedList<Map.Entry<String, Integer>>();
        for (int i=0; i<20; i++) {
            linkedList.add(sortedList.get(i));
        }
        return linkedList;
    }

    public static void main(String args[]){
        try{
            String contents = "";
            Scanner in = new Scanner(new FileReader("src/ADayInTheLife.txt"));
            while(in.hasNextLine())
            {
                contents += in.nextLine() + "\n";
            }
            WordCounter wc = new WordCounter();
            Hashtable count = wc.count_words(contents);

            LinkedList<String> top20 = wc.top20(count);

            System.out.println(top20);

        } catch (Exception e){
            System.err.println("Error " + e.getMessage());
        }
    }
}