package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ImageView imageView = findViewById(R.id.profileImageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
                builder.setTitle("Profile");
                builder.setMessage("MADness");
                builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Present MainActivity, pass over random number
                        Intent mainActivity = new Intent(ListActivity.this, MainActivity.class);

                        int randomNumber = (int) Math.round(Math.random() * 1000000);

                        mainActivity.putExtra("RandomNumber", randomNumber);

                        startActivity(mainActivity);
                    }
                });

                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }
}