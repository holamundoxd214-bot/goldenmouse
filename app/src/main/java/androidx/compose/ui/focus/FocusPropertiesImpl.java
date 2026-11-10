package androidx.compose.ui.focus;

import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001A\u0010\u0004\u001A\u00020\u0005X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001A\u0010\n\u001A\u00020\u000BX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0010\u001A\u00020\u000BX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000FR\u001A\u0010\u0013\u001A\u00020\u000BX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000FR\u001A\u0010\u0016\u001A\u00020\u000BX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000FR\u001A\u0010\u0019\u001A\u00020\u000BX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\r\"\u0004\b\u001B\u0010\u000FR\u001A\u0010\u001C\u001A\u00020\u000BX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001D\u0010\r\"\u0004\b\u001E\u0010\u000FR\u001A\u0010\u001F\u001A\u00020\u000BX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b \u0010\r\"\u0004\b!\u0010\u000FR\u001A\u0010\"\u001A\u00020\u000BX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b#\u0010\r\"\u0004\b$\u0010\u000FR+\u0010%\u001A\u0013\u0012\u0004\u0012\u00020\'\u0012\u0004\u0012\u00020(0&¢\u0006\u0002\b)X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b*\u0010+\"\u0004\b,\u0010-R+\u0010.\u001A\u0013\u0012\u0004\u0012\u00020\'\u0012\u0004\u0012\u00020(0&¢\u0006\u0002\b)X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b/\u0010+\"\u0004\b0\u0010-R\u001A\u00101\u001A\u000202X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b3\u00104\"\u0004\b5\u00106¨\u00067"}, d2={"Landroidx/compose/ui/focus/FocusPropertiesImpl;", "Landroidx/compose/ui/focus/FocusProperties;", "<init>", "()V", "canFocus", "", "getCanFocus", "()Z", "setCanFocus", "(Z)V", "next", "Landroidx/compose/ui/focus/FocusRequester;", "getNext", "()Landroidx/compose/ui/focus/FocusRequester;", "setNext", "(Landroidx/compose/ui/focus/FocusRequester;)V", "previous", "getPrevious", "setPrevious", "up", "getUp", "setUp", "down", "getDown", "setDown", "left", "getLeft", "setLeft", "right", "getRight", "setRight", "start", "getStart", "setStart", "end", "getEnd", "setEnd", "onEnter", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusEnterExitScope;", "", "Lkotlin/ExtensionFunctionType;", "getOnEnter", "()Lkotlin/jvm/functions/Function1;", "setOnEnter", "(Lkotlin/jvm/functions/Function1;)V", "onExit", "getOnExit", "setOnExit", "focusRect", "Landroidx/compose/ui/geometry/Rect;", "getFocusRect", "()Landroidx/compose/ui/geometry/Rect;", "setFocusRect", "(Landroidx/compose/ui/geometry/Rect;)V", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FocusPropertiesImpl implements FocusProperties {
    public static final int $stable = 8;
    private boolean canFocus;
    private FocusRequester down;
    private FocusRequester end;
    private Rect focusRect;
    private FocusRequester left;
    private FocusRequester next;
    private Function1 onEnter;
    private Function1 onExit;
    private FocusRequester previous;
    private FocusRequester right;
    private FocusRequester start;
    private FocusRequester up;

    static {
    }

    public FocusPropertiesImpl() {
        super();
        this.canFocus = true;
        this.next = FocusRequester.Companion.getDefault();
        this.previous = FocusRequester.Companion.getDefault();
        this.up = FocusRequester.Companion.getDefault();
        this.down = FocusRequester.Companion.getDefault();
        this.left = FocusRequester.Companion.getDefault();
        this.right = FocusRequester.Companion.getDefault();
        this.start = FocusRequester.Companion.getDefault();
        this.end = FocusRequester.Companion.getDefault();
        this.onEnter = FocusPropertiesImpl$onEnter$1.INSTANCE;
        this.onExit = FocusPropertiesImpl$onExit$1.INSTANCE;
        this.focusRect = FocusProperties.Companion.getUnsetFocusRect();
    }

    public boolean getCanFocus() {
        return this.canFocus;
    }

    public FocusRequester getDown() {
        return this.down;
    }

    public FocusRequester getEnd() {
        return this.end;
    }

    public Rect getFocusRect() {
        return this.focusRect;
    }

    public FocusRequester getLeft() {
        return this.left;
    }

    public FocusRequester getNext() {
        return this.next;
    }

    public Function1 getOnEnter() {
        return this.onEnter;
    }

    public Function1 getOnExit() {
        return this.onExit;
    }

    public FocusRequester getPrevious() {
        return this.previous;
    }

    public FocusRequester getRight() {
        return this.right;
    }

    public FocusRequester getStart() {
        return this.start;
    }

    public FocusRequester getUp() {
        return this.up;
    }

    public void setCanFocus(boolean arg1) {
        this.canFocus = arg1;
    }

    public void setDown(FocusRequester arg1) {
        this.down = arg1;
    }

    public void setEnd(FocusRequester arg1) {
        this.end = arg1;
    }

    public void setFocusRect(Rect arg1) {
        this.focusRect = arg1;
    }

    public void setLeft(FocusRequester arg1) {
        this.left = arg1;
    }

    public void setNext(FocusRequester arg1) {
        this.next = arg1;
    }

    public void setOnEnter(Function1 arg1) {
        this.onEnter = arg1;
    }

    public void setOnExit(Function1 arg1) {
        this.onExit = arg1;
    }

    public void setPrevious(FocusRequester arg1) {
        this.previous = arg1;
    }

    public void setRight(FocusRequester arg1) {
        this.right = arg1;
    }

    public void setStart(FocusRequester arg1) {
        this.start = arg1;
    }

    public void setUp(FocusRequester arg1) {
        this.up = arg1;
    }
}

