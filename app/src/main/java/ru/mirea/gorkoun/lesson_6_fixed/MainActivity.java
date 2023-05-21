package ru.mirea.gorkoun.lesson_6_fixed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import ru.mirea.gorkoun.lesson_6_fixed.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    public ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SharedPreferences sharedPref = getSharedPreferences("mirea_settings", Context.MODE_PRIVATE);

        String group = sharedPref.getString("GROUP ", "Введите номер группы");
        String listnumber = sharedPref.getString("LISTNUMBER", "введите ваш номер в списке");
        String film = sharedPref.getString("FILM", "введите название вашего любимого фильма");
        binding.groupNum.setText(group);
        binding.listNum.setText(listnumber);
        binding.favouriteFilm.setText(film);

        binding.saveButton.setOnClickListener(new	View.OnClickListener()	{
            @Override
            public	void	onClick(View	v)	{
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("GROUP", binding.groupNum.getText().toString());
                editor.putString("LISTNUMBER", binding.listNum.getText().toString());
                editor.putString("FILM", binding.favouriteFilm.getText().toString());
                editor.apply();
            }
        });
    }
}