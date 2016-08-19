package uq.deco2800.ducktales.util;

/**
 * 2D array implementation.
 * 
 * @author Anonymousthing
 *
 * @param <T>
 */
public class Array2D<T> {
	private int width;
	private int height;

	private Object[] arr;

	public Array2D(int width, int height) {
		this.width = width;
		this.height = height;
		arr = new Object[width * height];
	}

	@SuppressWarnings("unchecked")
	public T get(int x, int y) {
		if (x >= width || y >= height || x < 0 || y < 0) {
			throw new IndexOutOfBoundsException();
		}
		// This cast will always be safe as set() only takes values of type T
		return (T) arr[y * width + x];
	}

	public void set(int x, int y, T val) {
		if (x >= width || y >= height || x < 0 || y < 0) {
			throw new IndexOutOfBoundsException();
		}
		arr[y * width + x] = val;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
