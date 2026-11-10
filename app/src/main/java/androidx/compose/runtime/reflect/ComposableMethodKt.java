package androidx.compose.runtime.reflect;

import androidx.compose.runtime.Composer;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u00004\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0003\u001A\u0018\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0001H\u0002\u001A\u0010\u0010\u0005\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0001H\u0002\u001A\f\u0010\u0006\u001A\u00020\u0007*\u00020\bH\u0002\u001A\u0012\u0010\t\u001A\u0004\u0018\u00010\n*\u0006\u0012\u0002\b\u00030\u000BH\u0002\u001A\f\u0010\f\u001A\u0004\u0018\u00010\r*\u00020\b\u001A(\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\u00100\u000F\"\u0006\b\u0000\u0010\u0010\u0018\u0001*\u0002H\u00102\u0006\u0010\u0011\u001A\u00020\u0001H\u0082\b¢\u0006\u0002\u0010\u0012\u001A7\u0010\u0013\u001A\u00020\r*\u0006\u0012\u0002\b\u00030\u000B2\u0006\u0010\u0014\u001A\u00020\u00152\u001A\u0010\u0016\u001A\u000E\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u000B0\u000F\"\u0006\u0012\u0002\b\u00030\u000B¢\u0006\u0002\u0010\u0017\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2={"BITS_PER_INT", "", "changedParamCount", "realValueParams", "thisParams", "defaultParamCount", "getComposableInfo", "Landroidx/compose/runtime/reflect/ComposableInfo;", "Ljava/lang/reflect/Method;", "getDefaultValue", "", "Ljava/lang/Class;", "asComposableMethod", "Landroidx/compose/runtime/reflect/ComposableMethod;", "dup", "", "T", "count", "(Ljava/lang/Object;I)[Ljava/lang/Object;", "getDeclaredComposableMethod", "methodName", "", "args", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Landroidx/compose/runtime/reflect/ComposableMethod;", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ComposableMethodKt {
    private static final int BITS_PER_INT = 0x1F;

    public static final Object access$getDefaultValue(Class arg0) {
        return ComposableMethodKt.getDefaultValue(arg0);
    }

    public static final ComposableMethod asComposableMethod(Method arg2) {
        ComposableInfo v0 = ComposableMethodKt.getComposableInfo(arg2);
        if(v0.isComposable()) {
            return new ComposableMethod(arg2, v0);
        }

        return null;
    }

    private static final int changedParamCount(int arg2, int arg3) {
        if(arg2 == 0) {
            return 1;
        }

        return ((int)Math.ceil((((double)(arg2 + arg3))) / 10));
    }

    private static final int defaultParamCount(int arg4) {
        return ((int)Math.ceil((((double)arg4)) / 31));
    }

    private static final Object[] dup(Object arg3, int arg4) {
        IntRange v4 = RangesKt.until(0, arg4);
        ArrayList v1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v4), 10));
        Iterator v4_1 = ((Iterable)v4).iterator();
        while(v4_1.hasNext()) {
            v4_1.nextInt();
            ((Collection)v1).add(arg3);
        }

        Intrinsics.reifiedOperationMarker(0, "T?");
        return ((Collection)v1).toArray(new Object[0]);
    }

    private static final ComposableInfo getComposableInfo(Method arg7) {
        Class[] v0 = arg7.getParameterTypes();
        int v2 = -1;
        int v1 = v0.length + v2;
        if(v1 >= 0) {
            while(true) {
                int v3 = v1 - 1;
                if(Intrinsics.areEqual(v0[v1], Composer.class)) {
                    break;
                }
                else if(v3 < 0) {
                    goto label_15;
                }
                else {
                    v1 = v3;
                    continue;
                }
            }
        }
        else {
        label_15:
            v1 = v2;
        }

        boolean v0_1 = false;
        if(v1 == v2) {
            return new ComposableInfo(false, arg7.getParameterTypes().length, 0, 0);
        }

        v2 = ComposableMethodKt.changedParamCount(v1, Modifier.isStatic(arg7.getModifiers()) ^ 1);
        int v4 = v1 + 1 + v2;
        int v7 = arg7.getParameterTypes().length;
        int v5 = v7 != v4 ? ComposableMethodKt.defaultParamCount(v1) : 0;
        if(v4 + v5 == v7) {
            v0_1 = true;
        }

        return new ComposableInfo(v0_1, v1, v2, v5);
    }

    public static final ComposableMethod getDeclaredComposableMethod(Class arg8, String arg9, Class[] arg10) throws NoSuchMethodException {
        Method v10;
        int v0 = ComposableMethodKt.changedParamCount(arg10.length, 0);
        int v2 = 10;
        try {
            SpreadBuilder v3 = new SpreadBuilder(3);
            v3.addSpread(arg10);
            v3.add(Composer.class);
            Class v4 = Integer.TYPE;
            IntRange v5 = RangesKt.until(0, v0);
            ArrayList v6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v5), v2));
            Iterator v5_1 = ((Iterable)v5).iterator();
            while(v5_1.hasNext()) {
                v5_1.nextInt();
                ((Collection)v6).add(v4);
            }

            v3.addSpread(((Collection)v6).toArray(new Class[0]));
            v10 = arg8.getDeclaredMethod(arg9, v3.toArray(new Class[v3.size()]));
        }
        catch(ReflectiveOperationException ) {
            int v3_1 = ComposableMethodKt.defaultParamCount(((Class[])v10).length);
            try {
                SpreadBuilder v4_1 = new SpreadBuilder(4);
                v4_1.addSpread(v10);
                v4_1.add(Composer.class);
                Class v10_1 = Integer.TYPE;
                IntRange v0_1 = RangesKt.until(0, v0);
                ArrayList v5_2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v0_1), v2));
                Iterator v0_2 = ((Iterable)v0_1).iterator();
                while(v0_2.hasNext()) {
                    v0_2.nextInt();
                    ((Collection)v5_2).add(v10_1);
                }

                v4_1.addSpread(((Collection)v5_2).toArray(new Class[0]));
                v10_1 = Integer.TYPE;
                v0_1 = RangesKt.until(0, v3_1);
                ArrayList v3_2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v0_1), v2));
                v0_2 = ((Iterable)v0_1).iterator();
                while(v0_2.hasNext()) {
                    v0_2.nextInt();
                    ((Collection)v3_2).add(v10_1);
                }

                v4_1.addSpread(((Collection)v3_2).toArray(new Class[0]));
                v10 = arg8.getDeclaredMethod(arg9, v4_1.toArray(new Class[v4_1.size()]));
            }
            catch(ReflectiveOperationException ) {
                v10 = null;
            }
        }

        if(v10 != null) {
            ComposableMethod v8 = ComposableMethodKt.asComposableMethod(v10);
            Intrinsics.checkNotNull(v8);
            return v8;
        }

        throw new NoSuchMethodException(arg8.getName() + '.' + arg9);
    }

    private static final Object getDefaultValue(Class arg2) {
        String v2 = arg2.getName();
        if(v2 != null) {
            switch(v2.hashCode()) {
                case -1325958191: {
                    goto label_50;
                }
                case 104431: {
                    goto label_44;
                }
                case 3039496: {
                    goto label_38;
                }
                case 3052374: {
                    goto label_32;
                }
                case 3327612: {
                    goto label_25;
                }
                case 64711720: {
                    goto label_19;
                }
                case 97526364: {
                    goto label_12;
                }
                case 109413500: {
                    goto label_6;
                }
            }

            return null;
        label_50:
            if(!v2.equals("double")) {
            }
            else {
                return Double.valueOf(0);
            label_19:
                if(!v2.equals("boolean")) {
                }
                else {
                    return Boolean.valueOf(false);
                label_38:
                    if(!v2.equals("byte")) {
                    }
                    else {
                        return Byte.valueOf(0);
                    label_6:
                        if(!v2.equals("short")) {
                        }
                        else {
                            return Short.valueOf(0);
                        label_25:
                            if(!v2.equals("long")) {
                            }
                            else {
                                return Long.valueOf(0);
                            label_12:
                                if(!v2.equals("float")) {
                                }
                                else {
                                    return Float.valueOf(0f);
                                label_44:
                                    if(!v2.equals("int")) {
                                    }
                                    else {
                                        return Integer.valueOf(0);
                                    label_32:
                                        if(!v2.equals("char")) {
                                        }
                                        else {
                                            return Character.valueOf('\u0000');
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return null;
    }
}

