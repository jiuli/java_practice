package pattern.MVC;

public class BeatController implements ControllerInterface {
	BeatModelInterface model;
	DJView view;
	
	
	public BeatController(BeatModelInterface model) {
		super();
		this.model = model;
		view = new DJView(this, model);
		view.createView();
		view.createControls();
		view.disableStopMenuItem();
		view.disableStartMenuItem();
		model.initialize();
		
	}
	public void start() {
		// TODO Auto-generated method stub
		model.on();
		view.disableStartMenuItem();
		view.disableStopMenuItem();
	}
	public void stop() {
		// TODO Auto-generated method stub
		model.off();
		view.disableStartMenuItem();
		view.disableStopMenuItem();
	}
	public void increaseBPM() {
		// TODO Auto-generated method stub
		int bpm = model.getBPM();
		model.setBPM(bpm + 1);
	}
	public void decreaseBPM() {
		// TODO Auto-generated method stub
		int bpm = model.getBPM();
		model.setBPM(bpm - 1);
	}
	public void setBPM(int bpm) {
		// TODO Auto-generated method stub
		model.setBPM(bpm);
	}
}
