package shapes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class MyCircle extends MyHudElement{
	Circle _mC;
	Boolean _mHiden;
	int _mId;
	String _mTexture;
	TextureRegion _mTextureRegion;  
	
	public MyCircle(float x, float y, float radius,boolean hiden,String texture, int texturesize, int zonetype) {
		_mC = new Circle(x, y, radius);
		_mHiden = hiden;
		_mTexture = texture;
		_mZoneType = zonetype;
		if (!_mTexture.equals("")){
			Texture t = new Texture(Gdx.files.internal(_mTexture)); 
			_mTextureRegion = new TextureRegion(t,texturesize,texturesize);
		}
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		//Gdx.app.log("MyTag", "        - MyCircle.draw() ");
		if (!_mHiden){
			if(_mTextureRegion != null){
				// la texture sera appliqué sue un carréde cote le radius et de centre,
				// le meme centre que le cerce
				batch.draw(_mTextureRegion,_mC.x-_mC.radius,_mC.y-_mC.radius,_mC.radius*2,_mC.radius*2);
			}
		}
	}

	@Override
	public Actor hit(float x, float y) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see shapes.MyHudElement#touches(int, int)
	 */
	@Override
	public boolean touches(int x, int y) {
		return _mC.contains(x, y);
	}
	

}
