package b4a.community.donmanfred.widget;

import com.rey.material.widget.FloatingActionButton;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
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

@ShortName("bcFloatingActionButton")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
@Events(values={
		"onclick(v As Object)"
//		"onhourchanged(oldValue As int, newValue As int)",
//		"onminutechanged(oldValue As int, newValue As int)"
		})
//@DependsOn(values={"android-viewbadger"})
public class bcFloatingActionButton extends ViewWrapper<FloatingActionButton>  implements DesignerCustomView {
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
		this.setObject(new FloatingActionButton(ba.context));
		this.getObject().setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (ba.subExists(eventName + "_onclick")) {
					//ba.Log("lib:Raising.. "+eventName + "_onclick()");								
					ba.raiseEvent(ba.context, eventName+"_onclick", (Object)v);
					//ba.raiseEventFromDifferentThread(ba.context, null, 0, eventName + "_onclick", true, new Object[] {mode});
				}else {
					BA.Log("lib: NOTFOUND '"+eventName + "_onclick");
				}
				
			}
			
		});
 	}

	@Override
	public Object getTag() {
		return this.getObject().getTag();
	}
	@Override
	public void setTag(Object tag) {
		this.getObject().setTag(tag);
	}

	public int getRadius() {
		return this.getObject().getRadius();
	}

	public void setRadius(int radius) {
		this.getObject().setRadius(radius);
	}
	
	public int getLineMorphingState() {
		return this.getObject().getLineMorphingState();
	}

	public void setLineMorphingState(int state, boolean animation) {
		this.getObject().setLineMorphingState(state, animation);
	}

	public int getBackgroundColor() {
		return this.getObject().getBackgroundColor();
	}

	public Drawable getIcon() {
		return this.getObject().getIcon();
	}

	public void setIcon(Drawable icon, boolean animation) {
		this.getObject().setIcon(icon, animation);
	}

	public void show(final BA ba, int x, int y, int gravity) {
		this.getObject().show(ba.activity, x, y, gravity);
	}

	public void dismiss() {
		this.getObject().dismiss();
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
