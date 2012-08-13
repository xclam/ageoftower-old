package com.me.mygdxgame;

//import java.util.List;

import utils.NodeGrid;
import layer.EnemisLayer;
import layer.GridLayer;
import layer.HudLayer;
import layer.Layer;
import layer.MapLayer;
import layer.MessageLayer;
import layer.TurretsLayer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
//import com.badlogic.gdx.InputProcessor;
//import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;

public class MyGameStage extends Stage{
	NodeGrid _mNG;
	public MyGdxGame01 _mGame;
	InputMultiplexer _mInputMPlexer;
	private Array<Layer> _mNodes;
    private Layer _mMapLayer;
    private Layer _mTurretsLayer;
    private Layer _mEnemisLayer;
    private Layer _mGridLayer;
	private float _mRootPosX;
	private float _mRootPosY;
	
	
	public MyGameStage(float width, float height, boolean stretch, MyGdxGame01 game) {		
		super(width, height, stretch);
		_mGame = game;
		set_mRootPosX(0);
		set_mRootPosY(0);
		_mNodes = new Array<Layer>();
		_mInputMPlexer = new InputMultiplexer();
		//-- gestion map
		_mMapLayer = new MapLayer(this);
		this.addLayer(_mMapLayer);
		//-- gestion tourrel 
		_mTurretsLayer = new TurretsLayer(this);
		this.addLayer(_mTurretsLayer);
		//-- gestion Enemis
		_mEnemisLayer = new EnemisLayer(this);
		this.addLayer(_mEnemisLayer);
		//-- gestion grill pour le depot des tourelle
		_mGridLayer = new GridLayer(this);
		this.addLayer(_mEnemisLayer);
		
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

	public void set_mRootPosX(float _mRootPosX) {
		this._mRootPosX = _mRootPosX;
	}

	public float get_mRootPosX() {
		return _mRootPosX;
	}

	public void set_mRootPosY(float _mRootPosY) {
		this._mRootPosY = _mRootPosY;
	}

	public float get_mRootPosY() {
		return _mRootPosY;
	}
}
