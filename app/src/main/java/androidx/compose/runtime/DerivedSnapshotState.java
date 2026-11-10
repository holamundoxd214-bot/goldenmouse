package androidx.compose.runtime;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.internal.System_jvmKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.snapshots.StateRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001(B%\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u000E\u0010\u0006\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000E\u001A\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u000F\u001A\u00020\u0010J:\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00000\r2\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u00142\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0002J\u0010\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u0016H\u0016J\b\u0010!\u001A\u00020\"H\u0016J\b\u0010\'\u001A\u00020\"H\u0002R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\u0006\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001A\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001B\u001A\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001DR\u001A\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00000\u001E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001F\u0010 R\u0019\u0010#\u001A\u0004\u0018\u00018\u00008G¢\u0006\f\u0012\u0004\b$\u0010%\u001A\u0004\b&\u0010\u001D¨\u0006)"}, d2={"Landroidx/compose/runtime/DerivedSnapshotState;", "T", "Landroidx/compose/runtime/snapshots/StateObjectImpl;", "Landroidx/compose/runtime/DerivedState;", "calculation", "Lkotlin/Function0;", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "<init>", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/SnapshotMutationPolicy;)V", "getPolicy", "()Landroidx/compose/runtime/SnapshotMutationPolicy;", "first", "Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", "current", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "currentRecord", "readable", "forceDependencyReads", "", "firstStateRecord", "Landroidx/compose/runtime/snapshots/StateRecord;", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "prependStateRecord", "", "value", "getValue", "()Ljava/lang/Object;", "Landroidx/compose/runtime/DerivedState$Record;", "getCurrentRecord", "()Landroidx/compose/runtime/DerivedState$Record;", "toString", "", "debuggerDisplayValue", "getDebuggerDisplayValue$annotations", "()V", "getDebuggerDisplayValue", "displayValue", "ResultRecord", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class DerivedSnapshotState extends StateObjectImpl implements DerivedState {
    @Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 2*\u0004\b\u0001\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u00012B\u0013\u0012\n\u0010\u0004\u001A\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010$\u001A\u00020%2\u0006\u0010&\u001A\u00020\u0002H\u0016J\b\u0010\'\u001A\u00020\u0002H\u0016J\u0019\u0010\'\u001A\u00020\u00022\n\u0010\u0004\u001A\u00060\u0005j\u0002`\u0006H\u0016¢\u0006\u0002\u0010(J\u001A\u0010)\u001A\u00020*2\n\u0010+\u001A\u0006\u0012\u0002\b\u00030,2\u0006\u0010-\u001A\u00020.J\u001A\u0010/\u001A\u00020\u000F2\n\u0010+\u001A\u0006\u0012\u0002\b\u00030,2\u0006\u0010-\u001A\u00020.R \u0010\t\u001A\u00060\u0005j\u0002`\u0006X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\r\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\bR\u001A\u0010\u000E\u001A\u00020\u000FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001AR\u001C\u0010\u001B\u001A\u0004\u0018\u00010\u001CX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001D\u0010\u001E\"\u0004\b\u001F\u0010 R\u001A\u0010!\u001A\u00020\u000FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\u0014\u00100\u001A\u00028\u00018VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b1\u0010\u001E¨\u00063"}, d2={"Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", "T", "Landroidx/compose/runtime/snapshots/StateRecord;", "Landroidx/compose/runtime/DerivedState$Record;", "snapshotId", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "<init>", "(J)V", "validSnapshotId", "getValidSnapshotId", "()J", "setValidSnapshotId", "J", "validSnapshotWriteCount", "", "getValidSnapshotWriteCount", "()I", "setValidSnapshotWriteCount", "(I)V", "dependencies", "Landroidx/collection/ObjectIntMap;", "Landroidx/compose/runtime/snapshots/StateObject;", "getDependencies", "()Landroidx/collection/ObjectIntMap;", "setDependencies", "(Landroidx/collection/ObjectIntMap;)V", "result", "", "getResult", "()Ljava/lang/Object;", "setResult", "(Ljava/lang/Object;)V", "resultHash", "getResultHash", "setResultHash", "assign", "", "value", "create", "(J)Landroidx/compose/runtime/snapshots/StateRecord;", "isValid", "", "derivedState", "Landroidx/compose/runtime/DerivedState;", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "readableHash", "currentValue", "getCurrentValue", "Companion", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ResultRecord extends StateRecord implements Record {
        @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2={"Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord$Companion;", "", "<init>", "()V", "Unset", "getUnset", "()Ljava/lang/Object;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
            public Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private Companion() {
                super();
            }

            public final Object getUnset() {
                return ResultRecord.Unset;
            }
        }

        public static final int $stable;
        public static final Companion Companion;
        private static final Object Unset;
        private ObjectIntMap dependencies;
        private Object result;
        private int resultHash;
        private long validSnapshotId;
        private int validSnapshotWriteCount;

        static {
            ResultRecord.Companion = new Companion(null);
            ResultRecord.$stable = 8;
            ResultRecord.Unset = new Object();
        }

        public ResultRecord(long arg1) {
            super(arg1);
            this.dependencies = ObjectIntMapKt.emptyObjectIntMap();
            this.result = ResultRecord.Unset;
        }

        public static final Object access$getUnset$cp() {
            return ResultRecord.Unset;
        }

        public void assign(StateRecord arg2) {
            Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type androidx.compose.runtime.DerivedSnapshotState.ResultRecord<T of androidx.compose.runtime.DerivedSnapshotState.ResultRecord>");
            this.setDependencies(((ResultRecord)arg2).getDependencies());
            this.result = ((ResultRecord)arg2).result;
            this.resultHash = ((ResultRecord)arg2).resultHash;
        }

        public StateRecord create() {
            return this.create(SnapshotKt.currentSnapshot().getSnapshotId());
        }

        public StateRecord create(long arg1) {
            return new ResultRecord(arg1);
        }

        public Object getCurrentValue() {
            return this.result;
        }

        public ObjectIntMap getDependencies() {
            return this.dependencies;
        }

        public final Object getResult() {
            return this.result;
        }

        public final int getResultHash() {
            return this.resultHash;
        }

        public final long getValidSnapshotId() {
            return this.validSnapshotId;
        }

        public final int getValidSnapshotWriteCount() {
            return this.validSnapshotWriteCount;
        }

        public final boolean isValid(DerivedState arg6, Snapshot arg7) {
            boolean v2;
            Object v0 = SnapshotKt.getLock();
            __monitor_enter(v0);
            try {
                v2 = false;
                if(Long.compare(this.validSnapshotId, arg7.getSnapshotId()) != 0) {
                    goto label_14;
                }
                else if(this.validSnapshotWriteCount == arg7.getWriteCount$runtime()) {
                    goto label_12;
                }
            }
            catch(Throwable v5) {
                __monitor_exit(v0);
                throw v5;
            }

            goto label_14;
        label_12:
            int v1 = 0;
            goto label_15;
        label_14:
            v1 = 1;
        label_15:
            __monitor_exit(v0);
            if(this.result != ResultRecord.Unset && (v1 == 0 || this.resultHash == this.readableHash(arg6, arg7))) {
                v2 = true;
            }

            if((v2) && v1 != 0) {
                Object v6 = SnapshotKt.getLock();
                __monitor_enter(v6);
                try {
                    this.validSnapshotId = arg7.getSnapshotId();
                    this.validSnapshotWriteCount = arg7.getWriteCount$runtime();
                }
                catch(Throwable v5) {
                    __monitor_exit(v6);
                    throw v5;
                }

                __monitor_exit(v6);
                return v2;
            }

            return v2;
        }

        public final int readableHash(DerivedState arg32, Snapshot arg33) {
            int v5_2;
            ResultRecord v7;
            long v27;
            int[] v26;
            Object[] v25;
            int v20;
            long[] v19_1;
            long v23;
            int v31;
            int v9;
            int v10;
            ObjectIntMap v3;
            DerivedState v1 = arg32;
            Snapshot v0 = arg33;
            Object v2 = SnapshotKt.getLock();
            __monitor_enter(v2);
            try {
                v3 = this.getDependencies();
            }
            catch(Throwable v0_1) {
                __monitor_exit(v2);
                throw v0_1;
            }

            __monitor_exit(v2);
            int v4 = 7;
            if(!v3.isNotEmpty()) {
                return v4;
            }

            MutableVector v2_1 = SnapshotStateKt.derivedStateObservers();
            Object[] v5 = v2_1.content;
            int v6 = v2_1.getSize();
            int v8;
            for(v8 = 0; v8 < v6; ++v8) {
                v5[v8].start(v1);
            }

            try {
                v5 = v3.keys;
                int[] v6_1 = v3.values;
                long[] v3_1 = v3.metadata;
                v8 = v3_1.length - 2;
                if(v8 >= 0) {
                    v10 = v4;
                    v9 = 0;
                    goto label_26;
                }
                else {
                    goto label_163;
                    while(true) {
                    label_26:
                        long v11 = v3_1[v9];
                        long v15 = -9187201950435737472L;
                        if((~v11 << v4 & v11 & v15) != v15) {
                            int v14 = 8;
                            int v13 = 8 - (~(v9 - v8) >>> 0x1F);
                            v31 = v4;
                            v4 = 0;
                            while(v4 < v13) {
                                long v17 = 0xFF;
                                long v21 = 0x80;
                                if((v11 & v17) < v21) {
                                    int v19 = (v9 << 3) + v4;
                                    v23 = v15;
                                    Object v15_1 = v5[v19];
                                    int v16 = v14;
                                    if(v6_1[v19] != 1) {
                                        v19_1 = v3_1;
                                        v20 = v4;
                                        v25 = v5;
                                        v26 = v6_1;
                                        v27 = v11;
                                    }
                                    else {
                                        if((v15_1 instanceof DerivedSnapshotState)) {
                                            v7 = ((DerivedSnapshotState)v15_1).current(v0);
                                            ObjectIntMap v14_1 = v7.getDependencies();
                                            Object[] v15_2 = v14_1.keys;
                                            long[] v14_2 = v14_1.metadata;
                                            v19_1 = v3_1;
                                            int v3_2 = v14_2.length - 2;
                                            v20 = v4;
                                            v25 = v5;
                                            v26 = v6_1;
                                            if(v3_2 >= 0) {
                                                v4 = 0;
                                                while(true) {
                                                    long v5_1 = v14_2[v4];
                                                    v27 = v11;
                                                    int v12 = v10;
                                                    if((~v5_1 << v31 & v5_1 & v23) != v23) {
                                                        v10 = 8 - (~(v4 - v3_2) >>> 0x1F);
                                                        int v11_1;
                                                        for(v11_1 = 0; v11_1 < v10; ++v11_1) {
                                                            if((v5_1 & v17) < v21) {
                                                                v12 = v12 * 0x1F + System_jvmKt.identityHashCode(v15_2[(v4 << 3) + v11_1]);
                                                            }

                                                            v5_1 >>= v16;
                                                        }

                                                        if(v10 == v16) {
                                                            goto label_104;
                                                        }

                                                        v10 = v12;
                                                        break;
                                                    }

                                                label_104:
                                                    v10 = v12;
                                                    if(v4 == v3_2) {
                                                        break;
                                                    }

                                                    ++v4;
                                                    v11 = v27;
                                                    v16 = 8;
                                                }
                                            }
                                            else {
                                                v27 = v11;
                                            }
                                        }
                                        else {
                                            v19_1 = v3_1;
                                            v20 = v4;
                                            v25 = v5;
                                            v26 = v6_1;
                                            v27 = v11;
                                            StateRecord v7_1 = SnapshotKt.current(((StateObject)v15_1).getFirstStateRecord(), v0);
                                        }

                                        v10 = (v10 * 0x1F + System_jvmKt.identityHashCode(v7)) * 0x1F + Long.hashCode(((StateRecord)v7).getSnapshotId$runtime());
                                    }

                                    v5_2 = 8;
                                }
                                else {
                                    v19_1 = v3_1;
                                    v20 = v4;
                                    v25 = v5;
                                    v26 = v6_1;
                                    v27 = v11;
                                    v23 = v15;
                                    v5_2 = v14;
                                }

                                v11 = v27 >> v5_2;
                                v4 = v20 + 1;
                                v14 = v5_2;
                                v3_1 = v19_1;
                                v15 = v23;
                                v5 = v25;
                                v6_1 = v26;
                            }

                            v19_1 = v3_1;
                            v25 = v5;
                            v26 = v6_1;
                            if(v13 != v14) {
                                goto label_164;
                            }
                        }
                        else {
                            v19_1 = v3_1;
                            v31 = v4;
                            v25 = v5;
                            v26 = v6_1;
                        }

                        if(v9 == v8) {
                            break;
                        }

                        ++v9;
                        v4 = v31;
                        v3_1 = v19_1;
                        v5 = v25;
                        v6_1 = v26;
                    }

                    v4 = v10;
                label_163:
                    v10 = v4;
                }

            label_164:
            }
            catch(Throwable v0_1) {
                goto label_175;
            }

            Object[] v0_2 = v2_1.content;
            int v2_2 = v2_1.getSize();
            int v7_2;
            for(v7_2 = 0; v7_2 < v2_2; ++v7_2) {
                v0_2[v7_2].done(v1);
            }

            return v10;
        label_175:
            Object[] v3_3 = v2_1.content;
            v2_2 = v2_1.getSize();
            for(v7_2 = 0; v7_2 < v2_2; ++v7_2) {
                v3_3[v7_2].done(v1);
            }

            throw v0_1;
            return v4;
        }

        public void setDependencies(ObjectIntMap arg1) {
            this.dependencies = arg1;
        }

        public final void setResult(Object arg1) {
            this.result = arg1;
        }

        public final void setResultHash(int arg1) {
            this.resultHash = arg1;
        }

        public final void setValidSnapshotId(long arg1) {
            this.validSnapshotId = arg1;
        }

        public final void setValidSnapshotWriteCount(int arg1) {
            this.validSnapshotWriteCount = arg1;
        }
    }

    private final Function0 calculation;
    private ResultRecord first;
    private final SnapshotMutationPolicy policy;

    public static Unit $r8$lambda$2u80IC3hx-0NI15_kz-k3m5EogE(DerivedSnapshotState arg0, IntRef arg1, MutableObjectIntMap arg2, int arg3, Object arg4) {
        return DerivedSnapshotState.currentRecord$lambda$1$0$0(arg0, arg1, arg2, arg3, arg4);
    }

    public DerivedSnapshotState(Function0 arg3, SnapshotMutationPolicy arg4) {
        super();
        this.calculation = arg3;
        this.policy = arg4;
        this.first = new ResultRecord(SnapshotKt.currentSnapshot().getSnapshotId());
    }

    public final ResultRecord current(Snapshot arg4) {
        return this.currentRecord(SnapshotKt.current(this.first, arg4), arg4, false, this.calculation);
    }

    private final ResultRecord currentRecord(ResultRecord arg22, Snapshot arg23, boolean arg24, Function0 arg25) {
        Object v5_2;
        IntRef v7_2;
        Object[] v1_1;
        int v3_1;
        long[] v18;
        int v21;
        int v11;
        int v10;
        IntRef v6_2;
        int v6;
        DerivedSnapshotState v0 = this;
        ResultRecord v1 = arg22;
        DerivedSnapshotState v2 = v0;
        Snapshot v3 = arg23;
        int v5 = 0;
        if(v1.isValid(((DerivedState)v2), v3)) {
            if(arg24) {
                MutableVector v4 = SnapshotStateKt.derivedStateObservers();
                Object[] v0_1 = v4.content;
                v6 = v4.getSize();
                int v7;
                for(v7 = 0; v7 < v6; ++v7) {
                    v0_1[v7].start(((DerivedState)v2));
                }

                try {
                    ObjectIntMap v0_3 = v1.getDependencies();
                    Object v6_1 = SnapshotStateKt__DerivedStateKt.access$getCalculationBlockNestedLevel$p().get();
                    if(v6_1 == null) {
                        v6_2 = new IntRef(0);
                        SnapshotStateKt__DerivedStateKt.access$getCalculationBlockNestedLevel$p().set(v6_2);
                    }

                    v7 = v6_2.getElement();
                    Object[] v8 = v0_3.keys;
                    int[] v9 = v0_3.values;
                    long[] v0_4 = v0_3.metadata;
                    v10 = v0_4.length - 2;
                    if(v10 >= 0) {
                        v11 = 0;
                        while(true) {
                            long v12 = v0_4[v11];
                            if((~v12 << 7 & v12 & -9187201950435737472L) != -9187201950435737472L) {
                                int v15 = 8;
                                int v14 = 8 - (~(v11 - v10) >>> 0x1F);
                                while(v5 < v14) {
                                    if((v12 & 0xFF) < 0x80) {
                                        int v17 = (v11 << 3) + v5;
                                        v21 = v15;
                                        Object v15_1 = v8[v17];
                                        v18 = v0_4;
                                        v6_2.setElement(v7 + v9[v17]);
                                        Function1 v0_5 = v3.getReadObserver();
                                        if(v0_5 != null) {
                                            v0_5.invoke(v15_1);
                                        }
                                    }
                                    else {
                                        v18 = v0_4;
                                        v21 = v15;
                                    }

                                    v12 >>= v21;
                                    ++v5;
                                    v15 = v21;
                                    v0_4 = v18;
                                }

                                v18 = v0_4;
                                if(v14 != v15) {
                                    break;
                                }
                            }
                            else {
                                v18 = v0_4;
                            }

                            if(v11 == v10) {
                                break;
                            }

                            ++v11;
                            v0_4 = v18;
                            v5 = 0;
                        }
                    }

                    v6_2.setElement(v7);
                }
                catch(Throwable v0_2) {
                    goto label_92;
                }

                v0_1 = v4.content;
                v3_1 = v4.getSize();
                for(v5 = 0; true; ++v5) {
                    if(v5 >= v3_1) {
                        return v1;
                    }

                    v0_1[v5].done(((DerivedState)v2));
                }

            label_92:
                v1_1 = v4.content;
                v3_1 = v4.getSize();
                for(v5 = 0; v5 < v3_1; ++v5) {
                    v1_1[v5].done(((DerivedState)v2));
                }

                throw v0_2;
            }

            return v1;
        }

        DefaultConstructorMarker v5_1 = null;
        v6 = 0;
        MutableObjectIntMap v3_2 = new MutableObjectIntMap(0, 1, v5_1);
        Object v7_1 = SnapshotStateKt__DerivedStateKt.access$getCalculationBlockNestedLevel$p().get();
        if(v7_1 == null) {
            v7_2 = new IntRef(0);
            SnapshotStateKt__DerivedStateKt.access$getCalculationBlockNestedLevel$p().set(v7_2);
        }

        int v8_1 = v7_2.getElement();
        MutableVector v9_1 = SnapshotStateKt.derivedStateObservers();
        Object[] v10_1 = v9_1.content;
        v11 = v9_1.getSize();
        int v12_1;
        for(v12_1 = 0; v12_1 < v11; ++v12_1) {
            v10_1[v12_1].start(((DerivedState)v2));
        }

        v10 = v8_1 + 1;
        try {
            v7_2.setElement(v10);
            v5_2 = Snapshot.Companion.observe(new DerivedSnapshotState$$ExternalSyntheticLambda0(v0, v7_2, v3_2, v8_1), ((Function1)v5_1), arg25);
            v7_2.setElement(v8_1);
        }
        catch(Throwable v0_2) {
            v1_1 = v9_1.content;
            v3_1 = v9_1.getSize();
            v5 = 0;
            goto label_193;
        }

        Object[] v7_3 = v9_1.content;
        v8_1 = v9_1.getSize();
        goto label_134;
    label_193:
        while(v5 < v3_1) {
            v1_1[v5].done(((DerivedState)v2));
            ++v5;
        }

        throw v0_2;
    label_134:
        while(v6 < v8_1) {
            v7_3[v6].done(((DerivedState)v2));
            ++v6;
        }

        Object v2_1 = SnapshotKt.getLock();
        __monitor_enter(v2_1);
        try {
            Snapshot v6_3 = Snapshot.Companion.getCurrent();
            if(v1.getResult() != ResultRecord.Companion.getUnset()) {
                SnapshotMutationPolicy v7_4 = v0.getPolicy();
                if(v7_4 == null) {
                    goto label_156;
                }
                else if(v7_4.equivalent(v5_2, v1.getResult())) {
                    v1.setDependencies(((ObjectIntMap)v3_2));
                    v1.setResultHash(v1.readableHash(((DerivedState)v0), v6_3));
                }
                else {
                    goto label_156;
                }
            }
            else {
            label_156:
                StateRecord v1_2 = SnapshotKt.newWritableRecord(v0.first, v0, v6_3);
                ((ResultRecord)v1_2).setDependencies(((ObjectIntMap)v3_2));
                ((ResultRecord)v1_2).setResultHash(((ResultRecord)v1_2).readableHash(((DerivedState)v0), v6_3));
                ((ResultRecord)v1_2).setResult(v5_2);
            }
        }
        catch(Throwable v0_2) {
            __monitor_exit(v2_1);
            throw v0_2;
        }

        __monitor_exit(v2_1);
        Object v0_6 = SnapshotStateKt__DerivedStateKt.access$getCalculationBlockNestedLevel$p().get();
        if(v0_6 != null && ((IntRef)v0_6).getElement() == 0) {
            Snapshot.Companion.notifyObjectsInitialized();
            v2_1 = SnapshotKt.getLock();
            __monitor_enter(v2_1);
            try {
                Snapshot v0_7 = Snapshot.Companion.getCurrent();
                v1.setValidSnapshotId(v0_7.getSnapshotId());
                v1.setValidSnapshotWriteCount(v0_7.getWriteCount$runtime());
            }
            catch(Throwable v0_2) {
                __monitor_exit(v2_1);
                throw v0_2;
            }

            __monitor_exit(v2_1);
            return v1;
        }

        return v1;
    }

    private static final Unit currentRecord$lambda$1$0$0(DerivedSnapshotState arg0, IntRef arg1, MutableObjectIntMap arg2, int arg3, Object arg4) {
        if((((DerivedSnapshotState)arg4)) != arg0) {
            if((arg4 instanceof StateObject)) {
                arg2.set(arg4, Math.min(arg1.getElement() - arg3, arg2.getOrDefault(arg4, 0x7FFFFFFF)));
            }

            return Unit.INSTANCE;
        }

        throw new IllegalStateException("A derived state calculation cannot read itself".toString());
    }

    private final String displayValue() {
        StateRecord v0 = SnapshotKt.current(this.first);
        if(((ResultRecord)v0).isValid(((DerivedState)this), Snapshot.Companion.getCurrent())) {
            return String.valueOf(((ResultRecord)v0).getResult());
        }

        return "<Not calculated>";
    }

    public Record getCurrentRecord() {
        Snapshot v0 = Snapshot.Companion.getCurrent();
        return this.currentRecord(SnapshotKt.current(this.first, v0), v0, false, this.calculation);
    }

    public final Object getDebuggerDisplayValue() {
        StateRecord v0 = SnapshotKt.current(this.first);
        if(((ResultRecord)v0).isValid(((DerivedState)this), Snapshot.Companion.getCurrent())) {
            return ((ResultRecord)v0).getResult();
        }

        return null;
    }

    public static void getDebuggerDisplayValue$annotations() {
    }

    public StateRecord getFirstStateRecord() {
        return this.first;
    }

    public SnapshotMutationPolicy getPolicy() {
        return this.policy;
    }

    public Object getValue() {
        Function1 v0 = Snapshot.Companion.getCurrent().getReadObserver();
        if(v0 != null) {
            v0.invoke(this);
        }

        Snapshot v0_1 = Snapshot.Companion.getCurrent();
        return this.currentRecord(SnapshotKt.current(this.first, v0_1), v0_1, true, this.calculation).getResult();
    }

    public void prependStateRecord(StateRecord arg2) {
        Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type androidx.compose.runtime.DerivedSnapshotState.ResultRecord<T of androidx.compose.runtime.DerivedSnapshotState>");
        this.first = ((ResultRecord)arg2);
    }

    public String toString() {
        SnapshotKt.current(this.first);
        return "DerivedState(value=" + this.displayValue() + ")@" + this.hashCode();
    }
}

