package org.cap.theatermgt.entities;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Screen {
	
	@Id
	@GeneratedValue
	private int screenId;
	private int theaterId;
	private String screenName;
	@ElementCollection
	private List<Integer> showList;
	private int row;
	private int column;
	public int getScreenId() {
		return screenId;
	}
	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}
	public int getTheaterId() {
		return theaterId;
	}
	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + row;
		result = prime * result + screenId;
		result = prime * result + ((screenName == null) ? 0 : screenName.hashCode());
		result = prime * result + ((showList == null) ? 0 : showList.hashCode());
		result = prime * result + theaterId;
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
		Screen other = (Screen) obj;
		if (column != other.column)
			return false;
		if (row != other.row)
			return false;
		if (screenId != other.screenId)
			return false;
		if (screenName == null) {
			if (other.screenName != null)
				return false;
		} else if (!screenName.equals(other.screenName))
			return false;
		if (showList == null) {
			if (other.showList != null)
				return false;
		} else if (!showList.equals(other.showList))
			return false;
		if (theaterId != other.theaterId)
			return false;
		return true;
	}
	
}
