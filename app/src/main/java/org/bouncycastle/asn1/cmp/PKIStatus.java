package org.bouncycastle.asn1.cmp;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;

public class PKIStatus extends ASN1Object {
    public static final int GRANTED = 0;
    public static final int GRANTED_WITH_MODS = 1;
    public static final int KEY_UPDATE_WARNING = 6;
    public static final int REJECTION = 2;
    public static final int REVOCATION_NOTIFICATION = 5;
    public static final int REVOCATION_WARNING = 4;
    public static final int WAITING = 3;
    public static final PKIStatus granted;
    public static final PKIStatus grantedWithMods;
    public static final PKIStatus keyUpdateWaiting;
    public static final PKIStatus rejection;
    public static final PKIStatus revocationNotification;
    public static final PKIStatus revocationWarning;
    private final ASN1Integer value;
    public static final PKIStatus waiting;

    static {
        PKIStatus.granted = new PKIStatus(0);
        PKIStatus.grantedWithMods = new PKIStatus(1);
        PKIStatus.rejection = new PKIStatus(2);
        PKIStatus.waiting = new PKIStatus(3);
        PKIStatus.revocationWarning = new PKIStatus(4);
        PKIStatus.revocationNotification = new PKIStatus(5);
        PKIStatus.keyUpdateWaiting = new PKIStatus(6);
    }

    private PKIStatus(int arg4) {
        this(new ASN1Integer(((long)arg4)));
    }

    private PKIStatus(ASN1Integer arg1) {
        super();
        this.value = arg1;
    }

    public static PKIStatus getInstance(Object arg1) {
        if((arg1 instanceof PKIStatus)) {
            return arg1;
        }

        if(arg1 != null) {
            return new PKIStatus(ASN1Integer.getInstance(arg1));
        }

        return null;
    }

    public BigInteger getValue() {
        return this.value.getValue();
    }

    public ASN1Primitive toASN1Primitive() {
        return this.value;
    }
}

