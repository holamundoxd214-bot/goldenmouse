package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0001\u0018\u00002\u00020\u0001BQ\b\u0000\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u001C\u0010\u000B\u001A\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000E0\f¢\u0006\u0002\b\u000F¢\u0006\u0002\b\u0010¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\u0017\u001A\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\u0017\u001A\u0004\b\u0018\u0010\u0016R\u0013\u0010\u0007\u001A\u00020\b¢\u0006\n\n\u0002\u0010\u001B\u001A\u0004\b\u0019\u0010\u001AR\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u001DR)\u0010\u000B\u001A\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000E0\f¢\u0006\u0002\b\u000F¢\u0006\u0002\b\u0010¢\u0006\n\n\u0002\u0010 \u001A\u0004\b\u001E\u0010\u001F¨\u0006!"}, d2={"Landroidx/compose/material3/NavigationBarOverrideScope;", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "<init>", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getModifier", "()Landroidx/compose/ui/Modifier;", "getContainerColor-0d7_KjU", "()J", "J", "getContentColor-0d7_KjU", "getTonalElevation-D9Ej5fM", "()F", "F", "getWindowInsets", "()Landroidx/compose/foundation/layout/WindowInsets;", "getContent", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function3;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class NavigationBarOverrideScope {
    public static final int $stable;
    private final long containerColor;
    private final Function3 content;
    private final long contentColor;
    private final Modifier modifier;
    private final float tonalElevation;
    private final WindowInsets windowInsets;

    static {
    }

    public NavigationBarOverrideScope(Modifier arg1, long arg2, long arg4, float arg6, WindowInsets arg7, Function3 arg8, DefaultConstructorMarker arg9) {
        this(arg1, arg2, arg4, arg6, arg7, arg8);
    }

    private NavigationBarOverrideScope(Modifier arg1, long arg2, long arg4, float arg6, WindowInsets arg7, Function3 arg8) {
        super();
        this.modifier = arg1;
        this.containerColor = arg2;
        this.contentColor = arg4;
        this.tonalElevation = arg6;
        this.windowInsets = arg7;
        this.content = arg8;
    }

    public NavigationBarOverrideScope(Modifier arg11, long arg12, long arg14, float arg16, WindowInsets arg17, Function3 arg18, int arg19, DefaultConstructorMarker arg20) {
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

    public final Modifier getModifier() {
        return this.modifier;
    }

    public final float getTonalElevation-D9Ej5fM() {
        return this.tonalElevation;
    }

    public final WindowInsets getWindowInsets() {
        return this.windowInsets;
    }
}

