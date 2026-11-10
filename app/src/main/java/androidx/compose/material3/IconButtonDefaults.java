package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.FilledIconButtonTokens;
import androidx.compose.material3.tokens.FilledTonalIconButtonTokens;
import androidx.compose.material3.tokens.OutlinedIconButtonTokens;
import androidx.compose.material3.tokens.SmallIconButtonTokens;
import androidx.compose.material3.tokens.StandardIconButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001_B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001A\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J7\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\bH\u0007¢\u0006\u0004\b\f\u0010\rJ\u001B\u0010\u000E\u001A\u00020\u0005*\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\bH\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001A\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J7\u0010\u0013\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\bH\u0007¢\u0006\u0004\b\u0014\u0010\rJ\u0011\u0010\u0015\u001A\u00020\u0005*\u00020\u000FH\u0000¢\u0006\u0002\b\u0016J\r\u0010\u0017\u001A\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019JK\u0010\u0017\u001A\u00020\u00182\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\b2\b\b\u0002\u0010\u001A\u001A\u00020\b2\b\b\u0002\u0010\u001B\u001A\u00020\bH\u0007¢\u0006\u0004\b\u001C\u0010\u001DJ\u001B\u0010\u001E\u001A\u00020\u0018*\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\bH\u0000¢\u0006\u0004\b\u001F\u0010 J\r\u0010!\u001A\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019JK\u0010!\u001A\u00020\u00182\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\b2\b\b\u0002\u0010\u001A\u001A\u00020\b2\b\b\u0002\u0010\u001B\u001A\u00020\bH\u0007¢\u0006\u0004\b\"\u0010\u001DJ\u0011\u0010#\u001A\u00020\u0018*\u00020\u000FH\u0000¢\u0006\u0002\b$J\r\u0010%\u001A\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J7\u0010%\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\bH\u0007¢\u0006\u0004\b&\u0010\rJ\r\u0010*\u001A\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019JK\u0010*\u001A\u00020\u00182\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\b2\b\b\u0002\u0010\u001A\u001A\u00020\b2\b\b\u0002\u0010\u001B\u001A\u00020\bH\u0007¢\u0006\u0004\b+\u0010\u001DJ\r\u0010/\u001A\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J7\u0010/\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\bH\u0007¢\u0006\u0004\b0\u0010\rJ\r\u00103\u001A\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019JK\u00103\u001A\u00020\u00182\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\b2\b\b\u0002\u0010\u001A\u001A\u00020\b2\b\b\u0002\u0010\u001B\u001A\u00020\bH\u0007¢\u0006\u0004\b4\u0010\u001DJ\r\u00107\u001A\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J7\u00107\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\bH\u0007¢\u0006\u0004\b8\u0010\rJ\u001B\u00109\u001A\u00020\u0005*\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\bH\u0000¢\u0006\u0004\b:\u0010\u0012J\r\u0010;\u001A\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J7\u0010;\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\bH\u0007¢\u0006\u0004\b<\u0010\rJ\u0011\u0010=\u001A\u00020\u0005*\u00020\u000FH\u0000¢\u0006\u0002\b>J\r\u0010?\u001A\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019JK\u0010?\u001A\u00020\u00182\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\b2\b\b\u0002\u0010\u001A\u001A\u00020\b2\b\b\u0002\u0010\u001B\u001A\u00020\bH\u0007¢\u0006\u0004\b@\u0010\u001DJ\u001B\u0010A\u001A\u00020\u0018*\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\bH\u0000¢\u0006\u0004\bB\u0010 J\r\u0010C\u001A\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019JK\u0010C\u001A\u00020\u00182\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\b2\b\b\u0002\u0010\u001A\u001A\u00020\b2\b\b\u0002\u0010\u001B\u001A\u00020\bH\u0007¢\u0006\u0004\bD\u0010\u001DJ\u0011\u0010E\u001A\u00020\u0018*\u00020\u000FH\u0000¢\u0006\u0002\bFJ\u001F\u0010G\u001A\u0004\u0018\u00010H2\u0006\u0010I\u001A\u00020J2\u0006\u0010K\u001A\u00020JH\u0007¢\u0006\u0002\u0010LJ\u001F\u0010M\u001A\u0004\u0018\u00010H2\u0006\u0010I\u001A\u00020J2\u0006\u0010K\u001A\u00020JH\u0007¢\u0006\u0002\u0010LJ\u0015\u0010N\u001A\u00020H2\u0006\u0010I\u001A\u00020JH\u0007¢\u0006\u0002\u0010OJ\u0015\u0010P\u001A\u00020H2\u0006\u0010I\u001A\u00020JH\u0007¢\u0006\u0002\u0010OJ\u0019\u0010Y\u001A\u00020Z2\b\b\u0002\u0010[\u001A\u00020\\H\u0000¢\u0006\u0004\b]\u0010^R\u0018\u0010\'\u001A\u00020\u0005*\u00020\u000F8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b(\u0010)R\u0018\u0010,\u001A\u00020\u0018*\u00020\u000F8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b-\u0010.R\u0018\u00101\u001A\u00020\u0005*\u00020\u000F8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b2\u0010)R\u0018\u00105\u001A\u00020\u0018*\u00020\u000F8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b6\u0010.R\u0011\u0010Q\u001A\u00020R8G¢\u0006\u0006\u001A\u0004\bS\u0010TR\u0011\u0010U\u001A\u00020R8G¢\u0006\u0006\u001A\u0004\bV\u0010TR\u0011\u0010W\u001A\u00020R8G¢\u0006\u0006\u001A\u0004\bX\u0010T¨\u0006`"}, d2={"Landroidx/compose/material3/IconButtonDefaults;", "", "<init>", "()V", "iconButtonColors", "Landroidx/compose/material3/IconButtonColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/IconButtonColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "iconButtonColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/IconButtonColors;", "defaultIconButtonColors", "Landroidx/compose/material3/ColorScheme;", "localContentColor", "defaultIconButtonColors-4WTKRHQ$material3", "(Landroidx/compose/material3/ColorScheme;J)Landroidx/compose/material3/IconButtonColors;", "iconButtonVibrantColors", "iconButtonVibrantColors-ro_MJ88", "defaultIconButtonVibrantColors", "defaultIconButtonVibrantColors$material3", "iconToggleButtonColors", "Landroidx/compose/material3/IconToggleButtonColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/IconToggleButtonColors;", "checkedContainerColor", "checkedContentColor", "iconToggleButtonColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/IconToggleButtonColors;", "defaultIconToggleButtonColors", "defaultIconToggleButtonColors-4WTKRHQ$material3", "(Landroidx/compose/material3/ColorScheme;J)Landroidx/compose/material3/IconToggleButtonColors;", "iconToggleButtonVibrantColors", "iconToggleButtonVibrantColors-5tl4gsc", "defaultIconToggleButtonVibrantColors", "defaultIconToggleButtonVibrantColors$material3", "filledIconButtonColors", "filledIconButtonColors-ro_MJ88", "defaultFilledIconButtonColors", "getDefaultFilledIconButtonColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/IconButtonColors;", "filledIconToggleButtonColors", "filledIconToggleButtonColors-5tl4gsc", "defaultFilledIconToggleButtonColors", "getDefaultFilledIconToggleButtonColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/IconToggleButtonColors;", "filledTonalIconButtonColors", "filledTonalIconButtonColors-ro_MJ88", "defaultFilledTonalIconButtonColors", "getDefaultFilledTonalIconButtonColors$material3", "filledTonalIconToggleButtonColors", "filledTonalIconToggleButtonColors-5tl4gsc", "defaultFilledTonalIconToggleButtonColors", "getDefaultFilledTonalIconToggleButtonColors$material3", "outlinedIconButtonColors", "outlinedIconButtonColors-ro_MJ88", "defaultOutlinedIconButtonColors", "defaultOutlinedIconButtonColors-4WTKRHQ$material3", "outlinedIconButtonVibrantColors", "outlinedIconButtonVibrantColors-ro_MJ88", "defaultOutlinedIconButtonVibrantColors", "defaultOutlinedIconButtonVibrantColors$material3", "outlinedIconToggleButtonColors", "outlinedIconToggleButtonColors-5tl4gsc", "defaultOutlinedIconToggleButtonColors", "defaultOutlinedIconToggleButtonColors-4WTKRHQ$material3", "outlinedIconToggleButtonVibrantColors", "outlinedIconToggleButtonVibrantColors-5tl4gsc", "defaultOutlinedIconToggleButtonVibrantColors", "defaultOutlinedIconToggleButtonVibrantColors$material3", "outlinedIconToggleButtonBorder", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "checked", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "outlinedIconToggleButtonVibrantBorder", "outlinedIconButtonBorder", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "outlinedIconButtonVibrantBorder", "standardShape", "Landroidx/compose/ui/graphics/Shape;", "getStandardShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "filledShape", "getFilledShape", "outlinedShape", "getOutlinedShape", "smallContainerSize", "Landroidx/compose/ui/unit/DpSize;", "widthOption", "Landroidx/compose/material3/IconButtonDefaults$IconButtonWidthOption;", "smallContainerSize-N-wlBFI$material3", "(I)J", "IconButtonWidthOption", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class IconButtonDefaults {
    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000E2\u00020\u0001:\u0001\u000EB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0006\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001A\u00020\u0003HÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000F"}, d2={"Landroidx/compose/material3/IconButtonDefaults$IconButtonWidthOption;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class IconButtonWidthOption {
        @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007¨\u0006\r"}, d2={"Landroidx/compose/material3/IconButtonDefaults$IconButtonWidthOption$Companion;", "", "<init>", "()V", "Narrow", "Landroidx/compose/material3/IconButtonDefaults$IconButtonWidthOption;", "getNarrow-rc6NtMs", "()I", "I", "Uniform", "getUniform-rc6NtMs", "Wide", "getWide-rc6NtMs", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
            public Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private Companion() {
                super();
            }

            public final int getNarrow-rc6NtMs() {
                return IconButtonWidthOption.Narrow;
            }

            public final int getUniform-rc6NtMs() {
                return IconButtonWidthOption.Uniform;
            }

            public final int getWide-rc6NtMs() {
                return IconButtonWidthOption.Wide;
            }
        }

        public static final Companion Companion;
        private static final int Narrow;
        private static final int Uniform;
        private static final int Wide;
        private final int value;

        static {
            IconButtonWidthOption.Companion = new Companion(null);
            IconButtonWidthOption.Narrow = IconButtonWidthOption.constructor-impl(0);
            IconButtonWidthOption.Uniform = IconButtonWidthOption.constructor-impl(1);
            IconButtonWidthOption.Wide = IconButtonWidthOption.constructor-impl(2);
        }

        private IconButtonWidthOption(int arg1) {
            super();
            this.value = arg1;
        }

        public static final int access$getNarrow$cp() {
            return IconButtonWidthOption.Narrow;
        }

        public static final int access$getUniform$cp() {
            return IconButtonWidthOption.Uniform;
        }

        public static final int access$getWide$cp() {
            return IconButtonWidthOption.Wide;
        }

        public static final IconButtonWidthOption box-impl(int arg1) {
            return new IconButtonWidthOption(arg1);
        }

        private static int constructor-impl(int arg0) {
            return arg0;
        }

        public boolean equals(Object arg1) {
            return IconButtonWidthOption.equals-impl(this.value, arg1);
        }

        public static boolean equals-impl(int arg2, Object arg3) {
            if(!(arg3 instanceof IconButtonWidthOption)) {
                return 0;
            }

            if(arg2 != ((IconButtonWidthOption)arg3).unbox-impl()) {
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
            return IconButtonWidthOption.hashCode-impl(this.value);
        }

        public static int hashCode-impl(int arg0) {
            return Integer.hashCode(arg0);
        }

        public String toString() {
            return IconButtonWidthOption.toString-impl(this.value);
        }

        public static String toString-impl(int arg1) {
            if(IconButtonWidthOption.equals-impl0(arg1, IconButtonWidthOption.Narrow)) {
                return "Narrow";
            }

            if(IconButtonWidthOption.equals-impl0(arg1, IconButtonWidthOption.Uniform)) {
                return "Uniform";
            }

            if(IconButtonWidthOption.equals-impl0(arg1, IconButtonWidthOption.Wide)) {
                return "Wide";
            }

            return "Unknown";
        }

        public final int unbox-impl() {
            return this.value;
        }
    }

    public static final int $stable;
    public static final IconButtonDefaults INSTANCE;

    static {
        IconButtonDefaults.INSTANCE = new IconButtonDefaults();
    }

    private IconButtonDefaults() {
        super();
    }

    public final IconButtonColors defaultIconButtonColors-4WTKRHQ$material3(ColorScheme arg17, long arg18) {
        IconButtonColors v0 = arg17.getDefaultIconButtonColorsCached$material3();
        if(v0 == null) {
            IconButtonColors v1 = new IconButtonColors(Color.Companion.getTransparent-0d7_KjU(), arg18, Color.Companion.getTransparent-0d7_KjU(), Color.copy-wmQWz5c$default(arg18, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0f, 0f, 0f, 14, null), null);
            arg17.setDefaultIconButtonColorsCached$material3(v1);
            return v1;
        }

        return v0;
    }

    public final IconButtonColors defaultIconButtonVibrantColors$material3(ColorScheme arg18) {
        ColorScheme v0 = arg18;
        IconButtonColors v1 = v0.getDefaultIconButtonVibrantColorsCached$material3();
        if(v1 == null) {
            IconButtonColors v2 = new IconButtonColors(Color.Companion.getTransparent-0d7_KjU(), ColorSchemeKt.fromToken(v0, StandardIconButtonTokens.INSTANCE.getColor()), Color.Companion.getTransparent-0d7_KjU(), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, StandardIconButtonTokens.INSTANCE.getDisabledColor()), StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0f, 0f, 0f, 14, null), null);
            v0.setDefaultIconButtonVibrantColorsCached$material3(v2);
            return v2;
        }

        return v1;
    }

    public final IconToggleButtonColors defaultIconToggleButtonColors-4WTKRHQ$material3(ColorScheme arg18, long arg19) {
        ColorScheme v0 = arg18;
        IconToggleButtonColors v1 = v0.getDefaultIconToggleButtonColorsCached$material3();
        if(v1 == null) {
            IconToggleButtonColors v2 = new IconToggleButtonColors(Color.Companion.getTransparent-0d7_KjU(), arg19, Color.Companion.getTransparent-0d7_KjU(), Color.copy-wmQWz5c$default(arg19, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0f, 0f, 0f, 14, null), Color.Companion.getTransparent-0d7_KjU(), ColorSchemeKt.fromToken(v0, StandardIconButtonTokens.INSTANCE.getSelectedColor()), null);
            v0.setDefaultIconToggleButtonColorsCached$material3(v2);
            return v2;
        }

        return v1;
    }

    public final IconToggleButtonColors defaultIconToggleButtonVibrantColors$material3(ColorScheme arg18) {
        ColorScheme v0 = arg18;
        IconToggleButtonColors v1 = v0.getDefaultIconToggleButtonVibrantColorsCached$material3();
        if(v1 == null) {
            IconToggleButtonColors v2 = new IconToggleButtonColors(Color.Companion.getTransparent-0d7_KjU(), ColorSchemeKt.fromToken(v0, StandardIconButtonTokens.INSTANCE.getUnselectedColor()), Color.Companion.getTransparent-0d7_KjU(), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, StandardIconButtonTokens.INSTANCE.getDisabledColor()), StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0f, 0f, 0f, 14, null), Color.Companion.getTransparent-0d7_KjU(), ColorSchemeKt.fromToken(v0, StandardIconButtonTokens.INSTANCE.getSelectedColor()), null);
            v0.setDefaultIconToggleButtonVibrantColorsCached$material3(v2);
            return v2;
        }

        return v1;
    }

    public final IconButtonColors defaultOutlinedIconButtonColors-4WTKRHQ$material3(ColorScheme arg17, long arg18) {
        IconButtonColors v0 = arg17.getDefaultOutlinedIconButtonColorsCached$material3();
        if(v0 == null) {
            IconButtonColors v1 = new IconButtonColors(Color.Companion.getTransparent-0d7_KjU(), arg18, Color.Companion.getTransparent-0d7_KjU(), Color.copy-wmQWz5c$default(arg18, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0f, 0f, 0f, 14, null), null);
            arg17.setDefaultOutlinedIconButtonColorsCached$material3(v1);
            return v1;
        }

        return v0;
    }

    public final IconButtonColors defaultOutlinedIconButtonVibrantColors$material3(ColorScheme arg18) {
        ColorScheme v0 = arg18;
        IconButtonColors v1 = v0.getDefaultOutlinedIconButtonVibrantColorsCached$material3();
        if(v1 == null) {
            IconButtonColors v2 = new IconButtonColors(Color.Companion.getTransparent-0d7_KjU(), ColorSchemeKt.fromToken(v0, OutlinedIconButtonTokens.INSTANCE.getColor()), Color.Companion.getTransparent-0d7_KjU(), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, OutlinedIconButtonTokens.INSTANCE.getDisabledColor()), OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0f, 0f, 0f, 14, null), null);
            v0.setDefaultOutlinedIconButtonVibrantColorsCached$material3(v2);
            return v2;
        }

        return v1;
    }

    public final IconToggleButtonColors defaultOutlinedIconToggleButtonColors-4WTKRHQ$material3(ColorScheme arg18, long arg19) {
        ColorScheme v0 = arg18;
        IconToggleButtonColors v1 = v0.getDefaultIconToggleButtonColorsCached$material3();
        if(v1 == null) {
            IconToggleButtonColors v2 = new IconToggleButtonColors(Color.Companion.getTransparent-0d7_KjU(), arg19, Color.Companion.getTransparent-0d7_KjU(), Color.copy-wmQWz5c$default(arg19, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0f, 0f, 0f, 14, null), ColorSchemeKt.fromToken(v0, OutlinedIconButtonTokens.INSTANCE.getSelectedContainerColor()), ColorSchemeKt.contentColorFor-4WTKRHQ(v0, ColorSchemeKt.fromToken(v0, OutlinedIconButtonTokens.INSTANCE.getSelectedContainerColor())), null);
            v0.setDefaultOutlinedIconToggleButtonColorsCached$material3(v2);
            return v2;
        }

        return v1;
    }

    public final IconToggleButtonColors defaultOutlinedIconToggleButtonVibrantColors$material3(ColorScheme arg18) {
        ColorScheme v0 = arg18;
        IconToggleButtonColors v1 = v0.getDefaultOutlinedIconToggleButtonVibrantColorsCached$material3();
        if(v1 == null) {
            IconToggleButtonColors v2 = new IconToggleButtonColors(Color.Companion.getTransparent-0d7_KjU(), ColorSchemeKt.fromToken(v0, OutlinedIconButtonTokens.INSTANCE.getUnselectedColor()), Color.Companion.getTransparent-0d7_KjU(), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, OutlinedIconButtonTokens.INSTANCE.getDisabledColor()), OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0f, 0f, 0f, 14, null), ColorSchemeKt.fromToken(v0, OutlinedIconButtonTokens.INSTANCE.getSelectedContainerColor()), ColorSchemeKt.fromToken(v0, OutlinedIconButtonTokens.INSTANCE.getSelectedColor()), null);
            v0.setDefaultOutlinedIconToggleButtonColorsCached$material3(v2);
            return v2;
        }

        return v1;
    }

    public final IconButtonColors filledIconButtonColors(Composer arg4, int arg5) {
        int v1 = 0xC6E16FF7;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(filledIconButtonColors)300@13760L11:IconButtonDefaults.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.IconButtonDefaults.filledIconButtonColors (IconButtonDefaults.kt:300)");
        }

        IconButtonColors v3 = this.getDefaultFilledIconButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final IconButtonColors filledIconButtonColors-ro_MJ88(long arg14, long arg16, long arg18, long arg20, Composer arg22, int arg23, int arg24) {
        Composer v0 = arg22;
        int v1 = arg23;
        int v3 = -245481051;
        ComposerKt.sourceInformationMarkerStart(v0, v3, "C(filledIconButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)313@14404L31,317@14601L11:IconButtonDefaults.kt#uh7d8r");
        if((arg24 & 1) != 0) {
            arg14 = Color.Companion.getUnspecified-0d7_KjU();
        }

        long v5 = arg14;
        long v7 = (arg24 & 2) != 0 ? ColorSchemeKt.contentColorFor-ek8zF_U(v5, v0, v1 & 14) : arg16;
        long v9 = (arg24 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg18;
        long v11 = (arg24 & 8) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg20;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v3, v1, -1, "androidx.compose.material3.IconButtonDefaults.filledIconButtonColors (IconButtonDefaults.kt:317)");
        }

        IconButtonColors v13 = this.getDefaultFilledIconButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6)).copy-jRlVdoo(v5, v7, v9, v11);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v13;
    }

    public final IconToggleButtonColors filledIconToggleButtonColors(Composer arg4, int arg5) {
        int v1 = 0xA944028F;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(filledIconToggleButtonColors)346@16003L11:IconButtonDefaults.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.IconButtonDefaults.filledIconToggleButtonColors (IconButtonDefaults.kt:346)");
        }

        IconToggleButtonColors v3 = this.getDefaultFilledIconToggleButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final IconToggleButtonColors filledIconToggleButtonColors-5tl4gsc(long arg17, long arg19, long arg21, long arg23, long arg25, long arg27, Composer arg29, int arg30, int arg31) {
        Composer v0 = arg29;
        int v1 = arg30;
        int v3 = 0x57D0AA93;
        ComposerKt.sourceInformationMarkerStart(v0, v3, "C(filledIconToggleButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color,checkedContainerColor:c#ui.graphics.Color,checkedContentColor:c#ui.graphics.Color)368@17217L38,370@17311L11:IconButtonDefaults.kt#uh7d8r");
        long v4 = (arg31 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg17;
        long v6 = (arg31 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg19;
        long v8 = (arg31 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg21;
        long v10 = (arg31 & 8) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg23;
        long v12 = (arg31 & 16) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg25;
        long v14 = (arg31 & 0x20) != 0 ? ColorSchemeKt.contentColorFor-ek8zF_U(v12, v0, v1 >> 12 & 14) : arg27;
        if(ComposerKt.isTraceInProgress()) {
            arg17 = v4;
            ComposerKt.traceEventStart(v3, v1, -1, "androidx.compose.material3.IconButtonDefaults.filledIconToggleButtonColors (IconButtonDefaults.kt:370)");
        }
        else {
            arg17 = v4;
        }

        IconToggleButtonColors v1_1 = this.getDefaultFilledIconToggleButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6)).copy-tNS2XkQ(arg17, v6, v8, v10, v12, v14);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v1_1;
    }

    public final IconButtonColors filledTonalIconButtonColors(Composer arg4, int arg5) {
        int v1 = 0x443F5AF9;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(filledTonalIconButtonColors)407@19290L11:IconButtonDefaults.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconButtonColors (IconButtonDefaults.kt:407)");
        }

        IconButtonColors v3 = this.getDefaultFilledTonalIconButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final IconButtonColors filledTonalIconButtonColors-ro_MJ88(long arg14, long arg16, long arg18, long arg20, Composer arg22, int arg23, int arg24) {
        Composer v0 = arg22;
        int v1 = arg23;
        int v3 = 0x218B1463;
        ComposerKt.sourceInformationMarkerStart(v0, v3, "C(filledTonalIconButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)421@19956L31,425@20153L11:IconButtonDefaults.kt#uh7d8r");
        if((arg24 & 1) != 0) {
            arg14 = Color.Companion.getUnspecified-0d7_KjU();
        }

        long v5 = arg14;
        long v7 = (arg24 & 2) != 0 ? ColorSchemeKt.contentColorFor-ek8zF_U(v5, v0, v1 & 14) : arg16;
        long v9 = (arg24 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg18;
        long v11 = (arg24 & 8) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg20;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v3, v1, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconButtonColors (IconButtonDefaults.kt:425)");
        }

        IconButtonColors v13 = this.getDefaultFilledTonalIconButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6)).copy-jRlVdoo(v5, v7, v9, v11);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v13;
    }

    public final IconToggleButtonColors filledTonalIconToggleButtonColors(Composer arg4, int arg5) {
        int v1 = 0x271F7A91;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(filledTonalIconToggleButtonColors)454@21615L11:IconButtonDefaults.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconToggleButtonColors (IconButtonDefaults.kt:454)");
        }

        IconToggleButtonColors v3 = this.getDefaultFilledTonalIconToggleButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final IconToggleButtonColors filledTonalIconToggleButtonColors-5tl4gsc(long arg17, long arg19, long arg21, long arg23, long arg25, long arg27, Composer arg29, int arg30, int arg31) {
        Composer v0 = arg29;
        int v1 = arg30;
        int v3 = 0x7F00A351;
        ComposerKt.sourceInformationMarkerStart(v0, v3, "C(filledTonalIconToggleButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color,checkedContainerColor:c#ui.graphics.Color,checkedContentColor:c#ui.graphics.Color)470@22481L31,474@22725L38,476@22819L11:IconButtonDefaults.kt#uh7d8r");
        long v4 = (arg31 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg17;
        long v6 = (arg31 & 2) != 0 ? ColorSchemeKt.contentColorFor-ek8zF_U(v4, v0, v1 & 14) : arg19;
        long v8 = (arg31 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg21;
        long v10 = (arg31 & 8) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg23;
        long v12 = (arg31 & 16) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg25;
        long v14 = (arg31 & 0x20) != 0 ? ColorSchemeKt.contentColorFor-ek8zF_U(v12, v0, v1 >> 12 & 14) : arg27;
        if(ComposerKt.isTraceInProgress()) {
            arg17 = v4;
            ComposerKt.traceEventStart(v3, v1, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconToggleButtonColors (IconButtonDefaults.kt:476)");
        }
        else {
            arg17 = v4;
        }

        IconToggleButtonColors v1_1 = this.getDefaultFilledTonalIconToggleButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6)).copy-tNS2XkQ(arg17, v6, v8, v10, v12, v14);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v1_1;
    }

    public final IconButtonColors getDefaultFilledIconButtonColors$material3(ColorScheme arg18) {
        ColorScheme v0 = arg18;
        IconButtonColors v1 = v0.getDefaultFilledIconButtonColorsCached$material3();
        if(v1 == null) {
            IconButtonColors v2 = new IconButtonColors(ColorSchemeKt.fromToken(v0, FilledIconButtonTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(v0, FilledIconButtonTokens.INSTANCE.getColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, FilledIconButtonTokens.INSTANCE.getDisabledContainerColor()), FilledIconButtonTokens.INSTANCE.getDisabledContainerOpacity(), 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, FilledIconButtonTokens.INSTANCE.getDisabledColor()), FilledIconButtonTokens.INSTANCE.getDisabledOpacity(), 0f, 0f, 0f, 14, null), null);
            v0.setDefaultFilledIconButtonColorsCached$material3(v2);
            return v2;
        }

        return v1;
    }

    public final IconToggleButtonColors getDefaultFilledIconToggleButtonColors$material3(ColorScheme arg18) {
        ColorScheme v0 = arg18;
        IconToggleButtonColors v1 = v0.getDefaultFilledIconToggleButtonColorsCached$material3();
        if(v1 == null) {
            IconToggleButtonColors v2 = new IconToggleButtonColors(ColorSchemeKt.fromToken(v0, FilledIconButtonTokens.INSTANCE.getUnselectedContainerColor()), ColorSchemeKt.fromToken(v0, FilledIconButtonTokens.INSTANCE.getUnselectedColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, FilledIconButtonTokens.INSTANCE.getDisabledContainerColor()), FilledIconButtonTokens.INSTANCE.getDisabledContainerOpacity(), 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, FilledIconButtonTokens.INSTANCE.getDisabledColor()), FilledIconButtonTokens.INSTANCE.getDisabledOpacity(), 0f, 0f, 0f, 14, null), ColorSchemeKt.fromToken(v0, FilledIconButtonTokens.INSTANCE.getSelectedContainerColor()), ColorSchemeKt.fromToken(v0, FilledIconButtonTokens.INSTANCE.getSelectedColor()), null);
            v0.setDefaultFilledIconToggleButtonColorsCached$material3(v2);
            return v2;
        }

        return v1;
    }

    public final IconButtonColors getDefaultFilledTonalIconButtonColors$material3(ColorScheme arg18) {
        ColorScheme v0 = arg18;
        IconButtonColors v1 = v0.getDefaultFilledTonalIconButtonColorsCached$material3();
        if(v1 == null) {
            IconButtonColors v2 = new IconButtonColors(ColorSchemeKt.fromToken(v0, FilledTonalIconButtonTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(v0, FilledTonalIconButtonTokens.INSTANCE.getColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, FilledTonalIconButtonTokens.INSTANCE.getDisabledContainerColor()), FilledTonalIconButtonTokens.INSTANCE.getDisabledContainerOpacity(), 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, FilledTonalIconButtonTokens.INSTANCE.getDisabledColor()), FilledTonalIconButtonTokens.INSTANCE.getDisabledOpacity(), 0f, 0f, 0f, 14, null), null);
            v0.setDefaultFilledTonalIconButtonColorsCached$material3(v2);
            return v2;
        }

        return v1;
    }

    public final IconToggleButtonColors getDefaultFilledTonalIconToggleButtonColors$material3(ColorScheme arg18) {
        ColorScheme v0 = arg18;
        IconToggleButtonColors v1 = v0.getDefaultFilledTonalIconToggleButtonColorsCached$material3();
        if(v1 == null) {
            IconToggleButtonColors v2 = new IconToggleButtonColors(ColorSchemeKt.fromToken(v0, FilledTonalIconButtonTokens.INSTANCE.getUnselectedContainerColor()), ColorSchemeKt.fromToken(v0, FilledTonalIconButtonTokens.INSTANCE.getUnselectedColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, FilledTonalIconButtonTokens.INSTANCE.getDisabledContainerColor()), FilledTonalIconButtonTokens.INSTANCE.getDisabledContainerOpacity(), 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, FilledTonalIconButtonTokens.INSTANCE.getDisabledColor()), FilledTonalIconButtonTokens.INSTANCE.getDisabledOpacity(), 0f, 0f, 0f, 14, null), ColorSchemeKt.fromToken(v0, FilledTonalIconButtonTokens.INSTANCE.getSelectedContainerColor()), ColorSchemeKt.fromToken(v0, FilledTonalIconButtonTokens.INSTANCE.getSelectedColor()), null);
            v0.setDefaultFilledTonalIconToggleButtonColorsCached$material3(v2);
            return v2;
        }

        return v1;
    }

    public final Shape getFilledShape(Composer arg3, int arg4) {
        int v0 = 0x5BF53325;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-filledShape>)853@40101L5:IconButtonDefaults.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.IconButtonDefaults.<get-filledShape> (IconButtonDefaults.kt:853)");
        }

        Shape v2 = ShapesKt.getValue(SmallIconButtonTokens.INSTANCE.getContainerShapeRound(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public final Shape getOutlinedShape(Composer arg3, int arg4) {
        int v0 = 0x9A4B1065;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-outlinedShape>)857@40261L5:IconButtonDefaults.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.IconButtonDefaults.<get-outlinedShape> (IconButtonDefaults.kt:857)");
        }

        Shape v2 = ShapesKt.getValue(SmallIconButtonTokens.INSTANCE.getContainerShapeRound(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public final Shape getStandardShape(Composer arg3, int arg4) {
        int v0 = -377108005;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-standardShape>)849@39946L5:IconButtonDefaults.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.IconButtonDefaults.<get-standardShape> (IconButtonDefaults.kt:849)");
        }

        Shape v2 = ShapesKt.getValue(SmallIconButtonTokens.INSTANCE.getContainerShapeRound(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public final IconButtonColors iconButtonColors(Composer arg12, int arg13) {
        int v1 = -1037266503;
        ComposerKt.sourceInformationMarkerStart(arg12, v1, "C(iconButtonColors)43@1790L7,44@1833L11:IconButtonDefaults.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg13, -1, "androidx.compose.material3.IconButtonDefaults.iconButtonColors (IconButtonDefaults.kt:42)");
        }

        ProvidableCompositionLocal v13 = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(arg12, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v13_1 = arg12.consume(((CompositionLocal)v13));
        ComposerKt.sourceInformationMarkerEnd(arg12);
        long v0 = ((Color)v13_1).unbox-impl();
        IconButtonColors v11 = this.defaultIconButtonColors-4WTKRHQ$material3(MaterialTheme.INSTANCE.getColorScheme(arg12, 6), v0);
        if(Color.equals-impl0(v11.getContentColor-0d7_KjU(), v0)) {
        }
        else {
            v11 = IconButtonColors.copy-jRlVdoo$default(v11, 0, v0, 0, Color.copy-wmQWz5c$default(v0, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0f, 0f, 0f, 14, null), 5, null);
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg12);
        return v11;
    }

    public final IconButtonColors iconButtonColors-ro_MJ88(long arg17, long arg19, long arg21, long arg23, Composer arg25, int arg26, int arg27) {
        long v11;
        long v7;
        Composer v0 = arg25;
        int v2 = -1639168605;
        ComposerKt.sourceInformationMarkerStart(v0, v2, "C(iconButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)73@3133L7,78@3368L11,79@3435L7:IconButtonDefaults.kt#uh7d8r");
        long v3 = (arg27 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg17;
        String v5 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
        int v6 = 0x789C5F52;
        if((arg27 & 2) != 0) {
            ProvidableCompositionLocal v1 = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(v0, v6, v5);
            Object v1_1 = v0.consume(((CompositionLocal)v1));
            ComposerKt.sourceInformationMarkerEnd(v0);
            v7 = ((Color)v1_1).unbox-impl();
        }
        else {
            v7 = arg19;
        }

        long v9 = (arg27 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg21;
        if((arg27 & 8) != 0) {
            arg17 = v7;
            v7 = Color.copy-wmQWz5c$default(arg17, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0f, 0f, 0f, 14, null);
            v11 = arg17;
        }
        else {
            v11 = v7;
            v7 = arg23;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, arg26, -1, "androidx.compose.material3.IconButtonDefaults.iconButtonColors (IconButtonDefaults.kt:78)");
        }

        ColorScheme v1_2 = MaterialTheme.INSTANCE.getColorScheme(v0, 6);
        ProvidableCompositionLocal v2_1 = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(v0, v6, v5);
        Object v2_2 = v0.consume(((CompositionLocal)v2_1));
        ComposerKt.sourceInformationMarkerEnd(v0);
        IconButtonColors v1_3 = this.defaultIconButtonColors-4WTKRHQ$material3(v1_2, ((Color)v2_2).unbox-impl()).copy-jRlVdoo(v3, v11, v9, v7);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v1_3;
    }

    public final IconButtonColors iconButtonVibrantColors(Composer arg4, int arg5) {
        int v1 = 0x6A4A827;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(iconButtonVibrantColors)110@4699L11:IconButtonDefaults.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.IconButtonDefaults.iconButtonVibrantColors (IconButtonDefaults.kt:110)");
        }

        IconButtonColors v3 = this.defaultIconButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final IconButtonColors iconButtonVibrantColors-ro_MJ88(long arg15, long arg17, long arg19, long arg21, Composer arg23, int arg24, int arg25) {
        long v9;
        Composer v0 = arg23;
        int v2 = 1036440437;
        ComposerKt.sourceInformationMarkerStart(v0, v2, "C(iconButtonVibrantColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)132@5742L11:IconButtonDefaults.kt#uh7d8r");
        long v3 = (arg25 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg15;
        long v5 = (arg25 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg17;
        long v7 = (arg25 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg19;
        if((arg25 & 8) != 0) {
            arg15 = v5;
            v5 = Color.copy-wmQWz5c$default(arg15, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0f, 0f, 0f, 14, null);
            v9 = arg15;
        }
        else {
            v9 = v5;
            v5 = arg21;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, arg24, -1, "androidx.compose.material3.IconButtonDefaults.iconButtonVibrantColors (IconButtonDefaults.kt:132)");
        }

        IconButtonColors v14 = this.defaultIconButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6)).copy-jRlVdoo(v3, v9, v7, v5);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v14;
    }

    public final IconToggleButtonColors iconToggleButtonColors(Composer arg18, int arg19) {
        Composer v0 = arg18;
        int v1 = 0xAF309151;
        v0.startReplaceGroup(v1);
        ComposerKt.sourceInformation(v0, "C(iconToggleButtonColors)165@7229L7,166@7272L11:IconButtonDefaults.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg19, -1, "androidx.compose.material3.IconButtonDefaults.iconToggleButtonColors (IconButtonDefaults.kt:164)");
        }

        ProvidableCompositionLocal v1_1 = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(v0, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v1_2 = v0.consume(((CompositionLocal)v1_1));
        ComposerKt.sourceInformationMarkerEnd(v0);
        long v2 = ((Color)v1_2).unbox-impl();
        IconToggleButtonColors v1_3 = this.defaultIconToggleButtonColors-4WTKRHQ$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6), v2);
        if(Color.equals-impl0(v1_3.getContentColor-0d7_KjU(), v2)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v0.endReplaceGroup();
            return v1_3;
        }

        v1_3 = IconToggleButtonColors.copy-tNS2XkQ$default(v1_3, 0, v2, 0, Color.copy-wmQWz5c$default(v2, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0f, 0f, 0f, 14, null), 0, 0, 53, null);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        v0.endReplaceGroup();
        return v1_3;
    }

    public final IconToggleButtonColors iconToggleButtonColors-5tl4gsc(long arg20, long arg22, long arg24, long arg26, long arg28, long arg30, Composer arg32, int arg33, int arg34) {
        long v17;
        long v11;
        long v7;
        Composer v0 = arg32;
        int v2 = 1402082449;
        ComposerKt.sourceInformationMarkerStart(v0, v2, "C(iconToggleButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color,checkedContainerColor:c#ui.graphics.Color,checkedContentColor:c#ui.graphics.Color)196@8713L7,203@9068L11,204@9141L7:IconButtonDefaults.kt#uh7d8r");
        long v3 = (arg34 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg20;
        String v5 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
        int v6 = 0x789C5F52;
        if((arg34 & 2) != 0) {
            ProvidableCompositionLocal v1 = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(v0, v6, v5);
            Object v1_1 = v0.consume(((CompositionLocal)v1));
            ComposerKt.sourceInformationMarkerEnd(v0);
            v7 = ((Color)v1_1).unbox-impl();
        }
        else {
            v7 = arg22;
        }

        long v9 = (arg34 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg24;
        if((arg34 & 8) != 0) {
            arg20 = v7;
            v7 = Color.copy-wmQWz5c$default(arg20, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0f, 0f, 0f, 14, null);
            v11 = arg20;
        }
        else {
            v11 = v7;
            v7 = arg26;
        }

        long v13 = (arg34 & 16) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg28;
        long v15 = (arg34 & 0x20) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg30;
        if(ComposerKt.isTraceInProgress()) {
            v17 = v3;
            ComposerKt.traceEventStart(v2, arg33, -1, "androidx.compose.material3.IconButtonDefaults.iconToggleButtonColors (IconButtonDefaults.kt:203)");
        }
        else {
            v17 = v3;
        }

        ColorScheme v1_2 = MaterialTheme.INSTANCE.getColorScheme(v0, 6);
        ProvidableCompositionLocal v2_1 = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(v0, 0x789C5F52, v5);
        Object v2_2 = v0.consume(((CompositionLocal)v2_1));
        ComposerKt.sourceInformationMarkerEnd(v0);
        IconToggleButtonColors v1_3 = this.defaultIconToggleButtonColors-4WTKRHQ$material3(v1_2, ((Color)v2_2).unbox-impl()).copy-tNS2XkQ(v17, v11, v9, v7, v13, v15);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v1_3;
    }

    public final IconToggleButtonColors iconToggleButtonVibrantColors(Composer arg4, int arg5) {
        int v1 = 1755001127;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(iconToggleButtonVibrantColors)241@10812L11:IconButtonDefaults.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.IconButtonDefaults.iconToggleButtonVibrantColors (IconButtonDefaults.kt:241)");
        }

        IconToggleButtonColors v3 = this.defaultIconToggleButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final IconToggleButtonColors iconToggleButtonVibrantColors-5tl4gsc(long arg17, long arg19, long arg21, long arg23, long arg25, long arg27, Composer arg29, int arg30, int arg31) {
        long v9;
        Composer v0 = arg29;
        int v2 = 0xC2C434FB;
        ComposerKt.sourceInformationMarkerStart(v0, v2, "C(iconToggleButtonVibrantColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color,checkedContainerColor:c#ui.graphics.Color,checkedContentColor:c#ui.graphics.Color)267@12180L11:IconButtonDefaults.kt#uh7d8r");
        long v3 = (arg31 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg17;
        long v5 = (arg31 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg19;
        long v7 = (arg31 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg21;
        if((arg31 & 8) != 0) {
            arg17 = v5;
            v5 = Color.copy-wmQWz5c$default(arg17, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0f, 0f, 0f, 14, null);
            v9 = arg17;
        }
        else {
            v9 = v5;
            v5 = arg23;
        }

        long v11 = (arg31 & 16) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg25;
        long v13 = (arg31 & 0x20) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg27;
        if(ComposerKt.isTraceInProgress()) {
            arg17 = v3;
            ComposerKt.traceEventStart(v2, arg30, -1, "androidx.compose.material3.IconButtonDefaults.iconToggleButtonVibrantColors (IconButtonDefaults.kt:267)");
        }
        else {
            arg17 = v3;
        }

        IconToggleButtonColors v1 = this.defaultIconToggleButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6)).copy-tNS2XkQ(arg17, v9, v7, v5, v11, v13);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v1;
    }

    public final BorderStroke outlinedIconButtonBorder(boolean arg9, Composer arg10, int arg11) {
        int v0 = -1270640488;
        ComposerKt.sourceInformationMarkerStart(arg10, v0, "C(outlinedIconButtonBorder)N(enabled)819@38754L7,826@38979L83:IconButtonDefaults.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg11, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonBorder (IconButtonDefaults.kt:818)");
        }

        ProvidableCompositionLocal v8 = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(arg10, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v8_1 = arg10.consume(((CompositionLocal)v8));
        ComposerKt.sourceInformationMarkerEnd(arg10);
        long v0_1 = ((Color)v8_1).unbox-impl();
        if(arg9) {
        }
        else {
            v0_1 = Color.copy-wmQWz5c$default(v0_1, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0f, 0f, 0f, 14, null);
        }

        ComposerKt.sourceInformationMarkerStart(arg10, 0xB1A1F68B, "CC(remember):IconButtonDefaults.kt#9igjgp");
        boolean v8_2 = arg10.changed(v0_1);
        Object v9 = arg10.rememberedValue();
        if((v8_2) || v9 == Composer.Companion.getEmpty()) {
            BorderStroke v9_1 = BorderStrokeKt.BorderStroke-cXLIe8U(SmallIconButtonTokens.INSTANCE.getOutlinedOutlineWidth-D9Ej5fM(), v0_1);
            arg10.updateRememberedValue(v9_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg10);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg10);
        return ((BorderStroke)v9);
    }

    public final IconButtonColors outlinedIconButtonColors(Composer arg12, int arg13) {
        int v0 = 0x5EDA9877;
        arg12.startReplaceGroup(v0);
        ComposerKt.sourceInformation(arg12, "C(outlinedIconButtonColors)514@24910L7,515@24953L11:IconButtonDefaults.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg13, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonColors (IconButtonDefaults.kt:513)");
        }

        ProvidableCompositionLocal v13 = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(arg12, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v13_1 = arg12.consume(((CompositionLocal)v13));
        ComposerKt.sourceInformationMarkerEnd(arg12);
        long v0_1 = ((Color)v13_1).unbox-impl();
        IconButtonColors v11 = this.defaultOutlinedIconButtonColors-4WTKRHQ$material3(MaterialTheme.INSTANCE.getColorScheme(arg12, 6), v0_1);
        if(Color.equals-impl0(v11.getContentColor-0d7_KjU(), v0_1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            arg12.endReplaceGroup();
            return v11;
        }

        v11 = IconButtonColors.copy-jRlVdoo$default(v11, 0, v0_1, 0, Color.copy-wmQWz5c$default(v0_1, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0f, 0f, 0f, 14, null), 5, null);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        arg12.endReplaceGroup();
        return v11;
    }

    public final IconButtonColors outlinedIconButtonColors-ro_MJ88(long arg17, long arg19, long arg21, long arg23, Composer arg25, int arg26, int arg27) {
        long v11;
        long v7;
        Composer v0 = arg25;
        int v2 = 0xB05F8925;
        ComposerKt.sourceInformationMarkerStart(v0, v2, "C(outlinedIconButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)542@26100L7,547@26335L11,548@26410L7:IconButtonDefaults.kt#uh7d8r");
        long v3 = (arg27 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg17;
        String v5 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
        int v6 = 0x789C5F52;
        if((arg27 & 2) != 0) {
            ProvidableCompositionLocal v1 = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(v0, v6, v5);
            Object v1_1 = v0.consume(((CompositionLocal)v1));
            ComposerKt.sourceInformationMarkerEnd(v0);
            v7 = ((Color)v1_1).unbox-impl();
        }
        else {
            v7 = arg19;
        }

        long v9 = (arg27 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg21;
        if((arg27 & 8) != 0) {
            arg17 = v7;
            v7 = Color.copy-wmQWz5c$default(arg17, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0f, 0f, 0f, 14, null);
            v11 = arg17;
        }
        else {
            v11 = v7;
            v7 = arg23;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, arg26, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonColors (IconButtonDefaults.kt:547)");
        }

        ColorScheme v1_2 = MaterialTheme.INSTANCE.getColorScheme(v0, 6);
        ProvidableCompositionLocal v2_1 = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(v0, v6, v5);
        Object v2_2 = v0.consume(((CompositionLocal)v2_1));
        ComposerKt.sourceInformationMarkerEnd(v0);
        IconButtonColors v1_3 = this.defaultOutlinedIconButtonColors-4WTKRHQ$material3(v1_2, ((Color)v2_2).unbox-impl()).copy-jRlVdoo(v3, v11, v9, v7);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v1_3;
    }

    public final BorderStroke outlinedIconButtonVibrantBorder(boolean arg9, Composer arg10, int arg11) {
        int v0 = 0x80765426;
        ComposerKt.sourceInformationMarkerStart(arg10, v0, "C(outlinedIconButtonVibrantBorder)N(enabled)837@39473L5,844@39696L83:IconButtonDefaults.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg11, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonVibrantBorder (IconButtonDefaults.kt:836)");
        }

        long v0_1 = ColorSchemeKt.getValue(OutlinedIconButtonTokens.INSTANCE.getOutlineColor(), arg10, 6);
        if(arg9) {
        }
        else {
            v0_1 = Color.copy-wmQWz5c$default(v0_1, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0f, 0f, 0f, 14, null);
        }

        ComposerKt.sourceInformationMarkerStart(arg10, 1009914297, "CC(remember):IconButtonDefaults.kt#9igjgp");
        boolean v8 = arg10.changed(v0_1);
        Object v9 = arg10.rememberedValue();
        if((v8) || v9 == Composer.Companion.getEmpty()) {
            BorderStroke v9_1 = BorderStrokeKt.BorderStroke-cXLIe8U(SmallIconButtonTokens.INSTANCE.getOutlinedOutlineWidth-D9Ej5fM(), v0_1);
            arg10.updateRememberedValue(v9_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg10);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg10);
        return ((BorderStroke)v9);
    }

    public final IconButtonColors outlinedIconButtonVibrantColors(Composer arg4, int arg5) {
        int v1 = 0xCA632FA9;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(outlinedIconButtonVibrantColors)581@27717L11:IconButtonDefaults.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonVibrantColors (IconButtonDefaults.kt:581)");
        }

        IconButtonColors v3 = this.defaultOutlinedIconButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final IconButtonColors outlinedIconButtonVibrantColors-ro_MJ88(long arg15, long arg17, long arg19, long arg21, Composer arg23, int arg24, int arg25) {
        long v9;
        Composer v0 = arg23;
        int v2 = 0xEF6AF9B3;
        ComposerKt.sourceInformationMarkerStart(v0, v2, "C(outlinedIconButtonVibrantColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)603@28773L11:IconButtonDefaults.kt#uh7d8r");
        long v3 = (arg25 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg15;
        long v5 = (arg25 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg17;
        long v7 = (arg25 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg19;
        if((arg25 & 8) != 0) {
            arg15 = v5;
            v5 = Color.copy-wmQWz5c$default(arg15, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0f, 0f, 0f, 14, null);
            v9 = arg15;
        }
        else {
            v9 = v5;
            v5 = arg21;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, arg24, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonVibrantColors (IconButtonDefaults.kt:603)");
        }

        IconButtonColors v14 = this.defaultOutlinedIconButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6)).copy-jRlVdoo(v3, v9, v7, v5);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v14;
    }

    public final BorderStroke outlinedIconToggleButtonBorder(boolean arg4, boolean arg5, Composer arg6, int arg7) {
        int v0 = 0x733DDAA8;
        arg6.startReplaceGroup(v0);
        ComposerKt.sourceInformation(arg6, "C(outlinedIconToggleButtonBorder)N(enabled,checked)790@37646L33:IconButtonDefaults.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg7, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonBorder (IconButtonDefaults.kt:786)");
        }

        if(arg5) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            arg6.endReplaceGroup();
            return null;
        }

        BorderStroke v3 = this.outlinedIconButtonBorder(arg4, arg6, arg7 & 14 | arg7 >> 3 & 0x70);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        arg6.endReplaceGroup();
        return v3;
    }

    public final IconToggleButtonColors outlinedIconToggleButtonColors(Composer arg18, int arg19) {
        Composer v0 = arg18;
        int v1 = 0xCE446B0F;
        v0.startReplaceGroup(v1);
        ComposerKt.sourceInformation(v0, "C(outlinedIconToggleButtonColors)637@30317L7,638@30360L11:IconButtonDefaults.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg19, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonColors (IconButtonDefaults.kt:636)");
        }

        ProvidableCompositionLocal v1_1 = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(v0, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v1_2 = v0.consume(((CompositionLocal)v1_1));
        ComposerKt.sourceInformationMarkerEnd(v0);
        long v2 = ((Color)v1_2).unbox-impl();
        IconToggleButtonColors v1_3 = this.defaultOutlinedIconToggleButtonColors-4WTKRHQ$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6), v2);
        if(Color.equals-impl0(v1_3.getContentColor-0d7_KjU(), v2)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v0.endReplaceGroup();
            return v1_3;
        }

        v1_3 = IconToggleButtonColors.copy-tNS2XkQ$default(v1_3, 0, v2, 0, Color.copy-wmQWz5c$default(v2, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0f, 0f, 0f, 14, null), 0, 0, 53, null);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        v0.endReplaceGroup();
        return v1_3;
    }

    public final IconToggleButtonColors outlinedIconToggleButtonColors-5tl4gsc(long arg19, long arg21, long arg23, long arg25, long arg27, long arg29, Composer arg31, int arg32, int arg33) {
        long v12;
        long v8;
        Object v2_1;
        ProvidableCompositionLocal v2;
        Composer v0 = arg31;
        int v1 = arg32;
        int v3 = -514625005;
        ComposerKt.sourceInformationMarkerStart(v0, v3, "C(outlinedIconToggleButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color,checkedContainerColor:c#ui.graphics.Color,checkedContentColor:c#ui.graphics.Color)668@31784L7,673@32066L38,675@32160L11,676@32241L7:IconButtonDefaults.kt#uh7d8r");
        long v4 = (arg33 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg19;
        String v6 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
        int v7 = 0x789C5F52;
        if((arg33 & 2) != 0) {
            v2 = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(v0, v7, v6);
            v2_1 = v0.consume(((CompositionLocal)v2));
            ComposerKt.sourceInformationMarkerEnd(v0);
            v8 = ((Color)v2_1).unbox-impl();
        }
        else {
            v8 = arg21;
        }

        long v10 = (arg33 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg23;
        if((arg33 & 8) != 0) {
            arg19 = v8;
            v8 = Color.copy-wmQWz5c$default(arg19, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0f, 0f, 0f, 14, null);
            v12 = arg19;
        }
        else {
            v12 = v8;
            v8 = arg25;
        }

        long v14 = (arg33 & 16) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg27;
        long v16 = (arg33 & 0x20) != 0 ? ColorSchemeKt.contentColorFor-ek8zF_U(v14, v0, v1 >> 12 & 14) : arg29;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v3, v1, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonColors (IconButtonDefaults.kt:675)");
        }

        ColorScheme v1_1 = MaterialTheme.INSTANCE.getColorScheme(v0, 6);
        v2 = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(v0, 0x789C5F52, v6);
        v2_1 = v0.consume(((CompositionLocal)v2));
        ComposerKt.sourceInformationMarkerEnd(v0);
        IconToggleButtonColors v1_2 = this.defaultOutlinedIconToggleButtonColors-4WTKRHQ$material3(v1_1, ((Color)v2_1).unbox-impl()).copy-tNS2XkQ(v4, v12, v10, v8, v14, v16);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v1_2;
    }

    public final BorderStroke outlinedIconToggleButtonVibrantBorder(boolean arg4, boolean arg5, Composer arg6, int arg7) {
        int v0 = 394022990;
        arg6.startReplaceGroup(v0);
        ComposerKt.sourceInformation(arg6, "C(outlinedIconToggleButtonVibrantBorder)N(enabled,checked)805@38193L40:IconButtonDefaults.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg7, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonVibrantBorder (IconButtonDefaults.kt:801)");
        }

        if(arg5) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            arg6.endReplaceGroup();
            return null;
        }

        BorderStroke v3 = this.outlinedIconButtonVibrantBorder(arg4, arg6, arg7 & 14 | arg7 >> 3 & 0x70);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        arg6.endReplaceGroup();
        return v3;
    }

    public final IconToggleButtonColors outlinedIconToggleButtonVibrantColors(Composer arg4, int arg5) {
        int v1 = 0xB65085A9;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(outlinedIconToggleButtonVibrantColors)719@34133L11:IconButtonDefaults.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonVibrantColors (IconButtonDefaults.kt:719)");
        }

        IconToggleButtonColors v3 = this.defaultOutlinedIconToggleButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final IconToggleButtonColors outlinedIconToggleButtonVibrantColors-5tl4gsc(long arg17, long arg19, long arg21, long arg23, long arg25, long arg27, Composer arg29, int arg30, int arg31) {
        long v10;
        Composer v0 = arg29;
        int v1 = arg30;
        int v3 = 0xF7890139;
        ComposerKt.sourceInformationMarkerStart(v0, v3, "C(outlinedIconToggleButtonVibrantColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color,checkedContainerColor:c#ui.graphics.Color,checkedContentColor:c#ui.graphics.Color)743@35442L38,745@35536L11:IconButtonDefaults.kt#uh7d8r");
        long v4 = (arg31 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg17;
        long v6 = (arg31 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg19;
        long v8 = (arg31 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg21;
        if((arg31 & 8) != 0) {
            arg17 = v6;
            v6 = Color.copy-wmQWz5c$default(arg17, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0f, 0f, 0f, 14, null);
            v10 = arg17;
        }
        else {
            v10 = v6;
            v6 = arg23;
        }

        long v12 = (arg31 & 16) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg25;
        long v14 = (arg31 & 0x20) != 0 ? ColorSchemeKt.contentColorFor-ek8zF_U(v12, v0, v1 >> 12 & 14) : arg27;
        if(ComposerKt.isTraceInProgress()) {
            arg17 = v4;
            ComposerKt.traceEventStart(v3, v1, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonVibrantColors (IconButtonDefaults.kt:745)");
        }
        else {
            arg17 = v4;
        }

        IconToggleButtonColors v1_1 = this.defaultOutlinedIconToggleButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6)).copy-tNS2XkQ(arg17, v10, v8, v6, v12, v14);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v1_1;
    }

    public final long smallContainerSize-N-wlBFI$material3(int arg1) {
        float v0;
        if(IconButtonWidthOption.equals-impl0(arg1, IconButtonWidthOption.Companion.getNarrow-rc6NtMs())) {
            v0 = Dp.constructor-impl(SmallIconButtonTokens.INSTANCE.getNarrowLeadingSpace-D9Ej5fM() + SmallIconButtonTokens.INSTANCE.getNarrowTrailingSpace-D9Ej5fM());
        }
        else if(IconButtonWidthOption.equals-impl0(arg1, IconButtonWidthOption.Companion.getUniform-rc6NtMs())) {
            v0 = Dp.constructor-impl(SmallIconButtonTokens.INSTANCE.getDefaultLeadingSpace-D9Ej5fM() + SmallIconButtonTokens.INSTANCE.getDefaultLeadingSpace-D9Ej5fM());
        }
        else if(IconButtonWidthOption.equals-impl0(arg1, IconButtonWidthOption.Companion.getWide-rc6NtMs())) {
            v0 = Dp.constructor-impl(SmallIconButtonTokens.INSTANCE.getWideLeadingSpace-D9Ej5fM() + SmallIconButtonTokens.INSTANCE.getWideTrailingSpace-D9Ej5fM());
        }
        else {
            v0 = Dp.constructor-impl(0f);
        }

        return DpKt.DpSize-YgX7TsA(Dp.constructor-impl(SmallIconButtonTokens.INSTANCE.getIconSize-D9Ej5fM() + v0), SmallIconButtonTokens.INSTANCE.getContainerHeight-D9Ej5fM());
    }

    public static long smallContainerSize-N-wlBFI$material3$default(IconButtonDefaults arg0, int arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = IconButtonWidthOption.Companion.getUniform-rc6NtMs();
        }

        return arg0.smallContainerSize-N-wlBFI$material3(arg1);
    }
}

