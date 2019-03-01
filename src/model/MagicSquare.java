/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Icesi University (Cali - Colombia)
 * Faculty of Engineering (algorithms and programming 1)
 * laboratory 1
 * By: Carlos Andrés Restrepo Marín 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package model;

import customExceptions.TooLargeNumber;
import customExceptions.WrongNumberEntry;

public class MagicSquare {
	
		// Attributes 
		/**
		 *represents the order of the magic square
		 */
		private  int order;
		/**
		 * that represents the magicConstant of the magic square
		 */
		private  int magicConstant;
		/**
		 * matrix that represents the square
		 */
		private  int[][] square;
		/**
		 * represents the starting place for filling the square
		 */
		private char firstPosition;
		/**
		 *represents the direction to which the square is going to be completed
		 */
		private String direction;
		
		// constants
		
		/**
		 * represents the northwest direction 
		 */
		public static final String DIAGONAL_NO = "northwest";
		/**
		 * represents the northeast direction 
		 */
		public static final String DIAGONAL_NE = "northeast";
		/**
		 * represents the southwest direction 
		 */
		public static final String DIAGONAL_SO = "southwest";
		/**
		 * represents the southeast direction 
		 */
		public static final String DIAGONAL_SE = "southeast";
		
		
		/**
		 * represents the choice to start filling the square up
		 */
		public static final char UP = 'u';
		/**
		 * represents the choice to start filling the square left
		 */
		public static final char LEFT = 'l';
		/**
		 * represents the choice to start filling the square down
		 */
		public static final char DOWN = 'd';
		/**
		 * represents the choice to start filling the square right
		 */
		public static final char RIGHT = 'r';
		
		
		// builder
		
		/**
		 <b>Description:</b>
				* Initialize a new square.
				* @param order the order of the square
		 */
		
		public MagicSquare(int order){
			
		
			this.order = order;
			square = new int[order][order];
			
			int mgc = (int) (Math.pow(order,2) + 1);
			magicConstant = (order*mgc)/2;
			
		}
		/**
		 * * <b>Description:</b>
				* allows to obtain the order of the square.
		 * @return the square order.
		 */
		
		public int getOrder() {
			return order;
		}	
		/**
		 * * <b>Description:</b>
				* allows to modify the order of the square
		 * @param nn the new square order.
		 * @throws WrongNumberEntry the order of the square is even
		 * @throws TooLargeNumber the order of the square is very large
		 * @throws NegativeArraySizeException the order of the square is negative
		 */
		public void setOrder(int nn) throws WrongNumberEntry, TooLargeNumber, NegativeArraySizeException {
			if(nn%2 ==0) {
				throw new WrongNumberEntry("only odd numbers are allowed");
			}
			if(nn>TooLargeNumber.MAX_NUMBER) {
				throw new TooLargeNumber("the number is too large to generate the square");
			}
			
			this.order = nn;
			square = new int[order][order];
			
			int mgc = (int) (Math.pow(nn,2) + 1);
			magicConstant = (nn*mgc)/2;
		}
		/**
		 * * <b>Description:</b>
				* allows to obtain the square.
		 * @return the square.
		 */
		public int[][] getSquare(){
			return square;
		}
		
		/**
		 * * <b>Description:</b>
				* allows to obtain the magic constant of the square.
		 * @return the magic constant.
		 */
		public int getMagicConstant() {
			return magicConstant;
		}
		/**
		 * * <b>Description:</b>
				* allows to obtain the first position that the user chose
		 * @return the first position;
		 */
		public char getFirstPosition() {
			return firstPosition;
		}
		/**
		 * * <b>Description:</b>
				* allows to modify the first position that the user chose.
		 * @param firstPosition the new position.
		 */
		public void setFirstPosition(char firstPosition) {
			this.firstPosition = firstPosition;
		}
		/**
		 * * <b>Description:</b>
				* allows to obtain the direction in which the square is filled.
		 * @return the square direction.
		 */

		public String getDirection() {
			return direction;
		}

		/**
		 * * <b>Description:</b>
		 	* allows to modify the direction in which the square is filled.
		 * @param direction the new direction. 
		 */
		public void setDirection(String direction) {
			this.direction = direction;
		}
		
		/**
		 * * <b>Description:</b>
		 	* fill the square in the northeast direction regardless if the first position is up or right.
		 
		 * <b>pre:</b> the matrix square has already been inicializated.
		 * 
		 * @param m row of the first position.
		 * @param n column of the first position
		 * 
		 *  <b>post:</b> elements have been added to the matrix squared
		 */
		public void diagonalNe(int m, int n) {
			
			for(int i=2; i<=order*order; i++) {
				
			
					if(m==0 && n == order-1 ) {
						
						if(firstPosition == UP) {
							m++;
							square[m][n] = i;
						}else {
							n--;
							square[m][n] = i;
						}
							
					}else if(m==0) {
					
						if(square[order-1][n+1] ==0) {
							m = order-1;
							n++;
							square[m][n] = i;
						}		
					}else if(n == order-1) {
						if(square[m-1][0] == 0) {
							m--;
							n=0;
							square[m][n] = i;
						}
					}else if(square[m-1][n+1]  == 0 && n!= order-1) {
						m--; 
						n++;
						square[m][n] = i;
					}else {
						if(firstPosition == UP) {
							m++;
							square[m][n] = i;
						}else {
							n--;
							square[m][n] = i;
						}
						
					}
					
				}
			}
		
		
		/**
		 * * <b>Description:</b>
		 	* fill the square in the northwest direction regardless if the first position is up or left.
		 
		 * <b>pre:</b> the matrix square has already been inicializated.
		 * 
		 * @param m row of the first position.
		 * @param n column of the first position
		 * 
		 *  <b>post:</b> elements have been added to the matrix squared
		 */
		public void diagonalNo(int m, int n) {

			for(int i=2; i<=order*order; i++) {
				if(m==0 && n == 0 ) {
					
					if(firstPosition == UP) {
						m++;
						square[m][n] = i;
					}else {
						n++;
						square[m][n] = i;
					}
						
				}else if(m==0) {
				
					if(square[order-1][n-1] ==0) {
						m = order-1;
						n--;
						square[m][n] = i;
					}		
				}else if(n == 0) {
					if(square[m-1][order-1] == 0) {
						m--;
						n=order-1;
						square[m][n] = i;
					}
				}else if(square[m-1][n-1]  == 0 && n!= 0) {
					m--; 
					n--;
					square[m][n] = i;
				}else {
					if(firstPosition == UP) {
						m++;
						square[m][n] = i;
					}else {
						n++;
						square[m][n] = i;
					}
					
				}
			}
			}
			
		
		/**
		 * * <b>Description:</b>
		 	* fill the square in the southwest direction regardless if the first position is left or down.
		 
		 * <b>pre:</b> the matrix square has already been inicializated.
		 * 
		 * @param m row of the first position.
		 * @param n column of the first position
		 * 
		 *  <b>post:</b> elements have been added to the matrix squared
		 */
		public void diagonalSo(int m, int n) {
			for(int i=2; i<=order*order; i++) {
				if(m== order-1 && n == 0 ) {
					
					if(firstPosition == DOWN) {
						m--;
						square[m][n] = i;
					}else {
						n++;
						square[m][n] = i;
					}
						
				}else if(m== order-1) {
				
					if(square[0][n-1] ==0) {
						m = 0;
						n--;
						square[m][n] = i;
					}		
				}else if(n == 0) {
					if(square[m+1][order-1] == 0) {
						m++;
						n=order-1;
						square[m][n] = i;
					}
				}else if(square[m+1][n-1]  == 0 && n!= 0) {
					m++; 
					n--;
					square[m][n] = i;
				}else {
					if(firstPosition == DOWN) {
						m--;
						square[m][n] = i;
					}else {
						n++;
						square[m][n] = i;
					}
					
				}
			}
			}
		
		
		/**
		 * * <b>Description:</b>
		 	* fill the square in the southeast direction regardless if the first position is rigth or down.
		 
		 * <b>pre:</b> the matrix square has already been inicializated.
		 * 
		 * @param m row of the first position.
		 * @param n column of the first position
		 * 
		 *  <b>post:</b> elements have been added to the matrix squared
		 */
		public void diagonalSe(int m, int n) {
				for(int i=2; i<=order*order; i++) {
				if(m== order-1 && n == order-1 ) {
					
					if(firstPosition == DOWN) {
						m--;
						square[m][n] = i;
					}else {
						n--;
						square[m][n] = i;
					}
						
				}else if(m== order-1) {
				
					if(square[0][n+1] ==0) {
						m = 0;
						n++;
						square[m][n] = i;
					}		
				}else if(n == order-1) {
					if(square[m+1][0] == 0) {
						m++;
						n=0;
						square[m][n] = i;
					}
				}else if(square[m+1][n+1]  == 0 && n!= order-1) {
					m++; 
					n++;
					square[m][n] = i;
				}else {
					if(firstPosition == DOWN) {
						m--;
						square[m][n] = i;
					}else {
						n--;
						square[m][n] = i;
					}
					
				}
			}
		}
			
		
		/**
		 * * <b>Description:</b>
		 	* fill the square according to the direction and first position chosen by the user
		 *  <b>post:</b> elements have been added to the matrix squared
		 */
		public void fillSquare(){
	
			int m = 0;
			int n =0;
			if(firstPosition == UP) {
				n = (order/2);
				square[m][n] = 1;
			}else if(firstPosition == DOWN) {
				m = order-1;
				n = (order / 2) ;
				square[m][n] = 1;
			}else if(firstPosition == LEFT) {
				m = (order / 2);
				n = 0;
				square[m][n] = 1;
			}else {
				
				m = (order / 2);
				n = order-1;
				square[m][n] = 1;
			}
			if(direction.equalsIgnoreCase(DIAGONAL_NE)) {
				diagonalNe(m,n);
			}else if(direction.equalsIgnoreCase(DIAGONAL_NO)) {
				diagonalNo(m,n);
			}else if(direction.equalsIgnoreCase(DIAGONAL_SO)) {
				diagonalSo(m,n);
			}else {
				diagonalSe(m,n);
			}
				
		
			
		}
		
		
		
		
}
