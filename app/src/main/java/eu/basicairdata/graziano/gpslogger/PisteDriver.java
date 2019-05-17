package eu.basicairdata.graziano.gpslogger;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import eu.basicairdata.graziano.gpslogger.Interface.ItemClickListener;
import eu.basicairdata.graziano.gpslogger.Model.Category;
import eu.basicairdata.graziano.gpslogger.ViewHolder.MenuViewHolder;
import com.squareup.picasso.Picasso;

public class PisteDriver extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FirebaseDatabase database;
    DatabaseReference category;
    TextView txtFullName;

    RecyclerView recycler_menu;
    RecyclerView.LayoutManager layoutManager;
    FirebaseRecyclerAdapter<Category, MenuViewHolder> adapter;
    private Boolean isLoggingOut = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piste_driver);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Menu");
        setSupportActionBar(toolbar);

        //Init Firebase
        database = FirebaseDatabase.getInstance();
        category = database.getReference("Circuit");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Choose the piste that you want to track", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Set Name for user
        View headerView = navigationView.getHeaderView(0);
        txtFullName = (TextView)findViewById(R.id.txtFullName);
        // txtFullName.setText(current_user_db);

        //Load Menu
        recycler_menu = (RecyclerView)findViewById(R.id.recycler_menu);
        recycler_menu.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recycler_menu.setLayoutManager(layoutManager);
        loadMenu();

    }

    private void loadMenu() {
        adapter = new FirebaseRecyclerAdapter<Category, MenuViewHolder>(Category.class,R.layout.menu_item,MenuViewHolder.class,category) {
            @Override
            protected void populateViewHolder(MenuViewHolder viewHolder, Category model, int position) {
                viewHolder.txtMenuName.setText(model.getName());
                Picasso.with(getBaseContext()).load(model.getImage()).into(viewHolder.imageView);
                final Category clickItem = model;
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        Toast.makeText(PisteDriver.this,"Vous allez voir "+clickItem.getName(),Toast.LENGTH_SHORT).show();
                        if(clickItem.getId() == 1) {

                            Intent foodList = new Intent(PisteDriver.this, DriverMapActivity.class);


                            //Get CategoryId and send to new Activity
                            // Intent foodList = new Intent(Piste.this,CustomerMapActivity.class);

                            //Because CategoryId is key, so we just get key of this item
                            foodList.putExtra("CategoryId", adapter.getRef(position).getKey());
                            startActivity(foodList);
                            startActivity(new Intent(PisteDriver.this, DriverMapActivity.class));
                            finish();
                        }else if(clickItem.getId() == 2){
                            Intent foodList = new Intent(PisteDriver.this, DriverMapActivity2.class);


                            //Get CategoryId and send to new Activity
                            // Intent foodList = new Intent(Piste.this,CustomerMapActivity.class);

                            //Because CategoryId is key, so we just get key of this item
                            foodList.putExtra("CategoryId", adapter.getRef(position).getKey());
                            startActivity(foodList);
                            startActivity(new Intent(PisteDriver.this, DriverMapActivity2.class));
                            finish();

                        }else if(clickItem.getId() == 3){
                            Intent foodList = new Intent(PisteDriver.this, DriverMapActivity3.class);


                            //Get CategoryId and send to new Activity
                            // Intent foodList = new Intent(Piste.this,CustomerMapActivity.class);

                            //Because CategoryId is key, so we just get key of this item
                            foodList.putExtra("CategoryId", adapter.getRef(position).getKey());
                            startActivity(foodList);
                            startActivity(new Intent(PisteDriver.this, DriverMapActivity3.class));
                            finish();

                        }else if(clickItem.getId() == 4){
                            Intent foodList = new Intent(PisteDriver.this, DriverMapActivity4.class);


                            //Get CategoryId and send to new Activity
                            // Intent foodList = new Intent(Piste.this,CustomerMapActivity.class);

                            //Because CategoryId is key, so we just get key of this item
                            foodList.putExtra("CategoryId", adapter.getRef(position).getKey());
                            startActivity(foodList);
                            startActivity(new Intent(PisteDriver.this, DriverMapActivity4.class));
                            finish();

                        }else if(clickItem.getId() == 5){
                            Intent foodList = new Intent(PisteDriver.this, DriverMapActivity5.class);


                            //Get CategoryId and send to new Activity
                            // Intent foodList = new Intent(Piste.this,CustomerMapActivity.class);

                            //Because CategoryId is key, so we just get key of this item
                            foodList.putExtra("CategoryId", adapter.getRef(position).getKey());
                            startActivity(foodList);
                            startActivity(new Intent(PisteDriver.this, DriverMapActivity5.class));
                            finish();

                        }else if(clickItem.getId() == 6){
                            Intent foodList = new Intent(PisteDriver.this, DriverMapActivity6.class);


                            //Get CategoryId and send to new Activity
                            // Intent foodList = new Intent(Piste.this,CustomerMapActivity.class);

                            //Because CategoryId is key, so we just get key of this item
                            foodList.putExtra("CategoryId", adapter.getRef(position).getKey());
                            startActivity(foodList);
                            startActivity(new Intent(PisteDriver.this, DriverMapActivity6.class));
                            finish();

                        }else if(clickItem.getId() == 7){
                            Intent foodList = new Intent(PisteDriver.this, DriverMapActivity7.class);


                            //Get CategoryId and send to new Activity
                            // Intent foodList = new Intent(Piste.this,CustomerMapActivity.class);

                            //Because CategoryId is key, so we just get key of this item
                            foodList.putExtra("CategoryId", adapter.getRef(position).getKey());
                            startActivity(foodList);
                            startActivity(new Intent(PisteDriver.this, DriverMapActivity7.class));
                            finish();

                        }

                    }
                });
            }
        };

        recycler_menu.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.piste, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_menu) {
            // Handle the camera action
        } else if (id == R.id.nav_history) {
            Intent a = new Intent(PisteDriver.this,GPSActivity.class);
            startActivity(a);

        } else if (id == R.id.nav_seetings) {
            Intent a = new Intent(PisteDriver.this,DriverSettingsActivity.class);
            startActivity(a);

        } else if (id == R.id.nav_log_out) {
            isLoggingOut = true;
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(PisteDriver.this, MainActivity.class);
            startActivity(intent);
            finish();


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
