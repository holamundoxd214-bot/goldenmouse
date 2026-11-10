package androidx.compose.foundation.text.contextmenu.internal;

import android.os.Build$VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuComponent;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuData;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuItem;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSeparator;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuTextClassificationItem;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProvider;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

@Metadata(d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001:\u0002-.B3\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0014\u0010\u0004\u001A\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000BJ\u0016\u0010\u0019\u001A\u00020\u00122\u0006\u0010\u001A\u001A\u00020\u001BH\u0096@¢\u0006\u0002\u0010\u001CJ\u0006\u0010\u001D\u001A\u00020\u0012J\u0006\u0010\u001E\u001A\u00020\u0012J\u0018\u0010\u001F\u001A\u00020\u00062\u0006\u0010 \u001A\u00020!2\u0006\u0010\u001A\u001A\u00020\u001BH\u0002J\u0010\u0010\"\u001A\u00020#2\u0006\u0010\u001A\u001A\u00020\u001BH\u0002J\u0010\u0010$\u001A\u00020%2\u0006\u0010\u001A\u001A\u00020\u001BH\u0002JK\u0010&\u001A\u0002H\'\"\b\b\u0000\u0010\'*\u00020\u0011\"\b\b\u0001\u0010(*\u00020\u00112\u0006\u0010)\u001A\u0002H(2\u0012\u0010*\u001A\u000E\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u00020\u00120\u00052\f\u0010+\u001A\b\u0012\u0004\u0012\u0002H\'0\bH\u0002¢\u0006\u0002\u0010,R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\u0004\u001A\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0013\u001A\u000E\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001A\u0004\u0018\u00010\u0015X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001A\u0004\u0018\u00010\u0017X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001A\u0004\u0018\u00010\u0017X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006/"}, d2={"Landroidx/compose/foundation/text/contextmenu/internal/AndroidTextContextMenuToolbarProvider;", "Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuProvider;", "view", "Landroid/view/View;", "callbackInjector", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/contextmenu/internal/TextActionModeCallback;", "coordinatesProvider", "Lkotlin/Function0;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "mutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "snapshotStateObserver", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "onDataChange", "", "", "onPositionChange", "actionMode", "Landroid/view/ActionMode;", "startActionModeRunnable", "Ljava/lang/Runnable;", "finishActionModeRunnable", "showTextContextMenu", "dataProvider", "Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuDataProvider;", "(Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuDataProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "start", "dispose", "createActionModeCallback", "session", "Landroidx/compose/foundation/text/contextmenu/internal/AndroidTextContextMenuToolbarProvider$TextContextMenuSessionImpl;", "observeAndGetData", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuData;", "observeAndGetBounds", "Landroidx/compose/ui/geometry/Rect;", "observeReadsAndGet", "T", "S", "scope", "onValueChanged", "block", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "TextActionModeCallbackImpl", "TextContextMenuSessionImpl", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidTextContextMenuToolbarProvider implements TextContextMenuProvider {
    @Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\fJ\u001A\u0010\u000E\u001A\u00020\b2\u0006\u0010\u000F\u001A\u00020\u00102\b\u0010\t\u001A\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u0014H\u0016J\u0018\u0010\u0015\u001A\u00020\u00122\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u0014H\u0016J\u0018\u0010\u0016\u001A\u00020\u00122\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0017\u001A\u00020\u0018H\u0016J\u0010\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u000F\u001A\u00020\u0010H\u0016J\u0010\u0010\u001B\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0014H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001A\u0004\u0018\u00010\u0006X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001C"}, d2={"Landroidx/compose/foundation/text/contextmenu/internal/AndroidTextContextMenuToolbarProvider$TextActionModeCallbackImpl;", "Landroidx/compose/foundation/text/contextmenu/internal/TextActionModeCallback;", "session", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuSession;", "dataBuilder", "Lkotlin/Function0;", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuData;", "positioner", "Landroidx/compose/ui/geometry/Rect;", "view", "Landroid/view/View;", "<init>", "(Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuSession;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroid/view/View;)V", "previousData", "onGetContentRect", "mode", "Landroid/view/ActionMode;", "onCreateActionMode", "", "menu", "Landroid/view/Menu;", "onPrepareActionMode", "onActionItemClicked", "item", "Landroid/view/MenuItem;", "onDestroyActionMode", "", "updateMenuItems", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class TextActionModeCallbackImpl implements TextActionModeCallback {
        private final Function0 dataBuilder;
        private Function0 positioner;
        private TextContextMenuData previousData;
        private final TextContextMenuSession session;
        private final View view;

        public static boolean $r8$lambda$iBF5LEAJhMqvy1KvI9bmkI0Wv9Y(TextContextMenuComponent arg0, TextActionModeCallbackImpl arg1, MenuItem arg2) {
            return TextActionModeCallbackImpl.updateMenuItems$lambda$0$0(arg0, arg1, arg2);
        }

        public TextActionModeCallbackImpl(TextContextMenuSession arg1, Function0 arg2, Function0 arg3, View arg4) {
            super();
            this.session = arg1;
            this.dataBuilder = arg2;
            this.positioner = arg3;
            this.view = arg4;
        }

        public boolean onActionItemClicked(ActionMode arg1, MenuItem arg2) {
            return 0;
        }

        public boolean onCreateActionMode(ActionMode arg1, Menu arg2) {
            this.updateMenuItems(arg2);
            if(arg2.size() > 0) {
                return 1;
            }

            return 0;
        }

        public void onDestroyActionMode(ActionMode arg1) {
            this.session.close();
        }

        public Rect onGetContentRect(ActionMode arg1, View arg2) {
            return this.positioner.invoke();
        }

        public boolean onPrepareActionMode(ActionMode arg1, Menu arg2) {
            return this.updateMenuItems(arg2);
        }

        private final boolean updateMenuItems(Menu arg13) {
            Object v0 = this.dataBuilder.invoke();
            int v2 = 0;
            if(Intrinsics.areEqual(v0, this.previousData)) {
                return 0;
            }

            arg13.clear();
            List v0_1 = ((TextContextMenuData)v0).getComponents();
            int v1 = v0_1.size();
            int v6 = 1;
            int v10 = 1;
            while(v2 < v1) {
                Object v4 = v0_1.get(v2);
                if((v4 instanceof TextContextMenuItem)) {
                    int v5 = v6 + 1;
                    MenuItem v6_1 = arg13.add(v10, v6, v6, v4.getLabel());
                    v6_1.setShowAsAction(2);
                    v6_1.setOnMenuItemClickListener(new AndroidTextContextMenuToolbarProvider$TextActionModeCallbackImpl$$ExternalSyntheticLambda0(((TextContextMenuComponent)v4), this));
                    v6 = v5;
                }
                else if((v4 instanceof TextContextMenuTextClassificationItem)) {
                    if(Build$VERSION.SDK_INT >= 28) {
                        TextToolbarHelperApi28.INSTANCE.addMenuItem(arg13, v6, this.view.getContext(), v4.getTextClassification(), v4.getIndex());
                        ++v6;
                    }
                }
                else if((v4 instanceof TextContextMenuSeparator)) {
                    ++v10;
                }

                ++v2;
            }

            return 1;
        }

        private static final boolean updateMenuItems$lambda$0$0(TextContextMenuComponent arg0, TextActionModeCallbackImpl arg1, MenuItem arg2) {
            ((TextContextMenuItem)arg0).getOnClick().invoke(arg1.session);
            return 1;
        }
    }

    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001A\u00020\u0006H\u0016J\u000E\u0010\b\u001A\u00020\u0006H\u0086@¢\u0006\u0002\u0010\tR\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2={"Landroidx/compose/foundation/text/contextmenu/internal/AndroidTextContextMenuToolbarProvider$TextContextMenuSessionImpl;", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuSession;", "<init>", "()V", "channel", "Lkotlinx/coroutines/channels/Channel;", "", "close", "awaitClose", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class TextContextMenuSessionImpl implements TextContextMenuSession {
        private final Channel channel;

        public TextContextMenuSessionImpl() {
            super();
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
    }

    public static final int $stable = 8;
    private ActionMode actionMode;
    private final Function1 callbackInjector;
    private final Function0 coordinatesProvider;
    private Runnable finishActionModeRunnable;
    private final MutatorMutex mutatorMutex;
    private final Function1 onDataChange;
    private final Function1 onPositionChange;
    private final SnapshotStateObserver snapshotStateObserver;
    private Runnable startActionModeRunnable;
    private final View view;

    public static void $r8$lambda$hD9_mloftxF0Qz5q2loic8JigZI(Function0 arg0) {
        AndroidTextContextMenuToolbarProvider.snapshotStateObserver$lambda$0$0(arg0);
    }

    static {
    }

    public AndroidTextContextMenuToolbarProvider(View arg1, Function1 arg2, Function0 arg3) {
        super();
        this.view = arg1;
        this.callbackInjector = arg2;
        this.coordinatesProvider = arg3;
        this.mutatorMutex = new MutatorMutex();
        this.snapshotStateObserver = new SnapshotStateObserver(new AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda4(this));
        this.onDataChange = new AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda5(this);
        this.onPositionChange = new AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda6(this);
    }

    public static final TextActionModeCallback access$createActionModeCallback(AndroidTextContextMenuToolbarProvider arg0, TextContextMenuSessionImpl arg1, TextContextMenuDataProvider arg2) {
        return arg0.createActionModeCallback(arg1, arg2);
    }

    public static final ActionMode access$getActionMode$p(AndroidTextContextMenuToolbarProvider arg0) {
        return arg0.actionMode;
    }

    public static final Runnable access$getFinishActionModeRunnable$p(AndroidTextContextMenuToolbarProvider arg0) {
        return arg0.finishActionModeRunnable;
    }

    public static final SnapshotStateObserver access$getSnapshotStateObserver$p(AndroidTextContextMenuToolbarProvider arg0) {
        return arg0.snapshotStateObserver;
    }

    public static final Runnable access$getStartActionModeRunnable$p(AndroidTextContextMenuToolbarProvider arg0) {
        return arg0.startActionModeRunnable;
    }

    public static final View access$getView$p(AndroidTextContextMenuToolbarProvider arg0) {
        return arg0.view;
    }

    public static final void access$setActionMode$p(AndroidTextContextMenuToolbarProvider arg0, ActionMode arg1) {
        arg0.actionMode = arg1;
    }

    public static final void access$setFinishActionModeRunnable$p(AndroidTextContextMenuToolbarProvider arg0, Runnable arg1) {
        arg0.finishActionModeRunnable = arg1;
    }

    public static final void access$setStartActionModeRunnable$p(AndroidTextContextMenuToolbarProvider arg0, Runnable arg1) {
        arg0.startActionModeRunnable = arg1;
    }

    private final TextActionModeCallback createActionModeCallback(TextContextMenuSessionImpl arg4, TextContextMenuDataProvider arg5) {
        TextActionModeCallbackImpl v0 = new TextActionModeCallbackImpl(((TextContextMenuSession)arg4), new AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda1(this, arg5), new AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda2(this, arg5), this.view);
        Function1 v3 = this.callbackInjector;
        if(v3 != null) {
            Object v3_1 = v3.invoke(v0);
            if(v3_1 == null) {
            }
            else {
                return ((TextActionModeCallback)v3_1);
            }
        }

        return ((TextActionModeCallback)v0);
    }

    static final TextContextMenuData createActionModeCallback$lambda$0(AndroidTextContextMenuToolbarProvider arg0, TextContextMenuDataProvider arg1) {
        return arg0.observeAndGetData(arg1);
    }

    static final Rect createActionModeCallback$lambda$1(AndroidTextContextMenuToolbarProvider arg0, TextContextMenuDataProvider arg1) {
        return arg0.observeAndGetBounds(arg1);
    }

    public final void dispose() {
        this.snapshotStateObserver.stop();
        this.snapshotStateObserver.clear();
        ActionMode v0 = this.actionMode;
        if(v0 != null) {
            v0.finish();
        }

        this.actionMode = null;
    }

    private final Rect observeAndGetBounds(TextContextMenuDataProvider arg3) {
        return this.observeReadsAndGet("positioner", this.onPositionChange, new AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda7(this, arg3));
    }

    static final Rect observeAndGetBounds$lambda$0(AndroidTextContextMenuToolbarProvider arg2, TextContextMenuDataProvider arg3) {
        Object v2 = arg2.coordinatesProvider.invoke();
        if(v2.isAttached()) {
        }
        else {
            v2 = null;
        }

        if(v2 == null) {
            return Rect.Companion.getZero();
        }

        return arg3.contentBounds(((LayoutCoordinates)v2)).translate-k-4lQ0M(LayoutCoordinatesKt.positionInRoot(((LayoutCoordinates)v2)));
    }

    private final TextContextMenuData observeAndGetData(TextContextMenuDataProvider arg3) {
        return this.observeReadsAndGet("dataBuilder", this.onDataChange, new AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda0(arg3));
    }

    static final TextContextMenuData observeAndGetData$lambda$0(TextContextMenuDataProvider arg0) {
        return arg0.data();
    }

    private final Object observeReadsAndGet(Object arg3, Function1 arg4, Function0 arg5) {
        ObjectRef v0 = new ObjectRef();
        this.snapshotStateObserver.observeReads(arg3, arg4, new AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda3(v0, arg5));
        if(v0.element == null) {
            Intrinsics.throwUninitializedPropertyAccessException("result");
            return Unit.INSTANCE;
        }

        return v0.element;
    }

    static final Unit observeReadsAndGet$lambda$0(ObjectRef arg0, Function0 arg1) {
        arg0.element = arg1.invoke();
        return Unit.INSTANCE;
    }

    static final Unit onDataChange$lambda$0(AndroidTextContextMenuToolbarProvider arg0, Object arg1) {
        ActionMode v0 = arg0.actionMode;
        if(v0 != null) {
            v0.invalidate();
        }

        return Unit.INSTANCE;
    }

    static final Unit onPositionChange$lambda$0(AndroidTextContextMenuToolbarProvider arg0, Object arg1) {
        ActionMode v0 = arg0.actionMode;
        if(v0 != null) {
            TextToolbarHelper.INSTANCE.invalidateContentRect(v0);
        }

        return Unit.INSTANCE;
    }

    public Object showTextContextMenu(TextContextMenuDataProvider arg7, Continuation arg8) {
        Object v6 = MutatorMutex.mutate$default(this.mutatorMutex, null, new AndroidTextContextMenuToolbarProvider$showTextContextMenu$2(this, arg7, null), arg8, 1, null);
        if(v6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v6;
        }

        return Unit.INSTANCE;
    }

    static final Unit snapshotStateObserver$lambda$0(AndroidTextContextMenuToolbarProvider arg2, Function0 arg3) {
        Handler v0 = arg2.view.getHandler();
        Looper v0_1 = v0 != null ? v0.getLooper() : null;
        if(v0_1 == Looper.myLooper()) {
            arg3.invoke();
        }
        else {
            Handler v2 = arg2.view.getHandler();
            if(v2 != null) {
                v2.post(new AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda8(arg3));
            }
        }

        return Unit.INSTANCE;
    }

    private static final void snapshotStateObserver$lambda$0$0(Function0 arg0) {
        arg0.invoke();
    }

    public final void start() {
        this.snapshotStateObserver.start();
    }
}

