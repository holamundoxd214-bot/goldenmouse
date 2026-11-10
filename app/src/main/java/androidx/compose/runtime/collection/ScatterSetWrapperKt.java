package androidx.compose.runtime.collection;

import androidx.collection.ScatterSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000$\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\u001A\u001E\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0000\u001A1\u0010\u0004\u001A\u00020\u0005\"\b\b\u0000\u0010\u0002*\u00020\u0006*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00050\bH\u0080\b\u001A\'\u0010\t\u001A\u00020\n*\b\u0012\u0004\u0012\u00020\u00060\u00012\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\bH\u0080\b¨\u0006\u000B"}, d2={"wrapIntoSet", "", "T", "Landroidx/collection/ScatterSet;", "fastForEach", "", "", "block", "Lkotlin/Function1;", "fastAny", "", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ScatterSetWrapperKt {
    public static final boolean fastAny(Set arg14, Function1 arg15) {
        if((arg14 instanceof ScatterSetWrapper)) {
            ScatterSet v14 = ((ScatterSetWrapper)arg14).getSet$runtime();
            Object[] v0 = v14.elements;
            long[] v14_1 = v14.metadata;
            int v3 = v14_1.length - 2;
            if(v3 >= 0) {
                int v4;
                for(v4 = 0; true; ++v4) {
                    long v5 = v14_1[v4];
                    if((~v5 << 7 & v5 & -9187201950435737472L) != -9187201950435737472L) {
                        int v8 = 8;
                        int v7 = 8 - (~(v4 - v3) >>> 0x1F);
                        int v9;
                        for(v9 = 0; v9 < v7; ++v9) {
                            if((0xFF & v5) < 0x80 && (arg15.invoke(v0[(v4 << 3) + v9]).booleanValue())) {
                                return 1;
                            }

                            v5 >>= v8;
                        }

                        if(v7 != v8) {
                            return 0;
                        }
                    }

                    if(v4 == v3) {
                        return 0;
                    }
                }
            }

            return 0;
        }

        if(((arg14 instanceof Collection)) && (arg14.isEmpty())) {
            return 0;
        }

        Iterator v14_2 = ((Iterable)arg14).iterator();
        do {
            if(!v14_2.hasNext()) {
                return 0;
            }
        }
        while(!arg15.invoke(v14_2.next()).booleanValue());

        return 1;
    }

    public static final void fastForEach(Set arg13, Function1 arg14) {
        if((arg13 instanceof ScatterSetWrapper)) {
            ScatterSet v13 = ((ScatterSetWrapper)arg13).getSet$runtime();
            Object[] v0 = v13.elements;
            long[] v13_1 = v13.metadata;
            int v1 = v13_1.length - 2;
            if(v1 >= 0) {
                int v3;
                for(v3 = 0; true; ++v3) {
                    long v4 = v13_1[v3];
                    if((~v4 << 7 & v4 & -9187201950435737472L) != -9187201950435737472L) {
                        int v7 = 8;
                        int v6 = 8 - (~(v3 - v1) >>> 0x1F);
                        int v8;
                        for(v8 = 0; v8 < v6; ++v8) {
                            if((0xFF & v4) < 0x80) {
                                arg14.invoke(v0[(v3 << 3) + v8]);
                            }

                            v4 >>= v7;
                        }

                        if(v6 != v7) {
                            return;
                        }
                    }

                    if(v3 == v1) {
                        return;
                    }
                }
            }
        }
        else {
            Iterator v13_2 = ((Iterable)arg13).iterator();
            while(v13_2.hasNext()) {
                arg14.invoke(v13_2.next());
            }
        }
    }

    public static final Set wrapIntoSet(ScatterSet arg1) {
        return new ScatterSetWrapper(arg1);
    }
}

