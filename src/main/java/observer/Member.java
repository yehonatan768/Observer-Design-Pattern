package observer;
import observer.UndoableStringBuilder;


public interface Member {
	public void update(observer.UndoableStringBuilder usb);
}
