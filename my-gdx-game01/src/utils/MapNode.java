package utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

/*
 * Noeuds du niveau
 */
public class MapNode extends Actor{
	private TextureRegion _mTextureRegion;
	private int _mPosX;
	private int _mPosY;
	private int _mWidth;
	private int _mHeight;
	private boolean _mBuildable;
	
	public MapNode(int posX, int posY, int widh, int height,boolean buildable,TextureRegion tex){
		_mPosX = posX;
		_mPosY = posY;
		_mWidth = widh;
		_mHeight = height;
		_mBuildable = buildable;
		_mTextureRegion = tex;
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		//Gdx.app.log("MyTag", " MyXMLProcessor.process() -- node");
		batch.draw(_mTextureRegion, _mPosX*_mWidth, _mPosY*_mHeight);
	}

	@Override
	public Actor hit(float x, float y) {
		// TODO Auto-generated method stub
		return null;
	}
}
