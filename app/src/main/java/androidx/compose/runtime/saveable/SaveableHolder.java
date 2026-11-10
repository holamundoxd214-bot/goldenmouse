package androidx.compose.runtime.saveable;

import androidx.compose.runtime.RememberObserver;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003BG\u0012\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00028\u0000\u0012\u0010\u0010\f\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\r¢\u0006\u0004\b\u000E\u0010\u000FJK\u0010\u0016\u001A\u00020\u00172\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0007\u001A\u0004\u0018\u00010\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00028\u00002\u0010\u0010\f\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\r¢\u0006\u0002\u0010\u000FJ\b\u0010\u0018\u001A\u00020\u0017H\u0002J\u0010\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u000B\u001A\u00020\u0006H\u0016J\b\u0010\u001B\u001A\u00020\u0017H\u0016J\b\u0010\u001C\u001A\u00020\u0017H\u0016J\b\u0010\u001D\u001A\u00020\u0017H\u0016J\u001F\u0010\u001E\u001A\u0004\u0018\u00018\u00002\u0010\u0010\f\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\r¢\u0006\u0002\u0010\u001FR\u001A\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000B\u001A\u00028\u0000X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0010R\u001A\u0010\f\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\rX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0012\u001A\u0004\u0018\u00010\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2={"Landroidx/compose/runtime/saveable/SaveableHolder;", "T", "Landroidx/compose/runtime/saveable/SaverScope;", "Landroidx/compose/runtime/RememberObserver;", "saver", "Landroidx/compose/runtime/saveable/Saver;", "", "registry", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "key", "", "value", "inputs", "", "<init>", "(Landroidx/compose/runtime/saveable/Saver;Landroidx/compose/runtime/saveable/SaveableStateRegistry;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "Ljava/lang/Object;", "[Ljava/lang/Object;", "entry", "Landroidx/compose/runtime/saveable/SaveableStateRegistry$Entry;", "valueProvider", "Lkotlin/Function0;", "update", "", "register", "canBeSaved", "", "onRemembered", "onForgotten", "onAbandoned", "getValueIfInputsDidntChange", "([Ljava/lang/Object;)Ljava/lang/Object;", "runtime-saveable"}, k=1, mv={2, 1, 0}, xi=0x30) final class SaveableHolder implements RememberObserver, SaverScope {
    private Entry entry;
    private Object[] inputs;
    private String key;
    private SaveableStateRegistry registry;
    private Saver saver;
    private Object value;
    private final Function0 valueProvider;

    public SaveableHolder(Saver arg1, SaveableStateRegistry arg2, String arg3, Object arg4, Object[] arg5) {
        super();
        this.saver = arg1;
        this.registry = arg2;
        this.key = arg3;
        this.value = arg4;
        this.inputs = arg5;
        this.valueProvider = new SaveableHolder$$ExternalSyntheticLambda0(this);
    }

    public boolean canBeSaved(Object arg1) {
        SaveableStateRegistry v0 = this.registry;
        if(v0 != null) {
            if(v0.canBeSaved(arg1)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public final Object getValueIfInputsDidntChange(Object[] arg2) {
        if(Arrays.equals(arg2, this.inputs)) {
            return this.value;
        }

        return null;
    }

    public void onAbandoned() {
        Entry v0 = this.entry;
        if(v0 != null) {
            v0.unregister();
        }
    }

    public void onForgotten() {
        Entry v0 = this.entry;
        if(v0 != null) {
            v0.unregister();
        }
    }

    public void onRemembered() {
        this.register();
    }

    private final void register() {
        SaveableStateRegistry v0 = this.registry;
        if(this.entry == null) {
            if(v0 != null) {
                RememberSaveableKt.requireCanBeSaved(v0, this.valueProvider.invoke());
                this.entry = v0.registerProvider(this.key, this.valueProvider);
            }

            return;
        }

        throw new IllegalArgumentException("entry(" + this.entry + ") is not null".toString());
    }

    public final void update(Saver arg3, SaveableStateRegistry arg4, String arg5, Object arg6, Object[] arg7) {
        int v4;
        int v1 = 1;
        if(this.registry != arg4) {
            this.registry = arg4;
            v4 = 1;
        }
        else {
            v4 = 0;
        }

        if(!Intrinsics.areEqual(this.key, arg5)) {
            this.key = arg5;
        }
        else {
            v1 = v4;
        }

        this.saver = arg3;
        this.value = arg6;
        this.inputs = arg7;
        Entry v3 = this.entry;
        if(v3 != null && v1 != 0) {
            if(v3 != null) {
                v3.unregister();
            }

            this.entry = null;
            this.register();
        }
    }

    static final Object valueProvider$lambda$0(SaveableHolder arg2) {
        Saver v0 = arg2.saver;
        SaveableHolder v1 = arg2;
        Object v2 = arg2.value;
        if(v2 != null) {
            return v0.save(((SaverScope)v1), v2);
        }

        throw new IllegalArgumentException("Value should be initialized".toString());
    }
}

