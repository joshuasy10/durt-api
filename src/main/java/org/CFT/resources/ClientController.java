package org.CFT.resources;
import io.swagger.annotations.Api;
import org.CFT.api.ClientService;
import org.CFT.client.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Api("Client")
@Path("/api")

public class ClientController {


    private ClientService clientService = new ClientService();

    @GET
    @Path("/client")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClient() {
        try {
            return Response.ok(clientService.getAllClients()).build();
        } catch (FailedToGetClientException e) {
            System.err.println((e.getMessage()));
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/client/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClientById(@PathParam("id") int id) {
        try {
            return Response.ok(clientService.getClientByID(id)).build();
        } catch (FailedToGetClientException e) {
            System.err.println((e.getMessage()));
            return Response.serverError().build();
        } catch (ClientDoesNotExistException e){
            System.err.println((e.getMessage()));
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode(), e.getMessage()).build();
        }
    }

    @POST
    @Path("/client")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createClient(ClientRequest client) {
        try {
            return Response.ok(clientService.createClient(client)).build();
        } catch (FailedToCreateClientException e) {
            System.err.println((e.getMessage()));
            return Response.serverError().build();
        } catch (InvalidClientException e){
            System.err.println((e.getMessage()));
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/client/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateClientById(@PathParam("id") int id, ClientRequest client) {
        try {
            clientService.updateClient(id, client);
            return Response.ok().build();
        } catch (ClientDoesNotExistException e){
            System.err.println((e.getMessage()));
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode(), e.getMessage()).build();
        } catch (InvalidClientException e) {
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode(), e.getMessage()).build();
        } catch (FailedToUpdateClientException e){
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/client/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteClientById(@PathParam("id") int id) {
        try {
            clientService.deleteClient(id);
            return Response.ok().build();
        } catch (ClientDoesNotExistException e){
            System.err.println((e.getMessage()));
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode(), e.getMessage()).build();
        } catch (FailedToDeleteClientException e) {
            throw new RuntimeException(e);
        }
    }
}
