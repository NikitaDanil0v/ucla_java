package DIYStack;

/**
 * Created by Nikit on 10.08.2017.
 */
public class DIYStackException extends Throwable {

    public static void main(String args[]){

        try {
            DIYStackException myerror = new DIYStackException();
            throw myerror;

        } catch (DIYStackException e) {
            System.err.println("Error " + e.getMessage());

        }
    }
}