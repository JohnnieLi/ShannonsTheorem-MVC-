package network;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ShannonsTextPanel extends JPanel implements Observer{

	private ShannonsController controller;
	private JTextField maxDataRateJTestField = new JTextField();
	private JTextField bandwidthJTestField = new JTextField();
	private JTextField signalToNoiseJTestField = new JTextField();
	
	

	public  ShannonsTextPanel(ShannonsController controller){
		
		this.controller = controller;
		
		assembleUserInterface();	
		
		configureEvents();
		     
	}
	
	
	
	private void assembleUserInterface(){
		
		this.setLayout(new GridLayout(3,1));
		this.add(new JLabel("Bandwidth (herz) "));
		this.add(bandwidthJTestField);
		
		this.add(new JLabel("Signal to Noise (db)  "));
		this.add(signalToNoiseJTestField);
		
		this.add(new JLabel("Maximum Data Rate (bps)"));
		maxDataRateJTestField.setEditable(false);
		this.add(maxDataRateJTestField);	
		
	}
	
	
    private void configureEvents(){
    	bandwidthJTestField.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				signalToNoiseJTestField.requestFocusInWindow();
				try{   		
		    		controller.setBandwidth(Double.parseDouble(bandwidthJTestField.getText()));   		
		    	}catch (NumberFormatException exception){
		    		String message = "Enter only numbers for bandwidth";
		    		String title = "input error";
		    		JOptionPane.showMessageDialog(ShannonsTextPanel.this, message, title, JOptionPane.ERROR_MESSAGE);
		    		bandwidthJTestField.requestFocusInWindow();
		    		bandwidthJTestField.selectAll();
		    	}		
			}   		
    	});
    	
    	signalToNoiseJTestField.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				try {   	
		    	     controller.setSignalToNoise(Double.parseDouble(signalToNoiseJTestField.getText()));
		    	}catch (NumberFormatException exception){
		    		String message = "Enter only numbers for Signal to Noise";
		    		String title = "input error";
		    		JOptionPane.showMessageDialog(ShannonsTextPanel.this, message, title, JOptionPane.ERROR_MESSAGE);
		    		signalToNoiseJTestField.requestFocusInWindow();
		    		signalToNoiseJTestField.selectAll();
		    	}			
			}   		
    	});
    	
    	
    }
	
	
	@Override
	public void update(Observable o, Object arg) {
		if ( o instanceof ShannonsModel){
			ShannonsModel model = (ShannonsModel) o;
			String message = String.format("%.2f", model.maximumDataRate());
			maxDataRateJTestField.setText(message);
			
			String bandwidth = Double.toString(model.getBandwidth());
//			System.out.println(bandwidth);
			bandwidthJTestField.setText(bandwidth);
			
			String signalToNoise = Double.toString(model.getSignalToNoise());
			signalToNoiseJTestField.setText(signalToNoise);
		}
		
	}

}
