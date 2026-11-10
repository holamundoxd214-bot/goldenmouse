package androidx.compose.material3;

import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.window.DialogProperties;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0001\u0018\u00002\u00020\u0001B>\b\u0000\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b\u0012\u0011\u0010\t\u001A\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\n¢\u0006\u0004\b\u000B\u0010\fR\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u001E\u0010\t\u001A\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\n¢\u0006\n\n\u0002\u0010\u0015\u001A\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2={"Landroidx/compose/material3/BasicAlertDialogOverrideScope;", "", "onDismissRequest", "Lkotlin/Function0;", "", "modifier", "Landroidx/compose/ui/Modifier;", "properties", "Landroidx/compose/ui/window/DialogProperties;", "content", "Landroidx/compose/runtime/Composable;", "<init>", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function2;)V", "getOnDismissRequest", "()Lkotlin/jvm/functions/Function0;", "getModifier", "()Landroidx/compose/ui/Modifier;", "getProperties", "()Landroidx/compose/ui/window/DialogProperties;", "getContent", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class BasicAlertDialogOverrideScope {
    public static final int $stable;
    private final Function2 content;
    private final Modifier modifier;
    private final Function0 onDismissRequest;
    private final DialogProperties properties;

    static {
    }

    public BasicAlertDialogOverrideScope(Function0 arg1, Modifier arg2, DialogProperties arg3, Function2 arg4) {
        super();
        this.onDismissRequest = arg1;
        this.modifier = arg2;
        this.properties = arg3;
        this.content = arg4;
    }

    public BasicAlertDialogOverrideScope(Function0 arg7, Modifier arg8, DialogProperties arg9, Function2 arg10, int arg11, DefaultConstructorMarker arg12) {
        Companion v8;
        if((arg11 & 2) != 0) {
            v8 = Modifier.Companion;
        }

        if((arg11 & 4) != 0) {
            arg9 = new DialogProperties(false, false, false, 7, null);
        }

        this(arg7, ((Modifier)v8), arg9, arg10);
    }

    public final Function2 getContent() {
        return this.content;
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    public final Function0 getOnDismissRequest() {
        return this.onDismissRequest;
    }

    public final DialogProperties getProperties() {
        return this.properties;
    }
}

