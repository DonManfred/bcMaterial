package b4a.community.donmanfred.widget;


import com.rey.material.widget.CheckedTextView;

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

@ShortName("msCheckedTextView")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
@Events(values={
		"onClick(v as Object)"
//		"onhourchanged(oldValue As int, newValue As int)",
//		"onminutechanged(oldValue As int, newValue As int)"
		})
//@DependsOn(values={"android-viewbadger"})
public class bcCheckedTextView extends ViewWrapper<CheckedTextView>  implements DesignerCustomView {
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
		this.setObject(new CheckedTextView(ba.context));
		this.getObject().setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (ba.subExists(eventName + "_onclick")) {
					BA.Log("lib:Raising.. "+eventName + "_onclick()");								
					ba.raiseEvent(ba.context, eventName+"_onclick", v);
					//ba.raiseEventFromDifferentThread(ba.context, null, 0, eventName + "_onmodechanged", true, new Object[] {mode});
				}else {
					BA.Log("lib: NOTFOUND '"+eventName + "_onclick");
				}
				
			}
			
		});
 	}

	@Override
	public void setTag(Object tag){
		this.getObject().setTag(tag);
	}
	@Override
	public Object getTag(){
		return this.getObject().getTag();
	}
	public void setText(String text){
		this.getObject().setText(text);
	}
	public void setTextColor(int color){
		this.getObject().setTextColor(color);
	}
	public void setTextsize(int size){
		this.getObject().setTextSize(size);
	}
	public void setChecked(boolean checked){
		this.getObject().setChecked(checked);
	}
	public boolean getChecked(){
		return this.getObject().isChecked();
	}
  public void setBackgroundDrawable(Drawable drawable) {
  	this.getObject().setBackgroundDrawable(drawable);
  }
  @Override
	public void setBackground(Drawable drawable) {
  	this.getObject().setBackground(drawable);
  }
  public void setBackgroundColor(int color) {
  	this.getObject().setBackgroundColor(color);
  }
//  public void setBackgroundTintMode(tintMode mode) {
//  	this.getObject().setBackgroundTintMode(mode);
//  }
  
  
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
