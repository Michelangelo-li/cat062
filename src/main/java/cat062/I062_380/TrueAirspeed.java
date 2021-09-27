package cat062.I062_380;

import lombok.Data;

/**
 * 空速
 */
@Data
public class TrueAirspeed {

    private int Airspeed;

    public static final int length = 2;

    public TrueAirspeed(int[] data, int index) {

        Airspeed = (data[index] << 8) | data[index + 1];
    }

    @Override
    public String toString() {
        return Airspeed+"";
    }

}
