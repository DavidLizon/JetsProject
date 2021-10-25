package com.skilldistillery.jets.entities;

import java.util.Objects;

public class JetImpl extends Jet	{

	public JetImpl(String type, String model, int speed, int range, long price) {
		super(type, model, speed, range, price);
	}

	Jet newPlane;

	public Jet getNewPlane() {
		return newPlane;
	}

	public void setNewPlane(Jet newPlane) {
		this.newPlane = newPlane;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(newPlane);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		JetImpl other = (JetImpl) obj;
		return Objects.equals(newPlane, other.newPlane);
	}

}
