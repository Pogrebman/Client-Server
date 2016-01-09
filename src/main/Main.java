package main;

import java.util.Scanner;
import server.Server;
import client.Client;
import frame.MainFrame;
import dialog.Dialog;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Dialog dialog = new Dialog("dialog1");

		while(true){
			if(dialog.n == 0){
				System.out.println("Вы выбрали мать его сервер!");
				new Server();
				break;
			}

			if(dialog.n == 1){
				new Client();
				break;
			}
			else{
				System.out.println("Некорректный вваод. Повторите.");
				break;
			}

		}
	}

}
