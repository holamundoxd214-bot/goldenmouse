package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0001\u0018\u00002\u00020\u0001BD\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0011\u0010\u000B\u001A\r\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\b\u000E¢\u0006\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\u0015\u001A\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\u0015\u001A\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u0013\u0010\t\u001A\u00020\n¢\u0006\n\n\u0002\u0010\u001B\u001A\u0004\b\u0019\u0010\u001AR\u001E\u0010\u000B\u001A\r\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\b\u000E¢\u0006\n\n\u0002\u0010\u001E\u001A\u0004\b\u001C\u0010\u001D¨\u0006\u001F"}, d2={"Landroidx/compose/material3/ShortNavigationBarOverrideScope;", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "arrangement", "Landroidx/compose/material3/ShortNavigationBarArrangement;", "content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "<init>", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/foundation/layout/WindowInsets;ILkotlin/jvm/functions/Function2;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getModifier", "()Landroidx/compose/ui/Modifier;", "getContainerColor-0d7_KjU", "()J", "J", "getContentColor-0d7_KjU", "getWindowInsets", "()Landroidx/compose/foundation/layout/WindowInsets;", "getArrangement-LnnQw40", "()I", "I", "getContent", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ShortNavigationBarOverrideScope {
    public static final int $stable;
    private final int arrangement;
    private final long containerColor;
    private final Function2 content;
    private final long contentColor;
    private final Modifier modifier;
    private final WindowInsets windowInsets;

    static {
    }

    public ShortNavigationBarOverrideScope(Modifier arg1, long arg2, long arg4, WindowInsets arg6, int arg7, Function2 arg8, DefaultConstructorMarker arg9) {
        this(arg1, arg2, arg4, arg6, arg7, arg8);
    }

    private ShortNavigationBarOverrideScope(Modifier arg1, long arg2, long arg4, WindowInsets arg6, int arg7, Function2 arg8) {
        super();
        this.modifier = arg1;
        this.containerColor = arg2;
        this.contentColor = arg4;
        this.windowInsets = arg6;
        this.arrangement = arg7;
        this.content = arg8;
    }

    public final int getArrangement-LnnQw40() {
        return this.arrangement;
    }

    public final long getContainerColor-0d7_KjU() {
        return this.containerColor;
    }

    public final Function2 getContent() {
        return this.content;
    }

    public final long getContentColor-0d7_KjU() {
        return this.contentColor;
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    public final WindowInsets getWindowInsets() {
        return this.windowInsets;
    }
}

