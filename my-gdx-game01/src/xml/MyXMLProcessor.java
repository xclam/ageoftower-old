package xml;

import java.util.Iterator;

import layer.Layer;
import layer.MapLayer;
import layer.GridLayer;

import shapes.MyCircle;
import shapes.MyRectangle;
import utils.NodeGrid;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader.Element;
import com.me.mygdxgame.MyGameStage;
import com.me.mygdxgame.MyHudStage;

public class MyXMLProcessor {
	//-- constantes statique
	public static final int TYPE_HUD = 0;
	public static final int TYPE_MAP= 1;
	public static final int TYPE_GRID = 2;
	
	//-- instance var
	Element _mElmt;
	Layer _mL;
	
	public MyXMLProcessor(Element root,Layer l) {
		_mElmt = root;
		_mL = l;
	}

	// ajout des elements du xml dans le layer passé
	public void process(int type) {
		switch(type){
			case TYPE_HUD:
				setHude();
				break;
			case TYPE_MAP:
				setMap();
				break;
			case TYPE_GRID:
				setGrid();
				break;
		}
		

	}

	private void setGrid() {
		// gestion de la map (fichier map.xml) ----------------------------------------------------------- //
		Array<Element> l = _mElmt.getChildrenByName("map");
		Iterator<Element> t = l.iterator();
		Element tmp;
		while(t.hasNext()){
			Gdx.app.log("MyTag", " MyXMLProcessor.process() -- grid");
			tmp = t.next();
			((GridLayer)_mL)._mNodeGrid = new NodeGrid(tmp.getInt("slotX"),tmp.getInt("slotY"),tmp.getInt("sizeX")/tmp.getInt("slotX"));
		}		
	}

	private void setMap() {
		// gestion de la map (fichier map.xml) ----------------------------------------------------------- //
		Array<Element> l = _mElmt.getChildrenByName("map");
		Iterator<Element> t = l.iterator();
		Element tmp;
		while(t.hasNext()){
			Gdx.app.log("MyTag", " MyXMLProcessor.process() -- map");
			tmp = t.next();
			Texture tex = new Texture(Gdx.files.internal(tmp.getAttribute("texture")));
			((MapLayer)_mL)._mTextureRegion = new TextureRegion(tex,tmp.getInt("sizeX"),tmp.getInt("sizeY"));
			((MapLayer)_mL)._mTextureMapX = tmp.getInt("sizeX");
			((MapLayer)_mL)._mTextureMapY = tmp.getInt("sizeY");
		}
	}

	private void setHude() {
		// on ajoute les chape de _mElmt, au layer _mL (ficher layout.xml) ----------------------------- //
		Array<Element> l = _mElmt.getChildrenByName("shape");
		Iterator<Element> t = l.iterator();
		Element tmp;
		while(t.hasNext()){
			Gdx.app.log("MyTag", " MyXMLProcessor.process() -- layout");
			tmp = t.next();
			Gdx.app.log("MyTag", "     - "+tmp.get("type"));
			if(tmp.get("type").equals("circle")){
				_mL.addActor(parseCricle(tmp));
			}else if(tmp.get("type").equals("rectangle")){
				_mL.addActor(parseRectangle(tmp));
			}else{
				// type inconue
			}
		}		
	}

	private Actor parseCricle(Element elm) {
		MyCircle c = new MyCircle(parseFloatValue(elm.get("positionX"),"X"),
							      parseFloatValue(elm.get("positionY"),"Y"),
							      parseFloatValue(elm.get("radius"),"X"),
							      elm.getBoolean("hide"),
							      elm.getAttribute("texture"),
							      elm.getInt("texture_size"),
							      elm.getInt("zone_type"));
		return c;
	}

	private Actor parseRectangle(Element elm) {
		MyRectangle r = new MyRectangle(parseFloatValue(elm.get("positionX"),"X"),
										parseFloatValue(elm.get("positionY"),"Y"),
										parseFloatValue(elm.get("sizeX"),"X"),
										parseFloatValue(elm.get("sizeY"),"Y"),
										elm.getBoolean("hide"),
										elm.getAttribute("texture"),
										elm.getInt("texture_size"),
										elm.getInt("zone_type"));
		return r;
	}
	
	private float parseFloatValue(String string, String X_Y) {
		float tmp = 0;
		// taille en % (% hauteur, ou largeur)
		if(string.endsWith("%")){
			float rat = tmp = Float.valueOf(string.substring(0, string.length()-1));
			if(X_Y=="X"){
				tmp = ((MyHudStage)_mL.get_mMyStage())._mGame.getWidth()*rat/100;
			}else if(X_Y=="Y"){
				tmp = ((MyHudStage)_mL.get_mMyStage())._mGame.getHeight()*rat/100;;
			}
		// taille en px
		}else if(string.endsWith("p")){
			tmp = Float.valueOf(string.substring(0, string.length()-1));
		}
		return tmp;
	}
	
}
