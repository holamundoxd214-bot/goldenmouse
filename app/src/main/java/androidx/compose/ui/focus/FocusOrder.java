package androidx.compose.ui.focus;

import kotlin.Deprecated;
import kotlin.Metadata;

@Deprecated(message="Use FocusProperties instead") @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001A\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\b8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR$\u0010\r\u001A\u00020\b2\u0006\u0010\r\u001A\u00020\b8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u000E\u0010\n\"\u0004\b\u000F\u0010\fR$\u0010\u0010\u001A\u00020\b2\u0006\u0010\u0010\u001A\u00020\b8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR$\u0010\u0013\u001A\u00020\b2\u0006\u0010\u0013\u001A\u00020\b8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR$\u0010\u0016\u001A\u00020\b2\u0006\u0010\u0016\u001A\u00020\b8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR$\u0010\u0019\u001A\u00020\b2\u0006\u0010\u0019\u001A\u00020\b8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u001A\u0010\n\"\u0004\b\u001B\u0010\fR$\u0010\u001C\u001A\u00020\b2\u0006\u0010\u001C\u001A\u00020\b8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u001D\u0010\n\"\u0004\b\u001E\u0010\fR$\u0010\u001F\u001A\u00020\b2\u0006\u0010\u001F\u001A\u00020\b8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b \u0010\n\"\u0004\b!\u0010\f¨\u0006\""}, d2={"Landroidx/compose/ui/focus/FocusOrder;", "", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "<init>", "(Landroidx/compose/ui/focus/FocusProperties;)V", "()V", "next", "Landroidx/compose/ui/focus/FocusRequester;", "getNext", "()Landroidx/compose/ui/focus/FocusRequester;", "setNext", "(Landroidx/compose/ui/focus/FocusRequester;)V", "previous", "getPrevious", "setPrevious", "up", "getUp", "setUp", "down", "getDown", "setDown", "left", "getLeft", "setLeft", "right", "getRight", "setRight", "start", "getStart", "setStart", "end", "getEnd", "setEnd", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FocusOrder {
    public static final int $stable = 8;
    private final FocusProperties focusProperties;

    static {
    }

    public FocusOrder() {
        this(new FocusPropertiesImpl());
    }

    public FocusOrder(FocusProperties arg1) {
        super();
        this.focusProperties = arg1;
    }

    public final FocusRequester getDown() {
        return this.focusProperties.getDown();
    }

    public final FocusRequester getEnd() {
        return this.focusProperties.getEnd();
    }

    public final FocusRequester getLeft() {
        return this.focusProperties.getLeft();
    }

    public final FocusRequester getNext() {
        return this.focusProperties.getNext();
    }

    public final FocusRequester getPrevious() {
        return this.focusProperties.getPrevious();
    }

    public final FocusRequester getRight() {
        return this.focusProperties.getRight();
    }

    public final FocusRequester getStart() {
        return this.focusProperties.getStart();
    }

    public final FocusRequester getUp() {
        return this.focusProperties.getUp();
    }

    public final void setDown(FocusRequester arg1) {
        this.focusProperties.setDown(arg1);
    }

    public final void setEnd(FocusRequester arg1) {
        this.focusProperties.setEnd(arg1);
    }

    public final void setLeft(FocusRequester arg1) {
        this.focusProperties.setLeft(arg1);
    }

    public final void setNext(FocusRequester arg1) {
        this.focusProperties.setNext(arg1);
    }

    public final void setPrevious(FocusRequester arg1) {
        this.focusProperties.setPrevious(arg1);
    }

    public final void setRight(FocusRequester arg1) {
        this.focusProperties.setRight(arg1);
    }

    public final void setStart(FocusRequester arg1) {
        this.focusProperties.setStart(arg1);
    }

    public final void setUp(FocusRequester arg1) {
        this.focusProperties.setUp(arg1);
    }
}

