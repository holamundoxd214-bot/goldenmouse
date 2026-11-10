package com.TryJeanPc.goldenmouse.controls;

import java.util.Comparator;
import kotlin.jvm.functions.Function2;

public final class EditorHitDispatcher$Companion$$ExternalSyntheticLambda2 implements Comparator {
    public EditorHitDispatcher$Companion$$ExternalSyntheticLambda2(Function2 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final int compare(Object arg1, Object arg2) {
        return Companion.resolve$lambda$5(this.f$0, arg1, arg2);
    }
}

