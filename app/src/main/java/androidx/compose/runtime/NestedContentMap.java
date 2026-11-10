package androidx.compose.runtime;

import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.ObjectList;
import androidx.compose.runtime.collection.MultiValueMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001E\u0010\u000B\u001A\u00020\f2\u000E\u0010\r\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00062\u0006\u0010\u000E\u001A\u00020\u0007J\u0006\u0010\u000F\u001A\u00020\fJ\u0018\u0010\u0010\u001A\u0004\u0018\u00010\u00072\u000E\u0010\u0011\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006J\u0019\u0010\u0012\u001A\u00020\u00132\u000E\u0010\u0011\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006H\u0086\u0002J\u000E\u0010\u0014\u001A\u00020\f2\u0006\u0010\u0015\u001A\u00020\nR$\u0010\u0004\u001A\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR$\u0010\t\u001A\u0016\u0012\u0004\u0012\u00020\n\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0016"}, d2={"Landroidx/compose/runtime/NestedContentMap;", "", "<init>", "()V", "contentMap", "Landroidx/compose/runtime/collection/MultiValueMap;", "Landroidx/compose/runtime/MovableContent;", "Landroidx/compose/runtime/NestedMovableContent;", "Landroidx/collection/MutableScatterMap;", "containerMap", "Landroidx/compose/runtime/MovableContentStateReference;", "add", "", "content", "nestedContent", "clear", "removeLast", "key", "contains", "", "usedContainer", "reference", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class NestedContentMap {
    private final MutableScatterMap containerMap;
    private final MutableScatterMap contentMap;

    public static boolean $r8$lambda$dwRlJ15WVvl1vLlSebcqVsocoZY(MovableContentStateReference arg0, NestedMovableContent arg1) {
        return NestedContentMap.usedContainer$lambda$0$0(arg0, arg1);
    }

    public NestedContentMap() {
        super();
        this.contentMap = MultiValueMap.constructor-impl$default(null, 1, null);
        this.containerMap = MultiValueMap.constructor-impl$default(null, 1, null);
    }

    public final void add(MovableContent arg2, NestedMovableContent arg3) {
        MultiValueMap.add-impl(this.contentMap, arg2, arg3);
        MultiValueMap.add-impl(this.containerMap, arg3.getContainer(), arg2);
    }

    public final void clear() {
        MultiValueMap.clear-impl(this.contentMap);
        MultiValueMap.clear-impl(this.containerMap);
    }

    public final boolean contains(MovableContent arg1) {
        return MultiValueMap.contains-impl(this.contentMap, arg1);
    }

    public final NestedMovableContent removeLast(MovableContent arg2) {
        Object v2 = MultiValueMap.removeLast-impl(this.contentMap, arg2);
        if(MultiValueMap.isEmpty-impl(this.contentMap)) {
            MultiValueMap.clear-impl(this.containerMap);
        }

        return ((NestedMovableContent)v2);
    }

    public final void usedContainer(MovableContentStateReference arg8) {
        Object v0 = this.containerMap.get(arg8);
        if(v0 != null) {
            String v2 = "null cannot be cast to non-null type V of androidx.compose.runtime.collection.MultiValueMap";
            if((v0 instanceof MutableObjectList)) {
                Object[] v1 = ((ObjectList)v0).content;
                int v0_1 = ((ObjectList)v0)._size;
                int v3;
                for(v3 = 0; v3 < v0_1; ++v3) {
                    Object v4 = v1[v3];
                    Intrinsics.checkNotNull(v4, v2);
                    MultiValueMap.removeValueIf-impl(this.contentMap, v4, new NestedContentMap$$ExternalSyntheticLambda0(arg8));
                }
            }
            else {
                Intrinsics.checkNotNull(v0, v2);
                MultiValueMap.removeValueIf-impl(this.contentMap, v0, new NestedContentMap$$ExternalSyntheticLambda0(arg8));
            }
        }
    }

    private static final boolean usedContainer$lambda$0$0(MovableContentStateReference arg0, NestedMovableContent arg1) {
        return Intrinsics.areEqual(arg1.getContainer(), arg0);
    }
}

