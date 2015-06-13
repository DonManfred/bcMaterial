package b4a.community.donmanfred.widget;


import com.rey.material.widget.SnackBar;
import com.rey.material.widget.SnackBar.OnActionClickListener;

import android.view.ViewGroup;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.Pixel;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.keywords.Common.DesignerCustomView;
import anywheresoftware.b4a.objects.LabelWrapper;
import anywheresoftware.b4a.objects.PanelWrapper;
import anywheresoftware.b4a.objects.ViewWrapper;

@ShortName("bcSnackBar")
@ActivityObject
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
//@Events(values={
//		"ondatechanged(oldDay As Int, oldMonth As Int, oldYear As Int, newDay As Int, newMonth As Int, newYear As Int)"
//		})
//@DependsOn(values={"android-viewbadger"})
public class bcSnackBar extends ViewWrapper<SnackBar>  implements DesignerCustomView {
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
		this.setObject(new SnackBar(ba.context));
		
		this.getObject().actionClickListener(new OnActionClickListener(){

			@Override
			public void onActionClick(SnackBar sb, int actionId) {
				// TODO Auto-generated method stub
				if (ba.subExists(eventName + "_onactionclick")) {
					BA.Log("lib:Raising.. "+eventName + "_onactionclick()");								
					ba.raiseEvent(ba.context, eventName+"_onactionclick", sb, actionId);
					//ba.raiseEventFromDifferentThread(ba.context, null, 0, eventName + "_onmodechanged", true, new Object[] {mode});
				}else {
					BA.Log("lib: NOTFOUND '"+eventName + "_onmodechanged");
				}
			}
		
		});

		//		this.getObject().setOnDateChangedListener(new OnDateChangedListener(){
//
//			@Override
//			public void onDateChanged(int oldDay, int oldMonth, int oldYear, int newDay, int newMonth, int newYear) {
//				// TODO Auto-generated method stub
//				if (ba.subExists(eventName + "_ondatechanged")) {
//					ba.Log("lib:Raising.. "+eventName + "_ondatechanged()");								
//					ba.raiseEvent(ba.context, eventName+"_ondatechanged", oldDay, oldMonth, oldYear, newDay, newMonth, newYear);
//					//ba.raiseEventFromDifferentThread(ba.context, null, 0, eventName + "_onmodechanged", true, new Object[] {mode});
//				}else {
//					BA.Log("lib: NOTFOUND '"+eventName + "_onmodechanged");
//				}
//				
//			}
//			
//		});
 	}

	public SnackBar Text(CharSequence text) {
		return this.getObject().text(text);
	}
	public SnackBar TextSize(int size) {
		return this.getObject().textSize(size);
	}
	
	public SnackBar TextColor(int color) {
		return this.getObject().textColor(color);
	}

	public SnackBar actionText(CharSequence text) {
		return this.getObject().actionText(text);
	}

	public SnackBar actionTextColor(int color) {
		return this.getObject().actionTextColor(color);
	}
	
	public SnackBar setactionTextSize(int size) {
		return this.getObject().actionTextSize(size);
	}
	
	public SnackBar duration(int duration) {
		this.getObject().duration(duration);
		return this.getObject();
	}
	public SnackBar singleLine(boolean b){
		this.getObject().singleLine(b);
		return this.getObject();
	}
	
	public void show() {
		this.getObject().show(ba.activity);
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
