package androidx.compose.ui.graphics.colorspace;

public final class Rgb$Companion$$ExternalSyntheticLambda4 implements DoubleFunction {
    public Rgb$Companion$$ExternalSyntheticLambda4(TransferParameters arg1) {
        super();
        this.f$0 = arg1;
    }

    public final double invoke(double arg1) {
        return Companion.generateOetf$lambda$0(this.f$0, arg1);
    }
}

