package space.alex.vkmaket;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import space.alex.vkmaket.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    boolean imageResource = false;
    boolean imageResource2 = false;
    boolean positionFrames = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //binding.textView.setBackgroundColor(Color.BLUE);

        binding.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imageResource == false){
                    binding.imageView.setImageResource(R.drawable.ic_baseline_videocam_24);
                    imageResource = true;
                } else {
                    binding.imageView.setImageResource(R.drawable.ic_baseline_videocam_off_24);
                    imageResource = false;
                }
            }
        });

        binding.imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imageResource2 == false){
                    binding.imageView2.setImageResource(R.drawable.ic_baseline_mic_24);
                    imageResource2 = true;
                } else {
                    binding.imageView2.setImageResource(R.drawable.ic_baseline_mic_off_24);
                    imageResource2 = false;
                }
            }
        });

        binding.imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogFunc();
            }
        });

        binding.imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

        binding.imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.setData(Uri.parse("sms:"));
                startActivity(sendIntent);
            }
        });

        binding.imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(MainActivity.this, ListOfContacts.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e){

                }

            }
        });

        binding.imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(positionFrames == false){
                    binding.linear1.setVisibility(View.GONE);
                    binding.linear2.setVisibility(View.GONE);
                    binding.linear3.setVisibility(View.VISIBLE);
                    binding.linear4.setVisibility(View.VISIBLE);
                    positionFrames = true;
                } else {
                    binding.linear3.setVisibility(View.GONE);
                    binding.linear4.setVisibility(View.GONE);
                    binding.linear1.setVisibility(View.VISIBLE);
                    binding.linear2.setVisibility(View.VISIBLE);
                    positionFrames = false;
                }
            }
        });



    }
    private void dialogFunc(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("привет");
        //builder.setMessage("Привет");
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}