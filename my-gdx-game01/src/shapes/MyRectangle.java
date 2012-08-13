package shapes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class MyRectangle extends MyHudElement{
	Rectangle _mR;
	boolean _mHiden;
	String _mTexture;
	TextureRegion _mTextureRegion;  
	
	public MyRectangle(float x, float y, float width,float height ,boolean hidden, String texture, int texturesize, int zonetype){
		_mR = new Rectangle(x,y,width,height);
		_mHiden = hidden;
		_mTexture = texture;
		_mZoneType = zonetype;
		if (!_mTexture.equals("")){
			Texture t = new Texture(Gdx.files.internal(_mTexture)); 
			_mTextureRegion = new TextureRegion(t,texturesize,texturesize);
		}
	}
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
		if(!_mHiden){
			if(_mTextureRegion != null){
				//Gdx.app.log("MyTag", "        - MyRectangle.draw() ");
				batch.draw(_mTextureRegion,_mR.x,_mR.y,_mR.width,_mR.height);
			}
		}
	}

	@Override
	public Actor hit(float x, float y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean touches(int x, int y) {
		return _mR.contains(x, y);
	}
	
	
}
