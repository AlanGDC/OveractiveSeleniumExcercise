package TestData;

import java.util.Date;

public class ParkingTestData {

	private String lotDropData;
	private String entryTimeData;	
	private Date   entryDateData;
	private String leaveTimeData;
	private Date   leaveDateData;
	private String costText;
	private String daysText;


	public ParkingTestData(String lotDropData, String entryTimeData,
						Date entryDateData, String leaveTimeData, 
						Date leaveDateData, String costText, String daysText )
    {
	   
		this.lotDropData 	= lotDropData;
	    this.entryTimeData 	= entryTimeData;	
	    this.entryDateData 	= entryDateData;
	    this.leaveTimeData 	= leaveTimeData;
	    this.leaveDateData 	= leaveDateData;
	    this.costText		= costText;
	    this.daysText		= daysText;
    }

	public String getLotDropData() {
		return lotDropData;
	}

	public String getEntryTimeData() {
		return entryTimeData;
	}

	public Date getEntryDateData() {
		return entryDateData;
	}

	public String getLeaveTimeData() {
		return leaveTimeData;
	}
	
	public Date getLeaveDateData() {
		return leaveDateData;
	}
	
	public String getCostText() {
		return costText;
	}

	public String getDaysText() {
		return daysText;
	}

}