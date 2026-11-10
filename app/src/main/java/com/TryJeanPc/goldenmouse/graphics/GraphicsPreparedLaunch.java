package com.TryJeanPc.goldenmouse.graphics;

import com.TryJeanPc.goldenmouse.controls.VistaActivationCapture$Companion$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\b\u001A\u00020\tJ#\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00028\u0000¢\u0006\u0002\u0010\u0010J\u001D\u0010\u0011\u001A\u0004\u0018\u00018\u00002\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r¢\u0006\u0002\u0010\u0012R\u001C\u0010\u0005\u001A\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2={"Lcom/TryJeanPc/goldenmouse/graphics/GraphicsPreparedLaunch;", "T", "", "<init>", "()V", "pending", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsPreparedLaunch$Entry;", "hasPending", "", "put", "", "id", "", "pkg", "value", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "take", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "Entry", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GraphicsPreparedLaunch {
    @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0010\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u001F\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0006\u001A\u00028\u0001¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000F\u001A\u00020\u0004HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0004HÆ\u0003J\u000E\u0010\u0011\u001A\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\rJ2\u0010\u0012\u001A\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0006\u001A\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001A\u00020\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001A\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0013\u0010\u0006\u001A\u00028\u0001¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\f\u0010\r¨\u0006\u001A"}, d2={"Lcom/TryJeanPc/goldenmouse/graphics/GraphicsPreparedLaunch$Entry;", "T", "", "id", "", "pkg", "value", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "getId", "()Ljava/lang/String;", "getPkg", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Lcom/TryJeanPc/goldenmouse/graphics/GraphicsPreparedLaunch$Entry;", "equals", "", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class Entry {
        private final String id;
        private final String pkg;
        private final Object value;

        public Entry(String arg2, String arg3, Object arg4) {
            Intrinsics.checkNotNullParameter(arg2, "id");
            Intrinsics.checkNotNullParameter(arg3, "pkg");
            super();
            this.id = arg2;
            this.pkg = arg3;
            this.value = arg4;
        }

        public final String component1() {
            return this.id;
        }

        public final String component2() {
            return this.pkg;
        }

        public final Object component3() {
            return this.value;
        }

        public final Entry copy(String arg1, String arg2, Object arg3) {
            Intrinsics.checkNotNullParameter(arg1, "id");
            Intrinsics.checkNotNullParameter(arg2, "pkg");
            return new Entry(arg1, arg2, arg3);
        }

        public static Entry copy$default(Entry arg0, String arg1, String arg2, Object arg3, int arg4, Object arg5) {
            if((arg4 & 1) != 0) {
                arg1 = arg0.id;
            }

            if((arg4 & 2) != 0) {
                arg2 = arg0.pkg;
            }

            if((arg4 & 4) != 0) {
                arg3 = arg0.value;
            }

            return arg0.copy(arg1, arg2, arg3);
        }

        public boolean equals(Object arg5) {
            if(this == (((Entry)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof Entry)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.id, ((Entry)arg5).id)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.pkg, ((Entry)arg5).pkg)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.value, ((Entry)arg5).value)) {
                return 0;
            }

            return 1;
        }

        public final String getId() {
            return this.id;
        }

        public final String getPkg() {
            return this.pkg;
        }

        public final Object getValue() {
            return this.value;
        }

        public int hashCode() {
            int v0 = (this.id.hashCode() * 0x1F + this.pkg.hashCode()) * 0x1F;
            Object v2 = this.value;
            int v2_1 = v2 == null ? 0 : v2.hashCode();
            return v0 + v2_1;
        }

        public String toString() {
            return "Entry(id=" + this.id + ", pkg=" + this.pkg + ", value=" + this.value + ")";
        }
    }

    public static final int $stable = 8;
    private final AtomicReference pending;

    static {
    }

    public GraphicsPreparedLaunch() {
        super();
        this.pending = new AtomicReference(null);
    }

    public final boolean hasPending() {
        if(this.pending.get() != null) {
            return 1;
        }

        return 0;
    }

    public final void put(String arg2, String arg3, Object arg4) {
        Intrinsics.checkNotNullParameter(arg2, "id");
        Intrinsics.checkNotNullParameter(arg3, "pkg");
        this.pending.set(new Entry(arg2, arg3, arg4));
    }

    public final Object take(String arg4, String arg5) {
        Intrinsics.checkNotNullParameter(arg4, "id");
        Intrinsics.checkNotNullParameter(arg5, "pkg");
        Object v0 = this.pending.get();
        Object v1 = null;
        if(v0 != null) {
            if(!Intrinsics.areEqual(((Entry)v0).getId(), arg4) || !Intrinsics.areEqual(((Entry)v0).getPkg(), arg5)) {
                v0 = v1;
            }
            else {
            }

            if(v0 == null) {
                return v1;
            }

            if(!VistaActivationCapture$Companion$$ExternalSyntheticBackportWithForwarding0.m(this.pending, v0, v1)) {
                return v1;
            }

            return ((Entry)v0).getValue();
        }

        return v1;
    }
}

