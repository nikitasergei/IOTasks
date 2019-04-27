package PhoneBook;

import java.util.Objects;

public class Phone {

    private PhoneNumberType pNT;
    private long number;

    public Phone(PhoneNumberType pNT, long number) {
        this.number = number;
        this.pNT = pNT;
    }

    public PhoneNumberType getpNT() {
        return pNT;
    }

    public void setpNT(PhoneNumberType pNT) {
        this.pNT = pNT;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return number == phone.number &&
                pNT == phone.pNT;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pNT, number);
    }

    @Override
    public String toString() {
        return  pNT.toString() + " : " + Long.toString(number);
    }
}
