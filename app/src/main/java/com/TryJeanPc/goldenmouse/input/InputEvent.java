package com.TryJeanPc.goldenmouse.input;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u001F2\u00020\u0001:\b\u0018\u0019\u001A\u001B\u001C\u001D\u001E\u001FB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0016\u001A\u00020\u00002\u0006\u0010\u0017\u001A\u00020\tR\u0012\u0010\u0004\u001A\u00020\u0005X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001A\u00020\tX¦\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\f\u001A\u0004\u0018\u00010\rX¦\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0012\u0010\u0010\u001A\u00020\tX¦\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u000BR\u0012\u0010\u0012\u001A\u00020\u0013X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015\u0082\u0001\u0005 !\"#$¨\u0006%"}, d2={"Lcom/TryJeanPc/goldenmouse/input/InputEvent;", "", "<init>", "()V", "type", "Lcom/TryJeanPc/goldenmouse/input/InputEvent$Type;", "getType", "()Lcom/TryJeanPc/goldenmouse/input/InputEvent$Type;", "timestampNanos", "", "getTimestampNanos", "()J", "devicePath", "", "getDevicePath", "()Ljava/lang/String;", "sequenceNumber", "getSequenceNumber", "sourceRole", "Lcom/TryJeanPc/goldenmouse/input/InputDeviceRole;", "getSourceRole", "()Lcom/TryJeanPc/goldenmouse/input/InputDeviceRole;", "withSequenceNumber", "value", "Type", "Button", "KeyDown", "KeyUp", "MouseMove", "MouseButton", "Scroll", "Companion", "Lcom/TryJeanPc/goldenmouse/input/InputEvent$KeyDown;", "Lcom/TryJeanPc/goldenmouse/input/InputEvent$KeyUp;", "Lcom/TryJeanPc/goldenmouse/input/InputEvent$MouseButton;", "Lcom/TryJeanPc/goldenmouse/input/InputEvent$MouseMove;", "Lcom/TryJeanPc/goldenmouse/input/InputEvent$Scroll;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public abstract class InputEvent {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2={"Lcom/TryJeanPc/goldenmouse/input/InputEvent$Button;", "", "<init>", "(Ljava/lang/String;I)V", "LEFT", "RIGHT", "MIDDLE", "SIDE_1", "SIDE_2", "UNKNOWN", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum Button {
        public static final enum Button LEFT;
        public static final enum Button MIDDLE;
        public static final enum Button RIGHT;
        public static final enum Button SIDE_1;
        public static final enum Button SIDE_2;
        public static final enum Button UNKNOWN;

        private static final Button[] $values() {
            return new Button[]{Button.LEFT, Button.RIGHT, Button.MIDDLE, Button.SIDE_1, Button.SIDE_2, Button.UNKNOWN};
        }

        static {
            Button.LEFT = new Button("LEFT", 0);
            Button.RIGHT = new Button("RIGHT", 1);
            Button.MIDDLE = new Button("MIDDLE", 2);
            Button.SIDE_1 = new Button("SIDE_1", 3);
            Button.SIDE_2 = new Button("SIDE_2", 4);
            Button.UNKNOWN = new Button("UNKNOWN", 5);
            Button[] v0 = Button.$values();
            Button.$VALUES = v0;
            Button.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private Button(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return Button.$ENTRIES;
        }

        public static Button valueOf(String arg1) {
            return Enum.valueOf(Button.class, arg1);
        }

        public static Button[] values() {
            return Button.$VALUES.clone();
        }
    }

    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Lcom/TryJeanPc/goldenmouse/input/InputEvent$Companion;", "", "<init>", "()V", "UNASSIGNED_SEQUENCE_NUMBER", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    @Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001A\u00020\u0007¢\u0006\u0004\b\n\u0010\u000BJ\t\u0010\u001C\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001D\u001A\u00020\u0005HÆ\u0003J\t\u0010\u001E\u001A\u00020\u0007HÆ\u0003J\u000B\u0010\u001F\u001A\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010 \u001A\u00020\u0007HÆ\u0003J=\u0010!\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001A\u00020\u0007HÆ\u0001J\u0013\u0010\"\u001A\u00020#2\b\u0010$\u001A\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001A\u00020\u0003HÖ\u0001J\t\u0010\'\u001A\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0006\u001A\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0016\u0010\b\u001A\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u000FR\u0014\u0010\t\u001A\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001A\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001A\u00020\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001B¨\u0006("}, d2={"Lcom/TryJeanPc/goldenmouse/input/InputEvent$KeyDown;", "Lcom/TryJeanPc/goldenmouse/input/InputEvent;", "keyCode", "", "keyName", "", "timestampNanos", "", "devicePath", "sequenceNumber", "<init>", "(ILjava/lang/String;JLjava/lang/String;J)V", "getKeyCode", "()I", "getKeyName", "()Ljava/lang/String;", "getTimestampNanos", "()J", "getDevicePath", "getSequenceNumber", "type", "Lcom/TryJeanPc/goldenmouse/input/InputEvent$Type;", "getType", "()Lcom/TryJeanPc/goldenmouse/input/InputEvent$Type;", "sourceRole", "Lcom/TryJeanPc/goldenmouse/input/InputDeviceRole;", "getSourceRole", "()Lcom/TryJeanPc/goldenmouse/input/InputDeviceRole;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class KeyDown extends InputEvent {
        public static final int $stable;
        private final String devicePath;
        private final int keyCode;
        private final String keyName;
        private final long sequenceNumber;
        private final InputDeviceRole sourceRole;
        private final long timestampNanos;
        private final Type type;

        static {
        }

        public KeyDown(int arg2, String arg3, long arg4, String arg6, long arg7) {
            Intrinsics.checkNotNullParameter(arg3, "keyName");
            super(null);
            this.keyCode = arg2;
            this.keyName = arg3;
            this.timestampNanos = arg4;
            this.devicePath = arg6;
            this.sequenceNumber = arg7;
            this.type = Type.KEY_DOWN;
            this.sourceRole = InputDeviceRole.KEYBOARD;
        }

        public KeyDown(int arg9, String arg10, long arg11, String arg13, long arg14, int arg16, DefaultConstructorMarker arg17) {
            if((arg16 & 4) != 0) {
                arg11 = System.nanoTime();
            }

            long v3 = arg11;
            if((arg16 & 8) != 0) {
                arg13 = null;
            }

            String v5 = arg13;
            long v6 = (arg16 & 16) != 0 ? 0 : arg14;
            this(arg9, arg10, v3, v5, v6);
        }

        public final int component1() {
            return this.keyCode;
        }

        public final String component2() {
            return this.keyName;
        }

        public final long component3() {
            return this.timestampNanos;
        }

        public final String component4() {
            return this.devicePath;
        }

        public final long component5() {
            return this.sequenceNumber;
        }

        public final KeyDown copy(int arg9, String arg10, long arg11, String arg13, long arg14) {
            Intrinsics.checkNotNullParameter(arg10, "keyName");
            return new KeyDown(arg9, arg10, arg11, arg13, arg14);
        }

        public static KeyDown copy$default(KeyDown arg0, int arg1, String arg2, long arg3, String arg5, long arg6, int arg8, Object arg9) {
            if((arg8 & 1) != 0) {
                arg1 = arg0.keyCode;
            }

            if((arg8 & 2) != 0) {
                arg2 = arg0.keyName;
            }

            if((arg8 & 4) != 0) {
                arg3 = arg0.timestampNanos;
            }

            if((arg8 & 8) != 0) {
                arg5 = arg0.devicePath;
            }

            if((arg8 & 16) != 0) {
                arg6 = arg0.sequenceNumber;
            }

            return arg0.copy(arg1, arg2, arg3, arg5, arg6);
        }

        public boolean equals(Object arg8) {
            if(this == (((KeyDown)arg8))) {
                return 1;
            }

            if(!(arg8 instanceof KeyDown)) {
                return 0;
            }

            if(this.keyCode != ((KeyDown)arg8).keyCode) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.keyName, ((KeyDown)arg8).keyName)) {
                return 0;
            }

            if(this.timestampNanos != ((KeyDown)arg8).timestampNanos) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.devicePath, ((KeyDown)arg8).devicePath)) {
                return 0;
            }

            if(this.sequenceNumber != ((KeyDown)arg8).sequenceNumber) {
                return 0;
            }

            return 1;
        }

        public String getDevicePath() {
            return this.devicePath;
        }

        public final int getKeyCode() {
            return this.keyCode;
        }

        public final String getKeyName() {
            return this.keyName;
        }

        public long getSequenceNumber() {
            return this.sequenceNumber;
        }

        public InputDeviceRole getSourceRole() {
            return this.sourceRole;
        }

        public long getTimestampNanos() {
            return this.timestampNanos;
        }

        public Type getType() {
            return this.type;
        }

        public int hashCode() {
            int v0 = ((Integer.hashCode(this.keyCode) * 0x1F + this.keyName.hashCode()) * 0x1F + Long.hashCode(this.timestampNanos)) * 0x1F;
            String v1 = this.devicePath;
            int v1_1 = v1 == null ? 0 : v1.hashCode();
            return (v0 + v1_1) * 0x1F + Long.hashCode(this.sequenceNumber);
        }

        public String toString() {
            return "KeyDown(keyCode=" + this.keyCode + ", keyName=" + this.keyName + ", timestampNanos=" + this.timestampNanos + ", devicePath=" + this.devicePath + ", sequenceNumber=" + this.sequenceNumber + ")";
        }
    }

    @Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001A\u00020\u0007¢\u0006\u0004\b\n\u0010\u000BJ\t\u0010\u001C\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001D\u001A\u00020\u0005HÆ\u0003J\t\u0010\u001E\u001A\u00020\u0007HÆ\u0003J\u000B\u0010\u001F\u001A\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010 \u001A\u00020\u0007HÆ\u0003J=\u0010!\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001A\u00020\u0007HÆ\u0001J\u0013\u0010\"\u001A\u00020#2\b\u0010$\u001A\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001A\u00020\u0003HÖ\u0001J\t\u0010\'\u001A\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0006\u001A\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0016\u0010\b\u001A\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u000FR\u0014\u0010\t\u001A\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001A\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001A\u00020\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001B¨\u0006("}, d2={"Lcom/TryJeanPc/goldenmouse/input/InputEvent$KeyUp;", "Lcom/TryJeanPc/goldenmouse/input/InputEvent;", "keyCode", "", "keyName", "", "timestampNanos", "", "devicePath", "sequenceNumber", "<init>", "(ILjava/lang/String;JLjava/lang/String;J)V", "getKeyCode", "()I", "getKeyName", "()Ljava/lang/String;", "getTimestampNanos", "()J", "getDevicePath", "getSequenceNumber", "type", "Lcom/TryJeanPc/goldenmouse/input/InputEvent$Type;", "getType", "()Lcom/TryJeanPc/goldenmouse/input/InputEvent$Type;", "sourceRole", "Lcom/TryJeanPc/goldenmouse/input/InputDeviceRole;", "getSourceRole", "()Lcom/TryJeanPc/goldenmouse/input/InputDeviceRole;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class KeyUp extends InputEvent {
        public static final int $stable;
        private final String devicePath;
        private final int keyCode;
        private final String keyName;
        private final long sequenceNumber;
        private final InputDeviceRole sourceRole;
        private final long timestampNanos;
        private final Type type;

        static {
        }

        public KeyUp(int arg2, String arg3, long arg4, String arg6, long arg7) {
            Intrinsics.checkNotNullParameter(arg3, "keyName");
            super(null);
            this.keyCode = arg2;
            this.keyName = arg3;
            this.timestampNanos = arg4;
            this.devicePath = arg6;
            this.sequenceNumber = arg7;
            this.type = Type.KEY_UP;
            this.sourceRole = InputDeviceRole.KEYBOARD;
        }

        public KeyUp(int arg9, String arg10, long arg11, String arg13, long arg14, int arg16, DefaultConstructorMarker arg17) {
            if((arg16 & 4) != 0) {
                arg11 = System.nanoTime();
            }

            long v3 = arg11;
            if((arg16 & 8) != 0) {
                arg13 = null;
            }

            String v5 = arg13;
            long v6 = (arg16 & 16) != 0 ? 0 : arg14;
            this(arg9, arg10, v3, v5, v6);
        }

        public final int component1() {
            return this.keyCode;
        }

        public final String component2() {
            return this.keyName;
        }

        public final long component3() {
            return this.timestampNanos;
        }

        public final String component4() {
            return this.devicePath;
        }

        public final long component5() {
            return this.sequenceNumber;
        }

        public final KeyUp copy(int arg9, String arg10, long arg11, String arg13, long arg14) {
            Intrinsics.checkNotNullParameter(arg10, "keyName");
            return new KeyUp(arg9, arg10, arg11, arg13, arg14);
        }

        public static KeyUp copy$default(KeyUp arg0, int arg1, String arg2, long arg3, String arg5, long arg6, int arg8, Object arg9) {
            if((arg8 & 1) != 0) {
                arg1 = arg0.keyCode;
            }

            if((arg8 & 2) != 0) {
                arg2 = arg0.keyName;
            }

            if((arg8 & 4) != 0) {
                arg3 = arg0.timestampNanos;
            }

            if((arg8 & 8) != 0) {
                arg5 = arg0.devicePath;
            }

            if((arg8 & 16) != 0) {
                arg6 = arg0.sequenceNumber;
            }

            return arg0.copy(arg1, arg2, arg3, arg5, arg6);
        }

        public boolean equals(Object arg8) {
            if(this == (((KeyUp)arg8))) {
                return 1;
            }

            if(!(arg8 instanceof KeyUp)) {
                return 0;
            }

            if(this.keyCode != ((KeyUp)arg8).keyCode) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.keyName, ((KeyUp)arg8).keyName)) {
                return 0;
            }

            if(this.timestampNanos != ((KeyUp)arg8).timestampNanos) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.devicePath, ((KeyUp)arg8).devicePath)) {
                return 0;
            }

            if(this.sequenceNumber != ((KeyUp)arg8).sequenceNumber) {
                return 0;
            }

            return 1;
        }

        public String getDevicePath() {
            return this.devicePath;
        }

        public final int getKeyCode() {
            return this.keyCode;
        }

        public final String getKeyName() {
            return this.keyName;
        }

        public long getSequenceNumber() {
            return this.sequenceNumber;
        }

        public InputDeviceRole getSourceRole() {
            return this.sourceRole;
        }

        public long getTimestampNanos() {
            return this.timestampNanos;
        }

        public Type getType() {
            return this.type;
        }

        public int hashCode() {
            int v0 = ((Integer.hashCode(this.keyCode) * 0x1F + this.keyName.hashCode()) * 0x1F + Long.hashCode(this.timestampNanos)) * 0x1F;
            String v1 = this.devicePath;
            int v1_1 = v1 == null ? 0 : v1.hashCode();
            return (v0 + v1_1) * 0x1F + Long.hashCode(this.sequenceNumber);
        }

        public String toString() {
            return "KeyUp(keyCode=" + this.keyCode + ", keyName=" + this.keyName + ", timestampNanos=" + this.timestampNanos + ", devicePath=" + this.devicePath + ", sequenceNumber=" + this.sequenceNumber + ")";
        }
    }

    @Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000E\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001A\u00020\u0007¢\u0006\u0004\b\u000B\u0010\fJ\t\u0010\u001E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001F\u001A\u00020\u0005HÆ\u0003J\t\u0010 \u001A\u00020\u0007HÆ\u0003J\u000B\u0010!\u001A\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\"\u001A\u00020\u0007HÆ\u0003J=\u0010#\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001A\u00020\u0007HÆ\u0001J\u0013\u0010$\u001A\u00020\u00052\b\u0010%\u001A\u0004\u0018\u00010&HÖ\u0003J\t\u0010\'\u001A\u00020(HÖ\u0001J\t\u0010)\u001A\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0006\u001A\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0016\u0010\b\u001A\u0004\u0018\u00010\tX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0014\u0010\n\u001A\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0016\u001A\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001A\u001A\u00020\u001BX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u001D¨\u0006*"}, d2={"Lcom/TryJeanPc/goldenmouse/input/InputEvent$MouseButton;", "Lcom/TryJeanPc/goldenmouse/input/InputEvent;", "button", "Lcom/TryJeanPc/goldenmouse/input/InputEvent$Button;", "pressed", "", "timestampNanos", "", "devicePath", "", "sequenceNumber", "<init>", "(Lcom/TryJeanPc/goldenmouse/input/InputEvent$Button;ZJLjava/lang/String;J)V", "getButton", "()Lcom/TryJeanPc/goldenmouse/input/InputEvent$Button;", "getPressed", "()Z", "getTimestampNanos", "()J", "getDevicePath", "()Ljava/lang/String;", "getSequenceNumber", "type", "Lcom/TryJeanPc/goldenmouse/input/InputEvent$Type;", "getType", "()Lcom/TryJeanPc/goldenmouse/input/InputEvent$Type;", "sourceRole", "Lcom/TryJeanPc/goldenmouse/input/InputDeviceRole;", "getSourceRole", "()Lcom/TryJeanPc/goldenmouse/input/InputDeviceRole;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class MouseButton extends InputEvent {
        public static final int $stable;
        private final Button button;
        private final String devicePath;
        private final boolean pressed;
        private final long sequenceNumber;
        private final InputDeviceRole sourceRole;
        private final long timestampNanos;
        private final Type type;

        static {
        }

        public MouseButton(Button arg9, boolean arg10, long arg11, String arg13, long arg14, int arg16, DefaultConstructorMarker arg17) {
            if((arg16 & 4) != 0) {
                arg11 = System.nanoTime();
            }

            long v3 = arg11;
            if((arg16 & 8) != 0) {
                arg13 = null;
            }

            String v5 = arg13;
            long v6 = (arg16 & 16) != 0 ? 0 : arg14;
            this(arg9, arg10, v3, v5, v6);
        }

        public MouseButton(Button arg2, boolean arg3, long arg4, String arg6, long arg7) {
            Intrinsics.checkNotNullParameter(arg2, "button");
            super(null);
            this.button = arg2;
            this.pressed = arg3;
            this.timestampNanos = arg4;
            this.devicePath = arg6;
            this.sequenceNumber = arg7;
            this.type = Type.MOUSE_BUTTON;
            this.sourceRole = InputDeviceRole.MOUSE;
        }

        public final Button component1() {
            return this.button;
        }

        public final boolean component2() {
            return this.pressed;
        }

        public final long component3() {
            return this.timestampNanos;
        }

        public final String component4() {
            return this.devicePath;
        }

        public final long component5() {
            return this.sequenceNumber;
        }

        public final MouseButton copy(Button arg9, boolean arg10, long arg11, String arg13, long arg14) {
            Intrinsics.checkNotNullParameter(arg9, "button");
            return new MouseButton(arg9, arg10, arg11, arg13, arg14);
        }

        public static MouseButton copy$default(MouseButton arg0, Button arg1, boolean arg2, long arg3, String arg5, long arg6, int arg8, Object arg9) {
            if((arg8 & 1) != 0) {
                arg1 = arg0.button;
            }

            if((arg8 & 2) != 0) {
                arg2 = arg0.pressed;
            }

            if((arg8 & 4) != 0) {
                arg3 = arg0.timestampNanos;
            }

            if((arg8 & 8) != 0) {
                arg5 = arg0.devicePath;
            }

            if((arg8 & 16) != 0) {
                arg6 = arg0.sequenceNumber;
            }

            return arg0.copy(arg1, arg2, arg3, arg5, arg6);
        }

        public boolean equals(Object arg8) {
            if(this == (((MouseButton)arg8))) {
                return 1;
            }

            if(!(arg8 instanceof MouseButton)) {
                return 0;
            }

            if(this.button != ((MouseButton)arg8).button) {
                return 0;
            }

            if(this.pressed != ((MouseButton)arg8).pressed) {
                return 0;
            }

            if(this.timestampNanos != ((MouseButton)arg8).timestampNanos) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.devicePath, ((MouseButton)arg8).devicePath)) {
                return 0;
            }

            if(this.sequenceNumber != ((MouseButton)arg8).sequenceNumber) {
                return 0;
            }

            return 1;
        }

        public final Button getButton() {
            return this.button;
        }

        public String getDevicePath() {
            return this.devicePath;
        }

        public final boolean getPressed() {
            return this.pressed;
        }

        public long getSequenceNumber() {
            return this.sequenceNumber;
        }

        public InputDeviceRole getSourceRole() {
            return this.sourceRole;
        }

        public long getTimestampNanos() {
            return this.timestampNanos;
        }

        public Type getType() {
            return this.type;
        }

        public int hashCode() {
            int v0 = ((this.button.hashCode() * 0x1F + Boolean.hashCode(this.pressed)) * 0x1F + Long.hashCode(this.timestampNanos)) * 0x1F;
            String v1 = this.devicePath;
            int v1_1 = v1 == null ? 0 : v1.hashCode();
            return (v0 + v1_1) * 0x1F + Long.hashCode(this.sequenceNumber);
        }

        public String toString() {
            return "MouseButton(button=" + this.button + ", pressed=" + this.pressed + ", timestampNanos=" + this.timestampNanos + ", devicePath=" + this.devicePath + ", sequenceNumber=" + this.sequenceNumber + ")";
        }
    }

    @Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001A\u00020\u0006\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B¢\u0006\u0004\b\f\u0010\rJ\t\u0010!\u001A\u00020\u0003HÆ\u0003J\t\u0010\"\u001A\u00020\u0003HÆ\u0003J\t\u0010#\u001A\u00020\u0006HÆ\u0003J\u000B\u0010$\u001A\u0004\u0018\u00010\bHÆ\u0003J\t\u0010%\u001A\u00020\u0006HÆ\u0003J\u0010\u0010&\u001A\u0004\u0018\u00010\u000BHÆ\u0003¢\u0006\u0002\u0010\u0017JN\u0010\'\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00062\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001A\u00020\u00062\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000BHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001A\u00020\u000B2\b\u0010*\u001A\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001A\u00020\u0003HÖ\u0001J\t\u0010-\u001A\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u000FR\u0014\u0010\u0005\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0014\u0010\t\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0012R\u0015\u0010\n\u001A\u0004\u0018\u00010\u000B¢\u0006\n\n\u0002\u0010\u0018\u001A\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001A\u00020\u001AX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u001CR\u0014\u0010\u001D\u001A\u00020\u001EX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010 ¨\u0006."}, d2={"Lcom/TryJeanPc/goldenmouse/input/InputEvent$MouseMove;", "Lcom/TryJeanPc/goldenmouse/input/InputEvent;", "deltaX", "", "deltaY", "timestampNanos", "", "devicePath", "", "sequenceNumber", "cameraRead", "", "<init>", "(IIJLjava/lang/String;JLjava/lang/Boolean;)V", "getDeltaX", "()I", "getDeltaY", "getTimestampNanos", "()J", "getDevicePath", "()Ljava/lang/String;", "getSequenceNumber", "getCameraRead", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "type", "Lcom/TryJeanPc/goldenmouse/input/InputEvent$Type;", "getType", "()Lcom/TryJeanPc/goldenmouse/input/InputEvent$Type;", "sourceRole", "Lcom/TryJeanPc/goldenmouse/input/InputDeviceRole;", "getSourceRole", "()Lcom/TryJeanPc/goldenmouse/input/InputDeviceRole;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(IIJLjava/lang/String;JLjava/lang/Boolean;)Lcom/TryJeanPc/goldenmouse/input/InputEvent$MouseMove;", "equals", "other", "", "hashCode", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class MouseMove extends InputEvent {
        public static final int $stable;
        private final Boolean cameraRead;
        private final int deltaX;
        private final int deltaY;
        private final String devicePath;
        private final long sequenceNumber;
        private final InputDeviceRole sourceRole;
        private final long timestampNanos;
        private final Type type;

        static {
        }

        public MouseMove(int arg2, int arg3, long arg4, String arg6, long arg7, Boolean arg9) {
            super(null);
            this.deltaX = arg2;
            this.deltaY = arg3;
            this.timestampNanos = arg4;
            this.devicePath = arg6;
            this.sequenceNumber = arg7;
            this.cameraRead = arg9;
            this.type = Type.MOUSE_MOVE;
            this.sourceRole = InputDeviceRole.MOUSE;
        }

        public MouseMove(int arg10, int arg11, long arg12, String arg14, long arg15, Boolean arg17, int arg18, DefaultConstructorMarker arg19) {
            if((arg18 & 4) != 0) {
                arg12 = System.nanoTime();
            }

            long v3 = arg12;
            String v13 = null;
            String v5 = (arg18 & 8) != 0 ? v13 : arg14;
            long v6 = (arg18 & 16) != 0 ? 0 : arg15;
            Boolean v8 = (arg18 & 0x20) != 0 ? ((Boolean)v13) : arg17;
            this(arg10, arg11, v3, v5, v6, v8);
        }

        public final int component1() {
            return this.deltaX;
        }

        public final int component2() {
            return this.deltaY;
        }

        public final long component3() {
            return this.timestampNanos;
        }

        public final String component4() {
            return this.devicePath;
        }

        public final long component5() {
            return this.sequenceNumber;
        }

        public final Boolean component6() {
            return this.cameraRead;
        }

        public final MouseMove copy(int arg1, int arg2, long arg3, String arg5, long arg6, Boolean arg8) {
            return new MouseMove(arg1, arg2, arg3, arg5, arg6, arg8);
        }

        public static MouseMove copy$default(MouseMove arg0, int arg1, int arg2, long arg3, String arg5, long arg6, Boolean arg8, int arg9, Object arg10) {
            if((arg9 & 1) != 0) {
                arg1 = arg0.deltaX;
            }

            if((arg9 & 2) != 0) {
                arg2 = arg0.deltaY;
            }

            if((arg9 & 4) != 0) {
                arg3 = arg0.timestampNanos;
            }

            if((arg9 & 8) != 0) {
                arg5 = arg0.devicePath;
            }

            if((arg9 & 16) != 0) {
                arg6 = arg0.sequenceNumber;
            }

            if((arg9 & 0x20) != 0) {
                arg8 = arg0.cameraRead;
            }

            return arg0.copy(arg1, arg2, arg3, arg5, arg6, arg8);
        }

        public boolean equals(Object arg8) {
            if(this == (((MouseMove)arg8))) {
                return 1;
            }

            if(!(arg8 instanceof MouseMove)) {
                return 0;
            }

            if(this.deltaX != ((MouseMove)arg8).deltaX) {
                return 0;
            }

            if(this.deltaY != ((MouseMove)arg8).deltaY) {
                return 0;
            }

            if(this.timestampNanos != ((MouseMove)arg8).timestampNanos) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.devicePath, ((MouseMove)arg8).devicePath)) {
                return 0;
            }

            if(this.sequenceNumber != ((MouseMove)arg8).sequenceNumber) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.cameraRead, ((MouseMove)arg8).cameraRead)) {
                return 0;
            }

            return 1;
        }

        public final Boolean getCameraRead() {
            return this.cameraRead;
        }

        public final int getDeltaX() {
            return this.deltaX;
        }

        public final int getDeltaY() {
            return this.deltaY;
        }

        public String getDevicePath() {
            return this.devicePath;
        }

        public long getSequenceNumber() {
            return this.sequenceNumber;
        }

        public InputDeviceRole getSourceRole() {
            return this.sourceRole;
        }

        public long getTimestampNanos() {
            return this.timestampNanos;
        }

        public Type getType() {
            return this.type;
        }

        public int hashCode() {
            int v0 = ((Integer.hashCode(this.deltaX) * 0x1F + Integer.hashCode(this.deltaY)) * 0x1F + Long.hashCode(this.timestampNanos)) * 0x1F;
            String v1 = this.devicePath;
            int v2 = 0;
            int v1_1 = v1 == null ? 0 : v1.hashCode();
            v0 = ((v0 + v1_1) * 0x1F + Long.hashCode(this.sequenceNumber)) * 0x1F;
            Boolean v5 = this.cameraRead;
            if(v5 == null) {
            }
            else {
                v2 = v5.hashCode();
            }

            return v0 + v2;
        }

        public String toString() {
            return "MouseMove(deltaX=" + this.deltaX + ", deltaY=" + this.deltaY + ", timestampNanos=" + this.timestampNanos + ", devicePath=" + this.devicePath + ", sequenceNumber=" + this.sequenceNumber + ", cameraRead=" + this.cameraRead + ")";
        }
    }

    @Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000E\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001A\u00020\u0006¢\u0006\u0004\b\n\u0010\u000BJ\t\u0010\u001C\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001D\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001E\u001A\u00020\u0006HÆ\u0003J\u000B\u0010\u001F\u001A\u0004\u0018\u00010\bHÆ\u0003J\t\u0010 \u001A\u00020\u0006HÆ\u0003J=\u0010!\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00062\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001A\u00020\u0006HÆ\u0001J\u0013\u0010\"\u001A\u00020#2\b\u0010$\u001A\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001A\u00020\u0003HÖ\u0001J\t\u0010\'\u001A\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\rR\u0014\u0010\u0005\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0016\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0014\u0010\t\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0014\u001A\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001A\u00020\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001B¨\u0006("}, d2={"Lcom/TryJeanPc/goldenmouse/input/InputEvent$Scroll;", "Lcom/TryJeanPc/goldenmouse/input/InputEvent;", "deltaX", "", "deltaY", "timestampNanos", "", "devicePath", "", "sequenceNumber", "<init>", "(IIJLjava/lang/String;J)V", "getDeltaX", "()I", "getDeltaY", "getTimestampNanos", "()J", "getDevicePath", "()Ljava/lang/String;", "getSequenceNumber", "type", "Lcom/TryJeanPc/goldenmouse/input/InputEvent$Type;", "getType", "()Lcom/TryJeanPc/goldenmouse/input/InputEvent$Type;", "sourceRole", "Lcom/TryJeanPc/goldenmouse/input/InputDeviceRole;", "getSourceRole", "()Lcom/TryJeanPc/goldenmouse/input/InputDeviceRole;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Scroll extends InputEvent {
        public static final int $stable;
        private final int deltaX;
        private final int deltaY;
        private final String devicePath;
        private final long sequenceNumber;
        private final InputDeviceRole sourceRole;
        private final long timestampNanos;
        private final Type type;

        static {
        }

        public Scroll(int arg2, int arg3, long arg4, String arg6, long arg7) {
            super(null);
            this.deltaX = arg2;
            this.deltaY = arg3;
            this.timestampNanos = arg4;
            this.devicePath = arg6;
            this.sequenceNumber = arg7;
            this.type = Type.SCROLL;
            this.sourceRole = InputDeviceRole.MOUSE;
        }

        public Scroll(int arg9, int arg10, long arg11, String arg13, long arg14, int arg16, DefaultConstructorMarker arg17) {
            if((arg16 & 4) != 0) {
                arg11 = System.nanoTime();
            }

            long v3 = arg11;
            if((arg16 & 8) != 0) {
                arg13 = null;
            }

            String v5 = arg13;
            long v6 = (arg16 & 16) != 0 ? 0 : arg14;
            this(arg9, arg10, v3, v5, v6);
        }

        public final int component1() {
            return this.deltaX;
        }

        public final int component2() {
            return this.deltaY;
        }

        public final long component3() {
            return this.timestampNanos;
        }

        public final String component4() {
            return this.devicePath;
        }

        public final long component5() {
            return this.sequenceNumber;
        }

        public final Scroll copy(int arg1, int arg2, long arg3, String arg5, long arg6) {
            return new Scroll(arg1, arg2, arg3, arg5, arg6);
        }

        public static Scroll copy$default(Scroll arg0, int arg1, int arg2, long arg3, String arg5, long arg6, int arg8, Object arg9) {
            if((arg8 & 1) != 0) {
                arg1 = arg0.deltaX;
            }

            if((arg8 & 2) != 0) {
                arg2 = arg0.deltaY;
            }

            if((arg8 & 4) != 0) {
                arg3 = arg0.timestampNanos;
            }

            if((arg8 & 8) != 0) {
                arg5 = arg0.devicePath;
            }

            if((arg8 & 16) != 0) {
                arg6 = arg0.sequenceNumber;
            }

            return arg0.copy(arg1, arg2, arg3, arg5, arg6);
        }

        public boolean equals(Object arg8) {
            if(this == (((Scroll)arg8))) {
                return 1;
            }

            if(!(arg8 instanceof Scroll)) {
                return 0;
            }

            if(this.deltaX != ((Scroll)arg8).deltaX) {
                return 0;
            }

            if(this.deltaY != ((Scroll)arg8).deltaY) {
                return 0;
            }

            if(this.timestampNanos != ((Scroll)arg8).timestampNanos) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.devicePath, ((Scroll)arg8).devicePath)) {
                return 0;
            }

            if(this.sequenceNumber != ((Scroll)arg8).sequenceNumber) {
                return 0;
            }

            return 1;
        }

        public final int getDeltaX() {
            return this.deltaX;
        }

        public final int getDeltaY() {
            return this.deltaY;
        }

        public String getDevicePath() {
            return this.devicePath;
        }

        public long getSequenceNumber() {
            return this.sequenceNumber;
        }

        public InputDeviceRole getSourceRole() {
            return this.sourceRole;
        }

        public long getTimestampNanos() {
            return this.timestampNanos;
        }

        public Type getType() {
            return this.type;
        }

        public int hashCode() {
            int v0 = ((Integer.hashCode(this.deltaX) * 0x1F + Integer.hashCode(this.deltaY)) * 0x1F + Long.hashCode(this.timestampNanos)) * 0x1F;
            String v1 = this.devicePath;
            int v1_1 = v1 == null ? 0 : v1.hashCode();
            return (v0 + v1_1) * 0x1F + Long.hashCode(this.sequenceNumber);
        }

        public String toString() {
            return "Scroll(deltaX=" + this.deltaX + ", deltaY=" + this.deltaY + ", timestampNanos=" + this.timestampNanos + ", devicePath=" + this.devicePath + ", sequenceNumber=" + this.sequenceNumber + ")";
        }
    }

    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2={"Lcom/TryJeanPc/goldenmouse/input/InputEvent$Type;", "", "<init>", "(Ljava/lang/String;I)V", "KEY_DOWN", "KEY_UP", "MOUSE_MOVE", "MOUSE_BUTTON", "SCROLL", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum Type {
        public static final enum Type KEY_DOWN;
        public static final enum Type KEY_UP;
        public static final enum Type MOUSE_BUTTON;
        public static final enum Type MOUSE_MOVE;
        public static final enum Type SCROLL;

        private static final Type[] $values() {
            return new Type[]{Type.KEY_DOWN, Type.KEY_UP, Type.MOUSE_MOVE, Type.MOUSE_BUTTON, Type.SCROLL};
        }

        static {
            Type.KEY_DOWN = new Type("KEY_DOWN", 0);
            Type.KEY_UP = new Type("KEY_UP", 1);
            Type.MOUSE_MOVE = new Type("MOUSE_MOVE", 2);
            Type.MOUSE_BUTTON = new Type("MOUSE_BUTTON", 3);
            Type.SCROLL = new Type("SCROLL", 4);
            Type[] v0 = Type.$values();
            Type.$VALUES = v0;
            Type.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private Type(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return Type.$ENTRIES;
        }

        public static Type valueOf(String arg1) {
            return Enum.valueOf(Type.class, arg1);
        }

        public static Type[] values() {
            return Type.$VALUES.clone();
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    public static final long UNASSIGNED_SEQUENCE_NUMBER;

    static {
        InputEvent.Companion = new Companion(null);
    }

    private InputEvent() {
        super();
    }

    public InputEvent(DefaultConstructorMarker arg1) {
        this();
    }

    public abstract String getDevicePath();

    public abstract long getSequenceNumber();

    public abstract InputDeviceRole getSourceRole();

    public abstract long getTimestampNanos();

    public abstract Type getType();

    public final InputEvent withSequenceNumber(long arg12) {
        if((this instanceof KeyDown)) {
            return KeyDown.copy$default(this, 0, null, 0, null, arg12, 15, null);
        }

        long v6 = arg12;
        if((this instanceof KeyUp)) {
            return KeyUp.copy$default(this, 0, null, 0, null, v6, 15, null);
        }

        if((this instanceof MouseMove)) {
            return MouseMove.copy$default(this, 0, 0, 0, null, v6, null, 0x2F, null);
        }

        if((this instanceof MouseButton)) {
            return MouseButton.copy$default(this, null, false, 0, null, v6, 15, null);
        }

        if((this instanceof Scroll)) {
            return Scroll.copy$default(this, 0, 0, 0, null, v6, 15, null);
        }

        throw new NoWhenBranchMatchedException();
    }
}

