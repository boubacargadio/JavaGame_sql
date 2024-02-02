package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.controller.factory;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.controller.Controller;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.controller.InternalController;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.menu.GameMenuItem;

import java.lang.reflect.Constructor;

public class ControllerFactory {

    @org.jetbrains.annotations.NotNull
    @org.jetbrains.annotations.Contract("null -> fail")
    public static InternalController createInternalController(GameMenuItem item) throws ControllerFactoryException{
        if(item == null || item.getControllerClass() == null)
            throw new ControllerFactoryException("Item or associated controller is null, impossible to instantiate a controller!");
        try {
            Constructor<?> conEmpty = item.getControllerClass().getConstructor();
            Object result = conEmpty.newInstance();
            if(result instanceof InternalController){
                return (InternalController) result;
            } else {
                throw new ControllerFactoryException("The object you're trying to instantiate is not an instance of InternalController");
            }
        } catch (Exception e) {
            throw new ControllerFactoryException(e);
        }
    }

}
