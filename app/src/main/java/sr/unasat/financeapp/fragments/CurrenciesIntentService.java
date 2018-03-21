package sr.unasat.financeapp.fragments;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import sr.unasat.financeapp.entities.Currency;


public class CurrenciesIntentService extends IntentService {

    public static ArrayList<Currency> currencies;

    public CurrenciesIntentService(){
        super("CurrenciesIntentService");
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        getCurrencyData();
    }

    private void getCurrencyData() {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        final String ALL_CURRENCIES = "http://service.e-gostudio.com/api/currencies.json";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, ALL_CURRENCIES,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        currencies = mapJsonToCountryObject(response);
                        System.out.println(currencies);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(CurrenciesIntentService.this, "Something went wrong in getting currencies", Toast.LENGTH_SHORT).show();
            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }


    private ArrayList<Currency> mapJsonToCountryObject(String jsonArray) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Currency> currencyList = new ArrayList<>();
        ArrayList<Map<String, ?>> currencyArray = null;
        Currency currency = null;

        try {
            currencyArray = mapper.readValue(jsonArray, ArrayList.class);
            for (Map<String, ?> map : currencyArray) {
                currency = new Currency((String) map.get("symbol"));
                currencyList.add(currency);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Er is wat fout gegaan bij het parsen van de json data");
        }
        return currencyList;
    }

}
