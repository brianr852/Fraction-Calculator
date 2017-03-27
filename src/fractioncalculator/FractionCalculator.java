/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractioncalculator;

import java.util.Scanner;

/**
 *
 * @author brian
 */
public class FractionCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        final String VALID_NUMBER = "[0123456789]+" ;
    final String VALID_OPERATOR = "[+*:-]" ;
    
    Scanner scan = new Scanner ( System.in ) ;
    
    //1. prompts the user for four integers needed to create two Fraction objects
    String numerator1 = "" ;
    String numerator2 = "" ;
    String denominator1 = "" ;
    String denominator2 = "" ;
    
    do
    {
      System.out.println ( "please enter the numerator of the first fraction > " ) ;
      numerator1 = scan.next() ;
    } while ( ! ( numerator1.matches ( VALID_NUMBER ) ) ) ;
    do
    {
      System.out.println ( "please enter the denominator of the first fraction > " ) ;
      denominator1 = scan.next() ;
    } while ( ! ( denominator1.matches ( VALID_NUMBER ) ) ) ;
    if ( denominator1.equals("0") )
    {
      System.out.println ( "denominator cannot be equal to 0" ) ;
      System.out.println ( "denominator set to 1" ) ;
      System.out.println ( "fraction one is " + numerator1 + "/1" );
    }
    else
      System.out.println ( "fraction one is " + numerator1 + "/" + denominator1 ) ;
    do
    {
      System.out.println ( "please enter the numerator of the second fraction > " ) ;
      numerator2 = scan.next() ;
    } while ( ! ( numerator2.matches ( VALID_NUMBER ) ) ) ;
    do
    {
      System.out.println ( "please enter the denominator of the second fraction > " ) ;
      denominator2 = scan.next() ;
    } while ( ! ( denominator2.matches ( VALID_NUMBER ) ) ) ;
    if ( denominator2.equals("0") )
    {
      System.out.println ( "denominator cannot be equal to 0" ) ;
      System.out.println ( "denominator set to 1" ) ;
      System.out.println ( "fraction two is " + numerator2 + "/1" );
    }
    else
      System.out.println ( "fraction two is " + numerator2 + "/" + denominator2 ) ;
    
    
    //2. creates two Fraction objects
    
    int num1 = Integer.parseInt( numerator1 ) ;
    int num2 = Integer.parseInt ( numerator2 ) ;
    int denom1 = Integer.parseInt ( denominator1 ) ;
    int denom2 = Integer.parseInt ( denominator2 ) ;
    fraction frac1 = new fraction ( num1 , denom1 ) ;
    fraction frac2 = new fraction ( num2 , denom2 ) ;
    
    //3. prompts for the operation to be performed on these objects which is 
    //          one of: addition, subtraction, multiplication or division
    String operator = "" ;
    do
    {
      System.out.println ( "pleaser enter the operation you would like to perform ( + - * : ) > " ) ;
      operator = scan.next() ;
    } while ( ! ( operator.matches ( VALID_OPERATOR ) ) ) ;
    
    //4. performs the requested operation by calling appropriate method from your Fraction class 
    //          and displays the result. Use switch. See the attached sample run.    
    //
    // HINT:
    // if I wanted to add two Fraction objects f1 and f2
    // I would do the following to compute the sum and to print the result:
    //
    //     Fraction sum = f1.add(f2);
    //     System.out.println(f1 + " + " + f2 + " = " + sum );
    //
    
    switch ( operator.charAt ( 0 ) )
    {
      case '+' :
        fraction sum = frac1.add(frac2) ;
        System.out.println( frac1.getNumerator() + "/" + frac1.getDenominator() + " + " + frac2.getNumerator() + "/" + frac2.getDenominator() + " = " + sum ) ;
        break;
      case '-' :
        fraction negFrac2 = frac2.negate() ;
        fraction difference = frac1.add(negFrac2) ;
        System.out.println( frac1.getNumerator() + "/" + frac1.getDenominator() + " - " + frac2.getNumerator() + "/" + frac2.getDenominator() + " = " + difference ) ;     
        break ;
      case '*' :
        fraction product = frac1.multiply(frac2) ;
        System.out.println( frac1.getNumerator() + "/" + frac1.getDenominator() + " * " + frac2.getNumerator() + "/" + frac2.getDenominator() + " = " + product ) ;
        break ;
        case ':' :
          if ( num2 == 0 )
        {
          System.out.println ( "reciprocal not created cannot divide by 0" );
          System.out.println( num1 + "/" + denom1 + " : " + num2 + "/" + denom2 + " cannot be computed" ) ;
        }
          else
          {
            fraction recipFrac2 = frac2.reciprocal() ;
            fraction quotient = frac1.multiply(recipFrac2) ;
        System.out.println( frac1.getNumerator() + "/" + frac1.getDenominator() + " : " + frac2.getNumerator() + "/" + frac2.getDenominator() + " = " + quotient ) ;
          }
          break ;
      default :          
    }
    }
    
}
