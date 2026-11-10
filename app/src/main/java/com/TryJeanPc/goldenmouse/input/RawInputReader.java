package com.TryJeanPc.goldenmouse.input;

import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\b\u0007\u0018\u0000 92\u00020\u0001:\u00019B#\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0016\u001A\u00020\u0007J\u0010\u0010\u0017\u001A\u00020\u00072\u0006\u0010\u0018\u001A\u00020\u0019H\u0002J\u0018\u0010\u001A\u001A\u00020\u000E2\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001B\u001A\u00020\u0010H\u0002J \u0010\u001C\u001A\u00020\u00072\u0006\u0010\u001D\u001A\u00020\u00102\u0006\u0010\u001E\u001A\u00020\u00102\u0006\u0010\u001F\u001A\u00020\u0010H\u0002J \u0010 \u001A\u00020\u00072\u0006\u0010\u001E\u001A\u00020\u00192\u0006\u0010!\u001A\u00020\u00192\u0006\u0010\"\u001A\u00020\u0010H\u0002J\u0018\u0010#\u001A\u00020\u00072\u0006\u0010$\u001A\u00020\u00192\u0006\u0010\u001F\u001A\u00020\u0010H\u0002J\u0018\u0010%\u001A\u00020\u00072\u0006\u0010$\u001A\u00020\u00192\u0006\u0010&\u001A\u00020\u000BH\u0002J \u0010\'\u001A\u00020\u00072\u0006\u0010\u001E\u001A\u00020\u00192\u0006\u0010!\u001A\u00020\u00192\u0006\u0010\"\u001A\u00020\u0010H\u0002J\u0018\u0010(\u001A\u00020\u00072\u0006\u0010)\u001A\u00020*2\u0006\u0010\u001F\u001A\u00020\u0010H\u0002J\u0018\u0010+\u001A\u00020\u00072\u0006\u0010)\u001A\u00020*2\u0006\u0010&\u001A\u00020\u000BH\u0002J\u0018\u0010,\u001A\u00020\u00072\u0006\u0010\u001E\u001A\u00020\u00102\u0006\u0010\u001F\u001A\u00020\u0010H\u0002J\u0012\u0010-\u001A\u0004\u0018\u00010*2\u0006\u0010\u001E\u001A\u00020\u0010H\u0002J\u0018\u0010.\u001A\u00020\u00072\u0006\u0010\u001E\u001A\u00020\u00192\u0006\u0010\"\u001A\u00020\u0010H\u0002J\b\u0010/\u001A\u000200H\u0002J\b\u00101\u001A\u00020\u0007H\u0002J\u001F\u00102\u001A\u0004\u0018\u00010\u000B2\u0006\u0010!\u001A\u00020\u00192\u0006\u0010\"\u001A\u00020\u0010H\u0002¢\u0006\u0002\u00103J\u0010\u00104\u001A\u00020\u00102\u0006\u0010$\u001A\u00020\u0019H\u0002J\u0016\u00105\u001A\b\u0012\u0004\u0012\u00020\u0019062\u0006\u0010$\u001A\u00020\u0019H\u0002J\u0010\u00107\u001A\u00020\u00102\u0006\u00108\u001A\u00020\u0019H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006:"}, d2={"Lcom/TryJeanPc/goldenmouse/input/RawInputReader;", "", "captureSession", "Lcom/TryJeanPc/goldenmouse/input/DeviceCaptureSession;", "eventConsumer", "Lkotlin/Function1;", "Lcom/TryJeanPc/goldenmouse/input/InputEvent;", "", "<init>", "(Lcom/TryJeanPc/goldenmouse/input/DeviceCaptureSession;Lkotlin/jvm/functions/Function1;)V", "synchronizationLost", "", "nativeReadOpen", "nativeReadStartedNanos", "", "readDx", "", "readDy", "pendingMouseDx", "pendingMouseDy", "pendingScrollX", "pendingScrollY", "read", "parseLineFast", "line", "", "decimalToken", "offset", "parseNumericEvent", "eventType", "code", "value", "parseKeyboardCode", "valueText", "valueInt", "parseKeyboardValue", "keyName", "emitKeyboardEvent", "pressed", "parseButtonCode", "parseButtonValue", "button", "Lcom/TryJeanPc/goldenmouse/input/InputEvent$Button;", "emitMouseButton", "parseNumericRelCode", "numericMouseButton", "parseRelCode", "invalidateSynchronization", "", "flushSyncValues", "parsePressedState", "(Ljava/lang/String;I)Ljava/lang/Boolean;", "androidToKeyEventCode", "expandKeyCandidates", "", "parseValue", "raw", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class RawInputReader {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2={"Lcom/TryJeanPc/goldenmouse/input/RawInputReader$Companion;", "", "<init>", "()V", "INVALID_TOKEN", "", "EV_SYN", "", "EV_KEY", "EV_REL", "SYN_REPORT", "SYN_DROPPED", "REL_X", "REL_Y", "REL_HWHEEL", "REL_WHEEL", "BTN_LEFT", "BTN_RIGHT", "BTN_MIDDLE", "BTN_SIDE", "BTN_EXTRA", "BTN_FORWARD", "BTN_BACK", "BTN_TASK", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final int $stable = 0;
    @Deprecated public static final int BTN_BACK = 278;
    @Deprecated public static final int BTN_EXTRA = 276;
    @Deprecated public static final int BTN_FORWARD = 277;
    @Deprecated public static final int BTN_LEFT = 0x110;
    @Deprecated public static final int BTN_MIDDLE = 274;
    @Deprecated public static final int BTN_RIGHT = 273;
    @Deprecated public static final int BTN_SIDE = 275;
    @Deprecated public static final int BTN_TASK = 279;
    private static final Companion Companion = null;
    @Deprecated public static final int EV_KEY = 1;
    @Deprecated public static final int EV_REL = 2;
    @Deprecated public static final int EV_SYN = 0;
    @Deprecated public static final long INVALID_TOKEN = -1;
    @Deprecated public static final int REL_HWHEEL = 6;
    @Deprecated public static final int REL_WHEEL = 8;
    @Deprecated public static final int REL_X = 0;
    @Deprecated public static final int REL_Y = 1;
    @Deprecated public static final int SYN_DROPPED = 3;
    @Deprecated public static final int SYN_REPORT;
    private final DeviceCaptureSession captureSession;
    private final Function1 eventConsumer;
    private boolean nativeReadOpen;
    private long nativeReadStartedNanos;
    private int pendingMouseDx;
    private int pendingMouseDy;
    private int pendingScrollX;
    private int pendingScrollY;
    private int readDx;
    private int readDy;
    private boolean synchronizationLost;

    static {
        RawInputReader.Companion = new Companion(null);
        RawInputReader.$stable = 8;
    }

    public RawInputReader(DeviceCaptureSession arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "captureSession");
        Intrinsics.checkNotNullParameter(arg3, "eventConsumer");
        super();
        this.captureSession = arg2;
        this.eventConsumer = arg3;
    }

    private final int androidToKeyEventCode(String arg6) {
        int v6_1;
        int v0 = arg6.hashCode();
        if(v0 != 65) {
            if(v0 != 68) {
                if(v0 != 83) {
                    if(v0 != 87) {
                        if(v0 != 79100134) {
                            goto label_39;
                        }
                        else if(!arg6.equals("SPACE")) {
                            goto label_39;
                        }
                        else {
                            v0 = 62;
                        }
                    }
                    else if(arg6.equals("W")) {
                        v0 = 51;
                    }
                    else {
                        goto label_39;
                    }
                }
                else if(!arg6.equals("S")) {
                    goto label_39;
                }
                else {
                    v0 = 0x2F;
                }
            }
            else if(!arg6.equals("D")) {
                goto label_39;
            }
            else {
                v0 = 0x20;
            }
        }
        else if(!arg6.equals("A")) {
        label_39:
            v0 = 0;
        }
        else {
            v0 = 29;
        }

        if(v0 != 0) {
            return v0;
        }

        ArrayList v0_1 = new ArrayList();
        String v3 = "KEYCODE_";
        ((List)v0_1).add(v3 + arg6);
        List v5 = this.expandKeyCandidates(arg6);
        ArrayList v6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v5), 10));
        Iterator v5_1 = ((Iterable)v5).iterator();
        while(v5_1.hasNext()) {
            ((Collection)v6).add(v3 + v5_1.next());
        }

        ((List)v0_1).addAll(((Collection)v6));
        v5_1 = ((List)v0_1).iterator();
        do {
            if(!v5_1.hasNext()) {
                return 0;
            }

            v6_1 = KeyEvent.keyCodeFromString(v5_1.next());
        }
        while(v6_1 == 0);

        return v6_1;
    }

    private final long decimalToken(String arg12, int arg13) {
        long v6;
        while(arg13 < arg12.length()) {
            if(!CharsKt.isWhitespace(arg12.charAt(arg13))) {
                break;
            }

            ++arg13;
        }

        int v11 = arg13 >= arg12.length() || arg12.charAt(arg13) != 45 ? 0 : 1;
        if(v11 != 0) {
            ++arg13;
        }

        long v0 = v11 != 0 ? 0x80000000L : 0x7FFFFFFF;
        long v2 = 0;
        int v4 = arg13;
        while(true) {
            v6 = -1;
            if(v4 < arg12.length()) {
                int v5 = arg12.charAt(v4);
                int v8 = 0x30;
                if(v8 <= v5 && v5 < 58) {
                    v5 = v4 + 1;
                    v2 = v2 * 10 + (((long)(arg12.charAt(v4) - v8)));
                    if(v2 > v0) {
                        return v6;
                    }
                    else {
                        v4 = v5;
                        continue;
                    }
                }
            }

            break;
        }

        if(v4 != arg13 && (v4 >= arg12.length() || (CharsKt.isWhitespace(arg12.charAt(v4))))) {
            if(v11 != 0) {
                v2 = -v2;
            }

            return (((long)v4)) << 0x20 | 0xFFFFFFFFL & v2;
        }

        return v6;
    }

    private final void emitKeyboardEvent(String arg11, boolean arg12) {
        KeyDown v0;
        int v1 = this.androidToKeyEventCode(arg11);
        long v3 = System.nanoTime();
        if(arg12) {
            v0 = new KeyDown(v1, arg11, v3, this.captureSession.getDescriptor().getPath(), 0, 16, null);
        }
        else {
            KeyUp v0_1 = new KeyUp(v1, arg11, v3, this.captureSession.getDescriptor().getPath(), 0, 16, null);
        }

        KeyboardRouteDiagnostics.key$default(KeyboardRouteDiagnostics.INSTANCE, Stage.PARSED_KEY, v0, null, null, "requestedMode=" + this.captureSession.getCaptureMode() + " captureState=" + this.captureSession.getState(), 12, null);
        this.eventConsumer.invoke(v0);
    }

    private final void emitMouseButton(Button arg12, boolean arg13) {
        this.eventConsumer.invoke(new MouseButton(arg12, arg13, System.nanoTime(), this.captureSession.getDescriptor().getPath(), 0, 16, null));
    }

    private final List expandKeyCandidates(String arg8) {
        String v2_1;
        String[] v1_1;
        String v7 = "LEFT";
        int v1 = 2;
        Object v2 = null;
        String v5 = "substring(...)";
        if(StringsKt.startsWith$default(arg8, v7, false, v1, v2)) {
            int v6 = 4;
            if(arg8.length() > v6) {
                v1_1 = new String[v1];
                v2_1 = arg8.substring(v6);
                Intrinsics.checkNotNullExpressionValue(v2_1, v5);
                v1_1[0] = v2_1 + "_LEFT";
                arg8 = arg8.substring(v6);
                Intrinsics.checkNotNullExpressionValue(arg8, v5);
                v1_1[1] = arg8 + v7;
                return CollectionsKt.listOf(((Object[])v1_1));
            }
        }

        v7 = "RIGHT";
        if(StringsKt.startsWith$default(arg8, v7, false, v1, v2)) {
            int v3 = 5;
            if(arg8.length() > v3) {
                v1_1 = new String[v1];
                v2_1 = arg8.substring(v3);
                Intrinsics.checkNotNullExpressionValue(v2_1, v5);
                v1_1[0] = v2_1 + "_RIGHT";
                arg8 = arg8.substring(v3);
                Intrinsics.checkNotNullExpressionValue(arg8, v5);
                v1_1[1] = arg8 + v7;
                return CollectionsKt.listOf(((Object[])v1_1));
            }
        }

        return CollectionsKt.emptyList();
    }

    private final void flushSyncValues() {
        long v3 = System.nanoTime();
        String v5 = this.captureSession.getDescriptor().getPath();
        if(this.pendingMouseDx != 0 || this.pendingMouseDy != 0) {
            Function1 v12 = this.eventConsumer;
            int v1 = this.pendingMouseDx;
            int v2 = this.pendingMouseDy;
            Boolean v6 = this.nativeReadOpen ? Boolean.valueOf(false) : null;
            v12.invoke(new MouseMove(v1, v2, v3, v5, 0, v6, 16, null));
            this.pendingMouseDx = 0;
            this.pendingMouseDy = 0;
        }

        if(this.pendingScrollX == 0) {
            if(this.pendingScrollY != 0) {
            }
            else {
                return;
            }
        }

        int v10 = this.pendingScrollY;
        this.eventConsumer.invoke(new Scroll(this.pendingScrollX, this.pendingScrollY, v3, v5, 0, 16, null));
        if(v10 > 0) {
            this.emitKeyboardEvent("SCROLL_UP", true);
            this.emitKeyboardEvent("SCROLL_UP", false);
        }
        else if(v10 < 0) {
            this.emitKeyboardEvent("SCROLL_DOWN", true);
            this.emitKeyboardEvent("SCROLL_DOWN", false);
        }

        this.pendingScrollX = 0;
        this.pendingScrollY = 0;
    }

    private final Void invalidateSynchronization() {
        this.synchronizationLost = true;
        this.nativeReadOpen = false;
        this.readDx = 0;
        this.readDy = 0;
        this.pendingMouseDx = 0;
        this.pendingMouseDy = 0;
        this.pendingScrollX = 0;
        this.pendingScrollY = 0;
        throw new InputSynchronizationLost(this.captureSession.getDescriptor().getPath());
    }

    private final Button numericMouseButton(int arg1) {
        switch(arg1) {
            case 272: {
                goto label_11;
            }
            case 273: {
                goto label_9;
            }
            case 274: {
                goto label_7;
            }
            case 275: 
            case 278: {
                goto label_5;
            }
            case 276: 
            case 277: 
            case 279: {
                goto label_3;
            }
        }

        return null;
    label_3:
        return Button.SIDE_2;
    label_5:
        return Button.SIDE_1;
    label_7:
        return Button.MIDDLE;
    label_9:
        return Button.RIGHT;
    label_11:
        return Button.LEFT;
    }

    private final void parseButtonCode(String arg2, String arg3, int arg4) {
        Button v2;
        switch(arg2.hashCode()) {
            case 1189596066: {
                if(!arg2.equals("BTN_FORWARD")) {
                    goto label_45;
                }

            label_27:
                v2 = Button.SIDE_2;
                goto label_46;
            }
            case 1895369976: {
                if(!arg2.equals("BTN_MIDDLE")) {
                    goto label_45;
                }

                v2 = Button.MIDDLE;
                goto label_46;
            }
            case -1374897910: {
                if(arg2.equals("BTN_BACK")) {
                    goto label_43;
                }

                break;
            }
            case -1374596054: {
                if(!arg2.equals("BTN_LEFT")) {
                    goto label_45;
                }

                v2 = Button.LEFT;
                goto label_46;
            }
            case -1374383750: {
                if(arg2.equals("BTN_SIDE")) {
                    goto label_43;
                }

                break;
            }
            case -1374361176: {
                if(arg2.equals("BTN_TASK")) {
                    goto label_27;
                }

                break;
            }
            case 331310125: {
                if(arg2.equals("BTN_EXTRA")) {
                    goto label_27;
                }

                break;
            }
            case 342856249: {
                if(!arg2.equals("BTN_RIGHT")) {
                    goto label_45;
                }

                v2 = Button.RIGHT;
                goto label_46;
            }
            default: {
                break;
            }
        }

    label_45:
        v2 = Button.UNKNOWN;
        goto label_46;
    label_43:
        v2 = Button.SIDE_1;
    label_46:
        if(v2 == Button.UNKNOWN) {
        }
        else {
            Boolean v3 = this.parsePressedState(arg3, arg4);
            if(v3 != null) {
                this.emitMouseButton(v2, v3.booleanValue());
            }
        }
    }

    private final void parseButtonValue(Button arg2, int arg3) {
        Boolean v3 = this.parsePressedState(String.valueOf(arg3), arg3);
        if(v3 != null) {
            this.emitMouseButton(arg2, v3.booleanValue());
        }
    }

    private final void parseKeyboardCode(String arg1, String arg2, int arg3) {
        Boolean v2 = this.parsePressedState(arg2, arg3);
        if(v2 != null) {
            boolean v2_1 = v2.booleanValue();
            arg1 = StringsKt.removePrefix(arg1, "KEY_").toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(arg1, "toUpperCase(...)");
            this.emitKeyboardEvent(arg1, v2_1);
        }
    }

    private final void parseKeyboardValue(String arg2, int arg3) {
        Boolean v3 = this.parsePressedState(String.valueOf(arg3), arg3);
        if(v3 != null) {
            this.emitKeyboardEvent(arg2, v3.booleanValue());
        }
    }

    private final void parseLineFast(String arg22) {
        Integer v4_2;
        int v5;
        int v3;
        RawInputReader v0 = this;
        String v1 = StringsKt.trim(arg22).toString();
        String v2 = v1;
        if(((CharSequence)v2).length() == 0) {
            return;
        }

        if(Intrinsics.areEqual(v1, "GOLDEN_READ_BEGIN")) {
            v0.nativeReadOpen = true;
            v0.nativeReadStartedNanos = System.nanoTime();
            v0.readDx = 0;
            v0.readDy = 0;
            return;
        }

        if(Intrinsics.areEqual(v1, "GOLDEN_READ_END")) {
            if((v0.nativeReadOpen) && (v0.readDx != 0 || v0.readDy != 0)) {
                v0.eventConsumer.invoke(new MouseMove(v0.readDx, v0.readDy, v0.nativeReadStartedNanos, v0.captureSession.getDescriptor().getPath(), 0, Boolean.valueOf(true), 16, null));
            }

            v0.nativeReadOpen = false;
            v0.readDx = 0;
            v0.readDy = 0;
            return;
        }

        int v10 = 2;
        Object v11 = null;
        int v12 = 0x20;
        if(StringsKt.startsWith$default(v1, "GOLDEN_EVENT", false, v10, v11)) {
            v3 = 12;
            if(v1.length() > v3) {
                if(!CharsKt.isWhitespace(v1.charAt(v3))) {
                }
                else {
                    long v2_1 = v0.decimalToken(v1, v3);
                    long v4 = -1;
                    if(v2_1 == v4) {
                    }
                    else {
                        long v6 = v0.decimalToken(v1, ((int)(v2_1 >>> v12)));
                        if(v6 == v4) {
                        }
                        else {
                            long v8 = v0.decimalToken(v1, ((int)(v6 >>> v12)));
                            if(v8 == v4) {
                            }
                            else {
                                v0.parseNumericEvent(((int)v2_1), ((int)v6), ((int)v8));
                                return;
                            }
                        }
                    }
                }
            }
        }
        else {
            int v2_2 = StringsKt.indexOf$default(((CharSequence)v2), "EV_", 0, false, 6, null);
            if(v2_2 < 0) {
            }
            else {
                v1 = v1.substring(v2_2 + 3);
                v2 = "substring(...)";
                Intrinsics.checkNotNullExpressionValue(v1, v2);
                v3 = 0;
                while(true) {
                    v5 = 9;
                    if(v3 < v1.length() && v1.charAt(v3) != v12 && v1.charAt(v3) != v5) {
                        ++v3;
                        continue;
                    }

                    break;
                }

                if(v3 >= v1.length()) {
                    return;
                }

                String v4_1 = v1.substring(0, v3);
                Intrinsics.checkNotNullExpressionValue(v4_1, v2);
                while(v3 < v1.length()) {
                    if(v1.charAt(v3) != v12 && v1.charAt(v3) != v5) {
                        break;
                    }

                    ++v3;
                }

                if(v3 >= v1.length()) {
                    return;
                }

                int v6_1;
                for(v6_1 = v3; v6_1 < v1.length(); ++v6_1) {
                    if(v1.charAt(v6_1) == v12) {
                        break;
                    }

                    if(v1.charAt(v6_1) == v5) {
                        break;
                    }
                }

                if(v6_1 >= v1.length()) {
                    return;
                }

                String v3_1 = v1.substring(v3, v6_1);
                Intrinsics.checkNotNullExpressionValue(v3_1, v2);
                while(v6_1 < v1.length()) {
                    if(v1.charAt(v6_1) != v12 && v1.charAt(v6_1) != v5) {
                        break;
                    }

                    ++v6_1;
                }

                if(v6_1 >= v1.length()) {
                    return;
                }

                v1 = v1.substring(v6_1);
                Intrinsics.checkNotNullExpressionValue(v1, v2);
                v1 = StringsKt.trim(((CharSequence)v1)).toString();
                v2_2 = v0.parseValue(v1);
                v5 = v4_1.hashCode();
                if(v5 != 74303) {
                    if(v5 != 81017) {
                        if(v5 != 82600) {
                            return;
                        }

                        if(!v4_1.equals("SYN")) {
                            return;
                        }

                        int v1_1 = v3_1.hashCode();
                        if(v1_1 != 0x8AABB509) {
                            if(v1_1 != 0x978536AB) {
                                if(v1_1 != 0x168C03) {
                                    return;
                                }
                                else if(!v3_1.equals("0003")) {
                                    return;
                                }
                            }
                            else if(!v3_1.equals("SYN_REPORT")) {
                                return;
                            }
                            else {
                                v0.flushSyncValues();
                                return;
                            }
                        }
                        else if(!v3_1.equals("SYN_DROPPED")) {
                            return;
                        }

                        v0.invalidateSynchronization();
                        throw new KotlinNothingValueException();
                    }

                    if(!v4_1.equals("REL")) {
                        return;
                    }

                    v0.parseRelCode(v3_1, v2_2);
                    return;
                }

                if(!v4_1.equals("KEY")) {
                    return;
                }

                if(v3_1.length() == 4) {
                    v4_1 = v3_1;
                    for(v5 = 0; v5 < ((CharSequence)v4_1).length(); ++v5) {
                        char v6_2 = ((CharSequence)v4_1).charAt(v5);
                        if(!Character.isDigit(v6_2)) {
                            v6_1 = Character.toLowerCase(v6_2);
                            if(97 > v6_1) {
                            }
                            else if(v6_1 < 103) {
                                goto label_208;
                            }

                            goto label_213;
                        }

                    label_208:
                    }

                    v4_2 = StringsKt.toIntOrNull(v3_1, 16);
                }
                else {
                label_213:
                    v4_2 = ((Integer)v11);
                }

                String v5_1 = "BTN_";
                String v7 = "KEY_";
                if(!StringsKt.startsWith$default(v3_1, v5_1, false, v10, v11) && v4_2 == null) {
                    KeyboardRouteDiagnostics.INSTANCE.rawKey(v0.captureSession, v3_1, StringsKt.startsWith$default(v3_1, v7, false, v10, v11));
                }

                if(StringsKt.startsWith$default(v3_1, v7, false, v10, v11)) {
                    v0.parseKeyboardCode(v3_1, v1, v2_2);
                    return;
                }

                if(StringsKt.startsWith$default(v3_1, v5_1, false, v10, v11)) {
                    v0.parseButtonCode(v3_1, v1, v2_2);
                    return;
                }

                if(v4_2 == null) {
                    return;
                }

                Boolean v1_2 = v0.parsePressedState(v1, v2_2);
                if(v1_2 == null) {
                    return;
                }

                v0.parseNumericEvent(1, v4_2.intValue(), v1_2.booleanValue());
            }
        }
    }

    private final void parseNumericEvent(int arg4, int arg5, int arg6) {
        if(arg4 != 0) {
            if(arg4 == 1) {
                Button v4 = this.numericMouseButton(arg5);
                if(v4 != null) {
                    this.parseButtonValue(v4, arg6);
                    return;
                }
                else {
                    KeyboardRouteDiagnostics.INSTANCE.rawKey(this.captureSession, String.valueOf(arg5), true);
                    this.parseKeyboardValue(LinuxKeyCodeMap.INSTANCE.name(arg5), arg6);
                    return;
                }
            }
            else if(arg4 != 2) {
            }
            else {
                this.parseNumericRelCode(arg5, arg6);
                return;
            }
        }
        else if(arg5 != 0) {
            if(arg5 != 3) {
                return;
            }

            goto label_24;
        }
        else {
            goto label_28;
        }

        return;
    label_24:
        this.invalidateSynchronization();
        throw new KotlinNothingValueException();
    label_28:
        this.flushSyncValues();
    }

    private final void parseNumericRelCode(int arg2, int arg3) {
        if(arg2 == 0) {
            this.pendingMouseDx += arg3;
            if(this.nativeReadOpen) {
                this.readDx += arg3;
            }
        }
        else if(arg2 == 1) {
            this.pendingMouseDy += arg3;
            if(this.nativeReadOpen) {
                this.readDy += arg3;
                return;
            }
        }
        else if(arg2 == 6) {
            this.pendingScrollX += arg3;
            return;
        }
        else if(arg2 != 8) {
        }
        else {
            this.pendingScrollY += arg3;
            return;
        }
    }

    private final Boolean parsePressedState(String arg6, int arg7) {
        String v5 = arg6.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(v5, "toUpperCase(...)");
        int v6 = v5.hashCode();
        Boolean v1 = Boolean.valueOf(false);
        Boolean v2 = null;
        Boolean v4 = Boolean.valueOf(true);
        if(v6 == 0x8FDF219B) {
            if(!v5.equals("REPEAT")) {
                goto label_30;
            }

            return v2;
        }
        else if(v6 != 0xA9B) {
            if(v6 != 0x201CA2) {
            }
            else if(!v5.equals("DOWN")) {
            }
            else {
                return v4;
            }
        }
        else if(!v5.equals("UP")) {
        }
        else {
            return v1;
        }

    label_30:
        if(arg7 != 0) {
            if(arg7 != 1) {
                return v2;
            }

            return v4;
        }

        return v1;
    }

    private final void parseRelCode(String arg2, int arg3) {
        switch(arg2.hashCode()) {
            case -654416907: {
                if(!arg2.equals("REL_WHEEL")) {
                    return;
                }

                this.pendingScrollY += arg3;
                break;
            }
            case 77860370: {
                if(!arg2.equals("REL_X")) {
                    return;
                }

                this.pendingMouseDx += arg3;
                return;
            }
            case 77860371: {
                if(!arg2.equals("REL_Y")) {
                    return;
                }

                this.pendingMouseDy += arg3;
                return;
            }
            case 772417145: {
                if(!arg2.equals("REL_HWHEEL")) {
                    return;
                }

                this.pendingScrollX += arg3;
                return;
            }
            default: {
                break;
            }
        }
    }

    private final int parseValue(String arg3) {
        String v2 = StringsKt.removePrefix(arg3, "0x");
        if(v2.length() > 8) {
            return 0;
        }

        Long v2_1 = StringsKt.toLongOrNull(v2, 16);
        if(v2_1 != null) {
            return ((int)v2_1.longValue());
        }

        return 0;
    }

    public final void read() {
        String v0;
        if(!this.synchronizationLost) {
            while(!Thread.currentThread().isInterrupted()) {
                try {
                    v0 = this.captureSession.readLine();
                    if(v0 != null) {
                        goto label_9;
                    }
                }
                catch(Exception v1) {
                    throw v1;
                }
                catch(InterruptedException ) {
                    Thread.currentThread().interrupt();
                    return;
                }

                return;
            label_9:
                this.parseLineFast(v0);
            }

            return;
        }

        throw new InputSynchronizationLost(this.captureSession.getDescriptor().getPath());
    }
}

