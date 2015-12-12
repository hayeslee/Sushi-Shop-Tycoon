import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

/**
 * 
 * 
 * @author Hayes Lee and Jeffrey Wang 
 * @version June 11, 2014
 */

public class FinalProjectMain extends JFrame implements ActionListener
{

	private FinalProject gameBoard;

	public FinalProjectMain()
	{
		// Set up the frame
		super("Sushi Shop Tycoon");
		setLocation(0, 0);
		setResizable(false);

		// Add game board to center of frame
		gameBoard = new FinalProject();
		getContentPane().add(gameBoard, BorderLayout.CENTER);
		Container contentPane = getContentPane();
		contentPane.add(gameBoard, BorderLayout.CENTER);

	}

	public static void main(String[] args)
	{
		FinalProjectMain sushiShop = new FinalProjectMain();
		sushiShop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sushiShop.pack();
		sushiShop.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		// TODO Auto-generated method stub

	}

}
