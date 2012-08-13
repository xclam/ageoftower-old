package utils;


/*
 * Class materialisant la grille en deux dimention
 * Chaque noeuds pourra recevoir une tourelle
 */
public class NodeGrid {
	int _mWidth;
	int _mHeight;
	int _mUnitSize;
	MapNode[][] _mNodeMap;
	
	public NodeGrid(int width,int height, int unitSize){
		_mWidth = width;
		_mHeight = height;
		_mUnitSize = unitSize;
		_mNodeMap = new MapNode[_mWidth][_mHeight];
	}
}
