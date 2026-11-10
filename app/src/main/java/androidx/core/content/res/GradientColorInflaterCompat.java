package androidx.core.content.res;

import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader$TileMode;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.core.R$styleable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

final class GradientColorInflaterCompat {
    final class ColorStops {
        final int[] mColors;
        final float[] mOffsets;

        ColorStops(int arg1, int arg2, int arg3) {
            super();
            this.mColors = new int[]{arg1, arg2, arg3};
            this.mOffsets = new float[]{0f, 0.5f, 1f};
        }

        ColorStops(int arg1, int arg2) {
            super();
            this.mColors = new int[]{arg1, arg2};
            this.mOffsets = new float[]{0f, 1f};
        }

        ColorStops(List arg5, List arg6) {
            super();
            int v0 = arg5.size();
            this.mColors = new int[v0];
            this.mOffsets = new float[v0];
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                this.mColors[v1] = arg5.get(v1).intValue();
                this.mOffsets[v1] = arg6.get(v1).floatValue();
            }
        }
    }

    private static final int TILE_MODE_CLAMP = 0;
    private static final int TILE_MODE_MIRROR = 2;
    private static final int TILE_MODE_REPEAT = 1;

    private GradientColorInflaterCompat() {
        super();
    }

    private static ColorStops checkColors(ColorStops arg0, int arg1, int arg2, boolean arg3, int arg4) {
        if(arg0 != null) {
            return arg0;
        }

        if(arg3) {
            return new ColorStops(arg1, arg4, arg2);
        }

        return new ColorStops(arg1, arg2);
    }

    static Shader createFromXml(Resources arg4, XmlPullParser arg5, Resources$Theme arg6) throws XmlPullParserException, IOException {
        AttributeSet v0 = Xml.asAttributeSet(arg5);
        while(true) {
            int v1 = arg5.next();
            int v2 = 2;
            if(v1 != v2 && v1 != 1) {
                continue;
            }

            break;
        }

        if(v1 == v2) {
            return GradientColorInflaterCompat.createFromXmlInner(arg4, arg5, v0, arg6);
        }

        throw new XmlPullParserException("No start tag found");
    }

    static Shader createFromXmlInner(Resources arg20, XmlPullParser arg21, AttributeSet arg22, Resources$Theme arg23) throws IOException, XmlPullParserException {
        XmlPullParser v0 = arg21;
        String v1 = v0.getName();
        if(v1.equals("gradient")) {
            TypedArray v1_1 = TypedArrayUtils.obtainAttributes(arg20, arg23, arg22, styleable.GradientColor);
            float v9 = TypedArrayUtils.getNamedFloat(v1_1, v0, "startX", styleable.GradientColor_android_startX, 0f);
            float v10 = TypedArrayUtils.getNamedFloat(v1_1, v0, "startY", styleable.GradientColor_android_startY, 0f);
            float v11 = TypedArrayUtils.getNamedFloat(v1_1, v0, "endX", styleable.GradientColor_android_endX, 0f);
            float v12 = TypedArrayUtils.getNamedFloat(v1_1, v0, "endY", styleable.GradientColor_android_endY, 0f);
            float v14 = TypedArrayUtils.getNamedFloat(v1_1, v0, "centerX", styleable.GradientColor_android_centerX, 0f);
            float v15 = TypedArrayUtils.getNamedFloat(v1_1, v0, "centerY", styleable.GradientColor_android_centerY, 0f);
            int v5 = TypedArrayUtils.getNamedInt(v1_1, v0, "type", styleable.GradientColor_android_type, 0);
            int v6 = TypedArrayUtils.getNamedColor(v1_1, v0, "startColor", styleable.GradientColor_android_startColor, 0);
            boolean v7 = TypedArrayUtils.hasAttribute(v0, "centerColor");
            int v2 = TypedArrayUtils.getNamedColor(v1_1, v0, "centerColor", styleable.GradientColor_android_centerColor, 0);
            int v3 = TypedArrayUtils.getNamedColor(v1_1, v0, "endColor", styleable.GradientColor_android_endColor, 0);
            int v17 = TypedArrayUtils.getNamedInt(v1_1, v0, "tileMode", styleable.GradientColor_android_tileMode, 0);
            float v8 = TypedArrayUtils.getNamedFloat(v1_1, v0, "gradientRadius", styleable.GradientColor_android_gradientRadius, 0f);
            v1_1.recycle();
            ColorStops v0_1 = GradientColorInflaterCompat.checkColors(GradientColorInflaterCompat.inflateChildElements(arg20, arg21, arg22, arg23), v6, v3, v7, v2);
            if(v5 != 1) {
                if(v5 != 2) {
                    return new LinearGradient(v9, v10, v11, v12, v0_1.mColors, v0_1.mOffsets, GradientColorInflaterCompat.parseTileMode(v17));
                }

                return new SweepGradient(v14, v15, v0_1.mColors, v0_1.mOffsets);
            }

            if(v8 > 0f) {
                return new RadialGradient(v14, v15, v8, v0_1.mColors, v0_1.mOffsets, GradientColorInflaterCompat.parseTileMode(v17));
            }

            throw new XmlPullParserException("<gradient> tag requires \'gradientRadius\' attribute with radial type");
        }

        throw new XmlPullParserException(v0.getPositionDescription() + ": invalid gradient color tag " + v1);
    }

    private static ColorStops inflateChildElements(Resources arg8, XmlPullParser arg9, AttributeSet arg10, Resources$Theme arg11) throws XmlPullParserException, IOException {
        int v0 = arg9.getDepth() + 1;
        ArrayList v2 = new ArrayList(20);
        ArrayList v4 = new ArrayList(20);
        while(true) {
            int v3 = arg9.next();
            if(v3 != 1) {
                int v5 = arg9.getDepth();
                if(v5 < v0 && v3 == 3) {
                    goto label_53;
                }

                if(v3 != 2) {
                    continue;
                }

                if(v5 > v0) {
                    continue;
                }

                if(!arg9.getName().equals("item")) {
                    continue;
                }

                TypedArray v3_1 = TypedArrayUtils.obtainAttributes(arg8, arg11, arg10, styleable.GradientColorItem);
                boolean v5_1 = v3_1.hasValue(styleable.GradientColorItem_android_color);
                boolean v6 = v3_1.hasValue(styleable.GradientColorItem_android_offset);
                if((v5_1) && (v6)) {
                    v5 = v3_1.getColor(styleable.GradientColorItem_android_color, 0);
                    float v6_1 = v3_1.getFloat(styleable.GradientColorItem_android_offset, 0f);
                    v3_1.recycle();
                    ((List)v4).add(Integer.valueOf(v5));
                    ((List)v2).add(Float.valueOf(v6_1));
                    continue;
                }

                break;
            }

            goto label_53;
        }

        throw new XmlPullParserException(arg9.getPositionDescription() + ": <item> tag requires a \'color\' attribute and a \'offset\' attribute!");
    label_53:
        if(((List)v4).size() > 0) {
            return new ColorStops(((List)v4), ((List)v2));
        }

        return null;
    }

    private static Shader$TileMode parseTileMode(int arg1) {
        if(arg1 != 1) {
            if(arg1 != 2) {
                return Shader$TileMode.CLAMP;
            }

            return Shader$TileMode.MIRROR;
        }

        return Shader$TileMode.REPEAT;
    }
}

