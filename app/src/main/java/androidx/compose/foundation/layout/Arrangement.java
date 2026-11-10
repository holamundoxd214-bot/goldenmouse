package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0005FGHIJB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\"\u001A\u00020\u00152\u0006\u0010#\u001A\u00020$H\u0007¢\u0006\u0004\b%\u0010&J\u001F\u0010\"\u001A\u00020\u00052\u0006\u0010#\u001A\u00020$2\u0006\u0010\'\u001A\u00020(H\u0007¢\u0006\u0004\b)\u0010*J\u001F\u0010\"\u001A\u00020\r2\u0006\u0010#\u001A\u00020$2\u0006\u0010\'\u001A\u00020+H\u0007¢\u0006\u0004\b)\u0010,J\u0010\u0010-\u001A\u00020\u00052\u0006\u0010\'\u001A\u00020(H\u0007J\u0010\u0010-\u001A\u00020\r2\u0006\u0010\'\u001A\u00020+H\u0007J-\u0010.\u001A\u00020/2\u0006\u00100\u001A\u0002012\u0006\u00102\u001A\u0002032\u0006\u00104\u001A\u0002032\u0006\u00105\u001A\u000206H\u0000¢\u0006\u0002\b7J%\u00108\u001A\u00020/2\u0006\u00102\u001A\u0002032\u0006\u00104\u001A\u0002032\u0006\u00105\u001A\u000206H\u0000¢\u0006\u0002\b9J-\u0010:\u001A\u00020/2\u0006\u00100\u001A\u0002012\u0006\u00102\u001A\u0002032\u0006\u00104\u001A\u0002032\u0006\u00105\u001A\u000206H\u0000¢\u0006\u0002\b;J-\u0010<\u001A\u00020/2\u0006\u00100\u001A\u0002012\u0006\u00102\u001A\u0002032\u0006\u00104\u001A\u0002032\u0006\u00105\u001A\u000206H\u0000¢\u0006\u0002\b=J-\u0010>\u001A\u00020/2\u0006\u00100\u001A\u0002012\u0006\u00102\u001A\u0002032\u0006\u00104\u001A\u0002032\u0006\u00105\u001A\u000206H\u0000¢\u0006\u0002\b?J-\u0010@\u001A\u00020/2\u0006\u00100\u001A\u0002012\u0006\u00102\u001A\u0002032\u0006\u00104\u001A\u0002032\u0006\u00105\u001A\u000206H\u0000¢\u0006\u0002\bAJ/\u0010B\u001A\u00020/*\u0002032\u0006\u0010C\u001A\u0002062\u0018\u0010D\u001A\u0014\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020/0EH\u0082\bR\u001C\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\bR\u001C\u0010\t\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\n\u0010\u0003\u001A\u0004\b\u000B\u0010\bR\u001C\u0010\f\u001A\u00020\r8\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u000E\u0010\u0003\u001A\u0004\b\u000F\u0010\u0010R\u001C\u0010\u0011\u001A\u00020\r8\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0012\u0010\u0003\u001A\u0004\b\u0013\u0010\u0010R\u001C\u0010\u0014\u001A\u00020\u00158\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0016\u0010\u0003\u001A\u0004\b\u0017\u0010\u0018R\u001C\u0010\u0019\u001A\u00020\u00158\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u001A\u0010\u0003\u001A\u0004\b\u001B\u0010\u0018R\u001C\u0010\u001C\u001A\u00020\u00158\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u001D\u0010\u0003\u001A\u0004\b\u001E\u0010\u0018R\u001C\u0010\u001F\u001A\u00020\u00158\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b \u0010\u0003\u001A\u0004\b!\u0010\u0018¨\u0006K"}, d2={"Landroidx/compose/foundation/layout/Arrangement;", "", "<init>", "()V", "Start", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getStart$annotations", "getStart", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "End", "getEnd$annotations", "getEnd", "Top", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "getTop$annotations", "getTop", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "Bottom", "getBottom$annotations", "getBottom", "Center", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "getCenter$annotations", "getCenter", "()Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "SpaceEvenly", "getSpaceEvenly$annotations", "getSpaceEvenly", "SpaceBetween", "getSpaceBetween$annotations", "getSpaceBetween", "SpaceAround", "getSpaceAround$annotations", "getSpaceAround", "spacedBy", "space", "Landroidx/compose/ui/unit/Dp;", "spacedBy-0680j_4", "(F)Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "spacedBy-D5KLDUw", "(FLandroidx/compose/ui/Alignment$Horizontal;)Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "Landroidx/compose/ui/Alignment$Vertical;", "(FLandroidx/compose/ui/Alignment$Vertical;)Landroidx/compose/foundation/layout/Arrangement$Vertical;", "aligned", "placeRightOrBottom", "", "totalSize", "", "size", "", "outPosition", "reverseInput", "", "placeRightOrBottom$foundation_layout", "placeLeftOrTop", "placeLeftOrTop$foundation_layout", "placeCenter", "placeCenter$foundation_layout", "placeSpaceEvenly", "placeSpaceEvenly$foundation_layout", "placeSpaceBetween", "placeSpaceBetween$foundation_layout", "placeSpaceAround", "placeSpaceAround$foundation_layout", "forEachIndexed", "reversed", "action", "Lkotlin/Function2;", "Horizontal", "Vertical", "HorizontalOrVertical", "Absolute", "SpacedAligned", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Arrangement {
    @Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u001BH\u0007¢\u0006\u0004\b\u001C\u0010\u001DJ\u001F\u0010\u0018\u001A\u00020\u00052\u0006\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001E\u001A\u00020\u001FH\u0007¢\u0006\u0004\b \u0010!J\u001F\u0010\u0018\u001A\u00020\"2\u0006\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001E\u001A\u00020#H\u0007¢\u0006\u0004\b \u0010$J\u0010\u0010%\u001A\u00020\u00052\u0006\u0010\u001E\u001A\u00020\u001FH\u0007R\u001C\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\bR\u001C\u0010\t\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\n\u0010\u0003\u001A\u0004\b\u000B\u0010\bR\u001C\u0010\f\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\r\u0010\u0003\u001A\u0004\b\u000E\u0010\bR\u001C\u0010\u000F\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0010\u0010\u0003\u001A\u0004\b\u0011\u0010\bR\u001C\u0010\u0012\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0013\u0010\u0003\u001A\u0004\b\u0014\u0010\bR\u001C\u0010\u0015\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0016\u0010\u0003\u001A\u0004\b\u0017\u0010\b¨\u0006&"}, d2={"Landroidx/compose/foundation/layout/Arrangement$Absolute;", "", "<init>", "()V", "Left", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getLeft$annotations", "getLeft", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "Center", "getCenter$annotations", "getCenter", "Right", "getRight$annotations", "getRight", "SpaceBetween", "getSpaceBetween$annotations", "getSpaceBetween", "SpaceEvenly", "getSpaceEvenly$annotations", "getSpaceEvenly", "SpaceAround", "getSpaceAround$annotations", "getSpaceAround", "spacedBy", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "space", "Landroidx/compose/ui/unit/Dp;", "spacedBy-0680j_4", "(F)Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "spacedBy-D5KLDUw", "(FLandroidx/compose/ui/Alignment$Horizontal;)Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "Landroidx/compose/ui/Alignment$Vertical;", "(FLandroidx/compose/ui/Alignment$Vertical;)Landroidx/compose/foundation/layout/Arrangement$Vertical;", "aligned", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Absolute {
        public static final int $stable;
        private static final Horizontal Center;
        public static final Absolute INSTANCE;
        private static final Horizontal Left;
        private static final Horizontal Right;
        private static final Horizontal SpaceAround;
        private static final Horizontal SpaceBetween;
        private static final Horizontal SpaceEvenly;

        static {
            Absolute.INSTANCE = new Absolute();
            Absolute.Left = new Arrangement$Absolute$Left$1();
            Absolute.Center = new Arrangement$Absolute$Center$1();
            Absolute.Right = new Arrangement$Absolute$Right$1();
            Absolute.SpaceBetween = new Arrangement$Absolute$SpaceBetween$1();
            Absolute.SpaceEvenly = new Arrangement$Absolute$SpaceEvenly$1();
            Absolute.SpaceAround = new Arrangement$Absolute$SpaceAround$1();
        }

        private Absolute() {
            super();
        }

        public final Horizontal aligned(androidx.compose.ui.Alignment$Horizontal arg4) {
            return new SpacedAligned(Dp.constructor-impl(0f), false, new Arrangement$Absolute$$ExternalSyntheticLambda1(arg4), null);
        }

        static final int aligned$lambda$0(androidx.compose.ui.Alignment$Horizontal arg1, int arg2, LayoutDirection arg3) {
            return arg1.align(0, arg2, arg3);
        }

        public final Horizontal getCenter() {
            return Absolute.Center;
        }

        public static void getCenter$annotations() {
        }

        public final Horizontal getLeft() {
            return Absolute.Left;
        }

        public static void getLeft$annotations() {
        }

        public final Horizontal getRight() {
            return Absolute.Right;
        }

        public static void getRight$annotations() {
        }

        public final Horizontal getSpaceAround() {
            return Absolute.SpaceAround;
        }

        public static void getSpaceAround$annotations() {
        }

        public final Horizontal getSpaceBetween() {
            return Absolute.SpaceBetween;
        }

        public static void getSpaceBetween$annotations() {
        }

        public final Horizontal getSpaceEvenly() {
            return Absolute.SpaceEvenly;
        }

        public static void getSpaceEvenly$annotations() {
        }

        public final HorizontalOrVertical spacedBy-0680j_4(float arg3) {
            return new SpacedAligned(arg3, false, null, null);
        }

        public final Horizontal spacedBy-D5KLDUw(float arg3, androidx.compose.ui.Alignment$Horizontal arg4) {
            return new SpacedAligned(arg3, false, new Arrangement$Absolute$$ExternalSyntheticLambda2(arg4), null);
        }

        public final Vertical spacedBy-D5KLDUw(float arg3, androidx.compose.ui.Alignment$Vertical arg4) {
            return new SpacedAligned(arg3, false, new Arrangement$Absolute$$ExternalSyntheticLambda0(arg4), null);
        }

        static final int spacedBy_D5KLDUw$lambda$0(androidx.compose.ui.Alignment$Horizontal arg1, int arg2, LayoutDirection arg3) {
            return arg1.align(0, arg2, arg3);
        }

        static final int spacedBy_D5KLDUw$lambda$1(androidx.compose.ui.Alignment$Vertical arg0, int arg1, LayoutDirection arg2) {
            return arg0.align(0, arg1);
        }
    }

    @Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J,\u0010\u0006\u001A\u00020\u0007*\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\fH&R\u0014\u0010\u0002\u001A\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0003"}, d2={"Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "", "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "", "sizes", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "outPositions", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public interface Horizontal {
        @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
            @Deprecated public static float getSpacing-D9Ej5fM(Horizontal arg0) {
                return arg0.getSpacing-D9Ej5fM();
            }
        }

        static float access$getSpacing-D9Ej5fM$jd(Horizontal arg0) {
            return super.getSpacing-D9Ej5fM();
        }

        void arrange(Density arg1, int arg2, int[] arg3, LayoutDirection arg4, int[] arg5);

        default float getSpacing-D9Ej5fM() {
            return Dp.constructor-impl(0f);
        }
    }

    @Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u00012\u00020\u0002R\u0014\u0010\u0003\u001A\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0003"}, d2={"Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public interface HorizontalOrVertical extends Horizontal, Vertical {
        @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical$DefaultImpls {
            @Deprecated public static float getSpacing-D9Ej5fM(HorizontalOrVertical arg0) {
                return arg0.getSpacing-D9Ej5fM();
            }
        }

        static float access$getSpacing-D9Ej5fM$jd(HorizontalOrVertical arg0) {
            return super.getSpacing-D9Ej5fM();
        }

        default float getSpacing-D9Ej5fM() {
            return Dp.constructor-impl(0f);
        }
    }

    @Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u001A\u0010\u0006\u001A\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000BJ,\u0010\u0015\u001A\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001A\u00020\b2\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\t2\u0006\u0010\u001C\u001A\u00020\u001AH\u0016J$\u0010\u0015\u001A\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001A\u00020\b2\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001C\u001A\u00020\u001AH\u0016J\b\u0010\u001D\u001A\u00020\u001EH\u0016J\u0010\u0010\u001F\u001A\u00020\u0003HÆ\u0003¢\u0006\u0004\b \u0010\rJ\t\u0010!\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\"\u001A\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003JB\u0010#\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\u001C\b\u0002\u0010\u0006\u001A\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b$\u0010%J\u0013\u0010&\u001A\u00020\u00052\b\u0010\'\u001A\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001A\u00020\bHÖ\u0001R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R%\u0010\u0006\u001A\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001A\u00020\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\u0014\u0010\r¨\u0006*"}, d2={"Landroidx/compose/foundation/layout/Arrangement$SpacedAligned;", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "space", "Landroidx/compose/ui/unit/Dp;", "rtlMirror", "", "alignment", "Lkotlin/Function2;", "", "Landroidx/compose/ui/unit/LayoutDirection;", "<init>", "(FZLkotlin/jvm/functions/Function2;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSpace-D9Ej5fM", "()F", "F", "getRtlMirror", "()Z", "getAlignment", "()Lkotlin/jvm/functions/Function2;", "spacing", "getSpacing-D9Ej5fM", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "sizes", "", "layoutDirection", "outPositions", "toString", "", "component1", "component1-D9Ej5fM", "component2", "component3", "copy", "copy-8Feqmps", "(FZLkotlin/jvm/functions/Function2;)Landroidx/compose/foundation/layout/Arrangement$SpacedAligned;", "equals", "other", "", "hashCode", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SpacedAligned implements HorizontalOrVertical {
        public static final int $stable;
        private final Function2 alignment;
        private final boolean rtlMirror;
        private final float space;
        private final float spacing;

        static {
        }

        public SpacedAligned(float arg1, boolean arg2, Function2 arg3, DefaultConstructorMarker arg4) {
            this(arg1, arg2, arg3);
        }

        private SpacedAligned(float arg1, boolean arg2, Function2 arg3) {
            super();
            this.space = arg1;
            this.rtlMirror = arg2;
            this.alignment = arg3;
            this.spacing = arg1;
        }

        public void arrange(Density arg9, int arg10, int[] arg11, LayoutDirection arg12, int[] arg13) {
            int v4;
            int v3;
            int v1;
            if(arg11.length == 0) {
                return;
            }

            int v9 = arg9.roundToPx-0680j_4(this.space);
            int v2 = 0;
            int v0 = !this.rtlMirror || arg12 != LayoutDirection.Rtl ? 0 : 1;
            if(v0 == 0) {
                v0 = arg11.length;
                v1 = 0;
                v3 = 0;
                v4 = 0;
                int v5;
                for(v5 = 0; v1 < v0; v5 = v6) {
                    v4 = arg11[v1];
                    int v6 = v5 + 1;
                    v3 = Math.min(v3, arg10 - v4);
                    arg13[v5] = v3;
                    v3 = Math.min(v9, arg10 - v3 - v4);
                    ++v1;
                    v5 = arg13[v5] + v4 + v3;
                    v4 = v3;
                    v3 = v5;
                }
            }
            else {
                v0 = arg11.length - 1;
                v3 = 0;
                v4 = 0;
                while(-1 < v0) {
                    v1 = arg11[v0];
                    v3 = Math.min(v3, arg10 - v1);
                    arg13[v0] = v3;
                    v4 = Math.min(v9, arg10 - v3 - v1);
                    v3 = arg13[v0] + v1 + v4;
                    --v0;
                }
            }

            v3 -= v4;
            Function2 v8 = this.alignment;
            if(v8 != null && v3 < arg10) {
                int v8_1 = v8.invoke(Integer.valueOf(arg10 - v3), arg12).intValue();
                v9 = arg13.length;
                while(v2 < v9) {
                    arg13[v2] += v8_1;
                    ++v2;
                }
            }
        }

        public void arrange(Density arg7, int arg8, int[] arg9, int[] arg10) {
            this.arrange(arg7, arg8, arg9, LayoutDirection.Ltr, arg10);
        }

        public final float component1-D9Ej5fM() {
            return this.space;
        }

        public final boolean component2() {
            return this.rtlMirror;
        }

        public final Function2 component3() {
            return this.alignment;
        }

        public final SpacedAligned copy-8Feqmps(float arg2, boolean arg3, Function2 arg4) {
            return new SpacedAligned(arg2, arg3, arg4, null);
        }

        public static SpacedAligned copy-8Feqmps$default(SpacedAligned arg0, float arg1, boolean arg2, Function2 arg3, int arg4, Object arg5) {
            if((arg4 & 1) != 0) {
                arg1 = arg0.space;
            }

            if((arg4 & 2) != 0) {
                arg2 = arg0.rtlMirror;
            }

            if((arg4 & 4) != 0) {
                arg3 = arg0.alignment;
            }

            return arg0.copy-8Feqmps(arg1, arg2, arg3);
        }

        public boolean equals(Object arg5) {
            if(this == (((SpacedAligned)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof SpacedAligned)) {
                return 0;
            }

            if(!Dp.equals-impl0(this.space, ((SpacedAligned)arg5).space)) {
                return 0;
            }

            if(this.rtlMirror != ((SpacedAligned)arg5).rtlMirror) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.alignment, ((SpacedAligned)arg5).alignment)) {
                return 0;
            }

            return 1;
        }

        public final Function2 getAlignment() {
            return this.alignment;
        }

        public final boolean getRtlMirror() {
            return this.rtlMirror;
        }

        public final float getSpace-D9Ej5fM() {
            return this.space;
        }

        public float getSpacing-D9Ej5fM() {
            return this.spacing;
        }

        public int hashCode() {
            int v0 = (Dp.hashCode-impl(this.space) * 0x1F + Boolean.hashCode(this.rtlMirror)) * 0x1F;
            Function2 v2 = this.alignment;
            int v2_1 = v2 == null ? 0 : v2.hashCode();
            return v0 + v2_1;
        }

        public String toString() {
            String v1 = this.rtlMirror ? "" : "Absolute";
            return v1 + "Arrangement#spacedAligned(" + Dp.toString-impl(this.space) + ", " + this.alignment + ')';
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J$\u0010\u0006\u001A\u00020\u0007*\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\fH&R\u0014\u0010\u0002\u001A\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000EÀ\u0006\u0003"}, d2={"Landroidx/compose/foundation/layout/Arrangement$Vertical;", "", "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "", "sizes", "", "outPositions", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public interface Vertical {
        @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class androidx.compose.foundation.layout.Arrangement$Vertical$DefaultImpls {
            @Deprecated public static float getSpacing-D9Ej5fM(Vertical arg0) {
                return arg0.getSpacing-D9Ej5fM();
            }
        }

        static float access$getSpacing-D9Ej5fM$jd(Vertical arg0) {
            return super.getSpacing-D9Ej5fM();
        }

        void arrange(Density arg1, int arg2, int[] arg3, int[] arg4);

        default float getSpacing-D9Ej5fM() {
            return Dp.constructor-impl(0f);
        }
    }

    public static final int $stable;
    private static final Vertical Bottom;
    private static final HorizontalOrVertical Center;
    private static final Horizontal End;
    public static final Arrangement INSTANCE;
    private static final HorizontalOrVertical SpaceAround;
    private static final HorizontalOrVertical SpaceBetween;
    private static final HorizontalOrVertical SpaceEvenly;
    private static final Horizontal Start;
    private static final Vertical Top;

    static {
        Arrangement.INSTANCE = new Arrangement();
        Arrangement.Start = new Arrangement$Start$1();
        Arrangement.End = new Arrangement$End$1();
        Arrangement.Top = new Arrangement$Top$1();
        Arrangement.Bottom = new Arrangement$Bottom$1();
        Arrangement.Center = new Arrangement$Center$1();
        Arrangement.SpaceEvenly = new Arrangement$SpaceEvenly$1();
        Arrangement.SpaceBetween = new Arrangement$SpaceBetween$1();
        Arrangement.SpaceAround = new Arrangement$SpaceAround$1();
    }

    private Arrangement() {
        super();
    }

    public final Horizontal aligned(androidx.compose.ui.Alignment$Horizontal arg4) {
        return new SpacedAligned(Dp.constructor-impl(0f), true, new Arrangement$$ExternalSyntheticLambda2(arg4), null);
    }

    public final Vertical aligned(androidx.compose.ui.Alignment$Vertical arg4) {
        return new SpacedAligned(Dp.constructor-impl(0f), false, new Arrangement$$ExternalSyntheticLambda3(arg4), null);
    }

    static final int aligned$lambda$0(androidx.compose.ui.Alignment$Horizontal arg1, int arg2, LayoutDirection arg3) {
        return arg1.align(0, arg2, arg3);
    }

    static final int aligned$lambda$1(androidx.compose.ui.Alignment$Vertical arg0, int arg1, LayoutDirection arg2) {
        return arg0.align(0, arg1);
    }

    private final void forEachIndexed(int[] arg4, boolean arg5, Function2 arg6) {
        int v3;
        if(!arg5) {
            v3 = arg4.length;
            int v5 = 0;
            int v0;
            for(v0 = 0; v5 < v3; ++v0) {
                arg6.invoke(Integer.valueOf(v0), Integer.valueOf(arg4[v5]));
                ++v5;
            }
        }
        else {
            for(v3 = arg4.length - 1; -1 < v3; --v3) {
                arg6.invoke(Integer.valueOf(v3), Integer.valueOf(arg4[v3]));
            }
        }
    }

    public final Vertical getBottom() {
        return Arrangement.Bottom;
    }

    public static void getBottom$annotations() {
    }

    public final HorizontalOrVertical getCenter() {
        return Arrangement.Center;
    }

    public static void getCenter$annotations() {
    }

    public final Horizontal getEnd() {
        return Arrangement.End;
    }

    public static void getEnd$annotations() {
    }

    public final HorizontalOrVertical getSpaceAround() {
        return Arrangement.SpaceAround;
    }

    public static void getSpaceAround$annotations() {
    }

    public final HorizontalOrVertical getSpaceBetween() {
        return Arrangement.SpaceBetween;
    }

    public static void getSpaceBetween$annotations() {
    }

    public final HorizontalOrVertical getSpaceEvenly() {
        return Arrangement.SpaceEvenly;
    }

    public static void getSpaceEvenly$annotations() {
    }

    public final Horizontal getStart() {
        return Arrangement.Start;
    }

    public static void getStart$annotations() {
    }

    public final Vertical getTop() {
        return Arrangement.Top;
    }

    public static void getTop$annotations() {
    }

    public final void placeCenter$foundation_layout(int arg5, int[] arg6, int[] arg7, boolean arg8) {
        int v8;
        int v4 = arg6.length;
        int v0 = 0;
        int v1 = 0;
        int v2 = 0;
        while(v1 < v4) {
            v2 += arg6[v1];
            ++v1;
        }

        float v4_1 = (((float)(arg5 - v2))) / 2f;
        if(!arg8) {
            arg5 = arg6.length;
            v8 = 0;
            goto label_16;
        }
        else {
            arg5 = arg6.length - 1;
            while(true) {
                if(-1 < arg5) {
                    v8 = arg6[arg5];
                    arg7[arg5] = Math.round(v4_1);
                    v4_1 += ((float)v8);
                    --arg5;
                    continue;
                }

                return;
            }

        label_16:
            while(v0 < arg5) {
                v1 = arg6[v0];
                arg7[v8] = Math.round(v4_1);
                v4_1 += ((float)v1);
                ++v0;
                ++v8;
            }
        }
    }

    public final void placeLeftOrTop$foundation_layout(int[] arg5, int[] arg6, boolean arg7) {
        int v0;
        int v7;
        int v4 = 0;
        if(!arg7) {
            v7 = arg5.length;
            v0 = 0;
            int v1 = 0;
            while(v4 < v7) {
                int v2 = arg5[v4];
                arg6[v0] = v1;
                v1 += v2;
                ++v4;
                ++v0;
            }
        }
        else {
            for(v7 = arg5.length - 1; -1 < v7; --v7) {
                v0 = arg5[v7];
                arg6[v7] = v4;
                v4 += v0;
            }
        }
    }

    public final void placeRightOrBottom$foundation_layout(int arg5, int[] arg6, int[] arg7, boolean arg8) {
        int v8;
        int v4 = arg6.length;
        int v0 = 0;
        int v1 = 0;
        int v2 = 0;
        while(v1 < v4) {
            v2 += arg6[v1];
            ++v1;
        }

        arg5 -= v2;
        if(!arg8) {
            v4 = arg6.length;
            v8 = 0;
            goto label_13;
        }
        else {
            v4 = arg6.length - 1;
            while(true) {
                if(-1 < v4) {
                    v8 = arg6[v4];
                    arg7[v4] = arg5;
                    arg5 += v8;
                    --v4;
                    continue;
                }

                return;
            }

        label_13:
            while(v0 < v4) {
                v1 = arg6[v0];
                arg7[v8] = arg5;
                arg5 += v1;
                ++v0;
                ++v8;
            }
        }
    }

    public final void placeSpaceAround$foundation_layout(int arg6, int[] arg7, int[] arg8, boolean arg9) {
        int v9;
        int v5 = arg7.length;
        int v0 = 0;
        int v1 = 0;
        int v2 = 0;
        while(v1 < v5) {
            v2 += arg7[v1];
            ++v1;
        }

        v5 = arg7.length == 0 ? 1 : 0;
        float v5_1 = v5 == 0 ? (((float)(arg6 - v2))) / (((float)arg7.length)) : 0f;
        float v6 = v5_1 / 2f;
        if(!arg9) {
            v9 = arg7.length;
            v1 = 0;
            goto label_28;
        }
        else {
            v9 = arg7.length - 1;
            while(true) {
                if(-1 < v9) {
                    v0 = arg7[v9];
                    arg8[v9] = Math.round(v6);
                    v6 += (((float)v0)) + v5_1;
                    --v9;
                    continue;
                }

                return;
            }

        label_28:
            while(v0 < v9) {
                v2 = arg7[v0];
                arg8[v1] = Math.round(v6);
                v6 += (((float)v2)) + v5_1;
                ++v0;
                ++v1;
            }
        }
    }

    public final void placeSpaceBetween$foundation_layout(int arg6, int[] arg7, int[] arg8, boolean arg9) {
        int v9;
        if(arg7.length == 0) {
            return;
        }

        int v5 = arg7.length;
        int v0 = 0;
        int v1 = 0;
        int v2 = 0;
        while(v1 < v5) {
            v2 += arg7[v1];
            ++v1;
        }

        float v6 = (((float)(arg6 - v2))) / (((float)Math.max(ArraysKt.getLastIndex(arg7), 1)));
        float v5_1 = !arg9 || arg7.length != 1 ? 0f : v6;
        if(!arg9) {
            v9 = arg7.length;
            v1 = 0;
            goto label_28;
        }
        else {
            v9 = arg7.length - 1;
            while(true) {
                if(-1 < v9) {
                    v0 = arg7[v9];
                    arg8[v9] = Math.round(v5_1);
                    v5_1 += (((float)v0)) + v6;
                    --v9;
                    continue;
                }

                return;
            }

        label_28:
            while(v0 < v9) {
                v2 = arg7[v0];
                arg8[v1] = Math.round(v5_1);
                v5_1 += (((float)v2)) + v6;
                ++v0;
                ++v1;
            }
        }
    }

    public final void placeSpaceEvenly$foundation_layout(int arg6, int[] arg7, int[] arg8, boolean arg9) {
        int v9;
        float v1_1;
        int v5 = arg7.length;
        int v0 = 0;
        int v1 = 0;
        int v2 = 0;
        while(v1 < v5) {
            v2 += arg7[v1];
            ++v1;
        }

        float v5_1 = (((float)(arg6 - v2))) / (((float)(arg7.length + 1)));
        if(!arg9) {
            arg6 = arg7.length;
            v1_1 = v5_1;
            v9 = 0;
            goto label_19;
        }
        else {
            arg6 = arg7.length - 1;
            float v9_1 = v5_1;
            while(true) {
                if(-1 < arg6) {
                    v0 = arg7[arg6];
                    arg8[arg6] = Math.round(v9_1);
                    v9_1 += (((float)v0)) + v5_1;
                    --arg6;
                    continue;
                }

                return;
            }

        label_19:
            while(v0 < arg6) {
                v2 = arg7[v0];
                arg8[v9] = Math.round(v1_1);
                v1_1 += (((float)v2)) + v5_1;
                ++v0;
                ++v9;
            }
        }
    }

    public final HorizontalOrVertical spacedBy-0680j_4(float arg4) {
        return new SpacedAligned(arg4, true, new Arrangement$$ExternalSyntheticLambda4(), null);
    }

    public final Horizontal spacedBy-D5KLDUw(float arg3, androidx.compose.ui.Alignment$Horizontal arg4) {
        return new SpacedAligned(arg3, true, new Arrangement$$ExternalSyntheticLambda0(arg4), null);
    }

    public final Vertical spacedBy-D5KLDUw(float arg3, androidx.compose.ui.Alignment$Vertical arg4) {
        return new SpacedAligned(arg3, false, new Arrangement$$ExternalSyntheticLambda1(arg4), null);
    }

    static final int spacedBy_0680j_4$lambda$0(int arg2, LayoutDirection arg3) {
        return Alignment.Companion.getStart().align(0, arg2, arg3);
    }

    static final int spacedBy_D5KLDUw$lambda$0(androidx.compose.ui.Alignment$Horizontal arg1, int arg2, LayoutDirection arg3) {
        return arg1.align(0, arg2, arg3);
    }

    static final int spacedBy_D5KLDUw$lambda$1(androidx.compose.ui.Alignment$Vertical arg0, int arg1, LayoutDirection arg2) {
        return arg0.align(0, arg1);
    }
}

