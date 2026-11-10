package androidx.compose.runtime.composer.gapbuffer.changelist;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.composer.RememberManager;
import androidx.compose.runtime.composer.gapbuffer.GapAnchor;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000B\u001A\u00020\fJ\u0006\u0010\r\u001A\u00020\fJ\u0006\u0010\u000E\u001A\u00020\u000FJ,\u0010\u0010\u001A\u00020\u000F2\n\u0010\u0011\u001A\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018J&\u0010\u0019\u001A\u00020\u000F2\u000E\u0010\u001A\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u001C0\u001B2\u0006\u0010\u001D\u001A\u00020\b2\u0006\u0010\u001E\u001A\u00020\u001FJ\u0006\u0010 \u001A\u00020\u000FJ>\u0010!\u001A\u00020\u000F\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010#2\u0006\u0010$\u001A\u0002H\"2\u001D\u0010%\u001A\u0019\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H\"\u0012\u0004\u0012\u00020\u000F0&¢\u0006\u0002\b\'¢\u0006\u0002\u0010(J\u0010\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020*H\u0016R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001A\u00020\b8F¢\u0006\u0006\u001A\u0004\b\t\u0010\n¨\u0006,"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/FixupList;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationsDebugStringFormattable;", "<init>", "()V", "operations", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operations;", "pendingOperations", "size", "", "getSize", "()I", "isEmpty", "", "isNotEmpty", "clear", "", "executeAndFlushAllPendingFixups", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "createAndInsertNode", "factory", "Lkotlin/Function0;", "", "insertIndex", "groupAnchor", "Landroidx/compose/runtime/composer/gapbuffer/GapAnchor;", "endNodeInsert", "updateNode", "V", "T", "value", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "toDebugString", "", "linePrefix", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class FixupList extends OperationsDebugStringFormattable {
    public static final int $stable = 8;
    private final Operations operations;
    private final Operations pendingOperations;

    static {
    }

    public FixupList() {
        super();
        this.operations = new Operations();
        this.pendingOperations = new Operations();
    }

    public final void clear() {
        this.pendingOperations.clear();
        this.operations.clear();
    }

    public final void createAndInsertNode(Function0 arg9, int arg10, GapAnchor arg11) {
        Operations v0 = this.operations;
        InsertNodeFixup v1 = InsertNodeFixup.INSTANCE;
        v0.pushOp(((Operation)v1));
        Operations v2 = WriteScope.constructor-impl(v0);
        WriteScope.setObject-sGr0YRc(v2, ObjectParameter.constructor-impl(0), arg9);
        v2.intArgs[v2.intArgsSize - v2.opCodes[v2.opCodesSize - 1].getInts()] = arg10;
        WriteScope.setObject-sGr0YRc(v2, ObjectParameter.constructor-impl(1), arg11);
        v0.ensureAllArgumentsPushedFor(((Operation)v1));
        Operations v8 = this.pendingOperations;
        PostInsertNodeFixup v9 = PostInsertNodeFixup.INSTANCE;
        v8.pushOp(((Operation)v9));
        v0 = WriteScope.constructor-impl(v8);
        v0.intArgs[v0.intArgsSize - v0.opCodes[v0.opCodesSize - 1].getInts()] = arg10;
        WriteScope.setObject-sGr0YRc(v0, ObjectParameter.constructor-impl(0), arg11);
        v8.ensureAllArgumentsPushedFor(((Operation)v9));
    }

    public final void endNodeInsert() {
        if(!this.pendingOperations.isNotEmpty()) {
            ComposerKt.composeImmediateRuntimeError("Cannot end node insertion, there are no pending operations that can be realized.");
        }

        this.pendingOperations.popInto(this.operations);
    }

    public final void executeAndFlushAllPendingFixups(Applier arg2, SlotWriter arg3, RememberManager arg4, OperationErrorContext arg5) {
        if(!this.pendingOperations.isEmpty()) {
            ComposerKt.composeImmediateRuntimeError("FixupList has pending fixup operations that were not realized. Were there mismatched insertNode() and endNodeInsert() calls?");
        }

        this.operations.executeAndFlushAllPendingOperations(arg2, arg3, arg4, arg5);
    }

    public final int getSize() {
        return this.operations.getSize();
    }

    public final boolean isEmpty() {
        return this.operations.isEmpty();
    }

    public final boolean isNotEmpty() {
        return this.operations.isNotEmpty();
    }

    public String toDebugString(String arg4) {
        StringBuilder v0 = new StringBuilder();
        v0.append("FixupList instance containing " + this.getSize() + " operations");
        if(v0.length() > 0) {
            v0.append(":\n" + this.operations.toDebugString(arg4));
        }

        return v0.toString();
    }

    public final void updateNode(Object arg4, Function2 arg5) {
        Operations v3 = this.operations;
        UpdateNode v0 = UpdateNode.INSTANCE;
        v3.pushOp(((Operation)v0));
        Operations v1 = WriteScope.constructor-impl(v3);
        WriteScope.setObject-sGr0YRc(v1, ObjectParameter.constructor-impl(0), arg4);
        int v4 = ObjectParameter.constructor-impl(1);
        Intrinsics.checkNotNull(arg5, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Unit>");
        WriteScope.setObject-sGr0YRc(v1, v4, TypeIntrinsics.beforeCheckcastToFunctionOfArity(arg5, 2));
        v3.ensureAllArgumentsPushedFor(((Operation)v0));
    }
}

