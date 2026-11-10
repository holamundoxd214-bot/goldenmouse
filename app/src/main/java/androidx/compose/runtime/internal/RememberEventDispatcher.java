package androidx.compose.runtime.internal;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.ComposeRuntimeFlags;
import androidx.compose.runtime.GapRememberObserverHolder;
import androidx.compose.runtime.LinkRememberObserverHolder;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.composer.RememberManager;
import androidx.compose.runtime.composer.linkbuffer.LinkAnchorKt;
import androidx.compose.runtime.tooling.CompositionErrorContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001E\u0010\u001F\u001A\u00020\u00132\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0007\u001A\u0004\u0018\u00010\bJ:\u0010 \u001A\u00020\u00132\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0007\u001A\u0004\u0018\u00010\b2\u0017\u0010!\u001A\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00130\"¢\u0006\u0002\b#H\u0086\bJ\u0006\u0010$\u001A\u00020\u0013J\u0010\u0010\t\u001A\u00020\u00132\u0006\u0010%\u001A\u00020\u000BH\u0016J\u0010\u0010&\u001A\u00020\u00132\u0006\u0010%\u001A\u00020\u000BH\u0016J\u0016\u0010\'\u001A\u00020\u00132\f\u0010(\u001A\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\u0010\u0010)\u001A\u00020\u00132\u0006\u0010%\u001A\u00020\u0015H\u0016J\u0010\u0010\u0014\u001A\u00020\u00132\u0006\u0010%\u001A\u00020\u0015H\u0016J\u0010\u0010*\u001A\u00020\u00132\u0006\u0010+\u001A\u00020\u0018H\u0016J\u0010\u0010,\u001A\u00020\u00132\u0006\u0010+\u001A\u00020\u0018H\u0016J\u0010\u0010-\u001A\u00020\u00132\u0006\u0010+\u001A\u00020\u0018H\u0016J\u0006\u0010.\u001A\u00020\u0013J\u000E\u0010/\u001A\u00020\u00132\u0006\u0010%\u001A\u00020\u0015J\u0014\u00100\u001A\u00020\u00132\f\u00101\u001A\b\u0012\u0004\u0012\u00020\u000B0\u001EJ\u000E\u00102\u001A\n\u0012\u0004\u0012\u00020\u000B\u0018\u00010\u001EJ\u0016\u00103\u001A\u00020\u00132\f\u00104\u001A\b\u0012\u0004\u0012\u00020\u000B0\nH\u0002J\u0006\u00105\u001A\u00020\u0013J\u0006\u00106\u001A\u00020\u0013J\u0010\u00107\u001A\u00020\u00132\u0006\u0010%\u001A\u00020\u0010H\u0002J*\u00108\u001A\u0002H9\"\u0004\b\u0000\u001092\u0006\u0010%\u001A\u00020\u00102\f\u0010!\u001A\b\u0012\u0004\u0012\u0002H90\u0012H\u0082\b¢\u0006\u0002\u0010:R\u0016\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000B0\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u000B0\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00100\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0011\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001A\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\u0016\u001A\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0017X\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010\u001A\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\n\u0018\u00010\u001BX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u001CR\u0016\u0010\u001D\u001A\n\u0012\u0004\u0012\u00020\u000B\u0018\u00010\u001EX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006;"}, d2={"Landroidx/compose/runtime/internal/RememberEventDispatcher;", "Landroidx/compose/runtime/composer/RememberManager;", "<init>", "()V", "abandoning", "", "Landroidx/compose/runtime/RememberObserver;", "traceContext", "Landroidx/compose/runtime/tooling/CompositionErrorContext;", "remembering", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/runtime/RememberObserverHolder;", "rememberSet", "Landroidx/collection/MutableScatterSet;", "currentRememberingList", "leaving", "", "sideEffects", "Lkotlin/Function0;", "", "releasing", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "pausedPlaceholders", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/runtime/RecomposeScopeImpl;", "Landroidx/compose/runtime/internal/PausedCompositionRemembers;", "nestedRemembersLists", "Landroidx/compose/runtime/Stack;", "Ljava/util/ArrayList;", "ignoreLeavingSet", "Landroidx/collection/ScatterSet;", "prepare", "use", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "clear", "instance", "forgetting", "sideEffect", "effect", "deactivating", "rememberPausingScope", "scope", "startResumingScope", "endResumingScope", "dispatchRememberObservers", "dispatchOnDeactivateIfNecessary", "ignoreForgotten", "ignoreSet", "extractRememberSet", "dispatchRememberList", "list", "dispatchSideEffects", "dispatchAbandons", "recordLeaving", "withComposeStackTrace", "T", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class RememberEventDispatcher implements RememberManager {
    public static final int $stable = 8;
    private Set abandoning;
    private MutableVector currentRememberingList;
    private ScatterSet ignoreLeavingSet;
    private final MutableVector leaving;
    private ArrayList nestedRemembersLists;
    private MutableScatterMap pausedPlaceholders;
    private MutableScatterSet releasing;
    private MutableScatterSet rememberSet;
    private final MutableVector remembering;
    private final MutableVector sideEffects;
    private CompositionErrorContext traceContext;

    static {
    }

    public RememberEventDispatcher() {
        super();
        MutableVector v0 = new MutableVector(new RememberObserverHolder[16], 0);
        this.remembering = v0;
        this.rememberSet = ScatterSetKt.mutableScatterSetOf();
        this.currentRememberingList = v0;
        this.leaving = new MutableVector(new Object[16], 0);
        this.sideEffects = new MutableVector(new Function0[16], 0);
    }

    public final void clear() {
        this.abandoning = null;
        this.traceContext = null;
        this.remembering.clear();
        this.rememberSet.clear();
        this.currentRememberingList = this.remembering;
        this.leaving.clear();
        this.sideEffects.clear();
        this.releasing = null;
        this.pausedPlaceholders = null;
        this.nestedRemembersLists = null;
    }

    public void deactivating(ComposeNodeLifecycleCallback arg1) {
        this.recordLeaving(arg1);
    }

    public final void dispatchAbandons() {
        Set v2 = this.abandoning;
        if(v2 == null) {
        }
        else if(!v2.isEmpty()) {
            Object v0 = Trace.INSTANCE.beginSection("Compose:abandons");
            try {
                Iterator v2_2 = v2.iterator();
                while(v2_2.hasNext()) {
                    Object v1 = v2_2.next();
                    v2_2.remove();
                    ((RememberObserver)v1).onAbandoned();
                }
            }
            catch(Throwable v2_1) {
                goto label_22;
            }

            Trace.INSTANCE.endSection(v0);
            return;
        label_22:
            Trace.INSTANCE.endSection(v0);
            throw v2_1;
        }
    }

    public final void dispatchOnDeactivateIfNecessary(ComposeNodeLifecycleCallback arg1) {
        if(this.leaving.remove(arg1)) {
            arg1.onDeactivate();
        }
    }

    private final void dispatchRememberList(MutableVector arg6) {
        Unit v3;
        Set v0 = this.abandoning;
        if(v0 == null) {
        }
        else {
            Object[] v1 = arg6.content;
            int v6 = arg6.getSize();
            int v2 = 0;
            while(v2 < v6) {
                RememberObserver v4 = v1[v2].getWrapped();
                v0.remove(v4);
                try {
                    v4.onRemembered();
                    v3 = Unit.INSTANCE;
                    ++v2;
                    continue;
                }
                catch(Throwable v6_1) {
                    CompositionErrorContext v5 = this.traceContext;
                    if(v5 != null) {
                        v5.attachComposeStackTrace(v6_1, v3);
                    }

                    throw v6_1;
                }

                return;
            }
        }
    }

    public final void dispatchRememberObservers() {
        Object v4;
        int v3;
        Set v0 = this.abandoning;
        if(v0 == null) {
            return;
        }

        this.ignoreLeavingSet = null;
        if(this.leaving.getSize() != 0) {
            Object v1 = Trace.INSTANCE.beginSection("Compose:onForgotten");
            try {
                MutableScatterSet v2 = this.releasing;
                v3 = this.leaving.getSize() - 1;
                while(true) {
                label_15:
                    if(-1 < v3) {
                        v4 = this.leaving.content[v3];
                        break;
                    }
                    else {
                        goto label_44;
                    }
                }
            }
            catch(Throwable v6) {
                goto label_50;
            }

            try {
                if((v4 instanceof RememberObserverHolder)) {
                    RememberObserver v5 = v4.getWrapped();
                    v0.remove(v5);
                    v5.onForgotten();
                }

                if((v4 instanceof ComposeNodeLifecycleCallback)) {
                    if(v2 != null && (v2.contains(v4))) {
                        v4.onRelease();
                        goto label_36;
                    }

                    v4.onDeactivate();
                }

            label_36:
                Unit v4_1 = Unit.INSTANCE;
                --v3;
                goto label_15;
            }
            catch(Throwable v0_1) {
                try {
                    CompositionErrorContext v6_1 = this.traceContext;
                    if(v6_1 != null) {
                        v6_1.attachComposeStackTrace(v0_1, v4);
                    }

                    throw v0_1;
                label_44:
                }
                catch(Throwable v6) {
                    goto label_50;
                }
            }

            Trace.INSTANCE.endSection(v1);
            goto label_52;
        label_50:
            Trace.INSTANCE.endSection(v1);
            throw v6;
        }

    label_52:
        if(this.remembering.getSize() != 0) {
            Object v0_2 = Trace.INSTANCE.beginSection("Compose:onRemembered");
            try {
                this.dispatchRememberList(this.remembering);
            }
            catch(Throwable v6) {
                Trace.INSTANCE.endSection(v0_2);
                throw v6;
            }

            Trace.INSTANCE.endSection(v0_2);
            return;
        }
    }

    public final void dispatchSideEffects() {
        if(this.sideEffects.getSize() == 0) {
            return;
        }

        Object v0 = Trace.INSTANCE.beginSection("Compose:sideeffects");
        try {
            MutableVector v1 = this.sideEffects;
            Object[] v2 = v1.content;
            int v1_1 = v1.getSize();
            int v3;
            for(v3 = 0; v3 < v1_1; ++v3) {
                v2[v3].invoke();
            }

            this.sideEffects.clear();
        }
        catch(Throwable v5) {
            goto label_23;
        }

        Trace.INSTANCE.endSection(v0);
        return;
    label_23:
        Trace.INSTANCE.endSection(v0);
        throw v5;
    }

    public void endResumingScope(RecomposeScopeImpl arg3) {
        MutableScatterMap v0 = this.pausedPlaceholders;
        if(v0 != null && v0.get(arg3) != null) {
            ArrayList v1 = this.nestedRemembersLists;
            if(v1 != null) {
                Object v1_1 = Stack.pop-impl(v1);
                if(v1_1 != null) {
                    this.currentRememberingList = ((MutableVector)v1_1);
                }
            }

            v0.remove(arg3);
        }
    }

    public final ScatterSet extractRememberSet() {
        if(this.rememberSet.isNotEmpty()) {
            MutableScatterSet v0 = this.rememberSet;
            this.rememberSet = ScatterSetKt.mutableScatterSetOf();
            this.remembering.clear();
            return ((ScatterSet)v0);
        }

        return null;
    }

    public void forgetting(RememberObserverHolder arg2) {
        if(this.rememberSet.contains(arg2)) {
            this.rememberSet.remove(arg2);
            if(!this.currentRememberingList.remove(arg2)) {
                if(this.remembering.remove(arg2)) {
                }
                else {
                    RememberEventDispatcher.forgetting$removeFrom(arg2, this.remembering);
                }
            }

            Set v1 = this.abandoning;
            if(v1 == null) {
                return;
            }

            v1.add(arg2.getWrapped());
            return;
        }
        else {
            ScatterSet v0 = this.ignoreLeavingSet;
            if(v0 != null) {
                if(!v0.contains(arg2)) {
                }
                else {
                    return;
                }
            }

            goto label_26;
        }

        return;
    label_26:
        this.recordLeaving(arg2);
    }

    private static final boolean forgetting$removeFrom(RememberObserverHolder arg6, MutableVector arg7) {
        Object[] v0 = arg7.content;
        int v7 = arg7.getSize();
        int v2;
        for(v2 = 0; v2 < v7; ++v2) {
            RememberObserver v3 = v0[v2].getWrapped();
            if((v3 instanceof PausedCompositionRemembers)) {
                MutableVector v3_1 = ((PausedCompositionRemembers)v3).getPausedRemembers();
                if(v3_1.remove(arg6)) {
                    return 1;
                }
                else if(RememberEventDispatcher.forgetting$removeFrom(arg6, v3_1)) {
                    return 1;
                }
            }
        }

        return 0;
    }

    public final void ignoreForgotten(ScatterSet arg1) {
        this.ignoreLeavingSet = arg1;
    }

    public final void prepare(Set arg1, CompositionErrorContext arg2) {
        this.clear();
        this.abandoning = arg1;
        this.traceContext = arg2;
    }

    private final void recordLeaving(Object arg1) {
        this.leaving.add(arg1);
    }

    public void releasing(ComposeNodeLifecycleCallback arg2) {
        MutableScatterSet v0 = this.releasing;
        if(v0 == null) {
            v0 = ScatterSetKt.mutableScatterSetOf();
            this.releasing = v0;
        }

        v0.plusAssign(arg2);
        this.recordLeaving(arg2);
    }

    public void rememberPausingScope(RecomposeScopeImpl arg3) {
        LinkRememberObserverHolder v3;
        Set v0 = this.abandoning;
        if(v0 == null) {
            return;
        }

        PausedCompositionRemembers v1 = new PausedCompositionRemembers(v0);
        MutableScatterMap v0_1 = this.pausedPlaceholders;
        if(v0_1 == null) {
            v0_1 = ScatterMapKt.mutableScatterMapOf();
            this.pausedPlaceholders = v0_1;
        }

        v0_1.set(arg3, v1);
        MutableVector v2 = this.currentRememberingList;
        if(ComposeRuntimeFlags.isLinkBufferComposerEnabled) {
            v3 = new LinkRememberObserverHolder(((RememberObserver)v1), LinkAnchorKt.getNullAnchor());
        }
        else {
            GapRememberObserverHolder v3_1 = new GapRememberObserverHolder(((RememberObserver)v1), -1);
        }

        v2.add(v3);
    }

    public void remembering(RememberObserverHolder arg2) {
        this.currentRememberingList.add(arg2);
        this.rememberSet.add(arg2);
    }

    public void sideEffect(Function0 arg1) {
        this.sideEffects.add(arg1);
    }

    public void startResumingScope(RecomposeScopeImpl arg3) {
        MutableScatterMap v0 = this.pausedPlaceholders;
        ArrayList v1 = null;
        Object v3 = v0 != null ? v0.get(arg3) : v1;
        if(v3 != null) {
            ArrayList v0_1 = this.nestedRemembersLists;
            if(v0_1 == null) {
                v0_1 = Stack.constructor-impl$default(v1, 1, ((DefaultConstructorMarker)v1));
                this.nestedRemembersLists = v0_1;
            }

            Stack.push-impl(v0_1, this.currentRememberingList);
            this.currentRememberingList = ((PausedCompositionRemembers)v3).getPausedRemembers();
        }
    }

    public final void use(Set arg1, CompositionErrorContext arg2, Function1 arg3) {
        try {
            this.prepare(arg1, arg2);
            arg3.invoke(this);
        }
        catch(Throwable v1) {
            this.clear();
            throw v1;
        }

        this.clear();
    }

    private final Object withComposeStackTrace(Object arg1, Function0 arg2) {
        Object v0;
        try {
            v0 = arg2.invoke();
            return v0;
        }
        catch(Throwable v2) {
            CompositionErrorContext v0_1 = ((RememberEventDispatcher)v0).traceContext;
            if(v0_1 != null) {
                v0_1.attachComposeStackTrace(v2, arg1);
            }

            throw v2;
        }
    }
}

