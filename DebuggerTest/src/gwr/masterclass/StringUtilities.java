package gwr.masterclass;

/**
 * Created by timbuchalka on 15/11/16.
 */
public class StringUtilities {
	private StringBuilder sBuilder = new StringBuilder();
	private int charsAdded = 0;

	public void addChar(StringBuilder sBuilder, char c) {
		this.sBuilder.append(c);
		charsAdded++;
	}
}