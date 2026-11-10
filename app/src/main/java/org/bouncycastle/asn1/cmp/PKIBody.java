package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.crmf.CertReqMessages;
import org.bouncycastle.asn1.pkcs.CertificationRequest;
import org.bouncycastle.util.Exceptions;

public class PKIBody extends ASN1Object implements ASN1Choice {
    public static final int TYPE_CA_KEY_UPDATE_ANN = 15;
    public static final int TYPE_CERT_ANN = 16;
    public static final int TYPE_CERT_CONFIRM = 24;
    public static final int TYPE_CERT_REP = 3;
    public static final int TYPE_CERT_REQ = 2;
    public static final int TYPE_CONFIRM = 19;
    public static final int TYPE_CRL_ANN = 18;
    public static final int TYPE_CROSS_CERT_REP = 14;
    public static final int TYPE_CROSS_CERT_REQ = 13;
    public static final int TYPE_ERROR = 23;
    public static final int TYPE_GEN_MSG = 21;
    public static final int TYPE_GEN_REP = 22;
    public static final int TYPE_INIT_REP = 1;
    public static final int TYPE_INIT_REQ = 0;
    public static final int TYPE_KEY_RECOVERY_REP = 10;
    public static final int TYPE_KEY_RECOVERY_REQ = 9;
    public static final int TYPE_KEY_UPDATE_REP = 8;
    public static final int TYPE_KEY_UPDATE_REQ = 7;
    public static final int TYPE_NESTED = 20;
    public static final int TYPE_P10_CERT_REQ = 4;
    public static final int TYPE_POLL_REP = 26;
    public static final int TYPE_POLL_REQ = 25;
    public static final int TYPE_POPO_CHALL = 5;
    public static final int TYPE_POPO_REP = 6;
    public static final int TYPE_REVOCATION_ANN = 17;
    public static final int TYPE_REVOCATION_REP = 12;
    public static final int TYPE_REVOCATION_REQ = 11;
    private final ASN1Encodable body;
    private final int tagNo;

    public PKIBody(int arg1, ASN1Encodable arg2) {
        super();
        this.tagNo = arg1;
        this.body = PKIBody.getBodyForType(arg1, arg2);
    }

    private PKIBody(ASN1TaggedObject arg3) {
        String v0 = "malformed body found: ";
        super();
        int v1 = arg3.getTagNo();
        this.tagNo = v1;
        try {
            this.body = PKIBody.getBodyForType(v1, arg3.getExplicitBaseObject());
            return;
        }
        catch(IllegalArgumentException v2) {
            throw Exceptions.illegalArgumentException(v0 + v2.getMessage(), ((Throwable)v2));
        }
        catch(ClassCastException v2_1) {
            throw Exceptions.illegalArgumentException(v0 + v2_1.getMessage(), ((Throwable)v2_1));
        }
    }

    private static ASN1Encodable getBodyForType(int arg5, ASN1Encodable arg6) {
        PKIMessages v5_12;
        String v0 = "unknown tag number: ";
        String v1 = " has incorrect type got: ";
        String v2 = "body type of ";
        switch(arg5) {
            case 4: {
                goto label_44;
            }
            case 5: {
                goto label_42;
            }
            case 6: {
                goto label_40;
            }
            case 10: {
                goto label_38;
            }
            case 11: {
                goto label_36;
            }
            case 12: {
                goto label_34;
            }
            case 0: 
            case 2: 
            case 7: 
            case 9: 
            case 13: {
                goto label_32;
            }
            case 1: 
            case 3: 
            case 8: 
            case 14: {
                goto label_30;
            }
            case 15: {
                goto label_28;
            }
            case 16: {
                goto label_26;
            }
            case 17: {
                goto label_24;
            }
            case 18: {
                goto label_22;
            }
            case 19: {
                goto label_20;
            }
            case 20: {
                goto label_18;
            }
            case 21: {
                goto label_16;
            }
            case 22: {
                goto label_14;
            }
            case 23: {
                goto label_12;
            }
            case 24: {
                goto label_10;
            }
            case 25: {
                goto label_8;
            }
            case 26: {
                goto label_6;
            }
        }

        try {
            throw new IllegalArgumentException(v0 + arg5);
        label_34:
            RevRepContent v5 = RevRepContent.getInstance(arg6);
            return ((ASN1Encodable)v5);
        label_36:
            RevReqContent v5_1 = RevReqContent.getInstance(arg6);
            return ((ASN1Encodable)v5_1);
        label_38:
            KeyRecRepContent v5_2 = KeyRecRepContent.getInstance(arg6);
            return ((ASN1Encodable)v5_2);
        label_40:
            POPODecKeyRespContent v5_3 = POPODecKeyRespContent.getInstance(arg6);
            return ((ASN1Encodable)v5_3);
        label_42:
            POPODecKeyChallContent v5_4 = POPODecKeyChallContent.getInstance(arg6);
            return ((ASN1Encodable)v5_4);
        label_44:
            CertificationRequest v5_5 = CertificationRequest.getInstance(arg6);
            return ((ASN1Encodable)v5_5);
        label_6:
            PollRepContent v5_6 = PollRepContent.getInstance(arg6);
            return ((ASN1Encodable)v5_6);
        label_8:
            PollReqContent v5_7 = PollReqContent.getInstance(arg6);
            return ((ASN1Encodable)v5_7);
        label_10:
            CertConfirmContent v5_8 = CertConfirmContent.getInstance(arg6);
            return ((ASN1Encodable)v5_8);
        label_12:
            ErrorMsgContent v5_9 = ErrorMsgContent.getInstance(arg6);
            return ((ASN1Encodable)v5_9);
        label_14:
            GenRepContent v5_10 = GenRepContent.getInstance(arg6);
            return ((ASN1Encodable)v5_10);
        label_16:
            GenMsgContent v5_11 = GenMsgContent.getInstance(arg6);
            return ((ASN1Encodable)v5_11);
        label_18:
            v5_12 = PKIMessages.getInstance(arg6);
            return ((ASN1Encodable)v5_12);
        label_20:
            PKIConfirmContent v5_13 = PKIConfirmContent.getInstance(arg6);
            return ((ASN1Encodable)v5_13);
        label_22:
            CRLAnnContent v5_14 = CRLAnnContent.getInstance(arg6);
            return ((ASN1Encodable)v5_14);
        label_24:
            RevAnnContent v5_15 = RevAnnContent.getInstance(arg6);
            return ((ASN1Encodable)v5_15);
        label_26:
            CMPCertificate v5_16 = CMPCertificate.getInstance(arg6);
            return ((ASN1Encodable)v5_16);
        label_28:
            CAKeyUpdAnnContent v5_17 = CAKeyUpdAnnContent.getInstance(arg6);
            return ((ASN1Encodable)v5_17);
        label_30:
            CertRepMessage v5_18 = CertRepMessage.getInstance(arg6);
            return ((ASN1Encodable)v5_18);
        label_32:
            CertReqMessages v5_19 = CertReqMessages.getInstance(arg6);
            return ((ASN1Encodable)v5_19);
        }
        catch(IllegalArgumentException ) {
            throw new IllegalArgumentException(v2 + (((int)v5_12)) + v1 + arg6.getClass());
        }
        catch(ClassCastException ) {
            throw new IllegalArgumentException(v2 + (((int)v5_12)) + v1 + arg6.getClass());
        }
    }

    public ASN1Encodable getContent() {
        return this.body;
    }

    public static PKIBody getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof PKIBody)) {
            }
            else if((arg3 instanceof ASN1TaggedObject)) {
                return new PKIBody(((ASN1TaggedObject)arg3));
            }
            else {
                throw new IllegalArgumentException("Invalid object: " + arg3.getClass().getName());
            }
        }

        return arg3;
    }

    public int getType() {
        return this.tagNo;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(true, this.tagNo, this.body);
    }
}

