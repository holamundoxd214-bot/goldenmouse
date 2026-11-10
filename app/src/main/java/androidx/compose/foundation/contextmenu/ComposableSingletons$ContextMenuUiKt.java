package androidx.compose.foundation.contextmenu;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function8;

@Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class ComposableSingletons$ContextMenuUiKt {
    public static final ComposableSingletons$ContextMenuUiKt INSTANCE;
    private static Function3 lambda$-1455401925;
    private static Function8 lambda$-1571120048;

    static {
        ComposableSingletons$ContextMenuUiKt.INSTANCE = new ComposableSingletons$ContextMenuUiKt();
        ComposableSingletons$ContextMenuUiKt.lambda$-1571120048 = ComposableLambdaKt.composableLambdaInstance(-1571120048, false, new ComposableSingletons$ContextMenuUiKt$$ExternalSyntheticLambda0());
        ComposableSingletons$ContextMenuUiKt.lambda$-1455401925 = ComposableLambdaKt.composableLambdaInstance(0xA940543B, false, new ComposableSingletons$ContextMenuUiKt$$ExternalSyntheticLambda1());
    }

    public ComposableSingletons$ContextMenuUiKt() {
        super();
    }

    public final Function3 getLambda$-1455401925$foundation() {
        return ComposableSingletons$ContextMenuUiKt.lambda$-1455401925;
    }

    public final Function8 getLambda$-1571120048$foundation() {
        return ComposableSingletons$ContextMenuUiKt.lambda$-1571120048;
    }

    static final Unit lambda__1455401925$lambda$0(ContextMenuColors arg9, Composer arg10, int arg11) {
        ComposerKt.sourceInformation(arg10, "CN(colors)305@11326L290:ContextMenuUi.kt#3xeu6s");
        if((arg11 & 6) == 0) {
            int v0 = arg10.changed(arg9) ? 4 : 2;
            arg11 |= v0;
        }

        boolean v0_1 = (arg11 & 19) != 18 ? true : false;
        if(arg10.shouldExecute(v0_1, arg11 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xA940543B, arg11, -1, "androidx.compose.foundation.contextmenu.ComposableSingletons$ContextMenuUiKt.lambda$-1455401925.<anonymous> (ContextMenuUi.kt:305)");
            }

            BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, 0f, ContextMenuSpec.INSTANCE.getDividerVerticalPadding-D9Ej5fM(), 1, null), 0f, 1, null), ContextMenuSpec.INSTANCE.getDividerHeight-D9Ej5fM()), arg9.getIconColor-0d7_KjU(), null, 2, null), arg10, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_48;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg10.skipToGroupEnd();
        }

    label_48:
        return Unit.INSTANCE;
    }

    static final Unit lambda__1571120048$lambda$0(Modifier arg9, String arg10, boolean arg11, ContextMenuColors arg12, Function3 arg13, Function0 arg14, Composer arg15, int arg16) {
        int v2;
        int v1;
        int v0 = arg16;
        ComposerKt.sourceInformation(arg15, "CN(modifier,label,enabled,colors,leadingIcon,onClick)136@5002L71:ContextMenuUi.kt#3xeu6s");
        if((v0 & 6) == 0) {
            v1 = arg15.changed(arg9) ? 4 : 2;
            v1 |= v0;
        }
        else {
            v1 = v0;
        }

        if((v0 & 0x30) == 0) {
            v2 = arg15.changed(arg10) ? 0x20 : 16;
            v1 |= v2;
        }

        if((v0 & 0x180) == 0) {
            v2 = arg15.changed(arg11) ? 0x100 : 0x80;
            v1 |= v2;
        }

        if((v0 & 0xC00) == 0) {
            v2 = arg15.changed(arg12) ? 0x800 : 0x400;
            v1 |= v2;
        }

        if((v0 & 0x6000) == 0) {
            v2 = arg15.changedInstance(arg13) ? 0x4000 : 0x2000;
            v1 |= v2;
        }

        if((v0 & 0x30000) == 0) {
            v0 = arg15.changedInstance(arg14) ? 0x20000 : 0x10000;
            v1 |= v0;
        }

        boolean v0_1 = (0x92493 & v1) != 0x92492 ? true : false;
        if(arg15.shouldExecute(v0_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1571120048, v1, -1, "androidx.compose.foundation.contextmenu.ComposableSingletons$ContextMenuUiKt.lambda$-1571120048.<anonymous> (ContextMenuUi.kt:136)");
            }

            ContextMenuUiKt.ContextMenuItem(arg10, arg11, arg12, arg9, arg13, arg14, arg15, v1 >> 3 & 0x3FE | v1 << 9 & 0x1C00 | 0xE000 & v1 | v1 & 0x70000, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_95;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg15.skipToGroupEnd();
        }

    label_95:
        return Unit.INSTANCE;
    }
}

