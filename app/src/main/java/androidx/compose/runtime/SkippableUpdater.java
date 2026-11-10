package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\t\u001A\u00020\n2\u001D\u0010\u000B\u001A\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\u000EH\u0086\b¢\u0006\u0004\b\u000F\u0010\u0010J\u0014\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0002HÖ\u0083\u0004J\n\u0010\u0014\u001A\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001A\u00020\u0017HÖ\u0081\u0004R\u0016\u0010\u0003\u001A\u00020\u00048\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\b\u0088\u0001\u0003\u0092\u0001\u00020\u0004¨\u0006\u0018"}, d2={"Landroidx/compose/runtime/SkippableUpdater;", "T", "", "composer", "Landroidx/compose/runtime/Composer;", "constructor-impl", "(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;", "getComposer$annotations", "()V", "update", "", "block", "Lkotlin/Function1;", "Landroidx/compose/runtime/Updater;", "Lkotlin/ExtensionFunctionType;", "update-impl", "(Landroidx/compose/runtime/Composer;Lkotlin/jvm/functions/Function1;)V", "equals", "", "other", "hashCode", "", "toString", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) @JvmInline public final class SkippableUpdater {
    private final Composer composer;

    private SkippableUpdater(Composer arg1) {
        super();
        this.composer = arg1;
    }

    public static final SkippableUpdater box-impl(Composer arg1) {
        return new SkippableUpdater(arg1);
    }

    public static Composer constructor-impl(Composer arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return SkippableUpdater.equals-impl(this.composer, arg1);
    }

    public static boolean equals-impl(Composer arg2, Object arg3) {
        if(!(arg3 instanceof SkippableUpdater)) {
            return 0;
        }

        if(!Intrinsics.areEqual(arg2, ((SkippableUpdater)arg3).unbox-impl())) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(Composer arg0, Composer arg1) {
        return Intrinsics.areEqual(arg0, arg1);
    }

    public static void getComposer$annotations() {
    }

    public int hashCode() {
        return SkippableUpdater.hashCode-impl(this.composer);
    }

    public static int hashCode-impl(Composer arg0) {
        return arg0.hashCode();
    }

    public String toString() {
        return SkippableUpdater.toString-impl(this.composer);
    }

    public static String toString-impl(Composer arg2) {
        return "SkippableUpdater(composer=" + arg2 + ')';
    }

    public final Composer unbox-impl() {
        return this.composer;
    }

    public static final void update-impl(Composer arg1, Function1 arg2) {
        arg1.startReplaceableGroup(509942095);
        arg2.invoke(Updater.box-impl(Updater.constructor-impl(arg1)));
        arg1.endReplaceableGroup();
    }
}

