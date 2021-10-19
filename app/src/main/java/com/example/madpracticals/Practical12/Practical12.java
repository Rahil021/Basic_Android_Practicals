package com.example.madpracticals.Practical12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.airbnb.lottie.L;
import com.example.madpracticals.Practical12.DirectionHelpers.FetchURL;
import com.example.madpracticals.Practical12.DirectionHelpers.TaskLoadedCallback;
import com.example.madpracticals.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.mahfa.dnswitch.DayNightSwitch;
import com.mahfa.dnswitch.DayNightSwitchListener;

public class Practical12 extends FragmentActivity implements OnMapReadyCallback, TaskLoadedCallback {

    private GoogleMap mMap;
    private Polyline currentPolyline;
    MarkerOptions sydney_marker_option,eva_marker_option,zoo_marker_option;
    DayNightSwitch day_night_switch;
    Boolean night = false;
    ImageView invisible_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practical12);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        day_night_switch = findViewById(R.id.day_night_switch);
        invisible_button = findViewById(R.id.invisible_button);

        day_night_switch.setListener(new DayNightSwitchListener() {
            @Override
            public void onSwitch(boolean is_night) {

                boolean success=true;

                if(!is_night){

                    success = mMap.setMapStyle(
                                MapStyleOptions.loadRawResourceStyle(Practical12.this, R.raw.map));
                    invisible_button.setImageDrawable(getResources().getDrawable(R.drawable.navigation));


                } else if(is_night) {

                    success = mMap.setMapStyle(
                                MapStyleOptions.loadRawResourceStyle(Practical12.this, R.raw.map_day));

                    invisible_button.setImageDrawable(getResources().getDrawable(R.drawable.navigation_light));

                }

                try {
                    // Customise the styling of the base map using a JSON object defined
                    // in a raw resource file.

                    if (!success) {
                        Log.e("MapsActivity", "Style parsing failed.");
                    }
                } catch (Resources.NotFoundException e) {
                    Log.e("MapsActivity", "Can't find style. Error: ", e);
                }
            }

        });

        invisible_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FetchURL(Practical12.this).execute(getUrl(eva_marker_option.getPosition(), zoo_marker_option.getPosition(), "driving"),"driving");
                invisible_button.setEnabled(false);

            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        LatLng zoo = new LatLng(22.3115, 73.1914);
        LatLng eva = new LatLng(22.2734, 73.1888 );

        sydney_marker_option = new MarkerOptions().position(sydney).title("Marker in Sydney");
        zoo_marker_option = new MarkerOptions().position(zoo).title("Marker at M.S University");
        eva_marker_option = new MarkerOptions().position(eva).title("Marker at Eva Mall");

        mMap.addMarker(eva_marker_option);
        mMap.addMarker(zoo_marker_option);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(eva));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(eva, 13));

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

    }

    private String getUrl(LatLng origin, LatLng dest, String directionMode) {
        // Origin of route
        String str_origin = "origin=" + origin.latitude + "," + origin.longitude;
        // Destination of route
        String str_dest = "destination=" + dest.latitude + "," + dest.longitude;
        // Mode
        String mode = "mode=" + directionMode;
        // Building the parameters to the web service
        String parameters = str_origin + "&" + str_dest + "&" + mode;
        // Output format
        String output = "json";
        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters + "&key=" + getString(R.string.google_maps_key);

        Log.v("URL",""+url);

        return url;
    }

    @Override
    public void onTaskDone(Object... values) {
        if (currentPolyline != null) {
            currentPolyline.remove();
        }
        currentPolyline = mMap.addPolyline((PolylineOptions) values[0]);
    }

    public void default_status_bar(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.glight, Practical12.this.getTheme()));
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.glight));
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        }
    }
}