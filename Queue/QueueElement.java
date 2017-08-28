package Queue;

/**
 * Created by Nikit on 24.08.2017.
 */
public class QueueElement<Item> {
    private Item item;
    private QueueElement next;

    public QueueElement(Item _item, QueueElement _next){
        item = _item;
        next = _next;
    }

    public Item getItem() {
        return item;
    }

    public QueueElement getNext() {
        return next;
    }

    public void setNext(QueueElement _next) {
        next = _next;
    }
}