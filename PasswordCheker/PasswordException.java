package PasswordCheker;

/**
 * Created by User on 8/10/2017.
 */
public class PasswordException extends Throwable{

    public static void main(String args[]){

        try {
            PasswordException myerror = new PasswordException();
            throw myerror;
        } catch (PasswordException e) {
            System.err.println("Error " + e.getMessage());
        }
    }


}