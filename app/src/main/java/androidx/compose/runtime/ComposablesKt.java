package androidx.compose.runtime;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u008C\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A)\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0013\b\u0004\u0010\u0002\u001A\r\u0012\u0004\u0012\u0002H\u00010\u0003¢\u0006\u0002\b\u0004H\u0087\b¢\u0006\u0002\u0010\u0005\u001A3\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\b\u0010\u0006\u001A\u0004\u0018\u00010\u00072\u0013\b\u0004\u0010\u0002\u001A\r\u0012\u0004\u0012\u0002H\u00010\u0003¢\u0006\u0002\b\u0004H\u0087\b¢\u0006\u0002\u0010\b\u001A=\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\b\u0010\u0006\u001A\u0004\u0018\u00010\u00072\b\u0010\t\u001A\u0004\u0018\u00010\u00072\u0013\b\u0004\u0010\u0002\u001A\r\u0012\u0004\u0012\u0002H\u00010\u0003¢\u0006\u0002\b\u0004H\u0087\b¢\u0006\u0002\u0010\n\u001AG\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\b\u0010\u0006\u001A\u0004\u0018\u00010\u00072\b\u0010\t\u001A\u0004\u0018\u00010\u00072\b\u0010\u000B\u001A\u0004\u0018\u00010\u00072\u0013\b\u0004\u0010\u0002\u001A\r\u0012\u0004\u0012\u0002H\u00010\u0003¢\u0006\u0002\b\u0004H\u0087\b¢\u0006\u0002\u0010\f\u001AA\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0016\u0010\r\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u000E\"\u0004\u0018\u00010\u00072\u0013\b\u0004\u0010\u0002\u001A\r\u0012\u0004\u0012\u0002H\u00010\u0003¢\u0006\u0002\b\u0004H\u0087\b¢\u0006\u0002\u0010\u000F\u001A?\u0010\u0010\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0016\u0010\r\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u000E\"\u0004\u0018\u00010\u00072\u0011\u0010\u0011\u001A\r\u0012\u0004\u0012\u0002H\u00010\u0003¢\u0006\u0002\b\u0012H\u0087\b¢\u0006\u0002\u0010\u0013\u001A+\u0010\u0014\u001A\u00020\u00152\b\u0010\u0010\u001A\u0004\u0018\u00010\u00072\u0011\u0010\u0016\u001A\r\u0012\u0004\u0012\u00020\u00150\u0003¢\u0006\u0002\b\u0012H\u0087\b¢\u0006\u0002\u0010\u0017\u001A+\u0010\u0018\u001A\u00020\u00152\u0006\u0010\u0019\u001A\u00020\u001A2\u0013\b\u0004\u0010\u0016\u001A\r\u0012\u0004\u0012\u00020\u00150\u0003¢\u0006\u0002\b\u0012H\u0087\b¢\u0006\u0002\u0010\u001B\u001A\\\u00109\u001A\u00020\u0015\"\b\b\u0000\u0010\u0001*\u00020\u0007\"\u000E\b\u0001\u0010:\u0018\u0001*\u0006\u0012\u0002\b\u00030;2\u000E\b\b\u0010<\u001A\b\u0012\u0004\u0012\u0002H\u00010\u00032\"\u0010=\u001A\u001E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010?\u0012\u0004\u0012\u00020\u00150>¢\u0006\u0002\b\u0004¢\u0006\u0002\b@H\u0087\b¢\u0006\u0002\u0010A\u001A\\\u0010B\u001A\u00020\u0015\"\b\b\u0000\u0010\u0001*\u00020\u0007\"\u000E\b\u0001\u0010:\u0018\u0001*\u0006\u0012\u0002\b\u00030;2\u000E\b\b\u0010<\u001A\b\u0012\u0004\u0012\u0002H\u00010\u00032\"\u0010=\u001A\u001E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010?\u0012\u0004\u0012\u00020\u00150>¢\u0006\u0002\b\u0004¢\u0006\u0002\b@H\u0087\b¢\u0006\u0002\u0010A\u001Aq\u00109\u001A\u00020\u0015\"\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u0007\"\u000E\b\u0001\u0010:\u0018\u0001*\u0006\u0012\u0002\b\u00030;2\u000E\b\b\u0010<\u001A\b\u0012\u0004\u0012\u0002H\u00010\u00032\"\u0010=\u001A\u001E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010?\u0012\u0004\u0012\u00020\u00150>¢\u0006\u0002\b\u0004¢\u0006\u0002\b@2\u0011\u0010\u0016\u001A\r\u0012\u0004\u0012\u00020\u00150\u0003¢\u0006\u0002\b\u0012H\u0087\b¢\u0006\u0002\u0010C\u001Aq\u0010B\u001A\u00020\u0015\"\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u0007\"\u000E\b\u0001\u0010:\u0018\u0001*\u0006\u0012\u0002\b\u00030;2\u000E\b\b\u0010<\u001A\b\u0012\u0004\u0012\u0002H\u00010\u00032\"\u0010=\u001A\u001E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010?\u0012\u0004\u0012\u00020\u00150>¢\u0006\u0002\b\u0004¢\u0006\u0002\b@2\u0011\u0010\u0016\u001A\r\u0012\u0004\u0012\u00020\u00150\u0003¢\u0006\u0002\b\u0012H\u0087\b¢\u0006\u0002\u0010C\u001A\u0091\u0001\u00109\u001A\u00020\u0015\"\u0004\b\u0000\u0010\u0001\"\u000E\b\u0001\u0010:\u0018\u0001*\u0006\u0012\u0002\b\u00030;2\u000E\b\b\u0010<\u001A\b\u0012\u0004\u0012\u0002H\u00010\u00032\"\u0010=\u001A\u001E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010?\u0012\u0004\u0012\u00020\u00150>¢\u0006\u0002\b\u0004¢\u0006\u0002\b@2$\b\b\u0010D\u001A\u001E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010E\u0012\u0004\u0012\u00020\u00150>¢\u0006\u0002\b\u0012¢\u0006\u0002\b@2\u0011\u0010\u0016\u001A\r\u0012\u0004\u0012\u00020\u00150\u0003¢\u0006\u0002\b\u0012H\u0087\b¢\u0006\u0002\u0010F\u001A\u0091\u0001\u0010B\u001A\u00020\u0015\"\u0004\b\u0000\u0010\u0001\"\u000E\b\u0001\u0010:\u0018\u0001*\u0006\u0012\u0002\b\u00030;2\u000E\b\b\u0010<\u001A\b\u0012\u0004\u0012\u0002H\u00010\u00032\"\u0010=\u001A\u001E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010?\u0012\u0004\u0012\u00020\u00150>¢\u0006\u0002\b\u0004¢\u0006\u0002\b@2$\b\b\u0010D\u001A\u001E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010E\u0012\u0004\u0012\u00020\u00150>¢\u0006\u0002\b\u0012¢\u0006\u0002\b@2\u0011\u0010\u0016\u001A\r\u0012\u0004\u0012\u00020\u00150\u0003¢\u0006\u0002\b\u0012H\u0087\b¢\u0006\u0002\u0010F\u001A\b\u0010G\u001A\u00020\u0015H\u0001\u001A\r\u0010H\u001A\u00020!H\u0007¢\u0006\u0002\u0010%\"\u0011\u0010\u001C\u001A\u00020\u001D8G¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001F\"\u001A\u0010 \u001A\u00020!8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010#\u001A\u0004\b$\u0010%\"\u0011\u0010&\u001A\u00020\'8G¢\u0006\u0006\u001A\u0004\b(\u0010)\"\u0017\u0010*\u001A\u00020+8G¢\u0006\f\u0012\u0004\b,\u0010#\u001A\u0004\b-\u0010.\"\u001A\u0010/\u001A\u0002008GX\u0087\u0004¢\u0006\f\u0012\u0004\b1\u0010#\u001A\u0004\b2\u00103\"\u0015\u00104\u001A\u000605j\u0002`68G¢\u0006\u0006\u001A\u0004\b7\u00108¨\u0006I"}, d2={"remember", "T", "calculation", "Lkotlin/Function0;", "Landroidx/compose/runtime/DisallowComposableCalls;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "key1", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "key2", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "key3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "keys", "", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "key", "block", "Landroidx/compose/runtime/Composable;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "ReusableContent", "", "content", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ReusableContentHost", "active", "", "(ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "currentComposer", "Landroidx/compose/runtime/Composer;", "getCurrentComposer", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/Composer;", "currentCompositionContext", "Landroidx/compose/runtime/CompositionContext;", "getCurrentCompositionContext$annotations", "(Landroidx/compose/runtime/Composer;I)V", "getCurrentCompositionContext", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/CompositionContext;", "currentRecomposeScope", "Landroidx/compose/runtime/RecomposeScope;", "getCurrentRecomposeScope", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/RecomposeScope;", "currentCompositionLocalContext", "Landroidx/compose/runtime/CompositionLocalContext;", "getCurrentCompositionLocalContext$annotations", "getCurrentCompositionLocalContext", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/CompositionLocalContext;", "currentCompositeKeyHash", "", "getCurrentCompositeKeyHash$annotations", "getCurrentCompositeKeyHash", "(Landroidx/compose/runtime/Composer;I)I", "currentCompositeKeyHashCode", "", "Landroidx/compose/runtime/CompositeKeyHashCode;", "getCurrentCompositeKeyHashCode", "(Landroidx/compose/runtime/Composer;I)J", "ComposeNode", "E", "Landroidx/compose/runtime/Applier;", "factory", "update", "Lkotlin/Function1;", "Landroidx/compose/runtime/Updater;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ReusableComposeNode", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "skippableUpdate", "Landroidx/compose/runtime/SkippableUpdater;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "invalidApplier", "rememberCompositionContext", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ComposablesKt {
    public static final void ComposeNode(Function0 arg2, Function1 arg3, Composer arg4, int arg5) {
        ComposerKt.sourceInformationMarkerStart(arg4, 0x7076B8D0, "CC(ComposeNode)N(factory,update):Composables.kt#9igjgp");
        Applier v5 = arg4.getApplier();
        Intrinsics.reifiedOperationMarker(3, "E");
        if(!(v5 instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }

        arg4.startNode();
        if(arg4.getInserting()) {
            arg4.createNode(arg2);
        }
        else {
            arg4.useNode();
        }

        arg3.invoke(Updater.box-impl(Updater.constructor-impl(arg4)));
        arg4.endNode();
        ComposerKt.sourceInformationMarkerEnd(arg4);
    }

    public static final void ComposeNode(Function0 arg3, Function1 arg4, Function2 arg5, Composer arg6, int arg7) {
        ComposerKt.sourceInformationMarkerStart(arg6, 0xB304A10F, "CC(ComposeNode)N(factory,update,content)372@14715L9:Composables.kt#9igjgp");
        Applier v0 = arg6.getApplier();
        Intrinsics.reifiedOperationMarker(3, "E");
        if(!(v0 instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }

        arg6.startNode();
        if(arg6.getInserting()) {
            arg6.createNode(arg3);
        }
        else {
            arg6.useNode();
        }

        arg4.invoke(Updater.box-impl(Updater.constructor-impl(arg6)));
        arg5.invoke(arg6, Integer.valueOf(arg7 >> 6 & 14));
        arg6.endNode();
        ComposerKt.sourceInformationMarkerEnd(arg6);
    }

    public static final void ComposeNode(Function0 arg3, Function1 arg4, Function3 arg5, Function2 arg6, Composer arg7, int arg8) {
        ComposerKt.sourceInformationMarkerStart(arg7, 417406607, "CC(ComposeNode)N(factory,update,skippableUpdate,content)453@18024L17,455@18100L9:Composables.kt#9igjgp");
        Applier v0 = arg7.getApplier();
        Intrinsics.reifiedOperationMarker(3, "E");
        if(!(v0 instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }

        arg7.startNode();
        if(arg7.getInserting()) {
            arg7.createNode(arg3);
        }
        else {
            arg7.useNode();
        }

        arg4.invoke(Updater.box-impl(Updater.constructor-impl(arg7)));
        arg5.invoke(SkippableUpdater.box-impl(SkippableUpdater.constructor-impl(arg7)), arg7, Integer.valueOf(arg8 >> 3 & 0x70));
        arg7.startReplaceableGroup(2058660585);
        arg6.invoke(arg7, Integer.valueOf(arg8 >> 9 & 14));
        arg7.endReplaceableGroup();
        arg7.endNode();
        ComposerKt.sourceInformationMarkerEnd(arg7);
    }

    public static final void ReusableComposeNode(Function0 arg2, Function1 arg3, Composer arg4, int arg5) {
        ComposerKt.sourceInformationMarkerStart(arg4, 1405779621, "CC(ReusableComposeNode)N(factory,update):Composables.kt#9igjgp");
        Applier v5 = arg4.getApplier();
        Intrinsics.reifiedOperationMarker(3, "E");
        if(!(v5 instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }

        arg4.startReusableNode();
        if(arg4.getInserting()) {
            arg4.createNode(arg2);
        }
        else {
            arg4.useNode();
        }

        arg3.invoke(Updater.box-impl(Updater.constructor-impl(arg4)));
        arg4.endNode();
        ComposerKt.sourceInformationMarkerEnd(arg4);
    }

    public static final void ReusableComposeNode(Function0 arg3, Function1 arg4, Function2 arg5, Composer arg6, int arg7) {
        ComposerKt.sourceInformationMarkerStart(arg6, 0xDF082A64, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
        Applier v0 = arg6.getApplier();
        Intrinsics.reifiedOperationMarker(3, "E");
        if(!(v0 instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }

        arg6.startReusableNode();
        if(arg6.getInserting()) {
            arg6.createNode(arg3);
        }
        else {
            arg6.useNode();
        }

        arg4.invoke(Updater.box-impl(Updater.constructor-impl(arg6)));
        arg5.invoke(arg6, Integer.valueOf(arg7 >> 6 & 14));
        arg6.endNode();
        ComposerKt.sourceInformationMarkerEnd(arg6);
    }

    public static final void ReusableComposeNode(Function0 arg3, Function1 arg4, Function3 arg5, Function2 arg6, Composer arg7, int arg8) {
        ComposerKt.sourceInformationMarkerStart(arg7, 0x2F8FAB64, "CC(ReusableComposeNode)N(factory,update,skippableUpdate,content)499@20006L17,501@20082L9:Composables.kt#9igjgp");
        Applier v0 = arg7.getApplier();
        Intrinsics.reifiedOperationMarker(3, "E");
        if(!(v0 instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }

        arg7.startReusableNode();
        if(arg7.getInserting()) {
            arg7.createNode(arg3);
        }
        else {
            arg7.useNode();
        }

        arg4.invoke(Updater.box-impl(Updater.constructor-impl(arg7)));
        arg5.invoke(SkippableUpdater.box-impl(SkippableUpdater.constructor-impl(arg7)), arg7, Integer.valueOf(arg8 >> 3 & 0x70));
        arg7.startReplaceableGroup(2058660585);
        arg6.invoke(arg7, Integer.valueOf(arg8 >> 9 & 14));
        arg7.endReplaceableGroup();
        arg7.endNode();
        ComposerKt.sourceInformationMarkerEnd(arg7);
    }

    public static final void ReusableContent(Object arg2, Function2 arg3, Composer arg4, int arg5) {
        ComposerKt.sourceInformationMarkerStart(arg4, 1800201264, "CC(ReusableContent)N(key,content)143@5486L9:Composables.kt#9igjgp");
        arg4.startReusableGroup(0xCF, arg2);
        arg3.invoke(arg4, Integer.valueOf(arg5 >> 3 & 14));
        arg4.endReusableGroup();
        ComposerKt.sourceInformationMarkerEnd(arg4);
    }

    public static final void ReusableContentHost(boolean arg2, Function2 arg3, Composer arg4, int arg5) {
        ComposerKt.sourceInformationMarkerStart(arg4, 1991829300, "CC(ReusableContentHost)N(active,content)169@6768L9:Composables.kt#9igjgp");
        arg4.startReusableGroup(0xCF, Boolean.valueOf(arg2));
        boolean v0 = arg4.changed(arg2);
        if(arg2) {
            arg3.invoke(arg4, Integer.valueOf(arg5 >> 3 & 14));
        }
        else {
            arg4.deactivateToEndGroup(v0);
        }

        arg4.endReusableGroup();
        ComposerKt.sourceInformationMarkerEnd(arg4);
    }

    public static final Composer getCurrentComposer(Composer arg2, int arg3) {
        int v1 = 0xDEF6D01C;
        ComposerKt.sourceInformationMarkerStart(arg2, v1, "C(<get-currentComposer>):Composables.kt#9igjgp");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg3, -1, "androidx.compose.runtime.<get-currentComposer> (Composables.kt:191)");
        }

        throw new NotImplementedError("Implemented as an intrinsic");
    }

    public static final int getCurrentCompositeKeyHash(Composer arg3, int arg4) {
        int v1 = 0x1F4264F3;
        ComposerKt.sourceInformationMarkerStart(arg3, v1, "C(<get-currentCompositeKeyHash>):Composables.kt#9igjgp");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg4, -1, "androidx.compose.runtime.<get-currentCompositeKeyHash> (Composables.kt:252)");
        }

        arg4 = arg3.getCompoundKeyHash();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return arg4;
    }

    @Deprecated(message="Prefer the higher-precision currentCompositeKeyHashCode", replaceWith="<_subannotation>") public static void getCurrentCompositeKeyHash$annotations(Composer arg0, int arg1) {
    }

    public static final long getCurrentCompositeKeyHashCode(Composer arg3, int arg4) {
        int v1 = 0xF5F890A0;
        ComposerKt.sourceInformationMarkerStart(arg3, v1, "C(<get-currentCompositeKeyHashCode>):Composables.kt#9igjgp");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg4, -1, "androidx.compose.runtime.<get-currentCompositeKeyHashCode> (Composables.kt:268)");
        }

        long v0 = arg3.getCompositeKeyHashCode();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0;
    }

    public static final CompositionContext getCurrentCompositionContext(Composer arg3, int arg4) {
        int v1 = 0x621027D7;
        ComposerKt.sourceInformationMarkerStart(arg3, v1, "C(<get-currentCompositionContext>):Composables.kt#9igjgp");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg4, -1, "androidx.compose.runtime.<get-currentCompositionContext> (Composables.kt:206)");
        }

        ControlledComposition v4 = arg3.getComposition();
        Intrinsics.checkNotNull(v4, "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl");
        CompositionContext v4_1 = ((CompositionImpl)v4).getParent();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v4_1;
    }

    public static void getCurrentCompositionContext$annotations(Composer arg0, int arg1) {
    }

    public static final CompositionLocalContext getCurrentCompositionLocalContext(Composer arg3, int arg4) {
        int v1 = 0xFD6A7EDC;
        ComposerKt.sourceInformationMarkerStart(arg3, v1, "C(<get-currentCompositionLocalContext>):Composables.kt#9igjgp");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg4, -1, "androidx.compose.runtime.<get-currentCompositionLocalContext> (Composables.kt:231)");
        }

        CompositionLocalContext v4 = new CompositionLocalContext(arg3.buildContext().getCompositionLocalScope$runtime());
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v4;
    }

    public static void getCurrentCompositionLocalContext$annotations(Composer arg0, int arg1) {
    }

    public static final RecomposeScope getCurrentRecomposeScope(Composer arg3, int arg4) {
        int v1 = 0x178A93E7;
        ComposerKt.sourceInformationMarkerStart(arg3, v1, "C(<get-currentRecomposeScope>):Composables.kt#9igjgp");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg4, -1, "androidx.compose.runtime.<get-currentRecomposeScope> (Composables.kt:216)");
        }

        RecomposeScope v4 = arg3.getRecomposeScope();
        if(v4 != null) {
            arg3.recordUsed(v4);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            ComposerKt.sourceInformationMarkerEnd(arg3);
            return v4;
        }

        throw new IllegalStateException("no recompose scope found".toString());
    }

    public static final void invalidApplier() {
        throw new IllegalStateException("Invalid applier".toString());
    }

    public static final Object key(Object[] arg1, Function2 arg2, Composer arg3, int arg4) {
        ComposerKt.sourceInformationMarkerStart(arg3, 1839058670, "CC(key)N(keys,block)129@4832L7:Composables.kt#9igjgp");
        Object v1 = arg2.invoke(arg3, Integer.valueOf(arg4 >> 3 & 14));
        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v1;
    }

    public static final Object remember(Object arg1, Object arg2, Object arg3, Function0 arg4, Composer arg5, int arg6) {
        ComposerKt.sourceInformationMarkerStart(arg5, 0x607FB4C4, "CC(remember)N(key1,key2,key3,calculation):Composables.kt#9igjgp");
        int v1 = arg5.changed(arg1) | arg5.changed(arg2) | arg5.changed(arg3);
        arg2 = arg5.rememberedValue();
        if(v1 != 0 || arg2 == Composer.Companion.getEmpty()) {
            arg2 = arg4.invoke();
            arg5.updateRememberedValue(arg2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        return arg2;
    }

    public static final Object remember(Object arg1, Object arg2, Function0 arg3, Composer arg4, int arg5) {
        ComposerKt.sourceInformationMarkerStart(arg4, 0x1E7B2B64, "CC(remember)N(key1,key2,calculation):Composables.kt#9igjgp");
        int v1 = arg4.changed(arg1) | arg4.changed(arg2);
        arg2 = arg4.rememberedValue();
        if(v1 != 0 || arg2 == Composer.Companion.getEmpty()) {
            arg2 = arg3.invoke();
            arg4.updateRememberedValue(arg2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return arg2;
    }

    public static final Object remember(Object arg1, Function0 arg2, Composer arg3, int arg4) {
        ComposerKt.sourceInformationMarkerStart(arg3, 0x44FAF204, "CC(remember)N(key1,calculation):Composables.kt#9igjgp");
        boolean v1 = arg3.changed(arg1);
        Object v4 = arg3.rememberedValue();
        if((v1) || v4 == Composer.Companion.getEmpty()) {
            v4 = arg2.invoke();
            arg3.updateRememberedValue(v4);
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v4;
    }

    public static final Object remember(Function0 arg1, Composer arg2, int arg3) {
        ComposerKt.sourceInformationMarkerStart(arg2, 0xE2A708A4, "CC(remember)N(calculation):Composables.kt#9igjgp");
        Object v3 = arg2.rememberedValue();
        if(v3 == Composer.Companion.getEmpty()) {
            v3 = arg1.invoke();
            arg2.updateRememberedValue(v3);
        }

        ComposerKt.sourceInformationMarkerEnd(arg2);
        return v3;
    }

    public static final Object remember(Object[] arg3, Function0 arg4, Composer arg5, int arg6) {
        ComposerKt.sourceInformationMarkerStart(arg5, 0xDE219177, "CC(remember)N(keys,calculation):Composables.kt#9igjgp");
        arg6 = arg3.length;
        int v0 = 0;
        int v1 = 0;
        while(v0 < arg6) {
            v1 |= arg5.changed(arg3[v0]);
            ++v0;
        }

        Object v3 = arg5.rememberedValue();
        if(v1 != 0 || v3 == Composer.Companion.getEmpty()) {
            v3 = arg4.invoke();
            arg5.updateRememberedValue(v3);
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        return v3;
    }

    public static final CompositionContext rememberCompositionContext(Composer arg3, int arg4) {
        int v1 = 0xBA8383F4;
        ComposerKt.sourceInformationMarkerStart(arg3, v1, "C(rememberCompositionContext):Composables.kt#9igjgp");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg4, -1, "androidx.compose.runtime.rememberCompositionContext (Composables.kt:516)");
        }

        CompositionContext v4 = arg3.buildContext();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v4;
    }
}

