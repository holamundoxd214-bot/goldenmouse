package androidx.compose.ui.focus;

import androidx.compose.ui.geometry.Rect;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 A2\u00020\u0001:\u0001AR\u0018\u0010\u0002\u001A\u00020\u0003X¦\u000E¢\u0006\f\u001A\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\t8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER$\u0010\u000F\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\t8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000ER$\u0010\u0012\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\t8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000ER$\u0010\u0015\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\t8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000ER$\u0010\u0018\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\t8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\u0019\u0010\f\"\u0004\b\u001A\u0010\u000ER$\u0010\u001B\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\t8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\u001C\u0010\f\"\u0004\b\u001D\u0010\u000ER$\u0010\u001E\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\t8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\u001F\u0010\f\"\u0004\b \u0010\u000ER$\u0010!\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\t8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000ERB\u0010\'\u001A\u000E\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\t0%2\u0012\u0010$\u001A\u000E\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\t0%8V@WX\u0097\u000E¢\u0006\u0012\u0012\u0004\b(\u0010)\u001A\u0004\b*\u0010+\"\u0004\b,\u0010-RF\u00101\u001A\u0013\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/0%¢\u0006\u0002\b02\u0017\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/0%¢\u0006\u0002\b08V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b2\u0010+\"\u0004\b3\u0010-RB\u00104\u001A\u000E\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\t0%2\u0012\u0010$\u001A\u000E\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\t0%8V@WX\u0097\u000E¢\u0006\u0012\u0012\u0004\b5\u0010)\u001A\u0004\b6\u0010+\"\u0004\b7\u0010-RF\u00108\u001A\u0013\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/0%¢\u0006\u0002\b02\u0017\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/0%¢\u0006\u0002\b08V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b9\u0010+\"\u0004\b:\u0010-R$\u0010<\u001A\u00020;2\u0006\u0010\b\u001A\u00020;8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b=\u0010>\"\u0004\b?\u0010@ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006BÀ\u0006\u0001"}, d2={"Landroidx/compose/ui/focus/FocusProperties;", "", "canFocus", "", "getCanFocus", "()Z", "setCanFocus", "(Z)V", "_", "Landroidx/compose/ui/focus/FocusRequester;", "next", "getNext", "()Landroidx/compose/ui/focus/FocusRequester;", "setNext", "(Landroidx/compose/ui/focus/FocusRequester;)V", "previous", "getPrevious", "setPrevious", "up", "getUp", "setUp", "down", "getDown", "setDown", "left", "getLeft", "setLeft", "right", "getRight", "setRight", "start", "getStart", "setStart", "end", "getEnd", "setEnd", "value", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusDirection;", "enter", "getEnter$annotations", "()V", "getEnter", "()Lkotlin/jvm/functions/Function1;", "setEnter", "(Lkotlin/jvm/functions/Function1;)V", "Landroidx/compose/ui/focus/FocusEnterExitScope;", "", "Lkotlin/ExtensionFunctionType;", "onEnter", "getOnEnter", "setOnEnter", "exit", "getExit$annotations", "getExit", "setExit", "onExit", "getOnExit", "setOnExit", "Landroidx/compose/ui/geometry/Rect;", "focusRect", "getFocusRect", "()Landroidx/compose/ui/geometry/Rect;", "setFocusRect", "(Landroidx/compose/ui/geometry/Rect;)V", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface FocusProperties {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/ui/focus/FocusProperties$Companion;", "", "<init>", "()V", "UnsetFocusRect", "Landroidx/compose/ui/geometry/Rect;", "getUnsetFocusRect", "()Landroidx/compose/ui/geometry/Rect;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        private static final Rect UnsetFocusRect;

        static {
            Companion.$$INSTANCE = new Companion();
            Companion.UnsetFocusRect = new Rect(NaNf, NaNf, NaNf, NaNf);
        }

        private Companion() {
            super();
        }

        public final Rect getUnsetFocusRect() {
            return Companion.UnsetFocusRect;
        }
    }

    public static final Companion Companion;

    static {
        FocusProperties.Companion = Companion.$$INSTANCE;
    }

    boolean getCanFocus();

    default FocusRequester getDown() {
        return FocusRequester.Companion.getDefault();
    }

    default FocusRequester getEnd() {
        return FocusRequester.Companion.getDefault();
    }

    default Function1 getEnter() {
        return FocusProperties$enter$1.INSTANCE;
    }

    static void getEnter$annotations() {
    }

    default Function1 getExit() {
        return FocusProperties$exit$1.INSTANCE;
    }

    static void getExit$annotations() {
    }

    default Rect getFocusRect() {
        return FocusProperties.Companion.getUnsetFocusRect();
    }

    default FocusRequester getLeft() {
        return FocusRequester.Companion.getDefault();
    }

    default FocusRequester getNext() {
        return FocusRequester.Companion.getDefault();
    }

    default Function1 getOnEnter() {
        return FocusProperties$onEnter$1.INSTANCE;
    }

    default Function1 getOnExit() {
        return FocusProperties$onExit$1.INSTANCE;
    }

    default FocusRequester getPrevious() {
        return FocusRequester.Companion.getDefault();
    }

    default FocusRequester getRight() {
        return FocusRequester.Companion.getDefault();
    }

    default FocusRequester getStart() {
        return FocusRequester.Companion.getDefault();
    }

    default FocusRequester getUp() {
        return FocusRequester.Companion.getDefault();
    }

    void setCanFocus(boolean arg1);

    default void setDown(FocusRequester arg1) {
    }

    default void setEnd(FocusRequester arg1) {
    }

    @Deprecated(message="Use onEnter instead", replaceWith="<_subannotation>") default void setEnter(Function1 arg1) {
        this.setOnEnter(FocusPropertiesKt.access$toUsingEnterExitScope(arg1));
    }

    @Deprecated(message="Use onExit instead", replaceWith="<_subannotation>") default void setExit(Function1 arg1) {
        this.setOnExit(FocusPropertiesKt.access$toUsingEnterExitScope(arg1));
    }

    default void setFocusRect(Rect arg1) {
    }

    default void setLeft(FocusRequester arg1) {
    }

    default void setNext(FocusRequester arg1) {
    }

    default void setOnEnter(Function1 arg1) {
    }

    default void setOnExit(Function1 arg1) {
    }

    default void setPrevious(FocusRequester arg1) {
    }

    default void setRight(FocusRequester arg1) {
    }

    default void setStart(FocusRequester arg1) {
    }

    default void setUp(FocusRequester arg1) {
    }
}

