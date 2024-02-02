package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.model;

public class DbAccess {

    private static DbAccess instance;

    public static DbAccess getInstance() {
        if (instance == null) instance = new DbAccess();
        return instance;
    }

    private DbAccess() {
        //TODO generate everything you need for db connection
    }
}
