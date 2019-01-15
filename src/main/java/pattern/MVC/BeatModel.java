package pattern.MVC;

import java.util.ArrayList;

import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

//模型负责维护所有的数据、状态和应用逻辑。
public class BeatModel implements BeatModelInterface, MetaEventListener{
	Sequencer sequencer; //
	ArrayList beat_obsers = new ArrayList();
	ArrayList bpm_obsers = new ArrayList();
	int bpm = 90;
	Sequence sequence;
	Track track;
	public void meta(MetaMessage message) {
		if (message.getType() == 47) {
			beatEvent();
			sequencer.start();
			setBPM(getBPM());
		}
		
	}
	public void initialize() {
		setUpMidi();
		buildTrackAndStart();
	}
	
	public void setUpMidi() {
		try {
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.addMetaEventListener(this);
			
			sequence = new Sequence(Sequence.PPQ, 4);
			track = sequence.createTrack();
			sequencer.setTempoInBPM(getBPM());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void buildTrackAndStart() {
		int[] track_list = {35, 0, 46, 0};
		sequence.deleteTrack(null);;
		track = sequence.createTrack();
		
		makeTracks(track_list);
		track.add(makeEvent(192, 9, 1, 0, 4));
		try {
			sequencer.setSequence(sequence);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void makeTracks(int[] list) {
		for (int i = 0,len = list.length; i < len; i++) {
			int key = list[i];
			if (key != 0) {
				track.add(makeEvent(144, 9, key, 100, i));
				track.add(makeEvent(128, 9, key, 100, i+1));
			}
		}
	}
	
	public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
		MidiEvent event = null;
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return event;
	}
	public void on() {
		
		sequencer.start();
		setBPM(90);
	}
	public void off() {
		
		setBPM(0);
		sequencer.stop();
	}
	public void setBPM(int bpm) {
		
		this.bpm = bpm;
		sequencer.setTempoInBPM(getBPM()); //要求定序器改变BPM
		notifyBPMObservers(); //通知所有的BPM观察者，BPM已经改变。
	}
	public int getBPM() {
		
		return bpm;
	}
	
	void beatEvent() {
		notifyBeatObservers(); 
	}
	public void registerObserver(IBeatObserver o) {
		beat_obsers.add(o);
		
	}
	public void removeObserver(IBeatObserver o) {
		int i = beat_obsers.indexOf(o);
		if (i >= 0) {
			beat_obsers.remove(i);
		}
	}
	public void registerObserver(IBPMObserver o) {
		bpm_obsers.add(o);
	}
	public void removeObserver(IBPMObserver o) {
		int i = bpm_obsers.indexOf(o);
		if (i >= 0) {
			bpm_obsers.remove(i);
		}
		
	}
	
	public void notifyBeatObservers() {
		for (int i = 0,len = beat_obsers.size(); i < len; i++) {
			IBeatObserver obser = (IBeatObserver)beat_obsers.get(i);
			obser.updateBeat();
		}
	}
	
	public void notifyBPMObservers() {
		for (int i = 0,len = bpm_obsers.size(); i < len; i++) {
			IBPMObserver obser = (IBPMObserver)bpm_obsers.get(i);
			obser.updateBPM();
		}
	}
	
}
