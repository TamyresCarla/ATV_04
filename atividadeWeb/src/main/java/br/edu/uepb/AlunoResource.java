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



@Path("alunos") // rota do resource
public class AlunoResource {

    private final AlunoRepository alunoRepository = new AlunoRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPessoas() { // response status code 200
        return Response.ok(alunoRepository.getAll()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPessoa(final Aluno aluno) {
        alunoRepository.create(aluno);
        return Response.status(Response.Status.CREATED).entity(aluno).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPessoaById(@PathParam("id") final int id) {
        return Response.ok(alunoRepository.getById(id)).build();
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editPessoa(@PathParam("id") final int id, final Aluno aluno) {
        final Aluno p = alunoRepository.getById(id);
        if (p == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        try {
            aluno.setId(id);
            alunoRepository.edit(aluno);
            return Response.ok(aluno).build();
        } catch (final Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletePessoa(@PathParam("id") final int id, final Aluno aluno ) {
        final Aluno p = alunoRepository.getById(id);
        if (p == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        try {
            alunoRepository.delete(id);
            return Response.noContent().build();
        } catch (final Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }
    }

}