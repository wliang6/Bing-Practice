package project;

import java.awt.GridLayout;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeMap;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProcessorViewPanel implements Observer {
	private MachineModel model;
	private JTextField acc = new JTextField(); 

	public ProcessorViewPanel(ViewsOrganizer gui, MachineModel model) {
		this.model = model;
		gui.addObserver(this);
	}

	public JComponent createProcessorDisplay() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,0));
		panel.add(new JLabel("Accumulator: ", JLabel.RIGHT));
		panel.add(acc);
		return panel;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if(model != null) {
			acc.setText("" + model.getAccumulator());
			
		}
	}
	
	public static void main(String[] args) {
		ViewsOrganizer view = new ViewsOrganizer(); 
		MachineModel model = new MachineModel();
		ProcessorViewPanel panel = 
			new ProcessorViewPanel(view, model);
		JFrame frame = new JFrame("TEST");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 60);
		frame.setLocationRelativeTo(null);
		frame.add(panel.createProcessorDisplay());
		frame.setVisible(true);
	}

}
	
	
	

