package model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;

import customExceptions.TooLargeNumber;
import customExceptions.WrongNumberEntry;
import model.MagicSquare;

class MagicSquareTest {
	/**
	 * relationship with the class of the model
	 */
	private MagicSquare sq;
	
	/**
	 * first stage, it is empty since the constructor of the magic square class will be tested
	 */
	private void setupScenary1() {
	
	}
	/**
	 * second stage,a magical square of order 9 is created
	 * and you want to fill in the northwest direction starting at the up
	 */
	private void setupScenary2() {      // direction northwest
		
		sq = new MagicSquare(9);
		sq.setDirection("northwest");
		sq.setFirstPosition('u');
		sq.fillSquare();
	}
	/**
	 * third stage,a magical square of order 3 is created
	 * and you want to fill in the northeast direction starting at the right
	 */
	private void setupScenary3() {      // direction northeast
		sq = new MagicSquare(3);
		sq.setDirection("northeast");
		sq.setFirstPosition('r');
		sq.fillSquare();
	}
	/**
	 * fourth stage,a magical square of order 4 is created
	 * and you want to fill in the southwest direction starting at the left
	 */
	private void setupScenary4() {       // direction southwest
		sq = new MagicSquare(5);
		sq.setDirection("southwest");
		sq.setFirstPosition('l');
		sq.fillSquare();
	}
	/**
	 * fifth stage, a magical square of order 5 is created
	 * and you want to fill in the southeast direction starting at the down
	 */
	private void setupScenary5() {      // direction southeast
		sq = new MagicSquare(7);
		sq.setDirection("southeast");
		sq.setFirstPosition('d');
		sq.fillSquare();
	}
	
	/**
	 *  test to know if it catches the exception
	 */
	
	@Test
	void testSetOrder1()  {  			
		setupScenary2();
		
		try {
			sq.setOrder(4);
			fail("does not capture the exception");
		}catch(WrongNumberEntry e){
			
		}catch(TooLargeNumber t){
			
		}catch(NegativeArraySizeException n){
			
		}
	}
	
	/**
	 * test to know if it does not catch the exception when the value is correct
	 */
	@Test
	void testSetOrder2() {  			
		setupScenary2();
		
		
		try {
			sq.setOrder(9);
			assertTrue("the value of the order of the square was not changed", sq.getOrder() == 9);
		} catch (WrongNumberEntry e) {
			fail("catch the exception when you should not");
		}catch(TooLargeNumber t) {
			fail("catch the exception when you should not");
		}catch(NegativeArraySizeException n) {
			fail("catch the exception when you should not");
		}
	
	}
	
	/**
	 * test to verify the correct creation of a square and the correct functioning of trivial methods
	 */
	
	@Test
	void testMagicSquare() { 
		setupScenary1();
		
			sq = new MagicSquare(9);
			sq.setDirection("northwest");
			sq.setFirstPosition('u');
			assertNotNull("The new magic square is null", sq);
			assertTrue("the value of the order is not assigned correctly", sq.getOrder() == 9);
			assertTrue("the value of the direction is not assigned correctly", sq.getDirection().equals("northwest"));
			assertTrue("the value of the first position is not assigned correctly", sq.getFirstPosition() == 'u');
			int magicConst = (int) (Math.pow(9,2) + 1);
			magicConst = (9*magicConst)/2;
			assertTrue("the magic constant is not calculated correctly", magicConst == sq.getMagicConstant());
		
	
	}
	
	/**
	 * test to verify that when filling the square in the northwest 
	 * direction all the values assigned in the square are different.
	 */
	
	@Test
	void testFillSquare1(){   // direction northwest
		setupScenary2();
		
	
		HashSet<Integer> hash = new HashSet<Integer>();
		
		for(int i=0; i<sq.getSquare().length; i++) {
			for(int j=0; j<sq.getSquare().length; j++) {
				hash.add(sq.getSquare()[i][j]);
			}
		}
		boolean dif = false;
		
		if(hash.size() == sq.getOrder()*sq.getOrder()) { 
			dif = true;
		}
		
		assertTrue("The square has some repeated value", dif);
		
	}
	
	/**
	 * test to verify that when filling the square in the northeast 
	 * direction all the values assigned in the square are different.
	 */
	
	@Test
	void testFillSquare2() throws WrongNumberEntry, TooLargeNumber {      // direction northeast
		setupScenary3();
		
	
		HashSet<Integer> hash = new HashSet<Integer>();
		
		for(int i=0; i<sq.getSquare().length; i++) {
			for(int j=0; j<sq.getSquare().length; j++) {
				hash.add(sq.getSquare()[i][j]);
			}
		}
		boolean dif = false;
		
		if(hash.size() == sq.getOrder()*sq.getOrder()) {
			dif = true;
		}
		
		assertTrue("The square has some repeated value", dif);
		
	}
	
	/**
	 * test to verify that when filling the square in the southwest 
	 * direction all the values assigned in the square are different.
	 */
	
	@Test
	void testFillSquare3() throws WrongNumberEntry, TooLargeNumber {      // direction southwest
		setupScenary4();
		
	
		HashSet<Integer> hash = new HashSet<Integer>();
		
		for(int i=0; i<sq.getSquare().length; i++) {
			for(int j=0; j<sq.getSquare().length; j++) {
				hash.add(sq.getSquare()[i][j]);
			}
		}
		boolean dif = false;
		
		if(hash.size() == sq.getOrder()*sq.getOrder()) {
			dif = true;
		}
		
		assertTrue("The square has some repeated value", dif);
		
	}
	
	/**
	 * test to verify that when filling the square in the southeast 
	 * direction all the values assigned in the square are different.
	 */
	
	@Test
	void testFillSquare4() throws WrongNumberEntry, TooLargeNumber {     // direction southeast
		setupScenary5();
		
	
		HashSet<Integer> hash = new HashSet<Integer>();
		
		for(int i=0; i<sq.getSquare().length; i++) {
			for(int j=0; j<sq.getSquare().length; j++) {
				hash.add(sq.getSquare()[i][j]);
			}
		}
		boolean dif = false;
		
		if(hash.size() == sq.getOrder()*sq.getOrder()) {
			dif = true;
		}
		
		assertTrue("The square has some repeated value", dif);
		
	}

	/**
	 * test to Verify that the square is filled, forming a correct magic square according in the direction northwest.
	 */
	@Test
	void testDiagonalNo(){
		setupScenary2();
		
		int[][] squM = sq.getSquare();
		int constant = sq.getMagicConstant();
		
		int sum = 0;
		boolean exit = false;
		
			for(int i=0; i<squM.length && !exit; i++) {              // rows sum
				for(int j=0; j<squM.length && !exit; j++) {
					sum+= squM[i][j];
				}
				if(sum != constant) {
					exit = true;
				}
				sum =0;
			}
			
			for(int i=0; i<squM.length && !exit; i++) {            // colums sum
				for(int j=0; j<squM.length && !exit; j++) {
					sum+= squM[j][i];
				}
				if(sum != constant) {
					exit = true;
				}
				sum =0;
			}
			
			for(int i=0; i<squM.length && !exit; i++) {				// diagonal sum
					sum+= squM[i][i];
			}		
				if(sum != constant) {
					exit = true;
					sum =0;
				}
			sum =0;
			
			for(int i=0; i<squM.length && !exit; i++) {					// reverse diagonal sum
				for(int j=squM.length-1; j>-1 && !exit; j--) {		
					sum+= squM[i][j];
				}
				if(sum != constant) {
					exit = true;
				}
				sum =0;
			}
			
			assertTrue("the magic square in the northwest direction was not generated correctly", !exit);
			
	}
	
	/**
	 * test to Verify that the square is filled, forming a correct magic square according in the direction northeast.
	 */
	
	@Test
	void testDiagonalNe(){
		setupScenary3();
		
		int[][] squM = sq.getSquare();
		int constant = sq.getMagicConstant();
		
		int sum = 0;
		boolean exit = false;
		
			for(int i=0; i<squM.length && !exit; i++) {              // rows sum
				for(int j=0; j<squM.length && !exit; j++) {
					sum+= squM[i][j];
				}
				if(sum != constant) {
					exit = true;
				}
				sum =0;
			}
			
			for(int i=0; i<squM.length && !exit; i++) {            // colums sum
				for(int j=0; j<squM.length && !exit; j++) {
					sum+= squM[j][i];
				}
				if(sum != constant) {
					exit = true;
				}
				sum =0;
			}
			
			for(int i=0; i<squM.length && !exit; i++) {				// diagonal sum
					sum+= squM[i][i];
			}		
				if(sum != constant) {
					exit = true;
					sum =0;
				}
			sum =0;
			
			for(int i=0; i<squM.length && !exit; i++) {					// reverse diagonal sum
				for(int j=squM.length-1; j>-1 && !exit; j--) {		
					sum+= squM[i][j];
				}
				if(sum != constant) {
					exit = true;
				}
				sum =0;
			}
			
			assertTrue("the magic square in the northeast direction was not generated correctly", !exit);
			
	}
	
	/**
	 * test to Verify that the square is filled, forming a correct magic square according in the direction southwest.
	 */
	
	@Test
	void testDiagonalSo(){
		setupScenary4();
		
		int[][] squM = sq.getSquare();
		int constant = sq.getMagicConstant();
		
		int sum = 0;
		boolean exit = false;
		
			for(int i=0; i<squM.length && !exit; i++) {              // rows sum
				for(int j=0; j<squM.length && !exit; j++) {
					sum+= squM[i][j];
				}
				if(sum != constant) {
					exit = true;
				}
				sum =0;
			}
			
			for(int i=0; i<squM.length && !exit; i++) {            // colums sum
				for(int j=0; j<squM.length && !exit; j++) {
					sum+= squM[j][i];
				}
				if(sum != constant) {
					exit = true;
				}
				sum =0;
			}
			
			for(int i=0; i<squM.length && !exit; i++) {				// diagonal sum
					sum+= squM[i][i];
			}		
				if(sum != constant) {
					exit = true;
					sum =0;
				}
			sum =0;
			
			for(int i=0; i<squM.length && !exit; i++) {					// reverse diagonal sum
				for(int j=squM.length-1; j>-1 && !exit; j--) {		
					sum+= squM[i][j];
				}
				if(sum != constant) {
					exit = true;
				}
				sum =0;
			}
			
			assertTrue("the magic square in the southwest direction was not generated correctly", !exit);
			
	}
	
	/**
	 * test to Verify that the square is filled, forming a correct magic square according in the direction southeast.
	 */
	
	@Test
	void testDiagonalSe(){
		setupScenary5();
		
		int[][] squM = sq.getSquare();
		int constant = sq.getMagicConstant();
		
		int sum = 0;
		boolean exit = false;
		
			for(int i=0; i<squM.length && !exit; i++) {              // rows sum
				for(int j=0; j<squM.length && !exit; j++) {
					sum+= squM[i][j];
				}
				if(sum != constant) {
					exit = true;
				}
				sum =0;
			}
			
			for(int i=0; i<squM.length && !exit; i++) {            // colums sum
				for(int j=0; j<squM.length && !exit; j++) {
					sum+= squM[j][i];
				}
				if(sum != constant) {
					exit = true;
				}
				sum =0;
			}
			
			for(int i=0; i<squM.length && !exit; i++) {				// diagonal sum
					sum+= squM[i][i];
			}		
				if(sum != constant) {
					exit = true;
					sum =0;
				}
			sum =0;
			
			for(int i=0; i<squM.length && !exit; i++) {					// reverse diagonal sum
				for(int j=squM.length-1; j>-1 && !exit; j--) {		
					sum+= squM[i][j];
				}
				if(sum != constant) {
					exit = true;
				}
				sum =0;
			}
			
			assertTrue("the magic square in the southeast direction was not generated correctly", !exit);
			
	}
	
	
}
