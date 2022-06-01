package app;

import app.Usuarios.Administrador;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class jsonUtiles {

    public JSONObject crearJsonObject(Administrador admin)
    {
        JSONObject ob= new JSONObject();
        try {
            ob.put("nombre",admin.getNombre());
            ob.put("apellido",admin.getApellido());
            ob.put("password",admin.getPassword());
            ob.put("estado",admin.isEstado());
            ob.put("log",admin.getLog());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ob;
    }

    public JSONArray crearArregloJason(Administrador admin)
    {
        JSONArray ar= new JSONArray();
        ar.put(crearArregloJason(admin));
        return ar;
    }



}
