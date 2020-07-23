package modules.security;

import java.math.BigDecimal;

public class ScreenMaster {
	
	

	private String screenName;


	private String screenDesc;

	
	private String screenPath;

	private String parentModuleId;
	
	private String screenStatus;
	
	public ScreenMaster() {
		
	}

	public ScreenMaster(String screenName, String screenDesc, String screenPath, String parentModuleId,
			String screenStatus) {
		super();
		this.screenName = screenName;
		this.screenDesc = screenDesc;
		this.screenPath = screenPath;
		this.parentModuleId = parentModuleId;
		this.screenStatus = screenStatus;
	}

	@Override
	public String toString() {
		return "ScreenMaster [screenName=" + screenName + ", screenDesc=" + screenDesc + ", screenPath=" + screenPath
				+ ", parentModuleId=" + parentModuleId + ", screenStatus=" + screenStatus + "]";
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getScreenDesc() {
		return screenDesc;
	}

	public void setScreenDesc(String screenDesc) {
		this.screenDesc = screenDesc;
	}

	public String getScreenPath() {
		return screenPath;
	}

	public void setScreenPath(String screenPath) {
		this.screenPath = screenPath;
	}

	public String getParentModuleId() {
		return parentModuleId;
	}

	public void setParentModuleId(String parentModuleId) {
		this.parentModuleId = parentModuleId;
	}

	public String getScreenStatus() {
		return screenStatus;
	}

	public void setScreenStatus(String screenStatus) {
		this.screenStatus = screenStatus;
	}
	
	
	
}
