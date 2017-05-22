package com.nadan.java.mybbs;

import com.nadan.java.mybbs.presenter.BbsPresenter;

public class BbsMain {

	public static void main(String[] args) {
		//메인 클래스에서 start 실행, 프로그램 시작
		BbsPresenter presenter = new BbsPresenter();
		presenter.start();

	}
}
