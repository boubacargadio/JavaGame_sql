package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.application.bash;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.application.bash.view.BashUserInteraction;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.application.bash.view.BashView;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.application.menu.ApplicationMenuItems;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.application.menu.ApplicationMenuStates;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.application.listeners.MenuObserver;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.UserInteraction;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.View;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.application.menu.ApplicationMenu;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.container.Containable;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.exception.IncorrectInputException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BashApplicationMenu implements ApplicationMenu {

    private final List<MenuObserver> observers = new ArrayList<>();
    private ApplicationMenuStates status;
    private UserInteraction userInteraction = new BashUserInteraction();
    private View view = new BashView();
    private List<ApplicationMenuItems> currentItems;
    private ApplicationMenuItems currentItem;

    public BashApplicationMenu(){
        goRoot();
    }

    private void goRoot(){
        currentItems = Arrays.stream(ApplicationMenuItems.values())
                .filter(applicationMenuItems -> applicationMenuItems.getParent()==null).toList();
        currentItem = null;
    }

    @Override
    public void addApplicationMenuObserver(MenuObserver observer) {
        if(observer != null) observers.add(observer);
    }

    @Override
    public void removeApplicationMenuObserver(MenuObserver observer) {
        if(observer != null) observers.remove(observer);
    }

    protected void notifiyOnMenuClicked() {
        for (MenuObserver observer: observers) {
            observer.onMenuClicked(currentItem);
        }
    }

    protected void notifiyOnQuitAsked() {
        for (MenuObserver observer: observers) {
            observer.onQuitAsked();
        }
    }
    @Override
    public void showMainMenu() {
        goRoot();
        status=ApplicationMenuStates.IN_WAITING;
        checkMenuStatus();
    }

    private void showCurrentMenu(){
        show(createMenuLine());
        waitAnswer();
    }

    private void waitAnswer(){
        try {
            char choice = waitForChar();
            ApplicationMenuItems item =getItemByShortcut(choice);
            if(item == null){
                show("The shortcut is not recognizied, try again!");
            } else {
                treatChoice(item);
            }
        } catch (IncorrectInputException e) {
            show(e.getMessage());
        }
        checkMenuStatus();
    }

    private void treatChoice(ApplicationMenuItems item){
        if(item == ApplicationMenuItems.QUIT){
            status = ApplicationMenuStates.QUIT;
        } else if(item.getControllerClass() != null){
            currentItem = item;
            status = ApplicationMenuStates.DEMAND;
        } else if (!item.getChildren().isEmpty()) {
            currentItems = item.getChildren().stream()
                    .map(gameMenuItem -> (ApplicationMenuItems) gameMenuItem).toList();
            status = ApplicationMenuStates.IN_WAITING;
        } else {
            if(!item.getPreviousLevel().isEmpty()){
                currentItems = item.getPreviousLevel().stream()
                        .map(gameMenuItem -> (ApplicationMenuItems) gameMenuItem).toList();
            } else {
                goRoot();
            }
            status = ApplicationMenuStates.IN_WAITING;
        }
    }

    private ApplicationMenuItems getItemByShortcut(char shortcut){
        return currentItems.stream()
                .filter(applicationMenuItems -> applicationMenuItems.getShortCut() == shortcut)
                .findFirst().orElse(null);
    }

    private String createMenuLine(){
        return currentItems.stream()
                .map(applicationMenuItems -> "| "+applicationMenuItems.toString())
                .reduce("",(s, s2) -> s+s2);
    }

    private void checkMenuStatus(){
        switch (status){
            case QUIT -> notifiyOnQuitAsked();
            case DEMAND -> notifiyOnMenuClicked();
            case IN_WAITING -> showCurrentMenu();
        }
    }

    @Override
    public int waitForInt() throws IncorrectInputException {
        return userInteraction.waitForInt();
    }

    @Override
    public String waitForString() {
        return userInteraction.waitForString();
    }

    @Override
    public char waitForChar() throws IncorrectInputException {
        return userInteraction.waitForChar();
    }

    @Override
    public void show(String message) {
        view.show(message);
    }

    @Override
    public void clear() {
        this.observers.clear();
        this.view.clear();
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void addContent(Containable containable) {

    }

    @Override
    public void removeContent(Containable containable) {

    }

    @Override
    public void switchContent(Containable in, Containable out) {

    }
}
