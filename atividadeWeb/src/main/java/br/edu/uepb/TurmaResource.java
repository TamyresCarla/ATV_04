
package br.edu.uepb;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;



@Path("Turmas") // rota do resource
public class TurmaResource {

    private final TurmaRepository TurmaRepository = new TurmaRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPessoas() { // response status code 200
        return Response.ok(TurmaRepository.getAll()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPessoa(final Turma p) {
        TurmaRepository.create(p);
        return Response.status(Response.Status.CREATED).entity(Turma).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPessoaById(@PathParam("id") final int id) {
        return Response.ok(TurmaRepository.getById(id)).build();
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editPessoa(@PathParam("id") final int id, final Turma pessoa) {
        final Turma p = TurmaRepository.getById(id);
        if (p == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        try {
            Turma.setId(id);
            TurmaRepository.edit(Turma);
            return Response.ok(Turma).build();
        } catch (final Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletePessoa(@PathParam("id") final int id, final Turma Turma ) {
        final Turma p = TurmaRepository.getById(id);
        if (p == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        try {
            TurmaRepository.delete(Turma);
            return Response.noContent().build();
        } catch (final Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }
    }

}