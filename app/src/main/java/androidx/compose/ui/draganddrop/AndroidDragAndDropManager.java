package androidx.compose.ui.draganddrop;

import android.view.DragEvent;
import android.view.View$OnDragListener;
import android.view.View;
import androidx.collection.ArraySet;
import androidx.compose.ui.Modifier;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$BooleanRef;

@Metadata(d1={"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002Be\u0012\\\u0010\u0003\u001AX\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012$\u0012\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000B¢\u0006\u0002\b\u000E¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000F\u0012\u0004\u0012\u00020\u00100\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u001F\u0010\u001E\u001A\u00020\r2\u0006\u0010\u001F\u001A\u00020\u00142\u0006\u0010 \u001A\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J\u0018\u0010$\u001A\u00020\u00102\u0006\u0010%\u001A\u00020&2\u0006\u0010\'\u001A\u00020(H\u0016J\u0010\u0010)\u001A\u00020\r2\u0006\u0010*\u001A\u00020\u0017H\u0016J\u0010\u0010+\u001A\u00020\u00102\u0006\u0010*\u001A\u00020\u0017H\u0016Rd\u0010\u0003\u001AX\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012$\u0012\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000B¢\u0006\u0002\b\u000E¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000F\u0012\u0004\u0012\u00020\u00100\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001A\u00020\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001BR\u0014\u0010\u001C\u001A\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001D¨\u0006,"}, d2={"Landroidx/compose/ui/draganddrop/AndroidDragAndDropManager;", "Landroid/view/View$OnDragListener;", "Landroidx/compose/ui/draganddrop/DragAndDropManager;", "startDrag", "Lkotlin/Function3;", "Landroidx/compose/ui/draganddrop/DragAndDropTransferData;", "Lkotlin/ParameterName;", "name", "transferData", "Landroidx/compose/ui/geometry/Size;", "decorationSize", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "drawDragDecoration", "", "<init>", "(Lkotlin/jvm/functions/Function3;)V", "rootDragAndDropNode", "Landroidx/compose/ui/draganddrop/DragAndDropNode;", "interestedTargets", "Landroidx/collection/ArraySet;", "Landroidx/compose/ui/draganddrop/DragAndDropTarget;", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "isRequestDragAndDropTransferRequired", "()Z", "requestDragAndDropTransfer", "node", "offset", "Landroidx/compose/ui/geometry/Offset;", "requestDragAndDropTransfer-Uv8p0NA", "(Landroidx/compose/ui/draganddrop/DragAndDropNode;J)V", "onDrag", "view", "Landroid/view/View;", "event", "Landroid/view/DragEvent;", "registerTargetInterest", "target", "isInterestedTarget", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidDragAndDropManager implements View$OnDragListener, DragAndDropManager {
    public static final int $stable = 8;
    private final ArraySet interestedTargets;
    private final Modifier modifier;
    private final DragAndDropNode rootDragAndDropNode;
    private final Function3 startDrag;

    static {
    }

    public AndroidDragAndDropManager(Function3 arg4) {
        super();
        this.startDrag = arg4;
        this.rootDragAndDropNode = new DragAndDropNode(null, null, 3, null);
        this.interestedTargets = new ArraySet(0, 1, null);
        this.modifier = new AndroidDragAndDropManager$modifier$1(this);
    }

    public static final DragAndDropNode access$getRootDragAndDropNode$p(AndroidDragAndDropManager arg0) {
        return arg0.rootDragAndDropNode;
    }

    public static final Function3 access$getStartDrag$p(AndroidDragAndDropManager arg0) {
        return arg0.startDrag;
    }

    public Modifier getModifier() {
        return this.modifier;
    }

    public boolean isInterestedTarget(DragAndDropTarget arg1) {
        return this.interestedTargets.contains(arg1);
    }

    public boolean isRequestDragAndDropTransferRequired() {
        return 1;
    }

    public boolean onDrag(View arg2, DragEvent arg3) {
        DragAndDropEvent v2 = new DragAndDropEvent(arg3);
        switch(arg3.getAction()) {
            case 1: {
                goto label_23;
            }
            case 2: {
                goto label_20;
            }
            case 3: {
                goto label_17;
            }
            case 4: {
                goto label_12;
            }
            case 5: {
                goto label_9;
            }
            case 6: {
                goto label_6;
            }
        }

        return 0;
    label_17:
        return this.rootDragAndDropNode.onDrop(v2);
    label_20:
        this.rootDragAndDropNode.onMoved(v2);
        return 0;
    label_6:
        this.rootDragAndDropNode.onExited(v2);
        return 0;
    label_23:
        boolean v3 = this.rootDragAndDropNode.acceptDragAndDropTransfer(v2);
        Iterator v1 = this.interestedTargets.iterator();
        while(v1.hasNext()) {
            v1.next().onStarted(v2);
        }

        return v3;
    label_9:
        this.rootDragAndDropNode.onEntered(v2);
        return 0;
    label_12:
        this.rootDragAndDropNode.onEnded(v2);
        this.interestedTargets.clear();
        return 0;
    }

    public void registerTargetInterest(DragAndDropTarget arg1) {
        this.interestedTargets.add(arg1);
    }

    public void requestDragAndDropTransfer-Uv8p0NA(DragAndDropNode arg3, long arg4) {
        BooleanRef v0 = new BooleanRef();
        arg3.startDragAndDropTransfer-d-4ec7I(new AndroidDragAndDropManager$requestDragAndDropTransfer$dragAndDropSourceScope$1(v0, this), arg4, new AndroidDragAndDropManager$requestDragAndDropTransfer$1$1(v0));
    }
}

