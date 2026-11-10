package androidx.compose.ui.graphics.colorspace;

public final class Rgb$Companion$$ExternalSyntheticLambda7 implements DoubleFunction {
    public Rgb$Companion$$ExternalSyntheticLambda7(TransferParameters arg1) {
        super();
        this.f$0 = arg1;
    }

    public final double invoke(double arg1) {
        return Companion.generateOetf$lambda$3(this.f$0, arg1);
    }
}

