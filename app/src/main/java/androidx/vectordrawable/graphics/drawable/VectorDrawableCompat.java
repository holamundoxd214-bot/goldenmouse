package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint$Cap;
import android.graphics.Paint$Join;
import android.graphics.Paint$Style;
import android.graphics.Paint;
import android.graphics.Path$FillType;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff$Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable$ConstantState;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser$PathDataNode;
import androidx.core.graphics.PathParser;
import androidx.core.graphics.drawable.DrawableCompat;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class VectorDrawableCompat extends VectorDrawableCommon {
    class androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$1 {
    }

    class VClipPath extends VPath {
        VClipPath() {
            super();
        }

        VClipPath(VClipPath arg1) {
            super(((VPath)arg1));
        }

        public void inflate(Resources arg2, AttributeSet arg3, Resources$Theme arg4, XmlPullParser arg5) {
            if(!TypedArrayUtils.hasAttribute(arg5, "pathData")) {
                return;
            }

            TypedArray v2 = TypedArrayUtils.obtainAttributes(arg2, arg4, arg3, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_CLIP_PATH);
            this.updateStateFromTypedArray(v2, arg5);
            v2.recycle();
        }

        public boolean isClipPath() {
            return 1;
        }

        private void updateStateFromTypedArray(TypedArray arg4, XmlPullParser arg5) {
            String v1 = arg4.getString(0);
            if(v1 != null) {
                this.mPathName = v1;
            }

            v1 = arg4.getString(1);
            if(v1 != null) {
                this.mNodes = PathParser.createNodesFromPathData(v1);
            }

            this.mFillRule = TypedArrayUtils.getNamedInt(arg4, arg5, "fillType", 2, 0);
        }
    }

    class VFullPath extends VPath {
        float mFillAlpha;
        ComplexColorCompat mFillColor;
        float mStrokeAlpha;
        ComplexColorCompat mStrokeColor;
        Paint$Cap mStrokeLineCap;
        Paint$Join mStrokeLineJoin;
        float mStrokeMiterlimit;
        float mStrokeWidth;
        private int[] mThemeAttrs;
        float mTrimPathEnd;
        float mTrimPathOffset;
        float mTrimPathStart;

        VFullPath() {
            super();
            this.mStrokeWidth = 0f;
            this.mStrokeAlpha = 1f;
            this.mFillAlpha = 1f;
            this.mTrimPathStart = 0f;
            this.mTrimPathEnd = 1f;
            this.mTrimPathOffset = 0f;
            this.mStrokeLineCap = Paint$Cap.BUTT;
            this.mStrokeLineJoin = Paint$Join.MITER;
            this.mStrokeMiterlimit = 4f;
        }

        VFullPath(VFullPath arg3) {
            super(((VPath)arg3));
            this.mStrokeWidth = 0f;
            this.mStrokeAlpha = 1f;
            this.mFillAlpha = 1f;
            this.mTrimPathStart = 0f;
            this.mTrimPathEnd = 1f;
            this.mTrimPathOffset = 0f;
            this.mStrokeLineCap = Paint$Cap.BUTT;
            this.mStrokeLineJoin = Paint$Join.MITER;
            this.mStrokeMiterlimit = 4f;
            this.mThemeAttrs = arg3.mThemeAttrs;
            this.mStrokeColor = arg3.mStrokeColor;
            this.mStrokeWidth = arg3.mStrokeWidth;
            this.mStrokeAlpha = arg3.mStrokeAlpha;
            this.mFillColor = arg3.mFillColor;
            this.mFillRule = arg3.mFillRule;
            this.mFillAlpha = arg3.mFillAlpha;
            this.mTrimPathStart = arg3.mTrimPathStart;
            this.mTrimPathEnd = arg3.mTrimPathEnd;
            this.mTrimPathOffset = arg3.mTrimPathOffset;
            this.mStrokeLineCap = arg3.mStrokeLineCap;
            this.mStrokeLineJoin = arg3.mStrokeLineJoin;
            this.mStrokeMiterlimit = arg3.mStrokeMiterlimit;
        }

        public void applyTheme(Resources$Theme arg1) {
        }

        public boolean canApplyTheme() {
            if(this.mThemeAttrs != null) {
                return 1;
            }

            return 0;
        }

        float getFillAlpha() {
            return this.mFillAlpha;
        }

        int getFillColor() {
            return this.mFillColor.getColor();
        }

        float getStrokeAlpha() {
            return this.mStrokeAlpha;
        }

        int getStrokeColor() {
            return this.mStrokeColor.getColor();
        }

        private Paint$Cap getStrokeLineCap(int arg1, Paint$Cap arg2) {
            if(arg1 != 0) {
                if(arg1 != 1) {
                    if(arg1 != 2) {
                        return arg2;
                    }

                    return Paint$Cap.SQUARE;
                }

                return Paint$Cap.ROUND;
            }

            return Paint$Cap.BUTT;
        }

        private Paint$Join getStrokeLineJoin(int arg1, Paint$Join arg2) {
            if(arg1 != 0) {
                if(arg1 != 1) {
                    if(arg1 != 2) {
                        return arg2;
                    }

                    return Paint$Join.BEVEL;
                }

                return Paint$Join.ROUND;
            }

            return Paint$Join.MITER;
        }

        float getStrokeWidth() {
            return this.mStrokeWidth;
        }

        float getTrimPathEnd() {
            return this.mTrimPathEnd;
        }

        float getTrimPathOffset() {
            return this.mTrimPathOffset;
        }

        float getTrimPathStart() {
            return this.mTrimPathStart;
        }

        public void inflate(Resources arg2, AttributeSet arg3, Resources$Theme arg4, XmlPullParser arg5) {
            TypedArray v2 = TypedArrayUtils.obtainAttributes(arg2, arg4, arg3, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_PATH);
            this.updateStateFromTypedArray(v2, arg5, arg4);
            v2.recycle();
        }

        public boolean isStateful() {
            if(!this.mFillColor.isStateful()) {
                if(this.mStrokeColor.isStateful()) {
                }
                else {
                    return 0;
                }
            }

            return 1;
        }

        public boolean onStateChanged(int[] arg2) {
            return this.mStrokeColor.onStateChanged(arg2) | this.mFillColor.onStateChanged(arg2);
        }

        void setFillAlpha(float arg1) {
            this.mFillAlpha = arg1;
        }

        void setFillColor(int arg1) {
            this.mFillColor.setColor(arg1);
        }

        void setStrokeAlpha(float arg1) {
            this.mStrokeAlpha = arg1;
        }

        void setStrokeColor(int arg1) {
            this.mStrokeColor.setColor(arg1);
        }

        void setStrokeWidth(float arg1) {
            this.mStrokeWidth = arg1;
        }

        void setTrimPathEnd(float arg1) {
            this.mTrimPathEnd = arg1;
        }

        void setTrimPathOffset(float arg1) {
            this.mTrimPathOffset = arg1;
        }

        void setTrimPathStart(float arg1) {
            this.mTrimPathStart = arg1;
        }

        private void updateStateFromTypedArray(TypedArray arg8, XmlPullParser arg9, Resources$Theme arg10) {
            this.mThemeAttrs = null;
            if(!TypedArrayUtils.hasAttribute(arg9, "pathData")) {
                return;
            }

            String v0 = arg8.getString(0);
            if(v0 != null) {
                this.mPathName = v0;
            }

            v0 = arg8.getString(2);
            if(v0 != null) {
                this.mNodes = PathParser.createNodesFromPathData(v0);
            }

            this.mFillColor = TypedArrayUtils.getNamedComplexColor(arg8, arg9, arg10, "fillColor", 1, 0);
            this.mFillAlpha = TypedArrayUtils.getNamedFloat(arg8, arg9, "fillAlpha", 12, this.mFillAlpha);
            this.mStrokeLineCap = this.getStrokeLineCap(TypedArrayUtils.getNamedInt(arg8, arg9, "strokeLineCap", 8, -1), this.mStrokeLineCap);
            this.mStrokeLineJoin = this.getStrokeLineJoin(TypedArrayUtils.getNamedInt(arg8, arg9, "strokeLineJoin", 9, -1), this.mStrokeLineJoin);
            this.mStrokeMiterlimit = TypedArrayUtils.getNamedFloat(arg8, arg9, "strokeMiterLimit", 10, this.mStrokeMiterlimit);
            this.mStrokeColor = TypedArrayUtils.getNamedComplexColor(arg8, arg9, arg10, "strokeColor", 3, 0);
            this.mStrokeAlpha = TypedArrayUtils.getNamedFloat(arg8, arg9, "strokeAlpha", 11, this.mStrokeAlpha);
            this.mStrokeWidth = TypedArrayUtils.getNamedFloat(arg8, arg9, "strokeWidth", 4, this.mStrokeWidth);
            this.mTrimPathEnd = TypedArrayUtils.getNamedFloat(arg8, arg9, "trimPathEnd", 6, this.mTrimPathEnd);
            this.mTrimPathOffset = TypedArrayUtils.getNamedFloat(arg8, arg9, "trimPathOffset", 7, this.mTrimPathOffset);
            this.mTrimPathStart = TypedArrayUtils.getNamedFloat(arg8, arg9, "trimPathStart", 5, this.mTrimPathStart);
            this.mFillRule = TypedArrayUtils.getNamedInt(arg8, arg9, "fillType", 13, this.mFillRule);
        }
    }

    class VGroup extends VObject {
        int mChangingConfigurations;
        final ArrayList mChildren;
        private String mGroupName;
        final Matrix mLocalMatrix;
        private float mPivotX;
        private float mPivotY;
        float mRotate;
        private float mScaleX;
        private float mScaleY;
        final Matrix mStackedMatrix;
        private int[] mThemeAttrs;
        private float mTranslateX;
        private float mTranslateY;

        public VGroup() {
            super(null);
            this.mStackedMatrix = new Matrix();
            this.mChildren = new ArrayList();
            this.mRotate = 0f;
            this.mPivotX = 0f;
            this.mPivotY = 0f;
            this.mScaleX = 1f;
            this.mScaleY = 1f;
            this.mTranslateX = 0f;
            this.mTranslateY = 0f;
            this.mLocalMatrix = new Matrix();
            this.mGroupName = null;
        }

        public VGroup(VGroup arg5, ArrayMap arg6) {
            VClipPath v2_1;
            super(null);
            this.mStackedMatrix = new Matrix();
            this.mChildren = new ArrayList();
            this.mRotate = 0f;
            this.mPivotX = 0f;
            this.mPivotY = 0f;
            this.mScaleX = 1f;
            this.mScaleY = 1f;
            this.mTranslateX = 0f;
            this.mTranslateY = 0f;
            Matrix v1 = new Matrix();
            this.mLocalMatrix = v1;
            this.mGroupName = null;
            this.mRotate = arg5.mRotate;
            this.mPivotX = arg5.mPivotX;
            this.mPivotY = arg5.mPivotY;
            this.mScaleX = arg5.mScaleX;
            this.mScaleY = arg5.mScaleY;
            this.mTranslateX = arg5.mTranslateX;
            this.mTranslateY = arg5.mTranslateY;
            this.mThemeAttrs = arg5.mThemeAttrs;
            String v0 = arg5.mGroupName;
            this.mGroupName = v0;
            this.mChangingConfigurations = arg5.mChangingConfigurations;
            if(v0 != null) {
                arg6.put(v0, this);
            }

            v1.set(arg5.mLocalMatrix);
            ArrayList v5 = arg5.mChildren;
            int v0_1;
            for(v0_1 = 0; true; ++v0_1) {
                if(v0_1 >= v5.size()) {
                    return;
                }

                Object v1_1 = v5.get(v0_1);
                if((v1_1 instanceof VGroup)) {
                    this.mChildren.add(new VGroup(((VGroup)v1_1), arg6));
                }
                else {
                    if((v1_1 instanceof VFullPath)) {
                        VFullPath v2 = new VFullPath(((VFullPath)v1_1));
                    }
                    else if((v1_1 instanceof VClipPath)) {
                        v2_1 = new VClipPath(((VClipPath)v1_1));
                    }
                    else {
                        break;
                    }

                    this.mChildren.add(v2_1);
                    if(((VPath)v2_1).mPathName == null) {
                        goto label_72;
                    }

                    arg6.put(((VPath)v2_1).mPathName, v2_1);
                }

            label_72:
            }

            throw new IllegalStateException("Unknown object in the tree!");
        }

        public String getGroupName() {
            return this.mGroupName;
        }

        public Matrix getLocalMatrix() {
            return this.mLocalMatrix;
        }

        public float getPivotX() {
            return this.mPivotX;
        }

        public float getPivotY() {
            return this.mPivotY;
        }

        public float getRotation() {
            return this.mRotate;
        }

        public float getScaleX() {
            return this.mScaleX;
        }

        public float getScaleY() {
            return this.mScaleY;
        }

        public float getTranslateX() {
            return this.mTranslateX;
        }

        public float getTranslateY() {
            return this.mTranslateY;
        }

        public void inflate(Resources arg2, AttributeSet arg3, Resources$Theme arg4, XmlPullParser arg5) {
            TypedArray v2 = TypedArrayUtils.obtainAttributes(arg2, arg4, arg3, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_GROUP);
            this.updateStateFromTypedArray(v2, arg5);
            v2.recycle();
        }

        public boolean isStateful() {
            int v1;
            for(v1 = 0; v1 < this.mChildren.size(); ++v1) {
                if(this.mChildren.get(v1).isStateful()) {
                    return 1;
                }
            }

            return 0;
        }

        public boolean onStateChanged(int[] arg4) {
            int v0 = 0;
            int v1 = 0;
            while(v0 < this.mChildren.size()) {
                v1 |= this.mChildren.get(v0).onStateChanged(arg4);
                ++v0;
            }

            return ((boolean)v1);
        }

        public void setPivotX(float arg2) {
            if(arg2 != this.mPivotX) {
                this.mPivotX = arg2;
                this.updateLocalMatrix();
            }
        }

        public void setPivotY(float arg2) {
            if(arg2 != this.mPivotY) {
                this.mPivotY = arg2;
                this.updateLocalMatrix();
            }
        }

        public void setRotation(float arg2) {
            if(arg2 != this.mRotate) {
                this.mRotate = arg2;
                this.updateLocalMatrix();
            }
        }

        public void setScaleX(float arg2) {
            if(arg2 != this.mScaleX) {
                this.mScaleX = arg2;
                this.updateLocalMatrix();
            }
        }

        public void setScaleY(float arg2) {
            if(arg2 != this.mScaleY) {
                this.mScaleY = arg2;
                this.updateLocalMatrix();
            }
        }

        public void setTranslateX(float arg2) {
            if(arg2 != this.mTranslateX) {
                this.mTranslateX = arg2;
                this.updateLocalMatrix();
            }
        }

        public void setTranslateY(float arg2) {
            if(arg2 != this.mTranslateY) {
                this.mTranslateY = arg2;
                this.updateLocalMatrix();
            }
        }

        private void updateLocalMatrix() {
            this.mLocalMatrix.reset();
            this.mLocalMatrix.postTranslate(-this.mPivotX, -this.mPivotY);
            this.mLocalMatrix.postScale(this.mScaleX, this.mScaleY);
            this.mLocalMatrix.postRotate(this.mRotate, 0f, 0f);
            this.mLocalMatrix.postTranslate(this.mTranslateX + this.mPivotX, this.mTranslateY + this.mPivotY);
        }

        private void updateStateFromTypedArray(TypedArray arg4, XmlPullParser arg5) {
            this.mThemeAttrs = null;
            this.mRotate = TypedArrayUtils.getNamedFloat(arg4, arg5, "rotation", 5, this.mRotate);
            this.mPivotX = arg4.getFloat(1, this.mPivotX);
            this.mPivotY = arg4.getFloat(2, this.mPivotY);
            this.mScaleX = TypedArrayUtils.getNamedFloat(arg4, arg5, "scaleX", 3, this.mScaleX);
            this.mScaleY = TypedArrayUtils.getNamedFloat(arg4, arg5, "scaleY", 4, this.mScaleY);
            this.mTranslateX = TypedArrayUtils.getNamedFloat(arg4, arg5, "translateX", 6, this.mTranslateX);
            this.mTranslateY = TypedArrayUtils.getNamedFloat(arg4, arg5, "translateY", 7, this.mTranslateY);
            String v4 = arg4.getString(0);
            if(v4 != null) {
                this.mGroupName = v4;
            }

            this.updateLocalMatrix();
        }
    }

    abstract class VObject {
        private VObject() {
            super();
        }

        VObject(androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$1 arg1) {
            this();
        }

        public boolean isStateful() {
            return 0;
        }

        public boolean onStateChanged(int[] arg1) {
            return 0;
        }
    }

    abstract class VPath extends VObject {
        protected static final int FILL_TYPE_WINDING;
        int mChangingConfigurations;
        int mFillRule;
        protected PathDataNode[] mNodes;
        String mPathName;

        public VPath() {
            super(null);
            this.mNodes = null;
            this.mFillRule = 0;
        }

        public VPath(VPath arg2) {
            super(null);
            this.mNodes = null;
            this.mFillRule = 0;
            this.mPathName = arg2.mPathName;
            this.mChangingConfigurations = arg2.mChangingConfigurations;
            this.mNodes = PathParser.deepCopyNodes(arg2.mNodes);
        }

        public void applyTheme(Resources$Theme arg1) {
        }

        public boolean canApplyTheme() {
            return 0;
        }

        public PathDataNode[] getPathData() {
            return this.mNodes;
        }

        public String getPathName() {
            return this.mPathName;
        }

        public boolean isClipPath() {
            return 0;
        }

        public String nodesToString(PathDataNode[] arg6) {
            String v5 = " ";
            int v1;
            for(v1 = 0; v1 < arg6.length; ++v1) {
                v5 = v5 + arg6[v1].mType + ":";
                float[] v2 = arg6[v1].mParams;
                int v3;
                for(v3 = 0; v3 < v2.length; ++v3) {
                    v5 = v5 + v2[v3] + ",";
                }
            }

            return v5;
        }

        public void printVPath(int arg4) {
            String v0 = "";
            int v1;
            for(v1 = 0; v1 < arg4; ++v1) {
                v0 = v0 + "    ";
            }

            Log.v("VectorDrawableCompat", v0 + "current path is :" + this.mPathName + " pathData is " + this.nodesToString(this.mNodes));
        }

        public void setPathData(PathDataNode[] arg2) {
            if(!PathParser.canMorph(this.mNodes, arg2)) {
                this.mNodes = PathParser.deepCopyNodes(arg2);
                return;
            }

            PathParser.updateNodes(this.mNodes, arg2);
        }

        public void toPath(Path arg1) {
            arg1.reset();
            PathDataNode[] v0 = this.mNodes;
            if(v0 != null) {
                PathDataNode.nodesToPath(v0, arg1);
            }
        }
    }

    class VPathRenderer {
        private static final Matrix IDENTITY_MATRIX;
        float mBaseHeight;
        float mBaseWidth;
        private int mChangingConfigurations;
        Paint mFillPaint;
        private final Matrix mFinalPathMatrix;
        Boolean mIsStateful;
        private final Path mPath;
        private PathMeasure mPathMeasure;
        private final Path mRenderPath;
        int mRootAlpha;
        final VGroup mRootGroup;
        String mRootName;
        Paint mStrokePaint;
        final ArrayMap mVGTargetsMap;
        float mViewportHeight;
        float mViewportWidth;

        static {
            VPathRenderer.IDENTITY_MATRIX = new Matrix();
        }

        public VPathRenderer() {
            super();
            this.mFinalPathMatrix = new Matrix();
            this.mBaseWidth = 0f;
            this.mBaseHeight = 0f;
            this.mViewportWidth = 0f;
            this.mViewportHeight = 0f;
            this.mRootAlpha = 0xFF;
            this.mRootName = null;
            this.mIsStateful = null;
            this.mVGTargetsMap = new ArrayMap();
            this.mRootGroup = new VGroup();
            this.mPath = new Path();
            this.mRenderPath = new Path();
        }

        public VPathRenderer(VPathRenderer arg4) {
            super();
            this.mFinalPathMatrix = new Matrix();
            this.mBaseWidth = 0f;
            this.mBaseHeight = 0f;
            this.mViewportWidth = 0f;
            this.mViewportHeight = 0f;
            this.mRootAlpha = 0xFF;
            this.mRootName = null;
            this.mIsStateful = null;
            ArrayMap v0 = new ArrayMap();
            this.mVGTargetsMap = v0;
            this.mRootGroup = new VGroup(arg4.mRootGroup, v0);
            this.mPath = new Path(arg4.mPath);
            this.mRenderPath = new Path(arg4.mRenderPath);
            this.mBaseWidth = arg4.mBaseWidth;
            this.mBaseHeight = arg4.mBaseHeight;
            this.mViewportWidth = arg4.mViewportWidth;
            this.mViewportHeight = arg4.mViewportHeight;
            this.mChangingConfigurations = arg4.mChangingConfigurations;
            this.mRootAlpha = arg4.mRootAlpha;
            this.mRootName = arg4.mRootName;
            String v1 = arg4.mRootName;
            if(v1 != null) {
                v0.put(v1, this);
            }

            this.mIsStateful = arg4.mIsStateful;
        }

        private static float cross(float arg0, float arg1, float arg2, float arg3) {
            return arg0 * arg3 - arg1 * arg2;
        }

        public void draw(Canvas arg8, int arg9, int arg10, ColorFilter arg11) {
            this.drawGroupTree(this.mRootGroup, VPathRenderer.IDENTITY_MATRIX, arg8, arg9, arg10, arg11);
        }

        private void drawGroupTree(VGroup arg16, Matrix arg17, Canvas arg18, int arg19, int arg20, ColorFilter arg21) {
            VGroup v1 = arg16;
            v1.mStackedMatrix.set(arg17);
            v1.mStackedMatrix.preConcat(v1.mLocalMatrix);
            arg18.save();
            int v7 = 0;
            while(v7 < v1.mChildren.size()) {
                Object v0 = v1.mChildren.get(v7);
                if((v0 instanceof VGroup)) {
                    this.drawGroupTree(v0, v1.mStackedMatrix, arg18, arg19, arg20, arg21);
                }
                else if((v0 instanceof VPath)) {
                    this.drawPath(v1, v0, arg18, arg19, arg20, arg21);
                }

                ++v7;
                v1 = arg16;
            }

            arg18.restore();
        }

        private void drawPath(VGroup arg8, VPath arg9, Canvas arg10, int arg11, int arg12, ColorFilter arg13) {
            Shader v11_2;
            Paint v4_1;
            ComplexColorCompat v11_1;
            float v11 = (((float)arg11)) / this.mViewportWidth;
            float v12 = (((float)arg12)) / this.mViewportHeight;
            float v0 = Math.min(v11, v12);
            Matrix v8 = arg8.mStackedMatrix;
            this.mFinalPathMatrix.set(v8);
            this.mFinalPathMatrix.postScale(v11, v12);
            float v8_1 = this.getMatrixScale(v8);
            if(v8_1 == 0f) {
            }
            else {
                arg9.toPath(this.mPath);
                Path v12_1 = this.mPath;
                this.mRenderPath.reset();
                if(arg9.isClipPath()) {
                    Path v8_2 = this.mRenderPath;
                    Path$FillType v9 = arg9.mFillRule == 0 ? Path$FillType.WINDING : Path$FillType.EVEN_ODD;
                    v8_2.setFillType(v9);
                    this.mRenderPath.addPath(v12_1, this.mFinalPathMatrix);
                    arg10.clipPath(this.mRenderPath);
                    return;
                }
                else {
                    float v2 = 1f;
                    if(Float.compare(((VFullPath)arg9).mTrimPathStart, 0f) != 0 || ((VFullPath)arg9).mTrimPathEnd != v2) {
                        float v1 = (((VFullPath)arg9).mTrimPathStart + ((VFullPath)arg9).mTrimPathOffset) % v2;
                        float v4 = (((VFullPath)arg9).mTrimPathEnd + ((VFullPath)arg9).mTrimPathOffset) % v2;
                        PathMeasure v2_1 = this.mPathMeasure;
                        if(v2_1 == null) {
                            v2_1 = new PathMeasure();
                            this.mPathMeasure = v2_1;
                        }

                        v2_1.setPath(this.mPath, false);
                        v2 = this.mPathMeasure.getLength();
                        v1 *= v2;
                        v4 *= v2;
                        v12_1.reset();
                        int v5 = Float.compare(v1, v4);
                        PathMeasure v6 = this.mPathMeasure;
                        if(v5 > 0) {
                            v6.getSegment(v1, v2, v12_1, true);
                            this.mPathMeasure.getSegment(0f, v4, v12_1, true);
                        }
                        else {
                            v6.getSegment(v1, v4, v12_1, true);
                        }

                        v12_1.rLineTo(0f, 0f);
                    }

                    this.mRenderPath.addPath(v12_1, this.mFinalPathMatrix);
                    v12 = 255f;
                    int v1_1 = 0xFF;
                    Shader v2_2 = null;
                    if(((VFullPath)arg9).mFillColor.willDraw()) {
                        v11_1 = ((VFullPath)arg9).mFillColor;
                        if(this.mFillPaint == null) {
                            v4_1 = new Paint(1);
                            this.mFillPaint = v4_1;
                            v4_1.setStyle(Paint$Style.FILL);
                        }

                        v4_1 = this.mFillPaint;
                        if(v11_1.isGradient()) {
                            v11_2 = v11_1.getShader();
                            v11_2.setLocalMatrix(this.mFinalPathMatrix);
                            v4_1.setShader(v11_2);
                            v4_1.setAlpha(Math.round(((VFullPath)arg9).mFillAlpha * v12));
                        }
                        else {
                            v4_1.setShader(v2_2);
                            v4_1.setAlpha(v1_1);
                            v4_1.setColor(VectorDrawableCompat.applyAlpha(v11_1.getColor(), ((VFullPath)arg9).mFillAlpha));
                        }

                        v4_1.setColorFilter(arg13);
                        Path v11_3 = this.mRenderPath;
                        Path$FillType v5_1 = ((VFullPath)arg9).mFillRule == 0 ? Path$FillType.WINDING : Path$FillType.EVEN_ODD;
                        v11_3.setFillType(v5_1);
                        arg10.drawPath(this.mRenderPath, v4_1);
                    }

                    if(!((VFullPath)arg9).mStrokeColor.willDraw()) {
                        return;
                    }

                    v11_1 = ((VFullPath)arg9).mStrokeColor;
                    if(this.mStrokePaint == null) {
                        v4_1 = new Paint(1);
                        this.mStrokePaint = v4_1;
                        v4_1.setStyle(Paint$Style.STROKE);
                    }

                    Paint v3 = this.mStrokePaint;
                    if(((VFullPath)arg9).mStrokeLineJoin != null) {
                        v3.setStrokeJoin(((VFullPath)arg9).mStrokeLineJoin);
                    }

                    if(((VFullPath)arg9).mStrokeLineCap != null) {
                        v3.setStrokeCap(((VFullPath)arg9).mStrokeLineCap);
                    }

                    v3.setStrokeMiter(((VFullPath)arg9).mStrokeMiterlimit);
                    if(v11_1.isGradient()) {
                        v11_2 = v11_1.getShader();
                        v11_2.setLocalMatrix(this.mFinalPathMatrix);
                        v3.setShader(v11_2);
                        v3.setAlpha(Math.round(((VFullPath)arg9).mStrokeAlpha * v12));
                    }
                    else {
                        v3.setShader(v2_2);
                        v3.setAlpha(v1_1);
                        v3.setColor(VectorDrawableCompat.applyAlpha(v11_1.getColor(), ((VFullPath)arg9).mStrokeAlpha));
                    }

                    v3.setColorFilter(arg13);
                    v3.setStrokeWidth(((VFullPath)arg9).mStrokeWidth * (v0 * v8_1));
                    arg10.drawPath(this.mRenderPath, v3);
                }
            }
        }

        public float getAlpha() {
            return (((float)this.getRootAlpha())) / 255f;
        }

        private float getMatrixScale(Matrix arg9) {
            float[] v8 = new float[]{0f, 1f, 1f, 0f};
            arg9.mapVectors(v8);
            float v0 = ((float)Math.hypot(((double)v8[0]), ((double)v8[1])));
            float v3 = ((float)Math.hypot(((double)v8[2]), ((double)v8[3])));
            float v8_1 = VPathRenderer.cross(v8[0], v8[1], v8[2], v8[3]);
            float v9 = Math.max(v0, v3);
            if(v9 > 0f) {
                return Math.abs(v8_1) / v9;
            }

            return 0;
        }

        public int getRootAlpha() {
            return this.mRootAlpha;
        }

        public boolean isStateful() {
            Boolean v0 = this.mIsStateful;
            if(v0 == null) {
                v0 = Boolean.valueOf(this.mRootGroup.isStateful());
                this.mIsStateful = v0;
            }

            return v0.booleanValue();
        }

        public boolean onStateChanged(int[] arg1) {
            return this.mRootGroup.onStateChanged(arg1);
        }

        public void setAlpha(float arg2) {
            this.setRootAlpha(((int)(arg2 * 255f)));
        }

        public void setRootAlpha(int arg1) {
            this.mRootAlpha = arg1;
        }
    }

    class VectorDrawableCompatState extends Drawable$ConstantState {
        boolean mAutoMirrored;
        boolean mCacheDirty;
        boolean mCachedAutoMirrored;
        Bitmap mCachedBitmap;
        int mCachedRootAlpha;
        int[] mCachedThemeAttrs;
        ColorStateList mCachedTint;
        PorterDuff$Mode mCachedTintMode;
        int mChangingConfigurations;
        Paint mTempPaint;
        ColorStateList mTint;
        PorterDuff$Mode mTintMode;
        VPathRenderer mVPathRenderer;

        public VectorDrawableCompatState() {
            super();
            this.mTint = null;
            this.mTintMode = VectorDrawableCompat.DEFAULT_TINT_MODE;
            this.mVPathRenderer = new VPathRenderer();
        }

        public VectorDrawableCompatState(VectorDrawableCompatState arg4) {
            super();
            this.mTint = null;
            this.mTintMode = VectorDrawableCompat.DEFAULT_TINT_MODE;
            if(arg4 != null) {
                this.mChangingConfigurations = arg4.mChangingConfigurations;
                this.mVPathRenderer = new VPathRenderer(arg4.mVPathRenderer);
                if(arg4.mVPathRenderer.mFillPaint != null) {
                    this.mVPathRenderer.mFillPaint = new Paint(arg4.mVPathRenderer.mFillPaint);
                }

                if(arg4.mVPathRenderer.mStrokePaint != null) {
                    this.mVPathRenderer.mStrokePaint = new Paint(arg4.mVPathRenderer.mStrokePaint);
                }

                this.mTint = arg4.mTint;
                this.mTintMode = arg4.mTintMode;
                this.mAutoMirrored = arg4.mAutoMirrored;
            }
        }

        public boolean canReuseBitmap(int arg2, int arg3) {
            if(arg2 == this.mCachedBitmap.getWidth() && arg3 == this.mCachedBitmap.getHeight()) {
                return 1;
            }

            return 0;
        }

        public boolean canReuseCache() {
            if(!this.mCacheDirty && this.mCachedTint == this.mTint && this.mCachedTintMode == this.mTintMode && this.mCachedAutoMirrored == this.mAutoMirrored && this.mCachedRootAlpha == this.mVPathRenderer.getRootAlpha()) {
                return 1;
            }

            return 0;
        }

        public void createCachedBitmapIfNeeded(int arg2, int arg3) {
            if(this.mCachedBitmap != null) {
                if(!this.canReuseBitmap(arg2, arg3)) {
                }
                else {
                    return;
                }
            }

            this.mCachedBitmap = Bitmap.createBitmap(arg2, arg3, Bitmap$Config.ARGB_8888);
            this.mCacheDirty = true;
        }

        public void drawCachedBitmapWithRootAlpha(Canvas arg2, ColorFilter arg3, Rect arg4) {
            arg2.drawBitmap(this.mCachedBitmap, null, arg4, this.getPaint(arg3));
        }

        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        public Paint getPaint(ColorFilter arg3) {
            if(!this.hasTranslucentRoot() && arg3 == null) {
                return null;
            }

            if(this.mTempPaint == null) {
                Paint v0 = new Paint();
                this.mTempPaint = v0;
                v0.setFilterBitmap(true);
            }

            this.mTempPaint.setAlpha(this.mVPathRenderer.getRootAlpha());
            this.mTempPaint.setColorFilter(arg3);
            return this.mTempPaint;
        }

        public boolean hasTranslucentRoot() {
            if(this.mVPathRenderer.getRootAlpha() < 0xFF) {
                return 1;
            }

            return 0;
        }

        public boolean isStateful() {
            return this.mVPathRenderer.isStateful();
        }

        public Drawable newDrawable() {
            return new VectorDrawableCompat(this);
        }

        public Drawable newDrawable(Resources arg1) {
            return new VectorDrawableCompat(this);
        }

        public boolean onStateChanged(int[] arg2) {
            boolean v2 = this.mVPathRenderer.onStateChanged(arg2);
            this.mCacheDirty |= ((int)v2);
            return v2;
        }

        public void updateCacheStates() {
            this.mCachedTint = this.mTint;
            this.mCachedTintMode = this.mTintMode;
            this.mCachedRootAlpha = this.mVPathRenderer.getRootAlpha();
            this.mCachedAutoMirrored = this.mAutoMirrored;
            this.mCacheDirty = false;
        }

        public void updateCachedBitmap(int arg3, int arg4) {
            this.mCachedBitmap.eraseColor(0);
            this.mVPathRenderer.draw(new Canvas(this.mCachedBitmap), arg3, arg4, null);
        }
    }

    class VectorDrawableDelegateState extends Drawable$ConstantState {
        private final Drawable$ConstantState mDelegateState;

        public VectorDrawableDelegateState(Drawable$ConstantState arg1) {
            super();
            this.mDelegateState = arg1;
        }

        public boolean canApplyTheme() {
            return this.mDelegateState.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.mDelegateState.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            VectorDrawableCompat v0 = new VectorDrawableCompat();
            v0.mDelegateDrawable = this.mDelegateState.newDrawable();
            return ((Drawable)v0);
        }

        public Drawable newDrawable(Resources arg2) {
            VectorDrawableCompat v0 = new VectorDrawableCompat();
            v0.mDelegateDrawable = this.mDelegateState.newDrawable(arg2);
            return ((Drawable)v0);
        }

        public Drawable newDrawable(Resources arg2, Resources$Theme arg3) {
            VectorDrawableCompat v0 = new VectorDrawableCompat();
            v0.mDelegateDrawable = this.mDelegateState.newDrawable(arg2, arg3);
            return ((Drawable)v0);
        }
    }

    private static final boolean DBG_VECTOR_DRAWABLE = false;
    static final PorterDuff$Mode DEFAULT_TINT_MODE = null;
    private static final int LINECAP_BUTT = 0;
    private static final int LINECAP_ROUND = 1;
    private static final int LINECAP_SQUARE = 2;
    private static final int LINEJOIN_BEVEL = 2;
    private static final int LINEJOIN_MITER = 0;
    private static final int LINEJOIN_ROUND = 1;
    static final String LOGTAG = "VectorDrawableCompat";
    private static final int MAX_CACHED_BITMAP_SIZE = 0x800;
    private static final String SHAPE_CLIP_PATH = "clip-path";
    private static final String SHAPE_GROUP = "group";
    private static final String SHAPE_PATH = "path";
    private static final String SHAPE_VECTOR = "vector";
    private boolean mAllowCaching;
    private Drawable$ConstantState mCachedConstantStateDelegate;
    private ColorFilter mColorFilter;
    private boolean mMutated;
    private PorterDuffColorFilter mTintFilter;
    private final Rect mTmpBounds;
    private final float[] mTmpFloats;
    private final Matrix mTmpMatrix;
    private VectorDrawableCompatState mVectorState;

    static {
        VectorDrawableCompat.DEFAULT_TINT_MODE = PorterDuff$Mode.SRC_IN;
    }

    VectorDrawableCompat() {
        super();
        this.mAllowCaching = true;
        this.mTmpFloats = new float[9];
        this.mTmpMatrix = new Matrix();
        this.mTmpBounds = new Rect();
        this.mVectorState = new VectorDrawableCompatState();
    }

    VectorDrawableCompat(VectorDrawableCompatState arg3) {
        super();
        this.mAllowCaching = true;
        this.mTmpFloats = new float[9];
        this.mTmpMatrix = new Matrix();
        this.mTmpBounds = new Rect();
        this.mVectorState = arg3;
        this.mTintFilter = this.updateTintFilter(this.mTintFilter, arg3.mTint, arg3.mTintMode);
    }

    static int applyAlpha(int arg2, float arg3) {
        return arg2 & 0xFFFFFF | (((int)((((float)Color.alpha(arg2))) * arg3))) << 24;
    }

    public void applyTheme(Resources$Theme arg1) {
        super.applyTheme(arg1);
    }

    public boolean canApplyTheme() {
        if(this.mDelegateDrawable != null) {
            DrawableCompat.canApplyTheme(this.mDelegateDrawable);
        }

        return 0;
    }

    public void clearColorFilter() {
        super.clearColorFilter();
    }

    public static VectorDrawableCompat create(Resources arg1, int arg2, Resources$Theme arg3) {
        VectorDrawableCompat v0 = new VectorDrawableCompat();
        v0.mDelegateDrawable = ResourcesCompat.getDrawable(arg1, arg2, arg3);
        v0.mCachedConstantStateDelegate = new VectorDrawableDelegateState(v0.mDelegateDrawable.getConstantState());
        return v0;
    }

    public static VectorDrawableCompat createFromXmlInner(Resources arg1, XmlPullParser arg2, AttributeSet arg3, Resources$Theme arg4) throws XmlPullParserException, IOException {
        VectorDrawableCompat v0 = new VectorDrawableCompat();
        v0.inflate(arg1, arg2, arg3, arg4);
        return v0;
    }

    public void draw(Canvas arg10) {
        PorterDuffColorFilter v0_1;
        if(this.mDelegateDrawable != null) {
            this.mDelegateDrawable.draw(arg10);
            return;
        }

        this.copyBounds(this.mTmpBounds);
        if(this.mTmpBounds.width() > 0) {
            if(this.mTmpBounds.height() <= 0) {
            }
            else {
                ColorFilter v0 = this.mColorFilter;
                if(v0 == null) {
                    v0_1 = this.mTintFilter;
                }

                arg10.getMatrix(this.mTmpMatrix);
                this.mTmpMatrix.getValues(this.mTmpFloats);
                float v1 = Math.abs(this.mTmpFloats[0]);
                float v3 = Math.abs(this.mTmpFloats[4]);
                float v4 = Math.abs(this.mTmpFloats[1]);
                float v5 = Math.abs(this.mTmpFloats[3]);
                float v7 = 1f;
                if(Float.compare(v4, 0f) != 0 || v5 != 0f) {
                    v1 = v7;
                    v3 = v1;
                }

                int v1_1 = ((int)((((float)this.mTmpBounds.width())) * v1));
                int v3_1 = ((int)((((float)this.mTmpBounds.height())) * v3));
                v1_1 = Math.min(0x800, v1_1);
                v3_1 = Math.min(0x800, v3_1);
                if(v1_1 <= 0) {
                    return;
                }

                if(v3_1 <= 0) {
                    return;
                }

                int v4_1 = arg10.save();
                arg10.translate(((float)this.mTmpBounds.left), ((float)this.mTmpBounds.top));
                if(this.needMirroring()) {
                    arg10.translate(((float)this.mTmpBounds.width()), 0f);
                    arg10.scale(-1f, v7);
                }

                this.mTmpBounds.offsetTo(0, 0);
                this.mVectorState.createCachedBitmapIfNeeded(v1_1, v3_1);
                boolean v2 = this.mAllowCaching;
                VectorDrawableCompatState v5_1 = this.mVectorState;
                if(!v2) {
                    v5_1.updateCachedBitmap(v1_1, v3_1);
                }
                else if(!v5_1.canReuseCache()) {
                    this.mVectorState.updateCachedBitmap(v1_1, v3_1);
                    this.mVectorState.updateCacheStates();
                }

                this.mVectorState.drawCachedBitmapWithRootAlpha(arg10, ((ColorFilter)v0_1), this.mTmpBounds);
                arg10.restoreToCount(v4_1);
            }
        }
    }

    public int getAlpha() {
        if(this.mDelegateDrawable != null) {
            return DrawableCompat.getAlpha(this.mDelegateDrawable);
        }

        return this.mVectorState.mVPathRenderer.getRootAlpha();
    }

    public int getChangingConfigurations() {
        if(this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getChangingConfigurations();
        }

        return this.mVectorState.getChangingConfigurations() | super.getChangingConfigurations();
    }

    public ColorFilter getColorFilter() {
        if(this.mDelegateDrawable != null) {
            return DrawableCompat.getColorFilter(this.mDelegateDrawable);
        }

        return this.mColorFilter;
    }

    public Drawable$ConstantState getConstantState() {
        if(this.mDelegateDrawable != null) {
            return new VectorDrawableDelegateState(this.mDelegateDrawable.getConstantState());
        }

        this.mVectorState.mChangingConfigurations = this.getChangingConfigurations();
        return this.mVectorState;
    }

    public Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        if(this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getIntrinsicHeight();
        }

        return ((int)this.mVectorState.mVPathRenderer.mBaseHeight);
    }

    public int getIntrinsicWidth() {
        if(this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getIntrinsicWidth();
        }

        return ((int)this.mVectorState.mVPathRenderer.mBaseWidth);
    }

    public int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        if(this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getOpacity();
        }

        return -3;
    }

    public boolean getPadding(Rect arg1) {
        return super.getPadding(arg1);
    }

    public float getPixelSize() {
        VectorDrawableCompatState v0 = this.mVectorState;
        if(v0 != null && v0.mVPathRenderer != null && this.mVectorState.mVPathRenderer.mBaseWidth != 0f && this.mVectorState.mVPathRenderer.mBaseHeight != 0f && this.mVectorState.mVPathRenderer.mViewportHeight != 0f) {
            if(this.mVectorState.mVPathRenderer.mViewportWidth == 0f) {
            }
            else {
                return Math.min(this.mVectorState.mVPathRenderer.mViewportWidth / this.mVectorState.mVPathRenderer.mBaseWidth, this.mVectorState.mVPathRenderer.mViewportHeight / this.mVectorState.mVPathRenderer.mBaseHeight);
            }
        }

        return 1f;
    }

    public int[] getState() {
        return super.getState();
    }

    Object getTargetByName(String arg1) {
        return this.mVectorState.mVPathRenderer.mVGTargetsMap.get(arg1);
    }

    public Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public void inflate(Resources arg3, XmlPullParser arg4, AttributeSet arg5, Resources$Theme arg6) throws XmlPullParserException, IOException {
        if(this.mDelegateDrawable != null) {
            DrawableCompat.inflate(this.mDelegateDrawable, arg3, arg4, arg5, arg6);
            return;
        }

        VectorDrawableCompatState v0 = this.mVectorState;
        v0.mVPathRenderer = new VPathRenderer();
        TypedArray v1 = TypedArrayUtils.obtainAttributes(arg3, arg6, arg5, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_TYPE_ARRAY);
        this.updateStateFromTypedArray(v1, arg4, arg6);
        v1.recycle();
        v0.mChangingConfigurations = this.getChangingConfigurations();
        v0.mCacheDirty = true;
        this.inflateInternal(arg3, arg4, arg5, arg6);
        this.mTintFilter = this.updateTintFilter(this.mTintFilter, v0.mTint, v0.mTintMode);
    }

    public void inflate(Resources arg2, XmlPullParser arg3, AttributeSet arg4) throws XmlPullParserException, IOException {
        if(this.mDelegateDrawable != null) {
            this.mDelegateDrawable.inflate(arg2, arg3, arg4);
            return;
        }

        this.inflate(arg2, arg3, arg4, null);
    }

    private void inflateInternal(Resources arg10, XmlPullParser arg11, AttributeSet arg12, Resources$Theme arg13) throws XmlPullParserException, IOException {
        VectorDrawableCompatState v9 = this.mVectorState;
        VPathRenderer v0 = v9.mVPathRenderer;
        ArrayDeque v1 = new ArrayDeque();
        v1.push(v0.mRootGroup);
        int v2 = arg11.getEventType();
        int v3 = arg11.getDepth() + 1;
        int v5 = 1;
        while(v2 != 1) {
            int v7 = 3;
            if(arg11.getDepth() < v3 && v2 == v7) {
                break;
            }

            String v8 = "group";
            if(v2 == 2) {
                String v2_1 = arg11.getName();
                Object v6 = v1.peek();
                if("path".equals(v2_1)) {
                    VFullPath v2_2 = new VFullPath();
                    v2_2.inflate(arg10, arg12, arg13, arg11);
                    ((VGroup)v6).mChildren.add(v2_2);
                    if(v2_2.getPathName() != null) {
                        v0.mVGTargetsMap.put(v2_2.getPathName(), v2_2);
                    }

                    v9.mChangingConfigurations |= v2_2.mChangingConfigurations;
                    v5 = 0;
                }
                else {
                    if("clip-path".equals(v2_1)) {
                        VClipPath v2_3 = new VClipPath();
                        v2_3.inflate(arg10, arg12, arg13, arg11);
                        ((VGroup)v6).mChildren.add(v2_3);
                        if(v2_3.getPathName() != null) {
                            v0.mVGTargetsMap.put(v2_3.getPathName(), v2_3);
                        }

                        v9.mChangingConfigurations |= v2_3.mChangingConfigurations;
                        goto label_82;
                    }

                    if(!v8.equals(v2_1)) {
                        goto label_82;
                    }

                    VGroup v2_4 = new VGroup();
                    v2_4.inflate(arg10, arg12, arg13, arg11);
                    ((VGroup)v6).mChildren.add(v2_4);
                    v1.push(v2_4);
                    if(v2_4.getGroupName() != null) {
                        v0.mVGTargetsMap.put(v2_4.getGroupName(), v2_4);
                    }

                    v9.mChangingConfigurations |= v2_4.mChangingConfigurations;
                }
            }
            else {
                if(v2 != v7) {
                    goto label_82;
                }

                if(!v8.equals(arg11.getName())) {
                    goto label_82;
                }

                v1.pop();
            }

        label_82:
            v2 = arg11.next();
        }

        if(v5 == 0) {
            return;
        }

        throw new XmlPullParserException("no path defined");
    }

    public void invalidateSelf() {
        if(this.mDelegateDrawable != null) {
            this.mDelegateDrawable.invalidateSelf();
            return;
        }

        super.invalidateSelf();
    }

    public boolean isAutoMirrored() {
        if(this.mDelegateDrawable != null) {
            return DrawableCompat.isAutoMirrored(this.mDelegateDrawable);
        }

        return this.mVectorState.mAutoMirrored;
    }

    public boolean isStateful() {
        if(this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.isStateful();
        }

        if(!super.isStateful()) {
            VectorDrawableCompatState v0 = this.mVectorState;
            if(v0 != null) {
                if(v0.isStateful()) {
                    return 1;
                }
                else if(this.mVectorState.mTint != null && (this.mVectorState.mTint.isStateful())) {
                    return 1;
                }
            }

            return 0;
        }

        return 1;
    }

    public void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        if(this.mDelegateDrawable != null) {
            this.mDelegateDrawable.mutate();
            return this;
        }

        if(!this.mMutated && super.mutate() == this) {
            this.mVectorState = new VectorDrawableCompatState(this.mVectorState);
            this.mMutated = true;
        }

        return this;
    }

    private boolean needMirroring() {
        if((this.isAutoMirrored()) && DrawableCompat.getLayoutDirection(((Drawable)this)) == 1) {
            return 1;
        }

        return 0;
    }

    protected void onBoundsChange(Rect arg2) {
        if(this.mDelegateDrawable != null) {
            this.mDelegateDrawable.setBounds(arg2);
        }
    }

    protected boolean onStateChange(int[] arg6) {
        boolean v1;
        if(this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.setState(arg6);
        }

        VectorDrawableCompatState v0 = this.mVectorState;
        if(v0.mTint == null || v0.mTintMode == null) {
            v1 = false;
        }
        else {
            this.mTintFilter = this.updateTintFilter(this.mTintFilter, v0.mTint, v0.mTintMode);
            this.invalidateSelf();
            v1 = true;
        }

        if((v0.isStateful()) && (v0.onStateChanged(arg6))) {
            this.invalidateSelf();
            return 1;
        }

        return v1;
    }

    private static PorterDuff$Mode parseTintModeCompat(int arg1, PorterDuff$Mode arg2) {
        if(arg1 == 3) {
            goto label_18;
        }

        if(arg1 == 5) {
            goto label_16;
        }

        if(arg1 == 9) {
            goto label_14;
        }

        switch(arg1) {
            case 14: {
                goto label_12;
            }
            case 15: {
                goto label_10;
            }
            case 16: {
                goto label_8;
            }
        }

        return arg2;
    label_8:
        return PorterDuff$Mode.ADD;
    label_10:
        return PorterDuff$Mode.SCREEN;
    label_12:
        return PorterDuff$Mode.MULTIPLY;
    label_14:
        return PorterDuff$Mode.SRC_ATOP;
    label_16:
        return PorterDuff$Mode.SRC_IN;
    label_18:
        return PorterDuff$Mode.SRC_OVER;
    }

    private void printGroupTree(VGroup arg5, int arg6) {
        String v0 = "";
        int v1 = 0;
        int v2;
        for(v2 = 0; v2 < arg6; ++v2) {
            v0 = v0 + "    ";
        }

        Log.v("VectorDrawableCompat", v0 + "current group is :" + arg5.getGroupName() + " rotation is " + arg5.mRotate);
        Log.v("VectorDrawableCompat", v0 + "matrix is :" + arg5.getLocalMatrix().toString());
        while(v1 < arg5.mChildren.size()) {
            Object v0_1 = arg5.mChildren.get(v1);
            if((v0_1 instanceof VGroup)) {
                this.printGroupTree(((VGroup)v0_1), arg6 + 1);
            }
            else {
                ((VPath)v0_1).printVPath(arg6 + 1);
            }

            ++v1;
        }
    }

    public void scheduleSelf(Runnable arg2, long arg3) {
        if(this.mDelegateDrawable != null) {
            this.mDelegateDrawable.scheduleSelf(arg2, arg3);
            return;
        }

        super.scheduleSelf(arg2, arg3);
    }

    void setAllowCaching(boolean arg1) {
        this.mAllowCaching = arg1;
    }

    public void setAlpha(int arg2) {
        if(this.mDelegateDrawable != null) {
            this.mDelegateDrawable.setAlpha(arg2);
            return;
        }

        if(this.mVectorState.mVPathRenderer.getRootAlpha() != arg2) {
            this.mVectorState.mVPathRenderer.setRootAlpha(arg2);
            this.invalidateSelf();
        }
    }

    public void setAutoMirrored(boolean arg2) {
        if(this.mDelegateDrawable != null) {
            DrawableCompat.setAutoMirrored(this.mDelegateDrawable, arg2);
            return;
        }

        this.mVectorState.mAutoMirrored = arg2;
    }

    public void setChangingConfigurations(int arg1) {
        super.setChangingConfigurations(arg1);
    }

    public void setColorFilter(ColorFilter arg2) {
        if(this.mDelegateDrawable != null) {
            this.mDelegateDrawable.setColorFilter(arg2);
            return;
        }

        this.mColorFilter = arg2;
        this.invalidateSelf();
    }

    public void setColorFilter(int arg1, PorterDuff$Mode arg2) {
        super.setColorFilter(arg1, arg2);
    }

    public void setFilterBitmap(boolean arg1) {
        super.setFilterBitmap(arg1);
    }

    public void setHotspot(float arg1, float arg2) {
        super.setHotspot(arg1, arg2);
    }

    public void setHotspotBounds(int arg1, int arg2, int arg3, int arg4) {
        super.setHotspotBounds(arg1, arg2, arg3, arg4);
    }

    public boolean setState(int[] arg1) {
        return super.setState(arg1);
    }

    public void setTint(int arg2) {
        if(this.mDelegateDrawable != null) {
            DrawableCompat.setTint(this.mDelegateDrawable, arg2);
            return;
        }

        this.setTintList(ColorStateList.valueOf(arg2));
    }

    public void setTintList(ColorStateList arg3) {
        if(this.mDelegateDrawable != null) {
            DrawableCompat.setTintList(this.mDelegateDrawable, arg3);
            return;
        }

        VectorDrawableCompatState v0 = this.mVectorState;
        if(v0.mTint != arg3) {
            v0.mTint = arg3;
            this.mTintFilter = this.updateTintFilter(this.mTintFilter, arg3, v0.mTintMode);
            this.invalidateSelf();
        }
    }

    public void setTintMode(PorterDuff$Mode arg3) {
        if(this.mDelegateDrawable != null) {
            DrawableCompat.setTintMode(this.mDelegateDrawable, arg3);
            return;
        }

        VectorDrawableCompatState v0 = this.mVectorState;
        if(v0.mTintMode != arg3) {
            v0.mTintMode = arg3;
            this.mTintFilter = this.updateTintFilter(this.mTintFilter, v0.mTint, arg3);
            this.invalidateSelf();
        }
    }

    public boolean setVisible(boolean arg2, boolean arg3) {
        if(this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.setVisible(arg2, arg3);
        }

        return super.setVisible(arg2, arg3);
    }

    public void unscheduleSelf(Runnable arg2) {
        if(this.mDelegateDrawable != null) {
            this.mDelegateDrawable.unscheduleSelf(arg2);
            return;
        }

        super.unscheduleSelf(arg2);
    }

    private void updateStateFromTypedArray(TypedArray arg5, XmlPullParser arg6, Resources$Theme arg7) throws XmlPullParserException {
        VectorDrawableCompatState v4 = this.mVectorState;
        VPathRenderer v0 = v4.mVPathRenderer;
        v4.mTintMode = VectorDrawableCompat.parseTintModeCompat(TypedArrayUtils.getNamedInt(arg5, arg6, "tintMode", 6, -1), PorterDuff$Mode.SRC_IN);
        ColorStateList v7 = TypedArrayUtils.getNamedColorStateList(arg5, arg6, arg7, "tint", 1);
        if(v7 != null) {
            v4.mTint = v7;
        }

        v4.mAutoMirrored = TypedArrayUtils.getNamedBoolean(arg5, arg6, "autoMirrored", 5, v4.mAutoMirrored);
        v0.mViewportWidth = TypedArrayUtils.getNamedFloat(arg5, arg6, "viewportWidth", 7, v0.mViewportWidth);
        v0.mViewportHeight = TypedArrayUtils.getNamedFloat(arg5, arg6, "viewportHeight", 8, v0.mViewportHeight);
        if(v0.mViewportWidth > 0f) {
            if(v0.mViewportHeight > 0f) {
                v0.mBaseWidth = arg5.getDimension(3, v0.mBaseWidth);
                v0.mBaseHeight = arg5.getDimension(2, v0.mBaseHeight);
                if(v0.mBaseWidth > 0f) {
                    if(v0.mBaseHeight > 0f) {
                        v0.setAlpha(TypedArrayUtils.getNamedFloat(arg5, arg6, "alpha", 4, v0.getAlpha()));
                        String v4_1 = arg5.getString(0);
                        if(v4_1 != null) {
                            v0.mRootName = v4_1;
                            v0.mVGTargetsMap.put(v4_1, v0);
                        }

                        return;
                    }

                    throw new XmlPullParserException(arg5.getPositionDescription() + "<vector> tag requires height > 0");
                }

                throw new XmlPullParserException(arg5.getPositionDescription() + "<vector> tag requires width > 0");
            }

            throw new XmlPullParserException(arg5.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }

        throw new XmlPullParserException(arg5.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
    }

    PorterDuffColorFilter updateTintFilter(PorterDuffColorFilter arg1, ColorStateList arg2, PorterDuff$Mode arg3) {
        if(arg2 != null) {
            if(arg3 == null) {
            }
            else {
                return new PorterDuffColorFilter(arg2.getColorForState(this.getState(), 0), arg3);
            }
        }

        return null;
    }
}

