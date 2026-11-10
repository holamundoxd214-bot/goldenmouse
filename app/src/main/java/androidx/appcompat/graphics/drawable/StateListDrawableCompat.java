package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.resources.Compatibility$Api21Impl;
import androidx.appcompat.resources.R$styleable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.res.TypedArrayUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class StateListDrawableCompat extends DrawableContainerCompat {
    class StateListState extends DrawableContainerState {
        int[][] mStateSets;

        StateListState(StateListState arg1, StateListDrawableCompat arg2, Resources arg3) {
            super(((DrawableContainerState)arg1), ((DrawableContainerCompat)arg2), arg3);
            if(arg1 != null) {
                this.mStateSets = arg1.mStateSets;
                return;
            }

            this.mStateSets = new int[this.getCapacity()][];
        }

        int addStateSet(int[] arg1, Drawable arg2) {
            int v2 = this.addChild(arg2);
            this.mStateSets[v2] = arg1;
            return v2;
        }

        public void growArray(int arg3, int arg4) {
            super.growArray(arg3, arg4);
            int[][] v4 = new int[arg4][];
            System.arraycopy(this.mStateSets, 0, v4, 0, arg3);
            this.mStateSets = v4;
        }

        int indexOfStateSet(int[] arg4) {
            int[][] v0 = this.mStateSets;
            int v3 = this.getChildCount();
            int v1;
            for(v1 = 0; v1 < v3; ++v1) {
                if(StateSet.stateSetMatches(v0[v1], arg4)) {
                    return v1;
                }
            }

            return -1;
        }

        void mutate() {
            int[][] v0 = this.mStateSets;
            int[][] v1 = new int[v0.length][];
            int v0_1;
            for(v0_1 = v0.length - 1; v0_1 >= 0; --v0_1) {
                int[] v2 = this.mStateSets[v0_1];
                if(v2 != null) {
                    Object v2_1 = v2.clone();
                }
                else {
                    v2 = null;
                }

                v1[v0_1] = v2;
            }

            this.mStateSets = v1;
        }

        public Drawable newDrawable() {
            return new StateListDrawableCompat(this, null);
        }

        public Drawable newDrawable(Resources arg2) {
            return new StateListDrawableCompat(this, arg2);
        }
    }

    private static final boolean DEBUG = false;
    private static final String TAG = "StateListDrawableCompat";
    private boolean mMutated;
    private StateListState mStateListState;

    public StateListDrawableCompat() {
        this(null, null);
    }

    StateListDrawableCompat(StateListState arg2, Resources arg3) {
        super();
        this.setConstantState(new StateListState(arg2, this, arg3));
        this.onStateChange(this.getState());
    }

    StateListDrawableCompat(StateListState arg1) {
        super();
        if(arg1 != null) {
            this.setConstantState(((DrawableContainerState)arg1));
        }
    }

    public void addState(int[] arg2, Drawable arg3) {
        if(arg3 != null) {
            this.mStateListState.addStateSet(arg2, arg3);
            this.onStateChange(this.getState());
        }
    }

    public void applyTheme(Resources$Theme arg1) {
        super.applyTheme(arg1);
        this.onStateChange(this.getState());
    }

    void clearMutated() {
        super.clearMutated();
        this.mMutated = false;
    }

    DrawableContainerState cloneConstantState() {
        return this.cloneConstantState();
    }

    StateListState cloneConstantState() {
        return new StateListState(this.mStateListState, this, null);
    }

    int[] extractStateSet(AttributeSet arg8) {
        int v7 = arg8.getAttributeCount();
        int[] v0 = new int[v7];
        int v2 = 0;
        int v3 = 0;
        while(v2 < v7) {
            int v4 = arg8.getAttributeNameResource(v2);
            if(v4 != 0 && v4 != 0x10100D0 && v4 != 0x1010199) {
                int v5 = v3 + 1;
                if(arg8.getAttributeBooleanValue(v2, false)) {
                }
                else {
                    v4 = -v4;
                }

                v0[v3] = v4;
                v3 = v5;
            }

            ++v2;
        }

        return StateSet.trimStateSet(v0, v3);
    }

    int getStateCount() {
        return this.mStateListState.getChildCount();
    }

    Drawable getStateDrawable(int arg1) {
        return this.mStateListState.getChild(arg1);
    }

    int getStateDrawableIndex(int[] arg1) {
        return this.mStateListState.indexOfStateSet(arg1);
    }

    StateListState getStateListState() {
        return this.mStateListState;
    }

    int[] getStateSet(int arg1) {
        return this.mStateListState.mStateSets[arg1];
    }

    public void inflate(Context arg4, Resources arg5, XmlPullParser arg6, AttributeSet arg7, Resources$Theme arg8) throws XmlPullParserException, IOException {
        TypedArray v0 = TypedArrayUtils.obtainAttributes(arg5, arg8, arg7, styleable.StateListDrawable);
        this.setVisible(v0.getBoolean(styleable.StateListDrawable_android_visible, true), true);
        this.updateStateFromTypedArray(v0);
        this.updateDensity(arg5);
        v0.recycle();
        this.inflateChildElements(arg4, arg5, arg6, arg7, arg8);
        this.onStateChange(this.getState());
    }

    private void inflateChildElements(Context arg8, Resources arg9, XmlPullParser arg10, AttributeSet arg11, Resources$Theme arg12) throws XmlPullParserException, IOException {
        int v4;
        StateListState v0 = this.mStateListState;
        int v1 = arg10.getDepth() + 1;
        while(true) {
        label_4:
            int v3 = arg10.next();
            if(v3 != 1) {
                v4 = arg10.getDepth();
                if(v4 < v1 && v3 == 3) {
                    return;
                }

                int v5 = 2;
                if(v3 != v5) {
                    continue;
                }

                if(v4 > v1) {
                    continue;
                }

                if(arg10.getName().equals("item")) {
                    break;
                }

                continue;
            }

            return;
        }

        TypedArray v3_1 = TypedArrayUtils.obtainAttributes(arg9, arg12, arg11, styleable.StateListDrawableItem);
        v4 = v3_1.getResourceId(styleable.StateListDrawableItem_android_drawable, -1);
        Drawable v4_1 = v4 > 0 ? ResourceManagerInternal.get().getDrawable(arg8, v4) : null;
        v3_1.recycle();
        int[] v3_2 = this.extractStateSet(arg11);
        if(v4_1 != null) {
            goto label_49;
        }

        goto label_32;
        return;
        while(true) {
        label_32:
            v4 = arg10.next();
            if(v4 != 4) {
                break;
            }
        }

        if(v4 == v5) {
            v4_1 = Api21Impl.createFromXmlInner(arg9, arg10, arg11, arg12);
        }
        else {
            throw new XmlPullParserException(arg10.getPositionDescription() + ": <item> tag requires a \'drawable\' attribute or child tag defining a drawable");
        }

    label_49:
        v0.addStateSet(v3_2, v4_1);
        goto label_4;
    }

    public boolean isStateful() {
        return 1;
    }

    public Drawable mutate() {
        if(!this.mMutated && super.mutate() == this) {
            this.mStateListState.mutate();
            this.mMutated = true;
        }

        return this;
    }

    protected boolean onStateChange(int[] arg3) {
        boolean v0 = super.onStateChange(arg3);
        int v3 = this.mStateListState.indexOfStateSet(arg3);
        if(v3 < 0) {
            v3 = this.mStateListState.indexOfStateSet(StateSet.WILD_CARD);
        }

        if(!this.selectDrawable(v3)) {
            if(v0) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    void setConstantState(DrawableContainerState arg2) {
        super.setConstantState(arg2);
        if((arg2 instanceof StateListState)) {
            this.mStateListState = ((StateListState)arg2);
        }
    }

    private void updateStateFromTypedArray(TypedArray arg3) {
        StateListState v2 = this.mStateListState;
        v2.mChangingConfigurations |= Api21Impl.getChangingConfigurations(arg3);
        v2.mVariablePadding = arg3.getBoolean(styleable.StateListDrawable_android_variablePadding, v2.mVariablePadding);
        v2.mConstantSize = arg3.getBoolean(styleable.StateListDrawable_android_constantSize, v2.mConstantSize);
        v2.mEnterFadeDuration = arg3.getInt(styleable.StateListDrawable_android_enterFadeDuration, v2.mEnterFadeDuration);
        v2.mExitFadeDuration = arg3.getInt(styleable.StateListDrawable_android_exitFadeDuration, v2.mExitFadeDuration);
        v2.mDither = arg3.getBoolean(styleable.StateListDrawable_android_dither, v2.mDither);
    }
}

