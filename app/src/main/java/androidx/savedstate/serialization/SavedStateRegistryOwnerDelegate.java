package androidx.savedstate.serialization;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.savedstate.SavedStateRegistry$SavedStateProvider;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateWriter;
import androidx.savedstate.internal.CanonicalName_jvmKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0004:\u0001#B=\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\b\u0012\b\u0010\t\u001A\u0004\u0018\u00010\n\u0012\u0006\u0010\u000B\u001A\u00020\f\u0012\f\u0010\r\u001A\b\u0012\u0004\u0012\u00028\u00000\u000E¢\u0006\u0004\b\u000F\u0010\u0010J$\u0010\u0012\u001A\u00028\u00002\b\u0010\u0013\u001A\u0004\u0018\u00010\u00032\n\u0010\u0014\u001A\u0006\u0012\u0002\b\u00030\u0015H\u0096\u0002¢\u0006\u0002\u0010\u0016J,\u0010\u0017\u001A\u00020\u00182\b\u0010\u0013\u001A\u0004\u0018\u00010\u00032\n\u0010\u0014\u001A\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u0019\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u001AJ\u0011\u0010\u001B\u001A\u00060\u001Cj\u0002`\u001DH\u0016¢\u0006\u0002\u0010\u001EJ\u0017\u0010\u001F\u001A\u0004\u0018\u00018\u00002\u0006\u0010 \u001A\u00020\nH\u0002¢\u0006\u0002\u0010!J\u001E\u0010\"\u001A\u00020\n2\b\u0010\u0013\u001A\u0004\u0018\u00010\u00032\n\u0010\u0014\u001A\u0006\u0012\u0002\b\u00030\u0015H\u0002R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001A\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001A\b\u0012\u0004\u0012\u00028\u00000\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001A\u0004\u0018\u00010\u0003X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006$"}, d2={"Landroidx/savedstate/serialization/SavedStateRegistryOwnerDelegate;", "T", "Lkotlin/properties/ReadWriteProperty;", "", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "registry", "Landroidx/savedstate/SavedStateRegistry;", "serializer", "Lkotlinx/serialization/KSerializer;", "key", "", "configuration", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "init", "Lkotlin/Function0;", "<init>", "(Landroidx/savedstate/SavedStateRegistry;Lkotlinx/serialization/KSerializer;Ljava/lang/String;Landroidx/savedstate/serialization/SavedStateConfiguration;Lkotlin/jvm/functions/Function0;)V", "cachedValue", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "saveState", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "()Landroid/os/Bundle;", "loadInitialValue", "qualifiedKey", "(Ljava/lang/String;)Ljava/lang/Object;", "getQualifiedKey", "UNINITIALIZED", "savedstate"}, k=1, mv={2, 0, 0}, xi=0x30) final class SavedStateRegistryOwnerDelegate implements SavedStateProvider, ReadWriteProperty {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2={"Landroidx/savedstate/serialization/SavedStateRegistryOwnerDelegate$UNINITIALIZED;", "", "<init>", "()V", "savedstate"}, k=1, mv={2, 0, 0}, xi=0x30) final class UNINITIALIZED {
        public static final UNINITIALIZED INSTANCE;

        static {
            UNINITIALIZED.INSTANCE = new UNINITIALIZED();
        }

        private UNINITIALIZED() {
            super();
        }
    }

    private Object cachedValue;
    private final SavedStateConfiguration configuration;
    private final Function0 init;
    private final String key;
    private final SavedStateRegistry registry;
    private final KSerializer serializer;

    public SavedStateRegistryOwnerDelegate(SavedStateRegistry arg2, KSerializer arg3, String arg4, SavedStateConfiguration arg5, Function0 arg6) {
        Intrinsics.checkNotNullParameter(arg2, "registry");
        Intrinsics.checkNotNullParameter(arg3, "serializer");
        Intrinsics.checkNotNullParameter(arg5, "configuration");
        Intrinsics.checkNotNullParameter(arg6, "init");
        super();
        this.registry = arg2;
        this.serializer = arg3;
        this.key = arg4;
        this.configuration = arg5;
        this.init = arg6;
        this.cachedValue = UNINITIALIZED.INSTANCE;
    }

    private final String getQualifiedKey(Object arg1, KProperty arg2) {
        String v0 = this.key;
        if(v0 != null) {
            return v0;
        }

        v0 = arg1 != null ? CanonicalName_jvmKt.getCanonicalName(Reflection.getOrCreateKotlinClass(arg1.getClass())) + '.' : "";
        return v0 + arg2.getName();
    }

    public Object getValue(Object arg3, KProperty arg4) {
        Intrinsics.checkNotNullParameter(arg4, "property");
        if(Intrinsics.areEqual(this.cachedValue, UNINITIALIZED.INSTANCE)) {
            String v3 = this.getQualifiedKey(arg3, arg4);
            this.registry.registerSavedStateProvider(v3, this);
            this.cachedValue = this.loadInitialValue(v3);
        }

        return this.cachedValue;
    }

    private final Object loadInitialValue(String arg3) {
        Bundle v3 = this.registry.consumeRestoredStateForKey(arg3);
        if(v3 == null) {
            return this.init.invoke();
        }

        KSerializer v0 = this.serializer;
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<{T of androidx.savedstate.serialization.SavedStateRegistryOwnerDelegate & Any}>");
        return SavedStateDecoderKt.decodeFromSavedStateNullable(((DeserializationStrategy)v0), v3, this.configuration);
    }

    public Bundle saveState() {
        Object[] v4_3;
        if(Intrinsics.areEqual(this.cachedValue, UNINITIALIZED.INSTANCE)) {
            Map v4 = MapsKt.emptyMap();
            if(v4.isEmpty()) {
                Pair[] v4_1 = new Pair[0];
            }
            else {
                ArrayList v0 = new ArrayList(v4.size());
                Iterator v4_2 = v4.entrySet().iterator();
                while(v4_2.hasNext()) {
                    Object v2 = v4_2.next();
                    ((Collection)v0).add(TuplesKt.to(((Map$Entry)v2).getKey(), ((Map$Entry)v2).getValue()));
                }

                v4_3 = ((Collection)v0).toArray(new Pair[0]);
            }

            Bundle v4_4 = BundleKt.bundleOf(Arrays.copyOf(v4_3, ((Pair[])v4_3).length));
            SavedStateWriter.constructor-impl(v4_4);
            return v4_4;
        }

        return SavedStateEncoderKt.encodeToSavedStateNullable(this.serializer, this.cachedValue, this.configuration);
    }

    public void setValue(Object arg3, KProperty arg4, Object arg5) {
        Intrinsics.checkNotNullParameter(arg4, "property");
        if(Intrinsics.areEqual(this.cachedValue, UNINITIALIZED.INSTANCE)) {
            this.registry.registerSavedStateProvider(this.getQualifiedKey(arg3, arg4), this);
        }

        this.cachedValue = arg5;
    }
}

