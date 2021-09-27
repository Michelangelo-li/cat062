package cat062.simpleitem;

import lombok.Data;


/**
 * Cat 062 Item 136 - Measured Flight Level (MFL)
 * Last valid and credible flight level used to update the track, in
 * two’s complement form. The criteria to determine the credibility of the flight level are Tracker
 * dependent.Credible means: within reasonable range of change with respect to the previous detection
 * Validation: -15FL to 1500 FL
 *
 * 实测飞行高度
 */
@Data
public class I062_136_MeasuredFlightLevel {

    /**
     * uint:ft, LSB:6.25, min:-1500, max:150000
     */
    private double FlightLevel;


    public static final int length = 2;

    //toshort
    public I062_136_MeasuredFlightLevel(int[] data, int index) {
        FlightLevel = ((data[index] << 8) | data[index + 1]) / 4.0;
    }

    @Override
    public String toString() {
        return FlightLevel + "";
    }
}
