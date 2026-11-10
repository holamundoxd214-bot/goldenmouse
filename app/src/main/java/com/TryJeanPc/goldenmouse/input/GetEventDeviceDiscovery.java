package com.TryJeanPc.goldenmouse.input;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0002\u0015\u0016B!\u0012\u0018\u0010\u0002\u001A\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000E\u0010\b\u001A\b\u0012\u0004\u0012\u00020\t0\u0005H\u0016J\u0016\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000B2\u0006\u0010\r\u001A\u00020\tH\u0016J\u001C\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\t0\u00052\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00040\u0005H\u0002J \u0010\u0010\u001A\u00020\u00112\u0006\u0010\r\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00042\u0006\u0010\u0014\u001A\u00020\u0004H\u0002R \u0010\u0002\u001A\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2={"Lcom/TryJeanPc/goldenmouse/input/GetEventDeviceDiscovery;", "Lcom/TryJeanPc/goldenmouse/input/InputDeviceDiscovery;", "commandRunner", "Lkotlin/Function1;", "", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "listDevices", "Lcom/TryJeanPc/goldenmouse/input/InputDeviceDescriptor;", "classifyRoles", "", "Lcom/TryJeanPc/goldenmouse/input/InputDeviceRole;", "device", "parseDevices", "lines", "readCapabilities", "", "Lcom/TryJeanPc/goldenmouse/input/GetEventDeviceDiscovery$MutableDevice;", "capability", "values", "MutableDevice", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GetEventDeviceDiscovery implements InputDeviceDiscovery {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\n\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\tR\u0011\u0010\f\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\tR\u0011\u0010\u000E\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\tR\u0011\u0010\u0010\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\tR\u0011\u0010\u0012\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\t¨\u0006\u0014"}, d2={"Lcom/TryJeanPc/goldenmouse/input/GetEventDeviceDiscovery$Companion;", "", "<init>", "()V", "GETEVENT_LIST_COMMAND", "", "inputDeviceLineRegex", "Lkotlin/text/Regex;", "getInputDeviceLineRegex", "()Lkotlin/text/Regex;", "inputDeviceNameRegex", "getInputDeviceNameRegex", "capabilityLineRegex", "getCapabilityLineRegex", "mouseButtonRegex", "getMouseButtonRegex", "keyboardKeyRegex", "getKeyboardKeyRegex", "hexadecimalKeyRegex", "getHexadecimalKeyRegex", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Regex getCapabilityLineRegex() {
            return GetEventDeviceDiscovery.capabilityLineRegex;
        }

        public final Regex getHexadecimalKeyRegex() {
            return GetEventDeviceDiscovery.hexadecimalKeyRegex;
        }

        public final Regex getInputDeviceLineRegex() {
            return GetEventDeviceDiscovery.inputDeviceLineRegex;
        }

        public final Regex getInputDeviceNameRegex() {
            return GetEventDeviceDiscovery.inputDeviceNameRegex;
        }

        public final Regex getKeyboardKeyRegex() {
            return GetEventDeviceDiscovery.keyboardKeyRegex;
        }

        public final Regex getMouseButtonRegex() {
            return GetEventDeviceDiscovery.mouseButtonRegex;
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u001E\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0006\u0012\b\b\u0002\u0010\b\u001A\u00020\u0006\u0012\b\b\u0002\u0010\t\u001A\u00020\u0006\u0012\b\b\u0002\u0010\n\u001A\u00020\u0006\u0012\b\b\u0002\u0010\u000B\u001A\u00020\u0006\u0012\b\b\u0002\u0010\f\u001A\u00020\u0006¢\u0006\u0004\b\r\u0010\u000EJ\u0006\u0010$\u001A\u00020%J\t\u0010&\u001A\u00020\u0003HÆ\u0003J\t\u0010\'\u001A\u00020\u0003HÆ\u0003J\t\u0010(\u001A\u00020\u0006HÆ\u0003J\t\u0010)\u001A\u00020\u0006HÆ\u0003J\t\u0010*\u001A\u00020\u0006HÆ\u0003J\t\u0010+\u001A\u00020\u0006HÆ\u0003J\t\u0010,\u001A\u00020\u0006HÆ\u0003J\t\u0010-\u001A\u00020\u0006HÆ\u0003J\t\u0010.\u001A\u00020\u0006HÆ\u0003Jc\u0010/\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\u00062\b\b\u0002\u0010\b\u001A\u00020\u00062\b\b\u0002\u0010\t\u001A\u00020\u00062\b\b\u0002\u0010\n\u001A\u00020\u00062\b\b\u0002\u0010\u000B\u001A\u00020\u00062\b\b\u0002\u0010\f\u001A\u00020\u0006HÆ\u0001J\u0013\u00100\u001A\u00020\u00062\b\u00101\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001A\u000203HÖ\u0001J\t\u00104\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u001A\u0010\u0004\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0010\"\u0004\b\u0012\u0010\u0013R\u001A\u0010\u0005\u001A\u00020\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001A\u0010\u0007\u001A\u00020\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001A\u0010\b\u001A\u00020\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u0015\"\u0004\b\u001B\u0010\u0017R\u001A\u0010\t\u001A\u00020\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001C\u0010\u0015\"\u0004\b\u001D\u0010\u0017R\u001A\u0010\n\u001A\u00020\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001E\u0010\u0015\"\u0004\b\u001F\u0010\u0017R\u001A\u0010\u000B\u001A\u00020\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017R\u001A\u0010\f\u001A\u00020\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017¨\u00065"}, d2={"Lcom/TryJeanPc/goldenmouse/input/GetEventDeviceDiscovery$MutableDevice;", "", "path", "", "name", "hasRelX", "", "hasRelY", "hasKeys", "hasMouseButtons", "hasKeyboardKeys", "hasWheel", "hasHorizontalWheel", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZZZZZZ)V", "getPath", "()Ljava/lang/String;", "getName", "setName", "(Ljava/lang/String;)V", "getHasRelX", "()Z", "setHasRelX", "(Z)V", "getHasRelY", "setHasRelY", "getHasKeys", "setHasKeys", "getHasMouseButtons", "setHasMouseButtons", "getHasKeyboardKeys", "setHasKeyboardKeys", "getHasWheel", "setHasWheel", "getHasHorizontalWheel", "setHasHorizontalWheel", "toDescriptor", "Lcom/TryJeanPc/goldenmouse/input/InputDeviceDescriptor;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class MutableDevice {
        private boolean hasHorizontalWheel;
        private boolean hasKeyboardKeys;
        private boolean hasKeys;
        private boolean hasMouseButtons;
        private boolean hasRelX;
        private boolean hasRelY;
        private boolean hasWheel;
        private String name;
        private final String path;

        public MutableDevice(String arg10, String arg11, boolean arg12, boolean arg13, boolean arg14, boolean arg15, boolean arg16, boolean arg17, boolean arg18, int arg19, DefaultConstructorMarker arg20) {
            int v0 = arg19;
            String v1 = (v0 & 2) != 0 ? "desconocido" : arg11;
            boolean v2 = (v0 & 4) != 0 ? false : arg12;
            boolean v4 = (v0 & 8) != 0 ? false : arg13;
            boolean v5 = (v0 & 16) != 0 ? false : arg14;
            boolean v6 = (v0 & 0x20) != 0 ? false : arg15;
            boolean v7 = (v0 & 0x40) != 0 ? false : arg16;
            boolean v8 = (v0 & 0x80) != 0 ? false : arg17;
            boolean v20 = (v0 & 0x100) != 0 ? false : arg18;
            this(arg10, v1, v2, v4, v5, v6, v7, v8, v20);
        }

        public MutableDevice(String arg2, String arg3, boolean arg4, boolean arg5, boolean arg6, boolean arg7, boolean arg8, boolean arg9, boolean arg10) {
            Intrinsics.checkNotNullParameter(arg2, "path");
            Intrinsics.checkNotNullParameter(arg3, "name");
            super();
            this.path = arg2;
            this.name = arg3;
            this.hasRelX = arg4;
            this.hasRelY = arg5;
            this.hasKeys = arg6;
            this.hasMouseButtons = arg7;
            this.hasKeyboardKeys = arg8;
            this.hasWheel = arg9;
            this.hasHorizontalWheel = arg10;
        }

        public final String component1() {
            return this.path;
        }

        public final String component2() {
            return this.name;
        }

        public final boolean component3() {
            return this.hasRelX;
        }

        public final boolean component4() {
            return this.hasRelY;
        }

        public final boolean component5() {
            return this.hasKeys;
        }

        public final boolean component6() {
            return this.hasMouseButtons;
        }

        public final boolean component7() {
            return this.hasKeyboardKeys;
        }

        public final boolean component8() {
            return this.hasWheel;
        }

        public final boolean component9() {
            return this.hasHorizontalWheel;
        }

        public final MutableDevice copy(String arg11, String arg12, boolean arg13, boolean arg14, boolean arg15, boolean arg16, boolean arg17, boolean arg18, boolean arg19) {
            Intrinsics.checkNotNullParameter(arg11, "path");
            Intrinsics.checkNotNullParameter(arg12, "name");
            return new MutableDevice(arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19);
        }

        public static MutableDevice copy$default(MutableDevice arg0, String arg1, String arg2, boolean arg3, boolean arg4, boolean arg5, boolean arg6, boolean arg7, boolean arg8, boolean arg9, int arg10, Object arg11) {
            if((arg10 & 1) != 0) {
                arg1 = arg0.path;
            }

            if((arg10 & 2) != 0) {
                arg2 = arg0.name;
            }

            if((arg10 & 4) != 0) {
                arg3 = arg0.hasRelX;
            }

            if((arg10 & 8) != 0) {
                arg4 = arg0.hasRelY;
            }

            if((arg10 & 16) != 0) {
                arg5 = arg0.hasKeys;
            }

            if((arg10 & 0x20) != 0) {
                arg6 = arg0.hasMouseButtons;
            }

            if((arg10 & 0x40) != 0) {
                arg7 = arg0.hasKeyboardKeys;
            }

            if((arg10 & 0x80) != 0) {
                arg8 = arg0.hasWheel;
            }

            if((arg10 & 0x100) != 0) {
                arg9 = arg0.hasHorizontalWheel;
            }

            return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
        }

        public boolean equals(Object arg5) {
            if(this == (((MutableDevice)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof MutableDevice)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.path, ((MutableDevice)arg5).path)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.name, ((MutableDevice)arg5).name)) {
                return 0;
            }

            if(this.hasRelX != ((MutableDevice)arg5).hasRelX) {
                return 0;
            }

            if(this.hasRelY != ((MutableDevice)arg5).hasRelY) {
                return 0;
            }

            if(this.hasKeys != ((MutableDevice)arg5).hasKeys) {
                return 0;
            }

            if(this.hasMouseButtons != ((MutableDevice)arg5).hasMouseButtons) {
                return 0;
            }

            if(this.hasKeyboardKeys != ((MutableDevice)arg5).hasKeyboardKeys) {
                return 0;
            }

            if(this.hasWheel != ((MutableDevice)arg5).hasWheel) {
                return 0;
            }

            if(this.hasHorizontalWheel != ((MutableDevice)arg5).hasHorizontalWheel) {
                return 0;
            }

            return 1;
        }

        public final boolean getHasHorizontalWheel() {
            return this.hasHorizontalWheel;
        }

        public final boolean getHasKeyboardKeys() {
            return this.hasKeyboardKeys;
        }

        public final boolean getHasKeys() {
            return this.hasKeys;
        }

        public final boolean getHasMouseButtons() {
            return this.hasMouseButtons;
        }

        public final boolean getHasRelX() {
            return this.hasRelX;
        }

        public final boolean getHasRelY() {
            return this.hasRelY;
        }

        public final boolean getHasWheel() {
            return this.hasWheel;
        }

        public final String getName() {
            return this.name;
        }

        public final String getPath() {
            return this.path;
        }

        public int hashCode() {
            return (((((((this.path.hashCode() * 0x1F + this.name.hashCode()) * 0x1F + Boolean.hashCode(this.hasRelX)) * 0x1F + Boolean.hashCode(this.hasRelY)) * 0x1F + Boolean.hashCode(this.hasKeys)) * 0x1F + Boolean.hashCode(this.hasMouseButtons)) * 0x1F + Boolean.hashCode(this.hasKeyboardKeys)) * 0x1F + Boolean.hashCode(this.hasWheel)) * 0x1F + Boolean.hashCode(this.hasHorizontalWheel);
        }

        public final void setHasHorizontalWheel(boolean arg1) {
            this.hasHorizontalWheel = arg1;
        }

        public final void setHasKeyboardKeys(boolean arg1) {
            this.hasKeyboardKeys = arg1;
        }

        public final void setHasKeys(boolean arg1) {
            this.hasKeys = arg1;
        }

        public final void setHasMouseButtons(boolean arg1) {
            this.hasMouseButtons = arg1;
        }

        public final void setHasRelX(boolean arg1) {
            this.hasRelX = arg1;
        }

        public final void setHasRelY(boolean arg1) {
            this.hasRelY = arg1;
        }

        public final void setHasWheel(boolean arg1) {
            this.hasWheel = arg1;
        }

        public final void setName(String arg2) {
            Intrinsics.checkNotNullParameter(arg2, "<set-?>");
            this.name = arg2;
        }

        public final InputDeviceDescriptor toDescriptor() {
            Set v0 = SetsKt.createSetBuilder();
            if((this.hasRelX) && (this.hasRelY) && (this.hasMouseButtons)) {
                v0.add(InputDeviceRole.MOUSE);
            }

            if(this.hasKeyboardKeys) {
                v0.add(InputDeviceRole.KEYBOARD);
            }

            return new InputDeviceDescriptor(this.path, this.name, SetsKt.build(v0), this.hasRelX, this.hasRelY, this.hasKeys, Boolean.valueOf(this.hasMouseButtons), Boolean.valueOf(this.hasWheel), Boolean.valueOf(this.hasHorizontalWheel));
        }

        public String toString() {
            return "MutableDevice(path=" + this.path + ", name=" + this.name + ", hasRelX=" + this.hasRelX + ", hasRelY=" + this.hasRelY + ", hasKeys=" + this.hasKeys + ", hasMouseButtons=" + this.hasMouseButtons + ", hasKeyboardKeys=" + this.hasKeyboardKeys + ", hasWheel=" + this.hasWheel + ", hasHorizontalWheel=" + this.hasHorizontalWheel + ")";
        }
    }

    public static final int $stable = 0;
    private static final Companion Companion = null;
    @Deprecated public static final String GETEVENT_LIST_COMMAND = "getevent -lp";
    private static final Regex capabilityLineRegex;
    private final Function1 commandRunner;
    private static final Regex hexadecimalKeyRegex;
    private static final Regex inputDeviceLineRegex;
    private static final Regex inputDeviceNameRegex;
    private static final Regex keyboardKeyRegex;
    private static final Regex mouseButtonRegex;

    static {
        GetEventDeviceDiscovery.Companion = new Companion(null);
        GetEventDeviceDiscovery.inputDeviceLineRegex = new Regex("add device \\d+:\\s+(/dev/input/event\\d+)");
        GetEventDeviceDiscovery.inputDeviceNameRegex = new Regex("name:\\s+\"([^\"]+)\"");
        GetEventDeviceDiscovery.capabilityLineRegex = new Regex("^\\s*([A-Z]+)\\s+\\([0-9a-fA-F]+\\):\\s*(.*)$");
        GetEventDeviceDiscovery.mouseButtonRegex = new Regex("\\bBTN_(MOUSE|LEFT|RIGHT|MIDDLE|SIDE|EXTRA)\\b");
        GetEventDeviceDiscovery.keyboardKeyRegex = new Regex("\\bKEY_[A-Z0-9_]+\\b");
        GetEventDeviceDiscovery.hexadecimalKeyRegex = new Regex("\\b[0-9a-fA-F]{4}\\b");
    }

    public GetEventDeviceDiscovery(Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "commandRunner");
        super();
        this.commandRunner = arg2;
    }

    public static final Regex access$getCapabilityLineRegex$cp() {
        return GetEventDeviceDiscovery.capabilityLineRegex;
    }

    public static final Regex access$getHexadecimalKeyRegex$cp() {
        return GetEventDeviceDiscovery.hexadecimalKeyRegex;
    }

    public static final Regex access$getInputDeviceLineRegex$cp() {
        return GetEventDeviceDiscovery.inputDeviceLineRegex;
    }

    public static final Regex access$getInputDeviceNameRegex$cp() {
        return GetEventDeviceDiscovery.inputDeviceNameRegex;
    }

    public static final Regex access$getKeyboardKeyRegex$cp() {
        return GetEventDeviceDiscovery.keyboardKeyRegex;
    }

    public static final Regex access$getMouseButtonRegex$cp() {
        return GetEventDeviceDiscovery.mouseButtonRegex;
    }

    public Set classifyRoles(InputDeviceDescriptor arg1) {
        Intrinsics.checkNotNullParameter(arg1, "device");
        return arg1.getRoles();
    }

    public List listDevices() {
        return this.parseDevices(this.commandRunner.invoke("getevent -lp"));
    }

    private final List parseDevices(List arg25) {
        Object v13;
        List v7_1;
        GetEventDeviceDiscovery v0 = this;
        ArrayList v1 = new ArrayList();
        Iterator v2 = arg25.iterator();
        Object v3 = null;
        MutableDevice v4 = ((MutableDevice)v3);
        Object v5 = v4;
        while(v2.hasNext()) {
            Object v6 = v2.next();
            Object v8 = v6;
            int v10 = 2;
            MatchResult v7 = Regex.find$default(GetEventDeviceDiscovery.inputDeviceLineRegex, ((CharSequence)v8), 0, v10, v3);
            if(v7 != null) {
                v7_1 = v7.getGroupValues();
                if(v7_1 != null) {
                    v13 = v7_1.get(1);
                }
                else {
                    goto label_23;
                }
            }
            else {
            label_23:
                v13 = v3;
            }

            if(v13 != null) {
                if(v4 != null) {
                    InputDeviceDescriptor v4_1 = v4.toDescriptor();
                    if(v4_1 != null) {
                        ((List)v1).add(v4_1);
                    }
                }

                v5 = v3;
                v4 = new MutableDevice(((String)v13), null, false, false, false, false, false, false, false, 510, null);
                continue;
            }

            if(v4 == null) {
                continue;
            }

            v7 = Regex.find$default(GetEventDeviceDiscovery.inputDeviceNameRegex, ((CharSequence)v8), 0, v10, v3);
            if(v7 != null) {
                v7_1 = v7.getGroupValues();
                if(v7_1 != null) {
                    Object v7_2 = v7_1.get(1);
                    if(v7_2 != null) {
                        v4.setName(((String)v7_2));
                    }
                }
            }

            v7 = Regex.find$default(GetEventDeviceDiscovery.capabilityLineRegex, ((CharSequence)v8), 0, v10, v3);
            if(v7 != null) {
                v5 = v7.getGroupValues().get(1);
                v0.readCapabilities(v4, v5, v7.getGroupValues().get(v10));
                continue;
            }

            if(v5 == null) {
                continue;
            }

            v0.readCapabilities(v4, v5, ((String)v6));
        }

        if(v4 != null) {
            InputDeviceDescriptor v0_1 = v4.toDescriptor();
            if(v0_1 != null) {
                ((List)v1).add(v0_1);
            }
        }

        return ((List)v1);
    }

    private final void readCapabilities(MutableDevice arg5, String arg6, String arg7) {
        Object v0 = null;
        int v1 = 2;
        if(Intrinsics.areEqual(arg6, "KEY")) {
            arg5.setHasKeys(true);
            if(GetEventDeviceDiscovery.mouseButtonRegex.containsMatchIn(((CharSequence)arg7))) {
                arg5.setHasMouseButtons(true);
            }

            if(!GetEventDeviceDiscovery.keyboardKeyRegex.containsMatchIn(((CharSequence)arg7))) {
                Iterator v4 = Regex.findAll$default(GetEventDeviceDiscovery.hexadecimalKeyRegex, ((CharSequence)arg7), 0, v1, v0).iterator();
                do {
                    if(v4.hasNext()) {
                        int v6 = Integer.parseInt(v4.next().getValue(), CharsKt.checkRadix(16));
                        if(Intrinsics.areEqual(LinuxKeyCodeMap.INSTANCE.name(v6), "LINUX_" + v6)) {
                            continue;
                        }

                        break;
                    }
                    else {
                        return;
                    }
                }
                while(true);

                goto label_36;
                return;
            }

        label_36:
            arg5.setHasKeyboardKeys(true);
            return;
        }

        if(Intrinsics.areEqual(arg6, "REL")) {
            if(StringsKt.contains$default(((CharSequence)arg7), "REL_X", false, v1, v0)) {
                arg5.setHasRelX(true);
            }

            if(StringsKt.contains$default(((CharSequence)arg7), "REL_Y", false, v1, v0)) {
                arg5.setHasRelY(true);
            }

            if(new Regex("\\bREL_WHEEL\\b").containsMatchIn(((CharSequence)arg7))) {
                arg5.setHasWheel(true);
            }

            if(!new Regex("\\bREL_HWHEEL\\b").containsMatchIn(((CharSequence)arg7))) {
                return;
            }

            arg5.setHasHorizontalWheel(true);
        }
    }
}

