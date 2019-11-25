package myarray;

/**
 * MyArray
 */
public class MyArray {
	// private int length = 0; // Actual length in use
	private int[] array;

	public MyArray() {
		this(10);
	}

	MyArray(final int n) {
		if (n <= 0) {
			throw new NegativeArraySizeException("The length of array should greater than 0");
		}
		array = new int[n];
	}

	MyArray(final MyArray otherArray) {
		array = new int[otherArray.array.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = otherArray.array[i];
		}
	}

	MyArray(final int[] otherArray) {
		if (otherArray.length <= 0) {
			throw new NegativeArraySizeException("The length of the parameter array should greater than 0");
		}
		array = new int[otherArray.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = otherArray[i];
		}
	}

	public int[] GetArray() {
		var returnArray = new int[array.length];
		for (int i = 0; i < returnArray.length; i++) {
			returnArray[i] = array[i];
		}
		return returnArray;
	}

	public void RandomArray() {
		RandomArray(100);
	}

	public void RandomArray(final int max) {
		RandomArray(array.length, max);
	}

	public void RandomArray(final int n, final int max) {
		if (n <= 0) {
			throw new IllegalArgumentException("The length of the parameter array should greater than 0");
		}
		if (n != array.length)
			array = new int[n];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * (max + 1));
		}
	}

	public boolean CheckOrder() {
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1])
				return false;
		}
		return true;
	}

	public int Sum() {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum;
	}

	public boolean CheckKey(final int key) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == key)
				return true;
		}
		return false;
	}
}