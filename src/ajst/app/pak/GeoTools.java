package ajst.app.pak;

import com.google.android.maps.GeoPoint;

public class GeoTools {
	public static GeoPoint makeGeoPoint(double latitudeParam,
			double longitudeParam) {
		Double dLatitude = new Double(latitudeParam * 1E6);
		Double dLongitude = new Double(longitudeParam * 1E6);
		return new GeoPoint(dLatitude.intValue(), dLongitude.intValue());
	}
}