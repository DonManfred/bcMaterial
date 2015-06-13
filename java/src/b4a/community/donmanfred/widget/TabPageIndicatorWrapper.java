package b4a.community.donmanfred.widget;


import com.rey.material.widget.TabPageIndicator;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.objects.ViewWrapper;

//@ShortName("msTimePickerDialog")
//@ActivityObject
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
@Events(values={
		"onTimeChanged(oldHour As Int, oldMinute As Int, newHour As Int, newMinute As Int)"
		})
//@DependsOn(values={"android-viewbadger"})
public class TabPageIndicatorWrapper extends ViewWrapper<TabPageIndicator>{
	private BA ba;
	private String eventName;

	public void Initialize(final BA ba, String EventName) {
		_initialize(ba, null, EventName);
	}
	
	@Hide
	public void _initialize(final BA ba, Object activityClass, String EventName) {
		this.eventName = EventName.toLowerCase(BA.cul);
		this.ba = ba;
		this.setObject(new TabPageIndicator(ba.context));
		

//		this.getObject().onTimeChangedListener(new OnTimeChangedListener(){
//
//			@Override
//			public void onTimeChanged(int oldHour, int oldMinute, int newHour,	int newMinute) {
//				// TODO Auto-generated method stub
//			if (ba.subExists(eventName + "_ontimechanged")) {
//				ba.Log("lib:Raising.. "+eventName + "_ontimechanged()");								
//				ba.raiseEvent(ba.context, eventName+"_ontimechanged", oldHour, oldMinute, newHour, newMinute);
//				//ba.raiseEventFromDifferentThread(ba.context, null, 0, eventName + "_ontimechanged", true, new Object[] {mode});
//			}else {
//				BA.Log("lib: NOTFOUND '"+eventName + "_ontimechanged");
//			}
//				
//			}
//			
//		});

  }

	
	

	
	
}
