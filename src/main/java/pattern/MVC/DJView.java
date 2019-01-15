package pattern.MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class DJView implements ActionListener, IBeatObserver, IBPMObserver {
	BeatModelInterface model;
	ControllerInterface controller;
	JFrame view_frame;
	JPanel view_panel;
	BeatBar beat_bar;
	JLabel bpm_label;
	JTextField bpm_text_field;
	JButton set_bpm_button;
	JButton increase_bpm_button;
	JButton decrease_bpm_button;
	JMenu menu;
	JMenuItem start_menu_item;
	JMenuItem stop_menu_item;
	
	public void createControls() {
		
	}
	
	public void enableStopMenuItem() {
		stop_menu_item.setEnabled(true);
	}
	
	public void disableStopMenuItem() {
		stop_menu_item.setEnabled(false);
	}
	
	public void enableStartMenuItem() {
		start_menu_item.setEnabled(false);
	}
	public void disableStartMenuItem() {
		start_menu_item.setEnabled(false);
	}
	
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == set_bpm_button) {
			int bpm = Integer.parseInt(bpm_text_field.getText());
			controller.setBPM(bpm);
		} else if (event.getSource() == increase_bpm_button) {
			controller.increaseBPM();
		} else if (event.getSource() == decrease_bpm_button) {
			controller.decreaseBPM();
		}
	}
	public DJView(ControllerInterface controller, BeatModelInterface model) {
		super();
		this.model = model;
		this.controller = controller;
		model.registerObserver((IBeatObserver)this);
		model.registerObserver((IBPMObserver)this);
	}
	
	public void createView() {
		//
	}
	
	public void updateBPM() {
		int bpm = model.getBPM();
		if	(bpm == 0) {
			bpm_label.setText("offline");
		} else {
			bpm_label.setText("Current BPM:" + model.getBPM());
		}
	}
	
	public void updateBeat() {
		beat_bar.setValue(100);
	}
	
	
	
}
