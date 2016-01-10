package frame;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;



public class MainFrame extends JFrame{
	JLabel jl;
	JPanel jp,jp2,jp3;
	JButton jb;
	JTextField jt;
	public String string;
	public MainFrame(String name){
		if(name == "main"){
			try{
				setSize(640,380);
				setVisible(true);
				setTitle("ЧАТИК");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				jp = new JPanel();
				jp2 = new JPanel();
				jp3 = new JPanel();
				jt = new JTextField(20);
				jt.setBounds(0,0,20,100);
				jl = new JLabel(string);
				jb = new JButton("Send");
				jb.setBounds(270,270,100,30);

				jp.add(jl);
				add(jp, BorderLayout.CENTER);
				jp3.add(jt);
				add(jp3, BorderLayout.NORTH);
				jp2.add(jb);
				add(jp2, BorderLayout.EAST);


			}
			catch (Exception e) {
				System.out.println("There was an exeption occured!");
			}
		}

		if(name == "server"){
			try{
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(0,0,300,200);
				JButton shut = new JButton("Shut down");
				shut.setToolTipText("CAUTION!!! BY PRESSING THIS BUTTON YOU CAN DROP SERVER!");
				shut.setBounds(80,130,150,30);
				add(shut);
			 	setLayout(null);
				setVisible(true);
				setTitle("Server");
				shut.addActionListener(new CloseListener());
			}
			catch (Exception e) {
				System.out.println("An error was occured. Try again.");
			}
		}
	}

	public void uLabel(String text){

		jl.setText(text);
	}
}

class CloseListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e){
		System.exit(0);
	}
}
