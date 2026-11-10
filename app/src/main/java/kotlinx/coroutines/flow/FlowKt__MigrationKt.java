package kotlinx.coroutines.flow;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;

@Metadata(d1={"\u0000\u0086\u0001\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\u001A\b\u0010\u0000\u001A\u00020\u0001H\u0000\u001A&\u0010\u0002\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u0010\u0005\u001A\u00020\u0006H\u0007\u001A&\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u0010\u0005\u001A\u00020\u0006H\u0007\u001A&\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u0010\u0005\u001A\u00020\u0006H\u0007\u001A,\u0010\t\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\f\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003H\u0007\u001A,\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\f\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003H\u0007\u001A\u0018\u0010\f\u001A\u00020\r\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0003H\u0007\u001AA\u0010\f\u001A\u00020\r\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\"\u0010\u000E\u001A\u001E\b\u0001\u0012\u0004\u0012\u0002H\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000FH\u0007¢\u0006\u0002\u0010\u0012\u001Ae\u0010\f\u001A\u00020\r\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\"\u0010\u000E\u001A\u001E\b\u0001\u0012\u0004\u0012\u0002H\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000F2\"\u0010\u0013\u001A\u001E\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000FH\u0007¢\u0006\u0002\u0010\u0015\u001AS\u0010\u0016\u001A\b\u0012\u0004\u0012\u0002H\u00170\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0017*\b\u0012\u0004\u0012\u0002H\u00040\u00032(\u0010\u0018\u001A$\b\u0001\u0012\u0004\u0012\u0002H\u0004\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u00030\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000FH\u0007¢\u0006\u0002\u0010\u0019\u001A>\u0010\u001A\u001A\b\u0012\u0004\u0012\u0002H\u00170\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0017*\b\u0012\u0004\u0012\u0002H\u00040\u00032\u0018\u0010\u0018\u001A\u0014\u0012\u0004\u0012\u0002H\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u00030\u001BH\u0007\u001A$\u0010\u001C\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0003H\u0007\u001A$\u0010\u001D\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0003H\u0007\u001AI\u0010\u001E\u001A\b\u0012\u0004\u0012\u0002H\u00170\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0017*\b\u0012\u0004\u0012\u0002H\u00040\u00032#\u0010\u001F\u001A\u001F\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u00030\u001B¢\u0006\u0002\b H\u0007\u001A&\u0010!\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u0010\"\u001A\u00020#H\u0007\u001AP\u0010$\u001A\u00020\r\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u000321\u0010%\u001A-\b\u0001\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b&\u0012\b\b\'\u0012\u0004\b\b((\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000FH\u0007¢\u0006\u0002\u0010\u0012\u001A{\u0010)\u001A\b\u0012\u0004\u0012\u0002H\u00170\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0017*\b\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u0010*\u001A\u0002H\u00172H\b\u0001\u0010+\u001AB\b\u0001\u0012\u0013\u0012\u0011H\u0017¢\u0006\f\b&\u0012\b\b\'\u0012\u0004\b\b(-\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b&\u0012\b\b\'\u0012\u0004\b\b((\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110,H\u0007¢\u0006\u0002\u0010.\u001A+\u0010/\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u0010\n\u001A\u0002H\u0004H\u0007¢\u0006\u0002\u00100\u001AA\u0010/\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u0010\n\u001A\u0002H\u00042\u0014\b\u0002\u00101\u001A\u000E\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u0002020\u001BH\u0007¢\u0006\u0002\u00103\u001A+\u00104\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u0010(\u001A\u0002H\u0004H\u0007¢\u0006\u0002\u00100\u001A,\u00104\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\f\u00105\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003H\u0007\u001A+\u00106\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u0010(\u001A\u0002H\u0004H\u0007¢\u0006\u0002\u00100\u001A,\u00106\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\f\u00105\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003H\u0007\u001Ag\u00107\u001A\b\u0012\u0004\u0012\u0002H\u00170\u0003\"\u0004\b\u0000\u00108\"\u0004\b\u0001\u00109\"\u0004\b\u0002\u0010\u0017*\b\u0012\u0004\u0012\u0002H80\u00032\f\u00105\u001A\b\u0012\u0004\u0012\u0002H90\u00032(\u0010:\u001A$\b\u0001\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H9\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110,H\u0007¢\u0006\u0002\u0010;\u001A\u0081\u0001\u00107\u001A\b\u0012\u0004\u0012\u0002H\u00170\u0003\"\u0004\b\u0000\u00108\"\u0004\b\u0001\u00109\"\u0004\b\u0002\u0010<\"\u0004\b\u0003\u0010\u0017*\b\u0012\u0004\u0012\u0002H80\u00032\f\u00105\u001A\b\u0012\u0004\u0012\u0002H90\u00032\f\u0010=\u001A\b\u0012\u0004\u0012\u0002H<0\u00032.\u0010:\u001A*\b\u0001\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H9\u0012\u0004\u0012\u0002H<\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110>H\u0007¢\u0006\u0002\u0010?\u001A\u009B\u0001\u00107\u001A\b\u0012\u0004\u0012\u0002H\u00170\u0003\"\u0004\b\u0000\u00108\"\u0004\b\u0001\u00109\"\u0004\b\u0002\u0010<\"\u0004\b\u0003\u0010@\"\u0004\b\u0004\u0010\u0017*\b\u0012\u0004\u0012\u0002H80\u00032\f\u00105\u001A\b\u0012\u0004\u0012\u0002H90\u00032\f\u0010=\u001A\b\u0012\u0004\u0012\u0002H<0\u00032\f\u0010A\u001A\b\u0012\u0004\u0012\u0002H@0\u000324\u0010:\u001A0\b\u0001\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H9\u0012\u0004\u0012\u0002H<\u0012\u0004\u0012\u0002H@\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110BH\u0007¢\u0006\u0002\u0010C\u001Aµ\u0001\u00107\u001A\b\u0012\u0004\u0012\u0002H\u00170\u0003\"\u0004\b\u0000\u00108\"\u0004\b\u0001\u00109\"\u0004\b\u0002\u0010<\"\u0004\b\u0003\u0010@\"\u0004\b\u0004\u0010D\"\u0004\b\u0005\u0010\u0017*\b\u0012\u0004\u0012\u0002H80\u00032\f\u00105\u001A\b\u0012\u0004\u0012\u0002H90\u00032\f\u0010=\u001A\b\u0012\u0004\u0012\u0002H<0\u00032\f\u0010A\u001A\b\u0012\u0004\u0012\u0002H@0\u00032\f\u0010E\u001A\b\u0012\u0004\u0012\u0002HD0\u00032:\u0010:\u001A6\b\u0001\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H9\u0012\u0004\u0012\u0002H<\u0012\u0004\u0012\u0002H@\u0012\u0004\u0012\u0002HD\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110FH\u0007¢\u0006\u0002\u0010G\u001A&\u0010H\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u0010I\u001A\u00020JH\u0007\u001A&\u0010K\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u0010I\u001A\u00020JH\u0007\u001Ab\u0010L\u001A\b\u0012\u0004\u0012\u0002H\u00170\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0017*\b\u0012\u0004\u0012\u0002H\u00040\u000327\u0010:\u001A3\b\u0001\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b&\u0012\b\b\'\u0012\u0004\b\b((\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u00030\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000FH\u0007¢\u0006\u0002\u0010\u0019\u001Ak\u0010M\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032F\u0010+\u001AB\b\u0001\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b&\u0012\b\b\'\u0012\u0004\b\b(-\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b&\u0012\b\b\'\u0012\u0004\b\b((\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110,H\u0007¢\u0006\u0002\u0010N\u001A\u001E\u0010O\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0003H\u0007\u001A&\u0010O\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u0010P\u001A\u00020#H\u0007\u001A\u001E\u0010Q\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0003H\u0007\u001A&\u0010Q\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u0010P\u001A\u00020#H\u0007\u001A\u001E\u0010R\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0003H\u0007¨\u0006S"}, d2={"noImpl", "", "observeOn", "Lkotlinx/coroutines/flow/Flow;", "T", "context", "Lkotlin/coroutines/CoroutineContext;", "publishOn", "subscribeOn", "onErrorResume", "fallback", "onErrorResumeNext", "subscribe", "", "onEach", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)V", "onError", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "flatMap", "R", "mapper", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "concatMap", "Lkotlin/Function1;", "merge", "flatten", "compose", "transformer", "Lkotlin/ExtensionFunctionType;", "skip", "count", "", "forEach", "action", "Lkotlin/ParameterName;", "name", "value", "scanFold", "initial", "operation", "Lkotlin/Function3;", "accumulator", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "onErrorReturn", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "predicate", "", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "startWith", "other", "concatWith", "combineLatest", "T1", "T2", "transform", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "T3", "other2", "Lkotlin/Function4;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "T4", "other3", "Lkotlin/Function5;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function5;)Lkotlinx/coroutines/flow/Flow;", "T5", "other4", "Lkotlin/Function6;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function6;)Lkotlinx/coroutines/flow/Flow;", "delayFlow", "timeMillis", "", "delayEach", "switchMap", "scanReduce", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "publish", "bufferSize", "replay", "cache", "kotlinx-coroutines-core"}, k=5, mv={2, 1, 0}, xi=0x30, xs="kotlinx/coroutines/flow/FlowKt") final class FlowKt__MigrationKt {
    public static boolean $r8$lambda$j65qxiLcnohuuSSpMR6ozVhaNdA(Throwable arg0) {
        return FlowKt__MigrationKt.onErrorReturn$lambda$0$FlowKt__MigrationKt(arg0);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'cache()\' is \'shareIn\' with unlimited replay and \'started = SharingStarted.Lazily\' argument\'", replaceWith="<_subannotation>") public static final Flow cache(Flow arg0) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'combineLatest\' is \'combine\'", replaceWith="<_subannotation>") public static final Flow combineLatest(Flow arg0, Flow arg1, Function3 arg2) {
        return FlowKt.combine(arg0, arg1, arg2);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'combineLatest\' is \'combine\'", replaceWith="<_subannotation>") public static final Flow combineLatest(Flow arg0, Flow arg1, Flow arg2, Function4 arg3) {
        return FlowKt.combine(arg0, arg1, arg2, arg3);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'combineLatest\' is \'combine\'", replaceWith="<_subannotation>") public static final Flow combineLatest(Flow arg0, Flow arg1, Flow arg2, Flow arg3, Function5 arg4) {
        return FlowKt.combine(arg0, arg1, arg2, arg3, arg4);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'combineLatest\' is \'combine\'", replaceWith="<_subannotation>") public static final Flow combineLatest(Flow arg0, Flow arg1, Flow arg2, Flow arg3, Flow arg4, Function6 arg5) {
        return FlowKt.combine(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'compose\' is \'let\'", replaceWith="<_subannotation>") public static final Flow compose(Flow arg0, Function1 arg1) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'concatMap\' is \'flatMapConcat\'", replaceWith="<_subannotation>") public static final Flow concatMap(Flow arg0, Function1 arg1) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'concatWith\' is \'onCompletion\'. Use \'onCompletion { emit(value) }\'", replaceWith="<_subannotation>") public static final Flow concatWith(Flow arg0, Object arg1) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'concatWith\' is \'onCompletion\'. Use \'onCompletion { if (it == null) emitAll(other) }\'", replaceWith="<_subannotation>") public static final Flow concatWith(Flow arg0, Flow arg1) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Use \'onEach { delay(timeMillis) }\'", replaceWith="<_subannotation>") public static final Flow delayEach(Flow arg2, long arg3) {
        return FlowKt.onEach(arg2, new FlowKt__MigrationKt$delayEach$1(arg3, null));
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Use \'onStart { delay(timeMillis) }\'", replaceWith="<_subannotation>") public static final Flow delayFlow(Flow arg2, long arg3) {
        return FlowKt.onStart(arg2, new FlowKt__MigrationKt$delayFlow$1(arg3, null));
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue is \'flatMapConcat\'", replaceWith="<_subannotation>") public static final Flow flatMap(Flow arg0, Function2 arg1) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'flatten\' is \'flattenConcat\'", replaceWith="<_subannotation>") public static final Flow flatten(Flow arg0) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'forEach\' is \'collect\'", replaceWith="<_subannotation>") public static final void forEach(Flow arg0, Function2 arg1) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'merge\' is \'flattenConcat\'", replaceWith="<_subannotation>") public static final Flow merge(Flow arg0) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final Void noImpl() {
        throw new UnsupportedOperationException("Not implemented, should not be called");
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Collect flow in the desired context instead") public static final Flow observeOn(Flow arg0, CoroutineContext arg1) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'onErrorXxx\' is \'catch\'. Use \'catch { emitAll(fallback) }\'", replaceWith="<_subannotation>") public static final Flow onErrorResume(Flow arg0, Flow arg1) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'onErrorXxx\' is \'catch\'. Use \'catch { emitAll(fallback) }\'", replaceWith="<_subannotation>") public static final Flow onErrorResumeNext(Flow arg0, Flow arg1) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'onErrorXxx\' is \'catch\'. Use \'catch { emit(fallback) }\'", replaceWith="<_subannotation>") public static final Flow onErrorReturn(Flow arg0, Object arg1) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'onErrorXxx\' is \'catch\'. Use \'catch { e -> if (predicate(e)) emit(fallback) else throw e }\'", replaceWith="<_subannotation>") public static final Flow onErrorReturn(Flow arg2, Object arg3, Function1 arg4) {
        return FlowKt.catch(arg2, new FlowKt__MigrationKt$onErrorReturn$2(arg4, arg3, null));
    }

    public static Flow onErrorReturn$default(Flow arg0, Object arg1, Function1 arg2, int arg3, Object arg4) {
        FlowKt__MigrationKt$$ExternalSyntheticLambda0 v2;
        if((arg3 & 2) != 0) {
            v2 = new FlowKt__MigrationKt$$ExternalSyntheticLambda0();
        }

        return FlowKt.onErrorReturn(arg0, arg1, ((Function1)v2));
    }

    private static final boolean onErrorReturn$lambda$0$FlowKt__MigrationKt(Throwable arg0) {
        return 1;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'publish()\' is \'shareIn\'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to \'started = SharingStarted.Lazily\' argument, \npublish().refCount() translates to \'started = SharingStarted.WhileSubscribed()\' argument.", replaceWith="<_subannotation>") public static final Flow publish(Flow arg0) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'publish(bufferSize)\' is \'buffer\' followed by \'shareIn\'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to \'started = SharingStarted.Lazily\' argument, \npublish().refCount() translates to \'started = SharingStarted.WhileSubscribed()\' argument.", replaceWith="<_subannotation>") public static final Flow publish(Flow arg0, int arg1) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Collect flow in the desired context instead") public static final Flow publishOn(Flow arg0, CoroutineContext arg1) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'replay()\' is \'shareIn\' with unlimited replay. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to \'started = SharingStarted.Lazily\' argument, \nreplay().refCount() translates to \'started = SharingStarted.WhileSubscribed()\' argument.", replaceWith="<_subannotation>") public static final Flow replay(Flow arg0) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'replay(bufferSize)\' is \'shareIn\' with the specified replay parameter. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to \'started = SharingStarted.Lazily\' argument, \nreplay().refCount() translates to \'started = SharingStarted.WhileSubscribed()\' argument.", replaceWith="<_subannotation>") public static final Flow replay(Flow arg0, int arg1) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow has less verbose \'scan\' shortcut", replaceWith="<_subannotation>") public static final Flow scanFold(Flow arg0, Object arg1, Function3 arg2) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="\'scanReduce\' was renamed to \'runningReduce\' to be consistent with Kotlin standard library", replaceWith="<_subannotation>") public static final Flow scanReduce(Flow arg0, Function3 arg1) {
        return FlowKt.runningReduce(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'skip\' is \'drop\'", replaceWith="<_subannotation>") public static final Flow skip(Flow arg0, int arg1) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'startWith\' is \'onStart\'. Use \'onStart { emit(value) }\'", replaceWith="<_subannotation>") public static final Flow startWith(Flow arg0, Object arg1) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'startWith\' is \'onStart\'. Use \'onStart { emitAll(other) }\'", replaceWith="<_subannotation>") public static final Flow startWith(Flow arg0, Flow arg1) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Use \'launchIn\' with \'onEach\', \'onCompletion\' and \'catch\' instead") public static final void subscribe(Flow arg0) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Use \'launchIn\' with \'onEach\', \'onCompletion\' and \'catch\' instead") public static final void subscribe(Flow arg0, Function2 arg1) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Use \'launchIn\' with \'onEach\', \'onCompletion\' and \'catch\' instead") public static final void subscribe(Flow arg0, Function2 arg1, Function2 arg2) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Use \'flowOn\' instead") public static final Flow subscribeOn(Flow arg0, CoroutineContext arg1) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogues of \'switchMap\' are \'transformLatest\', \'flatMapLatest\' and \'mapLatest\'", replaceWith="<_subannotation>") public static final Flow switchMap(Flow arg2, Function2 arg3) {
        return FlowKt.transformLatest(arg2, new FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1(arg3, null));
    }
}

