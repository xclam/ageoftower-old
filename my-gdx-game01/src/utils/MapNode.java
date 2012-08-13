package utils;

import com.badlogic.gdx.math.Rectangle;

/*
 * Noeuds du niveau
 */
public class MapNode {
	Rectangle _mRect;
	boolean _mBuildable;
	
	public MapNode(float posX, float posY, float widh, float height,boolean buildable){
		_mRect = new Rectangle(posX,posY,widh,height);
		_mBuildable = buildable;
	}
}
