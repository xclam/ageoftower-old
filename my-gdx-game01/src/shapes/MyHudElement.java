package shapes;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class MyHudElement extends Actor {
	int _mZoneType;
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		// TODO Auto-generated method stub

	}

	@Override
	public Actor hit(float x, float y) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Retourn vrai si le point decrit est dans la zone
	 */
	public abstract boolean touches(int x, int y);
	
	public int getZoneType(){
		return _mZoneType;
	}
}
