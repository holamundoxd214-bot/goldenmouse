package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View$OnApplyWindowInsetsListener;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.R$styleable;
import java.util.ArrayList;

public final class FragmentContainerView extends FrameLayout {
    private View$OnApplyWindowInsetsListener mApplyWindowInsetsListener;
    private ArrayList mDisappearingFragmentChildren;
    private boolean mDrawDisappearingViewsFirst;
    private ArrayList mTransitioningFragmentViews;

    public FragmentContainerView(Context arg1) {
        super(arg1);
        this.mDrawDisappearingViewsFirst = true;
    }

    public FragmentContainerView(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, 0);
    }

    public FragmentContainerView(Context arg2, AttributeSet arg3, int arg4) {
        String v3;
        super(arg2, arg3, arg4);
        this.mDrawDisappearingViewsFirst = true;
        if(arg3 != null) {
            String v4 = arg3.getClassAttribute();
            TypedArray v2 = arg2.obtainStyledAttributes(arg3, styleable.FragmentContainerView);
            if(v4 == null) {
                v4 = v2.getString(styleable.FragmentContainerView_android_name);
                v3 = "android:name";
            }
            else {
                v3 = "class";
            }

            v2.recycle();
            if(v4 == null) {
                return;
            }

            if(this.isInEditMode()) {
                return;
            }

            throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + v3 + "=\"" + v4 + "\"");
        }
    }

    FragmentContainerView(Context arg6, AttributeSet arg7, FragmentManager arg8) {
        super(arg6, arg7);
        this.mDrawDisappearingViewsFirst = true;
        String v1 = arg7.getClassAttribute();
        TypedArray v2 = arg6.obtainStyledAttributes(arg7, styleable.FragmentContainerView);
        if(v1 == null) {
            v1 = v2.getString(styleable.FragmentContainerView_android_name);
        }

        String v3 = v2.getString(styleable.FragmentContainerView_android_tag);
        v2.recycle();
        int v2_1 = this.getId();
        Fragment v4 = arg8.findFragmentById(v2_1);
        if(v1 != null && v4 == null) {
            if(v2_1 <= 0) {
                String v5 = v3 != null ? " with tag " + v3 : "";
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + v1 + v5);
            }
            else {
                Fragment v1_1 = arg8.getFragmentFactory().instantiate(arg6.getClassLoader(), v1);
                v1_1.onInflate(arg6, arg7, null);
                arg8.beginTransaction().setReorderingAllowed(true).add(((ViewGroup)this), v1_1, v3).commitNowAllowingStateLoss();
            }
        }

        arg8.onContainerAvailable(this);
    }

    private void addDisappearingFragmentView(View arg2) {
        ArrayList v0 = this.mTransitioningFragmentViews;
        if(v0 != null && (v0.contains(arg2))) {
            v0 = this.mDisappearingFragmentChildren;
            if(v0 == null) {
                v0 = new ArrayList();
                this.mDisappearingFragmentChildren = v0;
            }

            v0.add(arg2);
        }
    }

    public void addView(View arg2, int arg3, ViewGroup$LayoutParams arg4) {
        if(FragmentManager.getViewFragment(arg2) != null) {
            super.addView(arg2, arg3, arg4);
            return;
        }

        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + arg2 + " is not associated with a Fragment.");
    }

    protected boolean addViewInLayout(View arg2, int arg3, ViewGroup$LayoutParams arg4, boolean arg5) {
        if(FragmentManager.getViewFragment(arg2) != null) {
            return super.addViewInLayout(arg2, arg3, arg4, arg5);
        }

        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + arg2 + " is not associated with a Fragment.");
    }

    public WindowInsets dispatchApplyWindowInsets(WindowInsets arg5) {
        WindowInsetsCompat v0 = WindowInsetsCompat.toWindowInsetsCompat(arg5);
        View$OnApplyWindowInsetsListener v1 = this.mApplyWindowInsetsListener;
        v0 = v1 != null ? WindowInsetsCompat.toWindowInsetsCompat(v1.onApplyWindowInsets(((View)this), arg5)) : ViewCompat.onApplyWindowInsets(((View)this), v0);
        if(!v0.isConsumed()) {
            int v1_1 = this.getChildCount();
            int v2;
            for(v2 = 0; v2 < v1_1; ++v2) {
                ViewCompat.dispatchApplyWindowInsets(this.getChildAt(v2), v0);
            }
        }

        return arg5;
    }

    protected void dispatchDraw(Canvas arg5) {
        if((this.mDrawDisappearingViewsFirst) && this.mDisappearingFragmentChildren != null) {
            int v0;
            for(v0 = 0; v0 < this.mDisappearingFragmentChildren.size(); ++v0) {
                super.drawChild(arg5, this.mDisappearingFragmentChildren.get(v0), this.getDrawingTime());
            }
        }

        super.dispatchDraw(arg5);
    }

    protected boolean drawChild(Canvas arg2, View arg3, long arg4) {
        if(this.mDrawDisappearingViewsFirst) {
            ArrayList v0 = this.mDisappearingFragmentChildren;
            if(v0 != null && v0.size() > 0 && (this.mDisappearingFragmentChildren.contains(arg3))) {
                return 0;
            }
        }

        return super.drawChild(arg2, arg3, arg4);
    }

    public void endViewTransition(View arg2) {
        ArrayList v0 = this.mTransitioningFragmentViews;
        if(v0 != null) {
            v0.remove(arg2);
            v0 = this.mDisappearingFragmentChildren;
            if(v0 != null && (v0.remove(arg2))) {
                this.mDrawDisappearingViewsFirst = true;
            }
        }

        super.endViewTransition(arg2);
    }

    public WindowInsets onApplyWindowInsets(WindowInsets arg1) {
        return arg1;
    }

    public void removeAllViewsInLayout() {
        int v0;
        for(v0 = this.getChildCount() - 1; v0 >= 0; --v0) {
            this.addDisappearingFragmentView(this.getChildAt(v0));
        }

        super.removeAllViewsInLayout();
    }

    protected void removeDetachedView(View arg1, boolean arg2) {
        if(arg2) {
            this.addDisappearingFragmentView(arg1);
        }

        super.removeDetachedView(arg1, arg2);
    }

    public void removeView(View arg1) {
        this.addDisappearingFragmentView(arg1);
        super.removeView(arg1);
    }

    public void removeViewAt(int arg2) {
        this.addDisappearingFragmentView(this.getChildAt(arg2));
        super.removeViewAt(arg2);
    }

    public void removeViewInLayout(View arg1) {
        this.addDisappearingFragmentView(arg1);
        super.removeViewInLayout(arg1);
    }

    public void removeViews(int arg3, int arg4) {
        int v0;
        for(v0 = arg3; v0 < arg3 + arg4; ++v0) {
            this.addDisappearingFragmentView(this.getChildAt(v0));
        }

        super.removeViews(arg3, arg4);
    }

    public void removeViewsInLayout(int arg3, int arg4) {
        int v0;
        for(v0 = arg3; v0 < arg3 + arg4; ++v0) {
            this.addDisappearingFragmentView(this.getChildAt(v0));
        }

        super.removeViewsInLayout(arg3, arg4);
    }

    void setDrawDisappearingViewsLast(boolean arg1) {
        this.mDrawDisappearingViewsFirst = arg1;
    }

    public void setLayoutTransition(LayoutTransition arg1) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    public void setOnApplyWindowInsetsListener(View$OnApplyWindowInsetsListener arg1) {
        this.mApplyWindowInsetsListener = arg1;
    }

    public void startViewTransition(View arg2) {
        if(arg2.getParent() == this) {
            ArrayList v0 = this.mTransitioningFragmentViews;
            if(v0 == null) {
                v0 = new ArrayList();
                this.mTransitioningFragmentViews = v0;
            }

            v0.add(arg2);
        }

        super.startViewTransition(arg2);
    }
}

