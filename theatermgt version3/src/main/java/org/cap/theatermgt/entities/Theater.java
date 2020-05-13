package org.cap.theatermgt.entities;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.*;

@Entity
@Table(name = "theaters")
public class Theater {

	@Id
	@GeneratedValue
	private Integer theaterId;
	private String theaterName;
	private String theaterCity;
	@ElementCollection
	private List<Integer> movieList;
	@OneToMany
	private List<Screen> screenList;
	private String managerName;
	private	String managerContact;
	

	public Integer getTheaterId() {
		return theaterId;
	}
	public void setTheaterId(Integer theaterId) {
		this.theaterId = theaterId;
	}
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	public String getTheaterCity() {
		return theaterCity;
	}
	public void setTheaterCity(String theaterCity) {
		this.theaterCity = theaterCity;
	}
	
	public List<Screen> getScreenList() {
		return screenList;
	}
	public void setScreenList(List<Screen> screenList) {
		this.screenList = screenList;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerContact() {
		return managerContact;
	}
	public void setManagerContact(String managerContact) {
		this.managerContact = managerContact;
	}
	public List<Integer> getMovieList() {
		return movieList;
	}
	public void setMovieList(List<Integer> movieList) {
		this.movieList = movieList;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((managerContact == null) ? 0 : managerContact.hashCode());
		result = prime * result + ((managerName == null) ? 0 : managerName.hashCode());
		result = prime * result + ((movieList == null) ? 0 : movieList.hashCode());
		result = prime * result + ((screenList == null) ? 0 : screenList.hashCode());
		result = prime * result + ((theaterCity == null) ? 0 : theaterCity.hashCode());
		result = prime * result + ((theaterId == null) ? 0 : theaterId.hashCode());
		result = prime * result + ((theaterName == null) ? 0 : theaterName.hashCode());
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
		Theater other = (Theater) obj;
		if (managerContact == null) {
			if (other.managerContact != null)
				return false;
		} else if (!managerContact.equals(other.managerContact))
			return false;
		if (managerName == null) {
			if (other.managerName != null)
				return false;
		} else if (!managerName.equals(other.managerName))
			return false;
		if (movieList == null) {
			if (other.movieList != null)
				return false;
		} else if (!movieList.equals(other.movieList))
			return false;
		if (screenList == null) {
			if (other.screenList != null)
				return false;
		} else if (!screenList.equals(other.screenList))
			return false;
		if (theaterCity == null) {
			if (other.theaterCity != null)
				return false;
		} else if (!theaterCity.equals(other.theaterCity))
			return false;
		if (theaterId == null) {
			if (other.theaterId != null)
				return false;
		} else if (!theaterId.equals(other.theaterId))
			return false;
		if (theaterName == null) {
			if (other.theaterName != null)
				return false;
		} else if (!theaterName.equals(other.theaterName))
			return false;
		return true;
	}

	
}
