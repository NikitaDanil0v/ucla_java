package MyLinkedList;

/**
 * Created by Nikita on 24.08.2017.
 */
public class MyLinkedList<T> {
    MyLinkedList next;
    T object;

    public MyLinkedList(T new_object){
        this.object = new_object;
    }

    public void add(T new_object){
        MyLinkedList inst = this;
        while (inst.next != null){
            inst = inst.next;

        }

        inst.next = new MyLinkedList(new_object);

    }

    public void print(){
        MyLinkedList inst = this;
        while (inst != null) {
            System.out.println(inst.object);
            inst = inst.next;

        }
    }

    public static void main(String[] args){
        MyLinkedList<Float> mll = new MyLinkedList<Float>((float) 0.343);
        mll.add((float) 23.2);
        mll.print();

    }
}