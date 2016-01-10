package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import dialog.Dialog;
import frame.MainFrame;
import main.Const;

public class Client {
	private BufferedReader in;
	private PrintWriter out;
	private Socket socket;

	public Client() {
		Scanner scan = new Scanner(System.in);
		Dialog dialog2 = new Dialog("dialog2");

		String ip = dialog2.inputValue;

		try {
			MainFrame frame = new MainFrame("main");
			socket = new Socket(ip, Const.Port);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);

			out.println(dialog2.inputValue2);
			Resender resend = new Resender();
			resend.start();

			String str = "";
			while (!str.equals("exit")) {
				str = scan.nextLine();
				frame.uLabel(str);
				out.println(str);
			}
			resend.setStop();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	private void close() {
		try {
			in.close();
			out.close();
			socket.close();
		} catch (Exception e) {
			System.err.println("Потоки не были закрыты!");
		}
	}

	private class Resender extends Thread {

		private boolean stoped;

		public void setStop() {
			stoped = true;
		}

		@Override
		public void run() {
			try {
				while (!stoped) {
					String str = in.readLine();
					System.out.println(str);
				}
			} catch (IOException e) {
				System.err.println("Ошибка при получении сообщения.");
				e.printStackTrace();
			}
		}
	}

}
