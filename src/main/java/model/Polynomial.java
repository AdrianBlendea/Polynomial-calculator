package model;
import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private ArrayList<Monomial> polynom;


    public Polynomial ()
    {
        this.polynom =new ArrayList<Monomial>();
    }

    public ArrayList<Monomial> getPolynom() {
        return polynom;
    }

    public void addMonomial (Monomial monomial)
    {
        this.polynom.add(monomial);
        Collections.sort(polynom);
    }

    public String printPolynom ()
    {
        String prt="";
        for(Monomial m:this.polynom)
        {
            if(m.getCoef() >0)
            {
                prt+= " +";
            }

            prt += m.toString();



        }
        try {
            if (prt.charAt(1) == '+')
                prt = prt.substring(2);
        }
        catch(IndexOutOfBoundsException e)
        {

        }
        return prt;
    }

    public void normalize()
    {
        int size =this.getPolynom().get(0).getPower() +1;
      //  Vector<Integer> v = new Vector<Integer>(size);
        float[] freq= new float[size+1];

        for(Monomial m:this.polynom)
        {
            int index =m.getPower();
            freq[index]+= m.getCoef();
        }
        this.polynom.clear();

        for(int i=size ; i>=0; i--)
        {   if(freq[i]!=0)
            this.polynom.add(new Monomial(i,freq[i]));
        }
    }


   public Polynomial add(Polynomial p2)
   {    Polynomial Result = new Polynomial();

       for (Monomial m:this.getPolynom())
       {
           Result.polynom.add(m);
       }

       for(Monomial m:p2.getPolynom())
       {
         Result.polynom.add(m);
       }
    Result.normalize();

       return Result;
   }

   public Polynomial substract (Polynomial p2)
   {    Polynomial Result = new Polynomial();
       for (Monomial m:this.getPolynom())
       {
           Result.polynom.add(m);
       }

       for(Monomial m:p2.getPolynom())
       {
           Result.polynom.add(new Monomial(m.getPower(),-m.getCoef()));
       }
       Result.normalize();

       return Result;
   }

   public Polynomial multiply (Polynomial p2)
   {    Polynomial Result = new Polynomial();
       for (Monomial m1:this.polynom)
       {
           for(Monomial m2:p2.polynom)
           {
               Result.polynom.add(new Monomial(m1.getPower()+ m2.getPower(),m2.getCoef()*m1.getCoef()));

           }
       }
        Result.normalize();
       return Result;
   }

    public Polynomial derivation ()
    {   Polynomial Result = new Polynomial();

        for(Monomial m:this.polynom)
        {
            if(m.getPower() >0) {
                Result.addMonomial(new Monomial(m.getPower() - 1, m.getCoef() * m.getPower()));
            }

        }


      return Result;
    }

    public Polynomial integration ()
    {
        Polynomial Result = new Polynomial();

        for(Monomial m:this.polynom)
        {   if(m.getPower()!=0)
        {
            Result.polynom.add(new Monomial(m.getPower() + 1, m.getCoef() / (m.getPower() + 1)));
        }
        else
        {
            Result.polynom.add(new Monomial (1,m.getCoef()));
        }
        }

        return Result;
        }

    public DivisionResult division (Polynomial p2)
    {   Polynomial quotient = new Polynomial();
        Polynomial remainder= new Polynomial ();
        Polynomial multiply =new Polynomial(); // creeam alt polinom in care sa tinem doar indicele recent pentru a efectua inmultirea
            try{
        while(this.polynom.get(0).getPower()>=p2.polynom.get(0).getPower())
        {

            int pwd = this.polynom.get(0).getPower()-p2.polynom.get(0).getPower();
            float cf = this.polynom.get(0).getCoef()/p2.polynom.get(0).getCoef();
            Monomial m = new Monomial(pwd,cf);
            quotient.addMonomial(m);    //adaugam in cat
            multiply.addMonomial(m);
            Polynomial substract = p2.multiply(multiply); // facem inmultirea
            multiply.getPolynom().clear(); //curatam ceilalti indici
            this.polynom= this.substract(substract).polynom; // facem scaderea

        } remainder = this;
            }
            catch(IndexOutOfBoundsException e){remainder.addMonomial(new Monomial(0,0));

    } // acest block try catch este necesar pt cazurile de impartire fara rest deoarece polinomul o sa se reduca complet prin scadeeri


      return new DivisionResult(quotient,remainder) ;
    }

    public Polynomial getPolynomial (JTextField j)
    {
        String exp = j.getText();
        exp=exp.replaceAll("\\s+",""); // inlatura spatiile goale din input
        Pattern pattern = Pattern.compile("([+-]?[^-+]+)");
        Matcher matcher = pattern.matcher(exp);
        Monomial help=new Monomial(1,1);
        Polynomial result =new Polynomial();
        while (matcher.find()){
            String monom = matcher.group(1);
            result.addMonomial(help.stringToMonomial(monom));


        }
        result.normalize();
        return result;

    }

   }

