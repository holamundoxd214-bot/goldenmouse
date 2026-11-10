package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J-\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u0005H&¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000BÀ\u0006\u0003"}, d2={"Landroidx/compose/foundation/gestures/TransformScope;", "", "transformBy", "", "zoomChange", "", "panChange", "Landroidx/compose/ui/geometry/Offset;", "rotationChange", "transformBy-d-4ec7I", "(FJF)V", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface TransformScope {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        public static void transformBy-d-4ec7I$default(TransformScope arg0, float arg1, long arg2, float arg4, int arg5, Object arg6) {
            TransformScope.transformBy-d-4ec7I$default(arg0, arg1, arg2, arg4, arg5, arg6);
        }
    }

    void transformBy-d-4ec7I(float arg1, long arg2, float arg3);

    static void transformBy-d-4ec7I$default(TransformScope arg0, float arg1, long arg2, float arg4, int arg5, Object arg6) {
        if(arg6 == null) {
            if((arg5 & 1) != 0) {
                arg1 = 1f;
            }

            if((arg5 & 2) != 0) {
                arg2 = Offset.Companion.getZero-F1C5BW0();
            }

            arg0.transformBy-d-4ec7I(arg1, arg2, 0f);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: transformBy-d-4ec7I");
    }
}

