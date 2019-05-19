package TestData;

import java.util.Date;

public class ParkingTestData {

	private String lotDropData;
	private String entryTimeData;	
	private String entryDateData;
	private String leaveTimeData;
	private String leaveDateData;
	private String costText;
	private String daysText;


	public ParkingTestData(String lotDropData, String entryTimeData,
							String entryDateData, String leaveTimeData, 
							String leaveDateData, String costText, String daysText )
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

	public String getEntryDateData() {
		return entryDateData;
	}

	public String getLeaveTimeData() {
		return leaveTimeData;
	}
	
	public String getLeaveDateData() {
		return leaveDateData;
	}
	
	public String getCostText() {
		return costText;
	}

	public String getDaysText() {
		return daysText;
	}

}