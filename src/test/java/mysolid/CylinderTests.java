package mysolid;

/**
 * CylinderTests
 */
import static org.junit.jupiter.api.Assertions.*;
// import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

// import myarray.MyArray;

public class CylinderTests {
	static final int SIG_DIGIT = 8; // Significant digits to compare two doubles

	@Test
	void testCylinder() {
		Cylinder a;
		a = new Cylinder(10, 20);
		new Cylinder(a);
		assertThrows(IllegalArgumentException.class, () -> {
			new Cylinder(-10, 10);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Cylinder(10, -10);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Cylinder(0, Double.NaN);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Cylinder(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
		});
	}

	@ParameterizedTest
	@CsvSource({ "1., 1.", "2., 3.", "1.5, 2.6" })
	void paraTestGetRadius(double radius, double height) {
		assertEquals(radius, (new Cylinder(radius, height)).getRadius());
	}

	@ParameterizedTest
	@CsvSource({ "1., 1.", "2., 3.", "1.5, 2.6" })
	void paraTestGetHeight(double radius, double height) {
		assertEquals(height, (new Cylinder(radius, height)).getHeight());
	}

	@ParameterizedTest
	@CsvSource({ "1., 1., 3.141592654", "2., 3., 37.69911184", "1.5, 2.6, 18.37831702" })
	void paraTestVolume(double radius, double height, double expected) {
		assertTrue(compareSignificantDigits((new Cylinder(radius, height)).volume(), expected));
	}

	@ParameterizedTest
	@CsvSource({ "1., 1., 3.141592654", "2., 3., 12.56637061", "1.5, 2.6, 7.068583471" })
	void testArea(double radius, double height, double expected) {
		System.out.println((new Cylinder(radius, height)).volume());
		assertTrue(compareSignificantDigits((new Cylinder(radius, height)).area(), expected));
	}

	@ParameterizedTest
	@CsvSource({ "1.002, 1.003, 3, true", "1.002, 1.003, 4, false", "123.45, 123.46, 4, true",
			"123.45, 123.46, 5, false", "123.45, 124.45, 2, true", "123.45, 124.45, 3, false", "0., -0., 8, true" })
	void paraTestCompareSignificantDigits(double value1, double value2, int digit, boolean expected) {
		assertEquals(expected, compareSignificantDigits(value1, value2, digit));
	}

	@Test
	void testCompareSignificantDigits() {
		assertTrue(compareSignificantDigits(0. / 0., -0. / 0.));
		assertTrue(compareSignificantDigits(1. + 1. / 0., 1. / 0.));
		assertFalse(compareSignificantDigits(1. / 0., -1. / 0.));
	}

	// private static String significantDigits(final double value, final int digit)
	// {
	// if (Math.abs(value) < Double.MIN_NORMAL)
	// return String.format("%." + digit + "f", 0.D);
	// var offset = (short) Math.floor(Math.log10(Math.abs(value))); // use short to
	// handle with Infinity
	// var b = String.valueOf(Math.round(value / Math.pow(10, digit - offset)))
	// + String.format("%0" + (digit - offset) + "d", 0);
	// var a = String.valueOf(Math.round(value / Math.pow(10, offset - digit)));
	// System.out.println(a);
	// // if (digit > offset)
	// // return String.valueOf(Math.round(value / Math.pow(10, digit - offset)))
	// // + String.format("%0" + (digit - offset) + "d", 0);
	// return String.format("%." + (digit - offset - 1) + "f", value);

	// }

	private static String significantDigits(final double value, final int digit) {
		if (Math.abs(value) < Double.MIN_NORMAL)
			return String.format("%." + (digit - 1) + "e", 0.D);
		return String.format("%." + (digit - 1) + "e", value);
	}

	private static boolean compareSignificantDigits(final double value1, final double value2, final int digit) {
		return (significantDigits(value1, digit).equals(significantDigits(value2, digit)));
	}

	private static boolean compareSignificantDigits(final double value1, final double value2) {
		return compareSignificantDigits(value1, value2, SIG_DIGIT);
	}
}