package DIYStack;

/**
 * Created by Nikit on 10.08.2017.
 */
public class DIYStackElement {
    private DIYStackElement next;
    private String value;

    public DIYStackElement(String _value, DIYStackElement _next){
        value = _value;
        next = _next;
    }

    public DIYStackElement getNext() {
        return next;
    }

    public String getValue() {
        return value;
    }
}
