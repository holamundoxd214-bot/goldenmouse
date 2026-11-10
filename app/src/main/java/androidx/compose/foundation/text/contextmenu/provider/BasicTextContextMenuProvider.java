package androidx.compose.foundation.text.contextmenu.provider;

import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function5;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0001\u0018\u00002\u00020\u0001:\u0001!B_\u0012V\u0010\u0002\u001AR\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000B0\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0003¢\u0006\u0002\b\u000E¢\u0006\u0004\b\u000F\u0010\u0010J\u0016\u0010\u001C\u001A\u00020\r2\u0006\u0010\t\u001A\u00020\bH\u0096@¢\u0006\u0002\u0010\u001DJ\u001B\u0010\u001E\u001A\u00020\r2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000B0\nH\u0007¢\u0006\u0002\u0010\u001FJ\u0006\u0010 \u001A\u00020\rR`\u0010\u0002\u001AR\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000B0\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0003¢\u0006\u0002\b\u000EX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\u0007\u001A\b\u0018\u00010\u0015R\u00020\u00002\f\u0010\u0014\u001A\b\u0018\u00010\u0015R\u00020\u00008B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b\u001A\u0010\u001B\u001A\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\""}, d2={"Landroidx/compose/foundation/text/contextmenu/provider/BasicTextContextMenuProvider;", "Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuProvider;", "contextMenuBlock", "Lkotlin/Function3;", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuSession;", "Lkotlin/ParameterName;", "name", "session", "Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuDataProvider;", "dataProvider", "Lkotlin/Function0;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "anchorLayoutCoordinates", "", "Landroidx/compose/runtime/Composable;", "<init>", "(Lkotlin/jvm/functions/Function5;)V", "Lkotlin/jvm/functions/Function5;", "mutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "<set-?>", "Landroidx/compose/foundation/text/contextmenu/provider/BasicTextContextMenuProvider$SessionImpl;", "getSession", "()Landroidx/compose/foundation/text/contextmenu/provider/BasicTextContextMenuProvider$SessionImpl;", "setSession", "(Landroidx/compose/foundation/text/contextmenu/provider/BasicTextContextMenuProvider$SessionImpl;)V", "session$delegate", "Landroidx/compose/runtime/MutableState;", "showTextContextMenu", "(Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuDataProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ContextMenu", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "cancel", "SessionImpl", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class BasicTextContextMenuProvider implements TextContextMenuProvider {
    @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000B\u001A\u00020\nH\u0016J\u000E\u0010\f\u001A\u00020\nH\u0086@¢\u0006\u0002\u0010\rR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Landroidx/compose/foundation/text/contextmenu/provider/BasicTextContextMenuProvider$SessionImpl;", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuSession;", "dataProvider", "Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuDataProvider;", "<init>", "(Landroidx/compose/foundation/text/contextmenu/provider/BasicTextContextMenuProvider;Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuDataProvider;)V", "getDataProvider", "()Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuDataProvider;", "channel", "Lkotlinx/coroutines/channels/Channel;", "", "close", "awaitClose", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class SessionImpl implements TextContextMenuSession {
        private final Channel channel;
        private final TextContextMenuDataProvider dataProvider;

        public SessionImpl(BasicTextContextMenuProvider arg2, TextContextMenuDataProvider arg3) {
            BasicTextContextMenuProvider.this = arg2;
            super();
            this.dataProvider = arg3;
            this.channel = ChannelKt.Channel$default(0, null, null, 7, null);
        }

        public final Object awaitClose(Continuation arg1) {
            Object v0 = this.channel.receive(arg1);
            if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return v0;
            }

            return Unit.INSTANCE;
        }

        public void close() {
            this.channel.trySend-JP2dKIU(Unit.INSTANCE);
        }

        public final TextContextMenuDataProvider getDataProvider() {
            return this.dataProvider;
        }
    }

    public static final int $stable;
    private final Function5 contextMenuBlock;
    private final MutatorMutex mutatorMutex;
    private final MutableState session$delegate;

    static {
    }

    public BasicTextContextMenuProvider(Function5 arg2) {
        super();
        this.contextMenuBlock = arg2;
        this.mutatorMutex = new MutatorMutex();
        this.session$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    }

    public final void ContextMenu(Function0 arg8, Composer arg9, int arg10) {
        Function0 v4;
        int v9;
        int v0 = 0x2B25D11E;
        Composer v5 = arg9.startRestartGroup(v0);
        ComposerKt.sourceInformation(v5, "C(ContextMenu)N(anchorLayoutCoordinates)139@5440L72:BasicTextContextMenuProvider.kt#qzx0zs");
        if((arg10 & 6) == 0) {
            v9 = v5.changedInstance(arg8) ? 4 : 2;
            v9 |= arg10;
        }
        else {
            v9 = arg10;
        }

        if((arg10 & 0x30) == 0) {
            int v1 = v5.changed(this) ? 0x20 : 16;
            v9 |= v1;
        }

        boolean v1_1 = (v9 & 19) != 18 ? true : false;
        if(v5.shouldExecute(v1_1, v9 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v9, -1, "androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProvider.ContextMenu (BasicTextContextMenuProvider.kt:137)");
            }

            SessionImpl v2 = this.getSession();
            if(v2 == null) {
                if(ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }

                ScopeUpdateScope v9_1 = v5.endRestartGroup();
                if(v9_1 == null) {
                    return;
                }

                v9_1.updateScope(new BasicTextContextMenuProvider$$ExternalSyntheticLambda0(this, arg8, arg10));
                return;
            }

            v4 = arg8;
            this.contextMenuBlock.invoke(v2, v2.getDataProvider(), v4, v5, Integer.valueOf(v9 << 6 & 0x380));
            if(!ComposerKt.isTraceInProgress()) {
                goto label_60;
            }

            ComposerKt.traceEventEnd();
            goto label_60;
        }
        else {
            v4 = arg8;
            v5.skipToGroupEnd();
        label_60:
            ScopeUpdateScope v8 = v5.endRestartGroup();
            if(v8 == null) {
                return;
            }

            v8.updateScope(new BasicTextContextMenuProvider$$ExternalSyntheticLambda1(this, v4, arg10));
        }
    }

    static final Unit ContextMenu$lambda$0(BasicTextContextMenuProvider arg0, Function0 arg1, int arg2, Composer arg3, int arg4) {
        arg0.ContextMenu(arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }

    static final Unit ContextMenu$lambda$1(BasicTextContextMenuProvider arg0, Function0 arg1, int arg2, Composer arg3, int arg4) {
        arg0.ContextMenu(arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }

    public static final void access$setSession(BasicTextContextMenuProvider arg0, SessionImpl arg1) {
        arg0.setSession(arg1);
    }

    public final void cancel() {
        SessionImpl v0 = this.getSession();
        if(v0 != null) {
            v0.close();
        }
    }

    private final SessionImpl getSession() {
        return this.session$delegate.getValue();
    }

    private final void setSession(SessionImpl arg1) {
        this.session$delegate.setValue(arg1);
    }

    public Object showTextContextMenu(TextContextMenuDataProvider arg8, Continuation arg9) {
        Object v7 = MutatorMutex.mutate$default(this.mutatorMutex, null, new BasicTextContextMenuProvider$showTextContextMenu$2(this, new SessionImpl(this, arg8), null), arg9, 1, null);
        if(v7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v7;
        }

        return Unit.INSTANCE;
    }
}

