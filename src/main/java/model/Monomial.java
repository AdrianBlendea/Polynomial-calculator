package model;

import java.util.StringTokenizer;

public class Monomial implements Comparable<Monomial> {
    private int power;
    private float coef;

    public Monomial (int power, float coef)
    {
        this.coef=coef;
        this.power =power;

    }

    public int getPower() {
        return power;
    }

    public float getCoef() {
        return coef;
    }

    @Override
    public String toString() {
        if (this.power != 0) {
            return this.coef + " * " + "X^" + this.power + " ";
        } else {
            if(this.coef !=0) {
                return Float.toString(this.coef);
            }
            else
            {
                return "";
            }
            }
    }

    @Override
    public int compareTo(Monomial o) {
        return o.power - this.power;
    }

    public Monomial stringToMonomial (String s)
    {
        Monomial m;
        StringTokenizer div =new StringTokenizer(s,"X");

        if(s.charAt(0)=='-') {
           m=this.caseMinus(div,s);


        }
        else if(s.charAt(0)=='+')
        {
            m=this.casePlus(div,s);

        }

        else {
            m=caseNothing(div,s);
        }

        return m;
    }
    public Monomial caseMinus(StringTokenizer div,String s)
    {
        Monomial m;

            if (div.countTokens() == 1) {
                float coef=0;
                for(int i=1 ; i <= s.length()-1;i++)
                {
                    coef = coef*10 +Character.getNumericValue(s.charAt(i));
                }
                m = new Monomial(0,-coef);

            }
            else
            {
                String coef = div.nextToken();
                String pwd =div.nextToken();
                int cf=0;
                for(int i=1 ; i <= coef.length()-1;i++)
                {
                    cf = cf*10 +Character.getNumericValue(coef.charAt(i));
                }
                m = new Monomial(Character.getNumericValue(pwd.charAt(pwd.length()-1)),-cf);




            }



        return m;

    }

    public Monomial casePlus(StringTokenizer div,String s) {
        Monomial m;

        if (div.countTokens() == 1) {
            float coef = 0;
            for (int i = 1; i <= s.length() - 1; i++) {
                coef = coef * 10 + Character.getNumericValue(s.charAt(i));
            }
            m = new Monomial(0, coef);

        } else {
            String coef = div.nextToken();
            String pwd = div.nextToken();
            int cf = 0;
            for (int i = 1; i <= coef.length() - 1; i++) {
                cf = cf * 10 + Character.getNumericValue(coef.charAt(i));
            }
            m = new Monomial(Character.getNumericValue(pwd.charAt(pwd.length() - 1)), cf);


        }
        return m;


    }
    public Monomial caseNothing (StringTokenizer div,String s)
    {
        Monomial m;
        if (div.countTokens() == 1) {
            float coef = 0;
            for (int i = 0; i <= s.length() - 1; i++) {
                coef = coef * 10 + Character.getNumericValue(s.charAt(i));
            }
            m = new Monomial(0, coef);

        } else {
            String coef = div.nextToken();
            String pwd = div.nextToken();
            int cf = 0;
            for (int i = 0; i <= coef.length() - 1; i++) {
                cf = cf * 10 + Character.getNumericValue(coef.charAt(i));
            }
            m = new Monomial(Character.getNumericValue(pwd.charAt(pwd.length() - 1)), cf);


        }
        return m;
    }


}
