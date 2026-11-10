package androidx.compose.ui.graphics.vector.compat;

import android.content.res.ColorStateList;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector$Builder;
import androidx.compose.ui.graphics.vector.PathParser;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.TypedArrayUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@Metadata(d1={"\u0000`\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A!\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u00012\b\b\u0002\u0010\u000F\u001A\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001A!\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u000E\u001A\u00020\u00012\b\b\u0002\u0010\u000F\u001A\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0011\u001A\f\u0010\u0015\u001A\u00020\u0016*\u00020\u0017H\u0000\u001A<\u0010\u0018\u001A\u00020\u0001*\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001D2\u000E\b\u0002\u0010\u001E\u001A\b\u0018\u00010\u001FR\u00020\u001B2\u0006\u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020\u0001H\u0000\u001A\f\u0010#\u001A\u00020\u0017*\u00020\u0017H\u0000\u001A*\u0010$\u001A\u00020!*\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u001B2\f\u0010\u001E\u001A\b\u0018\u00010\u001FR\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001DH\u0000\u001A2\u0010%\u001A\u00020&*\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u001B2\f\u0010\u001E\u001A\b\u0018\u00010\u001FR\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001D2\u0006\u0010 \u001A\u00020!H\u0000\u001A\u0012\u0010\'\u001A\u0004\u0018\u00010(2\u0006\u0010)\u001A\u00020*H\u0002\u001A2\u0010+\u001A\u00020&*\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u001B2\f\u0010\u001E\u001A\b\u0018\u00010\u001FR\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001D2\u0006\u0010 \u001A\u00020!H\u0000\u001A2\u0010,\u001A\u00020&*\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u001B2\f\u0010\u001E\u001A\b\u0018\u00010\u001FR\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001D2\u0006\u0010 \u001A\u00020!H\u0000\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0003\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0004\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0005\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0006\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0007\u001A\u00020\u0001X\u0082D¢\u0006\u0002\n\u0000\"\u000E\u0010\b\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\n\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u000B\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006-"}, d2={"LINECAP_BUTT", "", "LINECAP_ROUND", "LINECAP_SQUARE", "LINEJOIN_MITER", "LINEJOIN_ROUND", "LINEJOIN_BEVEL", "FILL_TYPE_WINDING", "SHAPE_CLIP_PATH", "", "SHAPE_GROUP", "SHAPE_PATH", "getStrokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "id", "defValue", "getStrokeLineCap-CSYIeUk", "(II)I", "getStrokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "getStrokeLineJoin-kLtJ_vA", "isAtEnd", "", "Lorg/xmlpull/v1/XmlPullParser;", "parseCurrentVectorNode", "Landroidx/compose/ui/graphics/vector/compat/AndroidVectorParser;", "res", "Landroid/content/res/Resources;", "attrs", "Landroid/util/AttributeSet;", "theme", "Landroid/content/res/Resources$Theme;", "builder", "Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "nestedGroups", "seekToStartTag", "createVectorImageBuilder", "parsePath", "", "obtainBrushFromComplexColor", "Landroidx/compose/ui/graphics/Brush;", "complexColor", "Landroidx/core/content/res/ComplexColorCompat;", "parseClipPath", "parseGroup", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class XmlVectorParser_androidKt {
    private static final int FILL_TYPE_WINDING = 0;
    private static final int LINECAP_BUTT = 0;
    private static final int LINECAP_ROUND = 1;
    private static final int LINECAP_SQUARE = 2;
    private static final int LINEJOIN_BEVEL = 2;
    private static final int LINEJOIN_MITER = 0;
    private static final int LINEJOIN_ROUND = 1;
    private static final String SHAPE_CLIP_PATH = "clip-path";
    private static final String SHAPE_GROUP = "group";
    private static final String SHAPE_PATH = "path";

    static {
    }

    public static final Builder createVectorImageBuilder(AndroidVectorParser arg19, Resources arg20, Resources$Theme arg21, AttributeSet arg22) {
        long v6_1;
        AndroidVectorParser v0 = arg19;
        Resources$Theme v1 = arg21;
        Resources v3 = arg20;
        TypedArray v2 = v0.obtainAttributes(v3, v1, arg22, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_TYPE_ARRAY());
        boolean v16 = v0.getNamedBoolean(v2, "autoMirrored", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_AUTO_MIRRORED(), false);
        float v11 = v0.getNamedFloat(v2, "viewportWidth", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_VIEWPORT_WIDTH(), 0f);
        float v12 = v0.getNamedFloat(v2, "viewportHeight", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_VIEWPORT_HEIGHT(), 0f);
        if(v11 > 0f) {
            if(v12 > 0f) {
                float v4 = v0.getDimension(v2, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_WIDTH(), 0f);
                float v5 = v0.getDimension(v2, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_HEIGHT(), 0f);
                if(v2.hasValue(AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_TINT())) {
                    TypedValue v6 = new TypedValue();
                    v2.getValue(AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_TINT(), v6);
                    if(v6.type == 2) {
                        v6_1 = Color.Companion.getUnspecified-0d7_KjU();
                    }
                    else {
                        ColorStateList v1_1 = v0.getNamedColorStateList(v2, v1, "tint", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_TINT());
                        v6_1 = v1_1 != null ? ColorKt.Color(v1_1.getDefaultColor()) : Color.Companion.getUnspecified-0d7_KjU();
                    }
                }
                else {
                    v6_1 = Color.Companion.getUnspecified-0d7_KjU();
                }

                long v13 = v6_1;
                int v0_1 = v0.getInt(v2, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_TINT_MODE(), -1);
                if(v0_1 == -1) {
                    v0_1 = BlendMode.Companion.getSrcIn-0nO6VwU();
                }
                else if(v0_1 == 3) {
                    v0_1 = BlendMode.Companion.getSrcOver-0nO6VwU();
                }
                else if(v0_1 == 5) {
                    v0_1 = BlendMode.Companion.getSrcIn-0nO6VwU();
                }
                else if(v0_1 != 9) {
                    switch(v0_1) {
                        case 14: {
                            goto label_79;
                        }
                        case 15: {
                            goto label_76;
                        }
                        case 16: {
                            goto label_73;
                        }
                    }

                    v0_1 = BlendMode.Companion.getSrcIn-0nO6VwU();
                    goto label_93;
                label_73:
                    v0_1 = BlendMode.Companion.getPlus-0nO6VwU();
                    goto label_93;
                label_76:
                    v0_1 = BlendMode.Companion.getScreen-0nO6VwU();
                    goto label_93;
                label_79:
                    v0_1 = BlendMode.Companion.getModulate-0nO6VwU();
                }
                else {
                    v0_1 = BlendMode.Companion.getSrcAtop-0nO6VwU();
                }

            label_93:
                float v9 = Dp.constructor-impl(v4 / v3.getDisplayMetrics().density);
                float v10 = Dp.constructor-impl(v5 / v3.getDisplayMetrics().density);
                v2.recycle();
                return new Builder(null, v9, v10, v11, v12, v13, v0_1, v16, 1, null);
            }

            throw new XmlPullParserException(v2.getPositionDescription() + "<VectorGraphic> tag requires viewportHeight > 0");
        }

        throw new XmlPullParserException(v2.getPositionDescription() + "<VectorGraphic> tag requires viewportWidth > 0");
    }

    private static final int getStrokeLineCap-CSYIeUk(int arg1, int arg2) {
        if(arg1 != 0) {
            if(arg1 != 1) {
                if(arg1 != 2) {
                    return arg2;
                }

                return StrokeCap.Companion.getSquare-KaPHkGw();
            }

            return StrokeCap.Companion.getRound-KaPHkGw();
        }

        return StrokeCap.Companion.getButt-KaPHkGw();
    }

    static int getStrokeLineCap-CSYIeUk$default(int arg0, int arg1, int arg2, Object arg3) {
        if((arg2 & 2) != 0) {
            arg1 = StrokeCap.Companion.getButt-KaPHkGw();
        }

        return XmlVectorParser_androidKt.getStrokeLineCap-CSYIeUk(arg0, arg1);
    }

    private static final int getStrokeLineJoin-kLtJ_vA(int arg1, int arg2) {
        if(arg1 != 0) {
            if(arg1 != 1) {
                if(arg1 != 2) {
                    return arg2;
                }

                return StrokeJoin.Companion.getBevel-LxFBmk8();
            }

            return StrokeJoin.Companion.getRound-LxFBmk8();
        }

        return StrokeJoin.Companion.getMiter-LxFBmk8();
    }

    static int getStrokeLineJoin-kLtJ_vA$default(int arg0, int arg1, int arg2, Object arg3) {
        if((arg2 & 2) != 0) {
            arg1 = StrokeJoin.Companion.getMiter-LxFBmk8();
        }

        return XmlVectorParser_androidKt.getStrokeLineJoin-kLtJ_vA(arg0, arg1);
    }

    public static final boolean isAtEnd(XmlPullParser arg2) {
        if(arg2.getEventType() != 1 && (arg2.getDepth() >= 1 || arg2.getEventType() != 3)) {
            return 0;
        }

        return 1;
    }

    private static final Brush obtainBrushFromComplexColor(ComplexColorCompat arg4) {
        DefaultConstructorMarker v1 = null;
        if(arg4.willDraw()) {
            Shader v0 = arg4.getShader();
            if(v0 != null) {
                return BrushKt.ShaderBrush(v0);
            }

            return new SolidColor(ColorKt.Color(arg4.getColor()), v1);
        }

        return ((Brush)v1);
    }

    public static final void parseClipPath(AndroidVectorParser arg14, Resources arg15, Resources$Theme arg16, AttributeSet arg17, Builder arg18) {
        List v14;
        TypedArray v0 = arg14.obtainAttributes(arg15, arg16, arg17, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_CLIP_PATH());
        String v1 = arg14.getString(v0, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_CLIP_PATH_NAME());
        if(v1 == null) {
            v1 = "";
        }

        String v3 = v1;
        v1 = arg14.getString(v0, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_CLIP_PATH_PATH_DATA());
        if(v1 == null) {
            v14 = VectorKt.getEmptyPath();
        }
        else {
            ArrayList v14_1 = PathParser.pathStringToNodes$default(arg14.pathParser, v1, null, 2, null);
        }

        v0.recycle();
        Builder.addGroup$default(arg18, v3, 0f, 0f, 0f, 0f, 0f, 0f, 0f, v14, 0xFE, null);
    }

    public static final int parseCurrentVectorNode(AndroidVectorParser arg4, Resources arg5, AttributeSet arg6, Resources$Theme arg7, Builder arg8, int arg9) {
        int v0 = arg4.getXmlParser().getEventType();
        String v2 = "group";
        if(v0 == 2) {
            String v0_1 = arg4.getXmlParser().getName();
            if(v0_1 != null) {
                int v1 = v0_1.hashCode();
                if(v1 != 0x9DB17482) {
                    if(v1 != 3433509) {
                        if(v1 != 0x5E0F67F) {
                        }
                        else if(!v0_1.equals(v2)) {
                        }
                        else {
                            XmlVectorParser_androidKt.parseGroup(arg4, arg5, arg7, arg6, arg8);
                            return arg9;
                        }
                    }
                    else if(!v0_1.equals("path")) {
                    }
                    else {
                        XmlVectorParser_androidKt.parsePath(arg4, arg5, arg7, arg6, arg8);
                        return arg9;
                    }
                }
                else if(!v0_1.equals("clip-path")) {
                }
                else {
                    XmlVectorParser_androidKt.parseClipPath(arg4, arg5, arg7, arg6, arg8);
                    ++arg9;
                }
            }
        }
        else if(v0 != 3) {
        }
        else if(Intrinsics.areEqual(v2, arg4.getXmlParser().getName())) {
            ++arg9;
            int v5;
            for(v5 = 0; v5 < arg9; ++v5) {
                arg8.clearGroup();
            }

            return 0;
        }

        return arg9;
    }

    public static int parseCurrentVectorNode$default(AndroidVectorParser arg6, Resources arg7, AttributeSet arg8, Resources$Theme arg9, Builder arg10, int arg11, int arg12, Object arg13) {
        if((arg12 & 4) != 0) {
            arg9 = null;
        }

        return XmlVectorParser_androidKt.parseCurrentVectorNode(arg6, arg7, arg8, arg9, arg10, arg11);
    }

    public static final void parseGroup(AndroidVectorParser arg11, Resources arg12, Resources$Theme arg13, AttributeSet arg14, Builder arg15) {
        TypedArray v12 = arg11.obtainAttributes(arg12, arg13, arg14, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_GROUP());
        float v3 = arg11.getNamedFloat(v12, "rotation", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_ROTATION(), 0f);
        float v4 = arg11.getFloat(v12, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_PIVOT_X(), 0f);
        float v5 = arg11.getFloat(v12, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_PIVOT_Y(), 0f);
        float v6 = arg11.getNamedFloat(v12, "scaleX", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_SCALE_X(), 1f);
        float v7 = arg11.getNamedFloat(v12, "scaleY", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_SCALE_Y(), 1f);
        float v8 = arg11.getNamedFloat(v12, "translateX", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_TRANSLATE_X(), 0f);
        float v9 = arg11.getNamedFloat(v12, "translateY", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_TRANSLATE_Y(), 0f);
        String v11 = arg11.getString(v12, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_NAME());
        if(v11 == null) {
            v11 = "";
        }

        v12.recycle();
        arg15.addGroup(v11, v3, v4, v5, v6, v7, v8, v9, VectorKt.getEmptyPath());
    }

    public static final void parsePath(AndroidVectorParser arg18, Resources arg19, Resources$Theme arg20, AttributeSet arg21, Builder arg22) throws IllegalArgumentException {
        ArrayList v2_2;
        AndroidVectorParser v0 = arg18;
        TypedArray v1 = v0.obtainAttributes(arg19, arg20, arg21, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH());
        if(TypedArrayUtils.hasAttribute(v0.getXmlParser(), "pathData")) {
            String v2 = v0.getString(v1, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_NAME());
            if(v2 == null) {
                v2 = "";
            }

            String v6 = v2;
            v2 = v0.getString(v1, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_PATH_DATA());
            if(v2 == null) {
                List v2_1 = VectorKt.getEmptyPath();
            }
            else {
                v2_2 = PathParser.pathStringToNodes$default(v0.pathParser, v2, null, 2, null);
            }

            List v7 = ((List)v2_2);
            ComplexColorCompat v8 = v0.getNamedComplexColor(v1, arg20, "fillColor", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_FILL_COLOR(), 0);
            float v10 = v0.getNamedFloat(v1, "fillAlpha", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_FILL_ALPHA(), 1f);
            int v12 = XmlVectorParser_androidKt.getStrokeLineCap-CSYIeUk(v0.getNamedInt(v1, "strokeLineCap", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_LINE_CAP(), -1), StrokeCap.Companion.getButt-KaPHkGw());
            int v13 = XmlVectorParser_androidKt.getStrokeLineJoin-kLtJ_vA(v0.getNamedInt(v1, "strokeLineJoin", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_LINE_JOIN(), -1), StrokeJoin.Companion.getMiter-LxFBmk8());
            float v14 = v0.getNamedFloat(v1, "strokeMiterLimit", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_MITER_LIMIT(), 4f);
            ComplexColorCompat v2_3 = v0.getNamedComplexColor(v1, arg20, "strokeColor", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_COLOR(), 0);
            float v3 = v0.getNamedFloat(v1, "strokeAlpha", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_ALPHA(), 1f);
            float v11 = v0.getNamedFloat(v1, "strokeWidth", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_WIDTH(), 1f);
            float v16 = v0.getNamedFloat(v1, "trimPathEnd", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_TRIM_PATH_END(), 1f);
            float v17 = v0.getNamedFloat(v1, "trimPathOffset", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_TRIM_PATH_OFFSET(), 0f);
            float v15 = v0.getNamedFloat(v1, "trimPathStart", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_TRIM_PATH_START(), 0f);
            int v0_1 = v0.getNamedInt(v1, "fillType", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_TRIM_PATH_FILLTYPE(), XmlVectorParser_androidKt.FILL_TYPE_WINDING);
            v1.recycle();
            Brush v1_1 = XmlVectorParser_androidKt.obtainBrushFromComplexColor(v8);
            Brush v9 = XmlVectorParser_androidKt.obtainBrushFromComplexColor(v2_3);
            v0_1 = v0_1 == 0 ? PathFillType.Companion.getNonZero-Rg-k1Os() : PathFillType.Companion.getEvenOdd-Rg-k1Os();
            arg22.addPath-oIyEayM(v7, v0_1, v6, v1_1, v10, v9, v3, v11, v12, v13, v14, v15, v16, v17);
            return;
        }

        throw new IllegalArgumentException("No path data available");
    }

    public static final XmlPullParser seekToStartTag(XmlPullParser arg3) throws XmlPullParserException {
        int v0 = arg3.next();
        while(true) {
            int v1 = 2;
            if(v0 != v1 && v0 != 1) {
                v0 = arg3.next();
                continue;
            }

            break;
        }

        if(v0 == v1) {
            return arg3;
        }

        throw new XmlPullParserException("No start tag found");
    }
}

