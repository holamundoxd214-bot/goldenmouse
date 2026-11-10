package org.bouncycastle.asn1.cmp;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.ASN1Util;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.GeneralName;

public class PKIHeader extends ASN1Object {
    public static final int CMP_1999 = 1;
    public static final int CMP_2000 = 2;
    public static final int CMP_2021 = 3;
    public static final GeneralName NULL_NAME;
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

    static {
        PKIHeader.NULL_NAME = new GeneralName(X500Name.getInstance(new DERSequence()));
    }

    public PKIHeader(int arg4, GeneralName arg5, GeneralName arg6) {
        this(new ASN1Integer(((long)arg4)), arg5, arg6);
    }

    private PKIHeader(ASN1Integer arg1, GeneralName arg2, GeneralName arg3) {
        super();
        this.pvno = arg1;
        this.sender = arg2;
        this.recipient = arg3;
    }

    private PKIHeader(ASN1Sequence arg4) {
        Object v0;
        super();
        Enumeration v4 = arg4.getObjects();
        this.pvno = ASN1Integer.getInstance(v4.nextElement());
        this.sender = GeneralName.getInstance(v4.nextElement());
        this.recipient = GeneralName.getInstance(v4.nextElement());
        while(true) {
            if(!v4.hasMoreElements()) {
                return;
            }

            v0 = v4.nextElement();
            if(!((ASN1TaggedObject)v0).hasContextTag()) {
                break;
            }

            switch(((ASN1TaggedObject)v0).getTagNo()) {
                case 0: {
                    goto label_52;
                }
                case 1: {
                    goto label_49;
                }
                case 2: {
                    goto label_46;
                }
                case 3: {
                    goto label_43;
                }
                case 4: {
                    goto label_40;
                }
                case 5: {
                    goto label_37;
                }
                case 6: {
                    goto label_34;
                }
                case 7: {
                    goto label_31;
                }
                case 8: {
                    goto label_28;
                }
            }

            throw new IllegalArgumentException("unknown tag number: " + ((ASN1TaggedObject)v0).getTagNo());
        label_49:
            this.protectionAlg = AlgorithmIdentifier.getInstance(((ASN1TaggedObject)v0), true);
            continue;
        label_34:
            this.recipNonce = ASN1OctetString.getInstance(((ASN1TaggedObject)v0), true);
            continue;
        label_52:
            this.messageTime = ASN1GeneralizedTime.getInstance(((ASN1TaggedObject)v0), true);
            continue;
        label_37:
            this.senderNonce = ASN1OctetString.getInstance(((ASN1TaggedObject)v0), true);
            continue;
        label_40:
            this.transactionID = ASN1OctetString.getInstance(((ASN1TaggedObject)v0), true);
            continue;
        label_43:
            this.recipKID = ASN1OctetString.getInstance(((ASN1TaggedObject)v0), true);
            continue;
        label_28:
            this.generalInfo = ASN1Sequence.getInstance(((ASN1TaggedObject)v0), true);
            continue;
        label_46:
            this.senderKID = ASN1OctetString.getInstance(((ASN1TaggedObject)v0), true);
            continue;
        label_31:
            this.freeText = PKIFreeText.getInstance(((ASN1TaggedObject)v0), true);
        }

        throw new IllegalArgumentException("unknown tag: " + ASN1Util.getTagText(((ASN1TaggedObject)v0)));
    }

    private void addOptional(ASN1EncodableVector arg2, int arg3, ASN1Encodable arg4) {
        if(arg4 != null) {
            arg2.add(new DERTaggedObject(true, arg3, arg4));
        }
    }

    public PKIFreeText getFreeText() {
        return this.freeText;
    }

    public InfoTypeAndValue[] getGeneralInfo() {
        ASN1Sequence v0 = this.generalInfo;
        if(v0 == null) {
            return null;
        }

        int v0_1 = v0.size();
        InfoTypeAndValue[] v1 = new InfoTypeAndValue[v0_1];
        int v2;
        for(v2 = 0; v2 < v0_1; ++v2) {
            v1[v2] = InfoTypeAndValue.getInstance(this.generalInfo.getObjectAt(v2));
        }

        return v1;
    }

    public static PKIHeader getInstance(Object arg1) {
        if((arg1 instanceof PKIHeader)) {
            return arg1;
        }

        if(arg1 != null) {
            return new PKIHeader(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1GeneralizedTime getMessageTime() {
        return this.messageTime;
    }

    public AlgorithmIdentifier getProtectionAlg() {
        return this.protectionAlg;
    }

    public ASN1Integer getPvno() {
        return this.pvno;
    }

    public ASN1OctetString getRecipKID() {
        return this.recipKID;
    }

    public ASN1OctetString getRecipNonce() {
        return this.recipNonce;
    }

    public GeneralName getRecipient() {
        return this.recipient;
    }

    public GeneralName getSender() {
        return this.sender;
    }

    public ASN1OctetString getSenderKID() {
        return this.senderKID;
    }

    public ASN1OctetString getSenderNonce() {
        return this.senderNonce;
    }

    public ASN1OctetString getTransactionID() {
        return this.transactionID;
    }

    public ASN1Primitive toASN1Primitive() {
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
        return new DERSequence(v0);
    }
}

