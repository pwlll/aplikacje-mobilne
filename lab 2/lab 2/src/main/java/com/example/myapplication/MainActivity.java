package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import static java.lang.Math.min;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.myapplication.databinding.ActivityMainBinding;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics. Paint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Panel canvasPanel;
    Paint tile_bg=new Paint();
    Paint tile_bg2=new Paint();
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int selected=item.getItemId();
        /*switch (item.getItemId()){
            case R.id.author:
                Context context = getApplicationContext();
                CharSequence text = "Twórca: Paweł J";
                Toast toast= Toast.makeText(context, text, Toast.LENGTH_SHORT);
                toast.setGravity (Gravity.BOTTOM, 0, 0);
                toast.show();
                return true;
            case 2: finish();
                return true;
            case 3:
                tile_bg.setColor(Color.BLACK);
                tile_bg2.setColor(Color.WHITE);
                //canvasPanel.postInvalidate();
                return true;
            case 4:
                tile_bg.setColor(Color.RED);
                tile_bg2.setColor(Color. YELLOW);
                //canvasPanel.postInvalidate();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }*/
        if(selected==R.id.author){
            Context context = getApplicationContext();
            CharSequence text = "Twórca: Paweł J";
            Toast toast= Toast.makeText(context, text, Toast.LENGTH_SHORT);
            toast.setGravity (Gravity.BOTTOM, 0, 0);
            toast.show();
            return true;
        }
        if(selected==R.id.exit){
            finish();
            return true;
        }
        if(selected==R.id.color1){
            tile_bg.setColor(Color.BLACK);
            tile_bg2.setColor(Color.WHITE);
            setContentView(canvasPanel=new Panel(this,tile_bg,tile_bg2));
            //canvasPanel.postInvalidate();
            return true;
        }
        if(selected==R.id.color2){
            tile_bg.setColor(Color.RED);
            tile_bg2.setColor(Color.YELLOW);
            setContentView(canvasPanel=new Panel(this,tile_bg,tile_bg2));
            //canvasPanel.postInvalidate();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }
    class Panel extends View {
        Paint title_bg,title_bg2;
        public Panel (Context context,Paint bg,Paint bg2) {
            super (context);
            title_bg=bg;
            tile_bg2=bg2;
        }
        @Override
        public void onDraw (Canvas canvas) {
            canvas.drawColor(Color.GRAY);
            float width=canvasPanel.getWidth();
            float height=canvasPanel.getHeight();
            for (int i=0;i<8;i++) {
                for (int j=0;j<8;j++) {
                    if ((i + j) % 2 == 0) {
                        canvas.drawRect(i * Math.min(width,height) / 8, j * Math.min(width,height) / 8, (i + 1) * Math.min(width,height) / 8, (j + 1) * Math.min(width,height) / 8, tile_bg);
                    } else {
                        canvas.drawRect(i * Math.min(width,height) / 8, j * Math.min(width,height) / 8, (i + 1) * Math.min(width,height) / 8, (j + 1) * Math.min(width,height) / 8, tile_bg2);
                    }
                }
            }
        }
    }
}
