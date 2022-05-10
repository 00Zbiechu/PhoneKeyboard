import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {


    //Zmienna przechowująca wielkość rozdzielczości
    Dimension screenResolution;

    //Rozmiar okna rozbity na wysokość i szerokość
    int screenWidth;
    int screenHeight;

    //Rozmiar okna aplikacji
    int windowWidth;
    int windowHeight;

    JPanel panelTextField, panelButtons;

    JButton one,two,three,four,five,six,seven,eight,nine,star,zero,hash,plus,call,remove;

    JTextField screenTextField;

    Window(){

        //Zamykanie okna programu
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Wyłączenie możliwości zmiany wielkości okna
        setResizable(false);

        //Ustawienie layoutu dla okna głównego aplikacji
        setLayout(new FlowLayout());


        //Inicjalizacja komponentów GUI
        initGUI();

    }

    private void initGUI(){

        //Pobranie i ustawianie wielkości monitora
        setScreenResolution();

        //Konwertowanie wartości wielkości monitora na szerokość i wysokość
        setWidthHeight(getScreenResolution());

        //Ustawianie pozycji okna
        setLocationOfMainWindow(screenWidth,screenHeight);

        //Ustawienie wielkości okna
        setSizeOfWindow(screenWidth,screenHeight);

        createPanels();

        //Utworzenie etykiety tekstowej działającej jak ekran telefonu
        createTextField();

        //Utworzenie przycisków do aplikacji
        createButtons();

        //Wywołanie metody dodającej layout dla klawiatury i dodającej do niej komponenty
        addLayoutAndComponents(createLayoutManagerKeyboard(windowWidth,windowHeight));
    }

    //Seter dla wielkości okna
    private void setScreenResolution(){
        //Obiekt służący do pobrania rozdzielczości ekranu użytkownika
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        screenResolution = toolkit.getScreenSize();

    }

    private Dimension getScreenResolution() {
        return screenResolution;
    }

    private void setWidthHeight(Dimension screenResolution){

        screenHeight = screenResolution.height;
        screenWidth = screenResolution.width;

    }


    //Ustawia wielkość okna na podstawie wielkości możliwej do wyświetlenia na ekranie monitora
    private void setSizeOfWindow(int width, int height){

        //Ustawianie rozmiaru okna do zmiennych
        this.windowWidth = width/6;
        this.windowHeight = height/2;

        this.setSize(windowWidth,windowHeight);

    }

    private void setLocationOfMainWindow(int width,int height){

        int widthWhereShowWindow = (width/4);
        int heightWhereShowWindow = (height/4);

        this.setLocation(widthWhereShowWindow,heightWhereShowWindow);

    }

    private JTextField createJTextField(){

        JTextField jTextField = new JTextField();
        jTextField.setSize(windowWidth,windowHeight/6);

        return jTextField;

    }

    private void createPanels(){

        this.panelTextField = new JPanel();
        this.panelButtons = new JPanel();

    }

    private void createTextField(){

        screenTextField = createJTextField();
            screenTextField.setPreferredSize(new Dimension((int) (windowWidth*0.9),windowHeight/7));

    }


    private JButton createJButton(String label){

        JButton jButton = new JButton(label);
        jButton.addActionListener(this);

        return jButton;

    }

    private void createButtons(){

        //przycisków do aplikacji
        one = createJButton("1");
        two = createJButton("2");
        three = createJButton("3");
        four = createJButton("4");
        five = createJButton("5");
        six = createJButton("6");
        seven = createJButton("7");
        eight = createJButton("8");
        nine = createJButton("9");
        star = createJButton("*");
        zero = createJButton("0");
        hash = createJButton("#");
        plus = createJButton("+");
        call = createJButton("C");
            call.setBackground(Color.GREEN);
            call.setForeground(Color.WHITE);
        remove = createJButton("R");
            remove.setBackground(Color.RED);
            remove.setForeground(Color.WHITE);

    }

    //Utworzenie menadżera layoutu na podstawie wielkości okna
    private LayoutManager createLayoutManagerKeyboard(int width, int height){


        String colConfiguration = width/3+"px,"+width/3+"px,"+width/3+"px";
        String  rowConfiguration = height/7+"px,"+height/7+"px,"+height/7+"px,"+height/7+"px,"+height/7+"px";

        FormLayout formLayout = new FormLayout(colConfiguration,rowConfiguration);

        return  formLayout;
    }

    private void addLayoutAndComponents(LayoutManager layoutManager){

        panelTextField.setLayout(new GridLayout());
        panelButtons.setLayout(layoutManager);

        //Obiekt do obsługi komórek layoutu
        CellConstraints cc = new CellConstraints();

        //Dodanie textFiled do panelu TextField
        panelTextField.add(screenTextField);


        //Dodanie przycisków do głównego okna
        panelButtons.add(one,cc.xy(1,1,CellConstraints.FILL,CellConstraints.FILL));
        panelButtons.add(two,cc.xy(2,1,CellConstraints.FILL,CellConstraints.FILL));
        panelButtons.add(three,cc.xy(3,1,CellConstraints.FILL,CellConstraints.FILL));
        panelButtons.add(four,cc.xy(1,2,CellConstraints.FILL,CellConstraints.FILL));
        panelButtons.add(five,cc.xy(2,2,CellConstraints.FILL,CellConstraints.FILL));
        panelButtons.add(six,cc.xy(3,2,CellConstraints.FILL,CellConstraints.FILL));
        panelButtons.add(seven,cc.xy(1,3,CellConstraints.FILL,CellConstraints.FILL));
        panelButtons.add(eight,cc.xy(2,3,CellConstraints.FILL,CellConstraints.FILL));
        panelButtons.add(nine,cc.xy(3,3,CellConstraints.FILL,CellConstraints.FILL));
        panelButtons.add(star,cc.xy(1,4,CellConstraints.FILL,CellConstraints.FILL));
        panelButtons.add(zero,cc.xy(2,4,CellConstraints.FILL,CellConstraints.FILL));
        panelButtons.add(hash,cc.xy(3,4,CellConstraints.FILL,CellConstraints.FILL));
        panelButtons.add(plus,cc.xy(1,5,CellConstraints.FILL,CellConstraints.FILL));
        panelButtons.add(call,cc.xy(2,5,CellConstraints.FILL,CellConstraints.FILL));
        panelButtons.add(remove,cc.xy(3,5,CellConstraints.FILL,CellConstraints.FILL));


        //Dodanie paneli zawierających główne elementy do ekranu głównego
        add(panelTextField);
        add(panelButtons);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==call){

            Logic.call(screenTextField,this);

        }else if(e.getSource()==remove){

            Logic.clear(screenTextField);

        }else{

            //Pobieranie wartości labela buttona, który przycisnął user
            JButton myButton = (JButton)e.getSource();

            Logic.insertNumber(screenTextField,myButton.getText());

        }

    }
}
