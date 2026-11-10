package androidx.compose.material3.internal;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector$Builder;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2={"Landroidx/compose/material3/internal/Icons;", "", "<init>", "()V", "AutoMirrored", "Filled", "Outlined", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Icons {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2={"Landroidx/compose/material3/internal/Icons$AutoMirrored;", "", "<init>", "()V", "Filled", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AutoMirrored {
        @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001A\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001A\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u0007R\u0010\u0010\u000B\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Landroidx/compose/material3/internal/Icons$AutoMirrored$Filled;", "", "<init>", "()V", "KeyboardArrowLeft", "Landroidx/compose/ui/graphics/vector/ImageVector;", "getKeyboardArrowLeft$material3", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "_keyboardArrowLeft", "KeyboardArrowRight", "getKeyboardArrowRight$material3", "_keyboardArrowRight", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Filled {
            public static final int $stable;
            public static final Filled INSTANCE;
            private static ImageVector _keyboardArrowLeft;
            private static ImageVector _keyboardArrowRight;

            static {
                Filled.INSTANCE = new Filled();
                Filled.$stable = 8;
            }

            private Filled() {
                super();
            }

            public final ImageVector getKeyboardArrowLeft$material3() {
                ImageVector v0 = Filled._keyboardArrowLeft;
                if(v0 != null) {
                    Intrinsics.checkNotNull(v0);
                    return v0;
                }

                Builder v1 = new Builder("AutoMirrored.Filled.KeyboardArrowLeft", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, true, 0x60, null);
                int v3 = VectorKt.getDefaultFillType();
                SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
                int v10 = StrokeCap.Companion.getButt-KaPHkGw();
                int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
                PathBuilder v0_1 = new PathBuilder();
                v0_1.moveTo(15.41f, 16.59f);
                v0_1.lineTo(10.83f, 12f);
                v0_1.lineToRelative(4.58f, -4.59f);
                v0_1.lineTo(14f, 6f);
                v0_1.lineToRelative(-6f, 6f);
                v0_1.lineToRelative(6f, 6f);
                v0_1.lineToRelative(1.41f, -1.41f);
                v0_1.close();
                v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
                Filled._keyboardArrowLeft = v0;
                Intrinsics.checkNotNull(v0);
                return v0;
            }

            public final ImageVector getKeyboardArrowRight$material3() {
                ImageVector v0 = Filled._keyboardArrowRight;
                if(v0 != null) {
                    Intrinsics.checkNotNull(v0);
                    return v0;
                }

                Builder v1 = new Builder("AutoMirrored.Filled.KeyboardArrowRight", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, true, 0x60, null);
                int v3 = VectorKt.getDefaultFillType();
                SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
                int v10 = StrokeCap.Companion.getButt-KaPHkGw();
                int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
                PathBuilder v0_1 = new PathBuilder();
                v0_1.moveTo(8.59f, 16.59f);
                v0_1.lineTo(13.17f, 12f);
                v0_1.lineTo(8.59f, 7.41f);
                v0_1.lineTo(10f, 6f);
                v0_1.lineToRelative(6f, 6f);
                v0_1.lineToRelative(-6f, 6f);
                v0_1.lineToRelative(-1.41f, -1.41f);
                v0_1.close();
                v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
                Filled._keyboardArrowRight = v0;
                Intrinsics.checkNotNull(v0);
                return v0;
            }
        }

        public static final int $stable;
        public static final AutoMirrored INSTANCE;

        static {
            AutoMirrored.INSTANCE = new AutoMirrored();
        }

        private AutoMirrored() {
            super();
        }
    }

    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001A\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001A\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u0007R\u0010\u0010\u000B\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001A\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u0007R\u0010\u0010\u000E\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u000F\u001A\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0007R\u0010\u0010\u0011\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001A\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0007R\u0010\u0010\u0014\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"Landroidx/compose/material3/internal/Icons$Filled;", "", "<init>", "()V", "Close", "Landroidx/compose/ui/graphics/vector/ImageVector;", "getClose$material3", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "_close", "Check", "getCheck$material3", "_check", "Edit", "getEdit$material3", "_edit", "DateRange", "getDateRange$material3", "_dateRange", "ArrowDropDown", "getArrowDropDown$material3", "_arrowDropDown", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class androidx.compose.material3.internal.Icons$Filled {
        public static final int $stable;
        public static final androidx.compose.material3.internal.Icons$Filled INSTANCE;
        private static ImageVector _arrowDropDown;
        private static ImageVector _check;
        private static ImageVector _close;
        private static ImageVector _dateRange;
        private static ImageVector _edit;

        static {
            androidx.compose.material3.internal.Icons$Filled.INSTANCE = new androidx.compose.material3.internal.Icons$Filled();
            androidx.compose.material3.internal.Icons$Filled.$stable = 8;
        }

        private androidx.compose.material3.internal.Icons$Filled() {
            super();
        }

        public final ImageVector getArrowDropDown$material3() {
            ImageVector v0 = androidx.compose.material3.internal.Icons$Filled._arrowDropDown;
            if(v0 != null) {
                Intrinsics.checkNotNull(v0);
                return v0;
            }

            Builder v1 = new Builder("Filled.ArrowDropDown", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0xE0, null);
            int v3 = VectorKt.getDefaultFillType();
            SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
            int v10 = StrokeCap.Companion.getButt-KaPHkGw();
            int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
            PathBuilder v0_1 = new PathBuilder();
            v0_1.moveTo(7f, 10f);
            v0_1.lineToRelative(5f, 5f);
            v0_1.lineToRelative(5f, -5f);
            v0_1.close();
            v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
            androidx.compose.material3.internal.Icons$Filled._arrowDropDown = v0;
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        public final ImageVector getCheck$material3() {
            ImageVector v0 = androidx.compose.material3.internal.Icons$Filled._check;
            if(v0 != null) {
                Intrinsics.checkNotNull(v0);
                return v0;
            }

            Builder v1 = new Builder("Filled.Check", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0xE0, null);
            int v3 = VectorKt.getDefaultFillType();
            SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
            int v10 = StrokeCap.Companion.getButt-KaPHkGw();
            int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
            PathBuilder v0_1 = new PathBuilder();
            v0_1.moveTo(9f, 16.17f);
            v0_1.lineTo(4.83f, 12f);
            v0_1.lineToRelative(-1.42f, 1.41f);
            v0_1.lineTo(9f, 19f);
            v0_1.lineTo(21f, 7f);
            v0_1.lineToRelative(-1.41f, -1.41f);
            v0_1.close();
            v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
            androidx.compose.material3.internal.Icons$Filled._check = v0;
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        public final ImageVector getClose$material3() {
            ImageVector v0 = androidx.compose.material3.internal.Icons$Filled._close;
            if(v0 != null) {
                Intrinsics.checkNotNull(v0);
                return v0;
            }

            Builder v1 = new Builder("Filled.Close", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0xE0, null);
            int v3 = VectorKt.getDefaultFillType();
            SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
            int v10 = StrokeCap.Companion.getButt-KaPHkGw();
            int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
            PathBuilder v0_1 = new PathBuilder();
            v0_1.moveTo(19f, 6.41f);
            v0_1.lineTo(17.59f, 5f);
            v0_1.lineTo(12f, 10.59f);
            v0_1.lineTo(6.41f, 5f);
            v0_1.lineTo(5f, 6.41f);
            v0_1.lineTo(10.59f, 12f);
            v0_1.lineTo(5f, 17.59f);
            v0_1.lineTo(6.41f, 19f);
            v0_1.lineTo(12f, 13.41f);
            v0_1.lineTo(17.59f, 19f);
            v0_1.lineTo(19f, 17.59f);
            v0_1.lineTo(13.41f, 12f);
            v0_1.close();
            v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
            androidx.compose.material3.internal.Icons$Filled._close = v0;
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        public final ImageVector getDateRange$material3() {
            ImageVector v0 = androidx.compose.material3.internal.Icons$Filled._dateRange;
            if(v0 != null) {
                Intrinsics.checkNotNull(v0);
                return v0;
            }

            Builder v1 = new Builder("Filled.DateRange", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0xE0, null);
            int v3 = VectorKt.getDefaultFillType();
            SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
            int v10 = StrokeCap.Companion.getButt-KaPHkGw();
            int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
            PathBuilder v12 = new PathBuilder();
            v12.moveTo(9f, 11f);
            v12.lineTo(7f, 11f);
            v12.verticalLineToRelative(2f);
            v12.horizontalLineToRelative(2f);
            v12.verticalLineToRelative(-2f);
            v12.close();
            v12.moveTo(13f, 11f);
            v12.horizontalLineToRelative(-2f);
            v12.verticalLineToRelative(2f);
            v12.horizontalLineToRelative(2f);
            v12.verticalLineToRelative(-2f);
            v12.close();
            v12.moveTo(17f, 11f);
            v12.horizontalLineToRelative(-2f);
            v12.verticalLineToRelative(2f);
            v12.horizontalLineToRelative(2f);
            v12.verticalLineToRelative(-2f);
            v12.close();
            v12.moveTo(19f, 4f);
            v12.horizontalLineToRelative(-1f);
            v12.lineTo(18f, 2f);
            v12.horizontalLineToRelative(-2f);
            v12.verticalLineToRelative(2f);
            v12.lineTo(8f, 4f);
            v12.lineTo(8f, 2f);
            v12.lineTo(6f, 2f);
            v12.verticalLineToRelative(2f);
            v12.lineTo(5f, 4f);
            v12.curveToRelative(-1.11f, 0f, -1.99f, 0.9f, -1.99f, 2f);
            v12.lineTo(3f, 20f);
            v12.curveToRelative(0f, 1.1f, 0.89f, 2f, 2f, 2f);
            v12.horizontalLineToRelative(14f);
            v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
            v12.lineTo(21f, 6f);
            v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
            v12.close();
            v12.moveTo(19f, 20f);
            v12.lineTo(5f, 20f);
            v12.lineTo(5f, 9f);
            v12.horizontalLineToRelative(14f);
            v12.verticalLineToRelative(11f);
            v12.close();
            v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
            androidx.compose.material3.internal.Icons$Filled._dateRange = v0;
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        public final ImageVector getEdit$material3() {
            ImageVector v0 = androidx.compose.material3.internal.Icons$Filled._edit;
            if(v0 != null) {
                Intrinsics.checkNotNull(v0);
                return v0;
            }

            Builder v1 = new Builder("Filled.Edit", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0xE0, null);
            int v3 = VectorKt.getDefaultFillType();
            SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
            int v10 = StrokeCap.Companion.getButt-KaPHkGw();
            int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
            PathBuilder v12 = new PathBuilder();
            v12.moveTo(3f, 17.25f);
            v12.verticalLineTo(21f);
            v12.horizontalLineToRelative(3.75f);
            v12.lineTo(17.809999f, 9.94f);
            v12.lineToRelative(-3.75f, -3.75f);
            v12.lineTo(3f, 17.25f);
            v12.close();
            v12.moveTo(20.709999f, 7.04f);
            v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
            v12.lineToRelative(-2.34f, -2.34f);
            v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
            v12.lineToRelative(-1.83f, 1.83f);
            v12.lineToRelative(3.75f, 3.75f);
            v12.lineToRelative(1.83f, -1.83f);
            v12.close();
            v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
            androidx.compose.material3.internal.Icons$Filled._edit = v0;
            Intrinsics.checkNotNull(v0);
            return v0;
        }
    }

    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\n\u0010\u0007R\u0010\u0010\u000B\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Landroidx/compose/material3/internal/Icons$Outlined;", "", "<init>", "()V", "Schedule", "Landroidx/compose/ui/graphics/vector/ImageVector;", "getSchedule", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "_schedule", "Keyboard", "getKeyboard", "_keyboard", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Outlined {
        public static final int $stable;
        public static final Outlined INSTANCE;
        private static ImageVector _keyboard;
        private static ImageVector _schedule;

        static {
            Outlined.INSTANCE = new Outlined();
            Outlined.$stable = 8;
        }

        private Outlined() {
            super();
        }

        public final ImageVector getKeyboard() {
            ImageVector v0 = Outlined._keyboard;
            if(v0 != null) {
                Intrinsics.checkNotNull(v0);
                return v0;
            }

            Builder v1 = new Builder("Outlined.Keyboard", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0xE0, null);
            int v3 = VectorKt.getDefaultFillType();
            SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
            int v10 = StrokeCap.Companion.getButt-KaPHkGw();
            int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
            PathBuilder v12 = new PathBuilder();
            v12.moveTo(20f, 7f);
            v12.verticalLineToRelative(10f);
            v12.lineTo(4f, 17f);
            v12.lineTo(4f, 7f);
            v12.horizontalLineToRelative(16f);
            v12.moveToRelative(0f, -2f);
            v12.lineTo(4f, 5f);
            v12.curveToRelative(-1.1f, 0f, -1.99f, 0.9f, -1.99f, 2f);
            v12.lineTo(2f, 17f);
            v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
            v12.horizontalLineToRelative(16f);
            v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
            v12.lineTo(22f, 7f);
            v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
            v12.close();
            v12.moveTo(11f, 8f);
            v12.horizontalLineToRelative(2f);
            v12.verticalLineToRelative(2f);
            v12.horizontalLineToRelative(-2f);
            v12.close();
            v12.moveTo(11f, 11f);
            v12.horizontalLineToRelative(2f);
            v12.verticalLineToRelative(2f);
            v12.horizontalLineToRelative(-2f);
            v12.close();
            v12.moveTo(8f, 8f);
            v12.horizontalLineToRelative(2f);
            v12.verticalLineToRelative(2f);
            v12.lineTo(8f, 10f);
            v12.close();
            v12.moveTo(8f, 11f);
            v12.horizontalLineToRelative(2f);
            v12.verticalLineToRelative(2f);
            v12.lineTo(8f, 13f);
            v12.close();
            v12.moveTo(5f, 11f);
            v12.horizontalLineToRelative(2f);
            v12.verticalLineToRelative(2f);
            v12.lineTo(5f, 13f);
            v12.close();
            v12.moveTo(5f, 8f);
            v12.horizontalLineToRelative(2f);
            v12.verticalLineToRelative(2f);
            v12.lineTo(5f, 10f);
            v12.close();
            v12.moveTo(8f, 14f);
            v12.horizontalLineToRelative(8f);
            v12.verticalLineToRelative(2f);
            v12.lineTo(8f, 16f);
            v12.close();
            v12.moveTo(14f, 11f);
            v12.horizontalLineToRelative(2f);
            v12.verticalLineToRelative(2f);
            v12.horizontalLineToRelative(-2f);
            v12.close();
            v12.moveTo(14f, 8f);
            v12.horizontalLineToRelative(2f);
            v12.verticalLineToRelative(2f);
            v12.horizontalLineToRelative(-2f);
            v12.close();
            v12.moveTo(17f, 11f);
            v12.horizontalLineToRelative(2f);
            v12.verticalLineToRelative(2f);
            v12.horizontalLineToRelative(-2f);
            v12.close();
            v12.moveTo(17f, 8f);
            v12.horizontalLineToRelative(2f);
            v12.verticalLineToRelative(2f);
            v12.horizontalLineToRelative(-2f);
            v12.close();
            v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
            Outlined._keyboard = v0;
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        public final ImageVector getSchedule() {
            ImageVector v0 = Outlined._schedule;
            if(v0 != null) {
                Intrinsics.checkNotNull(v0);
                return v0;
            }

            Builder v1 = new Builder("Outlined.Schedule", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0xE0, null);
            int v3 = VectorKt.getDefaultFillType();
            SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
            int v10 = StrokeCap.Companion.getButt-KaPHkGw();
            int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
            PathBuilder v12 = new PathBuilder();
            v12.moveTo(11.99f, 2f);
            v12.curveTo(6.47f, 2f, 2f, 6.48f, 2f, 12f);
            v12.reflectiveCurveToRelative(4.47f, 10f, 9.99f, 10f);
            v12.curveTo(17.52f, 22f, 22f, 17.52f, 22f, 12f);
            v12.reflectiveCurveTo(17.52f, 2f, 11.99f, 2f);
            v12.close();
            v12.moveTo(12f, 20f);
            v12.curveToRelative(-4.42f, 0f, -8f, -3.58f, -8f, -8f);
            v12.reflectiveCurveToRelative(3.58f, -8f, 8f, -8f);
            v12.reflectiveCurveToRelative(8f, 3.58f, 8f, 8f);
            v12.reflectiveCurveToRelative(-3.58f, 8f, -8f, 8f);
            v12.close();
            v12.moveTo(12.5f, 7f);
            v12.lineTo(11f, 7f);
            v12.verticalLineToRelative(6f);
            v12.lineToRelative(5.25f, 3.15f);
            v12.lineToRelative(0.75f, -1.23f);
            v12.lineToRelative(-4.5f, -2.67f);
            v12.close();
            v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
            Outlined._schedule = v0;
            Intrinsics.checkNotNull(v0);
            return v0;
        }
    }

    public static final int $stable;
    public static final Icons INSTANCE;

    static {
        Icons.INSTANCE = new Icons();
    }

    private Icons() {
        super();
    }
}

