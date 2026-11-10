package androidx.compose.ui.graphics.colorspace;

import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A(\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\nH\u0080\b¢\u0006\u0004\b\u000B\u0010\f\"\u001A\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0003\u0010\u0004¨\u0006\r"}, d2={"Connectors", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/compose/ui/graphics/colorspace/Connector;", "getConnectors", "()Landroidx/collection/MutableIntObjectMap;", "connectorKey", "", "src", "dst", "renderIntent", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "connectorKey-YBCOT_4", "(III)I", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ConnectorKt {
    private static final MutableIntObjectMap Connectors;

    static {
        ConnectorKt.Connectors = IntObjectMapKt.mutableIntObjectMapOf(ColorSpaces.INSTANCE.getSrgb().getId$ui_graphics() | ColorSpaces.INSTANCE.getSrgb().getId$ui_graphics() << 6 | RenderIntent.Companion.getPerceptual-uksYyKA() << 12, Connector.Companion.identity$ui_graphics(ColorSpaces.INSTANCE.getSrgb()), ColorSpaces.INSTANCE.getSrgb().getId$ui_graphics() | ColorSpaces.INSTANCE.getOklab().getId$ui_graphics() << 6 | RenderIntent.Companion.getPerceptual-uksYyKA() << 12, new Connector(ColorSpaces.INSTANCE.getSrgb(), ColorSpaces.INSTANCE.getOklab(), RenderIntent.Companion.getPerceptual-uksYyKA(), null), ColorSpaces.INSTANCE.getOklab().getId$ui_graphics() | ColorSpaces.INSTANCE.getSrgb().getId$ui_graphics() << 6 | RenderIntent.Companion.getPerceptual-uksYyKA() << 12, new Connector(ColorSpaces.INSTANCE.getOklab(), ColorSpaces.INSTANCE.getSrgb(), RenderIntent.Companion.getPerceptual-uksYyKA(), null));
    }

    public static final int connectorKey-YBCOT_4(int arg0, int arg1, int arg2) {
        return arg0 | arg1 << 6 | arg2 << 12;
    }

    public static final MutableIntObjectMap getConnectors() {
        return ConnectorKt.Connectors;
    }
}

