package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.controller.game;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.Board;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.ClearableComponent;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.cell.symbols.Symbol;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.listener.BoardObserver;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.games.GameStates;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.games.GameTypes;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.games.validators.GameValidator;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.players.opponents.Opposable;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.UserInteraction;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.View;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.container.ViewContainer;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGame implements Game, BoardObserver {

    private Board board;
    private Opposable opponents;
    private View view;
    private ViewContainer viewContainer;
    private UserInteraction userInteractions;
    private GameValidator gameValidator;
    private GameTypes gameType;
    private GameStates currentGameState;
    private final List<ClearableComponent> clearables = new ArrayList<>();

    protected Board getBoard() {
        return board;
    }

    protected Opposable getOpponents() {
        return opponents;
    }

    protected View getView() {
        return view;
    }

    protected UserInteraction getUserInteractions() {
        return userInteractions;
    }

    protected GameValidator getGameValidator() {
        return gameValidator;
    }

    protected GameTypes getGameType() {
        return gameType;
    }

    protected GameStates getCurrentGameState(){
        return currentGameState;
    }

    protected AbstractGame(Board board, Opposable opponents, View view, UserInteraction userInteractions, GameValidator gameValidator, GameTypes gameType) {
        this.board = board;
        this.opponents = opponents;
        this.view = view;
        this.userInteractions = userInteractions;
        this.gameValidator = gameValidator;
        this.gameType = gameType;
    }

    @Override
    public void play() {
        createPlayers();
        currentGameState = GameStates.MENU;
        playGame();
    }

    protected void playGame(){
        switch (currentGameState){
            case TIE -> showTie();
            case WIN -> showVictory();
            case TURN -> {
                playTurn();
                playGame();
            }
            case MENU -> showTurnMenu();
            case SAVE -> saveGame();
            case EXIT -> showExitMenu();
            default -> {}
        }
    }

    @Override
    public void onCellOccupied(Symbol symbol) {
        if(!gameValidator.isGamePlayable(board)){
            currentGameState = GameStates.TIE;
        } else if (gameValidator.hasWinner(board)){
            currentGameState = GameStates.WIN;
        } else {
            currentGameState = GameStates.MENU;
        }
    }

    protected void playTurn(){

    }

    protected void showVictory(){
        view.show(createVictoryMessage());
    }

    protected abstract String createVictoryMessage();


    protected void showTie(){
        view.show(createTieMessage());
    }

    protected abstract String createTieMessage();

    protected void createPlayers(){

    }

    protected void showTurnMenu(){

    }

    protected void saveGame(){
        view.show("Sorry, not implemented yet!");
    }

    protected  void showExitMenu(){
        view.show(createExitMessage());
    }

    protected abstract String createExitMessage();

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    protected void restartGame(){
        this.board.clear();
        this.opponents.clear();
        play();
    }

    @Override
    public void clear() {

    }
}
