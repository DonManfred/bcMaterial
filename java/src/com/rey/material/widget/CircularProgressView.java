package com.rey.material.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;

import com.rey.material.R;
import com.rey.material.drawable.CircularProgressDrawable;
import com.rey.material.drawable.LinearProgressDrawable;

public class CircularProgressView extends View {

	private boolean mAutostart;
	private boolean mCircular;
	private int mProgressId;
	private int[] mColors;

	public static final int MODE_DETERMINATE = 0;
	public static final int MODE_INDETERMINATE = 1;
	public static final int MODE_BUFFER = 2;
	public static final int MODE_QUERY = 3;

	private Drawable mProgressDrawable;

	public CircularProgressView(Context context) {
		this(context, null, 0, 0);
	}

	public CircularProgressView(Context context, AttributeSet attrs) {
		this(context, attrs, 0, 0);
	}

	public CircularProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
		this(context, attrs, defStyleAttr, 0);
	}

	@SuppressWarnings("deprecation")
	@TargetApi(android.os.Build.VERSION_CODES.JELLY_BEAN)
	public CircularProgressView(Context context, AttributeSet attrs, int defStyleAttr,
			int defStyleRes) {
		super(context, attrs, defStyleAttr);

		init(context, attrs, defStyleAttr, defStyleRes);
	}

	private void init(Context context, AttributeSet attrs, int defStyleAttr,
			int defStyleRes) {
		applyStyle(context, attrs, defStyleAttr, defStyleRes);
	}

	public void applyStyle(int resId) {
		applyStyle(getContext(), null, 0, resId);
	}

	private void applyStyle(Context context, AttributeSet attrs,
			int defStyleAttr, int defStyleRes) {
		TypedArray a = context.obtainStyledAttributes(attrs,
				R.styleable.ProgressView, defStyleAttr, defStyleRes);
		mAutostart = a.getBoolean(R.styleable.ProgressView_pv_autostart, true);
		mCircular = true;
		mProgressId = R.style.Material_Drawable_CircularProgress;
		mProgressDrawable = new CircularProgressDrawable.Builder(context,mProgressId).build();
		if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN)
			setBackground(mProgressDrawable);
		else
			setBackgroundDrawable(mProgressDrawable);
	}

	public boolean isAutostart() {
		return mAutostart;
	}

	public void setAutostart(boolean Autostart) {
		this.mAutostart = Autostart;
	}

	public int getProgressId() {
		return mProgressId;
	}

	public void setProgressId(int ProgressId) {
		this.mProgressId = ProgressId;
	}

	public Drawable getProgressDrawable() {
		return mProgressDrawable;
	}

	public void setProgressDrawable(Drawable ProgressDrawable) {
		this.mProgressDrawable = ProgressDrawable;
	}

	@Override
	public void setVisibility(int v) {
		if (getVisibility() != v) {
			super.setVisibility(v);
			if (getProgressMode() == MODE_INDETERMINATE && mAutostart) {
				if (v == GONE || v == INVISIBLE)
					stop();
				else
					start();
			}
		}
	}

	@Override
	protected void onVisibilityChanged(@NonNull View changedView, int visibility) {
		super.onVisibilityChanged(changedView, visibility);

		if (getProgressMode() == MODE_INDETERMINATE && mAutostart) {
			if (visibility == GONE || visibility == INVISIBLE)
				stop();
			else
				start();
		}
	}

	@Override
	protected void onAttachedToWindow() {
		super.onAttachedToWindow();
		if (getProgressMode() == MODE_INDETERMINATE && mAutostart)
			start();
	}

	@Override
	protected void onDetachedFromWindow() {
		if (getProgressMode() == MODE_INDETERMINATE && mAutostart)
			stop();

		super.onDetachedFromWindow();
	}

	public int getProgressMode() {
		return ((CircularProgressDrawable) mProgressDrawable).getProgressMode();
	}

	public float getProgress() {
		return ((CircularProgressDrawable) mProgressDrawable).getProgress();
	}

	public float getSecondaryProgress() {
		return ((CircularProgressDrawable) mProgressDrawable).getSecondaryProgress();
	}

	public void setProgress(float percent) {
		((CircularProgressDrawable) mProgressDrawable).setProgress(percent);
	}

	public void setSecondaryProgress(float percent) {
		((CircularProgressDrawable) mProgressDrawable).setSecondaryProgress(percent);
	}

	public void start() {
		if (mProgressDrawable != null)
			((Animatable) mProgressDrawable).start();
	}

	public void stop() {
		if (mProgressDrawable != null)
			((Animatable) mProgressDrawable).stop();
	}

	/**
	 * @return the mColors
	 */
	public int[] getColors() {
		return mColors;
	}

	/**
	 * @param mColors the mColors to set
	 */
	public void setColors(int[] Colors) {
		this.mColors = Colors;
	}

}
