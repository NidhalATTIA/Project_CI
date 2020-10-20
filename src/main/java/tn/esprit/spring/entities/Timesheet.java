package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Entity
public class Timesheet implements Serializable{

	private static final long serialVersionUID = 3876346912862238239L;

	@EmbeddedId
	private TimesheetPK timesheetPK;
	
	
	private boolean isValide;
	

	public boolean isValide() {
		return isValide;
	}

	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}

	public TimesheetPK getTimesheetPK() {
		return timesheetPK;
	}

	public void setTimesheetPK(TimesheetPK timesheetPK) {
		this.timesheetPK = timesheetPK;
	}

	
	
}
