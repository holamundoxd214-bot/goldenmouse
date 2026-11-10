package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u001C\u0010\u0000\u001A\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\t"}, d2={"specs", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimationSpecsNode;", "", "getSpecs", "(Ljava/lang/Object;)Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimationSpecsNode;", "EmptyArray", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "[Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyLayoutItemAnimatorKt {
    private static final LazyLayoutItemAnimation[] EmptyArray;

    static {
        LazyLayoutItemAnimatorKt.EmptyArray = new LazyLayoutItemAnimation[0];
    }

    public static final LazyLayoutItemAnimation[] access$getEmptyArray$p() {
        return LazyLayoutItemAnimatorKt.EmptyArray;
    }

    public static final LazyLayoutAnimationSpecsNode access$getSpecs(Object arg0) {
        return LazyLayoutItemAnimatorKt.getSpecs(arg0);
    }

    private static final LazyLayoutAnimationSpecsNode getSpecs(Object arg1) {
        if((arg1 instanceof LazyLayoutAnimationSpecsNode)) {
            return arg1;
        }

        return null;
    }
}

