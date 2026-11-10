package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bg\u0018\u0000 \u00102\u00020\u0001:\u0002\u000F\u0010J\u0017\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\b\u001A\u00020\u0003H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000B\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&¢\u0006\u0004\b\f\u0010\u0007J\u000F\u0010\r\u001A\u00020\u0003H&¢\u0006\u0004\b\u000E\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2={"Landroidx/compose/foundation/layout/PaddingValues;", "", "calculateLeftPadding", "Landroidx/compose/ui/unit/Dp;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "calculateLeftPadding-u2uoSUM", "(Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateTopPadding", "calculateTopPadding-D9Ej5fM", "()F", "calculateRightPadding", "calculateRightPadding-u2uoSUM", "calculateBottomPadding", "calculateBottomPadding-D9Ej5fM", "Absolute", "Companion", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public interface PaddingValues {
    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000F\u001A\u00020\u00032\u0006\u0010\u0010\u001A\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0014\u001A\u00020\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001A\u00020\u00032\u0006\u0010\u0010\u001A\u00020\u0011H\u0016¢\u0006\u0004\b\u0018\u0010\u0013J\u000F\u0010\u0019\u001A\u00020\u0003H\u0016¢\u0006\u0004\b\u001A\u0010\u0016J\u0013\u0010\u001B\u001A\u00020\u001C2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001EH\u0096\u0002J\b\u0010\u001F\u001A\u00020 H\u0016J\b\u0010!\u001A\u00020\"H\u0016R\u0018\u0010\u0002\u001A\u00020\u00038\u0002X\u0083\u0004¢\u0006\n\n\u0002\u0010\u000B\u0012\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001A\u00020\u00038\u0002X\u0083\u0004¢\u0006\n\n\u0002\u0010\u000B\u0012\u0004\b\f\u0010\nR\u0018\u0010\u0005\u001A\u00020\u00038\u0002X\u0083\u0004¢\u0006\n\n\u0002\u0010\u000B\u0012\u0004\b\r\u0010\nR\u0018\u0010\u0006\u001A\u00020\u00038\u0002X\u0083\u0004¢\u0006\n\n\u0002\u0010\u000B\u0012\u0004\b\u000E\u0010\n¨\u0006#"}, d2={"Landroidx/compose/foundation/layout/PaddingValues$Absolute;", "Landroidx/compose/foundation/layout/PaddingValues;", "left", "Landroidx/compose/ui/unit/Dp;", "top", "right", "bottom", "<init>", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLeft-D9Ej5fM$annotations", "()V", "F", "getTop-D9Ej5fM$annotations", "getRight-D9Ej5fM$annotations", "getBottom-D9Ej5fM$annotations", "calculateLeftPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "calculateLeftPadding-u2uoSUM", "(Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateTopPadding", "calculateTopPadding-D9Ej5fM", "()F", "calculateRightPadding", "calculateRightPadding-u2uoSUM", "calculateBottomPadding", "calculateBottomPadding-D9Ej5fM", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Absolute implements PaddingValues {
        public static final int $stable;
        private final float bottom;
        private final float left;
        private final float right;
        private final float top;

        static {
        }

        private Absolute(float arg3, float arg4, float arg5, float arg6) {
            super();
            this.left = arg3;
            this.top = arg4;
            this.right = arg5;
            this.bottom = arg6;
            int v0 = 1;
            int v3 = Float.compare(arg3, 0f) >= 0 ? 1 : 0;
            int v4 = arg4 >= 0f ? 1 : 0;
            v3 &= v4;
            v4 = arg5 >= 0f ? 1 : 0;
            v3 &= v4;
            if(arg6 >= 0f) {
            }
            else {
                v0 = 0;
            }

            if((v3 & v0) == 0) {
                InlineClassHelperKt.throwIllegalArgumentException("Padding must be non-negative");
            }
        }

        public Absolute(float arg8, float arg9, float arg10, float arg11, int arg12, DefaultConstructorMarker arg13) {
            if((arg12 & 1) != 0) {
                arg8 = Dp.constructor-impl(0f);
            }

            float v2 = arg8;
            if((arg12 & 2) != 0) {
                arg9 = Dp.constructor-impl(0f);
            }

            float v3 = arg9;
            if((arg12 & 4) != 0) {
                arg10 = Dp.constructor-impl(0f);
            }

            float v4 = arg10;
            if((arg12 & 8) != 0) {
                arg11 = Dp.constructor-impl(0f);
            }

            this(v2, v3, v4, arg11, null);
        }

        public Absolute(float arg1, float arg2, float arg3, float arg4, DefaultConstructorMarker arg5) {
            this(arg1, arg2, arg3, arg4);
        }

        public float calculateBottomPadding-D9Ej5fM() {
            return this.bottom;
        }

        public float calculateLeftPadding-u2uoSUM(LayoutDirection arg1) {
            return this.left;
        }

        public float calculateRightPadding-u2uoSUM(LayoutDirection arg1) {
            return this.right;
        }

        public float calculateTopPadding-D9Ej5fM() {
            return this.top;
        }

        public boolean equals(Object arg4) {
            if(!(arg4 instanceof Absolute)) {
                return 0;
            }

            if((Dp.equals-impl0(this.left, ((Absolute)arg4).left)) && (Dp.equals-impl0(this.top, ((Absolute)arg4).top)) && (Dp.equals-impl0(this.right, ((Absolute)arg4).right)) && (Dp.equals-impl0(this.bottom, ((Absolute)arg4).bottom))) {
                return 1;
            }

            return 0;
        }

        private static void getBottom-D9Ej5fM$annotations() {
        }

        private static void getLeft-D9Ej5fM$annotations() {
        }

        private static void getRight-D9Ej5fM$annotations() {
        }

        private static void getTop-D9Ej5fM$annotations() {
        }

        public int hashCode() {
            return ((Dp.hashCode-impl(this.left) * 0x1F + Dp.hashCode-impl(this.top)) * 0x1F + Dp.hashCode-impl(this.right)) * 0x1F + Dp.hashCode-impl(this.bottom);
        }

        public String toString() {
            return "PaddingValues.Absolute(left=" + Dp.toString-impl(this.left) + ", top=" + Dp.toString-impl(this.top) + ", right=" + Dp.toString-impl(this.right) + ", bottom=" + Dp.toString-impl(this.bottom) + ')';
        }
    }

    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001A\u0010\u0004\u001A\u00020\u0005X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"Landroidx/compose/foundation/layout/PaddingValues$Companion;", "", "<init>", "()V", "Zero", "Landroidx/compose/foundation/layout/PaddingValues;", "getZero$annotations", "getZero", "()Landroidx/compose/foundation/layout/PaddingValues;", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        private static final PaddingValues Zero;

        static {
            Companion.$$INSTANCE = new Companion();
            Companion.Zero = new Absolute(0f, 0f, 0f, 0f, 15, null);
        }

        private Companion() {
            super();
        }

        public final PaddingValues getZero() {
            return Companion.Zero;
        }

        public static void getZero$annotations() {
        }
    }

    public static final Companion Companion;

    static {
        PaddingValues.Companion = Companion.$$INSTANCE;
    }

    float calculateBottomPadding-D9Ej5fM();

    float calculateLeftPadding-u2uoSUM(LayoutDirection arg1);

    float calculateRightPadding-u2uoSUM(LayoutDirection arg1);

    float calculateTopPadding-D9Ej5fM();
}

