package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build$VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.R$attr;
import androidx.core.R$styleable;
import androidx.core.math.MathUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class ColorStateListInflaterCompat {
    private static final ThreadLocal sTempTypedValue;

    static {
        ColorStateListInflaterCompat.sTempTypedValue = new ThreadLocal();
    }

    private ColorStateListInflaterCompat() {
        super();
    }

    public static ColorStateList createFromXml(Resources arg4, XmlPullParser arg5, Resources$Theme arg6) throws XmlPullParserException, IOException {
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
            return ColorStateListInflaterCompat.createFromXmlInner(arg4, arg5, v0, arg6);
        }

        throw new XmlPullParserException("No start tag found");
    }

    public static ColorStateList createFromXmlInner(Resources arg2, XmlPullParser arg3, AttributeSet arg4, Resources$Theme arg5) throws XmlPullParserException, IOException {
        String v0 = arg3.getName();
        if(v0.equals("selector")) {
            return ColorStateListInflaterCompat.inflate(arg2, arg3, arg4, arg5);
        }

        throw new XmlPullParserException(arg3.getPositionDescription() + ": invalid color state list tag " + v0);
    }

    private static TypedValue getTypedValue() {
        TypedValue v1_1;
        ThreadLocal v0 = ColorStateListInflaterCompat.sTempTypedValue;
        Object v1 = v0.get();
        if(v1 == null) {
            v1_1 = new TypedValue();
            v0.set(v1_1);
        }

        return v1_1;
    }

    private static ColorStateList inflate(Resources arg17, XmlPullParser arg18, AttributeSet arg19, Resources$Theme arg20) throws XmlPullParserException, IOException {
        Object[] v6_1;
        int[] v0_1;
        Resources v0 = arg17;
        AttributeSet v1 = arg19;
        Resources$Theme v2 = arg20;
        int v4 = 1;
        int v3 = arg18.getDepth() + 1;
        int[][] v6 = new int[20][];
        int[] v5 = new int[20];
        int v8 = 0;
        while(true) {
            int v9 = arg18.next();
            if(v9 != v4) {
                int v10 = arg18.getDepth();
                if(v10 < v3 && v9 == 3) {
                    break;
                }

                if(v9 == 2 && v10 <= v3 && (arg18.getName().equals("item"))) {
                    TypedArray v9_1 = ColorStateListInflaterCompat.obtainAttributes(v0, v2, v1, styleable.ColorStateListItem);
                    v10 = v9_1.getResourceId(styleable.ColorStateListItem_android_color, -1);
                    int v12 = 0xFFFF00FF;
                    if(v10 != -1 && !ColorStateListInflaterCompat.isColorInt(v0, v10)) {
                        try {
                            v10 = ColorStateListInflaterCompat.createFromXml(v0, v0.getXml(v10), v2).getDefaultColor();
                        }
                        catch(Exception ) {
                            v10 = v9_1.getColor(styleable.ColorStateListItem_android_color, v12);
                        }
                    }
                    else {
                        v10 = v9_1.getColor(styleable.ColorStateListItem_android_color, v12);
                    }

                    float v12_1 = 1f;
                    if(v9_1.hasValue(styleable.ColorStateListItem_android_alpha)) {
                        v12_1 = v9_1.getFloat(styleable.ColorStateListItem_android_alpha, v12_1);
                    }
                    else if(v9_1.hasValue(styleable.ColorStateListItem_alpha)) {
                        v12_1 = v9_1.getFloat(styleable.ColorStateListItem_alpha, v12_1);
                    }

                    float v14 = -1f;
                    float v11 = Build$VERSION.SDK_INT < 0x1F || !v9_1.hasValue(styleable.ColorStateListItem_android_lStar) ? v9_1.getFloat(styleable.ColorStateListItem_lStar, v14) : v9_1.getFloat(styleable.ColorStateListItem_android_lStar, v14);
                    v9_1.recycle();
                    v9 = v1.getAttributeCount();
                    int[] v13 = new int[v9];
                    int v14_1 = 0;
                    int v15 = 0;
                    while(v14_1 < v9) {
                        v4 = v1.getAttributeNameResource(v14_1);
                        if(v4 != 0x10101A5 && v4 != 0x101031F && v4 != attr.alpha && v4 != attr.lStar) {
                            int v7 = v15 + 1;
                            if(v1.getAttributeBooleanValue(v14_1, false)) {
                            }
                            else {
                                v4 = -v4;
                            }

                            v13[v15] = v4;
                            v15 = v7;
                        }

                        ++v14_1;
                    }

                    v0_1 = StateSet.trimStateSet(v13, v15);
                    v5 = GrowingArrayUtils.append(v5, v8, ColorStateListInflaterCompat.modulateColorAlpha(v10, v12_1, v11));
                    v6_1 = GrowingArrayUtils.append(v6_1, v8, v0_1);
                    ++v8;
                }

                v4 = 1;
                v0 = arg17;
                continue;
            }

            break;
        }

        v0_1 = new int[v8];
        int[][] v1_1 = new int[v8][];
        System.arraycopy(v5, 0, v0_1, 0, v8);
        System.arraycopy(v6_1, 0, v1_1, 0, v8);
        return new ColorStateList(v1_1, v0_1);
    }

    public static ColorStateList inflate(Resources arg0, int arg1, Resources$Theme arg2) {
        try {
            return ColorStateListInflaterCompat.createFromXml(arg0, arg0.getXml(arg1), arg2);
        }
        catch(Exception v0) {
            Log.e("CSLCompat", "Failed to inflate ColorStateList.", ((Throwable)v0));
            return null;
        }
    }

    private static boolean isColorInt(Resources arg2, int arg3) {
        TypedValue v0 = ColorStateListInflaterCompat.getTypedValue();
        arg2.getValue(arg3, v0, true);
        if(v0.type >= 28 && v0.type <= 0x1F) {
            return 1;
        }

        return 0;
    }

    private static int modulateColorAlpha(int arg3, float arg4, float arg5) {
        int v0 = Float.compare(arg5, 0f) < 0 || arg5 > 100f ? 0 : 1;
        if(arg4 == 1f && v0 == 0) {
            return arg3;
        }

        int v4 = MathUtils.clamp(((int)((((float)Color.alpha(arg3))) * arg4 + 0.5f)), 0, 0xFF);
        if(v0 != 0) {
            CamColor v3 = CamColor.fromColor(arg3);
            arg3 = CamColor.toColor(v3.getHue(), v3.getChroma(), arg5);
        }

        return arg3 & 0xFFFFFF | v4 << 24;
    }

    private static TypedArray obtainAttributes(Resources arg0, Resources$Theme arg1, AttributeSet arg2, int[] arg3) {
        if(arg1 == null) {
            return arg0.obtainAttributes(arg2, arg3);
        }

        return arg1.obtainStyledAttributes(arg2, arg3, 0, 0);
    }
}

