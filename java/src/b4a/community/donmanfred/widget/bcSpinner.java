package b4a.community.donmanfred.widget;



import com.rey.material.widget.Spinner;
import com.rey.material.widget.Spinner.OnItemClickListener;
import com.rey.material.widget.Spinner.OnItemSelectedListener;

import android.graphics.drawable.Drawable;
import android.view.View;
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

@ShortName("bcSpinner")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
@Events(values={
		"ondatechanged(oldDay As Int, oldMonth As Int, oldYear As Int, newDay As Int, newMonth As Int, newYear As Int)"
})
//@DependsOn(values={"android-viewbadger"})
@Hide
public class bcSpinner extends ViewWrapper<Spinner>  implements DesignerCustomView {
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
		this.setObject(new Spinner(ba.context));
		this.getObject().setOnItemClickListener(new OnItemClickListener(){

			@Override
			public boolean onItemClick(Spinner parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				return false;
			}
			
		});
		
		this.getObject().setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(Spinner parent, View view, int position,	long id) {
				// TODO Auto-generated method stub
			}
			
		});
		//if (ba.subExists(eventName + "_ondatechanged")) {
		//	//ba.Log("lib:Raising.. "+eventName + "_ondatechanged()");								
		//	ba.raiseEvent(ba.context, eventName+"_ondatechanged", oldDay, oldMonth, oldYear, newDay, newMonth, newYear);
		//}else {
		//	//BA.Log("lib: NOTFOUND '"+eventName + "_ondatechanged");
		//}

 	}

	
	public View getSelectedView() {
		return this.getObject().getSelectedView();
	}

	public void setSelection(int position) {
		this.getObject().setSelection(position);
	}

	public int getSelectedItemPosition() {
		return this.getObject().getSelectedItemPosition();
	}

	public void setBackgroundColor(int backgroundColor) {
		this.getObject().setBackgroundColor(backgroundColor);
	}

	
	public void setPopupBackgroundDrawable(Drawable background) {
		this.getObject().setPopupBackgroundDrawable(background);
	}

	public Drawable getPopupBackground() {
		return this.getObject().getPopupBackground();
	}

	public void setDropDownVerticalOffset(int pixels) {
		this.getObject().setDropDownVerticalOffset(pixels);
	}

	public int getDropDownVerticalOffset() {
		return this.getObject().getDropDownVerticalOffset();
	}

	public void setDropDownHorizontalOffset(int pixels) {
		this.getObject().setDropDownVerticalOffset(pixels);
	}

	public int getDropDownHorizontalOffset() {
		return this.getObject().getDropDownHorizontalOffset();
	}

	public void setDropDownWidth(int pixels) {
		this.getObject().setDropDownWidth(pixels);
	}

	public int getDropDownWidth() {
		return this.getObject().getDropDownWidth();
	}
	public void setGravity(int gravity) {
		this.getObject().setGravity(gravity);
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
