package com.slidingmenu.lib;

import android.view.animation.Interpolator;

public class WiggleInterpolator implements Interpolator {

	private final float mWiggleCount;
	private boolean mReached = false;
	
	public WiggleInterpolator(int wiggleCount) {
		mWiggleCount = wiggleCount;
	}
	
	@Override
	public float getInterpolation(float paramFloat) {
		mReached = paramFloat==1.0f;
		
		paramFloat = mWiggleCount*paramFloat % 1.0f;
		
		if (paramFloat==1.0f)
			return 0;

		if (paramFloat > 0.5f)
			return 1.0f - (float) (Math.sin((paramFloat-0.5f)*Math.PI)*Math.sin((paramFloat-0.5f)*Math.PI));
		return (float) (Math.sin(paramFloat*Math.PI)*Math.sin(paramFloat*Math.PI));
	}
	
	public boolean endReached() {
		return mReached;
	}

	public void setEndReached(boolean set) {
		mReached = set;
	}

}
