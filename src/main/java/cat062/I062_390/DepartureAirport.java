package cat062.I062_390;

import lombok.Data;

/**
 * 起飞机场
 */
@Data
public class DepartureAirport {

    private String Airport;

    public static final int length = 4;

    //65-90之间才是字母
    public DepartureAirport(int[] data, int index) {

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


    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            String j = ((num & 1 << i)) == 0 ? "0" : "1";
            System.out.print(j);
        }
    }

}
