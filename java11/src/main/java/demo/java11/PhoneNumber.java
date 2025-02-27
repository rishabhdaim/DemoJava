package demo.java11;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

import java.util.Comparator;
import java.util.Formattable;
import java.util.Formatter;

public class PhoneNumber implements Formattable, Comparable<PhoneNumber> {

    private final int areaCode;
    private final int number;
    private static final Comparator<PhoneNumber> PHONE_NUMBER_COMPARATOR = Comparator.comparingInt(PhoneNumber::getAreaCode)
            .thenComparingInt((PhoneNumber::getNumber));

    private PhoneNumber(int areaCode, int number) {
        this.areaCode = areaCode;
        this.number = number;
    }

    public static PhoneNumber of(int areaCode, int number) {
        Preconditions.checkArgument(areaCode > 100);
        Preconditions.checkArgument(number > 1000);
        return new PhoneNumber(areaCode, number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhoneNumber that = (PhoneNumber) o;

        if (areaCode != that.areaCode) return false;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        int result = areaCode;
        result = 31 * result + number;
        return result;
    }

    @Override
    public void formatTo(Formatter formatter, int flags, int width, int precision) {
        formatter.format("%d-%d", areaCode, number);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("areaCode", areaCode).add("number", number).toString();
    }

    public int getAreaCode() {
        return areaCode;
    }

    public int getNumber() {
        return number;
    }

    public static void main(String[] args) {
        System.out.println(PhoneNumber.of(200, 2000));
        System.out.printf("%s", PhoneNumber.of(200, 2000));
    }

    @Override
    public int compareTo(PhoneNumber o) {
        return PHONE_NUMBER_COMPARATOR.compare(this, o);
//        return ComparisonChain.start().compare(this.areaCode, o.areaCode).compare(this.number, o.number).result();
    }
}
