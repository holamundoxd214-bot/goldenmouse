package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.internal.CombineKt;

@Metadata(d1={"\u0000h\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001C\n\u0002\b\u0005\u001A\u0087\u0001\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00040\u00012F\u0010\u0006\u001AB\b\u0001\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000B\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0007H\u0007¢\u0006\u0004\b\u000E\u0010\u000F\u001A\u0087\u0001\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u00022\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u0002H\u00040\u00012F\u0010\u0006\u001AB\b\u0001\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000B\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0007¢\u0006\u0002\u0010\u000F\u001A\u009A\u0001\u0010\u0011\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00040\u00012Y\b\u0001\u0010\u0006\u001AS\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0013\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000B\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0012¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001A\u009A\u0001\u0010\u0011\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u00022\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u0002H\u00040\u00012Y\b\u0001\u0010\u0006\u001AS\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0013\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000B\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0012¢\u0006\u0002\b\u0015¢\u0006\u0002\u0010\u0017\u001A\u0085\u0001\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0018\"\u0004\b\u0003\u0010\u00022\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u0002H\u00180\u000120\b\u0001\u0010\u0006\u001A*\b\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0012¢\u0006\u0002\u0010\u001A\u001A\u0096\u0001\u0010\u0011\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0018\"\u0004\b\u0003\u0010\u00022\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u0002H\u00180\u00012A\b\u0001\u0010\u0006\u001A;\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0013\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u001B¢\u0006\u0002\b\u0015¢\u0006\u0002\u0010\u001C\u001A\u009D\u0001\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0018\"\u0004\b\u0003\u0010\u001D\"\u0004\b\u0004\u0010\u00022\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u0002H\u00180\u00012\f\u0010\u001E\u001A\b\u0012\u0004\u0012\u0002H\u001D0\u000124\u0010\u0006\u001A0\b\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001D\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u001B¢\u0006\u0002\u0010\u001F\u001A°\u0001\u0010\u0011\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0018\"\u0004\b\u0003\u0010\u001D\"\u0004\b\u0004\u0010\u00022\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u0002H\u00180\u00012\f\u0010\u001E\u001A\b\u0012\u0004\u0012\u0002H\u001D0\u00012G\b\u0001\u0010\u0006\u001AA\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0013\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001D\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\f\u0012\u0006\u0012\u0004\u0018\u00010\r0 ¢\u0006\u0002\b\u0015¢\u0006\u0002\u0010!\u001A·\u0001\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0018\"\u0004\b\u0003\u0010\u001D\"\u0004\b\u0004\u0010\"\"\u0004\b\u0005\u0010\u00022\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u0002H\u00180\u00012\f\u0010\u001E\u001A\b\u0012\u0004\u0012\u0002H\u001D0\u00012\f\u0010#\u001A\b\u0012\u0004\u0012\u0002H\"0\u00012:\u0010\u0006\u001A6\b\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001D\u0012\u0004\u0012\u0002H\"\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0 ¢\u0006\u0002\u0010$\u001AÊ\u0001\u0010\u0011\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0018\"\u0004\b\u0003\u0010\u001D\"\u0004\b\u0004\u0010\"\"\u0004\b\u0005\u0010\u00022\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u0002H\u00180\u00012\f\u0010\u001E\u001A\b\u0012\u0004\u0012\u0002H\u001D0\u00012\f\u0010#\u001A\b\u0012\u0004\u0012\u0002H\"0\u00012M\b\u0001\u0010\u0006\u001AG\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0013\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001D\u0012\u0004\u0012\u0002H\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\f\u0012\u0006\u0012\u0004\u0018\u00010\r0%¢\u0006\u0002\b\u0015¢\u0006\u0002\u0010&\u001An\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\'\u0018\u0001\"\u0004\b\u0001\u0010\u00022\u001E\u0010(\u001A\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\'0\u00010)\"\b\u0012\u0004\u0012\u0002H\'0\u00012*\b\u0004\u0010\u0006\u001A$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\'0)\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0*H\u0086\b¢\u0006\u0002\u0010+\u001A\u007F\u0010\u0011\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\'\u0018\u0001\"\u0004\b\u0001\u0010\u00022\u001E\u0010(\u001A\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\'0\u00010)\"\b\u0012\u0004\u0012\u0002H\'0\u00012;\b\u0005\u0010\u0006\u001A5\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\'0)\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0007¢\u0006\u0002\b\u0015H\u0086\b¢\u0006\u0002\u0010,\u001Ap\u0010-\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\'\u0018\u0001\"\u0004\b\u0001\u0010\u00022\u001E\u0010(\u001A\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\'0\u00010)\"\b\u0012\u0004\u0012\u0002H\'0\u00012*\b\u0004\u0010\u0006\u001A$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\'0)\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0*H\u0082\b¢\u0006\u0004\b.\u0010+\u001A\u0081\u0001\u0010/\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\'\u0018\u0001\"\u0004\b\u0001\u0010\u00022\u001E\u0010(\u001A\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\'0\u00010)\"\b\u0012\u0004\u0012\u0002H\'0\u00012;\b\u0005\u0010\u0006\u001A5\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\'0)\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0007¢\u0006\u0002\b\u0015H\u0082\b¢\u0006\u0004\b0\u0010,\u001A!\u00101\u001A\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\'\u0018\u00010)02\"\u0004\b\u0000\u0010\'H\u0002¢\u0006\u0002\b3\u001Ab\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\'\u0018\u0001\"\u0004\b\u0001\u0010\u00022\u0012\u0010(\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\'0\u0001042*\b\u0004\u0010\u0006\u001A$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\'0)\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0*H\u0086\b¢\u0006\u0002\u00105\u001As\u0010\u0011\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\'\u0018\u0001\"\u0004\b\u0001\u0010\u00022\u0012\u0010(\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\'0\u0001042;\b\u0005\u0010\u0006\u001A5\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\'0)\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0007¢\u0006\u0002\b\u0015H\u0086\b¢\u0006\u0002\u00106\u001Ae\u00107\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u00108\u001A\b\u0012\u0004\u0012\u0002H\u00040\u00012(\u0010\u0006\u001A$\b\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0007¢\u0006\u0002\u0010\u000F¨\u00069"}, d2={"combine", "Lkotlinx/coroutines/flow/Flow;", "R", "T1", "T2", "flow", "transform", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "a", "b", "Lkotlin/coroutines/Continuation;", "", "flowCombine", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "flow2", "combineTransform", "Lkotlin/Function4;", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlin/ExtensionFunctionType;", "flowCombineTransform", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "T3", "flow3", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function5;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function5;)Lkotlinx/coroutines/flow/Flow;", "T4", "flow4", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function5;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function6;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function6;)Lkotlinx/coroutines/flow/Flow;", "T5", "flow5", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function6;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function7;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function7;)Lkotlinx/coroutines/flow/Flow;", "T", "flows", "", "Lkotlin/Function2;", "([Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "([Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "combineUnsafe", "combineUnsafe$FlowKt__ZipKt", "combineTransformUnsafe", "combineTransformUnsafe$FlowKt__ZipKt", "nullArrayFactory", "Lkotlin/Function0;", "nullArrayFactory$FlowKt__ZipKt", "", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "zip", "other", "kotlinx-coroutines-core"}, k=5, mv={2, 1, 0}, xi=0x30, xs="kotlinx/coroutines/flow/FlowKt") final class FlowKt__ZipKt {
    public static final Function0 access$nullArrayFactory() {
        return FlowKt__ZipKt.nullArrayFactory$FlowKt__ZipKt();
    }

    public static final Flow combine(Iterable arg1, Function2 arg2) {
        Object[] v1 = CollectionsKt.toList(arg1).toArray(new Flow[0]);
        Intrinsics.needClassReification();
        return new FlowKt__ZipKt$combine$$inlined$unsafeFlow$3(((Flow[])v1), arg2);
    }

    public static final Flow combine(Flow arg0, Flow arg1, Function3 arg2) {
        return FlowKt.flowCombine(arg0, arg1, arg2);
    }

    public static final Flow combine(Flow arg2, Flow arg3, Flow arg4, Function4 arg5) {
        return new FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1(new Flow[]{arg2, arg3, arg4}, arg5);
    }

    public static final Flow combine(Flow arg2, Flow arg3, Flow arg4, Flow arg5, Function5 arg6) {
        return new FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2(new Flow[]{arg2, arg3, arg4, arg5}, arg6);
    }

    public static final Flow combine(Flow arg2, Flow arg3, Flow arg4, Flow arg5, Flow arg6, Function6 arg7) {
        return new FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3(new Flow[]{arg2, arg3, arg4, arg5, arg6}, arg7);
    }

    public static final Flow combine(Flow[] arg1, Function2 arg2) {
        Intrinsics.needClassReification();
        return new FlowKt__ZipKt$combine$$inlined$unsafeFlow$2(arg1, arg2);
    }

    public static final Flow combineTransform(Iterable arg2, Function3 arg3) {
        Object[] v2 = CollectionsKt.toList(arg2).toArray(new Flow[0]);
        Intrinsics.needClassReification();
        return FlowKt.flow(new FlowKt__ZipKt$combineTransform$7(((Flow[])v2), arg3, null));
    }

    public static final Flow combineTransform(Flow arg2, Flow arg3, Function4 arg4) {
        return FlowKt.flow(new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$2(new Flow[]{arg2, arg3}, null, arg4));
    }

    public static final Flow combineTransform(Flow arg2, Flow arg3, Flow arg4, Function5 arg5) {
        return FlowKt.flow(new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3(new Flow[]{arg2, arg3, arg4}, null, arg5));
    }

    public static final Flow combineTransform(Flow arg2, Flow arg3, Flow arg4, Flow arg5, Function6 arg6) {
        return FlowKt.flow(new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$4(new Flow[]{arg2, arg3, arg4, arg5}, null, arg6));
    }

    public static final Flow combineTransform(Flow arg2, Flow arg3, Flow arg4, Flow arg5, Flow arg6, Function7 arg7) {
        return FlowKt.flow(new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$5(new Flow[]{arg2, arg3, arg4, arg5, arg6}, null, arg7));
    }

    public static final Flow combineTransform(Flow[] arg2, Function3 arg3) {
        Intrinsics.needClassReification();
        return FlowKt.flow(new FlowKt__ZipKt$combineTransform$6(arg2, arg3, null));
    }

    private static final Flow combineTransformUnsafe$FlowKt__ZipKt(Flow[] arg2, Function3 arg3) {
        Intrinsics.needClassReification();
        return FlowKt.flow(new FlowKt__ZipKt$combineTransformUnsafe$1(arg2, arg3, null));
    }

    private static final Flow combineUnsafe$FlowKt__ZipKt(Flow[] arg1, Function2 arg2) {
        Intrinsics.needClassReification();
        return new FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1(arg1, arg2);
    }

    public static final Flow flowCombine(Flow arg1, Flow arg2, Function3 arg3) {
        return new FlowKt__ZipKt$combine$$inlined$unsafeFlow$1(arg1, arg2, arg3);
    }

    public static final Flow flowCombineTransform(Flow arg2, Flow arg3, Function4 arg4) {
        return FlowKt.flow(new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$1(new Flow[]{arg2, arg3}, null, arg4));
    }

    private static final Function0 nullArrayFactory$FlowKt__ZipKt() {
        return FlowKt__ZipKt$nullArrayFactory$1.INSTANCE;
    }

    public static final Flow zip(Flow arg0, Flow arg1, Function3 arg2) {
        return CombineKt.zipImpl(arg0, arg1, arg2);
    }
}

