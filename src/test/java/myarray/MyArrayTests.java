/**
 * MyArrayTests
 */
package myarray;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.Arrays;
// import java.util.List;

// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

class MyArrayTests {
	@Test
	// @DisplayName("testMyArray")
	void testMyArray() {
		MyArray a;
		a = new MyArray();
		a = new MyArray(10);
		int[] arr = { 1, 2, 3 };
		a = new MyArray(arr);
		assertArrayEquals(arr, a.GetArray());
		a = new MyArray(a);
		assertArrayEquals(arr, a.GetArray());
	}

	@Test
	void testGetArray() {
		int[] arr = {1, 2, 3};
		var a = new MyArray(arr);
		assertArrayEquals(arr, a.GetArray());
		assertArrayEquals(arr, (new MyArray(a)).GetArray());
	}

	@ParameterizedTest(name = "CheckOrderArray: {index} ==> input={0}, result={1}")
	@MethodSource // ("paraTestCheckOrder")
	void paraTestCheckOrder(int[] array, boolean expected) {
		assertEquals(expected, (new MyArray(array)).CheckOrder());
	}

	static Collection<Object[]> paraTestCheckOrder() {	// List is OK
		return Arrays.asList(new Object[][] {
			{ new int[] { 1, 2, 3, 4 }, true },
			{ new int[] { 2, -5, 1 }, false },
			{ new int[] { 0, -0 }, true },
			{ new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE }, true }
		});
	}


	@ParameterizedTest(name = "Sum: {index} ==> array={0}, result={1}")
	@MethodSource // ("testCheckOrder")
	void testSum(int[] array, int expected) {
		assertEquals(expected, (new MyArray(array)).Sum());
	}

	static Collection<Object[]> testSum() {
		return Arrays.asList(new Object[][] {
			{ new int[] { 1, 2, 3, 4 }, 10 },
			{ new int[] { 10, 9, 0 }, 19 },
			{ new int[] { 0 }, 0 },
		});
	}

	@ParameterizedTest(name = "CheckKey: {index} ==> array={0}, result={1}")
	@MethodSource // ("paraTestCheckOrder")
	void paraTestCheckKey(int[] array, int key, boolean expected) {
		assertEquals(expected, (new MyArray(array)).CheckKey(key));
	}

	static Collection<Object[]> paraTestCheckKey() {
		return Arrays.asList(new Object[][] {
			{ new int[] { 2, 2, 2, 2 }, 2, true },
			{ new int[] { 2, 2, 2, 2 }, 0, false },
			{ new int[] { 1, 2, 2 }, 2, true },
			{ new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE }, Integer.MIN_VALUE, true },
		});
	}

	// import static org.junit.jupiter.params.provider.Arguments.arguments;
	// import java.util.stream.*;
	// private static Stream<Arguments> testCheckOrder() {
	// 	return Stream.of(
	// 		arguments(new int[] { 1, 2, 3 }, true),
	// 		arguments(new int[] { 3, 2, 1 }, false),
	// 		arguments(new int[] { 3, 2, 1 }, false),
	// 		arguments(new int[] { 0, -0, 0 }, true),
	// 		arguments(new int[] { Integer.MIN_VALUE, -0, Integer.MAX_VALUE }, true)
	// 		);
	// }
}
