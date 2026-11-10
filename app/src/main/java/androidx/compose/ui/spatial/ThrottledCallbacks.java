package androidx.compose.ui.spatial;

import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.ui.node.DelegatableNode$RegistrationHandle;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeKt;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u001F\b\u0001\u0018\u00002\u00020\u0001:\u0001ZB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010&\u001A\u00020\'2\u0006\u0010(\u001A\u00020\u00152\u0006\u0010)\u001A\u00020\u00152\b\u0010*\u001A\u0004\u0018\u00010 2\u0006\u0010+\u001A\u00020,2\u0006\u0010-\u001A\u00020,¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001A\u00020\u000F2\u0006\u00101\u001A\u00020\u000FH\u0002J:\u00102\u001A\u0002032\u0006\u00104\u001A\u00020,2\u0006\u00105\u001A\u00020\u000F2\u0006\u00106\u001A\u00020\u000F2\u0006\u00107\u001A\u0002082\u0012\u00109\u001A\u000E\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<0:J:\u0010=\u001A\u0002032\u0006\u00104\u001A\u00020,2\u0006\u00105\u001A\u00020\u000F2\u0006\u00106\u001A\u00020\u000F2\u0006\u00107\u001A\u0002082\u0012\u00109\u001A\u000E\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<0:J&\u0010>\u001A\u00020<2\u0006\u00104\u001A\u00020,2\u0006\u0010?\u001A\u00020\u000F2\u0006\u0010@\u001A\u00020\u000F2\u0006\u0010A\u001A\u00020\u000FJ!\u0010B\u001A\u00020<2\u0016\u00109\u001A\u0012\u0012\b\u0012\u00060\u0006R\u00020\u0000\u0012\u0004\u0012\u00020<0:H\u0086\bJ\u000E\u0010C\u001A\u00020<2\u0006\u0010A\u001A\u00020\u000FJ\u000E\u0010D\u001A\u00020<2\u0006\u0010A\u001A\u00020\u000FJ\u000E\u0010E\u001A\u00020<2\u0006\u0010A\u001A\u00020\u000FJ1\u0010F\u001A\u00020<2\n\u0010G\u001A\u00060\u0006R\u00020\u00002\u0006\u0010?\u001A\u00020\u000F2\u0006\u0010@\u001A\u00020\u000F2\u0006\u0010A\u001A\u00020\u000FH\u0000¢\u0006\u0002\bHJ=\u0010I\u001A\u00020<2\n\u0010G\u001A\u00060\u0006R\u00020\u00002\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0019\u001A\u00020\u00152\b\u0010\u001F\u001A\u0004\u0018\u00010 2\u0006\u0010A\u001A\u00020\u000FH\u0002¢\u0006\u0004\bJ\u0010KJE\u0010L\u001A\u00020\u000F2\n\u0010G\u001A\u00060\u0006R\u00020\u00002\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0019\u001A\u00020\u00152\b\u0010\u001F\u001A\u0004\u0018\u00010 2\u0006\u0010A\u001A\u00020\u000F2\u0006\u0010M\u001A\u00020\u000FH\u0002¢\u0006\u0004\bN\u0010OJ\u0014\u0010P\u001A\u00020<2\n\u0010G\u001A\u00060\u0006R\u00020\u0000H\u0002J\u0014\u0010Q\u001A\u00020\'2\n\u0010G\u001A\u00060\u0006R\u00020\u0000H\u0002J)\u0010R\u001A\u00020<*\u00060\u0006R\u00020\u00002\u0016\u0010S\u001A\u0012\u0012\b\u0012\u00060\u0006R\u00020\u0000\u0012\u0004\u0012\u00020<0:H\u0082\bJ/\u0010T\u001A\u00020<*\f\u0012\b\u0012\u00060\u0006R\u00020\u00000\u00052\u0016\u0010S\u001A\u0012\u0012\b\u0012\u00060\u0006R\u00020\u0000\u0012\u0004\u0012\u00020<0:H\u0082\bJ7\u0010U\u001A\u00020<*\f\u0012\b\u0012\u00060\u0006R\u00020\u00000\u00052\u0006\u00104\u001A\u00020,2\u0016\u0010S\u001A\u0012\u0012\b\u0012\u00060\u0006R\u00020\u0000\u0012\u0004\u0012\u00020<0:H\u0082\bJ.\u0010V\u001A\u00060\u0006R\u00020\u0000*\f\u0012\b\u0012\u00060\u0006R\u00020\u00000\u00052\u0006\u0010W\u001A\u00020,2\n\u0010X\u001A\u00060\u0006R\u00020\u0000H\u0002J*\u0010Y\u001A\u00020\'*\f\u0012\b\u0012\u00060\u0006R\u00020\u00000\u00052\u0006\u0010W\u001A\u00020,2\n\u0010X\u001A\u00060\u0006R\u00020\u0000H\u0002R\u001B\u0010\u0004\u001A\f\u0012\b\u0012\u00060\u0006R\u00020\u00000\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR \u0010\t\u001A\b\u0018\u00010\u0006R\u00020\u0000X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR\u001A\u0010\u000E\u001A\u00020\u000FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001C\u0010\u0014\u001A\u00020\u0015X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0018\u001A\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001C\u0010\u0019\u001A\u00020\u0015X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0018\u001A\u0004\b\u001A\u0010\u0011\"\u0004\b\u001B\u0010\u0013R\u001A\u0010\u001C\u001A\u00020\u000FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001D\u0010\u0011\"\u0004\b\u001E\u0010\u0013R\u001E\u0010\u001F\u001A\u0004\u0018\u00010 X\u0086\u000E¢\u0006\u0010\n\u0002\u0010%\u001A\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006["}, d2={"Landroidx/compose/ui/spatial/ThrottledCallbacks;", "", "<init>", "()V", "rectChangedMap", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/compose/ui/spatial/ThrottledCallbacks$Entry;", "getRectChangedMap", "()Landroidx/collection/MutableIntObjectMap;", "globalChangeEntries", "getGlobalChangeEntries", "()Landroidx/compose/ui/spatial/ThrottledCallbacks$Entry;", "setGlobalChangeEntries", "(Landroidx/compose/ui/spatial/ThrottledCallbacks$Entry;)V", "minDebounceDeadline", "", "getMinDebounceDeadline", "()J", "setMinDebounceDeadline", "(J)V", "windowOffset", "Landroidx/compose/ui/unit/IntOffset;", "getWindowOffset-nOcc-ac", "setWindowOffset--gyyYBs", "J", "screenOffset", "getScreenOffset-nOcc-ac", "setScreenOffset--gyyYBs", "windowSize", "getWindowSize", "setWindowSize", "viewToWindowMatrix", "Landroidx/compose/ui/graphics/Matrix;", "getViewToWindowMatrix-3i98HWw", "()[F", "setViewToWindowMatrix-Q8lPUPs", "([F)V", "[F", "updateOffsets", "", "screen", "window", "matrix", "windowWidth", "", "windowHeight", "updateOffsets-LDcG7Xg", "(JJ[FII)Z", "roundDownToMultipleOf8", "x", "registerOnRectChanged", "Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "id", "throttleMillis", "debounceMillis", "node", "Landroidx/compose/ui/node/DelegatableNode;", "callback", "Lkotlin/Function1;", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "", "registerOnGlobalChange", "fireOnUpdatedRect", "topLeft", "bottomRight", "currentMillis", "forEachNewCallbackNeverInvoked", "fireOnRectChangedEntries", "fireGlobalChangeEntries", "triggerDebounced", "fireWithUpdatedRect", "entry", "fireWithUpdatedRect$ui", "fire", "fire-WY9HvpM", "(Landroidx/compose/ui/spatial/ThrottledCallbacks$Entry;JJ[FJ)V", "debounceEntry", "minDeadline", "debounceEntry-b8qMvQI", "(Landroidx/compose/ui/spatial/ThrottledCallbacks$Entry;JJ[FJJ)J", "addToGlobalEntries", "removeFromGlobalEntries", "linkedForEach", "block", "multiForEach", "runFor", "multiPut", "key", "value", "multiRemove", "Entry", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ThrottledCallbacks {
    @Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0004\b\r\u0010\u000EJ\b\u0010+\u001A\u00020\fH\u0016J7\u0010,\u001A\u00020\f2\u0006\u0010\u001E\u001A\u00020\u00052\u0006\u0010\"\u001A\u00020\u00052\u0006\u0010-\u001A\u00020.2\u0006\u0010/\u001A\u00020.2\b\u00100\u001A\u0004\u0018\u000101¢\u0006\u0004\b2\u00103R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u001D\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\f0\n¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001A\b\u0018\u00010\u0000R\u00020\u0019X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u001B\"\u0004\b\u001C\u0010\u001DR\u001A\u0010\u001E\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001F\u0010\u0012\"\u0004\b \u0010!R\u001A\u0010\"\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b#\u0010\u0012\"\u0004\b$\u0010!R\u001A\u0010%\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b&\u0010\u0012\"\u0004\b\'\u0010!R\u001A\u0010(\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b)\u0010\u0012\"\u0004\b*\u0010!¨\u00064"}, d2={"Landroidx/compose/ui/spatial/ThrottledCallbacks$Entry;", "Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "id", "", "throttleMillis", "", "debounceMillis", "node", "Landroidx/compose/ui/node/DelegatableNode;", "callback", "Lkotlin/Function1;", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "", "<init>", "(Landroidx/compose/ui/spatial/ThrottledCallbacks;IJJLandroidx/compose/ui/node/DelegatableNode;Lkotlin/jvm/functions/Function1;)V", "getId", "()I", "getThrottleMillis", "()J", "getDebounceMillis", "getNode", "()Landroidx/compose/ui/node/DelegatableNode;", "getCallback", "()Lkotlin/jvm/functions/Function1;", "next", "Landroidx/compose/ui/spatial/ThrottledCallbacks;", "getNext", "()Landroidx/compose/ui/spatial/ThrottledCallbacks$Entry;", "setNext", "(Landroidx/compose/ui/spatial/ThrottledCallbacks$Entry;)V", "topLeft", "getTopLeft", "setTopLeft", "(J)V", "bottomRight", "getBottomRight", "setBottomRight", "lastInvokeMillis", "getLastInvokeMillis", "setLastInvokeMillis", "lastUninvokedFireMillis", "getLastUninvokedFireMillis", "setLastUninvokedFireMillis", "unregister", "fire", "windowOffset", "Landroidx/compose/ui/unit/IntOffset;", "screenOffset", "viewToWindowMatrix", "Landroidx/compose/ui/graphics/Matrix;", "fire-9b-9wPM", "(JJJJ[F)V", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Entry implements RegistrationHandle {
        private long bottomRight;
        private final Function1 callback;
        private final long debounceMillis;
        private final int id;
        private long lastInvokeMillis;
        private long lastUninvokedFireMillis;
        private Entry next;
        private final DelegatableNode node;
        private final long throttleMillis;
        private long topLeft;

        public Entry(ThrottledCallbacks arg1, int arg2, long arg3, long arg5, DelegatableNode arg7, Function1 arg8) {
            ThrottledCallbacks.this = arg1;
            super();
            this.id = arg2;
            this.throttleMillis = arg3;
            this.debounceMillis = arg5;
            this.node = arg7;
            this.callback = arg8;
            this.lastInvokeMillis = -9223372036854775808L;
            this.lastUninvokedFireMillis = -1;
        }

        public final void fire-9b-9wPM(long arg13, long arg15, long arg17, long arg19, float[] arg21) {
            RelativeLayoutBounds v13 = ThrottledCallbacksKt.rectInfoFor-Dg36KO4(this.node, arg13, arg15, arg17, arg19, ThrottledCallbacks.this.getWindowSize(), arg21);
            if(v13 == null) {
                return;
            }

            this.callback.invoke(v13);
        }

        public final long getBottomRight() {
            return this.bottomRight;
        }

        public final Function1 getCallback() {
            return this.callback;
        }

        public final long getDebounceMillis() {
            return this.debounceMillis;
        }

        public final int getId() {
            return this.id;
        }

        public final long getLastInvokeMillis() {
            return this.lastInvokeMillis;
        }

        public final long getLastUninvokedFireMillis() {
            return this.lastUninvokedFireMillis;
        }

        public final Entry getNext() {
            return this.next;
        }

        public final DelegatableNode getNode() {
            return this.node;
        }

        public final long getThrottleMillis() {
            return this.throttleMillis;
        }

        public final long getTopLeft() {
            return this.topLeft;
        }

        public final void setBottomRight(long arg1) {
            this.bottomRight = arg1;
        }

        public final void setLastInvokeMillis(long arg1) {
            this.lastInvokeMillis = arg1;
        }

        public final void setLastUninvokedFireMillis(long arg1) {
            this.lastUninvokedFireMillis = arg1;
        }

        public final void setNext(Entry arg1) {
            this.next = arg1;
        }

        public final void setTopLeft(long arg1) {
            this.topLeft = arg1;
        }

        public void unregister() {
            if(!ThrottledCallbacks.this.multiRemove(ThrottledCallbacks.this.getRectChangedMap(), this.id, this)) {
                ThrottledCallbacks.this.removeFromGlobalEntries(this);
            }
        }
    }

    public static final int $stable = 8;
    private Entry globalChangeEntries;
    private long minDebounceDeadline;
    private final MutableIntObjectMap rectChangedMap;
    private long screenOffset;
    private float[] viewToWindowMatrix;
    private long windowOffset;
    private long windowSize;

    static {
    }

    public ThrottledCallbacks() {
        super();
        this.rectChangedMap = IntObjectMapKt.mutableIntObjectMapOf();
        this.minDebounceDeadline = -1;
        this.windowOffset = IntOffset.Companion.getZero-nOcc-ac();
        this.screenOffset = IntOffset.Companion.getZero-nOcc-ac();
    }

    public static final boolean access$multiRemove(ThrottledCallbacks arg0, MutableIntObjectMap arg1, int arg2, Entry arg3) {
        return arg0.multiRemove(arg1, arg2, arg3);
    }

    public static final boolean access$removeFromGlobalEntries(ThrottledCallbacks arg0, Entry arg1) {
        return arg0.removeFromGlobalEntries(arg1);
    }

    private final void addToGlobalEntries(Entry arg2) {
        arg2.setNext(this.globalChangeEntries);
        this.globalChangeEntries = arg2;
    }

    private final long debounceEntry-b8qMvQI(Entry arg13, long arg14, long arg16, float[] arg18, long arg19, long arg21) {
        long v1 = arg19;
        long v10 = arg21;
        long v5 = 0;
        if(arg13.getDebounceMillis() > v5 && arg13.getLastUninvokedFireMillis() > v5) {
            if(v1 - arg13.getLastUninvokedFireMillis() >= arg13.getDebounceMillis()) {
                arg13.setLastInvokeMillis(v1);
                arg13.setLastUninvokedFireMillis(-1);
                arg13.fire-9b-9wPM(arg13.getTopLeft(), arg13.getBottomRight(), arg14, arg16, arg18);
                return v10;
            }
            else {
                return Math.min(v10, arg13.getLastUninvokedFireMillis() + arg13.getDebounceMillis());
            }
        }

        return v10;
    }

    private final void fire-WY9HvpM(Entry arg17, long arg18, long arg20, float[] arg22, long arg23) {
        ThrottledCallbacks v0 = this;
        Entry v1 = arg17;
        long v11 = arg23;
        long v2 = v1.getLastInvokeMillis();
        int v2_1 = Long.compare(v11 - v2, v1.getThrottleMillis()) > 0 || v2 == -9223372036854775808L ? 1 : 0;
        long v13 = 0;
        int v15 = v1.getDebounceMillis() == v13 ? 1 : 0;
        v1.setLastUninvokedFireMillis(v11);
        if(v2_1 != 0 && v15 != 0) {
            v1.setLastInvokeMillis(v11);
            v1.fire-9b-9wPM(v1.getTopLeft(), v1.getBottomRight(), arg18, arg20, arg22);
        }

        if(v15 == 0) {
            long v1_1 = v0.minDebounceDeadline;
            long v3 = arg17.getDebounceMillis() + v11;
            if(v1_1 > v13 && v3 < v1_1) {
                v0.minDebounceDeadline = v1_1;
            }
        }
    }

    public final void fireGlobalChangeEntries(long arg15) {
        long v2 = this.windowOffset;
        long v4 = this.screenOffset;
        float[] v6 = this.viewToWindowMatrix;
        Entry v0 = this.globalChangeEntries;
        if(v0 != null) {
            Entry v1;
            for(v1 = v0; v1 != null; v1 = v1.getNext()) {
                LayoutNode v0_1 = DelegatableNodeKt.requireLayoutNode(v1.getNode());
                long v7 = LayoutNodeKt.requireOwner(v0_1).getRectManager().getOffsetFromRectListFor-Bjo55l4(v0_1);
                long v9 = v0_1.getLastSize-YbymL2g$ui();
                v1.setTopLeft(v7);
                v1.setBottomRight((((long)(IntOffset.getX-impl(v7) + (((int)(v9 >> 0x20)))))) << 0x20 | (((long)(IntOffset.getY-impl(v7) + (((int)(v9 & 0xFFFFFFFFL)))))) & 0xFFFFFFFFL);
                this.fire-WY9HvpM(v1, v2, v4, v6, arg15);
            }
        }
    }

    public final void fireOnRectChangedEntries(long arg21) {
        ThrottledCallbacks v0 = this;
        long v2 = v0.windowOffset;
        long v4 = v0.screenOffset;
        float[] v6 = v0.viewToWindowMatrix;
        MutableIntObjectMap v1 = v0.rectChangedMap;
        Object[] v9 = ((IntObjectMap)v1).values;
        long[] v10 = ((IntObjectMap)v1).metadata;
        int v11 = v10.length - 2;
        if(v11 >= 0) {
            int v13 = 0;
            while(true) {
                long v7 = v10[v13];
                if((~v7 << 7 & v7 & -9187201950435737472L) != -9187201950435737472L) {
                    int v14 = 8;
                    int v15 = 8 - (~(v13 - v11) >>> 0x1F);
                    long v16 = v7;
                    int v1_1 = 0;
                    while(v1_1 < v15) {
                        if((v16 & 0xFF) < 0x80) {
                            Object v7_1 = v9[(v13 << 3) + v1_1];
                            while(v7_1 != null) {
                                v0.fire-WY9HvpM(v7_1, v2, v4, v6, arg21);
                                Entry v7_2 = v7_1.getNext();
                                v0 = this;
                                v1_1 = v1_1;
                            }
                        }

                        v16 >>= v14;
                        ++v1_1;
                        v0 = this;
                    }

                    if(v15 != v14) {
                        return;
                    }
                }

                if(v13 == v11) {
                    return;
                }

                ++v13;
                v0 = this;
            }
        }
    }

    public final void fireOnUpdatedRect(int arg9, long arg10, long arg12, long arg14) {
        Object v9 = this.rectChangedMap.get(arg9);
        while(true) {
            Object v1 = v9;
            if(v1 == null) {
                return;
            }

            Entry v9_1 = ((Entry)v1).getNext();
            this.fireWithUpdatedRect$ui(((Entry)v1), arg10, arg12, arg14);
        }
    }

    public final void fireWithUpdatedRect$ui(Entry arg16, long arg17, long arg19, long arg21) {
        Entry v1 = arg16;
        long v2 = arg21;
        long v4 = v1.getLastInvokeMillis();
        long v6 = v1.getThrottleMillis();
        long v8 = v1.getDebounceMillis();
        int v4_1 = v2 - v4 >= v6 || v4 == -9223372036854775808L ? 1 : 0;
        long v13 = 0;
        int v5 = v8 == v13 ? 1 : 0;
        int v6_1 = v6 == v13 ? 1 : 0;
        arg16.setTopLeft(arg17);
        long v11 = arg19;
        v1.setBottomRight(v11);
        int v10 = v5 == 0 && v6_1 == 0 || v5 != 0 ? 1 : 0;
        if(v4_1 != 0 && v10 != 0) {
            v1.setLastUninvokedFireMillis(-1);
            v1.setLastInvokeMillis(v2);
            v1.fire-9b-9wPM(arg17, v11, this.windowOffset, this.screenOffset, this.viewToWindowMatrix);
            return;
        }

        if(v5 == 0) {
            v1.setLastUninvokedFireMillis(v2);
            v4 = this.minDebounceDeadline;
            long v1_1 = v2 + v8;
            if(v4 > v13 && v1_1 < v4) {
                this.minDebounceDeadline = v4;
            }
        }
    }

    public final void forEachNewCallbackNeverInvoked(Function1 arg17) {
        MutableIntObjectMap v0 = this.getRectChangedMap();
        Object[] v1 = ((IntObjectMap)v0).values;
        long[] v0_1 = ((IntObjectMap)v0).metadata;
        int v2 = v0_1.length - 2;
        if(v2 >= 0) {
            int v4;
            for(v4 = 0; true; ++v4) {
                long v5 = v0_1[v4];
                if((~v5 << 7 & v5 & -9187201950435737472L) != -9187201950435737472L) {
                    int v8 = 8;
                    int v7 = 8 - (~(v4 - v2) >>> 0x1F);
                    int v9;
                    for(v9 = 0; v9 < v7; ++v9) {
                        if((0xFF & v5) < 0x80) {
                            Object v10 = v1[(v4 << 3) + v9];
                            Object v11 = v10;
                            while(v11 != null) {
                                if(((Entry)v10).getLastInvokeMillis() == -9223372036854775808L) {
                                    arg17.invoke(v10);
                                }

                                Entry v11_1 = ((Entry)v11).getNext();
                            }
                        }

                        v5 >>= v8;
                    }

                    if(v7 != v8) {
                        return;
                    }
                }

                if(v4 == v2) {
                    return;
                }
            }
        }
    }

    public final Entry getGlobalChangeEntries() {
        return this.globalChangeEntries;
    }

    public final long getMinDebounceDeadline() {
        return this.minDebounceDeadline;
    }

    public final MutableIntObjectMap getRectChangedMap() {
        return this.rectChangedMap;
    }

    public final long getScreenOffset-nOcc-ac() {
        return this.screenOffset;
    }

    public final float[] getViewToWindowMatrix-3i98HWw() {
        return this.viewToWindowMatrix;
    }

    public final long getWindowOffset-nOcc-ac() {
        return this.windowOffset;
    }

    public final long getWindowSize() {
        return this.windowSize;
    }

    private final void linkedForEach(Entry arg1, Function1 arg2) {
        while(arg1 != null) {
            arg2.invoke(arg1);
            arg1 = arg1.getNext();
        }
    }

    private final void multiForEach(MutableIntObjectMap arg13, Function1 arg14) {
        Object[] v12 = ((IntObjectMap)arg13).values;
        long[] v13 = ((IntObjectMap)arg13).metadata;
        int v0 = v13.length - 2;
        if(v0 >= 0) {
            int v2;
            for(v2 = 0; true; ++v2) {
                long v3 = v13[v2];
                if((~v3 << 7 & v3 & -9187201950435737472L) != -9187201950435737472L) {
                    int v6 = 8;
                    int v5 = 8 - (~(v2 - v0) >>> 0x1F);
                    int v7;
                    for(v7 = 0; v7 < v5; ++v7) {
                        if((0xFF & v3) < 0x80) {
                            Object v8 = v12[(v2 << 3) + v7];
                            while(v8 != null) {
                                arg14.invoke(v8);
                                Entry v8_1 = v8_1.getNext();
                            }
                        }

                        v3 >>= v6;
                    }

                    if(v5 != v6) {
                        return;
                    }
                }

                if(v2 == v0) {
                    return;
                }
            }
        }
    }

    private final Entry multiPut(MutableIntObjectMap arg1, int arg2, Entry arg3) {
        Entry v0_1;
        Object v0 = arg1.get(arg2);
        if(v0 == null) {
            arg1.set(arg2, arg3);
            v0_1 = arg3;
        }

        if(v0_1 != arg3) {
            while(v0_1.getNext() != null) {
                v0_1 = v0_1.getNext();
                Intrinsics.checkNotNull(v0_1);
            }

            v0_1.setNext(arg3);
        }

        return arg3;
    }

    private final boolean multiRemove(MutableIntObjectMap arg5, int arg6, Entry arg7) {
        Entry v4_1;
        Object v4 = arg5.remove(arg6);
        if(v4 == null) {
            return 0;
        }

        Entry v3 = null;
        if(Intrinsics.areEqual(v4, arg7)) {
            v4_1 = arg7.getNext();
            arg7.setNext(v3);
            if(v4_1 != null) {
                arg5.put(arg6, v4_1);
            }
            else {
                LayoutNode v4_2 = DelegatableNodeKt.requireLayoutNode(arg7.getNode().getNode());
                if(v4_2.getAddedToRectList$ui()) {
                    LayoutNodeKt.requireOwner(v4_2).getRectManager().unsetHasCallbacksFor(v4_2);
                }
            }

            return 1;
        }

        arg5.put(arg6, v4);
        while(v4 != null) {
            Entry v5 = ((Entry)v4).getNext();
            if(v5 == null) {
                return 0;
            }
            else if(v5 == arg7) {
                ((Entry)v4).setNext(arg7.getNext());
                arg7.setNext(v3);
            }
            else {
                v4_1 = v4_1.getNext();
                continue;
            }

            return 1;
        }

        return 1;
    }

    public final RegistrationHandle registerOnGlobalChange(int arg11, long arg12, long arg14, DelegatableNode arg16, Function1 arg17) {
        long v6 = arg14 == 0 ? arg12 : arg14;
        Entry v1 = new Entry(this, arg11, arg12, v6, arg16, arg17);
        this.addToGlobalEntries(v1);
        return ((RegistrationHandle)v1);
    }

    public final RegistrationHandle registerOnRectChanged(int arg11, long arg12, long arg14, DelegatableNode arg16, Function1 arg17) {
        long v6 = arg14 == 0 ? arg12 : arg14;
        return this.multiPut(this.rectChangedMap, arg11, new Entry(this, arg11, arg12, v6, arg16, arg17));
    }

    private final boolean removeFromGlobalEntries(Entry arg5) {
        Entry v0 = this.globalChangeEntries;
        Entry v2 = null;
        if(v0 == arg5) {
            this.globalChangeEntries = v0.getNext();
            arg5.setNext(v2);
            return 1;
        }

        Entry v4;
        for(v4 = v0 != null ? v0.getNext() : v2; true; v4 = v0.getNext()) {
            Entry v3 = v0;
            v0 = v4;
            v4 = v3;
            if(v0 == null) {
                return 0;
            }

            if(v0 == arg5) {
                if(v4 != null) {
                    v4.setNext(v0.getNext());
                }

                arg5.setNext(v2);
                return 1;
            }
        }

        return 0;
    }

    private final long roundDownToMultipleOf8(long arg1) {
        return arg1 >> 3 << 3;
    }

    private final void runFor(MutableIntObjectMap arg1, int arg2, Function1 arg3) {
        Object v0 = arg1.get(arg2);
        while(v0 != null) {
            Entry v1 = ((Entry)v0).getNext();
            arg3.invoke(v0);
            Entry v0_1 = v1;
        }
    }

    public final void setGlobalChangeEntries(Entry arg1) {
        this.globalChangeEntries = arg1;
    }

    public final void setMinDebounceDeadline(long arg1) {
        this.minDebounceDeadline = arg1;
    }

    public final void setScreenOffset--gyyYBs(long arg1) {
        this.screenOffset = arg1;
    }

    public final void setViewToWindowMatrix-Q8lPUPs(float[] arg1) {
        this.viewToWindowMatrix = arg1;
    }

    public final void setWindowOffset--gyyYBs(long arg1) {
        this.windowOffset = arg1;
    }

    public final void setWindowSize(long arg1) {
        this.windowSize = arg1;
    }

    public final void triggerDebounced(long arg27) {
        int v21;
        long v17;
        long v9;
        long v7;
        ThrottledCallbacks v0 = this;
        if(v0.minDebounceDeadline > arg27) {
            return;
        }

        long v2 = v0.windowOffset;
        long v4 = v0.screenOffset;
        float[] v6 = v0.viewToWindowMatrix;
        MutableIntObjectMap v1 = v0.rectChangedMap;
        Object[] v11 = ((IntObjectMap)v1).values;
        long[] v12 = ((IntObjectMap)v1).metadata;
        int v13 = v12.length - 2;
        if(v13 >= 0) {
            int v1_1 = 0;
            v7 = 0x7FFFFFFFFFFFFFFFL;
            while(true) {
                v9 = v12[v1_1];
                v17 = 0x7FFFFFFFFFFFFFFFL;
                if((~v9 << 7 & v9 & -9187201950435737472L) != -9187201950435737472L) {
                    int v15 = 8;
                    int v14 = 8 - (~(v1_1 - v13) >>> 0x1F);
                    long v19 = v9;
                    int v9_1 = 0;
                    while(v9_1 < v14) {
                        if((v19 & 0xFF) < 0x80) {
                            Object v10 = v11[(v1_1 << 3) + v9_1];
                            while(v10 != null) {
                                v7 = v0.debounceEntry-b8qMvQI(v10, v2, v4, v6, arg27, v7);
                                v9_1 = v9_1;
                                Entry v10_1 = v10_1.getNext();
                                v1_1 = v1_1;
                            }

                            v21 = v9_1;
                        }
                        else {
                            v21 = v9_1;
                        }

                        v19 >>= v15;
                        v9_1 = v21 + 1;
                        v1_1 = v1_1;
                    }

                    int v25 = v1_1;
                    if(v14 != v15) {
                        break;
                    }

                    v1_1 = v25;
                }

                if(v1_1 == v13) {
                    break;
                }

                ++v1_1;
            }
        }
        else {
            v17 = 0x7FFFFFFFFFFFFFFFL;
            v7 = v17;
        }

        Entry v1_2 = v0.globalChangeEntries;
        if(v1_2 != null) {
            v9 = v7;
            while(v1_2 != null) {
                v9 = v0.debounceEntry-b8qMvQI(v1_2, v2, v4, v6, arg27, v9);
                v1_2 = v1_2.getNext();
            }

            v7 = v9;
        }

        if(v7 == v17) {
            v7 = -1;
        }

        v0.minDebounceDeadline = v7;
    }

    public final boolean updateOffsets-LDcG7Xg(long arg5, long arg7, float[] arg9, int arg10, int arg11) {
        boolean v7;
        if(!IntOffset.equals-impl0(arg7, this.windowOffset)) {
            this.windowOffset = arg7;
            v7 = true;
        }
        else {
            v7 = false;
        }

        if(!IntOffset.equals-impl0(arg5, this.screenOffset)) {
            this.screenOffset = arg5;
            v7 = true;
        }

        if(arg9 != null) {
            this.viewToWindowMatrix = arg9;
            v7 = true;
        }

        arg5 = (((long)arg10)) << 0x20 | (((long)arg11)) & 0xFFFFFFFFL;
        if(arg5 != this.windowSize) {
            this.windowSize = arg5;
            return 1;
        }

        return v7;
    }
}

