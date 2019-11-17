package io.gojek.parkinglot.models;

import io.gojek.parkinglot.models.enums.Color;
import io.gojek.parkinglot.models.enums.SlotStatus;
import sun.applet.resources.MsgAppletViewer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Parking lot class
 * has : list of slots
 * has : map with key color and value as map : key-> registration number to value-> slot number
 */
public class ParkingLot {

    private List<Slot> slots;
    private Map<Color, Map<String, Integer>> colorSegmentMap;
    private Map<String, Integer> registrationSlotMap;

    public ParkingLot(int parkingLotSize) {
        Slot[] array = new Slot[parkingLotSize];
        Arrays.fill(array,0, parkingLotSize,new Slot());
        this.slots= Arrays.asList(array);
        this.registrationSlotMap = new HashMap<String, Integer>();
        this.colorSegmentMap = new HashMap<Color, Map<String, Integer>>();
    }

    public Map<Color, Map<String, Integer>> getColorSegmentMap() {
        return colorSegmentMap;
    }

    public void setColorSegmentMap(Map<Color, Map<String, Integer>> colorSegmentMap) {
        this.colorSegmentMap = colorSegmentMap;
    }

    public Map<String, Integer> getRegistrationSlotMap() {
        return registrationSlotMap;
    }

    public void setRegistrationSlotMap(Map<String, Integer> registrationSlotMap) {
        this.registrationSlotMap = registrationSlotMap;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "slots=" + slots +
                ", colorSegmentMap=" + colorSegmentMap +
                ", registrationSlotMap=" + registrationSlotMap +
                '}';
    }
}
