package layer;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;

import shapes.MyHudElement;

import xml.MyXMLProcessor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Plane;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.Ray;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;
import com.me.mygdxgame.MyGameStage;
import com.me.mygdxgame.MyHudStage;

//import com.badlogic.gdx.Gdx;

public class HudLayer extends Layer {
	//-- constantes statique
	static final int ZONE_STATE_IDLE = 0;
	static final int ZONE_STATE_ZOOMING = 1;
	static final int ZONE_STATE_SCROLLING = 2;
	static final int ZONE_STATE_PLACING_TURET = 3;
	static final int ZONE_STATE_SELECTING_TURET = 4;
	static final int ZONE_STATE_ACTION_TRIGERED = 5;
	
	//-- instance var
	float _mXori = 0;
	float _mYori = 0;
	float _mLastX = 0;
	float _mLastY = 0;
	MyXMLProcessor _mMxp;
	public int _mHudState;
	private float _mLastZoom; 
	Plane _mPlan;
	OrthographicCamera _mGameStageCam;
	
	public HudLayer(Stage myStage) {
		_mHudState = ZONE_STATE_IDLE;
		set_mMyStage(myStage);
		XmlReader xml = new XmlReader();
		_mPlan = new Plane(new Vector3(0,0,1),0);
		try {
			Element root = xml.parse(Gdx.files.internal("data/layout.xml"));
			_mMxp = new MyXMLProcessor(root,this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reloadLayout();
	}
	
	public void reloadLayout() {
		this.clear();
		_mMxp.process(MyXMLProcessor.TYPE_HUD);
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer){
		//Gdx.app.log("MyTag", " HudLayer.touchDragged() called, _mHudState:"+_mHudState);
		_mGameStageCam = ((OrthographicCamera)(((MyHudStage) get_mMyStage())._mGame._pScreen._mGameStage.getCamera()));
		switch(_mHudState){
			case ZONE_STATE_IDLE:
				break;
			case ZONE_STATE_SCROLLING:
				_mGameStageCam.translate((-x + _mXori)*_mGameStageCam.zoom , (+y - _mYori)*_mGameStageCam.zoom );
				_mXori = x;
				_mYori = y;
				break;
			case ZONE_STATE_ZOOMING:
				_mGameStageCam.zoom = (float) (0.01*(-y + _mYori)+_mLastZoom);
				break;
			case ZONE_STATE_PLACING_TURET:
				Gdx.app.log("MyTag", " HudLayer.touchDragged() called, _mHudState:"+_mHudState);
				// depose de la tourelle, il faut desiner la grille et la future position de la tourelle
				break;
		}
		
		return true;
	}
	
	@Override
	public boolean touchDown(int x, int y, int pointer, int button){
		//super.touchDown(x, y, pointer, button);
		switch(_mHudState){
			case ZONE_STATE_IDLE:
				// mode IDLE, ... on passe dans le nouveau mode
				_mHudState = getTouchedZone(x,y); 
				break;
			case ZONE_STATE_ZOOMING:
				break;
			case ZONE_STATE_SCROLLING:
				break;
			case ZONE_STATE_ACTION_TRIGERED:
				_mHudState = ZONE_STATE_PLACING_TURET;
				break;
		}		
		//Gdx.app.log("MyTag", " HudLayer.touchDown() called");
		_mXori = x;
		_mYori = y;		
		return true; 
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button){
		//Gdx.app.log("MyTag", " HudLayer.touchDown() called,"+_mLastY+" "+_mLastX);
		_mGameStageCam = ((OrthographicCamera)(((MyHudStage) get_mMyStage())._mGame._pScreen._mGameStage.getCamera()));
		_mLastZoom = _mGameStageCam.zoom;
		switch(_mHudState){
			case ZONE_STATE_IDLE:
				break;
			case ZONE_STATE_ZOOMING:
				_mHudState = ZONE_STATE_IDLE;
				break;
			case ZONE_STATE_SCROLLING:
				_mHudState = ZONE_STATE_IDLE;
				break;
			case ZONE_STATE_ACTION_TRIGERED:
				break;
			case ZONE_STATE_PLACING_TURET:
				// la position de la tourell est donné, maintenant: choi de la tourelle.
				_mHudState = ZONE_STATE_SELECTING_TURET;
				break;
			case ZONE_STATE_SELECTING_TURET:
				_mHudState = ZONE_STATE_IDLE;
				break;
		}
		return true;
	}
	
	private int getTouchedZone(int x, int y) {
		// PArcours des zone fille (dans this.getActors()) pour retrouver le bouton "pousser"
		int zone = 0;
		List<Actor> l = this.getActors();
		Iterator<Actor> i = l.iterator();
		while(i.hasNext() && zone==0){
			MyHudElement tmp = (MyHudElement) i.next(); 
			// la position des shapes est inverse sur l'axe Y d'ou: this._mMyStage._mGame.getHeight() - Y
			if (tmp.touches(x,(int) (((MyHudStage) get_mMyStage())._mGame.getHeight()-y))){
				zone = tmp.getZoneType();
			}
		}
		Gdx.app.log("MyTag", " HudLayer.getTouchedZone() called, zone:"+zone);
		return zone;
	}
}
