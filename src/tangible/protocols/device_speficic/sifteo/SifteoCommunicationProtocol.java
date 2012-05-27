/*
 * Master-Thesis work: see https://sites.google.com/site/sifthesis/
 */
package tangible.protocols.device_speficic.sifteo;

import java.awt.image.BufferedImage;
import restful.streaming.AbstractStreamingThread;
import tangible.devices.SifteoCubeDevice;
import tangible.protocols.TangibleDeviceCommunicationProtocol;

/**
 *
 * @author leo
 */
public class SifteoCommunicationProtocol
        implements TangibleDeviceCommunicationProtocol<SifteoCubeDevice> {


  private SiftDriverCommunicationProtocol _driverTalk;
  private final String _cubeId;
  private final String[] _id_in_array;

  public SifteoCommunicationProtocol(SiftDriverCommunicationProtocol talk, String cubeId) {
    this._driverTalk = talk;
    _cubeId = cubeId;
    _id_in_array = new String[1];
    _id_in_array[0] = _cubeId;
  }

  @Override
  public boolean isConnected() {
    return _driverTalk.isConnected();
  }

  @Override
  public void showColor(int r, int g, int b) {
//    System.out.println("SifteoCommunicationProtocol: Show color -> _cubeId = " + _cubeId);
    _driverTalk.showColor(r, g, b, _id_in_array);
  }

  @Override
  public void showColor(int color) {

//    System.out.println("SifteoCommunicationProtocol: Show color -> _cubeId = " + _cubeId);
    _driverTalk.showColor(color, _id_in_array);
  }

  @Override
  public void addAllEventsNotification(AbstractStreamingThread sTh) {
    _driverTalk.addAllEventsNotification(sTh, _id_in_array);
  }

  @Override
  public void showPicture(BufferedImage img) {
    _driverTalk.showPicture(img, _id_in_array);
  }

	@Override
	public void showText(String msg) {
		_driverTalk.showText(msg, _id_in_array);
	}

	@Override
	public void showText(String msg, int color) {
		_driverTalk.showText(msg, color, _id_in_array);
	}

	@Override
	public void fadeColor(int color) {
		_driverTalk.fadeColor(color, _id_in_array);
	}
}
