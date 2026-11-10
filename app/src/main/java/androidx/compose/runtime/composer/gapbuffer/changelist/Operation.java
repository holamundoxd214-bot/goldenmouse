package androidx.compose.runtime.composer.gapbuffer.changelist;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.ControlledComposition;
import androidx.compose.runtime.GapComposerKt;
import androidx.compose.runtime.MovableContentState;
import androidx.compose.runtime.MovableContentStateReference;
import androidx.compose.runtime.OffsetApplier;
import androidx.compose.runtime.RecomposeScopeImpl$Companion;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.RecomposeScopeOwner;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.composer.RememberManager;
import androidx.compose.runtime.composer.gapbuffer.GapAnchor;
import androidx.compose.runtime.composer.gapbuffer.SlotTable;
import androidx.compose.runtime.composer.gapbuffer.SlotTableKt;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.internal.System_jvmKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1={"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001:&$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIB\u001D\b\u0004\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J0\u0010\u000E\u001A\u00020\u000F*\u00020\u00102\n\u0010\u0011\u001A\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018J\u0016\u0010\u0019\u001A\u0004\u0018\u00010\u001A*\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u0014H\u0014J2\u0010\u001B\u001A\u00020\u000F*\u00020\u00102\n\u0010\u0011\u001A\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H$J\u0014\u0010\u001C\u001A\u00020\u000B2\n\u0010\u001D\u001A\u00060\u0003j\u0002`\u001EH\u0016J\u001B\u0010\u001F\u001A\u00020\u000B2\n\u0010\u001D\u001A\u0006\u0012\u0002\b\u00030 H\u0016¢\u0006\u0004\b!\u0010\"J\b\u0010#\u001A\u00020\u000BH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\bR\u0011\u0010\n\u001A\u00020\u000B8F¢\u0006\u0006\u001A\u0004\b\f\u0010\r\u0082\u0001%JKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmn¨\u0006o"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "", "ints", "", "objects", "<init>", "(II)V", "getInts", "()I", "getObjects", "name", "", "getName", "()Ljava/lang/String;", "executeWithComposeStackTrace", "", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "getGroupAnchor", "Landroidx/compose/runtime/composer/gapbuffer/GapAnchor;", "execute", "intParamName", "parameter", "Landroidx/compose/runtime/composer/gapbuffer/changelist/IntParameter;", "objectParamName", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$ObjectParameter;", "objectParamName-PtL-UHM", "(I)Ljava/lang/String;", "toString", "ObjectParameter", "Ups", "Downs", "AdvanceSlotsBy", "SideEffect", "Remember", "RememberPausingScope", "StartResumingScope", "EndResumingScope", "AppendValue", "TrimParentValues", "UpdateValue", "UpdateAnchoredValue", "UpdateAuxData", "EnsureRootGroupStarted", "EnsureGroupStarted", "RemoveCurrentGroup", "MoveCurrentGroup", "EndCurrentGroup", "SkipToEndOfCurrentGroup", "EndCompositionScope", "UseCurrentNode", "UpdateNode", "RemoveNode", "MoveNode", "InsertSlots", "InsertSlotsWithFixups", "InsertNodeFixup", "PostInsertNodeFixup", "DeactivateCurrentGroup", "ResetSlots", "DetermineMovableContentNodeIndex", "CopyNodesToNewAnchorLocation", "CopySlotTableToAnchorLocation", "EndMovableContentPlacement", "ReleaseMovableGroupAtCurrent", "ApplyChangeList", "TestOperation", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$AdvanceSlotsBy;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$AppendValue;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$ApplyChangeList;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$CopyNodesToNewAnchorLocation;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$CopySlotTableToAnchorLocation;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$DeactivateCurrentGroup;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$DetermineMovableContentNodeIndex;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$Downs;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$EndCompositionScope;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$EndCurrentGroup;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$EndMovableContentPlacement;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$EndResumingScope;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$EnsureGroupStarted;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$EnsureRootGroupStarted;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$InsertNodeFixup;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$InsertSlots;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$InsertSlotsWithFixups;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$MoveCurrentGroup;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$MoveNode;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$PostInsertNodeFixup;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$ReleaseMovableGroupAtCurrent;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$Remember;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$RememberPausingScope;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$RemoveCurrentGroup;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$RemoveNode;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$ResetSlots;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$SideEffect;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$SkipToEndOfCurrentGroup;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$StartResumingScope;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$TestOperation;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$TrimParentValues;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$UpdateAnchoredValue;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$UpdateAuxData;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$UpdateNode;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$UpdateValue;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$Ups;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$UseCurrentNode;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class Operation {
    @Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\b\u001A\u00020\t2\n\u0010\n\u001A\u00060\u0005j\u0002`\u000BH\u0016J2\u0010\f\u001A\u00020\r*\u00020\u000E2\n\u0010\u000F\u001A\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016H\u0014R\u0012\u0010\u0004\u001A\u00020\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$AdvanceSlotsBy;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "<init>", "()V", "Distance", "", "getDistance", "()I", "intParamName", "", "parameter", "Landroidx/compose/runtime/composer/gapbuffer/changelist/IntParameter;", "execute", "", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class AdvanceSlotsBy extends Operation {
        public static final int $stable;
        public static final AdvanceSlotsBy INSTANCE;

        static {
            AdvanceSlotsBy.INSTANCE = new AdvanceSlotsBy();
        }

        private AdvanceSlotsBy() {
            super(1, 0, 2, null);
        }

        protected void execute(OperationArgContainer arg1, Applier arg2, SlotWriter arg3, RememberManager arg4, OperationErrorContext arg5) {
            arg3.advanceBy(arg1.getInt(0));
        }

        public final int getDistance() {
            return 0;
        }

        public String intParamName(int arg1) {
            if(arg1 == 0) {
                return "distance";
            }

            return super.intParamName(arg1);
        }
    }

    @Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001B\u0010\f\u001A\u00020\r2\n\u0010\u000E\u001A\u0006\u0012\u0002\b\u00030\u0005H\u0016¢\u0006\u0004\b\u000F\u0010\u0010J2\u0010\u0011\u001A\u00020\u0012*\u00020\u00132\n\u0010\u0014\u001A\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u00192\b\u0010\u001A\u001A\u0004\u0018\u00010\u001BH\u0014R\u0018\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0007\u0010\bR\u001A\u0010\t\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u000B\u0010\b¨\u0006\u001C"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$AppendValue;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "<init>", "()V", "Anchor", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$ObjectParameter;", "Landroidx/compose/runtime/composer/gapbuffer/GapAnchor;", "getAnchor-w8_IdGo", "()I", "Value", "", "getValue-w8_IdGo", "objectParamName", "", "parameter", "objectParamName-PtL-UHM", "(I)Ljava/lang/String;", "execute", "", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class AppendValue extends Operation {
        public static final int $stable;
        public static final AppendValue INSTANCE;

        static {
            AppendValue.INSTANCE = new AppendValue();
        }

        private AppendValue() {
            super(0, 2, 1, null);
        }

        protected void execute(OperationArgContainer arg1, Applier arg2, SlotWriter arg3, RememberManager arg4, OperationErrorContext arg5) {
            Object v0 = arg1.getObject-PtL-UHM(ObjectParameter.constructor-impl(0));
            Object v1 = arg1.getObject-PtL-UHM(ObjectParameter.constructor-impl(1));
            if((v1 instanceof RememberObserverHolder)) {
                arg4.remembering(v1);
            }

            arg3.appendSlot(((GapAnchor)v0), v1);
        }

        public final int getAnchor-w8_IdGo() {
            return ObjectParameter.constructor-impl(0);
        }

        public final int getValue-w8_IdGo() {
            return ObjectParameter.constructor-impl(1);
        }

        public String objectParamName-PtL-UHM(int arg2) {
            if(ObjectParameter.equals-impl0(arg2, ObjectParameter.constructor-impl(0))) {
                return "anchor";
            }

            if(ObjectParameter.equals-impl0(arg2, ObjectParameter.constructor-impl(1))) {
                return "value";
            }

            return super.objectParamName-PtL-UHM(arg2);
        }
    }

    @Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001B\u0010\f\u001A\u00020\r2\n\u0010\u000E\u001A\u0006\u0012\u0002\b\u00030\u0005H\u0016¢\u0006\u0004\b\u000F\u0010\u0010J2\u0010\u0011\u001A\u00020\u0012*\u00020\u00132\n\u0010\u0014\u001A\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u00192\b\u0010\u001A\u001A\u0004\u0018\u00010\u001BH\u0014R\u0018\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0007\u0010\bR\u001A\u0010\t\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u000B\u0010\b¨\u0006\u001C"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$ApplyChangeList;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "<init>", "()V", "Changes", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$ObjectParameter;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/ChangeList;", "getChanges-w8_IdGo", "()I", "EffectiveNodeIndex", "Landroidx/compose/runtime/internal/IntRef;", "getEffectiveNodeIndex-w8_IdGo", "objectParamName", "", "parameter", "objectParamName-PtL-UHM", "(I)Ljava/lang/String;", "execute", "", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ApplyChangeList extends Operation {
        public static final int $stable;
        public static final ApplyChangeList INSTANCE;

        static {
            ApplyChangeList.INSTANCE = new ApplyChangeList();
        }

        private ApplyChangeList() {
            super(0, 2, 1, null);
        }

        protected void execute(OperationArgContainer arg2, Applier arg3, SlotWriter arg4, RememberManager arg5, OperationErrorContext arg6) {
            OffsetApplier v3;
            Object v1 = arg2.getObject-PtL-UHM(ObjectParameter.constructor-impl(1));
            int v1_1 = v1 != null ? ((IntRef)v1).getElement() : 0;
            Object v2 = arg2.getObject-PtL-UHM(ObjectParameter.constructor-impl(0));
            if(v1_1 > 0) {
                v3 = new OffsetApplier(arg3, v1_1);
            }

            OperationErrorContext v1_2 = arg6 != null ? OperationKt.access$withCurrentStackTrace(arg6, arg4) : null;
            ((ChangeList)v2).executeAndFlushAllPendingChanges(((Applier)v3), arg4, arg5, v1_2);
        }

        public final int getChanges-w8_IdGo() {
            return ObjectParameter.constructor-impl(0);
        }

        public final int getEffectiveNodeIndex-w8_IdGo() {
            return ObjectParameter.constructor-impl(1);
        }

        public String objectParamName-PtL-UHM(int arg2) {
            if(ObjectParameter.equals-impl0(arg2, ObjectParameter.constructor-impl(0))) {
                return "changes";
            }

            if(ObjectParameter.equals-impl0(arg2, ObjectParameter.constructor-impl(1))) {
                return "effectiveNodeIndex";
            }

            return super.objectParamName-PtL-UHM(arg2);
        }
    }

    @Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001B\u0010\r\u001A\u00020\u000E2\n\u0010\u000F\u001A\u0006\u0012\u0002\b\u00030\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J2\u0010\u0012\u001A\u00020\u0013*\u00020\u00142\n\u0010\u0015\u001A\u0006\u0012\u0002\b\u00030\u00162\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001A2\b\u0010\u001B\u001A\u0004\u0018\u00010\u001CH\u0014R\u0018\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0007\u0010\bR \u0010\t\u001A\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\n0\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\f\u0010\b¨\u0006\u001D"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$CopyNodesToNewAnchorLocation;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "<init>", "()V", "EffectiveNodeIndex", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$ObjectParameter;", "Landroidx/compose/runtime/internal/IntRef;", "getEffectiveNodeIndex-w8_IdGo", "()I", "Nodes", "", "", "getNodes-w8_IdGo", "objectParamName", "", "parameter", "objectParamName-PtL-UHM", "(I)Ljava/lang/String;", "execute", "", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class CopyNodesToNewAnchorLocation extends Operation {
        public static final int $stable;
        public static final CopyNodesToNewAnchorLocation INSTANCE;

        static {
            CopyNodesToNewAnchorLocation.INSTANCE = new CopyNodesToNewAnchorLocation();
        }

        private CopyNodesToNewAnchorLocation() {
            super(0, 2, 1, null);
        }

        protected void execute(OperationArgContainer arg2, Applier arg3, SlotWriter arg4, RememberManager arg5, OperationErrorContext arg6) {
            int v1 = 0;
            int v4 = arg2.getObject-PtL-UHM(ObjectParameter.constructor-impl(0)).getElement();
            Object v2 = arg2.getObject-PtL-UHM(ObjectParameter.constructor-impl(1));
            int v5 = v2.size();
            while(v1 < v5) {
                Object v6 = ((List)v2).get(v1);
                Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
                int v0 = v4 + v1;
                arg3.insertBottomUp(v0, v6);
                arg3.insertTopDown(v0, v6);
                ++v1;
            }
        }

        public final int getEffectiveNodeIndex-w8_IdGo() {
            return ObjectParameter.constructor-impl(0);
        }

        public final int getNodes-w8_IdGo() {
            return ObjectParameter.constructor-impl(1);
        }

        public String objectParamName-PtL-UHM(int arg2) {
            if(ObjectParameter.equals-impl0(arg2, ObjectParameter.constructor-impl(0))) {
                return "effectiveNodeIndex";
            }

            if(ObjectParameter.equals-impl0(arg2, ObjectParameter.constructor-impl(1))) {
                return "nodes";
            }

            return super.objectParamName-PtL-UHM(arg2);
        }
    }

    @Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001B\u0010\u0011\u001A\u00020\u00122\n\u0010\u0013\u001A\u0006\u0012\u0002\b\u00030\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J2\u0010\u0016\u001A\u00020\u0017*\u00020\u00182\n\u0010\u0019\u001A\u0006\u0012\u0002\b\u00030\u001A2\u0006\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u001E2\b\u0010\u001F\u001A\u0004\u0018\u00010 H\u0014R\u001A\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001A\b\u0012\u0004\u0012\u00020\n0\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u000B\u0010\bR\u0018\u0010\f\u001A\b\u0012\u0004\u0012\u00020\r0\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u000E\u0010\bR\u0018\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\r0\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0010\u0010\b¨\u0006!"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$CopySlotTableToAnchorLocation;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "<init>", "()V", "ResolvedState", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$ObjectParameter;", "Landroidx/compose/runtime/MovableContentState;", "getResolvedState-w8_IdGo", "()I", "ParentCompositionContext", "Landroidx/compose/runtime/CompositionContext;", "getParentCompositionContext-w8_IdGo", "From", "Landroidx/compose/runtime/MovableContentStateReference;", "getFrom-w8_IdGo", "To", "getTo-w8_IdGo", "objectParamName", "", "parameter", "objectParamName-PtL-UHM", "(I)Ljava/lang/String;", "execute", "", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class CopySlotTableToAnchorLocation extends Operation {
        public static final int $stable;
        public static final CopySlotTableToAnchorLocation INSTANCE;

        static {
            CopySlotTableToAnchorLocation.INSTANCE = new CopySlotTableToAnchorLocation();
        }

        private CopySlotTableToAnchorLocation() {
            super(0, 4, 1, null);
        }

        protected void execute(OperationArgContainer arg3, Applier arg4, SlotWriter arg5, RememberManager arg6, OperationErrorContext arg7) {
            MovableContentState v3_1;
            int v2 = 2;
            Object v4 = arg3.getObject-PtL-UHM(ObjectParameter.constructor-impl(v2));
            Object v6 = arg3.getObject-PtL-UHM(ObjectParameter.constructor-impl(3));
            Object v0 = arg3.getObject-PtL-UHM(ObjectParameter.constructor-impl(1));
            Object v3 = arg3.getObject-PtL-UHM(ObjectParameter.constructor-impl(0));
            if(v3 == null) {
                v3_1 = ((CompositionContext)v0).movableContentStateResolve$runtime(((MovableContentStateReference)v4));
                if(v3_1 != null) {
                }
                else {
                    ComposerKt.composeRuntimeError("Could not resolve state for movable content");
                    throw new KotlinNothingValueException();
                }
            }

            List v2_1 = arg5.moveIntoGroupFrom(1, SlotTableKt.asGapBufferSlotTable(v3_1.getSlotStorage$runtime()), v2);
            Companion v3_2 = RecomposeScopeImpl.Companion;
            ControlledComposition v4_1 = ((MovableContentStateReference)v6).getComposition$runtime();
            Intrinsics.checkNotNull(v4_1, "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeOwner");
            v3_2.adoptAnchoredScopes$runtime(arg5, v2_1, ((RecomposeScopeOwner)v4_1));
        }

        public final int getFrom-w8_IdGo() {
            return ObjectParameter.constructor-impl(2);
        }

        public final int getParentCompositionContext-w8_IdGo() {
            return ObjectParameter.constructor-impl(1);
        }

        public final int getResolvedState-w8_IdGo() {
            return ObjectParameter.constructor-impl(0);
        }

        public final int getTo-w8_IdGo() {
            return ObjectParameter.constructor-impl(3);
        }

        public String objectParamName-PtL-UHM(int arg2) {
            if(ObjectParameter.equals-impl0(arg2, ObjectParameter.constructor-impl(0))) {
                return "resolvedState";
            }

            if(ObjectParameter.equals-impl0(arg2, ObjectParameter.constructor-impl(1))) {
                return "resolvedCompositionContext";
            }

            if(ObjectParameter.equals-impl0(arg2, ObjectParameter.constructor-impl(2))) {
                return "from";
            }

            if(ObjectParameter.equals-impl0(arg2, ObjectParameter.constructor-impl(3))) {
                return "to";
            }

            return super.objectParamName-PtL-UHM(arg2);
        }
    }

    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001A\u00020\u0005*\u00020\u00062\n\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u000EH\u0014¨\u0006\u000F"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$DeactivateCurrentGroup;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "<init>", "()V", "execute", "", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class DeactivateCurrentGroup extends Operation {
        public static final int $stable;
        public static final DeactivateCurrentGroup INSTANCE;

        static {
            DeactivateCurrentGroup.INSTANCE = new DeactivateCurrentGroup();
        }

        private DeactivateCurrentGroup() {
            super(0, 0, 3, null);
        }

        protected void execute(OperationArgContainer arg1, Applier arg2, SlotWriter arg3, RememberManager arg4, OperationErrorContext arg5) {
            GapComposerKt.deactivateCurrentGroup(arg3, arg4);
        }
    }

    @Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001B\u0010\f\u001A\u00020\r2\n\u0010\u000E\u001A\u0006\u0012\u0002\b\u00030\u0005H\u0016¢\u0006\u0004\b\u000F\u0010\u0010J2\u0010\u0011\u001A\u00020\u0012*\u00020\u00132\n\u0010\u0014\u001A\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u00192\b\u0010\u001A\u001A\u0004\u0018\u00010\u001BH\u0014R\u0018\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001A\b\u0012\u0004\u0012\u00020\n0\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u000B\u0010\b¨\u0006\u001C"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$DetermineMovableContentNodeIndex;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "<init>", "()V", "EffectiveNodeIndexOut", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$ObjectParameter;", "Landroidx/compose/runtime/internal/IntRef;", "getEffectiveNodeIndexOut-w8_IdGo", "()I", "Anchor", "Landroidx/compose/runtime/composer/gapbuffer/GapAnchor;", "getAnchor-w8_IdGo", "objectParamName", "", "parameter", "objectParamName-PtL-UHM", "(I)Ljava/lang/String;", "execute", "", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class DetermineMovableContentNodeIndex extends Operation {
        public static final int $stable;
        public static final DetermineMovableContentNodeIndex INSTANCE;

        static {
            DetermineMovableContentNodeIndex.INSTANCE = new DetermineMovableContentNodeIndex();
        }

        private DetermineMovableContentNodeIndex() {
            super(0, 2, 1, null);
        }

        protected void execute(OperationArgContainer arg1, Applier arg2, SlotWriter arg3, RememberManager arg4, OperationErrorContext arg5) {
            Object v0 = arg1.getObject-PtL-UHM(ObjectParameter.constructor-impl(0));
            Object v1 = arg1.getObject-PtL-UHM(ObjectParameter.constructor-impl(1));
            Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            ((IntRef)v0).setElement(OperationKt.access$positionToInsert(arg3, ((GapAnchor)v1), arg2));
        }

        public final int getAnchor-w8_IdGo() {
            return ObjectParameter.constructor-impl(1);
        }

        public final int getEffectiveNodeIndexOut-w8_IdGo() {
            return ObjectParameter.constructor-impl(0);
        }

        public String objectParamName-PtL-UHM(int arg2) {
            if(ObjectParameter.equals-impl0(arg2, ObjectParameter.constructor-impl(0))) {
                return "effectiveNodeIndexOut";
            }

            if(ObjectParameter.equals-impl0(arg2, ObjectParameter.constructor-impl(1))) {
                return "anchor";
            }

            return super.objectParamName-PtL-UHM(arg2);
        }
    }

    @Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001B\u0010\n\u001A\u00020\u000B2\n\u0010\f\u001A\u0006\u0012\u0002\b\u00030\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000EJ2\u0010\u000F\u001A\u00020\u0010*\u00020\u00112\n\u0010\u0012\u001A\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00172\b\u0010\u0018\u001A\u0004\u0018\u00010\u0019H\u0014R \u0010\u0004\u001A\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\u001A"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$Downs;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "<init>", "()V", "Nodes", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$ObjectParameter;", "", "", "getNodes-w8_IdGo", "()I", "objectParamName", "", "parameter", "objectParamName-PtL-UHM", "(I)Ljava/lang/String;", "execute", "", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Downs extends Operation {
        public static final int $stable;
        public static final Downs INSTANCE;

        static {
            Downs.INSTANCE = new Downs();
        }

        private Downs() {
            super(0, 1, 1, null);
        }

        protected void execute(OperationArgContainer arg1, Applier arg2, SlotWriter arg3, RememberManager arg4, OperationErrorContext arg5) {
            Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            int v0 = 0;
            Object v1 = arg1.getObject-PtL-UHM(ObjectParameter.constructor-impl(0));
            int v3 = v1.length;
            while(v0 < v3) {
                arg2.down(v1[v0]);
                ++v0;
            }
        }

        public final int getNodes-w8_IdGo() {
            return ObjectParameter.constructor-impl(0);
        }

        public String objectParamName-PtL-UHM(int arg2) {
            if(ObjectParameter.equals-impl0(arg2, ObjectParameter.constructor-impl(0))) {
                return "nodes";
            }

            return super.objectParamName-PtL-UHM(arg2);
        }
    }

    @Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001B\u0010\r\u001A\u00020\u000E2\n\u0010\u000F\u001A\u0006\u0012\u0002\b\u00030\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J2\u0010\u0012\u001A\u00020\b*\u00020\u00132\n\u0010\u0014\u001A\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u00192\b\u0010\u001A\u001A\u0004\u0018\u00010\u001BH\u0014R$\u0010\u0004\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\t\u0010\nR\u0018\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00070\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\f\u0010\n¨\u0006\u001C"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$EndCompositionScope;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "<init>", "()V", "Action", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$ObjectParameter;", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composition;", "", "getAction-w8_IdGo", "()I", "Composition", "getComposition-w8_IdGo", "objectParamName", "", "parameter", "objectParamName-PtL-UHM", "(I)Ljava/lang/String;", "execute", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class EndCompositionScope extends Operation {
        public static final int $stable;
        public static final EndCompositionScope INSTANCE;

        static {
            EndCompositionScope.INSTANCE = new EndCompositionScope();
        }

        private EndCompositionScope() {
            super(0, 2, 1, null);
        }

        protected void execute(OperationArgContainer arg1, Applier arg2, SlotWriter arg3, RememberManager arg4, OperationErrorContext arg5) {
            arg1.getObject-PtL-UHM(ObjectParameter.constructor-impl(0)).invoke(arg1.getObject-PtL-UHM(ObjectParameter.constructor-impl(1)));
        }

        public final int getAction-w8_IdGo() {
            return ObjectParameter.constructor-impl(0);
        }

        public final int getComposition-w8_IdGo() {
            return ObjectParameter.constructor-impl(1);
        }

        public String objectParamName-PtL-UHM(int arg2) {
            if(ObjectParameter.equals-impl0(arg2, ObjectParameter.constructor-impl(0))) {
                return "anchor";
            }

            if(ObjectParameter.equals-impl0(arg2, ObjectParameter.constructor-impl(1))) {
                return "composition";
            }

            return super.objectParamName-PtL-UHM(arg2);
        }
    }

    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001A\u00020\u0005*\u00020\u00062\n\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u000EH\u0014¨\u0006\u000F"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$EndCurrentGroup;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "<init>", "()V", "execute", "", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class EndCurrentGroup extends Operation {
        public static final int $stable;
        public static final EndCurrentGroup INSTANCE;

        static {
            EndCurrentGroup.INSTANCE = new EndCurrentGroup();
        }

        private EndCurrentGroup() {
            super(0, 0, 3, null);
        }

        protected void execute(OperationArgContainer arg1, Applier arg2, SlotWriter arg3, RememberManager arg4, OperationErrorContext arg5) {
            arg3.endGroup();
        }
    }

    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001A\u00020\u0005*\u00020\u00062\n\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u000EH\u0014¨\u0006\u000F"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$EndMovableContentPlacement;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "<init>", "()V", "execute", "", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class EndMovableContentPlacement extends Operation {
        public static final int $stable;
        public static final EndMovableContentPlacement INSTANCE;

        static {
            EndMovableContentPlacement.INSTANCE = new EndMovableContentPlacement();
        }

        private EndMovableContentPlacement() {
            super(0, 0, 3, null);
        }

        protected void execute(OperationArgContainer arg1, Applier arg2, SlotWriter arg3, RememberManager arg4, OperationErrorContext arg5) {
            Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            OperationKt.access$positionToParentOf(arg3, arg2, 0);
            arg3.endGroup();
        }
    }

    @Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001B\u0010\t\u001A\u00020\n2\n\u0010\u000B\u001A\u0006\u0012\u0002\b\u00030\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ2\u0010\u000E\u001A\u00020\u000F*\u00020\u00102\n\u0010\u0011\u001A\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0014R\u0018\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$EndResumingScope;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "<init>", "()V", "Scope", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$ObjectParameter;", "Landroidx/compose/runtime/RecomposeScopeImpl;", "getScope-w8_IdGo", "()I", "objectParamName", "", "parameter", "objectParamName-PtL-UHM", "(I)Ljava/lang/String;", "execute", "", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class EndResumingScope extends Operation {
        public static final int $stable;
        public static final EndResumingScope INSTANCE;

        static {
            EndResumingScope.INSTANCE = new EndResumingScope();
        }

        private EndResumingScope() {
            super(0, 1, 1, null);
        }

        protected void execute(OperationArgContainer arg1, Applier arg2, SlotWriter arg3, RememberManager arg4, OperationErrorContext arg5) {
            arg4.endResumingScope(arg1.getObject-PtL-UHM(ObjectParameter.constructor-impl(0)));
        }

        public final int getScope-w8_IdGo() {
            return ObjectParameter.constructor-impl(0);
        }

        public String objectParamName-PtL-UHM(int arg2) {
            if(ObjectParameter.equals-impl0(arg2, ObjectParameter.constructor-impl(0))) {
                return "scope";
            }

            return super.objectParamName-PtL-UHM(arg2);
        }
    }

    @Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001B\u0010\t\u001A\u00020\n2\n\u0010\u000B\u001A\u0006\u0012\u0002\b\u00030\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ2\u0010\u000E\u001A\u00020\u000F*\u00020\u00102\n\u0010\u0011\u001A\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0014R\u0018\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$EnsureGroupStarted;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "<init>", "()V", "Anchor", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$ObjectParameter;", "Landroidx/compose/runtime/composer/gapbuffer/GapAnchor;", "getAnchor-w8_IdGo", "()I", "objectParamName", "", "parameter", "objectParamName-PtL-UHM", "(I)Ljava/lang/String;", "execute", "", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class EnsureGroupStarted extends Operation {
        public static final int $stable;
        public static final EnsureGroupStarted INSTANCE;

        static {
            EnsureGroupStarted.INSTANCE = new EnsureGroupStarted();
        }

        private EnsureGroupStarted() {
            super(0, 1, 1, null);
        }

        protected void execute(OperationArgContainer arg1, Applier arg2, SlotWriter arg3, RememberManager arg4, OperationErrorContext arg5) {
            arg3.ensureStarted(arg1.getObject-PtL-UHM(ObjectParameter.constructor-impl(0)));
        }

        public final int getAnchor-w8_IdGo() {
            return ObjectParameter.constructor-impl(0);
        }

        public String objectParamName-PtL-UHM(int arg2) {
            if(ObjectParameter.equals-impl0(arg2, ObjectParameter.constructor-impl(0))) {
                return "anchor";
            }

            return super.objectParamName-PtL-UHM(arg2);
        }
    }

    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001A\u00020\u0005*\u00020\u00062\n\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u000EH\u0014¨\u0006\u000F"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$EnsureRootGroupStarted;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "<init>", "()V", "execute", "", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class EnsureRootGroupStarted extends Operation {
        public static final int $stable;
        public static final EnsureRootGroupStarted INSTANCE;

        static {
            EnsureRootGroupStarted.INSTANCE = new EnsureRootGroupStarted();
        }

        private EnsureRootGroupStarted() {
            super(0, 0, 3, null);
        }

        protected void execute(OperationArgContainer arg1, Applier arg2, SlotWriter arg3, RememberManager arg4, OperationErrorContext arg5) {
            arg3.ensureStarted(0);
        }
    }

    @Metadata(d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0010\u001A\u00020\u00112\n\u0010\u0012\u001A\u00060\u000Bj\u0002`\u0013H\u0016J\u001B\u0010\u0014\u001A\u00020\u00112\n\u0010\u0012\u001A\u0006\u0012\u0002\b\u00030\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0017\u001A\u0004\u0018\u00010\u000E*\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001AH\u0014J2\u0010\u001B\u001A\u00020\u001C*\u00020\u00182\n\u0010\u001D\u001A\u0006\u0012\u0002\b\u00030\u001E2\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001F\u001A\u00020 2\b\u0010!\u001A\u0004\u0018\u00010\"H\u0014R \u0010\u0004\u001A\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\u0012\u0010\n\u001A\u00020\u000B8Æ\u0002¢\u0006\u0006\u001A\u0004\b\f\u0010\tR\u0018\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000E0\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u000F\u0010\t¨\u0006#"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$InsertNodeFixup;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "<init>", "()V", "Factory", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$ObjectParameter;", "Lkotlin/Function0;", "", "getFactory-w8_IdGo", "()I", "InsertIndex", "", "getInsertIndex", "GroupAnchor", "Landroidx/compose/runtime/composer/gapbuffer/GapAnchor;", "getGroupAnchor-w8_IdGo", "intParamName", "", "parameter", "Landroidx/compose/runtime/composer/gapbuffer/changelist/IntParameter;", "objectParamName", "objectParamName-PtL-UHM", "(I)Ljava/lang/String;", "getGroupAnchor", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "execute", "", "applier", "Landroidx/compose/runtime/Applier;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class InsertNodeFixup extends Operation {
        public static final int $stable;
        public static final InsertNodeFixup INSTANCE;

        static {
            InsertNodeFixup.INSTANCE = new InsertNodeFixup();
        }

        private InsertNodeFixup() {
            super(1, 2, null);
        }

        protected void execute(OperationArgContainer arg1, Applier arg2, SlotWriter arg3, RememberManager arg4, OperationErrorContext arg5) {
            Object v4 = arg1.getObject-PtL-UHM(ObjectParameter.constructor-impl(0)).invoke();
            Object v5 = arg1.getObject-PtL-UHM(ObjectParameter.constructor-impl(1));
            int v0 = arg1.getInt(0);
            Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            arg3.updateNode(((GapAnchor)v5), v4);
            arg2.insertTopDown(v0, v4);
            arg2.down(v4);
        }

        public final int getFactory-w8_IdGo() {
            return ObjectParameter.constructor-impl(0);
        }

        protected GapAnchor getGroupAnchor(OperationArgContainer arg1, SlotWriter arg2) {
            return arg1.getObject-PtL-UHM(ObjectParameter.constructor-impl(1));
        }

        public final int getGroupAnchor-w8_IdGo() {
            return ObjectParameter.constructor-impl(1);
        }

        public final int getInsertIndex() {
            return 0;
        }

        public String intParamName(int arg1) {
            if(arg1 == 0) {
                return "insertIndex";
            }

            return super.intParamName(arg1);
        }

        public String objectParamName-PtL-UHM(int arg2) {
            if(ObjectParameter.equals-impl0(arg2, ObjectParameter.constructor-impl(0))) {
                return "factory";
            }

            if(ObjectParameter.equals-impl0(arg2, ObjectParameter.constructor-impl(1))) {
                return "groupAnchor";
            }

            return super.objectParamName-PtL-UHM(arg2);
        }
    }

    @Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001B\u0010\f\u001A\u00020\r2\n\u0010\u000E\u001A\u0006\u0012\u0002\b\u00030\u0005H\u0016¢\u0006\u0004\b\u000F\u0010\u0010J2\u0010\u0011\u001A\u00020\u0012*\u00020\u00132\n\u0010\u0014\u001A\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u00192\b\u0010\u001A\u001A\u0004\u0018\u00010\u001BH\u0014R\u0018\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001A\b\u0012\u0004\u0012\u00020\n0\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u000B\u0010\b¨\u0006\u001C"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$InsertSlots;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "<init>", "()V", "Anchor", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$ObjectParameter;", "Landroidx/compose/runtime/composer/gapbuffer/GapAnchor;", "getAnchor-w8_IdGo", "()I", "FromSlotTable", "Landroidx/compose/runtime/composer/gapbuffer/SlotTable;", "getFromSlotTable-w8_IdGo", "objectParamName", "", "parameter", "objectParamName-PtL-UHM", "(I)Ljava/lang/String;", "execute", "", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class InsertSlots extends Operation {
        public static final int $stable;
        public static final InsertSlots INSTANCE;

        static {
            InsertSlots.INSTANCE = new InsertSlots();
        }

        private InsertSlots() {
            super(0, 2, 1, null);
        }

        protected void execute(OperationArgContainer arg1, Applier arg2, SlotWriter arg3, RememberManager arg4, OperationErrorContext arg5) {
            Object v0 = arg1.getObject-PtL-UHM(ObjectParameter.constructor-impl(1));
            Object v1 = arg1.getObject-PtL-UHM(ObjectParameter.constructor-impl(0));
            arg3.beginInsert();
            arg3.moveFrom(((SlotTable)v0), ((GapAnchor)v1).toIndexFor(((SlotTable)v0)), false);
            arg3.endInsert();
        }

        public final int getAnchor-w8_IdGo() {
            return ObjectParameter.constructor-impl(0);
        }

        public final int getFromSlotTable-w8_IdGo() {
            return ObjectParameter.constructor-impl(1);
        }

        public String objectParamName-PtL-UHM(int arg2) {
            if(ObjectParameter.equals-impl0(arg2, ObjectParameter.constructor-impl(0))) {
                return "anchor";
            }

            if(ObjectParameter.equals-impl0(arg2, ObjectParameter.constructor-impl(1))) {
                return "from";
            }

            return super.objectParamName-PtL-UHM(arg2);
        }
    }

    @Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001B\u0010\u000F\u001A\u00020\u00102\n\u0010\u0011\u001A\u0006\u0012\u0002\b\u00030\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J2\u0010\u0014\u001A\u00020\u0015*\u00020\u00162\n\u0010\u0017\u001A\u0006\u0012\u0002\b\u00030\u00182\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u001C2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001EH\u0014R\u0018\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001A\b\u0012\u0004\u0012\u00020\n0\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u000B\u0010\bR\u0018\u0010\f\u001A\b\u0012\u0004\u0012\u00020\r0\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u000E\u0010\b¨\u0006\u001F"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$InsertSlotsWithFixups;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "<init>", "()V", "Anchor", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$ObjectParameter;", "Landroidx/compose/runtime/composer/gapbuffer/GapAnchor;", "getAnchor-w8_IdGo", "()I", "FromSlotTable", "Landroidx/compose/runtime/composer/gapbuffer/SlotTable;", "getFromSlotTable-w8_IdGo", "Fixups", "Landroidx/compose/runtime/composer/gapbuffer/changelist/FixupList;", "getFixups-w8_IdGo", "objectParamName", "", "parameter", "objectParamName-PtL-UHM", "(I)Ljava/lang/String;", "execute", "", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class InsertSlotsWithFixups extends Operation {
        public static final int $stable;
        public static final InsertSlotsWithFixups INSTANCE;

        static {
            InsertSlotsWithFixups.INSTANCE = new InsertSlotsWithFixups();
        }

        private InsertSlotsWithFixups() {
            super(0, 3, 1, null);
        }

        protected void execute(OperationArgContainer arg5, Applier arg6, SlotWriter arg7, RememberManager arg8, OperationErrorContext arg9) {
            Object v0 = arg5.getObject-PtL-UHM(ObjectParameter.constructor-impl(1));
            Object v2 = arg5.getObject-PtL-UHM(ObjectParameter.constructor-impl(0));
            Object v5 = arg5.getObject-PtL-UHM(ObjectParameter.constructor-impl(2));
            SlotWriter v3 = ((SlotTable)v0).openWriter();
            if(arg9 != null) {
                try {
                    arg9 = OperationKt.access$withCurrentStackTrace(arg9, arg7);
                    goto label_16;
                label_15:
                    arg9 = null;
                label_16:
                    ((FixupList)v5).executeAndFlushAllPendingFixups(arg6, v3, arg8, arg9);
                    goto label_18;
                label_14:
                    goto label_24;
                }
                catch(Throwable v4) {
                    goto label_14;
                }
            }
            else {
                goto label_15;
            }

            goto label_16;
        label_24:
            v3.close(false);
            throw v4;
        label_18:
            v3.close(true);
            arg7.beginInsert();
            arg7.moveFrom(((SlotTable)v0), ((GapAnchor)v2).toIndexFor(((SlotTable)v0)), false);
            arg7.endInsert();
        }

        public final int getAnchor-w8_IdGo() {
            return ObjectParameter.constructor-impl(0);
        }

        public final int getFixups-w8_IdGo() {
            return ObjectParameter.constructor-impl(2);
        }

        public final int getFromSlotTable-w8_IdGo() {
            return ObjectParameter.constructor-impl(1);
        }

        public String objectParamName-PtL-UHM(int arg2) {
            if(ObjectParameter.equals-impl0(arg2, ObjectParameter.constructor-impl(0))) {
                return "anchor";
            }

            if(ObjectParameter.equals-impl0(arg2, ObjectParameter.constructor-impl(1))) {
                return "from";
            }

            if(ObjectParameter.equals-impl0(arg2, ObjectParameter.constructor-impl(2))) {
                return "fixups";
            }

            return super.objectParamName-PtL-UHM(arg2);
        }
    }

    @Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\b\u001A\u00020\t2\n\u0010\n\u001A\u00060\u0005j\u0002`\u000BH\u0016J2\u0010\f\u001A\u00020\r*\u00020\u000E2\n\u0010\u000F\u001A\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016H\u0014R\u0012\u0010\u0004\u001A\u00020\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$MoveCurrentGroup;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "<init>", "()V", "Offset", "", "getOffset", "()I", "intParamName", "", "parameter", "Landroidx/compose/runtime/composer/gapbuffer/changelist/IntParameter;", "execute", "", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class MoveCurrentGroup extends Operation {
        public static final int $stable;
        public static final MoveCurrentGroup INSTANCE;

        static {
            MoveCurrentGroup.INSTANCE = new MoveCurrentGroup();
        }

        private MoveCurrentGroup() {
            super(1, 0, 2, null);
        }

        protected void execute(OperationArgContainer arg1, Applier arg2, SlotWriter arg3, RememberManager arg4, OperationErrorContext arg5) {
            arg3.moveGroup(arg1.getInt(0));
        }

        public final int getOffset() {
            return 0;
        }

        public String intParamName(int arg1) {
            if(arg1 == 0) {
                return "offset";
            }

            return super.intParamName(arg1);
        }
    }

    @Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\f\u001A\u00020\r2\n\u0010\u000E\u001A\u00060\u0005j\u0002`\u000FH\u0016J2\u0010\u0010\u001A\u00020\u0011*\u00020\u00122\n\u0010\u0013\u001A\u0006\u0012\u0002\b\u00030\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00182\b\u0010\u0019\u001A\u0004\u0018\u00010\u001AH\u0014R\u0012\u0010\u0004\u001A\u00020\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001A\u00020\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\t\u0010\u0007R\u0012\u0010\n\u001A\u00020\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u000B\u0010\u0007¨\u0006\u001B"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$MoveNode;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "<init>", "()V", "From", "", "getFrom", "()I", "To", "getTo", "Count", "getCount", "intParamName", "", "parameter", "Landroidx/compose/runtime/composer/gapbuffer/changelist/IntParameter;", "execute", "", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class MoveNode extends Operation {
        public static final int $stable;
        public static final MoveNode INSTANCE;

        static {
            MoveNode.INSTANCE = new MoveNode();
        }

        private MoveNode() {
            super(3, 0, 2, null);
        }

        protected void execute(OperationArgContainer arg1, Applier arg2, SlotWriter arg3, RememberManager arg4, OperationErrorContext arg5) {
            arg2.move(arg1.getInt(0), arg1.getInt(1), arg1.getInt(2));
        }

        public final int getCount() {
            return 2;
        }

        public final int getFrom() {
            return 0;
        }

        public final int getTo() {
            return 1;
        }

        public String intParamName(int arg2) {
            if(arg2 == 0) {
                return "from";
            }

            if(arg2 == 1) {
                return "to";
            }

            if(arg2 == 2) {
                return "count";
            }

            return super.intParamName(arg2);
        }
    }

    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0087@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\t\u001A\u00020\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\u0002HÖ\u0083\u0004J\n\u0010\f\u001A\u00020\u0004HÖ\u0081\u0004J\n\u0010\r\u001A\u00020\u000EHÖ\u0081\u0004R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b\u0088\u0001\u0003¨\u0006\u000F"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$ObjectParameter;", "T", "", "offset", "", "constructor-impl", "(I)I", "getOffset", "()I", "equals", "", "other", "hashCode", "toString", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) @JvmInline public final class ObjectParameter {
        private final int offset;

        private ObjectParameter(int arg1) {
            super();
            this.offset = arg1;
        }

        public static final ObjectParameter box-impl(int arg1) {
            return new ObjectParameter(arg1);
        }

        public static int constructor-impl(int arg0) {
            return arg0;
        }

        public boolean equals(Object arg1) {
            return ObjectParameter.equals-impl(this.offset, arg1);
        }

        public static boolean equals-impl(int arg2, Object arg3) {
            if(!(arg3 instanceof ObjectParameter)) {
                return 0;
            }

            if(arg2 != ((ObjectParameter)arg3).unbox-impl()) {
                return 0;
            }

            return 1;
        }

        public static final boolean equals-impl0(int arg0, int arg1) {
            if(arg0 == arg1) {
                return 1;
            }

            return 0;
        }

        public final int getOffset() {
            return this.offset;
        }

        public int hashCode() {
            return ObjectParameter.hashCode-impl(this.offset);
        }

        public static int hashCode-impl(int arg0) {
            return Integer.hashCode(arg0);
        }

        public String toString() {
            return ObjectParameter.toString-impl(this.offset);
        }

        public static String toString-impl(int arg2) {
            return "ObjectParameter(offset=" + arg2 + ')';
        }

        public final int unbox-impl() {
            return this.offset;
        }
    }

    @Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\f\u001A\u00020\r2\n\u0010\u000E\u001A\u00060\u0005j\u0002`\u000FH\u0016J\u001B\u0010\u0010\u001A\u00020\r2\n\u0010\u000E\u001A\u0006\u0012\u0002\b\u00030\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0013\u001A\u0004\u0018\u00010\n*\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0016H\u0014J2\u0010\u0017\u001A\u00020\u0018*\u00020\u00142\n\u0010\u0019\u001A\u0006\u0012\u0002\b\u00030\u001A2\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u001B\u001A\u00020\u001C2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001EH\u0014R\u0012\u0010\u0004\u001A\u00020\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t8Æ\u0002¢\u0006\u0006\u001A\u0004\b\u000B\u0010\u0007¨\u0006\u001F"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$PostInsertNodeFixup;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "<init>", "()V", "InsertIndex", "", "getInsertIndex", "()I", "GroupAnchor", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$ObjectParameter;", "Landroidx/compose/runtime/composer/gapbuffer/GapAnchor;", "getGroupAnchor-w8_IdGo", "intParamName", "", "parameter", "Landroidx/compose/runtime/composer/gapbuffer/changelist/IntParameter;", "objectParamName", "objectParamName-PtL-UHM", "(I)Ljava/lang/String;", "getGroupAnchor", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "execute", "", "applier", "Landroidx/compose/runtime/Applier;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class PostInsertNodeFixup extends Operation {
        public static final int $stable;
        public static final PostInsertNodeFixup INSTANCE;

        static {
            PostInsertNodeFixup.INSTANCE = new PostInsertNodeFixup();
        }

        private PostInsertNodeFixup() {
            super(1, 1, null);
        }

        protected void execute(OperationArgContainer arg1, Applier arg2, SlotWriter arg3, RememberManager arg4, OperationErrorContext arg5) {
            Object v4 = arg1.getObject-PtL-UHM(ObjectParameter.constructor-impl(0));
            int v0 = arg1.getInt(0);
            arg2.up();
            Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            arg2.insertBottomUp(v0, arg3.node(((GapAnchor)v4)));
        }

        protected GapAnchor getGroupAnchor(OperationArgContainer arg1, SlotWriter arg2) {
            return arg1.getObject-PtL-UHM(ObjectParameter.constructor-impl(0));
        }

        public final int getGroupAnchor-w8_IdGo() {
            return ObjectParameter.constructor-impl(0);
        }

        public final int getInsertIndex() {
            return 0;
        }

        public String intParamName(int arg1) {
            if(arg1 == 0) {
                return "insertIndex";
            }

            return super.intParamName(arg1);
        }

        public String objectParamName-PtL-UHM(int arg2) {
            if(ObjectParameter.equals-impl0(arg2, ObjectParameter.constructor-impl(0))) {
                return "groupAnchor";
            }

            return super.objectParamName-PtL-UHM(arg2);
        }
    }

    @Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001B\u0010\u000F\u001A\u00020\u00102\n\u0010\u0011\u001A\u0006\u0012\u0002\b\u00030\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J2\u0010\u0014\u001A\u00020\u0015*\u00020\u00162\n\u0010\u0017\u001A\u0006\u0012\u0002\b\u00030\u00182\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u001C2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001EH\u0014R\u0018\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001A\b\u0012\u0004\u0012\u00020\n0\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u000B\u0010\bR\u0018\u0010\f\u001A\b\u0012\u0004\u0012\u00020\r0\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u000E\u0010\b¨\u0006\u001F"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$ReleaseMovableGroupAtCurrent;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "<init>", "()V", "Composition", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$ObjectParameter;", "Landroidx/compose/runtime/ControlledComposition;", "getComposition-w8_IdGo", "()I", "ParentCompositionContext", "Landroidx/compose/runtime/CompositionContext;", "getParentCompositionContext-w8_IdGo", "Reference", "Landroidx/compose/runtime/MovableContentStateReference;", "getReference-w8_IdGo", "objectParamName", "", "parameter", "objectParamName-PtL-UHM", "(I)Ljava/lang/String;", "execute", "", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ReleaseMovableGroupAtCurrent extends Operation {
        public static final int $stable;
        public static final ReleaseMovableGroupAtCurrent INSTANCE;

        static {
            ReleaseMovableGroupAtCurrent.INSTANCE = new ReleaseMovableGroupAtCurrent();
        }

        private ReleaseMovableGroupAtCurrent() {
            super(0, 3, 1, null);
        }

        protected void execute(OperationArgContainer arg1, Applier arg2, SlotWriter arg3, RememberManager arg4, OperationErrorContext arg5) {
            Object v0 = arg1.getObject-PtL-UHM(ObjectParameter.constructor-impl(0));
            Object v4 = arg1.getObject-PtL-UHM(ObjectParameter.constructor-impl(2));
            arg1.getObject-PtL-UHM(ObjectParameter.constructor-impl(1)).movableContentStateReleased$runtime(((MovableContentStateReference)v4), ComposerKt.extractMovableContentAtCurrent(((ControlledComposition)v0), ((MovableContentStateReference)v4), arg3, null), arg2);
        }

        public final int getComposition-w8_IdGo() {
            return ObjectParameter.constructor-impl(0);
        }

        public final int getParentCompositionContext-w8_IdGo() {
            return ObjectParameter.constructor-impl(1);
        }

        public final int getReference-w8_IdGo() {
            return ObjectParameter.constructor-impl(2);
        }

        public String objectParamName-PtL-UHM(int arg2) {
            if(ObjectParameter.equals-impl0(arg2, ObjectParameter.constructor-impl(0))) {
                return "composition";
            }

            if(ObjectParameter.equals-impl0(arg2, ObjectParameter.constructor-impl(1))) {
                return "parentCompositionContext";
            }

            if(ObjectParameter.equals-impl0(arg2, ObjectParameter.constructor-impl(2))) {
                return "reference";
            }

            return super.objectParamName-PtL-UHM(arg2);
        }
    }

    @Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001B\u0010\t\u001A\u00020\n2\n\u0010\u000B\u001A\u0006\u0012\u0002\b\u00030\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ2\u0010\u000E\u001A\u00020\u000F*\u00020\u00102\n\u0010\u0011\u001A\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0014R\u0018\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$Remember;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "<init>", "()V", "Value", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$ObjectParameter;", "Landroidx/compose/runtime/RememberObserverHolder;", "getValue-w8_IdGo", "()I", "objectParamName", "", "parameter", "objectParamName-PtL-UHM", "(I)Ljava/lang/String;", "execute", "", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Remember extends Operation {
        public static final int $stable;
        public static final Remember INSTANCE;

        static {
            Remember.INSTANCE = new Remember();
        }

        private Remember() {
            super(0, 1, 1, null);
        }

        protected void execute(OperationArgContainer arg1, Applier arg2, SlotWriter arg3, RememberManager arg4, OperationErrorContext arg5) {
            arg4.remembering(arg1.getObject-PtL-UHM(ObjectParameter.constructor-impl(0)));
        }

        public final int getValue-w8_IdGo() {
            return ObjectParameter.constructor-impl(0);
        }

        public String objectParamName-PtL-UHM(int arg2) {
            if(ObjectParameter.equals-impl0(arg2, ObjectParameter.constructor-impl(0))) {
                return "value";
            }

            return super.objectParamName-PtL-UHM(arg2);
        }
    }

    @Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001B\u0010\t\u001A\u00020\n2\n\u0010\u000B\u001A\u0006\u0012\u0002\b\u00030\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ2\u0010\u000E\u001A\u00020\u000F*\u00020\u00102\n\u0010\u0011\u001A\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0014R\u0018\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$RememberPausingScope;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "<init>", "()V", "Scope", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$ObjectParameter;", "Landroidx/compose/runtime/RecomposeScopeImpl;", "getScope-w8_IdGo", "()I", "objectParamName", "", "parameter", "objectParamName-PtL-UHM", "(I)Ljava/lang/String;", "execute", "", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class RememberPausingScope extends Operation {
        public static final int $stable;
        public static final RememberPausingScope INSTANCE;

        static {
            RememberPausingScope.INSTANCE = new RememberPausingScope();
        }

        private RememberPausingScope() {
            super(0, 1, 1, null);
        }

        protected void execute(OperationArgContainer arg1, Applier arg2, SlotWriter arg3, RememberManager arg4, OperationErrorContext arg5) {
            arg4.rememberPausingScope(arg1.getObject-PtL-UHM(ObjectParameter.constructor-impl(0)));
        }

        public final int getScope-w8_IdGo() {
            return ObjectParameter.constructor-impl(0);
        }

        public String objectParamName-PtL-UHM(int arg2) {
            if(ObjectParameter.equals-impl0(arg2, ObjectParameter.constructor-impl(0))) {
                return "scope";
            }

            return super.objectParamName-PtL-UHM(arg2);
        }
    }

    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001A\u00020\u0005*\u00020\u00062\n\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u000EH\u0014¨\u0006\u000F"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$RemoveCurrentGroup;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "<init>", "()V", "execute", "", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class RemoveCurrentGroup extends Operation {
        public static final int $stable;
        public static final RemoveCurrentGroup INSTANCE;

        static {
            RemoveCurrentGroup.INSTANCE = new RemoveCurrentGroup();
        }

        private RemoveCurrentGroup() {
            super(0, 0, 3, null);
        }

        protected void execute(OperationArgContainer arg1, Applier arg2, SlotWriter arg3, RememberManager arg4, OperationErrorContext arg5) {
            ComposerKt.removeCurrentGroup(arg3, arg4);
        }
    }

    @Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\n\u001A\u00020\u000B2\n\u0010\f\u001A\u00060\u0005j\u0002`\rH\u0016J2\u0010\u000E\u001A\u00020\u000F*\u00020\u00102\n\u0010\u0011\u001A\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0014R\u0012\u0010\u0004\u001A\u00020\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001A\u00020\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\t\u0010\u0007¨\u0006\u0019"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$RemoveNode;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "<init>", "()V", "RemoveIndex", "", "getRemoveIndex", "()I", "Count", "getCount", "intParamName", "", "parameter", "Landroidx/compose/runtime/composer/gapbuffer/changelist/IntParameter;", "execute", "", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class RemoveNode extends Operation {
        public static final int $stable;
        public static final RemoveNode INSTANCE;

        static {
            RemoveNode.INSTANCE = new RemoveNode();
        }

        private RemoveNode() {
            super(2, 0, 2, null);
        }

        protected void execute(OperationArgContainer arg1, Applier arg2, SlotWriter arg3, RememberManager arg4, OperationErrorContext arg5) {
            arg2.remove(arg1.getInt(0), arg1.getInt(1));
        }

        public final int getCount() {
            return 1;
        }

        public final int getRemoveIndex() {
            return 0;
        }

        public String intParamName(int arg2) {
            if(arg2 == 0) {
                return "removeIndex";
            }

            if(arg2 == 1) {
                return "count";
            }

            return super.intParamName(arg2);
        }
    }

    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001A\u00020\u0005*\u00020\u00062\n\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u000EH\u0014¨\u0006\u000F"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$ResetSlots;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "<init>", "()V", "execute", "", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ResetSlots extends Operation {
        public static final int $stable;
        public static final ResetSlots INSTANCE;

        static {
            ResetSlots.INSTANCE = new ResetSlots();
        }

        private ResetSlots() {
            super(0, 0, 3, null);
        }

        protected void execute(OperationArgContainer arg1, Applier arg2, SlotWriter arg3, RememberManager arg4, OperationErrorContext arg5) {
            arg3.reset();
        }
    }

    @Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001B\u0010\n\u001A\u00020\u000B2\n\u0010\f\u001A\u0006\u0012\u0002\b\u00030\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000EJ2\u0010\u000F\u001A\u00020\u0007*\u00020\u00102\n\u0010\u0011\u001A\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0014R\u001E\u0010\u0004\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\u0019"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$SideEffect;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "<init>", "()V", "Effect", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$ObjectParameter;", "Lkotlin/Function0;", "", "getEffect-w8_IdGo", "()I", "objectParamName", "", "parameter", "objectParamName-PtL-UHM", "(I)Ljava/lang/String;", "execute", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SideEffect extends Operation {
        public static final int $stable;
        public static final SideEffect INSTANCE;

        static {
            SideEffect.INSTANCE = new SideEffect();
        }

        private SideEffect() {
            super(0, 1, 1, null);
        }

        protected void execute(OperationArgContainer arg1, Applier arg2, SlotWriter arg3, RememberManager arg4, OperationErrorContext arg5) {
            arg4.sideEffect(arg1.getObject-PtL-UHM(ObjectParameter.constructor-impl(0)));
        }

        public final int getEffect-w8_IdGo() {
            return ObjectParameter.constructor-impl(0);
        }

        public String objectParamName-PtL-UHM(int arg2) {
            if(ObjectParameter.equals-impl0(arg2, ObjectParameter.constructor-impl(0))) {
                return "effect";
            }

            return super.objectParamName-PtL-UHM(arg2);
        }
    }

    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001A\u00020\u0005*\u00020\u00062\n\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u000EH\u0014¨\u0006\u000F"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$SkipToEndOfCurrentGroup;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "<init>", "()V", "execute", "", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SkipToEndOfCurrentGroup extends Operation {
        public static final int $stable;
        public static final SkipToEndOfCurrentGroup INSTANCE;

        static {
            SkipToEndOfCurrentGroup.INSTANCE = new SkipToEndOfCurrentGroup();
        }

        private SkipToEndOfCurrentGroup() {
            super(0, 0, 3, null);
        }

        protected void execute(OperationArgContainer arg1, Applier arg2, SlotWriter arg3, RememberManager arg4, OperationErrorContext arg5) {
            arg3.skipToGroupEnd();
        }
    }

    @Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001B\u0010\t\u001A\u00020\n2\n\u0010\u000B\u001A\u0006\u0012\u0002\b\u00030\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ2\u0010\u000E\u001A\u00020\u000F*\u00020\u00102\n\u0010\u0011\u001A\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0014R\u0018\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$StartResumingScope;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "<init>", "()V", "Scope", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$ObjectParameter;", "Landroidx/compose/runtime/RecomposeScopeImpl;", "getScope-w8_IdGo", "()I", "objectParamName", "", "parameter", "objectParamName-PtL-UHM", "(I)Ljava/lang/String;", "execute", "", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class StartResumingScope extends Operation {
        public static final int $stable;
        public static final StartResumingScope INSTANCE;

        static {
            StartResumingScope.INSTANCE = new StartResumingScope();
        }

        private StartResumingScope() {
            super(0, 1, 1, null);
        }

        protected void execute(OperationArgContainer arg1, Applier arg2, SlotWriter arg3, RememberManager arg4, OperationErrorContext arg5) {
            arg4.startResumingScope(arg1.getObject-PtL-UHM(ObjectParameter.constructor-impl(0)));
        }

        public final int getScope-w8_IdGo() {
            return ObjectParameter.constructor-impl(0);
        }

        public String objectParamName-PtL-UHM(int arg2) {
            if(ObjectParameter.equals-impl0(arg2, ObjectParameter.constructor-impl(0))) {
                return "scope";
            }

            return super.objectParamName-PtL-UHM(arg2);
        }
    }

    @Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001BC\b\u0007\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012$\b\u0002\u0010\u0005\u001A\u001E\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0006¢\u0006\u0004\b\u000B\u0010\fJ2\u0010\u001A\u001A\u00020\n*\u00020\u001B2\n\u0010\u001C\u001A\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u001D\u001A\u00020\b2\u0006\u0010\u001E\u001A\u00020\t2\b\u0010\u001F\u001A\u0004\u0018\u00010 H\u0014J\b\u0010!\u001A\u00020\"H\u0016R-\u0010\u0005\u001A\u001E\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0006¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u001D\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00030\u0010¢\u0006\u000E\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014R%\u0010\u0015\u001A\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00160\u0010¢\u0006\u000E\n\u0000\u0012\u0004\b\u0018\u0010\u0012\u001A\u0004\b\u0019\u0010\u0014¨\u0006#"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$TestOperation;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "ints", "", "objects", "block", "Lkotlin/Function3;", "Landroidx/compose/runtime/Applier;", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "Landroidx/compose/runtime/composer/RememberManager;", "", "<init>", "(IILkotlin/jvm/functions/Function3;)V", "getBlock", "()Lkotlin/jvm/functions/Function3;", "intParams", "", "getIntParams$annotations", "()V", "getIntParams", "()Ljava/util/List;", "objParams", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$ObjectParameter;", "", "getObjParams$annotations", "getObjParams", "execute", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "applier", "slots", "rememberManager", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "toString", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class TestOperation extends Operation {
        public static final int $stable = 8;
        private final Function3 block;
        private final List intParams;
        private final List objParams;

        static {
        }

        public TestOperation() {
            this(0, 0, null, 7, null);
        }

        public TestOperation(int arg2, int arg3, Function3 arg4, int arg5, DefaultConstructorMarker arg6) {
            Operation$TestOperation$$ExternalSyntheticLambda0 v4;
            if((arg5 & 4) != 0) {
                v4 = new Operation$TestOperation$$ExternalSyntheticLambda0();
            }

            this(0, 0, ((Function3)v4));
        }

        public TestOperation(int arg4, int arg5, Function3 arg6) {
            super(arg4, arg5, null);
            this.block = arg6;
            ArrayList v6 = new ArrayList(arg4);
            int v0 = 0;
            int v1;
            for(v1 = 0; v1 < arg4; ++v1) {
                v6.add(Integer.valueOf(v1));
            }

            this.intParams = ((List)v6);
            ArrayList v4 = new ArrayList(arg5);
            while(v0 < arg5) {
                v4.add(ObjectParameter.box-impl(ObjectParameter.constructor-impl(v0)));
                ++v0;
            }

            this.objParams = ((List)v4);
        }

        static final Unit _init_$lambda$0(Applier arg0, SlotWriter arg1, RememberManager arg2) {
            return Unit.INSTANCE;
        }

        protected void execute(OperationArgContainer arg1, Applier arg2, SlotWriter arg3, RememberManager arg4, OperationErrorContext arg5) {
            this.block.invoke(arg2, arg3, arg4);
        }

        public final Function3 getBlock() {
            return this.block;
        }

        public final List getIntParams() {
            return this.intParams;
        }

        public static void getIntParams$annotations() {
        }

        public final List getObjParams() {
            return this.objParams;
        }

        public static void getObjParams$annotations() {
        }

        public String toString() {
            return "TestOperation(ints = " + this.getInts() + ", objects = " + this.getObjects() + ")@" + System_jvmKt.identityHashCode(this);
        }
    }

    @Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\b\u001A\u00020\t2\n\u0010\n\u001A\u00060\u0005j\u0002`\u000BH\u0016J2\u0010\f\u001A\u00020\r*\u00020\u000E2\n\u0010\u000F\u001A\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016H\u0014R\u0012\u0010\u0004\u001A\u00020\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$TrimParentValues;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "<init>", "()V", "Count", "", "getCount", "()I", "intParamName", "", "parameter", "Landroidx/compose/runtime/composer/gapbuffer/changelist/IntParameter;", "execute", "", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class TrimParentValues extends Operation {
        public static final int $stable;
        public static final TrimParentValues INSTANCE;

        static {
            TrimParentValues.INSTANCE = new TrimParentValues();
        }

        private TrimParentValues() {
            super(1, 0, 2, null);
        }

        protected void execute(OperationArgContainer arg2, Applier arg3, SlotWriter arg4, RememberManager arg5, OperationErrorContext arg6) {
            int v1 = arg2.getInt(0);
            int v2 = arg4.getParent();
            int v3 = arg4.slotsStartIndex$runtime(v2);
            v2 = arg4.slotsEndIndex$runtime(v2);
            for(v3 = Math.max(v3, v2 - v1); v3 < v2; ++v3) {
                Object v6 = arg4.slots[arg4.dataIndexToDataAddress(v3)];
                if((v6 instanceof RememberObserverHolder)) {
                    arg5.forgetting(((RememberObserverHolder)v6));
                }
                else if((v6 instanceof RecomposeScopeImpl)) {
                    ((RecomposeScopeImpl)v6).release();
                }
            }

            arg4.trimTailSlots(v1);
        }

        public final int getCount() {
            return 0;
        }

        public String intParamName(int arg1) {
            if(arg1 == 0) {
                return "count";
            }

            return super.intParamName(arg1);
        }
    }

    @Metadata(d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u000F\u001A\u00020\u00102\n\u0010\u0011\u001A\u00060\rj\u0002`\u0012H\u0016J\u001B\u0010\u0013\u001A\u00020\u00102\n\u0010\u0011\u001A\u0006\u0012\u0002\b\u00030\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J2\u0010\u0016\u001A\u00020\u0017*\u00020\u00182\n\u0010\u0019\u001A\u0006\u0012\u0002\b\u00030\u001A2\u0006\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u001E2\b\u0010\u001F\u001A\u0004\u0018\u00010 H\u0014R\u001A\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001A\b\u0012\u0004\u0012\u00020\n0\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u000B\u0010\bR\u0012\u0010\f\u001A\u00020\r8Æ\u0002¢\u0006\u0006\u001A\u0004\b\u000E\u0010\b¨\u0006!"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$UpdateAnchoredValue;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "<init>", "()V", "Value", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$ObjectParameter;", "", "getValue-w8_IdGo", "()I", "Anchor", "Landroidx/compose/runtime/composer/gapbuffer/GapAnchor;", "getAnchor-w8_IdGo", "GroupSlotIndex", "", "getGroupSlotIndex", "intParamName", "", "parameter", "Landroidx/compose/runtime/composer/gapbuffer/changelist/IntParameter;", "objectParamName", "objectParamName-PtL-UHM", "(I)Ljava/lang/String;", "execute", "", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class UpdateAnchoredValue extends Operation {
        public static final int $stable;
        public static final UpdateAnchoredValue INSTANCE;

        static {
            UpdateAnchoredValue.INSTANCE = new UpdateAnchoredValue();
        }

        private UpdateAnchoredValue() {
            super(1, 2, null);
        }

        protected void execute(OperationArgContainer arg1, Applier arg2, SlotWriter arg3, RememberManager arg4, OperationErrorContext arg5) {
            Object v2 = arg1.getObject-PtL-UHM(ObjectParameter.constructor-impl(0));
            Object v5 = arg1.getObject-PtL-UHM(ObjectParameter.constructor-impl(1));
            int v0 = arg1.getInt(0);
            if((v2 instanceof RememberObserverHolder)) {
                arg4.remembering(v2);
            }

            Object v0_1 = arg3.set(arg3.anchorIndex(((GapAnchor)v5)), v0, v2);
            if((v0_1 instanceof RememberObserverHolder)) {
                arg4.forgetting(((RememberObserverHolder)v0_1));
                return;
            }

            if((v0_1 instanceof RecomposeScopeImpl)) {
                ((RecomposeScopeImpl)v0_1).release();
            }
        }

        public final int getAnchor-w8_IdGo() {
            return ObjectParameter.constructor-impl(1);
        }

        public final int getGroupSlotIndex() {
            return 0;
        }

        public final int getValue-w8_IdGo() {
            return ObjectParameter.constructor-impl(0);
        }

        public String intParamName(int arg1) {
            if(arg1 == 0) {
                return "groupSlotIndex";
            }

            return super.intParamName(arg1);
        }

        public String objectParamName-PtL-UHM(int arg2) {
            if(ObjectParameter.equals-impl0(arg2, ObjectParameter.constructor-impl(0))) {
                return "value";
            }

            if(ObjectParameter.equals-impl0(arg2, ObjectParameter.constructor-impl(1))) {
                return "anchor";
            }

            return super.objectParamName-PtL-UHM(arg2);
        }
    }

    @Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001B\u0010\t\u001A\u00020\n2\n\u0010\u000B\u001A\u0006\u0012\u0002\b\u00030\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ2\u0010\u000E\u001A\u00020\u000F*\u00020\u00102\n\u0010\u0011\u001A\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0014R\u001A\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$UpdateAuxData;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "<init>", "()V", "Data", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$ObjectParameter;", "", "getData-w8_IdGo", "()I", "objectParamName", "", "parameter", "objectParamName-PtL-UHM", "(I)Ljava/lang/String;", "execute", "", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class UpdateAuxData extends Operation {
        public static final int $stable;
        public static final UpdateAuxData INSTANCE;

        static {
            UpdateAuxData.INSTANCE = new UpdateAuxData();
        }

        private UpdateAuxData() {
            super(0, 1, 1, null);
        }

        protected void execute(OperationArgContainer arg1, Applier arg2, SlotWriter arg3, RememberManager arg4, OperationErrorContext arg5) {
            arg3.updateAux(arg1.getObject-PtL-UHM(ObjectParameter.constructor-impl(0)));
        }

        public final int getData-w8_IdGo() {
            return ObjectParameter.constructor-impl(0);
        }

        public String objectParamName-PtL-UHM(int arg2) {
            if(ObjectParameter.equals-impl0(arg2, ObjectParameter.constructor-impl(0))) {
                return "data";
            }

            return super.objectParamName-PtL-UHM(arg2);
        }
    }

    @Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001B\u0010\u000E\u001A\u00020\u000F2\n\u0010\u0010\u001A\u0006\u0012\u0002\b\u00030\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J2\u0010\u0013\u001A\u00020\u000B*\u00020\u00142\n\u0010\u0015\u001A\u0006\u0012\u0002\b\u00030\u00162\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001A2\b\u0010\u001B\u001A\u0004\u0018\u00010\u001CH\u0014R\u001A\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0007\u0010\bR3\u0010\t\u001A#\u0012\u001F\u0012\u001D\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u000B0\n¢\u0006\u0002\b\f0\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\r\u0010\b¨\u0006\u001D"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$UpdateNode;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "<init>", "()V", "Value", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$ObjectParameter;", "", "getValue-w8_IdGo", "()I", "Block", "Lkotlin/Function2;", "", "Lkotlin/ExtensionFunctionType;", "getBlock-w8_IdGo", "objectParamName", "", "parameter", "objectParamName-PtL-UHM", "(I)Ljava/lang/String;", "execute", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class UpdateNode extends Operation {
        public static final int $stable;
        public static final UpdateNode INSTANCE;

        static {
            UpdateNode.INSTANCE = new UpdateNode();
        }

        private UpdateNode() {
            super(0, 2, 1, null);
        }

        protected void execute(OperationArgContainer arg1, Applier arg2, SlotWriter arg3, RememberManager arg4, OperationErrorContext arg5) {
            arg2.apply(arg1.getObject-PtL-UHM(ObjectParameter.constructor-impl(1)), arg1.getObject-PtL-UHM(ObjectParameter.constructor-impl(0)));
        }

        public final int getBlock-w8_IdGo() {
            return ObjectParameter.constructor-impl(1);
        }

        public final int getValue-w8_IdGo() {
            return ObjectParameter.constructor-impl(0);
        }

        public String objectParamName-PtL-UHM(int arg2) {
            if(ObjectParameter.equals-impl0(arg2, ObjectParameter.constructor-impl(0))) {
                return "value";
            }

            if(ObjectParameter.equals-impl0(arg2, ObjectParameter.constructor-impl(1))) {
                return "block";
            }

            return super.objectParamName-PtL-UHM(arg2);
        }
    }

    @Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\f\u001A\u00020\r2\n\u0010\u000E\u001A\u00060\nj\u0002`\u000FH\u0016J\u001B\u0010\u0010\u001A\u00020\r2\n\u0010\u000E\u001A\u0006\u0012\u0002\b\u00030\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J2\u0010\u0013\u001A\u00020\u0014*\u00020\u00152\n\u0010\u0016\u001A\u0006\u0012\u0002\b\u00030\u00172\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u001B2\b\u0010\u001C\u001A\u0004\u0018\u00010\u001DH\u0014R\u001A\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001A\u00020\n8Æ\u0002¢\u0006\u0006\u001A\u0004\b\u000B\u0010\b¨\u0006\u001E"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$UpdateValue;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "<init>", "()V", "Value", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$ObjectParameter;", "", "getValue-w8_IdGo", "()I", "GroupSlotIndex", "", "getGroupSlotIndex", "intParamName", "", "parameter", "Landroidx/compose/runtime/composer/gapbuffer/changelist/IntParameter;", "objectParamName", "objectParamName-PtL-UHM", "(I)Ljava/lang/String;", "execute", "", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class UpdateValue extends Operation {
        public static final int $stable;
        public static final UpdateValue INSTANCE;

        static {
            UpdateValue.INSTANCE = new UpdateValue();
        }

        private UpdateValue() {
            super(1, 1, null);
        }

        protected void execute(OperationArgContainer arg1, Applier arg2, SlotWriter arg3, RememberManager arg4, OperationErrorContext arg5) {
            Object v2 = arg1.getObject-PtL-UHM(ObjectParameter.constructor-impl(0));
            int v0 = arg1.getInt(0);
            if((v2 instanceof RememberObserverHolder)) {
                arg4.remembering(v2);
            }

            Object v0_1 = arg3.set(arg3.getCurrentGroup(), v0, v2);
            if((v0_1 instanceof RememberObserverHolder)) {
                arg4.forgetting(((RememberObserverHolder)v0_1));
                return;
            }

            if((v0_1 instanceof RecomposeScopeImpl)) {
                ((RecomposeScopeImpl)v0_1).release();
            }
        }

        public final int getGroupSlotIndex() {
            return 0;
        }

        public final int getValue-w8_IdGo() {
            return ObjectParameter.constructor-impl(0);
        }

        public String intParamName(int arg1) {
            if(arg1 == 0) {
                return "groupSlotIndex";
            }

            return super.intParamName(arg1);
        }

        public String objectParamName-PtL-UHM(int arg2) {
            if(ObjectParameter.equals-impl0(arg2, ObjectParameter.constructor-impl(0))) {
                return "value";
            }

            return super.objectParamName-PtL-UHM(arg2);
        }
    }

    @Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\b\u001A\u00020\t2\n\u0010\n\u001A\u00060\u0005j\u0002`\u000BH\u0016J2\u0010\f\u001A\u00020\r*\u00020\u000E2\n\u0010\u000F\u001A\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016H\u0014R\u0012\u0010\u0004\u001A\u00020\u00058Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$Ups;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "<init>", "()V", "Count", "", "getCount", "()I", "intParamName", "", "parameter", "Landroidx/compose/runtime/composer/gapbuffer/changelist/IntParameter;", "execute", "", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Ups extends Operation {
        public static final int $stable;
        public static final Ups INSTANCE;

        static {
            Ups.INSTANCE = new Ups();
        }

        private Ups() {
            super(1, 0, 2, null);
        }

        protected void execute(OperationArgContainer arg1, Applier arg2, SlotWriter arg3, RememberManager arg4, OperationErrorContext arg5) {
            int v0 = 0;
            int v1 = arg1.getInt(0);
            while(v0 < v1) {
                arg2.up();
                ++v0;
            }
        }

        public final int getCount() {
            return 0;
        }

        public String intParamName(int arg1) {
            if(arg1 == 0) {
                return "count";
            }

            return super.intParamName(arg1);
        }
    }

    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001A\u00020\u0005*\u00020\u00062\n\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u000EH\u0014¨\u0006\u000F"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$UseCurrentNode;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "<init>", "()V", "execute", "", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class UseCurrentNode extends Operation {
        public static final int $stable;
        public static final UseCurrentNode INSTANCE;

        static {
            UseCurrentNode.INSTANCE = new UseCurrentNode();
        }

        private UseCurrentNode() {
            super(0, 0, 3, null);
        }

        protected void execute(OperationArgContainer arg1, Applier arg2, SlotWriter arg3, RememberManager arg4, OperationErrorContext arg5) {
            arg2.reuse();
        }
    }

    public static final int $stable;
    private final int ints;
    private final int objects;

    static {
    }

    private Operation(int arg1, int arg2) {
        super();
        this.ints = arg1;
        this.objects = arg2;
    }

    public Operation(int arg2, int arg3, int arg4, DefaultConstructorMarker arg5) {
        this(0, 0, null);
    }

    public Operation(int arg1, int arg2, DefaultConstructorMarker arg3) {
        this(arg1, arg2);
    }

    protected abstract void execute(OperationArgContainer arg1, Applier arg2, SlotWriter arg3, RememberManager arg4, OperationErrorContext arg5);

    public final void executeWithComposeStackTrace(OperationArgContainer arg3, Applier arg4, SlotWriter arg5, RememberManager arg6, OperationErrorContext arg7) {
        GapAnchor v1 = this.getGroupAnchor(arg3, arg5);
        try {
            this.execute(arg3, arg4, arg5, arg6, arg7);
            return;
        }
        catch(Throwable v0) {
            throw OperationKt.access$attachComposeStackTrace(v0, arg7, arg5, v1);
        }
    }

    protected GapAnchor getGroupAnchor(OperationArgContainer arg1, SlotWriter arg2) {
        return null;
    }

    public final int getInts() {
        return this.ints;
    }

    public final String getName() {
        String v0 = Reflection.getOrCreateKotlinClass(this.getClass()).getSimpleName();
        if(v0 == null) {
            v0 = "";
        }

        return v0;
    }

    public final int getObjects() {
        return this.objects;
    }

    public String intParamName(int arg2) {
        return "IntParameter(" + arg2 + ')';
    }

    public String objectParamName-PtL-UHM(int arg2) {
        return "ObjectParameter(" + arg2 + ')';
    }

    public String toString() {
        return this.getName();
    }
}

