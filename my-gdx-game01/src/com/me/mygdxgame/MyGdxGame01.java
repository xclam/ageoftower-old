package com.me.mygdxgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class MyGdxGame01 extends Game {
	MainScreen _mScreen; //-- Menu principale
	public PlayScreen _pScreen; //-- Ecran de jeu
	int _mWidth = 800;
	int _mHeight = 320;
	
	@Override
	public void create() {		
		_mScreen = new MainScreen(this);
		_pScreen = new PlayScreen(this);
		this.setScreen(_mScreen);
	}

	@Override
	public void dispose() {
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		_mWidth = width;
		_mHeight = height;
		super.resize(width, height);
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	public float getWidth() {
		return _mWidth;
	}

	public float getHeight() {
		return _mHeight;
	}
}
