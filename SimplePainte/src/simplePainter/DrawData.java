package simplePainter;

import java.awt.Color;
import java.awt.Point;

public class DrawData {

	public int nDrawType;
	public Point pt1,pt2;
	public int nSize;
	public Color colorShape;
	public boolean bfill;
	
	public DrawData() {
		nDrawType = DrawiConstants.NONE;
		pt1 = new Point();
		pt2 = new Point();
		nSize = 1;
		colorShape = Color.black;
		bfill = false;

		
	}
	
	public DrawData(DrawData data) {
		this.nDrawType = data.nDrawType;
		this.pt1=data.pt1;
		this.pt2=data.pt2;
		this.nSize = data.nSize;
		this.colorShape = data.colorShape;
		this.bfill = data.bfill;
	}
}
