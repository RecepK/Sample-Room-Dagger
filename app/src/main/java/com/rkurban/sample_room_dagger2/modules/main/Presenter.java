package com.rkurban.sample_room_dagger2.modules.main;

public class Presenter {

    MainView mainView;

    public Presenter(MainView mainView) {
        this.mainView = mainView;
    }

    public void init() {
        mainView.showMessage("Main activity");
    }


}
