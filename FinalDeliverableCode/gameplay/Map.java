/**
 * @author Rishabh Tandon
 */

package gameplay;

public class Map {
	private Tile[][] tiles;
    private int xSize;
    private int ySize;
	private int pOneXStart;
	private int pTwoXStart;
	private int pOneYStart;
	private int pTwoYStart;
	
	
	public Map(int x, int y){
		this.xSize = x+3;
		this.ySize = y+3;
		tiles = new Tile[xSize][ySize];
	}
	public Tile[][] getMap(){
		return tiles;
	}
	public int getXSize(){
		return this.xSize;
	}
	public void setXSize(int x){
		this.xSize = x+2;
	}
	public int getYSize(){
		return this.ySize;
	}
	public void setYSize(int y){
		this.ySize = y+2;
	}
	public int getPOneXStart(){
		return pOneXStart;
	}
	public void setPOneXStart(int x){
		this.pOneXStart = x+1;
	}
	public int getPTwoXStart(){
		return pTwoXStart;
	}
	public void setPTwoXStart(int x){
		this.pTwoXStart = x+1;
	}
	public int getPOneYStart(){
		return pOneYStart;
	}
	public void setPOneYStart(int y){
		this.pOneYStart = y+1;
	}
	public int getPTwoYStart(){
		return pTwoYStart;
	}
	public void setPTwoYStart(int y){
		this.pTwoYStart = y+1;
	}
	public void setRectObstacle(int xLo, int xHi, int yLo, int yHi){
		for (int i=xLo; i<xHi; i++){
			for (int j=yLo; j<yHi; j++){
				tiles[i][j] = Tile.WALL;
			}
		}
	}
	public void setBorder(){
		for (int x=0; x<xSize; x++){
			for (int y=0; y<ySize; y++){
                if (x==0 || y==0 || x>=xSize-1 || y>=ySize-1){
                    tiles[x][y] = Tile.WALL;
                }
                else{
                    tiles[x][y] = Tile.EMPTY;
                }
			}
		}
	}
}