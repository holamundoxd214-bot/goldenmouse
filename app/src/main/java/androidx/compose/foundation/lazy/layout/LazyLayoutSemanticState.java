package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.semantics.CollectionInfo;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\b\u0010\u000E\u001A\u00020\u000FH&J\u0016\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0003H¦@¢\u0006\u0002\u0010\u0013R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001A\u00020\tX¦\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0012\u0010\f\u001A\u00020\tX¦\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000Bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2={"Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "", "viewport", "", "getViewport", "()I", "contentPadding", "getContentPadding", "scrollOffset", "", "getScrollOffset", "()F", "maxScrollOffset", "getMaxScrollOffset", "collectionInfo", "Landroidx/compose/ui/semantics/CollectionInfo;", "scrollToItem", "", "index", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface LazyLayoutSemanticState {
    CollectionInfo collectionInfo();

    int getContentPadding();

    float getMaxScrollOffset();

    float getScrollOffset();

    int getViewport();

    Object scrollToItem(int arg1, Continuation arg2);
}

