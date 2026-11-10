package androidx.compose.ui.layout;

import kotlin.Metadata;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000 \f2\u00020\u0001:\u0001\fJ\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH&R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\u0005\u0082\u0001\u0002\r\u000Eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000FÀ\u0006\u0001"}, d2={"Landroidx/compose/ui/layout/WindowInsetsRulers;", "", "current", "Landroidx/compose/ui/layout/RectRulers;", "getCurrent", "()Landroidx/compose/ui/layout/RectRulers;", "maximum", "getMaximum", "getAnimation", "Landroidx/compose/ui/layout/WindowInsetsAnimation;", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Companion", "Landroidx/compose/ui/layout/InnermostInsetsRulers;", "Landroidx/compose/ui/layout/WindowInsetsRulersImpl;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface WindowInsetsRulers {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001C\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010 \u001A\u00020\u00052\u0012\u0010!\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00050\"\"\u00020\u0005¢\u0006\u0002\u0010#R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\u0007R\u0011\u0010\f\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u0007R\u0011\u0010\u000E\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0007R\u0011\u0010\u0010\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001A\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u0007R\u0011\u0010\u001C\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u0007R\u0011\u0010\u001E\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010\u0007¨\u0006$"}, d2={"Landroidx/compose/ui/layout/WindowInsetsRulers$Companion;", "", "<init>", "()V", "CaptionBar", "Landroidx/compose/ui/layout/WindowInsetsRulers;", "getCaptionBar", "()Landroidx/compose/ui/layout/WindowInsetsRulers;", "DisplayCutout", "getDisplayCutout", "Ime", "getIme", "MandatorySystemGestures", "getMandatorySystemGestures", "NavigationBars", "getNavigationBars", "StatusBars", "getStatusBars", "SystemBars", "getSystemBars", "SystemGestures", "getSystemGestures", "TappableElement", "getTappableElement", "Waterfall", "getWaterfall", "SafeDrawing", "getSafeDrawing", "SafeGestures", "getSafeGestures", "SafeContent", "getSafeContent", "innermostOf", "windowInsetsRulers", "", "([Landroidx/compose/ui/layout/WindowInsetsRulers;)Landroidx/compose/ui/layout/WindowInsetsRulers;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        private static final WindowInsetsRulers CaptionBar;
        private static final WindowInsetsRulers DisplayCutout;
        private static final WindowInsetsRulers Ime;
        private static final WindowInsetsRulers MandatorySystemGestures;
        private static final WindowInsetsRulers NavigationBars;
        private static final WindowInsetsRulers SafeContent;
        private static final WindowInsetsRulers SafeDrawing;
        private static final WindowInsetsRulers SafeGestures;
        private static final WindowInsetsRulers StatusBars;
        private static final WindowInsetsRulers SystemBars;
        private static final WindowInsetsRulers SystemGestures;
        private static final WindowInsetsRulers TappableElement;
        private static final WindowInsetsRulers Waterfall;

        static {
            Companion.$$INSTANCE = new Companion();
            WindowInsetsRulersImpl v0 = new WindowInsetsRulersImpl("caption bar");
            Companion.CaptionBar = ((WindowInsetsRulers)v0);
            WindowInsetsRulersImpl v1 = new WindowInsetsRulersImpl("display cutout");
            Companion.DisplayCutout = ((WindowInsetsRulers)v1);
            WindowInsetsRulersImpl v2 = new WindowInsetsRulersImpl("ime");
            Companion.Ime = ((WindowInsetsRulers)v2);
            WindowInsetsRulersImpl v3 = new WindowInsetsRulersImpl("mandatory system gestures");
            Companion.MandatorySystemGestures = ((WindowInsetsRulers)v3);
            WindowInsetsRulersImpl v4 = new WindowInsetsRulersImpl("navigation bars");
            Companion.NavigationBars = ((WindowInsetsRulers)v4);
            WindowInsetsRulersImpl v5 = new WindowInsetsRulersImpl("status bars");
            Companion.StatusBars = ((WindowInsetsRulers)v5);
            Companion.SystemBars = new InnermostInsetsRulers("system bars", new WindowInsetsRulers[]{v5, v4, v0});
            WindowInsetsRulersImpl v6 = new WindowInsetsRulersImpl("system gestures");
            Companion.SystemGestures = ((WindowInsetsRulers)v6);
            WindowInsetsRulersImpl v8 = new WindowInsetsRulersImpl("tappable element");
            Companion.TappableElement = ((WindowInsetsRulers)v8);
            WindowInsetsRulersImpl v12 = new WindowInsetsRulersImpl("waterfall");
            Companion.Waterfall = ((WindowInsetsRulers)v12);
            Companion.SafeDrawing = new InnermostInsetsRulers("safe drawing", new WindowInsetsRulers[]{v5, v4, v0, v1, v2, v8});
            Companion.SafeGestures = new InnermostInsetsRulers("safe gestures", new WindowInsetsRulers[]{v3, v6, v8, v12});
            Companion.SafeContent = new InnermostInsetsRulers("safe content", new WindowInsetsRulers[]{v5, v4, v0, v2, v6, v3, v8, v1, v12});
        }

        private Companion() {
            super();
        }

        public final WindowInsetsRulers getCaptionBar() {
            return Companion.CaptionBar;
        }

        public final WindowInsetsRulers getDisplayCutout() {
            return Companion.DisplayCutout;
        }

        public final WindowInsetsRulers getIme() {
            return Companion.Ime;
        }

        public final WindowInsetsRulers getMandatorySystemGestures() {
            return Companion.MandatorySystemGestures;
        }

        public final WindowInsetsRulers getNavigationBars() {
            return Companion.NavigationBars;
        }

        public final WindowInsetsRulers getSafeContent() {
            return Companion.SafeContent;
        }

        public final WindowInsetsRulers getSafeDrawing() {
            return Companion.SafeDrawing;
        }

        public final WindowInsetsRulers getSafeGestures() {
            return Companion.SafeGestures;
        }

        public final WindowInsetsRulers getStatusBars() {
            return Companion.StatusBars;
        }

        public final WindowInsetsRulers getSystemBars() {
            return Companion.SystemBars;
        }

        public final WindowInsetsRulers getSystemGestures() {
            return Companion.SystemGestures;
        }

        public final WindowInsetsRulers getTappableElement() {
            return Companion.TappableElement;
        }

        public final WindowInsetsRulers getWaterfall() {
            return Companion.Waterfall;
        }

        public final WindowInsetsRulers innermostOf(WindowInsetsRulers[] arg2) {
            return new InnermostInsetsRulers(null, arg2);
        }
    }

    public static final Companion Companion;

    static {
        WindowInsetsRulers.Companion = Companion.$$INSTANCE;
    }

    WindowInsetsAnimation getAnimation(PlacementScope arg1);

    RectRulers getCurrent();

    RectRulers getMaximum();
}

