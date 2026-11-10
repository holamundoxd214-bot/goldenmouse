package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.ui.Alignment$Horizontal;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001B\b\u0001\u0018\u00002\u00020\u0001B¤\u0001\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0013\u0010\n\u001A\u000F\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\b\u0007\u0012\u0006\u0010\u000B\u001A\u00020\t\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0011\u0010\u000E\u001A\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007\u0012\u001C\u0010\u000F\u001A\u0018\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00060\u0010¢\u0006\u0002\b\u0007¢\u0006\u0002\b\u0012\u0012\u0006\u0010\u0013\u001A\u00020\u0014\u0012\u0006\u0010\u0015\u001A\u00020\u0016\u0012\u0006\u0010\u0017\u001A\u00020\u0018\u0012\b\u0010\u0019\u001A\u0004\u0018\u00010\u001A¢\u0006\u0004\b\u001B\u0010\u001CR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u001ER\u001E\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007¢\u0006\n\n\u0002\u0010!\u001A\u0004\b\u001F\u0010 R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010#R \u0010\n\u001A\u000F\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\b\u0007¢\u0006\n\n\u0002\u0010!\u001A\u0004\b$\u0010 R\u0011\u0010\u000B\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b%\u0010#R\u0011\u0010\f\u001A\u00020\r¢\u0006\b\n\u0000\u001A\u0004\b&\u0010\'R\u001E\u0010\u000E\u001A\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007¢\u0006\n\n\u0002\u0010!\u001A\u0004\b(\u0010 R)\u0010\u000F\u001A\u0018\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00060\u0010¢\u0006\u0002\b\u0007¢\u0006\u0002\b\u0012¢\u0006\n\n\u0002\u0010+\u001A\u0004\b)\u0010*R\u0013\u0010\u0013\u001A\u00020\u0014¢\u0006\n\n\u0002\u0010.\u001A\u0004\b,\u0010-R\u0011\u0010\u0015\u001A\u00020\u0016¢\u0006\b\n\u0000\u001A\u0004\b/\u00100R\u0011\u0010\u0017\u001A\u00020\u0018¢\u0006\b\n\u0000\u001A\u0004\b1\u00102R\u0013\u0010\u0019\u001A\u0004\u0018\u00010\u001A¢\u0006\b\n\u0000\u001A\u0004\b3\u00104¨\u00065"}, d2={"Landroidx/compose/material3/SingleRowTopAppBarOverrideScope;", "", "modifier", "Landroidx/compose/ui/Modifier;", "title", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "titleTextStyle", "Landroidx/compose/ui/text/TextStyle;", "subtitle", "subtitleTextStyle", "titleHorizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "navigationIcon", "actions", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "expandedHeight", "Landroidx/compose/ui/unit/Dp;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "colors", "Landroidx/compose/material3/TopAppBarColors;", "scrollBehavior", "Landroidx/compose/material3/TopAppBarScrollBehavior;", "<init>", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/Alignment$Horizontal;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getModifier", "()Landroidx/compose/ui/Modifier;", "getTitle", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "getTitleTextStyle", "()Landroidx/compose/ui/text/TextStyle;", "getSubtitle", "getSubtitleTextStyle", "getTitleHorizontalAlignment", "()Landroidx/compose/ui/Alignment$Horizontal;", "getNavigationIcon", "getActions", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function3;", "getExpandedHeight-D9Ej5fM", "()F", "F", "getWindowInsets", "()Landroidx/compose/foundation/layout/WindowInsets;", "getColors", "()Landroidx/compose/material3/TopAppBarColors;", "getScrollBehavior", "()Landroidx/compose/material3/TopAppBarScrollBehavior;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SingleRowTopAppBarOverrideScope {
    public static final int $stable;
    private final Function3 actions;
    private final TopAppBarColors colors;
    private final float expandedHeight;
    private final Modifier modifier;
    private final Function2 navigationIcon;
    private final TopAppBarScrollBehavior scrollBehavior;
    private final Function2 subtitle;
    private final TextStyle subtitleTextStyle;
    private final Function2 title;
    private final Horizontal titleHorizontalAlignment;
    private final TextStyle titleTextStyle;
    private final WindowInsets windowInsets;

    static {
    }

    public SingleRowTopAppBarOverrideScope(Modifier arg1, Function2 arg2, TextStyle arg3, Function2 arg4, TextStyle arg5, Horizontal arg6, Function2 arg7, Function3 arg8, float arg9, WindowInsets arg10, TopAppBarColors arg11, TopAppBarScrollBehavior arg12, DefaultConstructorMarker arg13) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
    }

    private SingleRowTopAppBarOverrideScope(Modifier arg1, Function2 arg2, TextStyle arg3, Function2 arg4, TextStyle arg5, Horizontal arg6, Function2 arg7, Function3 arg8, float arg9, WindowInsets arg10, TopAppBarColors arg11, TopAppBarScrollBehavior arg12) {
        super();
        this.modifier = arg1;
        this.title = arg2;
        this.titleTextStyle = arg3;
        this.subtitle = arg4;
        this.subtitleTextStyle = arg5;
        this.titleHorizontalAlignment = arg6;
        this.navigationIcon = arg7;
        this.actions = arg8;
        this.expandedHeight = arg9;
        this.windowInsets = arg10;
        this.colors = arg11;
        this.scrollBehavior = arg12;
    }

    public final Function3 getActions() {
        return this.actions;
    }

    public final TopAppBarColors getColors() {
        return this.colors;
    }

    public final float getExpandedHeight-D9Ej5fM() {
        return this.expandedHeight;
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    public final Function2 getNavigationIcon() {
        return this.navigationIcon;
    }

    public final TopAppBarScrollBehavior getScrollBehavior() {
        return this.scrollBehavior;
    }

    public final Function2 getSubtitle() {
        return this.subtitle;
    }

    public final TextStyle getSubtitleTextStyle() {
        return this.subtitleTextStyle;
    }

    public final Function2 getTitle() {
        return this.title;
    }

    public final Horizontal getTitleHorizontalAlignment() {
        return this.titleHorizontalAlignment;
    }

    public final TextStyle getTitleTextStyle() {
        return this.titleTextStyle;
    }

    public final WindowInsets getWindowInsets() {
        return this.windowInsets;
    }
}

