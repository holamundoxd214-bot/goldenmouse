package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u0018H\u0016¢\u0006\u0004\b\u001A\u0010\u001BJ\u0017\u0010\u001C\u001A\u00020\u00182\u0006\u0010\u001D\u001A\u00020\u0018H\u0016¢\u0006\u0004\b\u001E\u0010\u001BJ\u0017\u0010\u001F\u001A\u00020\u00182\u0006\u0010 \u001A\u00020\u0018H&¢\u0006\u0004\b!\u0010\u001BJ\u0017\u0010\"\u001A\u00020\u00182\u0006\u0010\u001D\u001A\u00020\u0018H&¢\u0006\u0004\b#\u0010\u001BJ\u0017\u0010$\u001A\u00020\u00182\u0006\u0010\u001D\u001A\u00020\u0018H&¢\u0006\u0004\b%\u0010\u001BJ\u001F\u0010&\u001A\u00020\u00182\u0006\u0010\'\u001A\u00020\u00002\u0006\u0010(\u001A\u00020\u0018H&¢\u0006\u0004\b)\u0010*J+\u0010&\u001A\u00020\u00182\u0006\u0010\'\u001A\u00020\u00002\b\b\u0002\u0010(\u001A\u00020\u00182\b\b\u0002\u0010+\u001A\u00020\u0011H\u0016¢\u0006\u0004\b,\u0010-J\u001A\u0010.\u001A\u00020/2\u0006\u0010\'\u001A\u00020\u00002\b\b\u0002\u00100\u001A\u00020\u0011H&J\u001F\u00101\u001A\u0002022\u0006\u0010\'\u001A\u00020\u00002\u0006\u00103\u001A\u000204H\u0016¢\u0006\u0004\b5\u00106J\u0017\u00107\u001A\u0002022\u0006\u00103\u001A\u000204H\u0016¢\u0006\u0004\b8\u00109J\u0011\u0010:\u001A\u00020;2\u0006\u0010<\u001A\u00020\bH¦\u0002R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\nR\u0014\u0010\u000B\u001A\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u0014\u0010\u000E\u001A\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\rR\u0012\u0010\u0010\u001A\u00020\u0011X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0012R\u001A\u0010\u0013\u001A\u00020\u00118VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0016\u0010\u0012ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006=À\u0006\u0003"}, d2={"Landroidx/compose/ui/layout/LayoutCoordinates;", "", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "providedAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getProvidedAlignmentLines", "()Ljava/util/Set;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "parentCoordinates", "getParentCoordinates", "isAttached", "", "()Z", "introducesMotionFrameOfReference", "getIntroducesMotionFrameOfReference$annotations", "()V", "getIntroducesMotionFrameOfReference", "screenToLocal", "Landroidx/compose/ui/geometry/Offset;", "relativeToScreen", "screenToLocal-MK-Hz9U", "(J)J", "localToScreen", "relativeToLocal", "localToScreen-MK-Hz9U", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "localToWindow", "localToWindow-MK-Hz9U", "localToRoot", "localToRoot-MK-Hz9U", "localPositionOf", "sourceCoordinates", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "includeMotionFrameOfReference", "localPositionOf-S_NoaFU", "(Landroidx/compose/ui/layout/LayoutCoordinates;JZ)J", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "clipBounds", "transformFrom", "", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "transformToScreen", "transformToScreen-58bKbWc", "([F)V", "get", "", "alignmentLine", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface LayoutCoordinates {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static boolean getIntroducesMotionFrameOfReference(LayoutCoordinates arg0) {
            return arg0.getIntroducesMotionFrameOfReference();
        }

        public static void getIntroducesMotionFrameOfReference$annotations() {
        }

        public static Rect localBoundingBoxOf$default(LayoutCoordinates arg0, LayoutCoordinates arg1, boolean arg2, int arg3, Object arg4) {
            return LayoutCoordinates.localBoundingBoxOf$default(arg0, arg1, arg2, arg3, arg4);
        }

        @Deprecated public static long localPositionOf-S_NoaFU(LayoutCoordinates arg0, LayoutCoordinates arg1, long arg2, boolean arg4) {
            return arg0.localPositionOf-S_NoaFU(arg1, arg2, arg4);
        }

        public static long localPositionOf-S_NoaFU$default(LayoutCoordinates arg0, LayoutCoordinates arg1, long arg2, boolean arg4, int arg5, Object arg6) {
            return LayoutCoordinates.localPositionOf-S_NoaFU$default(arg0, arg1, arg2, arg4, arg5, arg6);
        }

        @Deprecated public static long localToScreen-MK-Hz9U(LayoutCoordinates arg0, long arg1) {
            return arg0.localToScreen-MK-Hz9U(arg1);
        }

        @Deprecated public static long screenToLocal-MK-Hz9U(LayoutCoordinates arg0, long arg1) {
            return arg0.screenToLocal-MK-Hz9U(arg1);
        }

        @Deprecated public static void transformFrom-EL8BTi8(LayoutCoordinates arg0, LayoutCoordinates arg1, float[] arg2) {
            arg0.transformFrom-EL8BTi8(arg1, arg2);
        }

        @Deprecated public static void transformToScreen-58bKbWc(LayoutCoordinates arg0, float[] arg1) {
            arg0.transformToScreen-58bKbWc(arg1);
        }
    }

    static boolean access$getIntroducesMotionFrameOfReference$jd(LayoutCoordinates arg0) {
        return super.getIntroducesMotionFrameOfReference();
    }

    static long access$localPositionOf-S_NoaFU$jd(LayoutCoordinates arg0, LayoutCoordinates arg1, long arg2, boolean arg4) {
        return super.localPositionOf-S_NoaFU(arg1, arg2, arg4);
    }

    static long access$localToScreen-MK-Hz9U$jd(LayoutCoordinates arg0, long arg1) {
        return super.localToScreen-MK-Hz9U(arg1);
    }

    static long access$screenToLocal-MK-Hz9U$jd(LayoutCoordinates arg0, long arg1) {
        return super.screenToLocal-MK-Hz9U(arg1);
    }

    static void access$transformFrom-EL8BTi8$jd(LayoutCoordinates arg0, LayoutCoordinates arg1, float[] arg2) {
        super.transformFrom-EL8BTi8(arg1, arg2);
    }

    static void access$transformToScreen-58bKbWc$jd(LayoutCoordinates arg0, float[] arg1) {
        super.transformToScreen-58bKbWc(arg1);
    }

    int get(AlignmentLine arg1);

    default boolean getIntroducesMotionFrameOfReference() {
        return 0;
    }

    LayoutCoordinates getParentCoordinates();

    LayoutCoordinates getParentLayoutCoordinates();

    Set getProvidedAlignmentLines();

    long getSize-YbymL2g();

    boolean isAttached();

    Rect localBoundingBoxOf(LayoutCoordinates arg1, boolean arg2);

    static Rect localBoundingBoxOf$default(LayoutCoordinates arg0, LayoutCoordinates arg1, boolean arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            return arg0.localBoundingBoxOf(arg1, true);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: localBoundingBoxOf");
    }

    long localPositionOf-R5De75A(LayoutCoordinates arg1, long arg2);

    default long localPositionOf-S_NoaFU(LayoutCoordinates arg1, long arg2, boolean arg4) {
        throw new UnsupportedOperationException("localPositionOf is not implemented on this LayoutCoordinates");
    }

    static long localPositionOf-S_NoaFU$default(LayoutCoordinates arg0, LayoutCoordinates arg1, long arg2, boolean arg4, int arg5, Object arg6) {
        if(arg6 == null) {
            if((arg5 & 2) != 0) {
                arg2 = Offset.Companion.getZero-F1C5BW0();
            }

            return arg0.localPositionOf-S_NoaFU(arg1, arg2, true);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: localPositionOf-S_NoaFU");
    }

    long localToRoot-MK-Hz9U(long arg1);

    default long localToScreen-MK-Hz9U(long arg1) {
        return Offset.Companion.getUnspecified-F1C5BW0();
    }

    long localToWindow-MK-Hz9U(long arg1);

    default long screenToLocal-MK-Hz9U(long arg1) {
        return Offset.Companion.getUnspecified-F1C5BW0();
    }

    default void transformFrom-EL8BTi8(LayoutCoordinates arg1, float[] arg2) {
        InlineClassHelperKt.throwUnsupportedOperationException("transformFrom is not implemented on this LayoutCoordinates");
    }

    default void transformToScreen-58bKbWc(float[] arg1) {
        throw new UnsupportedOperationException("transformToScreen is not implemented on this LayoutCoordinates");
    }

    long windowToLocal-MK-Hz9U(long arg1);
}

