package game;

import java.util.LinkedList;

import gameplay.Map;
import gameplay.Tile;

public class MapHandler {
	Map map;
	Map[] maps = new Map[3];
    public MapHandler(){
    	setMapThree();
    	setMapTwo();
    	setMapOne();
    	setMapDefaults();
    }
    public Map getMap(){
    	return map;
    }
    public void setMapOne(){
    	setMapDefaults();
    	maps[0] = map;
    }
    public void setMapTwo(){
    	setMapDefaults();
    	maps[1] = map;
    }
    public void setMapThree(){
    	setMapDefaults();
    	maps[2] = map;
    }
    public void setMapDefaults(){
    	map = new Map(75,50);
    	map.setBorder();
    	map.setPOneXStart(0);
    	map.setPOneYStart(50);
    	map.setPTwoXStart(75);
    	map.setPTwoYStart(0);
    }
}
