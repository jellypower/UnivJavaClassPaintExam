package simplePainter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrimaryPanelController {

	protected PrimaryPanelView view;
	
	public PrimaryPanelController(PrimaryPanelView view) {
		
		this.view = view;
	}
	
	protected class ButtonMenuListener implements ActionListener{
		protected ButtonMenuListener(ActionEvent event) {
			
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
}
