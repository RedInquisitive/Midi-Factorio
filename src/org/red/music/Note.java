package org.red.music;

public class Note {
	public final String name, trackName;
	public final int key, octave, velocity;
	private long currentMidiTick, deltaMidiTick;
	private double seconds;
	private int gameTickOffset = 0;
	
	public Note(String name, String trackName, int key, int octave, int velocity) {
		this.name = name;
		this.key = key;
		this.octave = octave;
		this.velocity = velocity;
		this.trackName = trackName;
	}
	
	public void setTime(double seconds, long currentTick, long deltaTick) {
		this.seconds = seconds;
		this.currentMidiTick = currentTick;
		this.deltaMidiTick = deltaTick;
	}
	
	public String toString() {
        return String.format("%s%d key %d vol %d at second:  %.2f (%d, +%d)", name, octave, key, velocity, seconds, currentMidiTick, deltaMidiTick);
	}
	
	public void increaseGameTickOffset() {
		this.gameTickOffset++;
	}
	
	public int getGameTick() {
		return (int)(seconds * 60.0) + gameTickOffset;
	}
}
