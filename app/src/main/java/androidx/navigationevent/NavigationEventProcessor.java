package androidx.navigationevent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1={"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010!\u001A\u00020\"J\u001B\u0010#\u001A\u00020\"2\f\u0010$\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u0011H\u0000¢\u0006\u0002\b%J$\u0010&\u001A\u00020\"2\u0006\u0010\'\u001A\u00020(2\n\u0010$\u001A\u0006\u0012\u0002\b\u00030\u00112\b\b\u0002\u0010)\u001A\u00020\u0015J\u0012\u0010*\u001A\u00020\"2\n\u0010$\u001A\u0006\u0012\u0002\b\u00030\u0011J\u001E\u0010+\u001A\u00020\"2\u0006\u0010\'\u001A\u00020(2\u0006\u0010,\u001A\u00020\u00182\u0006\u0010)\u001A\u00020\u0015J\u000E\u0010-\u001A\u00020\"2\u0006\u0010,\u001A\u00020\u0018J\"\u0010.\u001A\u00020\"2\u0006\u0010,\u001A\u00020\u00182\u0006\u0010/\u001A\u00020\u00152\n\b\u0002\u00100\u001A\u0004\u0018\u000101J\u001E\u00102\u001A\u00020\"2\u0006\u0010,\u001A\u00020\u00182\u0006\u0010/\u001A\u00020\u00152\u0006\u00100\u001A\u000201J \u00103\u001A\u00020\"2\u0006\u0010,\u001A\u00020\u00182\u0006\u0010/\u001A\u00020\u00152\b\u00104\u001A\u0004\u0018\u000105J\u0016\u00106\u001A\u00020\"2\u0006\u0010,\u001A\u00020\u00182\u0006\u0010/\u001A\u00020\u0015J\u0018\u00107\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u00112\b\b\u0002\u0010/\u001A\u00020\u0015H\u0002J\'\u00108\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u00112\u0016\u00109\u001A\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0011\u0012\u0004\u0012\u00020\u001E0:H\u0082\bJ\u000E\u0010;\u001A\b\u0012\u0004\u0012\u00020=0<H\u0002R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0014\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001A\b\u0012\u0004\u0012\u00020\f0\b¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\nR\u0018\u0010\u000F\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001A\u00020\u0015X\u0082\u000E¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0003R\u0010\u0010\u0017\u001A\u0004\u0018\u00010\u0018X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00180\u001AX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u00180\u001AX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u00180\u001AX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001D\u001A\u00020\u001EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001F\u001A\u00020\u001EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010 \u001A\u00020\u001EX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006>"}, d2={"Landroidx/navigationevent/NavigationEventProcessor;", "", "<init>", "()V", "_transitionState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/navigationevent/NavigationEventTransitionState;", "transitionState", "Lkotlinx/coroutines/flow/StateFlow;", "getTransitionState", "()Lkotlinx/coroutines/flow/StateFlow;", "_history", "Landroidx/navigationevent/NavigationEventHistory;", "history", "getHistory", "overlayHandlers", "Lkotlin/collections/ArrayDeque;", "Landroidx/navigationevent/NavigationEventHandler;", "defaultHandlers", "inProgressHandler", "inProgressDirection", "", "getInProgressDirection$annotations", "inProgressInput", "Landroidx/navigationevent/NavigationEventInput;", "unspecifiedInputs", "", "defaultInputs", "overlayInputs", "hasEnabledDefaultHandlers", "", "hasEnabledOverlayHandlers", "hasEnabledAnyHandlers", "refreshEnabledHandlers", "", "updateEnabledHandlerInfo", "handler", "updateEnabledHandlerInfo$navigationevent", "addHandler", "dispatcher", "Landroidx/navigationevent/NavigationEventDispatcher;", "priority", "removeHandler", "addInput", "input", "removeInput", "dispatchOnStarted", "direction", "event", "Landroidx/navigationevent/NavigationEvent;", "dispatchOnProgressed", "dispatchOnCompleted", "onBackCompletedFallback", "Landroidx/navigationevent/OnBackCompletedFallback;", "dispatchOnCancelled", "resolveEnabledHandler", "findHandler", "predicate", "Lkotlin/Function1;", "resolveCombinedBackInfo", "", "Landroidx/navigationevent/NavigationEventInfo;", "navigationevent"}, k=1, mv={2, 0, 0}, xi=0x30) public final class NavigationEventProcessor {
    private final MutableStateFlow _history;
    private final MutableStateFlow _transitionState;
    private final ArrayDeque defaultHandlers;
    private final Set defaultInputs;
    private boolean hasEnabledAnyHandlers;
    private boolean hasEnabledDefaultHandlers;
    private boolean hasEnabledOverlayHandlers;
    private final StateFlow history;
    private int inProgressDirection;
    private NavigationEventHandler inProgressHandler;
    private NavigationEventInput inProgressInput;
    private final ArrayDeque overlayHandlers;
    private final Set overlayInputs;
    private final StateFlow transitionState;
    private final Set unspecifiedInputs;

    public NavigationEventProcessor() {
        super();
        MutableStateFlow v0 = StateFlowKt.MutableStateFlow(Idle.INSTANCE);
        this._transitionState = v0;
        this.transitionState = FlowKt.asStateFlow(v0);
        v0 = StateFlowKt.MutableStateFlow(new NavigationEventHistory());
        this._history = v0;
        this.history = FlowKt.asStateFlow(v0);
        this.overlayHandlers = new ArrayDeque();
        this.defaultHandlers = new ArrayDeque();
        this.unspecifiedInputs = new LinkedHashSet();
        this.defaultInputs = new LinkedHashSet();
        this.overlayInputs = new LinkedHashSet();
    }

    public final void addHandler(NavigationEventDispatcher arg2, NavigationEventHandler arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg2, "dispatcher");
        Intrinsics.checkNotNullParameter(arg3, "handler");
        if(arg3.getDispatcher$navigationevent() == null) {
            if(arg4 == 0) {
                this.overlayHandlers.addFirst(arg3);
            }
            else if(arg4 == 1) {
                this.defaultHandlers.addFirst(arg3);
            }
            else {
                throw new IllegalArgumentException("Unsupported priority value: " + arg4);
            }

            arg3.setDispatcher$navigationevent(arg2);
            this.refreshEnabledHandlers();
            return;
        }

        throw new IllegalArgumentException("Handler \'" + arg3 + "\' is already registered with a dispatcher".toString());
    }

    public static void addHandler$default(NavigationEventProcessor arg0, NavigationEventDispatcher arg1, NavigationEventHandler arg2, int arg3, int arg4, Object arg5) {
        arg0.addHandler(arg1, arg2, 1);
    }

    public final void addInput(NavigationEventDispatcher arg3, NavigationEventInput arg4, int arg5) {
        boolean v2;
        Set v1;
        Intrinsics.checkNotNullParameter(arg3, "dispatcher");
        Intrinsics.checkNotNullParameter(arg4, "input");
        if(arg4.getDispatcher$navigationevent() == null) {
            if(arg5 == 0) {
                v1 = this.overlayInputs;
            }
            else if(arg5 != 1) {
                v1 = this.unspecifiedInputs;
            }
            else {
                v1 = this.defaultInputs;
            }

            ((Collection)v1).add(arg4);
            arg4.setDispatcher$navigationevent(arg3);
            arg4.doOnAdded$navigationevent(arg3);
            arg4.doOnHistoryChanged$navigationevent(this.history.getValue());
            if(arg5 == 0) {
                v2 = this.hasEnabledOverlayHandlers;
            }
            else if(arg5 != 1) {
                v2 = this.hasEnabledAnyHandlers;
            }
            else {
                v2 = this.hasEnabledDefaultHandlers;
            }

            arg4.doOnHasEnabledHandlersChanged$navigationevent(v2);
            return;
        }

        throw new IllegalArgumentException("Input \'" + arg4 + "\' is already added to dispatcher " + arg4.getDispatcher$navigationevent() + '.'.toString());
    }

    public final void dispatchOnCancelled(NavigationEventInput arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg3, "input");
        if(Intrinsics.areEqual(arg3, this.inProgressInput)) {
            if(arg4 != this.inProgressDirection) {
            }
            else {
                NavigationEventHandler v3 = this.inProgressHandler;
                if(v3 == null) {
                    v3 = this.resolveEnabledHandler(arg4);
                }

                this.inProgressHandler = null;
                this.inProgressDirection = 0;
                this.inProgressInput = null;
                if(arg4 != -1) {
                    if(arg4 != 1) {
                    }
                    else if(v3 != null) {
                        v3.doOnForwardCancelled$navigationevent();
                    }
                }
                else if(v3 != null) {
                    v3.doOnBackCancelled$navigationevent();
                }

                this._transitionState.setValue(Idle.INSTANCE);
            }
        }
    }

    public final void dispatchOnCompleted(NavigationEventInput arg3, int arg4, OnBackCompletedFallback arg5) {
        Intrinsics.checkNotNullParameter(arg3, "input");
        if(Intrinsics.areEqual(arg3, this.inProgressInput)) {
            if(arg4 != this.inProgressDirection) {
            }
            else {
                NavigationEventHandler v3 = this.inProgressHandler;
                if(v3 == null) {
                    v3 = this.resolveEnabledHandler(arg4);
                }

                this.inProgressHandler = null;
                this.inProgressDirection = 0;
                this.inProgressInput = null;
                if(arg4 != -1) {
                    if(arg4 != 1) {
                    }
                    else if(v3 != null) {
                        v3.doOnForwardCompleted$navigationevent();
                    }
                }
                else if(v3 != null) {
                    v3.doOnBackCompleted$navigationevent();
                }
                else if(arg5 != null) {
                    arg5.onBackCompletedFallback();
                }

                this._transitionState.setValue(Idle.INSTANCE);
            }
        }
    }

    public final void dispatchOnProgressed(NavigationEventInput arg2, int arg3, NavigationEvent arg4) {
        Intrinsics.checkNotNullParameter(arg2, "input");
        Intrinsics.checkNotNullParameter(arg4, "event");
        if(Intrinsics.areEqual(arg2, this.inProgressInput)) {
            if(arg3 != this.inProgressDirection) {
            }
            else {
                NavigationEventHandler v2 = this.inProgressHandler;
                if(v2 == null) {
                    v2 = this.resolveEnabledHandler(arg3);
                }

                if(arg3 != -1) {
                    if(arg3 != 1) {
                    }
                    else if(v2 != null) {
                        v2.doOnForwardProgressed$navigationevent(arg4);
                    }
                }
                else if(v2 != null) {
                    v2.doOnBackProgressed$navigationevent(arg4);
                }

                this._transitionState.setValue(new InProgress(arg4, arg3));
            }
        }
    }

    public final void dispatchOnStarted(NavigationEventInput arg2, int arg3, NavigationEvent arg4) {
        Intrinsics.checkNotNullParameter(arg2, "input");
        if(this.inProgressDirection != 0) {
        }
        else {
            NavigationEventHandler v0 = this.resolveEnabledHandler(arg3);
            this.inProgressHandler = v0;
            this.inProgressDirection = arg3;
            this.inProgressInput = arg2;
            if(arg4 != null) {
                if(arg3 != -1) {
                    if(arg3 != 1) {
                    }
                    else if(v0 != null) {
                        v0.doOnForwardStarted$navigationevent(arg4);
                    }
                }
                else if(v0 != null) {
                    v0.doOnBackStarted$navigationevent(arg4);
                }

                this._transitionState.setValue(new InProgress(arg4, arg3));
            }
        }
    }

    public static void dispatchOnStarted$default(NavigationEventProcessor arg0, NavigationEventInput arg1, int arg2, NavigationEvent arg3, int arg4, Object arg5) {
        if((arg4 & 4) != 0) {
            arg3 = null;
        }

        arg0.dispatchOnStarted(arg1, arg2, arg3);
    }

    private final NavigationEventHandler findHandler(Function1 arg5) {
        Object v0_1;
        Iterator v4;
        Object v1;
        NavigationEventHandler v2;
        Iterator v0 = this.overlayHandlers.iterator();
        do {
            v2 = null;
            if(v0.hasNext()) {
                v1 = v0.next();
                if(!arg5.invoke(v1).booleanValue()) {
                    continue;
                }

                break;
            }
            else {
                goto label_10;
            }
        }
        while(true);

        goto label_11;
    label_10:
        v1 = v2;
    label_11:
        if(v1 == null) {
            v4 = this.defaultHandlers.iterator();
            goto label_14;
        }

        return ((NavigationEventHandler)v1);
        do {
        label_14:
            if(v4.hasNext()) {
                v0_1 = v4.next();
                if(!arg5.invoke(v0_1).booleanValue()) {
                    continue;
                }

                break;
            }

            return v2;
        }
        while(true);

        Object v2_1 = v0_1;
        return v2;
    }

    public final StateFlow getHistory() {
        return this.history;
    }

    private static void getInProgressDirection$annotations() {
    }

    public final StateFlow getTransitionState() {
        return this.transitionState;
    }

    public final void refreshEnabledHandlers() {
        Iterator v5_1;
        boolean v1_3;
        boolean v0_2;
        ArrayDeque v0 = this.overlayHandlers;
        if(!(v0 instanceof Collection) || !v0.isEmpty()) {
            Iterator v0_1 = ((Iterable)v0).iterator();
            do {
                if(v0_1.hasNext()) {
                    Object v1 = v0_1.next();
                    if(!((NavigationEventHandler)v1).isBackEnabled() && !((NavigationEventHandler)v1).isForwardEnabled()) {
                        continue;
                    }

                    break;
                }
                else {
                    goto label_8;
                }
            }
            while(true);

            v0_2 = true;
            goto label_19;
        label_8:
            v0_2 = false;
        }
        else {
            goto label_8;
        }

    label_19:
        ArrayDeque v1_1 = this.defaultHandlers;
        if(!(v1_1 instanceof Collection) || !v1_1.isEmpty()) {
            Iterator v1_2 = ((Iterable)v1_1).iterator();
            do {
                if(v1_2.hasNext()) {
                    Object v4 = v1_2.next();
                    if(!((NavigationEventHandler)v4).isBackEnabled() && !((NavigationEventHandler)v4).isForwardEnabled()) {
                        continue;
                    }

                    break;
                }
                else {
                    goto label_25;
                }
            }
            while(true);

            v1_3 = true;
            goto label_36;
        label_25:
            v1_3 = false;
        }
        else {
            goto label_25;
        }

    label_36:
        boolean v4_1 = (v0_2) || (v1_3) ? true : false;
        int v5 = this.hasEnabledOverlayHandlers != v0_2 ? 1 : 0;
        int v6 = this.hasEnabledDefaultHandlers != v1_3 ? 1 : 0;
        int v7 = this.hasEnabledAnyHandlers != v4_1 ? 1 : 0;
        if(v5 != 0) {
            v5_1 = this.overlayInputs.iterator();
            while(v5_1.hasNext()) {
                v5_1.next().doOnHasEnabledHandlersChanged$navigationevent(v0_2);
            }
        }

        if(v6 != 0) {
            v5_1 = this.defaultInputs.iterator();
            while(v5_1.hasNext()) {
                v5_1.next().doOnHasEnabledHandlersChanged$navigationevent(v1_3);
            }
        }

        if(v7 != 0) {
            v5_1 = this.unspecifiedInputs.iterator();
            while(v5_1.hasNext()) {
                v5_1.next().doOnHasEnabledHandlersChanged$navigationevent(v4_1);
            }
        }

        this.hasEnabledOverlayHandlers = v0_2;
        this.hasEnabledDefaultHandlers = v1_3;
        this.hasEnabledAnyHandlers = v4_1;
        NavigationEventHandler v0_3 = this.inProgressHandler;
        if(v0_3 == null) {
            v0_3 = NavigationEventProcessor.resolveEnabledHandler$default(this, 0, 1, null);
        }

        this.updateEnabledHandlerInfo$navigationevent(v0_3);
    }

    public final void removeHandler(NavigationEventHandler arg4) {
        Intrinsics.checkNotNullParameter(arg4, "handler");
        NavigationEventHandler v1 = null;
        if(Intrinsics.areEqual(arg4, this.inProgressHandler)) {
            int v0 = this.inProgressDirection;
            if(v0 == -1) {
                arg4.doOnBackCancelled$navigationevent();
            }
            else if(v0 != 1) {
            }
            else {
                arg4.doOnForwardCancelled$navigationevent();
            }

            this.inProgressHandler = v1;
            this.inProgressDirection = 0;
            this.inProgressInput = ((NavigationEventInput)v1);
        }

        this.overlayHandlers.remove(arg4);
        this.defaultHandlers.remove(arg4);
        arg4.setDispatcher$navigationevent(((NavigationEventDispatcher)v1));
        this.refreshEnabledHandlers();
    }

    public final void removeInput(NavigationEventInput arg2) {
        Intrinsics.checkNotNullParameter(arg2, "input");
        this.overlayInputs.remove(arg2);
        this.defaultInputs.remove(arg2);
        this.unspecifiedInputs.remove(arg2);
        arg2.setDispatcher$navigationevent(null);
        arg2.doOnRemoved$navigationevent();
    }

    private final List resolveCombinedBackInfo() {
        ArrayList v0 = new ArrayList();
        Iterator v1 = this.overlayHandlers.iterator();
        while(v1.hasNext()) {
            Object v2 = v1.next();
            if(!((NavigationEventHandler)v2).isBackEnabled()) {
                continue;
            }

            if(((NavigationEventHandler)v2).getBackInfo().isEmpty()) {
                continue;
            }

            ((List)v0).addAll(((NavigationEventHandler)v2).getBackInfo());
        }

        Iterator v4 = this.defaultHandlers.iterator();
        while(v4.hasNext()) {
            Object v1_1 = v4.next();
            if(!((NavigationEventHandler)v1_1).isBackEnabled()) {
                continue;
            }

            if(((NavigationEventHandler)v1_1).getBackInfo().isEmpty()) {
                continue;
            }

            ((List)v0).addAll(((NavigationEventHandler)v1_1).getBackInfo());
        }

        return ((List)v0);
    }

    private final NavigationEventHandler resolveEnabledHandler(int arg5) {
        Object v5_1;
        Iterator v4;
        Object v0;
        NavigationEventHandler v1 = null;
        if(arg5 == -1) {
            goto label_65;
        }

        if(arg5 == 0) {
            goto label_39;
        }

        if(arg5 != 1) {
            goto label_28;
        }

        Iterator v5 = this.overlayHandlers.iterator();
        do {
            if(v5.hasNext()) {
                v0 = v5.next();
                if(!v0.isForwardEnabled()) {
                    continue;
                }

                break;
            }
            else {
                goto label_15;
            }
        }
        while(true);

        goto label_16;
    label_15:
        v0 = v1;
    label_16:
        if(v0 == null) {
            v4 = this.defaultHandlers.iterator();
            goto label_19;
        }

        return ((NavigationEventHandler)v0);
        do {
        label_19:
            if(v4.hasNext()) {
                v5_1 = v4.next();
                if(!v5_1.isForwardEnabled()) {
                    continue;
                }

                break;
            }

            return v1;
        }
        while(true);

        Object v1_1 = v5_1;
        return v1;
    label_28:
        throw new IllegalStateException("Unsupported direction: \'" + arg5 + "\'.".toString());
    label_39:
        v5 = this.overlayHandlers.iterator();
        do {
            if(v5.hasNext()) {
                v0 = v5.next();
                Object v2 = v0;
                if(!((NavigationEventHandler)v2).isBackEnabled()) {
                    if(!((NavigationEventHandler)v2).isForwardEnabled()) {
                        continue;
                    }

                    break;
                }
            }
            else {
                goto label_50;
            }

            goto label_51;
        }
        while(true);

        goto label_51;
    label_50:
        v0 = v1;
    label_51:
        if(v0 == null) {
            v4 = this.defaultHandlers.iterator();
            goto label_54;
        }

        return ((NavigationEventHandler)v0);
        do {
        label_54:
            if(v4.hasNext()) {
                v5_1 = v4.next();
                v0 = v5_1;
                if(!((NavigationEventHandler)v0).isBackEnabled() && !((NavigationEventHandler)v0).isForwardEnabled()) {
                    continue;
                }

                break;
            }

            return v1;
        }
        while(true);

        v1_1 = v5_1;
        return v1;
    label_65:
        v5 = this.overlayHandlers.iterator();
        do {
            if(v5.hasNext()) {
                v0 = v5.next();
                if(!v0.isBackEnabled()) {
                    continue;
                }

                break;
            }
            else {
                goto label_74;
            }
        }
        while(true);

        goto label_75;
    label_74:
        v0 = v1;
    label_75:
        if(v0 == null) {
            v4 = this.defaultHandlers.iterator();
            goto label_78;
        }

        return ((NavigationEventHandler)v0);
        do {
        label_78:
            if(v4.hasNext()) {
                v5_1 = v4.next();
                if(!v5_1.isBackEnabled()) {
                    continue;
                }

                break;
            }

            return v1;
        }
        while(true);

        v1_1 = v5_1;
        return v1;
    }

    static NavigationEventHandler resolveEnabledHandler$default(NavigationEventProcessor arg0, int arg1, int arg2, Object arg3) {
        return arg0.resolveEnabledHandler(0);
    }

    public final void updateEnabledHandlerInfo$navigationevent(NavigationEventHandler arg4) {
        NavigationEventHandler v0 = this.inProgressHandler;
        if(v0 == null) {
            v0 = NavigationEventProcessor.resolveEnabledHandler$default(this, 0, 1, null);
        }

        if(!Intrinsics.areEqual(v0, arg4)) {
        }
        else {
            NavigationEventHistory v4 = v0 == null ? new NavigationEventHistory() : new NavigationEventHistory(v0.getCurrentInfo(), this.resolveCombinedBackInfo(), v0.getForwardInfo());
            if(Intrinsics.areEqual(this._history.getValue(), v4)) {
                return;
            }

            this._history.setValue(v4);
            Iterator v0_1 = this.overlayInputs.iterator();
            while(v0_1.hasNext()) {
                v0_1.next().doOnHistoryChanged$navigationevent(v4);
            }

            v0_1 = this.defaultInputs.iterator();
            while(v0_1.hasNext()) {
                v0_1.next().doOnHistoryChanged$navigationevent(v4);
            }

            Iterator v3 = this.unspecifiedInputs.iterator();
            while(v3.hasNext()) {
                v3.next().doOnHistoryChanged$navigationevent(v4);
            }
        }
    }
}

