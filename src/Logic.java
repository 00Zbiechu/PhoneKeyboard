import javax.swing.*;
import java.awt.*;

public class Logic {

    public static void insertNumber(JTextField textField, String label){

       StringBuilder stringBuilder = new StringBuilder(textField.getText());

       stringBuilder.append(label);

       textField.setText(String.valueOf(stringBuilder));

    }

    public static void clear(JTextField textField){

        if(textField.getText().length()>0){
            //creating a constructor of StringBuffer class
            StringBuffer sb = new StringBuffer(textField.getText());
            //invoking the method
            sb.deleteCharAt(sb.length()-1);
            //prints the string after deleting the character
            textField.setText(String.valueOf(sb));
        }

    }

    public static void call(JTextField textField, Component parent){

            int length = textField.getText().length();
            String firstLetter = null;

            try{
                 firstLetter = textField.getText().substring(0,1);
            }catch (Exception e){
                JOptionPane.showMessageDialog(parent,"Pusty nr telefonu.");
            }



        if(length==9 || (length==12 && firstLetter.equals("+"))){

            textField.setText("Dzwonienie...");

            Timer timer = new Timer(3000, e->textField.setText(""));
            timer.setRepeats(false);
            timer.start();

        }else{

            JOptionPane.showMessageDialog(parent,"Zły format nr telefonu.");

        }



    }

}
