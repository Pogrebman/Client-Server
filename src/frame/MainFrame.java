package frame;

import javax.swing.*;


public class MainFrame extends JFrame{
	public MainFrame(String name){
		if(name == "main"){
			try{
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				JButton confirm = new JButton("Send");
				confirm.setBounds(270,270,100,30);
				add(confirm);
				setBounds(0,0,640,380);
				setLayout(null);
				setVisible(true);
				setTitle("ЧАТИК");
			}

			catch (Exception e) {
				System.out.println("There was an exeption occured!");
			}
		}
		if(name == "server"){
			try{
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(0,0,640,380);
				setLayout(null);
				setVisible(true);
				setTitle("Server");
			}

			catch (Exception e) {
				System.out.println("An error was occured. Try again.");
			}
		}
	}
}
