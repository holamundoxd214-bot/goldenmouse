package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.cmp.CMPObjectIdentifiers;
import org.bouncycastle.asn1.cmp.PBMParameter;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class PKMACValue extends ASN1Object {
    private AlgorithmIdentifier algId;
    private ASN1BitString value;

    private PKMACValue(ASN1Sequence arg2) {
        super();
        this.algId = AlgorithmIdentifier.getInstance(arg2.getObjectAt(0));
        this.value = ASN1BitString.getInstance(arg2.getObjectAt(1));
    }

    public PKMACValue(PBMParameter arg3, DERBitString arg4) {
        this(new AlgorithmIdentifier(CMPObjectIdentifiers.passwordBasedMac, ((ASN1Encodable)arg3)), arg4);
    }

    public PKMACValue(AlgorithmIdentifier arg1, DERBitString arg2) {
        super();
        this.algId = arg1;
        this.value = ((ASN1BitString)arg2);
    }

    public AlgorithmIdentifier getAlgId() {
        return this.algId;
    }

    public static PKMACValue getInstance(Object arg1) {
        if((arg1 instanceof PKMACValue)) {
            return arg1;
        }

        if(arg1 != null) {
            return new PKMACValue(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public static PKMACValue getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return PKMACValue.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public ASN1BitString getValue() {
        return this.value;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.algId, this.value);
    }
}

