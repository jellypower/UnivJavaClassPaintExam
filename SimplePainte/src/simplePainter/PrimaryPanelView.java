package simplePainter;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class PrimaryPanelView extends JPanel{
	
	private JPanel menuPanel;
	private JPanel menuOptionPanel, messagePanel,optionPanel;
	protected DrawingPanel drawingPanel;
	private HoveringListener hoverL;
	
	protected JButton[] btnMenuArray;
	
	public PrimaryPanelView() {
		setBackground(Color.white);
		setPreferredSize(new Dimension(420,640));
		setLayout(null);
		
		menuOptionPanel = new JPanel();
		menuOptionPanel.setBackground(Color.white);
		menuOptionPanel.setBounds(10, 10, 400,120);
		menuOptionPanel.setLayout(null);
		menuOptionPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
		add(menuOptionPanel);
		
		drawingPanel = new DrawingPanel();
		drawingPanel.setBounds(10,140,400,400);
		add(drawingPanel);
		
		
		messagePanel = new JPanel();
		messagePanel.setBackground(Color.white);
		messagePanel.setBounds(10,550,400,80);
		messagePanel.setBorder(BorderFactory.createTitledBorder("MESSAGE"));
		add(messagePanel);
		
		
		menuPanel = new JPanel();
		menuPanel.setBackground(Color.white);
		menuPanel.setBounds(10,10,200,100);
		menuPanel.setBorder(BorderFactory.createTitledBorder("MENU"));
		menuPanel.setLayout(new GridLayout(2, 3));
		menuOptionPanel.add(menuPanel);


		optionPanel = new JPanel();
		optionPanel.setBackground(Color.white);
		optionPanel.setBounds(220,10,190,100);
		optionPanel.setBorder(BorderFactory.createTitledBorder("OPTION"));
		menuOptionPanel.add(optionPanel);
		
		hoverL = new HoveringListener();
		
		btnMenuArray = new JButton[6];
		
		for(int i=0;i<6;i++) {
			btnMenuArray[i] = new JButton(DrawiConstants.MENU[i]);
			btnMenuArray[i].setFont(new Font("verdana",Font.BOLD,8));
			
			btnMenuArray[i].setBackground(DrawiConstants.MENU_EXIT[0]);
			btnMenuArray[i].setBackground(DrawiConstants.MENU_EXIT[1]);
			btnMenuArray[i].addMouseListener(hoverL);
			
			//btnMenuArray[i].addActionListener(new PrimaryPanelController());
			
			menuPanel.add(btnMenuArray[i]);
		}
	}
	
	public void addMenuListener(ActionListener listener) {
		
		for(int i=0;i<6;i++) {
			btnMenuArray[i].addActionListener(listener);
		}
	}
	
	private class HoveringListener implements MouseListener{
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			JButton obj = (JButton)e.getSource();
			obj.setBackground(DrawiConstants.MENU_ENTER[0]);
			obj.setForeground(DrawiConstants.MENU_ENTER[1]);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			JButton obj = (JButton)e.getSource();
			obj.setBackground(DrawiConstants.MENU_EXIT[1]);
			obj.setForeground(DrawiConstants.MENU_EXIT[0]);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}// PrimaryPanelView Class
