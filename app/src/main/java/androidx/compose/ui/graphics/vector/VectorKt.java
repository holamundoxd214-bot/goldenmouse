package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000f\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u001A(\u0010(\u001A\b\u0012\u0004\u0012\u00020\f0\u000B2\u0017\u0010)\u001A\u0013\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0*¢\u0006\u0002\b-H\u0086\b\u001A\u0016\u0010.\u001A\b\u0012\u0004\u0012\u00020\f0\u000B2\b\u0010/\u001A\u0004\u0018\u00010\u0001\u001A\u001B\u00100\u001A\u000201*\u00020!2\u0006\u00102\u001A\u00020!H\u0000¢\u0006\u0004\b3\u00104\u001A\u0013\u00105\u001A\u00020!*\u00020!H\u0000¢\u0006\u0004\b6\u00107\u001A\u000E\u00108\u001A\u000201*\u0004\u0018\u000109H\u0000\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0004\u001A\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0005\u001A\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0006\u001A\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0007\u001A\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000E\u0010\b\u001A\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000E\u0010\t\u001A\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u0017\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000B¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u000E\u0010\u000F\u001A\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0010\u001A\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0011\u001A\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0012\u001A\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0013\u001A\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0014\u001A\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0015\u001A\u00020\u0016¢\u0006\n\n\u0002\u0010\u0019\u001A\u0004\b\u0017\u0010\u0018\"\u0013\u0010\u001A\u001A\u00020\u001B¢\u0006\n\n\u0002\u0010\u0019\u001A\u0004\b\u001C\u0010\u0018\"\u0013\u0010\u001D\u001A\u00020\u001E¢\u0006\n\n\u0002\u0010\u0019\u001A\u0004\b\u001F\u0010\u0018\"\u0013\u0010 \u001A\u00020!¢\u0006\n\n\u0002\u0010$\u001A\u0004\b\"\u0010#\"\u0013\u0010%\u001A\u00020&¢\u0006\n\n\u0002\u0010\u0019\u001A\u0004\b\'\u0010\u0018¨\u0006:"}, d2={"DefaultGroupName", "", "DefaultRotation", "", "DefaultPivotX", "DefaultPivotY", "DefaultScaleX", "DefaultScaleY", "DefaultTranslationX", "DefaultTranslationY", "EmptyPath", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "getEmptyPath", "()Ljava/util/List;", "DefaultPathName", "DefaultStrokeLineWidth", "DefaultStrokeLineMiter", "DefaultTrimPathStart", "DefaultTrimPathEnd", "DefaultTrimPathOffset", "DefaultStrokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "getDefaultStrokeLineCap", "()I", "I", "DefaultStrokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "getDefaultStrokeLineJoin", "DefaultTintBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "getDefaultTintBlendMode", "DefaultTintColor", "Landroidx/compose/ui/graphics/Color;", "getDefaultTintColor", "()J", "J", "DefaultFillType", "Landroidx/compose/ui/graphics/PathFillType;", "getDefaultFillType", "PathData", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/vector/PathBuilder;", "", "Lkotlin/ExtensionFunctionType;", "addPathNodes", "pathStr", "rgbEqual", "", "other", "rgbEqual--OWjLjI", "(JJ)Z", "toOpaque", "toOpaque-8_81llA", "(J)J", "tintableWithAlphaMask", "Landroidx/compose/ui/graphics/ColorFilter;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class VectorKt {
    private static final int DefaultFillType = 0;
    public static final String DefaultGroupName = "";
    public static final String DefaultPathName = "";
    public static final float DefaultPivotX = 0f;
    public static final float DefaultPivotY = 0f;
    public static final float DefaultRotation = 0f;
    public static final float DefaultScaleX = 1f;
    public static final float DefaultScaleY = 1f;
    private static final int DefaultStrokeLineCap = 0;
    private static final int DefaultStrokeLineJoin = 0;
    public static final float DefaultStrokeLineMiter = 4f;
    public static final float DefaultStrokeLineWidth = 0f;
    private static final int DefaultTintBlendMode = 0;
    private static final long DefaultTintColor = 0;
    public static final float DefaultTranslationX = 0f;
    public static final float DefaultTranslationY = 0f;
    public static final float DefaultTrimPathEnd = 1f;
    public static final float DefaultTrimPathOffset;
    public static final float DefaultTrimPathStart;
    private static final List EmptyPath;

    static {
        VectorKt.EmptyPath = CollectionsKt.emptyList();
        VectorKt.DefaultStrokeLineCap = StrokeCap.Companion.getButt-KaPHkGw();
        VectorKt.DefaultStrokeLineJoin = StrokeJoin.Companion.getMiter-LxFBmk8();
        VectorKt.DefaultTintBlendMode = BlendMode.Companion.getSrcIn-0nO6VwU();
        VectorKt.DefaultTintColor = Color.Companion.getTransparent-0d7_KjU();
        VectorKt.DefaultFillType = PathFillType.Companion.getNonZero-Rg-k1Os();
    }

    public static final List PathData(Function1 arg1) {
        PathBuilder v0 = new PathBuilder();
        arg1.invoke(v0);
        return v0.getNodes();
    }

    public static final List addPathNodes(String arg1) {
        if(arg1 == null) {
            return VectorKt.EmptyPath;
        }

        return new PathParser().parsePathString(arg1).toNodes();
    }

    public static final int getDefaultFillType() {
        return VectorKt.DefaultFillType;
    }

    public static final int getDefaultStrokeLineCap() {
        return VectorKt.DefaultStrokeLineCap;
    }

    public static final int getDefaultStrokeLineJoin() {
        return VectorKt.DefaultStrokeLineJoin;
    }

    public static final int getDefaultTintBlendMode() {
        return VectorKt.DefaultTintBlendMode;
    }

    public static final long getDefaultTintColor() {
        return VectorKt.DefaultTintColor;
    }

    public static final List getEmptyPath() {
        return VectorKt.EmptyPath;
    }

    public static final boolean rgbEqual--OWjLjI(long arg2, long arg4) {
        if(Color.getRed-impl(arg2) == Color.getRed-impl(arg4) && Color.getGreen-impl(arg2) == Color.getGreen-impl(arg4) && Color.getBlue-impl(arg2) == Color.getBlue-impl(arg4)) {
            return 1;
        }

        return 0;
    }

    public static final boolean tintableWithAlphaMask(ColorFilter arg4) {
        if((arg4 instanceof BlendModeColorFilter)) {
            if(!BlendMode.equals-impl0(((BlendModeColorFilter)arg4).getBlendMode-0nO6VwU(), BlendMode.Companion.getSrcIn-0nO6VwU())) {
                if(BlendMode.equals-impl0(((BlendModeColorFilter)arg4).getBlendMode-0nO6VwU(), BlendMode.Companion.getSrcOver-0nO6VwU())) {
                }
                else {
                    return 0;
                }
            }

            return 1;
        }

        if(arg4 == null) {
            return 1;
        }

        return 0;
    }

    public static final long toOpaque-8_81llA(long arg9) {
        if(Color.getAlpha-impl(arg9) == 1f) {
            return arg9;
        }

        return Color.copy-wmQWz5c$default(arg9, 1f, 0f, 0f, 0f, 14, null);
    }
}

