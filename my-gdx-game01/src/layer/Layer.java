package layer;

import java.util.List;

//import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.me.mygdxgame.MyGameStage;

public class Layer extends Group implements InputProcessor{
	protected Stage _mMyStage;
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha){
		super.draw(batch, parentAlpha);
	}
	
	public void enter(){
		List<Actor> list = this.getActors();
		int size = list.size();
		for (int i = 0; i < size; i++){
			Actor actor = list.get(i);
			if (actor instanceof Layer){
				Layer layer = (Layer) actor;
				layer.enter();
			}
		}
	}

	public void exit(){
		List<Actor> list = this.getActors();
		int size = list.size();
		for (int i = 0; i < size; i++){
			Actor actor = list.get(i);
			if (actor instanceof Layer){
				Layer layer = (Layer) actor;
				layer.exit();
			}
		}
	}

	public boolean touchDown(int x, int y, int pointer, int button){
		Gdx.app.log("MyTag", "Layer.touchDown() called");
		boolean handled = false;
		List<Actor> list = this.getActors();
		int size = list.size();
		int index = 0;
		while (index < size && !handled){
			Gdx.app.log("MyTag", "    - calling  Actor.touchDown() called");
			Actor actor = list.get(index);
			if (actor instanceof Layer)	{
				Layer layer = (Layer) actor;
				handled = layer.touchDown(x, y, pointer, button);
			}
			index++;
		}
		return handled;
	}

	public boolean touchUp(int x, int y, int pointer, int button){
		boolean handled = false;
		List<Actor> list = this.getActors();
		int size = list.size();
		int index = 0;
		while (index < size && !handled){
			Actor actor = list.get(index);
			if (actor instanceof Layer)	{
				Layer layer = (Layer) actor;
				handled = layer.touchUp(x, y, pointer, button);
			}
			index++;
		}
		return handled;
	}

	public boolean touchDragged(int x, int y, int pointer){
		boolean handled = false;
		List<Actor> list = this.getActors();
		int size = list.size();
		int index = 0;
		while (index < size && !handled)
		{
			Actor actor = list.get(index);
			if (actor instanceof Layer){
				Layer layer = (Layer) actor;
				handled = layer.touchDragged(x, y, pointer);
			}
			index++;
		}
		return handled;
	}

	public boolean touchMoved(int x, int y)	{
		boolean handled = false;
		List<Actor> list = this.getActors();
		int size = list.size();
		int index = 0;
		while (index < size && !handled){
			Actor actor = list.get(index);
			if (actor instanceof Layer){
				Layer layer = (Layer) actor;
				handled = layer.touchMoved(x, y);
			}
			index++;
		}
		return handled;
	}

	public void set_mMyStage(Stage myStage) {
		this._mMyStage = myStage;
	}

	public Stage get_mMyStage() {
		return _mMyStage;
	}
}
