package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.ui.Alignment$Horizontal;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\b\u0001\u0018\u00002\u00020\u0001Bì\u0001\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0011\u0010\f\u001A\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007\u0012\u0006\u0010\r\u001A\u00020\t\u0012\u0013\u0010\u000E\u001A\u000F\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\b\u0007\u0012\u0006\u0010\u000F\u001A\u00020\t\u0012\u0013\u0010\u0010\u001A\u000F\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\b\u0007\u0012\u0006\u0010\u0011\u001A\u00020\t\u0012\u0006\u0010\u0012\u001A\u00020\u0013\u0012\u0011\u0010\u0014\u001A\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007\u0012\u001C\u0010\u0015\u001A\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00060\u0016¢\u0006\u0002\b\u0007¢\u0006\u0002\b\u0018\u0012\u0006\u0010\u0019\u001A\u00020\u000B\u0012\u0006\u0010\u001A\u001A\u00020\u000B\u0012\u0006\u0010\u001B\u001A\u00020\u001C\u0012\u0006\u0010\u001D\u001A\u00020\u001E\u0012\b\u0010\u001F\u001A\u0004\u0018\u00010 ¢\u0006\u0004\b!\u0010\"R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b#\u0010$R\u001E\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007¢\u0006\n\n\u0002\u0010\'\u001A\u0004\b%\u0010&R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b(\u0010)R\u0013\u0010\n\u001A\u00020\u000B¢\u0006\n\n\u0002\u0010,\u001A\u0004\b*\u0010+R\u001E\u0010\f\u001A\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007¢\u0006\n\n\u0002\u0010\'\u001A\u0004\b-\u0010&R\u0011\u0010\r\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b.\u0010)R \u0010\u000E\u001A\u000F\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\b\u0007¢\u0006\n\n\u0002\u0010\'\u001A\u0004\b/\u0010&R\u0011\u0010\u000F\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b0\u0010)R \u0010\u0010\u001A\u000F\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\b\u0007¢\u0006\n\n\u0002\u0010\'\u001A\u0004\b1\u0010&R\u0011\u0010\u0011\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b2\u0010)R\u0011\u0010\u0012\u001A\u00020\u0013¢\u0006\b\n\u0000\u001A\u0004\b3\u00104R\u001E\u0010\u0014\u001A\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007¢\u0006\n\n\u0002\u0010\'\u001A\u0004\b5\u0010&R)\u0010\u0015\u001A\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00060\u0016¢\u0006\u0002\b\u0007¢\u0006\u0002\b\u0018¢\u0006\n\n\u0002\u00108\u001A\u0004\b6\u00107R\u0013\u0010\u0019\u001A\u00020\u000B¢\u0006\n\n\u0002\u0010,\u001A\u0004\b9\u0010+R\u0013\u0010\u001A\u001A\u00020\u000B¢\u0006\n\n\u0002\u0010,\u001A\u0004\b:\u0010+R\u0011\u0010\u001B\u001A\u00020\u001C¢\u0006\b\n\u0000\u001A\u0004\b;\u0010<R\u0011\u0010\u001D\u001A\u00020\u001E¢\u0006\b\n\u0000\u001A\u0004\b=\u0010>R\u0013\u0010\u001F\u001A\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001A\u0004\b?\u0010@¨\u0006A"}, d2={"Landroidx/compose/material3/TwoRowsTopAppBarOverrideScope;", "", "modifier", "Landroidx/compose/ui/Modifier;", "title", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "titleTextStyle", "Landroidx/compose/ui/text/TextStyle;", "titleBottomPadding", "Landroidx/compose/ui/unit/Dp;", "smallTitle", "smallTitleTextStyle", "subtitle", "subtitleTextStyle", "smallSubtitle", "smallSubtitleTextStyle", "titleHorizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "navigationIcon", "actions", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "collapsedHeight", "expandedHeight", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "colors", "Landroidx/compose/material3/TopAppBarColors;", "scrollBehavior", "Landroidx/compose/material3/TopAppBarScrollBehavior;", "<init>", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/Alignment$Horizontal;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getModifier", "()Landroidx/compose/ui/Modifier;", "getTitle", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "getTitleTextStyle", "()Landroidx/compose/ui/text/TextStyle;", "getTitleBottomPadding-D9Ej5fM", "()F", "F", "getSmallTitle", "getSmallTitleTextStyle", "getSubtitle", "getSubtitleTextStyle", "getSmallSubtitle", "getSmallSubtitleTextStyle", "getTitleHorizontalAlignment", "()Landroidx/compose/ui/Alignment$Horizontal;", "getNavigationIcon", "getActions", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function3;", "getCollapsedHeight-D9Ej5fM", "getExpandedHeight-D9Ej5fM", "getWindowInsets", "()Landroidx/compose/foundation/layout/WindowInsets;", "getColors", "()Landroidx/compose/material3/TopAppBarColors;", "getScrollBehavior", "()Landroidx/compose/material3/TopAppBarScrollBehavior;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TwoRowsTopAppBarOverrideScope {
    public static final int $stable;
    private final Function3 actions;
    private final float collapsedHeight;
    private final TopAppBarColors colors;
    private final float expandedHeight;
    private final Modifier modifier;
    private final Function2 navigationIcon;
    private final TopAppBarScrollBehavior scrollBehavior;
    private final Function2 smallSubtitle;
    private final TextStyle smallSubtitleTextStyle;
    private final Function2 smallTitle;
    private final TextStyle smallTitleTextStyle;
    private final Function2 subtitle;
    private final TextStyle subtitleTextStyle;
    private final Function2 title;
    private final float titleBottomPadding;
    private final Horizontal titleHorizontalAlignment;
    private final TextStyle titleTextStyle;
    private final WindowInsets windowInsets;

    static {
    }

    public TwoRowsTopAppBarOverrideScope(Modifier arg1, Function2 arg2, TextStyle arg3, float arg4, Function2 arg5, TextStyle arg6, Function2 arg7, TextStyle arg8, Function2 arg9, TextStyle arg10, Horizontal arg11, Function2 arg12, Function3 arg13, float arg14, float arg15, WindowInsets arg16, TopAppBarColors arg17, TopAppBarScrollBehavior arg18, DefaultConstructorMarker arg19) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18);
    }

    private TwoRowsTopAppBarOverrideScope(Modifier arg1, Function2 arg2, TextStyle arg3, float arg4, Function2 arg5, TextStyle arg6, Function2 arg7, TextStyle arg8, Function2 arg9, TextStyle arg10, Horizontal arg11, Function2 arg12, Function3 arg13, float arg14, float arg15, WindowInsets arg16, TopAppBarColors arg17, TopAppBarScrollBehavior arg18) {
        super();
        this.modifier = arg1;
        this.title = arg2;
        this.titleTextStyle = arg3;
        this.titleBottomPadding = arg4;
        this.smallTitle = arg5;
        this.smallTitleTextStyle = arg6;
        this.subtitle = arg7;
        this.subtitleTextStyle = arg8;
        this.smallSubtitle = arg9;
        this.smallSubtitleTextStyle = arg10;
        this.titleHorizontalAlignment = arg11;
        this.navigationIcon = arg12;
        this.actions = arg13;
        this.collapsedHeight = arg14;
        this.expandedHeight = arg15;
        this.windowInsets = arg16;
        this.colors = arg17;
        this.scrollBehavior = arg18;
    }

    public final Function3 getActions() {
        return this.actions;
    }

    public final float getCollapsedHeight-D9Ej5fM() {
        return this.collapsedHeight;
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

    public final Function2 getSmallSubtitle() {
        return this.smallSubtitle;
    }

    public final TextStyle getSmallSubtitleTextStyle() {
        return this.smallSubtitleTextStyle;
    }

    public final Function2 getSmallTitle() {
        return this.smallTitle;
    }

    public final TextStyle getSmallTitleTextStyle() {
        return this.smallTitleTextStyle;
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

    public final float getTitleBottomPadding-D9Ej5fM() {
        return this.titleBottomPadding;
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

