package info.hernanramirez.mismapas;

import android.content.DialogInterface;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import info.hernanramirez.mismapas.adapters.SitioDataAdapter;
import info.hernanramirez.mismapas.models.SitioMerida;

public class MainActivity extends AppCompatActivity implements MainFragment.OnFragmentInteractionListener, MapaFragment.OnFragmentInteractionListener {

    Toolbar androidToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidToolbar = (Toolbar) findViewById(R.id.toolbar_android);
        setSupportActionBar(androidToolbar);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_frame, new MainFragment())
                    .addToBackStack(null)
                    .commit();
        }

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_acerca:

                /*
                View messageView = getLayoutInflater().inflate(R.layout.dialogo_acerca, null, false);

                AlertDialog.Builder dialogo_acerca = new AlertDialog.Builder(MainActivity.this);
                dialogo_acerca.setIcon(R.drawable.dog_paw);
                dialogo_acerca.setTitle(R.string.app_name);
                dialogo_acerca.setView(messageView);
                dialogo_acerca.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
                dialogo_acerca.create();

                dialogo_acerca.show();
                */
                break;

            case R.id.action_chorros:
                MapaFragment configFragmentView = new MapaFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_frame,configFragmentView)
                        .addToBackStack(null)
                        .commit();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

}
