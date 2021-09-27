package cat062.I062_380;


import lombok.Data;

/**
 * "address": 7869913
 */
@Data
public class TargetAddress {

    private int Address;

    public static final int length = 3;

    public TargetAddress(int[] data, int index) {
        Address = (data[index] << 16) | (data[index + 1] << 8) | data[index + 2];
    }

    @Override
    public String toString() {
        return Address + "";
    }

}
