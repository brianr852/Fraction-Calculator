/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractioncalculator;

/**
 *
 * @author brian
 */
public class fraction {
  private int numerator;
  private int denominator;
  
  /**
   * Default constructor:<BR>
   * Sets numerator and denominator to 1
   */
  public fraction()
  {
    this.numerator = 1;
    this.denominator = 1;
  }
  
  
  /**
   * Overloaded constructor:<BR>
   * Allows client to set beginning values for numerator
   *   and denominator
   *   The created fraction is NOT simplified
   * This constructor takes two parameters<BR>
   * Calls mutator methods to validate new values
   * @param numerator the numerator of the fraction
   * @param denominator the denominator of the fraction
   */
  public fraction(int numerator, int denominator)
  {
    setNumerator( numerator );
    setDenominator( denominator );
  }
  
  /** getNumerator method
    * @return the numerator of the fraction
    */
  public int getNumerator( )
  {
    return this.numerator;
  }
  
  /**
   * Mutator method:<BR>
   * Allows client to set value of numerator
   * @param numerator the new value of numerator
   */
  public void setNumerator( int numerator )
  {
    this.numerator = numerator;
  }
  
  /** getDenominator method
    * @return the denominator of the fraction
    */
  public int getDenominator( )
  {
    return this.denominator;
  }
  
  /**
   * Mutator method:<BR>
   * Allows client to set value of denominator
   * <B>setDenominator</B> sets the value
   *   of <B>denominator</B> to 1 if newDenominator has value 0
   * @param denominator the new denominator
   */
  public void setDenominator( int denominator )
  {
    if ( denominator != 0 )
      this.denominator = denominator;
    else
    {
      this.denominator = 1;
    }
  }
  
  /**
   * Creates a Fraction object that is this Fraction simplified
   *
   */
  public fraction simplify()
  {
    int divideBy = gcd(this.numerator, this.denominator);
    return  new fraction((this.numerator / divideBy),
                         (this.denominator / divideBy));
  }
  
  /**
   * Compute the greatest common divisor of two positive integers
   *
   * @param a the first argument of gcd
   * @param b the second argument of gcd
   *
   * @return the gcd of the two arguments
   */
  private int gcd(int a, int b)
  {
    int result = 1;
    if (a == b)
      result = a;
    else
    {
      int smaller = Math.min(a,b);
      while (smaller > 0 && result == 1)
      {
        if ((a%smaller == 0) && (b%smaller == 0))
          result = smaller;
        smaller--;
      }
    }
    return result;
  }
  
  /**
   * @return the String representation of the fraction
   */
  public String toString( )
  {
    return( this.numerator + "/" + this.denominator );
  }
  
  /**
   * equals method
   * Compares two Fraction objects for the same field values
   * @param other another Fraction object
   * @return a boolean, true if this object
   * has the same field values as the parameter r
   */
  public boolean equals( fraction other )
  {
    return ( this.numerator == other.numerator
              && this.denominator == other.denominator );
  }
  
  //  vvvvvvvvvvvvvvvvv NEW METHODS  vvvvvvvvvvvvvv
  
  /**
   * reciprocal method
   * @return a Fraction, the reciprocal of this fraction or null
   *        if the new denominator is to be 0
   */
  public fraction reciprocal( )
  {
    if ( this.numerator == 0 )
    {
      return null ;
    }
    else
      return new fraction ( this.denominator , this.numerator ) ;
  }
  
  /**
   * negate method
   * @return a Fraction, the negation of this Fraction
   */
  public fraction negate( )
  {
    if ( this.numerator < 0 && this.denominator < 0 )
      return new fraction ( -this.numerator, -this.denominator ) ;
    else if ( this.numerator < 0 )
      return new fraction ( -this.numerator, this.denominator ) ;
    else
      return new fraction ( -this.numerator, this.denominator ) ;
  }
  
  /**
   * add method
   * Adds two Fraction objects and produces the result simplified (utilizes gcd method)
   * @param other another Fraction object
   * @return a Fraction, the result of the addition simplified.
   */
  public fraction add ( fraction other )
  {
    fraction frac = new fraction ( ( this.numerator * other.getDenominator() ) + ( other.getNumerator() * this.denominator ) , 
                                   ( this.denominator * other.getDenominator() ) ) ;
    fraction simpFrac = frac.simplify() ;
    
    return simpFrac ;
  }
  
  /**
   * multiply method
   * Multiplies two Fraction objects and produces the result simplified (utilized gcd method)
   * @param other another Fraction object
   * @return a Fraction, the result of the multiplication simplified
   */
  public fraction multiply( fraction other )
  {
    fraction frac = new fraction ( ( this.numerator * other.getNumerator() ) , 
                                   ( this.denominator * other.getDenominator() ) ) ;
    fraction simpFrac = frac.simplify() ;
    return simpFrac ;
  }
}
