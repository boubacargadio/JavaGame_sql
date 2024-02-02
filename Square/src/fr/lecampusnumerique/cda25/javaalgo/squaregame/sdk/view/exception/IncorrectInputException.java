package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.exception;

public class IncorrectInputException extends Exception{

    public IncorrectInputException(String input, String expectedType) {
        super("User input: "+ input + " does not match type requirement: "+expectedType);
    }
}
