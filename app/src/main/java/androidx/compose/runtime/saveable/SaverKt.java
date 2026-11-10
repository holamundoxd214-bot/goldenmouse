package androidx.compose.runtime.saveable;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001Aw\u0010\u0000\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u00042.\u0010\u0005\u001A*\u0012\u0004\u0012\u00020\u0007\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u0006¢\u0006\u0002\b\u000B2#\u0010\f\u001A\u001F\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\r\u001A\u0018\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u0002H\u000F\u0012\u0004\u0012\u00020\u00040\u0001\"\u0004\b\u0000\u0010\u000F\"\u001C\u0010\u0010\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00040\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2={"Saver", "Landroidx/compose/runtime/saveable/Saver;", "Original", "Saveable", "", "save", "Lkotlin/Function2;", "Landroidx/compose/runtime/saveable/SaverScope;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/ExtensionFunctionType;", "restore", "Lkotlin/Function1;", "autoSaver", "T", "AutoSaver", "runtime-saveable"}, k=2, mv={2, 1, 0}, xi=0x30) public final class SaverKt {
    private static final Saver AutoSaver;

    static {
        SaverKt.AutoSaver = SaverKt.Saver(new SaverKt$$ExternalSyntheticLambda0(), new SaverKt$$ExternalSyntheticLambda1());
    }

    static final Object AutoSaver$lambda$0(SaverScope arg0, Object arg1) {
        return arg1;
    }

    static final Object AutoSaver$lambda$1(Object arg0) {
        return arg0;
    }

    public static final Saver Saver(Function2 arg1, Function1 arg2) {
        return new SaverKt$Saver$1(arg1, arg2);
    }

    public static final Saver autoSaver() {
        Saver v0 = SaverKt.AutoSaver;
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.compose.runtime.saveable.SaverKt.autoSaver, kotlin.Any>");
        return v0;
    }
}

