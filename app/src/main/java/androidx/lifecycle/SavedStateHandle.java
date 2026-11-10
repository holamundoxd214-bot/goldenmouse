package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.internal.SavedStateHandleImpl;
import androidx.lifecycle.internal.SavedStateHandleImpl_androidKt;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateRegistry$SavedStateProvider;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 -2\u00020\u0001:\u0002,-B\u001F\b\u0017\u0012\u0014\u0010\u0002\u001A\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0017¢\u0006\u0004\b\u0005\u0010\u0007J\b\u0010\r\u001A\u00020\u000EH\u0007J\u0011\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0004H\u0087\u0002J\u001C\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0011\u001A\u00020\u0004H\u0007J)\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0011\u001A\u00020\u00042\u0006\u0010\u0015\u001A\u0002H\u0014H\u0007¢\u0006\u0002\u0010\u0016J1\u0010\u0017\u001A\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0011\u001A\u00020\u00042\u0006\u0010\u0018\u001A\u00020\u00102\u0006\u0010\u0015\u001A\u0002H\u0014H\u0002¢\u0006\u0002\u0010\u0019J)\u0010\u001A\u001A\b\u0012\u0004\u0012\u0002H\u00140\u001B\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0011\u001A\u00020\u00042\u0006\u0010\u0015\u001A\u0002H\u0014H\u0007¢\u0006\u0002\u0010\u001CJ)\u0010\u001D\u001A\b\u0012\u0004\u0012\u0002H\u00140\u001E\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0011\u001A\u00020\u00042\u0006\u0010\u0015\u001A\u0002H\u0014H\u0007¢\u0006\u0002\u0010\u001FJ\u000E\u0010 \u001A\b\u0012\u0004\u0012\u00020\u00040!H\u0007J\u001E\u0010\"\u001A\u0004\u0018\u0001H\u0014\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0011\u001A\u00020\u0004H\u0087\u0002¢\u0006\u0002\u0010#J&\u0010$\u001A\u00020%\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0011\u001A\u00020\u00042\b\u0010&\u001A\u0004\u0018\u0001H\u0014H\u0087\u0002¢\u0006\u0002\u0010\'J\u001D\u0010(\u001A\u0004\u0018\u0001H\u0014\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0011\u001A\u00020\u0004H\u0007¢\u0006\u0002\u0010#J\u0018\u0010)\u001A\u00020%2\u0006\u0010\u0011\u001A\u00020\u00042\u0006\u0010*\u001A\u00020\u000EH\u0007J\u0010\u0010+\u001A\u00020%2\u0006\u0010\u0011\u001A\u00020\u0004H\u0007R\u001E\u0010\b\u001A\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006."}, d2={"Landroidx/lifecycle/SavedStateHandle;", "", "initialState", "", "", "<init>", "(Ljava/util/Map;)V", "()V", "liveDatas", "", "Landroidx/lifecycle/SavedStateHandle$SavingStateLiveData;", "impl", "Landroidx/lifecycle/internal/SavedStateHandleImpl;", "savedStateProvider", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "contains", "", "key", "getLiveData", "Landroidx/lifecycle/MutableLiveData;", "T", "initialValue", "(Ljava/lang/String;Ljava/lang/Object;)Landroidx/lifecycle/MutableLiveData;", "getLiveDataInternal", "hasInitialValue", "(Ljava/lang/String;ZLjava/lang/Object;)Landroidx/lifecycle/MutableLiveData;", "getStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "(Ljava/lang/String;Ljava/lang/Object;)Lkotlinx/coroutines/flow/StateFlow;", "getMutableStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "(Ljava/lang/String;Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;", "keys", "", "get", "(Ljava/lang/String;)Ljava/lang/Object;", "set", "", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "remove", "setSavedStateProvider", "provider", "clearSavedStateProvider", "SavingStateLiveData", "Companion", "lifecycle-viewmodel-savedstate"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SavedStateHandle {
    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001A\u00020\u00052\u000E\u0010\u0006\u001A\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\u000E\u0010\t\u001A\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bH\u0007J\u0012\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001H\u0007¨\u0006\r"}, d2={"Landroidx/lifecycle/SavedStateHandle$Companion;", "", "<init>", "()V", "createHandle", "Landroidx/lifecycle/SavedStateHandle;", "restoredState", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "defaultState", "validateValue", "", "value", "lifecycle-viewmodel-savedstate"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        @JvmStatic public final SavedStateHandle createHandle(Bundle arg1, Bundle arg2) {
            if(arg1 == null) {
                arg1 = arg2;
            }

            if(arg1 == null) {
                return new SavedStateHandle();
            }

            ClassLoader v0 = SavedStateHandle.class.getClassLoader();
            Intrinsics.checkNotNull(v0);
            arg1.setClassLoader(v0);
            return new SavedStateHandle(SavedStateReader.toMap-impl(SavedStateReader.constructor-impl(arg1)));
        }

        public final boolean validateValue(Object arg1) {
            return SavedStateHandleImpl_androidKt.isAcceptableType(arg1);
        }
    }

    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\b\u0016\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00028\u0000¢\u0006\u0004\b\b\u0010\tB\u001B\b\u0016\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\nJ\u0015\u0010\u000B\u001A\u00020\f2\u0006\u0010\u0007\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\rJ\u0006\u0010\u000E\u001A\u00020\fR\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001A\u0004\u0018\u00010\u0004X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"Landroidx/lifecycle/SavedStateHandle$SavingStateLiveData;", "T", "Landroidx/lifecycle/MutableLiveData;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "key", "", "value", "<init>", "(Landroidx/lifecycle/SavedStateHandle;Ljava/lang/String;Ljava/lang/Object;)V", "(Landroidx/lifecycle/SavedStateHandle;Ljava/lang/String;)V", "setValue", "", "(Ljava/lang/Object;)V", "detach", "lifecycle-viewmodel-savedstate"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SavingStateLiveData extends MutableLiveData {
        private SavedStateHandle handle;
        private String key;

        public SavingStateLiveData(SavedStateHandle arg2, String arg3, Object arg4) {
            Intrinsics.checkNotNullParameter(arg3, "key");
            super(arg4);
            this.key = arg3;
            this.handle = arg2;
        }

        public SavingStateLiveData(SavedStateHandle arg2, String arg3) {
            Intrinsics.checkNotNullParameter(arg3, "key");
            super();
            this.key = arg3;
            this.handle = arg2;
        }

        public final void detach() {
            this.handle = null;
        }

        public void setValue(Object arg3) {
            SavedStateHandle v0 = this.handle;
            if(v0 != null) {
                SavedStateHandleImpl v0_1 = v0.impl;
                if(v0_1 != null) {
                    v0_1.set(this.key, arg3);
                }
            }

            super.setValue(arg3);
        }
    }

    public static final Companion Companion;
    private SavedStateHandleImpl impl;
    private final Map liveDatas;

    static {
        SavedStateHandle.Companion = new Companion(null);
    }

    public SavedStateHandle() {
        super();
        this.liveDatas = new LinkedHashMap();
        this.impl = new SavedStateHandleImpl(null, 1, null);
    }

    public SavedStateHandle(Map arg2) {
        Intrinsics.checkNotNullParameter(arg2, "initialState");
        super();
        this.liveDatas = new LinkedHashMap();
        this.impl = new SavedStateHandleImpl(arg2);
    }

    public static final SavedStateHandleImpl access$getImpl$p(SavedStateHandle arg0) {
        return arg0.impl;
    }

    public final void clearSavedStateProvider(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        this.impl.clearSavedStateProvider(arg2);
    }

    public final boolean contains(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return this.impl.contains(arg2);
    }

    @JvmStatic public static final SavedStateHandle createHandle(Bundle arg1, Bundle arg2) {
        return SavedStateHandle.Companion.createHandle(arg1, arg2);
    }

    public final Object get(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return this.impl.get(arg2);
    }

    public final MutableLiveData getLiveData(String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "key");
        MutableLiveData v2 = this.getLiveDataInternal(arg3, false, null);
        Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<T of androidx.lifecycle.SavedStateHandle.getLiveData>");
        return v2;
    }

    public final MutableLiveData getLiveData(String arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return this.getLiveDataInternal(arg2, true, arg3);
    }

    private final MutableLiveData getLiveDataInternal(String arg3, boolean arg4, Object arg5) {
        SavingStateLiveData v4;
        if(!this.impl.getMutableFlows().containsKey(arg3)) {
            Map v0 = this.liveDatas;
            Object v1 = v0.get(arg3);
            if(v1 == null) {
                if(this.impl.getRegular().containsKey(arg3)) {
                    v4 = new SavingStateLiveData(this, arg3, this.impl.getRegular().get(arg3));
                }
                else if(arg4) {
                    this.impl.getRegular().put(arg3, arg5);
                    v4 = new SavingStateLiveData(this, arg3, arg5);
                }
                else {
                    v4 = new SavingStateLiveData(this, arg3);
                }

                SavingStateLiveData v1_1 = v4;
                v0.put(arg3, v1_1);
            }

            return ((MutableLiveData)v1);
        }

        throw new IllegalArgumentException(SavedStateHandle_androidKt.access$createMutuallyExclusiveErrorMessage(arg3).toString());
    }

    public final MutableStateFlow getMutableStateFlow(String arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        if(!this.liveDatas.containsKey(arg2)) {
            return this.impl.getMutableStateFlow(arg2, arg3);
        }

        throw new IllegalArgumentException(SavedStateHandle_androidKt.access$createMutuallyExclusiveErrorMessage(arg2).toString());
    }

    public final StateFlow getStateFlow(String arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        boolean v0 = this.impl.getMutableFlows().containsKey(arg2);
        SavedStateHandleImpl v1 = this.impl;
        if(v0) {
            return FlowKt.asStateFlow(v1.getMutableStateFlow(arg2, arg3));
        }

        return v1.getStateFlow(arg2, arg3);
    }

    public final Set keys() {
        return SetsKt.plus(this.impl.keys(), this.liveDatas.keySet());
    }

    public final Object remove(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Object v0 = this.impl.remove(arg2);
        Object v1 = this.liveDatas.remove(arg2);
        if(v1 != null) {
            ((SavingStateLiveData)v1).detach();
        }

        return v0;
    }

    public final SavedStateProvider savedStateProvider() {
        return this.impl.getSavedStateProvider();
    }

    public final void set(String arg3, Object arg4) {
        Intrinsics.checkNotNullParameter(arg3, "key");
        if(SavedStateHandle.Companion.validateValue(arg4)) {
            Object v0 = this.liveDatas.get(arg3);
            if((v0 instanceof MutableLiveData)) {
            }
            else {
                v0 = null;
            }

            if(v0 != null) {
                ((MutableLiveData)v0).setValue(arg4);
            }

            this.impl.set(arg3, arg4);
            return;
        }

        Intrinsics.checkNotNull(arg4);
        throw new IllegalArgumentException("Can\'t put value with type " + arg4.getClass() + " into saved state".toString());
    }

    public final void setSavedStateProvider(String arg2, SavedStateProvider arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "provider");
        this.impl.setSavedStateProvider(arg2, arg3);
    }
}

