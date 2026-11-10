package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BF\u0012\u0006\u0010\u0003\u001A\u00028\u0000\u00125\u0010\u0004\u001A1\u0012\u001E\u0012\u001C\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000B\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\f¢\u0006\u0002\b\b¢\u0006\u0004\b\r\u0010\u000EJ\u000E\u0010\u0015\u001A\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u0010J=\u0010\u0016\u001A1\u0012\u001E\u0012\u001C\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000B\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\f¢\u0006\u0002\b\bHÆ\u0003¢\u0006\u0002\u0010\u0013JW\u0010\u0017\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001A\u00028\u000027\b\u0002\u0010\u0004\u001A1\u0012\u001E\u0012\u001C\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000B\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\f¢\u0006\u0002\b\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001A\u00020\u001A2\b\u0010\u001B\u001A\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001C\u001A\u00020\u001DHÖ\u0001J\t\u0010\u001E\u001A\u00020\u001FHÖ\u0001R\u0013\u0010\u0003\u001A\u00028\u0000¢\u0006\n\n\u0002\u0010\u0011\u001A\u0004\b\u000F\u0010\u0010RB\u0010\u0004\u001A1\u0012\u001E\u0012\u001C\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000B\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\f¢\u0006\u0002\b\b¢\u0006\n\n\u0002\u0010\u0014\u001A\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2={"Landroidx/compose/material3/FadeInFadeOutAnimationItem;", "T", "", "key", "transition", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ParameterName;", "name", "content", "Landroidx/compose/material3/FadeInFadeOutTransition;", "<init>", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getTransition", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function3;", "component1", "component2", "copy", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Landroidx/compose/material3/FadeInFadeOutAnimationItem;", "equals", "", "other", "hashCode", "", "toString", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class FadeInFadeOutAnimationItem {
    private final Object key;
    private final Function3 transition;

    public FadeInFadeOutAnimationItem(Object arg1, Function3 arg2) {
        super();
        this.key = arg1;
        this.transition = arg2;
    }

    public final Object component1() {
        return this.key;
    }

    public final Function3 component2() {
        return this.transition;
    }

    public final FadeInFadeOutAnimationItem copy(Object arg1, Function3 arg2) {
        return new FadeInFadeOutAnimationItem(arg1, arg2);
    }

    public static FadeInFadeOutAnimationItem copy$default(FadeInFadeOutAnimationItem arg0, Object arg1, Function3 arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.key;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.transition;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((FadeInFadeOutAnimationItem)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof FadeInFadeOutAnimationItem)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.key, ((FadeInFadeOutAnimationItem)arg5).key)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.transition, ((FadeInFadeOutAnimationItem)arg5).transition)) {
            return 0;
        }

        return 1;
    }

    public final Object getKey() {
        return this.key;
    }

    public final Function3 getTransition() {
        return this.transition;
    }

    public int hashCode() {
        Object v0 = this.key;
        int v0_1 = v0 == null ? 0 : v0.hashCode();
        return v0_1 * 0x1F + this.transition.hashCode();
    }

    public String toString() {
        return "FadeInFadeOutAnimationItem(key=" + this.key + ", transition=" + this.transition + ')';
    }
}

