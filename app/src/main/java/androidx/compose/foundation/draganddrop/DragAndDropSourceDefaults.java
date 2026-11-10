package androidx.compose.foundation.draganddrop;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R8\u0010\u0004\u001A\'\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005j\u0002`\n¢\u0006\u0002\b\t¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u000B\u0010\f¨\u0006\u000E"}, d2={"Landroidx/compose/foundation/draganddrop/DragAndDropSourceDefaults;", "", "<init>", "()V", "DefaultStartDetector", "Lkotlin/Function2;", "Landroidx/compose/foundation/draganddrop/DragAndDropStartDetectorScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/foundation/draganddrop/DragAndDropStartDetector;", "getDefaultStartDetector", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DragAndDropSourceDefaults {
    public static final int $stable;
    private static final Function2 DefaultStartDetector;
    public static final DragAndDropSourceDefaults INSTANCE;

    static {
        DragAndDropSourceDefaults.INSTANCE = new DragAndDropSourceDefaults();
        DragAndDropSourceDefaults.DefaultStartDetector = new DragAndDropSourceDefaults$DefaultStartDetector$1(null);
    }

    private DragAndDropSourceDefaults() {
        super();
    }

    public final Function2 getDefaultStartDetector() {
        return DragAndDropSourceDefaults.DefaultStartDetector;
    }
}

