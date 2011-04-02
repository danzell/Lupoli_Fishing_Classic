package com.midterm;

public class Fish implements Comparable<Fish>{
	
	private Float weight;
	private Float length;
	private Boolean life;
	
	
	public Fish(Float weight, Float length, Boolean life) {
		super();
		this.weight = weight;
		this.length = length;
		this.life = life;
	}
	
	/*
	 * getters 
	 */
	public Boolean getLife() {
		return life;
	}
	public Float getLength() {
		return length;
	}
	public Float getWeight() {
		return weight;
	}
	
	/*
	 * setters
	 */
	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public void setLength(Float length) {
		this.length = length;
	}
	
	public void setLife(Boolean life) {
		this.life = life;
	}

	@Override
	public String toString() {
		return "Fish [weight=" + weight + ", length=" + length + ", life="
				+ life + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((length == null) ? 0 : length.hashCode());
		result = prime * result + ((life == null) ? 0 : life.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fish other = (Fish) obj;
		if (length == null) {
			if (other.length != null)
				return false;
		} else if (!length.equals(other.length))
			return false;
		if (life == null) {
			if (other.life != null)
				return false;
		} else if (!life.equals(other.life))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}

	public int compareTo(Fish fish) {
		return weight.compareTo(fish.getWeight());
	}
	
	
	
	
	
}
