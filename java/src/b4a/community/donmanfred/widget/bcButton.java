package b4a.community.donmanfred.widget;

import com.rey.material.widget.Button;

import android.view.ViewGroup;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.Pixel;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.keywords.Common.DesignerCustomView;
import anywheresoftware.b4a.objects.LabelWrapper;
import anywheresoftware.b4a.objects.PanelWrapper;
import anywheresoftware.b4a.objects.ViewWrapper;

@ShortName("bcButton")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
//@Events(values={
//		"onmodechanged(mode As Int)",
//		"onhourchanged(oldValue As int, newValue As int)",
//		"onminutechanged(oldValue As int, newValue As int)"
//		})
//@DependsOn(values={"android-viewbadger"})
public class bcButton extends ViewWrapper<Button>  implements DesignerCustomView {
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
		this.setObject(new Button(ba.context));
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
