package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000E\n\u0002\b\u0005\u001A\u0015\u0010\u0000\u001A\u0004\u0018\u00010\u0001*\u00020\u0002H\u0081\u0080\u0004¢\u0006\u0002\b\u0003\u001A\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005*\u00020\u0002H\u0082\u0080\u0004\u001A\u000E\u0010\u0006\u001A\u00020\u0007*\u00020\u0002H\u0082\u0080\u0004\u001A\u001B\u0010\b\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t*\u00020\u0002H\u0081\u0080\u0004¢\u0006\u0002\u0010\u000B\u001A\u000E\u0010\u000E\u001A\u00020\u0007*\u00020\u0002H\u0081\u0080\u0004\"\u000F\u0010\f\u001A\u00020\u0007X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000F\u0010\r\u001A\u00020\u0007X\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"getStackTraceElementImpl", "Ljava/lang/StackTraceElement;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getStackTraceElement", "getDebugMetadataAnnotation", "Lkotlin/coroutines/jvm/internal/DebugMetadata;", "getLabel", "", "getSpilledVariableFieldMapping", "", "", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)[Ljava/lang/String;", "COROUTINES_DEBUG_METADATA_VERSION_1_3", "COROUTINES_DEBUG_METADATA_VERSION_2_2", "getNextLineNumber", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class DebugMetadataKt {
    private static final int COROUTINES_DEBUG_METADATA_VERSION_1_3 = 1;
    private static final int COROUTINES_DEBUG_METADATA_VERSION_2_2 = 2;

    private static final DebugMetadata getDebugMetadataAnnotation(BaseContinuationImpl arg1) {
        return arg1.getClass().getAnnotation(DebugMetadata.class);
    }

    private static final int getLabel(BaseContinuationImpl arg3) {
        int v1 = 0;
        if((arg3 instanceof TailCallBaseContinuationImpl)) {
            return 0;
        }

        try {
            Field v0 = arg3.getClass().getDeclaredField("label");
            v0.setAccessible(true);
            Object v3 = v0.get(arg3);
            if((v3 instanceof Integer)) {
            }
            else {
                v3 = null;
            }

            if(v3 != null) {
                v1 = ((Integer)v3).intValue();
            }
        }
        catch(Exception ) {
            return -1;
        }

        return v1 - 1;
    }

    public static final int getNextLineNumber(BaseContinuationImpl arg4) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        DebugMetadata v0 = DebugMetadataKt.getDebugMetadataAnnotation(arg4);
        int v1 = -1;
        if(v0 == null) {
            return v1;
        }

        if(v0.v() < 2) {
            return v1;
        }

        int v4 = DebugMetadataKt.getLabel(arg4);
        if(v4 < 0) {
            return v1;
        }

        if(v4 >= v0.nl().length) {
            return v1;
        }

        return v0.nl()[v4];
    }

    public static final String[] getSpilledVariableFieldMapping(BaseContinuationImpl arg7) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        DebugMetadata v0 = DebugMetadataKt.getDebugMetadataAnnotation(arg7);
        String[] v1 = null;
        if(v0 == null) {
            return v1;
        }

        if(v0.v() < 1) {
            return v1;
        }

        ArrayList v1_1 = new ArrayList();
        int v7 = DebugMetadataKt.getLabel(arg7);
        int[] v2 = v0.i();
        int v3 = v2.length;
        int v5;
        for(v5 = 0; v5 < v3; ++v5) {
            if(v2[v5] == v7) {
                v1_1.add(v0.s()[v5]);
                v1_1.add(v0.n()[v5]);
            }
        }

        return ((Collection)v1_1).toArray(new String[0]);
    }

    public static final StackTraceElement getStackTraceElement(BaseContinuationImpl arg4) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        DebugMetadata v0 = DebugMetadataKt.getDebugMetadataAnnotation(arg4);
        StackTraceElement v1 = null;
        if(v0 == null) {
            return v1;
        }

        if(v0.v() < 1) {
            return v1;
        }

        int v1_1 = DebugMetadataKt.getLabel(arg4);
        v1_1 = v1_1 < 0 ? -1 : v0.l()[v1_1];
        String v4 = ModuleNameRetriever.INSTANCE.getModuleName(((Continuation)arg4));
        v4 = v4 == null ? v0.c() : v4 + '/' + v0.c();
        return new StackTraceElement(v4, v0.m(), v0.f(), v1_1);
    }
}

