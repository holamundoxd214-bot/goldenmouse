package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources$NotFoundException;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser$PathDataNode;
import androidx.core.graphics.PathParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatorInflaterCompat {
    class PathDataEvaluator implements TypeEvaluator {
        private PathDataNode[] mNodeArray;

        PathDataEvaluator() {
            super();
        }

        PathDataEvaluator(PathDataNode[] arg1) {
            super();
            this.mNodeArray = arg1;
        }

        public Object evaluate(float arg1, Object arg2, Object arg3) {
            return this.evaluate(arg1, ((PathDataNode[])arg2), ((PathDataNode[])arg3));
        }

        public PathDataNode[] evaluate(float arg5, PathDataNode[] arg6, PathDataNode[] arg7) {
            PathDataNode[] v2;
            if(PathParser.canMorph(arg6, arg7)) {
                if(!PathParser.canMorph(this.mNodeArray, arg6)) {
                    this.mNodeArray = PathParser.deepCopyNodes(arg6);
                }

                int v0;
                for(v0 = 0; true; ++v0) {
                    int v1 = arg6.length;
                    v2 = this.mNodeArray;
                    if(v0 >= v1) {
                        return v2;
                    }

                    v2[v0].interpolatePathDataNode(arg6[v0], arg7[v0], arg5);
                }

                return v2;
            }

            throw new IllegalArgumentException("Can\'t interpolate between two incompatible pathData");
        }
    }

    private static final boolean DBG_ANIMATOR_INFLATER = false;
    private static final int MAX_NUM_POINTS = 100;
    private static final String TAG = "AnimatorInflater";
    private static final int TOGETHER = 0;
    private static final int VALUE_TYPE_COLOR = 3;
    private static final int VALUE_TYPE_FLOAT = 0;
    private static final int VALUE_TYPE_INT = 1;
    private static final int VALUE_TYPE_PATH = 2;
    private static final int VALUE_TYPE_UNDEFINED = 4;

    private AnimatorInflaterCompat() {
        super();
    }

    private static Animator createAnimatorFromXml(Context arg8, Resources arg9, Resources$Theme arg10, XmlPullParser arg11, float arg12) throws XmlPullParserException, IOException {
        return AnimatorInflaterCompat.createAnimatorFromXml(arg8, arg9, arg10, arg11, Xml.asAttributeSet(arg11), null, 0, arg12);
    }

    private static Animator createAnimatorFromXml(Context arg13, Resources arg14, Resources$Theme arg15, XmlPullParser arg16, AttributeSet arg17, AnimatorSet arg18, int arg19, float arg20) throws XmlPullParserException, IOException {
        XmlPullParser v3;
        ValueAnimator v6_1;
        int v11;
        AnimatorSet v8 = arg18;
        int v9 = arg16.getDepth();
        ObjectAnimator v6 = null;
        ArrayList v10 = ((ArrayList)v6);
        while(true) {
            int v0 = arg16.next();
            v11 = 0;
            if((v0 != 3 || arg16.getDepth() > v9) && v0 != 1) {
                if(v0 != 2) {
                }
                else {
                    String v12 = arg16.getName();
                    if(v12.equals("objectAnimator")) {
                        v6 = AnimatorInflaterCompat.loadObjectAnimator(arg13, arg14, arg15, arg17, arg20, arg16);
                    }
                    else if(v12.equals("animator")) {
                        v6_1 = AnimatorInflaterCompat.loadAnimator(arg13, arg14, arg15, arg17, null, arg20, arg16);
                    }
                    else {
                        v3 = arg16;
                        if(v12.equals("set")) {
                            AnimatorSet v5 = new AnimatorSet();
                            TypedArray v12_1 = TypedArrayUtils.obtainAttributes(arg14, arg15, arg17, AndroidResources.STYLEABLE_ANIMATOR_SET);
                            AnimatorInflaterCompat.createAnimatorFromXml(arg13, arg14, arg15, v3, arg17, v5, TypedArrayUtils.getNamedInt(v12_1, v3, "ordering", 0, 0), arg20);
                            v12_1.recycle();
                            AnimatorSet v6_2 = v5;
                        }
                        else if(v12.equals("propertyValuesHolder")) {
                            PropertyValuesHolder[] v4 = AnimatorInflaterCompat.loadValues(arg13, arg14, arg15, v3, Xml.asAttributeSet(v3));
                            if(v4 != null && (((((ObjectAnimator)v6_1)) instanceof ValueAnimator))) {
                                ((ObjectAnimator)v6_1).setValues(v4);
                            }

                            v11 = 1;
                        }
                        else {
                            break;
                        }
                    }

                    if(v8 == null) {
                        continue;
                    }

                    if(v11 != 0) {
                        continue;
                    }

                    if(v10 == null) {
                        v10 = new ArrayList();
                    }

                    v10.add(v6_1);
                }

                continue;
            }

            goto label_90;
        }

        throw new RuntimeException("Unknown animator name: " + v3.getName());
    label_90:
        if(v8 != null && v10 != null) {
            Animator[] v13 = new Animator[v10.size()];
            Iterator v14 = v10.iterator();
            while(v14.hasNext()) {
                v13[v11] = v14.next();
                ++v11;
            }

            if(arg19 == 0) {
                v8.playTogether(v13);
                return ((Animator)v6_1);
            }
            else {
                v8.playSequentially(v13);
            }
        }

        return ((Animator)v6_1);
    }

    private static Keyframe createNewKeyframe(Keyframe arg2, float arg3) {
        if(arg2.getType() == Float.TYPE) {
            return Keyframe.ofFloat(arg3);
        }

        if(arg2.getType() == Integer.TYPE) {
            return Keyframe.ofInt(arg3);
        }

        return Keyframe.ofObject(arg3);
    }

    private static void distributeKeyframes(Keyframe[] arg2, float arg3, int arg4, int arg5) {
        arg3 /= ((float)(arg5 - arg4 + 2));
        while(arg4 <= arg5) {
            arg2[arg4].setFraction(arg2[arg4 - 1].getFraction() + arg3);
            ++arg4;
        }
    }

    private static void dumpKeyframes(Object[] arg6, String arg7) {
        String v4;
        if(arg6 != null) {
            if(arg6.length == 0) {
            }
            else {
                String v0 = "AnimatorInflater";
                Log.d(v0, arg7);
                int v7 = arg6.length;
                int v1;
                for(v1 = 0; v1 < v7; ++v1) {
                    Object v2 = arg6[v1];
                    StringBuilder v3 = new StringBuilder("Keyframe ").append(v1).append(": fraction ");
                    String v5 = "null";
                    if(Float.compare(((Keyframe)v2).getFraction(), 0f) < 0) {
                        v4 = v5;
                    }
                    else {
                        Float v4_1 = Float.valueOf(((Keyframe)v2).getFraction());
                    }

                    v3 = v3.append(v4).append(", , value : ");
                    if(((Keyframe)v2).hasValue()) {
                        Object v5_1 = ((Keyframe)v2).getValue();
                    }

                    Log.d(v0, v3.append(v5).toString());
                }
            }
        }
    }

    private static PropertyValuesHolder getPVH(TypedArray arg11, int arg12, int arg13, int arg14, String arg15) {
        int v11_3;
        PropertyValuesHolder v11_2;
        float v11_1;
        TypedValue v0 = arg11.peekValue(arg13);
        int v3 = v0 != null ? 1 : 0;
        int v0_1 = v3 != 0 ? v0.type : 0;
        TypedValue v4 = arg11.peekValue(arg14);
        int v5 = v4 != null ? 1 : 0;
        int v4_1 = v5 != 0 ? v4.type : 0;
        int v7 = 3;
        if(arg12 == 4) {
            if(v3 != 0 && (AnimatorInflaterCompat.isColorType(v0_1)) || v5 != 0 && (AnimatorInflaterCompat.isColorType(v4_1))) {
                arg12 = v7;
                goto label_32;
            }

            arg12 = 0;
        }

    label_32:
        int v6 = arg12 == 0 ? 1 : 0;
        int v8 = 2;
        PropertyValuesHolder v9 = null;
        if(arg12 == v8) {
            String v12 = arg11.getString(arg13);
            String v11 = arg11.getString(arg14);
            PathDataNode[] v13 = PathParser.createNodesFromPathData(v12);
            PathDataNode[] v14 = PathParser.createNodesFromPathData(v11);
            if(v13 != null || v14 != null) {
                if(v13 != null) {
                    PathDataEvaluator v0_2 = new PathDataEvaluator();
                    if(v14 == null) {
                        return PropertyValuesHolder.ofObject(arg15, ((TypeEvaluator)v0_2), new Object[]{v13});
                    }
                    else if(PathParser.canMorph(v13, v14)) {
                        return PropertyValuesHolder.ofObject(arg15, ((TypeEvaluator)v0_2), new Object[]{v13, v14});
                    }
                    else {
                        throw new InflateException(" Can\'t morph from " + v12 + " to " + v11);
                    }
                }
                else if(v14 != null) {
                    return PropertyValuesHolder.ofObject(arg15, new PathDataEvaluator(), new Object[]{v14});
                }
            }

            return v9;
        }

        ArgbEvaluator v12_1 = arg12 == v7 ? ArgbEvaluator.getInstance() : ((ArgbEvaluator)v9);
        v7 = 5;
        if(v6 != 0) {
            if(v3 != 0) {
                float v13_1 = v0_1 == v7 ? arg11.getDimension(arg13, 0f) : arg11.getFloat(arg13, 0f);
                if(v5 != 0) {
                    v11_1 = v4_1 == v7 ? arg11.getDimension(arg14, 0f) : arg11.getFloat(arg14, 0f);
                    float[] v14_1 = new float[v8];
                    v14_1[0] = v13_1;
                    v14_1[1] = v11_1;
                    v11_2 = PropertyValuesHolder.ofFloat(arg15, v14_1);
                    goto label_108;
                }

                v11_2 = PropertyValuesHolder.ofFloat(arg15, new float[]{v13_1});
            }
            else {
                v11_1 = v4_1 == v7 ? arg11.getDimension(arg14, 0f) : arg11.getFloat(arg14, 0f);
                v11_2 = PropertyValuesHolder.ofFloat(arg15, new float[]{v11_1});
            }

        label_108:
            v9 = v11_2;
        }
        else {
            if(v3 != 0) {
                if(v0_1 == v7) {
                    arg13 = ((int)arg11.getDimension(arg13, 0f));
                }
                else if(AnimatorInflaterCompat.isColorType(v0_1)) {
                    arg13 = arg11.getColor(arg13, 0);
                }
                else {
                    arg13 = arg11.getInt(arg13, 0);
                }

                if(v5 != 0) {
                    if(v4_1 == v7) {
                        v11_3 = ((int)arg11.getDimension(arg14, 0f));
                    }
                    else if(AnimatorInflaterCompat.isColorType(v4_1)) {
                        v11_3 = arg11.getColor(arg14, 0);
                    }
                    else {
                        v11_3 = arg11.getInt(arg14, 0);
                    }

                    v9 = PropertyValuesHolder.ofInt(arg15, new int[]{arg13, v11_3});
                    goto label_148;
                }

                v9 = PropertyValuesHolder.ofInt(arg15, new int[]{arg13});
                goto label_148;
            }

            if(v5 == 0) {
                goto label_148;
            }

            if(v4_1 == v7) {
                v11_3 = ((int)arg11.getDimension(arg14, 0f));
            }
            else if(AnimatorInflaterCompat.isColorType(v4_1)) {
                v11_3 = arg11.getColor(arg14, 0);
            }
            else {
                v11_3 = arg11.getInt(arg14, 0);
            }

            v9 = PropertyValuesHolder.ofInt(arg15, new int[]{v11_3});
        }

    label_148:
        if(v9 != null && v12_1 != null) {
            v9.setEvaluator(((TypeEvaluator)v12_1));
        }

        return v9;
    }

    private static int inferValueTypeFromValues(TypedArray arg3, int arg4, int arg5) {
        TypedValue v4 = arg3.peekValue(arg4);
        int v0 = 1;
        int v2 = v4 != null ? 1 : 0;
        arg4 = v2 != 0 ? v4.type : 0;
        TypedValue v3 = arg3.peekValue(arg5);
        if(v3 != null) {
        }
        else {
            v0 = 0;
        }

        int v3_1 = v0 != 0 ? v3.type : 0;
        if(v2 != 0 && (AnimatorInflaterCompat.isColorType(arg4)) || v0 != 0 && (AnimatorInflaterCompat.isColorType(v3_1))) {
            return 3;
        }

        return 0;
    }

    private static int inferValueTypeOfKeyframe(Resources arg1, Resources$Theme arg2, AttributeSet arg3, XmlPullParser arg4) {
        TypedArray v1 = TypedArrayUtils.obtainAttributes(arg1, arg2, arg3, AndroidResources.STYLEABLE_KEYFRAME);
        int v3 = 0;
        TypedValue v2 = TypedArrayUtils.peekNamedValue(v1, arg4, "value", 0);
        if(v2 != null && (AnimatorInflaterCompat.isColorType(v2.type))) {
            v3 = 3;
        }

        v1.recycle();
        return v3;
    }

    private static boolean isColorType(int arg1) {
        if(arg1 >= 28 && arg1 <= 0x1F) {
            return 1;
        }

        return 0;
    }

    public static Animator loadAnimator(Context arg0, int arg1) throws Resources$NotFoundException {
        return AnimatorInflater.loadAnimator(arg0, arg1);
    }

    private static ValueAnimator loadAnimator(Context arg2, Resources arg3, Resources$Theme arg4, AttributeSet arg5, ValueAnimator arg6, float arg7, XmlPullParser arg8) throws Resources$NotFoundException {
        TypedArray v0 = TypedArrayUtils.obtainAttributes(arg3, arg4, arg5, AndroidResources.STYLEABLE_ANIMATOR);
        TypedArray v3 = TypedArrayUtils.obtainAttributes(arg3, arg4, arg5, AndroidResources.STYLEABLE_PROPERTY_ANIMATOR);
        if(arg6 == null) {
            arg6 = new ValueAnimator();
        }

        AnimatorInflaterCompat.parseAnimatorFromTypeArray(arg6, v0, v3, arg7, arg8);
        int v4 = TypedArrayUtils.getNamedResourceId(v0, arg8, "interpolator", 0, 0);
        if(v4 > 0) {
            arg6.setInterpolator(AnimationUtilsCompat.loadInterpolator(arg2, v4));
        }

        v0.recycle();
        if(v3 != null) {
            v3.recycle();
        }

        return arg6;
    }

    public static Animator loadAnimator(Context arg1, Resources arg2, Resources$Theme arg3, int arg4) throws Resources$NotFoundException {
        return AnimatorInflaterCompat.loadAnimator(arg1, arg2, arg3, arg4, 1f);
    }

    public static Animator loadAnimator(Context arg2, Resources arg3, Resources$Theme arg4, int arg5, float arg6) throws Resources$NotFoundException {
        Resources$NotFoundException v3;
        Animator v2_3;
        XmlResourceParser v1;
        String v0 = "Can\'t load animation resource ID #0x";
        try {
            v1 = arg3.getAnimation(arg5);
            v2_3 = AnimatorInflaterCompat.createAnimatorFromXml(arg2, arg3, arg4, ((XmlPullParser)v1), arg6);
            if(v1 == null) {
                return v2_3;
            }
        }
        catch(Throwable v2) {
        }
        catch(IOException v2_1) {
            try {
                v3 = new Resources$NotFoundException(v0 + Integer.toHexString(arg5));
                v3.initCause(((Throwable)v2_1));
                throw v3;
            }
            catch(Throwable v2) {
            label_29:
                if(v1 != null) {
                    v1.close();
                }

                throw v2;
            }
        }
        catch(XmlPullParserException v2_2) {
            try {
                v3 = new Resources$NotFoundException(v0 + Integer.toHexString(arg5));
                v3.initCause(((Throwable)v2_2));
                throw v3;
            }
            catch(Throwable v2) {
                goto label_29;
            }
        }

        v1.close();
        return v2_3;
    }

    private static Keyframe loadKeyframe(Context arg6, Resources arg7, Resources$Theme arg8, AttributeSet arg9, int arg10, XmlPullParser arg11) throws XmlPullParserException, IOException {
        Keyframe v8_1;
        TypedArray v7 = TypedArrayUtils.obtainAttributes(arg7, arg8, arg9, AndroidResources.STYLEABLE_KEYFRAME);
        int v0 = 3;
        float v8 = TypedArrayUtils.getNamedFloat(v7, arg11, "fraction", v0, -1f);
        String v9 = "value";
        TypedValue v2 = TypedArrayUtils.peekNamedValue(v7, arg11, v9, 0);
        int v4 = v2 != null ? 1 : 0;
        if(arg10 == 4) {
            if(v4 != 0 && (AnimatorInflaterCompat.isColorType(v2.type))) {
                arg10 = v0;
                goto label_23;
            }

            arg10 = 0;
        }

    label_23:
        if(v4 == 0) {
            if(arg10 == 0) {
                v8_1 = Keyframe.ofFloat(v8);
                goto label_40;
            }

            v8_1 = Keyframe.ofInt(v8);
        }
        else if(arg10 != 0) {
            if(arg10 != 1 && arg10 != v0) {
                v8_1 = null;
                goto label_40;
            }

            v8_1 = Keyframe.ofInt(v8, TypedArrayUtils.getNamedInt(v7, arg11, v9, 0, 0));
        }
        else {
            v8_1 = Keyframe.ofFloat(v8, TypedArrayUtils.getNamedFloat(v7, arg11, v9, 0, 0f));
        }

    label_40:
        int v9_1 = TypedArrayUtils.getNamedResourceId(v7, arg11, "interpolator", 1, 0);
        if(v9_1 > 0) {
            v8_1.setInterpolator(AnimationUtilsCompat.loadInterpolator(arg6, v9_1));
        }

        v7.recycle();
        return v8_1;
    }

    private static ObjectAnimator loadObjectAnimator(Context arg7, Resources arg8, Resources$Theme arg9, AttributeSet arg10, float arg11, XmlPullParser arg12) throws Resources$NotFoundException {
        ObjectAnimator v4 = new ObjectAnimator();
        AnimatorInflaterCompat.loadAnimator(arg7, arg8, arg9, arg10, ((ValueAnimator)v4), arg11, arg12);
        return v4;
    }

    private static PropertyValuesHolder loadPvh(Context arg9, Resources arg10, Resources$Theme arg11, XmlPullParser arg12, String arg13, int arg14) throws XmlPullParserException, IOException {
        Keyframe[] v11_1;
        float v2_2;
        int v10;
        int v9_1;
        XmlPullParser v7;
        Resources$Theme v4;
        Context v2_1;
        PropertyValuesHolder v0 = null;
        ArrayList v1 = ((ArrayList)v0);
        while(true) {
            int v2 = arg12.next();
            int v3 = 3;
            if(v2 != v3 && v2 != 1) {
                if(arg12.getName().equals("keyframe")) {
                    if(arg14 == 4) {
                        arg14 = AnimatorInflaterCompat.inferValueTypeOfKeyframe(arg10, arg11, Xml.asAttributeSet(arg12), arg12);
                    }

                    int v6 = arg14;
                    v2_1 = arg9;
                    v4 = arg11;
                    v7 = arg12;
                    Keyframe v9 = AnimatorInflaterCompat.loadKeyframe(v2_1, arg10, v4, Xml.asAttributeSet(arg12), v6, v7);
                    if(v9 != null) {
                        if(v1 == null) {
                            v1 = new ArrayList();
                        }

                        v1.add(v9);
                    }

                    v7.next();
                    arg14 = v6;
                }
                else {
                    v2_1 = arg9;
                    v4 = arg11;
                    v7 = arg12;
                }

                arg9 = v2_1;
                arg11 = v4;
                arg12 = v7;
                continue;
            }

            break;
        }

        if(v1 != null) {
            v9_1 = v1.size();
            if(v9_1 > 0) {
                v10 = 0;
                Object v11 = v1.get(0);
                Object v12 = v1.get(v9_1 - 1);
                float v0_1 = ((Keyframe)v12).getFraction();
                v2_2 = 1f;
                if(Float.compare(v0_1, v2_2) < 0) {
                    if(v0_1 < 0f) {
                        ((Keyframe)v12).setFraction(v2_2);
                    }
                    else {
                        v1.add(v1.size(), AnimatorInflaterCompat.createNewKeyframe(((Keyframe)v12), v2_2));
                        ++v9_1;
                    }
                }

                float v12_1 = ((Keyframe)v11).getFraction();
                if(v12_1 != 0f) {
                    if(v12_1 < 0f) {
                        ((Keyframe)v11).setFraction(0f);
                    }
                    else {
                        v1.add(0, AnimatorInflaterCompat.createNewKeyframe(((Keyframe)v11), 0f));
                        ++v9_1;
                    }
                }

                v11_1 = new Keyframe[v9_1];
                v1.toArray(((Object[])v11_1));
                goto label_66;
            }
        }

        return v0;
    label_66:
        while(v10 < v9_1) {
            Keyframe v12_2 = v11_1[v10];
            if(v12_2.getFraction() < 0f) {
                if(v10 == 0) {
                    v12_2.setFraction(0f);
                }
                else {
                    int v0_2 = v9_1 - 1;
                    if(v10 == v0_2) {
                        v12_2.setFraction(v2_2);
                    }
                    else {
                        int v12_3 = v10 + 1;
                        int v1_1 = v10;
                        while(v12_3 < v0_2) {
                            if(v11_1[v12_3].getFraction() >= 0f) {
                            }
                            else {
                                v1_1 = v12_3;
                                ++v12_3;
                                continue;
                            }

                            break;
                        }

                        AnimatorInflaterCompat.distributeKeyframes(v11_1, v11_1[v1_1 + 1].getFraction() - v11_1[v10 - 1].getFraction(), v10, v1_1);
                    }
                }
            }

            ++v10;
        }

        PropertyValuesHolder v9_2 = PropertyValuesHolder.ofKeyframe(arg13, v11_1);
        if(arg14 == v3) {
            v9_2.setEvaluator(ArgbEvaluator.getInstance());
        }

        return v9_2;
    }

    private static PropertyValuesHolder[] loadValues(Context arg13, Resources arg14, Resources$Theme arg15, XmlPullParser arg16, AttributeSet arg17) throws XmlPullParserException, IOException {
        PropertyValuesHolder[] v14;
        int v8;
        XmlPullParser v3 = arg16;
        PropertyValuesHolder[] v6 = null;
        ArrayList v7 = ((ArrayList)v6);
        while(true) {
            int v0 = v3.getEventType();
            v8 = 0;
            int v1 = 3;
            if(v0 != v1 && v0 != 1) {
                int v2 = 2;
                if(v0 != v2) {
                    v3.next();
                }
                else {
                    if(v3.getName().equals("propertyValuesHolder")) {
                        TypedArray v11 = TypedArrayUtils.obtainAttributes(arg14, arg15, arg17, AndroidResources.STYLEABLE_PROPERTY_VALUES_HOLDER);
                        String v4 = TypedArrayUtils.getNamedString(v11, v3, "propertyName", v1);
                        int v5 = TypedArrayUtils.getNamedInt(v11, v3, "valueType", v2, 4);
                        PropertyValuesHolder v12 = AnimatorInflaterCompat.loadPvh(arg13, arg14, arg15, v3, v4, v5);
                        if(v12 == null) {
                            v12 = AnimatorInflaterCompat.getPVH(v11, v5, 0, 1, v4);
                        }

                        if(v12 != null) {
                            if(v7 == null) {
                                v7 = new ArrayList();
                            }

                            v7.add(v12);
                        }

                        v11.recycle();
                    }

                    arg16.next();
                    v3 = arg16;
                }

                continue;
            }

            break;
        }

        if(v7 != null) {
            int v13 = v7.size();
            v14 = new PropertyValuesHolder[v13];
        }
        else {
            return v6;
        }

        while(v8 < v13) {
            v14[v8] = v7.get(v8);
            ++v8;
        }

        return v14;
    }

    private static void parseAnimatorFromTypeArray(ValueAnimator arg11, TypedArray arg12, TypedArray arg13, float arg14, XmlPullParser arg15) {
        long v0 = ((long)TypedArrayUtils.getNamedInt(arg12, arg15, "duration", 1, 300));
        long v3 = ((long)TypedArrayUtils.getNamedInt(arg12, arg15, "startOffset", 2, 0));
        int v8 = 4;
        int v6 = TypedArrayUtils.getNamedInt(arg12, arg15, "valueType", 7, v8);
        if((TypedArrayUtils.hasAttribute(arg15, "valueFrom")) && (TypedArrayUtils.hasAttribute(arg15, "valueTo"))) {
            int v7 = 6;
            int v9 = 5;
            if(v6 == v8) {
                v6 = AnimatorInflaterCompat.inferValueTypeFromValues(arg12, v9, v7);
            }

            PropertyValuesHolder v7_1 = AnimatorInflaterCompat.getPVH(arg12, v6, v9, v7, "");
            if(v7_1 == null) {
                goto label_30;
            }

            arg11.setValues(new PropertyValuesHolder[]{v7_1});
        }

    label_30:
        arg11.setDuration(v0);
        arg11.setStartDelay(v3);
        arg11.setRepeatCount(TypedArrayUtils.getNamedInt(arg12, arg15, "repeatCount", 3, 0));
        arg11.setRepeatMode(TypedArrayUtils.getNamedInt(arg12, arg15, "repeatMode", v8, 1));
        if(arg13 != null) {
            AnimatorInflaterCompat.setupObjectAnimator(arg11, arg13, v6, arg14, arg15);
        }
    }

    private static void setupObjectAnimator(ValueAnimator arg5, TypedArray arg6, int arg7, float arg8, XmlPullParser arg9) {
        String v0 = TypedArrayUtils.getNamedString(arg6, arg9, "pathData", 1);
        if(v0 != null) {
            String v1 = TypedArrayUtils.getNamedString(arg6, arg9, "propertyXName", 2);
            String v9 = TypedArrayUtils.getNamedString(arg6, arg9, "propertyYName", 3);
            if(v1 == null) {
                if(v9 != null) {
                }
                else {
                    throw new InflateException(arg6.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
                }
            }

            AnimatorInflaterCompat.setupPathMotion(PathParser.createPathFromPathData(v0), ((ObjectAnimator)arg5), arg8 * 0.5f, v1, v9);
            return;
        }

        ((ObjectAnimator)arg5).setPropertyName(TypedArrayUtils.getNamedString(arg6, arg9, "propertyName", 0));
    }

    private static void setupPathMotion(Path arg18, ObjectAnimator arg19, float arg20, String arg21, String arg22) {
        float[] v5;
        Path v0 = arg18;
        ObjectAnimator v1 = arg19;
        String v2 = arg21;
        String v3 = arg22;
        PathMeasure v4 = new PathMeasure(v0, false);
        ArrayList v6 = new ArrayList();
        float v7 = 0f;
        v6.add(Float.valueOf(0f));
        float v8 = 0f;
        do {
            v8 += v4.getLength();
            v6.add(Float.valueOf(v8));
        }
        while(v4.nextContour());

        v4 = new PathMeasure(v0, false);
        int v0_1 = Math.min(100, (((int)(v8 / arg20))) + 1);
        float[] v10 = new float[v0_1];
        float[] v11 = new float[v0_1];
        float[] v13 = new float[2];
        v8 /= ((float)(v0_1 - 1));
        int v14 = 0;
        int v15 = 0;
        while(true) {
            v5 = null;
            if(v14 >= v0_1) {
                break;
            }

            v4.getPosTan(v7 - v6.get(v15).floatValue(), v13, v5);
            v10[v14] = v13[0];
            v11[v14] = v13[1];
            v7 += v8;
            int v5_1 = v15 + 1;
            if(v5_1 < v6.size() && v7 > v6.get(v5_1).floatValue()) {
                v4.nextContour();
                v15 = v5_1;
            }

            ++v14;
        }

        PropertyValuesHolder v0_2 = v2 != null ? PropertyValuesHolder.ofFloat(v2, v10) : ((PropertyValuesHolder)v5);
        if(v3 != null) {
            PropertyValuesHolder v5_2 = PropertyValuesHolder.ofFloat(v3, v11);
        }

        if(v0_2 == null) {
            v1.setValues(new PropertyValuesHolder[]{((PropertyValuesHolder)v5)});
            return;
        }

        if((((PropertyValuesHolder)v5)) == null) {
            v1.setValues(new PropertyValuesHolder[]{v0_2});
            return;
        }

        v1.setValues(new PropertyValuesHolder[]{v0_2, ((PropertyValuesHolder)v5)});
    }
}

