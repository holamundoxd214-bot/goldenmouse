package androidx.compose.ui.autofill;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Deprecated(message="Use the new semantics-based API and androidx.compose.ui.autofill.ContentType instead.") @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\'\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\rj\u0002\b\u000Ej\u0002\b\u000Fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001Aj\u0002\b\u001Bj\u0002\b\u001Cj\u0002\b\u001Dj\u0002\b\u001Ej\u0002\b\u001Fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b\'¨\u0006("}, d2={"Landroidx/compose/ui/autofill/AutofillType;", "", "<init>", "(Ljava/lang/String;I)V", "EmailAddress", "Username", "Password", "NewUsername", "NewPassword", "PostalAddress", "PostalCode", "CreditCardNumber", "CreditCardSecurityCode", "CreditCardExpirationDate", "CreditCardExpirationMonth", "CreditCardExpirationYear", "CreditCardExpirationDay", "AddressCountry", "AddressRegion", "AddressLocality", "AddressStreet", "AddressAuxiliaryDetails", "PostalCodeExtended", "PersonFullName", "PersonFirstName", "PersonLastName", "PersonMiddleName", "PersonMiddleInitial", "PersonNamePrefix", "PersonNameSuffix", "PhoneNumber", "PhoneNumberDevice", "PhoneCountryCode", "PhoneNumberNational", "Gender", "BirthDateFull", "BirthDateDay", "BirthDateMonth", "BirthDateYear", "SmsOtpCode", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public enum AutofillType {
    public static final enum AutofillType AddressAuxiliaryDetails;
    public static final enum AutofillType AddressCountry;
    public static final enum AutofillType AddressLocality;
    public static final enum AutofillType AddressRegion;
    public static final enum AutofillType AddressStreet;
    public static final enum AutofillType BirthDateDay;
    public static final enum AutofillType BirthDateFull;
    public static final enum AutofillType BirthDateMonth;
    public static final enum AutofillType BirthDateYear;
    public static final enum AutofillType CreditCardExpirationDate;
    public static final enum AutofillType CreditCardExpirationDay;
    public static final enum AutofillType CreditCardExpirationMonth;
    public static final enum AutofillType CreditCardExpirationYear;
    public static final enum AutofillType CreditCardNumber;
    public static final enum AutofillType CreditCardSecurityCode;
    public static final enum AutofillType EmailAddress;
    public static final enum AutofillType Gender;
    public static final enum AutofillType NewPassword;
    public static final enum AutofillType NewUsername;
    public static final enum AutofillType Password;
    public static final enum AutofillType PersonFirstName;
    public static final enum AutofillType PersonFullName;
    public static final enum AutofillType PersonLastName;
    public static final enum AutofillType PersonMiddleInitial;
    public static final enum AutofillType PersonMiddleName;
    public static final enum AutofillType PersonNamePrefix;
    public static final enum AutofillType PersonNameSuffix;
    public static final enum AutofillType PhoneCountryCode;
    public static final enum AutofillType PhoneNumber;
    public static final enum AutofillType PhoneNumberDevice;
    public static final enum AutofillType PhoneNumberNational;
    public static final enum AutofillType PostalAddress;
    public static final enum AutofillType PostalCode;
    public static final enum AutofillType PostalCodeExtended;
    public static final enum AutofillType SmsOtpCode;
    public static final enum AutofillType Username;

    private static final AutofillType[] $values() {
        return new AutofillType[]{AutofillType.EmailAddress, AutofillType.Username, AutofillType.Password, AutofillType.NewUsername, AutofillType.NewPassword, AutofillType.PostalAddress, AutofillType.PostalCode, AutofillType.CreditCardNumber, AutofillType.CreditCardSecurityCode, AutofillType.CreditCardExpirationDate, AutofillType.CreditCardExpirationMonth, AutofillType.CreditCardExpirationYear, AutofillType.CreditCardExpirationDay, AutofillType.AddressCountry, AutofillType.AddressRegion, AutofillType.AddressLocality, AutofillType.AddressStreet, AutofillType.AddressAuxiliaryDetails, AutofillType.PostalCodeExtended, AutofillType.PersonFullName, AutofillType.PersonFirstName, AutofillType.PersonLastName, AutofillType.PersonMiddleName, AutofillType.PersonMiddleInitial, AutofillType.PersonNamePrefix, AutofillType.PersonNameSuffix, AutofillType.PhoneNumber, AutofillType.PhoneNumberDevice, AutofillType.PhoneCountryCode, AutofillType.PhoneNumberNational, AutofillType.Gender, AutofillType.BirthDateFull, AutofillType.BirthDateDay, AutofillType.BirthDateMonth, AutofillType.BirthDateYear, AutofillType.SmsOtpCode};
    }

    static {
        AutofillType.EmailAddress = new AutofillType("EmailAddress", 0);
        AutofillType.Username = new AutofillType("Username", 1);
        AutofillType.Password = new AutofillType("Password", 2);
        AutofillType.NewUsername = new AutofillType("NewUsername", 3);
        AutofillType.NewPassword = new AutofillType("NewPassword", 4);
        AutofillType.PostalAddress = new AutofillType("PostalAddress", 5);
        AutofillType.PostalCode = new AutofillType("PostalCode", 6);
        AutofillType.CreditCardNumber = new AutofillType("CreditCardNumber", 7);
        AutofillType.CreditCardSecurityCode = new AutofillType("CreditCardSecurityCode", 8);
        AutofillType.CreditCardExpirationDate = new AutofillType("CreditCardExpirationDate", 9);
        AutofillType.CreditCardExpirationMonth = new AutofillType("CreditCardExpirationMonth", 10);
        AutofillType.CreditCardExpirationYear = new AutofillType("CreditCardExpirationYear", 11);
        AutofillType.CreditCardExpirationDay = new AutofillType("CreditCardExpirationDay", 12);
        AutofillType.AddressCountry = new AutofillType("AddressCountry", 13);
        AutofillType.AddressRegion = new AutofillType("AddressRegion", 14);
        AutofillType.AddressLocality = new AutofillType("AddressLocality", 15);
        AutofillType.AddressStreet = new AutofillType("AddressStreet", 16);
        AutofillType.AddressAuxiliaryDetails = new AutofillType("AddressAuxiliaryDetails", 17);
        AutofillType.PostalCodeExtended = new AutofillType("PostalCodeExtended", 18);
        AutofillType.PersonFullName = new AutofillType("PersonFullName", 19);
        AutofillType.PersonFirstName = new AutofillType("PersonFirstName", 20);
        AutofillType.PersonLastName = new AutofillType("PersonLastName", 21);
        AutofillType.PersonMiddleName = new AutofillType("PersonMiddleName", 22);
        AutofillType.PersonMiddleInitial = new AutofillType("PersonMiddleInitial", 23);
        AutofillType.PersonNamePrefix = new AutofillType("PersonNamePrefix", 24);
        AutofillType.PersonNameSuffix = new AutofillType("PersonNameSuffix", 25);
        AutofillType.PhoneNumber = new AutofillType("PhoneNumber", 26);
        AutofillType.PhoneNumberDevice = new AutofillType("PhoneNumberDevice", 27);
        AutofillType.PhoneCountryCode = new AutofillType("PhoneCountryCode", 28);
        AutofillType.PhoneNumberNational = new AutofillType("PhoneNumberNational", 29);
        AutofillType.Gender = new AutofillType("Gender", 30);
        AutofillType.BirthDateFull = new AutofillType("BirthDateFull", 0x1F);
        AutofillType.BirthDateDay = new AutofillType("BirthDateDay", 0x20);
        AutofillType.BirthDateMonth = new AutofillType("BirthDateMonth", 33);
        AutofillType.BirthDateYear = new AutofillType("BirthDateYear", 34);
        AutofillType.SmsOtpCode = new AutofillType("SmsOtpCode", 35);
        AutofillType[] v0 = AutofillType.$values();
        AutofillType.$VALUES = v0;
        AutofillType.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private AutofillType(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return AutofillType.$ENTRIES;
    }

    public static AutofillType valueOf(String arg1) {
        return Enum.valueOf(AutofillType.class, arg1);
    }

    public static AutofillType[] values() {
        return AutofillType.$VALUES.clone();
    }
}

