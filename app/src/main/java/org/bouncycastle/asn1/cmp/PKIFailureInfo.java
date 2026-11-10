package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.DERBitString;

public class PKIFailureInfo extends DERBitString {
    public static final int ADD_INFO_NOT_AVAILABLE = 0x400000;
    public static final int BAD_ALG = 0x80;
    public static final int BAD_CERT_ID = 8;
    public static final int BAD_DATA_FORMAT = 4;
    public static final int BAD_MESSAGE_CHECK = 0x40;
    public static final int BAD_POP = 0x4000;
    public static final int BAD_REQUEST = 0x20;
    public static final int BAD_TIME = 16;
    public static final int INCORRECT_DATA = 1;
    public static final int MISSING_TIME_STAMP = 0x8000;
    public static final int SYSTEM_FAILURE = 0x40000000;
    public static final int TIME_NOT_AVAILABLE = 0x200;
    public static final int UNACCEPTED_EXTENSION = 0x800000;
    public static final int UNACCEPTED_POLICY = 0x100;
    public static final int WRONG_AUTHORITY = 2;
    public static final int addInfoNotAvailable = 0x400000;
    public static final int badAlg = 0x80;
    public static final int badCertId = 8;
    public static final int badCertTemplate = 0x100000;
    public static final int badDataFormat = 4;
    public static final int badMessageCheck = 0x40;
    public static final int badPOP = 0x4000;
    public static final int badRecipientNonce = 0x400;
    public static final int badRequest = 0x20;
    public static final int badSenderNonce = 0x200000;
    public static final int badTime = 16;
    public static final int certConfirmed = 0x1000;
    public static final int certRevoked = 0x2000;
    public static final int duplicateCertReq = 0x20000000;
    public static final int incorrectData = 1;
    public static final int missingTimeStamp = 0x8000;
    public static final int notAuthorized = 0x10000;
    public static final int signerNotTrusted = 0x80000;
    public static final int systemFailure = 0x40000000;
    public static final int systemUnavail = 0x80000000;
    public static final int timeNotAvailable = 0x200;
    public static final int transactionIdInUse = 0x40000;
    public static final int unacceptedExtension = 0x800000;
    public static final int unacceptedPolicy = 0x100;
    public static final int unsupportedVersion = 0x20000;
    public static final int wrongAuthority = 2;
    public static final int wrongIntegrity = 0x800;

    public PKIFailureInfo(int arg2) {
        super(PKIFailureInfo.getBytes(arg2), PKIFailureInfo.getPadBits(arg2));
    }

    public PKIFailureInfo(ASN1BitString arg2) {
        super(arg2.getBytes(), arg2.getPadBits());
    }

    public String toString() {
        return "PKIFailureInfo: 0x" + Integer.toHexString(this.intValue());
    }
}

