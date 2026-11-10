package androidx.compose.ui.autofill;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

@Metadata(d1={"\u0000\u001A\n\u0000\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u001E\u0010\u0000\u001A\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006\"0\u0010\u0007\u001A\u001E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\bj\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001`\tX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u000B¨\u0006\f"}, d2={"androidType", "", "Landroidx/compose/ui/autofill/AutofillType;", "getAndroidType$annotations", "(Landroidx/compose/ui/autofill/AutofillType;)V", "getAndroidType", "(Landroidx/compose/ui/autofill/AutofillType;)Ljava/lang/String;", "androidAutofillTypes", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getAndroidAutofillTypes$annotations", "()V", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidAutofillType_androidKt {
    private static final HashMap androidAutofillTypes;

    static {
        AndroidAutofillType_androidKt.androidAutofillTypes = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(AutofillType.EmailAddress, "emailAddress"), TuplesKt.to(AutofillType.Username, "username"), TuplesKt.to(AutofillType.Password, "password"), TuplesKt.to(AutofillType.NewUsername, "newUsername"), TuplesKt.to(AutofillType.NewPassword, "newPassword"), TuplesKt.to(AutofillType.PostalAddress, "postalAddress"), TuplesKt.to(AutofillType.PostalCode, "postalCode"), TuplesKt.to(AutofillType.CreditCardNumber, "creditCardNumber"), TuplesKt.to(AutofillType.CreditCardSecurityCode, "creditCardSecurityCode"), TuplesKt.to(AutofillType.CreditCardExpirationDate, "creditCardExpirationDate"), TuplesKt.to(AutofillType.CreditCardExpirationMonth, "creditCardExpirationMonth"), TuplesKt.to(AutofillType.CreditCardExpirationYear, "creditCardExpirationYear"), TuplesKt.to(AutofillType.CreditCardExpirationDay, "creditCardExpirationDay"), TuplesKt.to(AutofillType.AddressCountry, "addressCountry"), TuplesKt.to(AutofillType.AddressRegion, "addressRegion"), TuplesKt.to(AutofillType.AddressLocality, "addressLocality"), TuplesKt.to(AutofillType.AddressStreet, "streetAddress"), TuplesKt.to(AutofillType.AddressAuxiliaryDetails, "extendedAddress"), TuplesKt.to(AutofillType.PostalCodeExtended, "extendedPostalCode"), TuplesKt.to(AutofillType.PersonFullName, "personName"), TuplesKt.to(AutofillType.PersonFirstName, "personGivenName"), TuplesKt.to(AutofillType.PersonLastName, "personFamilyName"), TuplesKt.to(AutofillType.PersonMiddleName, "personMiddleName"), TuplesKt.to(AutofillType.PersonMiddleInitial, "personMiddleInitial"), TuplesKt.to(AutofillType.PersonNamePrefix, "personNamePrefix"), TuplesKt.to(AutofillType.PersonNameSuffix, "personNameSuffix"), TuplesKt.to(AutofillType.PhoneNumber, "phoneNumber"), TuplesKt.to(AutofillType.PhoneNumberDevice, "phoneNumberDevice"), TuplesKt.to(AutofillType.PhoneCountryCode, "phoneCountryCode"), TuplesKt.to(AutofillType.PhoneNumberNational, "phoneNational"), TuplesKt.to(AutofillType.Gender, "gender"), TuplesKt.to(AutofillType.BirthDateFull, "birthDateFull"), TuplesKt.to(AutofillType.BirthDateDay, "birthDateDay"), TuplesKt.to(AutofillType.BirthDateMonth, "birthDateMonth"), TuplesKt.to(AutofillType.BirthDateYear, "birthDateYear"), TuplesKt.to(AutofillType.SmsOtpCode, "smsOTPCode")});
    }

    private static void getAndroidAutofillTypes$annotations() {
    }

    public static final String getAndroidType(AutofillType arg1) {
        Object v1 = AndroidAutofillType_androidKt.androidAutofillTypes.get(arg1);
        if(v1 != null) {
            return ((String)v1);
        }

        throw new IllegalArgumentException("Unsupported autofill type".toString());
    }

    public static void getAndroidType$annotations(AutofillType arg0) {
    }
}

