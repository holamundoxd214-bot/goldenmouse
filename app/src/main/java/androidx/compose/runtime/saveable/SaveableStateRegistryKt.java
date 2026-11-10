package androidx.compose.runtime.saveable;

import androidx.collection.MutableScatterMap;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.text.CharsKt;

@Metadata(d1={"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A8\u0010\u0000\u001A\u00020\u00012\u001C\u0010\u0002\u001A\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0018\u00010\u00032\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b\u001A\f\u0010\u000E\u001A\u00020\t*\u00020\u000FH\u0002\u001A0\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u0011\"\u0004\b\u0000\u0010\u0012\"\u0004\b\u0001\u0010\u0013*\u000E\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u0003H\u0002\"\u0019\u0010\n\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000B¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\r¨\u0006\u0014"}, d2={"SaveableStateRegistry", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "restoredValues", "", "", "", "", "canBeSaved", "Lkotlin/Function1;", "", "LocalSaveableStateRegistry", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalSaveableStateRegistry", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "fastIsBlank", "", "toMutableScatterMap", "Landroidx/collection/MutableScatterMap;", "K", "V", "runtime-saveable"}, k=2, mv={2, 1, 0}, xi=0x30) public final class SaveableStateRegistryKt {
    private static final ProvidableCompositionLocal LocalSaveableStateRegistry;

    static {
        SaveableStateRegistryKt.LocalSaveableStateRegistry = CompositionLocalKt.staticCompositionLocalOf(new SaveableStateRegistryKt$$ExternalSyntheticLambda0());
    }

    static final SaveableStateRegistry LocalSaveableStateRegistry$lambda$0() {
        return null;
    }

    public static final SaveableStateRegistry SaveableStateRegistry(Map arg1, Function1 arg2) {
        return new SaveableStateRegistryImpl(arg1, arg2);
    }

    public static final boolean access$fastIsBlank(CharSequence arg0) {
        return SaveableStateRegistryKt.fastIsBlank(arg0);
    }

    public static final MutableScatterMap access$toMutableScatterMap(Map arg0) {
        return SaveableStateRegistryKt.toMutableScatterMap(arg0);
    }

    private static final boolean fastIsBlank(CharSequence arg4) {
        int v0 = arg4.length();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            if(!CharsKt.isWhitespace(arg4.charAt(v2))) {
                return 0;
            }
        }

        return 1;
    }

    public static final ProvidableCompositionLocal getLocalSaveableStateRegistry() {
        return SaveableStateRegistryKt.LocalSaveableStateRegistry;
    }

    private static final MutableScatterMap toMutableScatterMap(Map arg2) {
        MutableScatterMap v0 = new MutableScatterMap(arg2.size());
        v0.putAll(arg2);
        return v0;
    }
}

