package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable$Callback;
import android.graphics.drawable.Drawable$ConstantState;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.core.graphics.drawable.DrawableCompat;

public class DrawableContainerCompat extends Drawable implements Drawable$Callback {
    class Api21Impl {
        private Api21Impl() {
            super();
        }

        public static boolean canApplyTheme(Drawable$ConstantState arg0) {
            return arg0.canApplyTheme();
        }

        public static void getOutline(Drawable arg0, Outline arg1) {
            arg0.getOutline(arg1);
        }

        public static Resources getResources(Resources$Theme arg0) {
            return arg0.getResources();
        }
    }

    class BlockInvalidateCallback implements Drawable$Callback {
        private Drawable$Callback mCallback;

        BlockInvalidateCallback() {
            super();
        }

        public void invalidateDrawable(Drawable arg1) {
        }

        public void scheduleDrawable(Drawable arg1, Runnable arg2, long arg3) {
            Drawable$Callback v0 = this.mCallback;
            if(v0 != null) {
                v0.scheduleDrawable(arg1, arg2, arg3);
            }
        }

        public void unscheduleDrawable(Drawable arg1, Runnable arg2) {
            Drawable$Callback v0 = this.mCallback;
            if(v0 != null) {
                v0.unscheduleDrawable(arg1, arg2);
            }
        }

        public Drawable$Callback unwrap() {
            Drawable$Callback v0 = this.mCallback;
            this.mCallback = null;
            return v0;
        }

        public BlockInvalidateCallback wrap(Drawable$Callback arg1) {
            this.mCallback = arg1;
            return this;
        }
    }

    abstract class DrawableContainerState extends Drawable$ConstantState {
        boolean mAutoMirrored;
        boolean mCanConstantState;
        int mChangingConfigurations;
        boolean mCheckedConstantSize;
        boolean mCheckedConstantState;
        boolean mCheckedOpacity;
        boolean mCheckedPadding;
        boolean mCheckedStateful;
        int mChildrenChangingConfigurations;
        ColorFilter mColorFilter;
        int mConstantHeight;
        int mConstantMinimumHeight;
        int mConstantMinimumWidth;
        Rect mConstantPadding;
        boolean mConstantSize;
        int mConstantWidth;
        int mDensity;
        boolean mDither;
        SparseArray mDrawableFutures;
        Drawable[] mDrawables;
        int mEnterFadeDuration;
        int mExitFadeDuration;
        boolean mHasColorFilter;
        boolean mHasTintList;
        boolean mHasTintMode;
        int mLayoutDirection;
        boolean mMutated;
        int mNumChildren;
        int mOpacity;
        final DrawableContainerCompat mOwner;
        Resources mSourceRes;
        boolean mStateful;
        ColorStateList mTintList;
        PorterDuff$Mode mTintMode;
        boolean mVariablePadding;

        DrawableContainerState(DrawableContainerState arg4, DrawableContainerCompat arg5, Resources arg6) {
            Resources v2;
            super();
            int v0 = 0;
            this.mVariablePadding = false;
            this.mConstantSize = false;
            this.mDither = true;
            this.mEnterFadeDuration = 0;
            this.mExitFadeDuration = 0;
            this.mOwner = arg5;
            Rect v5 = null;
            if(arg6 != null) {
                v2 = arg6;
            }
            else if(arg4 != null) {
                v2 = arg4.mSourceRes;
            }
            else {
                v2 = ((Resources)v5);
            }

            this.mSourceRes = v2;
            int v2_1 = arg4 != null ? arg4.mDensity : 0;
            int v6 = DrawableContainerCompat.resolveDensity(arg6, v2_1);
            this.mDensity = v6;
            if(arg4 != null) {
                this.mChangingConfigurations = arg4.mChangingConfigurations;
                this.mChildrenChangingConfigurations = arg4.mChildrenChangingConfigurations;
                this.mCheckedConstantState = true;
                this.mCanConstantState = true;
                this.mVariablePadding = arg4.mVariablePadding;
                this.mConstantSize = arg4.mConstantSize;
                this.mDither = arg4.mDither;
                this.mMutated = arg4.mMutated;
                this.mLayoutDirection = arg4.mLayoutDirection;
                this.mEnterFadeDuration = arg4.mEnterFadeDuration;
                this.mExitFadeDuration = arg4.mExitFadeDuration;
                this.mAutoMirrored = arg4.mAutoMirrored;
                this.mColorFilter = arg4.mColorFilter;
                this.mHasColorFilter = arg4.mHasColorFilter;
                this.mTintList = arg4.mTintList;
                this.mTintMode = arg4.mTintMode;
                this.mHasTintList = arg4.mHasTintList;
                this.mHasTintMode = arg4.mHasTintMode;
                if(arg4.mDensity == v6) {
                    if(arg4.mCheckedPadding) {
                        if(arg4.mConstantPadding != null) {
                            v5 = new Rect(arg4.mConstantPadding);
                        }

                        this.mConstantPadding = v5;
                        this.mCheckedPadding = true;
                    }

                    if(!arg4.mCheckedConstantSize) {
                        goto label_81;
                    }

                    this.mConstantWidth = arg4.mConstantWidth;
                    this.mConstantHeight = arg4.mConstantHeight;
                    this.mConstantMinimumWidth = arg4.mConstantMinimumWidth;
                    this.mConstantMinimumHeight = arg4.mConstantMinimumHeight;
                    this.mCheckedConstantSize = true;
                }

            label_81:
                if(arg4.mCheckedOpacity) {
                    this.mOpacity = arg4.mOpacity;
                    this.mCheckedOpacity = true;
                }

                if(arg4.mCheckedStateful) {
                    this.mStateful = arg4.mStateful;
                    this.mCheckedStateful = true;
                }

                Drawable[] v5_1 = arg4.mDrawables;
                this.mDrawables = new Drawable[v5_1.length];
                this.mNumChildren = arg4.mNumChildren;
                SparseArray v4 = arg4.mDrawableFutures;
                this.mDrawableFutures = v4 != null ? v4.clone() : new SparseArray(this.mNumChildren);
                int v4_1 = this.mNumChildren;
                while(v0 < v4_1) {
                    Drawable v6_1 = v5_1[v0];
                    if(v6_1 != null) {
                        Drawable$ConstantState v6_2 = v6_1.getConstantState();
                        if(v6_2 != null) {
                            this.mDrawableFutures.put(v0, v6_2);
                        }
                        else {
                            this.mDrawables[v0] = v5_1[v0];
                        }
                    }

                    ++v0;
                }

                return;
            }

            this.mDrawables = new Drawable[10];
            this.mNumChildren = 0;
        }

        public final int addChild(Drawable arg5) {
            int v0 = this.mNumChildren;
            if(v0 >= this.mDrawables.length) {
                this.growArray(v0, v0 + 10);
            }

            arg5.mutate();
            arg5.setVisible(false, true);
            arg5.setCallback(this.mOwner);
            this.mDrawables[v0] = arg5;
            ++this.mNumChildren;
            this.mChildrenChangingConfigurations |= arg5.getChangingConfigurations();
            this.invalidateCache();
            this.mConstantPadding = null;
            this.mCheckedPadding = false;
            this.mCheckedConstantSize = false;
            this.mCheckedConstantState = false;
            return v0;
        }

        final void applyTheme(Resources$Theme arg6) {
            if(arg6 != null) {
                this.createAllFutures();
                int v0 = this.mNumChildren;
                Drawable[] v1 = this.mDrawables;
                int v2;
                for(v2 = 0; v2 < v0; ++v2) {
                    Drawable v3 = v1[v2];
                    if(v3 != null && (DrawableCompat.canApplyTheme(v3))) {
                        DrawableCompat.applyTheme(v1[v2], arg6);
                        this.mChildrenChangingConfigurations |= v1[v2].getChangingConfigurations();
                    }
                }

                this.updateDensity(Api21Impl.getResources(arg6));
            }
        }

        public boolean canApplyTheme() {
            int v0 = this.mNumChildren;
            Drawable[] v1 = this.mDrawables;
            int v3;
            for(v3 = 0; v3 < v0; ++v3) {
                Drawable v4 = v1[v3];
                if(v4 == null) {
                    Object v4_1 = this.mDrawableFutures.get(v3);
                    if(v4_1 != null && (Api21Impl.canApplyTheme(((Drawable$ConstantState)v4_1)))) {
                        return 1;
                    }
                }
                else if(DrawableCompat.canApplyTheme(v4)) {
                    return 1;
                }
            }

            return 0;
        }

        public boolean canConstantState() {
            if(this.mCheckedConstantState) {
                return this.mCanConstantState;
            }

            this.createAllFutures();
            this.mCheckedConstantState = true;
            int v1 = this.mNumChildren;
            Drawable[] v2 = this.mDrawables;
            int v4;
            for(v4 = 0; v4 < v1; ++v4) {
                if(v2[v4].getConstantState() == null) {
                    this.mCanConstantState = false;
                    return 0;
                }
            }

            this.mCanConstantState = true;
            return 1;
        }

        final void clearMutated() {
            this.mMutated = false;
        }

        protected void computeConstantSize() {
            this.mCheckedConstantSize = true;
            this.createAllFutures();
            int v0 = this.mNumChildren;
            Drawable[] v1 = this.mDrawables;
            this.mConstantHeight = -1;
            this.mConstantWidth = -1;
            int v2 = 0;
            this.mConstantMinimumHeight = 0;
            this.mConstantMinimumWidth = 0;
            while(v2 < v0) {
                Drawable v3 = v1[v2];
                int v4 = v3.getIntrinsicWidth();
                if(v4 > this.mConstantWidth) {
                    this.mConstantWidth = v4;
                }

                v4 = v3.getIntrinsicHeight();
                if(v4 > this.mConstantHeight) {
                    this.mConstantHeight = v4;
                }

                v4 = v3.getMinimumWidth();
                if(v4 > this.mConstantMinimumWidth) {
                    this.mConstantMinimumWidth = v4;
                }

                int v3_1 = v3.getMinimumHeight();
                if(v3_1 > this.mConstantMinimumHeight) {
                    this.mConstantMinimumHeight = v3_1;
                }

                ++v2;
            }
        }

        private void createAllFutures() {
            SparseArray v0 = this.mDrawableFutures;
            if(v0 != null) {
                int v0_1 = v0.size();
                int v1;
                for(v1 = 0; v1 < v0_1; ++v1) {
                    this.mDrawables[this.mDrawableFutures.keyAt(v1)] = this.prepareDrawable(this.mDrawableFutures.valueAt(v1).newDrawable(this.mSourceRes));
                }

                this.mDrawableFutures = null;
            }
        }

        final int getCapacity() {
            return this.mDrawables.length;
        }

        public int getChangingConfigurations() {
            return this.mChildrenChangingConfigurations | this.mChangingConfigurations;
        }

        public final Drawable getChild(int arg5) {
            Drawable v0 = this.mDrawables[arg5];
            if(v0 != null) {
                return v0;
            }

            SparseArray v0_1 = this.mDrawableFutures;
            SparseArray v1 = null;
            if(v0_1 != null) {
                int v0_2 = v0_1.indexOfKey(arg5);
                if(v0_2 >= 0) {
                    Drawable v2 = this.prepareDrawable(this.mDrawableFutures.valueAt(v0_2).newDrawable(this.mSourceRes));
                    this.mDrawables[arg5] = v2;
                    this.mDrawableFutures.removeAt(v0_2);
                    if(this.mDrawableFutures.size() == 0) {
                        this.mDrawableFutures = v1;
                    }

                    return v2;
                }
            }

            return ((Drawable)v1);
        }

        public final int getChildCount() {
            return this.mNumChildren;
        }

        public final int getConstantHeight() {
            if(!this.mCheckedConstantSize) {
                this.computeConstantSize();
            }

            return this.mConstantHeight;
        }

        public final int getConstantMinimumHeight() {
            if(!this.mCheckedConstantSize) {
                this.computeConstantSize();
            }

            return this.mConstantMinimumHeight;
        }

        public final int getConstantMinimumWidth() {
            if(!this.mCheckedConstantSize) {
                this.computeConstantSize();
            }

            return this.mConstantMinimumWidth;
        }

        public final Rect getConstantPadding() {
            Rect v1 = null;
            if(this.mVariablePadding) {
                return v1;
            }

            Rect v0 = this.mConstantPadding;
            if(v0 == null) {
                if(this.mCheckedPadding) {
                }
                else {
                    this.createAllFutures();
                    v0 = new Rect();
                    int v2 = this.mNumChildren;
                    Drawable[] v3 = this.mDrawables;
                    int v5;
                    for(v5 = 0; v5 < v2; ++v5) {
                        if(v3[v5].getPadding(v0)) {
                            if(v1 == null) {
                                v1 = new Rect(0, 0, 0, 0);
                            }

                            if(v0.left > v1.left) {
                                v1.left = v0.left;
                            }

                            if(v0.top > v1.top) {
                                v1.top = v0.top;
                            }

                            if(v0.right > v1.right) {
                                v1.right = v0.right;
                            }

                            if(v0.bottom <= v1.bottom) {
                                goto label_43;
                            }

                            v1.bottom = v0.bottom;
                        }

                    label_43:
                    }

                    this.mCheckedPadding = true;
                    this.mConstantPadding = v1;
                    return v1;
                }
            }

            return v0;
        }

        public final int getConstantWidth() {
            if(!this.mCheckedConstantSize) {
                this.computeConstantSize();
            }

            return this.mConstantWidth;
        }

        public final int getEnterFadeDuration() {
            return this.mEnterFadeDuration;
        }

        public final int getExitFadeDuration() {
            return this.mExitFadeDuration;
        }

        public final int getOpacity() {
            if(this.mCheckedOpacity) {
                return this.mOpacity;
            }

            this.createAllFutures();
            int v0 = this.mNumChildren;
            Drawable[] v1 = this.mDrawables;
            int v2 = v0 > 0 ? v1[0].getOpacity() : -2;
            int v4;
            for(v4 = 1; v4 < v0; ++v4) {
                v2 = Drawable.resolveOpacity(v2, v1[v4].getOpacity());
            }

            this.mOpacity = v2;
            this.mCheckedOpacity = true;
            return v2;
        }

        public void growArray(int arg3, int arg4) {
            Drawable[] v4 = new Drawable[arg4];
            Drawable[] v0 = this.mDrawables;
            if(v0 != null) {
                System.arraycopy(v0, 0, v4, 0, arg3);
            }

            this.mDrawables = v4;
        }

        void invalidateCache() {
            this.mCheckedOpacity = false;
            this.mCheckedStateful = false;
        }

        public final boolean isConstantSize() {
            return this.mConstantSize;
        }

        public final boolean isStateful() {
            if(this.mCheckedStateful) {
                return this.mStateful;
            }

            this.createAllFutures();
            int v0 = this.mNumChildren;
            Drawable[] v1 = this.mDrawables;
            boolean v2 = false;
            int v3 = 0;
            while(v3 < v0) {
                if(v1[v3].isStateful()) {
                    v2 = true;
                }
                else {
                    ++v3;
                    continue;
                }

                break;
            }

            this.mStateful = v2;
            this.mCheckedStateful = true;
            return v2;
        }

        void mutate() {
            int v0 = this.mNumChildren;
            Drawable[] v1 = this.mDrawables;
            int v2;
            for(v2 = 0; v2 < v0; ++v2) {
                Drawable v3 = v1[v2];
                if(v3 != null) {
                    v3.mutate();
                }
            }

            this.mMutated = true;
        }

        private Drawable prepareDrawable(Drawable arg2) {
            DrawableCompat.setLayoutDirection(arg2, this.mLayoutDirection);
            arg2 = arg2.mutate();
            arg2.setCallback(this.mOwner);
            return arg2;
        }

        public final void setConstantSize(boolean arg1) {
            this.mConstantSize = arg1;
        }

        public final void setEnterFadeDuration(int arg1) {
            this.mEnterFadeDuration = arg1;
        }

        public final void setExitFadeDuration(int arg1) {
            this.mExitFadeDuration = arg1;
        }

        final boolean setLayoutDirection(int arg6, int arg7) {
            int v0 = this.mNumChildren;
            Drawable[] v1 = this.mDrawables;
            int v2 = 0;
            boolean v3 = false;
            while(v2 < v0) {
                if(v1[v2] != null) {
                    boolean v4 = DrawableCompat.setLayoutDirection(v1[v2], arg6);
                    if(v2 == arg7) {
                        v3 = v4;
                    }
                }

                ++v2;
            }

            this.mLayoutDirection = arg6;
            return v3;
        }

        public final void setVariablePadding(boolean arg1) {
            this.mVariablePadding = arg1;
        }

        final void updateDensity(Resources arg2) {
            if(arg2 != null) {
                this.mSourceRes = arg2;
                int v2 = DrawableContainerCompat.resolveDensity(arg2, this.mDensity);
                int v0 = this.mDensity;
                this.mDensity = v2;
                if(v0 != v2) {
                    this.mCheckedConstantSize = false;
                    this.mCheckedPadding = false;
                }
            }
        }
    }

    private static final boolean DEBUG = false;
    private static final boolean DEFAULT_DITHER = true;
    private static final String TAG = "DrawableContainerCompat";
    private int mAlpha;
    private Runnable mAnimationRunnable;
    private BlockInvalidateCallback mBlockInvalidateCallback;
    private int mCurIndex;
    private Drawable mCurrDrawable;
    private DrawableContainerState mDrawableContainerState;
    private long mEnterAnimationEnd;
    private long mExitAnimationEnd;
    private boolean mHasAlpha;
    private Rect mHotspotBounds;
    private Drawable mLastDrawable;
    private boolean mMutated;

    public DrawableContainerCompat() {
        super();
        this.mAlpha = 0xFF;
        this.mCurIndex = -1;
    }

    void animate(boolean arg14) {
        int v3_1;
        int v0 = 1;
        this.mHasAlpha = true;
        long v1 = SystemClock.uptimeMillis();
        Drawable v3 = this.mCurrDrawable;
        long v4 = 0xFF;
        long v6 = 0;
        if(v3 != null) {
            long v9 = this.mEnterAnimationEnd;
            if(v9 == v6) {
                goto label_30;
            }
            else if(v9 <= v1) {
                v3.setAlpha(this.mAlpha);
                this.mEnterAnimationEnd = v6;
                goto label_30;
            }
            else {
                this.mCurrDrawable.setAlpha((0xFF - (((int)((v9 - v1) * v4))) / this.mDrawableContainerState.mEnterFadeDuration) * this.mAlpha / 0xFF);
                v3_1 = 1;
            }
        }
        else {
            this.mEnterAnimationEnd = v6;
        label_30:
            v3_1 = 0;
        }

        Drawable v9_1 = this.mLastDrawable;
        if(v9_1 != null) {
            long v10 = this.mExitAnimationEnd;
            if(v10 == v6) {
                goto label_54;
            }
            else if(v10 <= v1) {
                v9_1.setVisible(false, false);
                this.mLastDrawable = null;
                this.mExitAnimationEnd = v6;
                goto label_54;
            }
            else {
                this.mLastDrawable.setAlpha((((int)((v10 - v1) * v4))) / this.mDrawableContainerState.mExitFadeDuration * this.mAlpha / 0xFF);
            }
        }
        else {
            this.mExitAnimationEnd = v6;
        label_54:
            v0 = v3_1;
        }

        if((arg14) && v0 != 0) {
            this.scheduleSelf(this.mAnimationRunnable, v1 + 16);
        }
    }

    public void applyTheme(Resources$Theme arg1) {
        this.mDrawableContainerState.applyTheme(arg1);
    }

    public boolean canApplyTheme() {
        return this.mDrawableContainerState.canApplyTheme();
    }

    void clearMutated() {
        this.mDrawableContainerState.clearMutated();
        this.mMutated = false;
    }

    DrawableContainerState cloneConstantState() {
        return this.mDrawableContainerState;
    }

    public void draw(Canvas arg2) {
        Drawable v0 = this.mCurrDrawable;
        if(v0 != null) {
            v0.draw(arg2);
        }

        Drawable v1 = this.mLastDrawable;
        if(v1 != null) {
            v1.draw(arg2);
        }
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    public int getChangingConfigurations() {
        return this.mDrawableContainerState.getChangingConfigurations() | super.getChangingConfigurations();
    }

    public final Drawable$ConstantState getConstantState() {
        if(this.mDrawableContainerState.canConstantState()) {
            this.mDrawableContainerState.mChangingConfigurations = this.getChangingConfigurations();
            return this.mDrawableContainerState;
        }

        return null;
    }

    public Drawable getCurrent() {
        return this.mCurrDrawable;
    }

    int getCurrentIndex() {
        return this.mCurIndex;
    }

    public void getHotspotBounds(Rect arg2) {
        Rect v0 = this.mHotspotBounds;
        if(v0 != null) {
            arg2.set(v0);
            return;
        }

        super.getHotspotBounds(arg2);
    }

    public int getIntrinsicHeight() {
        if(this.mDrawableContainerState.isConstantSize()) {
            return this.mDrawableContainerState.getConstantHeight();
        }

        Drawable v1 = this.mCurrDrawable;
        if(v1 != null) {
            return v1.getIntrinsicHeight();
        }

        return -1;
    }

    public int getIntrinsicWidth() {
        if(this.mDrawableContainerState.isConstantSize()) {
            return this.mDrawableContainerState.getConstantWidth();
        }

        Drawable v1 = this.mCurrDrawable;
        if(v1 != null) {
            return v1.getIntrinsicWidth();
        }

        return -1;
    }

    public int getMinimumHeight() {
        if(this.mDrawableContainerState.isConstantSize()) {
            return this.mDrawableContainerState.getConstantMinimumHeight();
        }

        Drawable v1 = this.mCurrDrawable;
        if(v1 != null) {
            return v1.getMinimumHeight();
        }

        return 0;
    }

    public int getMinimumWidth() {
        if(this.mDrawableContainerState.isConstantSize()) {
            return this.mDrawableContainerState.getConstantMinimumWidth();
        }

        Drawable v1 = this.mCurrDrawable;
        if(v1 != null) {
            return v1.getMinimumWidth();
        }

        return 0;
    }

    public int getOpacity() {
        Drawable v0 = this.mCurrDrawable;
        if(v0 != null) {
            if(!v0.isVisible()) {
            }
            else {
                return this.mDrawableContainerState.getOpacity();
            }
        }

        return -2;
    }

    public void getOutline(Outline arg1) {
        Drawable v0 = this.mCurrDrawable;
        if(v0 != null) {
            Api21Impl.getOutline(v0, arg1);
        }
    }

    public boolean getPadding(Rect arg4) {
        boolean v0_1;
        Rect v0 = this.mDrawableContainerState.getConstantPadding();
        if(v0 != null) {
            arg4.set(v0);
            v0_1 = (v0.right | (v0.left | v0.top | v0.bottom)) != 0 ? true : false;
        }
        else {
            Drawable v0_2 = this.mCurrDrawable;
            v0_1 = v0_2 != null ? v0_2.getPadding(arg4) : super.getPadding(arg4);
        }

        if(this.needsMirroring()) {
            int v3 = arg4.left;
            arg4.left = arg4.right;
            arg4.right = v3;
        }

        return v0_1;
    }

    private void initializeDrawableForDisplay(Drawable arg5) {
        BlockInvalidateCallback v0 = this.mBlockInvalidateCallback;
        if(v0 == null) {
            v0 = new BlockInvalidateCallback();
            this.mBlockInvalidateCallback = v0;
        }

        arg5.setCallback(v0.wrap(arg5.getCallback()));
        try {
            if(this.mDrawableContainerState.mEnterFadeDuration <= 0 && (this.mHasAlpha)) {
                arg5.setAlpha(this.mAlpha);
            }

            boolean v0_2 = this.mDrawableContainerState.mHasColorFilter;
        }
        catch(Throwable v0_1) {
            goto label_64;
        }

        DrawableContainerState v1 = this.mDrawableContainerState;
        if(v0_2) {
            try {
                arg5.setColorFilter(v1.mColorFilter);
                goto label_33;
            label_22:
                if(v1.mHasTintList) {
                    DrawableCompat.setTintList(arg5, this.mDrawableContainerState.mTintList);
                }

                if(this.mDrawableContainerState.mHasTintMode) {
                    DrawableCompat.setTintMode(arg5, this.mDrawableContainerState.mTintMode);
                }

            label_33:
                arg5.setVisible(this.isVisible(), true);
                arg5.setDither(this.mDrawableContainerState.mDither);
                arg5.setState(this.getState());
                arg5.setLevel(this.getLevel());
                arg5.setBounds(this.getBounds());
                DrawableCompat.setLayoutDirection(arg5, DrawableCompat.getLayoutDirection(((Drawable)this)));
                DrawableCompat.setAutoMirrored(arg5, this.mDrawableContainerState.mAutoMirrored);
                Rect v0_3 = this.mHotspotBounds;
                if(v0_3 != null) {
                    DrawableCompat.setHotspotBounds(arg5, v0_3.left, v0_3.top, v0_3.right, v0_3.bottom);
                }

                goto label_57;
            }
            catch(Throwable v0_1) {
            label_64:
                arg5.setCallback(this.mBlockInvalidateCallback.unwrap());
                throw v0_1;
            }
        }
        else {
            goto label_22;
        }

        goto label_33;
    label_57:
        arg5.setCallback(this.mBlockInvalidateCallback.unwrap());
    }

    public void invalidateDrawable(Drawable arg2) {
        DrawableContainerState v0 = this.mDrawableContainerState;
        if(v0 != null) {
            v0.invalidateCache();
        }

        if(arg2 == this.mCurrDrawable && this.getCallback() != null) {
            this.getCallback().invalidateDrawable(((Drawable)this));
        }
    }

    public boolean isAutoMirrored() {
        return this.mDrawableContainerState.mAutoMirrored;
    }

    public boolean isStateful() {
        return this.mDrawableContainerState.isStateful();
    }

    public void jumpToCurrentState() {
        int v0_1;
        Drawable v0 = this.mLastDrawable;
        int v1 = 1;
        if(v0 != null) {
            v0.jumpToCurrentState();
            this.mLastDrawable = null;
            v0_1 = 1;
        }
        else {
            v0_1 = 0;
        }

        Drawable v2 = this.mCurrDrawable;
        if(v2 != null) {
            v2.jumpToCurrentState();
            if(this.mHasAlpha) {
                this.mCurrDrawable.setAlpha(this.mAlpha);
            }
        }

        long v4 = 0;
        if(this.mExitAnimationEnd != v4) {
            this.mExitAnimationEnd = v4;
            v0_1 = 1;
        }

        if(this.mEnterAnimationEnd != v4) {
            this.mEnterAnimationEnd = v4;
        }
        else {
            v1 = v0_1;
        }

        if(v1 != 0) {
            this.invalidateSelf();
        }
    }

    public Drawable mutate() {
        if(!this.mMutated && super.mutate() == this) {
            DrawableContainerState v0 = this.cloneConstantState();
            v0.mutate();
            this.setConstantState(v0);
            this.mMutated = true;
        }

        return this;
    }

    private boolean needsMirroring() {
        if((this.isAutoMirrored()) && DrawableCompat.getLayoutDirection(((Drawable)this)) == 1) {
            return 1;
        }

        return 0;
    }

    protected void onBoundsChange(Rect arg2) {
        Drawable v0 = this.mLastDrawable;
        if(v0 != null) {
            v0.setBounds(arg2);
        }

        Drawable v1 = this.mCurrDrawable;
        if(v1 != null) {
            v1.setBounds(arg2);
        }
    }

    public boolean onLayoutDirectionChanged(int arg2) {
        return this.mDrawableContainerState.setLayoutDirection(arg2, this.getCurrentIndex());
    }

    protected boolean onLevelChange(int arg2) {
        Drawable v0 = this.mLastDrawable;
        if(v0 != null) {
            return v0.setLevel(arg2);
        }

        Drawable v1 = this.mCurrDrawable;
        if(v1 != null) {
            return v1.setLevel(arg2);
        }

        return 0;
    }

    protected boolean onStateChange(int[] arg2) {
        Drawable v0 = this.mLastDrawable;
        if(v0 != null) {
            return v0.setState(arg2);
        }

        Drawable v1 = this.mCurrDrawable;
        if(v1 != null) {
            return v1.setState(arg2);
        }

        return 0;
    }

    static int resolveDensity(Resources arg0, int arg1) {
        if(arg0 == null) {
        }
        else {
            arg1 = arg0.getDisplayMetrics().densityDpi;
        }

        if(arg1 == 0) {
            return 0xA0;
        }

        return arg1;
    }

    public void scheduleDrawable(Drawable arg2, Runnable arg3, long arg4) {
        if(arg2 == this.mCurrDrawable && this.getCallback() != null) {
            this.getCallback().scheduleDrawable(((Drawable)this), arg3, arg4);
        }
    }

    boolean selectDrawable(int arg10) {
        Drawable v0;
        if(arg10 == this.mCurIndex) {
            return 0;
        }

        long v2 = SystemClock.uptimeMillis();
        Drawable v4 = null;
        long v5 = 0;
        if(this.mDrawableContainerState.mExitFadeDuration > 0) {
            v0 = this.mLastDrawable;
            if(v0 != null) {
                v0.setVisible(false, false);
            }

            v0 = this.mCurrDrawable;
            if(v0 != null) {
                this.mLastDrawable = v0;
                this.mExitAnimationEnd = (((long)this.mDrawableContainerState.mExitFadeDuration)) + v2;
                goto label_28;
            }

            this.mLastDrawable = v4;
            this.mExitAnimationEnd = v5;
        }
        else {
            v0 = this.mCurrDrawable;
            if(v0 == null) {
                goto label_28;
            }

            v0.setVisible(false, false);
        }

    label_28:
        if(arg10 < 0 || arg10 >= this.mDrawableContainerState.mNumChildren) {
            this.mCurrDrawable = v4;
            this.mCurIndex = -1;
        }
        else {
            v0 = this.mDrawableContainerState.getChild(arg10);
            this.mCurrDrawable = v0;
            this.mCurIndex = arg10;
            if(v0 != null) {
                if(this.mDrawableContainerState.mEnterFadeDuration > 0) {
                    this.mEnterAnimationEnd = v2 + (((long)this.mDrawableContainerState.mEnterFadeDuration));
                }

                this.initializeDrawableForDisplay(v0);
            }
        }

        if(Long.compare(this.mEnterAnimationEnd, v5) != 0 || this.mExitAnimationEnd != v5) {
            Runnable v10 = this.mAnimationRunnable;
            if(v10 == null) {
                this.mAnimationRunnable = new Runnable() {
                    public void run() {
                        DrawableContainerCompat.this.animate(true);
                        DrawableContainerCompat.this.invalidateSelf();
                    }
                };
            }
            else {
                this.unscheduleSelf(v10);
            }

            this.animate(true);
        }

        this.invalidateSelf();
        return 1;
    }

    public void setAlpha(int arg6) {
        if(!this.mHasAlpha || this.mAlpha != arg6) {
            this.mHasAlpha = true;
            this.mAlpha = arg6;
            Drawable v0 = this.mCurrDrawable;
            if(v0 != null) {
                if(this.mEnterAnimationEnd == 0) {
                    v0.setAlpha(arg6);
                    return;
                }
                else {
                    this.animate(false);
                }
            }
        }
    }

    public void setAutoMirrored(boolean arg2) {
        if(this.mDrawableContainerState.mAutoMirrored != arg2) {
            this.mDrawableContainerState.mAutoMirrored = arg2;
            Drawable v2 = this.mCurrDrawable;
            if(v2 != null) {
                DrawableCompat.setAutoMirrored(v2, this.mDrawableContainerState.mAutoMirrored);
            }
        }
    }

    public void setColorFilter(ColorFilter arg3) {
        this.mDrawableContainerState.mHasColorFilter = true;
        if(this.mDrawableContainerState.mColorFilter != arg3) {
            this.mDrawableContainerState.mColorFilter = arg3;
            Drawable v2 = this.mCurrDrawable;
            if(v2 != null) {
                v2.setColorFilter(arg3);
            }
        }
    }

    void setConstantState(DrawableContainerState arg2) {
        this.mDrawableContainerState = arg2;
        int v0 = this.mCurIndex;
        if(v0 >= 0) {
            Drawable v2 = arg2.getChild(v0);
            this.mCurrDrawable = v2;
            if(v2 != null) {
                this.initializeDrawableForDisplay(v2);
            }
        }

        this.mLastDrawable = null;
    }

    void setCurrentIndex(int arg1) {
        this.selectDrawable(arg1);
    }

    public void setDither(boolean arg2) {
        if(this.mDrawableContainerState.mDither != arg2) {
            this.mDrawableContainerState.mDither = arg2;
            Drawable v2 = this.mCurrDrawable;
            if(v2 != null) {
                v2.setDither(this.mDrawableContainerState.mDither);
            }
        }
    }

    public void setEnterFadeDuration(int arg1) {
        this.mDrawableContainerState.mEnterFadeDuration = arg1;
    }

    public void setExitFadeDuration(int arg1) {
        this.mDrawableContainerState.mExitFadeDuration = arg1;
    }

    public void setHotspot(float arg1, float arg2) {
        Drawable v0 = this.mCurrDrawable;
        if(v0 != null) {
            DrawableCompat.setHotspot(v0, arg1, arg2);
        }
    }

    public void setHotspotBounds(int arg2, int arg3, int arg4, int arg5) {
        Rect v0 = this.mHotspotBounds;
        if(v0 == null) {
            this.mHotspotBounds = new Rect(arg2, arg3, arg4, arg5);
        }
        else {
            v0.set(arg2, arg3, arg4, arg5);
        }

        Drawable v1 = this.mCurrDrawable;
        if(v1 != null) {
            DrawableCompat.setHotspotBounds(v1, arg2, arg3, arg4, arg5);
        }
    }

    public void setTint(int arg1) {
        this.setTintList(ColorStateList.valueOf(arg1));
    }

    public void setTintList(ColorStateList arg3) {
        this.mDrawableContainerState.mHasTintList = true;
        if(this.mDrawableContainerState.mTintList != arg3) {
            this.mDrawableContainerState.mTintList = arg3;
            DrawableCompat.setTintList(this.mCurrDrawable, arg3);
        }
    }

    public void setTintMode(PorterDuff$Mode arg3) {
        this.mDrawableContainerState.mHasTintMode = true;
        if(this.mDrawableContainerState.mTintMode != arg3) {
            this.mDrawableContainerState.mTintMode = arg3;
            DrawableCompat.setTintMode(this.mCurrDrawable, arg3);
        }
    }

    public boolean setVisible(boolean arg3, boolean arg4) {
        boolean v0 = super.setVisible(arg3, arg4);
        Drawable v1 = this.mLastDrawable;
        if(v1 != null) {
            v1.setVisible(arg3, arg4);
        }

        Drawable v2 = this.mCurrDrawable;
        if(v2 != null) {
            v2.setVisible(arg3, arg4);
        }

        return v0;
    }

    public void unscheduleDrawable(Drawable arg2, Runnable arg3) {
        if(arg2 == this.mCurrDrawable && this.getCallback() != null) {
            this.getCallback().unscheduleDrawable(((Drawable)this), arg3);
        }
    }

    final void updateDensity(Resources arg1) {
        this.mDrawableContainerState.updateDensity(arg1);
    }
}

