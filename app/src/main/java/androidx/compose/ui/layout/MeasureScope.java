package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.DpRect;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;

@MeasureScopeMarker @Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001JG\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\u0014\b\u0002\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\b2\u0017\u0010\n\u001A\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000B¢\u0006\u0002\b\u000EH\u0016Jd\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\u0014\b\u0002\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\b2\u001B\b\u0002\u0010\u000F\u001A\u0015\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r\u0018\u00010\u000B¢\u0006\u0002\b\u000E2\u0017\u0010\n\u001A\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000B¢\u0006\u0002\b\u000EH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0003"}, d2={"Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "layout", "Landroidx/compose/ui/layout/MeasureResult;", "width", "", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "placementBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "rulers", "Landroidx/compose/ui/layout/RulerScope;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface MeasureScope extends IntrinsicMeasureScope {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static boolean isLookingAhead(MeasureScope arg0) {
            return arg0.isLookingAhead();
        }

        @Deprecated public static MeasureResult layout(MeasureScope arg0, int arg1, int arg2, Map arg3, Function1 arg4) {
            return arg0.layout(arg1, arg2, arg3, arg4);
        }

        @Deprecated public static MeasureResult layout(MeasureScope arg0, int arg1, int arg2, Map arg3, Function1 arg4, Function1 arg5) {
            return arg0.layout(arg1, arg2, arg3, arg4, arg5);
        }

        public static MeasureResult layout$default(MeasureScope arg0, int arg1, int arg2, Map arg3, Function1 arg4, int arg5, Object arg6) {
            return MeasureScope.layout$default(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
        }

        public static MeasureResult layout$default(MeasureScope arg0, int arg1, int arg2, Map arg3, Function1 arg4, Function1 arg5, int arg6, Object arg7) {
            return MeasureScope.layout$default(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
        }

        @Deprecated public static int roundToPx--R2X_6o(MeasureScope arg0, long arg1) {
            return arg0.roundToPx--R2X_6o(arg1);
        }

        @Deprecated public static int roundToPx-0680j_4(MeasureScope arg0, float arg1) {
            return arg0.roundToPx-0680j_4(arg1);
        }

        @Deprecated public static float toDp-GaN1DYA(MeasureScope arg0, long arg1) {
            return arg0.toDp-GaN1DYA(arg1);
        }

        @Deprecated public static float toDp-u2uoSUM(MeasureScope arg0, float arg1) {
            return arg0.toDp-u2uoSUM(arg1);
        }

        @Deprecated public static float toDp-u2uoSUM(MeasureScope arg0, int arg1) {
            return arg0.toDp-u2uoSUM(arg1);
        }

        @Deprecated public static long toDpSize-k-rfVVM(MeasureScope arg0, long arg1) {
            return arg0.toDpSize-k-rfVVM(arg1);
        }

        @Deprecated public static float toPx--R2X_6o(MeasureScope arg0, long arg1) {
            return arg0.toPx--R2X_6o(arg1);
        }

        @Deprecated public static float toPx-0680j_4(MeasureScope arg0, float arg1) {
            return arg0.toPx-0680j_4(arg1);
        }

        @Deprecated public static Rect toRect(MeasureScope arg0, DpRect arg1) {
            return arg0.toRect(arg1);
        }

        @Deprecated public static long toSize-XkaWNTQ(MeasureScope arg0, long arg1) {
            return arg0.toSize-XkaWNTQ(arg1);
        }

        @Deprecated public static long toSp-0xMU5do(MeasureScope arg0, float arg1) {
            return arg0.toSp-0xMU5do(arg1);
        }

        @Deprecated public static long toSp-kPz2Gy4(MeasureScope arg0, float arg1) {
            return arg0.toSp-kPz2Gy4(arg1);
        }

        @Deprecated public static long toSp-kPz2Gy4(MeasureScope arg0, int arg1) {
            return arg0.toSp-kPz2Gy4(arg1);
        }
    }

    static boolean access$isLookingAhead$jd(MeasureScope arg0) {
        return super.isLookingAhead();
    }

    static MeasureResult access$layout$jd(MeasureScope arg0, int arg1, int arg2, Map arg3, Function1 arg4) {
        return super.layout(arg1, arg2, arg3, arg4);
    }

    static MeasureResult access$layout$jd(MeasureScope arg0, int arg1, int arg2, Map arg3, Function1 arg4, Function1 arg5) {
        return super.layout(arg1, arg2, arg3, arg4, arg5);
    }

    static int access$roundToPx--R2X_6o$jd(MeasureScope arg0, long arg1) {
        return super.roundToPx--R2X_6o(arg1);
    }

    static int access$roundToPx-0680j_4$jd(MeasureScope arg0, float arg1) {
        return super.roundToPx-0680j_4(arg1);
    }

    static float access$toDp-GaN1DYA$jd(MeasureScope arg0, long arg1) {
        return super.toDp-GaN1DYA(arg1);
    }

    static float access$toDp-u2uoSUM$jd(MeasureScope arg0, float arg1) {
        return super.toDp-u2uoSUM(arg1);
    }

    static float access$toDp-u2uoSUM$jd(MeasureScope arg0, int arg1) {
        return super.toDp-u2uoSUM(arg1);
    }

    static long access$toDpSize-k-rfVVM$jd(MeasureScope arg0, long arg1) {
        return super.toDpSize-k-rfVVM(arg1);
    }

    static float access$toPx--R2X_6o$jd(MeasureScope arg0, long arg1) {
        return super.toPx--R2X_6o(arg1);
    }

    static float access$toPx-0680j_4$jd(MeasureScope arg0, float arg1) {
        return super.toPx-0680j_4(arg1);
    }

    static Rect access$toRect$jd(MeasureScope arg0, DpRect arg1) {
        return super.toRect(arg1);
    }

    static long access$toSize-XkaWNTQ$jd(MeasureScope arg0, long arg1) {
        return super.toSize-XkaWNTQ(arg1);
    }

    static long access$toSp-0xMU5do$jd(MeasureScope arg0, float arg1) {
        return super.toSp-0xMU5do(arg1);
    }

    static long access$toSp-kPz2Gy4$jd(MeasureScope arg0, float arg1) {
        return super.toSp-kPz2Gy4(arg1);
    }

    static long access$toSp-kPz2Gy4$jd(MeasureScope arg0, int arg1) {
        return super.toSp-kPz2Gy4(arg1);
    }

    default MeasureResult layout(int arg7, int arg8, Map arg9, Function1 arg10) {
        return this.layout(arg7, arg8, arg9, null, arg10);
    }

    default MeasureResult layout(int arg9, int arg10, Map arg11, Function1 arg12, Function1 arg13) {
        int v0 = 0xFF000000;
        v0 = (arg9 & v0) != 0 || (v0 & arg10) != 0 ? 0 : 1;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalStateException("Size(" + arg9 + " x " + arg10 + ") is out of range. Each dimension must be between 0 and 16777215.");
        }

        return new MeasureScope$layout$1(arg9, arg10, arg11, arg12, this, arg13);
    }

    static MeasureResult layout$default(MeasureScope arg0, int arg1, int arg2, Map arg3, Function1 arg4, int arg5, Object arg6) {
        if(arg6 == null) {
            if((arg5 & 4) != 0) {
                arg3 = MapsKt.emptyMap();
            }

            return arg0.layout(arg1, arg2, arg3, arg4);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: layout");
    }

    static MeasureResult layout$default(MeasureScope arg6, int arg7, int arg8, Map arg9, Function1 arg10, Function1 arg11, int arg12, Object arg13) {
        if(arg13 == null) {
            if((arg12 & 4) != 0) {
                arg9 = MapsKt.emptyMap();
            }

            Map v3 = arg9;
            if((arg12 & 8) != 0) {
                arg10 = null;
            }

            return arg6.layout(arg7, arg8, v3, arg10, arg11);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: layout");
    }
}

