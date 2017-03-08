package com.haitago.factory;


import com.haitago.presenter.Presenter;

public interface PresenterFactory<P extends Presenter> {
    P createPresenter();
}
