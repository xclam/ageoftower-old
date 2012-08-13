package layer;

import java.io.IOException;

import xml.MyXMLProcessor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;
import com.me.mygdxgame.MyGameStage;

public class MapLayer extends Layer{
	public TextureRegion _mTextureRegion;  
	MyGameStage _mMyStage;
	MyXMLProcessor _mMxp;
	public int _mTextureMapX;
	public int _mTextureMapY;
	
	public MapLayer(MyGameStage myStage){		
		_mMyStage = myStage;
		XmlReader xml = new XmlReader();
		try {
			Element root = xml.parse(Gdx.files.internal("data/map.xml"));
			_mMxp = new MyXMLProcessor(root,this);
			_mMxp.process(MyXMLProcessor.TYPE_MAP);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha){
		//Gdx.app.log("MyTag", "MapLayer.draw() called");
		batch.draw(_mTextureRegion,_mMyStage.get_mRootPosX(),_mMyStage.get_mRootPosY(),_mTextureMapX,_mTextureMapY);
	}

	public void set_mTextureRegion(TextureRegion _mTextureRegion) {
		this._mTextureRegion = _mTextureRegion;
	}

	public TextureRegion get_mTextureRegion() {
		return _mTextureRegion;
	}
}
