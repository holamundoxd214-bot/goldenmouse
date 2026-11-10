package androidx.compose.runtime.composer.gapbuffer.changelist;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.composer.RememberManager;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\u008C\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u001C\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001:\u0002STB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0017\u001A\u00020\u0018J\u0006\u0010\u0019\u001A\u00020\u0018J\u0006\u0010\u001A\u001A\u00020\u001BJ\u0010\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u001D\u001A\u00020\u0006H\u0007J\u0018\u0010\u001E\u001A\u00020\n2\u0006\u0010\u001F\u001A\u00020\n2\u0006\u0010 \u001A\u00020\nH\u0002J\b\u0010!\u001A\u00020\u001BH\u0002J\u0011\u0010\"\u001A\u00020\u001B2\u0006\u0010 \u001A\u00020\nH\u0082\bJ\u0018\u0010#\u001A\u00020\u001B2\u0006\u0010\u001F\u001A\u00020\n2\u0006\u0010 \u001A\u00020\nH\u0002J\u0011\u0010$\u001A\u00020\u001B2\u0006\u0010 \u001A\u00020\nH\u0082\bJ\u0018\u0010%\u001A\u00020\u001B2\u0006\u0010\u001F\u001A\u00020\n2\u0006\u0010 \u001A\u00020\nH\u0002J\u000E\u0010&\u001A\u00020\u001B2\u0006\u0010\u001D\u001A\u00020\u0006J\u0010\u0010\'\u001A\u00020(2\u0006\u0010\u001D\u001A\u00020\u0006H\u0002J7\u0010&\u001A\u00020\u001B2\u0006\u0010\u001D\u001A\u00020\u00062\u0017\u0010)\u001A\u0013\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u001B0*¢\u0006\u0002\b,H\u0086\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001J\u000E\u0010-\u001A\u00020\u001B2\u0006\u0010\u001D\u001A\u00020\u0006J\u0010\u0010.\u001A\u00020(2\u0006\u0010\u001D\u001A\u00020\u0006H\u0002J\u0011\u0010/\u001A\u00020\n2\u0006\u00100\u001A\u00020\nH\u0082\bJ\u0006\u00101\u001A\u00020\u001BJ\u000E\u00102\u001A\u00020\u001B2\u0006\u00103\u001A\u00020\u0000J&\u00104\u001A\u00020\u001B2\u001B\u00105\u001A\u0017\u0012\b\u0012\u000606R\u00020\u0000\u0012\u0004\u0012\u00020\u001B0*¢\u0006\u0002\b,H\u0086\bJ&\u00107\u001A\u00020\u001B2\u001B\u00108\u001A\u0017\u0012\b\u0012\u000606R\u00020\u0000\u0012\u0004\u0012\u00020\u001B0*¢\u0006\u0002\b,H\u0086\bJ,\u00109\u001A\u00020\u001B2\n\u0010:\u001A\u0006\u0012\u0002\b\u00030;2\u0006\u0010<\u001A\u00020=2\u0006\u0010>\u001A\u00020?2\b\u0010@\u001A\u0004\u0018\u00010AJ\f\u0010B\u001A\u00020(*\u00020(H\u0002J\t\u0010C\u001A\u00020\u0006H\u0082\bJ\u0015\u0010D\u001A\u00020\n2\n\u0010E\u001A\u00060\nj\u0002`FH\u0082\bJ\u001C\u0010G\u001A\u00020\n2\n\u0010E\u001A\u0006\u0012\u0002\b\u00030HH\u0082\b¢\u0006\u0004\bI\u0010JJ\b\u0010K\u001A\u00020(H\u0017J\u0010\u0010L\u001A\u00020(2\u0006\u0010M\u001A\u00020(H\u0016J\u0018\u0010N\u001A\u00020(*\u000606R\u00020\u00002\u0006\u0010M\u001A\u00020(H\u0002J\u0016\u0010O\u001A\u00020(*\u0004\u0018\u00010\u000F2\u0006\u0010M\u001A\u00020(H\u0002J \u0010P\u001A\u00020(\"\u0004\b\u0000\u0010Q*\b\u0012\u0004\u0012\u0002HQ0R2\u0006\u0010M\u001A\u00020(H\u0002R \u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00058\u0000@\u0000X\u0081\u000E¢\u0006\n\n\u0002\u0010\b\u0012\u0004\b\u0007\u0010\u0003R\u0012\u0010\t\u001A\u00020\n8\u0000@\u0000X\u0081\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u000B\u001A\u00020\f8\u0000@\u0000X\u0081\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001A\u00020\n8\u0000@\u0000X\u0081\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\u000E\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u000F0\u00058\u0000@\u0000X\u0081\u000E¢\u0006\u0004\n\u0002\u0010\u0010R\u0012\u0010\u0011\u001A\u00020\n8\u0000@\u0000X\u0081\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001A\u00020\n8F¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016¨\u0006U"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operations;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationsDebugStringFormattable;", "<init>", "()V", "opCodes", "", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "getOpCodes$runtime$annotations", "[Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "opCodesSize", "", "intArgs", "", "intArgsSize", "objectArgs", "", "[Ljava/lang/Object;", "objectArgsSize", "pushedIntMask", "pushedObjectMask", "size", "getSize", "()I", "isEmpty", "", "isNotEmpty", "clear", "", "pushOp", "operation", "determineNewSize", "currentSize", "requiredSize", "resizeOpCodes", "ensureIntArgsSizeAtLeast", "resizeIntArgs", "ensureObjectArgsSizeAtLeast", "resizeObjectArgs", "push", "exceptionMessageForOperationPushNoScope", "", "args", "Lkotlin/Function1;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operations$WriteScope;", "Lkotlin/ExtensionFunctionType;", "ensureAllArgumentsPushedFor", "exceptionMessageForOperationPushWithScope", "createExpectedArgMask", "paramCount", "pop", "popInto", "other", "drain", "sink", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operations$OpIterator;", "forEach", "action", "executeAndFlushAllPendingOperations", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "indent", "peekOperation", "topIntIndexOf", "parameter", "Landroidx/compose/runtime/composer/gapbuffer/changelist/IntParameter;", "topObjectIndexOf", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$ObjectParameter;", "topObjectIndexOf-PtL-UHM", "(I)I", "toString", "toDebugString", "linePrefix", "currentOpToDebugString", "formatOpArgumentToString", "toCollectionString", "T", "", "WriteScope", "OpIterator", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Operations extends OperationsDebugStringFormattable {
    @Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001A\u00020\tJ\u0014\u0010\u000E\u001A\u00020\u00052\n\u0010\u000F\u001A\u00060\u0005j\u0002`\u0010H\u0016J#\u0010\u0011\u001A\u0002H\u0012\"\u0004\b\u0000\u0010\u00122\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u0002H\u00120\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0016\u001A\u00020\u0017R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001A\u00020\u000B8F¢\u0006\u0006\u001A\u0004\b\f\u0010\r¨\u0006\u0018"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operations$OpIterator;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationArgContainer;", "<init>", "(Landroidx/compose/runtime/composer/gapbuffer/changelist/Operations;)V", "opIdx", "", "intIdx", "objIdx", "next", "", "operation", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "getOperation", "()Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "getInt", "parameter", "Landroidx/compose/runtime/composer/gapbuffer/changelist/IntParameter;", "getObject", "T", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$ObjectParameter;", "getObject-PtL-UHM", "(I)Ljava/lang/Object;", "currentOperationDebugString", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class OpIterator implements OperationArgContainer {
        private int intIdx;
        private int objIdx;
        private int opIdx;

        public OpIterator(Operations arg1) {
            Operations.this = arg1;
            super();
        }

        public final String currentOperationDebugString() {
            Operations v0 = Operations.this;
            StringBuilder v1 = new StringBuilder("operation[");
            v1.append(this.opIdx);
            v1.append("] = ");
            v1.append(v0.currentOpToDebugString(this, ""));
            return v1.toString();
        }

        public int getInt(int arg2) {
            return Operations.this.intArgs[this.intIdx + arg2];
        }

        public Object getObject-PtL-UHM(int arg2) {
            return Operations.this.objectArgs[this.objIdx + arg2];
        }

        public final Operation getOperation() {
            return Operations.this.opCodes[this.opIdx];
        }

        public final boolean next() {
            if(this.opIdx >= Operations.this.opCodesSize) {
                return 0;
            }

            Operation v0 = this.getOperation();
            this.intIdx += v0.getInts();
            this.objIdx += v0.getObjects();
            int v0_1 = this.opIdx + 1;
            this.opIdx = v0_1;
            if(v0_1 < Operations.this.opCodesSize) {
                return 1;
            }

            return 0;
        }
    }

    @Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0087@\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\n\u001A\u00020\u000B2\n\u0010\f\u001A\u00060\rj\u0002`\u000E2\u0006\u0010\u000F\u001A\u00020\rH\u0086\b¢\u0006\u0004\b\u0010\u0010\u0011J8\u0010\u0012\u001A\u00020\u000B2\n\u0010\u0013\u001A\u00060\rj\u0002`\u000E2\u0006\u0010\u0014\u001A\u00020\r2\n\u0010\u0015\u001A\u00060\rj\u0002`\u000E2\u0006\u0010\u0016\u001A\u00020\rH\u0086\b¢\u0006\u0004\b\u0017\u0010\u0018JL\u0010\u0012\u001A\u00020\u000B2\n\u0010\u0013\u001A\u00060\rj\u0002`\u000E2\u0006\u0010\u0014\u001A\u00020\r2\n\u0010\u0015\u001A\u00060\rj\u0002`\u000E2\u0006\u0010\u0016\u001A\u00020\r2\n\u0010\u0019\u001A\u00060\rj\u0002`\u000E2\u0006\u0010\u001A\u001A\u00020\rH\u0086\b¢\u0006\u0004\b\u0017\u0010\u001BJ)\u0010\u001C\u001A\u00020\u000B\"\u0004\b\u0000\u0010\u001D2\f\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\u001D0\u001E2\u0006\u0010\u000F\u001A\u0002H\u001D¢\u0006\u0004\b\u001F\u0010 JE\u0010!\u001A\u00020\u000B\"\u0004\b\u0000\u0010\u001D\"\u0004\b\u0001\u0010\"2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u001D0\u001E2\u0006\u0010\u0014\u001A\u0002H\u001D2\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u0002H\"0\u001E2\u0006\u0010\u0016\u001A\u0002H\"¢\u0006\u0004\b#\u0010$Ja\u0010!\u001A\u00020\u000B\"\u0004\b\u0000\u0010\u001D\"\u0004\b\u0001\u0010\"\"\u0004\b\u0002\u0010%2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u001D0\u001E2\u0006\u0010\u0014\u001A\u0002H\u001D2\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u0002H\"0\u001E2\u0006\u0010\u0016\u001A\u0002H\"2\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u0002H%0\u001E2\u0006\u0010\u001A\u001A\u0002H%¢\u0006\u0004\b&\u0010\'J}\u0010!\u001A\u00020\u000B\"\u0004\b\u0000\u0010\u001D\"\u0004\b\u0001\u0010\"\"\u0004\b\u0002\u0010%\"\u0004\b\u0003\u0010(2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u001D0\u001E2\u0006\u0010\u0014\u001A\u0002H\u001D2\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u0002H\"0\u001E2\u0006\u0010\u0016\u001A\u0002H\"2\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u0002H%0\u001E2\u0006\u0010\u001A\u001A\u0002H%2\f\u0010)\u001A\b\u0012\u0004\u0012\u0002H(0\u001E2\u0006\u0010*\u001A\u0002H(¢\u0006\u0004\b+\u0010,J\u0014\u0010-\u001A\u00020.2\b\u0010/\u001A\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00100\u001A\u00020\rHÖ\u0081\u0004J\n\u00101\u001A\u000202HÖ\u0081\u0004R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\b\u0010\t\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u00063"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/Operations$WriteScope;", "", "stack", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operations;", "constructor-impl", "(Landroidx/compose/runtime/composer/gapbuffer/changelist/Operations;)Landroidx/compose/runtime/composer/gapbuffer/changelist/Operations;", "operation", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "getOperation-impl", "(Landroidx/compose/runtime/composer/gapbuffer/changelist/Operations;)Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation;", "setInt", "", "parameter", "", "Landroidx/compose/runtime/composer/gapbuffer/changelist/IntParameter;", "value", "setInt-impl", "(Landroidx/compose/runtime/composer/gapbuffer/changelist/Operations;II)V", "setInts", "parameter1", "value1", "parameter2", "value2", "setInts-impl", "(Landroidx/compose/runtime/composer/gapbuffer/changelist/Operations;IIII)V", "parameter3", "value3", "(Landroidx/compose/runtime/composer/gapbuffer/changelist/Operations;IIIIII)V", "setObject", "T", "Landroidx/compose/runtime/composer/gapbuffer/changelist/Operation$ObjectParameter;", "setObject-sGr0YRc", "(Landroidx/compose/runtime/composer/gapbuffer/changelist/Operations;ILjava/lang/Object;)V", "setObjects", "U", "setObjects-EsEZvaA", "(Landroidx/compose/runtime/composer/gapbuffer/changelist/Operations;ILjava/lang/Object;ILjava/lang/Object;)V", "V", "setObjects-JOGOPjs", "(Landroidx/compose/runtime/composer/gapbuffer/changelist/Operations;ILjava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;)V", "W", "parameter4", "value4", "setObjects-fiWQlIY", "(Landroidx/compose/runtime/composer/gapbuffer/changelist/Operations;ILjava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;)V", "equals", "", "other", "hashCode", "toString", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) @JvmInline public final class WriteScope {
        private final Operations stack;

        private WriteScope(Operations arg1) {
            super();
            this.stack = arg1;
        }

        public static final WriteScope box-impl(Operations arg1) {
            return new WriteScope(arg1);
        }

        public static Operations constructor-impl(Operations arg0) {
            return arg0;
        }

        public boolean equals(Object arg1) {
            return WriteScope.equals-impl(this.stack, arg1);
        }

        public static boolean equals-impl(Operations arg2, Object arg3) {
            if(!(arg3 instanceof WriteScope)) {
                return 0;
            }

            if(!Intrinsics.areEqual(arg2, ((WriteScope)arg3).unbox-impl())) {
                return 0;
            }

            return 1;
        }

        public static final boolean equals-impl0(Operations arg0, Operations arg1) {
            return Intrinsics.areEqual(arg0, arg1);
        }

        public static final Operation getOperation-impl(Operations arg1) {
            return arg1.opCodes[arg1.opCodesSize - 1];
        }

        public int hashCode() {
            return WriteScope.hashCode-impl(this.stack);
        }

        public static int hashCode-impl(Operations arg0) {
            return arg0.hashCode();
        }

        public static final void setInt-impl(Operations arg3, int arg4, int arg5) {
            arg3.intArgs[arg3.intArgsSize - arg3.opCodes[arg3.opCodesSize - 1].getInts() + arg4] = arg5;
        }

        public static final void setInts-impl(Operations arg3, int arg4, int arg5, int arg6, int arg7) {
            int v0 = arg3.intArgsSize - arg3.opCodes[arg3.opCodesSize - 1].getInts();
            int[] v3 = arg3.intArgs;
            v3[arg4 + v0] = arg5;
            v3[v0 + arg6] = arg7;
        }

        public static final void setInts-impl(Operations arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9) {
            int v0 = arg3.intArgsSize - arg3.opCodes[arg3.opCodesSize - 1].getInts();
            int[] v3 = arg3.intArgs;
            v3[arg4 + v0] = arg5;
            v3[arg6 + v0] = arg7;
            v3[v0 + arg8] = arg9;
        }

        public static final void setObject-sGr0YRc(Operations arg3, int arg4, Object arg5) {
            arg3.objectArgs[arg3.objectArgsSize - arg3.opCodes[arg3.opCodesSize - 1].getObjects() + arg4] = arg5;
        }

        public static final void setObjects-EsEZvaA(Operations arg3, int arg4, Object arg5, int arg6, Object arg7) {
            int v0 = arg3.objectArgsSize - arg3.opCodes[arg3.opCodesSize - 1].getObjects();
            Object[] v3 = arg3.objectArgs;
            v3[arg4 + v0] = arg5;
            v3[v0 + arg6] = arg7;
        }

        public static final void setObjects-JOGOPjs(Operations arg3, int arg4, Object arg5, int arg6, Object arg7, int arg8, Object arg9) {
            int v0 = arg3.objectArgsSize - arg3.opCodes[arg3.opCodesSize - 1].getObjects();
            Object[] v3 = arg3.objectArgs;
            v3[arg4 + v0] = arg5;
            v3[arg6 + v0] = arg7;
            v3[v0 + arg8] = arg9;
        }

        public static final void setObjects-fiWQlIY(Operations arg3, int arg4, Object arg5, int arg6, Object arg7, int arg8, Object arg9, int arg10, Object arg11) {
            int v0 = arg3.objectArgsSize - arg3.opCodes[arg3.opCodesSize - 1].getObjects();
            Object[] v3 = arg3.objectArgs;
            v3[arg4 + v0] = arg5;
            v3[arg6 + v0] = arg7;
            v3[arg8 + v0] = arg9;
            v3[v0 + arg10] = arg11;
        }

        public String toString() {
            return WriteScope.toString-impl(this.stack);
        }

        public static String toString-impl(Operations arg2) {
            return "WriteScope(stack=" + arg2 + ')';
        }

        public final Operations unbox-impl() {
            return this.stack;
        }
    }

    public static final int $stable = 8;
    public int[] intArgs;
    public int intArgsSize;
    public Object[] objectArgs;
    public int objectArgsSize;
    public Operation[] opCodes;
    public int opCodesSize;
    private int pushedIntMask;
    private int pushedObjectMask;

    static {
    }

    public Operations() {
        super();
        this.opCodes = new Operation[16];
        this.intArgs = new int[16];
        this.objectArgs = new Object[16];
    }

    public static final String access$currentOpToDebugString(Operations arg0, OpIterator arg1, String arg2) {
        return arg0.currentOpToDebugString(arg1, arg2);
    }

    public static final int access$getPushedIntMask$p(Operations arg0) {
        return arg0.pushedIntMask;
    }

    public static final int access$getPushedObjectMask$p(Operations arg0) {
        return arg0.pushedObjectMask;
    }

    public static final void access$setPushedIntMask$p(Operations arg0, int arg1) {
        arg0.pushedIntMask = arg1;
    }

    public static final void access$setPushedObjectMask$p(Operations arg0, int arg1) {
        arg0.pushedObjectMask = arg1;
    }

    public final void clear() {
        this.opCodesSize = 0;
        this.intArgsSize = 0;
        ArraysKt.fill(this.objectArgs, null, 0, this.objectArgsSize);
        this.objectArgsSize = 0;
    }

    private final int createExpectedArgMask(int arg1) {
        int v0 = arg1 == 0 ? 0 : -1;
        return v0 >>> 0x20 - arg1;
    }

    private final String currentOpToDebugString(OpIterator arg13, String arg14) {
        char v9;
        String v8;
        String v7;
        Operation v0 = arg13.getOperation();
        if(v0.getInts() == 0 && v0.getObjects() == 0) {
            return v0.getName();
        }

        StringBuilder v1 = new StringBuilder();
        v1.append(v0.getName());
        v1.append('(');
        String v2 = this.indent(arg14);
        int v3 = v0.getInts();
        int v4 = 1;
        int v6;
        for(v6 = 0; true; ++v6) {
            v7 = " = ";
            v8 = ", ";
            v9 = '\n';
            if(v6 >= v3) {
                break;
            }

            String v10 = v0.intParamName(v6);
            if(v4 == 0) {
                v1.append(v8);
            }
            else {
                v4 = 0;
            }

            v1.append(v9);
            v1.append(v2);
            v1.append(v10);
            v1.append(v7);
            v1.append(arg13.getInt(v6));
        }

        v3 = v0.getObjects();
        for(v6 = 0; v6 < v3; ++v6) {
            int v10_1 = ObjectParameter.constructor-impl(v6);
            String v11 = v0.objectParamName-PtL-UHM(v10_1);
            if(v4 == 0) {
                v1.append(v8);
            }
            else {
                v4 = 0;
            }

            v1.append(v9);
            v1.append(v2);
            v1.append(v11);
            v1.append(v7);
            v1.append(this.formatOpArgumentToString(arg13.getObject-PtL-UHM(v10_1), v2));
        }

        v1.append(v9);
        v1.append(arg14);
        v1.append(")");
        return v1.toString();
    }

    private final int determineNewSize(int arg1, int arg2) {
        return RangesKt.coerceAtLeast(arg1 + RangesKt.coerceAtMost(arg1, 0x400), arg2);
    }

    public final void drain(Function1 arg3) {
        if(this.isNotEmpty()) {
            OpIterator v0 = new OpIterator(this);
            do {
                arg3.invoke(v0);
                if(v0.next()) {
                    continue;
                }

                break;
            }
            while(true);
        }

        this.clear();
    }

    public final void ensureAllArgumentsPushedFor(Operation arg3) {
        int v2 = this.pushedIntMask;
        int v0 = arg3.getInts();
        int v1 = v0 == 0 ? 0 : -1;
        if(v2 == v1 >>> 0x20 - v0) {
            arg3.getObjects();
        }
    }

    private final void ensureIntArgsSizeAtLeast(int arg2) {
        int v0 = this.intArgs.length;
        if(arg2 > v0) {
            this.resizeIntArgs(v0, arg2);
        }
    }

    private final void ensureObjectArgsSizeAtLeast(int arg2) {
        int v0 = this.objectArgs.length;
        if(arg2 > v0) {
            this.resizeObjectArgs(v0, arg2);
        }
    }

    private final String exceptionMessageForOperationPushNoScope(Operation arg2) {
        return "Cannot push " + arg2 + " without arguments because it expects " + arg2.getInts() + " ints and " + arg2.getObjects() + " objects.";
    }

    private final String exceptionMessageForOperationPushWithScope(Operation arg11) {
        String v5;
        StringBuilder v0 = new StringBuilder();
        int v1 = arg11.getInts();
        int v2 = 0;
        int v3 = 0;
        int v4 = 0;
        while(true) {
            v5 = ", ";
            if(v3 >= v1) {
                break;
            }

            if((1 << v3 & this.pushedIntMask) == 0) {
                if(v4 > 0) {
                    v0.append(v5);
                }

                v0.append(arg11.intParamName(v3));
                ++v4;
            }

            ++v3;
        }

        String v0_1 = v0.toString();
        StringBuilder v1_1 = new StringBuilder();
        v3 = arg11.getObjects();
        int v7 = 0;
        while(v2 < v3) {
            if((1 << v2 & this.pushedObjectMask) == 0) {
                if(v4 > 0) {
                    v1_1.append(v5);
                }

                v1_1.append(arg11.objectParamName-PtL-UHM(ObjectParameter.constructor-impl(v2)));
                ++v7;
            }

            ++v2;
        }

        return "Error while pushing " + arg11 + ". Not all arguments were provided. Missing " + v4 + " int arguments (" + v0_1 + ") and " + v7 + " object arguments (" + v1_1.toString() + ").";
    }

    public final void executeAndFlushAllPendingOperations(Applier arg8, SlotWriter arg9, RememberManager arg10, OperationErrorContext arg11) {
        if(this.isNotEmpty()) {
            OpIterator v0 = new OpIterator(this);
            while(true) {
                Applier v3 = arg8;
                SlotWriter v4 = arg9;
                RememberManager v5 = arg10;
                OperationErrorContext v6 = arg11;
                v0.getOperation().executeWithComposeStackTrace(v0, v3, v4, v5, v6);
                if(!v0.next()) {
                    break;
                }

                arg8 = v3;
                arg9 = v4;
                arg10 = v5;
                arg11 = v6;
            }
        }

        this.clear();
    }

    public final void forEach(Function1 arg2) {
        if(this.isNotEmpty()) {
            OpIterator v0 = new OpIterator(this);
            do {
                arg2.invoke(v0);
                if(v0.next()) {
                    continue;
                }

                return;
            }
            while(true);
        }
    }

    private final String formatOpArgumentToString(Object arg2, String arg3) {
        if(arg2 == null) {
            return "null";
        }

        if((arg2 instanceof Object[])) {
            return this.toCollectionString(ArraysKt.asIterable(((Object[])arg2)), arg3);
        }

        if((arg2 instanceof int[])) {
            return this.toCollectionString(ArraysKt.asIterable(((int[])arg2)), arg3);
        }

        if((arg2 instanceof long[])) {
            return this.toCollectionString(ArraysKt.asIterable(((long[])arg2)), arg3);
        }

        if((arg2 instanceof float[])) {
            return this.toCollectionString(ArraysKt.asIterable(((float[])arg2)), arg3);
        }

        if((arg2 instanceof double[])) {
            return this.toCollectionString(ArraysKt.asIterable(((double[])arg2)), arg3);
        }

        if((arg2 instanceof Iterable)) {
            return this.toCollectionString(((Iterable)arg2), arg3);
        }

        if((arg2 instanceof OperationsDebugStringFormattable)) {
            return ((OperationsDebugStringFormattable)arg2).toDebugString(arg3);
        }

        return arg2.toString();
    }

    public static void getOpCodes$runtime$annotations() {
    }

    public final int getSize() {
        return this.opCodesSize;
    }

    private final String indent(String arg1) {
        return arg1 + "    ";
    }

    public final boolean isEmpty() {
        if(this.getSize() == 0) {
            return 1;
        }

        return 0;
    }

    public final boolean isNotEmpty() {
        if(this.getSize() != 0) {
            return 1;
        }

        return 0;
    }

    private final Operation peekOperation() {
        return this.opCodes[this.opCodesSize - 1];
    }

    public final void pop() {
        Operation[] v0 = this.opCodes;
        int v1 = this.opCodesSize - 1;
        this.opCodesSize = v1;
        Operation v2 = v0[v1];
        Operation v3 = null;
        v0[v1] = v3;
        int v0_1 = v2.getObjects();
        for(v1 = 0; v1 < v0_1; ++v1) {
            Object[] v4 = this.objectArgs;
            int v5 = this.objectArgsSize - 1;
            this.objectArgsSize = v5;
            v4[v5] = v3;
        }

        this.intArgsSize -= v2.getInts();
    }

    public final void popInto(Operations arg8) {
        Operation[] v0 = this.opCodes;
        int v1 = this.opCodesSize - 1;
        this.opCodesSize = v1;
        Operation v2 = v0[v1];
        v0[v1] = null;
        arg8.pushOp(v2);
        Object[] v0_1 = this.objectArgs;
        Object[] v1_1 = arg8.objectArgs;
        int v4 = arg8.objectArgsSize - v2.getObjects();
        int v5 = this.objectArgsSize - v2.getObjects();
        System.arraycopy(v0_1, v5, v1_1, v4, this.objectArgsSize - v5);
        ArraysKt.fill(this.objectArgs, null, this.objectArgsSize - v2.getObjects(), this.objectArgsSize);
        ArraysKt.copyInto(this.intArgs, arg8.intArgs, arg8.intArgsSize - v2.getInts(), this.intArgsSize - v2.getInts(), this.intArgsSize);
        this.objectArgsSize -= v2.getObjects();
        this.intArgsSize -= v2.getInts();
    }

    public final void push(Operation arg1) {
        this.pushOp(arg1);
    }

    public final void push(Operation arg2, Function1 arg3) {
        this.pushOp(arg2);
        arg3.invoke(WriteScope.box-impl(WriteScope.constructor-impl(this)));
        this.ensureAllArgumentsPushedFor(arg2);
    }

    public final void pushOp(Operation arg4) {
        if(this.opCodesSize == this.opCodes.length) {
            this.resizeOpCodes();
        }

        int v0 = this.intArgsSize + arg4.getInts();
        int v1 = this.intArgs.length;
        if(v0 > v1) {
            this.resizeIntArgs(v1, v0);
        }

        v0 = this.objectArgsSize + arg4.getObjects();
        v1 = this.objectArgs.length;
        if(v0 > v1) {
            this.resizeObjectArgs(v1, v0);
        }

        Operation[] v0_1 = this.opCodes;
        v1 = this.opCodesSize;
        this.opCodesSize = v1 + 1;
        v0_1[v1] = arg4;
        this.intArgsSize += arg4.getInts();
        this.objectArgsSize += arg4.getObjects();
    }

    private final void resizeIntArgs(int arg3, int arg4) {
        int[] v4 = new int[this.determineNewSize(arg3, arg4)];
        ArraysKt.copyInto(this.intArgs, v4, 0, 0, arg3);
        this.intArgs = v4;
    }

    private final void resizeObjectArgs(int arg3, int arg4) {
        Object[] v4 = new Object[this.determineNewSize(arg3, arg4)];
        System.arraycopy(this.objectArgs, 0, v4, 0, arg3);
        this.objectArgs = v4;
    }

    private final void resizeOpCodes() {
        int v0 = RangesKt.coerceAtMost(this.opCodesSize, 0x400);
        int v1 = this.opCodesSize;
        Operation[] v0_1 = new Operation[v0 + v1];
        System.arraycopy(this.opCodes, 0, v0_1, 0, v1);
        this.opCodes = v0_1;
    }

    private final String toCollectionString(Iterable arg11, String arg12) {
        return CollectionsKt.joinToString$default(arg11, ", ", "[", "]", 0, null, new Operations$$ExternalSyntheticLambda0(this, arg12), 24, null);
    }

    static final CharSequence toCollectionString$lambda$0(Operations arg0, String arg1, Object arg2) {
        return arg0.formatOpArgumentToString(arg2, arg1);
    }

    public String toDebugString(String arg6) {
        StringBuilder v0 = new StringBuilder();
        if(this.isNotEmpty()) {
            OpIterator v1 = new OpIterator(this);
            int v2;
            for(v2 = 0; true; v2 = v3) {
                v0.append(arg6);
                int v3 = v2 + 1;
                v0.append(v2);
                v0.append(". ");
                v0.append(this.currentOpToDebugString(v1, arg6)).append('\n');
                if(!v1.next()) {
                    break;
                }
            }
        }

        return v0.toString();
    }

    @Deprecated(message="toString() will return the default implementation from Any. Did you mean to use toDebugString()?", replaceWith="<_subannotation>") public String toString() {
        return super.toString();
    }

    private final int topIntIndexOf(int arg3) {
        return this.intArgsSize - this.opCodes[this.opCodesSize - 1].getInts() + arg3;
    }

    private final int topObjectIndexOf-PtL-UHM(int arg3) {
        return this.objectArgsSize - this.opCodes[this.opCodesSize - 1].getObjects() + arg3;
    }
}

