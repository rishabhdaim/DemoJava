package demo.java8.javageeks.dp.builder;

public class Cake {

	private final double sugar; // cup
	private final double butter; // cup
	private final int eggs;
	private final int vanila; // spoon
	private final double flour; // cup
	private final double bakingpowder; // spoon
	private final double milk; // cup
	private final int cherry;

	public static class Builder {
		private double sugar; // cup
		private double butter; // cup
		private int eggs;
		private int vanila; // spoon
		private double flour; // cup
		private double bakingpowder; // spoon
		private double milk; // cup
		private int cherry;

		// builder methods for setting property
		public Builder sugar(double cup) {
			this.sugar = cup;
			return this;
		}

		public Builder butter(double cup) {
			this.butter = cup;
			return this;
		}

		public Builder eggs(int number) {
			this.eggs = number;
			return this;
		}

		public Builder vanila(int spoon) {
			this.vanila = spoon;
			return this;
		}

		public Builder flour(double cup) {
			this.flour = cup;
			return this;
		}

		public Builder bakingpowder(double spoon) {
			this.sugar = spoon;
			return this;
		}

		public Builder milk(double cup) {
			this.milk = cup;
			return this;
		}

		public Builder cherry(int number) {
			this.cherry = number;
			return this;
		}

		// return fully build object
		/**
		 * @return
		 */
		public Cake build() {
			return new Cake(this);
		}

	}

	// private constructor to enforce object creation through builder
	/**
	 * @param builder
	 */
	private Cake(Builder builder) {
		this.sugar = builder.sugar;
		this.butter = builder.butter;
		this.eggs = builder.eggs;
		this.vanila = builder.vanila;
		this.flour = builder.flour;
		this.bakingpowder = builder.bakingpowder;
		this.milk = builder.milk;
		this.cherry = builder.cherry;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cake [sugar=" + sugar + ", butter=" + butter + ", eggs=" + eggs
				+ ", vanila=" + vanila + ", flour=" + flour + ", bakingpowder="
				+ bakingpowder + ", milk=" + milk + ", cherry=" + cherry + "]";
	}
}