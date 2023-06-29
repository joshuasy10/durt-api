package resources;

import io.swagger.annotations.Api;


@Api("SalesEmployees")
@Path("/api")

public class SalesEmployeeController {


    private SalesEmployeeService salesEmployeeService = new SalesEmployeeService();

    @GET
    @Path("/salesEmployees")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSalesEmployees() {
        try {
            return Response.ok(salesEmployeeService.getAllSalesEmployees()).build();
        } catch (FailedToGetSalesEmployeesException e) {
            System.err.println((e.getMessage()));
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/salesEmployees/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSalesEmployeeById(@PathParam("id") int id) {
        try {
            return Response.ok(salesEmployeeService.getSalesEmployeeById(id)).build();
        } catch (FailedToGetSalesEmployeesException e) {
            System.err.println((e.getMessage()));
            return Response.serverError().build();
        } catch (SalesEmployeeDoesNotExistException e){
            System.err.println((e.getMessage()));
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode(), e.getMessage()).build();
        }
    }

    @POST
    @Path("/salesEmployees")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createSalesEmployee(SalesEmployeeRequest salesEmployee) {
        try {
            return Response.ok(salesEmployeeService.createSalesEmployee(salesEmployee)).build();
        } catch (FailedToCreateSalesEmployeeException e) {
            System.err.println((e.getMessage()));
            return Response.serverError().build();
        } catch (InvalidSalesEmployeeException e){
            System.err.println((e.getMessage()));
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/salesEmployees/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateSalesEmployeeById(@PathParam("id") int id, SalesEmployeeRequest salesEmployee) {
        try {
            salesEmployeeService.updateSalesEmployee(id, salesEmployee);
            return Response.ok().build();
        } catch (SalesEmployeeDoesNotExistException e){
            System.err.println((e.getMessage()));
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode(), e.getMessage()).build();
        } catch (InvalidSalesEmployeeException e) {
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode(), e.getMessage()).build();
        } catch (FailedToUpdateSalesEmployeeException e){
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/salesEmployees/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteSalesEmployeeById(@PathParam("id") int id) {
        try {
            salesEmployeeService.deleteSalesEmployee(id);
            return Response.ok().build();
        } catch (SalesEmployeeDoesNotExistException e){
            System.err.println((e.getMessage()));
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode(), e.getMessage()).build();
        } catch (FailedToDeleteSalesEmployeeException e) {
            throw new RuntimeException(e);
        }
    }
}
