package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.controller.factory;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.controller.InternalController;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.application.ApplicationType;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.menu.GameMenuItem;

import java.lang.reflect.Constructor;

public class ControllerFactory {

//    @org.jetbrains.annotations.NotNull
//    @org.jetbrains.annotations.Contract("null -> fail")
    public static InternalController createInternalController(GameMenuItem item) throws ControllerFactoryException{
        return createInternalController(item, ApplicationType.BASH);
    }


//    @org.jetbrains.annotations.NotNull
//    @org.jetbrains.annotations.Contract("null -> fail")
    public static InternalController createInternalController(GameMenuItem item, ApplicationType type) throws ControllerFactoryException{
        if(item == null || item.getControllerClass() == null)
            throw new ControllerFactoryException("Item or associated controller is null, impossible to instantiate a controller!");
        try {
            Constructor<?> conEmpty = item.getControllerClass().getConstructor();
            Object result = conEmpty.newInstance();
            if(result instanceof InternalController){
                InternalController r = (InternalController) result;
                r.setViewMode(type);
                return r;
            } else {
                throw new ControllerFactoryException("The object you're trying to instantiate is not an instance of InternalController");
            }
        } catch (Exception e) {
            throw new ControllerFactoryException(e);
        }
    }

}
