package effectivejava.CH2.javatuning.ch2.decorator;

public class PacketBodyCreator implements IPacketCreator{
	@Override
	public String handleContent() {
		return "Content of Packet";
	}
}
