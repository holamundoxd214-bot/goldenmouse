package androidx.compose.foundation.text.input.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0003H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0003H&¢\u0006\u0004\b\b\u0010\u0006J\b\u0010\t\u001A\u00020\nH&J!\u0010\u000B\u001A\u00020\f2\u0017\u0010\r\u001A\u0013\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\f0\u000E¢\u0006\u0002\b\u0010H&J\b\u0010\u0011\u001A\u00020\nH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2={"Landroidx/compose/foundation/text/input/internal/ImeEditCommandScope;", "", "mapFromTransformed", "Landroidx/compose/ui/text/TextRange;", "range", "mapFromTransformed-GEjPoXI", "(J)J", "mapToTransformed", "mapToTransformed-GEjPoXI", "beginBatchEdit", "", "edit", "", "block", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "Lkotlin/ExtensionFunctionType;", "endBatchEdit", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface ImeEditCommandScope {
    boolean beginBatchEdit();

    void edit(Function1 arg1);

    boolean endBatchEdit();

    long mapFromTransformed-GEjPoXI(long arg1);

    long mapToTransformed-GEjPoXI(long arg1);
}

