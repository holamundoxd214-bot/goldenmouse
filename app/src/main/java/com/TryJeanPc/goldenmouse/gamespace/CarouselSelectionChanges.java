package com.TryJeanPc.goldenmouse.gamespace;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.math.MathKt;
import kotlin.sequences.SequencesKt;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001D\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0005¢\u0006\u0002\u0010\tJ$\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00050\u000B2\u0006\u0010\f\u001A\u00020\u00072\u0006\u0010\r\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0005¨\u0006\u000E"}, d2={"Lcom/TryJeanPc/goldenmouse/gamespace/CarouselSelectionChanges;", "", "<init>", "()V", "selectedIndex", "", "position", "", "count", "(DI)Ljava/lang/Integer;", "indices", "", "from", "to", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class CarouselSelectionChanges {
    public static final int $stable;
    public static final CarouselSelectionChanges INSTANCE;

    static {
        CarouselSelectionChanges.INSTANCE = new CarouselSelectionChanges();
    }

    private CarouselSelectionChanges() {
        super();
    }

    public final List indices(double arg1, double arg3, int arg5) {
        if(arg5 < 2) {
            return CollectionsKt.emptyList();
        }

        int v0 = MathKt.roundToInt(arg1);
        int v1 = MathKt.roundToInt(arg3);
        if(v0 == v1) {
            return CollectionsKt.emptyList();
        }

        int v2 = v1 > v0 ? 1 : -1;
        return SequencesKt.toList(SequencesKt.map(SequencesKt.take(SequencesKt.generateSequence(Integer.valueOf(v0 + v2), new CarouselSelectionChanges$$ExternalSyntheticLambda0(v2)), Math.abs(v1 - v0)), new CarouselSelectionChanges$$ExternalSyntheticLambda1(arg5)));
    }

    static final Integer indices$lambda$0(int arg0, int arg1) {
        return Integer.valueOf(arg1 + arg0);
    }

    static final int indices$lambda$1(int arg1, int arg2) {
        return CarouselGeometry.INSTANCE.wrap(arg2, arg1);
    }

    public final Integer selectedIndex(double arg1, int arg3) {
        if(arg3 <= 0) {
            return null;
        }

        return Integer.valueOf(CarouselGeometry.INSTANCE.wrap(MathKt.roundToInt(arg1), arg3));
    }
}

