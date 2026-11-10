package androidx.compose.ui.semantics;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map$Entry;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\b\u0010\u0004\u001A\u00020\u0005H\u0000\u001A-\u0010\u0006\u001A\u00020\u0007*\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\u0017\u0010\n\u001A\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000B¢\u0006\u0002\b\u000E\u001A#\u0010\u000F\u001A\u00020\u0007*\u00020\u00072\u0017\u0010\n\u001A\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000B¢\u0006\u0002\b\u000E\u001A\u0014\u0010\u0010\u001A\u00020\r*\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0013H\u0002\"\u0014\u0010\u0000\u001A\u00060\u0001j\u0002`\u0002X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0003¨\u0006\u0014"}, d2={"lastIdentifier", "Ljava/util/concurrent/atomic/AtomicInteger;", "Landroidx/compose/ui/platform/AtomicInt;", "Ljava/util/concurrent/atomic/AtomicInteger;", "generateSemanticsId", "", "semantics", "Landroidx/compose/ui/Modifier;", "mergeDescendants", "", "properties", "Lkotlin/Function1;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "", "Lkotlin/ExtensionFunctionType;", "clearAndSetSemantics", "addSemanticsPropertiesFrom", "Landroidx/compose/ui/platform/InspectorInfo;", "semanticsConfiguration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SemanticsModifierKt {
    private static AtomicInteger lastIdentifier;

    static {
        SemanticsModifierKt.lastIdentifier = new AtomicInteger(0);
    }

    public static final void access$addSemanticsPropertiesFrom(InspectorInfo arg0, SemanticsConfiguration arg1) {
        SemanticsModifierKt.addSemanticsPropertiesFrom(arg0, arg1);
    }

    private static final void addSemanticsPropertiesFrom(InspectorInfo arg3, SemanticsConfiguration arg4) {
        ValueElementSequence v3 = arg3.getProperties();
        LinkedHashMap v1 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(((Iterable)arg4), 10)), 16));
        Iterator v4 = ((Iterable)arg4).iterator();
        while(v4.hasNext()) {
            Object v0 = v4.next();
            Pair v0_1 = TuplesKt.to(((Map$Entry)v0).getKey().getName(), ((Map$Entry)v0).getValue());
            ((Map)v1).put(v0_1.getFirst(), v0_1.getSecond());
        }

        v3.set("properties", v1);
    }

    public static final Modifier clearAndSetSemantics(Modifier arg1, Function1 arg2) {
        return arg1.then(new ClearAndSetSemanticsElement(arg2));
    }

    public static final int generateSemanticsId() {
        return SemanticsModifierKt.lastIdentifier.addAndGet(1);
    }

    public static final Modifier semantics(Modifier arg1, boolean arg2, Function1 arg3) {
        return arg1.then(new AppendedSemanticsElement(arg2, arg3));
    }

    public static Modifier semantics$default(Modifier arg0, boolean arg1, Function1 arg2, int arg3, Object arg4) {
        return SemanticsModifierKt.semantics(arg0, false, arg2);
    }
}

