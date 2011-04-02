package com.midterm;

import java.util.ArrayList;

public class FishingTeam implements Comparable<FishingTeam>{
	private String name;
	private ArrayList<Fish> fishList = null;
	
	public FishingTeam(){
		super();
	}
	public FishingTeam(String name) {
		super();
		this.name = name;
	}

/*
 * getters
 */
	public String getName() {
		return name;
	}
	public ArrayList<Fish> getFishList() {
		return fishList;
	}

/*
 * setters
 */
	public void setName(String name) {
		this.name = name;
	} 
	public void setFishList(ArrayList<Fish> fishList) {
		this.fishList = fishList;
	}

	@Override
	public String toString() {
		return "FishingTeam [name=" + name + ", fishList=" + fishList + "]";
	}
	public int compareTo(FishingTeam fishingTeam){
		return name.compareTo(fishingTeam.getName());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FishingTeam other = (FishingTeam) obj;
		if (fishList == null) {
			if (other.fishList != null)
				return false;
		} else if (!fishList.equals(other.fishList))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	

}
