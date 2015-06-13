package b4a.community.donmanfred.drawables;


import com.rey.material.drawable.ArrowDrawable;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.Pixel;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.keywords.Common.DesignerCustomView;
import anywheresoftware.b4a.objects.LabelWrapper;
import anywheresoftware.b4a.objects.PanelWrapper;
import anywheresoftware.b4a.objects.ViewWrapper;

@ShortName("bcArrowDrawable")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
//@Events(values={
//		"onCheckedChanged(tag as Object, checked As boolean)"
//		"onhourchanged(oldValue As int, newValue As int)",
//		"onminutechanged(oldValue As int, newValue As int)"
//		})
//@DependsOn(values={"android-viewbadger"})
public class bcArrowDrawable {
	private BA ba;
	private String eventName;
	private ArrowDrawable ad; 

	
	/*
	 * Initialize the HTML-TextView 
	 */   	
	public void Initialize(final BA ba, String EventName) {
		this.eventName = EventName.toLowerCase(BA.cul);
		this.ba = ba;
		ad = new ArrowDrawable(0, 0, null, 0, null, false);
	}

	public void setColor(ColorStateList colorStateList){
		ad.setColor(colorStateList);
	}
	
	public void setMode(int mode, boolean animation){
		ad.setMode(mode, animation);
	}	
	
	public int getMode(){
		return ad.getMode();
	}

	public void start() {
		ad.start();
	}

	public void stop() {
		ad.stop();
	}

	public boolean isRunning() {
		return ad.isRunning();
	}
	public int getOpacity() {
		return ad.getOpacity();
	}
	public Drawable getCurrent() {
		return ad.getCurrent();
	}
	public Drawable mutate() {
		return ad.mutate();
	}


	
}
