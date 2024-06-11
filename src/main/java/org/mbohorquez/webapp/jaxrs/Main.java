package org.mbohorquez.webapp.jaxrs;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.mbohorquez.webapp.jaxrs.models.Curso;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Client client = ClientBuilder.newClient();
        WebTarget rootUri = client
                .target("http://localhost:8080/_73_1_webapp-jaxrs/api")
                .path("/cursos");

        System.out.println("============ por Id");
        /*Curso curso = rootUri
                .path("/8")
                .request(MediaType.APPLICATION_JSON)
                .get(Curso.class);*/
        Response response = rootUri.path("/8").request(MediaType.APPLICATION_JSON).get();
        Curso curso = response.readEntity(Curso.class);

        System.out.println(response.getStatus());
        System.out.println(response.getMediaType());
        System.out.println(curso);

        System.out.println("============ listando");
        listar(rootUri);

        System.out.println("============ creando");
        Curso cursoNuevo = new Curso();
        cursoNuevo.setNombre("Spring Cloud");
        cursoNuevo.setDescripcion("Spring Cloud Eureka");
        cursoNuevo.setDuracion(120D);
        cursoNuevo.setInstructor("Andres Guzman");

        Entity<Curso> entityHeader = Entity.entity(cursoNuevo, MediaType.APPLICATION_JSON);
        /*curso = rootUri
                .request(MediaType.APPLICATION_JSON)
                .post(entityHeader, Curso.class);
//                .post(entityHeader)
//                .readEntity(Curso.class);*/
        response = rootUri.request(MediaType.APPLICATION_JSON).post(entityHeader);
        curso = response.readEntity(Curso.class);

        System.out.println(curso);
        listar(rootUri);

        System.out.println("============ editando");
        Curso cursoEditado = curso;
        cursoEditado.setNombre("Microservicios con Spring Cloud Eureka");

        entityHeader = Entity.entity(cursoEditado, MediaType.APPLICATION_JSON);
        /*curso = rootUri
                .path("/" + curso.getId())
                .request(MediaType.APPLICATION_JSON)
                .put(entityHeader, Curso.class);
//                .put(entityHeader)
//                .readEntity(Curso.class);*/
        response = rootUri.path("/" + curso.getId()).request(MediaType.APPLICATION_JSON).put(entityHeader);
        curso = response.readEntity(Curso.class);

        System.out.println(curso);
        listar(rootUri);

        System.out.println("============ eliminando");
        rootUri.path("/" + curso.getId()).request().delete();
        listar(rootUri);
    }

    private static void listar(WebTarget rootUri) {
        System.out.println("============ lista actualizada");
        Response response;
    /*List<Curso> cursos = rootUri
            .request(MediaType.APPLICATION_JSON)
            .get(new GenericType<List<Curso>>() {});
//                .get(Response.class) //.get()
//                .readEntity(new GenericType<List<Curso>>(){});*/
        response = rootUri.request(MediaType.APPLICATION_JSON).get();
        List<Curso> cursos = response.readEntity(new GenericType<List<Curso>>() {
        });

        cursos.forEach(System.out::println);
    }
}
