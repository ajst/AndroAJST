package ajst.app.pak;

import java.util.List;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class GMapsActivity extends MapActivity {
	
	//Bundle coordonne = getIntent().getExtras();
	
	//int longitude = coordonne.getInt("longitude");
	//int altitude = coordonne.getInt("altitude");
	
	private MapView mapView;
	public Boolean day = false;
	private final int latitudeE6 = 36830902;
	private final int longitudeE6 = 10188317;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        
        mapView = (MapView) findViewById(R.id.map_view);       
        mapView.setBuiltInZoomControls(true);
        
        
        List<Overlay> mapOverlays = mapView.getOverlays();
        Drawable drawable = this.getResources().getDrawable(R.drawable.jour);
		CustomItemizedOverlay itemizedOverlay = new CustomItemizedOverlay(drawable, this,day);
		
		GeoPoint point = new GeoPoint(36830902, 10188317);
		OverlayItem overlayitem = new OverlayItem(point, "club central", "club central de Tunis");
		
		itemizedOverlay.addOverlay(overlayitem);
		
		GeoPoint point1 = new GeoPoint(36799990, 10187352);
		OverlayItem overlayitem1 = new OverlayItem(point1, "club de Tunis", "club de Tunis");
		
		itemizedOverlay.addOverlay(overlayitem1);
		
		GeoPoint point2 = new GeoPoint(34706517, 11204681);
		OverlayItem overlayitem2 = new OverlayItem(point2, "club  kerkennah", "club de karkennah");
		
		itemizedOverlay.addOverlay(overlayitem2);
		mapOverlays.add(itemizedOverlay);
		
		MapController mapController = mapView.getController();
		
		mapController.animateTo(new GeoPoint(latitudeE6, longitudeE6));
		mapController.setZoom(16);
        
    }

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
	
	
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_S) {
			mapView.setSatellite(!mapView.isSatellite());
			return (true);
		} else if (keyCode == KeyEvent.KEYCODE_Z) {
			mapView.displayZoomControls(true);
			return (true);
		}

		return (super.onKeyDown(keyCode, event));
	}
    
}