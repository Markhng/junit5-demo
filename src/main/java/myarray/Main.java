package myarray;

/**
 * Main
 */
import java.util.Arrays;

class Main {
	public static void main(String[] args) {
		var a = new MyArray();
		int n = 10, max = 100;
		System.out.println("n: " + n + ", max: " + max);
		a.RandomArray(n, max);
		System.out.println("Array: " + Arrays.toString(a.GetArray()));
		System.out.println("Sum: " + a.Sum());
		var key = a.GetArray()[2];
		System.out.println("key: " + key + ", `CheckKey` return: " + a.CheckKey(key));
		key = -1;
		System.out.println("key: " + key + ", `CheckKey` return: " + a.CheckKey(key));
	}
}