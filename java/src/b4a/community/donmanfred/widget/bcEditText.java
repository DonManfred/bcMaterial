package b4a.community.donmanfred.widget;




import java.util.Locale;

import com.rey.material.widget.EditText;
import com.rey.material.widget.TextView.OnSelectionChangedListener;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils.TruncateAt;
import android.text.method.TransformationMethod;
import android.text.style.URLSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
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

@ShortName("bcEditText")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
@Events(values={
		"onselectionchanged(v As Object, selStart As Int, selEnd As Int)",
		"onfocuschange(v As Object, focused As boolean)"
//		"onhourchanged(oldValue As int, newValue As int)",
//		"onminutechanged(oldValue As int, newValue As int)"
		})
//@DependsOn(values={"android-viewbadger"})
public class bcEditText extends ViewWrapper<EditText>  implements DesignerCustomView {
	private BA ba;
	private String eventName;
	@Override
	public void Initialize(final BA ba, String EventName) {
		_initialize(ba, null, EventName);
	}
	@Override
	@Hide
	public void _initialize(final BA ba, Object activityClass, String EventName) {
		this.eventName = EventName.toLowerCase(BA.cul);
		this.ba = ba;
		this.setObject(new EditText(ba.context));
		this.getObject().setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> adapter, View v, int arg2,	long arg3) {
				// TODO Auto-generated method stub
				ba.LogInfo("OnItemClickListener:onItemClick");
			}
			
		});
		this.getObject().setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ba.LogInfo("OnClickListener:onClick");
			}
			
		});
		
		this.getObject().setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> adapter, View v, int arg2, long arg3) {
				// TODO Auto-generated method stub
				ba.LogInfo("OnItemSelectedListener:onItemSelected");
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> adapter) {
				// TODO Auto-generated method stub
				ba.LogInfo("OnItemSelectedListener:onNothingSelected");
				
			}
			
		});
		
		
		this.getObject().setOnSelectionChangedListener(new OnSelectionChangedListener(){

			@Override
			public void onSelectionChanged(View v, int selStart, int selEnd) {
				// TODO Auto-generated method stub
				if (ba.subExists(eventName + "_onselectionchanged")) {
					//ba.Log("lib:Raising.. "+eventName + "_onselectionchanged()");								
					ba.raiseEvent(ba.context, eventName+"_onselectionchanged", v, selStart, selEnd);
					//ba.raiseEventFromDifferentThread(ba.context, null, 0, eventName + "_onselectionchanged", true, new Object[] {mode});
				}else {
					BA.Log("lib: NOTFOUND '"+eventName + "_onselectionchanged");
				}
				
			}
			
		});
		this.getObject().setOnFocusChangeListener(new OnFocusChangeListener(){

			@Override
			public void onFocusChange(View v, boolean focused) {
				// TODO Auto-generated method stub
				if (ba.subExists(eventName + "_onfocuschange")) {
					//ba.Log("lib:Raising.. "+eventName + "_onfocuschange()");								
					ba.raiseEvent(ba.context, eventName+"_onfocuschange", v, focused);
					//ba.raiseEventFromDifferentThread(ba.context, null, 0, eventName + "_onfocuschange", true, new Object[] {mode});
				}else {
					BA.Log("lib: NOTFOUND '"+eventName + "_onfocuschange");
				}
				
			}
			
		});
	}

	public void setBackgroundColor(int color){
		this.getObject().setBackgroundColor(color);
	}

	@Override
	public void setTag(Object tag){
		this.getObject().setTag(tag);
	}
	@Override
	public Object getTag(){
		return this.getObject().getTag();
	}
	
	public void setHelper(String helper) {
		this.getObject().setHelper(helper);
	}

	public CharSequence getHelper() {
		return this.getObject().getHelper();
	}

	public void setError(CharSequence error) {
		this.getObject().setError(error);
	}

	public CharSequence getError() {
		return this.getObject().getError();
	}

	public void clearError() {
		this.getObject().clearError();
	}

	public void clearFocus() {
		this.getObject().clearFocus();
	}

	/**
	 * <p>
	 * Sets the optional hint text that is displayed at the bottom of the the
	 * matching list. This can be used as a cue to the user on how to best use the
	 * list, or to provide extra information.
	 * </p>
	 * <p>
	 * Only work when autoCompleMode is AUTOCOMPLETE_MODE_SINGLE or
	 * AUTOCOMPLETE_MODE_MULTI
	 * </p>
	 *
	 * @param hint
	 *          the text to be displayed to the user
	 *
	 * @see #getCompletionHint()
	 *
	 * @attr ref android.R.styleable#AutoCompleteTextView_completionHint
	 */
	public void setCompletionHint(CharSequence hint) {
		this.getObject().setCompletionHint(hint);
	}

	/**
	 * Gets the optional hint text displayed at the bottom of the the matching
	 * list.
	 * <p>
	 * Only work when autoCompleMode is AUTOCOMPLETE_MODE_SINGLE or
	 * AUTOCOMPLETE_MODE_MULTI
	 * </p>
	 *
	 * @return The hint text, if any
	 *
	 */
	public CharSequence getCompletionHint() {
		return this.getObject().getCompletionHint();
	}
	/**
	 * <p>
	 * Returns the current width for the auto-complete drop down list. This can be
	 * a fixed width, or {@link ViewGroup.LayoutParams#MATCH_PARENT} to fill the
	 * screen, or {@link ViewGroup.LayoutParams#WRAP_CONTENT} to fit the width of
	 * its anchor view.
	 * </p>
	 * <p>
	 * Only work when autoCompleMode is AUTOCOMPLETE_MODE_SINGLE or
	 * AUTOCOMPLETE_MODE_MULTI
	 * </p>
	 *
	 * @return the width for the drop down list
	 *
	 */
	public int getDropDownWidth() {
		return this.getObject().getDropDownWidth();
	}
	/**
	 * <p>
	 * Sets the current width for the auto-complete drop down list. This can be a
	 * fixed width, or {@link ViewGroup.LayoutParams#MATCH_PARENT} to fill the
	 * screen, or {@link ViewGroup.LayoutParams#WRAP_CONTENT} to fit the width of
	 * its anchor view.
	 * </p>
	 * <p>
	 * Only work when autoCompleMode is AUTOCOMPLETE_MODE_SINGLE or
	 * AUTOCOMPLETE_MODE_MULTI
	 * </p>
	 *
	 * @param width
	 *          the width to use
	 *
	 * @attr ref android.R.styleable#AutoCompleteTextView_dropDownWidth
	 */
	public void setDropDownWidth(int width) {
		this.getObject().setDropDownWidth(width);
	}
	/**
	 * <p>
	 * Returns the current height for the auto-complete drop down list. This can
	 * be a fixed height, or {@link ViewGroup.LayoutParams#MATCH_PARENT} to fill
	 * the screen, or {@link ViewGroup.LayoutParams#WRAP_CONTENT} to fit the
	 * height of the drop down's content.
	 * </p>
	 * <p>
	 * Only work when autoCompleMode is AUTOCOMPLETE_MODE_SINGLE or
	 * AUTOCOMPLETE_MODE_MULTI
	 * </p>
	 *
	 * @return the height for the drop down list
	 *
	 * @attr ref android.R.styleable#AutoCompleteTextView_dropDownHeight
	 */
	public int getDropDownHeight() {
		return this.getObject().getDropDownHeight();
	}

	/**
	 * <p>
	 * Sets the current height for the auto-complete drop down list. This can be a
	 * fixed height, or {@link ViewGroup.LayoutParams#MATCH_PARENT} to fill the
	 * screen, or {@link ViewGroup.LayoutParams#WRAP_CONTENT} to fit the height of
	 * the drop down's content.
	 * </p>
	 * <p>
	 * Only work when autoCompleMode is AUTOCOMPLETE_MODE_SINGLE or
	 * AUTOCOMPLETE_MODE_MULTI
	 * </p>
	 *
	 * @param height
	 *          the height to use
	 *
	 * @attr ref android.R.styleable#AutoCompleteTextView_dropDownHeight
	 */
	public void setDropDownHeight(int height) {
		this.getObject().setDropDownHeight(height);
	}
	/**
	 * <p>
	 * Returns the id for the view that the auto-complete drop down list is
	 * anchored to.
	 * </p>
	 * <p>
	 * Only work when autoCompleMode is AUTOCOMPLETE_MODE_SINGLE or
	 * AUTOCOMPLETE_MODE_MULTI
	 * </p>
	 *
	 * @return the view's id, or {@link View#NO_ID} if none specified
	 *
	 * @attr ref android.R.styleable#AutoCompleteTextView_dropDownAnchor
	 */
	public int getDropDownAnchor() {
		return this.getObject().getDropDownAnchor();
	}
	/**
	 * <p>
	 * Sets the view to which the auto-complete drop down list should anchor. The
	 * view corresponding to this id will not be loaded until the next time it is
	 * needed to avoid loading a view which is not yet instantiated.
	 * </p>
	 * <p>
	 * Only work when autoCompleMode is AUTOCOMPLETE_MODE_SINGLE or
	 * AUTOCOMPLETE_MODE_MULTI
	 * </p>
	 *
	 * @param id
	 *          the id to anchor the drop down list view to
	 *
	 * @attr ref android.R.styleable#AutoCompleteTextView_dropDownAnchor
	 */
	public void setDropDownAnchor(int id) {
		this.getObject().setDropDownAnchor(id);
	}
	/**
	 * <p>
	 * Gets the background of the auto-complete drop-down list.
	 * </p>
	 * <p>
	 * Only work when autoCompleMode is AUTOCOMPLETE_MODE_SINGLE or
	 * AUTOCOMPLETE_MODE_MULTI
	 * </p>
	 *
	 * @return the background drawable
	 *
	 * @attr ref android.R.styleable#PopupWindow_popupBackground
	 */
	public Drawable getDropDownBackground() {
		return this.getObject().getDropDownBackground();
	}

	/**
	 * <p>
	 * Sets the background of the auto-complete drop-down list.
	 * </p>
	 * <p>
	 * Only work when autoCompleMode is AUTOCOMPLETE_MODE_SINGLE or
	 * AUTOCOMPLETE_MODE_MULTI
	 * </p>
	 *
	 * @param d
	 *          the drawable to set as the background
	 *
	 * @attr ref android.R.styleable#PopupWindow_popupBackground
	 */
	public void setDropDownBackgroundDrawable(Drawable d) {
		this.getObject().setDropDownBackgroundDrawable(d);
	}
	/**
	 * <p>
	 * Sets the vertical offset used for the auto-complete drop-down list.
	 * </p>
	 * <p>
	 * Only work when autoCompleMode is AUTOCOMPLETE_MODE_SINGLE or
	 * AUTOCOMPLETE_MODE_MULTI
	 * </p>
	 *
	 * @param offset
	 *          the vertical offset
	 *
	 * @attr ref android.R.styleable#ListPopupWindow_dropDownVerticalOffset
	 */
	public void setDropDownVerticalOffset(int offset) {
		this.getObject().setDropDownVerticalOffset(offset);
	}
	
	/**
	 * <p>
	 * Gets the vertical offset used for the auto-complete drop-down list.
	 * </p>
	 * <p>
	 * Only work when autoCompleMode is AUTOCOMPLETE_MODE_SINGLE or
	 * AUTOCOMPLETE_MODE_MULTI
	 * </p>
	 *
	 * @return the vertical offset
	 *
	 * @attr ref android.R.styleable#ListPopupWindow_dropDownVerticalOffset
	 */
	public int getDropDownVerticalOffset() {
		return this.getObject().getDropDownVerticalOffset();
	}
	/**
	 * <p>
	 * Sets the horizontal offset used for the auto-complete drop-down list.
	 * </p>
	 * <p>
	 * Only work when autoCompleMode is AUTOCOMPLETE_MODE_SINGLE or
	 * AUTOCOMPLETE_MODE_MULTI
	 * </p>
	 *
	 * @param offset
	 *          the horizontal offset
	 *
	 * @attr ref android.R.styleable#ListPopupWindow_dropDownHorizontalOffset
	 */
	public void setDropDownHorizontalOffset(int offset) {
		this.getObject().setDropDownHorizontalOffset(offset);
	}
	
	/**
	 * <p>
	 * Gets the horizontal offset used for the auto-complete drop-down list.
	 * </p>
	 * <p>
	 * Only work when autoCompleMode is AUTOCOMPLETE_MODE_SINGLE or
	 * AUTOCOMPLETE_MODE_MULTI
	 * </p>
	 *
	 * @return the horizontal offset
	 *
	 * @attr ref android.R.styleable#ListPopupWindow_dropDownHorizontalOffset
	 */
	public int getDropDownHorizontalOffset() {
		return this.getObject().getDropDownHorizontalOffset();
	}
	
	/**
	 * <p>
	 * Returns the number of characters the user must type before the drop down
	 * list is shown.
	 * </p>
	 * <p>
	 * Only work when autoCompleMode is AUTOCOMPLETE_MODE_SINGLE or
	 * AUTOCOMPLETE_MODE_MULTI
	 * </p>
	 *
	 * @return the minimum number of characters to type to show the drop down
	 *
	 * @see #setThreshold(int)
	 *
	 * @attr ref android.R.styleable#AutoCompleteTextView_completionThreshold
	 */
	public int getThreshold() {
		return this.getObject().getThreshold();
	}
	
	/**
	 * <p>
	 * Specifies the minimum number of characters the user has to type in the edit
	 * box before the drop down list is shown.
	 * </p>
	 *
	 * <p>
	 * When <code>threshold</code> is less than or equals 0, a threshold of 1 is
	 * applied.
	 * </p>
	 *
	 * <p>
	 * Only work when autoCompleMode is AUTOCOMPLETE_MODE_SINGLE or
	 * AUTOCOMPLETE_MODE_MULTI
	 * </p>
	 *
	 * @param threshold
	 *          the number of characters to type before the drop down is shown
	 *
	 * @see #getThreshold()
	 *
	 * @attr ref android.R.styleable#AutoCompleteTextView_completionThreshold
	 */
	public void setThreshold(int threshold) {
		this.getObject().setThreshold(threshold);
	}
	
	
	
	/**
	 * Returns <code>true</code> if the amount of text in the field meets or
	 * exceeds the {@link #getThreshold} requirement. You can override this to
	 * impose a different standard for when filtering will be triggered.
	 * <p>
	 * Only work when autoCompleMode is AUTOCOMPLETE_MODE_SINGLE or
	 * AUTOCOMPLETE_MODE_MULTI
	 * </p>
	 */
	public boolean enoughToFilter() {
		return this.getObject().enoughToFilter();
	}

	/**
	 * <p>
	 * Indicates whether the popup menu is showing.
	 * </p>
	 * <p>
	 * Only work when autoCompleMode is AUTOCOMPLETE_MODE_SINGLE or
	 * AUTOCOMPLETE_MODE_MULTI
	 * </p>
	 *
	 * @return true if the popup menu is showing, false otherwise
	 */
	public boolean isPopupShowing() {
		return this.getObject().isPopupShowing();
	}

	/**
	 * <p>
	 * Clear the list selection. This may only be temporary, as user input will
	 * often bring it back.
	 * <p>
	 * Only work when autoCompleMode is AUTOCOMPLETE_MODE_SINGLE or
	 * AUTOCOMPLETE_MODE_MULTI
	 * </p>
	 */
	public void clearListSelection() {
		this.getObject().clearListSelection();
	}

	/**
	 * Set the position of the dropdown view selection.
	 * <p>
	 * Only work when autoCompleMode is AUTOCOMPLETE_MODE_SINGLE or
	 * AUTOCOMPLETE_MODE_MULTI
	 * </p>
	 *
	 * @param position
	 *          The position to move the selector to.
	 */
	public void setListSelection(int position) {
		this.getObject().setListSelection(position);
	}

	/**
	 * Get the position of the dropdown view selection, if there is one. Returns
	 * {@link android.widget.ListView#INVALID_POSITION ListView.INVALID_POSITION}
	 * if there is no dropdown or if there is no selection.
	 * <p>
	 * Only work when autoCompleMode is AUTOCOMPLETE_MODE_SINGLE or
	 * AUTOCOMPLETE_MODE_MULTI
	 * </p>
	 *
	 * @return the position of the current selection, if there is one, or
	 *         {@link android.widget.ListView#INVALID_POSITION
	 *         ListView.INVALID_POSITION} if not.
	 *
	 * @see android.widget.ListView#getSelectedItemPosition()
	 */
	public int getListSelection() {
		return this.getObject().getListSelection();
	}

	/**
	 * <p>
	 * Performs the text completion by converting the selected item from the drop
	 * down list into a string, replacing the text box's content with this string
	 * and finally dismissing the drop down menu.
	 * </p>
	 * <p>
	 * Only work when autoCompleMode is AUTOCOMPLETE_MODE_SINGLE or
	 * AUTOCOMPLETE_MODE_MULTI
	 * </p>
	 */
	public void performCompletion() {
		this.getObject().performCompletion();
	}

	/**
	 * Identifies whether the view is currently performing a text completion, so
	 * subclasses can decide whether to respond to text changed events.
	 * <p>
	 * Only work when autoCompleMode is AUTOCOMPLETE_MODE_SINGLE or
	 * AUTOCOMPLETE_MODE_MULTI
	 * </p>
	 */
	public boolean isPerformingCompletion() {
		return this.getObject().isPerformingCompletion();
	}

	/**
	 * <p>
	 * Only work when autoCompleMode is AUTOCOMPLETE_MODE_SINGLE or
	 * AUTOCOMPLETE_MODE_MULTI
	 * </p>
	 */
	public void onFilterComplete(int count) {
		this.getObject().onFilterComplete(count);
	}

	/**
	 * <p>
	 * Closes the drop down if present on screen.
	 * </p>
	 * <p>
	 * Only work when autoCompleMode is AUTOCOMPLETE_MODE_SINGLE or
	 * AUTOCOMPLETE_MODE_MULTI
	 * </p>
	 */
	public void dismissDropDown() {
		this.getObject().dismissDropDown();
	}

	/**
	 * <p>
	 * Displays the drop down on screen.
	 * </p>
	 * <p>
	 * Only work when autoCompleMode is AUTOCOMPLETE_MODE_SINGLE or
	 * AUTOCOMPLETE_MODE_MULTI
	 * </p>
	 */
	public void showDropDown() {
		this.getObject().showDropDown();
	}
	
	
	
	
	/**
	 * Convenience for {@link android.text.Selection#extendSelection}.
	 */
	public void extendSelection(int index) {
		this.getObject().extendSelection(index);
	}

	public Editable getText() {
		return this.getObject().getText();
	}

	public void selectAll() {
		this.getObject().selectAll();
	}

	
	/**
	 * Convenience for
	 * {@link android.text.Selection#setSelection(android.text.Spannable, int)}.
	 */
	public void setSelectionStart(int index) {
		this.getObject().setSelection(index);
	}

	/**
	 * Convenience for
	 * {@link android.text.Selection#setSelection(android.text.Spannable, int, int)}
	 * .
	 */
	public void setSelection(int start, int stop) {
		this.getObject().setSelection(start, stop);
	}

	public void setText(CharSequence text) {
		this.getObject().setText(text);
	}
	
	
	/**
	 * Convenience method: Append the specified text to the TextView's display
	 * buffer, upgrading it to BufferType.EDITABLE if it was not already editable.
	 */
	public final void append(CharSequence text) {
		this.getObject().append(text);
	}
	
	/**
	 * Convenience method: Append the specified text slice to the TextView's
	 * display buffer, upgrading it to BufferType.EDITABLE if it was not already
	 * editable.
	 */
	public void appendAt(CharSequence text, int start, int end) {
		this.getObject().append(text, start, end);
	}

	public void beginBatchEdit() {
		this.getObject().beginBatchEdit();
	}
	/**
	 * Move the point, specified by the offset, into the view if it is needed.
	 * This has to be called after layout. Returns true if anything changed.
	 */
	public boolean bringPointIntoView(int offset) {
		return this.getObject().bringPointIntoView(offset);
	}

	public void cancelLongPress() {
		this.getObject().cancelLongPress();
	}
	/**
	 * Use
	 * {@link android.view.inputmethod.BaseInputConnection#removeComposingSpans
	 * BaseInputConnection.removeComposingSpans()} to remove any IME composing
	 * state from this text view.
	 */
	public void clearComposingText() {
		this.getObject().clearComposingText();
	}

	/**
	 * Returns true, only while processing a touch gesture, if the initial touch
	 * down event caused focus to move to the text view and as a result its
	 * selection changed. Only valid while processing the touch gesture of
	 * interest, in an editable text view.
	 */
	public boolean didTouchFocusSelect() {
		return this.getObject().didTouchFocusSelect();
	}

	public void endBatchEdit() {
		this.getObject().endBatchEdit();
	}
	
	/**
	 * Gets the autolink mask of the text. See
	 * {@link android.text.util.Linkify#ALL Linkify.ALL} and peers for possible
	 * values.
	 *
	 * @attr ref android.R.styleable#TextView_autoLink
	 */
	public final int getAutoLinkMask() {
		return this.getObject().getAutoLinkMask();
	}
	/**
	 * Returns the padding between the compound drawables and the text.
	 *
	 * @attr ref android.R.styleable#TextView_drawablePadding
	 */
	public int getCompoundDrawablePadding() {
		return this.getObject().getCompoundDrawablePadding();
	}

	/**
	 * Returns the bottom padding of the view, plus space for the bottom Drawable
	 * if any.
	 */
	public int getCompoundPaddingBottom() {
		return this.getObject().getCompoundPaddingBottom();
	}

	/**
	 * Returns the end padding of the view, plus space for the end Drawable if
	 * any.
	 */
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
	public int getCompoundPaddingEnd() {
		return this.getObject().getCompoundPaddingEnd();
	}

	/**
	 * Returns the left padding of the view, plus space for the left Drawable if
	 * any.
	 */
	public int getCompoundPaddingLeft() {
		return this.getObject().getCompoundPaddingLeft();
	}

	/**
	 * Returns the right padding of the view, plus space for the right Drawable if
	 * any.
	 */
	public int getCompoundPaddingRight() {
		return this.getObject().getCompoundPaddingRight();
	}

	/**
	 * Returns the start padding of the view, plus space for the start Drawable if
	 * any.
	 */
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
	public int getCompoundPaddingStart() {
		return this.getObject().getCompoundPaddingStart();
	}

	/**
	 * Returns the top padding of the view, plus space for the top Drawable if
	 * any.
	 */
	public int getCompoundPaddingTop() {
		return this.getObject().getCompoundPaddingTop();
	}

	/**
	 * <p>
	 * Return the current color selected to paint the hint text.
	 * </p>
	 *
	 * @return Returns the current hint text color.
	 */
	public final int getCurrentHintTextColor() {
		return this.getObject().getCurrentHintTextColor();
	}

	/**
	 * <p>
	 * Return the current color selected for normal text.
	 * </p>
	 *
	 * @return Returns the current text color.
	 */
	public final int getCurrentTextColor() {
		return this.getObject().getCurrentTextColor();
	}

	/**
	 * Return the text the TextView is displaying as an Editable object. If the
	 * text is not editable, null is returned.
	 *
	 * @see #getText
	 */
	public Editable getEditableText() {
		return this.getObject().getEditableText();
	}
	
	/**
	 * Returns where, if anywhere, words that are longer than the view is wide
	 * should be ellipsized.
	 */
	public TruncateAt getEllipsize() {
		return this.getObject().getEllipsize();
	}

	/**
	 * Returns the extended bottom padding of the view, including both the bottom
	 * Drawable if any and any extra space to keep more than maxLines of text from
	 * showing. It is only valid to call this after measuring.
	 */
	public int getExtendedPaddingBottom() {
		return this.getObject().getExtendedPaddingBottom();
	}

	/**
	 * Returns the extended top padding of the view, including both the top
	 * Drawable if any and any extra space to keep more than maxLines of text from
	 * showing. It is only valid to call this after measuring.
	 */
	public int getExtendedPaddingTop() {
		return this.getObject().getExtendedPaddingTop();
	}

	/**
	 * Returns the current list of input filters.
	 *
	 * @attr ref android.R.styleable#TextView_maxLength
	 */
	public InputFilter[] getFilters() {
		return this.getObject().getFilters();
	}

	/**
	 * Return whether this text view is including its entire text contents in
	 * frozen icicles.
	 *
	 * @return Returns true if text is included, false if it isn't.
	 *
	 * @see #setFreezesText
	 */
	public boolean getFreezesText() {
		return this.getObject().getFreezesText();
	}

	/**
	 * Returns the horizontal and vertical alignment of this TextView.
	 *
	 * @see android.view.Gravity
	 * @attr ref android.R.styleable#TextView_gravity
	 */
	public int getGravity() {
		return this.getObject().getGravity();
	}

	/**
	 * @return the color used to display the selection highlight
	 */
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	public int getHighlightColor() {
		return this.getObject().getHighlightColor();
	}

	/**
	 * Returns the hint that is displayed when the text of the TextView is empty.
	 *
	 * @attr ref android.R.styleable#TextView_hint
	 */
	public CharSequence getHint() {
		return this.getObject().getHint();
	}
	/**
	 * @return the color of the hint text, for the different states of this
	 *         TextView.
	 *
	 * @see #setHintTextColor(android.content.res.ColorStateList)
	 * @see #setHintTextColor(int)
	 * @see #setTextColor(android.content.res.ColorStateList)
	 * @see #setLinkTextColor(android.content.res.ColorStateList)
	 *
	 * @attr ref android.R.styleable#TextView_textColorHint
	 */
	public final ColorStateList getHintTextColors() {
		return this.getObject().getHintTextColors();
	}

	/**
	 * Get the IME action ID previous set with {@link #setImeActionLabel}.
	 *
	 * @see #setImeActionLabel
	 * @see android.view.inputmethod.EditorInfo
	 */
	public int getImeActionId() {
		return this.getObject().getImeActionId();
	}
	/**
	 * Get the IME action label previous set with {@link #setImeActionLabel}.
	 *
	 * @see #setImeActionLabel
	 * @see android.view.inputmethod.EditorInfo
	 */
	public CharSequence getImeActionLabel() {
		return this.getObject().getImeActionLabel();
	}

	/**
	 * Get the type of the IME editor.
	 *
	 * @see #setImeOptions(int)
	 * @see android.view.inputmethod.EditorInfo
	 */
	public int getImeOptions() {
		return this.getObject().getImeOptions();
	}

	/**
	 * Retrieve the input extras currently associated with the text view, which
	 * can be viewed as well as modified.
	 *
	 * @param create
	 *          If true, the extras will be created if they don't already exist.
	 *          Otherwise, null will be returned if none have been created.
	 * @see #setInputExtras(int)
	 * @see android.view.inputmethod.EditorInfo#extras
	 * @attr ref android.R.styleable#TextView_editorExtras
	 */
	public Bundle getInputExtras(boolean create) {
		return this.getObject().getInputExtras(create);
	}

	/**
	 * Get the type of the editable content.
	 *
	 * @see #setInputType(int)
	 * @see android.text.InputType
	 */
	public int getInputType() {
		return this.getObject().getInputType();
	}

	
	/**
	 * Return the baseline for the specified line (0...getLineCount() - 1) If
	 * bounds is not null, return the top, left, right, bottom extents of the
	 * specified line in it. If the internal Layout has not been built, return 0
	 * and set bounds to (0, 0, 0, 0)
	 * 
	 * @param line
	 *          which line to examine (0..getLineCount() - 1)
	 * @param bounds
	 *          Optional. If not null, it returns the extent of the line
	 * @return the Y-coordinate of the baseline
	 */
	public int getLineBounds(int line, Rect bounds) {
		return this.getObject().getLineBounds(line, bounds);
	}

	/**
	 * Return the number of lines of text, or 0 if the internal Layout has not
	 * been built.
	 */
	public int getLineCount() {
		return this.getObject().getLineCount();
	}

	/**
	 * @return the height of one standard line in pixels. Note that markup within
	 *         the text can cause individual lines to be taller or shorter than
	 *         this height, and the layout may contain additional first- or
	 *         last-line padding.
	 */
	public int getLineHeight() {
		return this.getObject().getLineHeight();
	}

	/**
	 * Gets the line spacing extra space
	 *
	 * @return the extra space that is added to the height of each lines of this
	 *         TextView.
	 *
	 * @see #setLineSpacing(float, float)
	 * @see #getLineSpacingMultiplier()
	 *
	 * @attr ref android.R.styleable#TextView_lineSpacingExtra
	 */
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	public float getLineSpacingExtra() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
			return this.getObject().getLineSpacingExtra();
		return 0f;
	}

	/**
	 * Gets the line spacing multiplier
	 *
	 * @return the value by which each line's height is multiplied to get its
	 *         actual height.
	 *
	 * @see #setLineSpacing(float, float)
	 * @see #getLineSpacingExtra()
	 *
	 * @attr ref android.R.styleable#TextView_lineSpacingMultiplier
	 */
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	public float getLineSpacingMultiplier() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
			return this.getObject().getLineSpacingMultiplier();
		return 0f;
	}

	/**
	 * @return the list of colors used to paint the links in the text, for the
	 *         different states of this TextView
	 *
	 * @see #setLinkTextColor(android.content.res.ColorStateList)
	 * @see #setLinkTextColor(int)
	 *
	 * @attr ref android.R.styleable#TextView_textColorLink
	 */
	public final ColorStateList getLinkTextColors() {
		return this.getObject().getLinkTextColors();
	}

	/**
	 * Returns whether the movement method will automatically be set to
	 * {@link android.text.method.LinkMovementMethod} if {@link #setAutoLinkMask}
	 * has been set to nonzero and links are detected in {@link #setText}. The
	 * default is true.
	 *
	 * @attr ref android.R.styleable#TextView_linksClickable
	 */
	public final boolean getLinksClickable() {
		return this.getObject().getLinksClickable();
	}

	/**
	 * Gets the number of times the marquee animation is repeated. Only meaningful
	 * if the TextView has marquee enabled.
	 *
	 * @return the number of times the marquee animation is repeated. -1 if the
	 *         animation repeats indefinitely
	 *
	 * @see #setMarqueeRepeatLimit(int)
	 *
	 * @attr ref android.R.styleable#TextView_marqueeRepeatLimit
	 */
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	public int getMarqueeRepeatLimit() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
			return this.getObject().getMarqueeRepeatLimit();

		return -1;
	}

	/**
	 * @return the maximum width of the TextView, expressed in ems or -1 if the
	 *         maximum width was set in pixels instead (using
	 *         {@link #setMaxWidth(int)} or {@link #setWidth(int)}).
	 *
	 * @see #setMaxEms(int)
	 * @see #setEms(int)
	 *
	 * @attr ref android.R.styleable#TextView_maxEms
	 */
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	public int getMaxEms() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
			return this.getObject().getMaxEms();

		return -1;
	}

	/**
	 * @return the maximum height of this TextView expressed in pixels, or -1 if
	 *         the maximum height was set in number of lines instead using
	 *         {@link #setMaxLines(int) or #setLines(int)}.
	 *
	 * @see #setMaxHeight(int)
	 *
	 * @attr ref android.R.styleable#TextView_maxHeight
	 */
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	public int getMaxHeight() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
			return this.getObject().getMaxHeight();

		return -1;
	}

	/**
	 * @return the maximum number of lines displayed in this TextView, or -1 if
	 *         the maximum height was set in pixels instead using
	 *         {@link #setMaxHeight(int) or #setHeight(int)}.
	 *
	 * @see #setMaxLines(int)
	 *
	 * @attr ref android.R.styleable#TextView_maxLines
	 */
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	public int getMaxLines() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
			return this.getObject().getMaxLines();

		return -1;
	}

	/**
	 * @return the maximum width of the TextView, in pixels or -1 if the maximum
	 *         width was set in ems instead (using {@link #setMaxEms(int)} or
	 *         {@link #setEms(int)}).
	 *
	 * @see #setMaxWidth(int)
	 * @see #setWidth(int)
	 *
	 * @attr ref android.R.styleable#TextView_maxWidth
	 */
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	public int getMaxWidth() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
			return this.getObject().getMaxWidth();

		return -1;
	}

	/**
	 * @return the minimum width of the TextView, expressed in ems or -1 if the
	 *         minimum width was set in pixels instead (using
	 *         {@link #setMinWidth(int)} or {@link #setWidth(int)}).
	 *
	 * @see #setMinEms(int)
	 * @see #setEms(int)
	 *
	 * @attr ref android.R.styleable#TextView_minEms
	 */
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	public int getMinEms() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
			return this.getObject().getMinEms();

		return -1;
	}

	/**
	 * @return the minimum height of this TextView expressed in pixels, or -1 if
	 *         the minimum height was set in number of lines instead using
	 *         {@link #setMinLines(int) or #setLines(int)}.
	 *
	 * @see #setMinHeight(int)
	 *
	 * @attr ref android.R.styleable#TextView_minHeight
	 */
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	public int getMinHeight() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
			return this.getObject().getMinHeight();

		return -1;
	}

	/**
	 * @return the minimum number of lines displayed in this TextView, or -1 if
	 *         the minimum height was set in pixels instead using
	 *         {@link #setMinHeight(int) or #setHeight(int)}.
	 *
	 * @see #setMinLines(int)
	 *
	 * @attr ref android.R.styleable#TextView_minLines
	 */
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	public int getMinLines() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
			return this.getObject().getMinLines();

		return -1;
	}

	/**
	 * @return the minimum width of the TextView, in pixels or -1 if the minimum
	 *         width was set in ems instead (using {@link #setMinEms(int)} or
	 *         {@link #setEms(int)}).
	 *
	 * @see #setMinWidth(int)
	 * @see #setWidth(int)
	 *
	 * @attr ref android.R.styleable#TextView_minWidth
	 */
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	public int getMinWidth() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
			return this.getObject().getMinWidth();

		return -1;
	}
	
	/**
	 * Get the character offset closest to the specified absolute position. A
	 * typical use case is to pass the result of
	 * {@link android.view.MotionEvent#getX()} and
	 * {@link android.view.MotionEvent#getY()} to this method.
	 *
	 * @param x
	 *          The horizontal absolute position of a point on screen
	 * @param y
	 *          The vertical absolute position of a point on screen
	 * @return the character offset for the character whose position is closest to
	 *         the specified position. Returns -1 if there is no layout.
	 */
	@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
	public int getOffsetForPosition(float x, float y) {
		return this.getObject().getOffsetForPosition(x, y);
	}
	/**
	 * Get the private type of the content.
	 *
	 * @see #setPrivateImeOptions(String)
	 * @see android.view.inputmethod.EditorInfo#privateImeOptions
	 */
	public String getPrivateImeOptions() {
		return this.getObject().getPrivateImeOptions();
	}

	/**
	 * Convenience for {@link android.text.Selection#getSelectionEnd}.
	 */
	public int getSelectionEnd() {
		return this.getObject().getSelectionEnd();
	}

	/**
	 * Convenience for {@link android.text.Selection#getSelectionStart}.
	 */
	public int getSelectionStart() {
		return this.getObject().getSelectionStart();
	}

	/**
	 * @return the color of the shadow layer
	 *
	 * @see #setShadowLayer(float, float, float, int)
	 *
	 * @attr ref android.R.styleable#TextView_shadowColor
	 */
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	public int getShadowColor() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
			return this.getObject().getShadowColor();

		return 0;
	}

	/**
	 * @return the horizontal offset of the shadow layer
	 *
	 * @see #setShadowLayer(float, float, float, int)
	 *
	 * @attr ref android.R.styleable#TextView_shadowDx
	 */
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	public float getShadowDx() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
			return this.getObject().getShadowDx();

		return 0;
	}

	/**
	 * @return the vertical offset of the shadow layer
	 *
	 * @see #setShadowLayer(float, float, float, int)
	 *
	 * @attr ref android.R.styleable#TextView_shadowDy
	 */
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	public float getShadowDy() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
			return this.getObject().getShadowDy();

		return 0;
	}

	/**
	 * Gets the radius of the shadow layer.
	 *
	 * @return the radius of the shadow layer. If 0, the shadow layer is not
	 *         visible
	 *
	 * @see #setShadowLayer(float, float, float, int)
	 *
	 * @attr ref android.R.styleable#TextView_shadowRadius
	 */
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	public float getShadowRadius() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
			return this.getObject().getShadowRadius();

		return 0;
	}

	/**
	 * Returns whether the soft input method will be made visible when this
	 * TextView gets focused. The default is true.
	 */
	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	public final boolean getShowSoftInputOnFocus() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
			return this.getObject().getShowSoftInputOnFocus();
		return true;
	}

	/**
	 * Gets the text colors for the different states (normal, selected, focused)
	 * of the TextView.
	 *
	 * @see #setTextColor(android.content.res.ColorStateList)
	 * @see #setTextColor(int)
	 *
	 * @attr ref android.R.styleable#TextView_textColor
	 */
	public final ColorStateList getTextColors() {
		return this.getObject().getTextColors();
	}

	/**
	 * Get the default {@link java.util.Locale} of the text in this TextView.
	 * 
	 * @return the default {@link java.util.Locale} of the text in this TextView.
	 */
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
	public Locale getTextLocale() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
			return this.getObject().getTextLocale();

		return Locale.getDefault();
	}

	/**
	 * @return the extent by which text is currently being stretched horizontally.
	 *         This will usually be 1.
	 */
	public float getTextScaleX() {
		return this.getObject().getTextScaleX();
	}

	/**
	 * @return the size (in pixels) of the default text size in this TextView.
	 */
	public float getTextSize() {
		return this.getObject().getTextSize();
	}

	/**
	 * Returns the total bottom padding of the view, including the bottom Drawable
	 * if any, the extra space to keep more than maxLines from showing, and the
	 * vertical offset for gravity, if any.
	 */
	public int getTotalPaddingBottom() {
		return this.getObject().getTotalPaddingBottom();
	}

	/**
	 * Returns the total end padding of the view, including the end Drawable if
	 * any.
	 */
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
	public int getTotalPaddingEnd() {
		return this.getObject().getTotalPaddingEnd();
	}

	/**
	 * Returns the total left padding of the view, including the left Drawable if
	 * any.
	 */
	public int getTotalPaddingLeft() {
		return this.getObject().getTotalPaddingLeft();
	}

	/**
	 * Returns the total right padding of the view, including the right Drawable
	 * if any.
	 */
	public int getTotalPaddingRight() {
		return this.getObject().getTotalPaddingRight();
	}

	/**
	 * Returns the total start padding of the view, including the start Drawable
	 * if any.
	 */
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
	public int getTotalPaddingStart() {
		return this.getObject().getTotalPaddingStart();
	}

	/**
	 * Returns the total top padding of the view, including the top Drawable if
	 * any, the extra space to keep more than maxLines from showing, and the
	 * vertical offset for gravity, if any.
	 */
	public int getTotalPaddingTop() {
		return this.getObject().getTotalPaddingTop();
	}

	/**
	 * @return the current transformation method for this TextView. This will
	 *         frequently be null except for single-line and password fields.
	 *
	 * @attr ref android.R.styleable#TextView_password
	 * @attr ref android.R.styleable#TextView_singleLine
	 */
	public final TransformationMethod getTransformationMethod() {
		return this.getObject().getTransformationMethod();
	}

	/**
	 * @return the current typeface and style in which the text is being
	 *         displayed.
	 *
	 * @see #setTypeface(android.graphics.Typeface)
	 *
	 * @attr ref android.R.styleable#TextView_fontFamily
	 * @attr ref android.R.styleable#TextView_typeface
	 * @attr ref android.R.styleable#TextView_textStyle
	 */
	public Typeface getTypeface() {
		return this.getObject().getTypeface();
	}
	/**
	 * Returns the list of URLSpans attached to the text (by
	 * {@link android.text.util.Linkify} or otherwise) if any. You can call
	 * {@link android.text.style.URLSpan#getURL} on them to find where they link
	 * to or use {@link android.text.Spanned#getSpanStart} and
	 * {@link android.text.Spanned#getSpanEnd} to find the region of the text they
	 * are attached to.
	 */
	public URLSpan[] getUrls() {
		return this.getObject().getUrls();
	}

	/**
	 * Return true iff there is a selection inside this text view.
	 */
	public boolean hasSelection() {
		return this.getObject().hasSelection();
	}

	/**
	 * @return whether or not the cursor is visible (assuming this TextView is
	 *         editable)
	 *
	 * @see #setCursorVisible(boolean)
	 *
	 * @attr ref android.R.styleable#TextView_cursorVisible
	 */
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	public boolean isCursorVisible() {
		return this.getObject().isCursorVisible();
	}
	
	/**
	 * Returns whether this text view is a current input method target. The
	 * default implementation just checks with
	 * {@link android.view.inputmethod.InputMethodManager}.
	 */
	public boolean isInputMethodTarget() {
		return this.getObject().isInputMethodTarget();
	}

	/**
	 * Return whether or not suggestions are enabled on this TextView. The
	 * suggestions are generated by the IME or by the spell checker as the user
	 * types. This is done by adding {@link android.text.style.SuggestionSpan}s to
	 * the text.
	 *
	 * When suggestions are enabled (default), this list of suggestions will be
	 * displayed when the user asks for them on these parts of the text. This
	 * value depends on the inputType of this TextView.
	 *
	 * The class of the input type must be
	 * {@link android.text.InputType#TYPE_CLASS_TEXT}.
	 *
	 * In addition, the type variation must be one of
	 * {@link android.text.InputType#TYPE_TEXT_VARIATION_NORMAL},
	 * {@link android.text.InputType#TYPE_TEXT_VARIATION_EMAIL_SUBJECT},
	 * {@link android.text.InputType#TYPE_TEXT_VARIATION_LONG_MESSAGE},
	 * {@link android.text.InputType#TYPE_TEXT_VARIATION_SHORT_MESSAGE} or
	 * {@link android.text.InputType#TYPE_TEXT_VARIATION_WEB_EDIT_TEXT}.
	 *
	 * And finally, the
	 * {@link android.text.InputType#TYPE_TEXT_FLAG_NO_SUGGESTIONS} flag must
	 * <i>not</i> be set.
	 *
	 * @return true if the suggestions popup window is enabled, based on the
	 *         inputType.
	 */
	@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
	public boolean isSuggestionsEnabled() {
		return this.getObject().isSuggestionsEnabled();
	}

	/**
	 *
	 * Returns the state of the {@code textIsSelectable} flag (See
	 * {@link #setTextIsSelectable setTextIsSelectable()}). Although you have to
	 * set this flag to allow users to select and copy text in a non-editable
	 * TextView, the content of an {@link EditText} can always be selected,
	 * independently of the value of this flag.
	 * <p>
	 *
	 * @return True if the text displayed in this TextView can be selected by the
	 *         user.
	 *
	 * @attr ref android.R.styleable#TextView_textIsSelectable
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public boolean isTextSelectable() {
		return this.getObject().isTextSelectable();
	}

	/**
	 * Returns the length, in characters, of the text managed by this TextView
	 */
	public int length() {
		return this.getObject().length();
	}

	/**
	 * Move the cursor, if needed, so that it is at an offset that is visible to
	 * the user. This will not move the cursor if it represents more than one
	 * character (a selection range). This will only work if the TextView contains
	 * spannable text; otherwise it will do nothing.
	 *
	 * @return True if the cursor was actually moved, false otherwise.
	 */
	public boolean moveCursorToVisibleOffset() {
		return this.getObject().moveCursorToVisibleOffset();
	}

	/**
	 * Sets the properties of this field to transform input to ALL CAPS display.
	 * This may use a "small caps" formatting if available. This setting will be
	 * ignored if this field is editable or selectable.
	 *
	 * This call replaces the current transformation method. Disabling this will
	 * not necessarily restore the previous behavior from before this was enabled.
	 *
	 * @see #setTransformationMethod(android.text.method.TransformationMethod)
	 * @attr ref android.R.styleable#TextView_textAllCaps
	 */
	@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
	public void setAllCaps(boolean allCaps) {
		this.getObject().setAllCaps(allCaps);
	}

	/**
	 * Sets the autolink mask of the text. See
	 * {@link android.text.util.Linkify#ALL Linkify.ALL} and peers for possible
	 * values.
	 *
	 * @attr ref android.R.styleable#TextView_autoLink
	 */
	public final void setAutoLinkMask(int mask) {
		this.getObject().setAutoLinkMask(mask);
	}

	/**
	 * Sets the size of the padding between the compound drawables and the text.
	 *
	 * @attr ref android.R.styleable#TextView_drawablePadding
	 */
	public void setCompoundDrawablePadding(int pad) {
		this.getObject().setCompoundDrawablePadding(pad);
	}
	/**
	 * Set whether the cursor is visible. The default is true. Note that this
	 * property only makes sense for editable TextView.
	 *
	 * @see #isCursorVisible()
	 *
	 * @attr ref android.R.styleable#TextView_cursorVisible
	 */
	public void setCursorVisible(boolean visible) {
		this.getObject().setCursorVisible(visible);
	}

	
	
	/**
	 * Sets the list of input filters that will be used if the buffer is Editable.
	 * Has no effect otherwise.
	 *
	 * @attr ref android.R.styleable#TextView_maxLength
	 */
	public void setFilters(InputFilter[] filters) {
		this.getObject().setFilters(filters);
	}

	/**
	 * Sets font feature settings. The format is the same as the CSS
	 * font-feature-settings attribute:
	 * http://dev.w3.org/csswg/css-fonts/#propdef-font-feature-settings
	 *
	 * @param fontFeatureSettings
	 *          font feature settings represented as CSS compatible string
	 * @see #getFontFeatureSettings()
	 * @see android.graphics.Paint#getFontFeatureSettings
	 *
	 * @attr ref android.R.styleable#TextView_fontFeatureSettings
	 */
	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	public void setFontFeatureSettings(String fontFeatureSettings) {
		this.getObject().setFontFeatureSettings(fontFeatureSettings);
	}

	/**
	 * Control whether this text view saves its entire text contents when freezing
	 * to an icicle, in addition to dynamic state such as cursor position. By
	 * default this is false, not saving the text. Set to true if the text in the
	 * text view is not being saved somewhere else in persistent storage (such as
	 * in a content provider) so that if the view is later thawed the user will
	 * not lose their data.
	 *
	 * @param freezesText
	 *          Controls whether a frozen icicle should include the entire text
	 *          data: true to include it, false to not.
	 *
	 * @attr ref android.R.styleable#TextView_freezesText
	 */
	public void setFreezesText(boolean freezesText) {
		this.getObject().setFreezesText(freezesText);
	}

	/**
	 * Sets the horizontal alignment of the text and the vertical gravity that
	 * will be used when there is extra space in the TextView beyond what is
	 * required for the text itself.
	 *
	 * @see android.view.Gravity
	 * @attr ref android.R.styleable#TextView_gravity
	 */
	public void setGravity(int gravity) {
		this.getObject().setGravity(gravity);
	}

	/**
	 * Sets the color used to display the selection highlight.
	 *
	 * @attr ref android.R.styleable#TextView_textColorHighlight
	 */
	public void setHighlightColor(int color) {
		this.getObject().setHighlightColor(color);
	}

	/**
	 * Sets the text to be displayed when the text of the TextView is empty. Null
	 * means to use the normal empty text. The hint does not currently participate
	 * in determining the size of the view.
	 *
	 * @attr ref android.R.styleable#TextView_hint
	 */
	public final void setHint(CharSequence hint) {
		this.getObject().setHint(hint);
	}

	/**
	 * Sets the color of the hint text.
	 *
	 * @see #getHintTextColors()
	 * @see #setHintTextColor(int)
	 * @see #setTextColor(android.content.res.ColorStateList)
	 * @see #setLinkTextColor(android.content.res.ColorStateList)
	 *
	 * @attr ref android.R.styleable#TextView_textColorHint
	 */
	public final void setHintTextColor(ColorStateList colors) {
		this.getObject().setHintTextColor(colors);
	}

	/**
	 * Sets the color of the hint text for all the states (disabled, focussed,
	 * selected...) of this TextView.
	 *
	 * @see #setHintTextColor(android.content.res.ColorStateList)
	 * @see #getHintTextColors()
	 * @see #setTextColor(int)
	 *
	 * @attr ref android.R.styleable#TextView_textColorHint
	 */
	public final void setHintTextColor(int color) {
		this.getObject().setHintTextColor(color);
	}

	/**
	 * Sets whether the text should be allowed to be wider than the View is. If
	 * false, it will be wrapped to the width of the View.
	 *
	 * @attr ref android.R.styleable#TextView_scrollHorizontally
	 */
	public void setHorizontallyScrolling(boolean whether) {
		this.getObject().setHorizontallyScrolling(whether);
	}

	/**
	 * Change the custom IME action associated with the text view, which will be
	 * reported to an IME with
	 * {@link android.view.inputmethod.EditorInfo#actionLabel} and
	 * {@link android.view.inputmethod.EditorInfo#actionId} when it has focus.
	 * 
	 * @see #getImeActionLabel
	 * @see #getImeActionId
	 * @see android.view.inputmethod.EditorInfo
	 * @attr ref android.R.styleable#TextView_imeActionLabel
	 * @attr ref android.R.styleable#TextView_imeActionId
	 */
	public void setImeActionLabel(CharSequence label, int actionId) {
		this.getObject().setImeActionLabel(label, actionId);
	}

	/**
	 * Change the editor type integer associated with the text view, which will be
	 * reported to an IME with
	 * {@link android.view.inputmethod.EditorInfo#imeOptions} when it has focus.
	 * 
	 * @see #getImeOptions
	 * @see android.view.inputmethod.EditorInfo
	 * @attr ref android.R.styleable#TextView_imeOptions
	 */
	public void setImeOptions(int imeOptions) {
		this.getObject().setImeOptions(imeOptions);
	}

	/**
	 * Set whether the TextView includes extra top and bottom padding to make room
	 * for accents that go above the normal ascent and descent. The default is
	 * true.
	 *
	 * @see #getIncludeFontPadding()
	 *
	 * @attr ref android.R.styleable#TextView_includeFontPadding
	 */
	public void setIncludeFontPadding(boolean includepad) {
		this.getObject().setIncludeFontPadding(includepad);
	}
	/**
	 * Set the type of the content with a constant as defined for
	 * {@link android.view.inputmethod.EditorInfo#inputType}. This will take care
	 * of changing the key listener, by calling
	 * {@link #setKeyListener(android.text.method.KeyListener)}, to match the
	 * given content type. If the given content type is
	 * {@link android.view.inputmethod.EditorInfo#TYPE_NULL} then a soft keyboard
	 * will not be displayed for this text view.
	 *
	 * Note that the maximum number of displayed lines (see
	 * {@link #setMaxLines(int)}) will be modified if you change the
	 * {@link android.view.inputmethod.EditorInfo#TYPE_TEXT_FLAG_MULTI_LINE} flag
	 * of the input type.
	 *
	 * @see #getInputType()
	 * @see #setRawInputType(int)
	 * @see android.text.InputType
	 * @attr ref android.R.styleable#TextView_inputType
	 */
	public void setInputType(int type) {
		this.getObject().setInputType(type);
	}

	/**
	 * Sets text letter-spacing. The value is in 'EM' units. Typical values for
	 * slight expansion will be around 0.05. Negative values tighten text.
	 *
	 * @see #getLetterSpacing()
	 * @see android.graphics.Paint#getLetterSpacing
	 *
	 * @attr ref android.R.styleable#TextView_letterSpacing
	 */
	public void setLetterSpacing(float letterSpacing) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
			this.getObject().setLetterSpacing(letterSpacing);
	}

	/**
	 * Sets line spacing for this TextView. Each line will have its height
	 * multiplied by <code>mult</code> and have <code>add</code> added to it.
	 *
	 * @attr ref android.R.styleable#TextView_lineSpacingExtra
	 * @attr ref android.R.styleable#TextView_lineSpacingMultiplier
	 */
	public void setLineSpacing(float add, float mult) {
		this.getObject().setLineSpacing(add, mult);
	}

	/**
	 * Makes the TextView exactly this many lines tall.
	 *
	 * Note that setting this value overrides any other (minimum / maximum) number
	 * of lines or height setting. A single line TextView will set this value to
	 * 1.
	 *
	 * @attr ref android.R.styleable#TextView_lines
	 */
	public void setLines(int lines) {
		this.getObject().setLines(lines);
	}

	/**
	 * Sets the color of links in the text.
	 *
	 * @see #setLinkTextColor(int)
	 * @see #getLinkTextColors()
	 * @see #setTextColor(android.content.res.ColorStateList)
	 * @see #setHintTextColor(android.content.res.ColorStateList)
	 *
	 * @attr ref android.R.styleable#TextView_textColorLink
	 */
	public final void setLinkTextColor(ColorStateList colors) {
		this.getObject().setLinkTextColor(colors);
	}

	/**
	 * Sets the color of links in the text.
	 *
	 * @see #setLinkTextColor(int)
	 * @see #getLinkTextColors()
	 * @see #setTextColor(android.content.res.ColorStateList)
	 * @see #setHintTextColor(android.content.res.ColorStateList)
	 *
	 * @attr ref android.R.styleable#TextView_textColorLink
	 */
	public final void setLinkTextColor(int color) {
		this.getObject().setLinkTextColor(color);
	}

	/**
	 * Sets whether the movement method will automatically be set to
	 * {@link android.text.method.LinkMovementMethod} if {@link #setAutoLinkMask}
	 * has been set to nonzero and links are detected in {@link #setText}. The
	 * default is true.
	 *
	 * @attr ref android.R.styleable#TextView_linksClickable
	 */
	public final void setLinksClickable(boolean whether) {
		this.getObject().setLinksClickable(whether);
	}

	/**
	 * Sets how many times to repeat the marquee animation. Only applied if the
	 * TextView has marquee enabled. Set to -1 to repeat indefinitely.
	 *
	 * @see #getMarqueeRepeatLimit()
	 *
	 * @attr ref android.R.styleable#TextView_marqueeRepeatLimit
	 */
	public void setMarqueeRepeatLimit(int marqueeLimit) {
		this.getObject().setMarqueeRepeatLimit(marqueeLimit);
	}

	/**
	 * Makes the TextView at most this many ems wide
	 *
	 * @attr ref android.R.styleable#TextView_maxEms
	 */
	public void setMaxEms(int maxems) {
		this.getObject().setMaxEms(maxems);
	}

	/**
	 * Makes the TextView at most this many pixels tall. This option is mutually
	 * exclusive with the {@link #setMaxLines(int)} method.
	 *
	 * Setting this value overrides any other (maximum) number of lines setting.
	 *
	 * @attr ref android.R.styleable#TextView_maxHeight
	 */
	public void setMaxHeight(int maxHeight) {
		this.getObject().setMaxHeight(maxHeight);
	}

	/**
	 * Makes the TextView at most this many lines tall.
	 *
	 * Setting this value overrides any other (maximum) height setting.
	 *
	 * @attr ref android.R.styleable#TextView_maxLines
	 */
	public void setMaxLines(int maxlines) {
		this.getObject().setMaxLines(maxlines);
	}

	/**
	 * Makes the TextView at most this many pixels wide
	 *
	 * @attr ref android.R.styleable#TextView_maxWidth
	 */
	public void setMaxWidth(int maxpixels) {
		this.getObject().setMaxWidth(maxpixels);
	}

	/**
	 * Makes the TextView at least this many ems wide
	 *
	 * @attr ref android.R.styleable#TextView_minEms
	 */
	public void setMinEms(int minems) {
		this.getObject().setMinEms(minems);
	}

	/**
	 * Makes the TextView at least this many pixels tall.
	 *
	 * Setting this value overrides any other (minimum) number of lines setting.
	 *
	 * @attr ref android.R.styleable#TextView_minHeight
	 */
	public void setMinHeight(int minHeight) {
		this.getObject().setMinHeight(minHeight);
	}

	/**
	 * Makes the TextView at least this many lines tall.
	 *
	 * Setting this value overrides any other (minimum) height setting. A single
	 * line TextView will set this value to 1.
	 *
	 * @see #getMinLines()
	 *
	 * @attr ref android.R.styleable#TextView_minLines
	 */
	public void setMinLines(int minlines) {
		this.getObject().setMinLines(minlines);
	}

	/**
	 * Makes the TextView at least this many pixels wide
	 *
	 * @attr ref android.R.styleable#TextView_minWidth
	 */
	public void setMinWidth(int minpixels) {
		this.getObject().setMinWidth(minpixels);
	}

	/**
	 * Directly change the content type integer of the text view, without
	 * modifying any other state.
	 * 
	 * @see #setInputType(int)
	 * @see android.text.InputType
	 * @attr ref android.R.styleable#TextView_inputType
	 */
	public void setRawInputType(int type) {
		this.getObject().setRawInputType(type);
	}

	/**
	 * Set the TextView so that when it takes focus, all the text is selected.
	 *
	 * @attr ref android.R.styleable#TextView_selectAllOnFocus
	 */
	public void setSelectAllOnFocus(boolean selectAllOnFocus) {
		this.getObject().setSelectAllOnFocus(selectAllOnFocus);
	}


	/**
	 * Gives the text a shadow of the specified blur radius and color, the
	 * specified distance from its drawn position.
	 * <p>
	 * The text shadow produced does not interact with the properties on view that
	 * are responsible for real time shadows,
	 * {@link android.view.View#getElevation() elevation} and
	 * {@link android.view.View#getTranslationZ() translationZ}.
	 *
	 * @see android.graphics.Paint#setShadowLayer(float, float, float, int)
	 *
	 * @attr ref android.R.styleable#TextView_shadowColor
	 * @attr ref android.R.styleable#TextView_shadowDx
	 * @attr ref android.R.styleable#TextView_shadowDy
	 * @attr ref android.R.styleable#TextView_shadowRadius
	 */
	public void setShadowLayer(float radius, float dx, float dy, int color) {
		this.getObject().setShadowLayer(radius, dx, dy, color);
	}

	/**
	 * Sets whether the soft input method will be made visible when this TextView
	 * gets focused. The default is true.
	 */
	public final void setShowSoftInputOnFocus(boolean show) {
		this.getObject().setShowSoftInputOnFocus(show);
	}

	/**
	 * Sets the properties of this field (lines, horizontally scrolling,
	 * transformation method) to be for a single-line input.
	 *
	 * @attr ref android.R.styleable#TextView_singleLine
	 */
	public void setSingleLine() {
		this.getObject().setSingleLine();
	}

	
	/**
	 * Sets the text color.
	 *
	 * @see #setTextColor(int)
	 * @see #getTextColors()
	 * @see #setHintTextColor(android.content.res.ColorStateList)
	 * @see #setLinkTextColor(android.content.res.ColorStateList)
	 *
	 * @attr ref android.R.styleable#TextView_textColor
	 */
	public void setTextColor(ColorStateList colors) {
		this.getObject().setTextColor(colors);
	}

	/**
	 * Sets the text color for all the states (normal, selected, focused) to be
	 * this color.
	 *
	 * @see #setTextColor(android.content.res.ColorStateList)
	 * @see #getTextColors()
	 *
	 * @attr ref android.R.styleable#TextView_textColor
	 */
	public void setTextColor(int color) {
		this.getObject().setTextColor(color);
	}

	/**
	 * Sets whether the content of this view is selectable by the user. The
	 * default is {@code false}, meaning that the content is not selectable.
	 * <p>
	 * When you use a TextView to display a useful piece of information to the
	 * user (such as a contact's address), make it selectable, so that the user
	 * can select and copy its content. You can also use set the XML attribute
	 * {@link android.R.styleable#TextView_textIsSelectable} to "true".
	 * <p>
	 * When you call this method to set the value of {@code textIsSelectable}, it
	 * sets the flags {@code focusable}, {@code focusableInTouchMode},
	 * {@code clickable}, and {@code longClickable} to the same value. These flags
	 * correspond to the attributes {@link android.R.styleable#View_focusable
	 * android:focusable}, {@link android.R.styleable#View_focusableInTouchMode
	 * android:focusableInTouchMode}, {@link android.R.styleable#View_clickable
	 * android:clickable}, and {@link android.R.styleable#View_longClickable
	 * android:longClickable}. To restore any of these flags to a state you had
	 * set previously, call one or more of the following methods:
	 * {@link #setFocusable(boolean) setFocusable()},
	 * {@link #setFocusableInTouchMode(boolean) setFocusableInTouchMode()},
	 * {@link #setClickable(boolean) setClickable()} or
	 * {@link #setLongClickable(boolean) setLongClickable()}.
	 *
	 * @param selectable
	 *          Whether the content of this TextView should be selectable.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public void setTextIsSelectable(boolean selectable) {
		this.getObject().setTextIsSelectable(selectable);
	}

	/**
	 * Like {@link #setText(CharSequence)}, except that the cursor position (if
	 * any) is retained in the new text.
	 *
	 * @param text
	 *          The new text to place in the text view.
	 *
	 * @see #setText(CharSequence)
	 */
	public final void setTextKeepState(CharSequence text) {
		this.getObject().setTextKeepState(text);
	}

	/**
	 * Set the default {@link java.util.Locale} of the text in this TextView to
	 * the given value. This value is used to choose appropriate typefaces for
	 * ambiguous characters. Typically used for CJK locales to disambiguate
	 * Hanzi/Kanji/Hanja characters.
	 *
	 * @param locale
	 *          the {@link java.util.Locale} for drawing text, must not be null.
	 *
	 * @see android.graphics.Paint#setTextLocale
	 */
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
	public void setTextLocale(Locale locale) {
		this.getObject().setTextLocale(locale);
	}

	/**
	 * Sets the extent by which text should be stretched horizontally.
	 *
	 * @attr ref android.R.styleable#TextView_textScaleX
	 */
	public void setTextScaleX(float size) {
		this.getObject().setTextScaleX(size);
	}

	/**
	 * Set the default text size to the given value, interpreted as "scaled pixel"
	 * units. This size is adjusted based on the current density and user font
	 * size preference.
	 *
	 * @param size
	 *          The scaled pixel size.
	 *
	 * @attr ref android.R.styleable#TextView_textSize
	 */
	public void setTextSize(float size) {
		this.getObject().setTextSize(size);
	}

	/**
	 * Sets the typeface and style in which the text should be displayed, and
	 * turns on the fake bold and italic bits in the Paint if the Typeface that
	 * you provided does not have all the bits in the style that you specified.
	 *
	 * @attr ref android.R.styleable#TextView_typeface
	 * @attr ref android.R.styleable#TextView_textStyle
	 */
	public void setTypeface2(Typeface tf, int style) {
		this.getObject().setTypeface(tf, style);
	}

	/**
	 * Sets the typeface and style in which the text should be displayed. Note
	 * that not all Typeface families actually have bold and italic variants, so
	 * you may need to use {@link #setTypeface(android.graphics.Typeface, int)} to
	 * get the appearance that you actually want.
	 *
	 * @see #getTypeface()
	 *
	 * @attr ref android.R.styleable#TextView_fontFamily
	 * @attr ref android.R.styleable#TextView_typeface
	 * @attr ref android.R.styleable#TextView_textStyle
	 */
	public void setTypeface(Typeface tf) {
		this.getObject().setTypeface(tf);
	}

	
	public boolean canCut() {
		return this.getObject().canCut();
	}

	public boolean canCopy() {
		return this.getObject().canCopy();
	}

	public boolean canPaste() {
		return this.getObject().canPaste();
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
