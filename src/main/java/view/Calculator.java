package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {

private JPanel textPanel;
private JPanel rezultatPanel;
private JPanel buttonsPanel;
private JLabel polinom1;
private JTextField polinomText1;
private JLabel polinom2;
private JTextField polinomText2;
private JTextField rezultat;
private JLabel rezultatLabel;
private JButton addButton;
private JButton substractButton;
    private JButton multiplyButton;
    private JButton derivationButton;
    private JButton integrationButton;
    private JButton divideButton;
    private JPanel helpPanel;

    private JLabel tip1;
    private JLabel tip2;
    private JLabel tip3;
    private JLabel tip4;
    private JLabel tip5;
    private JLabel tip6;
public Calculator(String name)
{
    JFrame frame = new JFrame(name);



    polinom1=new JLabel("Polinom 1:");
    polinomText1=new JTextField(30);
    polinom2=new JLabel("Polinom 2:");
    polinomText2=new JTextField(30);

    this.textPanel=new JPanel();
    this.textPanel.setLayout(new FlowLayout());
    textPanel.add(polinom1);
    textPanel.add(polinomText1);
    textPanel.add(polinom2);
    textPanel.add(polinomText2);

    rezultatPanel=new JPanel();
    rezultatPanel.setLayout(new FlowLayout());
    rezultat=new JTextField(60);
   rezultatLabel=new JLabel("Rezultat");
   rezultatPanel.add(rezultatLabel);
   rezultatPanel.add(rezultat);

    buttonsPanel = new JPanel();
    this.buttonsPanel.setLayout(new GridBagLayout());

    this.addButton = new JButton();
    addButton.setText("Adunare");
    this.substractButton = new JButton();
    substractButton.setText("Scadere");
    this.multiplyButton = new JButton();
    multiplyButton.setText("Inmultire");
    this.derivationButton = new JButton();
    derivationButton.setText("Derivare");
    this.integrationButton = new JButton();
    integrationButton.setText("Integrare");
    this.divideButton = new JButton();
    divideButton.setText("Impartire");

    this.buttonsPanel.add(addButton);
    this.buttonsPanel.add(substractButton);
    this.buttonsPanel.add(multiplyButton);
    this.buttonsPanel.add(derivationButton);
    this.buttonsPanel.add(integrationButton);
    this.buttonsPanel.add(divideButton);

    tip1 = new JLabel("Reguli de folosire:");
    tip2 = new JLabel("Se va folosi intotdeauna caracterul 'X'(mare) pentru a reprezenta necunoscuta polinomului!!!");
    tip2.setForeground(Color.RED);
    tip3=new JLabel("Se vor introduce mereu si indicii care sunt 1 exemplu: 1X^1 !!!");
    tip3.setForeground(Color.RED);
    tip4=new JLabel("Pentru operatiile care necesita un singur polinom se va folosi casuta text din stanga (Polinom 1)!!!");
    tip4.setForeground(Color.RED);
    tip5=new JLabel("Operatia de impartire va realiza impartirea polinomului din campul din stanga la cel din campul din dreapta!!!");
    tip5.setForeground(Color.RED);
    tip6=new JLabel("Nerespectarea acestor conditii va aduce rezultate eronate!!!");
    tip6.setForeground(Color.RED);
    helpPanel=new JPanel();
    helpPanel.setLayout(new BoxLayout(helpPanel,BoxLayout.PAGE_AXIS));
    helpPanel.add(tip1);
    helpPanel.add(tip2);
    helpPanel.add(tip3);
    helpPanel.add(tip4);
    helpPanel.add(tip5);
    helpPanel.add(tip6);






  //  this.getContentPane().setSize(400, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1920,800);
   frame.setLayout(new BorderLayout());
   frame.add(textPanel, BorderLayout.NORTH);
   frame.add(rezultatPanel,BorderLayout.SOUTH);
   frame.add(buttonsPanel,BorderLayout.EAST);
   frame.add(helpPanel,BorderLayout.CENTER);
   frame.setVisible(true);


}
public void adaugareListener(ActionListener actionListener)
{
    this.addButton.addActionListener(actionListener);
}

    public void scadereListener(ActionListener actionListener)
    {
        this.substractButton.addActionListener(actionListener);
    }

    public void inmultireListener(ActionListener actionListener)
    {
        this.multiplyButton.addActionListener(actionListener);
    }

    public void derivareListener(ActionListener actionListener)
    {
        this.derivationButton.addActionListener(actionListener);
    }

    public void integrareListener(ActionListener actionListener)
    {
        this.integrationButton.addActionListener(actionListener);
    }

    public void impartireListener(ActionListener actionListener)
    {
        this.divideButton.addActionListener(actionListener);
    }

    public JTextField getRezultat() {
        return rezultat;
    }

    public JTextField getPolinomText1() {
        return polinomText1;
    }

    public JTextField getPolinomText2() {
        return polinomText2;
    }
}
