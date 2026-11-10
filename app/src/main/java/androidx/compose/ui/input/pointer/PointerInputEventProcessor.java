package androidx.compose.ui.input.pointer;

import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\'\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00152\b\b\u0002\u0010\u0016\u001A\u00020\u000F¢\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0019\u001A\u00020\u001AJ\u0006\u0010\u001B\u001A\u00020\u001AR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001C"}, d2={"Landroidx/compose/ui/input/pointer/PointerInputEventProcessor;", "", "root", "Landroidx/compose/ui/node/LayoutNode;", "<init>", "(Landroidx/compose/ui/node/LayoutNode;)V", "getRoot", "()Landroidx/compose/ui/node/LayoutNode;", "hitPathTracker", "Landroidx/compose/ui/input/pointer/HitPathTracker;", "pointerInputChangeEventProducer", "Landroidx/compose/ui/input/pointer/PointerInputChangeEventProducer;", "hitResult", "Landroidx/compose/ui/node/HitTestResult;", "isProcessing", "", "process", "Landroidx/compose/ui/input/pointer/ProcessResult;", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerInputEvent;", "positionCalculator", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "isInBounds", "process-BIzXfog", "(Landroidx/compose/ui/input/pointer/PointerInputEvent;Landroidx/compose/ui/input/pointer/PositionCalculator;Z)I", "processCancel", "", "clearPreviouslyHitModifierNodes", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PointerInputEventProcessor {
    public static final int $stable = 8;
    private final HitPathTracker hitPathTracker;
    private final HitTestResult hitResult;
    private boolean isProcessing;
    private final PointerInputChangeEventProducer pointerInputChangeEventProducer;
    private final LayoutNode root;

    static {
    }

    public PointerInputEventProcessor(LayoutNode arg2) {
        super();
        this.root = arg2;
        this.hitPathTracker = new HitPathTracker(arg2.getCoordinates());
        this.pointerInputChangeEventProducer = new PointerInputChangeEventProducer();
        this.hitResult = new HitTestResult();
    }

    public final void clearPreviouslyHitModifierNodes() {
        this.hitPathTracker.clearPreviouslyHitModifierNodeCache();
    }

    public final LayoutNode getRoot() {
        return this.root;
    }

    public final int process-BIzXfog(PointerInputEvent arg17, PositionCalculator arg18, boolean arg19) {
        int v0_2;
        boolean v5_1;
        Object v7;
        PointerInputEventProcessor v1 = this;
        if(v1.isProcessing) {
            return PointerInputEventProcessorKt.ProcessResult(false, false, false);
        }

        boolean v0 = true;
        try {
            v1.isProcessing = true;
            InternalPointerEvent v3 = v1.pointerInputChangeEventProducer.produce(arg17, arg18);
            int v4 = v3.getChanges().size();
            int v5 = 0;
            while(true) {
                if(v5 < v4) {
                    Object v6 = v3.getChanges().valueAt(v5);
                    if(!((PointerInputChange)v6).getPressed()) {
                        if(((PointerInputChange)v6).getPreviousPressed()) {
                        }
                        else {
                            ++v5;
                            continue;
                        }
                    }

                    break;
                }
                else {
                    goto label_27;
                }
            }

            v4 = 0;
            goto label_28;
        label_27:
            v4 = 1;
        label_28:
            v5 = v3.getChanges().size();
            int v6_1;
            for(v6_1 = 0; v6_1 < v5; ++v6_1) {
                v7 = v3.getChanges().valueAt(v6_1);
                if(v4 != 0 || (PointerEventKt.changedToDownIgnoreConsumed(((PointerInputChange)v7)))) {
                    LayoutNode.hitTest-6fMxITs$ui$default(v1.root, ((PointerInputChange)v7).getPosition-F1C5BW0(), v1.hitResult, ((PointerInputChange)v7).getType-T8wyACA(), false, 8, null);
                    if(!v1.hitResult.isEmpty()) {
                        v1.hitPathTracker.addHitPath-QJqDSyo(((PointerInputChange)v7).getId-J3iCeTQ(), v1.hitResult, PointerEventKt.changedToDownIgnoreConsumed(((PointerInputChange)v7)));
                        v1.hitResult.clear();
                    }
                }
            }

            boolean v4_1 = v1.hitPathTracker.dispatchChanges(v3, arg19);
            if(!v3.getSuppressMovementConsumption()) {
                v5 = v3.getChanges().size();
                v6_1 = 0;
                while(true) {
                    if(v6_1 < v5) {
                        v7 = v3.getChanges().valueAt(v6_1);
                        if((PointerEventKt.positionChangedIgnoreConsumed(((PointerInputChange)v7))) && (((PointerInputChange)v7).isConsumed())) {
                            v5_1 = true;
                            break;
                        }

                        ++v6_1;
                        continue;
                    }
                    else {
                        goto label_62;
                    }
                }
            }
            else {
            label_62:
                v5_1 = false;
            }

            v6_1 = v3.getChanges().size();
            int v7_1 = 0;
            while(true) {
                if(v7_1 >= v6_1) {
                    break;
                }
                else if(v3.getChanges().valueAt(v7_1).isConsumed()) {
                }
                else {
                    ++v7_1;
                    continue;
                }

                goto label_90;
            }

            v0 = false;
        label_90:
            v0_2 = PointerInputEventProcessorKt.ProcessResult(v4_1, v5_1, v0);
        }
        catch(Throwable v0_1) {
            goto label_94;
        }

        v1.isProcessing = false;
        return v0_2;
    label_94:
        v1.isProcessing = false;
        throw v0_1;
    }

    public static int process-BIzXfog$default(PointerInputEventProcessor arg0, PointerInputEvent arg1, PositionCalculator arg2, boolean arg3, int arg4, Object arg5) {
        return arg0.process-BIzXfog(arg1, arg2, true);
    }

    public final void processCancel() {
        if(!this.isProcessing) {
            this.pointerInputChangeEventProducer.clear();
            this.hitPathTracker.processCancel();
        }
    }
}

