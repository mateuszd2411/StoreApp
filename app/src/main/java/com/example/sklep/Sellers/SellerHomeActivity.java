package com.example.sklep.Sellers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.sklep.HomeActivity;
import com.example.sklep.MainActivity;
import com.example.sklep.R;
import com.example.sklep.SellerProductCategoryActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class SellerHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_home);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.nav_home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId())
                {

                    case  R.id.navigation_home:


                        return true;

                    case R.id.navigation_add:

                        Intent intentCat = new Intent(SellerHomeActivity.this, SellerProductCategoryActivity.class);
                        startActivity(intentCat);
                        return true;

                    case R.id.navigation_logout:
                        final FirebaseAuth mAuth;
                        mAuth = FirebaseAuth.getInstance();
                        mAuth.signOut();

                        Intent intentMain = new Intent(SellerHomeActivity.this, MainActivity.class);
                        intentMain.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intentMain);
                        finish();
                        return true;



                }



                return false;
            }
        });

    }
}
