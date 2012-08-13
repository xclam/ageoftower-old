package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainScreen implements Screen {
	MyGdxGame01 _mGame;
	private SpriteBatch _mBatch;  
    private Texture _mTexture1;  
    BitmapFont _mFont;
    Sprite _mSprite;
	public MainScreen(MyGdxGame01 game){
		_mGame = game;		
	}
	 
	@Override
	public void render(float delta) {
		if (Gdx.input.justTouched()) // use your own criterion here
			_mGame.setScreen(_mGame._pScreen);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT); // This cryptic line clears the screen.  
		_mBatch.begin();  
        
        _mSprite.draw(_mBatch);
        _mFont.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        _mFont.draw(_mBatch, "Press the screen to start", 20, 20);
        
        _mBatch.end();  
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		//Gdx.app.log("MyTag", "MainScreen.show() called");
		_mBatch = new SpriteBatch();
		_mTexture1 = new Texture(Gdx.files.internal("data/devil.png"));  
		_mSprite = new Sprite(_mTexture1);
		_mFont = new BitmapFont();
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
