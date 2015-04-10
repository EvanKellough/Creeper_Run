package Entity;

import java.awt.Rectangle;

import Main.GamePanel;
import TileMap.Tile;
import TileMap.TileMap;


public abstract class MapObject {
	
	// tile stuff
	protected TileMap tileMap;
	protected int tileSize;
	protected double xmap;
	protected double ymap;
	
	// position and vector
	protected double x;
	protected double y;
	protected double dx;
	protected double dy;
	
	// dimensions
	protected int width;
	protected int height;
	
	// collision box
	protected int cwidth;
	protected int cheight;
	
	// collision
	protected int currRow;
	protected int currCol;
	protected double xdest;
	protected double ydest;
	protected double xtemp;
	protected double ytemp;
	protected boolean topLeft;
	protected boolean topRight;
	protected boolean bottomLeft;
	protected boolean bottomRight;
	protected int leftTile;
	protected int rightTile;
	protected int topTile;
	protected int bottomTile;
	
	// animation
	protected Animation animation;
	protected int currentAction;
	protected int previousAction;
	protected boolean facingRight;
	
	// movement
	protected boolean west;
	protected boolean east;
	protected boolean north;
	protected boolean south;
	protected boolean up;
	protected boolean down;
	protected boolean jumping;
	protected boolean falling;
	
	// movement attributes
	protected double moveSpeed;
	protected double maxSpeed;
	protected double stopSpeed;
	protected double fallSpeed;
	protected double maxFallSpeed;
	protected double jumpStart;
	protected double stopJumpSpeed;
	
	// constructor
	public MapObject(TileMap tm) {
		tileMap = tm;
		tileSize = tm.getTileSize();
		animation = new Animation();
		facingRight = true;
	}
	
	public boolean intersects(MapObject o) {
		Rectangle r1 = getRectangle();
		Rectangle r2 = o.getRectangle();
		return r1.intersects(r2);
	}
	
	public boolean intersects(Rectangle r) {
		return getRectangle().intersects(r);
	}
	
	public boolean contains(MapObject o) {
		Rectangle r1 = getRectangle();
		Rectangle r2 = o.getRectangle();
		return r1.contains(r2);
	}
	
	public boolean contains(Rectangle r) {
		return getRectangle().contains(r);
	}
	
	public Rectangle getRectangle() {
		return new Rectangle(
				(int)x - cwidth / 2,
				(int)y - cheight / 2,
				cwidth,
				cheight
		);
	}
	
	public void calculateCorners(double x, double y) {
		leftTile = (int)(x - cwidth / 2) / tileSize;
		rightTile = (int)(x + cwidth / 2 - 1) / tileSize;
		topTile = (int)(y - cheight / 2) / tileSize;
		bottomTile = (int)(y + cheight / 2 - 1) / tileSize;
		if(topTile < 0 || bottomTile >= tileMap.getNumRows() ||
			leftTile < 0 || rightTile >= tileMap.getNumCols()) {
			topLeft = topRight = bottomLeft = bottomRight = false;
			return;
		}
		int tl = tileMap.getType(topTile, leftTile);
		int tr = tileMap.getType(topTile, rightTile);
		int bl = tileMap.getType(bottomTile, leftTile);
		int br = tileMap.getType(bottomTile, rightTile);
		topLeft = tl == Tile.BLOCKED;
		topRight = tr == Tile.BLOCKED;
		bottomLeft = bl == Tile.BLOCKED;
		bottomRight = br == Tile.BLOCKED;
	}
	
	public void checkTileMapCollision() {
		
		currCol = (int)x / tileSize;
		currRow = (int)y / tileSize;
		
		xdest = x + dx;
		ydest = y + dy;
		
		xtemp = x;
		ytemp = y;
		
		calculateCorners(x, ydest);
		if(dy < 0) {
			if(topLeft || topRight) {
				dy = 0;
				ytemp = (topTile + 1) * tileSize + cheight / 2;
			}
			else {
				ytemp += dy;
			}
		}
		if(dy > 0) {
			if(bottomLeft || bottomRight) {
				dy = 0;
				falling = false;
				ytemp = bottomTile * tileSize - cheight / 2;
			}
			else {
				ytemp += dy;
			}
		}
		
		calculateCorners(xdest, y);
		if(dx < 0) {
			if(topLeft || bottomLeft) {
				dx = 0;
				xtemp = (leftTile + 1) * tileSize + cwidth / 2;
			}
			else {
				xtemp += dx;
			}
		}
		if(dx > 0) {
			if(topRight || bottomRight) {
				dx = 0;
				xtemp = rightTile * tileSize - cwidth / 2;
			}
			else {
				xtemp += dx;
			}
		}
		
		if(!falling) {
			calculateCorners(x, ydest + 1);
			if(!bottomLeft && !bottomRight) {
				falling = true;
			}
		}
		
	}
	
	public int getx() { return (int)x; }
	public int gety() { return (int)y; }
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	public int getCWidth() { return cwidth; }
	public int getCHeight() { return cheight; }
	public boolean isFacingRight() { return facingRight; }
	
	public void setPosition(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public void setVector(double dx, double dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	public void setMapPosition() {
		xmap = tileMap.getx();
		ymap = tileMap.gety();
	}
	
	public void setWest(boolean b) { west = b; }
	public void setEast(boolean b) { east = b; }
	public void setNorth(boolean b) { north = b; }
	public void setSouth(boolean b) { south = b; }
	
	public void setUp(boolean b) { up = b; }
	public void setDown(boolean b) { down = b; }
	public void setJumping(boolean b) { jumping = b; }
	
	public boolean notOnScreen() {
		return x + xmap + width < 0 ||
			x + xmap - width > GamePanel.WIDTH ||
			y + ymap + height < 0 ||
			y + ymap - height > GamePanel.HEIGHT;
	}
	
	public void draw(java.awt.Graphics2D g) {
		setMapPosition();
		if(facingRight) {
			g.drawImage(
				animation.getImage(),
				(int)(x + xmap - width / 2),
				(int)(y + ymap - height / 2),
				null
			);
		}
		else {
			g.drawImage(
				animation.getImage(),
				(int)(x + xmap - width / 2 + width),
				(int)(y + ymap - height / 2),
				-width,
				height,
				null
			);
		}
		// draw collision box
		//Rectangle r = getRectangle();
		//r.x += xmap;
		//r.y += ymap;
		//g.draw(r);
	}
	
}