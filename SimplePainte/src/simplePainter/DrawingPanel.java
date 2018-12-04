package simplePainter;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel{
	
	protected ArrayList<DrawData> dataList;
	protected DrawData data;
	
	private boolean bDrag;
	
	private DrawListener drawL;
	
	
	public DrawingPanel() {
		setBackground(Color.white);
		setBorder(BorderFactory.createLineBorder(Color.lightGray,1));
		
		drawL = new DrawListener();
		this.addMouseListener(drawL);
		this.addMouseMotionListener(drawL);
		
		dataList = new ArrayList<DrawData>();
		data = new DrawData();
		
		bDrag = false;
		
		//
		data.nSize = 2;
		data.colorShape = Color.red;
	
	
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		if(bDrag) {
			switch(data.nDrawType) {
			
			case DrawiConstants.LINE:
				Graphics2D page2D = (Graphics2D)g;
				page2D.setStroke(new BasicStroke(data.nSize));
				g.setColor(data.colorShape);
				g.drawLine(data.pt1.x, data.pt1.y,data.pt2.x,data.pt2.y);
				break;		
			case DrawiConstants.RECT:
				
				
				break;		
			case DrawiConstants.OVAL:
				
				break;		
			}
		}
		
		for( DrawData getData : dataList) {
			g.setColor(getData.colorShape);
			switch(getData.nDrawType) {
			
			case DrawiConstants.DOT:
				g.fillOval(getData.pt1.x-data.nSize/2, getData.pt1.y-data.nSize/2,getData.nSize, getData.nSize);
				break;
			case DrawiConstants.LINE:
				Graphics2D page2D = (Graphics2D)g;
				page2D.setStroke(new BasicStroke(data.nSize));
				g.drawLine(getData.pt1.x, getData.pt1.y,getData.pt2.x,getData.pt2.y);
				break;		
			case DrawiConstants.RECT:
				
				break;		
			case DrawiConstants.OVAL:
				
				break;		
			}
		}
		
	}
	
	private class DrawListener implements MouseListener,MouseMotionListener{
		
		
		
		public void mouseClicked(MouseEvent event) {
			if(data.nDrawType == DrawiConstants.DOT) {
				data.pt1 = event.getPoint();
				dataList.add(new DrawData(data));
				System.out.println(data.nDrawType);
				repaint();
			}
		}
		public void mousePressed(MouseEvent event) {
			bDrag = true;
			if(data.nDrawType == DrawiConstants.LINE || data.nDrawType == DrawiConstants.RECT || data.nDrawType == DrawiConstants.OVAL) {
				data.pt1 = event.getPoint();
			}
		}
		public void mouseReleased(MouseEvent event) {
			bDrag = false;
			if(data.nDrawType == DrawiConstants.LINE || data.nDrawType == DrawiConstants.RECT || data.nDrawType == DrawiConstants.OVAL) {
				data.pt2 = event.getPoint();
				dataList.add(new DrawData(data));
				repaint();
			}
		}
		public void mouseEntered(MouseEvent event) {}
		public void mouseExited(MouseEvent event) {}
		
		public void mouseDragged(MouseEvent event) {
			
			if(data.nDrawType == DrawiConstants.LINE || data.nDrawType == DrawiConstants.RECT || data.nDrawType == DrawiConstants.OVAL) {
				data.pt2 = event.getPoint();
				repaint();
			}
			
		}
		public void mouseMoved(MouseEvent event) {}
		
		
	}

	
	
}

