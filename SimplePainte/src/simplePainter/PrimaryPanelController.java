package simplePainter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrimaryPanelController {

	protected PrimaryPanelView view;
	
	public PrimaryPanelController(PrimaryPanelView view) {
		this.view = view;
		
		view.addMenuListener(new ButtonMenuListener());
	}
	
	protected class ButtonMenuListener implements ActionListener{
		

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			Object obj = event.getSource();
			for(int i=0;i<6;i++){

				if(obj == view.btnMenuArray[i]) {
					view.drawingPanel.data.nDrawType = i;
	
					System.out.println(view.drawingPanel.data.nDrawType);
				}
			}
		}
	}
}
