package androidx.compose.foundation.text.input.internal;

import android.view.KeyEvent;
import androidx.collection.MutableLongSet;
import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.text.DeadKeyCombiner;
import androidx.compose.foundation.text.KeyCommand;
import androidx.compose.foundation.text.KeyEventHelpers_androidKt;
import androidx.compose.foundation.text.KeyMapping;
import androidx.compose.foundation.text.KeyMapping_androidKt;
import androidx.compose.foundation.text.StringHelpers_jvmKt;
import androidx.compose.foundation.text.TextFieldKeyInput_androidKt;
import androidx.compose.foundation.text.input.internal.selection.SelectionMovementDeletionContext;
import androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelectionState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\b!\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J]\u0010\u001A\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u001F\u001A\u00020\r2\u0006\u0010 \u001A\u00020\r2\f\u0010!\u001A\b\u0012\u0004\u0012\u00020\r0\"H\u0016¢\u0006\u0004\b#\u0010$JU\u0010%\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u001F\u001A\u00020\r2\u0006\u0010 \u001A\u00020\r2\f\u0010!\u001A\b\u0012\u0004\u0012\u00020\r0\"H\u0002¢\u0006\u0004\b&\u0010\'J\f\u0010(\u001A\u00020)*\u00020\u001CH\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001A\u0004\u0018\u00010\u000BX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006*"}, d2={"Landroidx/compose/foundation/text/input/internal/TextFieldKeyEventHandler;", "", "<init>", "()V", "preparedSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelectionState;", "deadKeyCombiner", "Landroidx/compose/foundation/text/DeadKeyCombiner;", "keyMapping", "Landroidx/compose/foundation/text/KeyMapping;", "currentlyConsumedDownKeys", "Landroidx/collection/MutableLongSet;", "onPreKeyEvent", "", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "onPreKeyEvent-MyFupTE", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/focus/FocusManager;Landroidx/compose/ui/platform/SoftwareKeyboardController;)Z", "onKeyEvent", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "clipboardKeyCommandsHandler", "Landroidx/compose/foundation/text/input/internal/ClipboardKeyCommandsHandler;", "editable", "singleLine", "onSubmit", "Lkotlin/Function0;", "onKeyEvent-8zsqlwg", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/platform/SoftwareKeyboardController;ZZLkotlin/jvm/functions/Function0;)Z", "processKeyDownEvent", "processKeyDownEvent-q0GpTC0", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/platform/SoftwareKeyboardController;ZZLkotlin/jvm/functions/Function0;)Z", "getVisibleTextLayoutHeight", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class TextFieldKeyEventHandler {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[KeyCommand.values().length];
            try {
                v0[KeyCommand.COPY.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[KeyCommand.PASTE.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[KeyCommand.CUT.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[KeyCommand.LEFT_CHAR.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_19:
                                v0[KeyCommand.RIGHT_CHAR.ordinal()] = 5;
                                goto label_23;
                            }
                            catch(NoSuchFieldError ) {
                                try {
                                label_23:
                                    v0[KeyCommand.LEFT_WORD.ordinal()] = 6;
                                    goto label_27;
                                }
                                catch(NoSuchFieldError ) {
                                    try {
                                    label_27:
                                        v0[KeyCommand.RIGHT_WORD.ordinal()] = 7;
                                        goto label_31;
                                    }
                                    catch(NoSuchFieldError ) {
                                        try {
                                        label_31:
                                            v0[KeyCommand.PREV_PARAGRAPH.ordinal()] = 8;
                                            goto label_35;
                                        }
                                        catch(NoSuchFieldError ) {
                                            try {
                                            label_35:
                                                v0[KeyCommand.NEXT_PARAGRAPH.ordinal()] = 9;
                                                goto label_39;
                                            }
                                            catch(NoSuchFieldError ) {
                                                try {
                                                label_39:
                                                    v0[KeyCommand.UP.ordinal()] = 10;
                                                    goto label_43;
                                                }
                                                catch(NoSuchFieldError ) {
                                                    try {
                                                    label_43:
                                                        v0[KeyCommand.DOWN.ordinal()] = 11;
                                                        goto label_47;
                                                    }
                                                    catch(NoSuchFieldError ) {
                                                        try {
                                                        label_47:
                                                            v0[KeyCommand.PAGE_UP.ordinal()] = 12;
                                                            goto label_51;
                                                        }
                                                        catch(NoSuchFieldError ) {
                                                            try {
                                                            label_51:
                                                                v0[KeyCommand.PAGE_DOWN.ordinal()] = 13;
                                                                goto label_55;
                                                            }
                                                            catch(NoSuchFieldError ) {
                                                                try {
                                                                label_55:
                                                                    v0[KeyCommand.LINE_START.ordinal()] = 14;
                                                                    goto label_59;
                                                                }
                                                                catch(NoSuchFieldError ) {
                                                                    try {
                                                                    label_59:
                                                                        v0[KeyCommand.LINE_END.ordinal()] = 15;
                                                                        goto label_63;
                                                                    }
                                                                    catch(NoSuchFieldError ) {
                                                                        try {
                                                                        label_63:
                                                                            v0[KeyCommand.LINE_LEFT.ordinal()] = 16;
                                                                            goto label_67;
                                                                        }
                                                                        catch(NoSuchFieldError ) {
                                                                            try {
                                                                            label_67:
                                                                                v0[KeyCommand.LINE_RIGHT.ordinal()] = 17;
                                                                                goto label_71;
                                                                            }
                                                                            catch(NoSuchFieldError ) {
                                                                                try {
                                                                                label_71:
                                                                                    v0[KeyCommand.HOME.ordinal()] = 18;
                                                                                    goto label_75;
                                                                                }
                                                                                catch(NoSuchFieldError ) {
                                                                                    try {
                                                                                    label_75:
                                                                                        v0[KeyCommand.END.ordinal()] = 19;
                                                                                        goto label_79;
                                                                                    }
                                                                                    catch(NoSuchFieldError ) {
                                                                                        try {
                                                                                        label_79:
                                                                                            v0[KeyCommand.DELETE_PREV_CHAR.ordinal()] = 20;
                                                                                            goto label_83;
                                                                                        }
                                                                                        catch(NoSuchFieldError ) {
                                                                                            try {
                                                                                            label_83:
                                                                                                v0[KeyCommand.DELETE_NEXT_CHAR.ordinal()] = 21;
                                                                                                goto label_87;
                                                                                            }
                                                                                            catch(NoSuchFieldError ) {
                                                                                                try {
                                                                                                label_87:
                                                                                                    v0[KeyCommand.DELETE_PREV_WORD.ordinal()] = 22;
                                                                                                    goto label_91;
                                                                                                }
                                                                                                catch(NoSuchFieldError ) {
                                                                                                    try {
                                                                                                    label_91:
                                                                                                        v0[KeyCommand.DELETE_NEXT_WORD.ordinal()] = 23;
                                                                                                        goto label_95;
                                                                                                    }
                                                                                                    catch(NoSuchFieldError ) {
                                                                                                        try {
                                                                                                        label_95:
                                                                                                            v0[KeyCommand.DELETE_FROM_LINE_START.ordinal()] = 24;
                                                                                                            goto label_99;
                                                                                                        }
                                                                                                        catch(NoSuchFieldError ) {
                                                                                                            try {
                                                                                                            label_99:
                                                                                                                v0[KeyCommand.DELETE_TO_LINE_END.ordinal()] = 25;
                                                                                                                goto label_103;
                                                                                                            }
                                                                                                            catch(NoSuchFieldError ) {
                                                                                                                try {
                                                                                                                label_103:
                                                                                                                    v0[KeyCommand.NEW_LINE.ordinal()] = 26;
                                                                                                                    goto label_107;
                                                                                                                }
                                                                                                                catch(NoSuchFieldError ) {
                                                                                                                    try {
                                                                                                                    label_107:
                                                                                                                        v0[KeyCommand.TAB.ordinal()] = 27;
                                                                                                                        goto label_111;
                                                                                                                    }
                                                                                                                    catch(NoSuchFieldError ) {
                                                                                                                        try {
                                                                                                                        label_111:
                                                                                                                            v0[KeyCommand.SELECT_ALL.ordinal()] = 28;
                                                                                                                            goto label_115;
                                                                                                                        }
                                                                                                                        catch(NoSuchFieldError ) {
                                                                                                                            try {
                                                                                                                            label_115:
                                                                                                                                v0[KeyCommand.SELECT_LEFT_CHAR.ordinal()] = 29;
                                                                                                                                goto label_119;
                                                                                                                            }
                                                                                                                            catch(NoSuchFieldError ) {
                                                                                                                                try {
                                                                                                                                label_119:
                                                                                                                                    v0[KeyCommand.SELECT_RIGHT_CHAR.ordinal()] = 30;
                                                                                                                                    goto label_123;
                                                                                                                                }
                                                                                                                                catch(NoSuchFieldError ) {
                                                                                                                                    try {
                                                                                                                                    label_123:
                                                                                                                                        v0[KeyCommand.SELECT_LEFT_WORD.ordinal()] = 0x1F;
                                                                                                                                        goto label_127;
                                                                                                                                    }
                                                                                                                                    catch(NoSuchFieldError ) {
                                                                                                                                        try {
                                                                                                                                        label_127:
                                                                                                                                            v0[KeyCommand.SELECT_RIGHT_WORD.ordinal()] = 0x20;
                                                                                                                                            goto label_131;
                                                                                                                                        }
                                                                                                                                        catch(NoSuchFieldError ) {
                                                                                                                                            try {
                                                                                                                                            label_131:
                                                                                                                                                v0[KeyCommand.SELECT_PREV_PARAGRAPH.ordinal()] = 33;
                                                                                                                                                goto label_135;
                                                                                                                                            }
                                                                                                                                            catch(NoSuchFieldError ) {
                                                                                                                                                try {
                                                                                                                                                label_135:
                                                                                                                                                    v0[KeyCommand.SELECT_NEXT_PARAGRAPH.ordinal()] = 34;
                                                                                                                                                    goto label_139;
                                                                                                                                                }
                                                                                                                                                catch(NoSuchFieldError ) {
                                                                                                                                                    try {
                                                                                                                                                    label_139:
                                                                                                                                                        v0[KeyCommand.SELECT_LINE_START.ordinal()] = 35;
                                                                                                                                                        goto label_143;
                                                                                                                                                    }
                                                                                                                                                    catch(NoSuchFieldError ) {
                                                                                                                                                        try {
                                                                                                                                                        label_143:
                                                                                                                                                            v0[KeyCommand.SELECT_LINE_END.ordinal()] = 36;
                                                                                                                                                            goto label_147;
                                                                                                                                                        }
                                                                                                                                                        catch(NoSuchFieldError ) {
                                                                                                                                                            try {
                                                                                                                                                            label_147:
                                                                                                                                                                v0[KeyCommand.SELECT_LINE_LEFT.ordinal()] = 37;
                                                                                                                                                                goto label_151;
                                                                                                                                                            }
                                                                                                                                                            catch(NoSuchFieldError ) {
                                                                                                                                                                try {
                                                                                                                                                                label_151:
                                                                                                                                                                    v0[KeyCommand.SELECT_LINE_RIGHT.ordinal()] = 38;
                                                                                                                                                                    goto label_155;
                                                                                                                                                                }
                                                                                                                                                                catch(NoSuchFieldError ) {
                                                                                                                                                                    try {
                                                                                                                                                                    label_155:
                                                                                                                                                                        v0[KeyCommand.SELECT_UP.ordinal()] = 39;
                                                                                                                                                                        goto label_159;
                                                                                                                                                                    }
                                                                                                                                                                    catch(NoSuchFieldError ) {
                                                                                                                                                                        try {
                                                                                                                                                                        label_159:
                                                                                                                                                                            v0[KeyCommand.SELECT_DOWN.ordinal()] = 40;
                                                                                                                                                                            goto label_163;
                                                                                                                                                                        }
                                                                                                                                                                        catch(NoSuchFieldError ) {
                                                                                                                                                                            try {
                                                                                                                                                                            label_163:
                                                                                                                                                                                v0[KeyCommand.SELECT_PAGE_UP.ordinal()] = 41;
                                                                                                                                                                                goto label_167;
                                                                                                                                                                            }
                                                                                                                                                                            catch(NoSuchFieldError ) {
                                                                                                                                                                                try {
                                                                                                                                                                                label_167:
                                                                                                                                                                                    v0[KeyCommand.SELECT_PAGE_DOWN.ordinal()] = 42;
                                                                                                                                                                                    goto label_171;
                                                                                                                                                                                }
                                                                                                                                                                                catch(NoSuchFieldError ) {
                                                                                                                                                                                    try {
                                                                                                                                                                                    label_171:
                                                                                                                                                                                        v0[KeyCommand.SELECT_HOME.ordinal()] = 43;
                                                                                                                                                                                        goto label_175;
                                                                                                                                                                                    }
                                                                                                                                                                                    catch(NoSuchFieldError ) {
                                                                                                                                                                                        try {
                                                                                                                                                                                        label_175:
                                                                                                                                                                                            v0[KeyCommand.SELECT_END.ordinal()] = 44;
                                                                                                                                                                                            goto label_179;
                                                                                                                                                                                        }
                                                                                                                                                                                        catch(NoSuchFieldError ) {
                                                                                                                                                                                            try {
                                                                                                                                                                                            label_179:
                                                                                                                                                                                                v0[KeyCommand.DESELECT.ordinal()] = 45;
                                                                                                                                                                                                goto label_183;
                                                                                                                                                                                            }
                                                                                                                                                                                            catch(NoSuchFieldError ) {
                                                                                                                                                                                                try {
                                                                                                                                                                                                label_183:
                                                                                                                                                                                                    v0[KeyCommand.UNDO.ordinal()] = 46;
                                                                                                                                                                                                    goto label_187;
                                                                                                                                                                                                }
                                                                                                                                                                                                catch(NoSuchFieldError ) {
                                                                                                                                                                                                    try {
                                                                                                                                                                                                    label_187:
                                                                                                                                                                                                        v0[KeyCommand.REDO.ordinal()] = 0x2F;
                                                                                                                                                                                                        goto label_191;
                                                                                                                                                                                                    }
                                                                                                                                                                                                    catch(NoSuchFieldError ) {
                                                                                                                                                                                                        try {
                                                                                                                                                                                                        label_191:
                                                                                                                                                                                                            v0[KeyCommand.CHARACTER_PALETTE.ordinal()] = 0x30;
                                                                                                                                                                                                            goto label_195;
                                                                                                                                                                                                        }
                                                                                                                                                                                                        catch(NoSuchFieldError ) {
                                                                                                                                                                                                            try {
                                                                                                                                                                                                            label_195:
                                                                                                                                                                                                                v0[KeyCommand.CENTER.ordinal()] = 49;
                                                                                                                                                                                                                goto label_199;
                                                                                                                                                                                                            }
                                                                                                                                                                                                            catch(NoSuchFieldError ) {
                                                                                                                                                                                                            label_199:
                                                                                                                                                                                                                WhenMappings.$EnumSwitchMapping$0 = v0;
                                                                                                                                                                                                                return;
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static final int $stable = 8;
    private MutableLongSet currentlyConsumedDownKeys;
    private final DeadKeyCombiner deadKeyCombiner;
    private final KeyMapping keyMapping;
    private final TextFieldPreparedSelectionState preparedSelectionState;

    public static Unit $r8$lambda$cL2zOB6bDyBxmVpH7EzkneDMfC4(SelectionMovementDeletionContext arg0) {
        return TextFieldKeyEventHandler.processKeyDownEvent_q0GpTC0$lambda$0$1(arg0);
    }

    public static Unit $r8$lambda$ev-VnmB1Pdz9qgtwvfTEY9l9cN4(SelectionMovementDeletionContext arg0) {
        return TextFieldKeyEventHandler.processKeyDownEvent_q0GpTC0$lambda$0$0(arg0);
    }

    static {
    }

    public TextFieldKeyEventHandler() {
        super();
        this.preparedSelectionState = new TextFieldPreparedSelectionState();
        this.deadKeyCombiner = new DeadKeyCombiner();
        this.keyMapping = KeyMapping_androidKt.getPlatformDefaultKeyMapping();
    }

    private final float getVisibleTextLayoutHeight(TextLayoutState arg4) {
        Rect v1_1;
        LayoutCoordinates v3 = arg4.getTextLayoutNodeCoordinates();
        if(v3 != null) {
            Object v1 = null;
            if(v3.isAttached()) {
            }
            else {
                v3 = ((LayoutCoordinates)v1);
            }

            if(v3 == null) {
                return NaNf;
            }

            LayoutCoordinates v4 = arg4.getDecoratorNodeCoordinates();
            if(v4 != null) {
                if(v4.isAttached()) {
                }
                else {
                    v4 = ((LayoutCoordinates)v1);
                }

                if(v4 == null) {
                    goto label_18;
                }

                v1_1 = LayoutCoordinates.localBoundingBoxOf$default(v4, v3, false, 2, v1);
            }

        label_18:
            if(v1_1 == null) {
                return NaNf;
            }

            return Float.intBitsToFloat(((int)(v1_1.getSize-NH-jbRc() & 0xFFFFFFFFL)));
        }

        return NaNf;
    }

    public boolean onKeyEvent-8zsqlwg(KeyEvent arg12, TransformedTextFieldState arg13, TextLayoutState arg14, TextFieldSelectionState arg15, Function1 arg16, SoftwareKeyboardController arg17, boolean arg18, boolean arg19, Function0 arg20) {
        long v9 = KeyEvent_androidKt.getKey-ZmokQxo(arg12);
        if(KeyEventType.equals-impl0(KeyEvent_androidKt.getType-ZmokQxo(arg12), KeyEventType.Companion.getKeyUp-CS__XNY())) {
            MutableLongSet v1 = this.currentlyConsumedDownKeys;
            if(v1 != null && (v1.contains(v9))) {
                MutableLongSet v0 = this.currentlyConsumedDownKeys;
                if(v0 != null) {
                    v0.remove(v9);
                }

                return 1;
            }

            return 0;
        }

        if((KeyEventType.equals-impl0(KeyEvent_androidKt.getType-ZmokQxo(arg12), KeyEventType.Companion.getUnknown-CS__XNY())) && !TextFieldKeyInput_androidKt.isTypedEvent-ZmokQxo(arg12)) {
            return 0;
        }

        boolean v1_1 = this.processKeyDownEvent-q0GpTC0(arg12, arg13, arg14, arg16, arg17, arg18, arg19, arg20);
        if(v1_1) {
            MutableLongSet v2 = this.currentlyConsumedDownKeys;
            if(v2 == null) {
                v2 = new MutableLongSet(3);
                this.currentlyConsumedDownKeys = v2;
            }

            v2.plusAssign(v9);
        }

        return v1_1;
    }

    public boolean onPreKeyEvent-MyFupTE(KeyEvent arg1, TransformedTextFieldState arg2, TextFieldSelectionState arg3, FocusManager arg4, SoftwareKeyboardController arg5) {
        if(!TextRange.getCollapsed-impl(arg2.getVisualText().getSelection-d9O1mEE()) && (KeyEventHelpers_androidKt.cancelsTextSelection-ZmokQxo(arg1))) {
            arg3.deselect();
            return 1;
        }

        return 0;
    }

    private final boolean processKeyDownEvent-q0GpTC0(KeyEvent arg11, TransformedTextFieldState arg12, TextLayoutState arg13, Function1 arg14, SoftwareKeyboardController arg15, boolean arg16, boolean arg17, Function0 arg18) {
        int v1_1;
        boolean v1 = false;
        if(TextFieldKeyInput_androidKt.isTypedEvent-ZmokQxo(arg11)) {
            Integer v0 = this.deadKeyCombiner.consume-ZmokQxo(arg11);
            if(v0 != null) {
                String v13 = StringHelpers_jvmKt.appendCodePointX(new StringBuilder(2), v0.intValue()).toString();
                if(arg16) {
                    TransformedTextFieldState.replaceSelectedText$default(arg12, v13, true, null, TextFieldKeyEventHandler_androidKt.isFromSoftKeyboard-ZmokQxo(arg11) ^ 1, 4, null);
                    this.preparedSelectionState.resetCachedX();
                    return 1;
                }
                else {
                    return 0;
                }
            }
        }

        KeyCommand v0_1 = this.keyMapping.map-ZmokQxo(arg11);
        if(v0_1 != null && (!v0_1.getEditsText() || (arg16))) {
            SelectionMovementDeletionContext v10 = new SelectionMovementDeletionContext(arg12, arg13.getLayoutResult(), TextFieldKeyEventHandler_androidKt.isFromSoftKeyboard-ZmokQxo(arg11), this.getVisibleTextLayoutHeight(arg13), this.preparedSelectionState);
            switch(WhenMappings.$EnumSwitchMapping$0[v0_1.ordinal()]) {
                case 1: 
                case 2: 
                case 3: {
                    goto label_202;
                }
                case 4: {
                    goto label_198;
                }
                case 5: {
                    goto label_194;
                }
                case 6: {
                    goto label_192;
                }
                case 7: {
                    goto label_190;
                }
                case 8: {
                    goto label_188;
                }
                case 9: {
                    goto label_186;
                }
                case 10: {
                    goto label_184;
                }
                case 11: {
                    goto label_182;
                }
                case 12: {
                    goto label_180;
                }
                case 13: {
                    goto label_178;
                }
                case 14: {
                    goto label_176;
                }
                case 15: {
                    goto label_174;
                }
                case 16: {
                    goto label_172;
                }
                case 17: {
                    goto label_170;
                }
                case 18: {
                    goto label_168;
                }
                case 19: {
                    goto label_166;
                }
                case 20: {
                    goto label_163;
                }
                case 21: {
                    goto label_160;
                }
                case 22: {
                    goto label_157;
                }
                case 23: {
                    goto label_154;
                }
                case 24: {
                    goto label_151;
                }
                case 25: {
                    goto label_148;
                }
                case 26: {
                    goto label_130;
                }
                case 27: {
                    goto label_116;
                }
                case 28: {
                    goto label_114;
                }
                case 29: {
                    goto label_111;
                }
                case 30: {
                    goto label_108;
                }
                case 31: {
                    goto label_105;
                }
                case 32: {
                    goto label_102;
                }
                case 33: {
                    goto label_99;
                }
                case 34: {
                    goto label_96;
                }
                case 35: {
                    goto label_93;
                }
                case 36: {
                    goto label_90;
                }
                case 37: {
                    goto label_87;
                }
                case 38: {
                    goto label_84;
                }
                case 39: {
                    goto label_81;
                }
                case 40: {
                    goto label_78;
                }
                case 41: {
                    goto label_75;
                }
                case 42: {
                    goto label_72;
                }
                case 43: {
                    goto label_69;
                }
                case 44: {
                    goto label_66;
                }
                case 45: {
                    goto label_64;
                }
                case 46: {
                    goto label_61;
                }
                case 47: {
                    goto label_58;
                }
                case 48: {
                    goto label_55;
                }
                case 49: {
                    goto label_49;
                }
            }

            throw new NoWhenBranchMatchedException();
        label_99:
            v10.moveCursorPrevByParagraph().selectMovement();
            goto label_204;
        label_102:
            v10.moveCursorRightByWord().selectMovement();
            goto label_204;
        label_105:
            v10.moveCursorLeftByWord().selectMovement();
            goto label_204;
        label_108:
            v10.moveCursorRightByChar().selectMovement();
            goto label_204;
        label_111:
            v10.moveCursorLeftByChar().selectMovement();
            goto label_204;
        label_114:
            v10.selectAll();
            goto label_204;
        label_116:
            if(arg17) {
                goto label_205;
            }

            TransformedTextFieldState.replaceSelectedText$default(arg12, "\t", true, null, TextFieldKeyEventHandler_androidKt.isFromSoftKeyboard-ZmokQxo(arg11) ^ 1, 4, null);
            v1 = true;
            goto label_205;
        label_130:
            if(!arg17) {
                TransformedTextFieldState.replaceSelectedText$default(arg12, "\n", true, null, TextFieldKeyEventHandler_androidKt.isFromSoftKeyboard-ZmokQxo(arg11) ^ 1, 4, null);
                v1 = true;
                goto label_205;
            }

            v1 = arg18.invoke().booleanValue();
            goto label_205;
        label_148:
            v10.moveCursorToLineEnd().deleteMovement();
            goto label_204;
        label_151:
            v10.moveCursorToLineStart().deleteMovement();
            goto label_204;
        label_154:
            v10.moveCursorNextByWord().deleteMovement();
            goto label_204;
        label_157:
            v10.moveCursorPrevByWord().deleteMovement();
            goto label_204;
        label_160:
            v10.moveCursorNextByChar().deleteMovement();
            goto label_204;
        label_163:
            v10.moveCursorPrevByCodePointOrEmoji().deleteMovement();
            goto label_204;
        label_166:
            v10.moveCursorToEnd();
            goto label_204;
        label_168:
            v10.moveCursorToHome();
            goto label_204;
        label_170:
            v10.moveCursorToLineRightSide();
            goto label_204;
        label_172:
            v10.moveCursorToLineLeftSide();
            goto label_204;
        label_174:
            v10.moveCursorToLineEnd();
            goto label_204;
        label_176:
            v10.moveCursorToLineStart();
            goto label_204;
        label_49:
            if(!ComposeFoundationFlags.isTextFieldDpadNavigationEnabled) {
            }
            else {
                arg15.show();
                v1 = true;
                goto label_205;
            label_178:
                v10.moveCursorDownByPage();
                goto label_204;
            label_180:
                v10.moveCursorUpByPage();
                goto label_204;
            label_182:
                v10.moveCursorDownByLine();
                goto label_204;
            label_55:
                KeyEventHelpers_androidKt.showCharacterPalette();
                goto label_204;
            label_184:
                v10.moveCursorUpByLine();
                goto label_204;
            label_186:
                v10.moveCursorNextByParagraph();
                goto label_204;
            label_58:
                arg12.redo();
                goto label_204;
            label_188:
                v10.moveCursorPrevByParagraph();
                goto label_204;
            label_61:
                arg12.undo();
                goto label_204;
            label_190:
                v10.moveCursorRightByWord();
                goto label_204;
            label_192:
                v10.moveCursorLeftByWord();
                goto label_204;
            label_64:
                v10.deselect();
                goto label_204;
            label_194:
                v10.collapseRightOr(new TextFieldKeyEventHandler$$ExternalSyntheticLambda1());
                goto label_204;
            label_66:
                v10.moveCursorToEnd().selectMovement();
                goto label_204;
            label_69:
                v10.moveCursorToHome().selectMovement();
                goto label_204;
            label_198:
                v10.collapseLeftOr(new TextFieldKeyEventHandler$$ExternalSyntheticLambda0());
                goto label_204;
            label_72:
                v10.moveCursorDownByPage().selectMovement();
                goto label_204;
            label_202:
                arg14.invoke(v0_1);
                goto label_204;
            label_75:
                v10.moveCursorUpByPage().selectMovement();
                goto label_204;
            label_78:
                v10.moveCursorDownByLine().selectMovement();
                goto label_204;
            label_81:
                v10.moveCursorUpByLine().selectMovement();
                goto label_204;
            label_84:
                v10.moveCursorToLineRightSide().selectMovement();
                goto label_204;
            label_87:
                v10.moveCursorToLineLeftSide().selectMovement();
                goto label_204;
            label_90:
                v10.moveCursorToLineEnd().selectMovement();
                goto label_204;
            label_93:
                v10.moveCursorToLineStart().selectMovement();
                goto label_204;
            label_96:
                v10.moveCursorNextByParagraph().selectMovement();
            label_204:
                v1 = true;
            }

        label_205:
            if((ComposeFoundationFlags.isTextFieldDpadNavigationEnabled) && (v0_1 == KeyCommand.UP || v0_1 == KeyCommand.DOWN || v0_1 == KeyCommand.LEFT_CHAR || v0_1 == KeyCommand.RIGHT_CHAR)) {
                v1_1 = TextRange.equals-impl0(v10.getInitialValue().getSelection-d9O1mEE(), v10.getSelection-d9O1mEE()) ^ 1;
            }

            if(!TextRange.equals-impl0(v10.getSelection-d9O1mEE(), v10.getInitialValue().getSelection-d9O1mEE())) {
                arg12.selectCharsIn-5zc-tL8(v10.getSelection-d9O1mEE());
            }

            if(v10.getWedgeAffinity() == null) {
                goto label_243;
            }

            WedgeAffinity v11 = v10.getWedgeAffinity();
            if(v11 == null) {
                goto label_243;
            }

            if(TextRange.getCollapsed-impl(arg12.getUntransformedText().getSelection-d9O1mEE())) {
                arg12.setSelectionWedgeAffinity(new SelectionWedgeAffinity(v11));
                return ((boolean)v1_1);
            }

            arg12.setSelectionWedgeAffinity(SelectionWedgeAffinity.copy$default(v10.getInitialWedgeAffinity(), null, v11, 1, null));
        }

    label_243:
        return ((boolean)v1_1);
    }

    private static final Unit processKeyDownEvent_q0GpTC0$lambda$0$0(SelectionMovementDeletionContext arg0) {
        arg0.moveCursorLeftByChar();
        return Unit.INSTANCE;
    }

    private static final Unit processKeyDownEvent_q0GpTC0$lambda$0$1(SelectionMovementDeletionContext arg0) {
        arg0.moveCursorRightByChar();
        return Unit.INSTANCE;
    }
}

