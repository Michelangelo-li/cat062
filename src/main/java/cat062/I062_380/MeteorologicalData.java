package cat062.I062_380;

import lombok.Data;

/**
 * Meteorological Data
 * 气象资料
 */
@Data
public class MeteorologicalData {

    private int WS;

    private int WD;

    private int TMP;

    private int TRB;

    /**
     * uint:knot, LSB:1
     */
    private int WindSpeed;

    /**
     * uint:°, LSB:1
     */
    private int WindDirection;

    /**
     * uint:°C, LSB:0.25
     */
    private double Temperature;

    //湍流
    private int Turbulence;

    public static final int length = 8;

    public MeteorologicalData(int[] data, int index) {

        int originalByte = data[index];

        WS = (originalByte >> 7) & 0x01;
        WD = (originalByte >> 6) & 0x01;
        TMP = (originalByte >> 5) & 0x01;
        TRB = (originalByte >> 4) & 0x01;

        /**
         * uint:knot, LSB:1
         */
        WindSpeed = (data[index + 1] << 8) | data[index + 2];
        /**
         * uint:°, LSB:1
         */
        WindDirection = (data[index + 3] << 8) | data[index + 4];

        /**
         * uint:°C, LSB:0.25
         */
        //toShort
        Temperature = ((data[index + 5] << 8) | data[index + 6]) * 0.25;

        Turbulence = data[index + 7];
    }


    @Override
    public String toString() {
        return WS + "|" + WD + "|" + TMP + "|" + TRB + "|" +
                WindSpeed + "|" + WindDirection + "|" + Temperature + "|" + Turbulence;
    }

}
