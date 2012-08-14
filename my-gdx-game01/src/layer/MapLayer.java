package layer;

import java.io.IOException;

import xml.MyXMLProcessor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.tiled.TileAtlas;
import com.badlogic.gdx.graphics.g2d.tiled.TileMapRenderer;
import com.badlogic.gdx.graphics.g2d.tiled.TiledLoader;
import com.badlogic.gdx.graphics.g2d.tiled.TiledMap;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;
import com.me.mygdxgame.MyGameStage;

public class MapLayer extends Layer{
	private MyGameStage _mMyStage;
	private MyXMLProcessor _mMxp;
	private final int TILE_SIZE = 32;
	private TileMapRenderer _mTileMapRenderer;
	private TiledMap _mMap;
	private TileAtlas _mAtlas;
    private static final int[] layersList = { 0 };
	
	public MapLayer(MyGameStage myStage){		
		_mMyStage = myStage;
		
        // Load the tmx file into _mMap
        _mMap = TiledLoader.createMap(Gdx.files.internal("data/level.tmx"));
        
        // Load the tiles into _mAtlas
        _mAtlas = new TileAtlas(_mMap, Gdx.files.internal("data"));

        // Create the renderer
        _mTileMapRenderer = new TileMapRenderer(_mMap, _mAtlas, 32, 32);

	}
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha){
		//Gdx.app.log("MyTag", "MapLayer.draw() called");
		//batch.draw(_mTextureRegion,_mMyStage.get_mRootPosX(),_mMyStage.get_mRootPosY(),_mTextureMapX,_mTextureMapY);
		super.draw(batch, parentAlpha);
		Vector3 tmp = new Vector3();
		tmp.set(0, 0, 0);
		_mTileMapRenderer.render((OrthographicCamera)_mMyStage.getCamera());
	}

	public int getTileSize() {
		return TILE_SIZE;
	}

}
