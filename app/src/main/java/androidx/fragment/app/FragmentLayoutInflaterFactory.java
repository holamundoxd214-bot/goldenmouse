package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater$Factory2;
import android.view.View$OnAttachStateChangeListener;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R$styleable;

class FragmentLayoutInflaterFactory implements LayoutInflater$Factory2 {
    private static final String TAG = "FragmentManager";
    final FragmentManager mFragmentManager;

    FragmentLayoutInflaterFactory(FragmentManager arg1) {
        super();
        this.mFragmentManager = arg1;
    }

    public View onCreateView(View arg9, String arg10, Context arg11, AttributeSet arg12) {
        FragmentStateManager v11_1;
        Fragment v0_1;
        if(FragmentContainerView.class.getName().equals(arg10)) {
            return new FragmentContainerView(arg11, arg12, this.mFragmentManager);
        }

        View v0 = null;
        if(!"fragment".equals(arg10)) {
            return v0;
        }

        arg10 = arg12.getAttributeValue(((String)v0), "class");
        TypedArray v1 = arg11.obtainStyledAttributes(arg12, styleable.Fragment);
        if(arg10 == null) {
            arg10 = v1.getString(styleable.Fragment_android_name);
        }

        int v3 = -1;
        int v2 = v1.getResourceId(styleable.Fragment_android_id, v3);
        String v4 = v1.getString(styleable.Fragment_android_tag);
        v1.recycle();
        if(arg10 != null) {
            if(!FragmentFactory.isFragmentClass(arg11.getClassLoader(), arg10)) {
            }
            else {
                int v1_1 = arg9 != null ? arg9.getId() : 0;
                if(v1_1 == v3 && v2 == v3) {
                    if(v4 != null) {
                    }
                    else {
                        throw new IllegalArgumentException(arg12.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + arg10);
                    }
                }

                if(v2 != v3) {
                    v0_1 = this.mFragmentManager.findFragmentById(v2);
                }

                if((((Fragment)v0)) == null && v4 != null) {
                    v0_1 = this.mFragmentManager.findFragmentByTag(v4);
                }

                if((((Fragment)v0)) == null && v1_1 != v3) {
                    v0_1 = this.mFragmentManager.findFragmentById(v1_1);
                }

                String v3_1 = "Fragment ";
                String v5 = "FragmentManager";
                int v6 = 2;
                if((((Fragment)v0)) == null) {
                    v0_1 = this.mFragmentManager.getFragmentFactory().instantiate(arg11.getClassLoader(), arg10);
                    v0_1.mFromLayout = true;
                    int v11 = v2 != 0 ? v2 : v1_1;
                    v0_1.mFragmentId = v11;
                    v0_1.mContainerId = v1_1;
                    v0_1.mTag = v4;
                    v0_1.mInLayout = true;
                    v0_1.mFragmentManager = this.mFragmentManager;
                    v0_1.mHost = this.mFragmentManager.getHost();
                    v0_1.onInflate(this.mFragmentManager.getHost().getContext(), arg12, v0_1.mSavedFragmentState);
                    v11_1 = this.mFragmentManager.addFragment(v0_1);
                    if(!FragmentManager.isLoggingEnabled(v6)) {
                        goto label_130;
                    }

                    Log.v(v5, v3_1 + v0_1 + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(v2));
                }
                else {
                    if(((Fragment)v0).mInLayout) {
                        goto label_158;
                    }

                    ((Fragment)v0).mInLayout = true;
                    ((Fragment)v0).mFragmentManager = this.mFragmentManager;
                    ((Fragment)v0).mHost = this.mFragmentManager.getHost();
                    ((Fragment)v0).onInflate(this.mFragmentManager.getHost().getContext(), arg12, ((Fragment)v0).mSavedFragmentState);
                    v11_1 = this.mFragmentManager.createOrGetFragmentStateManager(((Fragment)v0));
                    if(!FragmentManager.isLoggingEnabled(v6)) {
                        goto label_130;
                    }

                    Log.v(v5, "Retained Fragment " + v0 + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(v2));
                }

            label_130:
                ((Fragment)v0).mContainer = ((ViewGroup)arg9);
                v11_1.moveToExpectedState();
                v11_1.ensureInflatedView();
                if(((Fragment)v0).mView != null) {
                    if(v2 != 0) {
                        ((Fragment)v0).mView.setId(v2);
                    }

                    if(((Fragment)v0).mView.getTag() == null) {
                        ((Fragment)v0).mView.setTag(v4);
                    }

                    ((Fragment)v0).mView.addOnAttachStateChangeListener(new View$OnAttachStateChangeListener(v11_1) {
                        public void onViewAttachedToWindow(View arg2) {
                            Fragment v2 = this.val$fragmentStateManager.getFragment();
                            this.val$fragmentStateManager.moveToExpectedState();
                            SpecialEffectsController.getOrCreateController(v2.mView.getParent(), FragmentLayoutInflaterFactory.this.mFragmentManager).forceCompleteAllOperations();
                        }

                        public void onViewDetachedFromWindow(View arg1) {
                        }
                    });
                    return ((Fragment)v0).mView;
                }

                throw new IllegalStateException(v3_1 + arg10 + " did not create a view.");
            label_158:
                throw new IllegalArgumentException(arg12.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(v2) + ", tag " + v4 + ", or parent id 0x" + Integer.toHexString(v1_1) + " with another fragment for " + arg10);
            }
        }

        return v0;
    }

    public View onCreateView(String arg2, Context arg3, AttributeSet arg4) {
        return this.onCreateView(null, arg2, arg3, arg4);
    }
}

