package cat062.I062_380;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 意向数据
 */
@Data
@AllArgsConstructor
public class IntentData {

    private int TCA;

    private int NC;

    private int TCPNumber;

    /**
     * unit:ft, LSB:10
     */
    private int Altitude;

    /**
     * uint:°, LSB:180°/(2**23)=180°/8388608
     */
    private double Latitude;

    /**
     * uint:°, LSB:180°/(2**23)=180°/8388608
     */
    private double Longitude;


    private int PointType;

    private int TD;

    private int TRA;

    private int TOA;

    private int TOV;

    private double TTR;


    @Override
    public String toString() {
        return TCA + "|" + NC + "|" + TCPNumber + "|" +
                Altitude + "|" + Latitude + "|" + Longitude + "|" + PointType + "|" +
                TD + "|" + TRA + "|" + TOA + "|" + TOV + "|" + TTR;
    }

}
