package cat062.I062_380;

import lombok.Data;

/**
 * 指示空速参数指示空速或马赫数
 *
 * //MACH NUMBER and AIRSPEED vs. ALTITUDE MACH NUMBER
 */
@Data
public class IndicatedAirspeedOrMachNumber {

    /**
     * IM=0:IAS, IM=1:Mach
     */
    private int IM;

    /**
     * uint:IAS or Mach, LSB:2**-14 NM/s or 0.001
     */
    private double Airspeed;

    public static final int length = 2;

    public IndicatedAirspeedOrMachNumber(int[] data, int index) {

        int b16 = (data[index] << 8) | data[index + 1];

        IM = (b16 >> 15) & 0x01;

        int tmp = b16 & 0x7FFF;

        Airspeed = (IM == 0) ? 0.00006103515625 * tmp : 0.001 * tmp;
    }


    @Override
    public String toString() {
        return Airspeed + "|" + IM;
    }

}
