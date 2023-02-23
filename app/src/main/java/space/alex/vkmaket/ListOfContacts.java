package space.alex.vkmaket;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListOfContacts extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerAdapter adapter;

    String contactsNames[] = {"Billy", "Van", "Олег", "Виктор", "Мустафа", "Иосиф",
    "Анна", "Elon", "Владимир", "Walter", "Jessi", "Николай"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_contacts);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAdapter(this, contactsNames);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed(){
        try {
            Intent intent = new Intent(ListOfContacts.this, MainActivity.class);
            startActivity(intent);finish();
        } catch (Exception e){

        }
    }

}
