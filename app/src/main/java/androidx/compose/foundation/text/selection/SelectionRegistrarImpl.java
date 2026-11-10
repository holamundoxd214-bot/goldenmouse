package androidx.compose.foundation.text.selection;

import androidx.collection.LongObjectMap;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b \b\u0001\u0018\u0000 f2\u00020\u0001:\u0001fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J\u0010\u0010N\u001A\u00020\u000F2\u0006\u0010O\u001A\u00020\u000FH\u0016J\u0010\u0010P\u001A\u00020 2\u0006\u0010O\u001A\u00020\u000FH\u0016J\b\u0010Q\u001A\u00020\u0003H\u0016J\u0014\u0010R\u001A\b\u0012\u0004\u0012\u00020\u000F0\u00112\u0006\u0010S\u001A\u00020\'J\u0010\u0010T\u001A\u00020 2\u0006\u0010U\u001A\u00020\u0003H\u0016J/\u0010V\u001A\u00020 2\u0006\u0010W\u001A\u00020\'2\u0006\u0010X\u001A\u00020(2\u0006\u0010Y\u001A\u00020)2\u0006\u0010Z\u001A\u00020\bH\u0016¢\u0006\u0004\b[\u0010\\J\u0018\u0010]\u001A\u00020 2\u0006\u0010U\u001A\u00020\u00032\u0006\u0010Z\u001A\u00020\bH\u0016J?\u0010^\u001A\u00020\b2\u0006\u0010W\u001A\u00020\'2\u0006\u0010_\u001A\u00020(2\u0006\u0010`\u001A\u00020(2\u0006\u0010a\u001A\u00020\b2\u0006\u0010Y\u001A\u00020)2\u0006\u0010Z\u001A\u00020\bH\u0016¢\u0006\u0004\bb\u0010cJ\b\u0010d\u001A\u00020 H\u0016J\u0010\u0010e\u001A\u00020 2\u0006\u0010U\u001A\u00020\u0003H\u0016R\u001A\u0010\u0007\u001A\u00020\bX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR\u0014\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u000F0\u00118@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u000F0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u000F0\u00178@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001A\u001A\u00060\u001Bj\u0002`\u001CX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u001DR(\u0010\u001E\u001A\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020 \u0018\u00010\u001FX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b!\u0010\"\"\u0004\b#\u0010$R:\u0010%\u001A\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\'\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020 \u0018\u00010&X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b*\u0010+\"\u0004\b,\u0010-R.\u0010.\u001A\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020 \u0018\u00010/X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b0\u00101\"\u0004\b2\u00103RF\u00104\u001A.\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\'\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\b\u0018\u000105X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010:\u001A\n\u0012\u0004\u0012\u00020 \u0018\u00010;X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b<\u0010=\"\u0004\b>\u0010?R(\u0010@\u001A\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020 \u0018\u00010\u001FX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bA\u0010\"\"\u0004\bB\u0010$R(\u0010C\u001A\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020 \u0018\u00010\u001FX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bD\u0010\"\"\u0004\bE\u0010$R7\u0010H\u001A\b\u0012\u0004\u0012\u00020G0\u00172\f\u0010F\u001A\b\u0012\u0004\u0012\u00020G0\u00178V@VX\u0096\u008E\u0002¢\u0006\u0012\n\u0004\bL\u0010M\u001A\u0004\bI\u0010\u0019\"\u0004\bJ\u0010K¨\u0006g"}, d2={"Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl;", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "initialIncrementId", "", "<init>", "(J)V", "()V", "sorted", "", "getSorted$foundation", "()Z", "setSorted$foundation", "(Z)V", "_selectables", "", "Landroidx/compose/foundation/text/selection/Selectable;", "selectables", "", "getSelectables$foundation", "()Ljava/util/List;", "_selectableMap", "Landroidx/collection/MutableLongObjectMap;", "selectableMap", "Landroidx/collection/LongObjectMap;", "getSelectableMap$foundation", "()Landroidx/collection/LongObjectMap;", "incrementId", "Ljava/util/concurrent/atomic/AtomicLong;", "Landroidx/compose/foundation/AtomicLong;", "Ljava/util/concurrent/atomic/AtomicLong;", "onPositionChangeCallback", "Lkotlin/Function1;", "", "getOnPositionChangeCallback$foundation", "()Lkotlin/jvm/functions/Function1;", "setOnPositionChangeCallback$foundation", "(Lkotlin/jvm/functions/Function1;)V", "onSelectionUpdateStartCallback", "Lkotlin/Function4;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "getOnSelectionUpdateStartCallback$foundation", "()Lkotlin/jvm/functions/Function4;", "setOnSelectionUpdateStartCallback$foundation", "(Lkotlin/jvm/functions/Function4;)V", "onSelectionUpdateSelectAll", "Lkotlin/Function2;", "getOnSelectionUpdateSelectAll$foundation", "()Lkotlin/jvm/functions/Function2;", "setOnSelectionUpdateSelectAll$foundation", "(Lkotlin/jvm/functions/Function2;)V", "onSelectionUpdateCallback", "Lkotlin/Function6;", "getOnSelectionUpdateCallback$foundation", "()Lkotlin/jvm/functions/Function6;", "setOnSelectionUpdateCallback$foundation", "(Lkotlin/jvm/functions/Function6;)V", "onSelectionUpdateEndCallback", "Lkotlin/Function0;", "getOnSelectionUpdateEndCallback$foundation", "()Lkotlin/jvm/functions/Function0;", "setOnSelectionUpdateEndCallback$foundation", "(Lkotlin/jvm/functions/Function0;)V", "onSelectableChangeCallback", "getOnSelectableChangeCallback$foundation", "setOnSelectableChangeCallback$foundation", "afterSelectableUnsubscribe", "getAfterSelectableUnsubscribe$foundation", "setAfterSelectableUnsubscribe$foundation", "<set-?>", "Landroidx/compose/foundation/text/selection/Selection;", "subselections", "getSubselections", "setSubselections", "(Landroidx/collection/LongObjectMap;)V", "subselections$delegate", "Landroidx/compose/runtime/MutableState;", "subscribe", "selectable", "unsubscribe", "nextSelectableId", "sort", "containerLayoutCoordinates", "notifyPositionChange", "selectableId", "notifySelectionUpdateStart", "layoutCoordinates", "startPosition", "adjustment", "isInTouchMode", "notifySelectionUpdateStart-ubNVwUQ", "(Landroidx/compose/ui/layout/LayoutCoordinates;JLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)V", "notifySelectionUpdateSelectAll", "notifySelectionUpdate", "newPosition", "previousPosition", "isStartHandle", "notifySelectionUpdate-njBpvok", "(Landroidx/compose/ui/layout/LayoutCoordinates;JJZLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)Z", "notifySelectionUpdateEnd", "notifySelectableChange", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SelectionRegistrarImpl implements SelectionRegistrar {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001D\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\t¨\u0006\n"}, d2={"Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl;", "", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Saver getSaver() {
            return SelectionRegistrarImpl.Saver;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final Saver Saver;
    private final MutableLongObjectMap _selectableMap;
    private final List _selectables;
    private Function1 afterSelectableUnsubscribe;
    private AtomicLong incrementId;
    private Function1 onPositionChangeCallback;
    private Function1 onSelectableChangeCallback;
    private Function6 onSelectionUpdateCallback;
    private Function0 onSelectionUpdateEndCallback;
    private Function2 onSelectionUpdateSelectAll;
    private Function4 onSelectionUpdateStartCallback;
    private boolean sorted;
    private final MutableState subselections$delegate;

    static {
        SelectionRegistrarImpl.Companion = new Companion(null);
        SelectionRegistrarImpl.$stable = 8;
        SelectionRegistrarImpl.Saver = SaverKt.Saver(new SelectionRegistrarImpl$$ExternalSyntheticLambda0(), new SelectionRegistrarImpl$$ExternalSyntheticLambda1());
    }

    public SelectionRegistrarImpl() {
        this(1);
    }

    private SelectionRegistrarImpl(long arg2) {
        super();
        this._selectables = new ArrayList();
        this._selectableMap = LongObjectMapKt.mutableLongObjectMapOf();
        this.incrementId = new AtomicLong(arg2);
        this.subselections$delegate = SnapshotStateKt.mutableStateOf$default(LongObjectMapKt.emptyLongObjectMap(), null, 2, null);
    }

    static final Long Saver$lambda$0(SaverScope arg0, SelectionRegistrarImpl arg1) {
        return Long.valueOf(arg1.incrementId.get());
    }

    static final SelectionRegistrarImpl Saver$lambda$1(long arg1) {
        return new SelectionRegistrarImpl(arg1);
    }

    public static final Saver access$getSaver$cp() {
        return SelectionRegistrarImpl.Saver;
    }

    public final Function1 getAfterSelectableUnsubscribe$foundation() {
        return this.afterSelectableUnsubscribe;
    }

    public final Function1 getOnPositionChangeCallback$foundation() {
        return this.onPositionChangeCallback;
    }

    public final Function1 getOnSelectableChangeCallback$foundation() {
        return this.onSelectableChangeCallback;
    }

    public final Function6 getOnSelectionUpdateCallback$foundation() {
        return this.onSelectionUpdateCallback;
    }

    public final Function0 getOnSelectionUpdateEndCallback$foundation() {
        return this.onSelectionUpdateEndCallback;
    }

    public final Function2 getOnSelectionUpdateSelectAll$foundation() {
        return this.onSelectionUpdateSelectAll;
    }

    public final Function4 getOnSelectionUpdateStartCallback$foundation() {
        return this.onSelectionUpdateStartCallback;
    }

    public final LongObjectMap getSelectableMap$foundation() {
        return this._selectableMap;
    }

    public final List getSelectables$foundation() {
        return this._selectables;
    }

    public final boolean getSorted$foundation() {
        return this.sorted;
    }

    public LongObjectMap getSubselections() {
        return this.subselections$delegate.getValue();
    }

    public long nextSelectableId() {
        long v0;
        for(v0 = this.incrementId.getAndIncrement(); v0 == 0; v0 = this.incrementId.getAndIncrement()) {
        }

        return v0;
    }

    public void notifyPositionChange(long arg2) {
        this.sorted = false;
        Function1 v1 = this.onPositionChangeCallback;
        if(v1 != null) {
            v1.invoke(Long.valueOf(arg2));
        }
    }

    public void notifySelectableChange(long arg1) {
        Function1 v0 = this.onSelectableChangeCallback;
        if(v0 != null) {
            v0.invoke(Long.valueOf(arg1));
        }
    }

    public boolean notifySelectionUpdate-njBpvok(LayoutCoordinates arg1, long arg2, long arg4, boolean arg6, SelectionAdjustment arg7, boolean arg8) {
        Function6 v0 = this.onSelectionUpdateCallback;
        if(v0 != null) {
            return v0.invoke(Boolean.valueOf(arg8), arg1, Offset.box-impl(arg2), Offset.box-impl(arg4), Boolean.valueOf(arg6), arg7).booleanValue();
        }

        return 1;
    }

    public void notifySelectionUpdateEnd() {
        Function0 v0 = this.onSelectionUpdateEndCallback;
        if(v0 != null) {
            v0.invoke();
        }
    }

    public void notifySelectionUpdateSelectAll(long arg1, boolean arg3) {
        Function2 v0 = this.onSelectionUpdateSelectAll;
        if(v0 != null) {
            v0.invoke(Boolean.valueOf(arg3), Long.valueOf(arg1));
        }
    }

    public void notifySelectionUpdateStart-ubNVwUQ(LayoutCoordinates arg1, long arg2, SelectionAdjustment arg4, boolean arg5) {
        Function4 v0 = this.onSelectionUpdateStartCallback;
        if(v0 != null) {
            v0.invoke(Boolean.valueOf(arg5), arg1, Offset.box-impl(arg2), arg4);
        }
    }

    public final void setAfterSelectableUnsubscribe$foundation(Function1 arg1) {
        this.afterSelectableUnsubscribe = arg1;
    }

    public final void setOnPositionChangeCallback$foundation(Function1 arg1) {
        this.onPositionChangeCallback = arg1;
    }

    public final void setOnSelectableChangeCallback$foundation(Function1 arg1) {
        this.onSelectableChangeCallback = arg1;
    }

    public final void setOnSelectionUpdateCallback$foundation(Function6 arg1) {
        this.onSelectionUpdateCallback = arg1;
    }

    public final void setOnSelectionUpdateEndCallback$foundation(Function0 arg1) {
        this.onSelectionUpdateEndCallback = arg1;
    }

    public final void setOnSelectionUpdateSelectAll$foundation(Function2 arg1) {
        this.onSelectionUpdateSelectAll = arg1;
    }

    public final void setOnSelectionUpdateStartCallback$foundation(Function4 arg1) {
        this.onSelectionUpdateStartCallback = arg1;
    }

    public final void setSorted$foundation(boolean arg1) {
        this.sorted = arg1;
    }

    public void setSubselections(LongObjectMap arg1) {
        this.subselections$delegate.setValue(arg1);
    }

    public final List sort(LayoutCoordinates arg3) {
        if(!this.sorted) {
            CollectionsKt.sortWith(this._selectables, new SelectionRegistrarImpl$$ExternalSyntheticLambda3(new SelectionRegistrarImpl$$ExternalSyntheticLambda2(arg3)));
            this.sorted = true;
        }

        return this.getSelectables$foundation();
    }

    static final int sort$lambda$0(LayoutCoordinates arg18, Selectable arg19, Selectable arg20) {
        long v0_1;
        long v8;
        long v6;
        LayoutCoordinates v0 = arg18;
        LayoutCoordinates v1 = arg19.getLayoutCoordinates();
        LayoutCoordinates v2 = arg20.getLayoutCoordinates();
        long v3 = 0xFFFFFFFFL;
        int v5 = 0x20;
        if(v1 != null) {
            v6 = v0.localPositionOf-R5De75A(v1, Offset.Companion.getZero-F1C5BW0());
            v8 = Offset.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v6 & v3))) + (((float)(((int)(v1.getSize-YbymL2g() & v3)))))))) & v3 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v6 >> v5))) + (((float)(((int)(v1.getSize-YbymL2g() >> v5)))))))) << v5);
        }
        else {
            v6 = Offset.Companion.getZero-F1C5BW0();
            v8 = Offset.Companion.getZero-F1C5BW0();
        }

        long v10 = v6;
        long v12 = v8;
        if(v2 != null) {
            v0_1 = v0.localPositionOf-R5De75A(v2, Offset.Companion.getZero-F1C5BW0());
            v6 = Offset.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v0_1 & v3))) + (((float)(((int)(v2.getSize-YbymL2g() & v3)))))))) & v3 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v0_1 >> v5))) + (((float)(((int)(v2.getSize-YbymL2g() >> v5)))))))) << v5);
        }
        else {
            v0_1 = Offset.Companion.getZero-F1C5BW0();
            v6 = Offset.Companion.getZero-F1C5BW0();
        }

        long v14 = v0_1;
        long v1_1 = v14;
        if(SelectionRegistrarImplKt.inARow-zwwh4xc(v10, v12, v14, v6)) {
            return ComparisonsKt.compareValues(Float.valueOf(Float.intBitsToFloat(((int)(v10 >> v5)))), Float.valueOf(Float.intBitsToFloat(((int)(v1_1 >> v5)))));
        }

        return ComparisonsKt.compareValues(Float.valueOf(Float.intBitsToFloat(((int)(v10 & v3)))), Float.valueOf(Float.intBitsToFloat(((int)(v1_1 & v3)))));
    }

    static final int sort$lambda$1(Function2 arg0, Object arg1, Object arg2) {
        return arg0.invoke(arg1, arg2).intValue();
    }

    public Selectable subscribe(Selectable arg5) {
        int v0 = Long.compare(arg5.getSelectableId(), 0) != 0 ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("The selectable contains an invalid id: " + arg5.getSelectableId());
        }

        if(this._selectableMap.containsKey(arg5.getSelectableId())) {
            InlineClassHelperKt.throwIllegalArgumentException("Another selectable with the id: " + arg5 + ".selectableId has already subscribed.");
        }

        this._selectableMap.set(arg5.getSelectableId(), arg5);
        this._selectables.add(arg5);
        this.sorted = false;
        return arg5;
    }

    public void unsubscribe(Selectable arg4) {
        if(!this._selectableMap.containsKey(arg4.getSelectableId())) {
        }
        else {
            this._selectables.remove(arg4);
            this._selectableMap.remove(arg4.getSelectableId());
            Function1 v3 = this.afterSelectableUnsubscribe;
            if(v3 != null) {
                v3.invoke(Long.valueOf(arg4.getSelectableId()));
            }
        }
    }
}

