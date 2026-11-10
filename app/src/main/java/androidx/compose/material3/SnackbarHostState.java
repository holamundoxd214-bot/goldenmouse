package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002\u001C\u001DB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0014\u001A\u00020\u00152\b\b\u0002\u0010\u0016\u001A\u00020\u0017H\u0086@¢\u0006\u0002\u0010\u0018J\u0016\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0019\u001A\u00020\u001AH\u0086@¢\u0006\u0002\u0010\u001BR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\b\u001A\u0004\u0018\u00010\u00072\b\u0010\u0006\u001A\u0004\u0018\u00010\u00078F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000E\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\f¨\u0006\u001E"}, d2={"Landroidx/compose/material3/SnackbarHostState;", "", "<init>", "()V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "<set-?>", "Landroidx/compose/material3/SnackbarData;", "currentSnackbarData", "getCurrentSnackbarData", "()Landroidx/compose/material3/SnackbarData;", "setCurrentSnackbarData", "(Landroidx/compose/material3/SnackbarData;)V", "currentSnackbarData$delegate", "Landroidx/compose/runtime/MutableState;", "showSnackbar", "Landroidx/compose/material3/SnackbarResult;", "message", "", "actionLabel", "withDismissAction", "", "duration", "Landroidx/compose/material3/SnackbarDuration;", "(Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/material3/SnackbarDuration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "visuals", "Landroidx/compose/material3/SnackbarVisuals;", "(Landroidx/compose/material3/SnackbarVisuals;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SnackbarVisualsImpl", "SnackbarDataImpl", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SnackbarHostState {
    @Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000B\u001A\u00020\fH\u0016J\b\u0010\r\u001A\u00020\fH\u0016J\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001A\u00020\u0013H\u0016R\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2={"Landroidx/compose/material3/SnackbarHostState$SnackbarDataImpl;", "Landroidx/compose/material3/SnackbarData;", "visuals", "Landroidx/compose/material3/SnackbarVisuals;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "Landroidx/compose/material3/SnackbarResult;", "<init>", "(Landroidx/compose/material3/SnackbarVisuals;Lkotlinx/coroutines/CancellableContinuation;)V", "getVisuals", "()Landroidx/compose/material3/SnackbarVisuals;", "performAction", "", "dismiss", "equals", "", "other", "", "hashCode", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class SnackbarDataImpl implements SnackbarData {
        private final CancellableContinuation continuation;
        private final SnackbarVisuals visuals;

        public SnackbarDataImpl(SnackbarVisuals arg1, CancellableContinuation arg2) {
            super();
            this.visuals = arg1;
            this.continuation = arg2;
        }

        public void dismiss() {
            if(this.continuation.isActive()) {
                this.continuation.resumeWith(Result.constructor-impl(SnackbarResult.Dismissed));
            }
        }

        public boolean equals(Object arg5) {
            if(this == (((SnackbarDataImpl)arg5))) {
                return 1;
            }

            if(arg5 != null) {
                if(this.getClass() != arg5.getClass()) {
                }
                else if(!Intrinsics.areEqual(this.getVisuals(), ((SnackbarDataImpl)arg5).getVisuals())) {
                    return 0;
                }
                else if(!Intrinsics.areEqual(this.continuation, ((SnackbarDataImpl)arg5).continuation)) {
                    return 0;
                }
                else {
                    return 1;
                }
            }

            return 0;
        }

        public SnackbarVisuals getVisuals() {
            return this.visuals;
        }

        public int hashCode() {
            return this.getVisuals().hashCode() * 0x1F + this.continuation.hashCode();
        }

        public void performAction() {
            if(this.continuation.isActive()) {
                this.continuation.resumeWith(Result.constructor-impl(SnackbarResult.ActionPerformed));
            }
        }
    }

    @Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0012\u001A\u00020\u00062\b\u0010\u0013\u001A\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001A\u00020\u0016H\u0016R\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0016\u0010\u0004\u001A\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\fR\u0014\u0010\u0005\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0007\u001A\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2={"Landroidx/compose/material3/SnackbarHostState$SnackbarVisualsImpl;", "Landroidx/compose/material3/SnackbarVisuals;", "message", "", "actionLabel", "withDismissAction", "", "duration", "Landroidx/compose/material3/SnackbarDuration;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/material3/SnackbarDuration;)V", "getMessage", "()Ljava/lang/String;", "getActionLabel", "getWithDismissAction", "()Z", "getDuration", "()Landroidx/compose/material3/SnackbarDuration;", "equals", "other", "", "hashCode", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class SnackbarVisualsImpl implements SnackbarVisuals {
        private final String actionLabel;
        private final SnackbarDuration duration;
        private final String message;
        private final boolean withDismissAction;

        public SnackbarVisualsImpl(String arg1, String arg2, boolean arg3, SnackbarDuration arg4) {
            super();
            this.message = arg1;
            this.actionLabel = arg2;
            this.withDismissAction = arg3;
            this.duration = arg4;
        }

        public boolean equals(Object arg5) {
            if(this == (((SnackbarVisualsImpl)arg5))) {
                return 1;
            }

            if(arg5 != null) {
                if(this.getClass() != arg5.getClass()) {
                }
                else if(!Intrinsics.areEqual(this.getMessage(), ((SnackbarVisualsImpl)arg5).getMessage())) {
                    return 0;
                }
                else if(!Intrinsics.areEqual(this.getActionLabel(), ((SnackbarVisualsImpl)arg5).getActionLabel())) {
                    return 0;
                }
                else if(this.getWithDismissAction() != ((SnackbarVisualsImpl)arg5).getWithDismissAction()) {
                    return 0;
                }
                else if(this.getDuration() != ((SnackbarVisualsImpl)arg5).getDuration()) {
                    return 0;
                }
                else {
                    return 1;
                }
            }

            return 0;
        }

        public String getActionLabel() {
            return this.actionLabel;
        }

        public SnackbarDuration getDuration() {
            return this.duration;
        }

        public String getMessage() {
            return this.message;
        }

        public boolean getWithDismissAction() {
            return this.withDismissAction;
        }

        public int hashCode() {
            int v0 = this.getMessage().hashCode() * 0x1F;
            String v1 = this.getActionLabel();
            int v1_1 = v1 != null ? v1.hashCode() : 0;
            return ((v0 + v1_1) * 0x1F + Boolean.hashCode(this.getWithDismissAction())) * 0x1F + this.getDuration().hashCode();
        }
    }

    public static final int $stable;
    private final MutableState currentSnackbarData$delegate;
    private final Mutex mutex;

    static {
    }

    public SnackbarHostState() {
        super();
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        this.currentSnackbarData$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    }

    public static final void access$setCurrentSnackbarData(SnackbarHostState arg0, SnackbarData arg1) {
        arg0.setCurrentSnackbarData(arg1);
    }

    public final SnackbarData getCurrentSnackbarData() {
        return this.currentSnackbarData$delegate.getValue();
    }

    private final void setCurrentSnackbarData(SnackbarData arg1) {
        this.currentSnackbarData$delegate.setValue(arg1);
    }

    public final Object showSnackbar(String arg2, String arg3, boolean arg4, SnackbarDuration arg5, Continuation arg6) {
        return this.showSnackbar(new SnackbarVisualsImpl(arg2, arg3, arg4, arg5), arg6);
    }

    public final Object showSnackbar(SnackbarVisuals arg8, Continuation arg9) {
        Object v8;
        Object v6;
        int v2;
        Continuation v0;
        if((arg9 instanceof SnackbarHostState$showSnackbar$2)) {
            v0 = arg9;
            v2 = 0x80000000;
            if((((SnackbarHostState$showSnackbar$2)v0).label & v2) != 0) {
                ((SnackbarHostState$showSnackbar$2)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            SnackbarHostState$showSnackbar$2 v0_1 = new SnackbarHostState$showSnackbar$2(this, arg9);
        }

        Object v9 = ((SnackbarHostState$showSnackbar$2)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((SnackbarHostState$showSnackbar$2)v0).label;
        int v3 = 2;
        Object v5 = null;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v9);
            Mutex v9_2 = this.mutex;
            ((SnackbarHostState$showSnackbar$2)v0).L$0 = arg8;
            ((SnackbarHostState$showSnackbar$2)v0).L$1 = v9_2;
            ((SnackbarHostState$showSnackbar$2)v0).label = 1;
            if(v9_2.lock(v5, v0) == v1) {
                return v1;
            }
            else {
                try {
                label_47:
                    ((SnackbarHostState$showSnackbar$2)v0).L$0 = v8;
                    ((SnackbarHostState$showSnackbar$2)v0).L$1 = v9;
                    ((SnackbarHostState$showSnackbar$2)v0).L$2 = v0;
                    ((SnackbarHostState$showSnackbar$2)v0).label = v3;
                    CancellableContinuationImpl v3_1 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(v0), 1);
                    v3_1.initCancellability();
                    this.setCurrentSnackbarData(new SnackbarDataImpl(((SnackbarVisuals)v8), v3_1));
                    v8 = v3_1.getResult();
                    if(v8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(v0);
                    }

                    goto label_64;
                }
                catch(Throwable v8_1) {
                    v6 = v9;
                    v9_1 = v8_1;
                    v8 = v6;
                }

                try {
                label_76:
                    this.setCurrentSnackbarData(((SnackbarData)v5));
                    throw v9_1;
                }
                catch(Throwable v7) {
                    goto label_79;
                }

            label_64:
                if(v8 == v1) {
                    return v1;
                }

                v6 = v9;
                v9 = v8;
                v8 = v6;
            }
        }
        else if(v2 == 1) {
            v8 = ((SnackbarHostState$showSnackbar$2)v0).L$1;
            Object v2_1 = ((SnackbarHostState$showSnackbar$2)v0).L$0;
            ResultKt.throwOnFailure(v9);
            v9 = v8;
            v8 = v2_1;
            goto label_47;
        }
        else if(v2 == v3) {
            v8 = ((SnackbarHostState$showSnackbar$2)v0).L$1;
            try {
                ResultKt.throwOnFailure(v9);
            }
            catch(Throwable v9_1) {
                goto label_76;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        try {
            this.setCurrentSnackbarData(((SnackbarData)v5));
        }
        catch(Throwable v7) {
        label_79:
            ((Mutex)v8).unlock(v5);
            throw v7;
        }

        ((Mutex)v8).unlock(v5);
        return v9;
    }

    public static Object showSnackbar$default(SnackbarHostState arg6, String arg7, String arg8, boolean arg9, SnackbarDuration arg10, Continuation arg11, int arg12, Object arg13) {
        if((arg12 & 2) != 0) {
            arg8 = null;
        }

        String v2 = arg8;
        if((arg12 & 8) != 0) {
            SnackbarDuration v8 = v2 == null ? SnackbarDuration.Short : SnackbarDuration.Indefinite;
            arg10 = v8;
        }

        return arg6.showSnackbar(arg7, v2, false, arg10, arg11);
    }
}

