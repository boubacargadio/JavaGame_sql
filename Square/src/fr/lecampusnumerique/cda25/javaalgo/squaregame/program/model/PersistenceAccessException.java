package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.model;

public class PersistenceAccessException extends Exception {

    public PersistenceAccessException(String message) {
        super(message);
    }

    public PersistenceAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersistenceAccessException(Throwable cause) {
        super(cause);
    }
}
