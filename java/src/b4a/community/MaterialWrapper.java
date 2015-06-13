package b4a.community;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;

@Version(0.05f)
@ShortName("Material")
@Author("B4A Community")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
//@Events(values={"onSigned(sign As Object)"})
//@DependsOn(values={"android-viewbadger"})
public class MaterialWrapper {
	private BA ba;
	private String eventName;

	/*
	 * Initialize the HTML-TextView 
	 */   	
	public void Initialize(BA ba, String EventName) {
		_initialize(ba, null, EventName);
	}
	
	@Hide
	public void _initialize(BA ba, Object activityClass, String EventName) {
		this.eventName = EventName.toLowerCase(BA.cul);
		this.ba = ba;
 	}
	
}
