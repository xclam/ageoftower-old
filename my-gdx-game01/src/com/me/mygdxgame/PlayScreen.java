package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;

public class PlayScreen implements Screen {
	MyGdxGame01 _mGame;
	public MyGameStage _mGameStage;
	MyHudStage _mHudStage;
	
	public PlayScreen(MyGdxGame01 game){
		_mGame = game;
		_mGameStage = new MyGameStage(game.getHeight(),game.getWidth(),false,game);
		_mHudStage = new MyHudStage(game.getHeight(),game.getWidth(),false,game);
	}
	
	@Override
	public void render(float delta) {
		//-- Raz ecran
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);  
		//-- Update and Render the Stage
		_mGameStage.act(delta);
		_mHudStage.act(delta);
		_mGameStage.draw();
		_mHudStage.draw();
	}

	@Override
	public void resize(int width, int height) {
		Gdx.app.log("MyTag", "PlayScreen.resize() called");
		_mGameStage.setViewport(width, height, true);
		_mHudStage.setViewport(width, height, true);
		_mHudStage.reaload_hud();
	}

	@Override
	public void show() {
		Gdx.app.log("MyTag", "PlayScreen.show() called");
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
