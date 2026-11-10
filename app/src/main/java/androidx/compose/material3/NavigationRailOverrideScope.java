package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0001\u0018\u00002\u00020\u0001Bi\b\u0000\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u001E\u0010\u0007\u001A\u001A\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\b\u000B¢\u0006\u0002\b\f\u0012\u0006\u0010\r\u001A\u00020\u000E\u0012\u001C\u0010\u000F\u001A\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000B¢\u0006\u0002\b\f¢\u0006\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\u0016\u001A\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\u0016\u001A\u0004\b\u0017\u0010\u0015R+\u0010\u0007\u001A\u001A\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\b\u000B¢\u0006\u0002\b\f¢\u0006\n\n\u0002\u0010\u001A\u001A\u0004\b\u0018\u0010\u0019R\u0011\u0010\r\u001A\u00020\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u001CR)\u0010\u000F\u001A\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000B¢\u0006\u0002\b\f¢\u0006\n\n\u0002\u0010\u001A\u001A\u0004\b\u001D\u0010\u0019¨\u0006\u001E"}, d2={"Landroidx/compose/material3/NavigationRailOverrideScope;", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "header", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "<init>", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getModifier", "()Landroidx/compose/ui/Modifier;", "getContainerColor-0d7_KjU", "()J", "J", "getContentColor-0d7_KjU", "getHeader", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function3;", "getWindowInsets", "()Landroidx/compose/foundation/layout/WindowInsets;", "getContent", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class NavigationRailOverrideScope {
    public static final int $stable;
    private final long containerColor;
    private final Function3 content;
    private final long contentColor;
    private final Function3 header;
    private final Modifier modifier;
    private final WindowInsets windowInsets;

    static {
    }

    public NavigationRailOverrideScope(Modifier arg1, long arg2, long arg4, Function3 arg6, WindowInsets arg7, Function3 arg8, DefaultConstructorMarker arg9) {
        this(arg1, arg2, arg4, arg6, arg7, arg8);
    }

    private NavigationRailOverrideScope(Modifier arg1, long arg2, long arg4, Function3 arg6, WindowInsets arg7, Function3 arg8) {
        super();
        this.modifier = arg1;
        this.containerColor = arg2;
        this.contentColor = arg4;
        this.header = arg6;
        this.windowInsets = arg7;
        this.content = arg8;
    }

    public NavigationRailOverrideScope(Modifier arg11, long arg12, long arg14, Function3 arg16, WindowInsets arg17, Function3 arg18, int arg19, DefaultConstructorMarker arg20) {
        Companion v11;
        if((arg19 & 1) != 0) {
            v11 = Modifier.Companion;
        }

        this(((Modifier)v11), arg12, arg14, arg16, arg17, arg18, null);
    }

    public final long getContainerColor-0d7_KjU() {
        return this.containerColor;
    }

    public final Function3 getContent() {
        return this.content;
    }

    public final long getContentColor-0d7_KjU() {
        return this.contentColor;
    }

    public final Function3 getHeader() {
        return this.header;
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    public final WindowInsets getWindowInsets() {
        return this.windowInsets;
    }
}

