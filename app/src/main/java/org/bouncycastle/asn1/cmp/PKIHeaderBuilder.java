package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.util.Arrays;

public class PKIHeaderBuilder {
    private PKIFreeText freeText;
    private ASN1Sequence generalInfo;
    private ASN1GeneralizedTime messageTime;
    private AlgorithmIdentifier protectionAlg;
    private final ASN1Integer pvno;
    private ASN1OctetString recipKID;
    private ASN1OctetString recipNonce;
    private final GeneralName recipient;
    private final GeneralName sender;
    private ASN1OctetString senderKID;
    private ASN1OctetString senderNonce;
    private ASN1OctetString transactionID;

    public PKIHeaderBuilder(int arg4, GeneralName arg5, GeneralName arg6) {
        this(new ASN1Integer(((long)arg4)), arg5, arg6);
    }

    private PKIHeaderBuilder(ASN1Integer arg1, GeneralName arg2, GeneralName arg3) {
        super();
        this.pvno = arg1;
        this.sender = arg2;
        this.recipient = arg3;
    }

    private void addOptional(ASN1EncodableVector arg2, int arg3, ASN1Encodable arg4) {
        if(arg4 != null) {
            arg2.add(new DERTaggedObject(true, arg3, arg4));
        }
    }

    public PKIHeader build() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(12);
        v0.add(this.pvno);
        v0.add(this.sender);
        v0.add(this.recipient);
        this.addOptional(v0, 0, this.messageTime);
        this.addOptional(v0, 1, this.protectionAlg);
        this.addOptional(v0, 2, this.senderKID);
        this.addOptional(v0, 3, this.recipKID);
        this.addOptional(v0, 4, this.transactionID);
        this.addOptional(v0, 5, this.senderNonce);
        this.addOptional(v0, 6, this.recipNonce);
        this.addOptional(v0, 7, this.freeText);
        this.addOptional(v0, 8, this.generalInfo);
        this.messageTime = null;
        this.protectionAlg = null;
        this.senderKID = null;
        this.recipKID = null;
        this.transactionID = null;
        this.senderNonce = null;
        this.recipNonce = null;
        this.freeText = null;
        this.generalInfo = null;
        return PKIHeader.getInstance(new DERSequence(v0));
    }

    private DEROctetString createClonedOctetString(byte[] arg1) {
        return new DEROctetString(Arrays.clone(arg1));
    }

    private static ASN1Sequence makeGeneralInfoSeq(InfoTypeAndValue arg1) {
        return new DERSequence(((ASN1Encodable)arg1));
    }

    private static ASN1Sequence makeGeneralInfoSeq(InfoTypeAndValue[] arg1) {
        if(arg1 != null) {
            return new DERSequence(((ASN1Encodable[])arg1));
        }

        return null;
    }

    public PKIHeaderBuilder setFreeText(PKIFreeText arg1) {
        this.freeText = arg1;
        return this;
    }

    public PKIHeaderBuilder setGeneralInfo(ASN1Sequence arg1) {
        this.generalInfo = arg1;
        return this;
    }

    public PKIHeaderBuilder setGeneralInfo(InfoTypeAndValue arg1) {
        return this.setGeneralInfo(PKIHeaderBuilder.makeGeneralInfoSeq(arg1));
    }

    public PKIHeaderBuilder setGeneralInfo(InfoTypeAndValue[] arg1) {
        return this.setGeneralInfo(PKIHeaderBuilder.makeGeneralInfoSeq(arg1));
    }

    public PKIHeaderBuilder setMessageTime(ASN1GeneralizedTime arg1) {
        this.messageTime = arg1;
        return this;
    }

    public PKIHeaderBuilder setProtectionAlg(AlgorithmIdentifier arg1) {
        this.protectionAlg = arg1;
        return this;
    }

    public PKIHeaderBuilder setRecipKID(ASN1OctetString arg1) {
        this.recipKID = arg1;
        return this;
    }

    public PKIHeaderBuilder setRecipKID(byte[] arg1) {
        DEROctetString v1_1;
        if(arg1 == null) {
            ASN1OctetString v1 = null;
        }
        else {
            v1_1 = this.createClonedOctetString(arg1);
        }

        return this.setRecipKID(((ASN1OctetString)v1_1));
    }

    public PKIHeaderBuilder setRecipNonce(ASN1OctetString arg1) {
        this.recipNonce = arg1;
        return this;
    }

    public PKIHeaderBuilder setRecipNonce(byte[] arg1) {
        DEROctetString v1_1;
        if(arg1 == null) {
            ASN1OctetString v1 = null;
        }
        else {
            v1_1 = this.createClonedOctetString(arg1);
        }

        return this.setRecipNonce(((ASN1OctetString)v1_1));
    }

    public PKIHeaderBuilder setSenderKID(ASN1OctetString arg1) {
        this.senderKID = arg1;
        return this;
    }

    public PKIHeaderBuilder setSenderKID(byte[] arg1) {
        ASN1OctetString v1;
        if(arg1 == null) {
            v1 = null;
        }
        else {
            DEROctetString v1_1 = this.createClonedOctetString(arg1);
        }

        return this.setSenderKID(v1);
    }

    public PKIHeaderBuilder setSenderNonce(ASN1OctetString arg1) {
        this.senderNonce = arg1;
        return this;
    }

    public PKIHeaderBuilder setSenderNonce(byte[] arg1) {
        DEROctetString v1_1;
        if(arg1 == null) {
            ASN1OctetString v1 = null;
        }
        else {
            v1_1 = this.createClonedOctetString(arg1);
        }

        return this.setSenderNonce(((ASN1OctetString)v1_1));
    }

    public PKIHeaderBuilder setTransactionID(ASN1OctetString arg1) {
        this.transactionID = arg1;
        return this;
    }

    public PKIHeaderBuilder setTransactionID(byte[] arg1) {
        ASN1OctetString v1;
        if(arg1 == null) {
            v1 = null;
        }
        else {
            DEROctetString v1_1 = this.createClonedOctetString(arg1);
        }

        return this.setTransactionID(v1);
    }
}

