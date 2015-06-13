package b4a.community.donmanfred.widget;


import com.rey.material.widget.LinearProgressView;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.Pixel;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.keywords.Common.DesignerCustomView;
import anywheresoftware.b4a.objects.LabelWrapper;
import anywheresoftware.b4a.objects.PanelWrapper;

@ShortName("bcLinearProgressView")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
@Events(values={
		"onCheckedChanged(tag as Object, checked As boolean)"
//		"onhourchanged(oldValue As int, newValue As int)",
//		"onminutechanged(oldValue As int, newValue As int)"
		})
//@DependsOn(values={"android-viewbadger"})
public class bcLinearProgressView extends AbsObjectWrapper<LinearProgressView>  implements DesignerCustomView {
	private BA ba;
	private String eventName;
	private int pType ; 

	
	/*
	 * Initialize the HTML-TextView 
	 */   	
	public void Initialize(final BA ba, String EventName, int type) {
		pType = type;
		_initialize(ba, null, EventName);
	}
	
	@Override
	@Hide
	public void _initialize(final BA ba, Object activityClass, String EventName) {
		this.eventName = EventName.toLowerCase(BA.cul);
		this.ba = ba;
		this.setObject(new LinearProgressView(ba.context));
		
		//this.getObject()
 	}

	public void setTag(Object tag){
		this.getObject().setTag(tag);
	}
	public Object getTag(){
		return this.getObject().getTag();
	}
	public int getProgressMode(){
		return this.getObject().getProgressMode();
	}
	
	public float getProgress(){
		return this.getObject().getProgress();
	}
	
	public float getSecondaryProgress(){
		return this.getObject().getSecondaryProgress();
	}
	
	public void setProgress(float percent){
		this.getObject().setProgress(percent);
	}
	
	public void setSecondaryProgress(float percent){
		this.getObject().setSecondaryProgress(percent);
	}
	
	public void start(){
		this.getObject().start();
	}
	
	public void stop(){
		 this.getObject().stop();
	}
	/**
	 * @return the mColors
	 */
	public int[] getColors() {
		return this.getObject().getColors();
	}

	/**
	 * @param mColors the mColors to set
	 */
	public void setColors(int[] Colors) {
		this.getObject().setColors(Colors);
	}


	public boolean isAutostart() {
		return this.getObject().isAutostart();
	}

	public void setAutostart(boolean Autostart) {
		this.getObject().setAutostart(Autostart);
	}

	public int getmProgressId() {
		return this.getObject().getProgressId();
	}

	public void setmProgressId(int ProgressId) {
		this.getObject().setProgressId(ProgressId);
	}

	public Drawable getProgressDrawable() {
		return this.getObject().getProgressDrawable();
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

	public void setLeft(int left)	{
		BALayout.LayoutParams lp = (BALayout.LayoutParams)this.getObject().getLayoutParams();
		lp.left = left;
		this.getObject().getParent().requestLayout();
	}
	public int getLeft()	{
		BALayout.LayoutParams lp = (BALayout.LayoutParams)this.getObject().getLayoutParams();
		return lp.left;
	}
	public void setTop(int top)	{
		BALayout.LayoutParams lp = (BALayout.LayoutParams)this.getObject().getLayoutParams();
		lp.top = top;
		this.getObject().getParent().requestLayout();
	}
	public int getTop()	{
		BALayout.LayoutParams lp = (BALayout.LayoutParams)this.getObject().getLayoutParams();
		return lp.top;
	}
	
	
}
