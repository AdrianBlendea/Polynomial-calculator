package main;

import controller.Controller;
import model.Monomial;
import model.Polynomial;

import view.Calculator;

import java.sql.SQLOutput;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Calculator view =new Calculator("Calculator polinoame");
        Controller controller =new Controller(view);

    }
}
