package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Path;
import kotlin.Metadata;

@DrawScopeMarker @Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J(\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000E\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\fH&JA\u0010\u0010\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\f2\b\b\u0002\u0010\u000E\u001A\u00020\f2\b\b\u0002\u0010\u000F\u001A\u00020\f2\b\b\u0002\u0010\u0011\u001A\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0015\u001A\u00020\n2\u0006\u0010\u0016\u001A\u00020\u00172\b\b\u0002\u0010\u0011\u001A\u00020\u0012H&¢\u0006\u0004\b\u0018\u0010\u0019J\u001C\u0010\u001A\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\fH&J!\u0010\u001B\u001A\u00020\n2\u0006\u0010\u001C\u001A\u00020\f2\b\b\u0002\u0010\u001D\u001A\u00020\u0007H&¢\u0006\u0004\b\u001E\u0010\u001FJ)\u0010 \u001A\u00020\n2\u0006\u0010!\u001A\u00020\f2\u0006\u0010\"\u001A\u00020\f2\b\b\u0002\u0010\u001D\u001A\u00020\u0007H&¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001A\u00020\n2\u0006\u0010&\u001A\u00020\'H&¢\u0006\u0004\b(\u0010)R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001A\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006*À\u0006\u0003"}, d2={"Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "()J", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter-F1C5BW0", "inset", "", "left", "", "top", "right", "bottom", "clipRect", "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "clipRect-N_I0leg", "(FFFFI)V", "clipPath", "path", "Landroidx/compose/ui/graphics/Path;", "clipPath-mtrdD-E", "(Landroidx/compose/ui/graphics/Path;I)V", "translate", "rotate", "degrees", "pivot", "rotate-Uv8p0NA", "(FJ)V", "scale", "scaleX", "scaleY", "scale-0AR0LA0", "(FFJ)V", "transform", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transform-58bKbWc", "([F)V", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public interface DrawTransform {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        public static void clipPath-mtrdD-E$default(DrawTransform arg0, Path arg1, int arg2, int arg3, Object arg4) {
            DrawTransform.clipPath-mtrdD-E$default(arg0, arg1, arg2, arg3, arg4);
        }

        public static void clipRect-N_I0leg$default(DrawTransform arg0, float arg1, float arg2, float arg3, float arg4, int arg5, int arg6, Object arg7) {
            DrawTransform.clipRect-N_I0leg$default(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
        }

        @Deprecated public static long getCenter-F1C5BW0(DrawTransform arg2) {
            return arg2.getCenter-F1C5BW0();
        }

        public static void rotate-Uv8p0NA$default(DrawTransform arg0, float arg1, long arg2, int arg4, Object arg5) {
            DrawTransform.rotate-Uv8p0NA$default(arg0, arg1, arg2, arg4, arg5);
        }

        public static void scale-0AR0LA0$default(DrawTransform arg0, float arg1, float arg2, long arg3, int arg5, Object arg6) {
            DrawTransform.scale-0AR0LA0$default(arg0, arg1, arg2, arg3, arg5, arg6);
        }

        public static void translate$default(DrawTransform arg0, float arg1, float arg2, int arg3, Object arg4) {
            DrawTransform.translate$default(arg0, arg1, arg2, arg3, arg4);
        }
    }

    static long access$getCenter-F1C5BW0$jd(DrawTransform arg2) {
        return super.getCenter-F1C5BW0();
    }

    void clipPath-mtrdD-E(Path arg1, int arg2);

    static void clipPath-mtrdD-E$default(DrawTransform arg0, Path arg1, int arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            if((arg3 & 2) != 0) {
                arg2 = ClipOp.Companion.getIntersect-rtfAjoo();
            }

            arg0.clipPath-mtrdD-E(arg1, arg2);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipPath-mtrdD-E");
    }

    void clipRect-N_I0leg(float arg1, float arg2, float arg3, float arg4, int arg5);

    static void clipRect-N_I0leg$default(DrawTransform arg4, float arg5, float arg6, float arg7, float arg8, int arg9, int arg10, Object arg11) {
        if(arg11 == null) {
            if((arg10 & 4) != 0) {
                arg7 = Float.intBitsToFloat(((int)(arg4.getSize-NH-jbRc() >> 0x20)));
            }

            if((arg10 & 8) != 0) {
                arg8 = Float.intBitsToFloat(((int)(arg4.getSize-NH-jbRc() & 0xFFFFFFFFL)));
            }

            if((arg10 & 16) != 0) {
                arg9 = ClipOp.Companion.getIntersect-rtfAjoo();
            }

            arg4.clipRect-N_I0leg(0f, 0f, arg7, arg8, arg9);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipRect-N_I0leg");
    }

    default long getCenter-F1C5BW0() {
        return Offset.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(this.getSize-NH-jbRc() >> 0x20))) / 2f))) << 0x20 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(this.getSize-NH-jbRc() & 0xFFFFFFFFL))) / 2f))) & 0xFFFFFFFFL);
    }

    long getSize-NH-jbRc();

    void inset(float arg1, float arg2, float arg3, float arg4);

    void rotate-Uv8p0NA(float arg1, long arg2);

    static void rotate-Uv8p0NA$default(DrawTransform arg0, float arg1, long arg2, int arg4, Object arg5) {
        if(arg5 == null) {
            if((arg4 & 2) != 0) {
                arg2 = arg0.getCenter-F1C5BW0();
            }

            arg0.rotate-Uv8p0NA(arg1, arg2);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rotate-Uv8p0NA");
    }

    void scale-0AR0LA0(float arg1, float arg2, long arg3);

    static void scale-0AR0LA0$default(DrawTransform arg0, float arg1, float arg2, long arg3, int arg5, Object arg6) {
        if(arg6 == null) {
            if((arg5 & 4) != 0) {
                arg3 = arg0.getCenter-F1C5BW0();
            }

            arg0.scale-0AR0LA0(arg1, arg2, arg3);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scale-0AR0LA0");
    }

    void transform-58bKbWc(float[] arg1);

    void translate(float arg1, float arg2);

    static void translate$default(DrawTransform arg1, float arg2, float arg3, int arg4, Object arg5) {
        if(arg5 == null) {
            arg1.translate(0f, 0f);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: translate");
    }
}

