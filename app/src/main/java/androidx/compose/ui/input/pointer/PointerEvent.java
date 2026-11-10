package androidx.compose.ui.input.pointer;

import android.os.Build$VERSION;
import android.view.MotionEvent;
import androidx.collection.LongSparseArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B!\b\u0000\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB\u0017\b\u0016\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\tJ\u000F\u0010#\u001A\u00020\u001EH\u0002¢\u0006\u0004\b$\u0010\u0015J\f\u0010%\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003J\u001E\u0010&\u001A\u00020\u00002\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u000E\u001A\u0004\u0018\u00010\u000FR\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0016\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0013\u0010\u000E\u001A\u0004\u0018\u00010\u000F8F¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001A\u00020\u0013¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001A\u00020\u0017¢\u0006\n\n\u0002\u0010\u0019\u001A\u0004\b\u0018\u0010\u0015R\u0013\u0010\u001A\u001A\u00020\u001B¢\u0006\n\n\u0002\u0010\u0019\u001A\u0004\b\u001C\u0010\u0015R&\u0010\u001F\u001A\u00020\u001E2\u0006\u0010\u001D\u001A\u00020\u001E@@X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0019\u001A\u0004\b \u0010\u0015\"\u0004\b!\u0010\"¨\u0006\'"}, d2={"Landroidx/compose/ui/input/pointer/PointerEvent;", "", "changes", "", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "<init>", "(Ljava/util/List;Landroidx/compose/ui/input/pointer/InternalPointerEvent;)V", "(Ljava/util/List;)V", "getChanges", "()Ljava/util/List;", "getInternalPointerEvent$ui", "()Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "motionEvent", "Landroid/view/MotionEvent;", "getMotionEvent", "()Landroid/view/MotionEvent;", "classification", "", "getClassification", "()I", "buttons", "Landroidx/compose/ui/input/pointer/PointerButtons;", "getButtons-ry648PA", "I", "keyboardModifiers", "Landroidx/compose/ui/input/pointer/PointerKeyboardModifiers;", "getKeyboardModifiers-k7X9c1A", "value", "Landroidx/compose/ui/input/pointer/PointerEventType;", "type", "getType-7fucELk", "setType-EhbLWgg$ui", "(I)V", "calculatePointerEventType", "calculatePointerEventType-7fucELk", "component1", "copy", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PointerEvent {
    public static final int $stable = 8;
    private final int buttons;
    private final List changes;
    private final int classification;
    private final InternalPointerEvent internalPointerEvent;
    private final int keyboardModifiers;
    private int type;

    static {
    }

    public PointerEvent(List arg2, InternalPointerEvent arg3) {
        int v2_1;
        MotionEvent v2;
        super();
        this.changes = arg2;
        this.internalPointerEvent = arg3;
        int v0 = 0;
        if(Build$VERSION.SDK_INT >= 29) {
            v2 = this.getMotionEvent();
            if(v2 != null) {
                v2_1 = v2.getClassification();
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v2_1 = 0;
        }

        this.classification = v2_1;
        v2 = this.getMotionEvent();
        v2_1 = v2 != null ? v2.getButtonState() : 0;
        this.buttons = PointerButtons.constructor-impl(v2_1);
        v2 = this.getMotionEvent();
        if(v2 != null) {
            v0 = v2.getMetaState();
        }

        this.keyboardModifiers = PointerKeyboardModifiers.constructor-impl(v0);
        this.type = this.calculatePointerEventType-7fucELk();
    }

    public PointerEvent(List arg2) {
        this(arg2, null);
    }

    private final int calculatePointerEventType-7fucELk() {
        MotionEvent v0 = this.getMotionEvent();
        if(v0 != null) {
            int v4 = v0.getActionMasked();
            if(v4 != 0) {
                if(v4 != 1) {
                    if(v4 != 2) {
                        switch(v4) {
                            case 5: {
                                goto label_27;
                            }
                            case 6: {
                                goto label_24;
                            }
                            case 7: {
                                goto label_21;
                            }
                            case 8: {
                                goto label_18;
                            }
                            case 9: {
                                goto label_15;
                            }
                            case 10: {
                                goto label_12;
                            }
                        }

                        return PointerEventType.Companion.getUnknown-7fucELk();
                    label_18:
                        return PointerEventType.Companion.getScroll-7fucELk();
                    label_12:
                        return PointerEventType.Companion.getExit-7fucELk();
                    label_15:
                        return PointerEventType.Companion.getEnter-7fucELk();
                    }

                label_21:
                    return PointerEventType.Companion.getMove-7fucELk();
                }

            label_24:
                return PointerEventType.Companion.getRelease-7fucELk();
            }

        label_27:
            return PointerEventType.Companion.getPress-7fucELk();
        }

        List v4_1 = this.changes;
        int v0_1 = v4_1.size();
        int v1;
        for(v1 = 0; v1 < v0_1; ++v1) {
            Object v2 = v4_1.get(v1);
            if(PointerEventKt.changedToUpIgnoreConsumed(((PointerInputChange)v2))) {
                return PointerEventType.Companion.getRelease-7fucELk();
            }

            if(PointerEventKt.changedToDownIgnoreConsumed(((PointerInputChange)v2))) {
                return PointerEventType.Companion.getPress-7fucELk();
            }
        }

        return PointerEventType.Companion.getMove-7fucELk();
    }

    public final List component1() {
        return this.changes;
    }

    public final PointerEvent copy(List arg33, MotionEvent arg34) {
        PointerEvent v0 = this;
        List v1 = arg33;
        MotionEvent v2 = arg34;
        if(v2 == null) {
            return new PointerEvent(v1, null);
        }

        if(Intrinsics.areEqual(v2, v0.getMotionEvent())) {
            return new PointerEvent(v1, v0.internalPointerEvent);
        }

        LongSparseArray v3 = new LongSparseArray(v1.size());
        ArrayList v4 = new ArrayList(v1.size());
        int v5 = v1.size();
        int v7 = 0;
        while(v7 < v5) {
            Object v8 = v1.get(v7);
            v3.put(((PointerInputChange)v8).getId-J3iCeTQ(), v8);
            ArrayList v9 = v4;
            long v11 = ((PointerInputChange)v8).getId-J3iCeTQ();
            long v13 = ((PointerInputChange)v8).getUptimeMillis();
            long v15 = ((PointerInputChange)v8).getPosition-F1C5BW0();
            long v17 = ((PointerInputChange)v8).getPosition-F1C5BW0();
            boolean v19 = ((PointerInputChange)v8).getPressed();
            float v20 = ((PointerInputChange)v8).getPressure();
            int v21 = ((PointerInputChange)v8).getType-T8wyACA();
            InternalPointerEvent v6 = v0.internalPointerEvent;
            ArrayList v30 = v4;
            int v31 = v5;
            boolean v22 = v6 == null || !v6.activeHoverEvent-0FcD4WY(((PointerInputChange)v8).getId-J3iCeTQ()) ? false : true;
            ((Collection)v9).add(new PointerInputEventData(v11, v13, v15, v17, v19, v20, v21, v22, null, 0, 0, 0x700, null));
            ++v7;
            v4 = v30;
            v5 = v31;
        }

        return new PointerEvent(v1, new InternalPointerEvent(v3, new PointerInputEvent(v2.getEventTime(), v4, v2)));
    }

    public final int getButtons-ry648PA() {
        return this.buttons;
    }

    public final List getChanges() {
        return this.changes;
    }

    public final int getClassification() {
        return this.classification;
    }

    public final InternalPointerEvent getInternalPointerEvent$ui() {
        return this.internalPointerEvent;
    }

    public final int getKeyboardModifiers-k7X9c1A() {
        return this.keyboardModifiers;
    }

    public final MotionEvent getMotionEvent() {
        InternalPointerEvent v0 = this.internalPointerEvent;
        if(v0 != null) {
            return v0.getMotionEvent();
        }

        return null;
    }

    public final int getType-7fucELk() {
        return this.type;
    }

    public final void setType-EhbLWgg$ui(int arg1) {
        this.type = arg1;
    }
}

