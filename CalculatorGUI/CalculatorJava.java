package Calculator.CalculatorGUI;

import javax.swing.*;//d
import java.awt.*;//d
import java.awt.event.*;//d
import static java.lang.Double.parseDouble;
public class CalculatorJava implements ActionListener{//d
    JFrame Frame;
    JTextField TextField;
    JButton[] numberButton=new JButton[10];
    JButton[] functionButton= new JButton[8];
    JButton addButton, subButton, divButton, mulButton;
    JButton decButton, delButton, clrButton, equlButton;
    JPanel panel;

    Font myFont= new Font("Arial", Font.BOLD,30);
    double num1=0, num2=0, result=0; 
    char operator;

    CalculatorJava(){
         Frame= new JFrame("Calculator");
         Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         Frame.setSize(420,550 );
         Frame.setLayout(null);

         TextField = new JTextField();
         TextField.setBounds(50,25,300,50);
         TextField.setFont(myFont);
         TextField.setEditable(true);

         addButton= new JButton("+");
         subButton= new JButton("-");
         divButton= new JButton("/");
         mulButton= new JButton("*");
         decButton= new JButton(".");
         equlButton= new JButton("=");
         clrButton= new JButton("CLEAR");
         delButton= new JButton("DEL");

         functionButton[0]=addButton;
         functionButton[1]=subButton;
         functionButton[2]=divButton;
         functionButton[3]=mulButton;
         functionButton[4]=decButton;
         functionButton[5]=delButton;
         functionButton[6]=equlButton;
         functionButton[7]=clrButton;

         for(int i=0; i<8;i++){
            functionButton[i].addActionListener(this);
            functionButton[i].setFont(myFont);
            functionButton[i].setFocusable(false);
         }

         for(int i=0; i<10; i++){
            numberButton[i]= new JButton(Integer.toString(i));//d
            numberButton[i].addActionListener(this);
            numberButton[i].setFont(myFont);
            numberButton[i].setFocusable(false);
         }

         delButton.setBounds(50,430,145,50);
         clrButton.setBounds(205,430,145,50);

        

         panel= new JPanel();
         panel.setBounds(50, 100, 300, 300);
         panel.setLayout(new GridLayout(4,4,10,10));
         panel.setBackground(Color.GRAY);

         panel.add(numberButton[1]) ;
         panel.add(numberButton[2]) ;
         panel.add(numberButton[3]) ;
         panel.add(addButton);
         panel.add(numberButton[4]) ;
         panel.add(numberButton[5]) ;
         panel.add(numberButton[6]) ;
         panel.add(subButton);
         panel.add(numberButton[7]) ;
         panel.add(numberButton[8]) ;
         panel.add(numberButton[9]) ;
         panel.add(divButton);
         panel.add(decButton);
         panel.add(numberButton[0]) ;
         panel.add(delButton);
         panel.add(mulButton);
         panel.add(equlButton);
         
         Frame.add(panel);
         Frame.add(delButton);
         Frame.add(clrButton);
          Frame.add(TextField);
         Frame.setVisible(true);

    }


    
    public static void main(String[] args) {
        CalculatorJava calc= new CalculatorJava();
        
    }

    public void actionPerformed(ActionEvent e){
        for(int i=0; i<10;i++){
            if(e.getSource()== numberButton[i]){
                TextField.setText(TextField.getText().concat(String.valueOf(i)));//d
            }
        }

            if(e.getSource()== decButton){
                TextField.setText(TextField.getText().concat(String.valueOf(".")));
            }
            if(e.getSource()==addButton){
                num1 =parseDouble(TextField.getText());
                operator='+';
                TextField.setText("");
            }
            if(e.getSource()==subButton){
                num1= Double.parseDouble(TextField.getText());
                operator='-';
                TextField.setText("");
            }
            if(e.getSource()==mulButton){
                num1=Double.parseDouble(TextField.getText());
                operator='*';
                TextField.setText("");
            }
            if(e.getSource()==divButton){
                num1=Double.parseDouble(TextField.getText());
                operator='/';
                TextField.setText("");
            }
            if(e.getSource()==equlButton){
                num2=Double.parseDouble(TextField.getText());

                switch(operator){
                    case '+':
                    result=num1+num2;
                    break;
                    case '-':
                    result=num1-num2;
                    break;
                    case '*':
                    result=num1*num2;
                    break;
                    case '/':
                    result=num1/num2;
                    break;
                }
                TextField.setText(String.valueOf(result));
                num1=result;  
          }
            if(e.getSource()==clrButton){
                TextField.setText("");
            }
            if(e.getSource()==delButton){
                String string= TextField.getText();
                TextField.setText("");
                for(int i=0;i<string.length()-1;i++){
                    TextField.setText(TextField.getText()+string.charAt(i));

                }
            }
            
        }
}        

  
