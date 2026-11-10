package androidx.core.view;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build$VERSION;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.DisplayShape;
import android.view.View;
import android.view.WindowInsets$Builder;
import android.view.WindowInsets$Type;
import android.view.WindowInsets;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class WindowInsetsCompat {
    public final class Builder {
        private final BuilderImpl mImpl;

        public Builder(WindowInsetsCompat arg3) {
            super();
            if(Build$VERSION.SDK_INT >= 36) {
                this.mImpl = new BuilderImpl36(arg3);
                return;
            }

            if(Build$VERSION.SDK_INT >= 35) {
                this.mImpl = new BuilderImpl35(arg3);
                return;
            }

            if(Build$VERSION.SDK_INT >= 34) {
                this.mImpl = new BuilderImpl34(arg3);
                return;
            }

            if(Build$VERSION.SDK_INT >= 0x1F) {
                this.mImpl = new BuilderImpl31(arg3);
                return;
            }

            if(Build$VERSION.SDK_INT >= 30) {
                this.mImpl = new BuilderImpl30(arg3);
                return;
            }

            if(Build$VERSION.SDK_INT >= 29) {
                this.mImpl = new BuilderImpl29(arg3);
                return;
            }

            this.mImpl = new BuilderImpl20(arg3);
        }

        public Builder() {
            super();
            if(Build$VERSION.SDK_INT >= 36) {
                this.mImpl = new BuilderImpl36();
                return;
            }

            if(Build$VERSION.SDK_INT >= 35) {
                this.mImpl = new BuilderImpl35();
                return;
            }

            if(Build$VERSION.SDK_INT >= 34) {
                this.mImpl = new BuilderImpl34();
                return;
            }

            if(Build$VERSION.SDK_INT >= 0x1F) {
                this.mImpl = new BuilderImpl31();
                return;
            }

            if(Build$VERSION.SDK_INT >= 30) {
                this.mImpl = new BuilderImpl30();
                return;
            }

            if(Build$VERSION.SDK_INT >= 29) {
                this.mImpl = new BuilderImpl29();
                return;
            }

            this.mImpl = new BuilderImpl20();
        }

        public WindowInsetsCompat build() {
            return this.mImpl.build();
        }

        public Builder setBoundingRects(int arg2, List arg3) {
            this.mImpl.setBoundingRects(arg2, arg3);
            return this;
        }

        public Builder setBoundingRectsIgnoringVisibility(int arg2, List arg3) {
            this.mImpl.setBoundingRectsIgnoringVisibility(arg2, arg3);
            return this;
        }

        public Builder setDisplayCutout(DisplayCutoutCompat arg2) {
            this.mImpl.setDisplayCutout(arg2);
            return this;
        }

        public Builder setDisplayShape(DisplayShapeCompat arg2) {
            this.mImpl.setDisplayShape(arg2);
            return this;
        }

        public Builder setInsets(int arg2, Insets arg3) {
            this.mImpl.setInsets(arg2, arg3);
            return this;
        }

        public Builder setInsetsIgnoringVisibility(int arg2, Insets arg3) {
            this.mImpl.setInsetsIgnoringVisibility(arg2, arg3);
            return this;
        }

        @Deprecated public Builder setMandatorySystemGestureInsets(Insets arg2) {
            this.mImpl.setMandatorySystemGestureInsets(arg2);
            return this;
        }

        public Builder setPrivacyIndicatorBounds(Rect arg2) {
            this.mImpl.setPrivacyIndicatorBounds(arg2);
            return this;
        }

        public Builder setRoundedCorner(int arg2, RoundedCornerCompat arg3) {
            this.mImpl.setRoundedCorner(arg2, arg3);
            return this;
        }

        @Deprecated public Builder setStableInsets(Insets arg2) {
            this.mImpl.setStableInsets(arg2);
            return this;
        }

        @Deprecated public Builder setSystemGestureInsets(Insets arg2) {
            this.mImpl.setSystemGestureInsets(arg2);
            return this;
        }

        @Deprecated public Builder setSystemWindowInsets(Insets arg2) {
            this.mImpl.setSystemWindowInsets(arg2);
            return this;
        }

        @Deprecated public Builder setTappableElementInsets(Insets arg2) {
            this.mImpl.setTappableElementInsets(arg2);
            return this;
        }

        public Builder setVisible(int arg2, boolean arg3) {
            this.mImpl.setVisible(arg2, arg3);
            return this;
        }
    }

    class BuilderImpl20 extends BuilderImpl {
        private WindowInsets mPlatformInsets;
        private Insets mStableInsets;
        private static Constructor sConstructor = null;
        private static boolean sConstructorFetched = false;
        private static Field sConsumedField = null;
        private static boolean sConsumedFieldFetched = false;

        static {
        }

        BuilderImpl20() {
            super();
            this.mPlatformInsets = BuilderImpl20.createWindowInsetsInstance();
        }

        BuilderImpl20(WindowInsetsCompat arg1) {
            super(arg1);
            this.mPlatformInsets = arg1.toWindowInsets();
        }

        WindowInsetsCompat build() {
            this.applyInsetTypes();
            WindowInsetsCompat v0 = WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets);
            v0.setOverriddenInsets(this.mInsetsTypeMask);
            v0.setStableInsets(this.mStableInsets);
            v0.setDisplayShape(this.mDisplayShapeCompat);
            v0.setTypeBoundingRectsMap(this.mTypeBoundingRectsMap);
            v0.setTypeMaxBoundingRectsMap(this.mTypeMaxBoundingRectsMap);
            return v0;
        }

        private static WindowInsets createWindowInsetsInstance() {
            String v2 = "WindowInsetsCompat";
            if(!BuilderImpl20.sConsumedFieldFetched) {
                try {
                    BuilderImpl20.sConsumedField = WindowInsets.class.getDeclaredField("CONSUMED");
                }
                catch(ReflectiveOperationException v0) {
                    Log.i(v2, "Could not retrieve WindowInsets.CONSUMED field", ((Throwable)v0));
                }

                BuilderImpl20.sConsumedFieldFetched = true;
            }

            Field v0_1 = BuilderImpl20.sConsumedField;
            Object v3 = null;
            if(v0_1 != null) {
                try {
                    Object v0_2 = v0_1.get(v3);
                    if(v0_2 == null) {
                        goto label_24;
                    }

                    return new WindowInsets(((WindowInsets)v0_2));
                }
                catch(ReflectiveOperationException v0) {
                    Log.i(v2, "Could not get value from WindowInsets.CONSUMED field", ((Throwable)v0));
                }
            }

        label_24:
            if(!BuilderImpl20.sConstructorFetched) {
                try {
                    BuilderImpl20.sConstructor = WindowInsets.class.getConstructor(Rect.class);
                }
                catch(ReflectiveOperationException v0) {
                    Log.i(v2, "Could not retrieve WindowInsets(Rect) constructor", ((Throwable)v0));
                }

                BuilderImpl20.sConstructorFetched = true;
            }

            Constructor v0_3 = BuilderImpl20.sConstructor;
            if(v0_3 != null) {
                try {
                    return v0_3.newInstance(new Rect());
                }
                catch(ReflectiveOperationException v0) {
                    Log.i(v2, "Could not invoke WindowInsets(Rect) constructor", ((Throwable)v0));
                }
            }

            return ((WindowInsets)v3);
        }

        void setStableInsets(Insets arg1) {
            this.mStableInsets = arg1;
        }

        void setSystemWindowInsets(Insets arg5) {
            WindowInsets v0 = this.mPlatformInsets;
            if(v0 != null) {
                this.mPlatformInsets = v0.replaceSystemWindowInsets(arg5.left, arg5.top, arg5.right, arg5.bottom);
            }
        }
    }

    class BuilderImpl29 extends BuilderImpl {
        final WindowInsets$Builder mPlatBuilder;

        BuilderImpl29() {
            super();
            this.mPlatBuilder = new WindowInsets$Builder();
        }

        BuilderImpl29(WindowInsetsCompat arg2) {
            super(arg2);
            WindowInsets v2 = arg2.toWindowInsets();
            WindowInsets$Builder v0 = v2 != null ? new WindowInsets$Builder(v2) : new WindowInsets$Builder();
            this.mPlatBuilder = v0;
        }

        WindowInsetsCompat build() {
            this.applyInsetTypes();
            WindowInsetsCompat v0 = WindowInsetsCompat.toWindowInsetsCompat(this.mPlatBuilder.build());
            v0.setOverriddenInsets(this.mInsetsTypeMask);
            v0.setDisplayShape(this.mDisplayShapeCompat);
            v0.setTypeBoundingRectsMap(this.mTypeBoundingRectsMap);
            v0.setTypeMaxBoundingRectsMap(this.mTypeMaxBoundingRectsMap);
            return v0;
        }

        void setDisplayCutout(DisplayCutoutCompat arg1) {
            WindowInsets$Builder v0 = this.mPlatBuilder;
            DisplayCutout v1 = arg1 != null ? arg1.unwrap() : null;
            v0.setDisplayCutout(v1);
        }

        void setMandatorySystemGestureInsets(Insets arg1) {
            this.mPlatBuilder.setMandatorySystemGestureInsets(arg1.toPlatformInsets());
        }

        void setStableInsets(Insets arg1) {
            this.mPlatBuilder.setStableInsets(arg1.toPlatformInsets());
        }

        void setSystemGestureInsets(Insets arg1) {
            this.mPlatBuilder.setSystemGestureInsets(arg1.toPlatformInsets());
        }

        void setSystemWindowInsets(Insets arg1) {
            this.mPlatBuilder.setSystemWindowInsets(arg1.toPlatformInsets());
        }

        void setTappableElementInsets(Insets arg1) {
            this.mPlatBuilder.setTappableElementInsets(arg1.toPlatformInsets());
        }
    }

    class BuilderImpl30 extends BuilderImpl29 {
        BuilderImpl30() {
            super();
        }

        BuilderImpl30(WindowInsetsCompat arg1) {
            super(arg1);
        }

        void setInsets(int arg1, Insets arg2) {
            this.mPlatBuilder.setInsets(TypeImpl30.toPlatformType(arg1), arg2.toPlatformInsets());
        }

        void setInsetsIgnoringVisibility(int arg1, Insets arg2) {
            this.mPlatBuilder.setInsetsIgnoringVisibility(TypeImpl30.toPlatformType(arg1), arg2.toPlatformInsets());
        }

        void setVisible(int arg1, boolean arg2) {
            this.mPlatBuilder.setVisible(TypeImpl30.toPlatformType(arg1), arg2);
        }
    }

    class BuilderImpl31 extends BuilderImpl30 {
        BuilderImpl31() {
            super();
        }

        BuilderImpl31(WindowInsetsCompat arg1) {
            super(arg1);
        }

        void setPrivacyIndicatorBounds(Rect arg2) {
            WindowInsets$Builder v1 = this.mPlatBuilder;
            Rect v0 = arg2 != null ? new Rect(arg2) : null;
            v1.setPrivacyIndicatorBounds(v0);
        }

        void setRoundedCorner(int arg1, RoundedCornerCompat arg2) {
            this.mPlatBuilder.setRoundedCorner(RoundedCornerCompat.toPlatformPosition(arg1), RoundedCornerCompat.toPlatformRoundedCorner(arg2));
        }
    }

    class BuilderImpl34 extends BuilderImpl31 {
        BuilderImpl34() {
            super();
        }

        BuilderImpl34(WindowInsetsCompat arg1) {
            super(arg1);
        }

        void setDisplayShape(DisplayShapeCompat arg2) {
            DisplayShape v0 = DisplayShapeCompat.toPlatformDisplayShape(arg2);
            if(v0 != null) {
                this.mPlatBuilder.setDisplayShape(v0);
                return;
            }

            this.mDisplayShapeCompat = arg2;
        }

        void setInsets(int arg1, Insets arg2) {
            this.mPlatBuilder.setInsets(TypeImpl34.toPlatformType(arg1), arg2.toPlatformInsets());
        }

        void setInsetsIgnoringVisibility(int arg1, Insets arg2) {
            this.mPlatBuilder.setInsetsIgnoringVisibility(TypeImpl34.toPlatformType(arg1), arg2.toPlatformInsets());
        }

        void setVisible(int arg1, boolean arg2) {
            this.mPlatBuilder.setVisible(TypeImpl34.toPlatformType(arg1), arg2);
        }
    }

    class BuilderImpl35 extends BuilderImpl34 {
        private boolean mSetInsetsCalled;
        private boolean mSetInsetsIgnoringVisibilityCalled;

        BuilderImpl35() {
            super();
            this.mSetInsetsCalled = false;
            this.mSetInsetsIgnoringVisibilityCalled = false;
        }

        BuilderImpl35(WindowInsetsCompat arg2) {
            super(arg2);
            this.mSetInsetsCalled = false;
            this.mSetInsetsIgnoringVisibilityCalled = false;
            if(!arg2.isConsumed()) {
                this.mSetInsetsCalled = true;
                this.mSetInsetsIgnoringVisibilityCalled = true;
            }
        }

        void initTypeBoundingRects(WindowInsetsCompat arg1) {
        }

        void setBoundingRects(int arg2, List arg3) {
            arg2 = TypeImpl34.toPlatformType(arg2);
            this.mPlatBuilder.setBoundingRects(arg2, arg3);
            if(!this.mSetInsetsCalled) {
                this.mSetInsetsCalled = true;
                this.mPlatBuilder.setInsets(arg2, android.graphics.Insets.NONE);
            }
        }

        void setBoundingRectsIgnoringVisibility(int arg2, List arg3) {
            arg2 = TypeImpl34.toPlatformType(arg2);
            this.mPlatBuilder.setBoundingRectsIgnoringVisibility(arg2, arg3);
            if(!this.mSetInsetsIgnoringVisibilityCalled) {
                this.mSetInsetsIgnoringVisibilityCalled = true;
                this.mPlatBuilder.setInsetsIgnoringVisibility(arg2, android.graphics.Insets.NONE);
            }
        }

        void setInsets(int arg1, Insets arg2) {
            super.setInsets(arg1, arg2);
            this.mSetInsetsCalled = true;
        }

        void setInsetsIgnoringVisibility(int arg1, Insets arg2) {
            super.setInsetsIgnoringVisibility(arg1, arg2);
            this.mSetInsetsIgnoringVisibilityCalled = true;
        }
    }

    class BuilderImpl36 extends BuilderImpl35 {
        BuilderImpl36() {
            super();
        }

        BuilderImpl36(WindowInsetsCompat arg1) {
            super(arg1);
        }

        void setBoundingRects(int arg1, List arg2) {
            this.mPlatBuilder.setBoundingRects(TypeImpl34.toPlatformType(arg1), arg2);
        }

        void setBoundingRectsIgnoringVisibility(int arg1, List arg2) {
            this.mPlatBuilder.setBoundingRectsIgnoringVisibility(TypeImpl34.toPlatformType(arg1), arg2);
        }
    }

    class BuilderImpl {
        DisplayShapeCompat mDisplayShapeCompat;
        private final WindowInsetsCompat mInsets;
        Insets[] mInsetsTypeMask;
        Rect[][] mTypeBoundingRectsMap;
        Rect[][] mTypeMaxBoundingRectsMap;

        BuilderImpl() {
            this(new WindowInsetsCompat(null));
        }

        BuilderImpl(WindowInsetsCompat arg3) {
            super();
            this.mTypeBoundingRectsMap = new Rect[10][];
            this.mTypeMaxBoundingRectsMap = new Rect[10][];
            this.mInsets = arg3;
            this.initTypeBoundingRects(arg3);
        }

        protected final void applyInsetTypes() {
            Insets[] v0 = this.mInsetsTypeMask;
            if(v0 != null) {
                Insets v0_1 = v0[Type.indexOf(1)];
                int v3 = 2;
                Insets v2 = this.mInsetsTypeMask[Type.indexOf(v3)];
                if(v2 == null) {
                    v2 = this.mInsets.getInsets(v3);
                }

                if(v0_1 == null) {
                    v0_1 = this.mInsets.getInsets(1);
                }

                this.setSystemWindowInsets(Insets.max(v0_1, v2));
                v0_1 = this.mInsetsTypeMask[Type.indexOf(16)];
                if(v0_1 != null) {
                    this.setSystemGestureInsets(v0_1);
                }

                v0_1 = this.mInsetsTypeMask[Type.indexOf(0x20)];
                if(v0_1 != null) {
                    this.setMandatorySystemGestureInsets(v0_1);
                }

                v0_1 = this.mInsetsTypeMask[Type.indexOf(0x40)];
                if(v0_1 == null) {
                    return;
                }

                this.setTappableElementInsets(v0_1);
            }
        }

        WindowInsetsCompat build() {
            this.applyInsetTypes();
            return this.mInsets;
        }

        void initTypeBoundingRects(WindowInsetsCompat arg6) {
            int v0;
            for(v0 = 1; v0 <= 0x200; v0 <<= 1) {
                List v1 = arg6.getBoundingRects(v0);
                int v2 = Type.indexOf(v0);
                this.mTypeBoundingRectsMap[v2] = v1.toArray(new Rect[v1.size()]);
                if(v0 != 8) {
                    v1 = arg6.getBoundingRectsIgnoringVisibility(v0);
                    this.mTypeMaxBoundingRectsMap[v2] = v1.toArray(new Rect[v1.size()]);
                }
            }
        }

        void setBoundingRects(int arg5, List arg6) {
            int v0;
            for(v0 = 1; v0 <= 0x200; v0 <<= 1) {
                if((arg5 & v0) == 0) {
                }
                else {
                    this.mTypeBoundingRectsMap[Type.indexOf(v0)] = arg6.toArray(new Rect[arg6.size()]);
                }
            }
        }

        void setBoundingRectsIgnoringVisibility(int arg5, List arg6) {
            if((arg5 & 8) == 0) {
                int v0;
                for(v0 = 1; v0 <= 0x200; v0 <<= 1) {
                    if((arg5 & v0) == 0) {
                    }
                    else {
                        this.mTypeMaxBoundingRectsMap[Type.indexOf(v0)] = arg6.toArray(new Rect[arg6.size()]);
                    }
                }

                return;
            }

            throw new IllegalArgumentException("Maximum bounding rects not available for IME");
        }

        void setDisplayCutout(DisplayCutoutCompat arg1) {
        }

        void setDisplayShape(DisplayShapeCompat arg1) {
            this.mDisplayShapeCompat = arg1;
        }

        void setInsets(int arg4, Insets arg5) {
            if(this.mInsetsTypeMask == null) {
                this.mInsetsTypeMask = new Insets[10];
            }

            int v0;
            for(v0 = 1; v0 <= 0x200; v0 <<= 1) {
                if((arg4 & v0) == 0) {
                }
                else {
                    this.mInsetsTypeMask[Type.indexOf(v0)] = arg5;
                }
            }
        }

        void setInsetsIgnoringVisibility(int arg1, Insets arg2) {
            if(arg1 != 8) {
                return;
            }

            throw new IllegalArgumentException("Ignoring visibility inset not available for IME");
        }

        void setMandatorySystemGestureInsets(Insets arg1) {
        }

        void setPrivacyIndicatorBounds(Rect arg1) {
        }

        void setRoundedCorner(int arg1, RoundedCornerCompat arg2) {
        }

        void setStableInsets(Insets arg1) {
        }

        void setSystemGestureInsets(Insets arg1) {
        }

        void setSystemWindowInsets(Insets arg1) {
        }

        void setTappableElementInsets(Insets arg1) {
        }

        void setVisible(int arg1, boolean arg2) {
        }
    }

    class Impl20 extends Impl {
        private static final int SYSTEM_BAR_VISIBILITY_MASK = 6;
        DisplayShapeCompat mDisplayShapeCompat;
        private Insets[] mOverriddenInsets;
        final WindowInsets mPlatformInsets;
        int mRootViewHeight;
        Insets mRootViewVisibleInsets;
        int mRootViewWidth;
        private WindowInsetsCompat mRootWindowInsets;
        int mSystemUiVisibility;
        private Insets mSystemWindowInsets;
        private Rect[][] mTypeBoundingRectsMap;
        private Rect[][] mTypeMaxBoundingRectsMap;
        private static Class sAttachInfoClass = null;
        private static Field sAttachInfoField = null;
        private static Method sGetViewRootImplMethod = null;
        private static Field sVisibleInsetsField = null;
        private static boolean sVisibleRectReflectionFetched = false;

        static {
        }

        Impl20(WindowInsetsCompat arg2, Impl20 arg3) {
            this(arg2, new WindowInsets(arg3.mPlatformInsets));
        }

        Impl20(WindowInsetsCompat arg2, WindowInsets arg3) {
            super(arg2);
            this.mSystemWindowInsets = null;
            this.mTypeBoundingRectsMap = new Rect[10][];
            this.mTypeMaxBoundingRectsMap = new Rect[10][];
            this.mPlatformInsets = arg3;
        }

        void copyRootViewBounds(View arg2) {
            this.mRootViewWidth = arg2.getWidth();
            this.mRootViewHeight = arg2.getHeight();
            Insets v2 = this.getVisibleInsets(arg2);
            if(v2 == null) {
                v2 = Insets.NONE;
            }

            this.setRootViewData(v2);
        }

        void copyWindowDataInto(WindowInsetsCompat arg2) {
            arg2.setRootWindowInsets(this.mRootWindowInsets);
            arg2.setRootViewData(this.mRootViewVisibleInsets);
            arg2.setSystemUiVisibility(this.mSystemUiVisibility);
            arg2.setDisplayShape(this.mDisplayShapeCompat);
            arg2.setTypeBoundingRectsMap(this.mTypeBoundingRectsMap);
            arg2.setTypeMaxBoundingRectsMap(this.mTypeMaxBoundingRectsMap);
        }

        private DisplayShapeCompat createDisplayShape(View arg12) {
            DisplayShapeCompat v0 = null;
            if(arg12 == null) {
                return v0;
            }

            Display v12 = arg12.getDisplay();
            if(v12 == null) {
                return v0;
            }

            Point v0_1 = new Point();
            v12.getRealSize(v0_1);
            if(this.mHost.isRound()) {
                return DisplayShapeCompat.create(v0_1.x, v0_1.y, true, 0, 0, 0, 0);
            }

            int v11 = 0;
            RoundedCornerCompat v1 = DisplayCompat.getRoundedCorner(v12, 0);
            RoundedCornerCompat v2 = DisplayCompat.getRoundedCorner(v12, 1);
            RoundedCornerCompat v3 = DisplayCompat.getRoundedCorner(v12, 2);
            RoundedCornerCompat v12_1 = DisplayCompat.getRoundedCorner(v12, 3);
            int v4 = v0_1.x;
            int v5 = v0_1.y;
            int v7 = v1 != null ? v1.getRadius() : 0;
            int v8 = v2 != null ? v2.getRadius() : 0;
            int v9 = v3 != null ? v3.getRadius() : 0;
            if(v12_1 != null) {
                v11 = v12_1.getRadius();
            }

            return DisplayShapeCompat.create(v4, v5, false, v7, v8, v9, v11);
        }

        public boolean equals(Object arg4) {
            if(!super.equals(arg4)) {
                return 0;
            }

            if((Objects.equals(this.mRootViewVisibleInsets, ((Impl20)arg4).mRootViewVisibleInsets)) && (Impl20.systemBarVisibilityEquals(this.mSystemUiVisibility, ((Impl20)arg4).mSystemUiVisibility))) {
                return 1;
            }

            return 0;
        }

        private static List getBoundingRects(Rect[][] arg6, int arg7) {
            Rect[] v0 = null;
            int v1;
            for(v1 = 1; v1 <= 0x200; v1 <<= 1) {
                if((arg7 & v1) == 0) {
                }
                else {
                    Rect[] v2 = arg6[Type.indexOf(v1)];
                    if(v2 == null) {
                    }
                    else if(v0 == null) {
                        v0 = v2;
                    }
                    else {
                        Rect[] v3 = new Rect[v0.length + v2.length];
                        System.arraycopy(v0, 0, v3, 0, v0.length);
                        System.arraycopy(v2, 0, v3, v0.length, v2.length);
                        v0 = v3;
                    }
                }
            }

            if(v0 == null) {
                return Collections.emptyList();
            }

            return Arrays.asList(((Object[])v0));
        }

        List getBoundingRects(int arg1) {
            return Impl20.getBoundingRects(this.mTypeBoundingRectsMap, arg1);
        }

        private Rect[] getBoundingRectsFromInsets(Insets arg7) {
            ArrayList v0 = new ArrayList();
            if(arg7.left != 0) {
                ((List)v0).add(new Rect(0, 0, arg7.left, this.mRootViewHeight));
            }

            if(arg7.top != 0) {
                ((List)v0).add(new Rect(0, 0, this.mRootViewWidth, arg7.top));
            }

            if(arg7.right != 0) {
                ((List)v0).add(new Rect(this.mRootViewWidth - arg7.right, 0, this.mRootViewWidth, this.mRootViewHeight));
            }

            if(arg7.bottom != 0) {
                ((List)v0).add(new Rect(0, this.mRootViewHeight - arg7.bottom, this.mRootViewWidth, this.mRootViewHeight));
            }

            return ((List)v0).toArray(new Rect[((List)v0).size()]);
        }

        List getBoundingRectsIgnoringVisibility(int arg1) {
            return Impl20.getBoundingRects(this.mTypeMaxBoundingRectsMap, arg1);
        }

        DisplayShapeCompat getDisplayShape() {
            DisplayShapeCompat v0 = this.mDisplayShapeCompat;
            if(v0 != null) {
                return v0;
            }

            return DisplayShapeCompat.EMPTY;
        }

        private Insets getInsets(int arg4, boolean arg5) {
            Insets v0 = Insets.NONE;
            int v1;
            for(v1 = 1; v1 <= 0x200; v1 <<= 1) {
                if((arg4 & v1) == 0) {
                }
                else {
                    v0 = Insets.max(v0, this.getInsetsForType(v1, arg5));
                }
            }

            return v0;
        }

        public Insets getInsets(int arg2) {
            return this.getInsets(arg2, false);
        }

        protected Insets getInsetsForType(int arg4, boolean arg5) {
            Insets v4_2;
            if(arg4 != 1) {
                Insets v0 = null;
                int v2 = 2;
                if(arg4 != v2) {
                    int v5 = 8;
                    if(arg4 != v5) {
                        if(arg4 != 16) {
                            if(arg4 != 0x20) {
                                if(arg4 != 0x40) {
                                    if(arg4 != 0x80) {
                                        return Insets.NONE;
                                    }

                                    WindowInsetsCompat v4 = this.mRootWindowInsets;
                                    DisplayCutoutCompat v3 = v4 != null ? v4.getDisplayCutout() : this.getDisplayCutout();
                                    if(v3 != null) {
                                        return Insets.of(v3.getSafeInsetLeft(), v3.getSafeInsetTop(), v3.getSafeInsetRight(), v3.getSafeInsetBottom());
                                    }

                                    return Insets.NONE;
                                }

                                return this.getTappableElementInsets();
                            }

                            return this.getMandatorySystemGestureInsets();
                        }

                        return this.getSystemGestureInsets();
                    }

                    Insets[] v4_1 = this.mOverriddenInsets;
                    if(v4_1 != null) {
                        v0 = v4_1[Type.indexOf(v5)];
                    }

                    if(v0 != null) {
                        return v0;
                    }

                    v4_2 = this.getSystemWindowInsets();
                    Insets v5_1 = this.getRootStableInsets();
                    if(v4_2.bottom > v5_1.bottom) {
                        return Insets.of(0, 0, 0, v4_2.bottom);
                    }

                    v4_2 = this.mRootViewVisibleInsets;
                    if(v4_2 != null && !v4_2.equals(Insets.NONE) && this.mRootViewVisibleInsets.bottom > v5_1.bottom) {
                        return Insets.of(0, 0, 0, this.mRootViewVisibleInsets.bottom);
                    }

                    return Insets.NONE;
                }

                if(arg5) {
                    v4_2 = this.getRootStableInsets();
                    Insets v3_1 = this.getStableInsets();
                    return Insets.of(Math.max(v4_2.left, v3_1.left), 0, Math.max(v4_2.right, v3_1.right), Math.max(v4_2.bottom, v3_1.bottom));
                }

                if((this.mSystemUiVisibility & v2) != 0) {
                    return Insets.NONE;
                }

                v4_2 = this.getSystemWindowInsets();
                WindowInsetsCompat v3_2 = this.mRootWindowInsets;
                if(v3_2 != null) {
                    v0 = v3_2.getStableInsets();
                }

                int v3_3 = v4_2.bottom;
                if(v0 != null) {
                    v3_3 = Math.min(v3_3, v0.bottom);
                }

                return Insets.of(v4_2.left, 0, v4_2.right, v3_3);
            }

            if(arg5) {
                return Insets.of(0, Math.max(this.getRootStableInsets().top, this.getSystemWindowInsets().top), 0, 0);
            }

            if((this.mSystemUiVisibility & 4) != 0) {
                return Insets.NONE;
            }

            return Insets.of(0, this.getSystemWindowInsets().top, 0, 0);
        }

        public Insets getInsetsIgnoringVisibility(int arg2) {
            return this.getInsets(arg2, true);
        }

        private Insets getRootStableInsets() {
            WindowInsetsCompat v0 = this.mRootWindowInsets;
            if(v0 != null) {
                return v0.getStableInsets();
            }

            return Insets.NONE;
        }

        final Insets getSystemWindowInsets() {
            Insets v0 = this.mSystemWindowInsets;
            if(v0 == null) {
                v0 = Insets.of(this.mPlatformInsets.getSystemWindowInsetLeft(), this.mPlatformInsets.getSystemWindowInsetTop(), this.mPlatformInsets.getSystemWindowInsetRight(), this.mPlatformInsets.getSystemWindowInsetBottom());
                this.mSystemWindowInsets = v0;
            }

            return v0;
        }

        private Insets getVisibleInsets(View arg4) {
            Insets v3_1;
            String v3 = "WindowInsetsCompat";
            if(Build$VERSION.SDK_INT < 30) {
                if(!Impl20.sVisibleRectReflectionFetched) {
                    Impl20.loadReflectionField();
                }

                Method v0 = Impl20.sGetViewRootImplMethod;
                Insets v1 = null;
                if(v0 != null && Impl20.sAttachInfoClass != null && Impl20.sVisibleInsetsField != null) {
                    try {
                        Object v4_1 = v0.invoke(arg4);
                        if(v4_1 == null) {
                            Log.w(v3, "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                            return v1;
                        }

                        v4_1 = Impl20.sVisibleInsetsField.get(Impl20.sAttachInfoField.get(v4_1));
                        if(v4_1 == null) {
                            return v1;
                        }

                        v3_1 = Insets.of(((Rect)v4_1));
                        return v3_1;
                    }
                    catch(ReflectiveOperationException v4) {
                        Log.e(((String)v3_1), "Failed to get visible insets. (Reflection error). " + v4.getMessage(), ((Throwable)v4));
                        return v1;
                    }

                    return v1;
                }

                return v1;
            }

            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        void initDisplayShape(View arg1) {
            this.mDisplayShapeCompat = this.createDisplayShape(arg1);
        }

        void initTypeBoundingRectsMaps() {
            int v0;
            for(v0 = 1; v0 <= 0x200; v0 <<= 1) {
                int v1 = Type.indexOf(v0);
                this.mTypeBoundingRectsMap[v1] = this.getBoundingRectsFromInsets(this.getInsets(v0));
                if(v0 != 8) {
                    this.mTypeMaxBoundingRectsMap[v1] = this.getBoundingRectsFromInsets(this.getInsetsIgnoringVisibility(v0));
                }
            }
        }

        WindowInsetsCompat inset(int arg3, int arg4, int arg5, int arg6) {
            Builder v0 = new Builder(WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets));
            v0.setSystemWindowInsets(WindowInsetsCompat.insetInsets(this.getSystemWindowInsets(), arg3, arg4, arg5, arg6));
            v0.setStableInsets(WindowInsetsCompat.insetInsets(this.getStableInsets(), arg3, arg4, arg5, arg6));
            return v0.build();
        }

        boolean isRound() {
            return this.mPlatformInsets.isRound();
        }

        protected boolean isTypeVisible(int arg4) {
            if(arg4 != 1 && arg4 != 2) {
                if(arg4 == 4) {
                    return 0;
                }
                else if(arg4 != 8 && arg4 != 0x80) {
                    return 1;
                }
            }

            return this.getInsetsForType(arg4, false).equals(Insets.NONE) ^ 1;
        }

        boolean isVisible(int arg4) {
            int v1;
            for(v1 = 1; v1 <= 0x200; v1 <<= 1) {
                if((arg4 & v1) == 0) {
                }
                else if(!this.isTypeVisible(v1)) {
                    return 0;
                }
            }

            return 1;
        }

        private static void loadReflectionField() {
            try {
                Impl20.sGetViewRootImplMethod = View.class.getDeclaredMethod("getViewRootImpl");
                Class v1_1 = Class.forName("android.view.View$AttachInfo");
                Impl20.sAttachInfoClass = v1_1;
                Impl20.sVisibleInsetsField = v1_1.getDeclaredField("mVisibleInsets");
                Impl20.sAttachInfoField = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                Impl20.sVisibleInsetsField.setAccessible(true);
                Impl20.sAttachInfoField.setAccessible(true);
            }
            catch(ReflectiveOperationException v1) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + v1.getMessage(), ((Throwable)v1));
            }

            Impl20.sVisibleRectReflectionFetched = true;
        }

        public void setDisplayShape(DisplayShapeCompat arg1) {
            this.mDisplayShapeCompat = arg1;
        }

        public void setOverriddenInsets(Insets[] arg1) {
            this.mOverriddenInsets = arg1;
        }

        void setRootViewData(Insets arg1) {
            this.mRootViewVisibleInsets = arg1;
        }

        void setRootWindowInsets(WindowInsetsCompat arg1) {
            this.mRootWindowInsets = arg1;
        }

        void setSystemUiVisibility(int arg1) {
            this.mSystemUiVisibility = arg1;
        }

        void setTypeBoundingRectsMap(Rect[][] arg1) {
            Objects.requireNonNull(arg1);
            this.mTypeBoundingRectsMap = arg1.clone();
        }

        void setTypeMaxBoundingRectsMap(Rect[][] arg1) {
            Objects.requireNonNull(arg1);
            this.mTypeMaxBoundingRectsMap = arg1.clone();
        }

        static boolean systemBarVisibilityEquals(int arg0, int arg1) {
            if((arg0 & 6) == (arg1 & 6)) {
                return 1;
            }

            return 0;
        }
    }

    class Impl21 extends Impl20 {
        private Insets mStableInsets;

        Impl21(WindowInsetsCompat arg1, WindowInsets arg2) {
            super(arg1, arg2);
            this.mStableInsets = null;
        }

        Impl21(WindowInsetsCompat arg1, Impl21 arg2) {
            super(arg1, ((Impl20)arg2));
            this.mStableInsets = null;
            this.mStableInsets = arg2.mStableInsets;
        }

        WindowInsetsCompat consumeStableInsets() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeStableInsets());
        }

        WindowInsetsCompat consumeSystemWindowInsets() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeSystemWindowInsets());
        }

        final Insets getStableInsets() {
            Insets v0 = this.mStableInsets;
            if(v0 == null) {
                v0 = Insets.of(this.mPlatformInsets.getStableInsetLeft(), this.mPlatformInsets.getStableInsetTop(), this.mPlatformInsets.getStableInsetRight(), this.mPlatformInsets.getStableInsetBottom());
                this.mStableInsets = v0;
            }

            return v0;
        }

        boolean isConsumed() {
            return this.mPlatformInsets.isConsumed();
        }

        public void setStableInsets(Insets arg1) {
            this.mStableInsets = arg1;
        }
    }

    class Impl28 extends Impl21 {
        Impl28(WindowInsetsCompat arg1, WindowInsets arg2) {
            super(arg1, arg2);
        }

        Impl28(WindowInsetsCompat arg1, Impl28 arg2) {
            super(arg1, ((Impl21)arg2));
        }

        WindowInsetsCompat consumeDisplayCutout() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeDisplayCutout());
        }

        public boolean equals(Object arg5) {
            if(this == (((Impl28)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof Impl28)) {
                return 0;
            }

            if((Objects.equals(this.mPlatformInsets, ((Impl28)arg5).mPlatformInsets)) && (Objects.equals(this.mRootViewVisibleInsets, ((Impl28)arg5).mRootViewVisibleInsets)) && (Impl28.systemBarVisibilityEquals(this.mSystemUiVisibility, ((Impl28)arg5).mSystemUiVisibility))) {
                return 1;
            }

            return 0;
        }

        DisplayCutoutCompat getDisplayCutout() {
            return DisplayCutoutCompat.wrap(this.mPlatformInsets.getDisplayCutout());
        }

        public int hashCode() {
            return this.mPlatformInsets.hashCode();
        }
    }

    class Impl29 extends Impl28 {
        private Insets mMandatorySystemGestureInsets;
        private Insets mSystemGestureInsets;
        private Insets mTappableElementInsets;

        Impl29(WindowInsetsCompat arg1, WindowInsets arg2) {
            super(arg1, arg2);
            this.mSystemGestureInsets = null;
            this.mMandatorySystemGestureInsets = null;
            this.mTappableElementInsets = null;
        }

        Impl29(WindowInsetsCompat arg1, Impl29 arg2) {
            super(arg1, ((Impl28)arg2));
            this.mSystemGestureInsets = null;
            this.mMandatorySystemGestureInsets = null;
            this.mTappableElementInsets = null;
        }

        Insets getMandatorySystemGestureInsets() {
            Insets v0 = this.mMandatorySystemGestureInsets;
            if(v0 == null) {
                v0 = Insets.toCompatInsets(this.mPlatformInsets.getMandatorySystemGestureInsets());
                this.mMandatorySystemGestureInsets = v0;
            }

            return v0;
        }

        Insets getSystemGestureInsets() {
            Insets v0 = this.mSystemGestureInsets;
            if(v0 == null) {
                v0 = Insets.toCompatInsets(this.mPlatformInsets.getSystemGestureInsets());
                this.mSystemGestureInsets = v0;
            }

            return v0;
        }

        Insets getTappableElementInsets() {
            Insets v0 = this.mTappableElementInsets;
            if(v0 == null) {
                v0 = Insets.toCompatInsets(this.mPlatformInsets.getTappableElementInsets());
                this.mTappableElementInsets = v0;
            }

            return v0;
        }

        WindowInsetsCompat inset(int arg1, int arg2, int arg3, int arg4) {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.inset(arg1, arg2, arg3, arg4));
        }

        public void setStableInsets(Insets arg1) {
        }
    }

    class Impl30 extends Impl29 {
        static final WindowInsetsCompat CONSUMED;

        static {
            Impl30.CONSUMED = WindowInsetsCompat.toWindowInsetsCompat(WindowInsets.CONSUMED);
        }

        Impl30(WindowInsetsCompat arg1, WindowInsets arg2) {
            super(arg1, arg2);
        }

        Impl30(WindowInsetsCompat arg1, Impl30 arg2) {
            super(arg1, ((Impl29)arg2));
        }

        final void copyRootViewBounds(View arg1) {
        }

        public Insets getInsets(int arg1) {
            return Insets.toCompatInsets(this.mPlatformInsets.getInsets(TypeImpl30.toPlatformType(arg1)));
        }

        public Insets getInsetsIgnoringVisibility(int arg1) {
            return Insets.toCompatInsets(this.mPlatformInsets.getInsetsIgnoringVisibility(TypeImpl30.toPlatformType(arg1)));
        }

        public boolean isVisible(int arg1) {
            return this.mPlatformInsets.isVisible(TypeImpl30.toPlatformType(arg1));
        }
    }

    class Impl31 extends Impl30 {
        Impl31(WindowInsetsCompat arg1, WindowInsets arg2) {
            super(arg1, arg2);
        }

        Impl31(WindowInsetsCompat arg1, Impl31 arg2) {
            super(arg1, ((Impl30)arg2));
        }

        Rect getPrivacyIndicatorBounds() {
            Rect v1 = this.mPlatformInsets.getPrivacyIndicatorBounds();
            if(v1 != null) {
                return new Rect(v1);
            }

            return null;
        }

        RoundedCornerCompat getRoundedCorner(int arg1) {
            return RoundedCornerCompat.toRoundedCornerCompat(this.mPlatformInsets.getRoundedCorner(arg1));
        }
    }

    class Impl34 extends Impl31 {
        static final WindowInsetsCompat CONSUMED;

        static {
            Impl34.CONSUMED = WindowInsetsCompat.toWindowInsetsCompat(WindowInsets.CONSUMED);
        }

        Impl34(WindowInsetsCompat arg1, WindowInsets arg2) {
            super(arg1, arg2);
        }

        Impl34(WindowInsetsCompat arg1, Impl34 arg2) {
            super(arg1, ((Impl31)arg2));
        }

        DisplayShapeCompat getDisplayShape() {
            if(this.mDisplayShapeCompat != null) {
                return this.mDisplayShapeCompat;
            }

            return DisplayShapeCompat.toDisplayShapeCompat(this.mPlatformInsets.getDisplayShape());
        }

        public Insets getInsets(int arg1) {
            return Insets.toCompatInsets(this.mPlatformInsets.getInsets(TypeImpl34.toPlatformType(arg1)));
        }

        public Insets getInsetsIgnoringVisibility(int arg1) {
            return Insets.toCompatInsets(this.mPlatformInsets.getInsetsIgnoringVisibility(TypeImpl34.toPlatformType(arg1)));
        }

        void initDisplayShape(View arg1) {
        }

        public boolean isVisible(int arg1) {
            return this.mPlatformInsets.isVisible(TypeImpl34.toPlatformType(arg1));
        }
    }

    class Impl35 extends Impl34 {
        Impl35(WindowInsetsCompat arg1, WindowInsets arg2) {
            super(arg1, arg2);
        }

        Impl35(WindowInsetsCompat arg1, Impl35 arg2) {
            super(arg1, ((Impl34)arg2));
        }

        List getBoundingRects(int arg1) {
            return this.mPlatformInsets.getBoundingRects(TypeImpl34.toPlatformType(arg1));
        }

        List getBoundingRectsIgnoringVisibility(int arg1) {
            return this.mPlatformInsets.getBoundingRectsIgnoringVisibility(TypeImpl34.toPlatformType(arg1));
        }

        void initTypeBoundingRectsMaps() {
        }
    }

    class Impl {
        static final WindowInsetsCompat CONSUMED;
        final WindowInsetsCompat mHost;

        static {
            Impl.CONSUMED = new Builder().build().consumeDisplayCutout().consumeStableInsets().consumeSystemWindowInsets();
        }

        Impl(WindowInsetsCompat arg1) {
            super();
            this.mHost = arg1;
        }

        WindowInsetsCompat consumeDisplayCutout() {
            return this.mHost;
        }

        WindowInsetsCompat consumeStableInsets() {
            return this.mHost;
        }

        WindowInsetsCompat consumeSystemWindowInsets() {
            return this.mHost;
        }

        void copyRootViewBounds(View arg1) {
        }

        void copyWindowDataInto(WindowInsetsCompat arg1) {
        }

        public boolean equals(Object arg5) {
            if(this == (((Impl)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof Impl)) {
                return 0;
            }

            if(this.isRound() == ((Impl)arg5).isRound() && this.isConsumed() == ((Impl)arg5).isConsumed() && (ObjectsCompat.equals(this.getSystemWindowInsets(), ((Impl)arg5).getSystemWindowInsets())) && (ObjectsCompat.equals(this.getStableInsets(), ((Impl)arg5).getStableInsets())) && (ObjectsCompat.equals(this.getDisplayCutout(), ((Impl)arg5).getDisplayCutout()))) {
                return 1;
            }

            return 0;
        }

        List getBoundingRects(int arg1) {
            return Collections.emptyList();
        }

        List getBoundingRectsIgnoringVisibility(int arg1) {
            return Collections.emptyList();
        }

        DisplayCutoutCompat getDisplayCutout() {
            return null;
        }

        DisplayShapeCompat getDisplayShape() {
            return DisplayShapeCompat.EMPTY;
        }

        Insets getInsets(int arg1) {
            return Insets.NONE;
        }

        Insets getInsetsIgnoringVisibility(int arg1) {
            if((arg1 & 8) == 0) {
                return Insets.NONE;
            }

            throw new IllegalArgumentException("Unable to query the maximum insets for IME");
        }

        Insets getMandatorySystemGestureInsets() {
            return this.getSystemWindowInsets();
        }

        Rect getPrivacyIndicatorBounds() {
            return null;
        }

        RoundedCornerCompat getRoundedCorner(int arg1) {
            return null;
        }

        Insets getStableInsets() {
            return Insets.NONE;
        }

        Insets getSystemGestureInsets() {
            return this.getSystemWindowInsets();
        }

        Insets getSystemWindowInsets() {
            return Insets.NONE;
        }

        Insets getTappableElementInsets() {
            return this.getSystemWindowInsets();
        }

        public int hashCode() {
            return ObjectsCompat.hash(new Object[]{Boolean.valueOf(this.isRound()), Boolean.valueOf(this.isConsumed()), this.getSystemWindowInsets(), this.getStableInsets(), this.getDisplayCutout()});
        }

        void initDisplayShape(View arg1) {
        }

        void initTypeBoundingRectsMaps() {
        }

        WindowInsetsCompat inset(int arg1, int arg2, int arg3, int arg4) {
            return Impl.CONSUMED;
        }

        boolean isConsumed() {
            return 0;
        }

        boolean isRound() {
            return 0;
        }

        boolean isVisible(int arg1) {
            return 1;
        }

        public void setDisplayShape(DisplayShapeCompat arg1) {
        }

        public void setOverriddenInsets(Insets[] arg1) {
        }

        void setRootViewData(Insets arg1) {
        }

        void setRootWindowInsets(WindowInsetsCompat arg1) {
        }

        public void setStableInsets(Insets arg1) {
        }

        void setSystemUiVisibility(int arg1) {
        }

        void setTypeBoundingRectsMap(Rect[][] arg1) {
        }

        void setTypeMaxBoundingRectsMap(Rect[][] arg1) {
        }
    }

    public final class Side {
        @Retention(value=RetentionPolicy.SOURCE) @public interface InsetsSide {
        }

        public static final int BOTTOM = 8;
        public static final int LEFT = 1;
        public static final int RIGHT = 4;
        public static final int TOP = 2;

        private Side() {
            super();
        }

        public static int all() {
            return 15;
        }
    }

    public final class Type {
        @Retention(value=RetentionPolicy.SOURCE) @public interface InsetsType {
        }

        static final int CAPTION_BAR = 4;
        static final int DISPLAY_CUTOUT = 0x80;
        static final int FIRST = 1;
        static final int IME = 8;
        static final int LAST = 0x200;
        static final int MANDATORY_SYSTEM_GESTURES = 0x20;
        static final int NAVIGATION_BARS = 2;
        static final int SIZE = 10;
        static final int STATUS_BARS = 1;
        static final int SYSTEM_GESTURES = 16;
        static final int SYSTEM_OVERLAYS = 0x200;
        static final int TAPPABLE_ELEMENT = 0x40;
        static final int WINDOW_DECOR = 0x100;

        private Type() {
            super();
        }

        static int all() {
            return -1;
        }

        public static int captionBar() {
            return 4;
        }

        public static int displayCutout() {
            return 0x80;
        }

        public static int ime() {
            return 8;
        }

        static int indexOf(int arg3) {
            if(arg3 != 1) {
                int v1 = 2;
                if(arg3 != v1) {
                    int v0 = 4;
                    if(arg3 != v0) {
                        v1 = 8;
                        if(arg3 != v1) {
                            if(arg3 != 16) {
                                if(arg3 != 0x20) {
                                    if(arg3 != 0x40) {
                                        if(arg3 != 0x80) {
                                            if(arg3 != 0x100) {
                                                if(arg3 == 0x200) {
                                                    return 9;
                                                }

                                                throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + arg3);
                                            }

                                            return v1;
                                        }

                                        return 7;
                                    }

                                    return 6;
                                }

                                return 5;
                            }

                            return v0;
                        }

                        return 3;
                    }

                    return v1;
                }

                return 1;
            }

            return 0;
        }

        public static int mandatorySystemGestures() {
            return 0x20;
        }

        public static int navigationBars() {
            return 2;
        }

        public static int statusBars() {
            return 1;
        }

        public static int systemBars() {
            return 0x207;
        }

        public static int systemGestures() {
            return 16;
        }

        public static int systemOverlays() {
            return 0x200;
        }

        public static int tappableElement() {
            return 0x40;
        }
    }

    final class TypeImpl30 {
        private TypeImpl30() {
            super();
        }

        static int toPlatformType(int arg4) {
            int v3;
            int v0 = 0;
            int v2;
            for(v2 = 1; v2 <= 0x200; v2 <<= 1) {
                if((arg4 & v2) != 0) {
                    if(v2 == 1) {
                        v3 = WindowInsets$Type.statusBars();
                    }
                    else if(v2 == 2) {
                        v3 = WindowInsets$Type.navigationBars();
                    }
                    else if(v2 == 4) {
                        v3 = WindowInsets$Type.captionBar();
                    }
                    else if(v2 == 8) {
                        v3 = WindowInsets$Type.ime();
                    }
                    else if(v2 == 16) {
                        v3 = WindowInsets$Type.systemGestures();
                    }
                    else if(v2 == 0x20) {
                        v3 = WindowInsets$Type.mandatorySystemGestures();
                    }
                    else if(v2 == 0x40) {
                        v3 = WindowInsets$Type.tappableElement();
                    }
                    else if(v2 != 0x80) {
                        goto label_39;
                    }
                    else {
                        v3 = WindowInsets$Type.displayCutout();
                    }

                    v0 |= v3;
                }

            label_39:
            }

            return v0;
        }
    }

    final class TypeImpl34 {
        private TypeImpl34() {
            super();
        }

        static int toPlatformType(int arg5) {
            int v0 = 0;
            int v2;
            for(v2 = 1; true; v2 <<= 1) {
                int v3 = 0x200;
                if(v2 > v3) {
                    return v0;
                }

                if((arg5 & v2) != 0) {
                    if(v2 == 1) {
                        v3 = WindowInsets$Type.statusBars();
                    }
                    else if(v2 == 2) {
                        v3 = WindowInsets$Type.navigationBars();
                    }
                    else if(v2 == 4) {
                        v3 = WindowInsets$Type.captionBar();
                    }
                    else if(v2 == 8) {
                        v3 = WindowInsets$Type.ime();
                    }
                    else if(v2 == 16) {
                        v3 = WindowInsets$Type.systemGestures();
                    }
                    else if(v2 == 0x20) {
                        v3 = WindowInsets$Type.mandatorySystemGestures();
                    }
                    else if(v2 == 0x40) {
                        v3 = WindowInsets$Type.tappableElement();
                    }
                    else if(v2 == 0x80) {
                        v3 = WindowInsets$Type.displayCutout();
                    }
                    else if(v2 != v3) {
                        goto label_42;
                    }
                    else {
                        v3 = WindowInsets$Type.systemOverlays();
                    }

                    v0 |= v3;
                }

            label_42:
            }

            return v0;
        }
    }

    public static final WindowInsetsCompat CONSUMED = null;
    private static final String TAG = "WindowInsetsCompat";
    private final Impl mImpl;

    static {
        if(Build$VERSION.SDK_INT >= 34) {
            WindowInsetsCompat.CONSUMED = Impl34.CONSUMED;
            return;
        }

        if(Build$VERSION.SDK_INT >= 30) {
            WindowInsetsCompat.CONSUMED = Impl30.CONSUMED;
            return;
        }

        WindowInsetsCompat.CONSUMED = Impl.CONSUMED;
    }

    public WindowInsetsCompat(WindowInsetsCompat arg3) {
        super();
        if(arg3 != null) {
            Impl v3 = arg3.mImpl;
            if(Build$VERSION.SDK_INT < 35 || !(v3 instanceof Impl35)) {
                if(Build$VERSION.SDK_INT >= 34 && ((v3 instanceof Impl34))) {
                    this.mImpl = new Impl34(this, v3);
                    goto label_80;
                }

                if(Build$VERSION.SDK_INT >= 0x1F && ((v3 instanceof Impl31))) {
                    this.mImpl = new Impl31(this, v3);
                    goto label_80;
                }

                if(Build$VERSION.SDK_INT >= 30 && ((v3 instanceof Impl30))) {
                    this.mImpl = new Impl30(this, v3);
                    goto label_80;
                }

                if(Build$VERSION.SDK_INT >= 29 && ((v3 instanceof Impl29))) {
                    this.mImpl = new Impl29(this, v3);
                    goto label_80;
                }

                if(Build$VERSION.SDK_INT >= 28 && ((v3 instanceof Impl28))) {
                    this.mImpl = new Impl28(this, v3);
                    goto label_80;
                }

                if((v3 instanceof Impl21)) {
                    this.mImpl = new Impl21(this, v3);
                    goto label_80;
                }

                if((v3 instanceof Impl20)) {
                    this.mImpl = new Impl20(this, v3);
                    goto label_80;
                }

                this.mImpl = new Impl(this);
            }
            else {
                this.mImpl = new Impl35(this, v3);
            }

        label_80:
            v3.copyWindowDataInto(this);
            return;
        }

        this.mImpl = new Impl(this);
    }

    private WindowInsetsCompat(WindowInsets arg3) {
        super();
        if(Build$VERSION.SDK_INT >= 35) {
            this.mImpl = new Impl35(this, arg3);
            return;
        }

        if(Build$VERSION.SDK_INT >= 34) {
            this.mImpl = new Impl34(this, arg3);
            return;
        }

        if(Build$VERSION.SDK_INT >= 0x1F) {
            this.mImpl = new Impl31(this, arg3);
            return;
        }

        if(Build$VERSION.SDK_INT >= 30) {
            this.mImpl = new Impl30(this, arg3);
            return;
        }

        if(Build$VERSION.SDK_INT >= 29) {
            this.mImpl = new Impl29(this, arg3);
            return;
        }

        if(Build$VERSION.SDK_INT >= 28) {
            this.mImpl = new Impl28(this, arg3);
            return;
        }

        this.mImpl = new Impl21(this, arg3);
    }

    @Deprecated public WindowInsetsCompat consumeDisplayCutout() {
        return this.mImpl.consumeDisplayCutout();
    }

    @Deprecated public WindowInsetsCompat consumeStableInsets() {
        return this.mImpl.consumeStableInsets();
    }

    @Deprecated public WindowInsetsCompat consumeSystemWindowInsets() {
        return this.mImpl.consumeSystemWindowInsets();
    }

    public boolean equals(Object arg2) {
        if(this == (((WindowInsetsCompat)arg2))) {
            return 1;
        }

        if(!(arg2 instanceof WindowInsetsCompat)) {
            return 0;
        }

        return ObjectsCompat.equals(this.mImpl, ((WindowInsetsCompat)arg2).mImpl);
    }

    public List getBoundingRects(int arg1) {
        return this.mImpl.getBoundingRects(arg1);
    }

    public List getBoundingRectsIgnoringVisibility(int arg1) {
        return this.mImpl.getBoundingRectsIgnoringVisibility(arg1);
    }

    public DisplayCutoutCompat getDisplayCutout() {
        return this.mImpl.getDisplayCutout();
    }

    public DisplayShapeCompat getDisplayShape() {
        return this.mImpl.getDisplayShape();
    }

    public Insets getInsets(int arg1) {
        return this.mImpl.getInsets(arg1);
    }

    public Insets getInsetsIgnoringVisibility(int arg1) {
        return this.mImpl.getInsetsIgnoringVisibility(arg1);
    }

    @Deprecated public Insets getMandatorySystemGestureInsets() {
        return this.mImpl.getMandatorySystemGestureInsets();
    }

    public Rect getPrivacyIndicatorBounds() {
        return this.mImpl.getPrivacyIndicatorBounds();
    }

    public RoundedCornerCompat getRoundedCorner(int arg1) {
        return this.mImpl.getRoundedCorner(arg1);
    }

    @Deprecated public int getStableInsetBottom() {
        return this.mImpl.getStableInsets().bottom;
    }

    @Deprecated public int getStableInsetLeft() {
        return this.mImpl.getStableInsets().left;
    }

    @Deprecated public int getStableInsetRight() {
        return this.mImpl.getStableInsets().right;
    }

    @Deprecated public int getStableInsetTop() {
        return this.mImpl.getStableInsets().top;
    }

    @Deprecated public Insets getStableInsets() {
        return this.mImpl.getStableInsets();
    }

    @Deprecated public Insets getSystemGestureInsets() {
        return this.mImpl.getSystemGestureInsets();
    }

    @Deprecated public int getSystemWindowInsetBottom() {
        return this.mImpl.getSystemWindowInsets().bottom;
    }

    @Deprecated public int getSystemWindowInsetLeft() {
        return this.mImpl.getSystemWindowInsets().left;
    }

    @Deprecated public int getSystemWindowInsetRight() {
        return this.mImpl.getSystemWindowInsets().right;
    }

    @Deprecated public int getSystemWindowInsetTop() {
        return this.mImpl.getSystemWindowInsets().top;
    }

    @Deprecated public Insets getSystemWindowInsets() {
        return this.mImpl.getSystemWindowInsets();
    }

    @Deprecated public Insets getTappableElementInsets() {
        return this.mImpl.getTappableElementInsets();
    }

    public boolean hasInsets() {
        if((this.getInsets(Type.all()).equals(Insets.NONE)) && (this.getInsetsIgnoringVisibility(Type.all() ^ Type.ime()).equals(Insets.NONE))) {
            if(this.getDisplayCutout() != null) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    @Deprecated public boolean hasStableInsets() {
        return this.mImpl.getStableInsets().equals(Insets.NONE) ^ 1;
    }

    @Deprecated public boolean hasSystemWindowInsets() {
        return this.mImpl.getSystemWindowInsets().equals(Insets.NONE) ^ 1;
    }

    public int hashCode() {
        Impl v0 = this.mImpl;
        if(v0 == null) {
            return 0;
        }

        return v0.hashCode();
    }

    void init(View arg2) {
        this.mImpl.copyRootViewBounds(arg2);
        this.mImpl.initDisplayShape(arg2);
        this.mImpl.initTypeBoundingRectsMaps();
    }

    public WindowInsetsCompat inset(int arg1, int arg2, int arg3, int arg4) {
        return this.mImpl.inset(arg1, arg2, arg3, arg4);
    }

    public WindowInsetsCompat inset(Insets arg4) {
        return this.inset(arg4.left, arg4.top, arg4.right, arg4.bottom);
    }

    static Insets insetInsets(Insets arg5, int arg6, int arg7, int arg8, int arg9) {
        int v0 = Math.max(0, arg5.left - arg6);
        int v2 = Math.max(0, arg5.top - arg7);
        int v3 = Math.max(0, arg5.right - arg8);
        int v1 = Math.max(0, arg5.bottom - arg9);
        if(v0 == arg6 && v2 == arg7 && v3 == arg8 && v1 == arg9) {
            return arg5;
        }

        return Insets.of(v0, v2, v3, v1);
    }

    public boolean isConsumed() {
        return this.mImpl.isConsumed();
    }

    public boolean isRound() {
        return this.mImpl.isRound();
    }

    public boolean isVisible(int arg1) {
        return this.mImpl.isVisible(arg1);
    }

    @Deprecated public WindowInsetsCompat replaceSystemWindowInsets(int arg2, int arg3, int arg4, int arg5) {
        return new Builder(this).setSystemWindowInsets(Insets.of(arg2, arg3, arg4, arg5)).build();
    }

    @Deprecated public WindowInsetsCompat replaceSystemWindowInsets(Rect arg2) {
        return new Builder(this).setSystemWindowInsets(Insets.of(arg2)).build();
    }

    void setDisplayShape(DisplayShapeCompat arg1) {
        this.mImpl.setDisplayShape(arg1);
    }

    void setOverriddenInsets(Insets[] arg1) {
        this.mImpl.setOverriddenInsets(arg1);
    }

    void setRootViewData(Insets arg1) {
        this.mImpl.setRootViewData(arg1);
    }

    void setRootWindowInsets(WindowInsetsCompat arg1) {
        this.mImpl.setRootWindowInsets(arg1);
    }

    void setStableInsets(Insets arg1) {
        this.mImpl.setStableInsets(arg1);
    }

    void setSystemUiVisibility(int arg1) {
        this.mImpl.setSystemUiVisibility(arg1);
    }

    void setTypeBoundingRectsMap(Rect[][] arg1) {
        this.mImpl.setTypeBoundingRectsMap(arg1);
    }

    void setTypeMaxBoundingRectsMap(Rect[][] arg1) {
        this.mImpl.setTypeMaxBoundingRectsMap(arg1);
    }

    public WindowInsets toWindowInsets() {
        Impl v1 = this.mImpl;
        if((v1 instanceof Impl20)) {
            return ((Impl20)v1).mPlatformInsets;
        }

        return null;
    }

    public static WindowInsetsCompat toWindowInsetsCompat(WindowInsets arg1, View arg2) {
        WindowInsetsCompat v0 = new WindowInsetsCompat(Preconditions.checkNotNull(arg1));
        if(arg2 != null && (arg2.isAttachedToWindow())) {
            v0.setRootWindowInsets(ViewCompat.getRootWindowInsets(arg2));
            v0.init(arg2.getRootView());
            v0.setSystemUiVisibility(arg2.getWindowSystemUiVisibility());
        }

        return v0;
    }

    public static WindowInsetsCompat toWindowInsetsCompat(WindowInsets arg1) {
        return WindowInsetsCompat.toWindowInsetsCompat(arg1, null);
    }
}

