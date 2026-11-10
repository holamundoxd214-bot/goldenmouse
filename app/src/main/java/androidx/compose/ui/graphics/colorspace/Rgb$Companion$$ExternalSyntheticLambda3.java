package androidx.compose.ui.graphics.colorspace;

public final class Rgb$Companion$$ExternalSyntheticLambda3 implements DoubleFunction {
    public Rgb$Companion$$ExternalSyntheticLambda3(TransferParameters arg1) {
        super();
        this.f$0 = arg1;
    }

    public final double invoke(double arg1) {
        return Companion.generateEotf$lambda$3(this.f$0, arg1);
    }
}

