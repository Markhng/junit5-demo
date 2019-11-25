package mysolid;

/**
 * Main
 */
public class Main {
	public static void main(String[] args) {
		var a = new Cylinder(10, 20);
		System.out.println("Cylinder radius: " + a.getRadius() + ", height: " + a.getHeight());
		System.out.printf("Area: %.2f%n", a.area());
		System.out.printf("Volume: %.2f%n", a.volume());
	}
}