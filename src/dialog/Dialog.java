package dialog;

import java.awt.*;
import javax.swing.*;

public class Dialog extends JFrame{
  public int n;
  public String inputValue, inputValue2;
  public Dialog(String check){
    if(check == "dialog1"){
    Object[] options = {"Сервер",
                        "Клиент"};
    n = JOptionPane.showOptionDialog(null,
        "Выберите режим работы: ",
        "ЧАТИК",
        JOptionPane.YES_NO_CANCEL_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,
        options,
        options[1]);
    }

    if(check == "dialog2"){
      inputValue = JOptionPane.showInputDialog("Please input IP adress");
      inputValue2 = JOptionPane.showInputDialog("Please input your nickname");
    }
  }
}
