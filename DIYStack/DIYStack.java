package DIYStack;

/**
 * Created by Nikit on 10.08.2017.
 */
public class DIYStack {
    private DIYStackElement top;

    public void push(String str){
        DIYStackElement new_top = new DIYStackElement(str, top);
        this.top = new_top;
    }

    public String pop(){
        DIYStackElement new_top = top.getNext();
        String old_value = top.getValue();
        top = new_top;
        return old_value;
    }

    public boolean hasNext(){
        return top.getNext() != null;
    }

    public static void main(String argv[]){
        DIYStack stack = new DIYStack();

        stack.push("Hello");
        stack.push("World");

        while (true) {
            try {
                System.out.println(stack.pop());
                if (!stack.hasNext()) {
                    System.out.println(stack.pop());
                    throw new DIYStackException();
                }
            } catch (DIYStackException exc) {
                break;
            }
        }
    }
}
