package lib.ilkayaktas.instagram.util;

/**
 * Debug.
 * 
 * @author Lorensius W. L. T <lorenz@londatiga.net>
 *
 */
public class Log {
	public static void i(String tag, String message) {
		if (LibConstants.ENABLE_DEBUG) {
			android.util.Log.i(tag, message);
		}
	}
	
	public static void i(String message) {
		Log.i(LibConstants.TAG, message);
	}
	
	public static void e(String tag, String message) {
		if (LibConstants.ENABLE_DEBUG) {
			android.util.Log.e(tag, message);
		}
	}
	
	public static void e(String message) {
		if (LibConstants.ENABLE_DEBUG) {
			Log.e(LibConstants.TAG, message);
		}
	}
	
	public static void e(String tag, String message, Exception e) {
		if (LibConstants.ENABLE_DEBUG) {
			android.util.Log.e(tag, message);

			e.printStackTrace();
		}
	}
}