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
	 * @invar | 1 <= nbRows
	 * @invar | elements != null
	 * @invar | elements.length % nbRows == 0
	 */
	private int nbRows;
	/**
	 * @representationObject
	 */
	private double[] elements;

	/**
	 * @basic
	 */
	
	
	public int getNbRows() {
		return nbRows;
	}

	/**
	 * @inspects | this
	 * @basic
	 * @creates | result
	 */
	public double[] getElementsRowMajor() {
		double[] result = new double[elements.length];
		for (int rowIndex = 0; rowIndex < nbRows; rowIndex++)
			for (int columnIndex = 0; columnIndex < elements.length / nbRows; columnIndex++)
				result[rowIndex * elements.length / nbRows + columnIndex] = elements[columnIndex * nbRows + rowIndex];
		return result;
	}

	/**
	 * @post | result == getElementsRowMajor().length / getNbRows()
	 */
	public int getNbColumns() {
		return elements.length / nbRows;
	}

	/**
	 * @post | result != null
	 * @post | result.length == getNbRows()
	 * @post | Arrays.stream(result).allMatch(row -> row != null && row.length == getNbColumns())
	 * @post | IntStream.range(0, getNbRows()).allMatch(rowIndex -> 
	 * 		 | 		IntStream.range(0, getNbColumns()).allMatch(columnIndex ->
	 * 		 | 		   result[rowIndex][columnIndex] == getElementsRowMajor()[rowIndex * getNbColumns() + columnIndex]))
	 *       
	 * @creates | result, ...result
	 */
	public double[][] getElementsRowArrays() {
		int nbColumns = getNbColumns();
		double[][] rows = new double[nbRows][];
		for(int rowIndex = 0; rowIndex < nbRows; rowIndex++) {
			rows[rowIndex] = new double[nbColumns];
			for(int columnIndex = 0; columnIndex < nbColumns; columnIndex++) {
				rows[rowIndex][columnIndex] = elements[columnIndex * nbRows + rowIndex]; 
			}
		}
		return rows;
	}


	public Matrix(int nbRows, int nbColumns, double[] elementsRowMajor) {
		if(nbRows < 1)
			throw new IllegalArgumentException("`nbRows` is less than 1");
		if(nbColumns < 1)
			throw new IllegalArgumentException("`nbColumns` is less than 1");
		if(elementsRowMajor == null)
			throw new IllegalArgumentException("`elementsRowajor` is null");
		if(elementsRowMajor.length != nbRows * nbColumns)
			throw new IllegalArgumentException("length of `elementsRowMajor` is worng");

		this.nbRows = nbRows;
		this.elements = new double[nbRows * nbColumns];

		for(int rowIndex = 0; rowIndex < nbRows; rowIndex++) {
			for(int columnIndex = 0; columnIndex < nbColumns; columnIndex++) 
				elements[columnIndex * nbRows + rowIndex] = elementsRowMajor[rowIndex * nbColumns + columnIndex];
		}
		
	}
}



