package androidx.compose.ui.layout;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0002\f\rJ:\u0010\u0002\u001A\u0004\u0018\u0001H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0019\u0010\u0006\u001A\u0015\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u0007¢\u0006\u0002\b\tH&¢\u0006\u0004\b\n\u0010\u000Bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000EÀ\u0006\u0001"}, d2={"Landroidx/compose/ui/layout/BeyondBoundsLayout;", "", "layout", "T", "direction", "Landroidx/compose/ui/layout/BeyondBoundsLayout$LayoutDirection;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "Lkotlin/ExtensionFunctionType;", "layout-o7g1Pn8", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "BeyondBoundsScope", "LayoutDirection", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface BeyondBoundsLayout {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2={"Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "", "hasMoreContent", "", "getHasMoreContent", "()Z", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface BeyondBoundsScope {
        boolean getHasMoreContent();
    }

    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000E2\u00020\u0001:\u0001\u000EB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0006\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001A\u00020\u0003HÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000F"}, d2={"Landroidx/compose/ui/layout/BeyondBoundsLayout$LayoutDirection;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class LayoutDirection {
        @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000E\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u000E\u0010\u0007R\u0013\u0010\u000F\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0012\u0010\u0007¨\u0006\u0013"}, d2={"Landroidx/compose/ui/layout/BeyondBoundsLayout$LayoutDirection$Companion;", "", "<init>", "()V", "Before", "Landroidx/compose/ui/layout/BeyondBoundsLayout$LayoutDirection;", "getBefore-hoxUOeE", "()I", "I", "After", "getAfter-hoxUOeE", "Left", "getLeft-hoxUOeE", "Right", "getRight-hoxUOeE", "Above", "getAbove-hoxUOeE", "Below", "getBelow-hoxUOeE", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
            public Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private Companion() {
                super();
            }

            public final int getAbove-hoxUOeE() {
                return LayoutDirection.Above;
            }

            public final int getAfter-hoxUOeE() {
                return LayoutDirection.After;
            }

            public final int getBefore-hoxUOeE() {
                return LayoutDirection.Before;
            }

            public final int getBelow-hoxUOeE() {
                return LayoutDirection.Below;
            }

            public final int getLeft-hoxUOeE() {
                return LayoutDirection.Left;
            }

            public final int getRight-hoxUOeE() {
                return LayoutDirection.Right;
            }
        }

        private static final int Above;
        private static final int After;
        private static final int Before;
        private static final int Below;
        public static final Companion Companion;
        private static final int Left;
        private static final int Right;
        private final int value;

        static {
            LayoutDirection.Companion = new Companion(null);
            LayoutDirection.Before = LayoutDirection.constructor-impl(1);
            LayoutDirection.After = LayoutDirection.constructor-impl(2);
            LayoutDirection.Left = LayoutDirection.constructor-impl(3);
            LayoutDirection.Right = LayoutDirection.constructor-impl(4);
            LayoutDirection.Above = LayoutDirection.constructor-impl(5);
            LayoutDirection.Below = LayoutDirection.constructor-impl(6);
        }

        private LayoutDirection(int arg1) {
            super();
            this.value = arg1;
        }

        public static final int access$getAbove$cp() {
            return LayoutDirection.Above;
        }

        public static final int access$getAfter$cp() {
            return LayoutDirection.After;
        }

        public static final int access$getBefore$cp() {
            return LayoutDirection.Before;
        }

        public static final int access$getBelow$cp() {
            return LayoutDirection.Below;
        }

        public static final int access$getLeft$cp() {
            return LayoutDirection.Left;
        }

        public static final int access$getRight$cp() {
            return LayoutDirection.Right;
        }

        public static final LayoutDirection box-impl(int arg1) {
            return new LayoutDirection(arg1);
        }

        public static int constructor-impl(int arg0) {
            return arg0;
        }

        public boolean equals(Object arg1) {
            return LayoutDirection.equals-impl(this.value, arg1);
        }

        public static boolean equals-impl(int arg2, Object arg3) {
            if(!(arg3 instanceof LayoutDirection)) {
                return 0;
            }

            if(arg2 != ((LayoutDirection)arg3).unbox-impl()) {
                return 0;
            }

            return 1;
        }

        public static final boolean equals-impl0(int arg0, int arg1) {
            if(arg0 == arg1) {
                return 1;
            }

            return 0;
        }

        public int hashCode() {
            return LayoutDirection.hashCode-impl(this.value);
        }

        public static int hashCode-impl(int arg0) {
            return Integer.hashCode(arg0);
        }

        public String toString() {
            return LayoutDirection.toString-impl(this.value);
        }

        public static String toString-impl(int arg1) {
            if(LayoutDirection.equals-impl0(arg1, LayoutDirection.Before)) {
                return "Before";
            }

            if(LayoutDirection.equals-impl0(arg1, LayoutDirection.After)) {
                return "After";
            }

            if(LayoutDirection.equals-impl0(arg1, LayoutDirection.Left)) {
                return "Left";
            }

            if(LayoutDirection.equals-impl0(arg1, LayoutDirection.Right)) {
                return "Right";
            }

            if(LayoutDirection.equals-impl0(arg1, LayoutDirection.Above)) {
                return "Above";
            }

            if(LayoutDirection.equals-impl0(arg1, LayoutDirection.Below)) {
                return "Below";
            }

            return "invalid LayoutDirection";
        }

        public final int unbox-impl() {
            return this.value;
        }
    }

    Object layout-o7g1Pn8(int arg1, Function1 arg2);
}

