package PasswordCheker;

import java.util.Scanner;

/**
 * Created by User on 8/10/2017.
 */
public class CmdShell {

    public boolean passCheck(){
        System.out.println("Enter your password");
        Scanner s1 = new Scanner(System.in);
        String pass1 = s1.next();

        System.out.println("Confirm your password");
        String pass2 = s1.next();

        try {
            if (!pass1.equals(pass2)) {
                System.out.println("Incorrect password. Try again!");
                throw new PasswordException();
            }
            return true;
        }
        catch (PasswordException e){
            return false;
        }
    }

    public static void main(String args[]){
        CmdShell shell = new CmdShell();
        boolean accessGranted = false;

        for(int i=0; i<3; i++){
            if(shell.passCheck()){
                System.out.println("Access Granted!");
                accessGranted = true;
                break;
            };
        }
        if (!accessGranted) {System.out.println("Security warning!");}
    }
}