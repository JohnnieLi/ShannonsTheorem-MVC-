/*
 *  @(#)ShannonsTheorem.java   1.0 YY/MM/DD
 *
 *
 *  This software contains confidential and proprietary information
 *  of Dyer Consulting ("Confidential Information").  You shall not disclose
 *  such Confidential Information and shall use it only in accordance with the
 *  terms of the license agreement you entered into with Dyer Consulting.
 *
 *  This software is provided "AS IS,".  No warrantee of any kind, express
 *  or implied, is included with this software; use at your own risk, responsibility
 *  for damages (if any) to anyone resulting from the use of this software rests
 *  entirely with the user even if Dyer Consulting has been advised of the
 *  possibility of such damages.
 *
 *  This software is not designed or intended for use in on-line control of
 *  aircraft, air traffic, aircraft navigation or aircraft communications; or in
 *  the design, construction, operation or maintenance of any nuclear
 *  facility. Licensee represents and warrants that it will not use or
 *  redistribute the Software for such purposes.
 *
 *  Distribute freely, except: don't remove my name from the source or
 *  documentation, mark your changes (don't blame me for your possible bugs),
 *  don't alter or remove any of this notice.
 */

/*File name: ShannonsTheorem.java
 * Author: Jiangqi Li ( 040797953)
 * Course: CST8283-310
 * Assignment: #2
 * Date: 2016-1-23
 * Professor:Stan
 * 
 */

package network;			/*	Package for class placement	*/
 

import java.text.DecimalFormat;
import java.util.Observable;

import javax.swing.JOptionPane;

/**
 * Implement Shannon's Theorem to compute the Capacity "C" (Maximum data rate).
 * @author    Jiangqi Li
 * @version   1.0.0 Date
 * @see network
 * @since 1.8.0_66
 */
public class ShannonsModel	extends Observable{
	
	
	
	/* ATTRIBUTES	-----------------------------------------------------	*/
	/** bandwidth of double type , represent the bandwidth in Herz.    */
    private double bandwidth;
    
    /** signalToNoise of double type. the units are called decibels dB.    */
    private double signalToNoise;
    
    
    
	/* CONSTRUCTORS	--------------------------------------------------	*/
	/**
	 *	Default constructor.
	 */
	public ShannonsModel()	{	super();		}

	



	/* ACCESSORS	-----------------------------------------------------	*/
	/**
	 *	return bandwidth of type double.
	 *  @return bandwidth.
	 */
	public double getBandwidth()		{ return bandwidth;	}
	
	/**
	 *	return signalToNoise of type double.
	 *  @return signalToNoise.
	 */
	public double getSignalToNoise()		{ return signalToNoise;	}

	/**
	 *	return maximunDataRate of type double.
	 *@param herz - double type, represent the bandwidth.
	 *@param signalToNoise - double type, represent the signalToNoise.
	 *  @return signalToNoise.
	 */
	
	private  double maximumDataRate(double bandwidth, double signalToNoise){		
		return (bandwidth*(Math.log(1+Math.pow(10, signalToNoise/10))/Math.log(2)));		
		}
	
	/**
	 *	return maximunDataRate of type double.
	 *  @return signalToNoise.
	 */
	public  double maximumDataRate() {
		return this.maximumDataRate(bandwidth, signalToNoise);        		
	}
	

	/* MODIFIERS	-----------------------------------------------------	*/
	/**
	 *	Set the value of bandwidth.
	 *@param h - the double value pass to bandwidth. 
	 */
	public void setBandwidth(double bandwidth) { 
		this.bandwidth = bandwidth;	
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 *	Set the value of bandwidth.
	 *@param snr - the double value pass to signalToNoise.
	 */
	public void setSignalToNoise(double signalToNoise)	{ 
		this.signalToNoise = signalToNoise;	
		this.setChanged();
		this.notifyObservers();
		}
	
	
	
	/*	NORMAL BEHAVIOR -------------------------------------------------	*/
	

	/**
	 *	Convert this class to a meaningful string.
	 *	@return	This class as a meaningful string.
	 */
	 public String toString()	{
		   DecimalFormat formatter = new DecimalFormat("#0.00");		
		 return	"["
		 			+ "MaximumDataRate = " + formatter.format(maximumDataRate())
		 			+ " bps]";
	}

 
	

	

}	/*	End of CLASS:	ShannonsTheorem.java			*/