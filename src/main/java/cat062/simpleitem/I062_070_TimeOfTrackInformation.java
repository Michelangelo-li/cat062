package cat062.simpleitem;

import lombok.Data;


/**
 * Cat 062 Item 070 - Time of track information - Mandatory
 * Absolute time stamping of the information provided in the track message,
 * in the form of elapsed time since last midnight,
 * expressed as UTC.
 * Unit of measure is 1/128 sec
 *
 * this is the time of the track state vector
 * the time is reset to zero at every midnight
 *
 * 跟踪时间
 */
@Data
public class I062_070_TimeOfTrackInformation {

    private double Time;

    public static final int length = 3;

    public I062_070_TimeOfTrackInformation(int[] data, int index) {

        Time = ((data[index] << 16) | (data[index + 1] << 8) | data[index + 2]) / 128.0;
    }

    @Override
    public String toString() {
        return Time + "";
    }


}
