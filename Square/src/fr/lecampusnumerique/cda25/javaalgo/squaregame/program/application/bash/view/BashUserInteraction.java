package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.application.bash.view;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.UserInteraction;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.exception.IncorrectInputException;

import java.util.Scanner;

public class BashUserInteraction implements UserInteraction {

    private final Scanner scanner = new Scanner(System.in);
    protected Scanner getScanner(){
        return scanner;
    }


    @Override
    public int waitForInt()  throws IncorrectInputException {
        String line = scanner.nextLine();
        try {
            return Integer.getInteger(line);
        } catch (Exception e){
            throw new IncorrectInputException(line, "int");
        }
    }

    @Override
    public String waitForString(){
        return scanner.nextLine();
    }

    @Override
    public char waitForChar()  throws IncorrectInputException{
        String line = scanner.nextLine();
        if(line.trim().length() == 1)
            return line.charAt(0);
        else
            throw new IncorrectInputException(line, "String");
    }

}
