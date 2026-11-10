package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.foundation.text.selection.TextFieldPreparedSelection;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextPreparedSelectionState;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.DeleteSurroundingTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.EditProcessor;
import androidx.compose.ui.text.input.FinishComposingTextCommand;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;

@Metadata(d1={"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t\u0012\b\b\u0002\u0010\n\u001A\u00020\t\u0012\u0006\u0010\u000B\u001A\u00020\f\u0012\b\b\u0002\u0010\r\u001A\u00020\u000E\u0012\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001A\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001A\u00020\u0014\u0012\u0014\b\u0002\u0010\u0015\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0006\u0010\u0018\u001A\u00020\u0019¢\u0006\u0004\b\u001A\u0010\u001BJ\u0012\u0010,\u001A\u00020\u0017*\b\u0012\u0004\u0012\u00020.0-H\u0002J\f\u0010,\u001A\u00020\u0017*\u00020.H\u0002J\u0019\u0010/\u001A\u0004\u0018\u0001002\u0006\u00101\u001A\u000202H\u0002¢\u0006\u0004\b3\u00104J\u0015\u00105\u001A\u00020\t2\u0006\u00101\u001A\u000202¢\u0006\u0004\b6\u00107J!\u00108\u001A\u00020\u00172\u0017\u00109\u001A\u0013\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0002\b;H\u0002R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u001DR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u001FR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b \u0010!R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010#R\u0011\u0010\n\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b$\u0010#R\u0011\u0010\u000B\u001A\u00020\f¢\u0006\b\n\u0000\u001A\u0004\b%\u0010&R\u0011\u0010\r\u001A\u00020\u000E¢\u0006\b\n\u0000\u001A\u0004\b\'\u0010(R\u0013\u0010\u000F\u001A\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001A\u0004\b)\u0010*R\u000E\u0010\u0011\u001A\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0015\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001A\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010+¨\u0006<"}, d2={"Landroidx/compose/foundation/text/TextFieldKeyInput;", "", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "selectionManager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "editable", "", "singleLine", "preparedSelectionState", "Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "undoManager", "Landroidx/compose/foundation/text/UndoManager;", "keyCombiner", "Landroidx/compose/foundation/text/DeadKeyCombiner;", "keyMapping", "Landroidx/compose/foundation/text/KeyMapping;", "onValueChange", "Lkotlin/Function1;", "", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "<init>", "(Landroidx/compose/foundation/text/LegacyTextFieldState;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/ui/text/input/TextFieldValue;ZZLandroidx/compose/foundation/text/selection/TextPreparedSelectionState;Landroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/UndoManager;Landroidx/compose/foundation/text/DeadKeyCombiner;Landroidx/compose/foundation/text/KeyMapping;Lkotlin/jvm/functions/Function1;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getState", "()Landroidx/compose/foundation/text/LegacyTextFieldState;", "getSelectionManager", "()Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "getValue", "()Landroidx/compose/ui/text/input/TextFieldValue;", "getEditable", "()Z", "getSingleLine", "getPreparedSelectionState", "()Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "getOffsetMapping", "()Landroidx/compose/ui/text/input/OffsetMapping;", "getUndoManager", "()Landroidx/compose/foundation/text/UndoManager;", "I", "apply", "", "Landroidx/compose/ui/text/input/EditCommand;", "typedCommand", "Landroidx/compose/ui/text/input/CommitTextCommand;", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "typedCommand-ZmokQxo", "(Landroid/view/KeyEvent;)Landroidx/compose/ui/text/input/CommitTextCommand;", "process", "process-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "commandExecutionContext", "block", "Landroidx/compose/foundation/text/selection/TextFieldPreparedSelection;", "Lkotlin/ExtensionFunctionType;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextFieldKeyInput {
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
    private final boolean editable;
    private final int imeAction;
    private final DeadKeyCombiner keyCombiner;
    private final KeyMapping keyMapping;
    private final OffsetMapping offsetMapping;
    private final Function1 onValueChange;
    private final TextPreparedSelectionState preparedSelectionState;
    private final TextFieldSelectionManager selectionManager;
    private final boolean singleLine;
    private final LegacyTextFieldState state;
    private final UndoManager undoManager;
    private final TextFieldValue value;

    public static Unit $r8$lambda$-FWlRpEjHUQPmaYAdzOygwQC4Dk(TextFieldPreparedSelection arg0) {
        return TextFieldKeyInput.process_ZmokQxo$lambda$1$0(arg0);
    }

    public static EditCommand $r8$lambda$0pJee9-lblG8JQdnQWObs29hjXg(TextFieldPreparedSelection arg0) {
        return TextFieldKeyInput.process_ZmokQxo$lambda$1$4(arg0);
    }

    public static EditCommand $r8$lambda$Iq-LwNYBkgN8w4UD32hxw3apY-U(TextFieldPreparedSelection arg0) {
        return TextFieldKeyInput.process_ZmokQxo$lambda$1$5(arg0);
    }

    public static EditCommand $r8$lambda$Xgd-VQOY0-fjYNis5zXw5yxxRtA(TextFieldPreparedSelection arg0) {
        return TextFieldKeyInput.process_ZmokQxo$lambda$1$3(arg0);
    }

    public static EditCommand $r8$lambda$bFbDIJ_Ij62kRREXj6ejhwYJNkY(TextFieldPreparedSelection arg0) {
        return TextFieldKeyInput.process_ZmokQxo$lambda$1$2(arg0);
    }

    public static EditCommand $r8$lambda$kH4XBYzzqzhU839iIdO-qB2FIV8(TextFieldPreparedSelection arg0) {
        return TextFieldKeyInput.process_ZmokQxo$lambda$1$7(arg0);
    }

    public static EditCommand $r8$lambda$kr_D9bgj5sxV9Ab9lgtLTFvS7E4(TextFieldPreparedSelection arg0) {
        return TextFieldKeyInput.process_ZmokQxo$lambda$1$6(arg0);
    }

    public static Unit $r8$lambda$qZ8HT8aYSzXBV9RB8G6CHdE6yyY(TextFieldPreparedSelection arg0) {
        return TextFieldKeyInput.process_ZmokQxo$lambda$1$1(arg0);
    }

    static {
    }

    private TextFieldKeyInput(LegacyTextFieldState arg1, TextFieldSelectionManager arg2, TextFieldValue arg3, boolean arg4, boolean arg5, TextPreparedSelectionState arg6, OffsetMapping arg7, UndoManager arg8, DeadKeyCombiner arg9, KeyMapping arg10, Function1 arg11, int arg12) {
        super();
        this.state = arg1;
        this.selectionManager = arg2;
        this.value = arg3;
        this.editable = arg4;
        this.singleLine = arg5;
        this.preparedSelectionState = arg6;
        this.offsetMapping = arg7;
        this.undoManager = arg8;
        this.keyCombiner = arg9;
        this.keyMapping = arg10;
        this.onValueChange = arg11;
        this.imeAction = arg12;
    }

    public TextFieldKeyInput(LegacyTextFieldState arg18, TextFieldSelectionManager arg19, TextFieldValue arg20, boolean arg21, boolean arg22, TextPreparedSelectionState arg23, OffsetMapping arg24, UndoManager arg25, DeadKeyCombiner arg26, KeyMapping arg27, Function1 arg28, int arg29, int arg30, DefaultConstructorMarker arg31) {
        TextFieldKeyInput$$ExternalSyntheticLambda9 v14;
        int v0 = arg30;
        TextFieldValue v6 = (v0 & 4) != 0 ? new TextFieldValue(null, 0, null, 7, null) : arg20;
        boolean v7 = (v0 & 8) != 0 ? true : arg21;
        boolean v8 = (v0 & 16) != 0 ? false : arg22;
        OffsetMapping v10 = (v0 & 0x40) != 0 ? OffsetMapping.Companion.getIdentity() : arg24;
        UndoManager v11 = (v0 & 0x80) != 0 ? null : arg25;
        KeyMapping v13 = (v0 & 0x200) != 0 ? KeyMapping_androidKt.getPlatformDefaultKeyMapping() : arg27;
        if((v0 & 0x400) != 0) {
            v14 = new TextFieldKeyInput$$ExternalSyntheticLambda9();
        }
        else {
            Function1 v14_1 = arg28;
        }

        this(arg18, arg19, v6, v7, v8, arg23, v10, v11, arg26, v13, ((Function1)v14), arg29, null);
    }

    public TextFieldKeyInput(LegacyTextFieldState arg1, TextFieldSelectionManager arg2, TextFieldValue arg3, boolean arg4, boolean arg5, TextPreparedSelectionState arg6, OffsetMapping arg7, UndoManager arg8, DeadKeyCombiner arg9, KeyMapping arg10, Function1 arg11, int arg12, DefaultConstructorMarker arg13) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
    }

    static final Unit _init_$lambda$0(TextFieldValue arg0) {
        return Unit.INSTANCE;
    }

    private final void apply(EditCommand arg1) {
        this.apply(CollectionsKt.listOf(arg1));
    }

    private final void apply(List arg4) {
        EditProcessor v0 = this.state.getProcessor();
        arg4 = CollectionsKt.toMutableList(((Collection)arg4));
        arg4.add(0, new FinishComposingTextCommand());
        this.onValueChange.invoke(v0.apply(arg4));
    }

    private final void commandExecutionContext(Function1 arg6) {
        TextFieldPreparedSelection v0 = new TextFieldPreparedSelection(this.value, this.offsetMapping, this.state.getLayoutResult(), this.preparedSelectionState);
        arg6.invoke(v0);
        if(TextRange.equals-impl0(v0.getSelection-d9O1mEE(), this.value.getSelection-d9O1mEE())) {
            if(!Intrinsics.areEqual(v0.getAnnotatedString(), this.value.getAnnotatedString())) {
            }
            else {
                return;
            }
        }

        this.onValueChange.invoke(v0.getValue());
    }

    public final boolean getEditable() {
        return this.editable;
    }

    public final OffsetMapping getOffsetMapping() {
        return this.offsetMapping;
    }

    public final TextPreparedSelectionState getPreparedSelectionState() {
        return this.preparedSelectionState;
    }

    public final TextFieldSelectionManager getSelectionManager() {
        return this.selectionManager;
    }

    public final boolean getSingleLine() {
        return this.singleLine;
    }

    public final LegacyTextFieldState getState() {
        return this.state;
    }

    public final UndoManager getUndoManager() {
        return this.undoManager;
    }

    public final TextFieldValue getValue() {
        return this.value;
    }

    public final boolean process-ZmokQxo(KeyEvent arg5) {
        CommitTextCommand v0 = this.typedCommand-ZmokQxo(arg5);
        if(v0 != null) {
            if(this.editable) {
                this.apply(((EditCommand)v0));
                this.preparedSelectionState.resetCachedX();
                return 1;
            }

            return 0;
        }

        if(!KeyEventType.equals-impl0(KeyEvent_androidKt.getType-ZmokQxo(arg5), KeyEventType.Companion.getKeyDown-CS__XNY())) {
            return 0;
        }

        KeyCommand v5 = this.keyMapping.map-ZmokQxo(arg5);
        if(v5 != null && (!v5.getEditsText() || (this.editable))) {
            BooleanRef v0_1 = new BooleanRef();
            v0_1.element = true;
            this.commandExecutionContext(new TextFieldKeyInput$$ExternalSyntheticLambda0(v5, this, v0_1));
            UndoManager v4 = this.undoManager;
            if(v4 != null) {
                v4.forceNextSnapshot();
            }

            return v0_1.element;
        }

        return 0;
    }

    static final Unit process_ZmokQxo$lambda$1(KeyCommand arg2, TextFieldKeyInput arg3, BooleanRef arg4, TextFieldPreparedSelection arg5) {
        List v2;
        TextFieldValue v2_2;
        UndoManager v2_1;
        switch(WhenMappings.$EnumSwitchMapping$0[arg2.ordinal()]) {
            case 1: {
                arg3.selectionManager.copy$foundation(false);
                break;
            }
            case 2: {
                arg3.selectionManager.paste$foundation();
                break;
            }
            case 3: {
                arg3.selectionManager.cut$foundation();
                break;
            }
            case 4: {
                arg5.collapseLeftOr(new TextFieldKeyInput$$ExternalSyntheticLambda1());
                break;
            }
            case 5: {
                arg5.collapseRightOr(new TextFieldKeyInput$$ExternalSyntheticLambda2());
                break;
            }
            case 6: {
                arg5.moveCursorLeftByWord();
                break;
            }
            case 7: {
                arg5.moveCursorRightByWord();
                break;
            }
            case 8: {
                arg5.moveCursorPrevByParagraph();
                break;
            }
            case 9: {
                arg5.moveCursorNextByParagraph();
                break;
            }
            case 10: {
                arg5.moveCursorUpByLine();
                break;
            }
            case 11: {
                arg5.moveCursorDownByLine();
                break;
            }
            case 12: {
                arg5.moveCursorUpByPage();
                break;
            }
            case 13: {
                arg5.moveCursorDownByPage();
                break;
            }
            case 14: {
                arg5.moveCursorToLineStart();
                break;
            }
            case 15: {
                arg5.moveCursorToLineEnd();
                break;
            }
            case 16: {
                arg5.moveCursorToLineLeftSide();
                break;
            }
            case 17: {
                arg5.moveCursorToLineRightSide();
                break;
            }
            case 18: {
                arg5.moveCursorToHome();
                break;
            }
            case 19: {
                arg5.moveCursorToEnd();
                break;
            }
            case 20: {
                v2 = arg5.deleteIfSelectedOr(new TextFieldKeyInput$$ExternalSyntheticLambda3());
                if(v2 == null) {
                    goto label_196;
                }

                arg3.apply(v2);
                break;
            }
            case 21: {
                v2 = arg5.deleteIfSelectedOr(new TextFieldKeyInput$$ExternalSyntheticLambda4());
                if(v2 == null) {
                    goto label_196;
                }

                arg3.apply(v2);
                break;
            }
            case 22: {
                v2 = arg5.deleteIfSelectedOr(new TextFieldKeyInput$$ExternalSyntheticLambda5());
                if(v2 == null) {
                    goto label_196;
                }

                arg3.apply(v2);
                break;
            }
            case 23: {
                v2 = arg5.deleteIfSelectedOr(new TextFieldKeyInput$$ExternalSyntheticLambda6());
                if(v2 == null) {
                    goto label_196;
                }

                arg3.apply(v2);
                break;
            }
            case 24: {
                v2 = arg5.deleteIfSelectedOr(new TextFieldKeyInput$$ExternalSyntheticLambda7());
                if(v2 == null) {
                    goto label_196;
                }

                arg3.apply(v2);
                break;
            }
            case 25: {
                v2 = arg5.deleteIfSelectedOr(new TextFieldKeyInput$$ExternalSyntheticLambda8());
                if(v2 == null) {
                    goto label_196;
                }

                arg3.apply(v2);
                break;
            }
            case 26: {
                if(!arg3.singleLine) {
                    arg3.apply(new CommitTextCommand("\n", 1));
                    goto label_196;
                }

                arg4.element = arg3.state.getOnImeActionPerformedWithResult().invoke(ImeAction.box-impl(arg3.imeAction)).booleanValue();
                break;
            }
            case 27: {
                if(!arg3.singleLine) {
                    arg3.apply(new CommitTextCommand("\t", 1));
                    goto label_196;
                }

                arg4.element = false;
                break;
            }
            case 28: {
                arg5.selectAll();
                break;
            }
            case 29: {
                arg5.moveCursorLeft().selectMovement();
                break;
            }
            case 30: {
                arg5.moveCursorRight().selectMovement();
                break;
            }
            case 31: {
                arg5.moveCursorLeftByWord().selectMovement();
                break;
            }
            case 32: {
                arg5.moveCursorRightByWord().selectMovement();
                break;
            }
            case 33: {
                arg5.moveCursorPrevByParagraph().selectMovement();
                break;
            }
            case 34: {
                arg5.moveCursorNextByParagraph().selectMovement();
                break;
            }
            case 35: {
                arg5.moveCursorToLineStart().selectMovement();
                break;
            }
            case 36: {
                arg5.moveCursorToLineEnd().selectMovement();
                break;
            }
            case 37: {
                arg5.moveCursorToLineLeftSide().selectMovement();
                break;
            }
            case 38: {
                arg5.moveCursorToLineRightSide().selectMovement();
                break;
            }
            case 39: {
                arg5.moveCursorUpByLine().selectMovement();
                break;
            }
            case 40: {
                arg5.moveCursorDownByLine().selectMovement();
                break;
            }
            case 41: {
                arg5.moveCursorUpByPage().selectMovement();
                break;
            }
            case 42: {
                arg5.moveCursorDownByPage().selectMovement();
                break;
            }
            case 43: {
                arg5.moveCursorToHome().selectMovement();
                break;
            }
            case 44: {
                arg5.moveCursorToEnd().selectMovement();
                break;
            }
            case 45: {
                arg5.deselect();
                break;
            }
            case 46: {
                v2_1 = arg3.undoManager;
                if(v2_1 != null) {
                    v2_1.makeSnapshot(arg5.getValue());
                }

                v2_1 = arg3.undoManager;
                if(v2_1 == null) {
                    goto label_196;
                }

                v2_2 = v2_1.undo();
                if(v2_2 == null) {
                    goto label_196;
                }

                arg3.onValueChange.invoke(v2_2);
                break;
            }
            case 47: {
                v2_1 = arg3.undoManager;
                if(v2_1 == null) {
                    goto label_196;
                }

                v2_2 = v2_1.redo();
                if(v2_2 == null) {
                    goto label_196;
                }

                arg3.onValueChange.invoke(v2_2);
                break;
            }
            case 48: {
                KeyEventHelpers_androidKt.showCharacterPalette();
                break;
            }
            case 49: {
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }

    label_196:
        return Unit.INSTANCE;
    }

    private static final Unit process_ZmokQxo$lambda$1$0(TextFieldPreparedSelection arg0) {
        arg0.moveCursorLeft();
        return Unit.INSTANCE;
    }

    private static final Unit process_ZmokQxo$lambda$1$1(TextFieldPreparedSelection arg0) {
        arg0.moveCursorRight();
        return Unit.INSTANCE;
    }

    private static final EditCommand process_ZmokQxo$lambda$1$2(TextFieldPreparedSelection arg4) {
        int v0 = arg4.getPrecedingCodePointOrEmojiStartIndex();
        if(v0 == -1) {
            return null;
        }

        return new DeleteSurroundingTextCommand(TextRange.getEnd-impl(arg4.getSelection-d9O1mEE()) - v0, 0);
    }

    private static final EditCommand process_ZmokQxo$lambda$1$3(TextFieldPreparedSelection arg4) {
        int v0 = arg4.getNextCharacterIndex();
        if(v0 != -1) {
            return new DeleteSurroundingTextCommand(0, v0 - TextRange.getEnd-impl(arg4.getSelection-d9O1mEE()));
        }

        return null;
    }

    private static final EditCommand process_ZmokQxo$lambda$1$4(TextFieldPreparedSelection arg4) {
        EditCommand v1_1;
        Integer v0 = arg4.getPreviousWordOffset();
        if(v0 != null) {
            DeleteSurroundingTextCommand v1 = new DeleteSurroundingTextCommand(TextRange.getEnd-impl(arg4.getSelection-d9O1mEE()) - ((Number)v0).intValue(), 0);
        }
        else {
            v1_1 = null;
        }

        return v1_1;
    }

    private static final EditCommand process_ZmokQxo$lambda$1$5(TextFieldPreparedSelection arg4) {
        EditCommand v1_1;
        Integer v0 = arg4.getNextWordOffset();
        if(v0 != null) {
            DeleteSurroundingTextCommand v1 = new DeleteSurroundingTextCommand(0, ((Number)v0).intValue() - TextRange.getEnd-impl(arg4.getSelection-d9O1mEE()));
        }
        else {
            v1_1 = null;
        }

        return v1_1;
    }

    private static final EditCommand process_ZmokQxo$lambda$1$6(TextFieldPreparedSelection arg4) {
        EditCommand v1_1;
        Integer v0 = arg4.getLineStartByOffset();
        if(v0 != null) {
            DeleteSurroundingTextCommand v1 = new DeleteSurroundingTextCommand(TextRange.getEnd-impl(arg4.getSelection-d9O1mEE()) - ((Number)v0).intValue(), 0);
        }
        else {
            v1_1 = null;
        }

        return v1_1;
    }

    private static final EditCommand process_ZmokQxo$lambda$1$7(TextFieldPreparedSelection arg4) {
        EditCommand v1_1;
        Integer v0 = arg4.getLineEndByOffset();
        if(v0 != null) {
            DeleteSurroundingTextCommand v1 = new DeleteSurroundingTextCommand(0, ((Number)v0).intValue() - TextRange.getEnd-impl(arg4.getSelection-d9O1mEE()));
        }
        else {
            v1_1 = null;
        }

        return v1_1;
    }

    private final CommitTextCommand typedCommand-ZmokQxo(KeyEvent arg3) {
        CommitTextCommand v1 = null;
        if(!TextFieldKeyInput_androidKt.isTypedEvent-ZmokQxo(arg3)) {
            return v1;
        }

        Integer v2 = this.keyCombiner.consume-ZmokQxo(arg3);
        if(v2 != null) {
            return new CommitTextCommand(StringHelpers_jvmKt.appendCodePointX(new StringBuilder(), v2.intValue()).toString(), 1);
        }

        return v1;
    }
}

