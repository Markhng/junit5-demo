package mysolid;

/**
 * Cylinder
 */
public class Cylinder implements Attributes {
	private final double radius;
	private final double height;

	public Cylinder(Cylinder otherCylinder) {
		this.radius = otherCylinder.radius;
		this.height = otherCylinder.height;
	}

	public Cylinder(double radius, double height) {
		if (radius <= 0) {
			throw new IllegalArgumentException("Radius should greater than 0");
		}
		if (height <= 0) {
			throw new IllegalArgumentException("Height should greater than 0");
		}
		this.radius = radius;
		this.height = height;
	}

	@Override
	public double area() {
		return radius * radius * Math.PI;
	}

	@Override
	public double volume() {
		return area() * height;
	}

	public double getRadius() {
		return radius;
	}

	public double getHeight() {
		return height;
	}
}