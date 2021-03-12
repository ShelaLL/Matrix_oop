package matrix_oop;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Each instance of this class represents a matrix (from algebra).
 * 
 * @invar | 1 <= getNbRows()
 * @invar | getElementsRowMajor() != null
 * @invar | getElementsRowMajor().length == getNbRows() * getNbColumns()
 * @invar | 1 <= getNbColumns()
 */
public class Matrix {

	/**
	 * @basic
	 */
	public int getNbRows() {throw new RuntimeException("Not yet implemented");}

	/**
	 * @basic
	 * @creates | result
	 * Since this inspector returns a mutable object, we should specify whether it is an existing object or a new one
	 * In this case, we create a new one, so we used the create clause.
	 * Creates clause tells the client whether this object he will return that he will have complete control over
	 * Guarantee to the client that this obejct will not be changed by class Matrix after at the end of this method calls
	 */
	public double[] getElementsRowMajor() {throw new RuntimeException("Not yet implemented");}

	/**
	 * @post | result == getElementsRowMajor().length / getNbRows()
	 *  In any case we should not mention fields in a post condition or a public method???
	 */
	public int getNbColumns() {throw new RuntimeException("Not yet implemented");}

	/**
	 * @post | result != null
	 * @post | result.length == getNbRows()
	 * @post | Arrays.stream(result).allMatch(row -> row != null && row.length == getNbColumns())
	 * Its elements should also not be null
	 * @post | IntStream.range(0, getNbRows()).allMatch(rowIndex -> 
	 * 		 | 		IntStream.range(0, getNbColumns()).allMatch(columnIndex ->
	 * 		 | 		   result[rowIndex][columnIndex] == getElementsRowMajor()[rowIndex * getNbColumns() + columnIndex]))
	 *       
	 * @creates | result, ...result
	 * same thing holds for the result of the getElementsRowArrays() method and also the elements of the resulting array are all new array objects
	 */
	public double[][] getElementsRowArrays() {throw new RuntimeException("Not yet implemented");}
	
	
	public Matrix(int nbRows, int nbColumns, double[] elementsRowMajor) {throw new RuntimeException("Not yet implemented");}
}

