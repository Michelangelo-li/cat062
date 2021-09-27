package cat062.simpleitem;

import cat062.I062_390.FPPSIdentificationTag;
import com.alibaba.fastjson.annotation.JSONField;
import cat062.I062_390.*;
import lombok.Data;


/**
 * Flight Plan Related Data
 *
 *All flight plan related information, provided by ground-based
 * systems.
 *
 * 飞行计划相关数据
 */
@Data
public class I062_390_FlightPlanRelatedData {

    @JSONField(serialize = false)
    private boolean[] existedItems = new boolean[24];

    private cat062.I062_390.FPPSIdentificationTag fPPSIdentificationTag = null;

    private cat062.I062_390.Callsign callsign = null;

    private cat062.I062_390.IFPS_FLIGHT_ID iFPS_FLIGHT_ID = null;

    private cat062.I062_390.FlightCategory flightCategory = null;

    private cat062.I062_390.TypeOfAircraft typeOfAircraft = null;

    private cat062.I062_390.WakeTurbulenceCategory wakeTurbulenceCategory = null;

    private cat062.I062_390.DepartureAirport departureAirport = null;

    private cat062.I062_390.DestinationAirport destinationAirport = null;


    private cat062.I062_390.RunwayDesignation runwayDesignation = null;

    private cat062.I062_390.CurrentClearedFlightLevel currentClearedFlightLevel = null;

    private cat062.I062_390.CurrentControlPosition currentControlPosition = null;

    private cat062.I062_390.TimeOfDepartureArrival timeOfDepartureArrival = null;

    private cat062.I062_390.AircraftStand aircraftStand = null;

    private cat062.I062_390.StandStatus standStatus = null;

    private cat062.I062_390.StandardInstrumentDeparture standardInstrumentDeparture = null;

    private cat062.I062_390.StandardInstrumentArrival standardInstrumentArrival = null;

    private cat062.I062_390.PreEmergencyMode3A preEmergencyMode3A = null;

    private cat062.I062_390.PreEmergencyCallsign preEmergencyCallsign = null;


    public static int length;

    public I062_390_FlightPlanRelatedData(int[] data, int index) {

        int currentIndex = index;

        int oByte = 0;

        int itemIndex = 24;

        do {
            oByte = data[currentIndex];

            for (int i = 7; i >= 1; i--) {
                itemIndex -= 1;
                existedItems[itemIndex] = ((oByte >> i) & 0x01) == 0x01;
            }
            itemIndex -= 1;
            currentIndex += 1;

        } while ((oByte & 0x01) == 0x01);


        if (existedItems[23]) {
            fPPSIdentificationTag = new FPPSIdentificationTag(data, currentIndex);
            currentIndex += FPPSIdentificationTag.length;
        }

        if (existedItems[22]) {
            callsign = new Callsign(data, currentIndex);
            currentIndex += Callsign.length;
        }

        if (existedItems[21]) {
            iFPS_FLIGHT_ID = new IFPS_FLIGHT_ID(data, currentIndex);
            currentIndex += IFPS_FLIGHT_ID.length;
        }

        if (existedItems[20]) {
            flightCategory = new FlightCategory(data, currentIndex);
            currentIndex += FlightCategory.length;
        }

        if (existedItems[19]) {
            typeOfAircraft = new TypeOfAircraft(data, currentIndex);
            currentIndex += TypeOfAircraft.length;
        }

        if (existedItems[18]) {
            wakeTurbulenceCategory = new WakeTurbulenceCategory(data, currentIndex);
            currentIndex += WakeTurbulenceCategory.length;
        }

        if (existedItems[17]) {
            departureAirport = new DepartureAirport(data, currentIndex);
            currentIndex += DepartureAirport.length;
        }

        if (existedItems[15]) {
            destinationAirport = new DestinationAirport(data, currentIndex);
            currentIndex += DestinationAirport.length;
        }

        if (existedItems[14]) {
            runwayDesignation = new RunwayDesignation(data, currentIndex);
            currentIndex += RunwayDesignation.length;
        }

        if (existedItems[13]) {
            currentClearedFlightLevel = new CurrentClearedFlightLevel(data, currentIndex);
            currentIndex += CurrentClearedFlightLevel.length;
        }

        if (existedItems[12]) {
            currentControlPosition = new CurrentControlPosition(data, currentIndex);
            currentIndex += CurrentControlPosition.length;
        }

        if (existedItems[11]) {
            timeOfDepartureArrival = new TimeOfDepartureArrival(data, currentIndex);
            currentIndex += TimeOfDepartureArrival.length;
        }

        if (existedItems[10]) {
            aircraftStand = new AircraftStand(data, currentIndex);
            currentIndex += AircraftStand.length;
        }

        if (existedItems[9]) {
            standStatus = new StandStatus(data, currentIndex);
            currentIndex += StandStatus.length;
        }

        if (existedItems[7]) {
            standardInstrumentDeparture = new StandardInstrumentDeparture(data, currentIndex);
            currentIndex += StandardInstrumentDeparture.length;
        }

        if (existedItems[6]) {
            standardInstrumentArrival = new StandardInstrumentArrival(data, currentIndex);
            currentIndex += StandardInstrumentArrival.length;
        }

        if (existedItems[5]) {
            preEmergencyMode3A = new PreEmergencyMode3A(data, currentIndex);
            currentIndex += PreEmergencyMode3A.length;
        }

        if (existedItems[4]) {
            preEmergencyCallsign = new PreEmergencyCallsign(data, currentIndex);
            currentIndex += PreEmergencyCallsign.length;
        }


        length = currentIndex - index;

    }


    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder(1024);

        return stringBuilder.append(fPPSIdentificationTag)
                .append(",").append(callsign)
                .append(",").append(iFPS_FLIGHT_ID)
                .append(",").append(flightCategory)
                .append(",").append(typeOfAircraft)
                .append(",").append(wakeTurbulenceCategory)
                .append(",").append(departureAirport)
                .append(",").append(destinationAirport)
                .append(",").append(runwayDesignation)
                .append(",").append(currentClearedFlightLevel)
                .append(",").append(currentControlPosition)
                .append(",").append(timeOfDepartureArrival)
                .append(",").append(aircraftStand)
                .append(",").append(standStatus)
                .append(",").append(standardInstrumentDeparture)
                .append(",").append(standardInstrumentArrival)
                .append(",").append(preEmergencyMode3A)
                .append(",").append(preEmergencyCallsign)
                .toString();
    }


}
