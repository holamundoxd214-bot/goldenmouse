package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.SystemPropsKt;

@Metadata(d1={"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b0\u001A,\u0010\u0000\u001A \u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001\"\u0004\b\u0000\u0010\u0004H\u0000\u001A*\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001A\u00020\u00022\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003H\u0002\u001Av\u0010\r\u001A\u00020\u000E\"\u0004\b\u0000\u0010\u000F*\b\u0012\u0004\u0012\u0002H\u000F0\u00102\u0006\u0010\u0011\u001A\u0002H\u000F2O\b\u0002\u0010\u0012\u001AI\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u0011H\u000F¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001A\u0018\u00010\u0013H\u0002¢\u0006\u0002\u0010\u001B\u001A\u0010\u0010\u001E\u001A\u00020\u00022\u0006\u0010\u001F\u001A\u00020\u000BH\u0002\u001A\u0018\u0010E\u001A\u00020\u00022\u0006\u0010F\u001A\u00020\u00022\u0006\u0010G\u001A\u00020\u000BH\u0002\u001A\u0018\u0010O\u001A\u00020\u00022\u0006\u0010F\u001A\u00020\u00022\u0006\u0010P\u001A\u00020\u000EH\u0002\"\u0016\u0010\b\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\n\u001A\u00020\u000B8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\f\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u001C\u001A\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u001D\u001A\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010 \u001A\u00020!8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\"\u001A\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010#\u001A\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010$\u001A\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010%\u001A\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010&\u001A\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\'\u001A\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010(\u001A\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010)\u001A\u00020!X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b*\u0010+\"\u000E\u0010,\u001A\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010-\u001A\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010.\u001A\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010/\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u00100\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u00101\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u00102\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u00103\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u00104\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u00105\u001A\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u00106\u001A\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u00107\u001A\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u00108\u001A\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u00109\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010:\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010;\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010<\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010=\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010>\u001A\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0019\u0010?\u001A\u00020\u0002*\u00020\u00028Â\u0002X\u0082\u0004¢\u0006\u0006\u001A\u0004\b@\u0010A\"\u0019\u0010B\u001A\u00020\u000B*\u00020\u00028Â\u0002X\u0082\u0004¢\u0006\u0006\u001A\u0004\bC\u0010D\"\u000E\u0010H\u001A\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010I\u001A\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0019\u0010J\u001A\u00020\u0002*\u00020\u00028Â\u0002X\u0082\u0004¢\u0006\u0006\u001A\u0004\bK\u0010A\"\u0019\u0010L\u001A\u00020\u000E*\u00020\u00028Â\u0002X\u0082\u0004¢\u0006\u0006\u001A\u0004\bM\u0010N¨\u0006Q"}, d2={"createSegmentFunction", "Lkotlin/reflect/KFunction2;", "", "Lkotlinx/coroutines/channels/ChannelSegment;", "E", "createSegment", "id", "prev", "NULL_SEGMENT", "", "SEGMENT_SIZE", "", "EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS", "tryResume0", "", "T", "Lkotlinx/coroutines/CancellableContinuation;", "value", "onCancellation", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/coroutines/CoroutineContext;", "context", "", "(Lkotlinx/coroutines/CancellableContinuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Z", "BUFFER_END_RENDEZVOUS", "BUFFER_END_UNLIMITED", "initialBufferEnd", "capacity", "BUFFERED", "Lkotlinx/coroutines/internal/Symbol;", "IN_BUFFER", "RESUMING_BY_RCV", "RESUMING_BY_EB", "POISONED", "DONE_RCV", "INTERRUPTED_SEND", "INTERRUPTED_RCV", "CHANNEL_CLOSED", "getCHANNEL_CLOSED", "()Lkotlinx/coroutines/internal/Symbol;", "SUSPEND", "SUSPEND_NO_WAITER", "FAILED", "RESULT_RENDEZVOUS", "RESULT_BUFFERED", "RESULT_SUSPEND", "RESULT_SUSPEND_NO_WAITER", "RESULT_CLOSED", "RESULT_FAILED", "NO_RECEIVE_RESULT", "CLOSE_HANDLER_CLOSED", "CLOSE_HANDLER_INVOKED", "NO_CLOSE_CAUSE", "CLOSE_STATUS_ACTIVE", "CLOSE_STATUS_CANCELLATION_STARTED", "CLOSE_STATUS_CLOSED", "CLOSE_STATUS_CANCELLED", "SENDERS_CLOSE_STATUS_SHIFT", "SENDERS_COUNTER_MASK", "sendersCounter", "getSendersCounter", "(J)J", "sendersCloseStatus", "getSendersCloseStatus", "(J)I", "constructSendersAndCloseStatus", "counter", "closeStatus", "EB_COMPLETED_PAUSE_EXPAND_BUFFERS_BIT", "EB_COMPLETED_COUNTER_MASK", "ebCompletedCounter", "getEbCompletedCounter", "ebPauseExpandBuffers", "getEbPauseExpandBuffers", "(J)Z", "constructEBCompletedAndPauseFlag", "pauseEB", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class BufferedChannelKt {
    public static final Symbol BUFFERED = null;
    private static final long BUFFER_END_RENDEZVOUS = 0;
    private static final long BUFFER_END_UNLIMITED = 0x7FFFFFFFFFFFFFFFL;
    private static final Symbol CHANNEL_CLOSED = null;
    private static final Symbol CLOSE_HANDLER_CLOSED = null;
    private static final Symbol CLOSE_HANDLER_INVOKED = null;
    private static final int CLOSE_STATUS_ACTIVE = 0;
    private static final int CLOSE_STATUS_CANCELLATION_STARTED = 1;
    private static final int CLOSE_STATUS_CANCELLED = 3;
    private static final int CLOSE_STATUS_CLOSED = 2;
    private static final Symbol DONE_RCV = null;
    private static final long EB_COMPLETED_COUNTER_MASK = 0x3FFFFFFFFFFFFFFFL;
    private static final long EB_COMPLETED_PAUSE_EXPAND_BUFFERS_BIT = 0x4000000000000000L;
    private static final int EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS = 0;
    private static final Symbol FAILED = null;
    private static final Symbol INTERRUPTED_RCV = null;
    private static final Symbol INTERRUPTED_SEND = null;
    private static final Symbol IN_BUFFER = null;
    private static final Symbol NO_CLOSE_CAUSE = null;
    private static final Symbol NO_RECEIVE_RESULT = null;
    private static final ChannelSegment NULL_SEGMENT = null;
    private static final Symbol POISONED = null;
    private static final int RESULT_BUFFERED = 1;
    private static final int RESULT_CLOSED = 4;
    private static final int RESULT_FAILED = 5;
    private static final int RESULT_RENDEZVOUS = 0;
    private static final int RESULT_SUSPEND = 2;
    private static final int RESULT_SUSPEND_NO_WAITER = 3;
    private static final Symbol RESUMING_BY_EB = null;
    private static final Symbol RESUMING_BY_RCV = null;
    public static final int SEGMENT_SIZE = 0;
    private static final int SENDERS_CLOSE_STATUS_SHIFT = 60;
    private static final long SENDERS_COUNTER_MASK = 0xFFFFFFFFFFFFFFFL;
    private static final Symbol SUSPEND;
    private static final Symbol SUSPEND_NO_WAITER;

    static {
        BufferedChannelKt.NULL_SEGMENT = new ChannelSegment(-1, null, null, 0);
        BufferedChannelKt.SEGMENT_SIZE = SystemPropsKt.systemProp$default("kotlinx.coroutines.bufferedChannel.segmentSize", 0x20, 0, 0, 12, null);
        BufferedChannelKt.EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS = SystemPropsKt.systemProp$default("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12, null);
        BufferedChannelKt.BUFFERED = new Symbol("BUFFERED");
        BufferedChannelKt.IN_BUFFER = new Symbol("SHOULD_BUFFER");
        BufferedChannelKt.RESUMING_BY_RCV = new Symbol("S_RESUMING_BY_RCV");
        BufferedChannelKt.RESUMING_BY_EB = new Symbol("RESUMING_BY_EB");
        BufferedChannelKt.POISONED = new Symbol("POISONED");
        BufferedChannelKt.DONE_RCV = new Symbol("DONE_RCV");
        BufferedChannelKt.INTERRUPTED_SEND = new Symbol("INTERRUPTED_SEND");
        BufferedChannelKt.INTERRUPTED_RCV = new Symbol("INTERRUPTED_RCV");
        BufferedChannelKt.CHANNEL_CLOSED = new Symbol("CHANNEL_CLOSED");
        BufferedChannelKt.SUSPEND = new Symbol("SUSPEND");
        BufferedChannelKt.SUSPEND_NO_WAITER = new Symbol("SUSPEND_NO_WAITER");
        BufferedChannelKt.FAILED = new Symbol("FAILED");
        BufferedChannelKt.NO_RECEIVE_RESULT = new Symbol("NO_RECEIVE_RESULT");
        BufferedChannelKt.CLOSE_HANDLER_CLOSED = new Symbol("CLOSE_HANDLER_CLOSED");
        BufferedChannelKt.CLOSE_HANDLER_INVOKED = new Symbol("CLOSE_HANDLER_INVOKED");
        BufferedChannelKt.NO_CLOSE_CAUSE = new Symbol("NO_CLOSE_CAUSE");
    }

    public static final long access$constructEBCompletedAndPauseFlag(long arg0, boolean arg2) {
        return BufferedChannelKt.constructEBCompletedAndPauseFlag(arg0, arg2);
    }

    public static final long access$constructSendersAndCloseStatus(long arg0, int arg2) {
        return BufferedChannelKt.constructSendersAndCloseStatus(arg0, arg2);
    }

    public static final ChannelSegment access$createSegment(long arg0, ChannelSegment arg2) {
        return BufferedChannelKt.createSegment(arg0, arg2);
    }

    public static final Symbol access$getCLOSE_HANDLER_CLOSED$p() {
        return BufferedChannelKt.CLOSE_HANDLER_CLOSED;
    }

    public static final Symbol access$getCLOSE_HANDLER_INVOKED$p() {
        return BufferedChannelKt.CLOSE_HANDLER_INVOKED;
    }

    public static final Symbol access$getDONE_RCV$p() {
        return BufferedChannelKt.DONE_RCV;
    }

    public static final int access$getEXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS$p() {
        return BufferedChannelKt.EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS;
    }

    public static final Symbol access$getFAILED$p() {
        return BufferedChannelKt.FAILED;
    }

    public static final Symbol access$getINTERRUPTED_RCV$p() {
        return BufferedChannelKt.INTERRUPTED_RCV;
    }

    public static final Symbol access$getINTERRUPTED_SEND$p() {
        return BufferedChannelKt.INTERRUPTED_SEND;
    }

    public static final Symbol access$getIN_BUFFER$p() {
        return BufferedChannelKt.IN_BUFFER;
    }

    public static final Symbol access$getNO_CLOSE_CAUSE$p() {
        return BufferedChannelKt.NO_CLOSE_CAUSE;
    }

    public static final Symbol access$getNO_RECEIVE_RESULT$p() {
        return BufferedChannelKt.NO_RECEIVE_RESULT;
    }

    public static final ChannelSegment access$getNULL_SEGMENT$p() {
        return BufferedChannelKt.NULL_SEGMENT;
    }

    public static final Symbol access$getPOISONED$p() {
        return BufferedChannelKt.POISONED;
    }

    public static final Symbol access$getRESUMING_BY_EB$p() {
        return BufferedChannelKt.RESUMING_BY_EB;
    }

    public static final Symbol access$getRESUMING_BY_RCV$p() {
        return BufferedChannelKt.RESUMING_BY_RCV;
    }

    public static final Symbol access$getSUSPEND$p() {
        return BufferedChannelKt.SUSPEND;
    }

    public static final Symbol access$getSUSPEND_NO_WAITER$p() {
        return BufferedChannelKt.SUSPEND_NO_WAITER;
    }

    public static final long access$initialBufferEnd(int arg2) {
        return BufferedChannelKt.initialBufferEnd(arg2);
    }

    public static final boolean access$tryResume0(CancellableContinuation arg0, Object arg1, Function3 arg2) {
        return BufferedChannelKt.tryResume0(arg0, arg1, arg2);
    }

    private static final long constructEBCompletedAndPauseFlag(long arg2, boolean arg4) {
        long v0 = arg4 ? 0x4000000000000000L : 0;
        return v0 + arg2;
    }

    private static final long constructSendersAndCloseStatus(long arg2, int arg4) {
        return ((((long)arg4)) << 60) + arg2;
    }

    private static final ChannelSegment createSegment(long arg6, ChannelSegment arg8) {
        return new ChannelSegment(arg6, arg8, arg8.getChannel(), 0);
    }

    public static final KFunction createSegmentFunction() {
        return BufferedChannelKt$createSegmentFunction$1.INSTANCE;
    }

    public static final Symbol getCHANNEL_CLOSED() {
        return BufferedChannelKt.CHANNEL_CLOSED;
    }

    private static final long getEbCompletedCounter(long arg2) {
        return arg2 & 0x3FFFFFFFFFFFFFFFL;
    }

    private static final boolean getEbPauseExpandBuffers(long arg2) {
        if((arg2 & 0x4000000000000000L) != 0) {
            return 1;
        }

        return 0;
    }

    private static final int getSendersCloseStatus(long arg1) {
        return ((int)(arg1 >> 60));
    }

    private static final long getSendersCounter(long arg2) {
        return arg2 & 0xFFFFFFFFFFFFFFFL;
    }

    private static final long initialBufferEnd(int arg2) {
        if(arg2 != 0) {
            if(arg2 != 0x7FFFFFFF) {
                return ((long)arg2);
            }

            return 0x7FFFFFFFFFFFFFFFL;
        }

        return 0;
    }

    private static final boolean tryResume0(CancellableContinuation arg1, Object arg2, Function3 arg3) {
        arg2 = arg1.tryResume(arg2, null, arg3);
        if(arg2 != null) {
            arg1.completeResume(arg2);
            return 1;
        }

        return 0;
    }

    static boolean tryResume0$default(CancellableContinuation arg0, Object arg1, Function3 arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        return BufferedChannelKt.tryResume0(arg0, arg1, arg2);
    }
}

