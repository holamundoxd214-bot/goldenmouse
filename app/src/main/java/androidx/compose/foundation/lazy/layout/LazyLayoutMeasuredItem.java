package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b`\u0018\u00002\u00020\u0001J\u0017\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u0002\u001A\u00020\u0003H&¢\u0006\u0004\b\u001E\u0010\u001FJ(\u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020\u00032\u0006\u0010#\u001A\u00020\u00032\u0006\u0010$\u001A\u00020\u00032\u0006\u0010%\u001A\u00020\u0003H&J\u0012\u0010&\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001A\u00020\u0003H&R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001A\u00020\u0001X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001A\u00020\nX¦\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\u000BR\u0012\u0010\f\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u0005R\u0012\u0010\u000E\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0005R\u0018\u0010\u0010\u001A\u00020\nX¦\u000E¢\u0006\f\u001A\u0004\b\u0011\u0010\u000B\"\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001A\u00020\u0015X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u0005R\u0012\u0010\u001A\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\'À\u0006\u0001"}, d2={"Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "", "index", "", "getIndex", "()I", "key", "getKey", "()Ljava/lang/Object;", "isVertical", "", "()Z", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "placeablesCount", "getPlaceablesCount", "nonScrollableItem", "getNonScrollableItem", "setNonScrollableItem", "(Z)V", "constraints", "Landroidx/compose/ui/unit/Constraints;", "getConstraints-msEJaDk", "()J", "lane", "getLane", "span", "getSpan", "getOffset", "Landroidx/compose/ui/unit/IntOffset;", "getOffset-Bjo55l4", "(I)J", "position", "", "mainAxisOffset", "crossAxisOffset", "layoutWidth", "layoutHeight", "getParentData", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface LazyLayoutMeasuredItem {
    long getConstraints-msEJaDk();

    int getIndex();

    Object getKey();

    int getLane();

    int getMainAxisSizeWithSpacings();

    boolean getNonScrollableItem();

    long getOffset-Bjo55l4(int arg1);

    Object getParentData(int arg1);

    int getPlaceablesCount();

    int getSpan();

    boolean isVertical();

    void position(int arg1, int arg2, int arg3, int arg4);

    void setNonScrollableItem(boolean arg1);
}

