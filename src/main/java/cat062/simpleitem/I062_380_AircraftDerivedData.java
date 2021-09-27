package cat062.simpleitem;

import com.alibaba.fastjson.annotation.JSONField;
import cat062.I062_380.*;
import lombok.Data;


/**
 * 飞机衍生数据Aircraft Derived Data
 *
 * 模式S/ADS-B相关数据
 */
@Data
public class I062_380_AircraftDerivedData {

    @JSONField(serialize = false)
    private boolean[] existedItems = new boolean[32];


    private cat062.I062_380.TargetAddress targetAddress = null;

    private cat062.I062_380.TargetIdentification targetIdentification = null;

    private cat062.I062_380.MagneticHeading magneticHeading = null;

    private cat062.I062_380.IndicatedAirspeedOrMachNumber indicatedAirspeedOrMachNumber = null;

    private cat062.I062_380.TrueAirspeed trueAirspeed = null;

    private cat062.I062_380.SelectedAltitude selectedAltitude = null;

    private cat062.I062_380.FinalStateSelectedAltitude finalStateSelectedAltitude = null;

    private cat062.I062_380.TrajectoryIntentStatus trajectoryIntentStatus = null;

    private cat062.I062_380.TrajectoryIntentData trajectoryIntentData = null;

    private cat062.I062_380.CommunicationsACASCapabilityAndFlightStatus communicationsACASCapabilityAndFlightStatus = null;

    private cat062.I062_380.StatusReportedByADSB statusReportedByADSB = null;

    private cat062.I062_380.ACASResolutionAdvisoryReport aCASResolutionAdvisoryReport = null;

    private cat062.I062_380.BarometricVerticalRate barometricVerticalRate = null;

    private cat062.I062_380.GeometricVerticalRate geometricVerticalRate = null;

    private cat062.I062_380.RollAngle rollAngle = null;

    private cat062.I062_380.TrackAngleRate trackAngleRate = null;

    private cat062.I062_380.TrackAngle trackAngle = null;

    private cat062.I062_380.GroundSpeed groundSpeed = null;

    private cat062.I062_380.VelocityUncertainty velocityUncertainty = null;

    private cat062.I062_380.MeteorologicalData meteorologicalData = null;

    private cat062.I062_380.EmitterCategory emitterCategory = null;

    private cat062.I062_380.Position position = null;

    private cat062.I062_380.GeometricAltitude geometricAltitude = null;

    private cat062.I062_380.PositionUncertainty positionUncertainty = null;

    private cat062.I062_380.ModeSMBData modeSMBData = null;

    private cat062.I062_380.IndicatedAirspeed indicatedAirspeed = null;

    private cat062.I062_380.MachNumber machNumber = null;

    private cat062.I062_380.BarometricPressureSetting barometricPressureSetting = null;


    public static int length;


    public I062_380_AircraftDerivedData(int[] data, int index) {

        int currentIndex = index;

        int oByte = 0;

        int itemIndex = 32;

        do {
            // adr
            oByte = data[currentIndex];

            for (int i = 7; i >= 1; i--) { //7
                itemIndex -= 1; //31
                // 1 为 true
                existedItems[itemIndex] = ((oByte >> i) & 0x01) == 0x01;
            }
            itemIndex -= 1;
            currentIndex += 1;

        } while ((oByte & 0x01) == 0x01);


        if (existedItems[31]) {
            targetAddress = new TargetAddress(data, currentIndex);
            currentIndex += TargetAddress.length;
        }

        if (existedItems[30]) {
            targetIdentification = new TargetIdentification(data, currentIndex);
            currentIndex += TargetIdentification.length;
        }

        if (existedItems[29]) {
            magneticHeading = new MagneticHeading(data, currentIndex);
            currentIndex += MagneticHeading.length;
        }

        if (existedItems[28]) {
            indicatedAirspeedOrMachNumber = new IndicatedAirspeedOrMachNumber(data, currentIndex);
            currentIndex += IndicatedAirspeedOrMachNumber.length;
        }

        if (existedItems[27]) {
            trueAirspeed = new TrueAirspeed(data, currentIndex);
            currentIndex += TrueAirspeed.length;
        }

        if (existedItems[26]) {
            selectedAltitude = new SelectedAltitude(data, currentIndex);
            currentIndex += SelectedAltitude.length;
        }

        if (existedItems[25]) {
            finalStateSelectedAltitude = new FinalStateSelectedAltitude(data, currentIndex);
            currentIndex += FinalStateSelectedAltitude.length;
        }

        if (existedItems[23]) {
            trajectoryIntentStatus = new TrajectoryIntentStatus(data, currentIndex);
            currentIndex += TrajectoryIntentStatus.length;
        }

        if (existedItems[22]) {
            trajectoryIntentData = new TrajectoryIntentData(data, currentIndex);
            currentIndex += TrajectoryIntentData.length;
        }

        if (existedItems[21]) {
            communicationsACASCapabilityAndFlightStatus = new CommunicationsACASCapabilityAndFlightStatus(data, currentIndex);
            currentIndex += CommunicationsACASCapabilityAndFlightStatus.length;
        }

        if (existedItems[20]) {
            statusReportedByADSB = new StatusReportedByADSB(data, currentIndex);
            currentIndex += StatusReportedByADSB.length;
        }

        if (existedItems[19]) {
            aCASResolutionAdvisoryReport = new ACASResolutionAdvisoryReport(data, currentIndex);
            currentIndex += ACASResolutionAdvisoryReport.length;
        }

        if (existedItems[18]) {
            barometricVerticalRate = new BarometricVerticalRate(data, currentIndex);
            currentIndex += BarometricVerticalRate.length;
        }

        if (existedItems[17]) {
            geometricVerticalRate = new GeometricVerticalRate(data, currentIndex);
            currentIndex += GeometricVerticalRate.length;
        }

        if (existedItems[15]) {
            rollAngle = new RollAngle(data, currentIndex);
            currentIndex += RollAngle.length;
        }

        if (existedItems[14]) {
            trackAngleRate = new TrackAngleRate(data, currentIndex);
            currentIndex += TrackAngleRate.length;
        }

        if (existedItems[13]) {
            trackAngle = new TrackAngle(data, currentIndex);
            currentIndex += TrackAngle.length;
        }

        if (existedItems[12]) {
            groundSpeed = new GroundSpeed(data, currentIndex);
            currentIndex += GroundSpeed.length;
        }

        if (existedItems[11]) {
            velocityUncertainty = new VelocityUncertainty(data, currentIndex);
            currentIndex += VelocityUncertainty.length;
        }

        if (existedItems[10]) {
            meteorologicalData = new MeteorologicalData(data, currentIndex);
            currentIndex += MeteorologicalData.length;
        }

        if (existedItems[9]) {
            emitterCategory = new EmitterCategory(data, currentIndex);
            currentIndex += EmitterCategory.length;
        }

        if (existedItems[7]) {
            position = new Position(data, currentIndex);
            currentIndex += Position.length;
        }

        if (existedItems[6]) {
            geometricAltitude = new GeometricAltitude(data, currentIndex);
            currentIndex += GeometricAltitude.length;
        }

        if (existedItems[5]) {
            positionUncertainty = new PositionUncertainty(data, currentIndex);
            currentIndex += PositionUncertainty.length;
        }

        if (existedItems[4]) {
            modeSMBData = new ModeSMBData(data, currentIndex);
            currentIndex += ModeSMBData.length;
        }

        if (existedItems[3]) {
            indicatedAirspeed = new IndicatedAirspeed(data, currentIndex);
            currentIndex += IndicatedAirspeed.length;
        }

        if (existedItems[2]) {
            machNumber = new MachNumber(data, currentIndex);
            currentIndex += MachNumber.length;
        }

        if (existedItems[1]) {
            barometricPressureSetting = new BarometricPressureSetting(data, currentIndex);
            currentIndex += BarometricPressureSetting.length;
        }

        length = currentIndex - index;
    }


    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder(1024);

        return stringBuilder.append(targetAddress)
                .append(",").append(targetIdentification)
                .append(",").append(magneticHeading)
                .append(",").append(indicatedAirspeedOrMachNumber)
                .append(",").append(trueAirspeed)
                .append(",").append(selectedAltitude)
                .append(",").append(finalStateSelectedAltitude)
                .append(",").append(trajectoryIntentStatus)
                .append(",").append(trajectoryIntentData)
                .append(",").append(communicationsACASCapabilityAndFlightStatus)
                .append(",").append(statusReportedByADSB)
                .append(",").append(aCASResolutionAdvisoryReport)
                .append(",").append(barometricVerticalRate)
                .append(",").append(geometricVerticalRate)
                .append(",").append(rollAngle)
                .append(",").append(trackAngleRate)
                .append(",").append(trackAngle)
                .append(",").append(groundSpeed)
                .append(",").append(velocityUncertainty)
                .append(",").append(meteorologicalData)
                .append(",").append(emitterCategory)
                .append(",").append(position)
                .append(",").append(geometricAltitude)
                .append(",").append(positionUncertainty)
                .append(",").append(modeSMBData)
                .append(",").append(indicatedAirspeed)
                .append(",").append(machNumber)
                .append(",").append(barometricPressureSetting)
                .toString();
    }

}
