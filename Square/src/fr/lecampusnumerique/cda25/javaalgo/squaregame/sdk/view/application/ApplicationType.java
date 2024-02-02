package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.application;

public enum ApplicationType {

    BASH("bash"),
    GUI("gui"),
    ;

    private String params;

    public String getParams() {
        return params;
    }

    ApplicationType(String params) {
        this.params = params;
    }

    public static ApplicationType getDefault(){
        return BASH;
    }
}
