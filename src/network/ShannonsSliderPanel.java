package network;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ShannonsSliderPanel extends JPanel implements Observer{
       
	   private ShannonsController controller;
	   private JSlider maxDataRateJslider = new JSlider();
	   private JSlider bandwidthJSlider = new JSlider();
	   private JSlider signalToNoiseJSlider = new JSlider();
	   private static final int BANDWIDTH_MAX = 3000;
	   private static final int BANDWIDTH_MIN = 0;
	   private static final int SIGNAL_TO_NOISE_MAX = 30;
	   private static final int SIGNAL_TO_NOISE_MIN = 0;
	   private static final int MAXIMUN_DATA_RATE_MAX = 29901;
	   private static final int MAXIMUN_DATA_RATE_MIN = 0;

	   

	public ShannonsSliderPanel(ShannonsTheorem controller) {
		
		this.controller = controller;
		
		assembleUserInterface();
		
		
		configureEvents();
		
	}


	


	private void assembleUserInterface() {
		this.setLayout(new GridLayout(3,1));
		
		this.add(new JLabel("Bandwidth (herz)"));
		bandwidthJSlider.setMaximum(BANDWIDTH_MAX);
		bandwidthJSlider.setMinimum(BANDWIDTH_MIN);
		bandwidthJSlider.setPaintTicks(true);
		bandwidthJSlider.setPaintLabels(true);
		bandwidthJSlider.setOrientation(JSlider.HORIZONTAL);
	    this.add(bandwidthJSlider);
	    
	    this.add(new JLabel("Signal to Noise (db)"));
	    signalToNoiseJSlider.setMaximum(SIGNAL_TO_NOISE_MAX);
	    signalToNoiseJSlider.setMinimum(SIGNAL_TO_NOISE_MIN);
	    signalToNoiseJSlider.setPaintTicks(true);
	    signalToNoiseJSlider.setValue(0);
	    this.add(signalToNoiseJSlider);
	    
	    this.add(new JLabel("Maximum Data Rate (bps)"));
	    maxDataRateJslider.setMaximum(MAXIMUN_DATA_RATE_MAX);
	    maxDataRateJslider.setMinimum(MAXIMUN_DATA_RATE_MIN);
	    maxDataRateJslider.setEnabled(false);
	    maxDataRateJslider.setPaintTicks(true);
	    this.add(maxDataRateJslider);
	    
	}


	private void configureEvents() {
		bandwidthJSlider.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent e) {				
				  controller.setBandwidth(bandwidthJSlider.getValue());
								
			}
			
		});
		
		signalToNoiseJSlider.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent e) {
				controller.setSignalToNoise(signalToNoiseJSlider.getValue());				
			}
			
		});
		
	}



	@Override
	public void update(Observable o, Object arg) {
		if ( o instanceof ShannonsModel){
			ShannonsModel model = (ShannonsModel) o;
			bandwidthJSlider.setValue((int)model.getBandwidth());			
			signalToNoiseJSlider.setValue((int)model.getSignalToNoise());			
			maxDataRateJslider.setValue((int)model.maximumDataRate());
			
		}
		
	}

}
