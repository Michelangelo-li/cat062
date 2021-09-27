package cat062.decoder;


import com.alibaba.fastjson.annotation.JSONField;
import cat062.simpleitem.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CAT062Track {

    I062_010_DataSourceIdentifier i062_010_DataSourceIdentifier;
    I062_040_TrackNumber i062_040_TrackNumber;
    I062_060_TrackMode3ACode i062_060_TrackMode3ACode;
    I062_070_TimeOfTrackInformation i062_070_TimeOfTrackInformation;
    I062_100_CalculatedTrackPosition_Cartesian i062_100_CalculatedTrackPosition_Cartesian;
    I062_105_CalculatedTrackPosition_WGS84 i062_105_CalculatedTrackPosition_WGS84;
    I062_130_CalculatedTrackGeometricAltitude i062_130_CalculatedTrackGeometricAltitude;
    I062_135_CalculatedTrackBarometricAltitude i062_135_CalculatedTrackBarometricAltitude;
    I062_136_MeasuredFlightLevel i062_136_MeasuredFlightLevel;
    I062_185_CalculatedTrackVelocity_Cartesian i062_185_CalculatedTrackVelocity_Cartesian;
    I062_200_ModeOfMovement i062_200_ModeOfMovement;
    I062_220_CalculatedRateOfClimbDescent i062_220_CalculatedRateOfClimbDescent;
    I062_245_TargetIdentification i062_245_TargetIdentification;
    I062_380_AircraftDerivedData i062_380_AircraftDerivedData;
    I062_390_FlightPlanRelatedData i062_390_FlightPlanRelatedData;

    // 指定字段不序列化
    @JSONField(serialize = false)
    private List<Integer> existedItems = new ArrayList();

    @JSONField(serialize = false)
    public static int length;

    //index=3,currentIndex += CAT062Track.length,currentIndex += CAT062Track.length;
    public CAT062Track(int[] data, int index) {

        int currentIndex = index;
        int oByte = 0;
        int itemIndex = 0;

        do {
            oByte = data[currentIndex];
            //>>表示右移，如果该数为正，则高位补0，若为负数，则高位补1；00000001=0x01
            for (int i = 7; i >= 1; i--) {
                //其中对应的位为1
                if (((oByte >> i) & 0x01) == 0x01) {
                    existedItems.add(CAT062UAP.UAP[itemIndex]);
                }
                itemIndex += 1;
            }
            currentIndex += 1;

        } while ((oByte & 0x01) == 0x01);
        ////00000001=0x01 只要oByte的最后一位为1就==，就继续

        for (int item : existedItems) {
            switch (item) {
                case 10:
                    i062_010_DataSourceIdentifier = new I062_010_DataSourceIdentifier(data, currentIndex);
                    currentIndex += I062_010_DataSourceIdentifier.length;
                    break;
                case 15: //optional
                    currentIndex += 1;
                    break;
                case 40:
                    i062_040_TrackNumber = new I062_040_TrackNumber(data, currentIndex);
                    currentIndex += I062_040_TrackNumber.length;
                    break;
                case 60:
                    i062_060_TrackMode3ACode = new I062_060_TrackMode3ACode(data, currentIndex);
                    currentIndex += I062_060_TrackMode3ACode.length;
                    break;
                case 70:
                    i062_070_TimeOfTrackInformation = new I062_070_TimeOfTrackInformation(data, currentIndex);
                    currentIndex += I062_070_TimeOfTrackInformation.length;
                    break;
                case 80:
                    //Variable length data item comprising a first part of one Octet, followed by 1-Octet extents as necessary
                    //0x01=0000 0001
                    while ((data[currentIndex] & 0x01) == 0x01) {
                        currentIndex += 1;
                    }
                    currentIndex += 1;
                    break;
                case 100:
                    i062_100_CalculatedTrackPosition_Cartesian = new I062_100_CalculatedTrackPosition_Cartesian(data, currentIndex);
                    currentIndex += I062_100_CalculatedTrackPosition_Cartesian.length;
                    break;
                case 105:
                    i062_105_CalculatedTrackPosition_WGS84 = new I062_105_CalculatedTrackPosition_WGS84(data, currentIndex);
                    currentIndex += I062_105_CalculatedTrackPosition_WGS84.length;
                    break;
                case 110:
                    int sign = data[currentIndex];
                    //todo：currentIndex++,这里不确定，等有数据项时，再完善。
                    currentIndex++;
                    if ((sign & 0x80) == 0x80) {
                        currentIndex += 1;
                    }
                    if ((sign & 0x40) == 0x40) {
                        currentIndex += 4;
                    }
                    if ((sign & 0x20) == 0x20) {
                        currentIndex += 6;
                    }
                    if ((sign & 0x10) == 0x10) {
                        currentIndex += 2;
                    }
                    if ((sign & 0x08) == 0x08) {
                        currentIndex += 2;
                    }
                    if ((sign & 0x04) == 0x04) {
                        currentIndex += 1;
                    }
                    if ((sign & 0x02) == 0x02) {
                        currentIndex += 1;
                    }
                    break;
                case 120:
                    currentIndex += 2;
                    break;
                case 130:
                    i062_130_CalculatedTrackGeometricAltitude = new I062_130_CalculatedTrackGeometricAltitude(data, currentIndex);
                    currentIndex += I062_130_CalculatedTrackGeometricAltitude.length;
                    break;
                case 135:
                    i062_135_CalculatedTrackBarometricAltitude = new I062_135_CalculatedTrackBarometricAltitude(data, currentIndex);
                    currentIndex += I062_135_CalculatedTrackBarometricAltitude.length;
                    break;
                case 136:
                    i062_136_MeasuredFlightLevel = new I062_136_MeasuredFlightLevel(data, currentIndex);
                    currentIndex += I062_136_MeasuredFlightLevel.length;
                    break;
                case 185:
                    i062_185_CalculatedTrackVelocity_Cartesian = new I062_185_CalculatedTrackVelocity_Cartesian(data, currentIndex);
                    currentIndex += I062_185_CalculatedTrackVelocity_Cartesian.length;
                    break;
                case 200:
                    i062_200_ModeOfMovement = new I062_200_ModeOfMovement(data, currentIndex);
                    currentIndex += I062_200_ModeOfMovement.length;
                    break;
                case 210:
                    currentIndex += 2;
                    break;
                case 220:
                    i062_220_CalculatedRateOfClimbDescent = new I062_220_CalculatedRateOfClimbDescent(data, currentIndex);
                    currentIndex += I062_220_CalculatedRateOfClimbDescent.length;
                    break;
                case 245:
                    i062_245_TargetIdentification = new I062_245_TargetIdentification(data, currentIndex);
                    currentIndex += I062_245_TargetIdentification.length;
                    break;
                case 270:
                    while ((data[currentIndex] & 0x01) == 0x01) {
                        currentIndex += 1;
                    }
                    currentIndex += 1;
                    break;
                case 290:
                    int len = 0;
                    int tempSign = data[currentIndex];
                    currentIndex += 1;
                    if ((tempSign & 0x80) == 0x80) {
                        len += 1;
                    }
                    if ((tempSign & 0x40) == 0x40) {
                        len += 1;
                    }
                    if ((tempSign & 0x20) == 0x20) {
                        len += 1;
                    }
                    if ((tempSign & 0x10) == 0x10) {
                        len += 1;
                    }
                    if ((tempSign & 0x08) == 0x08) {
                        len += 2;
                    }
                    if ((tempSign & 0x04) == 0x04) {
                        len += 1;
                    }
                    if ((tempSign & 0x02) == 0x02) {
                        len += 1;
                    }
                    if ((tempSign & 0x01) == 0x01) {
                        tempSign = data[currentIndex];
                        currentIndex += 1;
                        if ((tempSign & 0x80) == 0x80) {
                            len += 1;
                        }
                        if ((tempSign & 0x40) == 0x40) {
                            len += 1;
                        }
                        if ((tempSign & 0x20) == 0x20) {
                            len += 1;
                        }
                    }
                    currentIndex += len;
                    break;
                case 295:
                    int len1 = 0;
                    int sign1 = 0;
                    do {
                        sign1 = data[currentIndex];

                        for (int i = 7; i >= 1; i--) {
                            if (((sign1 >> i) & 0x01) == 0x01) {
                                len1 += 1;
                            }
                        }
                        currentIndex += 1;
                    } while ((sign1 & 0x01) == 0x01);
                    currentIndex += len1;
                    break;
                case 300:
                    currentIndex += 1;
                    break;
                case 340:
                    int sign2 = data[currentIndex];
                    currentIndex += 1;
                    if ((sign2 & 0x80) == 0x80) {
                        currentIndex += 2;
                    }
                    if ((sign2 & 0x40) == 0x40) {
                        currentIndex += 4;
                    }
                    if ((sign2 & 0x20) == 0x20) {
                        currentIndex += 2;
                    }
                    if ((sign2 & 0x10) == 0x10) {
                        currentIndex += 2;
                    }
                    if ((sign2 & 0x08) == 0x08) {
                        currentIndex += 2;
                    }
                    if ((sign2 & 0x04) == 0x04) {
                        currentIndex += 1;
                    }
                    break;
                case 380:
                    i062_380_AircraftDerivedData = new I062_380_AircraftDerivedData(data, currentIndex);
                    currentIndex += I062_380_AircraftDerivedData.length;
                    break;
                case 390:
                    i062_390_FlightPlanRelatedData = new I062_390_FlightPlanRelatedData(data, currentIndex);
                    currentIndex += I062_390_FlightPlanRelatedData.length;
                    break;
                case 500:
                    int len3 = 0;
                    int sign3 = data[currentIndex];
                    currentIndex += 1;
                    if ((sign3 & 0x80) == 0x80) {
                        len3 += 4;
                    }
                    if ((sign3 & 0x40) == 0x40) {
                        len3 += 2;
                    }
                    if ((sign3 & 0x20) == 0x20) {
                        len3 += 4;
                    }
                    if ((sign3 & 0x10) == 0x10) {
                        len3 += 1;
                    }
                    if ((sign3 & 0x08) == 0x08) {
                        len3 += 1;
                    }
                    if ((sign3 & 0x04) == 0x04) {
                        len3 += 2;
                    }
                    if ((sign3 & 0x02) == 0x02) {
                        len3 += 2;
                    }
                    if ((sign3 & 0x01) == 0x01) {
                        sign3 = data[currentIndex];
                        currentIndex += 1;
                        if ((sign3 & 0x80) == 0x80) {
                            len3 += 1;
                        }
                    }
                    currentIndex += len3;
                    break;
                case 510:
                    while ((data[currentIndex + 2] & 0x01) == 0x01) {
                        currentIndex += 3;
                    }
                    currentIndex += 3;
                    break;
                case -1:
                    currentIndex += data[currentIndex];
                    break;
                case -2:
                    while ((data[currentIndex] & 0x01) == 0x01) {
                        currentIndex += 1;
                    }
                    currentIndex += 1;
                    break;
                default:

                    // 10 20
                    if (item <= -3 && item >= -100) {
                        currentIndex += (data[currentIndex] * (-2 - item) + 1);
                    } else if (item < -100) {
                        currentIndex += (-100 - item);
                    }
                    break;
            }

        }


        length = currentIndex - index;


    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(2048);

        return stringBuilder.append(i062_010_DataSourceIdentifier)
                .append(",").append(i062_040_TrackNumber)
                .append(",").append(i062_060_TrackMode3ACode)
                .append(",").append(i062_070_TimeOfTrackInformation)
                .append(",").append(i062_100_CalculatedTrackPosition_Cartesian)
                .append(",").append(i062_105_CalculatedTrackPosition_WGS84)
                .append(",").append(i062_130_CalculatedTrackGeometricAltitude)
                .append(",").append(i062_135_CalculatedTrackBarometricAltitude)
                .append(",").append(i062_136_MeasuredFlightLevel)
                .append(",").append(i062_185_CalculatedTrackVelocity_Cartesian)
                .append(",").append(i062_200_ModeOfMovement)
                .append(",").append(i062_220_CalculatedRateOfClimbDescent)
                .append(",").append(i062_245_TargetIdentification)
                .append(",").append(i062_380_AircraftDerivedData)
                .append(",").append(i062_390_FlightPlanRelatedData)
                .toString();
    }

}
