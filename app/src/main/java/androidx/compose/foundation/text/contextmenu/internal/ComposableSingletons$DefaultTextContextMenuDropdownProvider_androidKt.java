package androidx.compose.foundation.text.contextmenu.internal;

import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function5;

@Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class ComposableSingletons$DefaultTextContextMenuDropdownProvider_androidKt {
    public static final ComposableSingletons$DefaultTextContextMenuDropdownProvider_androidKt INSTANCE;
    private static Function5 lambda$-1357803046;
    private static Function5 lambda$129995601;
    private static Function5 lambda$636288403;

    static {
        ComposableSingletons$DefaultTextContextMenuDropdownProvider_androidKt.INSTANCE = new ComposableSingletons$DefaultTextContextMenuDropdownProvider_androidKt();
        ComposableSingletons$DefaultTextContextMenuDropdownProvider_androidKt.lambda$129995601 = ComposableLambdaKt.composableLambdaInstance(0x7BF9351, false, new ComposableSingletons$DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda0());
        ComposableSingletons$DefaultTextContextMenuDropdownProvider_androidKt.lambda$636288403 = ComposableLambdaKt.composableLambdaInstance(0x25ECFD93, false, new ComposableSingletons$DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda1());
        ComposableSingletons$DefaultTextContextMenuDropdownProvider_androidKt.lambda$-1357803046 = ComposableLambdaKt.composableLambdaInstance(-1357803046, false, new ComposableSingletons$DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda2());
    }

    public ComposableSingletons$DefaultTextContextMenuDropdownProvider_androidKt() {
        super();
    }

    public final Function5 getLambda$-1357803046$foundation() {
        return ComposableSingletons$DefaultTextContextMenuDropdownProvider_androidKt.lambda$-1357803046;
    }

    public final Function5 getLambda$129995601$foundation() {
        return ComposableSingletons$DefaultTextContextMenuDropdownProvider_androidKt.lambda$129995601;
    }

    public final Function5 getLambda$636288403$foundation() {
        return ComposableSingletons$DefaultTextContextMenuDropdownProvider_androidKt.lambda$636288403;
    }

    static final Unit lambda_129995601$lambda$0(TextContextMenuSession arg3, TextContextMenuDataProvider arg4, Function0 arg5, Composer arg6, int arg7) {
        int v0_1;
        ComposerKt.sourceInformation(arg6, "CN(session,dataProvider,anchorLayoutCoordinates)75@3942L63:DefaultTextContextMenuDropdownProvider.android.kt#18dpbw");
        if((arg7 & 6) == 0) {
            boolean v0 = (arg7 & 8) == 0 ? arg6.changed(arg3) : arg6.changedInstance(arg3);
            v0_1 = v0 ? 4 : 2;
            v0_1 |= arg7;
        }
        else {
            v0_1 = arg7;
        }

        if((arg7 & 0x30) == 0) {
            boolean v1 = (arg7 & 0x40) == 0 ? arg6.changed(arg4) : arg6.changedInstance(arg4);
            int v1_1 = v1 ? 0x20 : 16;
            v0_1 |= v1_1;
        }

        if((arg7 & 0x180) == 0) {
            arg7 = arg6.changedInstance(arg5) ? 0x100 : 0x80;
            v0_1 |= arg7;
        }

        boolean v7 = (v0_1 & 0x493) != 1170 ? true : false;
        if(arg6.shouldExecute(v7, v0_1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x7BF9351, v0_1, -1, "androidx.compose.foundation.text.contextmenu.internal.ComposableSingletons$DefaultTextContextMenuDropdownProvider_androidKt.lambda$129995601.<anonymous> (DefaultTextContextMenuDropdownProvider.android.kt:75)");
            }

            DefaultTextContextMenuDropdownProvider_androidKt.access$OpenContextMenu(arg3, arg4, arg5, arg6, v0_1 & 0x3FE);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_58;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg6.skipToGroupEnd();
        }

    label_58:
        return Unit.INSTANCE;
    }

    static final Unit lambda_636288403$lambda$0(TextContextMenuSession arg3, TextContextMenuDataProvider arg4, Function0 arg5, Composer arg6, int arg7) {
        int v0_1;
        ComposerKt.sourceInformation(arg6, "CN(session,dataProvider,anchorLayoutCoordinates)90@4405L63:DefaultTextContextMenuDropdownProvider.android.kt#18dpbw");
        if((arg7 & 6) == 0) {
            boolean v0 = (arg7 & 8) == 0 ? arg6.changed(arg3) : arg6.changedInstance(arg3);
            v0_1 = v0 ? 4 : 2;
            v0_1 |= arg7;
        }
        else {
            v0_1 = arg7;
        }

        if((arg7 & 0x30) == 0) {
            boolean v1 = (arg7 & 0x40) == 0 ? arg6.changed(arg4) : arg6.changedInstance(arg4);
            int v1_1 = v1 ? 0x20 : 16;
            v0_1 |= v1_1;
        }

        if((arg7 & 0x180) == 0) {
            arg7 = arg6.changedInstance(arg5) ? 0x100 : 0x80;
            v0_1 |= arg7;
        }

        boolean v7 = (v0_1 & 0x493) != 1170 ? true : false;
        if(arg6.shouldExecute(v7, v0_1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x25ECFD93, v0_1, -1, "androidx.compose.foundation.text.contextmenu.internal.ComposableSingletons$DefaultTextContextMenuDropdownProvider_androidKt.lambda$636288403.<anonymous> (DefaultTextContextMenuDropdownProvider.android.kt:90)");
            }

            DefaultTextContextMenuDropdownProvider_androidKt.access$OpenContextMenu(arg3, arg4, arg5, arg6, v0_1 & 0x3FE);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_58;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg6.skipToGroupEnd();
        }

    label_58:
        return Unit.INSTANCE;
    }

    static final Unit lambda__1357803046$lambda$0(TextContextMenuSession arg3, TextContextMenuDataProvider arg4, Function0 arg5, Composer arg6, int arg7) {
        int v0_1;
        ComposerKt.sourceInformation(arg6, "CN(session,dataProvider,anchorLayoutCoordinates)99@4699L63:DefaultTextContextMenuDropdownProvider.android.kt#18dpbw");
        if((arg7 & 6) == 0) {
            boolean v0 = (arg7 & 8) == 0 ? arg6.changed(arg3) : arg6.changedInstance(arg3);
            v0_1 = v0 ? 4 : 2;
            v0_1 |= arg7;
        }
        else {
            v0_1 = arg7;
        }

        if((arg7 & 0x30) == 0) {
            boolean v1 = (arg7 & 0x40) == 0 ? arg6.changed(arg4) : arg6.changedInstance(arg4);
            int v1_1 = v1 ? 0x20 : 16;
            v0_1 |= v1_1;
        }

        if((arg7 & 0x180) == 0) {
            arg7 = arg6.changedInstance(arg5) ? 0x100 : 0x80;
            v0_1 |= arg7;
        }

        boolean v7 = (v0_1 & 0x493) != 1170 ? true : false;
        if(arg6.shouldExecute(v7, v0_1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1357803046, v0_1, -1, "androidx.compose.foundation.text.contextmenu.internal.ComposableSingletons$DefaultTextContextMenuDropdownProvider_androidKt.lambda$-1357803046.<anonymous> (DefaultTextContextMenuDropdownProvider.android.kt:99)");
            }

            DefaultTextContextMenuDropdownProvider_androidKt.access$OpenContextMenu(arg3, arg4, arg5, arg6, v0_1 & 0x3FE);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_58;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg6.skipToGroupEnd();
        }

    label_58:
        return Unit.INSTANCE;
    }
}

