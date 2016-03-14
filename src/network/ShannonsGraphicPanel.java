package network;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.text.DecimalFormat;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class ShannonsGraphicPanel extends JPanel implements Observer{

	private ShannonsModel model;
	
	public ShannonsGraphicPanel() {
		model = new ShannonsModel();
	}

	
	@Override
	public void paintComponent(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.BLACK);
		
		g.setColor(new Color(238, 230, 133));
		int widthAvailable = this.getWidth();
		double bandwidth = model.getBandwidth();
		int bandwidthBarWidth = (int)(bandwidth/3000*widthAvailable);
		g.fillRect(0, 0, bandwidthBarWidth,this.getHeight()/3);
		
		double signalToNoise = model.getSignalToNoise();
		int signalToNoiseBarWidth = (int)(signalToNoise/30*widthAvailable);
		g.fillRect(0, this.getHeight()/3, signalToNoiseBarWidth,this.getHeight()/3);
		
		double maximumDataRate = model.maximumDataRate();
		int dataRateBarWidth = (int)(maximumDataRate/29901*widthAvailable);
		g.fillRect(0, this.getHeight()/3*2, dataRateBarWidth,this.getHeight()/3);
		
		g.setFont(new Font("SannsSerif", Font.PLAIN, 10));
		g.setColor(Color.BLACK);
		FontMetrics metrics = g.getFontMetrics();
		g.drawString("bw(herz): "+model.getBandwidth(),0 , metrics.getHeight());
		g.drawString("snr(db): "+model.getSignalToNoise(),
				0, this.getHeight()/3+metrics.getHeight());
		DecimalFormat formatter = new DecimalFormat("#0.00");
		g.drawString("mdr(bps): "+formatter.format(model.maximumDataRate()),
				0, this.getHeight()/3*2+metrics.getHeight());
		
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof ShannonsModel){
			ShannonsModel model = (ShannonsModel)o;
			this.model = model;
			this.repaint();
			
		}
		
	}

}
