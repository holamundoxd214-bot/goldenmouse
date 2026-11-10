package androidx.transition;

import android.content.Context;
import android.content.res.Resources$NotFoundException;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.core.content.res.TypedArrayUtils;
import java.io.IOException;
import java.lang.reflect.Constructor;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class TransitionInflater {
    private static final ArrayMap CONSTRUCTORS;
    private static final Class[] CONSTRUCTOR_SIGNATURE;
    private final Context mContext;

    static {
        TransitionInflater.CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class};
        TransitionInflater.CONSTRUCTORS = new ArrayMap();
    }

    private TransitionInflater(Context arg1) {
        super();
        this.mContext = arg1;
    }

    private Object createCustom(AttributeSet arg5, Class arg6, String arg7) {
        ArrayMap v7;
        String v0 = arg5.getAttributeValue(null, "class");
        if(v0 != null) {
            try {
                v7 = TransitionInflater.CONSTRUCTORS;
                __monitor_enter(v7);
            }
            catch(Exception v4) {
                goto label_38;
            }

            try {
                Object v1 = v7.get(v0);
                if(v1 == null) {
                    Class v2 = Class.forName(v0, false, this.mContext.getClassLoader()).asSubclass(arg6);
                    if(v2 != null) {
                        Constructor v1_1 = v2.getConstructor(TransitionInflater.CONSTRUCTOR_SIGNATURE);
                        v1_1.setAccessible(true);
                        v7.put(v0, v1_1);
                    }
                }

                __monitor_exit(v7);
                return ((Constructor)v1).newInstance(this.mContext, arg5);
            label_25:
                __monitor_exit(v7);
            }
            catch(Throwable v4_1) {
                goto label_25;
            }

            try {
                throw v4_1;
            }
            catch(Exception v4) {
            label_38:
                throw new InflateException("Could not instantiate " + arg6 + " class " + v0, ((Throwable)v4));
            }
        }

        throw new InflateException(arg7 + " tag must have a \'class\' attribute");
    }

    private Transition createTransitionFromXml(XmlPullParser arg8, AttributeSet arg9, Transition arg10) throws XmlPullParserException, IOException {
        ChangeScroll v3_8;
        int v0 = arg8.getDepth();
        Transition v2 = null;
        Transition v1 = (arg10 instanceof TransitionSet) ? arg10 : v2;
        while(true) {
        label_7:
            Fade v3 = ((Fade)v2);
            while(true) {
            label_8:
                int v4 = arg8.next();
                if((v4 != 3 || arg8.getDepth() > v0) && v4 != 1) {
                    if(v4 != 2) {
                        continue;
                    }
                    else {
                        String v4_1 = arg8.getName();
                        if("fade".equals(v4_1)) {
                            v3 = new Fade(this.mContext, arg9);
                        }
                        else if("changeBounds".equals(v4_1)) {
                            ChangeBounds v3_1 = new ChangeBounds(this.mContext, arg9);
                        }
                        else if("slide".equals(v4_1)) {
                            Slide v3_2 = new Slide(this.mContext, arg9);
                        }
                        else if("explode".equals(v4_1)) {
                            Explode v3_3 = new Explode(this.mContext, arg9);
                        }
                        else if("changeImageTransform".equals(v4_1)) {
                            ChangeImageTransform v3_4 = new ChangeImageTransform(this.mContext, arg9);
                        }
                        else if("changeTransform".equals(v4_1)) {
                            ChangeTransform v3_5 = new ChangeTransform(this.mContext, arg9);
                        }
                        else if("changeClipBounds".equals(v4_1)) {
                            ChangeClipBounds v3_6 = new ChangeClipBounds(this.mContext, arg9);
                        }
                        else if("autoTransition".equals(v4_1)) {
                            AutoTransition v3_7 = new AutoTransition(this.mContext, arg9);
                        }
                        else if("changeScroll".equals(v4_1)) {
                            v3_8 = new ChangeScroll(this.mContext, arg9);
                        }
                        else if("transitionSet".equals(v4_1)) {
                            TransitionSet v3_9 = new TransitionSet(this.mContext, arg9);
                        }
                        else {
                            String v5 = "transition";
                            if(v5.equals(v4_1)) {
                                Object v3_10 = this.createCustom(arg9, Transition.class, v5);
                            }
                            else if("targets".equals(v4_1)) {
                                this.getTargetIds(arg8, arg9, arg10);
                            }
                            else if(!"arcMotion".equals(v4_1)) {
                                v5 = "pathMotion";
                                if(v5.equals(v4_1)) {
                                    if(arg10 != null) {
                                        arg10.setPathMotion(this.createCustom(arg9, PathMotion.class, v5));
                                    }
                                    else {
                                        throw new RuntimeException("Invalid use of pathMotion element");
                                    }
                                }
                                else if(!"patternPathMotion".equals(v4_1)) {
                                    goto label_150;
                                }
                                else if(arg10 != null) {
                                    arg10.setPathMotion(new PatternPathMotion(this.mContext, arg9));
                                }
                                else {
                                    goto label_146;
                                }
                            }
                            else if(arg10 != null) {
                                arg10.setPathMotion(new ArcMotion(this.mContext, arg9));
                            }
                            else {
                                throw new RuntimeException("Invalid use of arcMotion element");
                            }
                        }

                        if((((Fade)v3_8)) == null) {
                            continue;
                        }

                        if(!arg8.isEmptyElementTag()) {
                            this.createTransitionFromXml(arg8, arg9, ((Transition)v3_8));
                        }

                        if(v1 == null) {
                            break;
                        }

                        ((TransitionSet)v1).addTransition(((Transition)v3_8));
                        goto label_7;
                    }
                }

                goto label_159;
            }
        }

        if(arg10 == null) {
            goto label_8;
        }

        throw new InflateException("Could not add transition to another transition.");
    label_146:
        throw new RuntimeException("Invalid use of patternPathMotion element");
    label_150:
        throw new RuntimeException("Unknown scene name: " + arg8.getName());
    label_159:
        return ((Transition)v3_8);
    }

    private TransitionManager createTransitionManagerFromXml(XmlPullParser arg5, AttributeSet arg6, ViewGroup arg7) throws XmlPullParserException, IOException {
        int v0 = arg5.getDepth();
        TransitionManager v1 = null;
        while(true) {
            int v2 = arg5.next();
            if((v2 != 3 || arg5.getDepth() > v0) && v2 != 1) {
                if(v2 != 2) {
                    continue;
                }
                else {
                    String v2_1 = arg5.getName();
                    if(v2_1.equals("transitionManager")) {
                        v1 = new TransitionManager();
                        continue;
                    }
                    else {
                        if((v2_1.equals("transition")) && v1 != null) {
                            this.loadTransition(arg6, arg5, arg7, v1);
                            continue;
                        }

                        break;
                    }
                }
            }

            return v1;
        }

        throw new RuntimeException("Unknown scene name: " + arg5.getName());
        return v1;
    }

    public static TransitionInflater from(Context arg1) {
        return new TransitionInflater(arg1);
    }

    private void getTargetIds(XmlPullParser arg8, AttributeSet arg9, Transition arg10) throws XmlPullParserException, IOException {
        int v0 = arg8.getDepth();
        while(true) {
            int v1 = arg8.next();
            int v2 = 3;
            if((v1 != v2 || arg8.getDepth() > v0) && v1 != 1) {
                int v4 = 2;
                if(v1 != v4) {
                    continue;
                }
                else if(arg8.getName().equals("target")) {
                    TypedArray v1_1 = this.mContext.obtainStyledAttributes(arg9, Styleable.TRANSITION_TARGET);
                    int v5 = TypedArrayUtils.getNamedResourceId(v1_1, arg8, "targetId", 1, 0);
                    if(v5 != 0) {
                        arg10.addTarget(v5);
                    }
                    else {
                        v4 = TypedArrayUtils.getNamedResourceId(v1_1, arg8, "excludeId", v4, 0);
                        if(v4 != 0) {
                            arg10.excludeTarget(v4, true);
                        }
                        else {
                            String v4_1 = TypedArrayUtils.getNamedString(v1_1, arg8, "targetName", 4);
                            if(v4_1 != null) {
                                arg10.addTarget(v4_1);
                            }
                            else {
                                v4_1 = TypedArrayUtils.getNamedString(v1_1, arg8, "excludeName", 5);
                                if(v4_1 != null) {
                                    arg10.excludeTarget(v4_1, true);
                                }
                                else {
                                    String v2_1 = TypedArrayUtils.getNamedString(v1_1, arg8, "excludeClass", v2);
                                    if(v2_1 != null) {
                                        try {
                                            arg10.excludeTarget(Class.forName(v2_1), true);
                                            goto label_52;
                                        label_47:
                                            v2_1 = TypedArrayUtils.getNamedString(v1_1, arg8, "targetClass", 0);
                                            if(v2_1 != null) {
                                                arg10.addTarget(Class.forName(v2_1));
                                            }
                                        }
                                        catch(ClassNotFoundException v7) {
                                            v1_1.recycle();
                                            throw new RuntimeException("Could not create " + v2_1, ((Throwable)v7));
                                        }
                                    }
                                    else {
                                        goto label_47;
                                    }
                                }
                            }
                        }
                    }

                label_52:
                    v1_1.recycle();
                    continue;
                }
                else {
                    break;
                }
            }

            return;
        }

        throw new RuntimeException("Unknown scene name: " + arg8.getName());
    }

    public Transition inflateTransition(int arg4) {
        Transition v3_3;
        XmlResourceParser v4 = this.mContext.getResources().getXml(arg4);
        try {
            v3_3 = this.createTransitionFromXml(((XmlPullParser)v4), Xml.asAttributeSet(((XmlPullParser)v4)), null);
        }
        catch(Throwable v3) {
        }
        catch(IOException v3_1) {
            try {
                throw new InflateException(v4.getPositionDescription() + ": " + v3_1.getMessage(), ((Throwable)v3_1));
            }
            catch(Throwable v3) {
            label_28:
                v4.close();
                throw v3;
            }
        }
        catch(XmlPullParserException v3_2) {
            try {
                throw new InflateException(v3_2.getMessage(), ((Throwable)v3_2));
            }
            catch(Throwable v3) {
                goto label_28;
            }
        }

        v4.close();
        return v3_3;
    }

    public TransitionManager inflateTransitionManager(int arg3, ViewGroup arg4) {
        InflateException v4;
        TransitionManager v2_3;
        XmlResourceParser v3 = this.mContext.getResources().getXml(arg3);
        try {
            v2_3 = this.createTransitionManagerFromXml(((XmlPullParser)v3), Xml.asAttributeSet(((XmlPullParser)v3)), arg4);
        }
        catch(Throwable v2) {
        }
        catch(IOException v2_1) {
            try {
                v4 = new InflateException(v3.getPositionDescription() + ": " + v2_1.getMessage());
                v4.initCause(((Throwable)v2_1));
                throw v4;
            }
            catch(Throwable v2) {
            label_29:
                v3.close();
                throw v2;
            }
        }
        catch(XmlPullParserException v2_2) {
            try {
                v4 = new InflateException(v2_2.getMessage());
                v4.initCause(((Throwable)v2_2));
                throw v4;
            }
            catch(Throwable v2) {
                goto label_29;
            }
        }

        v3.close();
        return v2_3;
    }

    private void loadTransition(AttributeSet arg7, XmlPullParser arg8, ViewGroup arg9, TransitionManager arg10) throws Resources$NotFoundException {
        TypedArray v7 = this.mContext.obtainStyledAttributes(arg7, Styleable.TRANSITION_MANAGER);
        int v2 = -1;
        int v0 = TypedArrayUtils.getNamedResourceId(v7, arg8, "transition", 2, v2);
        int v1 = TypedArrayUtils.getNamedResourceId(v7, arg8, "fromScene", 0, v2);
        Scene v3 = null;
        Scene v1_1 = v1 < 0 ? v3 : Scene.getSceneForLayout(arg9, v1, this.mContext);
        int v8 = TypedArrayUtils.getNamedResourceId(v7, arg8, "toScene", 1, v2);
        if(v8 < 0) {
        }
        else {
            v3 = Scene.getSceneForLayout(arg9, v8, this.mContext);
        }

        if(v0 >= 0) {
            Transition v6 = this.inflateTransition(v0);
            if(v6 != null) {
                if(v3 == null) {
                    throw new RuntimeException("No toScene for transition ID " + v0);
                }
                else if(v1_1 == null) {
                    arg10.setTransition(v3, v6);
                }
                else {
                    arg10.setTransition(v1_1, v3, v6);
                }
            }
        }

        v7.recycle();
    }
}

