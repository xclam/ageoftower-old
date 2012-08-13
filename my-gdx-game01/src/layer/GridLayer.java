package layer;

import java.io.IOException;

import utils.NodeGrid;
import xml.MyXMLProcessor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Plane;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;

public class GridLayer extends Layer {
	MyXMLProcessor _mMxp;
	public NodeGrid _mNodeGrid;
	
	public GridLayer(Stage myStage){
		set_mMyStage(myStage);
		XmlReader xml = new XmlReader();
		//_mPlan = new Plane(new Vector3(0,0,1),0);
		try {
			Element root = xml.parse(Gdx.files.internal("data/layout.xml"));
			_mMxp = new MyXMLProcessor(root,this);
			_mMxp.process(MyXMLProcessor.TYPE_GRID);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha){
		//Gdx.app.log("MyTag", "MapLayer.draw() called");
		//batch.draw(_mTextureRegion,_mMyStage.get_mRootPosX(),_mMyStage.get_mRootPosY(),800,800);
		
	}
}
