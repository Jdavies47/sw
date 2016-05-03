/**
 *  The main idea is to compute the relative and absolute error, and then
 *  have a case analysis. The first case is that the nominal quantity is
 *  less than 5ml or more than 10000ml. In these cases the nominal
 *  quantity is not in the range of the definition of \u212E.  Else the
 *  program checks whether for a nominal amount in a particular case the
 *  corresponding maximal negative absolute or relative error is within
 *  the bounds. If it is a corresponding positive answer is given. If not,
 *  a corresponding negative answer is given.
 *
 *  @author Manfred Kerber
 *  @version 2015-10-15
 */

import java.util.Scanner;
public class Estimate {

    /**
     *  @param actual The actual amount of liquid in the container.
     *  @param nominal The amount of liquid that should be in the container.
     *  @return true if the the actual amount of liquid is within the
     *  definition of estimate at least approximately the nominal
     *  amount, false else.
     *  
     *  Note this method is a stub which always returns true. A proper
     *  implementation is still missing.
     */
	
    private double actual, nominal;
	
	public double getActual() {
		return actual;
	}

	public void setActual(double actual) {
		this.actual = actual;
	}

	public double getNominal() {
		return nominal;
	}

	public void setNominal(double nominal) {
		this.nominal = nominal;
	}
	
	public static boolean estimateInBounds(double actual, double nominal) {
    	double absShortFall = nominal - actual;
    	double relShortFall = absShortFall / nominal;
    	
    	if (nominal > 5  && nominal < 50){
    		if (relShortFall <= 0.09){
    		return true;
    		}    	
        	else return false;
    	}    	
    	
    	if (nominal > 50 && nominal < 100){
    		if (absShortFall <= 4.5){
    		return true;
    		}
        	else return false;
    	}
    	
    	if (nominal > 100 && nominal < 200)
    	{
    		if (relShortFall <= 0.045){
    			return true;
    		}
        	else return false;
    	}
    	
    	if (nominal > 200 && nominal < 300)
    	{
    		if (absShortFall <= 9){
    			return true;
    		}
        	else return false;
    	}

    	if (nominal > 300 && nominal < 500)
    	{
    		if (relShortFall <= 0.03){
    			return true;
    		}
        	else return false;
    	}
    	
    	if (nominal > 500 && nominal < 1000)
    	{
    		if (absShortFall <= 15){
    			return true;
    		}
        	else return false;
    	}
    	
    	if (nominal > 1000 && nominal < 10000)
    	{
    		if (relShortFall <= 0.015){
    			return true;
    		}
        	else return false;
    	}
    	
    	if (nominal > 10000 || nominal < 5 || actual > 10000 || actual < 5){
    		System.out.println("Sorry, out of range.");
    		return false;
    	}
    	else return false;


    }

	public Estimate(double actual, double nominal) {
		super();
		this.actual = actual;
		this.nominal = nominal;
	}
    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	Estimate liquid = new Estimate(0,0);
    	System.out.println("Hello. Please enter the amount of liquid the container holds in ml: ");
    	liquid.setActual(input.nextDouble());
    	System.out.println("Please enter the amount of liquid the container SHOULD hold in ml: ");
    	liquid.setNominal(input.nextDouble());
    	
    	if (estimateInBounds(liquid.getActual(),liquid.getNominal()) == false){
    		if (liquid.getNominal() > 10000 || liquid.getNominal() < 5 || liquid.getActual() > 10000 || liquid.getActual() < 5){
    		System.out.println("Sorry, out of range.");
    		}
    		else
    		System.out.println("Too little liquid in the container!");
    	}
    	else
    		System.out.println("Amount of liquid in container is OK.");
  	}
	
    
}