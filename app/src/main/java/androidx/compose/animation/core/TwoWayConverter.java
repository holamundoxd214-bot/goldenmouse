package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0004R\u001E\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\bR\u001E\u0010\t\u001A\u000E\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0006X¦\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000BÀ\u0006\u0001"}, d2={"Landroidx/compose/animation/core/TwoWayConverter;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "", "convertToVector", "Lkotlin/Function1;", "getConvertToVector", "()Lkotlin/jvm/functions/Function1;", "convertFromVector", "getConvertFromVector", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public interface TwoWayConverter {
    Function1 getConvertFromVector();

    Function1 getConvertToVector();
}

