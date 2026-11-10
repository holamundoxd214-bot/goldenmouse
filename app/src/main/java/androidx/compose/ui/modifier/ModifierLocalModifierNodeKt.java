package androidx.compose.ui.modifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.SpreadBuilder;

@Metadata(d1={"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u001A\u0006\u0010\u0000\u001A\u00020\u0001\u001A\u001A\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001A&\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0018\u0010\u0005\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0004\u0012\u0002H\u00020\u0006\u001A?\u0010\u0000\u001A\u00020\u00012\n\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\u00042\n\u0010\b\u001A\u0006\u0012\u0002\b\u00030\u00042\u001A\u0010\t\u001A\u000E\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00040\n\"\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u000B\u001Ao\u0010\u0000\u001A\u00020\u00012\u0016\u0010\f\u001A\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\r0\u00062\u0016\u0010\u000E\u001A\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\r0\u000622\u0010\u000F\u001A\u001A\u0012\u0016\b\u0001\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\r0\u00060\n\"\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\r0\u0006¢\u0006\u0002\u0010\u0010\u001A)\u0010\u0000\u001A\u00020\u00012\u001A\u0010\t\u001A\u000E\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00040\n\"\u0006\u0012\u0002\b\u00030\u0004H\u0007¢\u0006\u0002\u0010\u0011\u001AA\u0010\u0000\u001A\u00020\u000122\u0010\u000F\u001A\u001A\u0012\u0016\b\u0001\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\r0\u00060\n\"\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\r0\u0006H\u0007¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2={"modifierLocalMapOf", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "T", "key", "Landroidx/compose/ui/modifier/ModifierLocal;", "entry", "Lkotlin/Pair;", "key1", "key2", "keys", "", "(Landroidx/compose/ui/modifier/ModifierLocal;Landroidx/compose/ui/modifier/ModifierLocal;[Landroidx/compose/ui/modifier/ModifierLocal;)Landroidx/compose/ui/modifier/ModifierLocalMap;", "entry1", "", "entry2", "entries", "(Lkotlin/Pair;Lkotlin/Pair;[Lkotlin/Pair;)Landroidx/compose/ui/modifier/ModifierLocalMap;", "([Landroidx/compose/ui/modifier/ModifierLocal;)Landroidx/compose/ui/modifier/ModifierLocalMap;", "([Lkotlin/Pair;)Landroidx/compose/ui/modifier/ModifierLocalMap;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ModifierLocalModifierNodeKt {
    public static final ModifierLocalMap modifierLocalMapOf(Pair arg2) {
        SingleLocalMap v0 = new SingleLocalMap(arg2.getFirst());
        v0.set$ui(arg2.getFirst(), arg2.getSecond());
        return ((ModifierLocalMap)v0);
    }

    public static final ModifierLocalMap modifierLocalMapOf() {
        return EmptyMap.INSTANCE;
    }

    public static final ModifierLocalMap modifierLocalMapOf(ModifierLocal arg1) {
        return new SingleLocalMap(arg1);
    }

    public static final ModifierLocalMap modifierLocalMapOf(ModifierLocal arg6, ModifierLocal arg7, ModifierLocal[] arg8) {
        Object v0 = null;
        Pair v6 = TuplesKt.to(arg6, v0);
        SpreadBuilder v1 = new SpreadBuilder(2);
        v1.add(TuplesKt.to(arg7, v0));
        ArrayList v7 = new ArrayList(arg8.length);
        int v2 = arg8.length;
        int v4;
        for(v4 = 0; v4 < v2; ++v4) {
            ((Collection)v7).add(TuplesKt.to(arg8[v4], v0));
        }

        v1.addSpread(((Collection)v7).toArray(new Pair[0]));
        return new MultiLocalMap(v6, v1.toArray(new Pair[v1.size()]));
    }

    public static final ModifierLocalMap modifierLocalMapOf(Pair arg3, Pair arg4, Pair[] arg5) {
        SpreadBuilder v1 = new SpreadBuilder(2);
        v1.add(arg4);
        v1.addSpread(arg5);
        return new MultiLocalMap(arg3, v1.toArray(new Pair[v1.size()]));
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use a different overloaded version of this function") public static final ModifierLocalMap modifierLocalMapOf(ModifierLocal[] arg8) {
        int v0 = arg8.length;
        if(v0 != 0) {
            if(v0 != 1) {
                Object v2 = null;
                Pair v0_1 = TuplesKt.to(ArraysKt.first(((Object[])arg8)), v2);
                List v8 = ArraysKt.drop(((Object[])arg8), 1);
                ArrayList v1 = new ArrayList(v8.size());
                int v3 = v8.size();
                int v5;
                for(v5 = 0; v5 < v3; ++v5) {
                    v1.add(TuplesKt.to(v8.get(v5), v2));
                }

                Object[] v8_1 = ((Collection)v1).toArray(new Pair[0]);
                return new MultiLocalMap(v0_1, Arrays.copyOf(v8_1, v8_1.length));
            }

            return new SingleLocalMap(ArraysKt.first(((Object[])arg8)));
        }

        return EmptyMap.INSTANCE;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use a different overloaded version of this function") public static final ModifierLocalMap modifierLocalMapOf(Pair[] arg4) {
        int v0 = arg4.length;
        if(v0 != 0) {
            if(v0 != 1) {
                Object v3 = ArraysKt.first(((Object[])arg4));
                Object[] v4 = ArraysKt.drop(((Object[])arg4), 1).toArray(new Pair[0]);
                return new MultiLocalMap(((Pair)v3), Arrays.copyOf(v4, v4.length));
            }

            return new MultiLocalMap(ArraysKt.first(((Object[])arg4)), new Pair[0]);
        }

        return EmptyMap.INSTANCE;
    }
}

