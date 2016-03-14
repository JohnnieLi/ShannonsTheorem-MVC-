package network;

import java.util.Observer;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class ShannonsTheorem implements ShannonsController  {

	ShannonsModel model;
	
	public ShannonsTheorem(){
		model = new ShannonsModel();
	}
	
	public double getBandwidth(){
		return model.getBandwidth();
	}
	
	
	public double getSignalToNoise(){
		return model.getSignalToNoise();
	}
	
	public double maximumDataRate(){
		return model.maximumDataRate();
				
	}
	
	@Override
	public void setBandwidth(double bandwidth){
		model.setBandwidth(bandwidth);
	}
	
	@Override
	public void setSignalToNoise(double snr){
		model.setSignalToNoise(snr);
	}
	
	
	/*	ENTRY POINT for STAND-ALONE OPERATION ---------------------------	*/
	/**
	 * Entry point "main()" as required by the JVM.
	 * @param  args   Standard command line parameters (arguments) as a
	 *	string array.
	 */
	public static void main (String args[]) {	
		ShannonsTheorem shannonsTheorem = new ShannonsTheorem();
		
		 int i =0;
		 double SignalToNoise = 0;
		 do{ 
		  try{
			  SignalToNoise= Double.parseDouble (JOptionPane.showInputDialog("Please enter the SignalToNoise.",
					"0"));
			  i = 0;
		  }	catch (NumberFormatException e){
			  JOptionPane.showMessageDialog(null, "Please enter a number");
			  i = 1;
		  } catch (java.lang.NullPointerException e){
			  break;
		  }
		 }while (i ==1);
		 
		 i =0;
		 double bandwidth = 0;
		 do{ 
		  try{
			  i = 0;
			  bandwidth= Double.parseDouble (JOptionPane.showInputDialog("Please enter the Bandwidth.",
					"0"));		  
		  }	catch (NumberFormatException e){
			  JOptionPane.showMessageDialog(null, "Please enter a number");
			  i = 1;
		  } catch (java.lang.NullPointerException e){
			  break;
		  }
		 }while (i ==1);
		
		shannonsTheorem.setBandwidth (bandwidth);		
		shannonsTheorem.setSignalToNoise(SignalToNoise);		
		String input = shannonsTheorem.toString();
		JInternalFrame frame = new JInternalFrame();
		JOptionPane.showMessageDialog(frame,input,"Maximun Data Rate",JOptionPane.INFORMATION_MESSAGE );
		
	}

	@Override
	public void addObserver(Observer observer) {
		model.addObserver(observer);		      
	}

}
