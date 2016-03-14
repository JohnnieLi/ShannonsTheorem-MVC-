package network;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class ShannonsTheoremLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       ShannonsTheorem controller =new ShannonsTheorem();
       ShannonsTextPanel textView = new ShannonsTextPanel(controller);
       ShannonsSliderPanel sliderView = new ShannonsSliderPanel(controller);
       ShannonsGraphicPanel graphicView = new ShannonsGraphicPanel();
       controller.addObserver(textView);
       controller.addObserver(sliderView);
       controller.addObserver(graphicView);
       JFrame frame = new JFrame("Shannons Theorem");
       frame.setSize(400, 200);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.getContentPane().setLayout(new GridLayout(3,1));
       frame.getContentPane().add(textView);
       frame.getContentPane().add(sliderView);
       frame.getContentPane().add(graphicView);
       //frame.pack();
       frame.setVisible(true);
       
	}

}
