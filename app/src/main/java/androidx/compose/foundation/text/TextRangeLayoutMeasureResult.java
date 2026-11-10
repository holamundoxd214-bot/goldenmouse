package androidx.compose.foundation.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B\'\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\u000BR\u0017\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2={"Landroidx/compose/foundation/text/TextRangeLayoutMeasureResult;", "", "width", "", "height", "place", "Lkotlin/Function0;", "Landroidx/compose/ui/unit/IntOffset;", "<init>", "(IILkotlin/jvm/functions/Function0;)V", "getWidth", "()I", "getHeight", "getPlace", "()Lkotlin/jvm/functions/Function0;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextRangeLayoutMeasureResult {
    public static final int $stable;
    private final int height;
    private final Function0 place;
    private final int width;

    static {
    }

    public TextRangeLayoutMeasureResult(int arg1, int arg2, Function0 arg3) {
        super();
        this.width = arg1;
        this.height = arg2;
        this.place = arg3;
    }

    public final int getHeight() {
        return this.height;
    }

    public final Function0 getPlace() {
        return this.place;
    }

    public final int getWidth() {
        return this.width;
    }
}

