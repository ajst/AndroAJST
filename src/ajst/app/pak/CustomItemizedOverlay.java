package ajst.app.pak;

import java.util.ArrayList;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;

public class CustomItemizedOverlay extends ItemizedOverlay<OverlayItem> {
	
	private ArrayList<OverlayItem> mapOverlays = new ArrayList<OverlayItem>();
	private Drawable marker = null;
	private Context context;
	private Boolean day;
	Drawable marqueurJour;
	
	public CustomItemizedOverlay(Drawable defaultMarker) {
		  super(boundCenterBottom(defaultMarker));
	}
	
	public CustomItemizedOverlay(Drawable defaultMarker, Context context, Boolean day) {
		  this(defaultMarker);
		  this.context = context;
			this.marker = defaultMarker;
			this.day = day;
			marqueurJour = this.context.getResources().getDrawable(
					R.drawable.jour);
			marqueurJour.setBounds(0, 0, marqueurJour.getIntrinsicWidth(),
					marqueurJour.getIntrinsicHeight());
			
	}

	@Override
	protected OverlayItem createItem(int i) {
		return mapOverlays.get(i);
	}

	@Override
	public int size() {
		return mapOverlays.size();
	}
	
	@Override
	protected boolean onTap(int index) {
		OverlayItem item = mapOverlays.get(index);
		AlertDialog.Builder dialog = new AlertDialog.Builder(context);
		dialog.setTitle(item.getTitle());
		dialog.setMessage(item.getSnippet());
		dialog.show();
		return true;
	}
	
	public void addOverlay(OverlayItem overlay) {
		mapOverlays.add(overlay);
	    this.populate();
	}
	
	/*public void draw(Canvas canvas, MapView mapView, boolean shadow) {
		super.draw(canvas, mapView, shadow);
					
		}*/
	
	@Override
	public boolean onTouchEvent(MotionEvent event, MapView mapView) {
		return false;
	}

	}



