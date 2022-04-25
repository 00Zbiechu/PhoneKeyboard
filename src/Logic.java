import javax.swing.*;

public class Logic {

    public static void clear(JTextField textField){

        textField.setText("");

    }

    public static void call(JTextField textField){

//        if(textField.getText().length()>6 && textField.getText().length()<9){
//        }
            textField.setText("Dzwonienie...");

            Timer timer = new Timer(3000, e -> textField.setText(""));
            timer.setRepeats(false);
            timer.start();


    }

}
