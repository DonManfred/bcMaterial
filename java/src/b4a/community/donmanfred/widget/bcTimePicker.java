package b4a.community.donmanfred.widget;

import com.rey.material.widget.TimePicker;
import com.rey.material.widget.TimePicker.OnTimeChangedListener;

import android.graphics.Typeface;
import android.view.ViewGroup;
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

@ShortName("bcTimePicker")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
@Events(values={
		"onmodechanged(mode As Int)",
		"onhourchanged(oldValue As int, newValue As int)",
		"onminutechanged(oldValue As int, newValue As int)"
		})
//@DependsOn(values={"android-viewbadger"})
public class bcTimePicker extends ViewWrapper<TimePicker>  implements DesignerCustomView {
	private BA ba;
	private String eventName;
	 

	
	/*
	 * Initialize the HTML-TextView 
	 */   	
	@Override
	public void Initialize(final BA ba, String EventName) {
		_initialize(ba, null, EventName);
	}
	
	@Override
	@Hide
	public void _initialize(final BA ba, Object activityClass, String EventName) {
		this.eventName = EventName.toLowerCase(BA.cul);
		this.ba = ba;
		this.setObject(new TimePicker(ba.context));
		this.getObject().setOnTimeChangedListener(new OnTimeChangedListener(){

			@Override
			public void onModeChanged(int mode) {
				// TODO Auto-generated method stub
  			if (ba.subExists(eventName + "_onmodechanged")) {
  				//ba.Log("lib:Raising.. "+eventName + "_onmodechanged()");								
  				ba.raiseEvent(ba.context, eventName+"_onmodechanged", mode);
  				//ba.raiseEventFromDifferentThread(ba.context, null, 0, eventName + "_onmodechanged", true, new Object[] {mode});
  			}else {
  				//BA.Log("lib: NOTFOUND '"+eventName + "_onmodechanged");
  			}

			}

			@Override
			public void onHourChanged(int oldValue, int newValue) {
				// TODO Auto-generated method stub
  			if (ba.subExists(eventName + "_onhourchanged")) {
  				//ba.Log("lib:Raising.. "+eventName + "_onhourchanged()");								
  				ba.raiseEvent(ba.context, eventName+"_onhourchanged", oldValue, newValue);
  				//ba.raiseEventFromDifferentThread(ba.context, null, 0, eventName + "_onmodechanged", true, new Object[] {mode});
  			}else {
  				//BA.Log("lib: NOTFOUND '"+eventName + "_onhourchanged");
  			}
				
			}

			@Override
			public void onMinuteChanged(int oldValue, int newValue) {
				// TODO Auto-generated method stub
  			if (ba.subExists(eventName + "_onminutechanged")) {
  				//ba.Log("lib:Raising.. "+eventName + "_onminutechanged()");								
  				ba.raiseEvent(ba.context, eventName+"_onminutechanged", oldValue, newValue);
  				//ba.raiseEventFromDifferentThread(ba.context, null, 0, eventName + "_onmodechanged", true, new Object[] {mode});
  			}else {
  				//BA.Log("lib: NOTFOUND '"+eventName + "_onminutechanged");
  			}
				
			}
			
		});
 	}

	public int getBackgroundColor() {
		return this.getObject().getBackgroundColor();
	}
	public void setBackgroundColor(int backgroundColor) {
		this.getObject().setBackgroundColor(backgroundColor);
	}

	public Typeface getTf() {
		return this.getObject().getTf();
	}

	public void setTf(Typeface tf) {
		this.getObject().setTf(tf);
	}

	public int getSelectionColor() {
		return this.getObject().getSelectionColor();
	}
	public void setSelectionColor(int selectionColor) {
		this.getObject().setSelectionColor(selectionColor);
	}

	public int getSelectionRadius() {
		return this.getObject().getSelectionRadius();
	}

	public void setSelectionRadius(int selectionRadius) {
		this.getObject().setSelectionRadius(selectionRadius);
	}
	
	public Typeface getTypeface() {
		return this.getObject().getTypeface();
	}

	public int getTickSize() {
		return this.getObject().getTickSize();
	}

	public void setTickSize(int tickSize) {
		this.getObject().setTickSize(tickSize);
	}

	public int getTextSize() {
		return this.getObject().getTextSize();
	}
	public void setTextSize(int textSize) {
		this.getObject().setTextSize(textSize);
	}

	public int getTextColor() {
		return this.getObject().getTextColor();
	}
	public void setTextColor(int textColor) {
		this.getObject().setTextColor(textColor);
	}

	public int getTextHighlightColor() {
		return this.getObject().getTextHighlightColor();
	}
	public void setTextHighlightColor(int textHighlightColor) {
		this.getObject().setTextHighlightColor(textHighlightColor);
	}

	public int getAnimDuration() {
		return this.getObject().getAnimDuration();
	}

	public int getMode() {
		return this.getObject().getMode();
	}

	public int getHour() {
		return this.getObject().getHour();
	}

	public int getMinute() {
		return this.getObject().getMinute();
	}

	public boolean isTwentyFour() {
		return this.getObject().is24Hour();
	}

	public void setTwentyFourHour(boolean b) {
		this.getObject().set24Hour(b);
	}

	public int getTickColor() {
		return this.getObject().getTickColor();
	}

	public void setTickColor(int tickColor) {
		this.getObject().setTickColor(tickColor);
	}

	public void setMode(int mode, boolean animation) {
		this.getObject().setMode(mode, animation);
	}

	public void setHour(int hour) {
		this.getObject().setHour(hour);
	}

	public void setMinute(int minute) {
		this.getObject().setMinute(minute);
	}
	
	
	//programmatically add view
	public void AddToParent(ViewGroup Parent, @Pixel int left, @Pixel int top, @Pixel int width, @Pixel int height) {
		//AttributeSet attrs;		
		//XmlPullParser parser = Resources.getXml(myResouce);
		//AttributeSet myAttributes = Xml.asAttributeSet(parser);
		//AttributeSet myAttributes = null;
		//anywheresoftware.b4a.		 
		//mSignaturePad = new SignaturePad(ba.context, myAttributes);
		Parent.addView(this.getObject(), new BALayout.LayoutParams(left, top, width, height));
	}
	
	//this method cannot be hidden.
	@Override
	public void DesignerCreateView(PanelWrapper base, LabelWrapper lw, anywheresoftware.b4a.objects.collections.Map props) {
		ViewGroup vg = (ViewGroup) base.getObject().getParent();
		AddToParent(vg, base.getLeft(), base.getTop(), base.getWidth(), base.getHeight());
		base.RemoveView();
		//set text properties
	}

	@Override
	public void setLeft(int left)	{
		BALayout.LayoutParams lp = (BALayout.LayoutParams)this.getObject().getLayoutParams();
		lp.left = left;
		this.getObject().getParent().requestLayout();
	}
	@Override
	public int getLeft()	{
		BALayout.LayoutParams lp = (BALayout.LayoutParams)this.getObject().getLayoutParams();
		return lp.left;
	}
	@Override
	public void setTop(int top)	{
		BALayout.LayoutParams lp = (BALayout.LayoutParams)this.getObject().getLayoutParams();
		lp.top = top;
		this.getObject().getParent().requestLayout();
	}
	@Override
	public int getTop()	{
		BALayout.LayoutParams lp = (BALayout.LayoutParams)this.getObject().getLayoutParams();
		return lp.top;
	}
	
	
}
