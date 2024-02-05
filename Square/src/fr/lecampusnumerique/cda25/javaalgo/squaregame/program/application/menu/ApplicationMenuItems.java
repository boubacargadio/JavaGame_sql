package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.application.menu;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.account.create.ProfileCreationController;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.account.show.ShowProfileController;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.account.update.ProfileUpdateController;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.controller.Controller;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.games.connect4.Connect4;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.games.tictactoe.TicTacToe;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.menu.GameMenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum ApplicationMenuItems implements GameMenuItem {

    // Main menu

    GAME("Games", "Chose game", 'g'),
    PROFILE("Profile", "Update profile", 'p'),
    QUIT("Quit", "Exit program", 'q'),

    // Game submenu
    TICTACTOE(GAME, "TicTacToe", "TicTacToe game creation & play", 't', TicTacToe.class),
    CONNECT4(GAME, "Connect4", "Connect4 game creation & play", 'c', Connect4.class),
    GOMOKU(GAME, "Gomoku", "Gomoku game creation & play", 'g', null),
    GAME_BACK(GAME, "Back", "Return to Main menu", 'b'),

    // Profile submenu
    CREATE_PROFILE(PROFILE, "Create profile", "Create profile information", 'c', ProfileCreationController.class),
    UPDATE_PROFILE(PROFILE, "Update profile", "Update profile information", 'u', ProfileUpdateController.class),
    VIEW_PROFILE(PROFILE, "View profile", "View profile information", 'v', ShowProfileController.class),
    DELETE_PROFILE(PROFILE, "Delete profile", "Delete profile information", 'd', ProfileUpdateController.class),
    PROFILE_BACK(PROFILE, "Back", "Return to Main menu", 'b'),


    PROFILE_CREATION_SAVE(CREATE_PROFILE, "Save", "Save profile", 's'),
    PROFILE_CREATION_BACK(CREATE_PROFILE, "Back", "Return to Profile menu", 'b'),


    PROFILE_UPDATE_SAVE(CREATE_PROFILE, "Save", "Save profile", 's'),
    PROFILE_UPDATE_BACK(UPDATE_PROFILE, "Back", "Return to Profile menu", 'b'),

    PROFILE_VIEW_LOAD(VIEW_PROFILE, "Load", "Load profile", 'l'),
    PROFILE_VIEW_BACK(VIEW_PROFILE, "Back", "Return to  Profile menu", 'b'),


    PROFILE_DELETION_SAVE(PROFILE_BACK, "Remove", "Remove current profile", 'r'),
    PROFILE_DELETION_BACK(PROFILE_BACK, "Back", "Return to  Profile menu", 'b'),


    ;


    @Override
    public List<GameMenuItem> getChildren() {
        return Arrays.stream(ApplicationMenuItems.values())
                .filter(applicationMenuItems -> applicationMenuItems.getParent() == this)
                .map(item -> (GameMenuItem)item)
                .toList();
    }

    @Override
    public List<GameMenuItem> getSiblings() {
        return Arrays.stream(ApplicationMenuItems.values())
                .filter(applicationMenuItems -> applicationMenuItems.getParent() == getParent())
                .map(item -> (GameMenuItem)item)
                .toList();
    }

    @Override
    public List<GameMenuItem> getPreviousLevel() {
        ApplicationMenuItems parent = getParent();
        if(parent == null)
            return new ArrayList<>();
        else
            return Arrays.stream(ApplicationMenuItems.values())
                .filter(applicationMenuItems -> applicationMenuItems.getParent() == parent.getParent())
                .map(item -> (GameMenuItem)item)
                .toList();
    }

    private final ApplicationMenuItems parent;
    @Override
    public ApplicationMenuItems getParent() {
        return this.parent;
    }

    private final String text;
    @Override
    public String getText() {
        return this.text;
    }

    private final String information;
    @Override
    public String getInformation() {
        return this.information;
    }

    private final char shortcut;
    @Override
    public char getShortCut() {
        return this.shortcut;
    }

    private Class controllerClass;
    @Override
    public <T extends Controller>  Class<T> getControllerClass() {
        return controllerClass;
    }



    ApplicationMenuItems(String text, String information, char shortcut){
        this(text, information, shortcut, null);
    }

    <T extends Controller> ApplicationMenuItems(String text, String information, char shortcut, Class<T> controllerClass) {
        this(null, text, information, shortcut, controllerClass);
    }

    ApplicationMenuItems(ApplicationMenuItems parent, String text, String information, char shortcut){
        this(parent, text, information, shortcut, null);
    }

    <T extends Controller> ApplicationMenuItems(ApplicationMenuItems parent, String text, String information, char shortcut, Class<T> controllerClass) {
        this.parent = parent;
        this.text = text;
        this.information = information;
        this.shortcut = shortcut;
        this.controllerClass = controllerClass;
    }

    @Override
    public String toString() {
        return this.getText()+ " ("+this.getShortCut()+") ";
    }
}
