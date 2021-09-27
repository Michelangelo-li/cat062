package cat062.I062_390;

import lombok.Data;

/**
 * 目的机场
 */
@Data
public class DestinationAirport {

    private String Airport;

    public static final int length = 4;

    public DestinationAirport(int[] data, int index) {

//        Airport = CommonUtil.bytesToASCII(data[index],data[index + 1],data[index + 2],data[index + 3]);

//
//      byte c = (byte) (bi & 0xFF);

        Airport = new String(new char[]{
                (char) (byte) (data[index] & 0xFF),
                (char) (byte) (data[index + 1] & 0xFF),
                (char) (byte) (data[index + 2] & 0xFF),
                (char) (byte) (data[index + 3] & 0xFF)
        });

    }

    @Override
    public String toString() {
        return Airport;
    }

}
