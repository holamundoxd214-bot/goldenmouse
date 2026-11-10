package androidx.compose.foundation.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\u001A\u001C\u0010\u0000\u001A\u00020\u00012\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0000\"\u0014\u0010\u0006\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"commonKeyMapping", "Landroidx/compose/foundation/text/KeyMapping;", "shortcutModifier", "Lkotlin/Function1;", "Landroidx/compose/ui/input/key/KeyEvent;", "", "defaultKeyMapping", "getDefaultKeyMapping", "()Landroidx/compose/foundation/text/KeyMapping;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class KeyMappingKt {
    private static final KeyMapping defaultKeyMapping;

    static {
        KeyMappingKt.defaultKeyMapping = new KeyMappingKt$defaultKeyMapping$2$1(KeyMappingKt.commonKeyMapping(KeyMappingKt$defaultKeyMapping$1.INSTANCE));
    }

    public static final KeyMapping commonKeyMapping(Function1 arg1) {
        return new KeyMappingKt$commonKeyMapping$1(arg1);
    }

    public static final KeyMapping getDefaultKeyMapping() {
        return KeyMappingKt.defaultKeyMapping;
    }
}

