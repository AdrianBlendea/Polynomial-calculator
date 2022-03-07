package controller;

import model.DivisionResult;
import model.Monomial;
import model.Polynomial;
import view.Calculator;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    private Calculator calculatorView;



    public Controller(Calculator calculatorView)
    {



        this.calculatorView=calculatorView;

        this.calculatorView.adaugareListener(new ActionListener(){


            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial p1 =new Polynomial();
                Polynomial p2 = new Polynomial();
                Polynomial result = new Polynomial();
                p1=p1.getPolynomial(calculatorView.getPolinomText1());
                p2=p2.getPolynomial(calculatorView.getPolinomText2());

                result =p1.add(p2);
                String afisare="";
                afisare=result.printPolynom();
                if(afisare == "")
                    afisare="0";
                calculatorView.getRezultat().setText(afisare);

            }
        });

        this.calculatorView.scadereListener(new ActionListener(){


            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial p1 =new Polynomial();
                Polynomial p2 = new Polynomial();
                Polynomial result = new Polynomial();
                p1=p1.getPolynomial(calculatorView.getPolinomText1());
                p2=p2.getPolynomial(calculatorView.getPolinomText2());

                result =p1.substract(p2);
                String afisare="";
                afisare=result.printPolynom();
                if(afisare == "")
                    afisare="0";
                calculatorView.getRezultat().setText(afisare);

            }
        });

        this.calculatorView.inmultireListener(new ActionListener(){


            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial p1 =new Polynomial();
                Polynomial p2 = new Polynomial();
                Polynomial result = new Polynomial();
                p1=p1.getPolynomial(calculatorView.getPolinomText1());
                p2=p2.getPolynomial(calculatorView.getPolinomText2());


                result =p1.multiply(p2);

                String afisare="";
                afisare=result.printPolynom();
                if(afisare == "")
                    afisare="0";
                calculatorView.getRezultat().setText(afisare);

            }
        });



        this.calculatorView.derivareListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial print = new Polynomial();
                print = print.getPolynomial(calculatorView.getPolinomText1());
                print=print.derivation();
                String afisare = "";
                afisare=print.printPolynom();
                if(afisare=="")
                {
                    afisare="0";
                }
                calculatorView.getRezultat().setText(afisare);
            }
        });

        this.calculatorView.integrareListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial print = new Polynomial();
                print = print.getPolynomial(calculatorView.getPolinomText1());
                print=print.integration();
                String afisare = print.printPolynom();
                calculatorView.getRezultat().setText(afisare);
            }
        });


        this.calculatorView.impartireListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial p1 =new Polynomial();
                Polynomial p2 = new Polynomial();
                DivisionResult result ;
                p1=p1.getPolynomial(calculatorView.getPolinomText1());
                p2=p2.getPolynomial(calculatorView.getPolinomText2());

                result = p1.division(p2);

                String print="";
                print = "Cat :  " + result.getQuotient().printPolynom() + "       Rest :     " +result.getRemainder().printPolynom();
                calculatorView.getRezultat().setText(print);



            }
        });






    }




}