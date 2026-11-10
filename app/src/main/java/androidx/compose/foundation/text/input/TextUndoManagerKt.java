package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.UndoManagerKt;
import androidx.compose.foundation.text.input.internal.undo.TextDeleteType;
import androidx.compose.foundation.text.input.internal.undo.TextEditType;
import androidx.compose.foundation.text.input.internal.undo.TextUndoOperation;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u001A\u0016\u0010\u0000\u001A\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0000\u001A.\u0010\u0003\u001A\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\fH\u0000\"\u0018\u0010\r\u001A\u00020\f*\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000E\"\u000E\u0010\u000F\u001A\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2={"merge", "Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;", "next", "recordChanges", "", "Landroidx/compose/foundation/text/input/TextUndoManager;", "pre", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "post", "changes", "Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "allowMerge", "", "isNewLineInsert", "(Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;)Z", "TEXT_UNDO_CAPACITY", "", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextUndoManagerKt {
    private static final int TEXT_UNDO_CAPACITY = 100;

    private static final boolean isNewLineInsert(TextUndoOperation arg2) {
        if(!Intrinsics.areEqual(arg2.getPostText(), "\n")) {
            if(Intrinsics.areEqual(arg2.getPostText(), "\r\n")) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public static final TextUndoOperation merge(TextUndoOperation arg16, TextUndoOperation arg17) {
        TextUndoOperation v1 = null;
        if(arg16.getCanMerge()) {
            if(!arg17.getCanMerge()) {
            }
            else if(arg17.getTimeInMillis() >= arg16.getTimeInMillis()) {
                if(arg17.getTimeInMillis() - arg16.getTimeInMillis() >= (((long)UndoManagerKt.getSNAPSHOTS_INTERVAL_MILLIS()))) {
                }
                else if(!TextUndoManagerKt.isNewLineInsert(arg16)) {
                    if(TextUndoManagerKt.isNewLineInsert(arg17)) {
                    }
                    else if(arg16.getTextEditType() != arg17.getTextEditType()) {
                        return v1;
                    }
                    else {
                        if(arg16.getTextEditType() == TextEditType.Insert && arg16.getIndex() + arg16.getPostText().length() == arg17.getIndex()) {
                            return new TextUndoOperation(arg16.getIndex(), "", arg16.getPostText() + arg17.getPostText(), arg16.getPreSelection-d9O1mEE(), arg17.getPostSelection-d9O1mEE(), arg16.getTimeInMillis(), false, 0x40, null);
                        }

                        if(arg16.getTextEditType() != TextEditType.Delete) {
                            return v1;
                        }

                        if(arg16.getDeletionType() != arg17.getDeletionType()) {
                            return v1;
                        }

                        if(arg16.getDeletionType() != TextDeleteType.Start && arg16.getDeletionType() != TextDeleteType.End) {
                            return v1;
                        }

                        if(arg16.getIndex() == arg17.getIndex() + arg17.getPreText().length()) {
                            return new TextUndoOperation(arg17.getIndex(), arg17.getPreText() + arg16.getPreText(), "", arg16.getPreSelection-d9O1mEE(), arg17.getPostSelection-d9O1mEE(), arg16.getTimeInMillis(), false, 0x40, null);
                        }

                        if(arg16.getIndex() != arg17.getIndex()) {
                            return v1;
                        }

                        return new TextUndoOperation(arg16.getIndex(), arg16.getPreText() + arg17.getPreText(), "", arg16.getPreSelection-d9O1mEE(), arg17.getPostSelection-d9O1mEE(), arg16.getTimeInMillis(), false, 0x40, null);
                    }
                }
            }
        }

        return v1;
    }

    public static final void recordChanges(TextUndoManager arg19, TextFieldCharSequence arg20, TextFieldCharSequence arg21, ChangeList arg22, boolean arg23) {
        TextUndoManager v0 = arg19;
        ChangeList v1 = arg22;
        if(v1.getChangeCount() > 1) {
            v0.record(new TextUndoOperation(0, arg20.toString(), arg21.toString(), arg20.getSelection-d9O1mEE(), arg21.getSelection-d9O1mEE(), 0, false, 0x20, null));
            return;
        }

        if(v1.getChangeCount() == 1) {
            long v3 = v1.getOriginalRange--jx7JFs(0);
            long v1_1 = v1.getRange--jx7JFs(0);
            if((TextRange.getCollapsed-impl(v3)) && (TextRange.getCollapsed-impl(v1_1))) {
                return;
            }

            v0.record(new TextUndoOperation(TextRange.getMin-impl(v3), TextRangeKt.substring-FDrldGo(arg20, v3), TextRangeKt.substring-FDrldGo(arg21, v1_1), arg20.getSelection-d9O1mEE(), arg21.getSelection-d9O1mEE(), 0, arg23, 0x20, null));
        }
    }

    public static void recordChanges$default(TextUndoManager arg0, TextFieldCharSequence arg1, TextFieldCharSequence arg2, ChangeList arg3, boolean arg4, int arg5, Object arg6) {
        TextUndoManagerKt.recordChanges(arg0, arg1, arg2, arg3, true);
    }
}

