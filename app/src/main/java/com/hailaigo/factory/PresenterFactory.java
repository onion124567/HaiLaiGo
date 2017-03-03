package com.hailaigo.factory;


import com.hailaigo.presenter.Presenter;

public interface PresenterFactory<P extends Presenter> {
    P createPresenter();
}
