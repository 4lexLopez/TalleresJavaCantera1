package com.sofka.Taller2.Taller2Punto6;

public class Entry {
    private String plate;
    private String ownerName;
    private String ownerContactNumber;
    private String entryNote;
    private String leaveNote;
    private boolean inWorkshop;


    public Entry() {
        this.plate = "";
        this.ownerName = "";
        this.ownerContactNumber = "";
        this.entryNote = "Mantenimiento general";
        this.leaveNote = "";
        this.inWorkshop = true;

    }
    public Entry(String plate, String ownerName, String ownerContactNumber, String entryNote, String leaveNote) {
        this.plate = plate;
        this.ownerName = ownerName;
        this.ownerContactNumber = ownerContactNumber;
        this.entryNote = entryNote;
        this.leaveNote = leaveNote;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getEntryNote() {
        return entryNote;
    }

    public void setEntryNote(String entryNote) {
        this.entryNote = entryNote;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerContactNumber() {
        return ownerContactNumber;
    }

    public void setOwnerContactNumber(String ownerContactNumber) {
        this.ownerContactNumber = ownerContactNumber;
    }

    public boolean isInWorkshop() {
        return inWorkshop;
    }

    public void setInWorkshop(boolean inWorkshop) {
        this.inWorkshop = inWorkshop;
    }

    public String getLeaveNote() {
        return leaveNote;
    }

    public void setLeaveNote(String leaveNote) {
        this.leaveNote = leaveNote;
    }
}
