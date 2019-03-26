package com.projeto.demo.service;

import com.projeto.demo.model.Planeta;
import com.projeto.demo.repository.PlanetaRepository;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.http.client.HttpClient;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlanetaService {
    @Autowired
    PlanetaRepository pr;

    public void adicionarPlaneta(Planeta planeta){
       pr.saveAndFlush(planeta);
    }
    public void removerPlaneta(Planeta planeta){
        pr.delete(planeta);
    }
    public List<Planeta> listarPlanetaBd(){
        return pr.findAll();
    }
    public String chamadaAPiHttp() throws IOException {
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet request = new HttpGet("https://swapi.co/api/planets/");
        HttpResponse response = httpclient.execute(request);
        HttpEntity entity = response.getEntity();
        String planetasApi = EntityUtils.toString(entity);
        return planetasApi;
    }
    public List<Planeta> listarPlanetaApi() throws IOException {
        List<Planeta> planetas = new ArrayList<>();
        JSONObject object = new JSONObject(chamadaAPiHttp());

        JSONArray ArrayPlaneta = object.getJSONArray("results");
        for(int i = 0; i < ArrayPlaneta.length(); i++) {
            Planeta planeta = new Planeta();
            planeta.setNome(ArrayPlaneta.getJSONObject(i).getString("name"));
            planeta.setClima(ArrayPlaneta.getJSONObject(i).getString("climate"));
            planeta.setTerreno(ArrayPlaneta.getJSONObject(i).getString("terrain"));
            planetas.add(i,planeta);
        }
        return planetas;
    }
    public Planeta buscarPlanetaId(Long id){
        if(pr.buscarPlanetaId(id) == null)
            return pr.buscarPlanetaId(id);
        else
            return null;
    }
    public Planeta buscarPlanetaNome(String nome){
        if(pr.buscarPlanetaNome(nome) == null)
            return pr.buscarPlanetaNome(nome);
        else
            return null;
    }

}
