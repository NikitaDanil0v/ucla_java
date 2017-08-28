package Queue;

/**
 * Created by Nikit on 24.08.2017.
 */
public class Queue<Item> {
    private QueueElement current; //current Queue element for iteration

    private QueueElement first;
    private QueueElement last;

    public Queue() {
        current = null;

        first = null;
        last  = null;
    }

    public void queue(Item item){
        QueueElement old_last = last;
        last = new QueueElement(item, null);

        if (first == null) first = last;
        else old_last.setNext(last);
    }

    public Item dequeue(){
        Item old_item = (Item) first.getItem();
        QueueElement new_first = first.getNext();

        first = new_first;

        return old_item;
    }

    public boolean hasNext()  { return current != null; }

    public static void main(String argv[]) {

        Queue queue = new Queue();

        queue.queue("Hello");
        queue.queue("World");
        queue.queue((int)1234);

        queue.current = queue.first;
        while (true) {
            try {
                System.out.println(queue.dequeue());
                if (!queue.hasNext()) {
                    System.out.println(queue.dequeue());

                    queue.current = queue.current.getNext();
                }
            } catch (Exception e) {
                break;
            }
        }
    }
}
