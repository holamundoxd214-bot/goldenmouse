package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import androidx.constraintlayout.motion.widget.Debug;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

public class ConstraintAttribute {
    class androidx.constraintlayout.widget.ConstraintAttribute$1 {
        static {
            int[] v0 = new int[AttributeType.values().length];
            androidx.constraintlayout.widget.ConstraintAttribute$1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType = v0;
            try {
                v0[AttributeType.COLOR_TYPE.ordinal()] = 1;
                goto label_8;
            }
            catch(NoSuchFieldError ) {
                try {
                label_8:
                    androidx.constraintlayout.widget.ConstraintAttribute$1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.COLOR_DRAWABLE_TYPE.ordinal()] = 2;
                    goto label_13;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_13:
                        androidx.constraintlayout.widget.ConstraintAttribute$1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.INT_TYPE.ordinal()] = 3;
                        goto label_18;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_18:
                            androidx.constraintlayout.widget.ConstraintAttribute$1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.FLOAT_TYPE.ordinal()] = 4;
                            goto label_23;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_23:
                                androidx.constraintlayout.widget.ConstraintAttribute$1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.STRING_TYPE.ordinal()] = 5;
                                goto label_28;
                            }
                            catch(NoSuchFieldError ) {
                                try {
                                label_28:
                                    androidx.constraintlayout.widget.ConstraintAttribute$1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.BOOLEAN_TYPE.ordinal()] = 6;
                                    goto label_33;
                                }
                                catch(NoSuchFieldError ) {
                                    try {
                                    label_33:
                                        androidx.constraintlayout.widget.ConstraintAttribute$1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.DIMENSION_TYPE.ordinal()] = 7;
                                        return;
                                    }
                                    catch(NoSuchFieldError ) {
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public enum AttributeType {
        public static final enum AttributeType BOOLEAN_TYPE;
        public static final enum AttributeType COLOR_DRAWABLE_TYPE;
        public static final enum AttributeType COLOR_TYPE;
        public static final enum AttributeType DIMENSION_TYPE;
        public static final enum AttributeType FLOAT_TYPE;
        public static final enum AttributeType INT_TYPE;
        public static final enum AttributeType STRING_TYPE;

        static {
            AttributeType v0 = new AttributeType("INT_TYPE", 0);
            AttributeType.INT_TYPE = v0;
            AttributeType v1 = new AttributeType("FLOAT_TYPE", 1);
            AttributeType.FLOAT_TYPE = v1;
            AttributeType v2 = new AttributeType("COLOR_TYPE", 2);
            AttributeType.COLOR_TYPE = v2;
            AttributeType v3 = new AttributeType("COLOR_DRAWABLE_TYPE", 3);
            AttributeType.COLOR_DRAWABLE_TYPE = v3;
            AttributeType v4 = new AttributeType("STRING_TYPE", 4);
            AttributeType.STRING_TYPE = v4;
            AttributeType v5 = new AttributeType("BOOLEAN_TYPE", 5);
            AttributeType.BOOLEAN_TYPE = v5;
            AttributeType v6 = new AttributeType("DIMENSION_TYPE", 6);
            AttributeType.DIMENSION_TYPE = v6;
            AttributeType.$VALUES = new AttributeType[]{v0, v1, v2, v3, v4, v5, v6};
        }

        private AttributeType(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static AttributeType valueOf(String arg1) {
            return Enum.valueOf(AttributeType.class, arg1);
        }

        public static AttributeType[] values() {
            return AttributeType.$VALUES.clone();
        }
    }

    private static final String TAG = "TransitionLayout";
    boolean mBooleanValue;
    private int mColorValue;
    private float mFloatValue;
    private int mIntegerValue;
    String mName;
    private String mStringValue;
    private AttributeType mType;

    public ConstraintAttribute(String arg1, AttributeType arg2) {
        super();
        this.mName = arg1;
        this.mType = arg2;
    }

    public ConstraintAttribute(ConstraintAttribute arg2, Object arg3) {
        super();
        this.mName = arg2.mName;
        this.mType = arg2.mType;
        this.setValue(arg3);
    }

    public ConstraintAttribute(String arg1, AttributeType arg2, Object arg3) {
        super();
        this.mName = arg1;
        this.mType = arg2;
        this.setValue(arg3);
    }

    private static int clamp(int arg1) {
        arg1 = (arg1 & ~(arg1 >> 0x1F)) - 0xFF;
        return (arg1 & arg1 >> 0x1F) + 0xFF;
    }

    public boolean diff(ConstraintAttribute arg4) {
        if(arg4 != null) {
            if(this.mType != arg4.mType) {
            }
            else {
                switch(androidx.constraintlayout.widget.ConstraintAttribute$1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
                    case 1: 
                    case 2: {
                        goto label_38;
                    }
                    case 3: {
                        goto label_33;
                    }
                    case 4: {
                        goto label_28;
                    }
                    case 5: {
                        goto label_23;
                    }
                    case 6: {
                        goto label_18;
                    }
                    case 7: {
                        goto label_13;
                    }
                }

                return 0;
            label_33:
                if(this.mIntegerValue == arg4.mIntegerValue) {
                    return 1;
                }
                else {
                    return 0;
                label_18:
                    if(this.mBooleanValue == arg4.mBooleanValue) {
                        return 1;
                    }
                    else {
                        return 0;
                    label_38:
                        if(this.mColorValue == arg4.mColorValue) {
                            return 1;
                        label_23:
                            if(this.mIntegerValue == arg4.mIntegerValue) {
                                return 1;
                            }
                            else {
                                return 0;
                            label_28:
                                if(this.mFloatValue == arg4.mFloatValue) {
                                    return 1;
                                }
                                else {
                                    return 0;
                                label_13:
                                    if(this.mFloatValue == arg4.mFloatValue) {
                                        return 1;
                                    }
                                    else {
                                        return 0;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return 0;
    }

    public static HashMap extractAttributes(HashMap arg8, View arg9) {
        HashMap v0 = new HashMap();
        Class v1 = arg9.getClass();
        Iterator v2 = arg8.keySet().iterator();
        while(v2.hasNext()) {
            Object v3 = v2.next();
            Object v4 = arg8.get(v3);
            try {
                if(((String)v3).equals("BackgroundColor")) {
                    v0.put(v3, new ConstraintAttribute(((ConstraintAttribute)v4), Integer.valueOf(arg9.getBackground().getColor())));
                    continue;
                }

                v0.put(v3, new ConstraintAttribute(((ConstraintAttribute)v4), v1.getMethod("getMap" + (((String)v3))).invoke(arg9)));
            }
            catch(InvocationTargetException v3_1) {
                v3_1.printStackTrace();
            }
            catch(IllegalAccessException v3_2) {
                v3_2.printStackTrace();
            }
            catch(NoSuchMethodException v3_3) {
                v3_3.printStackTrace();
            }
        }

        return v0;
    }

    public AttributeType getType() {
        return this.mType;
    }

    public float getValueToInterpolate() {
        switch(androidx.constraintlayout.widget.ConstraintAttribute$1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
            case 1: 
            case 2: {
                goto label_24;
            }
            case 3: {
                goto label_21;
            }
            case 4: {
                goto label_19;
            }
            case 5: {
                goto label_15;
            }
            case 6: {
                goto label_9;
            }
            case 7: {
                goto label_7;
            }
        }

        return NaNf;
    label_19:
        return this.mFloatValue;
    label_21:
        return ((float)this.mIntegerValue);
    label_7:
        return this.mFloatValue;
    label_24:
        throw new RuntimeException("Color does not have a single color to interpolate");
    label_9:
        if(this.mBooleanValue) {
            return 0;
        }

        return 1f;
    label_15:
        throw new RuntimeException("Cannot interpolate String");
    }

    public void getValuesToInterpolate(float[] arg10) {
        switch(androidx.constraintlayout.widget.ConstraintAttribute$1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
            case 1: 
            case 2: {
                goto label_28;
            }
            case 3: {
                goto label_24;
            }
            case 4: {
                goto label_21;
            }
            case 5: {
                goto label_17;
            }
            case 6: {
                goto label_10;
            }
            case 7: {
                goto label_7;
            }
        }

        return;
    label_17:
        throw new RuntimeException("Color does not have a single color to interpolate");
    label_21:
        arg10[0] = this.mFloatValue;
        return;
    label_7:
        arg10[0] = this.mFloatValue;
        return;
    label_24:
        arg10[0] = ((float)this.mIntegerValue);
        return;
    label_10:
        float v9 = this.mBooleanValue ? 0f : 1f;
        arg10[0] = v9;
        return;
    label_28:
        int v0 = this.mColorValue >> 24 & 0xFF;
        int v2 = this.mColorValue >> 16 & 0xFF;
        int v3 = this.mColorValue >> 8 & 0xFF;
        int v9_1 = this.mColorValue & 0xFF;
        float v2_1 = ((float)Math.pow(((double)((((float)v2)) / 255f)), 2.2));
        float v3_1 = ((float)Math.pow(((double)((((float)v3)) / 255f)), 2.2));
        v9 = ((float)Math.pow(((double)((((float)v9_1)) / 255f)), 2.2));
        arg10[0] = v2_1;
        arg10[1] = v3_1;
        arg10[2] = v9;
        arg10[3] = (((float)v0)) / 255f;
    }

    public int noOfInterpValues() {
        int v2 = androidx.constraintlayout.widget.ConstraintAttribute$1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()];
        if(v2 != 1 && v2 != 2) {
            return 1;
        }

        return 4;
    }

    public static void parse(Context arg11, XmlPullParser arg12, HashMap arg13) {
        String v4_3;
        Float v4_2;
        Integer v4_1;
        AttributeType v3_1;
        TypedArray v12 = arg11.obtainStyledAttributes(Xml.asAttributeSet(arg12), styleable.CustomAttribute);
        int v0 = v12.getIndexCount();
        String v1 = null;
        Boolean v3 = ((Boolean)v1);
        AttributeType v4 = ((AttributeType)v3);
        int v5;
        for(v5 = 0; v5 < v0; ++v5) {
            int v6 = v12.getIndex(v5);
            if(v6 == styleable.CustomAttribute_attributeName) {
                v1 = v12.getString(v6);
                if(v1 != null && v1.length() > 0) {
                    v1 = Character.toUpperCase(v1.charAt(0)) + v1.substring(1);
                }
            }
            else if(v6 == styleable.CustomAttribute_customBoolean) {
                v3 = Boolean.valueOf(v12.getBoolean(v6, false));
                v4 = AttributeType.BOOLEAN_TYPE;
            }
            else {
                if(v6 == styleable.CustomAttribute_customColorValue) {
                    v3_1 = AttributeType.COLOR_TYPE;
                    v4_1 = Integer.valueOf(v12.getColor(v6, 0));
                }
                else if(v6 == styleable.CustomAttribute_customColorDrawableValue) {
                    v3_1 = AttributeType.COLOR_DRAWABLE_TYPE;
                    v4_1 = Integer.valueOf(v12.getColor(v6, 0));
                }
                else if(v6 == styleable.CustomAttribute_customPixelDimension) {
                    v3_1 = AttributeType.DIMENSION_TYPE;
                    v4_2 = Float.valueOf(TypedValue.applyDimension(1, v12.getDimension(v6, 0f), arg11.getResources().getDisplayMetrics()));
                }
                else if(v6 == styleable.CustomAttribute_customDimension) {
                    v3_1 = AttributeType.DIMENSION_TYPE;
                    v4_2 = Float.valueOf(v12.getDimension(v6, 0f));
                }
                else if(v6 == styleable.CustomAttribute_customFloatValue) {
                    v3_1 = AttributeType.FLOAT_TYPE;
                    v4_2 = Float.valueOf(v12.getFloat(v6, NaNf));
                }
                else if(v6 == styleable.CustomAttribute_customIntegerValue) {
                    v3_1 = AttributeType.INT_TYPE;
                    v4_1 = Integer.valueOf(v12.getInteger(v6, -1));
                }
                else if(v6 == styleable.CustomAttribute_customStringValue) {
                    v3_1 = AttributeType.STRING_TYPE;
                    v4_3 = v12.getString(v6);
                }
                else {
                    goto label_83;
                }

                Integer v10 = ((Integer)v4_3);
                v4 = v3_1;
                Integer v3_2 = v10;
            }

        label_83:
        }

        if(v1 != null && v3 != null) {
            arg13.put(v1, new ConstraintAttribute(v1, v4, v3));
        }

        v12.recycle();
    }

    public static void setAttributes(View arg11, HashMap arg12) {
        String v0 = "\" not found on ";
        String v1 = " Custom Attribute \"";
        String v2 = "TransitionLayout";
        Class v3 = arg11.getClass();
        Iterator v4 = arg12.keySet().iterator();
        while(v4.hasNext()) {
            Object v5 = v4.next();
            Object v6 = arg12.get(v5);
            String v7 = "set" + (((String)v5));
            try {
                switch(androidx.constraintlayout.widget.ConstraintAttribute$1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[((ConstraintAttribute)v6).mType.ordinal()]) {
                    case 1: {
                        goto label_78;
                    }
                    case 2: {
                        goto label_67;
                    }
                    case 3: {
                        goto label_58;
                    }
                    case 4: {
                        goto label_49;
                    }
                    case 5: {
                        goto label_41;
                    }
                    case 6: {
                        goto label_32;
                    }
                    case 7: {
                        goto label_23;
                    }
                }

                continue;
            label_49:
                v3.getMethod(v7, Float.TYPE).invoke(arg11, Float.valueOf(((ConstraintAttribute)v6).mFloatValue));
                continue;
            label_67:
                Method v8 = v3.getMethod(v7, Drawable.class);
                ColorDrawable v9 = new ColorDrawable();
                v9.setColor(((ConstraintAttribute)v6).mColorValue);
                v8.invoke(arg11, v9);
                continue;
            label_23:
                v3.getMethod(v7, Float.TYPE).invoke(arg11, Float.valueOf(((ConstraintAttribute)v6).mFloatValue));
                continue;
            label_41:
                v3.getMethod(v7, CharSequence.class).invoke(arg11, ((ConstraintAttribute)v6).mStringValue);
                continue;
            label_58:
                v3.getMethod(v7, Integer.TYPE).invoke(arg11, Integer.valueOf(((ConstraintAttribute)v6).mIntegerValue));
                continue;
            label_78:
                v3.getMethod(v7, Integer.TYPE).invoke(arg11, Integer.valueOf(((ConstraintAttribute)v6).mColorValue));
                continue;
            label_32:
                v3.getMethod(v7, Boolean.TYPE).invoke(arg11, Boolean.valueOf(((ConstraintAttribute)v6).mBooleanValue));
            }
            catch(InvocationTargetException v6_1) {
                Log.e(v2, v1 + (((String)v5)) + v0 + v3.getName());
                v6_1.printStackTrace();
            }
            catch(IllegalAccessException v6_2) {
                Log.e(v2, v1 + (((String)v5)) + v0 + v3.getName());
                v6_2.printStackTrace();
            }
            catch(NoSuchMethodException v6_3) {
                Log.e(v2, v6_3.getMessage());
                Log.e(v2, v1 + (((String)v5)) + v0 + v3.getName());
                Log.e(v2, v3.getName() + " must have a method " + v7);
            }
        }
    }

    public void setColorValue(int arg1) {
        this.mColorValue = arg1;
    }

    public void setFloatValue(float arg1) {
        this.mFloatValue = arg1;
    }

    public void setIntValue(int arg1) {
        this.mIntegerValue = arg1;
    }

    public void setInterpolatedValue(View arg17, float[] arg18) {
        ConstraintAttribute v0 = this;
        View v1 = arg17;
        String v2 = "\"";
        String v3 = "on View \"";
        String v4 = "TransitionLayout";
        String v5 = "unable to interpolate strings ";
        Class v6 = v1.getClass();
        String v7 = "set" + v0.mName;
        try {
            int v9 = 3;
            int v10 = 2;
            double v11 = 0.454545;
            float v13 = 255f;
            boolean v14 = true;
            switch(androidx.constraintlayout.widget.ConstraintAttribute$1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[v0.mType.ordinal()]) {
                case 1: {
                    goto label_115;
                }
                case 2: {
                    goto label_74;
                }
                case 3: {
                    goto label_64;
                }
                case 4: {
                    goto label_55;
                }
                case 5: {
                    goto label_47;
                }
                case 6: {
                    goto label_34;
                }
                case 7: {
                    goto label_25;
                }
            }

            return;
        label_34:
            Method v0_4 = v6.getMethod(v7, Boolean.TYPE);
            if(arg18[0] > 0.5f) {
            }
            else {
                v14 = false;
            }

            v0_4.invoke(v1, Boolean.valueOf(v14));
            return;
        label_115:
            v6.getMethod(v7, Integer.TYPE).invoke(v1, Integer.valueOf(ConstraintAttribute.clamp(((int)((((float)Math.pow(((double)arg18[0]), v11))) * v13))) << 16 | ConstraintAttribute.clamp(((int)(arg18[v9] * v13))) << 24 | ConstraintAttribute.clamp(((int)((((float)Math.pow(((double)arg18[1]), v11))) * v13))) << 8 | ConstraintAttribute.clamp(((int)((((float)Math.pow(((double)arg18[v10]), v11))) * v13)))));
            return;
        label_55:
            v6.getMethod(v7, Float.TYPE).invoke(v1, Float.valueOf(arg18[0]));
            return;
        label_25:
            v6.getMethod(v7, Float.TYPE).invoke(v1, Float.valueOf(arg18[0]));
            return;
        label_74:
            v0_4 = v6.getMethod(v7, Drawable.class);
            int v5_1 = ConstraintAttribute.clamp(((int)((((float)Math.pow(((double)arg18[0]), v11))) * v13))) << 16 | ConstraintAttribute.clamp(((int)(arg18[v9] * v13))) << 24 | ConstraintAttribute.clamp(((int)((((float)Math.pow(((double)arg18[1]), v11))) * v13))) << 8 | ConstraintAttribute.clamp(((int)((((float)Math.pow(((double)arg18[v10]), v11))) * v13)));
            ColorDrawable v6_1 = new ColorDrawable();
            v6_1.setColor(v5_1);
            v0_4.invoke(v1, v6_1);
            return;
        label_47:
            throw new RuntimeException(v5 + v0.mName);
        label_64:
            v6.getMethod(v7, Integer.TYPE).invoke(v1, Integer.valueOf(((int)arg18[0])));
            return;
        }
        catch(InvocationTargetException v0_1) {
            v0_1.printStackTrace();
        }
        catch(IllegalAccessException v0_2) {
            Log.e(v4, "cannot access method " + v7 + v3 + Debug.getName(v1) + v2);
            v0_2.printStackTrace();
        }
        catch(NoSuchMethodException v0_3) {
            Log.e(v4, "no method " + v7 + v3 + Debug.getName(v1) + v2);
            v0_3.printStackTrace();
        }
    }

    public void setStringValue(String arg1) {
        this.mStringValue = arg1;
    }

    public void setValue(Object arg3) {
        switch(androidx.constraintlayout.widget.ConstraintAttribute$1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
            case 1: 
            case 2: {
                goto label_20;
            }
            case 3: {
                goto label_17;
            }
            case 4: {
                goto label_14;
            }
            case 5: {
                goto label_12;
            }
            case 6: {
                goto label_9;
            }
            case 7: {
                goto label_6;
            }
        }

        return;
    label_17:
        this.mIntegerValue = ((Integer)arg3).intValue();
        return;
    label_20:
        this.mColorValue = ((Integer)arg3).intValue();
        return;
    label_6:
        this.mFloatValue = ((Float)arg3).floatValue();
        return;
    label_9:
        this.mBooleanValue = ((Boolean)arg3).booleanValue();
        return;
    label_12:
        this.mStringValue = ((String)arg3);
        return;
    label_14:
        this.mFloatValue = ((Float)arg3).floatValue();
    }

    public void setValue(float[] arg7) {
        boolean v1 = false;
        switch(androidx.constraintlayout.widget.ConstraintAttribute$1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
            case 1: 
            case 2: {
                goto label_28;
            }
            case 3: {
                goto label_24;
            }
            case 4: {
                goto label_21;
            }
            case 5: {
                goto label_17;
            }
            case 6: {
                goto label_10;
            }
            case 7: {
                goto label_7;
            }
        }

        return;
    label_17:
        throw new RuntimeException("Color does not have a single color to interpolate");
    label_21:
        this.mFloatValue = arg7[0];
        return;
    label_7:
        this.mFloatValue = arg7[0];
        return;
    label_24:
        this.mIntegerValue = ((int)arg7[0]);
        return;
    label_10:
        if((((double)arg7[0])) > 0.5) {
            v1 = true;
        }

        this.mBooleanValue = v1;
        return;
    label_28:
        int v0 = Color.HSVToColor(arg7);
        this.mColorValue = v0;
        this.mColorValue = ConstraintAttribute.clamp(((int)(arg7[3] * 255f))) << 24 | v0 & 0xFFFFFF;
    }
}

