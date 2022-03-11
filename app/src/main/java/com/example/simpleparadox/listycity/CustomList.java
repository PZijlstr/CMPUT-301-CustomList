package com.example.simpleparadox.listycity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities){
        super(context,0, cities);
        this.cities = cities;
        this.context = context;
    }

    /**
     * this function gets the size of a list
     * @return
     */
    public int getCount() {
        return cities.size();
    }

    /**
     * this function will add a city object into the list
     * @param city
     */
    public void addCity(City city) {
        cities.add(city);
        return;
    }

    /**
     * This method returns true if the list of city objects
     * contains the provided city, and false if it doesn't
     * contain the provided city
     * @param city
     * Expects an object of the City class
     * @return true if city is in the list of cities, false if city is not in the list of cities
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * This method deletes a city from the list of city objects.
     * If this city doesn't exist, it throws an exception
     * @param city
     * Expects an object of the City class
     * @throws IllegalArgumentException
     * The City provided must exist in the list to be deleted
     */
    public void delete(City city) {
        if(!cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     * This method returns the number of cities found within
     * the city list
     * @return number of cities in the city list
     */
    public int countCities() {
        return cities.size();
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }
}
