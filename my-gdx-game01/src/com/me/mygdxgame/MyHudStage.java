package com.me.mygdxgame;

import layer.EnemisLayer;
import layer.HudLayer;
import layer.Layer;
import layer.MapLayer;
import layer.MessageLayer;
import layer.TurretsLayer;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;


public class MyHudStage extends Stage {
	
	private InputMultiplexer _mInputMPlexer;
	private Array<Layer> _mNodes;
	private HudLayer _mHudLayer;
	public MyGdxGame01 _mGame;
	private MessageLayer _mMessageLayer;

	public MyHudStage(float width, float height, boolean stretch, MyGdxGame01 game) {
		super(width, height, stretch);
		_mGame = game;
		
		
		_mNodes = new Array<Layer>();
		_mInputMPlexer = new InputMultiplexer();
		
		//-- gestion HUD
		_mHudLayer = new HudLayer(this);
		this.addLayer(_mHudLayer);
		//-- gestion message
		_mMessageLayer = new MessageLayer(this);
		this.addLayer(_mMessageLayer);
		
		Gdx.input.setInputProcessor(_mInputMPlexer);
	}

	public InputMultiplexer getInputMultiplexer(){
        return _mInputMPlexer;
    }

	public void addLayer(Layer layer) {
        layer.width = this.width;
        layer.height = this.height;
        _mNodes.add(layer);
        _mInputMPlexer.addProcessor(layer);
        super.addActor(layer);
    }

	public void reaload_hud(){
		((HudLayer)_mHudLayer).reloadLayout();
	}
}
